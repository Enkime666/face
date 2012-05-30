
package net.enkime.standards.layout;


import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Layout;

class BorderLayout extends Layout {
	val controls = new Array[Control](5);
	var sizes: Array[Point] = null
	var width = 0
	var height = 0

	protected def computeSize(composite: Composite, wHint: Int, hHint: Int, flushCache: Boolean): Point = {
		if (sizes == null || flushCache) refreshSizes(composite.getChildren());
		return new Point(if (wHint != SWT.DEFAULT) wHint else width, if (hHint != SWT.DEFAULT) hHint else height);
	}

	protected def layout(composite: Composite, flushCache: Boolean) {
		if (flushCache || sizes == null) refreshSizes(composite.getChildren());

		val clientArea = composite.getClientArea();

		if (controls.array(BorderData.NORTH) != null) {
			controls.array(BorderData.NORTH).setBounds(
				clientArea.x,
				clientArea.y,
				clientArea.width,
				sizes.array(BorderData.NORTH).y);
		}
		if (controls.array(BorderData.SOUTH) != null) {
			controls.array(BorderData.SOUTH).setBounds(
				clientArea.x,
				clientArea.y + clientArea.height - sizes.array(BorderData.SOUTH).y,
				clientArea.width,
				sizes.array(BorderData.SOUTH).y);
		}
		if (controls.array(BorderData.WEST) != null) {
			controls.array(BorderData.WEST).setBounds(
				clientArea.x,
				clientArea.y + sizes.array(BorderData.NORTH).y,
				sizes.array(BorderData.WEST).x,
				clientArea.height - sizes.array(BorderData.NORTH).y - sizes.array(BorderData.SOUTH).y);
		}
		if (controls.array(BorderData.EAST) != null) {
			controls.array(BorderData.EAST).setBounds(
				clientArea.x + clientArea.width - sizes.array(BorderData.EAST).x,
				clientArea.y + sizes.array(BorderData.NORTH).y,
				sizes.array(BorderData.EAST).x,
				clientArea.height - sizes.array(BorderData.NORTH).y - sizes.array(BorderData.SOUTH).y);
		}
		if (controls.array(BorderData.CENTER) != null) {
			controls.array(BorderData.CENTER).setBounds(
				clientArea.x + sizes.array(BorderData.WEST).x,
				clientArea.y + sizes.array(BorderData.NORTH).y,
				clientArea.width - sizes.array(BorderData.WEST).x - sizes.array(BorderData.EAST).x,
				clientArea.height - sizes.array(BorderData.NORTH).y - sizes.array(BorderData.SOUTH).y);
		}
	}

	private def refreshSizes(children: Array[Control]) {
		for (i <- 0 until children.length) {
			val layoutData = children.array(i).getLayoutData();
			if (layoutData != null && (layoutData.isInstanceOf[Int])) {
				val borderData = layoutData.asInstanceOf[Int];
				if (0 <= borderData && borderData <= 4)
					controls.array(borderData) = children.array(i);
				else throw new IndexOutOfBoundsException()
			}
		}

		width = 0;
		height = 0;

		if (sizes == null) sizes = new Array[Point](5);

		for (i <- 0 until controls.length) {
			val control = controls.array(i);
			sizes.array(i) = (if (control != null) control.computeSize(SWT.DEFAULT, SWT.DEFAULT, true) else new Point(0, 0))
		}

		width = Math.max(width, sizes.array(BorderData.NORTH).x);
		width = Math.max(width, sizes.array(BorderData.WEST).x + sizes.array(BorderData.CENTER).x + sizes.array(BorderData.EAST).x);
		width = Math.max(width, sizes.array(BorderData.SOUTH).x);

		height = Math.max(Math.max(sizes.array(BorderData.WEST).y, sizes.array(BorderData.EAST).y), sizes.array(BorderData.CENTER).y) + sizes.array(BorderData.NORTH).y + sizes.array(BorderData.SOUTH).y;
	}
}
