
import java.sql.*;
import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*; 

public class project {
	static Connection connect=null;
	static String DatabaseName="database1";
	static String url = "jdbc:mysql://localhost:3306/" + DatabaseName;
	static String user="root";
	static String pass="Oindrila9654";
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		// TODO Auto-generated method stub
		    Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		connect=DriverManager.getConnection(url,user,pass);



		MyFrame frame= new MyFrame();
		}

		public void addNew(String s1,String s2) throws SQLException
		
		{ String sq2 = "select * from Tablenew where Username=?";
		PreparedStatement p0 = connect.prepareStatement(sq2);
		p0.setString(1,s1);
		final ResultSet result1 = p0.executeQuery();
		if (result1.next() == true)
		{
			JOptionPane.showMessageDialog(null, "Credentials already exist!");
			
			
		}
		else {
			
			
			String sql="Insert into Tablenew(Username,Password)" +"values(?,?)";
		PreparedStatement q1= connect.prepareStatement(sql);
		q1.setString(1,s1);
		q1.setString(2,s2);


		boolean Status=q1.execute();
//		System.out.println(Status);
		JOptionPane.showMessageDialog(null, "User signed up successfully!");

		}
		}

		public void check(String s1,String s2) throws SQLException{
		String sql="Select * from tablenew where Username =? and Password =?";
		PreparedStatement q1= connect.prepareStatement(sql);
		q1.setString(1,s1);
		q1.setString(2,s2);
		final ResultSet result = q1.executeQuery();
		if (result.next() == false) {
		    System.out.println("Incorrect credentials");
		JOptionPane.showMessageDialog(null, "Incorrect credentials!");
		return;
		}
		else
		{
		System.out.println("User logged in");
		JOptionPane.showMessageDialog(null, "User logged in successfully!");
		return;

		}
		}


		}




		class MyFrame extends JFrame implements ActionListener {

		private JLabel info;
		private Container c;

		public MyFrame()
		   {  c = getContentPane();
		      c.setLayout(null);
		      c.setSize(500,500);
		     
		     
		setTitle("Registration Form");
		       setBounds(500, 0, 500, 500);
		       setDefaultCloseOperation(EXIT_ON_CLOSE);
		       setResizable(true);
		       setSize(750,500);
		     
		     
		       ImageIcon ii = new ImageIcon("C:\\Users\\oindr\\Desktop\\DSI-Bangalore-Logo.png");
		       JLabel  lb = new JLabel(ii, JLabel.CENTER);
		       JLabel lb1 =new JLabel("<html>Dayandanda Sagar College Of Engineering <br>"+
		               "History:\r\n Established in 1979.\r\n Founded by Late Shri. R Dayananda Sagar.<br>"+
		               "It's run by the Mahatma Gandhi Vidyapeeth Trust.<br> Started with Civil, Mechanical, Electrical, "+
		               "and Electronics engineering</html>");
		       lb1.setBounds(200,250,200,200);
		       lb.setBounds(50,50,200,200);
		       c.add(lb);
		       c.add(lb1);
		       c.setBackground(Color.white);
		       
		     
		     
		       
		      JButton b1=new JButton("Sign up");  
		       b1.setBounds(500,300,95,30);
		       c.add(b1);
		       JButton b2=new JButton("Sign in");  
		       b2.setBounds(600,300,95,30);
		       c.add(b2);
		     
		     
		       b1.addActionListener(this);
		       b1.setActionCommand("up");
		     
		       b2.addActionListener(this);
		       b2.setActionCommand("in");
		     
		       setVisible(true);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String action = e.getActionCommand();
		       if (action.equals("up")) {
		       Signup supage= new Signup();
		       }
		     
		       if (action.equals("in")) {
		             Signin sipage= new Signin();
		       }
		    }
		}


		class Signup extends JFrame implements ActionListener {

		private JLabel info;
		private Container c;
		JTextField t1=new JTextField();
		JTextField t2=new JTextField();
		JButton button3 = new  JButton("Sign Up");
		JLabel l1 = new JLabel("Enter a new Username:");
		JLabel l2 = new JLabel("Enter a new Password:");
		

		public Signup()
		   {  c = getContentPane();
		      c.setLayout(null);
		      c.setBackground(Color.white);
		setTitle("Sign Up Page");
		       setBounds(200,200,200,200);
//		        setDefaultCloseOperation(EXIT_ON_CLOSE);
		       setResizable(true);
		       setSize(400,400);
		     
		       
		     
		       l1.setBounds(50,50,150,30);
		       c.add(l1);
		       
		       t1.setBounds(50,100,150,30);
		       c.add(t1);
		       
		       l2.setBounds(50,150,150,30);
		       c.add(l2);
		       
		       t2.setBounds(50,200,150,30);
		       c.add(t2);
		       
		       button3.setBounds(50,275,150,30);
		       c.add(button3);
		       
		       t1.addActionListener(this);
		       t1.setActionCommand("user");
		     
		       t2.addActionListener(this);
		       t2.setActionCommand("pass");
		       
		       button3.addActionListener(this);
		       button3.setActionCommand("signup");
		       setVisible(true);
		}

		@Override
		public void actionPerformed(ActionEvent e) {

		String s1="";
		String s2="";
		// TODO Auto-generated method stub
		String action = e.getActionCommand();

		s1 = t1.getText();
		s2 = t2.getText();




		       project p1=new project();
		      if(s1.equals("")||s2.equals(""))
		      {
		      JOptionPane.showMessageDialog(null, "Kindly enter the required credentials!");
		      return;
		      }
		     
		     
		     
		   try {
		p1.addNew(s1,s2);
		
		} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
		}
		     

		}
		}



		class Signin extends JFrame implements ActionListener {

		private JLabel info;
		private Container c;
		JTextField t1=new JTextField();
		JTextField t2=new JTextField();
		JButton button3 = new JButton("Login");
		JLabel l1 = new JLabel("Enter your Username:");
		JLabel l2 = new JLabel("Enter your  Password:");



		public Signin()
		   {  c = getContentPane();
		      c.setLayout(null);
		      c.setBackground(Color.white);
		setTitle("Sign In Page");
		       setBounds(200,200,200,200);
//		        setDefaultCloseOperation(EXIT_ON_CLOSE);
		       setResizable(true);
		       setSize(400,400);
		       
		       l1.setBounds(50,50,150,30);
		       c.add(l1);
		       
		       t1.setBounds(50,100,150,30);
		       c.add(t1);
		       
		       l2.setBounds(50,150,150,30);
		       c.add(l2);
		       
		       t2.setBounds(50,200,150,30);
		       c.add(t2);
		       
		       button3.setBounds(50,275,150,30);
		       c.add(button3);
		     
		       t1.addActionListener(this);
		       t1.setActionCommand("user");
		     
		       t2.addActionListener(this);
		       t2.setActionCommand("pass");
		       
		       button3.addActionListener(this);
		       button3.setActionCommand("signup");

		       setVisible(true);
		}


		@Override
		public void actionPerformed(ActionEvent e) {
		String s1="";
		String s2="";
		// TODO Auto-generated method stub
		String action = e.getActionCommand();
		  s1 = t1.getText();
		  s2 = t2.getText();


		if(s1.equals("")||s2.equals(""))
		{
		    JOptionPane.showMessageDialog(null, "Kindly enter the required credentials!");
		    return;
		}
		       project p2=new project();

		     
		   try {
		p2.check(s1,s2);
		} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
		}
		     
		     
		}
}

