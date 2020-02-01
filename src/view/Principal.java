package view;

import controller.SerialRxTx;
import dao.JavaConnect;
import gnu.io.SerialPortEvent;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Principal extends javax.swing.JFrame {

    private SerialRxTx serialRxTx;

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    String porta = "";
    String btUm = "";
    String btDois = "";
    boolean backuping = false;
    DefaultListModel dL = new DefaultListModel();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public Principal() {
        initComponents();
        setLocationRelativeTo(null);
        serialRxTx = new SerialRxTx();
        listPortas.addItem("Escolha");
        List<String> listaPortas = new ArrayList<>();
        try {
            listaPortas = serialRxTx.listaPortas();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        listaPortas.forEach((String listaPorta) -> {
            listPortas.addItem(listaPorta);
        });
        getConfig();
        if (listPortas.getModel().getSize() > 0) {
            // serialRxTx = new SerialRxTx2(listPortas.getModel().getSelectedItem().toString());
            if (!listPortas.getModel().getSelectedItem().equals("Escolha")) {
                 conectarArduino();
            }
        }
        
        btInfo.addActionListener(((e) -> {
             new Info().setVisible(true);
        }));

        listaLogs.setModel(dL);
        ListBT1.addActionListener((ActionEvent e) -> {
            if (ListBT1.getSelectedIndex() == 0) {
                ListBT2.setSelectedIndex(1);
            } else {
                ListBT2.setSelectedIndex(0);
            }
        });
        
        checkHabilitaHora.addActionListener((ActionEvent e) -> {
            if(checkHabilitaHora.isSelected()){
                
                habilitaHora(true);
            }else{
                 habilitaHora(false);
                 
            }
        });

        ListBT2.addActionListener((ActionEvent e) -> {
            if (ListBT2.getSelectedIndex() == 0) {
                ListBT1.setSelectedIndex(1);
            } else {
                ListBT1.setSelectedIndex(0);
            }
        });

        spinHora.setMaximum(23);
        spinMinuto.setMaximum(59);
        spinSegundo.setMaximum(59);

        setSpinnerHora();

        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent winEvt) {
                serialRxTx.close();
                System.exit(0);
            }
        });

        btBloquearBts.addActionListener((ActionEvent e) -> {
            if(serialRxTx.getSerialPort()!=null){
            if (btBloquearBts.isSelected()) {
                btBloquearBts.setText("Desbloquear Botões");
                serialRxTx.sendData("01C");
            } else {
                btBloquearBts.setText("Bloquear Botões");
                serialRxTx.sendData("02C");
            }
            }else{
                JOptionPane.showMessageDialog(null, "Modulo não conectado!");
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabs = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        checkSaida = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        checkEntrada = new javax.swing.JCheckBox();
        dtFim = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        dtInicio = new com.toedter.calendar.JDateChooser();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaLogs = new javax.swing.JTable();
        btPesquisa = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        spinMFimPesquisa = new com.toedter.components.JSpinField();
        jLabel2 = new javax.swing.JLabel();
        spinHFimPesquisa = new com.toedter.components.JSpinField();
        spinMIniPesquisa = new com.toedter.components.JSpinField();
        jLabel1 = new javax.swing.JLabel();
        spinHIniPesquisa = new com.toedter.components.JSpinField();
        checkHabilitaHora = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        BtGetLogs = new javax.swing.JButton();
        btApagaLogs = new javax.swing.JButton();
        btBloquearBts = new javax.swing.JToggleButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        listPortas = new javax.swing.JComboBox<>();
        btConectar = new javax.swing.JButton();
        btSalvarSistema = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        ListBT1 = new javax.swing.JComboBox();
        ListBT2 = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        btDesconectar = new javax.swing.JButton();
        btCarregarLista = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        checkDelete = new javax.swing.JComboBox<>();
        btLimparLogs = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        dataHardware = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        spinSegundo = new com.toedter.components.JSpinField();
        spinHora = new com.toedter.components.JSpinField();
        spinMinuto = new com.toedter.components.JSpinField();
        btSalvarHardware = new javax.swing.JButton();
        labelStatus = new javax.swing.JLabel();
        labelFixoStatus = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaLogs = new javax.swing.JList<>();
        habLogs = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        btSair = new javax.swing.JButton();
        btInfo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DataLogger");

        tabs.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tabs.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tabsStateChanged(evt);
            }
        });

        checkSaida.setText("Saida");

        jLabel4.setText("Data Fim");

        checkEntrada.setText("Entrada");

        jLabel3.setText("Data Inicio");

        tabelaLogs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "DATA", "HORA", "STATUS"
            }
        ));
        jScrollPane2.setViewportView(tabelaLogs);

        btPesquisa.setText("Pesquisar");
        btPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisaActionPerformed(evt);
            }
        });

        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        spinMFimPesquisa.setEnabled(false);
        spinMFimPesquisa.setValue(-1);

        jLabel2.setText("Hora Fim");

        spinHFimPesquisa.setEnabled(false);
        spinHFimPesquisa.setValue(-1);
        spinHFimPesquisa.setVerifyInputWhenFocusTarget(false);

        spinMIniPesquisa.setEnabled(false);
        spinMIniPesquisa.setValue(-1);

        jLabel1.setText("Hora Inicio");

        spinHIniPesquisa.setEnabled(false);
        spinHIniPesquisa.setValue(-1);

        checkHabilitaHora.setText("Habilitar pesquisa por Hora");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(checkHabilitaHora)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(spinHIniPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spinMIniPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(spinHFimPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)
                                .addComponent(spinMFimPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2))
                        .addGap(45, 45, 45))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addComponent(checkHabilitaHora)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 4, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spinHFimPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spinMFimPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spinMIniPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spinHIniPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(checkEntrada)
                        .addGap(18, 18, 18)
                        .addComponent(checkSaida)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dtInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(dtFim, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(142, 142, 142))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkEntrada)
                    .addComponent(checkSaida))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dtInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dtFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btPesquisa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        tabs.addTab("Pesquisa", jPanel2);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Logs Hardware"));

        BtGetLogs.setText("Backup De Logs");
        BtGetLogs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtGetLogsActionPerformed(evt);
            }
        });

        btApagaLogs.setText("Apagar Logs");
        btApagaLogs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btApagaLogsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BtGetLogs, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btApagaLogs, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtGetLogs)
                    .addComponent(btApagaLogs))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        btBloquearBts.setText("Bloquear Botões");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(btBloquearBts, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(207, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btBloquearBts)
                .addContainerGap(409, Short.MAX_VALUE))
        );

        tabs.addTab("Funções", jPanel1);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Sistema"));

        jLabel6.setText("Porta");

        btConectar.setText("conectar");
        btConectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConectarActionPerformed(evt);
            }
        });

        btSalvarSistema.setText("Salvar");
        btSalvarSistema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarSistemaActionPerformed(evt);
            }
        });

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Botões"));

        ListBT1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SAIDA", "ENTRADA" }));
        ListBT1.setSelectedIndex(1);

        ListBT2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SAIDA", "ENTRADA" }));

        jLabel12.setText("BOTÃO 1");

        jLabel13.setText("BOTÃO 2");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ListBT1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(ListBT2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ListBT1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ListBT2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(129, 129, 129))
        );

        btDesconectar.setText("Desconectar");
        btDesconectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDesconectarActionPerformed(evt);
            }
        });

        btCarregarLista.setText("Carregar");
        btCarregarLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCarregarListaActionPerformed(evt);
            }
        });

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Banco de Dados"));

        checkDelete.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Apagar Hoje", "Manter Mês Atual", "Manter 3 ultimos Mêses", "Limpar Tudo" }));

        btLimparLogs.setText("Limpar Logs");
        btLimparLogs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimparLogsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(checkDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btLimparLogs)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btLimparLogs))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btSalvarSistema, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(113, 113, 113))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(listPortas, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btCarregarLista)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btConectar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btDesconectar)
                        .addGap(0, 25, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(listPortas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btConectar)
                    .addComponent(btDesconectar)
                    .addComponent(btCarregarLista))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btSalvarSistema))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Hardware"));

        dataHardware.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jLabel8.setText("Data");

        jLabel9.setText("Hora");

        jLabel10.setText("Minuto");

        jLabel11.setText("Segundo");

        btSalvarHardware.setText("Enviar");
        btSalvarHardware.setToolTipText("");
        btSalvarHardware.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarHardwareActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(spinHora, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(57, 57, 57)))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(spinMinuto, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(spinSegundo, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btSalvarHardware, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel11)))
                    .addComponent(jLabel8)
                    .addComponent(dataHardware, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dataHardware, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spinHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(spinSegundo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spinMinuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(34, 34, 34))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btSalvarHardware)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71))
        );

        tabs.addTab("Configurações", jPanel4);

        labelStatus.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelStatus.setText("DESCONECTADO");

        labelFixoStatus.setText("Status: ");

        listaLogs.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(listaLogs);

        habLogs.setSelected(true);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("LOGS");

        btSair.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btSair.setText("X");
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });

        btInfo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btInfo.setText("?");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(tabs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(labelFixoStatus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelStatus)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(habLogs)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btSair)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btInfo)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelFixoStatus)
                            .addComponent(labelStatus))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tabs, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(habLogs)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(jLabel5))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(btSair, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btInfo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisaActionPerformed
        pesquisa();
    }//GEN-LAST:event_btPesquisaActionPerformed

    private void BtGetLogsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtGetLogsActionPerformed
       if(serialRxTx.getSerialPort()!=null){
            backuping = true;
            serialRxTx.sendData("06C");
       }else{
           JOptionPane.showMessageDialog(null, "Modulo não conectado!");
       }
    }//GEN-LAST:event_BtGetLogsActionPerformed

    private void btApagaLogsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btApagaLogsActionPerformed
        if(serialRxTx.getSerialPort()!=null){
            serialRxTx.sendData("07C");
        }else{
           JOptionPane.showMessageDialog(null, "Modulo não conectado!");
       }
    }//GEN-LAST:event_btApagaLogsActionPerformed

    private void btConectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConectarActionPerformed
        if(serialRxTx.serialPort==null)
            conectarArduino();
    }//GEN-LAST:event_btConectarActionPerformed

    private void btSalvarSistemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarSistemaActionPerformed
        if (!listPortas.getModel().getSelectedItem().equals("Escolha")) {

            String sql = "update configuracao set portaCom = ? , btUm = ? , btDois = ?";

            try {
                conn = JavaConnect.ConnectDb();
                pst = conn.prepareStatement(sql);
                pst.setString(1, listPortas.getModel().getSelectedItem().toString());
                pst.setString(2, ListBT1.getSelectedIndex() == 0 ? "0" : "1");
                pst.setString(3, ListBT2.getSelectedIndex() == 0 ? "0" : "1");
                pst.execute();
                JOptionPane.showMessageDialog(null, "Salvo com sucesso");
                try {
                    pst.close();
                    conn.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            } catch (HeadlessException | SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma Porta");
        }
    }//GEN-LAST:event_btSalvarSistemaActionPerformed

    private void btDesconectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDesconectarActionPerformed
        if (serialRxTx != null) {
            serialRxTx.close();
            labelStatus.setText("DESCONECTADO");
        }
    }//GEN-LAST:event_btDesconectarActionPerformed

    private void btSalvarHardwareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarHardwareActionPerformed
        if(serialRxTx.getSerialPort()!=null){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String dataHard = sdf.format(dataHardware.getCalendar().getTime());
        String horaHard = spinHora.getValue() + ":" + spinMinuto.getValue() + ":" + spinSegundo.getValue();
        String setDataTime = "03C" + dataHard + "-" + horaHard;
        serialRxTx.sendData(setDataTime);
        }else{
            JOptionPane.showMessageDialog(null, "Modulo não conectado!");
        }
    }//GEN-LAST:event_btSalvarHardwareActionPerformed

    private void tabsStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tabsStateChanged
        if (tabs.getSelectedIndex() == 2) {
            // setSpinnerHora();
        }
    }//GEN-LAST:event_tabsStateChanged

    private void btLimparLogsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimparLogsActionPerformed
        limparLogs();
    }//GEN-LAST:event_btLimparLogsActionPerformed

    private void btCarregarListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCarregarListaActionPerformed
        listarPorta();
    }//GEN-LAST:event_btCarregarListaActionPerformed

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
       new Login().setVisible(true);
       this.dispose();
    }//GEN-LAST:event_btSairActionPerformed

    private void getConfig() {
        String sql = "select * from configuracao";
        try {
            conn = JavaConnect.ConnectDb();
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                porta = rs.getString("portaCom");
                btUm = rs.getString("btUm");
                btDois = rs.getString("btDois");

                for (int X = 0; X < listPortas.getModel().getSize(); X++) {
                    if (listPortas.getModel().getElementAt(X).equals(porta)) {
                        listPortas.getModel().setSelectedItem(listPortas.getModel().getElementAt(X));
                    }
                }

                ListBT1.getModel().setSelectedItem(ListBT2.getModel().getElementAt(Integer.parseInt(btUm)));
                ListBT2.getModel().setSelectedItem(ListBT2.getModel().getElementAt(Integer.parseInt(btDois)));

                try {
                    pst.close();
                    conn.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Config nao localizada");
            }
        } catch (HeadlessException | NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(null, "--" + e);
        }
    }

    public void setSpinnerHora() {
        Calendar c = Calendar.getInstance();

        int h = c.get(Calendar.HOUR_OF_DAY);
        int m = c.get(Calendar.MINUTE);
        int s = c.get(Calendar.SECOND);

        dataHardware.setDate(c.getTime());

        spinHora.setValue(h);
        spinMinuto.setValue(m);
        spinSegundo.setValue(s);
    }

    public void conectarArduino() {
        serialRxTx = new SerialRxTx(listPortas.getModel().getSelectedItem().toString());
        if (serialRxTx.serialPort != null) {
            labelStatus.setText("CONECTADO");
            serialRxTx.addListener((SerialPortEvent spe) -> {
                try {
                    String leitura = serialRxTx.leitura(spe);

                    //   >info,105,n,24/8/2019,15:24:21,1,23
                    if (leitura != null && !leitura.isEmpty() && !leitura.equals("x-close")) {

                        String dados[] = leitura.split(",");
                        if (dados[0].substring(0, 1).equals(">")) {
                            String tipo = dados[0].substring(1);
                            if (tipo.equals("info")) {

                                if (dados[1].equals("1")) {
                                    JOptionPane.showMessageDialog(null, "Bloqueado");
                                } else if (dados[1].equals("7")) {
                                    JOptionPane.showMessageDialog(null, "Logs apagado");
                                } else if (dados[1].equals("106")) {
                                    JOptionPane.showMessageDialog(null, dados[2]);
                                } else if (dados[1].equals("2")) {
                                    JOptionPane.showMessageDialog(null, "Desbloqueado");
                                } else if (dados[1].equals("3")) {
                                    JOptionPane.showMessageDialog(null, "Data atualizada");
                                } else if (dados[1].equals("101")) {
                                    JOptionPane.showMessageDialog(null, "SD pronto");
                                } else //se o retorno for confirmação que ultimo log foi salvo no arduino e ainda está com flag backup
                                if (dados[1].equals("4") && backuping) {
                                    serialRxTx.sendData("06C");//solicita o ultimo log não salvo
                                } else //se retorno for o ultimo log não salvo e estiver com flag backup
                                if (dados[1].equals("105") && backuping) {
                                    if (salvaBackup(dados[3], dados[4], dados[5])) {//salva os dados no banco de dados
                                        serialRxTx.sendData("04C" + dados[6]);//solicita ao arduino para confirmar o salvamento do log no SD
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Erro ao salvar log");
                                        backuping = false;
                                    }
                                }

                            } else if (tipo.equals("erro")) {
                                //SD não encontrado
                                if (dados[1].equals("101")) {
                                    JOptionPane.showMessageDialog(null, dados[2]);
                                } else //Erro ao sincronizar com RTC
                                if (dados[1].equals("102")) {
                                    JOptionPane.showMessageDialog(null, dados[2]);
                                } else //Parametro invalido
                                if (dados[1].equals("103")) {
                                    JOptionPane.showMessageDialog(null, dados[2]);
                                } else if (dados[1].equals("7")) {
                                    JOptionPane.showMessageDialog(null, "Erro ao apagar logs");
                                } else if (dados[1].equals("3")) {
                                    JOptionPane.showMessageDialog(null, "Erro ao atualizar Data");
                                }

                            } else if (tipo.equals("response")) {
                                System.out.println("tipo erro");
                            }

                            /*if(backuping && !dados[1].equals("fim")){
                            dados = dados[1].split(",");
                            String dt=dados[0];
                            String hr=dados[1];
                            String bt=dados[2];
                            
                            salvaBackup(dt,hr,bt);
                            }else{
                            backuping = false;
                            }*/
                        }

                        if (habLogs.isSelected()) {
                            dL.addElement(leitura);
                        }

                    } else if (leitura != null && !leitura.isEmpty() && leitura.equals("x-close")) {
                        labelStatus.setText("DESCONECTADO");
                    }

                } catch (HeadlessException e) {
                }
            });

        } else {
            labelStatus.setText("FALHA");
        }
    }

     public boolean salvaBackup(String data, String hora, String bt) {
        String sql = "insert into logs (data, hora, status) values (?,?,?)";

        try {
            conn = JavaConnect.ConnectDb();
            pst = conn.prepareStatement(sql);
            pst.setString(1, data);
            pst.setString(2, hora);

            pst.setString(3, bt);
            pst.execute();

            try {
                pst.close();
                conn.close();
                return true;
            } catch (SQLException e) {
                return false;
            }
        } catch (SQLException e) {
            return false;
        }
    }
     
    public void listarPorta() {
        listPortas.removeAllItems();
        listPortas.addItem("Escolha");
        List<String> listaPortas = serialRxTx.listaPortas();
        listaPortas.forEach((listaPorta) -> {
            listPortas.addItem(listaPorta);
        });
    }

    public void pesquisa() {

        
        boolean verificado = true;
        String dataInicio = "";
        String dataFim = "";
        String entrada = checkEntrada.isSelected() ? "1" : "";
        String saida = checkSaida.isSelected() ? "2" : "";
        
        String hInicio =String.valueOf(spinHIniPesquisa.getValue()) + ":" + String.valueOf(spinMIniPesquisa.getValue());
        String hFim =String.valueOf(spinHFimPesquisa.getValue()) + ":" + String.valueOf(spinMFimPesquisa.getValue());
        
      
       
        

        if (dtInicio.getCalendar() != null) {
            dataInicio = sdf.format(dtInicio.getCalendar().getTime());
        } else {
            verificado = false;
        }

        if (dtFim.getCalendar() != null) {
            dataFim = sdf.format(dtFim.getCalendar().getTime());
        } else {
            verificado = false;
        }

        String sql = "select * from logs ";
        String aux = "";
        String cond1 = "";
        boolean temWhere = false;

        if (verificado) {
            temWhere = true;
            aux += " where data BETWEEN '" + dataInicio + "' AND '" + dataFim + "' ";
        }

        if (checkEntrada.isSelected()) {
            if (!aux.isEmpty()) {
                aux += "AND status = 1 ";
            } else {
                aux += "where status = 1 ";
                temWhere = true;
            }
        }

        if (checkSaida.isSelected()) {
            if (!aux.isEmpty()) {
                if (checkEntrada.isSelected()) {
                    aux += "OR status = 2 ";
                } else {
                    aux += "AND status = 2 ";
                }
            } else {
                aux += "where status = 2 ";
                temWhere = true;
            }
        }

        String sqlFinal = sql + aux;

        
        
        if(checkHabilitaHora.isSelected()){
            String auxS = "";
            if(temWhere){
                auxS = " AND ";
            }else{
                auxS = " WHERE ";
            }
 
            
            sqlFinal += auxS + "hora BETWEEN '" + hInicio + ":59' AND '" + hFim + ":59' ";
          
            System.out.println("hab - "+sqlFinal);
 
        }
        
        //sqlFinal += "order by " + listaFiltro.getSelectedItem().toString() + " " + (listaOrdem.getSelectedItem().toString().equals("Crescente") ? "asc" : "desc");
        sqlFinal += "order by data DESC,hora DESC";
        try {
            conn = JavaConnect.ConnectDb();
            pst = conn.prepareStatement(sqlFinal);
            rs = pst.executeQuery();
            DefaultTableModel modeloTabela = (DefaultTableModel) tabelaLogs.getModel();
            modeloTabela.getDataVector().removeAllElements();

            int linha = 0;

            while (rs.next()) {
                String dat[] = rs.getString("data").split("-");

                 modeloTabela.addRow(new String[modeloTabela.getColumnCount()]);
                tabelaLogs.setValueAt(rs.getString("id"), linha, 0);
                tabelaLogs.setValueAt(dat[2]+"/"+dat[1]+"/"+dat[0], linha, 1);
                tabelaLogs.setValueAt(rs.getString("hora"), linha, 2);
                tabelaLogs.setValueAt(rs.getString("status").equals("1") ? "Entrada" : "Saida", linha, 3);
                linha++;
            }
            
            System.out.println(sqlFinal);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

        try {
            pst.close();
            conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public void limparLogs(){
        int tipo = checkDelete.getSelectedIndex();
        String sql = "DELETE from logs WHERE data ";
        
        Calendar cHoje = Calendar.getInstance();
        String dtHoje = sdf.format(cHoje.getTime());
        
        Calendar inicio = Calendar.getInstance();
        inicio.set(Calendar.HOUR_OF_DAY, 0);
        inicio.set(Calendar.MINUTE, 0);
        inicio.set(Calendar.SECOND, 0);
        String Cinicio = sdf.format(inicio.getTime());
       
        switch(tipo){
            case 0:
                sql += "BETWEEN '" + Cinicio + "' AND '" + dtHoje + "'";  
                System.out.println(sql);
                executaDelete(sql);
                break;
                
            case 1:
                String m1 = cHoje.get(Calendar.MONTH) < 10 ? "0".concat(String.valueOf(cHoje.get(Calendar.MONTH)+1)):String.valueOf(cHoje.get(Calendar.MONTH)+1);
                String dt1 = String.valueOf(cHoje.get(Calendar.YEAR)) + "-" + m1 ;
                sql += "NOT BETWEEN '" + dt1 + "-01' AND '" + dtHoje + "'" ;
                System.out.println(sql);
                executaDelete(sql);
                break;
            
            case 2:   
                inicio.add(Calendar.MONTH, -3);  
                String m2 = inicio.get(Calendar.MONTH) < 10 ? "0".concat(String.valueOf(inicio.get(Calendar.MONTH)+1)):String.valueOf(inicio.get(Calendar.MONTH)+1);
                String dt2 = String.valueOf(inicio.get(Calendar.YEAR)) + "-"+m2  ;
                sql += "NOT BETWEEN '" + dt2 + "-01' AND '" + dtHoje + "'" ;
                System.out.println(sql);
                executaDelete(sql);
                break;
                
            case 3:
                 sql = "DELETE from logs";
                 System.out.println(sql);
                 executaDelete(sql);
                break;
        }
        
        
    }
    
    
    public void executaDelete(String sql){
         try {
            conn = JavaConnect.ConnectDb();
            pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Excluido");         
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

        try {
            pst.close();
            conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    
    public void habilitaHora(Boolean status){
        spinHIniPesquisa.setEnabled(status);
        spinMIniPesquisa.setEnabled(status);
        
        spinHFimPesquisa.setEnabled(status);
        spinMFimPesquisa.setEnabled(status);
    }
    
   // DELETE from logs WHERE data BETWEEN date('2019-09-07') AND date('2019-09-07') AND CAST(hora as time) BETWEEN "0:0:0" and "17:10:28"

    
    public String converteHora(Calendar c){
      
        int hIni=c.get(Calendar.HOUR_OF_DAY);
        int mIni=c.get(Calendar.MINUTE);
        int sIni=c.get(Calendar.SECOND);

        String h1 =  (hIni<10?"0".concat(String.valueOf(hIni)):String.valueOf(hIni));
        String m1 =  (mIni<10?"0".concat(String.valueOf(mIni)):String.valueOf(mIni));
        String s1 =  (sIni<10?"0".concat(String.valueOf(sIni)):String.valueOf(sIni));

        String h = h1+":"+m1+":"+s1;
        return h; 
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtGetLogs;
    private javax.swing.JComboBox ListBT1;
    private javax.swing.JComboBox ListBT2;
    private javax.swing.JButton btApagaLogs;
    private javax.swing.JToggleButton btBloquearBts;
    private javax.swing.JButton btCarregarLista;
    private javax.swing.JButton btConectar;
    private javax.swing.JButton btDesconectar;
    private javax.swing.JButton btInfo;
    private javax.swing.JButton btLimparLogs;
    private javax.swing.JButton btPesquisa;
    private javax.swing.JButton btSair;
    private javax.swing.JButton btSalvarHardware;
    private javax.swing.JButton btSalvarSistema;
    private javax.swing.JComboBox<String> checkDelete;
    private javax.swing.JCheckBox checkEntrada;
    private javax.swing.JCheckBox checkHabilitaHora;
    private javax.swing.JCheckBox checkSaida;
    private com.toedter.calendar.JDateChooser dataHardware;
    private com.toedter.calendar.JDateChooser dtFim;
    private com.toedter.calendar.JDateChooser dtInicio;
    private javax.swing.JCheckBox habLogs;
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
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelFixoStatus;
    private javax.swing.JLabel labelStatus;
    private javax.swing.JComboBox<String> listPortas;
    private javax.swing.JList<String> listaLogs;
    private com.toedter.components.JSpinField spinHFimPesquisa;
    private com.toedter.components.JSpinField spinHIniPesquisa;
    private com.toedter.components.JSpinField spinHora;
    private com.toedter.components.JSpinField spinMFimPesquisa;
    private com.toedter.components.JSpinField spinMIniPesquisa;
    private com.toedter.components.JSpinField spinMinuto;
    private com.toedter.components.JSpinField spinSegundo;
    private javax.swing.JTable tabelaLogs;
    private javax.swing.JTabbedPane tabs;
    // End of variables declaration//GEN-END:variables
}
