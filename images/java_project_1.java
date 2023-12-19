import java.awt.*;
import java.awt.event.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.*;
import java.util.*;
import javax.swing.border.Border;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
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
class ImagePanel1 extends JPanel {

    private Image img;
  
    public ImagePanel1(String img) {
      this(new ImageIcon(img).getImage());
    }
  
    public ImagePanel1(Image img) {
      this.img = img;
      Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
      setPreferredSize(size);
      setMinimumSize(size);
      setMaximumSize(size);
      setSize(size);
      setLayout(null);
    }
  
    public void paintComponent(Graphics g) {
      g.drawImage(img, 0, 0, null);
    }
  
  }
/*              admin_page      */      
class admin_page{
    String u_name;
    final
    JFrame admin_page_Frame=new JFrame("Admin page");
    admin_page(String s){
        ImageIcon bImageIcon=new ImageIcon("C:/Users/Dell/Desktop/project/Admin_login_bg_pg(1).jpg");
        Image bImage=bImageIcon.getImage();
        this.u_name="Welcome "+s.toUpperCase()+" !";
        admin_page_Frame.setContentPane(new ImagePanel(bImage));
        admin_page_Frame.setLocation(500,100);
        admin_page_Frame.setSize(800,600);
        admin_page_Frame.setLayout(null);
    }
    private static class RoundedBorder implements Border {
        private int radius;
        RoundedBorder(int radius) {
            this.radius = radius;
        }
        public Insets getBorderInsets(Component c) {
            return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
        }
        public boolean isBorderOpaque() {
            return false;
        }
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.drawRoundRect(x, y, width-1, height-1, radius, radius);
        }
    }
    
    public void get_info(){
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
                    JOptionPane.showMessageDialog(admin_page_Frame, "Details added Successfully !!");
                    admin_page_Frame.setVisible(false);
                }
                else{
                    JOptionPane.showMessageDialog(admin_page_Frame, "Some thing went wrong...try inserting again");
                    ad_name.setText("No empty fields are allowed !!");
                }
            }
        });
        input_Button.setBounds(340, 350, 100, 100);
        input_Button.setBorder(new RoundedBorder(100));

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


        //m_name.setBounds(x, y, width, height);

    }
}


