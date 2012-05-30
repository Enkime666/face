package net.enkime.standards.table
import org.eclipse.swt.layout.FillLayout
import org.eclipse.swt.widgets.Display
import org.eclipse.swt.widgets.Shell
import com.weiglewilczek.slf4s.Logging
import javax.swing.table.DefaultTableModel
import org.apache.log4j.Logger
import net.enkime.util.Test
import net.enkime.standards.test.DisplayTest
import net.enkime.standards.layout.BorderData
import org.eclipse.swt.SWT
import org.eclipse.swt.widgets.Event

object TableTest extends DisplayTest {
  val aa = new Array[Array[Object]](5)
  val a = new Array[Object](5)
  for (i <- 0 until aa.length) {
    aa.array(i) = new Array[Object](5)
    a.array(i) = " i = " + i
    for (j <- 0 until aa.length) {
      aa(i)(j) = "i =" + i + " j = " + j
    }
  }
  println(aa.toList)
  println(a.toList)

  val table = new STable(shell, new DefaultTableModel(aa, a))
  table.setLayoutData(BorderData.CENTER)
  table.addListener(SWT.Selection, (e: Event) => { println("Selection " + e) })
}
