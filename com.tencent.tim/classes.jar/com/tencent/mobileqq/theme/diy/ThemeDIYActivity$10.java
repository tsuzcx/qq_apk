package com.tencent.mobileqq.theme.diy;

import acfp;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import aquy;
import aquz;
import com.tencent.qphone.base.util.QLog;

class ThemeDIYActivity$10
  extends aquy
{
  ThemeDIYActivity$10(ThemeDIYActivity paramThemeDIYActivity) {}
  
  public void onDone(aquz paramaquz)
  {
    super.onDone(paramaquz);
    if ((paramaquz.getStatus() == 3) && (paramaquz.errCode == 0)) {}
    int j;
    for (int i = 1;; i = 0)
    {
      paramaquz = paramaquz.getParams();
      j = paramaquz.getInt("type");
      switch (j)
      {
      default: 
        return;
      }
    }
    this.this$0.loadResJson(j, true);
    return;
    ThemeDiyStyleLogic.a locala = this.this$0.saveStyleCallback;
    if (i != 0) {}
    for (i = 4;; i = 8)
    {
      locala.callback(13, i, paramaquz, null);
      return;
    }
  }
  
  public void onNetMobile2None()
  {
    QLog.e("ThemeDIYActivity", 2, "DownloadListener onNetMobile2None...");
    this.this$0.mHandler.sendMessage(Message.obtain(this.this$0.mHandler, 27, acfp.m(2131715288)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.theme.diy.ThemeDIYActivity.10
 * JD-Core Version:    0.7.0.1
 */