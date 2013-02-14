// A number is armstrong if the sum of cubes of individual digits of a number is equal to the number itself.
// For example 371 is an armstrong number as 33 + 73 + 13 = 371. 
// Some other armstrong numbers are: 0, 1, 153, 370, 407

public class MyArmstrongNumber {
 
    public boolean isArmstrongNumber(int number){
         
  	//  This Java String valueOf example describes how various java primitives and Object
		//  are converted to Java String object using String valueOf method. 
		 
		 
		/*int a = 2121; 
		String lll = String.valueOf(a);  // valueOf converts a int to string thats why String lll and not int lll
		note -- length always returns in number - so int ll is used.
		int ll = lll.length();
		System.out.println("len  : "+ll );*/

        int tmp = number;
        int noOfDigits = String.valueOf(number).length();  // output : 3, for every 3 objects(as numbers size: 3)
 
        int sum = 0;
        int div = 0; 
        while(tmp > 0) 
        { 
            div = tmp % 10; 
            int temp = 1;
            for(int i=0;i<noOfDigits;i++){
                temp *= div;
            }
            sum += temp;
            tmp = tmp/10; 
        } 
        if(number == sum) {
            return true; 
        } else {
            return false; 
        } 
    }
     
    public static void main(String a[]){
        MyArmstrongNumber man = new MyArmstrongNumber();
        System.out.println("Is 371 Armstrong number? "+man.isArmstrongNumber(371));
        System.out.println("Is 523 Armstrong number? "+man.isArmstrongNumber(523));
        System.out.println("Is 153 Armstrong number? "+man.isArmstrongNumber(153));
    }
}
