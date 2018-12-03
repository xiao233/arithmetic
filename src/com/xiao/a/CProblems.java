package com.xiao.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

public class CProblems {
	private Scanner scan = null;
	
	@Before
	public void init() {
		scan = new Scanner(System.in);
	}
	
	@Test
	public void a61() {
		
	}
	
	@Test
	public void a62() {
		
	}
	
	@Test
	public void a63() {
		
	}
	
	@Test
	public void a64() {
		
	}
	
	@Test
	public void a65() {
		
	}
	
	@Test
	public void a66() {
		
	}
	
	@Test
	public void a67() {
		
		
		//ac
		
		long start = System.currentTimeMillis();
		
		String data[][] = new String[100][];
		try {
			URL url = new URL("https://projecteuler.net/project/resources/p067_triangle.txt");
			InputStream is = url.openStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			String lines = null;
			int i = 0;
			
			while((lines=br.readLine())!=null) {
				data[i]=lines.split(" ");
				i++;
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		int dataInt[][] = new int[100][];
		for (int i = 0; i < data.length; i++) {
			dataInt[i] = new int[data[i].length];
			for (int j = 0; j < data[i].length; j++) {
				String temp = data[i][j];
				dataInt[i][j] = Integer.parseInt(temp);
			}
		}
		
		for (int i = 1; i < dataInt.length; i++) {
			for (int j = 0; j < dataInt[i].length; j++) {
				if(j==0) {
					dataInt[i][j]=dataInt[i][j]+dataInt[i-1][j];
				}else if(j==dataInt[i].length-1) {
					dataInt[i][j]=dataInt[i][j]+dataInt[i-1][j-1];
				}else {
					int left = dataInt[i][j]+dataInt[i-1][j-1];
					int right = dataInt[i][j]+dataInt[i-1][j];
					if(left<right) {
						left = right;
					}
					dataInt[i][j] = left;
				}
			}
		}
		
		int max = 0;
		for (int i = 0; i < dataInt[dataInt.length-1].length; i++) {
			if(dataInt[dataInt.length-1][i]>max) {
				max = dataInt[dataInt.length-1][i];
			}
		}
		System.out.println("\nmax: "+max);
		
		long end = System.currentTimeMillis();
		
		System.out.println("ºÄÊ±£º "+ new BigDecimal((end-start)/1000).setScale(2)+"s");
	}
	
	@Test
	public void a68() {
		
	}
	
	@Test
	public void a69() {
		
	}
	
	@Test
	public void a70() {
		
	}
}
