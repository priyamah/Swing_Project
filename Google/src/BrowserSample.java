import com.teamdev.jxbrowser.chromium.*;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.BorderLayout;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.ScrollPaneConstants;
import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.JSFunctionCallback;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;
import com.teamdev.jxbrowser.chromium.JSValue;
import com.teamdev.jxbrowser.chromium.events.ScriptContextAdapter;
import com.teamdev.jxbrowser.chromium.events.ScriptContextEvent;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

 
/**
 * This sample demonstrates how to create Browser instance,
 * embed it into Swing BrowserView container, display it in JFrame and
 * navigate to the "www.google.com" web site.
 */
public class BrowserSample {
	int total_vending_item () { return 20; }

	private JFrame frame;
	StringBuilder text3;
	StringBuilder text4=new StringBuilder("");
	String text_nameProduct;
	String text_Price;
	float total_price= 1;
	float coin_total=0;
	final DecimalFormat df = new DecimalFormat("#.00");
	public static final int MIN_ZOOM = 0;
    public static final int MAX_ZOOM = 21;
    public JTextArea left_text;
    public JPanel mainPanel;
    public JTextField left_Lowpaneltext;
    /**
     * In map.html file default zoom value is set to 4.
     */
    private static int zoomValue = 4;
    
    private  void initialize() {
    	
		frame = new JFrame();
		frame.setBounds(100, 50, 1000, 760);
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
		//northPanel.setBounds(0, 0, 10, 223);
		lowerPanel.add(leftPanel);
		leftPanel.setLayout(new GridLayout(3, 0, 0, 0));
		
		final JLabel left_label=new JLabel("<html><b><i>You have selected the following items:</b></i></html>");
		leftPanel.add(left_label);
		leftPanel.setBackground(Color.cyan);
		
		left_text=new JTextArea();
		final JScrollPane leftscroll=new JScrollPane(left_text);
		leftscroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		left_text.setLineWrap(true);
	    left_text.setBackground(Color.WHITE);
		leftPanel.add(leftscroll);
		left_text.setEditable(false);
		
		final  JPanel left_Lowpanel=new JPanel();
		leftPanel.add(left_Lowpanel);
		left_Lowpanel.setBackground(Color.MAGENTA);
		left_Lowpanel.setLayout(new GridLayout(1, 2, 3, 3));
		
		final JLabel left_LowpanelJlabel=new JLabel("<html><b>Total-Please Insert:-</b></html>");
		left_LowpanelJlabel.setHorizontalAlignment(SwingConstants.CENTER);
		left_Lowpanel.add(left_LowpanelJlabel);
		
		
		
		final JTextField left_Lowpaneltext=new JTextField();
		left_Lowpaneltext.setEnabled(false);
		
		
		left_Lowpaneltext.setHorizontalAlignment(SwingConstants.CENTER);
		left_Lowpanel.add(left_Lowpaneltext);
		left_Lowpanel.setEnabled(false);
		
		left_Lowpaneltext.setMargin(new Insets(100,100,100,100));
		
		final JPanel centerPanel=new JPanel();
		centerPanel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		centerPanel.setBackground(Color.GREEN);
		//northPanel.setBounds(0, 0, 10, 223);
		lowerPanel.add(centerPanel);
		centerPanel.setLayout(new BorderLayout(3, 3));
		JPanel uppercenterpanel=new JPanel();
		//centerlabel1.setSize(new Dimension(50,50));
		JPanel lowercenterpanel=new JPanel();
		centerPanel.add( uppercenterpanel,BorderLayout.NORTH);
		centerPanel.add(lowercenterpanel,BorderLayout.CENTER);
		
		uppercenterpanel.setPreferredSize(new Dimension(20,20));
		JLabel centeruppertext=new JLabel("<html><b><i>Please select the coins /cash:</b></i></html>");
		centeruppertext.setVerticalAlignment(SwingConstants.TOP);
		uppercenterpanel.add(centeruppertext);
		lowercenterpanel.setLayout(new GridLayout(3, 3, 50, 5));
		JButton[] coin=new JButton[6];
		for(int i=0;i<6;i++)
		{
		
			 coin[i]=new JButton();
			 lowercenterpanel.add(coin[i]);
			
				 
			
		}
		 
		
		
		
		//Adding img to each button
		try{
		
		 Image img1 = ImageIO.read(getClass().getResource("doll1.png"));
		
		 Image img2 = ImageIO.read(getClass().getResource("doll5.jpg"));
		
		 Image img3 = ImageIO.read(getClass().getResource("cent1.jpeg"));
		 Image img4 = ImageIO.read(getClass().getResource("cent5.jpg"));
		 Image img5 = ImageIO.read(getClass().getResource("cent10.jpeg"));
		 Image img6 = ImageIO.read(getClass().getResource("cent25.jpeg"));
		 Image[] images = {img1, img2, img3,img4,img5,img6};
		 for (int i=0;i<6;i++){
			 
			
			 images[i] = images[i].getScaledInstance(120, 30,  java.awt.Image.SCALE_SMOOTH ) ;
			
			 coin[i].setIcon(new ImageIcon(images[i]));
		 }
		}
		 catch(Exception e)
		 {
			 System.out.println("Error is" +e);
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
		JLabel total=new JLabel("Total amount entered :");
		total.setBackground(Color.blue);
		rightPanel1.add(total);
		final JTextArea totaltext=new JTextArea();
	    rightPanel1.setBackground(Color.WHITE);
	    totaltext.setEditable(false);
		rightPanel1.add(totaltext);
		
		final JPanel rightPanel2=new JPanel();
		rightPanel.add(rightPanel2,BorderLayout.CENTER);
		rightPanel2.setLayout(new GridLayout(3, 0, 3, 3));
		final JButton[] right_button=new JButton[2];
		for (int i=0;i<2;i++){
			 right_button[i]=new JButton();
			 rightPanel2.add(right_button[i]);
		}
		final JLabel error=new JLabel("");
		error.setHorizontalAlignment(SwingConstants.CENTER);
		rightPanel2.add(error);
		right_button[0].setText("PAY BY CASH");
		right_button[0].setEnabled(false);
		right_button[0].addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e){
				 String enter=totaltext.getText();
				 String enter_subs=enter.substring(1, 5);
				 float entered_cost=Float.parseFloat(enter_subs);
				 df.format(entered_cost);
				 //System.out.println("entered_cost");
				 
				 String req=left_Lowpaneltext.getText();
				
				 String req_subs=req.substring(1, 5);
				// System.out.println("req_subs");
				 float req_cost=Float.parseFloat(req_subs);
				 df.format(req_cost);
				// System.out.println("req_cost");
				 
				 
				 if (entered_cost==req_cost){
					 error.setText("<html><b><u>Thanks!Collect your items!<u><b></html>");
					 error.setForeground(Color.black);
					// error.setBackground(Color.green);
		
					 
					 
				 }
				 else if (entered_cost>req_cost){
					 float remaining=entered_cost-req_cost;
					 error.setText("<html><b><u>Thanks!Collect your items and remaining amount  i.e:-</u>"+remaining+"<b></html>");
					 error.setForeground(Color.black);
					// error.setBackground(Color.green);
					 
				 }
				 else{
					 error.setText("<html><b>Input the correct amount and then proceed!<b></html>");
					 error.setForeground(Color.red);
					 
				 }
	 }});
		right_button[1].setText("PAY BY CARD");
		right_button[1].setEnabled(false);
		
		
		
		// Adding ecvent handlers for coin button
		coin[0].addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e) {
				 right_button[0].setEnabled(true);
				 right_button[1].setEnabled(true);
				 coin_total=coin_total+1;
				 df.format(coin_total);
				 //totaltext.setText(Float.toString(coin_total)+"$");
				 totaltext.setText("$"+df.format(coin_total) );
				 
				 
			 }});
		coin[1].addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e) {
				 right_button[0].setEnabled(true);
				 right_button[1].setEnabled(true);
				 coin_total=coin_total+5;
				 df.format(coin_total);
				 totaltext.setText("$"+df.format(coin_total));
				 
				 
			 }});
		coin[2].addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e) {
				 right_button[0].setEnabled(true);
				 right_button[1].setEnabled(true);
				 coin_total=(float) (coin_total+0.01);
				 df.format(coin_total);
				// totaltext.setText(Float.toString(coin_total)+"$");
				 totaltext.setText("$"+df.format(coin_total));
				 
			 }});
		coin[3].addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e) {
				 right_button[0].setEnabled(true);
				 right_button[1].setEnabled(true);
				 coin_total=(float)(coin_total+0.05);
				 df.format(coin_total);
				// totaltext.setText(Float.toString(coin_total)+"$");
				 totaltext.setText("$"+df.format(coin_total));
				 
			 }});
		coin[4].addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e) {
				 right_button[0].setEnabled(true);
				 right_button[1].setEnabled(true);
				 coin_total=(float)(coin_total+0.10);
				 df.format(coin_total);
				 
				 //totaltext.setText(Float.toString(coin_total)+"$");
				 totaltext.setText("$"+df.format(coin_total) );
				 
			 }});
		coin[5].addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e) {
				 right_button[0].setEnabled(true);
				 right_button[1].setEnabled(true);
				 coin_total=(float)(coin_total+0.25);
				 df.format(coin_total);
				 //totaltext.setText(Float.toString(coin_total)+"$");
				 totaltext.setText("$"+df.format(coin_total));
				 
			 }});
		
		
		
		
		
		JPanel rightPanel3=new JPanel();
		rightPanel.add(rightPanel3,BorderLayout.SOUTH);
		rightPanel3.setPreferredSize(new Dimension(30,30));
		rightPanel3.setLayout(new BorderLayout(0, 0));
		JButton cancel=new JButton();
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				left_text.setText("");
				left_Lowpaneltext.setText("");
				totaltext.setText("");
				error.setText("");
				
				
			}
		});
		cancel.setText("<html><b>CANCEL OR RESET THE ORDER</b></html>");
		rightPanel3.add(cancel,BorderLayout.CENTER);
		
		final JPanel panel1 = new JPanel();
		JPanel upperPanel = new JPanel();
		panel1.add(upperPanel);
		upperPanel.setBounds(0,0,1000,50);
		upperPanel.setLayout(new GridLayout(1, 4, 20, 20));
		upperPanel.setBackground(Color.RED);
		JButton exit=new JButton("EXIT");
		JLabel greet =new JLabel("<html><b>WELCOME GUEST!</b></html>");
		JButton Login=new JButton("Login");
		Login.getColorModel();
		JLabel label=new JLabel("<html><b></i><u> VENDING MACHINE</u></b></html></i>");
		upperPanel.add(exit);
		upperPanel.add(greet);
		upperPanel.add(label);
		upperPanel.add(Login);
		
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setVerticalAlignment(JLabel.CENTER);
		label.setFont(new Font("Serif", Font.PLAIN, 20));
		
		
		parentPanel.add(panel1, "priya");
		panel1.setBackground(Color.RED);
		panel1.setLayout(null);
	
		
        mainPanel = new JPanel();
        mainPanel.setBounds(50,50,500, 550);
        mainPanel.setBackground(Color.ORANGE);
        mainPanel.setLayout(new GridLayout(0, 4, 20, 10));
        
      
         JScrollPane scrollPane = new JScrollPane(mainPanel);
         scrollPane.setViewportBorder(new LineBorder(Color.ORANGE, 10, true));
		
		
		scrollPane.setSize(new Dimension(900,500));
        scrollPane.setHorizontalScrollBarPolicy(scrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(scrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(50, 50, 900, 500);
        
        
        panel1.add(scrollPane);
        
}
	
void populate_buttons(JButton [] group_of_buttons, int count) {
		//String img_name = "cocacola.jpg";
		double price = 5.12;
		String name = "CocaCola";
		
		try {
			//RUN SQL QUERY TO FETCH THE DATA
			for(int i= 0; i< count; i++) {
				//System.out.println(img_name);
				Image img = ImageIO.read(getClass().getResource("cocacola.png"));
				//System.out.println(img);
				img = img.getScaledInstance(100, 150,java.awt.Image.SCALE_SMOOTH ) ; 
				group_of_buttons[i].setIcon(new ImageIcon(img));
				group_of_buttons[i].setText("<html><p><b><u>" + name+"</u></p><b/><p align='center'>$" +price + "</p></html>");
				group_of_buttons[i].setHorizontalTextPosition(JButton.CENTER);
				group_of_buttons[i].setVerticalTextPosition(JButton.NORTH);
				
				
				
			}
        }catch(Exception ep){
        	System.out.println("Exception"+ep);
        }
		
		
		 
		
	
	
	
}
	
public static void main(String[] args) {
    	
    	  final Browser browser = new Browser();
    	  final BrowserSample bSampleObj = new BrowserSample();
    	  browser.addScriptContextListener(new ScriptContextAdapter() {
    		    @Override
    		    public void onScriptContextCreated(ScriptContextEvent event) {
    		        Browser browser = event.getBrowser();
    		        JSValue window = browser.executeJavaScriptAndReturnValue("window");
    		        window.asObject().setProperty("save", new JSFunctionCallback() {
    		            @Override
    		            public Object invoke(Object... args) {
    		            	// FirstName is supposed to be first parameter
    		                  Object title = args[0];
    		                  Object type = args[1];
    		                  System.out.println("title clicked: " + title.toString());
    		                  System.out.println("type clicked: " + type.toString());
    		                  if (type.toString().equals("Cafe")){
    		                 	    
    		                	  bSampleObj.initialize();
    		                	  bSampleObj.frame.setVisible(true);
    		                	  final JButton[] group_of_buttons = new JButton[bSampleObj.total_vending_item()];
    		      					int i;

    		      				for (i=0;i<bSampleObj.total_vending_item();i++){ 
    		      					final int  j=i;
    		      						    group_of_buttons[i] =new JButton();
    		      							group_of_buttons[i].setBackground(Color.black);
    		      							group_of_buttons[i].setVisible(true);
    		      							group_of_buttons[i].addActionListener(new ActionListener(){
    		      							public void actionPerformed(ActionEvent e) {
    		      						    String quantity = JOptionPane.showInputDialog(bSampleObj.frame,
    		      					                        "Enter Quantity of the item?", null);
    		      						    int quant=Integer.parseInt(quantity);
    		      						    String final_text= group_of_buttons[j].getText();
    		      						    bSampleObj.text_nameProduct=final_text.substring(15, 23);
    		      						    bSampleObj.text_Price=final_text.substring(54,58);
    		      						    bSampleObj.text3=new StringBuilder(bSampleObj.text_nameProduct+":"+"$"+bSampleObj.text_Price+"   Qty:"+quant+"\n");
    		      						    bSampleObj.text4.append(bSampleObj.text3);
    		      						    bSampleObj.left_text.setText(bSampleObj.text4.toString());
    		      						    bSampleObj. total_price=(bSampleObj.total_price)+Float.parseFloat(bSampleObj.text_Price)*quant;
    		      							 DecimalFormat df = new DecimalFormat("#.00");
    		      							bSampleObj.left_Lowpaneltext.setText("$"+String.valueOf(df.format(bSampleObj.total_price)));
    		      							 }}); 

    		      							bSampleObj.mainPanel.add(group_of_buttons[i]);
    		      							//bSampleObj.mainPanel.revalidate();
    		      							//bSampleObj.mainPanel.repaint();
    		      				}
    		      				bSampleObj.populate_buttons(group_of_buttons, bSampleObj.total_vending_item());
    		    				
    		                  }

    		                  return title;
    		               // return null;
    		            }
    		        });
    		    }
    		});
    	 

     JButton zoomInButton = new JButton("Zoom In");
        zoomInButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (zoomValue < MAX_ZOOM) {
                    browser.executeJavaScript("map.setZoom(" + ++zoomValue + ")");
                }
            }
        });
        JButton zoomOutButton = new JButton("Zoom Out");
        zoomOutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (zoomValue > MIN_ZOOM) {
                    browser.executeJavaScript("map.setZoom(" + --zoomValue + ")");
                }
            }
        });
        JPanel toolBar = new JPanel();
        toolBar.add(zoomInButton);
        toolBar.add(zoomOutButton);

        //Browser browser = new Browser();
        BrowserView browserView = new BrowserView(browser);
        JButton setCafeMachine = new JButton("FIND CAFES");
        JButton setVendingMachine = new JButton("FIND VENDING MACHINE");
        setCafeMachine.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                browser.executeJavaScript("var myLatlng = new google.maps.LatLng(37.349608, -121.939181);\n" +
                        "var marker = new google.maps.Marker({\n" +
                        "    position: myLatlng,\n" +
                        "    map: map,\n" +
                        "    type: 'Cafe',\n" +
                        "    title: 'Priya Half-Cooked Cafe'\n});\n" + 
                        "var myLatlng1 = new google.maps.LatLng(37.350518, -121.939326);\n" +
                        "var marker1 = new google.maps.Marker({\n" +
                        "    position: myLatlng1,\n" +
                        "    map: map,\n" +
                        "    type: 'Cafe',\n" +
                        "    title: 'Priya Half-Cooked Cafe1'\n});\n" +
                       
                        "marker.addListener('click', function() {\n"
                       // + "map.setZoom(8);\n"
                        + "save(marker.title,marker.type);\n"
                        + "});\n"
                       // + "save('Hello', 'World');});"
                        
                        );
            }
        });
        toolBar.add(setCafeMachine);
        toolBar.add(setVendingMachine);
        JFrame googleframe = new JFrame();
        googleframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        googleframe.add(toolBar, BorderLayout.NORTH);
        googleframe.add(browserView, BorderLayout.CENTER);
        googleframe.setSize(800, 600);
        googleframe.setLocationRelativeTo(null);
        googleframe.setVisible(true);
        googleframe.setBounds(100, 50, 1000, 760);
		googleframe.setMaximumSize(new Dimension(1000,760));
        
        //browser.loadURL("http://www.google.com");
       browser.loadURL("file:///Users/priyamaheshwari/Documents/java_programs/Google/src/map.html");
       		
    }
}
