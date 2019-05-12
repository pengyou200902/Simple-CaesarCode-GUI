## 信息安全实验（一） —— 凯撒密码简单gui演示

## jdk = 11.0.3

凯撒密码是把字母表中的每个字母用该字母后的某个字母进行替代。
凯撒密码的通用加密算法是：C=E(p)=(p+k) mod 26，0<k<26 
凯撒密码的通用解密算法是：p=D(C)=(C-k) mod 26，0<k<26 
