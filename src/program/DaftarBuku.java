package program;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DaftarBuku extends javax.swing.JFrame {
    
    //database buku
    static String[][]buku = new String[100][5];
    static boolean cek = false;
    static int top =0;
    
    public static void updateTabel(String[][]array){
        DefaultTableModel model = (DefaultTableModel)tabelBuku.getModel();
        int jumlahBaris = model.getRowCount();
        System.out.println(jumlahBaris);
        //destroy isi table
        for(int i=jumlahBaris-1; i>=0; i--){
            model.removeRow(i);
        }
        //mengisi table lagi yg sudah diurutkan
        for(int j=0; j<top; j++){
            if(array[j][0].equals("0") && array[j][1].equals("0")&&array[j][2].equals("0")&&array[j][3].equals("0")&&array[j][4].equals("0")){
                System.out.println("yg kosong jangan ditambahkan ke table");
            }else{
                Object[]row = {array[j][0],array[j][1],array[j][2],array[j][3],array[j][4]};
                model.addRow(row);
            }
        }
        tabelBuku.setModel(model);
    }
    
    
    public static void tambahBuku(String id,String judul,String pengarang,String penerbit,String tahun){
        try {    
            DefaultTableModel model = (DefaultTableModel)tabelBuku.getModel();
            buku [top][0] = id;
            buku [top][1] = judul;
            buku [top][2] = pengarang;
            buku [top][3] = penerbit;
            buku [top][4] = tahun;        
            Object[]row ={buku [top][0],buku [top][1],buku [top][2],buku [top][3],buku [top][4]};
            model.addRow(row);
            top++;
            tabelBuku.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error! "+e);}
    }
    
    public static void hapusBuku(String id){
        DefaultTableModel model = (DefaultTableModel)tabelBuku.getModel();
        int index =0;
        while(index < top){
            if(id.equals(buku[index][0])){
                buku[index][0]="0";
                buku[index][1]="0";
                buku[index][2]="0";
                buku[index][3]="0";
                buku[index][4]="0";
                model.removeRow(index);
                cek = true;
                break;
            }else{
                cek = false;
            }
            index++;
        }
        updateTabel(buku);
    }
    
    public static void editBuku(String id,String judul,String pengarang,String penerbit,String tahun){
        DefaultTableModel model = (DefaultTableModel)tabelBuku.getModel();
        int index =0;
        while(index < top){
            if(id.equals(buku[index][0])){
                buku[index][0]=id;
                buku[index][1]=judul;
                buku[index][2]=pengarang;
                buku[index][3]=penerbit;
                buku[index][4]=tahun;
                cek = true;
                break;
            }else{
                cek = false;
            }
            index++;
        }
        updateTabel(buku);
    }
    
    public static void insertionSort(String[][] array, String angka){
        int indexInt = Integer.parseInt(angka);
        for(int i=0; i<top; i++){
            for(int j=i; j>0; j--){
                if(Integer.parseInt(array[j][indexInt]) < Integer.parseInt(array[j-1][indexInt])){
                    for (int k = 0; k < 5 ; k++){  
                        String temp = array[j][k];
                        array[j][k]=array[j-1][k];
                        array[j-1][k] = temp ;
                   }
                    
                }
            }
        }
        updateTabel(array);
    }
   
    /**
     * Creates new form DaftarBuku
     */
    public DaftarBuku() {
        initComponents();
        tabelBuku.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD,12));
        tabelBuku.getTableHeader().setBackground(new Color(102,102,102));
        tabelBuku.getTableHeader().setForeground(new Color(255,255,255));
    }

     //variable yang nantinya untuk menggeser window
    int mouseX;
    int mouseY;
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelBuku = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        tambahButton = new javax.swing.JButton();
        user = new javax.swing.JLabel();
        editButton = new javax.swing.JButton();
        hapusButton = new javax.swing.JButton();
        logoutButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        exitButton = new javax.swing.JLabel();
        minimizeButton = new javax.swing.JLabel();
        pilihCb = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        tabelBuku.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Buku", "Judul", "Pengarang", "Penerbit", "Tahun"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelBuku);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 624, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));

        tambahButton.setBackground(new java.awt.Color(172, 172, 172));
        tambahButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tambahButton.setForeground(new java.awt.Color(0, 0, 0));
        tambahButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/addbook.png"))); // NOI18N
        tambahButton.setText("TAMBAH");
        tambahButton.setFocusPainted(false);
        tambahButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        tambahButton.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        tambahButton.setRequestFocusEnabled(false);
        tambahButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahButtonActionPerformed(evt);
            }
        });

        user.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        user.setForeground(new java.awt.Color(255, 255, 255));
        user.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/user.png"))); // NOI18N
        user.setText("USER");
        user.setIconTextGap(6);
        user.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                userPropertyChange(evt);
            }
        });

        editButton.setBackground(new java.awt.Color(172, 172, 172));
        editButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        editButton.setForeground(new java.awt.Color(0, 0, 0));
        editButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/edit_file_36px.png"))); // NOI18N
        editButton.setText("EDIT");
        editButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        editButton.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        editButton.setRequestFocusEnabled(false);
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        hapusButton.setBackground(new java.awt.Color(172, 172, 172));
        hapusButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        hapusButton.setForeground(new java.awt.Color(0, 0, 0));
        hapusButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/remove_book_36px.png"))); // NOI18N
        hapusButton.setText("HAPUS");
        hapusButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        hapusButton.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        hapusButton.setRequestFocusEnabled(false);
        hapusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusButtonActionPerformed(evt);
            }
        });

        logoutButton.setBackground(new java.awt.Color(172, 172, 172));
        logoutButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        logoutButton.setForeground(new java.awt.Color(0, 0, 0));
        logoutButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/logout.png"))); // NOI18N
        logoutButton.setText("LOGOUT");
        logoutButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        logoutButton.setFocusPainted(false);
        logoutButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        logoutButton.setRequestFocusEnabled(false);
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hapusButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(user, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tambahButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(user)
                .addGap(10, 10, 10)
                .addComponent(tambahButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hapusButton, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(211, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("DAFTAR BUKU");

        exitButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/exit30.png"))); // NOI18N
        exitButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitButtonMouseClicked(evt);
            }
        });

        minimizeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/minimize.png"))); // NOI18N
        minimizeButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        minimizeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizeButtonMouseClicked(evt);
            }
        });

        pilihCb.setBackground(new java.awt.Color(102, 102, 102));
        pilihCb.setForeground(new java.awt.Color(255, 255, 255));
        pilihCb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Urut Berdasarkan:", "ID Buku", "Tahun" }));
        pilihCb.setFocusable(false);
        pilihCb.setOpaque(true);
        pilihCb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pilihCbActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pilihCb, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(144, 144, 144)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 182, Short.MAX_VALUE)
                .addComponent(minimizeButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exitButton)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(minimizeButton)
                    .addComponent(exitButton)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(pilihCb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tambahButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahButtonActionPerformed
        new Tambah().setVisible(true);
    }//GEN-LAST:event_tambahButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        new Edit().setVisible(true);
    }//GEN-LAST:event_editButtonActionPerformed

    private void hapusButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusButtonActionPerformed
        new Hapus().setVisible(true);
    }//GEN-LAST:event_hapusButtonActionPerformed

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        this.dispose();
        new Login().setVisible(true);
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void exitButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitButtonMouseClicked
         ImageIcon icon = new ImageIcon("src/resources/closelogo.png");
        int jawab = JOptionPane.showOptionDialog(this,
            "Apakah anda ingin keluar?",
            "Confirm Dialog",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE, icon, null, null);

        if(jawab == JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }//GEN-LAST:event_exitButtonMouseClicked

    private void minimizeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeButtonMouseClicked
          this.setExtendedState(DaftarBuku.ICONIFIED);
    }//GEN-LAST:event_minimizeButtonMouseClicked

    private void userPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_userPropertyChange
        user.setText(Login.user);
    }//GEN-LAST:event_userPropertyChange

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        mouseX = evt.getX();
        mouseY = evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        int koordinatX = evt.getXOnScreen();
        int koordinatY = evt.getYOnScreen();
        this.setLocation(koordinatX-mouseX, koordinatY-mouseY);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void pilihCbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pilihCbActionPerformed
        try {
            int indexComboBox = pilihCb.getSelectedIndex();
            if(indexComboBox==1){
                insertionSort(buku, "0");
            }else if(indexComboBox==2){
                insertionSort(buku, "4");
            }
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ID Buku/Tahun ada yang kosong!\nHarap edit dahulu!");
        }
    }//GEN-LAST:event_pilihCbActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DaftarBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DaftarBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DaftarBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DaftarBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DaftarBuku().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton editButton;
    private javax.swing.JLabel exitButton;
    private javax.swing.JButton hapusButton;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton logoutButton;
    private javax.swing.JLabel minimizeButton;
    private javax.swing.JComboBox<String> pilihCb;
    private static javax.swing.JTable tabelBuku;
    private javax.swing.JButton tambahButton;
    private javax.swing.JLabel user;
    // End of variables declaration//GEN-END:variables
}
