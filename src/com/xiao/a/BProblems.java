package com.xiao.a;

import org.junit.Before;
import org.junit.Test;

import com.xiao.utils.HelpUtils;

import java.util.List;
import java.util.Scanner;

import org.junit.After;

public class BProblems {
	private Scanner scan = null;
	private long MILLIONS = 1l;
	
	@Before
	public void init() {
		scan = new Scanner(System.in);
	}
	
	@After
	public void destory() {
		scan.close();
	}
	
	@Test
	public void a31() {
		int data[] = {1,2,5,10,20,50,100,200};
		int min = 200/200;//最多个数
		int max =200/1;//最少个数
		
		int count=0;
		for (int i = min; i <= max; i++) {
		
		}
	}
	
	@Test
	public void a32() {
		
	}
	
	@Test
	public void a33() {
		
	}
	
	@Test
	public void a34() {
		//ac
		long start = System.currentTimeMillis();
		long mul  =  HelpUtils.getDigital(9);
		System.out.println("9! = "+mul);
		String data = "99999";
		for (int i = 6; ; i++) {
			data+="9";
			if(Long.parseLong(data)>=i*mul) {
				System.out.println("data: "+data+" ,i: "+i);
				break;
			}
		}
		long sum = 0;
		for (long i = 10; i <= Long.parseLong(data); i++) {
			List<Integer> bits = HelpUtils.getBits(i);
			long mul_sum = 0;
			for (Integer integer : bits) {
				mul_sum+=HelpUtils.getDigital(integer);
			}
			if(mul_sum==i) {
				System.out.println("i: "+i+" ,mul_sum: "+mul_sum);
				sum+=i;
				System.out.println("sum: "+sum);
			}
		}
		long end = System.currentTimeMillis();
		System.out.println("耗时: "+(end-start)/MILLIONS+"ms");
	}
	
	@Test
	public void a35() {
		//ac
		long start = System.currentTimeMillis();
		int max = 1000000;
		int count = 0;
		for (int i = 2; i <= max; i++) {
			if(i>9) {
				List<Integer> bits = HelpUtils.getBits(i);
				boolean flag = false;
				for (Integer integer : bits) {
					if(integer%2==0||integer==5) {
						flag = true;
						break;
					}
				}
				if(flag) {
					flag = false;
					continue;
				}
			}
			if(!HelpUtils.checkPrime(i)) {
				continue;
			}
			
			
			boolean flag = true;
			
			List<String> rs = HelpUtils.getCircleDigital(""+i);
			
			for (String string : rs) {
				if(!HelpUtils.checkPrime(Long.parseLong(string))) {
					flag = false;
					break;
				}
			}
			if(flag) {
				++count;
				//System.out.println("count: "+count+" ,i: "+i);
			}
		}
		long end = System.currentTimeMillis();
		System.out.println("耗时: "+(end-start)/MILLIONS+"ms，结果: "+count);
	}
	
	@Test
	public void a36() {
		//ac
		
		
		/**
		 * 十进制数585=1001001001B（二进制），对于基数10和2都是回文数。
		 * 找出小于一百万的所有回文数（对于基数10和2都是回文数）之和。
		 */
		
		long start = System.currentTimeMillis();
		
		long sum=0;
		int max = 1000000;
		
		for(int i = 1 ;i <= max ; i++) {
			if(HelpUtils.judgeDigitalPalindromic(i+"")) {
				String bTemp = HelpUtils.intToBinary(i);
				if(HelpUtils.judgeDigitalPalindromic(bTemp)) {
					//System.out.println(i +" = "+bTemp+"是回文数");
					sum+=i;
				}
			}
		}
		
		long end = System.currentTimeMillis();
		System.out.println("耗时: "+(end-start)/MILLIONS+"ms，结果: "+sum); 
	}
	
	@Test
	public void a37() {
		
		//算法理论上虽然可行，但时间复杂度或者说效率不行，导致jre运行获取不到结果
		
		long start = System.currentTimeMillis();
		int maxCount = 0;
		long i = 10;
		long sum = 0l;
		while(true) {
			i++;
			boolean flag = true;
			
			List<Integer> bits = HelpUtils.getBits(i);
			if(bits.get(0)==1 || bits.get(bits.size()-1)==1
					||bits.get(0)==9 ||bits.get(bits.size()-1)==9) {
				continue;
			}
			
			for (int j = 0; j < bits.size()-1; j++) {
				if(bits.get(j)==bits.get(j+1)) {
					flag = false;
					break;
				}
			}
			if(!flag) {
				flag = true;
				continue;
			}
			
			for (Integer integer : bits) {
				if(integer%2==0||integer==5) {
					flag = false;
					break;
				}
			}
			if(!flag) {
				flag = true;
				continue;
			}
			
			if(!HelpUtils.checkPrime(i)) {
				continue;
			}
			
			//以上过滤掉删除数后不可能是质数的数
			
			System.out.println("i: "+i);
			
			long temp = i;
			long mul = 1;
			
			
			//右删除
			StringBuilder str = new StringBuilder(i+": ");
			while(temp!=0) {
				str.append(""+temp+", ");
				if(!HelpUtils.checkPrime(temp)) {
					flag = false;
					break;
				}
				temp/=10;
				mul*=10;
			}
			if(!flag) {
				flag = true;
				continue;
			}
			

			//左删除
			mul/=10;
			StringBuilder str1 = new StringBuilder(i+": ");
			temp = i;
			while(temp!=0) {
				str1.append(""+temp+", ");
				if(!HelpUtils.checkPrime(temp)) {
					flag = false;
					break;
				}
				temp%=mul;
				mul/=10;
			}
			
			if(!flag) {
				flag = true;
				continue;
			}
			
			System.out.println(maxCount+"---->"+str.toString());
			System.out.println(maxCount+"---->"+str1.toString()+"\n");
			
			maxCount++;
			sum+=i;
			if(maxCount==11) {
				break;
			}
		}
		long end = System.currentTimeMillis();
		System.out.println("耗时: "+(end-start)/MILLIONS+"ms，结果: "+sum); 
	}
	
	@Test
	public void a38() {
		
	}
	
	@Test
	public void a39() {
		
	}
}
