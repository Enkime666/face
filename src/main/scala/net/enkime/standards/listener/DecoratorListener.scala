package net.enkime.standards.listener
import org.eclipse.swt.events.SelectionListener
import org.eclipse.swt.widgets.Listener
import org.eclipse.swt.widgets.Event

trait DecoratorListener extends Listener with AdapterListener {}