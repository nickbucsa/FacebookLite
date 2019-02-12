public class Util {
    
	public static void print(String s) {
        System.out.println(s);
    }
	
    public static void reset(String[] s) {
        for(int i = 0; i < s.length; i++) {
            s[i] = "";
        }
    }
    
	public static void print(String[] s) {
		for(int i = 0; i < s.length; i++) {
            System.out.print(s[i] + "\t");
        }
    }
	
	public static void print(String[] s, int top) {
		for (int i = 0; i < top + 1; i++) {
			System.out.print(s[i] + "\t");
		}
	}
}