
//Imports are listed in full to show what's being used
//could just import javax.swing.* and java.awt.* etc..
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;

public class GuiAppl {

	// Note: Typically the main method will be in a
	// separate class. As this is a simple one class
	// example it's all in the one class.
	public static void main(String[] args) throws IOException {

		new GuiAppl();
	}

	public GuiAppl() throws IOException {
		JFrame guiFrame = new JFrame();
		guiFrame.getContentPane().setBackground(Color.WHITE);

		// make sure the program exits when the frame closes
		guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		guiFrame.setTitle("NBA Player Comparison Tool\n");
		guiFrame.setSize(1000, 1000);

		// This will center the JFrame in the middle of the screen
		guiFrame.setLocationRelativeTo(null);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 559, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		guiFrame.getContentPane().setLayout(gridBagLayout);

		JComboBox p1box = new JComboBox();
		Comparison.setStats();
		for (int i = 0; i < Comparison.names.length; i++) {
			p1box.addItem(Comparison.names[i]);
		}

		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 1;
		gbc_comboBox_1.gridy = 1;
		guiFrame.getContentPane().add(p1box, gbc_comboBox_1);

		JLabel lblVs = new JLabel("vs.");
		GridBagConstraints gbc_lblVs = new GridBagConstraints();
		gbc_lblVs.insets = new Insets(0, 0, 5, 0);
		gbc_lblVs.gridx = 1;
		gbc_lblVs.gridy = 2;
		guiFrame.getContentPane().add(lblVs, gbc_lblVs);

		JComboBox p2box = new JComboBox();
		for (int i = 0; i < Comparison.names.length; i++) {
			p2box.addItem(Comparison.names[i]);
		}
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 3;
		guiFrame.getContentPane().add(p2box, gbc_comboBox);


		JButton btnCompare = new JButton("Compare!");
		btnCompare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p2box.setVisible(false);
				btnCompare.setVisible(false);
				p1box.setVisible(false);
				lblVs.setVisible(false);
				JPanel panel = new JPanel();
				panel.setBackground(Color.WHITE);
				GridBagConstraints gbc_panel = new GridBagConstraints();
				gbc_panel.fill = GridBagConstraints.BOTH;
				gbc_panel.gridx = 1;
				gbc_panel.gridy = 5;
				guiFrame.getContentPane().add(panel, gbc_panel);

				GridBagLayout gbl_panel = new GridBagLayout();
				gbl_panel.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 20, 0, 22, 0, 20, 20, 26, 0, 0, 0, 0, 0, 20, 0 };
				gbl_panel.rowHeights = new int[] { 0, 0, 16, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
				gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
				gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
						Double.MIN_VALUE };
				panel.setLayout(gbl_panel);

				int p1Index = p1box.getSelectedIndex();
				int p2Index = p2box.getSelectedIndex();
				JLabel Player1Label = new JLabel(Comparison.names[p1Index]);
				Player1Label.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
				GridBagConstraints gbc_Player1Label = new GridBagConstraints();
				gbc_Player1Label.insets = new Insets(0, 0, 5, 5);
				gbc_Player1Label.gridx = 10;
				gbc_Player1Label.gridy = 0;
				panel.add(Player1Label, gbc_Player1Label);

				JLabel spacingp1 = new JLabel("New label");
				spacingp1.setForeground(Color.WHITE);
				spacingp1.setBackground(Color.LIGHT_GRAY);
				GridBagConstraints gbc_spacingp1 = new GridBagConstraints();
				gbc_spacingp1.insets = new Insets(0, 0, 5, 5);
				gbc_spacingp1.gridx = 11;
				gbc_spacingp1.gridy = 0;
				panel.add(spacingp1, gbc_spacingp1);

				JLabel lblPlayer = new JLabel("Player");
				lblPlayer.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
				GridBagConstraints gbc_lblPlayer = new GridBagConstraints();
				gbc_lblPlayer.insets = new Insets(0, 0, 5, 5);
				gbc_lblPlayer.gridx = 12;
				gbc_lblPlayer.gridy = 0;
				panel.add(lblPlayer, gbc_lblPlayer);

