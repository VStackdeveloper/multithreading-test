package test.problems.multithreading;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
	
	public static void main(String[] args) throws InterruptedException {
		
		ResultOfSum rsum1=new ResultOfSum();
		ResultOfSum rsum2=new ResultOfSum();
		ResultOfSum rfinal=new ResultOfSum();
		
		CountDownLatch latch=new CountDownLatch(2);
		
		CalculateSum1 sum1=new CalculateSum1(rsum1,10,20,latch);
		CalculateSum1 sum2=new CalculateSum1(rsum2,30,40,latch);
		sum1.start();
		sum2.start();
		
		latch.await();
		
		CalculateMulti1 multi=new CalculateMulti1(rfinal,rsum1,rsum2);
		multi.start();
	}

}



class CalculateSum1 extends Thread{
	
	Integer result;
	ResultOfSum rsum1=null;
	Integer a,b;
	CountDownLatch latch;
	
	CalculateSum1(ResultOfSum rsum1,Integer a,Integer b,CountDownLatch latch){
		this.rsum1=rsum1;
		this.a=a;
		this.b=b;
		this.latch=latch;
	}
	
	@Override
	public void run() {

			result=a+b;
			rsum1.result=result;
			System.out.println("result is : "+result);
			latch.countDown();
		}
	
}

class CalculateMulti1 extends Thread{
	
	Integer result;
	ResultOfSum rfinal,rsum1,rsum2;
	Integer a,b;
	
	CalculateMulti1(ResultOfSum rfinal,ResultOfSum rsum1,ResultOfSum rsum2){
		this.rfinal=rfinal;
		this.rsum1=rsum1;
		this.rsum2=rsum2;
	}
	
	@Override
	public void run() {
		result= rsum1.result*rsum2.result;
		rfinal.result=result;
		System.out.println("final result : "+result);
	}
}

class ResultOfSum{
	
	int result=0;

}

