package com.tencent.mobileqq.listentogether.lyrics;

import aipd;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class LyricsController$5
  implements Runnable
{
  public LyricsController$5(aipd paramaipd) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LyricsController", 2, "onActivityResumed: mHoldByPermissionType:" + this.this$0.dew + " mHoldByPermissionUin:" + this.this$0.bPr);
    }
    aipd localaipd = this.this$0;
    localaipd.deB += 1;
    if ((aipd.a(this.this$0)) && (this.this$0.dew != -1) && (!TextUtils.isEmpty(this.this$0.bPr))) {
      this.this$0.de(this.this$0.dew, this.this$0.bPr);
    }
    if (this.this$0.deB >= 3)
    {
      this.this$0.clh = false;
      this.this$0.deB = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.lyrics.LyricsController.5
 * JD-Core Version:    0.7.0.1
 */