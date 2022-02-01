package com.tencent.biz.pubaccount.readinjoy.common;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import awit;
import com.tencent.qphone.base.util.QLog;
import kxm;

public final class ReadInJoyUtils$10
  implements Runnable
{
  public ReadInJoyUtils$10(boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    Object localObject = awit.a(kxm.getAppRuntime(), this.ait, true);
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).remove(this.val$key);
      ((SharedPreferences.Editor)localObject).apply();
      QLog.d("ReadInJoyUtils", 2, "delete data in sp successful ! key : " + this.val$key);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils.10
 * JD-Core Version:    0.7.0.1
 */