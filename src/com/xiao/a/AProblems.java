package com.xiao.a;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

import org.junit.Before;
import org.junit.Test;

import com.xiao.entries.HugeLong;
import com.xiao.utils.HelpUtils;
import com.xiao.utils.StringUtils;
public class AProblems {
	private Scanner scan = null;
	
	@Before
	public void init() {
		scan = new Scanner(System.in);
	}
	@Test
	public void a1() {
		
		//ac
		int sum = 0;
		for(int i = 1 ;i<1000;i++) {
			if(i%3==0 || i%5==0) {
				sum+=i;
			}
		}
		System.out.println(sum);
	}
	
	@Test
	public void a2() {
		//ac
		int f1 =1;
		int f2 =2;
		int temp=0;
		int result = f2;
		while(true) {
			
			temp=f1;
			f1=f2;
			f2=temp+f2;
			if(f2>4000000) {
				break;
			}
			if(f2%2==0) {
				result+=f2;
			}
			
			System.out.println(f2);
		}
		System.out.println(result);
	}
	
	@Test
	public void a3() {
		long mul = 600851475143L ;
		//ac
		long maxPrime = 1L;
		for(long i = 2;i<=Math.sqrt(mul+1);i++) {
			if(mul%i==0 && HelpUtils.checkPrime(i)) {
				if(i>maxPrime) {
					maxPrime = i;
					System.out.println(i);
				}
			}
		}
		System.out.println("max value: "+maxPrime);
	}
	
	@Test
	public void a4() {
		//ac
		int max = 0;
		for(int i = 100;i<1000;i++) {
			for(int j =100;j<1000;j++) {
				if(HelpUtils.checkIsPalindromic(i*j)) {
					System.out.println(i+" + "+j+" = "+j*i);
					if(j*i>max)
					max = i*j;
				}
			}
		}
		System.out.println("max: "+max);
	}
	
	@Test
	public void a5() {
		//ac
		long min = 1;
		for(int i = 2;i<= 20;i++) {
			if(!HelpUtils.checkPrime(i)) {
				int maxCommon = HelpUtils.findMaxCommonPrime((int)min, i);
				System.out.println(min+"与"+i+"的最大公约数： "+maxCommon);
				min = min*i/maxCommon;
			}else {
				min*=i;
			}
		}
		System.out.println("min: "+min);
	}
	
	@Test
	public void a6() {
		//ac
		long sumPower = (50*(1+100))*(50*(1+100));
		System.out.println(sumPower-HelpUtils.calSumOfPower(1, 10));
		
	}
	@Test
	public void a7() {
		//ac
		int i  = 0;
		int max = 10001;
		long j = 2;
		
		while(true) {
			if(HelpUtils.checkPrime(j)) {
				i++;
			}
			if(i==max) {
				System.out.println(j);
				break;
			}
			j++;
		}
	}
	
	@Test
	public void a8() {
		//ac
		String str="73167176531330624919225119674426574742355349194934" + 
				"96983520312774506326239578318016984801869478851843" + 
				"85861560789112949495459501737958331952853208805511" + 
				"12540698747158523863050715693290963295227443043557" + 
				"66896648950445244523161731856403098711121722383113" + 
				"62229893423380308135336276614282806444486645238749" + 
				"30358907296290491560440772390713810515859307960866" + 
				"70172427121883998797908792274921901699720888093776" + 
				"65727333001053367881220235421809751254540594752243" + 
				"52584907711670556013604839586446706324415722155397" + 
				"53697817977846174064955149290862569321978468622482" + 
				"83972241375657056057490261407972968652414535100474" + 
				"82166370484403199890008895243450658541227588666881" + 
				"16427171479924442928230863465674813919123162824586" + 
				"17866458359124566529476545682848912883142607690042" + 
				"24219022671055626321111109370544217506941658960408" + 
				"07198403850962455444362981230987879927244284909188" + 
				"84580156166097919133875499200524063689912560717606" + 
				"05886116467109405077541002256983155200055935729725" + 
				"71636269561882670428252483600823257530420752963450";
		
		char strs[] = str.toCharArray();
		long max = 0;
		int k = -1;
		
		
		for (int i = 0; i < strs.length-13; i++) {
			long mul = strs[i]-'0';
			for (int j = i+1; j < i+13; j++) {
				 mul*=(strs[j]-'0');
			}
			if(mul>max) {
				k = i;
				max = mul;
			}
		}
		System.out.println("from "+k+" start: "+max);
	}
	
