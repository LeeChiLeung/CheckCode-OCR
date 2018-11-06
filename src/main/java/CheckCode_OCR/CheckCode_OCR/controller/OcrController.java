package CheckCode_OCR.CheckCode_OCR.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blue.core.util.UUID;
import com.sun.mail.util.BASE64DecoderStream;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import sun.misc.BASE64Decoder;

@RestController
@RequestMapping("/ocr")
public class OcrController {
	private  Logger logger = LoggerFactory.getLogger(OcrController.class);
	@GetMapping("/index")
    public String appIndex() {
		//logger.info("收到请求:{}","/index");
		String result = "访问成功";
		return result;
	}
	
	@GetMapping("/ocrHandler")
	public String handler(String requestBody) {
		
		Tesseract t  = new  Tesseract();
		if(requestBody == null)
		return null;
		
		BASE64Decoder b = new BASE64Decoder();
	    try {
			 byte[] by = b.decodeBuffer(requestBody.replace(" ", "+"));
			 ByteArrayInputStream bais = new ByteArrayInputStream(by);
			 BufferedImage bi1 =ImageIO.read(bais);
             String result = t.doOCR(bi1).replaceAll("\\pP|\\pS|\n*","");
             logger.info("提取到验证码:{}",result);
            // System.out.println(result);
		 return result;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TesseractException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		 return null;
		
	}
}
