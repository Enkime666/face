package net.enkime.standards.border;

import org.eclipse.swt.SWT
import org.eclipse.swt.widgets.Button
import org.eclipse.swt.widgets.Display
import org.eclipse.swt.widgets.Shell
import scala.actors.Logger
import net.enkime.standards.layout.BorderData;
import net.enkime.standards.layout.YABorderLayout;
import net.enkime.util.Test

//Send questions, comments, bug reports, etc. to the authors:

//Rob Warner (rwarner@interspatial.com)
//Robert Harris (rbrt_harris@yahoo.com)

object YABorderLayoutTest extends Test {
	try {
		logger.debug("begin");
		val display = new Display();
		val shell = new Shell(display);
		shell.setLayout(new YABorderLayout());
		val b1 = new Button(shell, SWT.PUSH);
		b1.setText("North");
		b1.setLayoutData(BorderData.NORTH);
		//b1.setLayoutData(new BorderData(0));
		val b2 = new Button(shell, SWT.PUSH);
		b2.setText("South");
		b2.setLayoutData(BorderData.SOUTH);
		val b3 = new Button(shell, SWT.PUSH);
		b3.setText("East");
		b3.setLayoutData(BorderData.EAST);
		val b4 = new Button(shell, SWT.PUSH);
		b4.setText("West");
		b4.setLayoutData(BorderData.WEST);
		val b5 = new Button(shell, SWT.PUSH);
		b5.setText("Center");
		b5.setLayoutData(BorderData.CENTER);
		shell.pack();
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	} catch {
		case e: Exception => logger.error(e toString, e)
	}
}
