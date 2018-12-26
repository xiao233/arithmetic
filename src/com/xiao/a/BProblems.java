package com.xiao.a;

import org.junit.Before;
import org.junit.Test;

import com.xiao.utils.HelpUtils;

import java.util.Arrays;
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
		
		//ac
		
		
		/**
		 * 分析：
		 * 若要乘数、被乘数、积各个位数刚好包含1-9
		 * 		令：乘数位数x，被乘数位数y,则积位数z<=x+y且z>=x+y-1(x、y、z不等于0);
		 * 		则：总的位数9=x+y+z>=x+y+x+y-1,得x+y<=5,z<=5;
		 * 		又：9=x+y+z<=x+y+x+y,得x+y>=4.5;
		 * 		因为x、y、z都是正整数，则x+y=5,z=4;
		 */
		
		int zStart = 1234;
		int zEnd = 9876;
		long sum = 0;
		
		int flag[]=new int[9];
		
		for (; zStart <= zEnd; zStart++) {
			a32Init(flag);
			boolean isOk = a32Check(flag,zStart);
			if(!isOk) {
				continue;
			}
			for (int i = 2; i <= zStart; i++) {
				int flagTemp[] = Arrays.copyOf(flag,flag.length);
				if(zStart%i==0&&a32Check(flagTemp,i)&&a32Check(flagTemp,zStart/i)
						&&a32CheckRs(flagTemp)) {
					System.out.println(i+" * "+(zStart/i)+" = "+zStart);
					sum+=zStart;
					break;
				}
			}
		}
		System.out.println("sum: "+sum);
	}
	
	/**
	 * 校验结果
	 * 2018-12-25 17:21:55
	 * @param flagTemp
	 * @return
	 */
	private boolean a32CheckRs(int[] flagTemp) {
		for (int i = 0; i < flagTemp.length; i++) {
			if(flagTemp[i]==0) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 乘数、被乘数、积占位，并判断是否符合条件
	 * 2018-12-25 16:42:05
	 * @param flag
	 * @param zStart
	 * @return
	 */
	private boolean a32Check(int[] flag, int zStart) {
		
		int left = zStart%10;
		
		while(zStart!=0) {
			if(left==0) {
				return false;
			}
			if(flag[left-1]==1) {
				return false;
			}
			flag[left-1]=1;
			zStart/=10;
			left = zStart%10;
		}
		return true;
	}

	/**
	 * 初始化数组
	 * 2018-12-25 16:41:47
	 * @param flag
	 */
	private void a32Init(int[] flag) {
		for (int i = 0; i < flag.length; i++) {
			flag[i]=0;
		}
		
	}

	@Test
	public void a33() {
		
		//ac
		
		/**
		 * 分析：分子分母都是两位数，分子分母不能被10整除；
		 * 	   是真分数，且分子分母至少有一个数字相同；
		 * 	 分子分母去掉相同的数后，值保持不变
		 */
		
		int upStart = 11;
		int downStart = upStart;
		
		int upPro =1 ;
		int downPro = 1;
		
		for (; upStart <= 99; upStart++) {
			if(upStart%10==0) {
				continue;
			}
			for (downStart=upStart+1; downStart <= 99; downStart++) {
				if(downStart%10==0) {
					continue;
				}
				boolean isOk = a33check(upStart,downStart);
				if(isOk) {
					upPro*=upStart;
					downPro*=downStart;
				}
			}
		}
		System.out.println("rs: "+downPro/upPro);
	}
	
	/**
	 * 判断两个数是否存满足条件
	 * 2018-12-25 17:38:22
	 * @param upStart
	 * @param downStart
	 * @return
	 */
	private boolean a33check(int upStart, int downStart) {
		char up[]=(""+upStart).toCharArray();
		char down[]=(""+downStart).toCharArray();
		
		int upLeft = 0;
		int downLeft = 0;
		for (int i = 0; i < down.length; i++) {
			for (int j = 0; j < up.length; j++) {
				if(down[i]==up[j]) {
					down[i]=up[j]=' ';
					break;
				}
			}
		}
		
		int countSame = 0;
		for (int i = 0; i < down.length; i++) {
			if(down[i]!=' ') {
				downLeft = down[i]-'0';
			}else {
				countSame++;
			}
		}
		
		if(countSame!=1) {
			return false;
		}
		for (int j = 0; j < up.length; j++) {
			if(up[j]!=' ') {
				upLeft = up[j]-'0';
			}
		}
		if(upLeft*downStart==upStart*downLeft) {
			System.out.println("upStart: "+upStart+" ,downStart: "+downStart
					+", upLeft: "+upLeft+" ,downLeft: "+downLeft);
			return true;
		}
		return false;
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
		
		//ac
		
		
		long start = System.currentTimeMillis();
		long sum = 0;
		int n = 0;
		
		int j =11;
		while(true) {
			if(n==11) {
				break;
			}
			if(j%10==1||j%2==0||j%9==0) {
				j++;
				continue;
			}
			
			String data = ""+j;
			boolean flag = true;
			for (int i = 0; i < data.length(); i++) {
				if(!HelpUtils.checkPrime(Long.parseLong(data.substring(0, data.length()-i)))
						||!HelpUtils.checkPrime(Long.parseLong(data.substring(i, data.length())))) {
					flag = false;
				}
			}
			if(flag) {
				n++;
				sum+=j;
				System.out.println("n: "+n+" ,j: "+j);
			}
			j++;
		}
		long end = System.currentTimeMillis();
		System.out.println("耗时: "+(end-start)/MILLIONS+"ms，结果: "+sum); 
	}
	
	@Test
	public void a38() {
		
		//ac
		
		/**
		 * 分析：要得到最大的9位数，则从最大9位987654321逆序查找，找到第一个符合要求的数
		 * 	令乘数为x，则结果最开头存在x，然后是2x....9x
		 */
		
		int product = 987654321;
		
		
		String data = "";
		loop:for(;product>=123456789;product--) {
			if(!a38check(product)) {//数必须包含1-9的九位数
				continue;
			}
			data=""+product;
			
			boolean isOk = true;//是否符合条件
			
			for (int i = 1; i < data.length()-1; i++) {
				
				isOk= true;
				
				int n = 1;
				int x = Integer.parseInt(data.substring(0, i));
				int productLength = 0;
				String left = data.substring(0,data.length());
				while(true) {
					int mul = n*x;
					if(left.indexOf(""+mul)!=0) {
						isOk = false;
						break;
					}
					productLength+=(""+mul).length();
					if(productLength==data.length()) {
						break;
					}
					n++;
					//System.out.println(data+" ,productLength: "+productLength+" ,mul:"+mul+" ,left: "+left);
					left=data.substring(productLength,data.length());
				}
				if(isOk) {
					System.out.println("x: "+x+", n: "+n+" ,product: "+product);
					break loop;//查最大
					//break;//查所有
				}
			}
		}
	}
	/**
	 * 初步过滤不符合要求的数
	 * 2018-12-26 10:35:25
	 * @param product
	 * @return
	 */
	private boolean a38check(int product) {
		char data [] = (""+product).toCharArray();
		
		int flag[] = new int[10];
		for (int i = 0; i < data.length; i++) {
			int index = data[i]-'0';
			if(index==0||flag[index]==1) {
				return false;
			}
			
			flag[index]=1;
		}
		//System.out.println("product------"+product);
		return true;
	}

	@Test
	public void a39() {
		
		//ac
		
		/**
		 * 分析：周长p,边长a(最大）、b(其次)、c(最小)，因为跟顺序无关，所以假定大小，则a>p/3；
		 * 	则：a+b+c=p,又b+c>a,则a<p/2;
		 * 	又直角三角形有a^2=b^2+c^2,公式换算p^2=2(bc+pa);
		 * 求能构成直角三角形最多组合的数p
		 */
		
		int pMax = 1000;
		int countMax = 0;
		int mx = 0;
		
		for (; pMax>=4; pMax--) {
			int count = 0;
			for (int a = pMax/3+1; a < pMax/2; a++) {
				for (int c = 1; c < pMax/3-1; c++) {
					if(pMax*pMax==2*(pMax*a+c*(pMax-a-c))) {
						count++;
						//System.out.println("p: "+pMax+" ,a: "+a+" ,b: "+(pMax-a-c)+" ,c: "+c);
					}
				}
			}
			if(countMax<count) {
				countMax=count;
				mx = pMax;
			}
		}
		System.out.println("mx: " +mx+" ,countMax: "+countMax);
	}
}
