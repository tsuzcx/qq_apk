package com.tencent.mqp.app.sec;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import arnn;
import com.tencent.qphone.base.util.BaseApplication;

public final class MQPSensitiveMsgUtil$5
  implements Runnable
{
  public void run()
  {
    int i = 0;
    Object localObject = "sp_confirmed_sensmsg_" + arnn.access$000();
    localObject = BaseApplication.getContext().getSharedPreferences((String)localObject, 0);
    Bundle localBundle = new Bundle();
    if (i < 10)
    {
      String str1 = Integer.toString(i);
      if (!((SharedPreferences)localObject).contains(str1)) {}
      for (;;)
      {
        i += 1;
        break;
        String str2 = ((SharedPreferences)localObject).getString(str1, null);
        if (!TextUtils.isEmpty(str2)) {
          localBundle.putString(str2, str1);
        }
      }
    }
    if (localBundle.size() > 0) {
      arnn.access$202(localBundle.size() - 1);
    }
    arnn.w().putBundle(arnn.access$000(), localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mqp.app.sec.MQPSensitiveMsgUtil.5
 * JD-Core Version:    0.7.0.1
 */