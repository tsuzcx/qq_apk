import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.shadow.dynamic.host.EnterCallback;
import mqq.app.AppRuntime;

public class avno
{
  private static int exB = -1;
  
  public static void S(Context paramContext, boolean paramBoolean)
  {
    if (avmc.a().aKJ())
    {
      avoc.u("ReaderPluginHelper", "[loadPluginRuntime] sIsPluginReady = true ! mGrayState = " + exB);
      return;
    }
    avoc.u("ReaderPluginHelper", "[loadPluginRuntime] sIsPluginReady = false, mGrayState = " + exB + " isShadowOnly = " + paramBoolean);
    if (aKN()) {
      gr(paramContext);
    }
    for (;;)
    {
      avof.dk(paramContext, String.valueOf(exB));
      return;
      if (paramBoolean) {
        break;
      }
      BaseApplicationImpl.getApplication().waitAppRuntime(null).getAppRuntime("qqreaderplugin.apk");
    }
  }
  
  public static void a(Context paramContext, Intent paramIntent, String paramString, EnterCallback paramEnterCallback)
  {
    Bundle localBundle = paramIntent.getExtras();
    paramIntent = localBundle;
    if (localBundle == null) {
      paramIntent = new Bundle();
    }
    paramIntent.putString("com.tencent.reader.plugin.KEY_ACTIVITY_CLASSNAME", paramString);
    paramIntent.putLong("start_plugin_act_begin_time", System.currentTimeMillis());
    avnq.a().enter(paramContext, 1003L, BaseApplicationImpl.getApplication().getRuntime().getAccount(), "", paramIntent, paramEnterCallback);
  }
  
  public static boolean aKN()
  {
    return false;
  }
  
  public static void e(Context paramContext, Intent paramIntent, String paramString)
  {
    a(paramContext, paramIntent, paramString, null);
  }
  
  public static void gr(Context paramContext)
  {
    avnq.a().enter(paramContext, 1002L, BaseApplicationImpl.getApplication().getRuntime().getAccount(), "", new Bundle(), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avno
 * JD-Core Version:    0.7.0.1
 */