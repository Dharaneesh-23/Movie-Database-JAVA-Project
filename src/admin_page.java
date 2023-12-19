import java.awt.*;
import java.awt.event.*;
import java.sql.DriverManager;
import javax.swing.*;

import com.mysql.jdbc.Statement;

class ImagePanel extends JComponent {
    private Image image;
    public ImagePanel(Image image) {
        this.image = image;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }
}

public class admin_page {
    JFrame admin_page_Frame=new JFrame("Admin page");
    private String u_name;
    
    void get_info(String s){
        try {
        
        ImageIcon bImageIcon=new ImageIcon("C:/Users/Dell/Desktop/project/Admin_login_bg_pg(1).jpg");
        Image bImage=bImageIcon.getImage();
        this.u_name="Welcome "+s.toUpperCase()+" !";
        admin_page_Frame.setContentPane(new ImagePanel(bImage));
        admin_page_Frame.setLocation(500,100);
        admin_page_Frame.setSize(800,600);
        admin_page_Frame.setLayout(null);

        JLabel ad_name=new JLabel(this.u_name);
        ad_name.setBounds(50, 100, 500, 30);
        ad_name.setFont(new Font(Font.SANS_SERIF,Font.ITALIC|Font.BOLD, 20));
        JLabel m_name=new JLabel("Movie Name");
        Font font=new Font(Font.SERIF,Font.BOLD,15);
        m_name.setBounds(  180, 170, 100, 20);
        m_name.setFont(font);
        JLabel Dir_name=new JLabel("Director Name");
        Dir_name.setBounds(180, 200, 100, 20);
        Dir_name.setFont(font);
        JLabel P_name=new JLabel("Producer");
        P_name.setBounds(180, 230, 100, 20);
        P_name.setFont(font);
        JLabel Cast=new JLabel("Cast");
        Cast.setBounds(180, 260, 100, 20);
        Cast.setFont(font);
        JLabel music_dir=new JLabel("Music Director");
        music_dir.setBounds(180, 290, 100, 20);

        JTextField m_nameField=new JTextField();
        m_nameField.setBounds(300, 170, 300, 20);
        JTextField dir_namField=new JTextField();
        dir_namField.setBounds(300, 200, 300, 20);
        JTextField p_namField=new JTextField();
        p_namField.setBounds(300, 230, 300, 20);
        JTextField castField=new JTextField();
        castField.setBounds(300, 260, 300, 20);
        JTextField music_namField=new JTextField();
        music_namField.setBounds(300, 290, 300, 20);

        ImageIcon btn_bg=new ImageIcon("C:/Users/Dell/Desktop/project/Admin_login_bg_btn(1).jpg");
        JButton input_Button=new JButton(btn_bg);
        input_Button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                if(m_nameField.getText().length()!=0 && dir_namField.getText().length()!=0 && p_namField.getText().length()!=0 && castField.getText().length()!=0 && music_namField.getText().length()!=0){
                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        java.sql.Connection m_con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db_movie?characterEncoding=latin1", "root", "password@123");
                        Statement smt=(Statement) m_con.createStatement();
                        smt.executeUpdate("insert into tbl_movie_det values('"+m_nameField.getText()+"','"+dir_namField.getText()+"','"
                        +p_namField.getText()+"','"+castField.getText()+"','"+music_namField.getText()+"')");
                        JOptionPane.showMessageDialog(admin_page_Frame, "Details added Successfully !!");
                        m_con.close();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(admin_page_Frame, e,"Couldn't add values into DB",JOptionPane.INFORMATION_MESSAGE);
                    }
                    admin_page_Frame.setVisible(false);
                }
                else{
                    JOptionPane.showMessageDialog(admin_page_Frame, "Some thing went wrong...try inserting again");
                    ad_name.setText("No empty fields are allowed !!");
                }
            }
        });
        input_Button.setBounds(340, 350, 100, 100);

        music_dir.setFont(font);
        admin_page_Frame.add(m_nameField);    
        admin_page_Frame.add(dir_namField);
        admin_page_Frame.add(p_namField);
        admin_page_Frame.add(castField);
        admin_page_Frame.add(music_namField);    
        admin_page_Frame.add(ad_name);
        admin_page_Frame.add(m_name);
        admin_page_Frame.add(Dir_name);
        admin_page_Frame.add(P_name);
        admin_page_Frame.add(Cast);
        admin_page_Frame.add(music_dir);
        admin_page_Frame.add(input_Button);
        admin_page_Frame.setVisible(true);

    } catch (Exception e) {
        // TODO: handle exception
        JOptionPane.showMessageDialog(admin_page_Frame, e,"Error",JOptionPane.ERROR_MESSAGE);
    }
        

        //m_name.setBounds(x, y, width, height);

    }
}
