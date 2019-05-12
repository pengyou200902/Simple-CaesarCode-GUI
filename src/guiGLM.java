import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class guiGLM {

    private JButton cipherBtn;
    private JButton resetBtn;
    private JButton exitBtn;
    private JPanel wholePanel;
    private JPanel botmPanl;
    private JPanel botmR;
    private JPanel botmL;
    private JPanel botmM;
    private JPanel topPanl;
    private JTextField key;
    private JTextField plainText;
    private JTextField cipherText;
    private JPanel midPanl;
    private JPanel midM;
    private JPanel midL;
    private JLabel keyL;
    private JLabel cipherL;
    private JLabel plainL;
    private JPanel midR;

    public guiGLM() {
        cipherBtn.addActionListener(new ActionListener() {  //cipherBtn
            @Override
            public void actionPerformed(ActionEvent e) {
//                key.setText("378126864sbdashdj");
                String k = key.getText();
                String plainString = plainText.getText();
                cipherText.setText(cipher(k, plainString).toString());
            }
        });

        exitBtn.addActionListener(new ActionListener() {    //exitBtn
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        resetBtn.addActionListener(new ActionListener() {   //resetBtn
            @Override
            public void actionPerformed(ActionEvent e) {
                key.setText("");
                plainText.setText("");
                cipherText.setText("");
            }
        });
    }

    private StringBuilder cipher(String k, String plainString) {
        int bias = Integer.parseInt(k);
        if(plainString.isEmpty()) {
            return new StringBuilder("");
        }
        else if(bias == 0) {
            return new StringBuilder(plainString);
        }
        else {
            return Caesar(bias, plainString);
        }

    }

    private StringBuilder Caesar(int k, String s) {
        int mod_A = 26;
        int delta = (int)'A';   // 便于移位
        char[] plain = s.toCharArray();
        StringBuilder cipher = new StringBuilder();
        int x = 0;
        for (int i = 0; i < plain.length; i++) {
            x = (int)plain[i];  //逐个检查
            if(x >= (int)'A' && x<= (int)'Z') { //大写字母
                x = (x - delta + k) % mod_A + delta;    //移位
            }
            else if(x >= (int)'a' && x<= (int)'z') {    //小写字母
                x = (x - delta - 32 + k) % mod_A + delta;   //移位
            }
            else {continue;}
            cipher.append((char)(x));   //保存结果

        }
        return cipher;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("guiGLM");
        frame.setContentPane(new guiGLM().wholePanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
