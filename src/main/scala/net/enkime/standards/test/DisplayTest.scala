package net.enkime.standards.test

import org.eclipse.swt.widgets.Display
import org.eclipse.swt.widgets.Shell
import net.enkime.util.Test
import net.enkime.standards.layout.BorderLayout
import javax.swing.JTable
import net.enkime.standards.listener.AdapterListener

trait DisplayTest extends Test with AdapterListener {
  val display = new Display();
  val shell = new Shell(display);
  shell.setLayout(new BorderLayout)
  val t = new JTable
  def run() {
    shell.pack();
    shell.open();
    while (!shell.isDisposed()) {
      if (!display.readAndDispatch()) {
        display.sleep();
      }
    }
    display.dispose();
  }

  override def main(args: Array[String]) {
    super.main(args)
    run
  }
}

// cd ~/Dokumenty/cs/eclipse/babel/standards