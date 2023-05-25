import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultCellEditor;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class Buscar {

    public static void sucursal(JPanel borraSucu, JTextField nom, JButton btn) {

        class ButtonRenderer extends JButton implements TableCellRenderer {
            public ButtonRenderer() {
                setOpaque(false);
            }

            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                    boolean hasFocus, int row, int column) {
                if (isSelected) {
                    setForeground(table.getSelectionForeground());
                    setBackground(table.getSelectionBackground());
                } else {
                    setForeground(table.getForeground());
                    setBackground(table.getBackground());
                }

                ImageIcon icon = new ImageIcon("src/papelera.png");
                setIcon(icon);
                return this;
            }
        }

        class ButtonEditor extends DefaultCellEditor {
            protected JButton button;
            private String label;
            private boolean isPushed;
            private JTable table;

            public ButtonEditor(JCheckBox checkBox, JTable table) {
                super(checkBox);
                this.table = table;
                button = new JButton();
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        int rowIndex = table.getSelectedRow();
                        String id = (String) table.getValueAt(rowIndex, 0);
                        eliminarRegistro(id);
                        borraSucu.revalidate();
                        borraSucu.repaint();
                        sucursal(borraSucu, nom, btn);
                        fireEditingStopped();
                    }
                });
            }

            public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
                    int column) {
                return button;
            }

            public Object getCellEditorValue() {
                if (isPushed) {
                    int rowIndex = table.getSelectedRow();
                    String id = (String) table.getValueAt(rowIndex, 0);
                    eliminarRegistro(id);
                    
                }
                isPushed = false;
                return label;
            }

            public boolean stopCellEditing() {
                isPushed = false;
                return super.stopCellEditing();
            }

            protected void fireEditingStopped() {
                super.fireEditingStopped();
            }
        }

        // Resto del código...

        if (!nom.getText().isBlank()) {
            Connection cnx = Conexion.conectar();
            borraSucu.removeAll();
            borraSucu.add(nom);
            borraSucu.add(btn);
            String[] columnNames = { "ID_SUCURSAL", "NOMBRE SUCURSAL", "DIRECCIÓN", "CP", "MUNICIPIO", "CIF", "CCC",
                    " " };
            DefaultTableModel model = new DefaultTableModel(columnNames, 0) {
                @Override
                public Class<?> getColumnClass(int columnIndex) {
                    return String.class;
                }

                @Override
                public boolean isCellEditable(int row, int column) {
                    return column == 1 || column == 2 || column == 3 || column == 4 || column == 5 || column == 6
                            || column == 7 || column == 8;
                }
            };

            JTable table = new JTable(model);
            table.setBackground(Color.white);

            JScrollPane scrollPane = new JScrollPane(table);
            scrollPane.setPreferredSize(new Dimension(1000, 400));

            borraSucu.add(scrollPane);

            String sql = "SELECT * FROM sucursal WHERE nombre like '%" + nom.getText() + "%' OR municipio like '%"
                    + nom.getText() + "%' OR direccion like '%" + nom.getText() + "%'";
            JButton btnEliminar = new JButton("Eliminar");

            try {
                java.sql.Statement sentencia = cnx.createStatement();
                ResultSet resultado = sentencia.executeQuery(sql);
                while (resultado.next()) {
                    String[] ln = new String[8];
                    ln[0] = resultado.getString(1);
                    ln[1] = resultado.getString(2);
                    ln[2] = resultado.getString(3);
                    ln[3] = resultado.getString(4);
                    ln[4] = resultado.getString(5);
                    ln[5] = resultado.getString(6);
                    ln[6] = resultado.getString(7);

                    btnEliminar.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {

                        }
                    });

                    Object[] row = new Object[9];
                    for (int i = 0; i < ln.length; i++) {
                        row[i] = ln[i];
                    }
                    row[8] = btnEliminar;
                    table.getColumnModel().getColumn(7).setCellRenderer(new ButtonRenderer());
                    table.getColumnModel().getColumn(7).setCellEditor(new ButtonEditor(new JCheckBox(), table));
                    model.addRow(row);
                }
            } catch (SQLException sqlE1) {
                sqlE1.printStackTrace();
            }

            table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            borraSucu.revalidate();
            borraSucu.repaint();
        } else {
            JOptionPane.showMessageDialog(null, "Debes introducir un valor.");
        }
    }

    public static void eliminarRegistro(String id) {
        // Aquí implementas la lógica para eliminar el registro con el ID proporcionado
        // Puedes utilizar una sentencia SQL DELETE o cualquier otro método de eliminación según tus necesidades

        // Ejemplo de eliminación utilizando una sentencia SQL DELETE:
        String sql = "DELETE FROM sucursal WHERE cod_sucursal = ?";

        try {
            Connection cnx = Conexion.conectar();
            PreparedStatement statement = cnx.prepareStatement(sql);
            statement.setString(1, id);
            int affectedRows = statement.executeUpdate();

            if (affectedRows > 0) {
                JOptionPane.showMessageDialog(null, "Registro eliminado correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo eliminar el registro");
            }

            statement.close();
            cnx.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
