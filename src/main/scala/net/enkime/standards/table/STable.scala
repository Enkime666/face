package net.enkime.standards.table
import org.eclipse.swt.widgets.Composite
import javax.swing.table.TableModel
import org.eclipse.swt.widgets.Table
import org.eclipse.swt.widgets.TableItem
import org.eclipse.swt.widgets.TableColumn
import org.eclipse.swt.SWT
import org.eclipse.swt.custom.TableEditor
import org.eclipse.swt.widgets.Text

class STable(val composite: Composite, val model: TableModel)
  extends Table(composite, SWT.BORDER) {

  override def checkSubclass() {}

  for (col <- 0 until model.getColumnCount) {
    val column = new TableColumn(this, SWT.CENTER)
    column.setText(model.getColumnName(col));
  }
  setHeaderVisible(true)
  for (row <- 0 until model.getRowCount) {
    val tableItem = new TableItem(this, SWT.NONE)
    val tableEditor = new TableEditor(this)
    for (col <- 0 until model.getColumnCount) {
      //tableItem.setText(col, model.getValueAt(row, col) toString)
      val text = new Text(this,0)
      tableEditor.setEditor(text,tableItem,col)
      
    }
  }
  for (col <- 0 until model.getColumnCount) {
    getColumn(col).pack();
  }
  //model.addTableModelListener()

  private def col_pack {
    for (col <- 0 until model.getColumnCount) {
      getColumn(col).pack();
    }
  }

}