package net.enkime.standards.layout
import org.eclipse.swt.widgets.Layout
import org.eclipse.swt.widgets.Composite
import org.eclipse.swt.graphics.Point
import org.eclipse.swt.SWT


class TrinityLayout extends YABorderLayout {
	override def getControls(composite: Composite) {
		val children = composite.getChildren()

		if (0 < children.length) {
			controls.array(BorderData.NORTH) = children.array(0)
			if (1 < children.length) {
				controls.array(BorderData.CENTER) = children.array(1)
				if (2 < children.length) {
					controls.array(BorderData.SOUTH) = children.array(2)
				}
			}
		}
	}
}