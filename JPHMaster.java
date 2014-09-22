package jph_hockey;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JPanel;

import java.awt.GridLayout;

import javax.swing.UIManager;

import java.awt.Color;

public class JPHMaster {

	private JFrame frmJphHockeyStats;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JPHMaster window = new JPHMaster();
					window.frmJphHockeyStats.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JPHMaster() {
		JPHdb.createTables();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmJphHockeyStats = new JFrame();
		frmJphHockeyStats.setTitle("JPH Hockey Stats");
		frmJphHockeyStats.setBounds(100, 100, 433, 420);
		frmJphHockeyStats.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frmJphHockeyStats.getContentPane().add(tabbedPane, BorderLayout.CENTER);

/* ====================================================
 * ==== Adding the Shots Panel Buttons and objects ==== 
 * ====================================================*/
		JPanel shotsPanel = new JPanel();
		tabbedPane.addTab("Shots", null, shotsPanel, null);
		shotsPanel.setLayout(new MigLayout("", "[grow][][grow][][grow]", "[][][][][][]"));

		// Add buttons to the Shots Panel

		final JComboBox leftTeam = new JComboBox();
		shotsPanel.add(leftTeam, "cell 0 1,growx");
		leftTeam.addItem("Frontenacs");
		leftTeam.addItem("Other");
		
		JButton btnGoal = new JButton("GOAL");
		shotsPanel.add(btnGoal, "cell 0 4");

		final JLabel lblOther = new JLabel("Other");
		shotsPanel.add(lblOther, "cell 23 1");
		
		JButton btnMiss = new JButton("MISS");
		shotsPanel.add(btnMiss, "cell 0 2");

		JButton btnMiss_1 = new JButton("MISS");
		shotsPanel.add(btnMiss_1, "cell 23 2");
		
		JButton btnShot = new JButton("SHOT");
		shotsPanel.add(btnShot, "cell 1 4");

		JButton btnShot_1 = new JButton("SHOT");
		shotsPanel.add(btnShot_1, "cell 21 4");

		JButton btnGoal_1 = new JButton("GOAL");
		shotsPanel.add(btnGoal_1, "cell 23 4");

		JButton btnBlock = new JButton("BLOCK");
		shotsPanel.add(btnBlock, "cell 0 6");

		JButton btnBlock_1 = new JButton("BLOCK");
		shotsPanel.add(btnBlock_1, "cell 23 6");
		
		/* =========================================
		 * ==== Start of Shots Action listeners ====
		 * =========================================*/
		leftTeam.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				String curr = leftTeam.getSelectedItem().toString();
				
				if (curr.equals("Frontenacs")){
					lblOther.setText("Other");
				} else {
					lblOther.setText("Frontenacs");
				}
			}
		});
		
		btnShot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String comboVal = leftTeam.getSelectedItem().toString();
				JPHdb.addShot("S", System.currentTimeMillis(), comboVal);
			}
		});
		
		btnGoal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String comboVal = leftTeam.getSelectedItem().toString();
				JPHdb.addShot("G", System.currentTimeMillis(), comboVal);
			}
		});
		
		btnMiss.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String comboVal = leftTeam.getSelectedItem().toString();
				JPHdb.addShot("M", System.currentTimeMillis(), comboVal);
			}
		});

		btnBlock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String comboVal = leftTeam.getSelectedItem().toString();
				JPHdb.addShot("B", System.currentTimeMillis(), comboVal);
			}
		});
		
		btnShot_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String labelVal = lblOther.getText().toString();
				JPHdb.addShot("S", System.currentTimeMillis(), labelVal);
			}
		});

		btnMiss_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String labelVal = lblOther.getText().toString();
				JPHdb.addShot("M", System.currentTimeMillis(), labelVal);
			}
		});

		btnBlock_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String labelVal = lblOther.getText().toString();
				JPHdb.addShot("B", System.currentTimeMillis(), labelVal);
			}
		});

		btnGoal_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String labelVal = lblOther.getText().toString();
				JPHdb.addShot("G", System.currentTimeMillis(), labelVal);
			}
		});
		/* =======================================
		 * ====End of Shots Action Listeners =====
		 * =======================================*/
		
		
