package extra;

import javax.swing.JOptionPane;

public class ortakMetodlar {
	public static void mesajGoster (String str) {
		String message;
		
		switch (str) {
		case "fill"	:
			message = "Lütfen tüm alanlarý doldurunuz";
			break;
		case "success":
			message = "Ýþlem Baþarýlý";
			break;
			
		default:
			message = str;
		}
		
		JOptionPane.showMessageDialog(null,message,"Mesaj",JOptionPane.INFORMATION_MESSAGE);
		
	}
	
	public static boolean confirm(String str)
	{
		String msg ;
		switch (str) {
		case "sure": {
			msg = "Bu iþlemi gerçekleþtirmek istiyor musunuz ?";
			break;
		}
		default:
			msg = str;
			break;
		}
		int res = JOptionPane.showConfirmDialog(null, msg,"Dikkat !",JOptionPane.YES_NO_OPTION);
		if (res ==0) {
			return true;
		}else {
			return false;
		}
	}
}
