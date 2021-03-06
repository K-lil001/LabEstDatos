/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estdatos1_lab1_v2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.System.console;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author khali
 */
public class frameI extends javax.swing.JFrame {

    static void removeLine(String filePath, String lineToRemove) throws IOException{
        File inputFile = new File(filePath);
        File tempFile = new File("C:\\user\\tmpFile.txt");
        BufferedReader reader;
        reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer;
        writer = new BufferedWriter(new FileWriter(tempFile));
        String currentLine;
        while ((currentLine = reader.readLine()) != null) {
            String trimmedLine = currentLine.trim();
            if (trimmedLine.equals(lineToRemove)) {
                continue;
            }
            writer.write(currentLine + System.getProperty("line.separator"));
        }
        writer.close();
        reader.close();
        inputFile.delete();
        tempFile.renameTo(inputFile);
    }

    /**
     * Creates new form frameI
     */
    public frameI() {
        initComponents();
    }

    public static void createFile(File f, File file) {
        f.mkdir();
        try {
            file.createNewFile();
        } catch (IOException ex) {
            System.out.println("Error en crear el archivo");
        }
    }

    public static void writeLine(String filePath, String line) {
        try ( FileWriter fw = new FileWriter(filePath, true)) {
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(line);
            bw.newLine();
            bw.flush();
            bw.close();
            fw.close();
        } catch (IOException e) {
            System.out.println("Error al registrar un nuevo paciente al archivo clientes");
        }
    }

    public static void overWrite(String filePath, String oldLine, String newLine) throws IOException {
        Scanner sc = new Scanner(new File(filePath));
        StringBuffer buffer = new StringBuffer();
        while (sc.hasNextLine()) {
            buffer.append(sc.nextLine() + System.lineSeparator());
        }
        String fileContents = buffer.toString();
        sc.close();

        fileContents = fileContents.replaceAll(oldLine, newLine);
        FileWriter writer = new FileWriter(filePath);
        writer.append(fileContents);
        writer.flush();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ingresoG = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ingClienteR = new javax.swing.JRadioButton();
        ingVetR = new javax.swing.JRadioButton();
        ingAdminR = new javax.swing.JRadioButton();
        ingText = new javax.swing.JLabel();
        ingField = new javax.swing.JTextField();
        ingButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel1.setText("Veterinaria");

        jLabel2.setText("Ingresar como:");

        ingresoG.add(ingClienteR);
        ingClienteR.setSelected(true);
        ingClienteR.setText("Cliente");
        ingClienteR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingClienteRActionPerformed(evt);
            }
        });

        ingresoG.add(ingVetR);
        ingVetR.setText("Veterinario");
        ingVetR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingVetRActionPerformed(evt);
            }
        });

        ingresoG.add(ingAdminR);
        ingAdminR.setText("Administrador");
        ingAdminR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingAdminRActionPerformed(evt);
            }
        });

        ingText.setText("Cedula del Cliente:");

        ingButton.setText("Ingresar");
        ingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ingButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(ingVetR, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(ingClienteR, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel2))))
                            .addComponent(ingAdminR, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(ingText))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ingField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(ingText))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ingClienteR)
                    .addComponent(ingField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ingVetR)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ingAdminR)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ingButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    int ing = 0;
    String contraVet = "hola";
    String contraAdmin = "aloh";
    private void ingClienteRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingClienteRActionPerformed
        ing = 0;
        ingText.setText("Cedula del Cliente:");
    }//GEN-LAST:event_ingClienteRActionPerformed

    private void ingVetRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingVetRActionPerformed
        ing = 1;
        ingText.setText("Contrase??a del Veterinario:");
    }//GEN-LAST:event_ingVetRActionPerformed

    private void ingAdminRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingAdminRActionPerformed
        ing = 2;
        ingText.setText("Contrase??a del Administrador:");
    }//GEN-LAST:event_ingAdminRActionPerformed

    private void ingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingButtonActionPerformed
        switch (ing) {
            case 0:
                if (ingField.getText().equals("")) {
                    frameC uiC = new frameC();
                    File f = new File("C:\\user");
                    File file = new File("C:\\user", "clientes.txt");
                    if (!file.exists()) {
                        createFile(f, file);
                    } else {
                        try ( Scanner sc = new Scanner(file)) {
                            ArrayList<String> perros = new ArrayList<String>();
                            while (sc.hasNextLine()) {
                                String linea = sc.nextLine();
                                String data[] = linea.split(",");
                                String cedula = data[0];
                                String perro = data[1];
                                String raza = data[2];
                                String color = data[3];
                                String fechaN = data[4];
                                perros.add(perro);
                                frameC.AddRowToTablaC(new Object[]{
                                    cedula,
                                    perro,
                                    raza,
                                    color,
                                    fechaN});
                            }
                            frameC.AddRowToPerroCB(perros);
                        } catch (FileNotFoundException e) {
                            System.out.println("Error en transferir el archivo clientes a la tabla (version hacker)");
                        }
                    }
                    uiC.setVisible(true);
                    dispose();
                } else {
                    try {
                        long ced = Long.parseLong(ingField.getText());
                        if (ingField.getText().length() == 10) {
                            frameC uiC = new frameC();
                            File f = new File("C:\\user");
                            File file = new File("C:\\user", "clientes.txt");

                            if (!file.exists()) {
                                createFile(f, file);
                            } else {
                                try ( Scanner sc = new Scanner(file)) {
                                    ArrayList<String> perros = new ArrayList<String>();
                                    while (sc.hasNextLine()) {
                                        String linea = sc.nextLine();
                                        String data[] = linea.split(",");
                                        String cedula = data[0];
                                        String perro = data[1];
                                        String raza = data[2];
                                        String color = data[3];
                                        String fechaN = data[4];
                                        if (cedula.equals(ingField.getText())) {
                                            perros.add(perro);
                                            frameC.AddRowToTablaC(new Object[]{
                                                cedula,
                                                perro,
                                                raza,
                                                color,
                                                fechaN});
                                        }

                                    }
                                    frameC.textFieldsONorOFF(String.valueOf(ced), false);
                                    frameC.AddRowToPerroCB(perros);
                                } catch (FileNotFoundException e) {
                                    System.out.println("Error en transferir el archivo clientes a la tabla");
                                }
                            }
                            uiC.setVisible(true);
                            dispose();
                        } else {
                            JOptionPane.showMessageDialog(null, "Su cedula debe ser 10 numeros");
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Su cedula debe ser en numeros");
                    }
                }
                break;
            case 1:
                if (contraVet.equals(ingField.getText())) {
                    frameV uiV = new frameV();
                    uiV.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Contrase??a incorrecta");
                }
                break;
            case 2:
                if (contraAdmin.equals(ingField.getText())) {
                    frameA uiA = new frameA();
                    uiA.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Contrase??a incorrecta");
                }
                break;
        }
    }//GEN-LAST:event_ingButtonActionPerformed

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
            java.util.logging.Logger.getLogger(frameI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frameI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frameI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frameI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frameI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton ingAdminR;
    private javax.swing.JButton ingButton;
    private javax.swing.JRadioButton ingClienteR;
    private javax.swing.JTextField ingField;
    private javax.swing.JLabel ingText;
    private javax.swing.JRadioButton ingVetR;
    private javax.swing.ButtonGroup ingresoG;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
