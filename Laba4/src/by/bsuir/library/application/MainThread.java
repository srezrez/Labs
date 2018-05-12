package by.bsuir.library.application;

import java.awt.FlowLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Semaphore;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import by.bsuir.library.bean.Access;
import by.bsuir.library.bean.Inform;
import by.bsuir.library.bean.Reader;
import by.bsuir.library.bean.Writer;

public class MainThread {
	
    Semaphore sem = new Semaphore(1, true);
	static Access a = new Access();
	static Inform inform = new Inform();

	private JButton read;
	private JButton write;
	private JButton endReading;
	private JButton endWriting;
	private JLabel readInform;
	private TextField info;

	public MainThread() {

		JPanel panel = new JPanel();
		panel.setLayout(null);
		JFrame jfrm = new JFrame("Books");
		jfrm.setLayout(new FlowLayout());
		jfrm.setSize(500, 300);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		read = new JButton("read");
		write = new JButton("write");
		readInform = new JLabel();
		endReading = new JButton("Finish");
		info = new TextField();
		endWriting = new JButton("Finish");
		
		System.out.println("Avai;able permits: "+ sem.availablePermits());
		
		read.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				System.out.println("Reader has been created");
				Reader reader = new Reader(a, sem, readInform, endReading, inform, read, write);
//				while(!reader.isAlive()) {
//					try {
//						Thread.sleep(50);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//				}
			}
		});

		write.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				Writer writer = new Writer(a, info, endWriting, sem, inform, read, write);
//				while(!writer.isAlive()) {
//					try {
//						Thread.sleep(50);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//				}
			}
		});
		

		jfrm.add(read);
		jfrm.add(write);
		jfrm.add(readInform);
		jfrm.add(endReading);
		jfrm.add(info);
		jfrm.add(endWriting);

		readInform.setVisible(false);
		endReading.setVisible(false);
		info.setVisible(false);
		endWriting.setVisible(false);

		jfrm.setVisible(true);

	}

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new MainThread();
			}
		});
	}

}
