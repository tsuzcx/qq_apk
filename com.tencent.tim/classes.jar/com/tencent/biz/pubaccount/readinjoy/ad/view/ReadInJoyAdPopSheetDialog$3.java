package com.tencent.biz.pubaccount.readinjoy.ad.view;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.qphone.base.util.QLog;
import koj;

public class ReadInJoyAdPopSheetDialog$3
  implements Runnable
{
  public ReadInJoyAdPopSheetDialog$3(koj paramkoj, String paramString) {}
  
  public void run()
  {
    long l = SystemClock.currentThreadTimeMillis();
    koj.a(this.this$0, koj.a(this.this$0));
    if (QLog.isColorLevel()) {
      QLog.d(koj.access$300(), 2, "init webview costTime=" + (SystemClock.currentThreadTimeMillis() - l));
    }
    if ((!TextUtils.isEmpty(this.abu)) && (koj.a(this.this$0) != null))
    {
      koj.a(this.this$0, SystemClock.currentThreadTimeMillis());
      koj.a(this.this$0).post(new ReadInJoyAdPopSheetDialog.3.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInJoyAdPopSheetDialog.3
 * JD-Core Version:    0.7.0.1
 */