	@Test
	public void a9() {
		//ac
		for (int a = 1; a < 333; a++) {
			for (int b = a+1; b < 500; b++) {
				if(a*a+b*b==(1000-a-b)*(1000-a-b)) {
					System.out.println("a: "+a+" b: "+b+" c: "+(1000-a-b));
					System.out.println(a*b*(1000-a-b));
				}
			}
		}
	}
	
	@Test
	public void a10() {
		//ac
		int end = 2000000;
		long sum = 0L;
		
		for(int i=2;i<=end;i++) {
			if(HelpUtils.checkPrime(i)) {
				sum+=i;
			}
		}
		System.out.println(sum);
	}
	
	@Test
	public void a11() {
		//can not understand the question
	}
	
	@Test
	public void a12() {
		//error answer
		long n = 0;
		int max = 480;
		for(long i =27754975;;i++) {
			n+=i;
			List<Long> list = HelpUtils.findDiviors(n);
			if(list.size()>max) {
				max = list.size();
			}
			if(list.size()>=500) {
				System.out.println(n+": "+list.size()+"---"+max+"==="+list);
				break;
			}
		}
	}
	
	@Test
	public void a13() {
		
		//ac *
		String data = 
				"37107287533902102798797998220837590246510135740250" + 
				"46376937677490009712648124896970078050417018260538" + 
				"74324986199524741059474233309513058123726617309629" + 
				"91942213363574161572522430563301811072406154908250" + 
				"23067588207539346171171980310421047513778063246676" + 
				"89261670696623633820136378418383684178734361726757" + 
				"28112879812849979408065481931592621691275889832738" + 
				"44274228917432520321923589422876796487670272189318" + 
				"47451445736001306439091167216856844588711603153276" + 
				"70386486105843025439939619828917593665686757934951" + 
				"62176457141856560629502157223196586755079324193331" + 
				"64906352462741904929101432445813822663347944758178" + 
				"92575867718337217661963751590579239728245598838407" + 
				"58203565325359399008402633568948830189458628227828" + 
				"80181199384826282014278194139940567587151170094390" + 
				"35398664372827112653829987240784473053190104293586" + 
				"86515506006295864861532075273371959191420517255829" + 
				"71693888707715466499115593487603532921714970056938" + 
				"54370070576826684624621495650076471787294438377604" + 
				"53282654108756828443191190634694037855217779295145" + 
				"36123272525000296071075082563815656710885258350721" + 
				"45876576172410976447339110607218265236877223636045" + 
				"17423706905851860660448207621209813287860733969412" + 
				"81142660418086830619328460811191061556940512689692" + 
				"51934325451728388641918047049293215058642563049483" +
				"62467221648435076201727918039944693004732956340691" + 
				"15732444386908125794514089057706229429197107928209" + 
				"55037687525678773091862540744969844508330393682126" + 
				"18336384825330154686196124348767681297534375946515" + 
				"80386287592878490201521685554828717201219257766954" + 
				"78182833757993103614740356856449095527097864797581" + 
				"16726320100436897842553539920931837441497806860984" + 
				"48403098129077791799088218795327364475675590848030" + 
				"87086987551392711854517078544161852424320693150332" + 
				"59959406895756536782107074926966537676326235447210" + 
				"69793950679652694742597709739166693763042633987085" + 
				"41052684708299085211399427365734116182760315001271" + 
				"65378607361501080857009149939512557028198746004375" + 
				"35829035317434717326932123578154982629742552737307" + 
				"94953759765105305946966067683156574377167401875275" + 
				"88902802571733229619176668713819931811048770190271" + 
				"25267680276078003013678680992525463401061632866526" + 
				"36270218540497705585629946580636237993140746255962" + 
				"24074486908231174977792365466257246923322810917141" + 
				"91430288197103288597806669760892938638285025333403" +
				"34413065578016127815921815005561868836468420090470" + 
				"23053081172816430487623791969842487255036638784583" + 
				"11487696932154902810424020138335124462181441773470" + 
				"63783299490636259666498587618221225225512486764533" + 
				"67720186971698544312419572409913959008952310058822" +
				"95548255300263520781532296796249481641953868218774" + 
				"76085327132285723110424803456124867697064507995236" + 
				"37774242535411291684276865538926205024910326572967" + 
				"23701913275725675285653248258265463092207058596522" + 
				"29798860272258331913126375147341994889534765745501" + 
				"18495701454879288984856827726077713721403798879715" + 
				"38298203783031473527721580348144513491373226651381" + 
				"34829543829199918180278916522431027392251122869539" + 
				"40957953066405232632538044100059654939159879593635" + 
				"29746152185502371307642255121183693803580388584903" + 
				"41698116222072977186158236678424689157993532961922" + 
				"62467957194401269043877107275048102390895523597457" + 
				"23189706772547915061505504953922979530901129967519" + 
				"86188088225875314529584099251203829009407770775672" + 
				"11306739708304724483816533873502340845647058077308" + 
				"82959174767140363198008187129011875491310547126581" + 
				"97623331044818386269515456334926366572897563400500" + 
				"42846280183517070527831839425882145521227251250327" + 
				"55121603546981200581762165212827652751691296897789" + 
				"32238195734329339946437501907836945765883352399886" + 
				"75506164965184775180738168837861091527357929701337" + 
				"62177842752192623401942399639168044983993173312731" + 
				"32924185707147349566916674687634660915035914677504" + 
				"99518671430235219628894890102423325116913619626622" + 
				"73267460800591547471830798392868535206946944540724" + 
				"76841822524674417161514036427982273348055556214818" + 
				"97142617910342598647204516893989422179826088076852" + 
				"87783646182799346313767754307809363333018982642090" + 
				"10848802521674670883215120185883543223812876952786" + 
				"71329612474782464538636993009049310363619763878039" + 
				"62184073572399794223406235393808339651327408011116" + 
				"66627891981488087797941876876144230030984490851411" + 
				"60661826293682836764744779239180335110989069790714" + 
				"85786944089552990653640447425576083659976645795096" + 
				"66024396409905389607120198219976047599490197230297" + 
				"64913982680032973156037120041377903785566085089252" + 
				"16730939319872750275468906903707539413042652315011" + 
				"94809377245048795150954100921645863754710598436791" + 
				"78639167021187492431995700641917969777599028300699" + 
				"15368713711936614952811305876380278410754449733078" + 
				"40789923115535562561142322423255033685442488917353" + 
				"44889911501440648020369068063960672322193204149535" + 
				"41503128880339536053299340368006977710650566631954" + 
				"81234880673210146739058568557934581403627822703280" + 
				"82616570773948327592232845941706525094512325230608" + 
				"22918802058777319719839450180888072429661980811197" + 
				"77158542502016545090413245809786882778948721859617" + 
				"72107838435069186155435662884062257473692284509516" + 
				"20849603980134001723930671666823555245252804609722" + 
				"53503534226472524250874054075591789781264330331690";
		
		String datas[] = new String[100];
		
		System.out.println(data.length());
		
		for (int i = 0; i < datas.length; i++) {
			datas[i]=data.substring(i*50, i*50+50);
		}
		int columns[] = new int[50];
		for (int i = 0; i < columns.length; i++) {
			int sum = 0;
			for (int j = 0; j < datas.length; j++) {
				char temp = datas[j].charAt(i);
				sum+=(temp-'0');
			}
			columns[i]=sum;
			System.out.println("i: "+sum);
		}
		
		
		int n = 0;//进位
		for (int i = columns.length-1; i>=0; i--) {
			columns[i]+=n;
			n = columns[i]/10;
			columns[i]=columns[i]%10;
			System.out.println("i---"+columns[i]);
			System.out.println("n---"+n);
		}
		
		System.out.print(n);
		for (int i = 0; i < columns.length; i++) {
			System.out.print("_"+columns[i]);
		}
		
		
	}
	
