package net.enkime.standards.listener

import org.eclipse.swt.widgets.Composite
import org.eclipse.swt.SWT

abstract class CompositeListener(composite: Composite, style: Int)
		extends Composite(composite, style) with DecoratorListener{
	def this(composite: Composite) = this(composite, SWT.NONE)
}