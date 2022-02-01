package com.tencent.mobileqq.emotionintegrate;

import afrp;
import akxb.a;
import akxn.a;
import akxr;
import com.tencent.qphone.base.util.QLog;

public class EmotionDownGIFCallback$1
  implements Runnable
{
  public EmotionDownGIFCallback$1(afrp paramafrp, akxb.a parama) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionDownGIFCallback", 1, "onDownload");
    }
    if ((this.a != null) && (this.a.bUF != null))
    {
      akxr localakxr = new akxr();
      localakxr.mResult = this.a.result;
      localakxr.en = this.a;
      localakxr.bjc = this.a.bjc;
      if (this.a.result != 0)
      {
        if (this.a.a == null)
        {
          akxn.a locala = new akxn.a();
          locala.bUJ = (this.a.errCode + "_" + this.a.errStr);
          locala.bUI = "onDownload";
          this.a.a = locala;
        }
        localakxr.c = this.a.a;
      }
      this.this$0.a(this.a.result, localakxr);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emotionintegrate.EmotionDownGIFCallback.1
 * JD-Core Version:    0.7.0.1
 */