/*      home page        */
class home_page extends admin_page{
    home_page(String s){
        super(s);
    }
    String dir_name,movie_name,cast,music_dir_name,producer_name;
    JFrame hm_frm=new JFrame("MOVIE INFO PROVIDER");
    ImageIcon frame_Icon=new ImageIcon("C:/Users/Dell/Desktop/project/Frame__icon.jpg");
    ImageIcon hm_bImageIcon=new ImageIcon("C:/Users/Dell/Desktop/project/Main_page_bg.jpg");
    /*JPanel detail_panel(){
        Jpanel 
        return 
    }*/
    public void admin_login(){
        
        JFrame frm1=new JFrame("Admin login page");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection ad_con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db_admin?characterEncoding=latin1", "root", "password@123");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frm1,e);

        }
        frm1.setIconImage(frame_Icon.getImage());
        ImageIcon bImageIcon=new ImageIcon("C:/Users/Dell/Desktop/project/Admin_login_bg_pg(1).jpg");
        Image bImage=bImageIcon.getImage();
        frm1.setContentPane(new ImagePanel(bImage));
        JLabel usJLabel=new JLabel("Username: ");
        JLabel passJLabel=new JLabel("Password: ");
        JButton loginButton=new JButton("Login");
        usJLabel.setBounds(200,150,80,30);
        passJLabel.setBounds(200,170,80,30);
        frm1.add(usJLabel);frm1.add(passJLabel);
        JTextField user_name=new JTextField("Username");
        user_name.addMouseListener(new MouseAdapter(){
           @Override
           public void mouseClicked(MouseEvent e){
              user_name.setText("");
           }
        });
        user_name.setToolTipText("Enter the Username");  
        JPasswordField pass=new JPasswordField();
        pass.setBackground(Color.GRAY);
        pass.setToolTipText("Enter the password");
        user_name.setBounds(280,155, 150,20);
        pass.setBounds(280, 175, 150 , 20);
        loginButton.setBounds(240,200,100,30);
        JLabel printJLabel=new JLabel();
        frm1.add(printJLabel);
        ActionListener AL_login_btn=new ActionListener(){
           int count;
           public void actionPerformed(ActionEvent login_ae){
              String temp_p=new String(pass.getPassword());
              if(count<4){
                 if(temp_p.equals("1234")){
                    admin_page obj1=new admin_page(new String(user_name.getText()));
                    printJLabel.setText("Login sucessfull");
                    obj1.get_info();
                    frm1.setVisible(false);
                    count=0;
                 }
                 else{
                    printJLabel.setText("Login failed");
                    count++;
                 }
              }
              else{loginButton.setEnabled(false);
              printJLabel.setText("Too many invalid attempts try after 10 mins");
            }
              printJLabel.setBounds(100,80,400,30);
           }
        };
        loginButton.addActionListener(AL_login_btn);
        frm1.add(loginButton);
        frm1.add(user_name);
        frm1.add(pass);
        frm1.setLayout(null);
        frm1.setBounds(0,0, 600, 450);
        frm1.setVisible(true);
        frm1.setLocation(500, 100);
    }
    JPanel searchJPanel(){
        JPanel dirJPanel=new JPanel();
        JScrollBar s=new JScrollBar();
        s.setBounds(180,0,20,200);
        dirJPanel.setBounds(200, 121, 200, 200);
        dirJPanel.add(s);
        dirJPanel.setLayout(null);
        dirJPanel.setVisible(false);
        return dirJPanel;
    }
    void hm_page(){
        hm_frm.setContentPane(new ImagePanel(hm_bImageIcon.getImage()));
        Font tiFont=new Font(Font.SANS_SERIF,Font.ITALIC|Font.BOLD,40);
        Font le_nameFont=new Font(Font.DIALOG,Font.BOLD,20);
        Font ri_nameFont=new Font(Font.MONOSPACED,Font.BOLD|Font.ITALIC,10);
        ImageIcon pic=new ImageIcon("C:/Users/Dell/Desktop/project/Baahubali.jpg");
        JLabel pic_Label=new JLabel(pic);
        pic_Label.setBounds(200, 80, 400, 198);
        JLabel tiJLabel=new JLabel("Baahubali");
        JLabel ti1JLabel=new JLabel("2015  Action/War 2hr 38min");
        JLabel m_name=new JLabel("Director          :Raajamouli");
        JLabel castel=new JLabel("Cast               :Prabhas,Rana Daggubati,Anushka Shetty,");
        JLabel caste2=new JLabel("                     Tamannaah,Ramya Krishna,Sathyaraj,Nassar");
        JLabel produc=new JLabel("Producer         :Shobu Yarlagadda,Prasad Devineni");
        JLabel musicJ=new JLabel("Music Director  :M. M. Keeravani");
        m_name.setFont(le_nameFont);
        m_name.setBounds(290,270,300,30);
        castel.setFont(le_nameFont);
        castel.setBounds(290, 320, 1000, 30);
        caste2.setFont(le_nameFont);
        caste2.setBounds(290, 340, 1000, 30);
        produc.setFont(le_nameFont);
        produc.setBounds(290, 390, 800, 30);
        musicJ.setFont(le_nameFont);
        musicJ.setBounds(290, 440, 600, 30);

        tiJLabel.setFont(tiFont);
        ti1JLabel.setFont(ri_nameFont);
        tiJLabel.setBounds(500, 160, 200, 30);
        ti1JLabel.setBounds(500, 200, 200, 20);
        hm_frm.add(tiJLabel);
        hm_frm.add(pic_Label);
        hm_frm.add(ti1JLabel);
        hm_frm.add(m_name);
        hm_frm.add(castel);
        hm_frm.add(caste2);
        hm_frm.add(produc);
        hm_frm.add(musicJ);

        pic_Label.setVisible(false);
        tiJLabel.setVisible(false);
        ti1JLabel.setVisible(false);
        m_name.setVisible(false);
        castel.setVisible(false);
        caste2.setVisible(false);
        produc.setVisible(false);
        musicJ.setVisible(false);

        JPanel tJPanel=new JPanel();
        tJPanel.setLayout(null);
        tJPanel.setBounds(200, 0, 900, 35);
        JButton hm_admin_login=new JButton("Admin Login");
        hm_admin_login.setBackground(Color.green);
        hm_admin_login.setBounds(540,2,150,30);
        hm_admin_login.addActionListener(new ActionListener(){
              public void actionPerformed(ActionEvent hm_login){
                 admin_login();
              }
        });
        hm_admin_login.setToolTipText("Press here to login as adminstrator");
        JTextField hm_search_bar=new JTextField("Search here");
        hm_search_bar.setBounds(0, 0, 420, 35);
        hm_search_bar.addMouseListener(new MouseAdapter(){
           @Override
           public void mouseClicked(MouseEvent e){
              hm_search_bar.setText("");
           }
        });
        ImageIcon searchIcon=new ImageIcon("C:/Users/Dell/Desktop/project/search_btn.jpeg");
        JButton search_btn=new JButton(searchIcon);
        search_btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                if(hm_search_bar.getText().toLowerCase().equals("baahubali")){
                    try {
                        pic_Label.setVisible(true);
                        tiJLabel.setVisible(true);
                        ti1JLabel.setVisible(true);
                        m_name.setVisible(true);
                        castel.setVisible(true);
                        caste2.setVisible(true);
                        produc.setVisible(true);
                        musicJ.setVisible(true);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(hm_frm, "No results found");
                    }
                    
                }
                else{
                    JOptionPane.showMessageDialog(hm_frm, "No results found");
                }
            }
        });
        search_btn.setBounds(420 , 2, 115, 30);
        tJPanel.add(hm_admin_login);
        tJPanel.add(hm_search_bar);
        tJPanel.add(search_btn);
        //------------------------->>>>>>>>>>>>>>>             Left panel
        JPanel LJPanel=new JPanel();
        LJPanel.setLayout(null);
        LJPanel.setBounds(0, 0, 200, 665);
        JLabel search_byJLabel=new JLabel("Search by Category ");
        search_byJLabel.setBounds(0, 100, 199, 20);
        ImageIcon logo=new ImageIcon("C:/Users/Dell/Desktop/project/Frame__icon.jpg");
        JLabel icon=new JLabel(logo);
        icon.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent me){
                pic_Label.setVisible(false);
                tiJLabel.setVisible(false);
                ti1JLabel.setVisible(false);
                m_name.setVisible(false);
                castel.setVisible(false);
                caste2.setVisible(false);
                produc.setVisible(false);
                musicJ.setVisible(false);
            }
        });
        icon.setBounds(0,0,200,100);
        JButton dirButton=new JButton("Directors");
        
        JPanel dirJPanel=searchJPanel();
        dirJPanel.setLayout(null);
        JButton dirL_1=new JButton("Rajamoil");
        dirL_1.setBounds(0, 0, 180, 50);
        JButton dirl_2=new JButton("Shankar");
        dirl_2.setBounds(0,51,180,50);
        JButton dirL_3=new JButton("Pradeep");
        dirL_3.setBounds(0, 101, 180, 50);
        JButton dirL_4=new JButton("Mani Rathman");
        dirL_4.setBounds(0, 151, 180, 50);
        JButton dirL_5=new JButton("Hari");
        dirL_5.setBounds(0, 201, 180, 50);
        dirJPanel.add(dirL_1);    
        dirJPanel.add(dirl_2);
        dirJPanel.add(dirL_3);
        dirJPanel.add(dirL_4);
        dirJPanel.add(dirL_5);

        dirButton.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent ae){
              if(!dirJPanel.isVisible()){dirJPanel.setVisible(true);}
              else if(dirJPanel.isVisible()){dirJPanel.setVisible(false);}
           }
        });
        JButton actorButton=new JButton("Actor");
        JPanel actorJPanel=searchJPanel();
        JPanel productionJpanel=searchJPanel();
        actorButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
               if(!actorJPanel.isVisible()){actorJPanel.setVisible(true);}
               else if(actorJPanel.isVisible()){actorJPanel.setVisible(false);}
            }
         });
        JButton productiButton=new JButton("Production house");
        productiButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
               if(!actorJPanel.isVisible()){actorJPanel.setVisible(true);}
               else if(actorJPanel.isVisible()){actorJPanel.setVisible(false);}
            }
        });
        JButton musicdir_Button=new JButton("Music director");
        JPanel music_dirJPanel=searchJPanel();
        musicdir_Button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                if(!music_dirJPanel.isVisible()){music_dirJPanel.setVisible(true);}
               else if(music_dirJPanel.isVisible()){music_dirJPanel.setVisible(false);}
            }
        });

        dirButton.setBounds(0, 121, 199, 25);
        actorButton.setBounds(0, 147, 199, 25);
        productiButton.setBounds(0, 173, 199, 25);
        musicdir_Button.setBounds(0, 200, 199, 24);
        hm_frm.add(dirJPanel);
        hm_frm.add(actorJPanel);
        hm_frm.add(productionJpanel);
        LJPanel.add(musicdir_Button);
        hm_frm.add(music_dirJPanel);
        LJPanel.add(icon);
        LJPanel.add(search_byJLabel);
        LJPanel.add(dirButton);      
        LJPanel.add(actorButton);   
        LJPanel.add(productiButton);

        //------------------------->>>>>>>>>>>>>>>          credits

        JButton cre_btn=new JButton("Creditor 1");
        JButton cre_btn1=new JButton("Creditor 2");
        cre_btn.setBounds(0, 380, 199, 30);
        cre_btn1.setBounds(0, 430, 199, 30);
        LJPanel.add(cre_btn);
        LJPanel.add(cre_btn1);

        Font f1=new Font(Font.MONOSPACED,Font.BOLD|Font.ITALIC,18);
        JLabel cre_name1=new JLabel("Dharaneesh R P");
        JLabel cre_num1=new JLabel("71762134014");
        JLabel cre_name2=new JLabel("Raghul Ajith N");
        JLabel cre_num2=new JLabel("71762134040");

        cre_btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                if(!cre_name1.isVisible()){cre_name1.setVisible(true);}
               else if(cre_name1.isVisible()){cre_name1.setVisible(false);}
               if(!cre_num1.isVisible()){cre_num1.setVisible(true);}
               else if(cre_num1.isVisible()){cre_num1.setVisible(false);}  
            }
        });
        cre_btn1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                if(!cre_name2.isVisible()){cre_name2.setVisible(true);}
               else if(cre_name2.isVisible()){cre_name2.setVisible(false);}
               if(!cre_num2.isVisible()){cre_num2.setVisible(true);}
               else if(cre_num2.isVisible()){cre_num2.setVisible(false);}  
            }
        });
        cre_name1.setFont(f1);
        cre_name2.setFont(f1);
        cre_num1.setFont(f1);
        cre_num2.setFont(f1);
        cre_name1.setBounds(10, 500, 200, 20);
        cre_name2.setBounds(10, 500, 200, 20);
        cre_num1.setBounds(10, 530, 200, 20);
        cre_num2.setBounds(10, 530, 200, 20);
        cre_name1.setVisible(false);
        cre_name2.setVisible(false);
        cre_num1.setVisible(false);
        cre_num2.setVisible(false);

        LJPanel.add(cre_name1);
        LJPanel.add(cre_num1);
        LJPanel.add(cre_name2);
        LJPanel.add(cre_num2);
        
        ImagePanel1 hm_frm_gb=new ImagePanel1(frame_Icon.getImage());
        hm_frm.getContentPane().add(hm_frm_gb);

      //      Function hm_page
      hm_frm.add(m_name);
      hm_frm.setIconImage(frame_Icon.getImage());
      hm_frm.getContentPane().setBackground(Color.BLACK);
      hm_frm.setBounds(0,0,910,700);
      hm_frm.setLayout(null);
      hm_frm.add(tJPanel);
      hm_frm.add(LJPanel);
      hm_frm.setVisible(true);
        //JButton
    }
}



/*          main class               */ 
public class java_project_1 {
    public static void main(String[] args) {
        home_page objHome_page=new home_page("");
        objHome_page.hm_page();
    }
}