/* ===================================================
 * ==== Adding the Neutral Zone Panel and objects ==== 
 * ===================================================*/
		JPanel neutralPanel = new JPanel();
		tabbedPane.addTab("Neutral Zone", null, neutralPanel, null);
		neutralPanel.setLayout(new MigLayout("", "15[]45[]45[]", "[]20[]20[]20[]"));
		
		final JComboBox neutralLeftTeam = new JComboBox();
		neutralPanel.add(neutralLeftTeam, "flowx,cell 0 0,growx");
		neutralLeftTeam.addItem("Frontenacs");
		neutralLeftTeam.addItem("Other");
		
		final JLabel lblNeutralOther = new JLabel("Other");
		neutralPanel.add(lblNeutralOther, "cell 2 0");
		
		final JLabel lblNeutralTime = new JLabel("TIME");
		neutralPanel.add(lblNeutralTime, "cell 1 1");
		
		final JLabel lblNeutralAttemptTime = new JLabel("0000000000000");
		neutralPanel.add(lblNeutralAttemptTime, "cell 1 2");
		
		final JButton btnLeftSuccess = new JButton("SUCCESS");
		btnLeftSuccess.setBackground(new Color(152, 251, 152));
		btnLeftSuccess.setEnabled(false);
		neutralPanel.add(btnLeftSuccess, "cell 0 1");
		
		final JButton btnLeftAttempt = new JButton("ATTEMPT");
		neutralPanel.add(btnLeftAttempt, "cell 0 2");
		
		final JButton btnLeftFailure = new JButton("FAILURE");
		btnLeftFailure.setEnabled(false);
		btnLeftFailure.setBackground(new Color(250, 128, 114));
		neutralPanel.add(btnLeftFailure, "cell 0 3");
		
		final JButton btnRightSuccess = new JButton("SUCCESS");
		btnRightSuccess.setEnabled(false);
		btnRightSuccess.setBackground(new Color(152, 251, 152));
		neutralPanel.add(btnRightSuccess, "cell 2 1");
		
		final JButton btnRightAttempt = new JButton("ATTEMPT");
		neutralPanel.add(btnRightAttempt, "cell 2 2");
		
		final JButton btnRightFailure = new JButton("FAILURE");
		btnRightFailure.setEnabled(false);
		btnRightFailure.setBackground(new Color(250, 128, 114));
		neutralPanel.add(btnRightFailure, "cell 2 3");
		
		/* =======================================
		 * ==== Neutral Zone Action Listeners ==== 
		 * ======================================= */
		neutralLeftTeam.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				String curr = neutralLeftTeam.getSelectedItem().toString();

				if (curr.equals("Frontenacs")){
					lblNeutralOther.setText("Other");
				} else {
					lblNeutralOther.setText("Frontenacs");
				}
			}
		});

		btnLeftAttempt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnLeftAttempt.setEnabled(false);
				btnLeftSuccess.setEnabled(true);
				btnLeftFailure.setEnabled(true);
				
				lblNeutralAttemptTime.setText(String.valueOf(System.currentTimeMillis()));
			}
		});
		
		btnLeftSuccess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLeftAttempt.setEnabled(true);
				btnLeftSuccess.setEnabled(false);
				btnLeftFailure.setEnabled(false);
				
				JPHdb.addNeutralZone(lblNeutralAttemptTime.getText(), true, neutralLeftTeam.getSelectedItem().toString());
				lblNeutralAttemptTime.setText("0000000000000");
			}
		});
		
		btnLeftFailure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLeftAttempt.setEnabled(true);
				btnLeftSuccess.setEnabled(false);
				btnLeftFailure.setEnabled(false);
				
				JPHdb.addNeutralZone(lblNeutralAttemptTime.getText(), false, neutralLeftTeam.getSelectedItem().toString());
				lblNeutralAttemptTime.setText("0000000000000");
			}
		});
		
		btnRightAttempt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnRightAttempt.setEnabled(false);
				btnRightSuccess.setEnabled(true);
				btnRightFailure.setEnabled(true);
				
				lblNeutralAttemptTime.setText(String.valueOf(System.currentTimeMillis()));
			}
		});
		
		btnRightSuccess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnRightAttempt.setEnabled(true);
				btnRightSuccess.setEnabled(false);
				btnRightFailure.setEnabled(false);
				
				JPHdb.addNeutralZone(lblNeutralAttemptTime.getText(), true, lblNeutralOther.getText().toString());
				lblNeutralAttemptTime.setText("0000000000000");
			}
		});
		
		btnRightFailure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnRightAttempt.setEnabled(true);
				btnRightSuccess.setEnabled(false);
				btnRightFailure.setEnabled(false);
				
				JPHdb.addNeutralZone(lblNeutralAttemptTime.getText(), false, lblNeutralOther.getText().toString());
				lblNeutralAttemptTime.setText("0000000000000");
			}
		});
		/* ==============================================
		 * ==== End of Neutral Zone Action Listeners ==== 
		 * ============================================== */
		
