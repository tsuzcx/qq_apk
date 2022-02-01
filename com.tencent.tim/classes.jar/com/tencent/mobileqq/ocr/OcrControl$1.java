package com.tencent.mobileqq.ocr;

import adhu;
import akne;
import akne.a;
import akng;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class OcrControl$1
  implements Runnable
{
  public OcrControl$1(akne paramakne, String paramString1, boolean paramBoolean, String paramString2) {}
  
  public void run()
  {
    if (akng.nJ(this.azt))
    {
      localObject = akng.u(new File(this.azt).getName(), false);
      if ((this.val$needCompress) && (akng.bk(this.azt, (String)localObject)))
      {
        localadhu = new adhu();
        localadhu.fileName = ((String)localObject);
        localadhu.fileFormat = 0;
        localadhu.bsZ = this.azt;
        if (QLog.isColorLevel()) {
          QLog.d("Q.ocr.control", 2, "upload pic size:" + new File((String)localObject).length() / 1024L + "KB");
        }
        this.this$0.a(localadhu, this.bTR);
      }
    }
    while (akne.a(this.this$0) == null)
    {
      adhu localadhu;
      return;
      Object localObject = new adhu();
      ((adhu)localObject).fileName = this.azt;
      ((adhu)localObject).fileFormat = 0;
      ((adhu)localObject).bsZ = this.azt;
      if (QLog.isColorLevel()) {
        QLog.d("Q.ocr.control", 2, "upload pic size:" + new File(this.azt).length() / 1024L + "KB");
      }
      this.this$0.a((adhu)localObject, this.bTR);
      return;
    }
    akne.a(this.this$0).a(1, null, this.azt, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OcrControl.1
 * JD-Core Version:    0.7.0.1
 */