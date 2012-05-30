package net.enkime.standards.composite
import org.eclipse.swt.widgets.Composite
import org.eclipse.swt.SWT

import net.enkime.standards.layout.ThreetierLayout;

import org.eclipse.swt.widgets.Label
import org.eclipse.swt.widgets.Text
import java.util.regex.Pattern
import org.eclipse.swt.widgets.Combo
import org.eclipse.swt.widgets.Listener

object LabelComposite {
	type Duck = {def getText: String; def addListener (i:Int,l :Listener)}
	val createText : Composite => Duck = new Text(_, SWT.BORDER | SWT.MULTI).asInstanceOf[Duck]	
	val createCombo : Composite => Duck = new Combo(_,SWT.READ_ONLY).asInstanceOf[Duck] 
}

class LabelComposite(
	parent: Composite, val TEXT: String, text: String, 
	lambda: Composite => LabelComposite.Duck )
		extends Composite(parent, SWT.NONE) {
	def this (parent: Composite, TEXT: String, text: String) = this (parent,  TEXT, text, LabelComposite.createText)

	val label = new Label(this, SWT.NONE)
	val duck = lambda (this)
	setLayout(new ThreetierLayout)
	label.setText(TEXT + text)
	
	override def toString = if (duck == null) "" else {
		val text = duck.getText
		if (text.matches("""\s""")) "" else TEXT + " " + text + " "
	}
}