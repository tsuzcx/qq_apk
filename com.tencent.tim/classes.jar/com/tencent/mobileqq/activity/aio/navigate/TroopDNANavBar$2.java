package com.tencent.mobileqq.activity.aio.navigate;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import anot;
import com.tencent.qphone.base.util.QLog;
import xrn;

public class TroopDNANavBar$2
  implements Runnable
{
  public TroopDNANavBar$2(xrn paramxrn) {}
  
  public void run()
  {
    Object localObject = PreferenceManager.getDefaultSharedPreferences(this.this$0.mContext);
    int i = ((SharedPreferences)localObject).getInt(xrn.j(this.this$0.mApp), 0);
    if (QLog.isColorLevel()) {
      QLog.d("NavigateBarManager.TroopDNANavBar", 2, String.format("onShow guide count: %s", new Object[] { Integer.valueOf(i) }));
    }
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putInt(xrn.j(this.this$0.mApp), i + 1).commit();
    ((SharedPreferences.Editor)localObject).apply();
    anot.a(null, "dc00898", "", "", "0X800A468", "0X800A468", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.navigate.TroopDNANavBar.2
 * JD-Core Version:    0.7.0.1
 */