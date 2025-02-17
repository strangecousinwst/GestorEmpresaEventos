package myutils;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

/**
 *
 * @author joao
 */
public class TableFormatter {
    
    private static final Color HEADER_BACKGROUND = new Color(51, 51, 51);
    private static final Color HEADER_FOREGROUND = Color.WHITE;
    private static final Font HEADER_FONT = new Font("Arial", Font.BOLD, 12);
    private static final Font CELL_FONT = new Font("Arial", Font.PLAIN, 12);
    
    /**
     * Makes a table read-only and applies consistent formatting.
     * @param table The JTable to format
     */
    public static void formatTable(JTable table) {
        makeTableReadOnly(table);
        formatTableHeader(table);
        formatTableCells(table);
        adjustColumnWidths(table);
    }
    
    private static void makeTableReadOnly(JTable table) {
        table.setModel(new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Makes all cells read-only
            }
        });
    }
    
    private static void formatTableHeader(JTable table) {
        JTableHeader header = table.getTableHeader();
        header.setBackground(HEADER_BACKGROUND);
        header.setForeground(HEADER_FOREGROUND);
        header.setFont(HEADER_FONT);
        header.setReorderingAllowed(false); // Prevent column reordering
    }
    
    private static void formatTableCells(JTable table) {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        
        for (int i = 0; i < table.getColumnCount(); i++) {
            TableColumn column = table.getColumnModel().getColumn(i);
            column.setCellRenderer(centerRenderer);
        }
        
        table.setFont(CELL_FONT);
        table.setRowHeight(25); // Consistent row height
        table.setShowGrid(true);
        table.setGridColor(Color.LIGHT_GRAY);
    }
    
    private static void adjustColumnWidths(JTable table) {
        for (int column = 0; column < table.getColumnCount(); column++) {
            TableColumn tableColumn = table.getColumnModel().getColumn(column);
            int preferredWidth = tableColumn.getMinWidth();
            int maxWidth = tableColumn.getMaxWidth();
 
            for (int row = 0; row < table.getRowCount(); row++) {
                java.awt.Component comp = table.prepareRenderer(
                        table.getCellRenderer(row, column), row, column);
                preferredWidth = Math.max(comp.getPreferredSize().width + 20, preferredWidth);
            }
 
            preferredWidth = Math.min(maxWidth, preferredWidth);
            tableColumn.setPreferredWidth(preferredWidth);
        }
    }
    
}
