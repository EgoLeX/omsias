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
import java.io.IOException;
import java.util.Locale;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.Desktop;

import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.ScrollPaneConstants;

public class helppage {

	private JFrame frame;
	private Border line = new LineBorder(Color.LIGHT_GRAY);
	private JEditorPane ep_content = new JEditorPane();
	private JScrollPane scrollpane_ep_content = new JScrollPane(ep_content);

	/**
	 * Launch the application.
	 */
	public static void helpwindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					helppage window = new helppage();
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
	public helppage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setSize(1000, 563);
		frame.setType(Type.UTILITY);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setUndecorated(true);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(helppage.class.getResource("/img/ic_omsias.png")));
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 165, 0));
		JLabel label = new JLabel(Messages.getString("help.title"));
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Arial", Font.BOLD, 15));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 2793, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(label)
					.addContainerGap(2633, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 27, Short.MAX_VALUE)
				.addComponent(label, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
		);
		panel.setLayout(gl_panel);
		
		//-----------------------------------------------------------> button backtomainmenu
		JButton btnBacktoMain = new JButton(Messages.getString("help.backtomainmenu")); //$NON-NLS-1$
		btnBacktoMain.setFont(new Font("Arial", Font.PLAIN, 14));
		btnBacktoMain.setFocusPainted(false);
		btnBacktoMain.setContentAreaFilled(false);
		btnBacktoMain.setBorder(line);
		btnBacktoMain.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
			}
		});
		btnBacktoMain.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		        btnBacktoMain.setForeground(new Color(255, 165, 0));
		        Border lineorange = new LineBorder(new Color(255, 165, 0));
		        btnBacktoMain.setBorder(lineorange);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		        btnBacktoMain.setForeground(new Color(0,0,0));
		        line = new LineBorder(Color.LIGHT_GRAY);
		        btnBacktoMain.setBorder(line);
		    }
		});
		
		//-----------------------------------------------------------> button faq
		
		JButton btnQuestionAnswer = new JButton(Messages.getString("help.faq")); //$NON-NLS-1$
		btnQuestionAnswer.setFont(new Font("Arial", Font.PLAIN, 14));
		btnQuestionAnswer.setFocusPainted(false);
		btnQuestionAnswer.setContentAreaFilled(false);
		btnQuestionAnswer.setBorder(line);
		btnQuestionAnswer.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		        btnQuestionAnswer.setForeground(new Color(255, 165, 0));
		        Border lineorange = new LineBorder(new Color(255, 165, 0));
		        btnQuestionAnswer.setBorder(lineorange);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		        btnQuestionAnswer.setForeground(new Color(0,0,0));
		        line = new LineBorder(Color.LIGHT_GRAY);
		        btnQuestionAnswer.setBorder(line);
		    }
		});
		btnQuestionAnswer.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(Locale.getDefault()==Locale.UK || Locale.getDefault()==Locale.US) {
					contenthtml("/p/faq_en.html");
				} else if(Locale.getDefault()==Locale.GERMANY) {
					contenthtml("/p/faq_de.html");
				} else {
					contenthtml("/p/faq_en.html");
				}
			}
		});
		ep_content.setEditable(false);
		ep_content.addHyperlinkListener(new HyperlinkListener() {
            @Override
            public void hyperlinkUpdate(HyperlinkEvent hle) {
                if (HyperlinkEvent.EventType.ACTIVATED.equals(hle.getEventType())) {
                    Desktop desktop = Desktop.getDesktop();
                    try {
                        desktop.browse(hle.getURL().toURI());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
		//----------------------------------------------------------->
		
		scrollpane_ep_content.setBorder(line);
		scrollpane_ep_content.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollpane_ep_content.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		//-----------------------------------------------------------> button terms of use
		
		JButton btn_termsofuse = new JButton(Messages.getString("help.license"));
		btn_termsofuse.setFont(new Font("Arial", Font.PLAIN, 14));
		btn_termsofuse.setFocusPainted(false);
		btn_termsofuse.setContentAreaFilled(false);
		btn_termsofuse.setBorder(line);
		btn_termsofuse.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		        btn_termsofuse.setForeground(new Color(255, 165, 0));
		        Border lineorange = new LineBorder(new Color(255, 165, 0));
		        btn_termsofuse.setBorder(lineorange);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		        btn_termsofuse.setForeground(new Color(0,0,0));
		        line = new LineBorder(Color.LIGHT_GRAY);
		        btn_termsofuse.setBorder(line);
		    }
		});
		btn_termsofuse.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if(Locale.getDefault()==Locale.UK || Locale.getDefault()==Locale.US) {
						contenthtml("/p/termsofuse_en.html");
					} else if(Locale.getDefault()==Locale.GERMANY) {
						contenthtml("/p/termsofuse_de.html");
					} else {
						contenthtml("/p/termsofuse_en.html");
					}
				}
			});
		
		//-----------------------------------------------------------> button splashscreen
		
		JButton btn_splashscreen = new JButton(Messages.getString("helppage.btn_splashscreen.text")); //$NON-NLS-1$
		btn_splashscreen.setFont(new Font("Arial", Font.PLAIN, 14));
		btn_splashscreen.setFocusPainted(false);
		btn_splashscreen.setContentAreaFilled(false);
		btn_splashscreen.setBorder(line);
		btn_splashscreen.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		        btn_splashscreen.setForeground(new Color(255, 165, 0));
		        Border lineorange = new LineBorder(new Color(255, 165, 0));
		        btn_splashscreen.setBorder(lineorange);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		        btn_splashscreen.setForeground(new Color(0,0,0));
		        line = new LineBorder(Color.LIGHT_GRAY);
		        btn_splashscreen.setBorder(line);
		    }
		});
		btn_splashscreen.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if(Locale.getDefault()==Locale.UK || Locale.getDefault()==Locale.US) {
						contenthtml("/p/splashscreen_en.html");
					} else if(Locale.getDefault()==Locale.GERMANY) {
						contenthtml("/p/splashscreen_de.html");
					} else {
						contenthtml("/p/splashscreen_en.html");
					}
				}
			});
		//----------------------------------------------------------->
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnQuestionAnswer, GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
						.addComponent(btnBacktoMain, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)
						.addComponent(btn_termsofuse, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)
						.addComponent(btn_splashscreen, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollpane_ep_content, GroupLayout.PREFERRED_SIZE, 752, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnQuestionAnswer, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btn_termsofuse, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btn_splashscreen, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
							.addGap(371)
							.addComponent(btnBacktoMain, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollpane_ep_content, GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE))
					.addContainerGap())
		);
		frame.getContentPane().setLayout(groupLayout);
	}
	
	private void contenthtml(String link) {
        try {
        	ep_content.setContentType("text/html");
            ep_content.setPage(this.getClass().getResource(link));
        } 
        catch (IOException ioe) {
            // HTML wird als Texttyp vorgegeben.
            ep_content.setContentType("text/html");
            ep_content.setText("<html> <center>"
                    + "Page not found"
                    + "</center> </html>.");
        }
	}
}
