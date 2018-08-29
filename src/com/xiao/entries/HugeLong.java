package com.xiao.entries;
/**
 * 目的：为了解决超大数据（超出long类型最大值）<br/>
 * @author xjl
 * 2018-08-22 17:20:57
 */
public class HugeLong {
	private String value ;
	private String symboy="";
	
	public HugeLong() {
		this.value="0";
	}
	
	public HugeLong(String value) {
		if(value.indexOf("-")==0) {
			this.symboy="-";
			this.value=value.substring(1);
		}else if(value.indexOf("+")==0){
			this.symboy="+";
			this.value=value.substring(1);
		}else {
			this.value=value;
		}
	}
	
	public HugeLong(int value) {
		if(value>0) {
			this.value=value+"";
		}else {
			this.value="-"+value;
		}
	}
	/**
	 * 实现加、减<br/>
	 * 2018-08-22 17:26:12
	 * @param param
	 */
	public void add(HugeLong param) {
		add(param.toString());
	}
	/**
	 * 实现加、减<br/>
	 * 2018-08-22 17:26:12
	 * @param param
	 */
	public void add(String param) {
		String paramSymboy = "";
		if(param.indexOf("-")==0 ) {
			paramSymboy="-";
			param = param.substring(1);
		}
		if(param.indexOf("+")==0) {
			param = param.substring(1);
		}
		if(param.length()>this.value.length()||(param.length()==this.value.length()&&param.compareTo(this.value)>0)) {
			String temp = param;
			param = this.value;
			this.value = temp;
			
			temp = paramSymboy;
			paramSymboy = this.symboy;
			this.symboy = temp;
		}
		
		StringBuilder srcDigit = new StringBuilder(this.value);
		int toHeader = 0;//进位
		int index = 0;
		int currentValue = 0;
		for (int i = srcDigit.length()-1; i >=0 ; i--) {
			if(param.length()>index) {
				if(!this.symboy.equals(paramSymboy)) {
					
					currentValue = Integer.parseInt(srcDigit.substring(i,i+1))
							-Integer.parseInt(param.substring(param.length()-index-1,param.length()-index))+toHeader;
					
				}else {
					currentValue = Integer.parseInt(srcDigit.substring(i,i+1))
							+Integer.parseInt(param.substring(param.length()-index-1,param.length()-index))+toHeader;
				}
				index++;
			}else {
				currentValue = Integer.parseInt(srcDigit.substring(i,i+1))+toHeader;
			}
			
			if(currentValue<0) {
				
				srcDigit.replace(i, i+1, (currentValue%10+10)+"");
				currentValue-=10;
			}else {
				srcDigit.replace(i, i+1, currentValue%10+"");
			}
			toHeader=currentValue/10;
			if(i==0&&toHeader!=0) {
				int temp = toHeader%10;
				toHeader/=10;
				srcDigit.insert(0, (long)Math.abs(temp)+"");
				break;
			}
		}
		this.value=srcDigit.toString();
	}
	/**
	 * 实现加、减<br/>
	 * 2018-08-22 17:26:12
	 * @param param
	 */
	public void add(long param) {
		add(""+param);
	}
	
	public String getValue() {
		deleteNoUseZero();
		return this.symboy+this.value;
	}
	
	public void setValue(String value) {
		this.value=value;
	}
	public long getValueSize() {
		return value.length();
	}

	@Override
	public String toString() {
		deleteNoUseZero();
		return this.symboy+this.value;
	}
	private void deleteNoUseZero() {
		if(this.value.equals("0")) {
			return;
		}
		int i = 0;
		for (; i < this.value.length(); i++) {
			if(this.value.charAt(i)!='0') {
				break;
			}
		}
		this.value=this.value.substring(i);
	}
}
