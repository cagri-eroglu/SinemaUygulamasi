package extra;

import javax.swing.JOptionPane;

public class ortakMetodlar {
	public static void mesajGoster (String str) {
		String message;
		
		switch (str) {
		case "fill"	:
			message = "L�tfen t�m alanlar� doldurunuz";
			break;
		case "success":
			message = "��lem Ba�ar�l�";
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
			msg = "Bu i�lemi ger�ekle�tirmek istiyor musunuz ?";
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
