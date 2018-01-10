package test.problems.multithreading;

import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Logger;

public class ProducerConsumerDemo {
	
	public static void main(String[] args) {
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		
		Producer p=new Producer(queue);
		Consumer c = new Consumer(queue);
		
		p.start();
		c.start();
		
	}
	

}

class Producer extends Thread{
	
	Queue<Integer> queue=null;
	Producer(Queue<Integer> queue){
		this.queue=queue;
	}
	
	@Override
	public void run() {
		
		
		for (int i = 0; i < 1000; i++) {
			
			
			synchronized(queue){
				
				while(queue.size()>=1){
					
					
						try {
							queue.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				System.out.println( "Produced : "+i);
				queue.add(i);
				queue.notify();
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			
			
			
		}
	}
	
	
	
}

class Consumer extends Thread{

	Queue<Integer> queue=null;
	Consumer(Queue<Integer> queue){
		this.queue=queue;
	}
	
	@Override
	public void run() {
		
		while(true){
			
			synchronized (queue) {
				
				while(queue.isEmpty()){
					
						try {
							queue.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				
				int result = queue.poll();
				System.out.println("Consumed : "+result);
				queue.notify();
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if(result==25) 
					break;
			}
			
		}
	}
	
}

