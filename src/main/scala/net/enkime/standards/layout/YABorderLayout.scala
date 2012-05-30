
package net.enkime.standards.layout

import org.eclipse.swt.SWT
import org.eclipse.swt.graphics.Point
import org.eclipse.swt.graphics.Rectangle
import org.eclipse.swt.widgets._

class YABorderLayout extends Layout {
	val controls = new Array[Control](5)

	protected def computeSize(composite: Composite, wHint: Int, hHint: Int, flushCache: Boolean): Point = {
		getControls(composite)
		var width = 0
		var height = 0
		width += (if (controls.array(BorderData.WEST) != null) getSize(controls.array(BorderData.WEST), flushCache).x else 0)
		width += (if (controls.array(BorderData.EAST) != null) getSize(controls.array(BorderData.EAST), flushCache).x else 0)
		width += (if (controls.array(BorderData.CENTER) != null) getSize(controls.array(BorderData.CENTER), flushCache).x else 0)
		
		if (controls.array(BorderData.NORTH) != null) width = Math.max(width, getSize(controls.array(BorderData.NORTH), flushCache).x)

		if (controls.array(BorderData.SOUTH) != null) width = Math.max(width, getSize(controls.array(BorderData.SOUTH), flushCache).x)

		height += (if (controls.array(BorderData.NORTH) != null) getSize(controls.array(BorderData.NORTH), flushCache).y else 0)
		height += (if (controls.array(BorderData.SOUTH) != null) getSize(controls.array(BorderData.SOUTH), flushCache).y else 0)

		var heightOther = (if (controls.array(BorderData.CENTER) != null) getSize(controls.array(BorderData.CENTER), flushCache).y else 0)
		if (controls.array(BorderData.WEST) != null) heightOther = Math.max(heightOther, getSize(controls.array(BorderData.WEST), flushCache).y)

		if (controls.array(BorderData.EAST) != null) heightOther = Math.max(heightOther, getSize(controls.array(BorderData.EAST), flushCache).y)
		height += heightOther

		return new Point(Math.max(width, wHint), Math.max(height, hHint))
	}

	protected def layout(composite: Composite, flushCache: Boolean) {
		getControls(composite)
		val rect = composite.getClientArea()
		var left = rect.x
		var right = rect.width
		var top = rect.y
		var bottom = rect.height
		if (controls.array(BorderData.NORTH) != null) {
			val pt = getSize(controls.array(BorderData.NORTH), flushCache)
			controls.array(BorderData.NORTH).setBounds(left, top, rect.width, pt.y)
			top += pt.y
		}
		if (controls.array(BorderData.SOUTH) != null) {
			val pt = getSize(controls.array(BorderData.SOUTH), flushCache)
			controls.array(BorderData.SOUTH).setBounds(left, rect.height - pt.y, rect.width, pt.y)
			bottom -= pt.y
		}
		if (controls.array(BorderData.EAST) != null) {
			val pt = getSize(controls.array(BorderData.EAST), flushCache)
			controls.array(BorderData.EAST).setBounds(rect.width - pt.x, top, pt.x, (bottom - top))
			right -= pt.x
		}
		if (controls.array(BorderData.WEST) != null) {
			val pt = getSize(controls.array(BorderData.WEST), flushCache)
			controls.array(BorderData.WEST).setBounds(left, top, pt.x, (bottom - top))
			left += pt.x
		}
		if (controls.array(BorderData.CENTER) != null) {
			controls.array(BorderData.CENTER).setBounds(left, top, (right - left), (bottom - top))
		}
	}

	protected def getSize(control: Control, flushCache: Boolean): Point = {
		return control.computeSize(SWT.DEFAULT, SWT.DEFAULT, flushCache)
	}

	protected def getControls(composite: Composite) {
		val children = composite.getChildren()
		for (i <- 0 until children.length) {
			val child = children.array(i)
			controls.array(child.getLayoutData().asInstanceOf[Int]) = child
		}
	}
}
