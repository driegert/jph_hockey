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
		
		JButton btnShot = new JButton("SAVE");
		shotsPanel.add(btnShot, "cell 1 4");

		JButton btnShot_1 = new JButton("SAVE");
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
		
		final JButton btnCancel = new JButton("CANCEL");
		btnCancel.setEnabled(false);
		neutralPanel.add(btnCancel, "cell 1 3");
		
		final JButton btnRightFailure = new JButton("FAILURE");
		btnRightFailure.setEnabled(false);
		btnRightFailure.setBackground(new Color(250, 128, 114));
		neutralPanel.add(btnRightFailure, "cell 2 3");
		
		/* =======================================
		 * ==== Neutral Zone Action Listeners ==== 
		 * ======================================= */
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnLeftAttempt.setEnabled(true);
				btnRightAttempt.setEnabled(true);
				btnLeftSuccess.setEnabled(false);
				btnLeftFailure.setEnabled(false);
				btnRightSuccess.setEnabled(false);
				btnRightFailure.setEnabled(false);
				btnCancel.setEnabled(false);
				
				lblNeutralAttemptTime.setText("0000000000000");
			}
		});
		
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
				btnRightAttempt.setEnabled(false);
				btnCancel.setEnabled(true);
				
				lblNeutralAttemptTime.setText(String.valueOf(System.currentTimeMillis()));
			}
		});
		
		btnLeftSuccess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLeftAttempt.setEnabled(true);
				btnRightAttempt.setEnabled(true);
				btnLeftSuccess.setEnabled(false);
				btnLeftFailure.setEnabled(false);
				btnCancel.setEnabled(false);
				
				JPHdb.addNeutralZone(lblNeutralAttemptTime.getText(), true, neutralLeftTeam.getSelectedItem().toString());
				lblNeutralAttemptTime.setText("0000000000000");
			}
		});
		
		btnLeftFailure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLeftAttempt.setEnabled(true);
				btnRightAttempt.setEnabled(true);
				btnLeftSuccess.setEnabled(false);
				btnLeftFailure.setEnabled(false);
				btnCancel.setEnabled(false);
				
				JPHdb.addNeutralZone(lblNeutralAttemptTime.getText(), false, neutralLeftTeam.getSelectedItem().toString());
				lblNeutralAttemptTime.setText("0000000000000");
			}
		});
		
		btnRightAttempt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnRightAttempt.setEnabled(false);
				btnLeftAttempt.setEnabled(false);
				btnRightSuccess.setEnabled(true);
				btnRightFailure.setEnabled(true);
				btnCancel.setEnabled(true);
				
				lblNeutralAttemptTime.setText(String.valueOf(System.currentTimeMillis()));
			}
		});
		
		btnRightSuccess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnRightAttempt.setEnabled(true);
				btnLeftAttempt.setEnabled(true);
				btnRightSuccess.setEnabled(false);
				btnRightFailure.setEnabled(false);
				btnCancel.setEnabled(false);
				
				JPHdb.addNeutralZone(lblNeutralAttemptTime.getText(), true, lblNeutralOther.getText().toString());
				lblNeutralAttemptTime.setText("0000000000000");
			}
		});
		
		btnRightFailure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnRightAttempt.setEnabled(true);
				btnLeftAttempt.setEnabled(true);
				btnRightSuccess.setEnabled(false);
				btnRightFailure.setEnabled(false);
				btnCancel.setEnabled(false);
				
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
		// number of rows for lines
		final int shiftRows = 4;
		
		JPanel shiftPanel = new JPanel();
		tabbedPane.addTab("Shift Change", null, shiftPanel, null);
		// D1 D2 ALL <> F1 F2 F3 ALL <> (are the columns, D: defense, F: forward)
		shiftPanel.setLayout(new MigLayout("", "[][][][]20[][][][][][]", "[]15[][][][]40[]40[]"));
		
		JLabel lblShiftDefense = new JLabel("D");
		shiftPanel.add(lblShiftDefense, "cell 1 0");
		
		JLabel lblShiftOffense = new JLabel("F");
		shiftPanel.add(lblShiftOffense, "cell 4 0");
		
		final JButton[] btnShiftDefense = new JButton[shiftRows*2];
		final JButton[] btnShiftForward = new JButton[shiftRows*3];
		final JButton[] btnShiftDefenseAll = new JButton[shiftRows];
		final JButton[] btnShiftForwardAll = new JButton[shiftRows];
		final JTextField txtShiftDefense = new JTextField("Def");
		final JTextField txtShiftForward = new JTextField("For");
		final JButton btnShiftAddDefense = new JButton("A");
		final JButton btnShiftAddForward = new JButton("A");
		final JButton btnShiftResetDefense = new JButton("R");
		final JButton btnShiftResetForward = new JButton("R");
		final JButton[] btnShiftCurrentD = new JButton[4];
		final JButton[] btnShiftCurrentF = new JButton[6];
		
		// Set size of the text fields and add and reset buttons
		txtShiftDefense.setSize(20, 20);
		txtShiftForward.setSize(20, 20);
		btnShiftAddDefense.setSize(20,20);
		btnShiftAddForward.setSize(20,20);
		btnShiftResetDefense.setSize(20,20);
		btnShiftResetForward.setSize(20,20);
		
		// Create, disable, and make invisible all the defense buttons
		for (int i = 0; i < shiftRows*2; i++){
			btnShiftDefense[i] = new JButton("");
			btnShiftDefense[i].setSize(20, 20);
			btnShiftDefense[i].setVisible(false);
			btnShiftDefense[i].setEnabled(false);
		}
		
		// Disable and make invisible all the forward buttons
		for (int i = 0; i < shiftRows*3; i++){
			btnShiftForward[i] = new JButton("");
			btnShiftForward[i].setSize(20, 20);
			btnShiftForward[i].setVisible(false);
			btnShiftForward[i].setEnabled(false);
		}
		
		// Disable and make invisible all the "all" buttons.
		for (int i = 0; i < shiftRows; i++){
			btnShiftDefenseAll[i] = new JButton("ALL");
			btnShiftForwardAll[i] = new JButton("ALL");
			btnShiftDefenseAll[i].setSize(20,20);
			btnShiftForwardAll[i].setSize(20,20);
			btnShiftDefenseAll[i].setVisible(false);
			btnShiftDefenseAll[i].setEnabled(false);
			btnShiftForwardAll[i].setVisible(false);
			btnShiftForwardAll[i].setEnabled(false);
		}
		
		for (int i = 0; i < shiftRows; i++){
			// Add defense buttons.
			shiftPanel.add(btnShiftDefense[2*i + 0], "cell 0 " + (i + 1));
			shiftPanel.add(btnShiftDefense[2*i + 1], "cell 1 " + (i + 1));
			shiftPanel.add(btnShiftDefenseAll[i], "cell 2 " + (i+ 1));
			
			// Add forward buttons.
			shiftPanel.add(btnShiftForward[3*i + 0], "cell 4 " + (i+ 1));
			shiftPanel.add(btnShiftForward[3*i + 1], "cell 5 " + (i+ 1));
			shiftPanel.add(btnShiftForward[3*i + 2], "cell 6 " + (i+ 1));
			shiftPanel.add(btnShiftForwardAll[i], "cell 7 " + (i+ 1));
		}
		
		// Add text fields and add / reset buttons
		shiftPanel.add(txtShiftDefense, "cell 0 6");
		shiftPanel.add(btnShiftAddDefense, "cell 1 6");
		shiftPanel.add(btnShiftResetDefense, "cell 2 6");
		shiftPanel.add(txtShiftForward, "cell 4 6");
		shiftPanel.add(btnShiftAddForward, "cell 5 6");
		shiftPanel.add(btnShiftResetForward, "cell 6 6");
		
		// Add current player buttons
		for (int i = 0; i < 4; i++){
			btnShiftCurrentD[i] = new JButton("  ");
			btnShiftCurrentD[i].setSize(20, 20);
			btnShiftCurrentD[i].setEnabled(false);
			shiftPanel.add(btnShiftCurrentD[i], "cell " + i + " 5");
		}
		
		for (int i = 0; i < 6; i++){
			btnShiftCurrentF[i] = new JButton("  ");
			btnShiftCurrentF[i].setSize(20, 20);
			btnShiftCurrentF[i].setEnabled(false);
			shiftPanel.add(btnShiftCurrentF[i], "cell " + (i+4) + " 5");
		}
		
		// ACTION LISTENERS
		// DEFENSE - add button action listener
		btnShiftAddDefense.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtShiftDefense.getText().toString().equals("")){
					return;
				}
				
				String txtValue = txtShiftDefense.getText().toString().replaceAll("\\s","");
				String[] player = txtValue.split(",");
				
				for (int i = 0; i < player.length; i++){
					if (player[i].length() < 2){
						player[i] = " " + player[i];
					}
					btnShiftDefense[i].setText(player[i]);
					btnShiftDefense[i].setVisible(true);
					btnShiftDefense[i].setEnabled(true);
					
					if (i % 2 == 0){
						btnShiftDefenseAll[i / 2].setVisible(true);
						btnShiftDefenseAll[i / 2].setEnabled(true);
					}
				}
			}
		});
		
		// FORWARD - add button action listener
		btnShiftAddForward.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtShiftForward.getText().toString().equals("")){
					return;
				}
				
				String txtValue = txtShiftForward.getText().toString().replaceAll("\\s","");
				String[] player = txtValue.split(",");
				
				for (int i = 0; i < player.length; i++){
					if (player[i].length() < 2){
						player[i] = " " + player[i];
					}
					btnShiftForward[i].setText(player[i]);
					btnShiftForward[i].setVisible(true);
					btnShiftForward[i].setEnabled(true);
					
					if (i % 3 == 0){
						btnShiftForwardAll[i / 3].setVisible(true);
						btnShiftForwardAll[i / 3].setEnabled(true);
					}
				}
			}
		});
		
		// 
		for (int i = 0; i < shiftRows*2; i++){
			btnShiftDefense[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					for (int i = 0; i < shiftRows*2; i++){
						if (e.getSource().equals(btnShiftDefense[i])){
							btnShiftDefense[i].setEnabled(false);
							
							String player = btnShiftDefense[i].getText().toString();
							
							JPHdb.addShift(System.currentTimeMillis(), player, "ON");
							
							for(int j = 0; j < 4; j++){
								if (btnShiftCurrentD[j].getText().toString().replaceAll("\\s","").equals("")){
									btnShiftCurrentD[j].setText(player);
									btnShiftCurrentD[j].setEnabled(true);
									break;
								}
							}
							break; // don't need to loop anymore
						}
					}
				}
			});
		}
		
		for (int i = 0; i < shiftRows*3; i++){
			btnShiftForward[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					for (int i = 0; i < shiftRows*3; i++){
						if (e.getSource().equals(btnShiftForward[i])){
							btnShiftForward[i].setEnabled(false);
							
							String player = btnShiftForward[i].getText().toString();
							
							JPHdb.addShift(System.currentTimeMillis(), player, "ON");
							
							for(int j = 0; j < 6; j++){
								if (btnShiftCurrentF[j].getText().toString().replaceAll("\\s","").equals("")){
									btnShiftCurrentF[j].setText(player);
									btnShiftCurrentF[j].setEnabled(true);
									break;
								}
							}
							break; // don't need to loop anymore
						}
					}
				}
			});
		}
		
		for (int i = 0; i < 4; i++){
			btnShiftCurrentD[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					for (int i = 0; i < 4; i++){
						if (e.getSource().equals(btnShiftCurrentD[i])){
							btnShiftCurrentD[i].setEnabled(false);
							
							String player = btnShiftCurrentD[i].getText().toString();
							
							JPHdb.addShift(System.currentTimeMillis(), player, "OFF");
							
							btnShiftCurrentD[i].setText(" ");
							
							for(int j = 0; j < shiftRows*2; j++){
								if (btnShiftDefense[j].getText().toString().equals(player)){
									btnShiftDefense[j].setEnabled(true);
									break;
								}
							}
							break; // don't need to loop anymore
						}
					}
				}
			});
		}
		
		for (int i = 0; i < 6; i++){
			btnShiftCurrentF[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					for (int i = 0; i < 6; i++){
						if (e.getSource().equals(btnShiftCurrentF[i])){
							btnShiftCurrentF[i].setEnabled(false);
							
							String player = btnShiftCurrentF[i].getText().toString();
							
							JPHdb.addShift(System.currentTimeMillis(), player, "OFF");
							
							btnShiftCurrentF[i].setText(" ");
							
							for(int j = 0; j < shiftRows*3; j++){
								if (btnShiftForward[j].getText().toString().equals(player)){
									btnShiftForward[j].setEnabled(true);
									break;
								}
							}
							break; // don't need to loop anymore
						}
					}
				}
			});
		}
		
		// DEFENSE - ALL action listeners
		for (int i = 0; i < shiftRows; i++){
			btnShiftDefenseAll[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					for (int i = 0; i < shiftRows; i++){
						if (e.getSource().equals(btnShiftDefenseAll[i])){
														
							String[] player = {"", "", "", ""};
							
							for (int j = 0; j < 4; j++){
								String curPlayer = btnShiftCurrentD[j].getText().toString().replaceAll("\\s","");
								if (!(curPlayer.equals(""))){
									player[j] = curPlayer;
									
									for (int m = 0; m < shiftRows*2; m++){
										if (btnShiftDefense[m].getText().toString().replaceAll("\\s","").equals(curPlayer)){
											btnShiftDefense[m].setEnabled(true);
										}
									}
								}
								
								btnShiftCurrentD[j].setText(" ");
								btnShiftCurrentD[j].setEnabled(false);
							}
							
							for (int j = 0; j < 4; j++){
								if (!(player[j].equals(""))){
									JPHdb.addShift(System.currentTimeMillis(), player[j], "OFF");
								}
							}
							
							player[0] = btnShiftDefense[2*i].getText().toString();
							player[1] = btnShiftDefense[2*i+1].getText().toString();
							
							btnShiftDefense[2*i].setEnabled(false);
							btnShiftDefense[2*i+1].setEnabled(false);
							
							JPHdb.addShift(System.currentTimeMillis(), player[0], "ON");
							JPHdb.addShift(System.currentTimeMillis(), player[1], "ON");
							
							for (int m = 0; m < 2; m++){
								btnShiftCurrentD[m].setText(player[m]);
								btnShiftCurrentD[m].setEnabled(true);
							}
							break; // don't need to loop anymore
						}
					}
				}
			});
		}
		
		// FORWARD - ALL action listeners
		for (int i = 0; i < shiftRows; i++){
			btnShiftForwardAll[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					for (int i = 0; i < shiftRows; i++){
						if (e.getSource().equals(btnShiftForwardAll[i])){
														
							String[] player = {"", "", "", "", "", ""};
							
							for (int j = 0; j < 6; j++){
								String curPlayer = btnShiftCurrentF[j].getText().toString().replaceAll("\\s","");
								if (!(curPlayer.equals(""))){
									player[j] = curPlayer;
									
									for (int m = 0; m < shiftRows*3; m++){
										if (btnShiftForward[m].getText().toString().replaceAll("\\s","").equals(curPlayer)){
											btnShiftForward[m].setEnabled(true);
										}
									}
								}
								
								btnShiftCurrentF[i].setText(" ");
								btnShiftCurrentF[i].setEnabled(false);
							}
							
							for (int j = 0; j < 6; j++){
								if (!(player[j].equals(""))){
									JPHdb.addShift(System.currentTimeMillis(), player[j], "OFF");
								}
							}
							
							player[0] = btnShiftDefense[3*i].getText().toString();
							player[1] = btnShiftDefense[3*i+1].getText().toString();
							player[2] = btnShiftDefense[3*i+2].getText().toString();
							
							btnShiftForward[3*i].setEnabled(false);
							btnShiftForward[3*i+1].setEnabled(false);
							btnShiftForward[3*i+1].setEnabled(false);
							
							JPHdb.addShift(System.currentTimeMillis(), player[0], "ON");
							JPHdb.addShift(System.currentTimeMillis(), player[1], "ON");
							JPHdb.addShift(System.currentTimeMillis(), player[2], "ON");
							
							for (int m = 0; m < 3; m++){
								btnShiftCurrentF[m].setText(player[m]);
								btnShiftCurrentF[m].setEnabled(true);
							}
							break; // don't need to loop anymore
						}
					}
				}
			});
		}
		