	@Test
	public void a14() {
		//ac
		long m = 1000000;
		int max = 0;
		long index = 0;
		for(;m>0;m--) {
			long start = m;
			int i=1;
			while(start!=1) {
				if(start%2==0) {
					start=start/2;
				}else {
					start=3*start+1;
				}
				
				i++;
			}
			System.out.println(m+"---"+i);
			if(i>max) {
				index = m;
				max = i;
			}
		}
		System.out.println(index+"===="+max);
	}
	
	@Test
	public void a15() {
		//can not 
		int n = 20;
		System.out.println((long)Math.pow(2, n)+2*(n-1));
		
		int m = 2;
		for (int i = 2; i <= 20; i++) {
			m=m+2*i;
			System.out.println(i+": "+m);
		}
		System.out.println(m);
	}
	
	@Test
	public void a16() {
		
		//ac *
		int n = 1000;
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		for (int i = 1; i <= n; i++) {
			int m = 0;
			for (int j =0; j<list.size() ; j++) {
				int curr = list.get(j)*2;
				curr+=m;
				int temp = curr%10;
				m=curr/10;
				list.set(j, temp);
				if(m>0&&j==list.size()-1) {
					list.add(m);
					break;
				}
			}
			System.out.println(i+"---"+list);
		}
		int sum = 0;
		for (Integer integer : list) {
			sum+=integer;
		}
		System.out.println(sum);
	}
	