				JLabel spacingp2 = new JLabel("New label");
				spacingp2.setForeground(Color.WHITE);
				spacingp2.setBackground(Color.WHITE);
				GridBagConstraints gbc_spacingp2 = new GridBagConstraints();
				gbc_spacingp2.insets = new Insets(0, 0, 5, 5);
				gbc_spacingp2.gridx = 13;
				gbc_spacingp2.gridy = 0;
				panel.add(spacingp2, gbc_spacingp2);

				JLabel Player2label = new JLabel(Comparison.names[p2Index]);
				Player2label.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
				GridBagConstraints gbc_Player2label = new GridBagConstraints();
				gbc_Player2label.insets = new Insets(0, 0, 5, 5);
				gbc_Player2label.gridx = 14;
				gbc_Player2label.gridy = 0;
				panel.add(Player2label, gbc_Player2label);

				JLabel lblSpace = new JLabel(" ");
				GridBagConstraints gbc_lblSpace = new GridBagConstraints();
				gbc_lblSpace.insets = new Insets(0, 0, 5, 5);
				gbc_lblSpace.gridx = 12;
				gbc_lblSpace.gridy = 1;
				panel.add(lblSpace, gbc_lblSpace);
				JLabel pointsp1 = new JLabel(Comparison.points[p1Index] + "");
				GridBagConstraints gbc_pointsp1 = new GridBagConstraints();
				gbc_pointsp1.anchor = GridBagConstraints.NORTH;
				gbc_pointsp1.insets = new Insets(0, 0, 5, 5);
				gbc_pointsp1.gridx = 10;
				gbc_pointsp1.gridy = 2;
				panel.add(pointsp1, gbc_pointsp1);

				JLabel PTSlabel = new JLabel("PTS");
				PTSlabel.setForeground(Color.BLUE);
				PTSlabel.setBackground(Color.RED);
				GridBagConstraints gbc_PTSlabel = new GridBagConstraints();
				gbc_PTSlabel.anchor = GridBagConstraints.NORTH;
				gbc_PTSlabel.insets = new Insets(0, 0, 5, 5);
				gbc_PTSlabel.gridx = 12;
				gbc_PTSlabel.gridy = 2;
				panel.add(PTSlabel, gbc_PTSlabel);

				JLabel pointsp2 = new JLabel(Comparison.points[p2Index] + "");
				pointsp2.setBackground(Color.WHITE);
				GridBagConstraints gbc_pointsp2 = new GridBagConstraints();
				gbc_pointsp2.anchor = GridBagConstraints.NORTH;
				gbc_pointsp2.insets = new Insets(0, 0, 5, 5);
				gbc_pointsp2.gridx = 14;
				gbc_pointsp2.gridy = 2;
				panel.add(pointsp2, gbc_pointsp2);

				JLabel rebp1 = new JLabel(Comparison.rebounds[p1Index] + "");
				rebp1.setVerticalAlignment(SwingConstants.TOP);
				GridBagConstraints gbc_rebp1 = new GridBagConstraints();
				gbc_rebp1.anchor = GridBagConstraints.NORTH;
				gbc_rebp1.insets = new Insets(0, 0, 5, 5);
				gbc_rebp1.gridx = 10;
				gbc_rebp1.gridy = 3;
				panel.add(rebp1, gbc_rebp1);

				JLabel REBlabel = new JLabel("REB\n");
				REBlabel.setForeground(Color.BLUE);
				REBlabel.setBackground(Color.RED);
				REBlabel.setVerticalAlignment(SwingConstants.BOTTOM);
				GridBagConstraints gbc_REBlabel = new GridBagConstraints();
				gbc_REBlabel.anchor = GridBagConstraints.NORTH;
				gbc_REBlabel.insets = new Insets(0, 0, 5, 5);
				gbc_REBlabel.gridx = 12;
				gbc_REBlabel.gridy = 3;
				panel.add(REBlabel, gbc_REBlabel);

