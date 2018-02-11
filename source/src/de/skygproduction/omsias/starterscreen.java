////////////////////////////////////////////////////////////
//	Program created by AkEgo/Skelett35 (SkyG-Production)  //
//														  //
//		http://steamcommunity.com/groups/S-Gde			  //
////////////////////////////////////////////////////////////

package de.skygproduction.omsias;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.util.Properties;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Desktop;

import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.SystemColor;

public class starterscreen {
	
	private JFrame frame;
	private static final String[] IMG_PATH = {"/img/bg1.jpg","/img/bg2.jpg","/img/bg3.jpg","/img/bg4.jpg","/img/bg5.jpg","/img/bg6.jpg"};
	private Border line = new LineBorder(Color.LIGHT_GRAY);
	
	Properties prop = new Properties();
	InputStream input = null;

	public static void starterwin() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					starterscreen window = new starterscreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public starterscreen(){
			initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// initialising Frame
		frame = new JFrame();
		frame.setSize(1000,563);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);
		frame.setTitle("OmsiAS (Omsi Advanced Starter)");
		frame.setVisible(true);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/ic_omsias.png")));
		frame.getContentPane().setBackground(SystemColor.menu);
		
		// creating gui
		JPanel panel_titelbar = new JPanel();
		panel_titelbar.setBackground(new Color(255, 165, 0));
		
