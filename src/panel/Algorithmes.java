package panel;

import java.util.ArrayList;

public class Algorithmes {



	public static String codeCesar(String text, Integer x) {

		char[] texta = text.toCharArray();
		String code= "";

		for (int i=0;i<texta.length;i++) {
			code = code + (char)(  ( ((int)texta[i])+x )%26  );	
		}
		return code;
	}
	public static String decodeCesar(String text, Integer x) {

		char[] texta = text.toCharArray();
		String code= "";

		for (int i=0;i<texta.length;i++) {
			code = code + (char)(   ( ((int)texta[i])-x )%26   );	
		}
		return code;
	}

	public static String codeVigenere(String msg,String key) {
		
		char[] msgc = msg.toCharArray();
		char[] keyc = key.toCharArray();
		ArrayList<Character> almsg = new ArrayList<Character>();
		ArrayList<Character> alkey = new ArrayList<Character>();
		String code= "";
		int msgsize=msg.length();
		
		
		for (int i=0;i<msg.length();i++) {
			almsg.add(i, msgc[i]);
		}
		for (int i=0;i<key.length();i++) {
			alkey.add(i, keyc[i]);
		}
		
		System.out.println("ArrayListmsg[]:"+almsg.toString());
		System.out.println("ArrayListkey[]:"+alkey.toString());
		
		while(msgsize % key.length()!=0) {
			msgsize++;
			msg=msg+"X";
		}

	
		System.out.println("msg:"+msg);

		for (int i=0;i<msgsize;i++) {
			System.out.println("begin");
			
			//tn.add((int)msgc[i]);

			code = code + (char)(   (   ((int)msgc[i]) + ((int)keyc[i%key.length()])   )%26  );	
		}

		System.out.println("arraylist: "+almsg.toString());
		System.out.println("code: "+code);
		return code;
		
	}
	public static String decodeVigenere(String msg,String key) {
		char[] msgc = msg.toCharArray();
		char[] keyc = key.toCharArray();
		ArrayList<Integer> tn = new ArrayList<Integer>();
		String code= "";
		int msgsize=msg.length();
		System.out.println("algorithme execution !!");
		while(msgsize%key.length()!=0) {
			msgsize++;
			msg=msg+"X";
		}
		for (int i=0;i<msgsize;i++) {
			System.out.println("begin");
			
			tn.add((int)msgc[i]);

			code = code + (char)(   (   ((int)msgc[i]) - ((int)keyc[i%key.length()])   )%26  );	
		}

		System.out.println("arraylist: "+tn.toString());
		System.out.println("code: "+code);
		return code;
		
	}
}