				JLabel rebp2 = new JLabel(Comparison.rebounds[p2Index] + "");
				rebp2.setVerticalAlignment(SwingConstants.BOTTOM);
				GridBagConstraints gbc_rebp2 = new GridBagConstraints();
				gbc_rebp2.insets = new Insets(0, 0, 5, 5);
				gbc_rebp2.anchor = GridBagConstraints.NORTH;
				gbc_rebp2.gridx = 14;
				gbc_rebp2.gridy = 3;
				panel.add(rebp2, gbc_rebp2);

				JLabel astp1 = new JLabel(Comparison.assists[p1Index] + "");
				GridBagConstraints gbc_astp1 = new GridBagConstraints();
				gbc_astp1.insets = new Insets(0, 0, 5, 5);
				gbc_astp1.gridx = 10;
				gbc_astp1.gridy = 4;
				panel.add(astp1, gbc_astp1);

				JLabel lblAst = new JLabel("AST");
				lblAst.setForeground(Color.BLUE);
				lblAst.setBackground(Color.RED);
				GridBagConstraints gbc_lblAst = new GridBagConstraints();
				gbc_lblAst.insets = new Insets(0, 0, 5, 5);
				gbc_lblAst.gridx = 12;
				gbc_lblAst.gridy = 4;
				panel.add(lblAst, gbc_lblAst);

				JLabel astp2 = new JLabel(Comparison.assists[p2Index] + "");
				GridBagConstraints gbc_astp2 = new GridBagConstraints();
				gbc_astp2.insets = new Insets(0, 0, 5, 5);
				gbc_astp2.gridx = 14;
				gbc_astp2.gridy = 4;
				panel.add(astp2, gbc_astp2);

				JLabel blkp1 = new JLabel(Comparison.blocks[p1Index] + "");
				GridBagConstraints gbc_blkp1 = new GridBagConstraints();
				gbc_blkp1.insets = new Insets(0, 0, 5, 5);
				gbc_blkp1.gridx = 10;
				gbc_blkp1.gridy = 5;
				panel.add(blkp1, gbc_blkp1);

				JLabel lblBlk = new JLabel("BLK");
				lblBlk.setForeground(Color.BLUE);
				lblBlk.setBackground(Color.RED);
				GridBagConstraints gbc_lblBlk = new GridBagConstraints();
				gbc_lblBlk.insets = new Insets(0, 0, 5, 5);
				gbc_lblBlk.gridx = 12;
				gbc_lblBlk.gridy = 5;
				panel.add(lblBlk, gbc_lblBlk);

				JLabel blkp2 = new JLabel(Comparison.blocks[p2Index] + "");
				GridBagConstraints gbc_blkp2 = new GridBagConstraints();
				gbc_blkp2.insets = new Insets(0, 0, 5, 5);
				gbc_blkp2.gridx = 14;
				gbc_blkp2.gridy = 5;
				panel.add(blkp2, gbc_blkp2);

				JLabel stlp1 = new JLabel(Comparison.steals[p1Index] + "");
				GridBagConstraints gbc_stlp1 = new GridBagConstraints();
				gbc_stlp1.insets = new Insets(0, 0, 5, 5);
				gbc_stlp1.gridx = 10;
				gbc_stlp1.gridy = 6;
				panel.add(stlp1, gbc_stlp1);

				JLabel lblStl = new JLabel("STL");
				lblStl.setForeground(Color.BLUE);
				lblStl.setBackground(Color.RED);
				GridBagConstraints gbc_lblStl = new GridBagConstraints();
				gbc_lblStl.insets = new Insets(0, 0, 5, 5);
				gbc_lblStl.gridx = 12;
				gbc_lblStl.gridy = 6;
				panel.add(lblStl, gbc_lblStl);

				JLabel stlp2 = new JLabel(Comparison.steals[p2Index] + "");
				GridBagConstraints gbc_stlp2 = new GridBagConstraints();
				gbc_stlp2.insets = new Insets(0, 0, 5, 5);
				gbc_stlp2.gridx = 14;
				gbc_stlp2.gridy = 6;
				panel.add(stlp2, gbc_stlp2);

