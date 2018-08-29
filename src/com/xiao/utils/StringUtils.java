package com.xiao.utils;

public class StringUtils {
	
	/**
	 * ��Դ�ַ���������������ַ���������������<br/>
	 * 2018-08-23 15:53:04
	 * @param src
	 * @return
	 */
	public static String getMaxSameStr(String src) {
		
		int i = src.length()/2;
		String maxSubStr = "";
		for (; i>=0; i--) {
			boolean flag = false;
			for (int j = 0; j<src.length()-i; j++) {
				String temp = src.substring(j, j+i);
				String temp1 = src.substring(j+i);
				if(temp1.indexOf(temp)==0) {
					maxSubStr=temp;
					flag = true;
					break;
				}
			}
			if(flag) {
				break;
			}
		}
		return maxSubStr;
	}
	
	/**
	 * ��Դ�ַ�����С�Ӵ���Դ�ַ������Ӵ��޷����ӣ�,<br/>
	 * 2018-08-23 16:35:47
	 * @param src
	 * @return
	 */
	public static String getMinSameStr(String src) {
		String str = "";
		for (int i = 0; i < src.length(); i++) {
			if(i==src.length()/2) {
				str=src;
				break;
			}
			str = src.substring(0,i+1);
			boolean flag = true;
			for (int j = i+1; j < src.length(); j+=str.length()) {
				String a = src.substring(j,str.length()+j);
				if(!a.equals(str)) {
					flag=false;
					break;
				}
			}
			if(flag) {
				break;
			}
		}
		return str;
	}
}
