package assignment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FileIO {

	public static void main(String[] args) throws IOException {
		
		ExecutorService executor = Executors.newFixedThreadPool(2);

	try {
			
			Reader read = new FileReader("words.txt");
			BufferedReader buff = new BufferedReader(read);
			String myWords = buff.readLine();
			
			//int myWords = reader.read();
				//System.out.print((char) myWords);
				//myWords = reader.read();
			//reader.close();
			
			FileWriter mem;
			mem = new FileWriter("memory.txt");
			BufferedWriter bWrite = new BufferedWriter(mem);
			
			while(myWords != null) {
				
				System.out.println(myWords);
				bWrite.write(myWords);
				bWrite.newLine();
				bWrite.flush();
				myWords = buff.readLine();
				
			//mem.write("words.txt");
			//mem.close();
			
			}
			buff.close();
			read.close();
		
			
			try {
				Thread.sleep(2000);
				System.out.println("Thread is asleep");
	
			}catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			mem.close();
			bWrite.close();
		
			
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		

		
	for (int i = 0; i < 10; i++) {
			 Runnable worker = new WorkerThread("" + i);
	          executor.execute(worker);
		}
	}

	
}
	
class WorkerThread implements Runnable {
		  
	 private String command;
	    
	    public WorkerThread(String s){
	        this.command=s;
	    }

	    @Override
	    public void run() {
	        System.out.println(Thread.currentThread().getName()+" Start. Command = "+command);
	       
	        processCommand();
	        System.out.println(Thread.currentThread().getName()+" End.");
	    }

	    private void processCommand() {
	        try {
	            Thread.sleep(2000);
	            System.out.println("Thread is asleep");
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public String toString(){
	        return this.command;
	    }
	}


