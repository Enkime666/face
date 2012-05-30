import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;

public class WidgetWindow extends ApplicationWindow {
	public WidgetWindow () {
		super (null);
	}

	protected Control createContents (Composite parent) {
		getShell ().setText ("Widget Window");
		parent.setSize (400, 250);
		return parent;
	}

	public static void main (String [] args) {
		WidgetWindow wwin = new WidgetWindow ();
		wwin.setBlockOnOpen (true);
		wwin.open ();
		Display.getCurrent ().dispose ();
	}
}