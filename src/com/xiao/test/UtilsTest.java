package com.xiao.test;

import org.junit.Test;

import java.util.Scanner;

import org.junit.Before;

import org.junit.After;

import com.xiao.entries.HugeLong;
import com.xiao.utils.HelpUtils;
import com.xiao.utils.StringUtils;

public class UtilsTest {
	
	private Scanner scan ;
	
	@Before
	public void init() {
		scan = new Scanner(System.in);
	}
	
	@Test
	public void testHugeLong() {
		HugeLong h = new HugeLong();
		
		
		h.add("-2");
		System.out.println(h);
		h.add("-2");
		System.out.println(h);
		h.add("+8");
		System.out.println(h);
		h.add("+8");
		System.out.println(h);
		h.add("-18");
		System.out.println(h);
		h.add(8);
		System.out.println(h);
		h.add(new HugeLong(12));
		System.out.println(h);
		
	}
	
	@Test
	public void test1() {
		System.out.println(HelpUtils.getMaxCommon(983, 10));
		System.out.println(HelpUtils.getMinCommon(54, 36));
	}
	
	@Test
	public void testjudgeFractions() {
		System.out.println(HelpUtils.judgeFractions(1, 2));
		System.out.println(HelpUtils.judgeFractions(1, 3));
		System.out.println(HelpUtils.judgeFractions(9, 15));
		System.out.println(HelpUtils.judgeFractions(2, 6));
		System.out.println(HelpUtils.judgeFractions(1, 7));
		System.out.println(HelpUtils.judgeFractions(1, 8));
		System.out.println(HelpUtils.judgeFractions(1, 983));
	}
	
	@Test
	public void testGetCircle() {
		String temp = HelpUtils.getCircle(1, 49);
		System.out.println(temp);
		temp = StringUtils.getMaxSameStr(temp);
		System.out.println(temp);
		temp = StringUtils.getMinSameStr(temp);
		System.out.println(temp);
	}
	@After
	public void destory(){
		scan.close();
	}
}