		JLabel lbl_titelbar = new JLabel("Omsi AS - Advanced Starter");
		lbl_titelbar.setForeground(Color.WHITE);
		lbl_titelbar.setFont(new Font("Arial", Font.BOLD, 15));
		GroupLayout gl_panel_titelbar = new GroupLayout(panel_titelbar);
		gl_panel_titelbar.setHorizontalGroup(
			gl_panel_titelbar.createParallelGroup(Alignment.LEADING)
				.addGap(0, 539, Short.MAX_VALUE)
				.addGroup(gl_panel_titelbar.createSequentialGroup()
					.addContainerGap()
					.addComponent(lbl_titelbar)
					.addContainerGap(308, Short.MAX_VALUE))
		);
		gl_panel_titelbar.setVerticalGroup(
			gl_panel_titelbar.createParallelGroup(Alignment.LEADING)
				.addGap(0, 27, Short.MAX_VALUE)
				.addComponent(lbl_titelbar, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
		);
		panel_titelbar.setLayout(gl_panel_titelbar);
		
		//-------------------------------------------------------------- Picture
		
		String bgimg = randommethode();
		JLabel lbl_pic = new JLabel();
		ImageIcon img_main_win = new ImageIcon(starterscreen.class.getResource(bgimg)); // load the image to a imageIcon
		Image image = img_main_win.getImage(); // transform it
		Image newimg = image.getScaledInstance(700, 394,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way 
		img_main_win = new ImageIcon(newimg);  // transform it back
		lbl_pic.setIcon(img_main_win);
		
		//-------------------------------------------------------------- Button Start
		
		JButton btnStart = new JButton();
		btnStart.setText(Messages.getString("mainmenu.startgame"));
		btnStart.setBackground(SystemColor.menu);
		btnStart.setFont(new Font("Arial", Font.PLAIN, 16));
		btnStart.setFocusPainted(false);
	    btnStart.setContentAreaFilled(false);
		btnStart.setBorder(line);
		btnStart.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// Open Popup to choose right Omsi Version
				startgame_chooser.startgame();
			}
		});
		btnStart.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		        btnStart.setForeground(new Color(255, 165, 0));
		        Border lineorange = new LineBorder(new Color(255, 165, 0));
		        btnStart.setBorder(lineorange);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		        btnStart.setForeground(new Color(0,0,0));
		        line = new LineBorder(Color.LIGHT_GRAY);
		        btnStart.setBorder(line);
		    }
		});
		
		//-------------------------------------------------------------- Button Patch Changer
		
		JButton btn_PatchChanger = new JButton();
		btn_PatchChanger.setText(Messages.getString("mainmenu.patchchanger"));
		btn_PatchChanger.setBackground(SystemColor.menu);
		btn_PatchChanger.setFont(new Font("Arial", Font.PLAIN, 16));
		btn_PatchChanger.setFocusPainted(false);
	    btn_PatchChanger.setContentAreaFilled(false);
		btn_PatchChanger.setBorder(line);
		btn_PatchChanger.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				patchchanger.patch_changer();
			}
		});
		btn_PatchChanger.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		        btn_PatchChanger.setForeground(new Color(255, 165, 0));
		        Border lineorange = new LineBorder(new Color(255, 165, 0));
		        btn_PatchChanger.setBorder(lineorange);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		        btn_PatchChanger.setForeground(new Color(0,0,0));
		        line = new LineBorder(Color.LIGHT_GRAY);
		        btn_PatchChanger.setBorder(line);
		    }
		});
		
		//-------------------------------------------------------------- Button Optionen
		
		JButton btnSettings = new JButton();
		btnSettings.setText(Messages.getString("mainmenu.settings"));
		btnSettings.setBackground(SystemColor.menu);
		btnSettings.setFont(new Font("Arial", Font.PLAIN, 16));
		btnSettings.setFocusPainted(false);
	    btnSettings.setContentAreaFilled(false);
		btnSettings.setBorder(line);
		btnSettings.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				optionen.optionswindow();
			}
		});
		btnSettings.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		        btnSettings.setForeground(new Color(255, 165, 0));
		        Border lineorange = new LineBorder(new Color(255, 165, 0));
		        btnSettings.setBorder(lineorange);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		        btnSettings.setForeground(new Color(0,0,0));
		        line = new LineBorder(Color.LIGHT_GRAY);
		        btnSettings.setBorder(line);
		    }
		});
		
		//-------------------------------------------------------------- Button quit
		
		JButton btnQuit = new JButton();
		btnQuit.setText(Messages.getString("mainmenu.quit"));
		btnQuit.setBackground(SystemColor.menu);
		btnQuit.setFont(new Font("Arial", Font.PLAIN, 16));
		btnQuit.setFocusPainted(false);
	    btnQuit.setContentAreaFilled(false);
		btnQuit.setBorder(line);
		btnQuit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// SHUTDOWN THE PROGRAM
				exit();
			}
		});
		btnQuit.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		        btnQuit.setForeground(new Color(255, 165, 0));
		        Border lineorange = new LineBorder(new Color(255, 165, 0));
		        btnQuit.setBorder(lineorange);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		        btnQuit.setForeground(new Color(0,0,0));
		        line = new LineBorder(Color.LIGHT_GRAY);
		        btnQuit.setBorder(line);
		    }
		});
		
		JLabel lblCreatedBy = new JLabel("  Created by");
		lblCreatedBy.setIcon(new ImageIcon(starterscreen.class.getResource("/img/logo_sgp_30x30.png")));
		lblCreatedBy.setFont(new Font("Arial", Font.PLAIN, 13));
		
		//------------------------------------------------------------- label - skygp
		
		JLabel lblSkygproductionde = new JLabel("EgoLeX - SkyGPDE");
		lblSkygproductionde.setFont(new Font("Arial", Font.PLAIN, 13));
		lblSkygproductionde.addMouseListener(new java.awt.event.MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					  Desktop desktop = java.awt.Desktop.getDesktop();
					  URI twitter = new URI("https://twitter.com/SkyGProdDE");
					  desktop.browse(twitter);
					} catch (Exception fe) {
					  fe.printStackTrace();
					}
			}
		});
		
		//------------------------------------------------------------- labels
		
		JLabel lblOmsiasVersion = new JLabel("OmsiAS Version:");
		lblOmsiasVersion.setFont(new Font("Arial", Font.PLAIN, 12));
		
		JLabel lblVersionNr = new JLabel(Messages.getString("starterscreen.lblVersionNr.text")); //$NON-NLS-1$
		lblVersionNr.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
		
		//-------------------------------------------------------------- Button help
		
		JButton btnHilfe = new JButton();
		btnHilfe.setText(Messages.getString("mainmenu.help"));
		btnHilfe.setFont(new Font("Arial", Font.PLAIN, 13));
		btnHilfe.setFocusPainted(false);
		btnHilfe.setContentAreaFilled(false);
		btnHilfe.setBorder(line);
		btnHilfe.setBackground(SystemColor.menu);
		btnHilfe.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent ae) {
				// SHUTDOWN THE PROGRAM
				helppage.helpwindow();
			}
		});
		btnHilfe.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		        btnHilfe.setForeground(new Color(255, 165, 0));
		        Border lineorange = new LineBorder(new Color(255, 165, 0));
		        btnHilfe.setBorder(lineorange);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		        btnHilfe.setForeground(new Color(0,0,0));
		        line = new LineBorder(Color.LIGHT_GRAY);
		        btnHilfe.setBorder(line);
		    }
		});
		
		//-------------------------------------------------------------- button oof
		
		JButton btnOOF = new JButton();
		btnOOF.setText(Messages.getString("mainmenu.oof"));
		btnOOF.setFont(new Font("Arial", Font.PLAIN, 13));
		btnOOF.setFocusPainted(false);
		btnOOF.setContentAreaFilled(false);
		btnOOF.setBorder(line);
		btnOOF.setBackground(SystemColor.menu);
		btnOOF.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent ae) {
				// TODO Auto-generated method stub
				try {
					  Desktop desktop = java.awt.Desktop.getDesktop();
					  URI sourceforge_webpage = new URI("http://www.omnibussimulator.de/forum/");
					  desktop.browse(sourceforge_webpage);
					} catch (Exception e) {
					  e.printStackTrace();
					}
			}
		});
		btnOOF.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		        btnOOF.setForeground(new Color(255, 165, 0));
		        Border lineorange = new LineBorder(new Color(255, 165, 0));
		        btnOOF.setBorder(lineorange);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		        btnOOF.setForeground(new Color(0,0,0));
		        line = new LineBorder(Color.LIGHT_GRAY);
		        btnOOF.setBorder(line);
		    }
		});
		
		//-------------------------------------------------------------- Button website
		
		JButton btnCheckVersion = new JButton();
		btnCheckVersion.setText(Messages.getString("mainmenu.checkversion")); //$NON-NLS-1$
		btnCheckVersion.setFont(new Font("Arial", Font.PLAIN, 13));
		btnCheckVersion.setFocusPainted(false);
		btnCheckVersion.setContentAreaFilled(false);
		btnCheckVersion.setBorder(line);
		btnCheckVersion.setBackground(SystemColor.menu);
		btnCheckVersion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent ae) {
				// TODO Auto-generated method stub
				try {
					  Desktop desktop = java.awt.Desktop.getDesktop();
					  URI sourceforge_webpage = new URI("https://github.com/EgoLeX/omsias");
					  desktop.browse(sourceforge_webpage);
					} catch (Exception e) {
					  e.printStackTrace();
					}
			}
		});
		btnCheckVersion.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		        btnCheckVersion.setForeground(new Color(255, 165, 0));
		        Border lineorange = new LineBorder(new Color(255, 165, 0));
		        btnCheckVersion.setBorder(lineorange);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		        btnCheckVersion.setForeground(new Color(0,0,0));
		        line = new LineBorder(Color.LIGHT_GRAY);
		        btnCheckVersion.setBorder(line);
		    }
		});
		
		//-------------------------------------------------------------- button tools
		
		JButton btn_tools = new JButton();
		btn_tools.setText(Messages.getString("mainmenu.tools"));
		btn_tools.setFont(new Font("Arial", Font.PLAIN, 16));
		btn_tools.setFocusPainted(false);
		btn_tools.setContentAreaFilled(false);
		btn_tools.setBorder(line);
		btn_tools.setBackground(SystemColor.menu);
		btn_tools.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tools.toolspg();
			}
		});
		btn_tools.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		        btn_tools.setForeground(new Color(255, 165, 0));
		        Border lineorange = new LineBorder(new Color(255, 165, 0));
		        btn_tools.setBorder(lineorange);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		        btn_tools.setForeground(new Color(0,0,0));
		        line = new LineBorder(Color.LIGHT_GRAY);
		        btn_tools.setBorder(line);
		    }
		});
		
		JButton btn_mail = new JButton();
		btn_mail.setText(Messages.getString("starterscreen.btn_mail.text")); //$NON-NLS-1$
		btn_mail.setFont(new Font("Arial", Font.PLAIN, 13));
		btn_mail.setFocusPainted(false);
		btn_mail.setContentAreaFilled(false);
		btn_mail.setBorder(line);
		btn_mail.setBackground(SystemColor.menu);
		btn_mail.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				launch_email_client();
			}
		});
		btn_mail.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		        btn_mail.setForeground(new Color(255, 165, 0));
		        Border lineorange = new LineBorder(new Color(255, 165, 0));
		        btn_mail.setBorder(lineorange);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		        btn_mail.setForeground(new Color(0,0,0));
		        line = new LineBorder(Color.LIGHT_GRAY);
		        btn_mail.setBorder(line);
		    }
		});
		
		//--------------------------------------------------------------
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addComponent(panel_titelbar, GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnHilfe, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
							.addComponent(btn_mail, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE))
						.addComponent(btn_PatchChanger, GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
						.addComponent(btn_tools, GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
						.addComponent(btnStart, GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
						.addComponent(btnQuit, GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
						.addComponent(btnSettings, GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblOmsiasVersion)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblVersionNr)
							.addGap(19))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lbl_pic, GroupLayout.PREFERRED_SIZE, 700, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnOOF, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnCheckVersion, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCreatedBy)
								.addComponent(lblSkygproductionde))
							.addGap(28))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel_titelbar, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblOmsiasVersion)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblVersionNr)
					.addGap(21)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnStart, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btn_PatchChanger, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btn_tools, GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
							.addGap(111)
							.addComponent(btnSettings, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnQuit, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
						.addComponent(lbl_pic, GroupLayout.PREFERRED_SIZE, 394, GroupLayout.PREFERRED_SIZE))
					.addGap(5)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblCreatedBy)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblSkygproductionde))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(30)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnHilfe, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addComponent(btn_mail, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnOOF, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnCheckVersion, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))))
					.addGap(12))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
	
	private String randommethode() {
		int idx = new Random().nextInt(IMG_PATH.length);
		String rdstringtemp = (IMG_PATH[idx]);
		return rdstringtemp;
	}
	
	//launch email client
	private void launch_email_client() {
		Desktop desktop = Desktop.getDesktop();  
		String url = "";  
		URI mailTo;  
		try {  
		url = "mailTo:deskygp@gmail.com" + "?subject=" + "[Help]%20OmsiAS";  
		mailTo = new URI(url);  
		desktop.mail(mailTo);  
		} catch (URISyntaxException e) {  
			e.printStackTrace();  
		} catch (IOException e) {  
			e.printStackTrace();  
		}  
	}
	
	//close program
	public void exit() {
		System.exit(0);
	}
}
