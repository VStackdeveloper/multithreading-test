package test.problems.multithreading.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CollableInterfaceDemo {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		ExecutorService executorService=Executors.newSingleThreadExecutor();
		
		Future<Integer> result1 = executorService.submit(new SumCalculator(10,20));
		Future<Integer> result2 = executorService.submit(new SumCalculator(30,40));
		
		Integer res1 = result1.get();
		System.out.println("Res1  : "+res1);
		Integer res2 = result2.get();
		System.out.println("Res2  : "+res2);
		Future<Integer> fResult = executorService.submit(new MultiCalculator(res1, res2));
		Integer finalResult = fResult.get();
		System.out.println("Result is : "+finalResult);
		
		
	}
	

}


class SumCalculator implements Callable<Integer>{
	
	int a,b;
	
	SumCalculator(int a,int b){
		this.a=a;
		this.b=b;
	}
	
	
	@Override
	public Integer call() throws Exception {
		return sum(a,b);
	}
	
	int sum(int a,int b){
		return a+b;
	}

	
	
}

class MultiCalculator implements Callable<Integer>{
	
	int a,b;
	
	MultiCalculator(int a,int b){
		this.a=a;
		this.b=b;
	}
	
	
	@Override
	public Integer call() throws Exception {
		return multi(a,b);
	}
	
	int multi(int a,int b){
		return a*b;
	}

	
	
}
