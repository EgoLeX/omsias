////////////////////////////////////////////////////////////
//	Program created by AkEgo/Skelett35 (SkyG-Production)  //
//														  //
//		http://steamcommunity.com/groups/S-Gde			  //
////////////////////////////////////////////////////////////

package de.skygproduction.omsias;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import java.util.Random;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class optionen extends JFrame {

	private String[] tipps = {Messages.getString("info.roadmap"),Messages.getString("info.chooseomsibeforestart"),Messages.getString("info.programcontinouslydeveloped")}; 
	static optionen frame;
	public String pathtoomsifolder;
	private Border line = new LineBorder(Color.LIGHT_GRAY);
	
	Properties prop = new Properties();
	OutputStream output = null;
	InputStream input = null;
	File fileproperties = new File("config.properties");
	private JTextField tx_pathtofolder;
	
	/**
	 * Launch the application.
	 */
	public static void optionswindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new optionen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public optionen() {
		load();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(optionen.class.getResource("/img/ic_omsias.png")));
		setType(Type.UTILITY);
		setSize(1000,563);
		setLocationRelativeTo(null);
		setUndecorated(true);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 165, 0));
		
		JLabel label = new JLabel(Messages.getString("settings.title"));
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Arial", Font.BOLD, 15));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 844, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(613, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 28, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.YELLOW);
		
		JLabel lbl_warndreieck = new JLabel("");
		lbl_warndreieck.setIcon(new ImageIcon(optionen.class.getResource("/img/warnschild-11036_960_720.png")));
		
		JLabel lbl_info = new JLabel("INFO:");
		lbl_info.setFont(new Font("Arial", Font.BOLD, 13));
		
		
		JLabel lbl_info_info = new JLabel("");
		String infotext = randominfo();
		lbl_info_info.setText(infotext);
		
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 541, Short.MAX_VALUE)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addComponent(lbl_warndreieck)
					.addGap(18)
					.addComponent(lbl_info)
					.addGap(32)
					.addComponent(lbl_info_info)
					.addContainerGap(182, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 41, Short.MAX_VALUE)
				.addComponent(lbl_warndreieck, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap(15, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbl_info)
						.addComponent(lbl_info_info))
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		
		//---------------------------------------------------------------- Button close
		
		JButton btnSchliessen = new JButton();
		btnSchliessen.setText(Messages.getString("settings.close"));
		btnSchliessen.setFont(new Font("Arial", Font.PLAIN, 15));
		btnSchliessen.setContentAreaFilled(false);
		btnSchliessen.setFocusPainted(false);
		btnSchliessen.setBorder(line);
		btnSchliessen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// Back to Mainmenu
				frame.dispose();
			}
		});
		
		btnSchliessen.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		        btnSchliessen.setForeground(new Color(255, 165, 0));
		        Border lineorange = new LineBorder(new Color(255, 165, 0));
		        btnSchliessen.setBorder(lineorange);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		        btnSchliessen.setForeground(new Color(0,0,0));
		        line = new LineBorder(Color.LIGHT_GRAY);
		        btnSchliessen.setBorder(line);
		    }
		});
		
		//---------------------------------------------------------------- Button save
		
		JButton btnSpeichern = new JButton();
		btnSpeichern.setText(Messages.getString("settings.save"));
		btnSpeichern.setFont(new Font("Arial", Font.PLAIN, 15));
		btnSpeichern.setContentAreaFilled(false);
		btnSpeichern.setFocusPainted(false);
		btnSpeichern.setBorder(line);
		btnSpeichern.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				save();
			}
		});
		
		btnSpeichern.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		        btnSpeichern.setForeground(new Color(255, 165, 0));
		        Border lineorange = new LineBorder(new Color(255, 165, 0));
		        btnSpeichern.setBorder(lineorange);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		        btnSpeichern.setForeground(new Color(0,0,0));
		        line = new LineBorder(Color.LIGHT_GRAY);
		        btnSpeichern.setBorder(line);
		    }
		    
		    public void mousePressed(java.awt.event.MouseEvent evt) {
		        btnSpeichern.setForeground(new Color(25, 180, 15));
		        Border lineorange = new LineBorder(new Color(25, 180, 15));
		        btnSpeichern.setBorder(lineorange);
		     }

		     public void mouseReleased(java.awt.event.MouseEvent evt) {
			        btnSpeichern.setForeground(new Color(0,0,0));
			        line = new LineBorder(Color.LIGHT_GRAY);
			        btnSpeichern.setBorder(line);
		     }
		});
		
		//---------------------------------------------------------------- Option 1 Text
		
		JLabel lbl_pathtofolder_text = new JLabel();
		lbl_pathtofolder_text.setText(Messages.getString("settings.pathtoomsifolder"));
		lbl_pathtofolder_text.setFont(new Font("Arial", Font.PLAIN, 13));
		
		tx_pathtofolder = new JTextField();
		if(pathtoomsifolder!=null) {
			tx_pathtofolder.setText(pathtoomsifolder);;
		}
		tx_pathtofolder.setEditable(false);
		tx_pathtofolder.setColumns(20);
		
		//---------------------------------------------------------------- Option 1 - Omsi 2 choose main folder - BUTTON
		
		JButton btn_chooseOmsiFolder = new JButton();
		btn_chooseOmsiFolder.setText(Messages.getString("settings.choosefolder"));
		btn_chooseOmsiFolder.setFont(new Font("Arial", Font.PLAIN, 11));
		btn_chooseOmsiFolder.setFocusPainted(false);
		btn_chooseOmsiFolder.setContentAreaFilled(false);
		btn_chooseOmsiFolder.setBorder(line);
		btn_chooseOmsiFolder.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//Choose EXE File
				String exetitel = Messages.getString("settings.choosefolder");
				String pathtoexe=filechooser(exetitel);
				tx_pathtofolder.setText(pathtoexe);
				pathtoomsifolder = pathtoexe;
			}
		});
		
		btn_chooseOmsiFolder.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		        btn_chooseOmsiFolder.setForeground(new Color(255, 165, 0));
		        Border lineorange = new LineBorder(new Color(255, 165, 0));
		        btn_chooseOmsiFolder.setBorder(lineorange);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		        btn_chooseOmsiFolder.setForeground(new Color(0,0,0));
		        line = new LineBorder(Color.LIGHT_GRAY);
		        btn_chooseOmsiFolder.setBorder(line);
		    }
		});
		
		//---------------------------------------------------------------- Layout
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(89)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lbl_pathtofolder_text, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(tx_pathtofolder)
							.addGap(18)
							.addComponent(btn_chooseOmsiFolder, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 541, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnSchliessen, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(btnSpeichern, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)))
					.addGap(6))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addGap(42)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(tx_pathtofolder, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(btn_chooseOmsiFolder, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbl_pathtofolder_text, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 387, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSchliessen, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSpeichern, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
					.addGap(29))
		);
		getContentPane().setLayout(groupLayout);
	
	}
	private String randominfo() {
		int idx = new Random().nextInt(tipps.length);
		String rdStringtemp = (tipps[idx]);
		return rdStringtemp;
	}
	
	private String filechooser(String title){
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JFileChooser fc = new JFileChooser();
		fc.setFileSelectionMode( JFileChooser.DIRECTORIES_ONLY );
		fc.showOpenDialog(frame);
		fc.setDialogTitle(title);
		String placeoffile = fc.getSelectedFile().getAbsolutePath();
		return placeoffile;
	}
	
	private void save() {
			try {
				output = new FileOutputStream(fileproperties);
				if(pathtoomsifolder!=null) {
					prop.setProperty("path_omsipath", pathtoomsifolder);
				} else {
					tx_pathtofolder.setText("KEIN OMSI 2 HAUPTORDNER AUSGEWÄHLT!");
				}
				prop.store(output, null);
	
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (output != null) {
					try {
						output.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
	}
	
	private void load() {
		if(fileproperties.exists() && fileproperties.isFile()) {
			try {
				input = new FileInputStream(fileproperties);
				// load a properties file
				prop.load(input);
	
				// get the property value and print it out
				pathtoomsifolder=prop.getProperty("path_omsipath");
	
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