/* ====================================================
 * ==== Adding the Shift Changes Panel and objects ==== 
 * ====================================================*/
		JPanel shiftPanel = new JPanel();
		tabbedPane.addTab("Shift Change", null, shiftPanel, null);
		shiftPanel.setLayout(new MigLayout("", "[][][]30[][][]", "[][][][][][][][][][]20[]"));
		
		// Add an array of textboxes and buttons (maybe this is NOT the way to do this..., but who's to say?
		final JButton[] btnOn = new JButton[20];
		final JButton[] btnOff = new JButton[20];
		final JTextField[] txtPlayer = new JTextField[20];
		
		for (int i=0; i<10; i++){
			txtPlayer[i] = new JTextField();
			txtPlayer[i].setColumns(4);
			shiftPanel.add(txtPlayer[i], "cell 0 " + i);
			
			btnOff[i] = new JButton("OFF");
			btnOff[i].setBackground(new Color(210,105,30));
			shiftPanel.add(btnOff[i], "cell 1 " + i);
			
			btnOn[i] = new JButton("ON");
			btnOn[i].setBackground(new Color(30,144,255));
			shiftPanel.add(btnOn[i], "cell 2 " + i);
			btnOn[i].setEnabled(false);
		}
		
		for (int i=10; i < 20; i++){
			txtPlayer[i] = new JTextField();
			txtPlayer[i].setColumns(4);
			shiftPanel.add(txtPlayer[i], "cell 3 " + (i-10));
			
			btnOff[i] = new JButton("OFF");
			btnOff[i].setBackground(new Color(210,105,30));
			shiftPanel.add(btnOff[i], "cell 4 " + (i-10));
			
			btnOn[i] = new JButton("ON");
			btnOn[i].setBackground(new Color(30,144,255));
			shiftPanel.add(btnOn[i], "cell 5 " + (i-10));
			btnOn[i].setEnabled(false);
		}
		
		// Action Listeners
		for (int i = 0; i < 20; i++){
			btnOff[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					for (int i = 0; i < 20; i++){
						if (e.getSource().equals(btnOff[i])){
							btnOn[i].setEnabled(true);
							btnOff[i].setEnabled(false);
							
							JPHdb.addShift(System.currentTimeMillis(), txtPlayer[i].getText().toString(), "OFF");
							break; // don't need to loop anymore
						}
					}
				}
			});
			
			btnOn[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					for (int i = 0; i < 20; i++){
						if (e.getSource().equals(btnOn[i])){
							btnOn[i].setEnabled(false);
							btnOff[i].setEnabled(true);
							
							JPHdb.addShift(System.currentTimeMillis(), txtPlayer[i].getText().toString(), "ON");
							break;
						}
					}
				}
			});
		}
		
		final JButton btnLock = new JButton("Lock");
		shiftPanel.add(btnLock, "cell 1 10");
		
		final JButton btnUnlock = new JButton("Unlock");
		btnUnlock.setEnabled(false);
		shiftPanel.add(btnUnlock, "cell 2 10");
		
		// Add action listeners for the lock and unlock buttons
		btnLock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < 20; i++){
					txtPlayer[i].setEditable(false);
					
					if (txtPlayer[i].getText().equals("")){
						btnOn[i].setEnabled(false);
						btnOff[i].setEnabled(false);
					}
				}
				
				btnLock.setEnabled(false);
				btnUnlock.setEnabled(true);
			}
		});
		
		btnUnlock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < 20; i++){
					txtPlayer[i].setEditable(true);
					
					if (txtPlayer[i].getText().equals("")){
						btnOn[i].setEnabled(false);
						btnOff[i].setEnabled(true);
					}
				}
				
				btnLock.setEnabled(true);
				btnUnlock.setEnabled(false);
			}
		});
	}
}
