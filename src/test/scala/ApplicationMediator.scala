package net.enkime.babel.view.standards

import org.eclipse.jface.window.ApplicationWindow
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label
import org.eclipse.swt.widgets.Display
import org.eclipse.swt.widgets.Composite
import org.eclipse.swt.widgets.Control
;

object ApplicationMediator extends App {
	(new ApplicationMediator) run
}

/**
 * Your first JFace application
 */
class ApplicationMediator extends ApplicationWindow(null) {
	/**
	 * HelloWorld constructor
	 */

	/**
	 * Runs the application
	 */
	def run() {
		// Don't return from open() until window closes
		setBlockOnOpen(true);

		// Open the main window
		open();

		// Dispose the display
		Display.getCurrent().dispose();
	}

	/**
	 * Creates the main window's contents
	 *
	 * @param parent the main window
	 * @return Control
	 */
	override def createContents(parent: Composite): Control = {
		// Create a Hello, World label
		val label = new Label(parent, SWT.CENTER);
		label.setText("Hello, World");
		return label;
	}

	/**
	 * The application entry point
	 *
	 * @param args the command line arguments
	 */
}