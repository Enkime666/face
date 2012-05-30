package net.enkime.standards.border;

import org.eclipse.swt.widgets.Button
import org.eclipse.swt.widgets.Display
import org.eclipse.swt.widgets.Shell
import org.eclipse.swt.widgets.Text
import org.eclipse.swt.SWT
import net.enkime.standards.layout.BorderData
import net.enkime.standards.layout.BorderLayout;
import net.enkime.standards.test.DisplayTest


object BorderLayoutTest extends DisplayTest {
  
    logger.debug("begin");

    shell.setLayout(new BorderLayout());

    val buttonWest = new Button(shell, SWT.PUSH);
    buttonWest.setText("West");
    buttonWest.setLayoutData(BorderData.WEST);

    val buttonEast = new Button(shell, SWT.PUSH);
    buttonEast.setText("East");
    buttonEast.setLayoutData(BorderData.EAST);

    val buttonNorth = new Button(shell, SWT.PUSH);
    buttonNorth.setText("North");
    buttonNorth.setLayoutData(BorderData.NORTH);

    val buttonSouth = new Button(shell, SWT.PUSH);
    buttonSouth.setText("South");
    buttonSouth.setLayoutData(BorderData.SOUTH);

    val text = new Text(shell, SWT.MULTI | SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
    text.setText("Center");
    text.setLayoutData(BorderData.CENTER);

}

           
