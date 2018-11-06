# CheckCode-OCR

简易的验证码识别　基于SpringBoot  及　tess4j的整合

---------
可以用于linux , mac os 开发中简易使用　需要安装　tesseract开源视觉识别引擎　版本是　３．０４

linux tess4j 安装教材

下载　leptonica-1.76.0 及　tesseract-3.0

切换到su模式

执行

tar -zxvf leptonica-1.76.0

cd leptonica-1.76.0

./configure

make

make install

ldconfig

继续执行

tar -zxvf tesseract-3.0

cd tesseract-3.0

./autogen.sh

./configure

make

make install

ldconfig

安装的时候生成的so Library仅在/usr/local/lib里面，而项目调用的lib则在/usr/lib里面，
所以要将/usr/local/lib中相关的tesseract和leptonica的library拷贝到/usr/lib当中

最后把所需的字典　拷贝到　tesseract　安装目录下即可

