package com.tencent.mobileqq.ocr;

import akni;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.ocr.data.TranslateResult;
import com.tencent.mobileqq.widget.QQToast;

public class TranslateFragment$1$1
  implements Runnable
{
  public TranslateFragment$1$1(akni paramakni, boolean paramBoolean, TranslateResult paramTranslateResult) {}
  
  public void run()
  {
    TranslateFragment.a(this.a.a, false);
    TranslateFragment.a(this.a.a);
    if ((this.val$isSuccess) && (this.c != null) && (this.c.isSuccess()) && (!this.c.isEmpty()))
    {
      TranslateFragment.a(this.a.a, this.c);
      TranslateFragment.a(this.a.a, 2, this.c);
      return;
    }
    String str2 = this.a.a.getResources().getString(2131701476);
    String str1 = str2;
    if (this.c != null)
    {
      if (TextUtils.isEmpty(this.c.errMsg)) {
        break label154;
      }
      str1 = this.c.errMsg;
    }
    for (;;)
    {
      QQToast.a(TranslateFragment.a(this.a.a), 1, str1, 0).show();
      return;
      label154:
      str1 = str2;
      if (this.c.isEmpty()) {
        str1 = this.a.a.getResources().getString(2131701455);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.TranslateFragment.1.1
 * JD-Core Version:    0.7.0.1
 */