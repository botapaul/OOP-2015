package GUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import source.User;

public class SelectNumberOfPlayersFrame implements ActionListener {
	private JFrame NOPlayers;
	private JLabel selectMessage;
	private JTextField nrIntroduced;
	private JButton OK;
	private User user;

	public SelectNumberOfPlayersFrame(User user) {
		this.user = user;
		
		OK = new JButton("OK");
		nrIntroduced = new JTextField();
		selectMessage = new JLabel("Select nuber of players");
		NOPlayers = new JFrame();
		
		NOPlayers.setLayout(new GridLayout(1, 3));
		NOPlayers.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		NOPlayers.setSize(500, 100);
		NOPlayers.setVisible(true);
		this.NOPlayers.setLocationRelativeTo(null);
		
		NOPlayers.add(selectMessage);
		NOPlayers.add(nrIntroduced);
		NOPlayers.add(OK);

		addActionListeners();
	}

	private void addActionListeners() {
		this.OK.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == this.OK) {
			this.NOPlayers.setVisible(false);
			int nbPlayers;
			nbPlayers = Integer.parseInt(nrIntroduced.getText());
			if (nbPlayers>12 || nbPlayers<1){
				new ErrorNumberIntroducedFrame(user);
			}
		   else new BetMoneyFrame(nbPlayers, user);
		}

	}

}
