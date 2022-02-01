package com.tencent.mobileqq.vashealth;

import android.content.SharedPreferences;
import android.text.TextUtils;
import aqtw;
import aqtz;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class StepAlarmReceiver$2
  implements Runnable
{
  StepAlarmReceiver$2(StepAlarmReceiver paramStepAlarmReceiver) {}
  
  public void run()
  {
    String str = String.valueOf(aqtw.hU());
    if ((!TextUtils.isEmpty(StepAlarmReceiver.cxi)) && (!str.equals(StepAlarmReceiver.cxi))) {
      aqtw.AL = 0.0F;
    }
    Object localObject = aqtz.C();
    if (((SharedPreferences)localObject).getBoolean("config_ready", false))
    {
      this.this$0.atP = ((SharedPreferences)localObject).getInt("max_interval", 0);
      this.this$0.ecT = ((SharedPreferences)localObject).getInt("max_increment", 0);
    }
    StepAlarmReceiver.cxi = str;
    try
    {
      localObject = aqtw.Cy();
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        return;
      }
      localObject = new JSONObject((String)localObject);
      int i = ((JSONObject)localObject).getInt(str + "_total");
      int j = ((JSONObject)localObject).getInt(str + "_init");
      float f1 = ((JSONObject)localObject).getInt(str + "_offset") + (i - j);
      float f2 = aqtw.AL;
      long l1 = NetConnInfoCenter.getServerTimeMillis();
      long l2 = aqtw.atM;
      str = ((JSONObject)localObject).toString();
      QLog.i("StepAlarmReceiver", 1, "receiver long time report max report steps:" + this.this$0.ecT + ",report interval:" + this.this$0.atP);
      if ((f1 - f2 > this.this$0.ecT) || (l1 - l2 > this.this$0.atP))
      {
        aqtw.VH(str);
        return;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("health_manager", 2, "long time report Exception:" + localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.StepAlarmReceiver.2
 * JD-Core Version:    0.7.0.1
 */