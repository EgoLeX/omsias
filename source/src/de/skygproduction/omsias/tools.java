package de.skygproduction.omsias;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.Desktop;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.ScrollPaneConstants;;

public class tools {

	private JFrame frame;
	private Border line = new LineBorder(Color.LIGHT_GRAY);
	public Process prc;
	private JEditorPane ep_info = new JEditorPane();
	private JScrollPane sp = new JScrollPane(ep_info);
	private JEditorPane ep_logfile_full = new JEditorPane();
	private JScrollPane sp_logfile_full = new JScrollPane(ep_logfile_full);
	private JEditorPane ep_omsicontent = new JEditorPane();
	private JScrollPane sp_installed_content = new JScrollPane(ep_omsicontent);
	private File directory = new File("");
	private String pathtoomsifolder;
	
	Properties prop = new Properties();
	InputStream input = null;
	File fileproperties = new File("config.properties");

	/**
	 * Launch the application.
	 */
	public static void toolspg() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tools window = new tools();
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
	public tools() {
		load();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//initialise frame
		frame = new JFrame();
		frame.setResizable(false);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(startgame_chooser.class.getResource("/img/ic_omsias.png")));
		frame.setType(Type.UTILITY);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);
		frame.setSize(1000,563);
		frame.setLocationRelativeTo(null);
		
		//creating gui
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 165, 0));
		
		JLabel label = new JLabel(Messages.getString("tools.title"));
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Arial", Font.BOLD, 15));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 1000, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(label)
					.addContainerGap(817, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 27, Short.MAX_VALUE)
				.addComponent(label, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
		);
		panel.setLayout(gl_panel);
		
		//------------------------------------------------------------> button backtomainmenu
		
		JButton btn_backtomain = new JButton(Messages.getString("tools.backmenu"));
		btn_backtomain.setFont(new Font("Arial", Font.PLAIN, 12));
		btn_backtomain.setFocusPainted(false);
		btn_backtomain.setContentAreaFilled(false);
		btn_backtomain.setBorder(line);
		btn_backtomain.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
			}
		});
		
		btn_backtomain.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		        btn_backtomain.setForeground(new Color(255, 165, 0));
		        Border lineorange = new LineBorder(new Color(255, 165, 0));
		        btn_backtomain.setBorder(lineorange);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		        btn_backtomain.setForeground(new Color(0,0,0));
		        line = new LineBorder(Color.LIGHT_GRAY);
		        btn_backtomain.setBorder(line);
		    }
		});
		//------------------------------------------------------------> 
		
		
		ep_info.setEditable(false);
		ep_info.setFont(new Font("Arial", Font.PLAIN, 12));
		ep_info.setText("");
		ep_info.setBackground(new Color(240,240,240));
		sp.setBorder(line);
		sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		ep_logfile_full.setEditable(false);
		ep_logfile_full.setFont(new Font("Arial", Font.PLAIN, 12));
		ep_logfile_full.setText("");
		ep_logfile_full.setBackground(new Color(240,240,240));
		sp_logfile_full.setBorder(line);
		sp_logfile_full.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		sp_logfile_full.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		ep_omsicontent.setFont(new Font("Arial", Font.PLAIN, 12));
		ep_omsicontent.setEditable(false);
		ep_omsicontent.setBackground(new Color(240,240,240));
		ep_omsicontent.setText("");
		sp_installed_content.setBorder(line);
		sp_installed_content.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		sp_installed_content.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		
		//------------------------------------------------------------> button 4gb patch
		
		
		JButton btn_4gbpatch = new JButton(Messages.getString("tools.gbpatch"));
		btn_4gbpatch.setFont(new Font("Arial", Font.PLAIN, 12));
		btn_4gbpatch.setFocusPainted(false);
		btn_4gbpatch.setContentAreaFilled(false);
		btn_4gbpatch.setBorder(line);
		btn_4gbpatch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String pathtoomsiobjecteditp = "toolsrc/ntcore/";
				OpenFolder(pathtoomsiobjecteditp);				
			}
		});
		
		btn_4gbpatch.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		        btn_4gbpatch.setForeground(new Color(255, 165, 0));
		        Border lineorange = new LineBorder(new Color(255, 165, 0));
		        btn_4gbpatch.setBorder(lineorange);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		        btn_4gbpatch.setForeground(new Color(0,0,0));
		        line = new LineBorder(Color.LIGHT_GRAY);
		        btn_4gbpatch.setBorder(line);
		    }
		});
		
		//------------------------------------------------------------> button info_patch
		
		JButton btn_info_patch = new JButton(Messages.getString("tools.infobtn")); //$NON-NLS-1$
		btn_info_patch.setFont(new Font("Arial", Font.PLAIN, 12));
		btn_info_patch.setFocusPainted(false);
		btn_info_patch.setContentAreaFilled(false);
		btn_info_patch.setBorder(line);
		btn_info_patch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(ep_info.getText().equals("")) {
					ep_info.setText(Messages.getString("tools.info.gbpatch"));
				} else {
					ep_info.setText("");
				}
			}
		});
		
		btn_info_patch.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		        btn_info_patch.setForeground(new Color(255, 165, 0));
		        Border lineorange = new LineBorder(new Color(255, 165, 0));
		        btn_info_patch.setBorder(lineorange);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		        btn_info_patch.setForeground(new Color(0,0,0));
		        line = new LineBorder(Color.LIGHT_GRAY);
		        btn_info_patch.setBorder(line);
		    }
		});
		
		//------------------------------------------------------------> button logfile
		
		JButton btn_logfile = new JButton(Messages.getString("tools.btn_logfile")); //$NON-NLS-1$
		btn_logfile.setFont(new Font("Arial", Font.PLAIN, 12));
		btn_logfile.setFocusPainted(false);
		btn_logfile.setContentAreaFilled(false);
		btn_logfile.setBorder(line);
		btn_logfile.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					readLog();
			}
		});
		
		btn_logfile.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		        btn_logfile.setForeground(new Color(255, 165, 0));
		        Border lineorange = new LineBorder(new Color(255, 165, 0));
		        btn_logfile.setBorder(lineorange);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		        btn_logfile.setForeground(new Color(0,0,0));
		        line = new LineBorder(Color.LIGHT_GRAY);
		        btn_logfile.setBorder(line);
		    }
		});
		
		//------------------------------------------------------------> button info logfile
		
		JButton btn_info_logfile = new JButton("i");
		btn_info_logfile.setFont(new Font("Arial", Font.PLAIN, 12));
		btn_info_logfile.setFocusPainted(false);
		btn_info_logfile.setContentAreaFilled(false);
		btn_info_logfile.setBorder(line);
		btn_info_logfile.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(ep_info.getText().equals("")) {
					ep_info.setText(Messages.getString("tools.info.logfile"));
				} else {
					ep_info.setText("");
				}
			}
		});
		
		btn_info_logfile.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		        btn_info_logfile.setForeground(new Color(255, 165, 0));
		        Border lineorange = new LineBorder(new Color(255, 165, 0));
		        btn_info_logfile.setBorder(lineorange);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		        btn_info_logfile.setForeground(new Color(0,0,0));
		        line = new LineBorder(Color.LIGHT_GRAY);
		        btn_info_logfile.setBorder(line);
		    }
		});
		
		//------------------------------------------------------------> button objecteditp
		
		JButton btn_omsiobjeditp = new JButton(Messages.getString("tools.btn_omsiobjeditp.text")); //$NON-NLS-1$
		btn_omsiobjeditp.setFont(new Font("Arial", Font.PLAIN, 12));
		btn_omsiobjeditp.setFocusPainted(false);
		btn_omsiobjeditp.setContentAreaFilled(false);
		btn_omsiobjeditp.setBorder(line);
		btn_omsiobjeditp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String pathtoomsiobjecteditp = "toolsrc/omsitool/OmsiObjEditP.exe";
				toolsstart(pathtoomsiobjecteditp);
			}
		});
		
		btn_omsiobjeditp.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btn_omsiobjeditp.setForeground(new Color(255, 165, 0));
		        Border lineorange = new LineBorder(new Color(255, 165, 0));
		        btn_omsiobjeditp.setBorder(lineorange);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btn_omsiobjeditp.setForeground(new Color(0,0,0));
		        line = new LineBorder(Color.LIGHT_GRAY);
		        btn_omsiobjeditp.setBorder(line);
		    }
		});
		
		//------------------------------------------------------------> button omsixconv

		JButton btn_omsixconv = new JButton(Messages.getString("tools.btn_omsixconv.text")); //$NON-NLS-1$
		btn_omsixconv.setFont(new Font("Arial", Font.PLAIN, 12));
		btn_omsixconv.setFocusPainted(false);
		btn_omsixconv.setContentAreaFilled(false);
		btn_omsixconv.setBorder(line);
		btn_omsixconv.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String pathtoomsiobjecteditp = "toolsrc/omsitool/OmsiXConv.exe";
				toolsstart(pathtoomsiobjecteditp);				
			}
		});
		
		btn_omsixconv.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btn_omsixconv.setForeground(new Color(255, 165, 0));
		        Border lineorange = new LineBorder(new Color(255, 165, 0));
		        btn_omsixconv.setBorder(lineorange);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btn_omsixconv.setForeground(new Color(0,0,0));
		        line = new LineBorder(Color.LIGHT_GRAY);
		        btn_omsixconv.setBorder(line);
		    }
		});
		
		//------------------------------------------------------------> button repainttool
		
		JButton btn_repainttool = new JButton(Messages.getString("tools.btn_repainttool.text")); //$NON-NLS-1$
		btn_repainttool.setFont(new Font("Arial", Font.PLAIN, 12));
		btn_repainttool.setFocusPainted(false);
		btn_repainttool.setContentAreaFilled(false);
		btn_repainttool.setBorder(line);
		btn_repainttool.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String pathtoomsiobjecteditp = "toolsrc/omsitool/RepaintTool.exe";
				toolsstart(pathtoomsiobjecteditp);					
			}
		});
		
		btn_repainttool.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		        btn_repainttool.setForeground(new Color(255, 165, 0));
		        Border lineorange = new LineBorder(new Color(255, 165, 0));
		        btn_repainttool.setBorder(lineorange);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		        btn_repainttool.setForeground(new Color(0,0,0));
		        line = new LineBorder(Color.LIGHT_GRAY);
		        btn_repainttool.setBorder(line);
		    }
		});
		
		//------------------------------------------------------------> button streetcreator
		
		JButton btn_streetcreator = new JButton(Messages.getString("tools.btn_streetcreator.text")); //$NON-NLS-1$
		btn_streetcreator.setFont(new Font("Arial", Font.PLAIN, 12));
		btn_streetcreator.setFocusPainted(false);
		btn_streetcreator.setContentAreaFilled(false);
		btn_streetcreator.setBorder(line);
		btn_streetcreator.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String pathtoomsiobjecteditp = "toolsrc/omsitool/StreetCreator.exe";
				toolsstart(pathtoomsiobjecteditp);					
			}
		});
		
		btn_streetcreator.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		        btn_streetcreator.setForeground(new Color(255, 165, 0));
		        Border lineorange = new LineBorder(new Color(255, 165, 0));
		        btn_streetcreator.setBorder(lineorange);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		        btn_streetcreator.setForeground(new Color(0,0,0));
		        line = new LineBorder(Color.LIGHT_GRAY);
		        btn_streetcreator.setBorder(line);
		    }
		});
		
		JLabel lbl_sdktools = new JLabel(Messages.getString("tools.sdklbl")); //$NON-NLS-1$
		lbl_sdktools.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
		
		//------------------------------------------------------------> button installed maps
		
		JButton btn_get_installed_maps = new JButton(Messages.getString("tools.btn_installedmaps")); //$NON-NLS-1$
		btn_get_installed_maps.setFont(new Font("Arial", Font.PLAIN, 12));
		btn_get_installed_maps.setFocusPainted(false);
		btn_get_installed_maps.setContentAreaFilled(false);
		btn_get_installed_maps.setBorder(line);
		btn_get_installed_maps.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		        btn_get_installed_maps.setForeground(new Color(255, 165, 0));
		        Border lineorange = new LineBorder(new Color(255, 165, 0));
		        btn_get_installed_maps.setBorder(lineorange);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btn_get_installed_maps.setForeground(new Color(0,0,0));
		        line = new LineBorder(Color.LIGHT_GRAY);
		        btn_get_installed_maps.setBorder(line);
		    }
		});
		btn_get_installed_maps.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(ep_omsicontent.getText().equals("")) {
					String mapspath = pathtoomsifolder;
					mapspath = new StringBuilder(mapspath).append("/maps/").toString();
					directory = new File(mapspath);
					String[] directories = directory.list(new FilenameFilter() {
						  @Override
						  public boolean accept(File current, String name) {
						    return new File(current, name).isDirectory();
						  }
						});
					ep_omsicontent.setText(Arrays.toString(directories));
				} else {
					ep_omsicontent.setText("");
				}
			}
		});
		
		//------------------------------------------------------------> button installed busses
		
		JButton btn_get_installed_busses = new JButton(Messages.getString("tools.installedbusses")); //$NON-NLS-1$
		btn_get_installed_busses.setFont(new Font("Arial", Font.PLAIN, 12));
		btn_get_installed_busses.setFocusPainted(false);
		btn_get_installed_busses.setContentAreaFilled(false);
		btn_get_installed_busses.setBorder(line);
		btn_get_installed_busses.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		        btn_get_installed_busses.setForeground(new Color(255, 165, 0));
		        Border lineorange = new LineBorder(new Color(255, 165, 0));
		        btn_get_installed_busses.setBorder(lineorange);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btn_get_installed_busses.setForeground(new Color(0,0,0));
		        line = new LineBorder(Color.LIGHT_GRAY);
		        btn_get_installed_busses.setBorder(line);
		    }
		});
		btn_get_installed_busses.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(ep_omsicontent.getText().equals("")) {
					String vehiclespath = pathtoomsifolder;
					vehiclespath = new StringBuilder(vehiclespath).append("/vehicles/").toString();
					directory = new File(vehiclespath);
					String[] directories = directory.list(new FilenameFilter() {
						  @Override
						  public boolean accept(File current, String name) {
						    return new File(current, name).isDirectory();
						  }
						});
					ep_omsicontent.setText(Arrays.toString(directories));
				} else {
					ep_omsicontent.setText("");
				}
			}
		});
		
		//------------------------------------------------------------>
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(btn_backtomain, GroupLayout.PREFERRED_SIZE, 980, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btn_4gbpatch, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btn_info_patch, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btn_logfile, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btn_info_logfile, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
						.addComponent(lbl_sdktools, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE))
					.addGap(131)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(sp_logfile_full)
						.addComponent(sp, GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE))
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btn_omsiobjeditp, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btn_omsixconv, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
					.addComponent(btn_repainttool, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btn_streetcreator, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btn_get_installed_maps, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE)
						.addComponent(btn_get_installed_busses, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 167, Short.MAX_VALUE)
					.addComponent(sp_installed_content, GroupLayout.PREFERRED_SIZE, 580, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(sp, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
						.addComponent(btn_info_patch, GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
						.addComponent(btn_4gbpatch, GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btn_logfile, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
								.addComponent(btn_info_logfile, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
							.addComponent(lbl_sdktools, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
							.addGap(22))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(13)
							.addComponent(sp_logfile_full, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btn_omsiobjeditp, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(btn_streetcreator, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
							.addComponent(btn_omsixconv, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
							.addComponent(btn_repainttool, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)))
					.addGap(42)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btn_get_installed_maps, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btn_get_installed_busses, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
						.addComponent(sp_installed_content, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
					.addGap(50)
					.addComponent(btn_backtomain, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		frame.getContentPane().setLayout(groupLayout);
	}
	
    public void readLog() {
    	String pathlog = new StringBuilder(pathtoomsifolder).append("/logfile.txt").toString();
    	File file = new File(pathlog);
    	try {
			ep_logfile_full.setPage(file.toURI().toURL());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
	
	public void prozess(String path) {
		try {
			prc = new ProcessBuilder(path).start();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void toolsstart(String _toolpath) {
		File jarDir = new File(ClassLoader.getSystemClassLoader().getResource(".").getPath());
		String toolpath = new StringBuilder(jarDir.getAbsolutePath().replaceAll("%20", " ")).toString();
		StringBuilder toolpath_sb = new StringBuilder(toolpath.substring(0, toolpath.length()-3));
		String toolpath_st = new StringBuilder(toolpath_sb.append(_toolpath)).toString();
		try {
			prc = new ProcessBuilder(toolpath_st).start();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void OpenFolder(String path) {
		File jarDir = new File(ClassLoader.getSystemClassLoader().getResource(".").getPath());
		String path_X = new StringBuilder(jarDir.getAbsolutePath().replaceAll("%20", " ")).toString();
		StringBuilder path_sb = new StringBuilder(path_X.substring(0, path_X.length()-3));
		String path_explorer = new StringBuilder(path_sb.append(path)).toString();
		File f = new File(path_explorer);
		try {
			Desktop dt = Desktop.getDesktop();
			dt.open(f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void load() {
		if(fileproperties.exists() && fileproperties.isFile()) {
			try {
				input = new FileInputStream(fileproperties);
				// load a properties file
				prop.load(input);
	
				// get the property value and print it out
				pathtoomsifolder = prop.getProperty("path_omsipath");
	
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