	@Test
	public void a17() {
		//It's diffcult to prepare data to program
	}
	
	@Test
	public void a18() {
		
	}
	
	@Test
	public void a19() {
		
	}
	@Test
	public void a20() {
		//ac*
		StringBuilder result = new StringBuilder("1");
		StringBuilder exp = new StringBuilder("1");
		int n = 1000;
		for (int i = 2; i <= n; i++) {
			int temp = 0;//前进位
			
			exp.append("*"+i);
			for (int j = 0; j < result.length(); j++) {
				String bitValue = result.substring(j, j+1);
				int tempRs = Integer.parseInt(bitValue)*i+temp;
				result.replace(j, j+1, ""+tempRs%10);
				temp = tempRs/10;
				if(temp>0 && j==result.length()-1) {
					while(temp!=0) {
						result.append(""+temp%10);
						temp/=10;
					}
					break;
				}
			}
			StringBuilder resultTemp = new StringBuilder(result.toString());
			System.out.println(i+"的阶乘是: "+exp+" = "+resultTemp.reverse().toString());
		}
		System.out.println(n+"的阶乘是: "+result.reverse().toString());
		System.out.println(n+"的阶乘长度: "+result.length());
		int sum = 0;
		for (int i = 0; i < result.length(); i++) {
			sum+=Integer.parseInt(result.substring(i, i+1));
		}
		System.out.println("sum: "+sum);
	}
	
	@Test
	public void a21() {
		//ac
		int n = 10000;
		long sum = 0;
		for (int i = 2; i <= n; i++) {
			List<Long> div = HelpUtils.findDiviors(i);
			//System.out.println(i+": "+div);
			long temp = div.get(div.size()-1)-i;
			List<Long> div1 = HelpUtils.findDiviors(temp);
			long temp1 = div1.get(div1.size()-1)-temp;
			
			if(i==temp1 && i!=temp) {
				System.out.println("d(a) = "+i+",d(b) = "+temp);
				sum+=i;
			}
		}
		System.out.println("sum: "+sum);
	}
	
