import java.util.Arrays;
import java.util.Scanner;
public class A1258 {
//二维数组有关操作
	//核心：邻接矩阵最短路径长度
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int lenth = in.nextInt();
		int [][]line=new int[lenth][lenth];
		input(lenth,line);
		int res[]=new int[line.length-1];
		for (int i = 0; i < line.length; i++) {
			line[i][0]=0;
		}
		int min=indexOfmin(line[0]);
		int min2=0;
		for (int t = 0; t < res.length;) {
			//横排查找
			min=indexOfmin(line[min2]);
			res[t++]=line[min2][min];
			//横排置为0
			for (int i = 0; i < line[min2].length; i++) {
				line[min2][i]=0;
			}
			//-----------------------
			//竖排查找
			if(t == res.length)
				break;
			min2=0;
			while(line[min2][min]==0) min2++;
			for (int i = 1; i < line.length; i++) {
				if(line[min2][min]>line[i][min])
					if(line[i][min]!=0)
						min2=i;	
			}
			res[t++]=line[min2][min];
			//竖排置为0
			for (int i = 0; i < line.length; i++) {
				line[i][min]=0;
			}
		}
		int fin=0;
		for (int i = 0; i < res.length; i++) {
			fin+=res[i];
		}
		System.out.print(fin);
		in.close();
	}
	static void input(int lenth,int [][]Arrayname){
		for(int y=0;y!=lenth;y++){
			for(int x=0;x!=lenth;x++){
				Arrayname[y][x]=new Scanner(System.in).nextInt();
			}
		}
	}
	static void printline(int []Arrayname){
		int x=0;
		for(;x!=Arrayname.length-1;x++){
			System.out.print(Arrayname[x]+" ");
		}
		System.out.print(Arrayname[x]);
	}
	static void print(int [][]Arrayname){
		int y=0;
		for(;y!=Arrayname.length-1;y++){
			printline(Arrayname[y]);
			System.out.println();
		}
		printline(Arrayname[y]);
	}
	static void sort(int lenth,int [][]Arrayname){
		for(int y=0;y!=lenth;y++){
			Arrays.sort(Arrayname[y]);
		}
	}
	static int valueOfmin(int []Arrayname){
		int res=Arrayname[0];
		for(int y=1;y!=Arrayname.length;y++){
			if(res>Arrayname[y])
				res=Arrayname[y];
		}
		return res;
	}
	static int indexOfmin(int []Arrayname){
		int res=0;
		while(Arrayname[res]==0) res++;
		for(int y=1;y!=Arrayname.length;y++){
			if(Arrayname[res]>Arrayname[y])
				if(Arrayname[y]!=0)
					res=y;
		}
		return res;
	}
	static int []delete(int index,int []Arrayname){
		for (int i = index; i < Arrayname.length-1; i++) {
			Arrayname[i] = Arrayname[i+1];
		}
		return Arrays.copyOf(Arrayname, Arrayname.length-1);
	}
	static void deletecol(int index,int [][]Arrayname){
		for (int i = 0; i < Arrayname.length; i++) {
			Arrayname[i]=delete(index, Arrayname[i]);
		}
	}
	static int [][]deleteline(int index,int [][]Arrayname){
		for (int i = 0; i < Arrayname.length-1; i++) {
			Arrayname[i] = Arrayname[i+1];
		}
		return Arrays.copyOfRange(Arrayname, 0,Arrayname.length-1);
	}
}
