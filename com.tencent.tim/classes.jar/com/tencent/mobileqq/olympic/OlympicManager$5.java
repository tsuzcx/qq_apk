package com.tencent.mobileqq.olympic;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;

class OlympicManager$5
  implements Runnable
{
  OlympicManager$5(OlympicManager paramOlympicManager, int paramInt) {}
  
  public void run()
  {
    synchronized (OlympicManager.a(this.this$0))
    {
      SharedPreferences localSharedPreferences = this.this$0.mApp.getPreferences();
      if (localSharedPreferences != null) {
        localSharedPreferences.edit().putInt("isTorchbearer", this.val$flag).commit();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.OlympicManager.5
 * JD-Core Version:    0.7.0.1
 */