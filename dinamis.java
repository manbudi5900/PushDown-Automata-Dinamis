import java.util.Scanner;
class Node {
    char data;
    Node next;
	Node prev;
	public Node (char data) {
    this.data = data;
	}
}
public class dinamis{
	Node head,tail;
	public void push(char x){
		Node baru =new Node (x);
		if (head==null){
			head=baru;
			tail=baru;
		}
		else{
			tail.next=baru;
			baru.prev=tail;
			tail=baru;
		}
		
	}

	public char peek(){
		return tail.data;
	}
	
	public void pop(){
		Node temp=tail;
		tail=tail.prev;
		temp=null;
	}
	public void tampil(){
		Node temp=tail;
		if (head==tail && head.data=='z'){
		System.out.print("input accept");}
		else if(head==null){
			System.out.println("stack kososng");
		}
		else{
			while (temp!=null){
			System.out.println("["+temp.data+"]");
			temp=temp.prev;
			}
			System.out.println("inputan salah");
		}
	}

	public void tampil1(){
		Node temp=tail;
		if(head==null){
			System.out.println("stack kososng");
		}
		else{
			while (temp!=null){
			System.out.println("["+temp.data+"]");
			temp=temp.prev;
			}
		}
		System.out.println("====================");
	}
}   
