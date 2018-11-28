1由于自己准备的文件使用UTF编码所以测试了UTF编码的长度
    检验代码位于report1
    发现
        中文 3byte
        英文 1byte
        标点 1byte
        数字 1byte
    UTF编码是变长的

2DataInputStream是可以二进制读写文件的
事实上不仅是文本文件MP3，jpg都可以