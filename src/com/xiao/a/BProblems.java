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
		int min = 200/200;//������
		int max =200/1;//���ٸ���
		
		int count=0;
		for (int i = min; i <= max; i++) {
		
		}
	}
	
	@Test
	public void a32() {
		
		//ac
		
		
		/**
		 * ������
		 * ��Ҫ��������������������λ���պð���1-9
		 * 		�����λ��x��������λ��y,���λ��z<=x+y��z>=x+y-1(x��y��z������0);
		 * 		���ܵ�λ��9=x+y+z>=x+y+x+y-1,��x+y<=5,z<=5;
		 * 		�֣�9=x+y+z<=x+y+x+y,��x+y>=4.5;
		 * 		��Ϊx��y��z��������������x+y=5,z=4;
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
	 * У����
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
	 * ����������������ռλ�����ж��Ƿ��������
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
	 * ��ʼ������
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
		 * ���������ӷ�ĸ������λ�������ӷ�ĸ���ܱ�10������
		 * 	   ����������ҷ��ӷ�ĸ������һ��������ͬ��
		 * 	 ���ӷ�ĸȥ����ͬ������ֵ���ֲ���
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
	 * �ж��������Ƿ����������
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
		System.out.println("��ʱ: "+(end-start)/MILLIONS+"ms");
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
		System.out.println("��ʱ: "+(end-start)/MILLIONS+"ms�����: "+count);
	}
	
	@Test
	public void a36() {
		//ac
		
		
		/**
		 * ʮ������585=1001001001B�������ƣ������ڻ���10��2���ǻ�������
		 * �ҳ�С��һ��������л����������ڻ���10��2���ǻ�������֮�͡�
		 */
		
		long start = System.currentTimeMillis();
		
		long sum=0;
		int max = 1000000;
		
		for(int i = 1 ;i <= max ; i++) {
			if(HelpUtils.judgeDigitalPalindromic(i+"")) {
				String bTemp = HelpUtils.intToBinary(i);
				if(HelpUtils.judgeDigitalPalindromic(bTemp)) {
					//System.out.println(i +" = "+bTemp+"�ǻ�����");
					sum+=i;
				}
			}
		}
		
		long end = System.currentTimeMillis();
		System.out.println("��ʱ: "+(end-start)/MILLIONS+"ms�����: "+sum); 
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
		System.out.println("��ʱ: "+(end-start)/MILLIONS+"ms�����: "+sum); 
	}
	
	@Test
	public void a38() {
		
		//ac
		
		/**
		 * ������Ҫ�õ�����9λ����������9λ987654321������ң��ҵ���һ������Ҫ�����
		 * 	�����Ϊx�������ͷ����x��Ȼ����2x....9x
		 */
		
		int product = 987654321;
		
		
		String data = "";
		loop:for(;product>=123456789;product--) {
			if(!a38check(product)) {//���������1-9�ľ�λ��
				continue;
			}
			data=""+product;
			
			boolean isOk = true;//�Ƿ��������
			
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
					break loop;//�����
					//break;//������
				}
			}
		}
	}
	/**
	 * �������˲�����Ҫ�����
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
		 * �������ܳ�p,�߳�a(��󣩡�b(���)��c(��С)����Ϊ��˳���޹أ����Լٶ���С����a>p/3��
		 * 	��a+b+c=p,��b+c>a,��a<p/2;
		 * 	��ֱ����������a^2=b^2+c^2,��ʽ����p^2=2(bc+pa);
		 * ���ܹ���ֱ�������������ϵ���p
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
