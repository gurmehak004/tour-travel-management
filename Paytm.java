
package travel.management.system;
import  javax.swing.*;
import java.awt.event.*;


public class Paytm extends JFrame implements ActionListener {
    Paytm() {
        setBounds(500,200,800,600);
        
        JEditorPane pane=new JEditorPane(); //text area is editable 
        pane.setEditable(false);
        
        try {
            pane.setPage("https://paytm.com/rent-payement");
        } catch(Exception e) {
            pane.setContentType("text/html");
            pane.setText("<html>Could not load,Error 404 </html");
        }
        
        JScrollPane sp=new JScrollPane(pane);
        getContentPane().add(sp);
        
        JButton back=new JButton("Back");
        back.setBounds(610,20,80,40);
        back.addActionListener(this);
        pane.add(back);
        
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Payement();
    }
    public static void main(String[] args) {
        new Paytm();
    }
}
