package com.tencent.mobileqq.ocr;

import adhu;
import adhv;
import aknf;
import akng;
import aqhq;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class OcrControl$5$2
  implements Runnable
{
  public OcrControl$5$2(aknf paramaknf, adhv paramadhv) {}
  
  public void run()
  {
    String str1 = this.jdField_a_of_type_Adhv.a.fileName;
    String str2 = new File(str1).getParent();
    if (akng.bTS.equals(str2))
    {
      aqhq.deleteFile(str1);
      if (QLog.isColorLevel()) {
        QLog.d("Q.ocr.control", 2, "delete pic path:" + str1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OcrControl.5.2
 * JD-Core Version:    0.7.0.1
 */