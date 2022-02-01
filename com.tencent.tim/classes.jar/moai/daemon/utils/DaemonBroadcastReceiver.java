package moai.daemon.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.Arrays;
import moai.daemon.DaemonManager;

public class DaemonBroadcastReceiver
  extends BroadcastReceiver
{
  private static final String TAG = "DaemonBroadcastReceiver";
  private static DaemonBroadcastReceiver sReceiver = new DaemonBroadcastReceiver();
  
  public static void register()
  {
    int i = 0;
    unregister();
    Context localContext = DaemonManager.getContext();
    if (localContext == null)
    {
      Log.w("DaemonBroadcastReceiver", "register, context is null!");
      return;
    }
    String[] arrayOfString = new String[3];
    arrayOfString[0] = "android.intent.action.USER_PRESENT";
    arrayOfString[1] = "android.intent.action.SCREEN_ON";
    arrayOfString[2] = "android.intent.action.SCREEN_OFF";
    IntentFilter localIntentFilter = new IntentFilter();
    int j = arrayOfString.length;
    while (i < j)
    {
      localIntentFilter.addAction(arrayOfString[i]);
      i += 1;
    }
    Log.i("DaemonBroadcastReceiver", "register receiver, actions: " + Arrays.toString(arrayOfString));
    try
    {
      localContext.registerReceiver(sReceiver, localIntentFilter);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.w("DaemonBroadcastReceiver", "register failed", localThrowable);
    }
  }
  
  public static void unregister()
  {
    Context localContext = DaemonManager.getContext();
    if (localContext == null)
    {
      Log.w("DaemonBroadcastReceiver", "unregister, context is null!");
      return;
    }
    Log.i("DaemonBroadcastReceiver", "unregister receiver");
    try
    {
      localContext.unregisterReceiver(sReceiver);
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null)
    {
      paramContext = null;
      Log.i("DaemonBroadcastReceiver", "onReceive, action: " + paramContext);
      if ((!"android.intent.action.USER_PRESENT".equals(paramContext)) && (!"android.intent.action.SCREEN_ON".equals(paramContext))) {
        break label60;
      }
      DaemonManager.finishDaemonActivity();
    }
    label60:
    while (!"android.intent.action.SCREEN_OFF".equals(paramContext))
    {
      return;
      paramContext = paramIntent.getAction();
      break;
    }
    DaemonManager.startDaemonActivity();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.daemon.utils.DaemonBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */