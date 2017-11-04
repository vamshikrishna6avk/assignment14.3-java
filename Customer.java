/*program for showing difference between notify() and notifyall()  method of thread class*/
//notify() method calls when a single thread after waiting the wait()method and notifyall() specifies after the amount of time specified and sleep completed
package notifyandnotifyall; //created package notifyandnotifyall

public class Customer { //created class Customer 
	int amount=10000;   //taking an integer variable of amount and initializing some the value
	  
	synchronized void withdraw(int amount){    // here Synchronized block is used to lock an object for any shared resource.
	System.out.println("going to withdraw amount");   //here it prints 
	//system is used to return code
    //out is a static member
//println is used to print text and gives output
	  
	if(this.amount<amount){  //here taking if statement whether it shows the balance 
	System.out.println("Less balance : waiting for deposit...");  
	try{wait();}catch(Exception e){}   //here wait() method  waits until object is notified. it shows an error while we use wait method 
	}                                        //so we use try catch to handle the error
	this.amount-=amount;  
	System.out.println("withdraw completed");  
	}  
	  
	synchronized void deposit(int amount){   //here it locks the deposit method and 
	System.out.println("going to deposit...!"); 
	this.amount+=amount;   
	System.out.println("deposit completed... ");   //calls for notify method. it Wakes up a single thread that is waiting on this object's 
	
	notify();  
	}  
	}  
	  
	class Test{       //created a subclass Test
	public static void main(String args[]){   //created the main method
	final Customer c=new Customer();          //by using final keyword we created an object
	new Thread(){                              //which calls thread
	public void run(){c.withdraw(15000);}  //Here public is a access modifier which defines who can access this method
	//void is used to define return type of the method,void means method wont return any value
	//main is name of method,and to display
	}.start();                                  //here created run method to executes the output 
	new Thread(){  
	public void run(){c.deposit(10000);}  //Here public is a access modifier which defines who can access this method
	//void is used to define return type of the method,void means method wont return any value
	}.start();  //start
	  
	}}  