// ###########################################################################################
		// Add an array of textboxes and buttons (maybe this is NOT the way to do this..., but who's to say?
//		final JButton[] btnOn = new JButton[30];
//		final JButton[] btnOff = new JButton[30];
//		final JTextField[] txtPlayer = new JTextField[30];
//		
//		for (int i=0; i<10; i++){
//			txtPlayer[i] = new JTextField();
//			txtPlayer[i].setColumns(4);
//			shiftPanel.add(txtPlayer[i], "cell 0 " + i);
//			
//			btnOff[i] = new JButton("OFF");
//			btnOff[i].setBackground(new Color(210,105,30));
//			shiftPanel.add(btnOff[i], "cell 1 " + i);
//			
//			btnOn[i] = new JButton("ON");
//			btnOn[i].setBackground(new Color(30,144,255));
//			shiftPanel.add(btnOn[i], "cell 2 " + i);
//			btnOn[i].setEnabled(false);
//		}
//		
//		for (int i=10; i < 20; i++){
//			txtPlayer[i] = new JTextField();
//			txtPlayer[i].setColumns(4);
//			shiftPanel.add(txtPlayer[i], "cell 3 " + (i-10));
//			
//			btnOff[i] = new JButton("OFF");
//			btnOff[i].setBackground(new Color(210,105,30));
//			shiftPanel.add(btnOff[i], "cell 4 " + (i-10));
//			
//			btnOn[i] = new JButton("ON");
//			btnOn[i].setBackground(new Color(30,144,255));
//			shiftPanel.add(btnOn[i], "cell 5 " + (i-10));
//			btnOn[i].setEnabled(false);
//		}
//		
//		for (int i=20; i < 30; i++){
//			txtPlayer[i] = new JTextField();
//			txtPlayer[i].setColumns(4);
//			shiftPanel.add(txtPlayer[i], "cell 6 " + (i-20));
//			
//			btnOff[i] = new JButton("OFF");
//			btnOff[i].setBackground(new Color(210,105,30));
//			shiftPanel.add(btnOff[i], "cell 7 " + (i-20));
//			
//			btnOn[i] = new JButton("ON");
//			btnOn[i].setBackground(new Color(30,144,255));
//			shiftPanel.add(btnOn[i], "cell 8 " + (i-20));
//			btnOn[i].setEnabled(false);
//		}
//		
//		// Action Listeners
//		for (int i = 0; i < 30; i++){
//			btnOff[i].addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent e) {
//					for (int i = 0; i < 30; i++){
//						if (e.getSource().equals(btnOff[i])){
//							btnOn[i].setEnabled(true);
//							btnOff[i].setEnabled(false);
//							
//							JPHdb.addShift(System.currentTimeMillis(), txtPlayer[i].getText().toString(), "OFF");
//							break; // don't need to loop anymore
//						}
//					}
//				}
//			});
//			
//			btnOn[i].addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent e) {
//					for (int i = 0; i < 30; i++){
//						if (e.getSource().equals(btnOn[i])){
//							btnOn[i].setEnabled(false);
//							btnOff[i].setEnabled(true);
//							
//							JPHdb.addShift(System.currentTimeMillis(), txtPlayer[i].getText().toString(), "ON");
//							break;
//						}
//					}
//				}
//			});
//		}
		
//		final JButton btnLock = new JButton("Lock");
//		shiftPanel.add(btnLock, "cell 1 10");
//		
//		final JButton btnUnlock = new JButton("Unlock");
//		btnUnlock.setEnabled(false);
//		shiftPanel.add(btnUnlock, "cell 2 10");
		
		// Add action listeners for the lock and unlock buttons
//		btnLock.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				for (int i = 0; i < 30; i++){
//					txtPlayer[i].setEditable(false);
//					
//					if (txtPlayer[i].getText().equals("")){
//						btnOn[i].setEnabled(false);
//						btnOff[i].setEnabled(false);
//					}
//				}
//				
//				btnLock.setEnabled(false);
//				btnUnlock.setEnabled(true);
//			}
//		});
//		
//		btnUnlock.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				for (int i = 0; i < 30; i++){
//					txtPlayer[i].setEditable(true);
//					
//					if (txtPlayer[i].getText().equals("")){
//						btnOn[i].setEnabled(false);
//						btnOff[i].setEnabled(true);
//					}
//				}
//				
//				btnLock.setEnabled(true);
//				btnUnlock.setEnabled(false);
//			}
//		});
	}
}
