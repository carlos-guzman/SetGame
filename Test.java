public class Test{
	public static void main(String[] args){

		String userInput = "hint 2";
		userInput = userInput.replaceAll("^.*hint\\D*", "");
		System.out.println(userInput);
		try{
			System.out.println(Integer.parseInt(userInput.replaceAll("\\D.*$",""))-1);
		}catch(Exception e){
			System.out.println("Failed");
		}
	}
}