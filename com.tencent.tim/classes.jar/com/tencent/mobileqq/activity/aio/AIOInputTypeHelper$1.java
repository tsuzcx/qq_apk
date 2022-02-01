package com.tencent.mobileqq.activity.aio;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import wir;

public final class AIOInputTypeHelper$1
  implements Runnable
{
  public AIOInputTypeHelper$1(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    wir.a(this.val$app).edit().putBoolean("ptt_guide_have_show", false).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.AIOInputTypeHelper.1
 * JD-Core Version:    0.7.0.1
 */