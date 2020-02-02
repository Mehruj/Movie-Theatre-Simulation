package mehruj;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.lang.Math;

public class MyGame {

	public static boolean isLetter(String str) {
		for (int i = 0; i < str.length(); i++) {
			if (!((str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') || (str.charAt(i) >= 'a' && str.charAt(i) <= 'z')
					|| str.charAt(i) == ' '))
				return false;
		}
		return true;
	}
	
	public static boolean isNumber(String n) {
		char[] c = n.toCharArray();
		for(int i=0; i<c.length; i++) {
			if(!(c[i]>= '0' && c[i]<= '9'))
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		int node = 1;
		int yAddress=0;
		int xAddress= 0;
		while (true) {
			if (node == -1) {
				System.exit(0);
			}
			if (node == 1) {
				String name = "Hello User! Welcome.";
				JOptionPane.showMessageDialog(null, name, "Greetings", JOptionPane.PLAIN_MESSAGE);
				node = 2;
			}
			if (node == 2) {
				String title = "Introduction";
				String message = "Please Enter Your Name So That I Can Call You Something, You Dumbo.";
				ImageIcon icon = new ImageIcon("src/mehruj/assets/saikihappy.jpg");
				JOptionPane.showMessageDialog(null, message, title, JOptionPane.PLAIN_MESSAGE, icon);
				node = 3;
			}
			if (node == 3) {
				String askName;
				askName = JOptionPane.showInputDialog("Now, what should I call you?");

				while (true) {
					if (!isLetter(askName)) {
						JOptionPane.showMessageDialog(null, "Please Enter Valid Name, You slow piece of shite.",
								"UGGH what are you doing", JOptionPane.PLAIN_MESSAGE);
						break;
					} else if (isLetter(askName)) {
						JOptionPane.showMessageDialog(null, "Hi " + askName + " Nice To Meet You!");
					}
					node = 4;
					break;
				}
			}
			if (node == 4) {

				String input;
				input= (JOptionPane.showInputDialog("Please enter your x position: "));
				while(true) {
					if(!isNumber(input)) {
						ImageIcon michael = new ImageIcon("src/michael saying no.jpg");
						JOptionPane.showMessageDialog(null, "Please Enter a Valid input!!",
								"Uh Oh", JOptionPane.PLAIN_MESSAGE,michael );
						break;
					}
					else if(isNumber(input)) {
						xAddress= Integer.parseInt(input);
					}
						node=5;
						break;
					
				}
			}
		
		if(node==5) {
			String input;
			input =( JOptionPane.showInputDialog("Please enter your y position: "));
			while(true) {
				if(!isNumber(input)) {
					ImageIcon michael = new ImageIcon("src/michael saying no.jpg");
					JOptionPane.showMessageDialog(null, "Please Enter Valid input!!",
							"Uh Oh", JOptionPane.PLAIN_MESSAGE, michael);
					break;
				}
				else if (isNumber(input)) {
					yAddress= Integer.parseInt(input);
				}
					node=6;	
					break;
				
			}

		}
		if (node==6) {
			String[] theaters= {"AMC" ,"Village East Cinema","Regal Union Square"};
			int[][]location= {{3,6}, {12,8},{20,5}};
			
            int mindistance=0;
            String particularTheater;
            
			for(int i=0 ; i<location.length; i++) {
				for(int j=0; j< location.length; j++) {
					int x= location[i][0];
					int y= location[i][1];
					//if(isNumber(xAddress) && isNumber(yAddress)) {
					int distance= (int) Math.sqrt( Math.pow((x-xAddress), 2)+ (Math.pow((y-yAddress), 2)));
					if(mindistance> distance) {
						mindistance= distance;
						particularTheater= theaters[x];
						ImageIcon laughing = new ImageIcon("src/michael laughing.jpg");
						JOptionPane.showMessageDialog(null, "Your nearest movie theater seems to be"+ particularTheater,
								"Found Something For You!!", JOptionPane.PLAIN_MESSAGE, laughing);
						
					}
				}
             }
		}
	}
 }
}
	

