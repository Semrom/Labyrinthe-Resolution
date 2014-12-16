/*
 * @author Romain Semler
 * 
 * @file GridSol.java
 * 
 * @date 28/09/2014
 */

package jeu;

import java.awt.*;
import javax.swing.*;

public class GridSol extends JFrame{

	/************************************** VARIABLES **************************************/
	
	private int [][] soluceGrille;
	private ImageIcon caseVide = new ImageIcon(new ImageIcon(getClass().getResource("/Vide.png")).getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT));
	private ImageIcon caseMur = new ImageIcon(new ImageIcon(getClass().getResource("/Mur.png")).getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT));
	private ImageIcon caseDepArr = new ImageIcon(new ImageIcon(getClass().getResource("/DepArr.png")).getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT));
	
	/************************************** CONSTRUCTEUR **************************************/
	
	public GridSol(int gridSol[][]) {
		super("Labyrinthe Résolu");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.soluceGrille = gridSol;
		
		Font police = new Font("Trebuchet MS", Font.BOLD, 25);
		JLabel enTete = new JLabel("Solution du labyrinthe");
		
		enTete.setHorizontalAlignment(JLabel.CENTER);
		enTete.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		enTete.setFont(police);
		
		this.add(enTete, BorderLayout.NORTH);
		affichage();
		
		pack();
		
	}
	
	/************************************** FONCTIONS **************************************/
	
	public void affichage() {
		
		Dimension dim = new Dimension(caseVide.getIconWidth(), caseVide.getIconHeight());
		JButton [][] button = new JButton[soluceGrille.length][soluceGrille[0].length];
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(soluceGrille.length, soluceGrille[0].length));
	
		for (int i = 0; i < soluceGrille.length; ++i)
				for (int j = 0; j < soluceGrille[0].length; ++j) {
					
					soluceGrille[soluceGrille.length-1][soluceGrille[0].length-1] = 7;
					
					if (soluceGrille[i][j] == 0 || soluceGrille[i][j] == 3) 
						//Image de fond blanc
						button[i][j] = new JButton(caseVide);
				
					else if (soluceGrille[i][j] == 1)
						//Image de fond noir
						button[i][j] = new JButton(caseMur);
					
					else if (soluceGrille[i][j] == 7)
						//Image de fond orange
						button[i][j] = new JButton(caseDepArr);
					
					else 
						//Image de fond orange
						button[i][j] = new JButton(caseDepArr);
			
					button[i][j].setPreferredSize(dim);
					button[i][j].setBorder(null);
					panel.add(button[i][j]);

				}
	      
		this.add(panel, BorderLayout.CENTER);
	
	} //Fin affichage()
	
} //Fin class
