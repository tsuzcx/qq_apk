package com.tencent.mqp.app.sec;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import arnn;
import com.tencent.qphone.base.util.BaseApplication;

public class MQPSensitiveMsgUtil$3
  implements Runnable
{
  public MQPSensitiveMsgUtil$3(arnn paramarnn, String paramString1, String paramString2) {}
  
  public void run()
  {
    Object localObject = "sp_confirmed_sensmsg_" + arnn.access$000();
    localObject = BaseApplication.getContext().getSharedPreferences((String)localObject, 0).edit();
    ((SharedPreferences.Editor)localObject).putString(this.cBa, this.val$key);
    ((SharedPreferences.Editor)localObject).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mqp.app.sec.MQPSensitiveMsgUtil.3
 * JD-Core Version:    0.7.0.1
 */