package com.tencent.mobileqq.ocr.activity;

import akns;
import android.text.TextUtils;
import com.tencent.mobileqq.ocr.data.OcrRecogResult;
import com.tencent.qphone.base.util.QLog;

public class ScanOcrActivity$8$1
  implements Runnable
{
  public ScanOcrActivity$8$1(akns paramakns, String paramString, int paramInt, OcrRecogResult paramOcrRecogResult, long paramLong) {}
  
  public void run()
  {
    if ((!ScanOcrActivity.b(this.a.this$0)) || (TextUtils.isEmpty(ScanOcrActivity.b(this.a.this$0))) || (!ScanOcrActivity.b(this.a.this$0).equals(this.val$imagePath)))
    {
      QLog.d("Q.ocr.ScanOcrActivity", 1, "OcrCallback onResult is not In recog, mRecogPicPath:" + ScanOcrActivity.b(this.a.this$0) + " ,imagePath:" + this.val$imagePath);
      return;
    }
    if (!ScanOcrActivity.c(this.a.this$0))
    {
      ScanOcrActivity.a(this.a.this$0, this.val$errCode, this.b, this.val$imagePath, this.val$costTime);
      return;
    }
    ScanOcrActivity.a(this.a.this$0, new ScanOcrActivity.a());
    ScanOcrActivity.a(this.a.this$0).errCode = this.val$errCode;
    ScanOcrActivity.a(this.a.this$0).d = this.b;
    ScanOcrActivity.a(this.a.this$0).imagePath = this.val$imagePath;
    ScanOcrActivity.a(this.a.this$0).costTime = this.val$costTime;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.activity.ScanOcrActivity.8.1
 * JD-Core Version:    0.7.0.1
 */