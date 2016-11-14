/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mongodb.main;

import br.com.mongodb.util.Menssagem;
import br.com.mongodb.view.AdicionaPaciente;
import br.com.mongodb.view.AdicionaMedico;
import br.com.mongodb.view.AdicionaConsulta;
import br.com.mongodb.dao.ConsultaDao;
import br.com.mongodb.dao.MedicoDao;
import br.com.mongodb.dao.PacienteDao;
import br.com.mongodb.model.Consulta;
import br.com.mongodb.model.Medico;
import br.com.mongodb.model.Paciente;
import br.com.mongodb.view.EditaConsulta;
import br.com.mongodb.view.EditaMedico;
import br.com.mongodb.view.EditaPaciente;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author eric.bezerra
 */
public final class DashBoard extends javax.swing.JFrame {

    DefaultTableModel modelo;
    private int confirmacao;

    /**
     * Creates new form DashBoard
     */
    public DashBoard() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        populaTabelaConsulta();
        populaTabelaPaciente();
        populaTabelaMedico();
    }

    public void populaTabelaConsulta() {
        ConsultaDao cdao = new ConsultaDao();
        MedicoDao mdao = new MedicoDao();
        PacienteDao pdao = new PacienteDao();

        Object[] consultaColuna
                = {"Data", "Hora", "Medico", "Paciente", "Excluir", "Alterar"};

        int colums = consultaColuna.length;
        int rows = cdao.find().size();

        Object[][] dados = new Object[rows][colums];

        for (int i = 0; i < rows; i++) {
            dados[i][0] = cdao.find().get(i).getData();
            dados[i][1] = cdao.find().get(i).getHora();
            dados[i][2] = mdao.findDocumentById(cdao.find().get(i).getMedicoId()).getNome();
            dados[i][3] = pdao.findDocumentById(cdao.find().get(i).getPacienteId()).getNome();
        }
        modelo = (DefaultTableModel) tabelaConsulta.getModel();

        for (int i = 0; i < dados.length; i++) {
            modelo.insertRow(modelo.getRowCount(), dados[i]);
        }
    }

    public void populaTabelaPaciente() {
        PacienteDao pd = new PacienteDao();
        Object[] pacienteColuna
                = {"Nome", "Sexo", "Idade"};
        int colums = pacienteColuna.length;
        int rows = pd.find().size();
        Object[][] dados = new Object[rows][colums];

        for (int i = 0; i < rows; i++) {
            dados[i][0] = pd.find().get(i).getNome();
            dados[i][1] = pd.find().get(i).getSexo();
            dados[i][2] = pd.find().get(i).getIdade();
        }
        modelo = (DefaultTableModel) tabelaPaciente.getModel();

        for (int i = 0; i < dados.length; i++) {
            modelo.insertRow(modelo.getRowCount(), dados[i]);
        }
    }

    public void populaTabelaMedico() {
        MedicoDao md = new MedicoDao();
        Object[] medicoColuna
                = {"Nome", "Especialidade"};
        int colums = medicoColuna.length;
        int rows = md.find().size();
        Object[][] dados = new Object[rows][colums];

        for (int i = 0; i < rows; i++) {
            dados[i][0] = md.find().get(i).getNome();
            dados[i][1] = md.find().get(i).getEspecialidade();
        }

        modelo = (DefaultTableModel) tabelaMedico.getModel();

        for (int i = 0; i < dados.length; i++) {
            modelo.insertRow(modelo.getRowCount(), dados[i]);
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

        jPanel2 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jpConsultas = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaConsulta = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jpPacientes = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaPaciente = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jpMedicos = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelaMedico = new javax.swing.JTable();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(650, 480));

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tabelaConsulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data", "Hora", "Medico", "Paciente"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tabelaConsulta);

        jButton1.setText("Nova");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Editar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Excluir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpConsultasLayout = new javax.swing.GroupLayout(jpConsultas);
        jpConsultas.setLayout(jpConsultasLayout);
        jpConsultasLayout.setHorizontalGroup(
            jpConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpConsultasLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(125, 125, 125))
            .addComponent(jScrollPane2)
        );
        jpConsultasLayout.setVerticalGroup(
            jpConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpConsultasLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(jpConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Consultas", jpConsultas);

        tabelaPaciente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Sexo", "Idade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelaPaciente);

        jButton4.setText("Nova");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Editar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Excluir");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpPacientesLayout = new javax.swing.GroupLayout(jpPacientes);
        jpPacientes.setLayout(jpPacientesLayout);
        jpPacientesLayout.setHorizontalGroup(
            jpPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpPacientesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(124, 124, 124))
        );
        jpPacientesLayout.setVerticalGroup(
            jpPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPacientesLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(jpPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Pacientes", jpPacientes);

        tabelaMedico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Especialidade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tabelaMedico);

        jButton7.setText("Nova");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Editar");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("Excluir");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpMedicosLayout = new javax.swing.GroupLayout(jpMedicos);
        jpMedicos.setLayout(jpMedicosLayout);
        jpMedicosLayout.setHorizontalGroup(
            jpMedicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpMedicosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(126, 126, 126))
        );
        jpMedicosLayout.setVerticalGroup(
            jpMedicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpMedicosLayout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(jpMedicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 15, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Medicos", jpMedicos);

        jLabel1.setFont(new java.awt.Font("Arial", 2, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("Consultas Médicas");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addComponent(jLabel1)
                .addContainerGap(84, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 589, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jMenu1.setText("Opções");

        jMenuItem1.setText("Sair");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Ajuda");

        jMenuItem2.setText("Sobre");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        new AdicionaConsulta().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (tabelaConsulta.getSelectedRow() != -1) {
            String data = tabelaConsulta.getValueAt(tabelaConsulta.getSelectedRow(), 0).toString();
            String hora = tabelaConsulta.getValueAt(tabelaConsulta.getSelectedRow(), 1).toString();
            String medico = tabelaConsulta.getValueAt(tabelaConsulta.getSelectedRow(), 2).toString();
            String paciente = tabelaConsulta.getValueAt(tabelaConsulta.getSelectedRow(), 3).toString();
            new EditaConsulta(data, hora, medico, paciente).setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma consulta para editar");
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (tabelaConsulta.getSelectedRow() != -1) {
            Consulta c = new Consulta();
            ConsultaDao cdao = new ConsultaDao();

            MedicoDao mdao = new MedicoDao();
            Medico medico = new Medico();
            ArrayList<Medico> ml;
            ml = mdao.find();

            PacienteDao pdao = new PacienteDao();
            Paciente paciente = new Paciente();
            ArrayList<Paciente> pl;
            pl = pdao.find();

            String data = tabelaConsulta.getValueAt(tabelaConsulta.getSelectedRow(), 0).toString();
            String hora = tabelaConsulta.getValueAt(tabelaConsulta.getSelectedRow(), 1).toString();
            String m = tabelaConsulta.getValueAt(tabelaConsulta.getSelectedRow(), 2).toString();
            String p = tabelaConsulta.getValueAt(tabelaConsulta.getSelectedRow(), 3).toString();

            for (int i = 0; i < ml.size(); i++) {
                if (ml.get(i).getNome().equalsIgnoreCase(m)) {
                    medico = ml.get(i);
                }
            }
            for (int i = 0; i < pl.size(); i++) {
                if (pl.get(i).getNome().equalsIgnoreCase(p)) {
                    paciente = pl.get(i);
                }
            }

            c.setData(data);
            c.setHora(hora);
            c.setMedicoId(medico.getId());
            c.setPacienteId(paciente.getId());

            dispose();

            int opt = JOptionPane.showConfirmDialog(this, "Confirma exclusão da consulta?\nConsulta:\nData: " + data
                    + "\nHora: " + hora
                    + "\nPaciente: " + p
                    + "\nMedico: " + m, "Exclusão de consulta", JOptionPane.YES_NO_OPTION);

            if (opt == 0) {
                cdao.delete(c);
                new DashBoard().setVisible(true);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma Consulta para excluir");
        }

    }//GEN-LAST:event_jButton3ActionPerformed


    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        new AdicionaPaciente().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if (tabelaPaciente.getSelectedRow() != -1) {
            String nome = tabelaPaciente.getValueAt(tabelaPaciente.getSelectedRow(), 0).toString();
            String sexo = tabelaPaciente.getValueAt(tabelaPaciente.getSelectedRow(), 1).toString();
            String idade = tabelaPaciente.getValueAt(tabelaPaciente.getSelectedRow(), 2).toString();

            new EditaPaciente(nome, sexo, idade).setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um Paciente para editar");
        }

        System.out.println("Editar Paciente");
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        if (tabelaPaciente.getSelectedRow() != -1) {
            String nome = tabelaPaciente.getValueAt(tabelaPaciente.getSelectedRow(), 0).toString();
            String sexo = tabelaPaciente.getValueAt(tabelaPaciente.getSelectedRow(), 1).toString();
            String idade = tabelaPaciente.getValueAt(tabelaPaciente.getSelectedRow(), 2).toString();
            String id = null;

            Paciente paciente = new Paciente(nome, sexo, Integer.parseInt(idade));
            PacienteDao pdao = new PacienteDao();

            for (int i = 0; i < pdao.find().size(); i++) {
                String fnome = pdao.find().get(i).getNome();
                String fsexo = pdao.find().get(i).getSexo();
                int fidade = pdao.find().get(i).getIdade();

                if ((fnome.equalsIgnoreCase(nome)) && (fsexo.equalsIgnoreCase(sexo)) && (fidade == Integer.parseInt(idade))) {
                    id = pdao.find().get(i).getId();
                }
            }
            ConsultaDao cdao = new ConsultaDao();
            ArrayList<Consulta> list = new ArrayList<>();
            dispose();
            int opt = JOptionPane.showConfirmDialog(this,
                    "Confirma exclusão do Paciente?\nNome: " + nome
                    + "\nSexo: " + sexo
                    + "\nIdade: " + idade,
                    "Exclusão do Paciente", JOptionPane.YES_NO_OPTION);

            if (opt == 0) {
                //verifica se tem consultas relacionadas como paciente
                for (int i = 0; i < cdao.find().size(); i++) {
                    if (cdao.find().get(i).getPacienteId().equalsIgnoreCase(id)) {
                        list.add(cdao.find().get(i));
                    }
                }
                //caso possua consulta pergunta se deseja excluir as consultas tambem
                if (list.size() > 0) {
                    confirmacao = JOptionPane.showConfirmDialog(this, "Esse paciente possui "
                            + list.size() + " consulta(s).\nDeseja realmente excluilo?"
                            + "\nIsso removerá todas as consultas relacionadas a ele.",
                            "Exclusão do Paciente", JOptionPane.YES_NO_OPTION);
                    //caso sim exclui todas as consultas relacionadas e o paciente tabem
                    if ((confirmacao == 0)) {
                        for (int i = 0; i < list.size(); i++) {
                            cdao.delete(list.get(i));
                        }
                        pdao.delete(paciente);
                        JOptionPane.showMessageDialog(null, "Paciente e Consultas relacionadas excluidos com sucesso.");
                        new DashBoard().setVisible(true);
                    } else {
                        new DashBoard().setVisible(true);
                    }
                    //caso não tenha consultas exclui o paciente e volta para a dashboard
                } else {
                    pdao.delete(paciente);
                    JOptionPane.showMessageDialog(null, "Paciente excluido com sucesso.");
                    new DashBoard().setVisible(true);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um Paciente para excluir");
        }

        System.out.println("Excluir Paciente");
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        System.out.println("Novo Medico");

        new AdicionaMedico().setVisible(true);
        dispose();

    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        if (tabelaMedico.getSelectedRow() != -1) {
            String nome = tabelaMedico.getValueAt(tabelaMedico.getSelectedRow(), 0).toString();
            String especialidade = tabelaMedico.getValueAt(tabelaMedico.getSelectedRow(), 1).toString();

            new EditaMedico(nome, especialidade).setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um Medico para editar");
        }

        System.out.println("Editar Medico");
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        if (tabelaMedico.getSelectedRow() != -1) {
            String nome = tabelaMedico.getValueAt(tabelaMedico.getSelectedRow(), 0).toString();
            String especialidade = tabelaMedico.getValueAt(tabelaMedico.getSelectedRow(), 1).toString();
            String id = null;

            Medico medico = new Medico(nome, especialidade);
            MedicoDao mdao = new MedicoDao();

            for (int i = 0; i < mdao.find().size(); i++) {
                String fnome = mdao.find().get(i).getNome();
                String fespecialidade = mdao.find().get(i).getEspecialidade();

                if ((fnome.equalsIgnoreCase(nome)) && (fespecialidade.equalsIgnoreCase(especialidade))) {
                    id = mdao.find().get(i).getId();
                }
            }
            ConsultaDao cdao = new ConsultaDao();
            ArrayList<Consulta> list = new ArrayList<>();
            dispose();
            int opt = JOptionPane.showConfirmDialog(this,
                    "Confirma exclusão do Medico?\nNome: " + nome
                    + "\nEspecialidade: " + especialidade,
                    "Exclusão do Medico", JOptionPane.YES_NO_OPTION);

            if (opt == 0) {
                //verifica se tem consultas relacionadas como medico
                for (int i = 0; i < cdao.find().size(); i++) {
                    if (cdao.find().get(i).getMedicoId().equalsIgnoreCase(id)) {
                        list.add(cdao.find().get(i));
                    }
                }
                //caso possua consulta pergunta se deseja excluir as consultas tambem
                if (list.size() > 0) {
                    confirmacao = JOptionPane.showConfirmDialog(this, "Esse medico possui "
                            + list.size() + " consulta(s).\nDeseja realmente excluilo?"
                            + "\nIsso removerá todas as consultas relacionadas a ele.",
                            "Exclusão do Medico", JOptionPane.YES_NO_OPTION);
                    //caso sim exclui todas as consultas relacionadas e o paciente tabem
                    if ((confirmacao == 0)) {
                        for (int i = 0; i < list.size(); i++) {
                            cdao.delete(list.get(i));
                        }
                        mdao.delete(medico);
                        JOptionPane.showMessageDialog(null, "Medico e Consultas relacionadas excluidos com sucesso.");
                        new DashBoard().setVisible(true);
                        //caso não volta para dashboard
                    } else {
                        new DashBoard().setVisible(true);
                    }
                    //caso não tenha consultas exclui o paciente e volta para a dashboard
                } else {
                    mdao.delete(medico);
                    JOptionPane.showMessageDialog(null, "Medico excluido com sucesso.");
                    new DashBoard().setVisible(true);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um Medico para excluir");
        }

        System.out.println("Excluir Medico");
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        new Start().setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        new Menssagem().sobre();
    }//GEN-LAST:event_jMenuItem2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel jpConsultas;
    private javax.swing.JPanel jpMedicos;
    private javax.swing.JPanel jpPacientes;
    private javax.swing.JTable tabelaConsulta;
    private javax.swing.JTable tabelaMedico;
    private javax.swing.JTable tabelaPaciente;
    // End of variables declaration//GEN-END:variables
}
