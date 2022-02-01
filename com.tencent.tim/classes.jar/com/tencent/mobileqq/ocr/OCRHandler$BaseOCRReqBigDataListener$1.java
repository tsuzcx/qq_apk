package com.tencent.mobileqq.ocr;

import aklq;
import aklq.a;
import android.content.Intent;
import aokl;
import aomh;
import com.tencent.qphone.base.util.QLog;

public class OCRHandler$BaseOCRReqBigDataListener$1
  implements Runnable
{
  public OCRHandler$BaseOCRReqBigDataListener$1(aklq.a parama, aomh paramaomh) {}
  
  public void run()
  {
    int i = 0;
    aklq localaklq;
    Intent localIntent;
    if ((this.b == null) || (this.b.mResult != 0))
    {
      if (this.b == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.ocr.OCRHandler", 2, "BaseOCRReqBigListener.onResp(), resp is null");
        }
        aokl.a().onFailed(6, aklq.a.a(this.a));
        i = -10;
      }
    }
    else
    {
      localaklq = this.a.a;
      localIntent = aklq.a.a(this.a);
      if (this.b == null) {
        break label191;
      }
    }
    label191:
    for (byte[] arrayOfByte = this.b.mRespData;; arrayOfByte = null)
    {
      aklq.a(localaklq, i, localIntent, arrayOfByte, aklq.a.a(this.a));
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("Q.ocr.OCRHandler", 2, "BaseOCRReqBigListener.onResp(), mResult=" + this.b.mResult + ",mErrCode=" + this.b.mErrCode + ",mHttpCode=" + this.b.dPy + ",mErrDesc=" + this.b.clO);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRHandler.BaseOCRReqBigDataListener.1
 * JD-Core Version:    0.7.0.1
 */