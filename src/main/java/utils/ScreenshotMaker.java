package utils;

import java.io.File;
import java.io.IOException;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.TesseractException;
import org.apache.commons.io.FileUtils;
import net.sourceforge.tess4j.Tesseract;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import setup.BaseTest;

public class ScreenshotMaker extends BaseTest {

    public synchronized boolean verifyToastMessage(String msg, String imgPath) throws IOException, TesseractException {

        final File file = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File(imgPath));

        System.out.println("Initializing tesseract");

        final ITesseract instance = new Tesseract();
        final String result = instance.doOCR(file);
        System.out.println("result is " + result);

        if (result.contains(msg))
        {
            return true;
        }
        return false;
    }
}
