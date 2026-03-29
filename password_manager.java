import javax.swing.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.awt.*;

public class password_manager {
    public static void main(String[] args) {
        System.out.println("Current dir: " + System.getProperty("user.dir")); // to check where the txt file is being created
        int[] y = {80};
        int[] click = {0, 0,};
        JFrame frame = new JFrame("Password Manager");
        frame.setSize(510, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

    
        JLabel text = new JLabel("bro needs one of his passwords again");
        text.setBounds(0, 70, frame.getWidth(),25);
        text.setFont(new Font("Ariel", Font.PLAIN, 20));
        text.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(text);

        JLabel textt = new JLabel("just enter ur password so ik its u");
        textt.setBounds(0, 120, frame.getWidth(),25);
        textt.setFont(new Font("Ariel", Font.PLAIN, 20));
        textt.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(textt);


        JPasswordField password = new JPasswordField();
        password.setBounds(125, 150, 250, 35);
        password.setFont(new Font("Ariel", Font.PLAIN, 25));
        password.setEchoChar('•');
        frame.add(password);


        JCheckBox show = new JCheckBox("o");
        show.setBounds(400, 149, 50, 35);
        frame.add(show);

        show.addActionListener(e -> {
            if (show.isSelected()) {
                password.setEchoChar((char)0);
                text.setText("bro gotta check what he's typing");
                textt.setText("");
            } else {
                password.setEchoChar('•');
                text.setText("damn.");
            }
        }); 
 
           JFrame pass = new JFrame("Passwords");
            pass.setSize(500, 500);
            pass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            pass.setLocationRelativeTo(null);
            pass.setLayout(null);




            JLabel add = new JLabel("ofc its u..");
            add.setBounds(0, 10, pass.getWidth(), 25);
            add.setHorizontalAlignment(SwingConstants.CENTER);
        
            add.setFont(new Font ("Ariel", Font.PLAIN, 20));


            JLabel addd = new JLabel("heres all ur shit");
            addd.setBounds(0, 40, pass.getWidth(), 25);
            addd.setHorizontalAlignment(SwingConstants.CENTER);
            addd.setFont(new Font ("Ariel", Font.PLAIN, 20));

            JButton addB = new JButton("add a new one");
            addB.setBounds(175,400,150, 35);
            addB.setFont(new Font("Ariel", Font.PLAIN, 15));

            pass.add(add);
            pass.add(addd);
            


            addB.addActionListener(e -> {
                JFrame addnewpass = new JFrame();
                addnewpass.setSize(400, 200);
                addnewpass.setLocationRelativeTo(null);
                addnewpass.setLayout(null);
                addnewpass.setVisible(true);

                JTextField newpass = new JTextField("The password....");
                newpass.setBounds(50,75,300,30);
                newpass.setFont(new Font("Ariel", Font.PLAIN, 15));
                JTextField newpassname = new JTextField("What is it for?....");
                newpassname.setBounds(50,35,300,30);
                newpassname.setFont(new Font("Ariel", Font.PLAIN, 15));
                JButton addF = new JButton("Add");
                addF.setBounds(125, 120, 150, 30);
                addnewpass.add(newpass);
                addnewpass.add(newpassname);
                addnewpass.add(addF);


                    newpass.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent eve) {
                             if (click[0] == 0) {
                                newpass.setText("");
                        } 
                            click[0] = click[0] + 1;
                }
                    });
                        click[0] = 0;


                    newpassname.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent even) {
                           if (click[1] == 0) {
                                newpassname.setText("");
                           }
                           click[1] = click[1] + 1;
                        }
                    });
                             click[1] = 0;

                    addF.addActionListener(ev -> {
                            addnewpass.dispose();
                            String name = newpassname.getText();
                            String passF = newpass.getText();

                           
                            JLabel addedname = new JLabel(name);
                            addedname.setBounds(50, y[0], 150, 30);
                            addedname.setFont(new Font("Ariel", Font.PLAIN, 15));
                            JTextField added = new JTextField(passF);
                            added.setBounds(250, y[0], 200, 30);
                            added.setFont(new Font("Ariel", Font.PLAIN, 15));
                            pass.add(addedname);
                            pass.add(added);
                            y[0] += 40;

                            
                            
                            try (FileWriter fw = new FileWriter("passwords.txt", true)) {
                                fw.write(name + ":" + passF + "\n");
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }

                            pass.revalidate();
                            pass.repaint();
                        }); });
            pass.add(addB);
    
                            try (BufferedReader br = new BufferedReader(new FileReader("passwords.txt"))) {
                        String line;
                        while ((line = br.readLine()) != null) {
                            String[] parts = line.split(":");
                            if (parts.length < 2) continue;
                            String name = parts[0];
                            String passF = parts[1];

                            JLabel addedname = new JLabel(name);
                            addedname.setBounds(50, y[0], 150, 30);
                            addedname.setFont(new Font("Ariel", Font.PLAIN, 15));
                            JTextField added = new JTextField(passF);
                            added.setBounds(250, y[0], 200, 30);
                            added.setFont(new Font("Ariel", Font.PLAIN, 15));
                            pass.add(addedname);
                            pass.add(added);
                            y[0] += 40;
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    pass.revalidate();
                    pass.repaint();


        String THEpass = "k";
        int wrong[] = {0};
       


        JButton check = new JButton("Check");
        check.setBounds(195, 198, 110, 35);
        check.setFont(new Font("Ariel", Font.PLAIN, 20));
        frame.add(check);
        frame.setVisible(true);
        check.addActionListener(e -> {
            if (String.valueOf(password.getPassword()).equals(THEpass)) {
            pass.setVisible(true);
            frame.dispose();
            } else {
                wrong[0] = wrong[0] + 1;
                if (wrong[0] == 1) {
                text.setText("damn");
                textt.setText("");
            } else if (wrong[0] == 2) {
                text.setText("bro ??");
                textt.setText(""); }
                else if (wrong[0] == 3) {
                text.setText("???");
                textt.setText("");
            } else if (wrong[0] > 3) {
                text.setText("WHO ARE YOU???");
                textt.setText("");
        }
            }
            
        });
    }
}
