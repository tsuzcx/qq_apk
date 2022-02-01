package com.tencent.mobileqq.managers;

import aiyw.a;
import android.text.TextUtils;
import anot;

public class CUOpenCardGuideMng$CUOpenCardClickableSpan$1
  implements Runnable
{
  public CUOpenCardGuideMng$CUOpenCardClickableSpan$1(aiyw.a parama) {}
  
  public void run()
  {
    String str;
    if (this.this$0.RH == 1) {
      str = "0X8008124";
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(str)) {
        anot.a(null, "dc00898", "", "", str, str, 0, 0, "", "", "", "");
      }
      return;
      if (this.this$0.RH == 2) {
        str = "0X8008126";
      } else if ((this.this$0.RH == 3) || (this.this$0.RH == 4)) {
        str = "0X800813E";
      } else {
        str = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.managers.CUOpenCardGuideMng.CUOpenCardClickableSpan.1
 * JD-Core Version:    0.7.0.1
 */