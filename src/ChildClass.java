import java.util.Vector;


public class ChildClass extends SuperClass {
	
	public ChildClass(){
		//super("xxxx");
	}
	
	public static void main(String[] args) {
		ChildClass child = new ChildClass();
		float f = 4.0f;
		System.out.println(f++);
		StringBuffer sb = new StringBuffer();
		
		
		 child.doIt();
		/* System.out.println("ddd"+1+2);

		 

		 String str = "abc我们哈哈的ddfakjsdkfjl中国，中华";

		 child.splitIt(str, 4);

		 String a = "0";
*/
		 

		  

		  
	}
	
	public static void doIt(){ 
		
		synchronized(ChildClass.class){
			System.out.println("xxxx");
		}
		
		int i=0;int[] arr = {1,3,3,2,8};
		
		StringBuffer sb = null;
		
		Vector<String> v = null;
		
		Integer a = 1;
		Long b = 127L;
		Long c = 127L;
		
		System.out.println(b==c);
		
		/*
		String str = "";
		for(;i<arr.length;){ 
		if(arr[i]>arr[i+1]){
				str=arr[i]+arr[i+1]+str; 

				break; 
		} else if(arr[i]<arr[i+1]){
			str=arr[i]+str+arr[i+1]; 
			i++;
			continue;
		} else {
			str+=arr[i]; 
			i++;
		}
		} 
		System.out.println(i);
		System.out.println(str);
		} */
	}
	public void splitIt(String splitStr,int splitByte){
		int loopCount;
		loopCount = (splitStr.length()%splitByte == 0)?splitStr.length()/splitByte:splitStr.length()/(splitByte+1);
		for(int i=1;i<=loopCount;i++){
			if(i == loopCount){
				System.out.println(splitStr.substring((i-1)*splitByte,splitStr.length()));
			}else{
				System.out.println(splitStr.substring((i-1)*splitByte,(i*splitByte)));
			}
		}
	}

}
