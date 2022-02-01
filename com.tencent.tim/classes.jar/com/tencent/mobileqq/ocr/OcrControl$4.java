package com.tencent.mobileqq.ocr;

import adhu;
import akne;
import anpc;
import com.tencent.common.app.BaseApplicationImpl;
import java.io.File;
import java.util.HashMap;

public class OcrControl$4
  implements Runnable
{
  public OcrControl$4(akne paramakne, adhu paramadhu) {}
  
  public void run()
  {
    long l1 = new File(this.b.fileName).length() / 1024L;
    long l2 = new File(this.b.bsZ).length() / 1024L;
    HashMap localHashMap = new HashMap();
    localHashMap.put("ocrFilesize", String.valueOf(l1));
    localHashMap.put("previewFilesize", String.valueOf(l2));
    anpc.a(BaseApplicationImpl.getContext()).collectPerformance("", "ocr_pic_size", true, 0L, 0L, localHashMap, "", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OcrControl.4
 * JD-Core Version:    0.7.0.1
 */