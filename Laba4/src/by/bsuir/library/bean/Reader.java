package by.bsuir.library.bean;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.JButton;
import javax.swing.JLabel;

public class Reader extends Thread{
	
	ReentrantLock lock = new ReentrantLock();
	
	Access a;
	Semaphore sem;
	JLabel readinform;
	JButton endReading;
	Inform inform;
	JButton read;
	JButton write;
	
	public Reader(Access a, Semaphore sem, JLabel readinform, JButton endReading, Inform inform, JButton read, JButton write) {
		System.out.println("Into reader's constructor");
		this.a = a;
		this.sem = sem;
		this.readinform = readinform;
		this.endReading = endReading;
		this.inform = inform;
		this.read = read;
		this.write = write;
		start();
	}
	
	public void run() {
		try {
			System.out.println("Reader into run. Waiting");
			// while(sem.availablePermits() ==0) sleep(50);
			sem.acquire();
			System.out.println("Reader after acquire. Available permits: " + sem.availablePermits());
			a.reading(this);
			endReading.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ae) {
					readinform.setVisible(false);
					endReading.setVisible(false);
					System.out.println("Reader has been deleted");
					sem.release();
					System.out.println("Reader after release. Available permits: " + sem.availablePermits());
					System.out.println("=====================================");
					read.setEnabled(true);
					write.setEnabled(true);
				}
			});
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
}