	@Test
	public void a22() throws IOException {
		
		//ac
		URL url = new URL("https://projecteuler.net/project/resources/p022_names.txt");
		InputStream is = url.openStream();
		
		int con = 0;
		
		TreeMap<String,Integer> map = new TreeMap<String, Integer>();
		
		int index = 1;//单词位置
		int values = 0;//单词各个字母的值
		String word = "";//各个单词
		long scores = 0;
		String bit ="";
		
		int even = 0;//是否是闭双引号,1表示不是
		while((con=is.read())>0) {
			if(con=='"') {
				even++;
			}else if(con==',') {
				continue;
			}else {
				word+=(char)con;
				bit+=con-'A'+1+"_";
				values+=con-'A'+1;
			}
			if(even%2==0) {
				System.out.println(index+": "+word+"--->"+bit+"--->"+values);
				map.put(word, values);
				even=0;
				values=0;
				word="";
				bit="";
				index++;
			}
		}
		
		int iindex=1;
		for(Entry<String,Integer> entry:map.entrySet()) {
			scores+=entry.getValue()*iindex;
			iindex++;
		}
		System.out.println("scores: "+scores);
		
	}
	
	@Test
	public void a23() {
		//not get correct answer,maybe I can not understand the problem correctly.
		int max = 28223;
		int sum = 1;
		long start = System.currentTimeMillis();
		for(int i = 2; i <= max;i++) {
			boolean flag = false;
			
			if(!flag) {
				sum+=i;
			}
			
		}
		long end = System.currentTimeMillis();
		System.out.println("耗时: "+(end-start)*1.0/1000+"秒，sum: "+sum);
	}
	
	/**
	 * judge a digit is a abundant（充裕的） number
	 * 2018-08-22 10:34:44
	 * @param j
	 * @return
	 */
	private boolean a23JudgeAbundant(int j) {
		List<Long> divisors = HelpUtils.findDiviors(j);
		long divisorSum = divisors.get(divisors.size()-1)-j;
		return divisorSum>j?true:false;
	}
	@Test
	public void a24() {
		String data[]= {"0","1","2","3","4","5","6","7","8","9"};//源数组
		//ac**
		int n = data.length;//源数组个数
		int mul = 1;
		
		//第多少个，从0开始
		int index = 999999;
		
		for(int i = 1;i <= n; i++) {
			mul*=i;
		}
		
		
		/**
		 * 找到各个位在源数组的位置，用过的数据置为“#”,不计入个数
		 */
		String rs = "";
		int sum=0;
		for(int i = n;i > 0; i--) {
			int e = mul/i;
			int bit = index/e;
			if(index==0) {
				break;
			}
			index%=e;
			mul/=i;
			rs+=bit;
			sum+=e*bit;
			System.out.println("e: " + e+" ,index: "+index+" ,rs: "+rs+" ,sum: "+sum);
		}
		String result ="";
		
		/**
		 * 将对应的位置转换成对应的值
		 */
		for (int i = 0; i < rs.length(); i++) {
			int temp = Integer.parseInt(rs.charAt(i)+"");
			String bitChar = getBitChar(temp,data);
			result+=bitChar;
			System.out.println("result: "+result);
		}
		System.out.println("result: "+result+getLeave(data));
	}
	/**
	 * 获取有序遗留字符串
	 * 2018-08-22 17:12:28
	 * @param data
	 * @return
	 */
	private String getLeave(String[] data) {
		String temp = "";
		for (int i = 0; i < data.length; i++) {
			if(!data[i].equals("#")) {
				temp+=data[i];
			}
		}
		return temp;
	}
	/**
	 * 获取每位的值
	 */
	private String getBitChar(int temp,String data[]) {
		String position="";
		int count=0;
		for (int i = 0; i < data.length; i++) {
			if(!data[i].equals("#")) {
				if(count==temp) {
					position=data[i];
					data[i]="#";
					break;
				}
				count++;
			}
		}
		return position;
	}
	@Test
	public void a25() {
		
		//ac*
		HugeLong hl = new HugeLong();
		HugeLong f1 = new HugeLong(1);
		HugeLong f2 = new HugeLong(1);
		
		int index =2;
		while(true) {
			System.out.println("f"+index+": "+f2);
			if(f2.getValueSize()==1000) {
				break;
			}
			index++;
			hl.setValue(f1.getValue());
			f1.setValue(f2.getValue());
			f2.add(hl);
		}
		System.out.println("index:"+index);
	}
	
