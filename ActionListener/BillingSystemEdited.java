import javax.swing.*;//For GUI
import java.awt.*;//AWT
import java.awt.event.*;//Events
import java.io.*;//FileWriter
import java.util.*;//Generated Number
public class BillingSystemEdited {
	public static void main (String [] args) {//Driver Code
		LoginForm form1 = new LoginForm();
		new PaymentForm (null,null); 
		form1.genFrame();
	}
}
class LoginForm{
	Image icon;
	JFrame frame;
	JLabel label,label2;
	Button loginButton,cancelButton;
	TextField userName;
	TextField passWord;
	TextField Email;
	Label wrongPassword,LabelUserName,LabelPassword;
	JPanel panel;
	Color color1 = new Color(232,90,2);
	Color color2 = new Color(199,199,199);
	Color color3 = new Color(197,197,197);
	Font font = new Font ("Arial",Font.BOLD,20);
	Font font2 = new Font ("Arial",Font.BOLD,15);
	
		LoginForm(){//Frame to Login 
			icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("meralcoLogo.jpg"));
			frame = new JFrame("Login Form");
			loginButton = new Button("Login");
			cancelButton = new Button("Cancel");
			userName = new TextField();
			passWord = new TextField();
			Email = new TextField();
			wrongPassword = new Label ();
			LabelUserName = new Label ("UserName:");
			LabelPassword = new Label ("Password:");
			panel = new JPanel();
			label = new JLabel(new ImageIcon(getClass().getResource("headerLogo.jpg")));
		}
		public void genFrame() {
			frame.setSize(450,500);
			frame.setIconImage(icon);
			frame.getContentPane().setBackground(color1);
			label.setBounds(0,0,450,199);
			panel.add(label);
			panel.setBackground(color1);
			panel.setBounds(0,-20,450,199);
			frame.add(panel);
			LabelUserName.setBounds(50,230,120,20);
			LabelUserName.setFont(font);
			frame.add(LabelUserName);
			LabelPassword.setBounds(50,260,120,20);
			LabelPassword.setFont(font);
			frame.add(LabelPassword);
			

			userName.setBounds(170,230,200,22);
			userName.setFont(font2);
			userName.setBackground(color3);
			frame.add(userName);
			
			passWord.setBounds(170,260,200,22);
			passWord.setBackground(color3);
			passWord.setFont(font2);
			passWord.setEchoChar('*');
			frame.add(passWord);

			
			wrongPassword.setBounds(50,320,270,20);
			frame.add(wrongPassword);
			
			loginButton.setBounds(50,350,150,50);
			loginButton.setFont(font);
			loginButton.setBackground(color2);
			frame.add(loginButton);
			cancelButton.setBounds(250,350,150,50);
			cancelButton.setFont(font);
			cancelButton.setBackground(color2);
			frame.add(cancelButton);
			userName.addActionListener(new EnterEvent());
			passWord.addActionListener(new EnterEvent());
			loginButton.addActionListener(new LoginEvent());
			cancelButton.addActionListener(new CancelEvent());
			
			
			frame.setLocationRelativeTo(null);
			frame.setLayout(null);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		}
class LoginEvent implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				if ((userName.getText().equals("admin")) && (passWord.getText() .equals("admin"))) {
					frame.dispose();
					FillupForm form1 = new FillupForm();
					try {
						Thread.sleep(500);
						form1.NextForm();
					} catch (InterruptedException e) {
				}
			}
				else{
				wrongPassword.setText("Incorrect username and password, Try Again!");
					try {
						Thread.sleep(2000);
						wrongPassword.setText("");
						} catch (InterruptedException e) {
					}
				}
			}
		}
