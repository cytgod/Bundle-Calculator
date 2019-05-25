package javaPractice;

import java.util.Scanner;

public class BundleCalculate {
	
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		String line1 = key.nextLine();
		String line2 = key.nextLine();
		String line3 = key.nextLine();
		String[] l1 = line1.split(" ");
		String[] l2 = line2.split(" ");
		String[] l3 = line3.split(" ");
		System.out.println(output(l1));
		System.out.println(output(l2));
		System.out.println(output(l3));
		key.close();
	}
	
	//get output from input
	public static String output(String[] a) {
		if(a[1].equalsIgnoreCase("IMG")) {
			int num_IMG = Integer.parseInt(a[0]);
			int[] bundles_IMG = calIMG(num_IMG);
			double money = bundles_IMG[0]*800+bundles_IMG[1]*450;
			String result = a[0]+" "+a[1].toUpperCase()+" "+"$"+money+"  "+bundles_IMG[0]+"x10"+" "+"$800"+" "+
			+bundles_IMG[1]+"x5"+" "+"$450";
			return result;	
		}
		if(a[1].equalsIgnoreCase("FLAC")) {
			int num_FLAC = Integer.parseInt(a[0]);
			int[] bundles_FLAC = calFlac(num_FLAC);
			double money = (double)bundles_FLAC[0]*1147.5+bundles_FLAC[1]*810+(double)bundles_FLAC[2]*427.50;
			String result = a[0]+" "+a[1].toUpperCase()+" "+"$"+money+"  "+bundles_FLAC[0]+"x9"+" "+"$1147.50"+" "
					+bundles_FLAC[1]+"x6"+" "+"$810"+" "+bundles_FLAC[2]+"x3"+" "+"$427.50";
			return result;
		}
		if(a[1].equalsIgnoreCase("VID")) {
			int num_VID = Integer.parseInt(a[0]);
			int[] bundles_VID = calVID(num_VID);
			double money = (double)bundles_VID[0]*1530+bundles_VID[1]*900+(double)bundles_VID[2]*570;
			String result = a[0]+" "+a[1].toUpperCase()+" "+"$"+money+"  "+bundles_VID[0]+"x9"+" "+"$1530"+" "
					+bundles_VID[1]+"x5"+" "+"$900"+" "+bundles_VID[2]+"x3"+" "+"$570";
			return result;
		}
		return null;
	}
	
	//calculate bundles for IMG
	public static int[] calIMG(int num) {
		int count_10=0;
		int count_5 = 0;
		int factor = num/5;
		count_10 = factor/2;
		count_5 = factor-((int)(factor/2))*2;
		return 	combine(count_10,count_5);			
	}
	
	//calculate bundles for FLAC
	public static int[] calFlac(int num) {
		int count_9 = 0;
		int count_6 = 0;
		int count_3 = 0;
		int factor = num/3;
		if(factor/3>=0) {
			count_9 = factor/3;
			int left = factor-((int)(factor/3))*3;
			if(left==0) {
				return combine(count_9,count_6,count_3);
			}
			if(left/2>=0) {
				count_6 = left/2;
				count_3 = left - ((int)(left/2))*2;
				return combine(count_9,count_6,count_3);
			}
		}
		return null;
	}
	
	
	
	//calculate bundles for VID
	public static int[] calVID(int num) {
		int count_9 = 0;
		int count_5 = 0;
		int count_3 = 0;
		
		count_9 = num/9;
		while(count_9>=0) {
			int left = num-9*count_9;
			if(left==0) {
				return combine(count_9,count_5,count_3); 
			}
			if(left!=0) {
				count_5 = left/5;
				int left1 = left;
				
				while(count_5>=0) {
					
					left1 = left1-5*count_5;
					if(left1==0) {
						return combine(count_9,count_5,count_3);  
					}
					if(left1!=0) {
						count_3 = left1/3;
						int left2 = left1;
						
						while(count_3>0) {
							
							left2 = left2-3*count_3;
							
							if(left2==0) {
								return combine(count_9,count_5,count_3); 
							}
							count_3-=1;
							
						}
					}
					count_5-=1;
				}
			}
			
			count_9-=1;
		}
		
		return null; 
	}
	

	public static int[] combine(int a, int b, int c) {
		return new int[]{a,b,c};
	}
	public static int[] combine(int a, int b) {
		return new int[]{a,b};
	}
}