				JLabel tovp1 = new JLabel(Comparison.turnovers[p1Index] + "");
				GridBagConstraints gbc_tovp1 = new GridBagConstraints();
				gbc_tovp1.insets = new Insets(0, 0, 5, 5);
				gbc_tovp1.gridx = 10;
				gbc_tovp1.gridy = 7;
				panel.add(tovp1, gbc_tovp1);

				JLabel lblTov = new JLabel("TOV");
				lblTov.setForeground(Color.BLUE);
				GridBagConstraints gbc_lblTov = new GridBagConstraints();
				gbc_lblTov.insets = new Insets(0, 0, 5, 5);
				gbc_lblTov.gridx = 12;
				gbc_lblTov.gridy = 7;
				panel.add(lblTov, gbc_lblTov);

				JLabel tovp2 = new JLabel(Comparison.turnovers[p2Index] + "");
				GridBagConstraints gbc_tovp2 = new GridBagConstraints();
				gbc_tovp2.insets = new Insets(0, 0, 5, 5);
				gbc_tovp2.gridx = 14;
				gbc_tovp2.gridy = 7;
				panel.add(tovp2, gbc_tovp2);

				JLabel effp1 = new JLabel(Comparison.efficiency[p1Index] + "");
				GridBagConstraints gbc_effp1 = new GridBagConstraints();
				gbc_effp1.insets = new Insets(0, 0, 5, 5);
				gbc_effp1.gridx = 10;
				gbc_effp1.gridy = 8;
				panel.add(effp1, gbc_effp1);

				JLabel lblEff = new JLabel("EFF");
				lblEff.setForeground(Color.BLUE);
				GridBagConstraints gbc_lblEff = new GridBagConstraints();
				gbc_lblEff.insets = new Insets(0, 0, 5, 5);
				gbc_lblEff.gridx = 12;
				gbc_lblEff.gridy = 8;
				panel.add(lblEff, gbc_lblEff);

				JLabel effp2 = new JLabel(Comparison.efficiency[p2Index] + "");
				GridBagConstraints gbc_effp2 = new GridBagConstraints();
				gbc_effp2.insets = new Insets(0, 0, 5, 5);
				gbc_effp2.gridx = 14;
				gbc_effp2.gridy = 8;
				panel.add(effp2, gbc_effp2);
				
				JLabel plusMinus1 = new JLabel(Comparison.plusMinus[p1Index]+"");
				GridBagConstraints gbc_plusMinus1 = new GridBagConstraints();
				gbc_plusMinus1.insets = new Insets(0, 0, 5, 5);
				gbc_plusMinus1.gridx = 10;
				gbc_plusMinus1.gridy = 9;
				panel.add(plusMinus1, gbc_plusMinus1);
				
				JLabel label = new JLabel("+/-");
				label.setForeground(Color.BLUE);
				GridBagConstraints gbc_label = new GridBagConstraints();
				gbc_label.insets = new Insets(0, 0, 5, 5);
				gbc_label.gridx = 12;
				gbc_label.gridy = 9;
				panel.add(label, gbc_label);
				
				JLabel plusMinus2 = new JLabel(Comparison.plusMinus[p2Index]+"");
				GridBagConstraints gbc_plusMinus2 = new GridBagConstraints();
				gbc_plusMinus2.insets = new Insets(0, 0, 5, 5);
				gbc_plusMinus2.gridx = 14;
				gbc_plusMinus2.gridy = 9;
				panel.add(plusMinus2, gbc_plusMinus2);

				JLabel space = new JLabel(" \n");
				GridBagConstraints gbc_space = new GridBagConstraints();
				gbc_space.insets = new Insets(0, 0, 5, 5);
				gbc_space.gridx = 12;
				gbc_space.gridy = 10;
				panel.add(space, gbc_space);

				double scorep1 = Comparison.points[p1Index] + 2 * Comparison.assists[p1Index]
						+ 1.5 * Comparison.rebounds[p1Index] + 2.5 * Comparison.blocks[p1Index]
						+ 2.5 * Comparison.steals[p1Index] - 2 * Comparison.turnovers[p1Index] + Comparison.efficiency[p1Index]+Comparison.plusMinus[p1Index]/2;
				JLabel p1score = new JLabel(scorep1 + "");
				GridBagConstraints gbc_p1score = new GridBagConstraints();
				gbc_p1score.insets = new Insets(0, 0, 5, 5);
				gbc_p1score.gridx = 10;
				gbc_p1score.gridy = 11;
				panel.add(p1score, gbc_p1score);

