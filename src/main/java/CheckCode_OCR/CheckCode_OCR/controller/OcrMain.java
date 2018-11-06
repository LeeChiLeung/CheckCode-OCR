package CheckCode_OCR.CheckCode_OCR.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class) 
public class OcrMain {
public static void main(String[] args) {
	Logger logger = LoggerFactory.getLogger(OcrMain.class);
	SpringApplication.run(OcrMain.class, args);
	logger.info("OCR识别启动成功...");
}
}