class EnterEvent implements ActionListener {
	public void actionPerformed(ActionEvent event) {
			if ((userName.getText().equalsIgnoreCase("admin")) && (passWord.getText() .equalsIgnoreCase("admin"))) {
				frame.dispose();
				FillupForm form1 = new FillupForm();
				try {
					Thread.sleep(500);
					form1.NextForm();
				} catch (InterruptedException e) {
			}
		}
			else{
			wrongPassword.setText("Incorrect username and password, Try Again!");
				try {
					Thread.sleep(2000);
					wrongPassword.setText("");
					} catch (InterruptedException e) {
				}
			}
	}
}
		class CancelEvent implements ActionListener{
			public void actionPerformed(ActionEvent event) {
				frame.dispose();
			}
		}		
}
class FillupForm {
	JFrame frame;
	TextField address,name;
	Image icon;
	Button next,clear,logout;
	Label fillUp;
	JLabel label,label2;
	Color color1 = new Color(232,90,2);
	Font font = new Font ("Arial",Font.BOLD,25);
	Font font1 = new Font ("Arial",Font.BOLD,15);
	Color color2 = new Color(199,199,199);
	Panel panel;
	public static String str1;
	FillupForm(){//Constructor
		icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("meralcoLogo.jpg"));
		label = new JLabel(new ImageIcon(getClass().getResource("fillUpHeaderIcon.png")));
		frame = new JFrame("Fill up");
		address = new TextField("Address");
		name = new TextField("Customer name");
		next = new Button("Next");
		clear = new Button ("Clear");
		logout = new Button("Logout");
		fillUp = new Label("Please Fill up this field below");
		panel = new Panel();
		label2 = new JLabel(new ImageIcon(getClass().getResource("meralcoLogo1.png")));
	}
	
	public void BodyForm (){
		frame.setIconImage(icon);
		frame.getContentPane().setBackground(color1);
		label.setBounds(0,330,450,140);
		label2.setBounds(-10,-10,100,97);
		frame.add(label2);
		panel.add(label);
		panel.setBackground(color1);
		panel.setBounds(0,330,450,140);
		frame.add(panel);
		frame.setSize(450,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(color1);
		fillUp.setBounds(50,100,350,25);
		fillUp.setFont(font);
		frame.add(fillUp);
		name.setBounds(25,150,400,30);
		name.setBackground(color2);
		name.setFont(font1);
		address.setBounds(25,200,400,30);
		address.setBackground(color2);
		address.setFont(font1);
		logout.setBounds(381,0,50,20);
		next.setBounds(50,240,50,20);
		clear.setBounds(350,240,50,20);
		frame.add(address);
		frame.add(name);
		frame.add(logout);
		frame.add(next);
		frame.add(clear);
		next.setEnabled(false);
		next.addActionListener(new next());
		clear.addActionListener(new clear());
		logout.addActionListener(new logout());
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		frame.setVisible(true);
	}
	public void NextForm() {
		FillupForm form = new FillupForm();
		form.BodyForm();
	}
	class next implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			frame.dispose();
			String var1 = name.getText();
			String var2 = address.getText();
			PaymentForm form = new PaymentForm(var1,var2);
			
			form.genFrame();
		}
	}
	
	class clear implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			name.setText(" ");
			address.setText(" ");
			next.setEnabled(true);
			clear.setEnabled(true);
				try {
					Thread.sleep(500);
					clear.setEnabled(true);
				}catch(Exception e) {
				}
		}
	}
	
	class logout implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			frame.dispose();
			LoginForm login = new LoginForm();
			login.genFrame();
		}
	}
	
}
class PaymentForm{//Frame to pay a payment
	
