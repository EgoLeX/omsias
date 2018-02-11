////////////////////////////////////////////////////////////
//	Program created by AkEgo/Skelett35 (SkyG-Production)  //
//														  //
//		http://steamcommunity.com/groups/S-Gde			  //
////////////////////////////////////////////////////////////

package de.skygproduction.omsias;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.UIManager;

public class patchchanger {

	private JFrame frame;
	private Border line = new LineBorder(Color.LIGHT_GRAY);
	public Process prc; 
	private String startpath = "";
	//private String omsiver = "currentver";

	File fileproperties = new File("config.properties");
	Properties prop = new Properties();
	InputStream input = null;
	/**
	 * Launch the application.
	 */
	public static void patch_changer() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					patchchanger window = new patchchanger();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public patchchanger() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		load();
		frame = new JFrame();
		frame.getContentPane().setBackground(UIManager.getColor("Button.background"));
		frame.setResizable(false);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(startgame_chooser.class.getResource("/img/ic_omsias.png")));
		frame.setType(Type.UTILITY);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);
		frame.setSize(1000,563);
		frame.setLocationRelativeTo(null);
		
		JButton btnBackToMenu = new JButton(Messages.getString("patchchanger.backtomainmenu"));
		btnBackToMenu.setContentAreaFilled(false);
		btnBackToMenu.setFocusPainted(false);
		btnBackToMenu.setFont(new Font("Arial", Font.PLAIN, 12));
		btnBackToMenu.setBorder(line);
		btnBackToMenu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
			}
		});
		
		btnBackToMenu.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		        btnBackToMenu.setForeground(new Color(255, 165, 0));
		        Border lineorange = new LineBorder(new Color(255, 165, 0));
		        btnBackToMenu.setBorder(lineorange);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		        btnBackToMenu.setForeground(new Color(0,0,0));
		        line = new LineBorder(Color.LIGHT_GRAY);
		        btnBackToMenu.setBorder(line);
		    }
		});
		
		JLabel lblOmsi = new JLabel("Omsi Version 2.2.032");
		
		JLabel lblAktuelleOmsiVersion = new JLabel(Messages.getString("patchchanger.currentversion"));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 165, 0));
		
		//-------------------------------------------------------------- Bild/Button Tram Version
		
		JButton btnStrassenbahnVer = new JButton();
		btnStrassenbahnVer.setContentAreaFilled(false);
		btnStrassenbahnVer.setFocusPainted(false);
		btnStrassenbahnVer.setBorderPainted(false);
		
		ImageIcon img_tram = new ImageIcon(starterscreen.class.getResource("/img/omsi2_tram_version.png")); // load the image to a imageIcon
		Image image_tram = img_tram.getImage(); // transform it
		Image newimg = image_tram.getScaledInstance(250, 419,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way 
		img_tram = new ImageIcon(newimg);  // transform it back
		btnStrassenbahnVer.setIcon(img_tram);
		
		btnStrassenbahnVer.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btnStrassenbahnVer.setBorderPainted(true);
		        Border lineorange = new LineBorder(new Color(255, 165, 0));
		        btnStrassenbahnVer.setBorder(lineorange);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		        btnStrassenbahnVer.setBorderPainted(false);
		    }
		});
		
		btnStrassenbahnVer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String oldVersion = startpath;
				oldVersion = new StringBuilder(oldVersion).append("/_Straﬂenbahn/Omsi_older.exe").toString();
				try {
					prc = new ProcessBuilder(oldVersion).start();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		//-------------------------------------------------------------- Bild/Button derzeitige Version (Doppelgelenkbus)
		
		JButton btnCurrentDGB = new JButton();
		btnCurrentDGB.setContentAreaFilled(false);
		btnCurrentDGB.setFocusPainted(false);
		btnCurrentDGB.setBorderPainted(false);
		
		ImageIcon img_dbg = new ImageIcon(starterscreen.class.getResource("/img/omsi2_doppelgelenk_version.png")); // load the image to a imageIcon
		Image image_dbg = img_dbg.getImage(); // transform it
		Image currentimg = image_dbg.getScaledInstance(250, 419,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way 
		img_dbg = new ImageIcon(currentimg);  // transform it back
		btnCurrentDGB.setIcon(img_dbg);
		
		btnCurrentDGB.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btnCurrentDGB.setBorderPainted(true);
		        Border lineorange = new LineBorder(new Color(255, 165, 0));
		        btnCurrentDGB.setBorder(lineorange);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		        btnCurrentDGB.setBorderPainted(false);
		    }
		});
		
		btnCurrentDGB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String currentVersion = startpath;
				currentVersion = new StringBuilder(currentVersion).append("/_Straﬂenbahn/Omsi_current.exe").toString();
				try {
					prc = new ProcessBuilder(currentVersion).start();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		//--------------------------------------------------------------
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(65)
							.addComponent(btnStrassenbahnVer, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(153)
							.addComponent(lblOmsi)))
					.addPreferredGap(ComponentPlacement.RELATED, 345, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnCurrentDGB, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblAktuelleOmsiVersion)
							.addGap(62)))
					.addGap(78))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnBackToMenu, GroupLayout.DEFAULT_SIZE, 980, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnStrassenbahnVer, GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
						.addComponent(btnCurrentDGB, GroupLayout.PREFERRED_SIZE, 453, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAktuelleOmsiVersion)
						.addComponent(lblOmsi))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnBackToMenu, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		JLabel lblOmsiAs = new JLabel(Messages.getString("patchchanger.title"));
		lblOmsiAs.setFont(new Font("Arial", Font.BOLD, 15));
		lblOmsiAs.setForeground(new Color(255, 255, 255));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblOmsiAs)
					.addContainerGap(380, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(lblOmsiAs, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
		);
		panel.setLayout(gl_panel);
		frame.getContentPane().setLayout(groupLayout);
	}
	
	private void load() {
		if(fileproperties.exists() && fileproperties.isFile()) {
			try {
				input = new FileInputStream(fileproperties);
				// load a properties file
				prop.load(input);
	
				// get the property value and print it out
				startpath=prop.getProperty("path_omsipath");
	
			} catch (IOException ex) {
				ex.printStackTrace();
			} finally {
				if (input != null) {
					try {
						input.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
