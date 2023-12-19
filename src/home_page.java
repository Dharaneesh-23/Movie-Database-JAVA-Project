import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Image;
import java.sql.*;

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

public class home_page {
        String dir_name,movie_name,cast,music_dir_name,producer_name;
        JFrame hm_frm=new JFrame("MOVIE INFO PROVIDER");
        ImageIcon frame_Icon=new ImageIcon("C:/Users/Dell/Desktop/project/Frame__icon.jpg");
        ImageIcon hm_bImageIcon=new ImageIcon("C:/Users/Dell/Desktop/project/Main_page_bg.jpg");
        /*JPanel detail_panel(){
            Jpanel 
            return 
        }*/
        boolean login_check(String u,String p){
            try {
                Class.forName("com.mysql.jdbc.Driver");
                java.sql.Connection ad_con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db_admin?characterEncoding=latin1", "root", "password@123");
                Statement m_smt=ad_con.createStatement();
                ResultSet smt_r=m_smt.executeQuery("Select * from tbl_admin_info");
                while (smt_r.next()) {
                    if(smt_r.getString(2).equals(u)){
                        if(smt_r.getString(3).equals(p)){
                            return true;
                        }
                    }
                }
                return false;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(hm_frm,e);
                return false;
            }
        }
        public void admin_login(){
            
            JFrame frm1=new JFrame("Admin login page");
            
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
                  String temp_u=user_name.getText();
                  String temp_p=new String(pass.getPassword());
                  if(count<4){
                     if(login_check(temp_u, temp_p)){
                        admin_page obj1=new admin_page();
                        printJLabel.setText("Login sucessfull");
                        obj1.get_info(new String(user_name.getText()));
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
            JLabel tiJLabel=new JLabel();
            JLabel m_name=new JLabel();
            JLabel castel=new JLabel();
            JLabel produc=new JLabel();
            JLabel musicJ=new JLabel();
            m_name.setFont(le_nameFont);
            m_name.setBounds(290,270,300,30);
            castel.setFont(le_nameFont);
            castel.setBounds(290, 320, 1000, 30);
            //caste2.setFont(le_nameFont);
            //caste2.setBounds(290, 340, 1000, 30);
            produc.setFont(le_nameFont);
            produc.setBounds(290, 390, 800, 30);
            musicJ.setFont(le_nameFont);
            musicJ.setBounds(290, 440, 600, 30);
    
            tiJLabel.setFont(tiFont);
            //ti1JLabel.setFont(ri_nameFont);
            tiJLabel.setBounds(500, 160, 200, 30);
            //ti1JLabel.setBounds(500, 200, 200, 20);
            hm_frm.add(tiJLabel);
            hm_frm.add(pic_Label);
            //hm_frm.add(ti1JLabel);
            hm_frm.add(m_name);
            hm_frm.add(castel);
            //hm_frm.add(caste2);
            hm_frm.add(produc);
            hm_frm.add(musicJ);
    
            pic_Label.setVisible(false);
            tiJLabel.setVisible(false);
            //ti1JLabel.setVisible(false);
            m_name.setVisible(false);
            castel.setVisible(false);
            //caste2.setVisible(false);
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
                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        java.sql.Connection d_con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db_movie?characterEncoding=latin1", "root", "password@123");
                        Statement smt=d_con.createStatement();
                        ResultSet re=smt.executeQuery("select * from tbl_movie_det");
                        while (re.next()) {
                            if(re.getString(1).equals(hm_search_bar.getText())){
                                tiJLabel.setText(re.getString(1));
                                m_name.setText("Director: "+re.getString(2));
                                produc.setText("Producer: "+re.getString(3));
                                castel.setText("Cast    : "+re.getString(4));
                                musicJ.setText("Music   : "+re.getString(5));
                                tiJLabel.setVisible(true);
                                m_name.setVisible(true);
                                produc.setVisible(true);
                                castel.setVisible(true);
                                musicJ.setVisible(true);
                            }
                        }
                        if(!tiJLabel.isVisible()){
                            JOptionPane.showMessageDialog(hm_frm, "No results found","Error",JOptionPane.WARNING_MESSAGE);
                        }
                        d_con.close();
                    } catch (Exception e) {
                        // TODO: handle exception
                        JOptionPane.showMessageDialog(hm_search_bar, e);
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
                    //ti1JLabel.setVisible(false);
                    m_name.setVisible(false);
                    castel.setVisible(false);
                    //caste2.setVisible(false);
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
