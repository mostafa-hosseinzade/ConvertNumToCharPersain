

public class ConvertNumToCharPersion {

    private String[] yakan = new String[]{"صفر", "یک", "دو", "سه", "چهار", "پنج", "شش", "هفت", "هشت", "نه"};
    private String[] dahgan = new String[]{"", "", "بیست", "سی", "چهل", "پنجاه", "شصت", "هفتاد", "هشتاد", "نود"};
    private String[] dahyek = new String[]{"ده", "یازده", "دوازده", "سیزده", "چهارده", "پانزده", "شانزده", "هفده", "هجده", "نوزده"};
    private String[] sadgan = new String[]{"", "یکصد", "دوصد", "سیصد", "چهارصد", "پانصد", "ششصد", "هفتصد", "هشتصد", "نهصد"};
    private String[] basex = new String[]{"", "هزار", "میلیون", "میلیارد", "تریلیون"};

    private String getnum3(int num3) {
        String s = "";
        int d3, d12;
        d12 = num3 % 100;
        d3 = num3 / 100;
        if (d3 != 0) {
            s = sadgan[d3] + " و ";
        }
        if ((d12 >= 10) && (d12 <= 19)) {
            s = s + dahyek[d12 - 10];
        } else {
            int d2 = d12 / 10;
            if (d2 != 0) {
                s = s + dahgan[d2] + " و ";
            }
            int d1 = d12 % 10;
            if (d1 != 0) {
                s = s + yakan[d1] + " و ";
            }
            s = s.substring(0, s.length() - 3);
        }
        return s;
    }

    public String num2str(String snum) {
        String stotal = "";
        if (snum == "0") {
            return yakan[0];
        } else {
            int zero = Integer.valueOf(((snum.length() - 1) / 3 + 1) * 3);
	    String str = "0";
            snum =(new String(new char['0']).replace("\0", str))+snum; //StringUtils.repeat('0', zero-snum.length())+snum;
            int L = snum.length() / 3 - 1;
            for (int i = 0; i <= L; i++) {
                int b = Integer.valueOf(snum.substring(i * 3, (i * 3)+ 3));
                if (b != 0) {
                    stotal = stotal + getnum3(b) + " " + basex[L - i] + " و ";
                }
            }
            stotal = stotal.substring(0, stotal.length() - 3);
        }
        return stotal;
    }

}