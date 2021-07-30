import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;

public class Home extends javax.swing.JFrame implements ActionListener{
    JPanel p1,p2,p3;
    ButtonGroup bg1,bg2;
    JRadioButton acButton,nonacButton,singleButton,doubleButton;
    JTextField roomprice1;
    JLabel roomnoLabel,roomtypeLabel,bedtypeLabel,roompriceLabel,roomnoLabel1;
    JButton addb1,editb2,deleteb3,cancelb4,refreshb5;
    Font f;
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    public Home() {
        initComponents();
        setSize(1000,700);
        addPanel();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Hotel_Management","root","qaz");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Exception : "+e);
        }
    }
    
    void addPanel(){
        p1=new JPanel();
        p2=new JPanel();
        p3=new JPanel();
        p1.setLayout(null);
        p3.setLayout(null);
        p2.setLayout(null);
        p1.setBounds(25,75,930,550);
        p2.setBounds(25,75,930,550);
        p3.setBounds(25,75,930,550);
        p1.setBackground(Color.LIGHT_GRAY);
        p2.setBackground(Color.red);
        p3.setBackground(Color.green);
        add(p1);add(p2);add(p3); 
        
        roomPanel();
    }
    void roomPanel(){
        // Design of room panel
        
        roomnoLabel=new JLabel("Room No");
        roomnoLabel.setBounds(50,150,90,40);
        roomnoLabel.setFont(new Font("Constantia",Font.BOLD,14));
        bedtypeLabel=new JLabel("Bed Type");
        bedtypeLabel.setBounds(50,200,90,40);
        bedtypeLabel.setFont(new Font("Constantia",Font.BOLD,14));
        roomtypeLabel=new JLabel("Room Type");
        roomtypeLabel.setBounds(50,250,90,40);
        roomtypeLabel.setFont(new Font("Constantia",Font.BOLD,14));
        roompriceLabel=new JLabel("Room Price");
        roompriceLabel.setBounds(50,300,90,40);
        roompriceLabel.setFont(new Font("Constantia",Font.BOLD,14));
        
        roomnoLabel1=new JLabel("1");
        roomnoLabel1.setBounds(160,150,90,30);
        roomnoLabel1.setFont(new Font("Constantia",Font.BOLD,14));
        
        singleButton=new JRadioButton("Single");
        singleButton.setBounds(160,200,90,30);
        singleButton.setFont(new Font("Constantia",Font.BOLD,14));
        doubleButton=new JRadioButton("Double");
        doubleButton.setBounds(260,200,90,30);
        doubleButton.setFont(new Font("Constantia",Font.BOLD,14));
        bg1=new ButtonGroup();
        bg1.add(singleButton);
        bg1.add(doubleButton);
        acButton=new JRadioButton("AC");
        acButton.setBounds(160,250,90,30);
        acButton.setFont(new Font("Constantia",Font.BOLD,14));
        nonacButton=new JRadioButton("Non AC");
        nonacButton.setBounds(260,250,90,30);
        nonacButton.setFont(new Font("Constantia",Font.BOLD,14));
        bg2=new ButtonGroup();
        bg2.add(acButton);
        bg2.add(nonacButton);
        
        //key listener for input numeric value
        roomprice1=new JTextField();
        roomprice1.setBounds(160,300,90,30);
        roomprice1.setFont(new Font("Constantia",Font.BOLD,14));
        roomprice1.setToolTipText("Enter Price");
        roomprice1.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent ke){
                if(ke.getKeyChar()>='0' && ke.getKeyChar()<='9')
                    roomprice1.setEditable(true);
                else if(ke.getKeyCode()==KeyEvent.VK_BACK_SPACE)
                    roomprice1.setEditable(true);
                else 
                    roomprice1.setEditable(false);
            }
        });
        
        //control Buttons 
        addb1=new JButton("Add");
        addb1.setBounds(60,400,80,30);
        addb1.setFont(new Font("Constantia",Font.BOLD,14));
        editb2=new JButton("Edit");
        editb2.setBounds(160,400,80,30);
        editb2.setFont(new Font("Constantia",Font.BOLD,14));
        deleteb3=new JButton("Delete");
        deleteb3.setBounds(260,400,80,30);
        deleteb3.setFont(new Font("Constantia",Font.BOLD,14));
        cancelb4=new JButton("Cancel");
        cancelb4.setBounds(160,450,80,30);
        cancelb4.setFont(new Font("Constantia",Font.BOLD,14));
        
        addb1.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent me){
                addb1.setBackground(Color.yellow);
            }
            public void mouseExited(MouseEvent me){
                addb1.setBackground(UIManager.getColor("control"));
            }
        });
        editb2.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent me){
                editb2.setBackground(Color.yellow);
            }
            public void mouseExited(MouseEvent me){
                editb2.setBackground(UIManager.getColor("control"));
            }
        });
        deleteb3.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent me){
                deleteb3.setBackground(Color.yellow);
            }
            public void mouseExited(MouseEvent me){
                deleteb3.setBackground(UIManager.getColor("control"));
            }
        });
        cancelb4.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent me){
                cancelb4.setBackground(Color.yellow);
            }
            public void mouseExited(MouseEvent me){
                cancelb4.setBackground(UIManager.getColor("control"));
            }
        });
        
        addb1.addActionListener(this);
        editb2.addActionListener(this);
        deleteb3.addActionListener(this);
        cancelb4.addActionListener(this);
        
        
        //components add to panel
        p1.add(roomnoLabel);p1.add(bedtypeLabel);p1.add(roomtypeLabel);p1.add(roompriceLabel);
        p1.add(acButton);p1.add(nonacButton);p1.add(singleButton);p1.add(doubleButton);
        p1.add(roomnoLabel1);p1.add(roomprice1);
        p1.add(addb1);p1.add(editb2);p1.add(deleteb3);p1.add(cancelb4);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        roomButton = new javax.swing.JButton();
        customerButton = new javax.swing.JButton();
        foodButton = new javax.swing.JButton();
        logoutButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        roomButton.setFont(new java.awt.Font("Constantia", 1, 14)); // NOI18N
        roomButton.setText("Room");
        roomButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                roomButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                roomButtonMouseExited(evt);
            }
        });
        roomButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomButtonActionPerformed(evt);
            }
        });

        customerButton.setFont(new java.awt.Font("Constantia", 1, 14)); // NOI18N
        customerButton.setText("Customer");
        customerButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                customerButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                customerButtonMouseExited(evt);
            }
        });
        customerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerButtonActionPerformed(evt);
            }
        });

        foodButton.setFont(new java.awt.Font("Constantia", 1, 14)); // NOI18N
        foodButton.setText("Food");
        foodButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                foodButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                foodButtonMouseExited(evt);
            }
        });
        foodButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                foodButtonActionPerformed(evt);
            }
        });

        logoutButton.setFont(new java.awt.Font("Constantia", 1, 14)); // NOI18N
        logoutButton.setText("Log Out");
        logoutButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logoutButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logoutButtonMouseExited(evt);
            }
        });
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(roomButton, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(customerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(foodButton, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 470, Short.MAX_VALUE)
                .addComponent(logoutButton)
                .addGap(31, 31, 31))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(roomButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(customerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(foodButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(logoutButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(476, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void actionPerformed(ActionEvent ae){
        String s=ae.getActionCommand();
        int roomno,roomprice;
        String roomtype,bedtype;
        
        roomno=Integer.parseInt(roomnoLabel1.getText());
        roomprice=Integer.parseInt(roomprice1.getText());
        try{
            bedtype=(String)bg1.getSelection().getActionCommand().toString();
        
        JOptionPane.showMessageDialog(this, ""+bedtype);
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Exception: "+e);
        }
        
        
        /*if(s.equals("Add")){
            try {
                ps=conn.prepareStatement("insert into tbl_room values('"++"')");
                
            } catch (SQLException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
        }*/
    }
    private void foodButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_foodButtonActionPerformed
        p3.setVisible(true);
        p1.setVisible(false);
        p2.setVisible(false);
    }//GEN-LAST:event_foodButtonActionPerformed

    private void foodButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_foodButtonMouseExited
        foodButton.setBackground(UIManager.getColor("control"));
    }//GEN-LAST:event_foodButtonMouseExited

    private void foodButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_foodButtonMouseEntered
        foodButton.setBackground(Color.yellow);
    }//GEN-LAST:event_foodButtonMouseEntered

    private void customerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerButtonActionPerformed
        p2.setVisible(true);
        p1.setVisible(false);
        p3.setVisible(false);
    }//GEN-LAST:event_customerButtonActionPerformed

    private void customerButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customerButtonMouseExited
        customerButton.setBackground(UIManager.getColor("control"));
    }//GEN-LAST:event_customerButtonMouseExited

    private void customerButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customerButtonMouseEntered
        customerButton.setBackground(Color.yellow);
    }//GEN-LAST:event_customerButtonMouseEntered

    private void roomButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roomButtonActionPerformed
        
        p1.setVisible(true);
        p2.setVisible(false);
        p3.setVisible(false);
    }//GEN-LAST:event_roomButtonActionPerformed

    private void roomButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_roomButtonMouseExited
        roomButton.setBackground(UIManager.getColor("control"));
    }//GEN-LAST:event_roomButtonMouseExited

    private void roomButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_roomButtonMouseEntered
        roomButton.setBackground(Color.yellow);
    }//GEN-LAST:event_roomButtonMouseEntered

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        dispose();
        new Login().setVisible(true);
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void logoutButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutButtonMouseEntered
        logoutButton.setBackground(Color.yellow);
    }//GEN-LAST:event_logoutButtonMouseEntered

    private void logoutButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutButtonMouseExited
        logoutButton.setBackground(UIManager.getColor("control"));
    }//GEN-LAST:event_logoutButtonMouseExited

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton customerButton;
    private javax.swing.JButton foodButton;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JButton logoutButton;
    private javax.swing.JButton roomButton;
    // End of variables declaration//GEN-END:variables
}
