import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.open.business.base.StaticAnalyz;
import com.tencent.open.business.base.appreport.AppReport;
import com.tencent.open.business.base.appreport.AppReportReceiver;
import com.tencent.qphone.base.remote.SimpleAccount;

public class hly
  implements Runnable
{
  public hly(AppReportReceiver paramAppReportReceiver, Intent paramIntent, Context paramContext) {}
  
  public void run()
  {
    int i = 8;
    int j;
    for (;;)
    {
      boolean bool;
      String str2;
      String str3;
      try
      {
        String str1 = this.jdField_a_of_type_AndroidContentIntent.getAction();
        bool = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("android.intent.extra.REPLACING", false);
        str2 = this.jdField_a_of_type_AndroidContentIntent.getDataString();
        if ((str2 == null) || (!str2.startsWith("package:"))) {
          return;
        }
        str2 = str2.substring(8);
        if (str2.equals("com.tencent.mobileqqi")) {
          return;
        }
        str3 = BaseApplicationImpl.a().getFirstSimpleAccount().getUin();
        if ((str1.equals("android.intent.action.PACKAGE_ADDED")) && (!bool))
        {
          j = 2;
          bool = str2.equals("com.tencent.android.qqdownloader");
          i = j;
          if (!bool) {}
        }
      }
      catch (Throwable localThrowable)
      {
        Log.d("crash", Log.getStackTraceString(localThrowable));
        return;
      }
      try
      {
        StaticAnalyz.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), str3);
        i = j;
      }
      catch (Exception localException)
      {
        i = j;
        continue;
      }
      if (BaseApplicationImpl.b)
      {
        Log.d("isFirstLaunch", "firstlaunch!");
        return;
        if ((!localThrowable.equals("android.intent.action.PACKAGE_REMOVED")) || (bool)) {
          if ((localThrowable.equals("android.intent.action.PACKAGE_REPLACED")) && (bool)) {
            i = 4;
          }
        }
      }
      else
      {
        AppReport.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), str2, i, null, null, str3);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hly
 * JD-Core Version:    0.7.0.1
 */