	@Test
	public void a26() {
		
		//ac**
		int d =1000;
		int maxLength = 0;
		int maxIndex = -1;
		for (int i = 2; i < d; i++) {
			if(HelpUtils.judgeFractions(1, i)) {//是无线循环小数
				String temp = HelpUtils.getCircle(1, i);
				temp = StringUtils.getMaxSameStr(temp);
				temp = StringUtils.getMinSameStr(temp);
				if(temp.length()>maxLength) {
					maxLength=temp.length();
					maxIndex = i;
				}
				System.out.println("1/"+i+": "+1*1.0/i+"--->"+temp+": "+temp.length());
			}
		}
		System.out.println(maxIndex+": "+maxLength);
	}
	
	@Test
	public void a27() {
		
	}
	
	@Test
	public void a28() {
		
		//ac*
		int n = 1001;
		
		int sum = 0;
		int row =0;
		int col = n;
		int flag = 0;
		int coll = 0;
		int colr = n-1;
		int rowd = n-1;
		int rowu = 0;
		
		boolean f = true;
		for (int i = n*n; i >= 1; i--) {
			
			if(f) {
				col--;
				f=false;
			}
			if(row+col==n-1||row==col) {
				sum+=i;
			}
			System.out.println("row: "+row+" ,col: "+col+" ,i "+i+" ,sum: "+sum);
			
			if(flag==0) {//列减
				col--;
				if(col<coll) {
					col++;
					flag=1;
					rowu++;
					/*System.out.println("colr: "+colr+" ,coll: "+coll+" ,rowd "+rowd+" ,rowu: "+rowu);
					System.out.println("------------------------------------------------------------\n");*/
				}
			}
			if(flag==1) {//行加
				row++;
				if(row>rowd) {
					row--;
					flag=2;
					coll++;
					/*System.out.println("colr: "+colr+" ,coll: "+coll+" ,rowd "+rowd+" ,rowu: "+rowu);
					System.out.println("------------------------------------------------------------\n");*/
				}
			}
			if(flag==2) {//列加
				col++;
				if(col>colr) {
					col--;
					flag=3;
					rowd--;
					/*System.out.println("colr: "+colr+" ,coll: "+coll+" ,rowd "+rowd+" ,rowu: "+rowu);
					System.out.println("------------------------------------------------------------\n");*/
				}
			}
			if(flag==3) {//行减
				row--;
				if(row<rowu) {
					row++;
					flag=0;
					colr--;
					/*System.out.println("colr: "+colr+" ,coll: "+coll+" ,rowd "+rowd+" ,rowu: "+rowu);
					System.out.println("------------------------------------------------------------\n");*/
					f=true;
				}
			}
		}
	}
	
	@Test
	public void a29() {
		int start = 2;
		int end = 100;
		int all = (end-start)*(end-start);
		
	}
	
	@Test
	public void a30() {
		
		//ac? 虽然ac了，但是数的范围没有确定，只是尽量大的写2~999999，所以存在一定的不确定性
		int sum = 0;
		for(int i = 2; i<999999;i++) {
			if(isSatisfy(i)) {
				sum+=i;
			}
		}
		System.out.println("sum : "+sum);
	}
	private boolean isSatisfy(int i) {
		
		int POWER = 5;
		
		char digit[] = (i+"").toCharArray();
		int digitPower5[] = new int[digit.length];
		
		int sum = 0;
		for (int j = 0; j < digit.length; j++) {
			int temp = (int) Math.pow(digit[j]-'0', POWER);
			sum+=temp;
			digitPower5[j]=temp;
		}
		if(sum==i) {
			StringBuilder str = new StringBuilder(i+" = ");
			for (int j = 0; j < digitPower5.length; j++) {
				str.append((digit[j]-'0')+"^"+POWER+" : "+digitPower5[j]);
				if(j!=digitPower5.length-1) {
					str.append(" + ");
				}
			}
			System.out.println(str);
			return true;
		}
		return false;
	}
	
}
