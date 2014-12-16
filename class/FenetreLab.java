/*
 * @author Romain Semler
 * 
 * @file FenetreLab.java
 * 
 * @date 28/09/2014
 */

package jeu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FenetreLab extends JFrame implements ActionListener{
	
	/************************************** VARIABLES **************************************/
	
	private int size;
	private GridSol grilleSol;
	private FenetreLab lab1;
	private FenetreLab lab2;
	private FenetreLab lab3;
	private FenetreLab labNoSol;
	private Labyrinthe labyrinthe;
	private JLabel enTete;
	
	public JButton showSoluce;

	
	 /************************************** CONSTRUCTEUR **********************************/
	
	public FenetreLab(int numLab) {
		super("Résolution d'un labyrinthe");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setJMenuBar(BarreMenu());
		this.size = numLab;
		
		Font police = new Font("Trebuchet MS", Font.BOLD, 17);
		Font police2 = new Font("Trebuchet MS", Font.BOLD, 20);
		labyrinthe = new Labyrinthe(size);
		showSoluce = new JButton("Afficher le chemin");
		
		enTete = new JLabel("Algorithme de résolution d'un labyrinthe");
		enTete.setHorizontalAlignment(JLabel.CENTER);
		enTete.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		enTete.setFont(police);
		
		showSoluce.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		showSoluce.setHorizontalAlignment(JButton.CENTER);
		showSoluce.addActionListener(this);
		showSoluce.setFont(police2);
		
		this.add(enTete, BorderLayout.NORTH);
		this.add(labyrinthe, BorderLayout.CENTER);
		this.add(showSoluce, BorderLayout.SOUTH);
		
		pack();
		
	}
	
	/************************************** MENU **********************************/
	
	private JMenuBar BarreMenu() {
     	
     	JMenuBar BarreMenu = new JMenuBar();
     	
     	JMenu Jeu = new JMenu("Labyrinthe");	
     	BarreMenu.add(Jeu);
     	
     	JMenuItem item = new JMenuItem("Taille 1");			
        Jeu.add(item);												
        item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                LabTaille1();
            	
            }
        });
        
     	item = new JMenuItem("Taille 2");			
        Jeu.add(item);												
        item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                LabTaille2();
            	
            }
        });
        
     	item = new JMenuItem("Taille 3");			
        Jeu.add(item);												
        item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                LabTaille3();
            	
            }
        });
        
     	item = new JMenuItem("Aucune solution");			
        Jeu.add(item);												
        item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                LabNoSol();
            	
            }
        });

     	return BarreMenu;
     }
	 
	
	/************************************** FONCTIONS **********************************/
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == showSoluce) {
			//Si une solution a été trouvée
			 if(labyrinthe.resolutionLab(0, 0)) {
				 //Alors créer une fenêtre contenant la solution
				 grilleSol = new GridSol(labyrinthe.grille);
			 	 grilleSol.setLocationRelativeTo(null);
			 	 grilleSol.setVisible(true);
			 	 showSoluce.setEnabled(false);
			 } 
			 //Sinon
			 else {
				 //Afficher un message d'information
				 JOptionPane.showMessageDialog(this, "Aucune sortie n'a été trouvée :(");
			 }
		}
	}
	
	private void LabTaille1() {
		lab1 = new FenetreLab(1);
		lab1.setLocationRelativeTo(null);
		lab1.setVisible(true);
		this.dispose();
		
	}
	
	private void LabTaille2() {
		lab2 = new FenetreLab(2);
		lab2.setLocationRelativeTo(null);
		lab2.setVisible(true);
		this.dispose();
		
	}
	
	private void LabTaille3() {
		lab3 = new FenetreLab(3);
		lab3.setLocationRelativeTo(null);
		lab3.setVisible(true);
		this.dispose();
		
	}
	
	private void LabNoSol() {
		labNoSol = new FenetreLab(4);
		labNoSol.setLocationRelativeTo(null);
		labNoSol.setVisible(true);
		this.dispose();
		
	}
	
	/************************************** FONCTION MAIN **********************************/
	
	public static void main(String[] args) {
		
		FenetreLab fenetre = new FenetreLab(1);
		fenetre.setLocationRelativeTo(null);
		fenetre.setVisible(true);
	} //Fin main()
	
} //Fin class
