
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;



public class demo {
	
	int total_vending_item () { return 10; }

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					demo window = new demo();
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
	public demo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 1000, 760);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setMaximumSize(new Dimension(1000,760));
		

		
		final JPanel parentPanel = new JPanel();
		parentPanel.setBackground(Color.BLUE);
		// FIrstly width and height
		parentPanel.setBounds(0,0,1000,550);
		frame.getContentPane().add(parentPanel);
		parentPanel.setLayout(new CardLayout(0, 0));
		
		
		final JPanel lowerPanel=new JPanel();
		lowerPanel.setBackground(Color.CYAN);
		lowerPanel.setBounds(0,549,1000,190);
		frame.getContentPane().add(lowerPanel);
		lowerPanel.setLayout(new GridLayout(0, 3, 0, 0));
		
		final JPanel leftPanel=new JPanel();
		leftPanel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		leftPanel.setBackground(Color.MAGENTA);
		lowerPanel.add(leftPanel);
		leftPanel.setLayout(new GridLayout(3, 0, 0, 0));
		
		final JLabel left_label=new JLabel("<html><b><i>You have selected the following items:</b></i></html>");
		leftPanel.add(left_label);
		leftPanel.setBackground(Color.cyan);
		
		final JTextArea left_text=new JTextArea();
	    left_text.setBackground(Color.WHITE);
		leftPanel.add(left_text);
		
		final  JPanel left_Lowpanel=new JPanel();
		leftPanel.add(left_Lowpanel);
		left_Lowpanel.setBackground(Color.MAGENTA);
		left_Lowpanel.setLayout(new GridLayout(1, 2, 3, 3));
		
		final JLabel left_LowpanelJlabel=new JLabel("<html><b>Total-Please Insert:-</b></html>");
		left_LowpanelJlabel.setHorizontalAlignment(SwingConstants.CENTER);
		left_Lowpanel.add(left_LowpanelJlabel);
		
		final JTextField left_Lowpaneltext=new JTextField();
		left_Lowpanel.add(left_Lowpaneltext);
		left_Lowpaneltext.setMargin(new Insets(100,100,100,100));
		
		
		
		
		
		
		
		
		
		
		final JPanel centerPanel=new JPanel();
		centerPanel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		centerPanel.setBackground(Color.GREEN);
		lowerPanel.add(centerPanel);
		centerPanel.setLayout(new BorderLayout(3, 3));
		JPanel uppercenterpanel=new JPanel();
		JPanel lowercenterpanel=new JPanel();
		centerPanel.add( uppercenterpanel,BorderLayout.NORTH);
		centerPanel.add(lowercenterpanel,BorderLayout.CENTER);
		
		uppercenterpanel.setPreferredSize(new Dimension(30,30));
		JLabel centeruppertext=new JLabel("<html><b><i>Please select the coins</b></i></html>");
		uppercenterpanel.add(centeruppertext);
		 
		
		
		
		lowercenterpanel.setLayout(new GridLayout(3, 3, 50, 10));
		JButton[] coin=new JButton[6];
		for(int i=0;i<6;i++)
		{
			 coin[i]=new JButton();
			 lowercenterpanel.add(coin[i]);
			 try{
			 Image img = ImageIO.read(getClass().getResource("coin.jpg"));
			 img = img.getScaledInstance(100, 25,  java.awt.Image.SCALE_SMOOTH ) ;
			 coin[i].setIcon(new ImageIcon(img));
			 }
			 catch(Exception e)
			 {
				 
			 }
		}
		
		
		final JPanel rightPanel=new JPanel();
		rightPanel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		rightPanel.setBackground(Color.YELLOW);
		//northPanel.setBounds(0, 0, 10, 223);
		lowerPanel.add(rightPanel);
		rightPanel.setLayout(new BorderLayout(3, 3));
		final JPanel right_upper=new JPanel();
		right_upper.setBackground(Color.YELLOW);
		
		JPanel rightPanel1=new JPanel();
		rightPanel.add(rightPanel1,BorderLayout.NORTH);
		rightPanel1.setPreferredSize(new Dimension(30,30));
		rightPanel1.setLayout(new GridLayout(1, 2, 5, 5));
		JLabel total=new JLabel("Total amount entered");
		total.setBackground(Color.blue);
		rightPanel1.add(total);
		final JTextArea totaltext=new JTextArea();
	    rightPanel1.setBackground(Color.WHITE);
		rightPanel1.add(totaltext);
		
		
		
		JPanel rightPanel2=new JPanel();
		rightPanel.add(rightPanel2,BorderLayout.CENTER);
		rightPanel2.setLayout(new GridLayout(3, 0, 3, 3));
		JButton[] right_button=new JButton[2];
		for (int i=0;i<2;i++){
			 right_button[i]=new JButton();
			 rightPanel2.add(right_button[i]);
		}
		right_button[0].setText("PAY BY CASH");
		right_button[1].setText("PAY BY COINS");
		JLabel error=new JLabel("ENTER AGAIN");
		error.setHorizontalAlignment(SwingConstants.CENTER);
		rightPanel2.add(error);
		
		
		
		JPanel rightPanel3=new JPanel();
		rightPanel.add(rightPanel3,BorderLayout.SOUTH);
		rightPanel3.setPreferredSize(new Dimension(30,30));
		rightPanel3.setLayout(new BorderLayout(0, 0));
		JButton cancel=new JButton();
		cancel.setText("<html><b>CANCEL OR RESET THE ORDER</b></html>");
		rightPanel3.add(cancel,BorderLayout.CENTER);
				
		
		
		
		
		
		JPanel button_panel = new JPanel();
		final JPanel panel1 = new JPanel();
		JPanel upperPanel = new JPanel();
		panel1.add(upperPanel);
		upperPanel.setBounds(0,0,1000,50);
		upperPanel.setLayout(new GridLayout(1, 0, 0, 0));
		upperPanel.setBackground(Color.RED);
		JLabel label=new JLabel("<html><b></i><u>WELCOME TO VENDING MACHINE</u></b></html></i>");
		upperPanel.add(label);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setVerticalAlignment(JLabel.CENTER);
		label.setFont(new Font("Serif", Font.PLAIN, 20));
	
		
		
		
		
		parentPanel.add(button_panel, "name_1463718721967014000");
		button_panel.setLayout(new BoxLayout(button_panel, BoxLayout.X_AXIS));
		//panel1.setBounds(50, 50, 800, 400);
		//panel1.setPreferredSize(new Dimension(420,280));
		//panel1.setSize(new Dimension(700,30));
		
		parentPanel.add(panel1, "priya");
		panel1.setBackground(Color.RED);
		panel1.setLayout(null);
	
		
        final JPanel mainPanel = new JPanel();
        mainPanel.setBounds(50,50,500, 550);
       
      //  panel1.add(mainPanel);
        
       
        mainPanel.setBackground(Color.ORANGE);
        mainPanel.setLayout(new GridLayout(0, 4, 20, 10));
        
      
         JScrollPane scrollPane = new JScrollPane(mainPanel);
         scrollPane.setViewportBorder(new LineBorder(Color.ORANGE, 10, true));
		
		/*scrollPane.setViewportView(panel1);*/
		scrollPane.setSize(new Dimension(900,500));
        scrollPane.setHorizontalScrollBarPolicy(scrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(scrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(50, 50, 900, 500);
        
        
        panel1.add(scrollPane);
        
		/*JScrollPane scrollPane = new JScrollPane(mainPanel);
		
		/*scrollPane.setViewportView(panel1);
		scrollPane.setSize(new Dimension(300,300));
        scrollPane.setHorizontalScrollBarPolicy(scrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(scrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setVisible(true);*/
       
	    JButton btnNewButton = new JButton("ENTER ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				parentPanel.removeAll();
				parentPanel.add(panel1);
				parentPanel.repaint();
				parentPanel.revalidate();
				JButton[] group_of_buttons = new JButton[total_vending_item()];
				

				for (int i=0;i<total_vending_item();i++){ 

							group_of_buttons[i] =new JButton();
							
							group_of_buttons[i].setBackground(Color.black);

							//group_of_buttons[i].setBounds(10+i*200,10,180,180);

							group_of_buttons[i].setVisible(true);

				            mainPanel.add(group_of_buttons[i]);

				            mainPanel.revalidate();

				            mainPanel.repaint();

				//guiframe.getContentPane().add(parentPanel);

				              //  panelGroup.add(new JPanel());

				        }
				populate_buttons(group_of_buttons, total_vending_item());
				
			/*	try {
			        Image img = ImageIO.read(getClass().getResource("cocacola.png"));
			        img = img.getScaledInstance( 200, 180,  java.awt.Image.SCALE_SMOOTH ) ; 
			        group_of_buttons[0].setIcon(new ImageIcon(img));
			        }catch(Exception ep){
			        	
			        }
			*/
			} 
			
		});
		
		button_panel.add(btnNewButton);
		
		
		
	}
	
	
	void populate_buttons(JButton [] group_of_buttons, int count) {
		String img_name = "cocacola.png";
		double price = 5.12;
		String name = "cocacola";
		try {
			//RUN SQL QUERY TO FETCH THE DATA
			for(int i= 0; i< count; i++) {
				Image img = ImageIO.read(getClass().getResource(img_name));
				img = img.getScaledInstance(180, 180,  java.awt.Image.SCALE_SMOOTH ) ; 
				group_of_buttons[i].setIcon(new ImageIcon(img));
				group_of_buttons[i].setText(name);
				group_of_buttons[i].setHorizontalTextPosition(JButton.CENTER);
				group_of_buttons[i].setVerticalTextPosition(JButton.NORTH);
				
				
			}
        }catch(Exception ep){
        	
        }
		
		 
		
	}
	
	
}
