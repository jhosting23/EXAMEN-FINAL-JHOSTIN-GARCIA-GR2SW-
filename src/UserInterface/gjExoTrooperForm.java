
package UserInterface;

import BusinessLogic.Entities.*;
import BusinessLogic.gjIABOT;
import DataAccess.gjDataFileHelper;
import Infrastructure.gjCMD;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class gjExoTrooperForm extends JFrame {
    private JComboBox<String> gjCbxTipoExobot;
    private JTable gjTable;
    private DefaultTableModel gjTableModel;
    private JButton gjBtnAgregar;
    private JButton gjBtnBuscar;
    private JButton gjBtnEntrenar;
    private JButton gjBtnAccion;

    
    private List<gjExobot> gjExobotList;
    private TableRowSorter<DefaultTableModel> gjSorter;

    public gjExoTrooperForm() {
        gjExobotList = new ArrayList<>();

        setTitle("ExoTrooper");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

       
        JPanel gjTopPanel = new JPanel();
        gjTopPanel.setLayout(new BoxLayout(gjTopPanel, BoxLayout.Y_AXIS));
        gjTopPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));

        JLabel gjLblHeader = new JLabel("Alumno(s):");
        gjLblHeader.setFont(new Font("SansSerif", Font.BOLD, 14));
        gjTopPanel.add(gjLblHeader);

        JPanel gjStudentInfoPanel = new JPanel(new GridLayout(2, 2));
        gjStudentInfoPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        gjStudentInfoPanel.setBackground(Color.WHITE);
       
        gjStudentInfoPanel.add(new JLabel("  1750750018"));
        gjStudentInfoPanel.add(new JLabel("Jhostin Alejandro Garcia Chica "));
        gjStudentInfoPanel.add(new JLabel("  Cédula "));
        gjStudentInfoPanel.add(new JLabel("Nombre "));
        gjTopPanel.add(gjStudentInfoPanel);

        add(gjTopPanel, BorderLayout.NORTH);

        
        JPanel gjCenterPanel = new JPanel(new BorderLayout(5, 5));
        gjCenterPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));

        // Controls: Combo | Agregar | Buscar
        JPanel gjControlPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));

        gjCbxTipoExobot = new JComboBox<>(new String[] {
                "ExoAsalto", "ExoExplorador", "ExoInfanteria", "ExoMedico", "ExoComando"
        });
        gjCbxTipoExobot.setPreferredSize(new Dimension(120, 30));

        gjBtnAgregar = new JButton("Agregar");
        gjBtnAgregar.setBackground(new Color(220, 220, 220)); // Light Gray

        gjBtnBuscar = new JButton("Buscar");
        gjBtnBuscar.setBackground(Color.WHITE);

        gjControlPanel.add(gjCbxTipoExobot);
        gjControlPanel.add(gjBtnAgregar);
        gjControlPanel.add(gjBtnBuscar);

        gjCenterPanel.add(gjControlPanel, BorderLayout.NORTH);

        // tabla
        String[] gjColNames = { "IdExobot", "TipoExobot", "Entreno", "No. Accion" };
        gjTableModel = new DefaultTableModel(gjColNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        gjTable = new JTable(gjTableModel);
        gjTable.setRowHeight(25);

        
        JTableHeader gjHeader = gjTable.getTableHeader();
        gjHeader.setBackground(new Color(2, 48, 32)); //verde oscuro 
        gjHeader.setForeground(Color.WHITE);
        gjHeader.setFont(new Font("SansSerif", Font.BOLD, 12));

        gjSorter = new TableRowSorter<>(gjTableModel);
        gjTable.setRowSorter(gjSorter);

        gjCenterPanel.add(new JScrollPane(gjTable), BorderLayout.CENTER);

        add(gjCenterPanel, BorderLayout.CENTER);

        // --- BOTTOM PANEL: Actions ---
        JPanel gjBottomPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        gjBottomPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        gjBtnEntrenar = new JButton("Entrenar \"AcciónArma\"");
        gjBtnAccion = new JButton("\"Acción_TipoArma\"");

        gjBottomPanel.add(gjBtnEntrenar);
        gjBottomPanel.add(gjBtnAccion);

        add(gjBottomPanel, BorderLayout.SOUTH);

        // --- EVENT LISTENERS ---
        gjBtnAgregar.addActionListener(e -> gjHandleAgregar());
        gjBtnEntrenar.addActionListener(e -> gjHandleEntrenar());
        gjBtnAccion.addActionListener(e -> gjHandleAccion());
        gjBtnBuscar.addActionListener(e -> gjHandleBuscar());
    }

    private void gjHandleAgregar() {
        String gjSelected = (String) gjCbxTipoExobot.getSelectedItem();
        gjExobot gjNewBot;

        switch (gjSelected) {
            case "ExoAsalto":
                gjNewBot = new gjExoAsalto();
                break;
            case "ExoExplorador":
                gjNewBot = new gjExoExplorador();
                break;
            case "ExoInfanteria":
                gjNewBot = new gjExoInfanteria();
                break;
            case "ExoMedico":
                gjNewBot = new gjExoMedico();
                break;
            case "ExoComando":
                gjNewBot = new gjExoComando();
                break;
            default:
                gjNewBot = new gjExoAsalto();
        }

        gjNewBot.gjSetIdExobot(gjExobotList.size() + 1);
        gjExobotList.add(gjNewBot);

        gjTableModel.addRow(new Object[] {
                gjNewBot.gjGetIdExobot(),
                gjNewBot.gjGetTipoExobot(),
                "NO",
                "0"
        });
    }

    private gjExobot gjGetSelectedBot() {
        int gjRow = gjTable.getSelectedRow();
        if (gjRow != -1) {

            int gjModelRow = gjTable.convertRowIndexToModel(gjRow);

            int gjId = (int) gjTableModel.getValueAt(gjModelRow, 0);
            return gjExobotList.stream().filter(b -> b.gjGetIdExobot() == gjId).findFirst().orElse(null);
        }
        return null;
    }

    private void gjHandleEntrenar() {
        gjExobot gjCurrentBot = gjGetSelectedBot();
        if (gjCurrentBot != null) {

            gjSoldadoExperto gjSoldado = new gjSoldadoExperto(
                    "SoldadoExperto-" + gjCurrentBot.gjGetArmaNombre().split("/")[0]);
            new gjIABOT().gjEntrenar(gjCurrentBot, gjSoldado);

            gjUpdateTableRow(gjCurrentBot);

            String gjLog = "GOOD : " + gjSoldado.gjGetNombre() + " " + gjCurrentBot.gjGetArmaNombre() + " "
                    + gjCurrentBot.gjRealizarAccion();
            gjCMD.gjImprimir(gjLog);
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un Exobot de la tabla.");
        }
    }

    private void gjHandleAccion() {
        gjExobot gjCurrentBot = gjGetSelectedBot();

        if (gjCurrentBot != null) {
            if (gjCurrentBot.gjIsEntrenado()) {
                String gjMunicion = gjDataFileHelper.gjBuscarMunicion(gjCurrentBot.gjGetArmaNombre());
                gjCurrentBot.gjIncrementarAccion();

                gjUpdateTableRow(gjCurrentBot);

                String gjLog = "GOOD : " + gjCurrentBot.gjGetArmaNombre() + " " + gjCurrentBot.gjRealizarAccion() + " "
                        + (gjMunicion != null ? gjMunicion : "No Municion");
                gjCMD.gjImprimir(gjLog);
            } else {
                String gjLog = "ERROR: " + gjCurrentBot.gjGetTipoExobot() + " No Entrenado.";
                gjCMD.gjImprimir(gjLog);
                JOptionPane.showMessageDialog(this, "El Exobot no está entrenado.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un Exobot de la tabla.");
        }
    }

    private void gjUpdateTableRow(gjExobot gjBot) {
        for (int i = 0; i < gjTableModel.getRowCount(); i++) {
            int gjId = (int) gjTableModel.getValueAt(i, 0);
            if (gjId == gjBot.gjGetIdExobot()) {
                gjTableModel.setValueAt(gjBot.gjIsEntrenado() ? "SI" : "NO", i, 2);
                gjTableModel.setValueAt(gjBot.gjGetNumeroAccion(), i, 3);
                break;
            }
        }
    }

    private void gjHandleBuscar() {
        String gjSelected = (String) gjCbxTipoExobot.getSelectedItem();
        if (gjSelected != null && !gjSelected.isEmpty()) {
            gjSorter.setRowFilter(RowFilter.regexFilter(gjSelected, 1));
        } else {
            gjSorter.setRowFilter(null);
        }
    }
}
