////////////////////////////////////////////////////////////
//	Program created by AkEgo/Skelett35 (SkyG-Production)  //
//														  //
//		http://steamcommunity.com/groups/S-Gde			  //
////////////////////////////////////////////////////////////

package de.skygproduction.omsias;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class startgame_chooser extends JFrame {

	private Border line = new LineBorder(Color.LIGHT_GRAY);
	static startgame_chooser frame;
	private static Process prc;
	private JLabel lbl_statustart = new JLabel("");
	
	Properties prop = new Properties();
	InputStream input = null;

	/**
	 * Launch the application.
	 */
	public static void startgame() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new startgame_chooser();
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
	public startgame_chooser() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(startgame_chooser.class.getResource("/img/ic_omsias.png")));
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setSize(1000,563);
		setLocationRelativeTo(null);
		
		//---------------------------------------------- creating GUI
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 165, 0));
		
		JLabel lblOmsiAs = new JLabel(Messages.getString("startgame.title"));
		lblOmsiAs.setForeground(Color.WHITE);
		lblOmsiAs.setFont(new Font("Arial", Font.BOLD, 15));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 1000, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblOmsiAs)
					.addContainerGap(769, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 27, Short.MAX_VALUE)
				.addComponent(lblOmsiAs, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
		);
		panel.setLayout(gl_panel);
		
		//-----------------------------------------------------------------> BUTTON BACK TO MENU
		
		JButton button = new JButton(Messages.getString("startgame.backtomainmenu"));
		button.setFont(new Font("Arial", Font.PLAIN, 12));
		button.setFocusPainted(false);
		button.setContentAreaFilled(false);
		button.setBorder(line);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
			}
		});
		button.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		        button.setForeground(new Color(255, 165, 0));
		        Border lineorange = new LineBorder(new Color(255, 165, 0));
		        button.setBorder(lineorange);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		        button.setForeground(new Color(0,0,0));
		        line = new LineBorder(Color.LIGHT_GRAY);
		        button.setBorder(line);
		    }
		});
		
		//----------------------------------------------------------------->
		
		lbl_statustart.setEnabled(false);
		lbl_statustart.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_statustart.setFont(new Font("Arial", Font.PLAIN, 13));
		
		//-----------------------------------------------------------------> button omsi
		
		JButton btnOmsi2 = new JButton("");
		btnOmsi2.setBorder(null);
		btnOmsi2.setIcon(btnimgicon("/img/btn_normal_starten.png", 364, 364));
		btnOmsi2.setFont(new Font("Arial", Font.PLAIN, 65));
		btnOmsi2.setContentAreaFilled(false);
		btnOmsi2.setFocusPainted(false);
		btnOmsi2.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		        btnOmsi2.setIcon(btnimgicon("/img/btn_normal_starten_hover.png", 364, 364));
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		        btnOmsi2.setIcon(btnimgicon("/img/btn_normal_starten.png", 364, 364));
		    }
		});
		btnOmsi2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					String startomsi = load();
					startomsi = new StringBuilder(startomsi).append("/Omsi.exe").toString();
					prc = new ProcessBuilder(startomsi).start();
					Thread.sleep(10000);
					frame.dispose();
				} catch (IOException | InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		//-----------------------------------------------------------------> button omsi editor
		
		JButton btnOmsiEditor = new JButton("");
		btnOmsiEditor.setBorder(null);
		btnOmsiEditor.setIcon(btnimgicon("/img/btn_editor_starten.png", 364, 364));
		btnOmsiEditor.setFont(new Font("Arial", Font.PLAIN, 65));
		btnOmsiEditor.setContentAreaFilled(false);
		btnOmsiEditor.setFocusPainted(false);
		btnOmsiEditor.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		        btnOmsiEditor.setIcon(btnimgicon("/img/btn_editor_starten_hover.png", 364, 364));
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		        btnOmsiEditor.setIcon(btnimgicon("/img/btn_editor_starten.png", 364, 364));
		    }
		});
		btnOmsiEditor.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String startomsieditor = load();
				startomsieditor = new StringBuilder(startomsieditor).append("/Omsi.exe").toString();
				try {
					prc = new ProcessBuilder(startomsieditor,"-editor").start();
					Thread.sleep(10000);
					frame.dispose();
				} catch (IOException | InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.YELLOW);
		
		//----------------------------------------------------------------->
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 2793, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnOmsi2, GroupLayout.PREFERRED_SIZE, 465, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnOmsiEditor, GroupLayout.PREFERRED_SIZE, 464, GroupLayout.PREFERRED_SIZE))
						.addComponent(button, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 980, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(lbl_statustart, GroupLayout.PREFERRED_SIZE, 344, GroupLayout.PREFERRED_SIZE)
					.addGap(1455))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(204)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 610, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(1979, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(213)
							.addComponent(lbl_statustart))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnOmsiEditor, GroupLayout.PREFERRED_SIZE, 418, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnOmsi2, GroupLayout.PREFERRED_SIZE, 418, GroupLayout.PREFERRED_SIZE))))
					.addGap(26)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		JLabel lblInfo = new JLabel(Messages.getString("startgame.info"));
		lblInfo.setForeground(Color.BLACK);
		lblInfo.setBackground(Color.WHITE);
		lblInfo.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblInfo, GroupLayout.DEFAULT_SIZE, 596, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addComponent(lblInfo, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
		);
		panel_1.setLayout(gl_panel_1);
		getContentPane().setLayout(groupLayout);
	}
	
	//load config
	public String load() {
		String startpath;
		try {
			input = new FileInputStream("config.properties");
			// load a properties file
			prop.load(input);
			// get the property value and print it out
			startpath=prop.getProperty("path_omsipath");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			startpath="";
		}
		return startpath;
	}
	
	//rezise image
	public ImageIcon btnimgicon(String a, Integer l, Integer b) {
		ImageIcon logobtn = new ImageIcon(startgame_chooser.class.getResource(a)); // load the image to a imageIcon
		Image image_logobtn = logobtn.getImage(); // transform it
		Image newimg_logobtn = image_logobtn.getScaledInstance(l, b,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way 
		logobtn = new ImageIcon(newimg_logobtn);  // transform it back
		return logobtn;
	}
}
