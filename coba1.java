import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.*;
import java.lang.*;
import java.io.*;

class simpul{
String info;
simpul next;
jalur arc;
	simpul(String info){
		this.info=info;
	}
}
class jalur{
String input,top,push;
jalur next;
simpul node;
	jalur(String input,String top, String push){
		this.input=input;
		this.top= top;
		this.push=push;
	}
}

public class coba1{
	boolean cek;
	dinamis xx = new dinamis();
	Scanner a = new Scanner (System.in);

simpul first;
	coba1(){}

	void empty(){
	first=null;}

	public void insert(String c){
	simpul baru = new simpul(c);
	baru.next=null;
	baru.arc=null;
		if (first==null){
		first=baru;
		}
		else{
		simpul temp=first;
			while (temp.next!=null){
			temp=temp.next;
			}
		temp.next=baru;
		}
	}

	public void addjalur(simpul awal, simpul akhir,String input,String top,String hasil){
	jalur baru= new jalur(input,top,hasil);
	baru.next=null;
	baru.node=akhir;
		if(awal.arc==null){
			awal.arc=baru;
		}
		else{
		jalur last=awal.arc;
			while(last.next!=null){
			last=last.next;}
			last.next=baru;
		}
	}


	public simpul cari(String x){
		simpul hasil= null;
		simpul temp=first;
		boolean ketemu=false;
			while ((temp!=null) && (ketemu==false)){
				if(temp.info.equals(x)){
					hasil=temp;
					ketemu=true;
				}
				else{
				temp=temp.next;
				}
			}
		return hasil;
	}

	public void tampil(){
		simpul temp=first;
			if(temp!=null){
				while (temp!=null){
					jalur lol= temp.arc;
					while(lol!=null){
						System.out.println("Q("+temp.info+","+lol.input+","+lol.top+")=("+lol.node.info+","+lol.push+")");
						lol=lol.next;
					}
				temp=temp.next;
				}
			}
	}
	public void awal(){
		xx.push('z');
	}

	public void control(String x){
		simpul temp=first;
		int i = 0;
		while ( temp!=null &&  i<x.length()) {
			jalur lol= temp.arc;
			while(lol!=null){
				if(!lol.top.equals("z")&& lol.input.equals("a") && lol.top.equals("a") && lol.push.equals("A")){
					cek=false;
					break;
				}
				else if(!lol.top.equals("z")&& lol.input.equals("b") && lol.top.equals("b") && lol.push.equals("b")){
					cek=false;
					break;
				}else if(lol.top.equals(String.valueOf('z'))){ 
					lol=lol.next;
				}
				else{
					cek=true;
					break;
				}
			}
			lol= temp.arc;
			while(lol!=null && i<x.length()){
				if(lol.top.equals(String.valueOf(xx.peek()))){
					if(lol.input.equals(String.valueOf(x.charAt(i)))){
						if(cek==true){
							if (lol.top.equals(String.valueOf(x.charAt(i)))) {
							xx.pop();
							xx.tampil1();
							i++;
							lol= temp.arc;
							}
							else{
							xx.push(x.charAt(i));
							i++;
							xx.tampil1();
							lol= temp.arc;
							}
						}else{
							if (!lol.top.equals(String.valueOf(x.charAt(i))) && !lol.top.equals("z")) {
							xx.pop();
							xx.tampil1();
							i++;
							lol= temp.arc;
							}
							else{
								xx.push(x.charAt(i));
							
							i++;
							xx.tampil1();
							lol= temp.arc;
							}
						}
					}else{
						lol=lol.next;
					}
				}else{
					lol=lol.next;
				}
			}
			temp=temp.next;

	}
		xx.tampil();
	}

	public void baca(){
		awal();
		Scanner m = new Scanner(System.in);
        String state;
        try {
          Scanner sc = new Scanner(new File("input.txt"));
          List<String> lines = new ArrayList<String>();
          while (sc.hasNextLine()) {
            lines.add(sc.nextLine());
          }
          String[] array = lines.toArray(new String[0]);
          int max = Integer.valueOf(array[0]);
          state=array[1];
          int at=0;
          int in=1;
          System.out.println("State :");
          for(int i=0;i<max;i++){
            String v = state.substring(at, in+1);
            System.out.println("=>"+v);
            insert(v);
            at=at+3;
            in=in+3;
          }
          max = Integer.valueOf(array[2]);
          int line=3;
          String transition;
          String old, next, terminal,top,pushS;
          at=0;
          in=1;
          for(int i=0;i<max;i++){
            transition=array[line];
            old=transition.substring(at,in+1);
			simpul awal =cari(old);
            terminal=String.valueOf(transition.charAt(3));
            top=String.valueOf(transition.charAt(5));
            next=transition.substring(7,9);
			simpul akhir =cari(next);
            if(transition.charAt(6)=='z'){
              pushS=transition.substring(10,12);
            }
            else{
              pushS=String.valueOf(transition.charAt(10));
            }
            addjalur(awal,akhir,terminal,top,pushS);
            line++;
          }
          System.out.println("=> Transtion State : ");
          tampil();
          System.out.println("=> Input the test word : ");
          String testWord=m.next();
          control(testWord);
        }
        catch (FileNotFoundException fnfe) {
            // do something sensible with the exception.
        }
	}


public static void main(String[]args ){
	String pil;
	coba1 ll= new coba1();
	ll.baca();
}
}