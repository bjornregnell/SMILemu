/**
 * 
 */
package com.brunschen.christian.smil;

import java.awt.Component;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import com.brunschen.christian.smil.DoubleRenderer;

public class MemoryTable extends JTable {
  /**
   * 
   */
  public static final long serialVersionUID = 0L;

  private WordEditor wordEditor;
  private DoubleEditor doubleEditor;
  private com.brunschen.christian.smil.DoubleRenderer doubleRenderer = 
    new com.brunschen.christian.smil.DoubleRenderer();

  private int preferredWidth = 0;

  public MemoryTable(MemoryTableModel m) {
    super(m);
    wordEditor = new WordEditor(m.memory());
    doubleEditor = new DoubleEditor(m.memory());
    DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
    setDefaultRenderer(String.class, renderer);
    Font font = SMILApp.labelFont().awtFont().deriveFont(12);
    renderer.setFont(font);
    setFont(font);
    initColumnSizes(font);
  }

  private void initColumnSizes(Font font) {
    TableModel model = getModel();
    TableColumn column = null;
    Component comp = null;
    int headerWidth = 0;
    int cellWidth = 0;
    TableCellRenderer headerRenderer = getTableHeader().getDefaultRenderer();

    for (int i = 0; i < 2; i++) {
      column = getColumnModel().getColumn(i);

      comp = headerRenderer.getTableCellRendererComponent(null, column.getHeaderValue(), false, false, 0, 0);
      headerWidth = comp.getPreferredSize().width;

      cellWidth = 0;
      for (int j = 0; j < 2; j++) {
        TableCellRenderer renderer = getCellRenderer(j, i);
        ((JLabel) renderer).setFont(font);
        Object o = model.getValueAt(j, i);
        comp = renderer.getTableCellRendererComponent(this, o, false, false, j, i);
        cellWidth = Math.max(cellWidth, comp.getPreferredSize().width);
      }

      int columnWidth = Math.max(headerWidth, cellWidth) + 10;
      // adjust to make sure there won't be any cropping
      column.setMaxWidth(columnWidth * 2);
      column.setPreferredWidth(columnWidth);
      column.setMinWidth(columnWidth / 2);

      preferredWidth += columnWidth;
    }

    getColumnModel().getColumn(2).setMinWidth(300);
    getColumnModel().getColumn(2).setPreferredWidth(600);
    getColumnModel().getColumn(2).setMaxWidth(4000);

    preferredWidth += 600;
  }

  public TableCellEditor getCellEditor(int row, int column) {
    if (column == 1) {
      switch (row % 2) {
        case 0:
          return wordEditor;
        case 1:
          return doubleEditor;
        default:
          return null;
      }
    } else {
      return super.getCellEditor(row, column);
    }
  }

  public TableCellRenderer getCellRenderer(int row, int column) {
    if (column == 1 && row % 2 == 1) {
      return doubleRenderer;
    } else {
      return super.getCellRenderer(row, column);
    }
  }

  public int preferredWidth() {
    return preferredWidth;
  }
}