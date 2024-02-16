import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;



public class Generator extends JFrame implements ActionListener{

    JButton button;
    JButton button1;
    JTextField textField;
    JTextField passwordField;
    
    final String[] chars = 
    {"1","2","3","4","5","6","7","8","9","0",
    "q", "w", "e", "r", "t", "z", "u", "i", "o", "p", "ü", "a", "s", "d", "f", "g", "h", "j", "k", "l", "ö", "ä", "y", "x", "c", "v", "b", "n", "m",
    "Q", "W", "E", "R", "T", "Z", "U", "I", "O", "P", "Ü", "A", "S", "D", "F", "G", "H", "J", "K", "L", "Ö", "Ä", "Y", "X", "C", "V", "B", "N", "M",
    "^", "!", "\"", "§", "$", "%", "&", "/", "(", ")", "=", "?", "ß", "\\", "+", "*", "<", ">", "|", "'", "#", ",", ";", ":", "-", "_", "{", "}", "[", "]", "~"};

    
    List<String> list = new ArrayList<>();

    StringBuilder password = new StringBuilder();


    Random random = new Random();


    int i = 0;    


  


    Generator(){
        
        this.setTitle("Password");
        this.setResizable(false);       
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(4,1));
        button = new JButton("Generate");
        button.addActionListener(this);

        button1 = new JButton("Delete");
        button1.addActionListener(this);               

        textField = new JTextField();
        textField.setPreferredSize(new Dimension(250,40));
    

        passwordField = new JTextField();
        passwordField.setPreferredSize(new Dimension(250,40));
        passwordField.setText("...");
        passwordField.setEditable(false);
        
        
        this.add(textField);
        this.add(button);
        this.add(passwordField);
        this.add(button1);
        this.pack();
        this.setVisible(true);
   
     }

     @Override
     public void actionPerformed(ActionEvent e){
        if(e.getSource()==button){
        System.out.println("Länge "+ textField.getText());

        String input = textField.getText();
        int length = 0;
        try{
            length = Integer.parseInt(input);
        }catch(NumberFormatException ex){
            textField.setText("This is not a valid input");
        }
        


        while (i<=length){
        int index = random.nextInt(chars.length);
        System.out.println(chars[index]);
        list.add(chars[index]);      
        i++;
        }
        for (int i = 0; i<list.size();i++){
            password.append(list.get(i));
        }
        
        System.out.println(list);
        passwordField.setText(password.toString());  


        i = 0;
        list.clear();
        password.setLength(0);
        
    }

        if (e.getSource()==button1) {

        textField.setText("");
        passwordField.setText("");
            
        }

        }      
        
  

     }