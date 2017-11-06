package panel;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.Font;


public class HomePanel {

	JPanel panel;
	
	JTextPane txtpnresultat,txtpntext;
	private JTextField tfKeyC;
	
	private String text = "";
	private String resultat = "";
	JButton btnDecoder,btnCoder;

	
private JFrame frame;
private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePanel window = new HomePanel();
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
	public HomePanel() {
		initialize();
		functionalize();
;		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Application of Simple Cryptographie Algorithm");
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.getContentPane().setBackground(new Color(192, 192, 192));
		frame.setBounds(150, 80, 1000, 640);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		//***********************************Second panel*********************************
		panel = new JPanel();
		panel.setBackground(new Color(153, 153, 153));
		panel.setForeground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 220, 613);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		//***********************************Label*********************************
		JLabel lblTitle = new JLabel("Application of Simple Cryptographie Algorithm");
		lblTitle.setFont(new Font("Dialog", Font.BOLD, 14));
		lblTitle.setBounds(446, 28, 328, 15);
		frame.getContentPane().add(lblTitle);
		
		JLabel lblTheR = new JLabel("The result :");
		lblTheR.setBounds(242, 327, 90, 15);
		frame.getContentPane().add(lblTheR);
		
		JLabel lblYTxt = new JLabel("Your text :");
		lblYTxt.setBounds(232, 73, 183, 15);
		frame.getContentPane().add(lblYTxt);
		
		JLabel lblConfig = new JLabel("Configuration");
		lblConfig.setBounds(60, 12, 94, 15);
		panel.add(lblConfig);
		
		JLabel lblKeyCesar = new JLabel("key :");
		lblKeyCesar.setBounds(18, 119, 42, 15);
		panel.add(lblKeyCesar);
		
		//***********************************ScrollPane+TextPane*********************************
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(232, 354, 742, 215);
		frame.getContentPane().add(scrollPane);
		
		txtpnresultat = new JTextPane();
		scrollPane.setViewportView(txtpnresultat);
		txtpnresultat.setText(resultat);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(232, 100, 742, 215);
		frame.getContentPane().add(scrollPane_1);
		
		txtpntext = new JTextPane();
		scrollPane_1.setViewportView(txtpntext);
		
		//***********************************TextFileds*********************************
		tfKeyC= new JTextField();
		tfKeyC.setText("5");
		
		tfKeyC.setBounds(60, 117, 42, 19);
		panel.add(tfKeyC);
		tfKeyC.setColumns(10);
		
		//***********************************Button*********************************
		btnCoder = new JButton("Code");
		btnCoder.setBackground(new Color(153, 153, 153));
		btnCoder.setBounds(505, 322, 90, 25);
		frame.getContentPane().add(btnCoder);
		
		
		btnDecoder = new JButton("Decode");
		btnDecoder.setForeground(new Color(51, 51, 51));
		btnDecoder.setBackground(new Color(153, 153, 153));
		btnDecoder.setBounds(645, 322, 90, 25);
		frame.getContentPane().add(btnDecoder);
		
		
		//***********************************JRadioButton*********************************
		
		JRadioButton rdbtnCesarAlgo = new JRadioButton("Cesar Algorithm");
		rdbtnCesarAlgo.setBackground(new Color(153, 153, 153));
		rdbtnCesarAlgo.setSelected(true);
		rdbtnCesarAlgo.setBounds(8, 88, 144, 23);
		panel.add(rdbtnCesarAlgo);

		JRadioButton rdbtnVignreAlgo = new JRadioButton("Vignére Algorithm");
		rdbtnVignreAlgo.setBackground(new Color(153, 153, 153));
		rdbtnVignreAlgo.setBounds(8, 167, 157, 23);
		panel.add(rdbtnVignreAlgo);
		
		ButtonGroup btngAlgo = new ButtonGroup();
		btngAlgo.add(rdbtnCesarAlgo);
		btngAlgo.add(rdbtnVignreAlgo);
		
	}

	private void functionalize() {
		
		btnCoder.addActionListener( new ActionListener()
		{
			@Override
		    public void actionPerformed(ActionEvent e)
		    {
			    try
			    {
				    //JOptionPane.showMessageDialog(btnCoder,this, "Do Coder Clicked",1);
			    	System.out.println("Do Coder Clicked");
			    	String _text= new String(txtpntext.getText());
			    	
			    	System.out.println("voici tstpntext.getText : "+_text);
			    	
			    	//resultat = Algorithmes.codeCesar(_text,Integer.parseInt(tfKeyC.getText()));
			    	resultat = Algorithmes.codeVigenere(_text,"abbb");
			    	txtpnresultat.setText(resultat);
			    	
			    }
			    catch (NullPointerException a)
			    {
			       /* gestion de l'erreur */
			    }	
		    }
		});
		btnDecoder.addActionListener( new ActionListener()
		{
		    @Override
		    public void actionPerformed(ActionEvent e)
		    {
		        System.out.println("Do Decoder Clicked");
		    	String _text= new String(txtpntext.getText());
		    	
		    	System.out.println("voici tstpntext.getText : "+_text);
		    	
		    	//resultat = Algorithmes.decodeCesar(_text,Integer.parseInt(tfKeyC.getText()));
		    	resultat = Algorithmes.decodeVigenere(_text,"abbb");
		    	txtpnresultat.setText(resultat);
		    }
		});
		
	}
	
	

		//***********************************Getters*********************************
		public String getText() {
			return text;
		}


		//***********************************Setters*********************************
		public void setText(String text) {
			this.text = text;
		}

		
}
