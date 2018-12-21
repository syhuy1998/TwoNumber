/**
 * Sum two string class.
 */
public class MyBigNumber {

    private IReceiver receiver;

    public MyBigNumber(){}

    public MyBigNumber(final IReceiver receiver) {
        this.receiver = receiver;
    }


    /**
     * Sum two string function.
     */

    public String sum( String s1,  String s2) {

        String result = "";             // chuỗi chứa kết quả
        String stepMsg = "";         // chuỗi chứa các bước trong quá trình cộng

        int temp = 0;                // biến lấy tổng
        int temp2 = 0;               // biến lấy hàng đơn vị
        int carry = 0;               // biến nhớ
        int i = 0;                   // biến đếm

        int n1 = 0;                 // biến chứa số trong chuỗi 1
        int n2 = 0;                  // biến chứa số trong chuỗi 2

        int len1 = s1.length();      // biến chứa độ dài chuỗi 1
        int len2 = s2.length();      // biến chứa độ dài chuỗi 2


        int length = len1 < len2 ? len2 : len1; // biến chứa độ dài lớn nhất trong 2 chuỗi s1, s2

        if (s1.contains("-")) {
            throw new NumberFormatException("So thu nhat phai la so nguyen duong");
        }

        if (s2.contains("-")) {
            throw new NumberFormatException("So thu nhi phai la so nguyen duong");
        }

        for (i = 0; i < length; i++) {

            n1 = i < len1 ? (s1.charAt(len1 - i - 1) - '0') : 0;
            n2 = i < len2 ? (s2.charAt(len2 - i - 1) - '0') : 0;

            temp = n2 + n1 + carry;
            temp2 = temp % 10;

            if (carry == 0) {
                stepMsg += "\n" + "Buoc " + (i + 1) + ": "
                        + "lay " + n1
                        + ", cong " + n2
                        + ", bang " + temp
                        + ", viet " + temp2
                        + ", nho " + temp / 10 + "\n";
            } else {
                stepMsg += "\n" + "Buoc " + (i + 1) + ": "
                        + "lay " + n1
                        + ", cong " + n2
                        + ", nho " + carry
                        + ", bang " + temp
                        + ", viet " + temp2
                        + ", nho " + carry + "\n";
            }

            carry = temp / 10;
            result = temp2 + result;

        }

        if (carry > 0) {
            result = carry + result;
            stepMsg += "\n" + "Buoc " + (i + 1) + ": "
                    + "lay " + 0
                    + ", cong " + 0
                    + ", nho " + 1
                    + ", bang " + 1
                    + ", viet " + 1
                    + "\n";
        }


        receiver.sendMessage(stepMsg);

        return result;

    }
}