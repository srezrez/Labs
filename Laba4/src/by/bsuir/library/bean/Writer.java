package by.bsuir.library.bean;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.JButton;

public class Writer extends Thread{
	
	ReentrantLock lock = new ReentrantLock();
	
	Access a;
	TextField info;
	JButton endWriting;
	Semaphore sem;
	Inform inform;
	JButton read;
	JButton write;
	
	public Writer(Access a, TextField info, JButton endWriting, Semaphore sem, Inform inform, JButton read, JButton write) {
		System.out.println("Into writing constructor");
		this.a = a;
		this.info = info;
		this.endWriting = endWriting;
		this.sem = sem;
		this.inform = inform;
		this.read = read;
		this.write = write;
		start();
	}
	
	public void run() {
		try {
			System.out.println("Writer into run. Waiting");
			System.out.println("Permits amount: " + sem.availablePermits());
			// while(sem.availablePermits() == 0) sleep(50);
			sem.acquire();
			System.out.println("Writer after acquire. Permits amount: " + sem.availablePermits());
			a.writing(this);
			endWriting.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ae) {
					inform.setInformation(info.getText());
					info.setVisible(false);
					endWriting.setVisible(false);
					sem.release();
					System.out.println("Writer after release. Permits amount: " + sem.availablePermits());
					System.out.println("===============================================");
					read.setEnabled(true);
					write.setEnabled(true);
				}
			});

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
