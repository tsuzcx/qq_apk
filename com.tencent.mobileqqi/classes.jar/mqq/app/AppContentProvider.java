package mqq.app;

import android.content.ContentProvider;
import android.content.Context;
import android.util.Log;
import com.tencent.qphone.base.util.QLog;

public abstract class AppContentProvider
  extends ContentProvider
{
  public AppRuntime getRuntime(String paramString)
  {
    try
    {
      paramString = ((MobileQQ)getContext().getApplicationContext()).getAppRuntime(paramString);
      return paramString;
    }
    catch (AccountNotMatchException paramString)
    {
      paramString.printStackTrace();
      QLog.e("mqq", 2, Log.getStackTraceString(paramString));
    }
    return null;
  }
  
  public boolean onCreate()
  {
    ((MobileQQ)getContext().getApplicationContext()).onCreate();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     mqq.app.AppContentProvider
 * JD-Core Version:    0.7.0.1
 */