import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.InetAddress;
import java.net.Socket;
import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.event.ListDataListener;

import com.google.common.collect.Lists;

import edu.rivier.cs585.gui.client.ClientMessageProvider;
import edu.rivier.cs585.gui.shared.ChatRoom;
import edu.rivier.cs585.gui.shared.ServerFunctionEnum;
import edu.rivier.cs585.gui.shared.SimpleChatProtocol;
import edu.rivier.cs585.gui.shared.UserStatement;


public class MyChatClient extends JFrame {
	
	private ClientMessageProvider messageProvider;
	
	private JButton submitButton;
	private JTextField messageEntry;
	private JTextArea messageConsole;
	
	private JComboBox<ChatRoom> roomSelect;
	private ChatRoomComboBoxModel roomModel;
	
	private List<ChatRoom> rooms = Lists.newArrayList();
	private String userName;
	private InetAddress serverAddress;
	
	public MyChatClient(InetAddress serverAddress, String userName) throws Exception {
		super("Chat Client | " + userName);
		setSize(500, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.userName = userName;
		this.serverAddress = serverAddress;
		
		messageProvider = new ClientMessageProvider(1, serverAddress, 250);
		messageProvider.start();
		
		setLayout(new BorderLayout());
		
		messageConsole = new JTextArea();
		messageConsole.setEditable(false);
		
		JScrollPane scroll = new JScrollPane(messageConsole);
		
		add(scroll, BorderLayout.CENTER);
		
		populateRoomsList();
		
		roomModel = new ChatRoomComboBoxModel(rooms);
		roomModel.setSelectedItem(rooms.get(0));
		roomSelect = new JComboBox<ChatRoom>(roomModel);
		roomSelect.setEditable(false);
		add(roomSelect, BorderLayout.NORTH);
		roomModel.addModelSelectionChangeListener(new ModelSelectionChangeListener<ChatRoom>() {
			
			@Override
			public void onSelectionChanged(ChatRoom oldSelection, ChatRoom newSelection) {
				messageConsole.setText("");
				messageProvider.resetToNewRoom(newSelection.getId());
				System.err.println("User selected room '" + newSelection.getName() + "'");
			}
		});
		
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new BorderLayout());
		
		messageEntry = new JTextField();
		bottomPanel.add(messageEntry, BorderLayout.CENTER);
		
		submitButton = new JButton("Submit");
		bottomPanel.add(submitButton, BorderLayout.EAST);
		
		add(bottomPanel, BorderLayout.SOUTH);
		
		messageEntry.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					onSubmit();
				}
			}
		});
		
		submitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				onSubmit();
			}
		});
		
		Timer timer = new Timer(250, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updateMessageConsole();
			}
		});
		timer.start();
	}
	
	protected void populateRoomsList() throws Exception {
		Socket socket = createClientSocket();
		SimpleChatProtocol protocol = new SimpleChatProtocol(socket);
		protocol.writeFunction(ServerFunctionEnum.FUNCTION_LIST_AVAILABLE_ROOMS);
		
		int roomCount = protocol.readNakedInt();
		
		for (int i = 0; i < roomCount; i++) {
			int roomId = protocol.readNakedInt();
			String roomName = protocol.readString();
			ChatRoom room = new ChatRoom(roomId, roomName);
			rooms.add(room);
		}
	}
	
	private Socket createClientSocket() throws Exception {
		Socket socket = new Socket(serverAddress, 12456);
		return socket;
	}
	
	protected void onSubmit() {
		String message = messageEntry.getText();
		messageEntry.setText("");
		
		if (message.length() > 0) {
			try {
				postMessage(message);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	protected void updateMessageConsole() {
		List<UserStatement> statements = messageProvider.getNewStatements();
		
		StringBuilder string = new StringBuilder();
		
		for (UserStatement statement : statements) {
			string.append(statement.getUser());
			string.append(": ");
			string.append(statement.getMessage());
			string.append("\n");
		}
		
		messageConsole.setText(messageConsole.getText() + string.toString());
	}
	
	protected int postMessage(String message) throws Exception {
		Socket socket = createClientSocket();
		SimpleChatProtocol protocol = new SimpleChatProtocol(socket);
		
		if (roomModel.getSelectedItem() == null) {
			System.err.println("No room selected!");
			return 0;
		}
		
		ChatRoom selectedRoom = (ChatRoom) roomModel.getSelectedItem();
		protocol.writeFunction(ServerFunctionEnum.FUNCTION_POST_MESSAGE);
		protocol.writeNakedInt(selectedRoom.getId());
		protocol.writeNakedInt(0);
		protocol.writeString(userName);
		protocol.writeString(message);
		
		int id = protocol.readNakedInt();
		
		socket.close();
		return id;
	}
	
	
	
	
	
	
	
	public interface ModelSelectionChangeListener<T> {
		public void onSelectionChanged(T oldSelection, T newSelection);
	}
	
	public class ChatRoomComboBoxModel implements ComboBoxModel<ChatRoom> {
		
		private List<ModelSelectionChangeListener<ChatRoom>> changeListeners = Lists.newArrayList();
		private List<ChatRoom> rooms;
		
		private ChatRoom selectedItem;
		
		public ChatRoomComboBoxModel(List<ChatRoom> rooms) {
			this.rooms = rooms;
		}
		
		public void addModelSelectionChangeListener(ModelSelectionChangeListener<ChatRoom> l) {
			this.changeListeners.add(l);
		}
		
		public boolean removeModelSelectionChangeListener(ModelSelectionChangeListener<ChatRoom> l) {
			return this.changeListeners.remove(l);
		}
		
		protected void fireModelSelectionChangeListeners(ChatRoom oldSelection, ChatRoom newSelection) {
			for (ModelSelectionChangeListener<ChatRoom> l : changeListeners) {
				l.onSelectionChanged(oldSelection, newSelection);
			}
		}
		
		@Override
		public int getSize() {
			return rooms.size();
		}

		@Override
		public ChatRoom getElementAt(int index) {
			return rooms.get(index);
		}

		@Override
		public void addListDataListener(ListDataListener l) {
			// Not Implemented
		}

		@Override
		public void removeListDataListener(ListDataListener l) {
			// Not Implemented
		}

		@Override
		public void setSelectedItem(Object anItem) {
			if (anItem instanceof ChatRoom) {
				fireModelSelectionChangeListeners(selectedItem, (ChatRoom) anItem);
				selectedItem = (ChatRoom) anItem;
			}
		}

		@Override
		public Object getSelectedItem() {
			return selectedItem;
		}
		
		
		
	}
	
	public static void main(String[] args){
		MyChatClient client;
		try{
			client = new MyChatClient(InetAddress.getByName("192.168.230.116"),"Y.J");
			client.setVisible(true);
			
		}
		catch (Exception ex){
			ex.printStackTrace();
		}
	}

}