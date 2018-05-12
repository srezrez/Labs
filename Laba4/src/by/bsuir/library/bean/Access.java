package by.bsuir.library.bean;

import java.util.concurrent.locks.ReentrantLock;

public class Access {
	
	ReentrantLock lock = new ReentrantLock();

	public  void writing(Writer t) {
		lock.lock();
		try {
			System.out.println("Writer into writing");
//			t.read.setEnabled(false);
//			t.write.setEnabled(false);
			t.info.setVisible(true);
			t.info.setText(t.inform.getInformation());
			t.endWriting.setVisible(true);
		}finally {
			lock.unlock();
		}
		
	}
	
	public  void reading(Reader t) {
		lock.lock();
		try {
			System.out.println("Into reading");
//			t.read.setEnabled(false);
//			t.write.setEnabled(false);
			t.readinform.setVisible(true);
			t.readinform.setText(t.inform.getInformation());
			t.endReading.setVisible(true);
		}finally {
			lock.unlock();
		}	
	}

}