	double totalAmount = 0;
	double kwh;
	double amount;
	static double change;
	Random rand;
	int max = 150;
	int min = 20;
	JFrame frame;
	Image icon2;
	Label kwhtextField,totalElectric;
	Label kwHLabel,TotalAmount,AmountToPay,customerName,customerAddress;
	TextField total,amountPay;
	Button logout,calculate,clear,print,preview;
	JLabel icon;
	Color color1 = new Color(232,90,2);
	Color color2 = new Color(199,199,199);
	Color color3 = new Color(197,197,197);
	Label outKWH,outAmountKWH,Amount,Change,boarder,summary;
	Font font = new Font ("Arial",Font.BOLD,14);
	Font font1 = new Font ("Arial",Font.BOLD,18);
	Font font2 = new Font ("Arial",Font.BOLD,15);
	String str2;
	FillupForm forms;
		PaymentForm(String str1, String str2){
			icon2 = Toolkit.getDefaultToolkit().getImage(getClass().getResource("meralcoLogo.jpg"));
			frame = new JFrame("Process Form");
			frame.setIconImage(icon2);
			kwHLabel = new Label ("Kilo-Watt per Hour: ");
			TotalAmount = new Label ("Amount per KWH :");
			kwhtextField = new Label();
			totalElectric = new Label();
			logout = new Button("Logout");
			calculate = new Button("Calculate");
			clear = new Button("Clear");
			AmountToPay = new Label("Amount to pay:");
			amountPay = new TextField();
			total = new TextField();
			print = new Button("Print");
			preview = new Button("Preview");
			outKWH = new Label();
			outAmountKWH = new Label();
			Amount = new Label();
			Change = new Label();
			summary = new Label("Details of Receipt");
			customerName = new Label();
			customerAddress = new Label();
			forms = new FillupForm();
			boarder = new Label("---------------------------------------------------------------------------------------");
			icon = new JLabel(new ImageIcon(getClass().getResource("meralcoLogo11.png")));
			customerAddress.setText("Customer Address: "+str2);
			customerName.setText("Customer Name: "+str1);
			customerName.setVisible(false);
			customerAddress.setVisible(false);
		}
		public void genFrame() {
			frame.setSize(450,500);
			frame.getContentPane().setBackground(color1);
			
			//Bounds Coordinates
			icon.setBounds(0,0,52,50);
			kwhtextField.setBounds(250,50,200,20);
			kwHLabel.setBounds(25,50,200,20);
			TotalAmount.setBounds(25,75,200,20);
			AmountToPay.setBounds(25,100,200,20);
			totalElectric.setBounds(250,75,150,20);
			amountPay.setBounds(250,100,150,20);
			boarder.setBounds(0,200,450,20);
			calculate.setBounds(250,125,60,20);
			clear.setBounds(320,125,50,20);
			logout.setBounds(381,0,50,20);
			preview.setBounds(150,180,50,20);
			print.setBounds(250,180,50,20);
			outKWH.setBounds(0,330,400,20);
			kwHLabel.setFont(font);
			outAmountKWH.setBounds(0,360,400,20);
			Amount.setBounds(0,390,400,20);
			Change.setBounds(0,420,400,20);
			customerName.setBounds(0,270,400,20);
			customerAddress.setBounds(0,300,400,20);
			summary.setBounds(150,220,400,20);
			//Adding to frames
			frame.add(icon);
			frame.add(AmountToPay);
			frame.add(kwHLabel);
			frame.add(kwhtextField);
			frame.add(TotalAmount);
			frame.add(totalElectric);
			frame.add(amountPay);
			frame.add(boarder);
			frame.add(calculate);
			frame.add(clear);
			frame.add(logout);
			frame.add(preview);
			frame.add(print);
			frame.add(outKWH);
			frame.add(outAmountKWH);
			frame.add(Amount);
			frame.add(Change);
			frame.add(summary);
			frame.add(customerName);
			frame.add(customerAddress);
			//Font
			AmountToPay.setFont(font);
			TotalAmount.setFont(font);
			boarder.setFont(font);
			outKWH.setFont(font1);
			outAmountKWH.setFont(font1);
			amountPay.setFont(font2);
			Amount.setFont(font1);
			Change.setFont(font1);
			summary.setFont(font1);
			kwhtextField.setFont(font2);
			totalElectric.setFont(font2);
			customerName.setFont(font1);
			customerAddress.setFont(font1);
			//ButtonBackground
			amountPay.setBackground(color3);
			calculate.setBackground(color2);
			clear.setBackground(color2);
			logout.setBackground(color2);
			//ReadOnlyButton
			calculate.setEnabled(false);
			clear.setEnabled(false);
			preview.setEnabled(false);
			print.setEnabled(false);
			//Action Listener
			calculate.addActionListener(new ElectricAmount());
			logout.addActionListener(new logOut());
			clear.addActionListener(new clear());
			amountPay.addActionListener(new complete());
			preview.addActionListener(new preview());
			print.addActionListener(new print());
			//FinalLayout
			frame.setLocationRelativeTo(null);
			frame.setLayout(null);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		}
		public void PaymentForm1 () {
			PaymentForm form1 = new PaymentForm(null,null);
			form1.genFrame();
			
		}
		
class ElectricAmount implements ActionListener{
			public void actionPerformed(ActionEvent event) {
				rand = new Random();
				kwh = rand.nextInt(max-min)+min;
				kwhtextField.setText(""+kwh);
				totalAmount = kwh*8.47;
				totalElectric.setText(""+totalAmount);
				preview.setEnabled(true);
				try {
				amount = Double.parseDouble(amountPay.getText());
				print.setEnabled(true);
				}catch(NumberFormatException e) {
				totalElectric.setText("INVALID");
				kwhtextField.setText("INVALID");
				preview.setEnabled(false);
				print.setEnabled(false);
				}
				change = amount-totalAmount;
				calculate.setEnabled(false);
				amountPay.setEnabled(false);
			}
		}
class clear implements ActionListener{
			public void actionPerformed(ActionEvent event) {
				kwhtextField.setText("");
				totalElectric.setText("");
				amountPay.setText("");
				outKWH.setText("");
				outAmountKWH.setText("");
				Amount.setText("");
				Change.setText("");
				customerName.setVisible(false);
				customerAddress.setVisible(false);
				amountPay.setEnabled(true);
				calculate.setEnabled(false);
				clear.setEnabled(false);
				preview.setEnabled(false);
				print.setEnabled(false);
			}
		}
class complete implements ActionListener{
			
