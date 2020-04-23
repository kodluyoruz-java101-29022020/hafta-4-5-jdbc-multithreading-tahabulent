package Question1;

import java.util.List;

public class ProgramThreads implements Runnable {

	private String threadName;
	private List<Integer> tekSayi;
	private List<Integer> ciftSayi;
	private List<Integer> arrayList;

	public ProgramThreads(String threadName, List<Integer> tekSayi, List<Integer> ciftSayi, List<Integer> arrayList) {

		this.threadName = threadName;
		this.arrayList = arrayList;
		this.tekSayi = tekSayi;
		this.ciftSayi = ciftSayi;
	}

	public List<Integer> getTekSayi() {
		return this.tekSayi;
	}

	public List<Integer> getCiftSayi() {
		return this.ciftSayi;
	}

	@Override
	public void run() {
		try {
			synchronized (ciftSayi) {

				for (Integer item : arrayList) {
					if (item % 2 == 0) {
						this.ciftSayi.add(item);
					}
				}
			}
			synchronized (tekSayi) {

				for (Integer item : arrayList) {
					if (item % 2 == 1) {
						this.tekSayi.add(item);
					}
				}
			}

		} catch (Exception e) {
			System.out.println("hata");
		}

	}

}
