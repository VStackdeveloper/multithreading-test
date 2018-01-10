package test.problems.multithreading;

public class MultiThreadDemo {
	
	public static void main(String[] args) throws InterruptedException {
		
		ResultOfSum rsum1 = new ResultOfSum();
		ResultOfSum rsum2 = new ResultOfSum();
		ResultOfSum rfinal = new ResultOfSum();
		CalculateSum2 sum1=new CalculateSum2(rsum1,10,20);
		CalculateSum2 sum2=new CalculateSum2(rsum2,30,40);
		
		sum1.start();
		sum2.start();
		
		synchronized (sum1) {
			
			while(rsum1.result==-1){
				
				sum1.wait();
			}
			
			synchronized (sum2) {
				while(rsum2.result==-1){
					sum2.wait();
				}
				CalculateMulti2 multi2=new CalculateMulti2(rfinal,rsum1,rsum2);
				multi2.start();
			}
			
		}
		
		
	}

}


class CalculateSum2 extends Thread{
	
	Integer result=-1;
	ResultOfSum rsum1=null;
	Integer a,b;
	
	CalculateSum2(ResultOfSum rsum1,Integer a,Integer b){
		this.rsum1=rsum1;
		this.a=a;
		this.b=b;
	}
	
	@Override
	public void run() {

		synchronized(this){
			result=a+b;
			rsum1.result=result;
			System.out.println("result is : "+result);
			notify();
		}
	}
	
}

class CalculateMulti2 extends Thread{
	
	Integer result;
	ResultOfSum rfinal,rsum1,rsum2;
	Integer a,b;
	
	CalculateMulti2(ResultOfSum rfinal,ResultOfSum rsum1,ResultOfSum rsum2){
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