			public void actionPerformed(ActionEvent event) {
				calculate.setEnabled(true);
				amountPay.setEnabled(true);
				clear.setEnabled(true);
				print.setEnabled(false);
			}
		}
class preview implements ActionListener{
			public void actionPerformed(ActionEvent event) {
				outKWH.setText("Kilowatt per Hour: "+kwh+" kWh");
				outAmountKWH.setText("Amount in KWH: P"+totalAmount);
				Amount.setText("Amount Pay: P"+amount);
				Change.setText("Change Value: P"+change);
				customerName.setVisible(true);
				customerAddress.setVisible(true);
				print.setEnabled(true);
			}
		}
class print implements ActionListener{
			public void actionPerformed(ActionEvent event) {
				try {
					FileWriter file = new FileWriter("Receipt.txt");
					file.write("\t\tMeralco Receipt\r\n");
					file.write("----------------------------------------------\r\n");
					file.write("----------------------------------------------\r\n");
					file.write("\r\n");
					file.write(customerName.getText()+"\r\n");
					file.write("\r\n");
					file.write(customerAddress.getText()+"\r\n");
					file.write("\r\n");
					file.write("Kilowatt per Hour: "+kwh+" KwH"+"\r\n");
					file.write("\r\n");
					file.write("Amount in KWH: P"+totalAmount+"\r\n");
					file.write("\r\n");
					file.write("Amount Pay: P"+amount+"\r\n");
					file.write("\r\n");
					file.write("Change Value: P"+change+"\r\n");
					file.write("\r\n");
					file.write("----------------------------------------------\r\n");
					file.write("Thank you for using our services");
					file.close();
					Thread.sleep(1000);
					JOptionPane.showMessageDialog(null, "Print Complete");
					Runtime.getRuntime().exec("cmd /c start Receipt.txt");
				} catch (Exception e) {
			}
		}
	}
class logOut implements ActionListener{
			public void actionPerformed(ActionEvent event) {
				frame.dispose();
				LoginForm login = new LoginForm();
				login.genFrame();
			}
		}
}
