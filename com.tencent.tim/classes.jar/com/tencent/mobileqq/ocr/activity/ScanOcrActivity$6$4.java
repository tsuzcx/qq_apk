package com.tencent.mobileqq.ocr.activity;

import aknq;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.ocr.view.MaskView;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ScanOcrActivity$6$4
  implements Runnable
{
  public ScanOcrActivity$6$4(aknq paramaknq, String paramString) {}
  
  public void run()
  {
    if ((!TextUtils.isEmpty(this.azt)) && (new File(this.azt).exists()))
    {
      long l = System.currentTimeMillis() - ScanOcrActivity.a(this.a.this$0);
      if (this.a.this$0.dnO == 1)
      {
        Object localObject = URLDrawable.URLDrawableOptions.obtain();
        localObject = URLDrawable.getDrawable(new File(this.azt), (URLDrawable.URLDrawableOptions)localObject);
        ((URLDrawable)localObject).downloadImediatly();
        this.a.this$0.a.setPreviewDrawable((Drawable)localObject);
        ScanOcrActivity.a(this.a.this$0, this.azt, true);
        return;
      }
      if (l > 900L)
      {
        ScanOcrActivity.a(this.a.this$0, this.azt, false);
        return;
      }
      ScanOcrActivity.a(this.a.this$0).postDelayed(new ScanOcrActivity.6.4.1(this), 900L - l);
      return;
    }
    ScanOcrActivity.a(this.a.this$0, false);
    QLog.d("Q.ocr.ScanOcrActivity", 1, "onTakePicFinish failed!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.activity.ScanOcrActivity.6.4
 * JD-Core Version:    0.7.0.1
 */