package myutils;

import java.security.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import java.sql.*;

/**
 *
 * @author joao
 */
public class TableModelBuilder {
    private static final class Column {
        private final String name;
        private final Class<?> type;

        public Column(String name, Class<?> type) {
            this.name = name;
            this.type = type;
        }
    }

    private final List<Column> columns = new ArrayList<>();
    private final List<List<Object>> rows = new ArrayList<>();

    public DefaultTableModel buildTableModel(ResultSet resultSet) throws SQLException {
        extractMetadata(resultSet);
        extractData(resultSet);
        return createTableModel();
    }

    private void extractMetadata(ResultSet resultSet) throws SQLException {
        ResultSetMetaData metaData = resultSet.getMetaData();
        for (int col = 1; col <= metaData.getColumnCount(); col++) {
            String columnName = formatColumnName(metaData.getColumnName(col));
            Class<?> columnType = mapSqlTypeToJava(metaData.getColumnType(col));
            columns.add(new Column(columnName, columnType));
        }
    }

    private void extractData(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            List<Object> row = new ArrayList<>();
            for (int col = 1; col <= columns.size(); col++) {
                Object value = resultSet.getObject(col);
                row.add(formatValue(value, columns.get(col - 1).type));
            }
            rows.add(row);
        }
    }

    private DefaultTableModel createTableModel() {
        String[] columnNames = columns.stream()
                .map(col -> col.name)
                .toArray(String[]::new);

        Object[][] data = rows.stream()
                .map(row -> row.toArray(new Object[0]))
                .toArray(Object[][]::new);

        return new DefaultTableModel(data, columnNames) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columns.get(columnIndex).type;
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Make table read-only by default
            }
        };
    }

    private String formatColumnName(String columnName) {
        // Convert database column names to more readable format
        return columnName.replace("_", " ")
                .trim()
                .toUpperCase();
    }

    private Object formatValue(Object value, Class<?> type) {
        if (value == null) {
            return null;
        }

        // Add custom formatting for specific types
        if (type == Date.class) {
            return new java.text.SimpleDateFormat("yyyy-MM-dd").format(value);
        }
        
        if (type == Double.class || type == Float.class) {
            return String.format("%.2f", value);
        }

        return value;
    }

    private Class<?> mapSqlTypeToJava(int sqlType) {
        return switch (sqlType) {
            case Types.INTEGER, Types.SMALLINT, Types.TINYINT -> Integer.class;
            case Types.BIGINT -> Long.class;
            case Types.FLOAT, Types.REAL -> Float.class;
            case Types.DOUBLE, Types.DECIMAL, Types.NUMERIC -> Double.class;
            case Types.BOOLEAN, Types.BIT -> Boolean.class;
            case Types.DATE -> Date.class;
            case Types.TIMESTAMP -> Timestamp.class;
            default -> String.class;
        };
    }
}
