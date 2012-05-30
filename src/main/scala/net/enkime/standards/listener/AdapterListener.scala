package net.enkime.standards.listener
import org.eclipse.swt.events.SelectionListener
import org.eclipse.swt.widgets.Listener
import org.eclipse.swt.widgets.Event

trait AdapterListener {
	implicit def toListener[T](lambda: (Event) => T) = new Listener() {
		override def handleEvent(event: Event) = lambda(event)
	}
}