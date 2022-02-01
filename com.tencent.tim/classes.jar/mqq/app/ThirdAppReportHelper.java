package mqq.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;

public class ThirdAppReportHelper
{
  public static IThirdAppOpenReport sThirdAppReporter;
  
  public static void handleIntentForQQBrowser(Context paramContext, Intent paramIntent)
  {
    try
    {
      if (paramIntent.getComponent() != null)
      {
        String str = paramIntent.getComponent().getClassName();
        if ((str != null) && ((str.contains("QQBrowserActivity")) || (str.contains("QQBrowserDelegationActivity"))) && (!paramIntent.hasExtra("StartClickTime")))
        {
          paramIntent.putExtra("StartClickTime", SystemClock.elapsedRealtime());
          paramIntent.putExtra("SourceActivityName", paramContext.getClass().getSimpleName());
        }
      }
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  public static void reportThirdAppOpen(Context paramContext, Intent paramIntent, int paramInt)
  {
    if (sThirdAppReporter != null) {
      sThirdAppReporter.report(paramContext, paramIntent, paramInt);
    }
    handleIntentForQQBrowser(paramContext, paramIntent);
  }
  
  public static void startActivityForResult(Activity paramActivity, Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    if (sThirdAppReporter != null) {
      sThirdAppReporter.startActivityForResult(paramActivity, paramIntent, paramInt, paramBundle);
    }
    handleIntentForQQBrowser(paramActivity, paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     mqq.app.ThirdAppReportHelper
 * JD-Core Version:    0.7.0.1
 */