import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * HelloWorld is the simplest SWT application, which displays a Shell with a
 * title.
 */
public class HelloWorldApplicationWindow {

	public static void main2 (String [] args) {
		Display display = new Display ();
		Shell shell = new Shell (display);
		shell.setText ("Hello, world!");
		shell.open ();

		while (!shell.isDisposed ()) {
			if (!display.readAndDispatch ()) {// If no more entries in event queue
				display.sleep ();
			}
		}

		display.dispose ();
	}

	public static void main (String [] args) {
		ApplicationWindow aw = new ApplicationWindow (null);
		aw.setBlockOnOpen (true);
		aw.open ();
	}

}
