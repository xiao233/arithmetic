package com.xiao.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HelpUtils {
	/**
	 * �ж�һ�����Ƿ�������
	 * 2018-08-09 16:30:44
	 * @param n
	 * @return
	 */
	public static boolean checkPrime(long n) {
		boolean flag = true;
		if(n<=1) {
			return false;
		}
		for(int i = 2; i <= Math.sqrt(n+1);i++) {
			if(n%i == 0) {
				flag = false;
				break;
			}
		}
		return flag;
	}

	/**
	 * �ж�һ�����Ƿ��ǻ�����
	 * 2018-08-09 16:54:07
	 * @param n
	 * @return
	 */
	public static boolean checkIsPalindromic(int n) {
		String nStr = n+"";
		boolean flag = false;
		char nstr[] = nStr.toCharArray();
		char strn[] = new char[nstr.length];
		for(int i = 0;i<nstr.length;i++) {
			strn[nstr.length-1-i]=nstr[i];
		}
		if(String.valueOf(nstr).equals(String.valueOf(strn))) {
			flag = true;
		}
		return flag;
	}
	
	/**
	 * �ҳ������������Լ��
	 * 2018-08-09 17:29:34
	 * @param prime1
	 * @param prime2
	 * @return
	 */
	public static int findMaxCommonPrime(int prime1 , int prime2) {
		int max = Math.max(prime1, prime2);
		int min = Math.min(prime1, prime2);
		
		int leave = max%min;
		while(leave!=0) {
			max = min;
			min = leave;
			leave = max%min;
		}
		return min;
	}
	
	/**
	 * ����ƽ����
	 * 2018-08-09 17:50:10
	 * @param start
	 * @param end
	 * @return
	 */
	public static long calSumOfPower(int start,int end) {
		if(start>end) {
			return -1;
		}
		
		long sum = 0L;
		for(;start<=end;start++) {
			sum+=start*start;
		}
		return sum;
	}
	
	/**
	 * �ҳ���,���һ����������֮��
	 * 2018-08-10 10:10:01
	 * @param n
	 * @return
	 */
	public static List<Long> findDiviors(long n){
		List<Long> list = new ArrayList<Long>();
		long sum = 0;
		for(long i =1;i<=n;i++) {
			if(n%i==0) {
				sum+=i;
				list.add(i);
			}
		}
		list.add(sum);
		return list;
	}
	
	/**
	 * ����������λ֮��
	 * 2018-08-10 16:25:06
	 * @param n
	 * @return
	 */
	public static int sumOfEveryBit(long n) {
		int temp = 0;
		int sum = 0;
		while(true) {
			temp = (int) (n%10);
			sum+=temp;
			n = n/10;
			if(n==0) {
				break;
			}
		}
		return sum;
	}
	/**
	 * �ж�һ��������λ��
	 * 2018-08-20 17:20:50
	 * @param n
	 * @return
	 */
	public static int judgeDigit(long n) {
		int size = 0;
		while(true) {
			n/=10;
			
			size++;
			if(n==0) {
				break;
			}
		}
		
		return size;
	}
	
	/**
	 * �ж�һ�������Ƿ�������ѭ��С����<br/>
	 * �򻯷����󣬷�ĸֻ����2����5���߰������ߵ�������<br/>
	 * 2018-08-23 11:42:50
	 * @param numerator ����
	 * @param denominators ��ĸ
	 * @return
	 */
	public static boolean judgeFractions (int numerator,int denominators ) {
		int maxCommon = getMaxCommon(numerator, denominators);
		numerator/=maxCommon;
		denominators/=maxCommon;
		boolean flag = false;
		if(getMaxCommon(10, denominators)==1) {
			flag=true;
		}
		
		return flag;
	}
	
	/**
	 * *
	 * ������ѭ��С����С������<br/>
	 * 2018-08-23 14:56:31
	 * @param numerator ����
	 * @param denominators ��ĸ
	 * @return
	 */
	public static String getCircle(int numerator,int denominators) {
		numerator%=denominators;
		String rs ="";
		int result=0;
		//int length = judgeDigit(denominators);
		for (int i = 1; i < denominators*2; i++) {
			//int temp = (int) (numerator*Math.pow(10, length));
			int temp = numerator*10;
			result = temp/denominators;
			numerator=temp%denominators;
			
			/*if(result!=0 && rs.indexOf(""+result)>=0) {
				rs=rs.substring(rs.indexOf(""+result));
				break;
			}*/
			rs+=result;
		}
		return rs;
	}
	/**
	 * ����������С������
	 * 2018-08-23 13:41:59
	 * @param param1
	 * @param param2
	 * @return
	 */
	public static int getMinCommon(int param1, int param2) {
		return param1*param2/getMaxCommon(param1, param2);
	}
	
	/**
	 * �������������Լ��
	 * 2018-08-23 13:43:32
	 * @param param1
	 * @param param2
	 * @return
	 */
	public static int getMaxCommon(int param1, int param2) {
		
		if(param1<param2) {
			int temp = param2;
			param2 = param1;
			param1 = temp;
		}
		
		while(param2>0) {
			int temp = param2;
			param2 = param1%param2;
			param1 = temp;
		}
		return param1;
	}
	
	/**
	 * ��һ�����Ľ׳�
	 * 2018-09-04 16:53:50
	 * @param n
	 * @return
	 */
	public static long getDigital(int n) {
		if(n==0) {
			return 1;
		}
		int mul =1;
		for (int i = 1; i <= n; i++) {
			mul*=i;
		}
		return mul;
	}

	/**
	 * ��ȡ���ֵ�ÿһλ
	 * 2018-09-04 17:08:50
	 * @param i
	 * @return
	 */
	public static List<Integer> getBits(long i) {
		List<Integer> bits = new ArrayList<Integer>();
		while(i!=0) {
			int temp = (int) (i%10);
			i/=10;
			bits.add(temp);
		}
		return bits;
	}
	
	/**
	 * ����Ԫ�ؼ�src��ȡ��ͬ������ִ�<br/>
	 * 2018-09-04 17:58:54
	 * @param src
	 * @return
	 */
	public static List<String> getSameBitsDifferentDigital(String []src){
		
		List<String> result = new ArrayList<String>();
		long max = getDigital(src.length);
		for (long i = 0; i < max; i++) {
			String src0[] = Arrays.copyOf(src, src.length);
			String temp = getIndexData(src0, i,max);
			result.add(temp);
		}
		return result;
	}
	
	/**
	 * ����Ԫ�ؼ���ȡ�Ĳ�ͬ����ָ��˳����ַ���,��0��ʼ
	 * 2018-09-04 18:00:56
	 * @param src
	 * @param index
	 * @return
	 */
	public static String getIndexData(String []src,long index,long max) {
		int dataLenth = src.length;
		
		//long src_index = index;
		
		String rs = "";
		for(int i = dataLenth;i >= 1;i--) {
			long e = max/i;
			if(index==0) {
				break;
			}
			int bit = (int) (index/e);
			index%=e;
			max/=i;
			rs+=bit;
		}
		String result ="";
		for (int i = 0; i < rs.length(); i++) {
			int temp = rs.charAt(i)-'0';
			int position = -1;
			for (int j = 0; j < src.length; j++) {
				if(!src[j].equals("#")) {
					position++;
				}
				if(position==temp) {
					result+=src[j];
					src[j]="#";
					break;
				}
			}
		}
		
		for (int i = 0; i < src.length; i++) {
			if(!src[i].equals("#")) {
				result+=src[i];
			}
		}
		//System.out.println("index: "+src_index+" ,result: "+result);
		return result;
	}

	/**
	 * ��ȡһ���ַ�����ѭ����<br/>
	 * �磺123-->231-->312
	 * 2018-09-05 10:53:00
	 * @param string
	 * @return
	 */
	public static List<String> getCircleDigital(String string) {
		List<String> result = new ArrayList<String>();
		result.add(string);
		for (int i = 0; i < string.length()-1; i++) {
			String firstChar = string.substring(0, 1);
			string = string.substring(1,string.length())+firstChar;
			result.add(string);
		}
		return result;
	}
	
	/**
	 * ʮ����ת������
	 * 2018-09-06 09:19:19
	 * @param src
	 * @return
	 */
	public static String intToBinary(int src) {
		StringBuilder result = new StringBuilder();
		while(src!=0) {
			result.insert(0, src%2);
			src/=2;
		}
		return result.toString();
	}
	
	/**
	 * �ж�һ���ַ����Ƿ��ǻ��ĵ�
	 * 2018-09-06 09:27:35
	 * @param src
	 * @return
	 */
	public static boolean judgeDigitalPalindromic (String src) {
		return src.equals(new StringBuilder(src).reverse().toString())?true:false;
	}
}
