package com.tencent.mobileqq.utils;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

final class AudioHelper$3
  implements Runnable
{
  AudioHelper$3(String paramString) {}
  
  public void run()
  {
    QQToast localQQToast = QQToast.a(BaseApplicationImpl.getContext(), "de:" + this.val$text, 1);
    localQQToast.setAutoTextSize();
    localQQToast.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.AudioHelper.3
 * JD-Core Version:    0.7.0.1
 */