/******************************************************************************
 * All Right Reserved. 
 * Copyright (c) 1998, 2004 Jackwind Li Guojie
 * 
 * Created on 2004-5-13 14:30:36 by JACK
 * $Id$
 * 
 *****************************************************************************/
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.jface.window.Window;

public class DummyWindow {
	public static void main (String [] args) {
		Window window = new ApplicationWindow (null);
		window.setBlockOnOpen (true);
		int returnStatus = window.open ();
	}
}