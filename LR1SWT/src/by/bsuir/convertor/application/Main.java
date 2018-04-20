package by.bsuir.convertor.application;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;

import by.bsuir.convertor.action.Convertor;

public class Main {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setText("Converter");
		shell.setSize(400, 300);
		shell.setLayout(new GridLayout(1, false));
		Label lbDecimal = new Label(shell, SWT.NONE);
		lbDecimal.setText("Decimal:");
		Text textDecimal = new Text(shell, SWT.BORDER);
		Label lbBinary = new Label(shell, SWT.NONE);
		lbBinary.setText("Binary:");
		Text textBinary = new Text(shell, SWT.BORDER | SWT.READ_ONLY);
		Button button = new Button(shell, SWT.NONE);
		button.setText("Convert");
		textBinary.setText("                                                              ");
		Convertor convertor = new Convertor();
	
		button.addListener(SWT.MouseDown, event -> 
				textBinary.setText(convertor.convert(Integer.parseInt(textDecimal.getText()))));
		shell.open();
		while (!shell.isDisposed())
			if (!display.readAndDispatch())
				display.sleep();
		display.dispose();
	}

	
}
