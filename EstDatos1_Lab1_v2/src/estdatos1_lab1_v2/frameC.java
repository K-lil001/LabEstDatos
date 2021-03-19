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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author khali
 */
public class frameC extends javax.swing.JFrame {

    /**
     * Creates new form frameC
     */
    public frameC() {
        initComponents();
        Date date = new Date();
        fechaC2.setDate(date);
        fechaC2.setMinSelectableDate(new Date());
        String dia = Integer.toString(fechaC2.getCalendar().get(Calendar.DAY_OF_MONTH));
        String mes = Integer.toString(fechaC2.getCalendar().get(Calendar.MONTH) + 1);
        String year = Integer.toString(fechaC2.getCalendar().get(Calendar.YEAR));

        //Sacar información de los TextFields
        String cedula = cedulaF2.getText();
        String perro = perroCBox.getSelectedItem().toString();
        String fechaN = dia + "/" + mes + "/" + year;
        diaHorario.setText("Horario para " + fechaN);

        String sDir = "C:\\user";
        File f = new File(sDir);
        String fileName = "agenda.txt";
        File file = new File(sDir, fileName);
        String Horario[] = new String[18];
        Horario[0] = "8:00";
        Horario[1] = "8:30";
        Horario[2] = "9:00";
        Horario[3] = "9:30";
        Horario[4] = "10:00";
        Horario[5] = "10:30";
        Horario[6] = "11:00";
        Horario[7] = "11:30";
        Horario[8] = "12:00";
        Horario[9] = "12:30";
        Horario[10] = "2:00";
        Horario[11] = "2:30";
        Horario[12] = "3:00";
        Horario[13] = "3:30";
        Horario[14] = "4:00";
        Horario[15] = "4:30";
        Horario[16] = "5:00";
        Horario[17] = "5:30";

        if (!file.exists()) {
            f.mkdir();

            try {
                file.createNewFile();
                FileWriter fw = new FileWriter(file.getAbsolutePath(), true);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(fechaN + "," + ",,,,,,,,,,,,,,,,,,"
                        + ",,,,,,,,,,,,,,,,,,"
                        + ",,,,,,,,,,,,,,,,,,"
                        + "Disponible,Disponible,Disponible,Disponible,"
                        + "Disponible,Disponible,Disponible,Disponible,"
                        + "Disponible,Disponible,Disponible,Disponible,"
                        + "Disponible,Disponible,Disponible,Disponible,"
                        + "Disponible,Disponible,");
                bw.newLine();
                bw.flush();
                bw.close();
                fw.close();
                DefaultTableModel model = (DefaultTableModel) tablaA.getModel();
                for (int i = 0; i < 18; i++) {
                    model.addRow(new Object[]{Horario[i], "", "", "", "Disponible"});
                }

            } catch (IOException ex) {
                System.out.println("Error en crear el archivo Agenda");
            }
        } else {
            try ( Scanner sc = new Scanner(file)) {
                boolean existehoy = false;
                while (sc.hasNextLine()) {
                    String linea = sc.nextLine();
                    String data[] = linea.split(",");
                    String fechaA = data[0];
                    String[] cedA = new String[18];
                    String[] perroA = new String[18];
                    String[] servicio = new String[18];
                    String[] disponible = new String[18];
                    DefaultTableModel model = (DefaultTableModel) tablaA.getModel();
                    if (fechaA.equals(fechaN)) {
                        existehoy = true;
                        for (int i = 0; i < 18; i++) {
                            cedA[i] = data[i + 1];
                            perroA[i] = data[i + 19];
                            servicio[i] = data[i + 37];
                            disponible[i] = data[i + 55];
                            model.addRow(new Object[]{Horario[i], cedA[i], perroA[i], servicio[i], disponible[i]});
                        }
                    }

                }
                if (existehoy == false) {
                    try ( FileWriter fw = new FileWriter(file.getAbsolutePath(), true)) {
                        BufferedWriter bw = new BufferedWriter(fw);
                        bw.write(fechaN + "," + ",,,,,,,,,,,,,,,,,,"
                                + ",,,,,,,,,,,,,,,,,,"
                                + ",,,,,,,,,,,,,,,,,,"
                                + "Disponible,Disponible,Disponible,Disponible,"
                                + "Disponible,Disponible,Disponible,Disponible,"
                                + "Disponible,Disponible,Disponible,Disponible,"
                                + "Disponible,Disponible,Disponible,Disponible,"
                                + "Disponible,Disponible,");
                        bw.newLine();
                        bw.flush();
                        bw.close();
                        fw.close();
                        DefaultTableModel model = (DefaultTableModel) tablaA.getModel();
                        for (int i = 0; i < 18; i++) {
                            model.addRow(new Object[]{Horario[i], "", "", "", "Disponible"});
                        }
                    } catch (IOException e) {
                        System.out.println("Error al registrar un nuevo paciente al archivo clientes");
                    }
                }
            } catch (FileNotFoundException e) {

                System.out.println("Error en transferir el archivo clientes a la tabla");
            }

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        accionG = new javax.swing.ButtonGroup();
        serviciosG = new javax.swing.ButtonGroup();
        CitaG = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaC = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        cedulaF = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        perroF = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        razaF = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        colorF = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        fechaC = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        accionRegR = new javax.swing.JRadioButton();
        accionActR = new javax.swing.JRadioButton();
        accionElimR = new javax.swing.JRadioButton();
        regresarB = new javax.swing.JButton();
        realizarB = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        diaHorario = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaA = new javax.swing.JTable();
        regresarB1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        consultaR = new javax.swing.JRadioButton();
        controlR = new javax.swing.JRadioButton();
        desparasitacionR = new javax.swing.JRadioButton();
        vacunacionR = new javax.swing.JRadioButton();
        radiologiaR = new javax.swing.JRadioButton();
        BañoR = new javax.swing.JRadioButton();
        guarderiaR = new javax.swing.JRadioButton();
        fechaC2 = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cedulaF2 = new javax.swing.JTextField();
        perroCBox = new javax.swing.JComboBox<>();
        realizarB2 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        regisCitaR = new javax.swing.JRadioButton();
        actCitaR = new javax.swing.JRadioButton();
        elimCitaR = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jLabel1.setText("Tabla de pacientes");

        tablaC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cedula del Dueño", "Nombre del Perro", "Raza del Perro", "Color del Perro", "Fecha de Nacimiento"
            }
        ));
        tablaC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaCMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaC);

        jLabel2.setText("Cedula del Dueño");

        jLabel3.setText("Nombre del Perro");

        jLabel4.setText("Raza del Perro");

        jLabel5.setText("Color del Perro");

        jLabel6.setText("Fecha de Nacimiento");

        jLabel7.setText("Que desea hacer?");

        accionG.add(accionRegR);
        accionRegR.setText("Registrar");
        accionRegR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accionRegRActionPerformed(evt);
            }
        });

        accionG.add(accionActR);
        accionActR.setText("Actualizar");
        accionActR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accionActRActionPerformed(evt);
            }
        });

        accionG.add(accionElimR);
        accionElimR.setText("Eliminar");
        accionElimR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accionElimRActionPerformed(evt);
            }
        });

        regresarB.setText("Regresar");
        regresarB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarBActionPerformed(evt);
            }
        });

        realizarB.setText("Realizar");
        realizarB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                realizarBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(regresarB, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(fechaC, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                            .addComponent(cedulaF, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(accionRegR, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(accionActR, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(accionElimR, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(realizarB, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                            .addComponent(perroF, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(razaF, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(colorF, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(26, 26, 26))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cedulaF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(perroF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(razaF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(colorF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fechaC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(accionRegR)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(accionActR)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(accionElimR))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(regresarB, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(realizarB, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Modulo de clientes y pacientes", jPanel1);

        diaHorario.setText("Disponibilidad para citas");

        tablaA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Hora", "Cedula del Dueño", "Nombre del Perro", "Procedimiento", "Disponibilidad"
            }
        ));
        jScrollPane2.setViewportView(tablaA);

        regresarB1.setText("Regresar");
        regresarB1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarB1ActionPerformed(evt);
            }
        });

        jLabel9.setText("Fecha para la cita:");

        serviciosG.add(consultaR);
        consultaR.setText("Consulta veterinario $60.000= tiempo de servicio 1 hora");
        consultaR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultaRActionPerformed(evt);
            }
        });

        serviciosG.add(controlR);
        controlR.setText("Control                     $10.000= tiempo de servicio 1/2 hora");
        controlR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                controlRActionPerformed(evt);
            }
        });

        serviciosG.add(desparasitacionR);
        desparasitacionR.setText("Desparasitación\t         $40.000= tiempo de servicio 1/2 hora");
        desparasitacionR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                desparasitacionRActionPerformed(evt);
            }
        });

        serviciosG.add(vacunacionR);
        vacunacionR.setText("Vacunación                $35.000= tiempo de servicio 1/2 hora");
        vacunacionR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vacunacionRActionPerformed(evt);
            }
        });

        serviciosG.add(radiologiaR);
        radiologiaR.setText("Radiologia                  $100.000= tiempo de servicio 1 hora");
        radiologiaR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radiologiaRActionPerformed(evt);
            }
        });

        serviciosG.add(BañoR);
        BañoR.setText("Baño                          $25.000= tiempo de servicio 2 horas");
        BañoR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BañoRActionPerformed(evt);
            }
        });

        serviciosG.add(guarderiaR);
        guarderiaR.setText("Guarderia solo por día $35.000= ");
        guarderiaR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guarderiaRActionPerformed(evt);
            }
        });

        jLabel10.setText("Eliga el perro para la cita:");

        jLabel11.setText("Servicios:");

        jLabel12.setText("Cedula del Dueño");

        cedulaF2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cedulaF2KeyReleased(evt);
            }
        });

        perroCBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        realizarB2.setText("Realizar");
        realizarB2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                realizarB2ActionPerformed(evt);
            }
        });

        jLabel13.setText("Que desea hacer?");

        CitaG.add(regisCitaR);
        regisCitaR.setText("Registrar cita");
        regisCitaR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regisCitaRActionPerformed(evt);
            }
        });

        CitaG.add(actCitaR);
        actCitaR.setText("Actualizar cita");
        actCitaR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actCitaRActionPerformed(evt);
            }
        });

        CitaG.add(elimCitaR);
        elimCitaR.setText("Eliminar cita");
        elimCitaR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                elimCitaRActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(diaHorario)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 599, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(regresarB1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(consultaR)
                            .addComponent(guarderiaR, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(vacunacionR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(desparasitacionR)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cedulaF2)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fechaC2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(perroCBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(radiologiaR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BañoR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(controlR, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(realizarB2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(regisCitaR, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(actCitaR, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(elimCitaR, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(diaHorario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fechaC2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cedulaF2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(perroCBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(consultaR)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(controlR)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(desparasitacionR)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(vacunacionR)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(guarderiaR)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radiologiaR)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BañoR)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(regisCitaR)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(actCitaR)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(elimCitaR))
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(realizarB2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(regresarB1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        fechaC2.getDateEditor().addPropertyChangeListener(new java.beans.PropertyChangeListener(){
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                //Aquí agregaremos la funcionalidad que queremos
                //por ejemplo al seleccionar una fecha le mostrare un diálogo con la fecha de hoy
                actualizarFecha();
            }
        });

        jTabbedPane1.addTab("Modulo de Agenda de citas", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 599, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    int accion;
    int accion2;
    int servicio;


    private void regresarBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarBActionPerformed
        frameI ui = new frameI();
        ui.setVisible(true);
        dispose();
    }//GEN-LAST:event_regresarBActionPerformed

    private void tablaCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaCMouseClicked
        int selectedRow = tablaC.getSelectedRow();
        try {
            DefaultTableModel model = (DefaultTableModel) tablaC.getModel();
            cedulaF.setText(model.getValueAt(selectedRow, 0).toString());
            perroF.setText(model.getValueAt(selectedRow, 1).toString());
            razaF.setText(model.getValueAt(selectedRow, 2).toString());
            colorF.setText(model.getValueAt(selectedRow, 3).toString());

            String date = (model.getValueAt(selectedRow, 4).toString());
            java.util.Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse(date);
            fechaC.setDate(date2);
        } catch (Exception e) {
            System.out.println("Error al actualizar los fields");
        }
    }//GEN-LAST:event_tablaCMouseClicked

    private void accionRegRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accionRegRActionPerformed
        accion = 0;
    }//GEN-LAST:event_accionRegRActionPerformed

    private void accionActRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accionActRActionPerformed
        accion = 1;
    }//GEN-LAST:event_accionActRActionPerformed

    private void accionElimRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accionElimRActionPerformed
        accion = 2;
    }//GEN-LAST:event_accionElimRActionPerformed

    private void realizarBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_realizarBActionPerformed
        DefaultTableModel model = (DefaultTableModel) tablaC.getModel();
        String dia = Integer.toString(fechaC.getCalendar().get(Calendar.DAY_OF_MONTH));
        String mes = Integer.toString(fechaC.getCalendar().get(Calendar.MONTH) + 1);
        String year = Integer.toString(fechaC.getCalendar().get(Calendar.YEAR));

        //Sacar información de los TextFields
        String cedula = cedulaF.getText();
        String perro = perroF.getText();
        String raza = razaF.getText();
        String color = colorF.getText();
        String fechaN = dia + "/" + mes + "/" + year;

        int selectedRow = tablaC.getSelectedRow();

        switch (accion) {
            case 0:
                try {
                long ced = Long.parseLong(cedulaF.getText());
                if (cedulaF.getText().length() == 10) {
                    model.addRow(new Object[]{cedula, perro, raza, color, fechaN});

                    try ( FileWriter fw = new FileWriter("C:\\user\\clientes.txt", true)) {
                        BufferedWriter bw = new BufferedWriter(fw);
                        bw.write(cedula + "," + perro + "," + raza + "," + color + "," + fechaN);
                        bw.newLine();
                        bw.flush();
                        bw.close();
                        fw.close();
                    } catch (IOException e) {
                        System.out.println("Error al registrar un nuevo paciente al archivo clientes");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Su cedula debe ser de 10 numeros");
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Su cedula debe ser en numeros");
            }

            break;
            case 1:

                if (selectedRow != -1) {
                    //Instantiating the File class
                    String filePath = "C:\\user\\clientes.txt";
                    //Instantiating the Scanner class to read the file
                    Scanner sc;
                    try {
                        sc = new Scanner(new File(filePath));
                        //instantiating the StringBuffer class
                        StringBuffer buffer = new StringBuffer();
                        //Reading lines of the file and appending them to StringBuffer
                        while (sc.hasNextLine()) {
                            buffer.append(sc.nextLine() + System.lineSeparator());
                        }
                        String fileContents = buffer.toString();
                        System.out.println("Contents of the file: " + fileContents);
                        //closing the Scanner object
                        sc.close();
                        String oldLine = (String) model.getValueAt(selectedRow, 0) + ","
                                + (String) model.getValueAt(selectedRow, 1) + ","
                                + (String) model.getValueAt(selectedRow, 2) + ","
                                + (String) model.getValueAt(selectedRow, 3) + ","
                                + (String) model.getValueAt(selectedRow, 4);
                        String newLine = cedula + "," + perro + "," + raza + "," + color + "," + fechaN;
                        System.out.println("old line: " + oldLine);
                        System.out.println("n line: " + newLine);
                        //Replacing the old line with new line
                        fileContents = fileContents.replaceAll(oldLine, newLine);
                        //instantiating the FileWriter class
                        FileWriter writer;
                        try {
                            writer = new FileWriter(filePath);
                            System.out.println("");
                            System.out.println("new data: " + fileContents);
                            writer.append(fileContents);
                            writer.flush();
                        } catch (IOException ex) {
                            Logger.getLogger(frameC.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(frameC.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    model.setValueAt(cedula, selectedRow, 0);
                    model.setValueAt(perro, selectedRow, 1);
                    model.setValueAt(raza, selectedRow, 2);
                    model.setValueAt(color, selectedRow, 3);
                    model.setValueAt(fechaN, selectedRow, 4);
                }
                break;
            case 2:
                if (selectedRow != -1) {
                    File inputFile = new File("C:\\user\\clientes.txt");
                    File tempFile = new File("C:\\user\\tmpFile.txt");

                    BufferedReader reader;
                    try {
                        reader = new BufferedReader(new FileReader(inputFile));
                        BufferedWriter writer;
                        try {
                            writer = new BufferedWriter(new FileWriter(tempFile));
                            String lineToRemove = (String) model.getValueAt(selectedRow, 0) + ","
                                    + (String) model.getValueAt(selectedRow, 1) + ","
                                    + (String) model.getValueAt(selectedRow, 2) + ","
                                    + (String) model.getValueAt(selectedRow, 3) + ","
                                    + (String) model.getValueAt(selectedRow, 4);
                            String currentLine;

                            while ((currentLine = reader.readLine()) != null) {
                                // trim newline when comparing with lineToRemove
                                String trimmedLine = currentLine.trim();
                                if (trimmedLine.equals(lineToRemove)) {
                                    continue;
                                }
                                writer.write(currentLine + System.getProperty("line.separator"));
                            }
                            writer.close();
                            reader.close();
                            inputFile.delete();
                            boolean successful = tempFile.renameTo(inputFile);
                            System.out.println(successful);
                        } catch (IOException ex) {
                            Logger.getLogger(frameC.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(frameC.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    model.removeRow(selectedRow);
                }
                break;
        }
    }//GEN-LAST:event_realizarBActionPerformed

    private void regresarB1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarB1ActionPerformed
        frameI ui = new frameI();
        ui.setVisible(true);
        dispose();
    }//GEN-LAST:event_regresarB1ActionPerformed

    private void realizarB2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_realizarB2ActionPerformed
        DefaultTableModel model = (DefaultTableModel) tablaA.getModel();
        String dia = Integer.toString(fechaC2.getCalendar().get(Calendar.DAY_OF_MONTH));
        String mes = Integer.toString(fechaC2.getCalendar().get(Calendar.MONTH) + 1);
        String year = Integer.toString(fechaC2.getCalendar().get(Calendar.YEAR));

        //Sacar información de los TextFields
        String cedula = cedulaF2.getText();
        String perro = perroCBox.getSelectedItem().toString();
        String fechaN = dia + "/" + mes + "/" + year;
        int selectedRow = tablaC.getSelectedRow();


    }//GEN-LAST:event_realizarB2ActionPerformed

    private void regisCitaRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regisCitaRActionPerformed
        accion2 = 0;
    }//GEN-LAST:event_regisCitaRActionPerformed

    private void actCitaRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actCitaRActionPerformed
        accion2 = 1;
    }//GEN-LAST:event_actCitaRActionPerformed

    private void elimCitaRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_elimCitaRActionPerformed
        accion2 = 2;
    }//GEN-LAST:event_elimCitaRActionPerformed

    private void consultaRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultaRActionPerformed
        servicio = 0;
    }//GEN-LAST:event_consultaRActionPerformed

    private void controlRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_controlRActionPerformed
        servicio = 1;
    }//GEN-LAST:event_controlRActionPerformed

    private void desparasitacionRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_desparasitacionRActionPerformed
        servicio = 2;
    }//GEN-LAST:event_desparasitacionRActionPerformed

    private void vacunacionRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vacunacionRActionPerformed
        servicio = 3;
    }//GEN-LAST:event_vacunacionRActionPerformed

    private void guarderiaRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guarderiaRActionPerformed
        servicio = 4;
    }//GEN-LAST:event_guarderiaRActionPerformed

    private void radiologiaRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radiologiaRActionPerformed
        servicio = 5;
    }//GEN-LAST:event_radiologiaRActionPerformed

    private void BañoRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BañoRActionPerformed
        servicio = 6;
    }//GEN-LAST:event_BañoRActionPerformed

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked


    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void cedulaF2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cedulaF2KeyReleased
        String sDir = "C:\\user";
        File f = new File(sDir);
        String fileName = "clientes.txt";
        File file = new File(sDir, fileName);
        try ( Scanner sc = new Scanner(file)) {
            ArrayList<String> perros = new ArrayList<String>();
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                String data[] = linea.split(",");
                String cedula = data[0];
                String perro = data[1];
                if (cedula.contains(cedulaF2.getText())) {
                    perros.add(perro);
                }
            }

            frameC.AddRowToPerroCB(perros);
        } catch (FileNotFoundException e) {

        }
    }//GEN-LAST:event_cedulaF2KeyReleased

    public static void AddRowToTablaC(Object[] dataRow) {
        DefaultTableModel model = (DefaultTableModel) tablaC.getModel();
        model.addRow(dataRow);
    }

    public static void AddRowToPerroCB(ArrayList<String> data) {
        DefaultComboBoxModel model;
        model = (DefaultComboBoxModel) perroCBox.getModel();
        model.removeAllElements();
        for (String perro : data) {
            model.addElement(perro);
        }
    }

    public static void textFieldsONorOFF(String ced, boolean mode) {
        cedulaF.setText(ced);
        cedulaF2.setText(ced);
        cedulaF.setEditable(mode);
        cedulaF2.setEditable(mode);
    }

    public void actualizarFecha() {
        try {
            String dia = Integer.toString(fechaC2.getCalendar().get(Calendar.DAY_OF_MONTH));
            String mes = Integer.toString(fechaC2.getCalendar().get(Calendar.MONTH) + 1);
            String year = Integer.toString(fechaC2.getCalendar().get(Calendar.YEAR));

            //Sacar información de los TextFields
            String fechaN = dia + "/" + mes + "/" + year;
            diaHorario.setText("Horario para " + fechaN);
        } catch (Exception e) {

        }

    }

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
            java.util.logging.Logger.getLogger(frameC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frameC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frameC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frameC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frameC().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton BañoR;
    private javax.swing.ButtonGroup CitaG;
    private javax.swing.JRadioButton accionActR;
    private javax.swing.JRadioButton accionElimR;
    private javax.swing.ButtonGroup accionG;
    private javax.swing.JRadioButton accionRegR;
    private javax.swing.JRadioButton actCitaR;
    private static javax.swing.JTextField cedulaF;
    private static javax.swing.JTextField cedulaF2;
    private javax.swing.JTextField colorF;
    private javax.swing.JRadioButton consultaR;
    private javax.swing.JRadioButton controlR;
    private javax.swing.JRadioButton desparasitacionR;
    private javax.swing.JLabel diaHorario;
    private javax.swing.JRadioButton elimCitaR;
    private com.toedter.calendar.JDateChooser fechaC;
    private com.toedter.calendar.JDateChooser fechaC2;
    private javax.swing.JRadioButton guarderiaR;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private static javax.swing.JComboBox<String> perroCBox;
    private javax.swing.JTextField perroF;
    private javax.swing.JRadioButton radiologiaR;
    private javax.swing.JTextField razaF;
    private javax.swing.JButton realizarB;
    private javax.swing.JButton realizarB2;
    private javax.swing.JRadioButton regisCitaR;
    private javax.swing.JButton regresarB;
    private javax.swing.JButton regresarB1;
    private javax.swing.ButtonGroup serviciosG;
    private javax.swing.JTable tablaA;
    private static javax.swing.JTable tablaC;
    private javax.swing.JRadioButton vacunacionR;
    // End of variables declaration//GEN-END:variables
}
