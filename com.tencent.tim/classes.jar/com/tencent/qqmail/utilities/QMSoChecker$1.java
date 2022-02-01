package com.tencent.qqmail.utilities;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.marcos.AppConfig;
import com.tencent.qqmail.trd.guava.Joiner;
import com.tencent.qqmail.utilities.log.QMLog;
import java.util.Arrays;
import moai.oss.OssHelper;
import moai.sochecker.SoChecker;
import moai.sochecker.SoCheckerException;

final class QMSoChecker$1
  implements Runnable
{
  public void run()
  {
    Object localObject = QMApplicationContext.sharedInstance();
    String str = String.valueOf(AppConfig.getSystemVersionCode());
    SharedPreferences localSharedPreferences = ((Context)localObject).getSharedPreferences("so_checker", 0);
    boolean bool = localSharedPreferences.getBoolean(str, false);
    Log.i("QMSoChecker", "doCheck hasChecked:" + bool + ", version:" + str);
    if (bool) {}
    for (;;)
    {
      return;
      localSharedPreferences.edit().putBoolean(str, true).commit();
      try
      {
        long l = System.currentTimeMillis();
        localObject = new SoChecker((Context)localObject, str);
        ((SoChecker)localObject).setLogger(new QMSoChecker.1.1(this));
        localObject = ((SoChecker)localObject).validateLib();
        QMLog.log(4, "QMSoChecker", "doCheck usedTime:[%d], ret[%s]", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Arrays.toString((Object[])localObject) });
        if ((localObject == null) || (localObject.length > 0))
        {
          OssHelper.soInvalid(new Object[] { "soCheck;" + Joiner.on(";").join((Object[])localObject) });
          return;
        }
      }
      catch (SoCheckerException localSoCheckerException)
      {
        QMLog.log(5, "QMSoChecker", "doCheck err", localSoCheckerException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.QMSoChecker.1
 * JD-Core Version:    0.7.0.1
 */