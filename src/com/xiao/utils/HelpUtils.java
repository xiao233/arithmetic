package com.xiao.utils;

import java.util.ArrayList;
import java.util.List;

public class HelpUtils {
	/**
	 * 判断一个数是否是质数
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
	 * 判断一个数是否是回文数
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
	 * 找出两个数的最大公约数
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
	 * 计算平方和
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
	 * 找除数,最后一项存各个除数之和
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
	 * 计算数各个位之和
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
	 * 判断一个数数几位数
	 * 2018-08-20 17:20:50
	 * @param n
	 * @return
	 */
	public static int judgeDigit(int n) {
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
	 * 判断一个分数是否是无线循环小数，<br/>
	 * 简化分数后，分母只能是2或者5或者包含两者的幂整除<br/>
	 * 2018-08-23 11:42:50
	 * @param numerator 分子
	 * @param denominators 分母
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
	 * 求无线循环小数的小数部分<br/>
	 * 2018-08-23 14:56:31
	 * @param numerator 分子
	 * @param denominators 分母
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
	 * 求两数的最小公倍数
	 * 2018-08-23 13:41:59
	 * @param param1
	 * @param param2
	 * @return
	 */
	public static int getMinCommon(int param1, int param2) {
		return param1*param2/getMaxCommon(param1, param2);
	}
	
	/**
	 * 求两个数的最大公约数
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
}
