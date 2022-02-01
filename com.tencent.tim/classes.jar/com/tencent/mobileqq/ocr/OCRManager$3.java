package com.tencent.mobileqq.ocr;

import aklr;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.qphone.base.util.QLog;

public class OCRManager$3
  implements Runnable
{
  public OCRManager$3(aklr paramaklr, boolean paramBoolean) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.ocr.manager", 2, "onGetOCRConfig ,excute runnable");
    }
    if ((this.val$isSucc) && (this.this$0.a != null)) {
      synchronized (aklr.a(this.this$0))
      {
        if (this.this$0.a != null) {
          this.this$0.a.saveToFile(this.this$0.mApp.getCurrentAccountUin());
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRManager.3
 * JD-Core Version:    0.7.0.1
 */