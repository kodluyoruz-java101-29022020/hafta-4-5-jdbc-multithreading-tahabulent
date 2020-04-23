package Question1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
	static ArrayList<Integer> part1 = new ArrayList<Integer>();
	static ArrayList<Integer> part2 = new ArrayList<Integer>();
	static ArrayList<Integer> part3 = new ArrayList<Integer>();
	static ArrayList<Integer> part4 = new ArrayList<Integer>();

	public static void main(String[] args) {
		List<Integer> arrayList = new ArrayList<Integer>();
		List<Integer> ciftSayi = new ArrayList<Integer>();
		List<Integer> tekSayi = new ArrayList<Integer>();

		fillArrayList(arrayList);
		splitArrayList(arrayList);

		ProgramThreads t1 = new ProgramThreads("Thread1", tekSayi, ciftSayi, part1);
		ProgramThreads t2 = new ProgramThreads("Thread2", tekSayi, ciftSayi, part2);
		ProgramThreads t3 = new ProgramThreads("Thread3", tekSayi, ciftSayi, part3);
		ProgramThreads t4 = new ProgramThreads("Thread4", tekSayi, ciftSayi, part4);

		Thread thread1 = new Thread(t1);
		Thread thread2 = new Thread(t2);
		Thread thread3 = new Thread(t3);
		Thread thread4 = new Thread(t4);

		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();

		ExecutorService executor = Executors.newSingleThreadExecutor();
		Callable<List<Integer>> callable = new Callable<List<Integer>>() {
			@Override
			public List<Integer> call() {
				List<Integer> a = new ArrayList<Integer>();
				a.addAll(tekSayi);
				a.addAll(ciftSayi);
				return a;

			}

		};
		Future<List<Integer>> future = executor.submit(callable);
		// future.get() returns 2 or raises an exception if the thread dies, so safer
		executor.shutdown();

		try {
			for (Integer item : future.get()) {
				System.out.println(item);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void fillArrayList(List<Integer> arrayList) {

		for (int i = 1; i < 10000; i++) {
			arrayList.add(i);
		}

	}

	public static void splitArrayList(List<Integer> arrayList) {

		for (int i = 1; i < 2500; i++) {
			part1.add(i);

		}
		for (int i = 2501; i < 5000; i++) {
			part2.add(i);

		}
		for (int i = 5001; i < 7500; i++) {
			part3.add(i);

		}
		for (int i = 7501; i < 10000; i++) {
			part4.add(i);

		}
	}
}