				JLabel lblPlayerScore = new JLabel("Player Score");
				GridBagConstraints gbc_lblPlayerScore = new GridBagConstraints();
				gbc_lblPlayerScore.insets = new Insets(0, 0, 5, 5);
				gbc_lblPlayerScore.gridx = 12;
				gbc_lblPlayerScore.gridy = 11;
				panel.add(lblPlayerScore, gbc_lblPlayerScore);

				double scorep2 = Comparison.points[p2Index] + 2 * Comparison.assists[p2Index]
						+ 1.5 * Comparison.rebounds[p2Index] + 2.5 * Comparison.blocks[p2Index]
						+ 2.5 * Comparison.steals[p2Index] - 2 * Comparison.turnovers[p2Index] + Comparison.efficiency[p2Index]+Comparison.plusMinus[p2Index]/2;
				JLabel p2score = new JLabel(scorep2 + "");
				GridBagConstraints gbc_p2score = new GridBagConstraints();
				gbc_p2score.insets = new Insets(0, 0, 5, 5);
				gbc_p2score.gridx = 14;
				gbc_p2score.gridy = 11;
				panel.add(p2score, gbc_p2score);

				JLabel lblWinnerIs = new JLabel("Winner is:");
				lblWinnerIs.setForeground(Color.DARK_GRAY);
				GridBagConstraints gbc_lblWinnerIs = new GridBagConstraints();
				gbc_lblWinnerIs.insets = new Insets(0, 0, 5, 5);
				gbc_lblWinnerIs.gridx = 12;
				gbc_lblWinnerIs.gridy = 12;
				panel.add(lblWinnerIs, gbc_lblWinnerIs);

				if (scorep1 > scorep2) {
					JLabel winnerPlayer = new JLabel(Comparison.names[p1Index]);
					winnerPlayer.setFont(new Font("SimHei", Font.PLAIN, 29));
					winnerPlayer.setForeground(Color.GREEN);
					GridBagConstraints gbc_winnerPlayer = new GridBagConstraints();
					gbc_winnerPlayer.insets = new Insets(0, 0, 0, 5);
					gbc_winnerPlayer.gridx = 3;
					gbc_winnerPlayer.gridy = 12;
					panel.add(winnerPlayer, gbc_winnerPlayer);
				} else if(scorep1<scorep2) {
					JLabel winnerPlayer = new JLabel(Comparison.names[p2Index]);
					winnerPlayer.setFont(new Font("SimHei", Font.PLAIN, 29));
					winnerPlayer.setForeground(Color.GREEN);
					GridBagConstraints gbc_winnerPlayer = new GridBagConstraints();
					gbc_winnerPlayer.insets = new Insets(0, 0, 0, 5);
					gbc_winnerPlayer.gridx = 3;
					gbc_winnerPlayer.gridy = 12;
					panel.add(winnerPlayer, gbc_winnerPlayer);
				} else {
					JLabel winnerPlayer = new JLabel("neither player. They have the same score!");
					winnerPlayer.setFont(new Font("SimHei", Font.PLAIN, 29));
					GridBagConstraints gbc_winnerPlayer = new GridBagConstraints();
					gbc_winnerPlayer.insets = new Insets(0, 0, 0, 5);
					gbc_winnerPlayer.gridx = 3;
					gbc_winnerPlayer.gridy = 12;
					panel.add(winnerPlayer, gbc_winnerPlayer);
				}
				
				
				panel.setVisible(true);

			}
		});
		GridBagConstraints gbc_btnCompare = new GridBagConstraints();
		gbc_btnCompare.insets = new Insets(0, 0, 5, 0);
		gbc_btnCompare.gridx = 1;
		gbc_btnCompare.gridy = 4;
		guiFrame.getContentPane().add(btnCompare, gbc_btnCompare);

		// make sure the JFrame is visible
		guiFrame.setVisible(true);
	}

}