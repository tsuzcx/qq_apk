package com.tencent.feedback.eup;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Process;
import android.util.Log;
import com.tencent.feedback.common.c;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class BuglyBroadcastRecevier
  extends BroadcastReceiver
{
  public static final String ACTION_ENCRY_KEY = "feedback";
  public static final int ACTION_ENCRY_TYPE = 1;
  public static final String ACTION_PROCESS_CRASHED = "com.tencent.feedback.A02";
  public static final String ACTION_PROCESS_LAUNCHED = "com.tencent.feedback.A01";
  public static final String BUNDLE_APPINFO = "com.tencent.feedback.B01";
  public static final String BUNDLE_CRASHINFO = "com.tencent.feedback.B02";
  public static final String PARAM_AVAIL_RAM = "com.tencent.feedback.P07";
  public static final String PARAM_AVAIL_ROM = "com.tencent.feedback.P13";
  public static final String PARAM_AVAIL_SDCARD = "com.tencent.feedback.P06";
  public static final String PARAM_CRASH_TYPE = "com.tencent.feedback.P05";
  public static final String PARAM_ENCRY_PKG_NAME = "com.tencent.feedback.P12";
  public static final String PARAM_EXP_MESSAGE = "com.tencent.feedback.P09";
  public static final String PARAM_EXP_STACK = "com.tencent.feedback.P010";
  public static final String PARAM_EXP_TYPE_NAME = "com.tencent.feedback.P08";
  public static final String PARAM_IS_FRONT_PROCESS = "com.tencent.feedback.P03";
  public static final String PARAM_PKG_NAME = "com.tencent.feedback.P01";
  public static final String PARAM_PROCESS_NAME = "com.tencent.feedback.P02";
  public static final String PARAM_SERVER_KEY_VALUE = "com.tencent.feedback.P17";
  public static final String PARAM_SERVER_SCENE_TAG = "com.tencent.feedback.P15";
  public static final String PARAM_SURVIVAL_TIME = "com.tencent.feedback.P011";
  public static final String PARAM_THREAD_NAME = "com.tencent.feedback.P04";
  public static final String PARAM_USER_KEY_VALUE = "com.tencent.feedback.P16";
  public static final String PARAM_USER_SCENE_TAG = "com.tencent.feedback.P14";
  public static final long UPLOADLIMITED = 60000L;
  private static BuglyBroadcastRecevier instance;
  private String lastAPN;
  private Context mContext;
  private IntentFilter mFilter = new IntentFilter();
  private final ProcessMoniterHandler monierHandler;
  
  public BuglyBroadcastRecevier()
  {
    this.monierHandler = null;
  }
  
  public BuglyBroadcastRecevier(ProcessMoniterHandler paramProcessMoniterHandler)
  {
    this.monierHandler = paramProcessMoniterHandler;
  }
  
  public static void brocastCrash(Context paramContext, e parame)
  {
    if (paramContext != null)
    {
      if (parame == null) {
        return;
      }
      try
      {
        Object localObject1 = CrashReport.getCrashRuntimeStrategy();
        if (localObject1 == null)
        {
          com.tencent.feedback.common.e.d("magic! no crash stategy,no notify return ?", new Object[0]);
          return;
        }
        if (!((CrashStrategyBean)localObject1).isBroadcast())
        {
          com.tencent.feedback.common.e.a("close brocast!", new Object[0]);
          return;
        }
        com.tencent.feedback.common.e.a("notify crash !", new Object[0]);
        localObject1 = com.tencent.feedback.common.a.b(paramContext);
        Object localObject2 = com.tencent.feedback.proguard.a.a(((String)localObject1).getBytes("utf8"), 1, "feedback");
        Intent localIntent = new Intent("com.tencent.feedback.A02");
        localIntent.putExtra("com.tencent.feedback.P12", (byte[])localObject2);
        localObject2 = new Bundle();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject1);
        ((Bundle)localObject2).putString("com.tencent.feedback.P01", localStringBuilder.toString());
        ((Bundle)localObject2).putString("com.tencent.feedback.P02", parame.q());
        ((Bundle)localObject2).putString("com.tencent.feedback.P04", parame.r());
        ((Bundle)localObject2).putByte("com.tencent.feedback.P05", parame.P());
        ((Bundle)localObject2).putLong("com.tencent.feedback.P13", parame.G());
        ((Bundle)localObject2).putLong("com.tencent.feedback.P06", parame.H());
        ((Bundle)localObject2).putLong("com.tencent.feedback.P07", parame.F());
        ((Bundle)localObject2).putString("com.tencent.feedback.P08", parame.e());
        ((Bundle)localObject2).putString("com.tencent.feedback.P09", parame.f());
        ((Bundle)localObject2).putString("com.tencent.feedback.P010", parame.h());
        ((Bundle)localObject2).putBoolean("com.tencent.feedback.P03", com.tencent.feedback.common.a.g(paramContext));
        ((Bundle)localObject2).putLong("com.tencent.feedback.P011", parame.Q());
        ((Bundle)localObject2).putInt("com.tencent.feedback.P14", parame.R());
        ((Bundle)localObject2).putInt("com.tencent.feedback.P15", parame.S());
        ((Bundle)localObject2).putBundle("com.tencent.feedback.P16", getBundleFromMap(parame.T()));
        ((Bundle)localObject2).putBundle("com.tencent.feedback.P17", getBundleFromMap(parame.U()));
        localIntent.putExtra("com.tencent.feedback.B02", (Bundle)localObject2);
        paramContext.sendBroadcast(localIntent);
        return;
      }
      catch (Throwable paramContext)
      {
        if (!com.tencent.feedback.common.e.a(paramContext))
        {
          parame = new StringBuilder("something error ");
          parame.append(paramContext.getClass().getName());
          Log.w("eup", parame.toString());
        }
        return;
      }
    }
  }
  
  protected static void brocastProcessLaunch(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    try
    {
      localObject1 = CrashReport.getCrashRuntimeStrategy();
      if (localObject1 == null)
      {
        com.tencent.feedback.common.e.d("magic! no crash stategy,no notify return ?", new Object[0]);
        return;
      }
      if (!((CrashStrategyBean)localObject1).isBroadcast())
      {
        com.tencent.feedback.common.e.a("close brocast!", new Object[0]);
        return;
      }
      com.tencent.feedback.common.e.a("notify launch !", new Object[0]);
      Object localObject2 = com.tencent.feedback.common.a.b(paramContext);
      Object localObject3 = com.tencent.feedback.proguard.a.a(((String)localObject2).getBytes("utf8"), 1, "feedback");
      localObject1 = new Intent("com.tencent.feedback.A01");
      ((Intent)localObject1).putExtra("com.tencent.feedback.P12", (byte[])localObject3);
      localObject3 = new Bundle();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject2);
      ((Bundle)localObject3).putString("com.tencent.feedback.P01", localStringBuilder.toString());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(com.tencent.feedback.common.a.a(Process.myPid()));
      ((Bundle)localObject3).putString("com.tencent.feedback.P02", ((StringBuilder)localObject2).toString());
      ((Bundle)localObject3).putBoolean("com.tencent.feedback.P03", com.tencent.feedback.common.a.g(paramContext));
      ((Intent)localObject1).putExtra("com.tencent.feedback.B01", (Bundle)localObject3);
      paramContext.sendBroadcast((Intent)localObject1);
      return;
    }
    catch (Throwable paramContext)
    {
      Object localObject1;
      if (!com.tencent.feedback.common.e.a(paramContext))
      {
        localObject1 = new StringBuilder("something error ");
        ((StringBuilder)localObject1).append(paramContext.getClass().getName());
        Log.w("eup", ((StringBuilder)localObject1).toString());
      }
    }
  }
  
  private static Bundle getBundleFromMap(Map<String, String> paramMap)
  {
    Bundle localBundle = new Bundle();
    if ((paramMap != null) && (paramMap.size() > 0))
    {
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        localBundle.putString((String)localEntry.getKey(), (String)localEntry.getValue());
      }
    }
    return localBundle;
  }
  
  public static BuglyBroadcastRecevier getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new BuglyBroadcastRecevier();
      }
      BuglyBroadcastRecevier localBuglyBroadcastRecevier = instance;
      return localBuglyBroadcastRecevier;
    }
    finally {}
  }
  
  public void addFilter(String paramString)
  {
    try
    {
      if (!this.mFilter.hasAction(paramString)) {
        this.mFilter.addAction(paramString);
      }
      com.tencent.feedback.common.e.b("add action %s", new Object[] { paramString });
      return;
    }
    finally {}
  }
  
  protected void finalize()
  {
    super.finalize();
    Context localContext = this.mContext;
    if (localContext != null) {
      localContext.unregisterReceiver(this);
    }
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if (processConnectedBroadCast(paramContext, paramIntent)) {
      return;
    }
    CrashStrategyBean localCrashStrategyBean = CrashReport.getCrashRuntimeStrategy();
    if (localCrashStrategyBean == null)
    {
      com.tencent.feedback.common.e.d("magic! no crash stategy,no notify return ?", new Object[0]);
      return;
    }
    if (!localCrashStrategyBean.isReceiveBroadcast())
    {
      com.tencent.feedback.common.e.a("close proc receiver!", new Object[0]);
      return;
    }
    if (processOtherProcessLaunched(paramContext, paramIntent)) {
      return;
    }
    if (processOtherProcessCrashed(paramContext, paramIntent)) {}
  }
  
  protected final boolean processConnectedBroadCast(Context paramContext, Intent paramIntent)
  {
    return false;
  }
  
  public final boolean processOtherProcessCrashed(Context paramContext, Intent paramIntent)
  {
    if ((paramContext != null) && (paramIntent != null)) {
      try
      {
        if (paramIntent.getAction().equals("com.tencent.feedback.A02"))
        {
          if (this.monierHandler == null)
          {
            com.tencent.feedback.common.e.a("no moniter handler", new Object[0]);
            return true;
          }
          try
          {
            Object localObject1 = paramContext.getPackageName();
            String str = c.a(paramContext).E();
            Object localObject2 = paramIntent.getByteArrayExtra("com.tencent.feedback.P12");
            paramContext = paramIntent.getBundleExtra("com.tencent.feedback.B02");
            if ((localObject2 != null) && (paramContext != null))
            {
              paramIntent = new String(com.tencent.feedback.proguard.a.b((byte[])localObject2, 1, "feedback"), "utf8");
              if (!paramIntent.equals(paramContext.getString("com.tencent.feedback.P01")))
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append(paramContext.getString("com.tencent.feedback.P01"));
                com.tencent.feedback.common.e.c("args fail other proc cra inner %s %s", new Object[] { paramIntent, ((StringBuilder)localObject1).toString() });
                return true;
              }
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append(paramIntent);
              ((StringBuilder)localObject2).append(paramContext.getString("com.tencent.feedback.P02"));
              localObject2 = ((StringBuilder)localObject2).toString();
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append((String)localObject1);
              localStringBuilder.append(str);
              if (((String)localObject2).equals(localStringBuilder.toString()))
              {
                com.tencent.feedback.common.e.a("current proc not need to notify", new Object[0]);
                return true;
              }
              com.tencent.feedback.common.e.a("notify other app cra %s", new Object[] { paramIntent });
              this.monierHandler.onOtherAppProcessCrash(paramIntent, paramContext.getString("com.tencent.feedback.P02"), paramContext.getString("com.tencent.feedback.P04"), paramContext.getByte("com.tencent.feedback.P05"), paramContext.getLong("com.tencent.feedback.P13"), paramContext.getLong("com.tencent.feedback.P06"), paramContext.getLong("com.tencent.feedback.P07"), paramContext.getString("com.tencent.feedback.P08"), paramContext.getString("com.tencent.feedback.P09"), paramContext.getString("com.tencent.feedback.P010"), paramContext.getBoolean("com.tencent.feedback.P03"), paramContext.getLong("com.tencent.feedback.P011"), paramContext);
              com.tencent.feedback.common.e.a("notify other app cra %s end", new Object[] { paramIntent });
            }
            else
            {
              paramIntent = new StringBuilder();
              paramIntent.append(localObject2);
              paramIntent = paramIntent.toString();
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append(paramContext);
              com.tencent.feedback.common.e.c("args fail other proc cra %s %s", new Object[] { paramIntent, ((StringBuilder)localObject1).toString() });
              return true;
            }
          }
          catch (UnsupportedEncodingException paramContext)
          {
            paramContext.printStackTrace();
            return true;
          }
        }
      }
      finally {}
    }
    return false;
  }
  
  protected final boolean processOtherProcessLaunched(Context paramContext, Intent paramIntent)
  {
    if ((paramContext != null) && (paramIntent != null)) {
      try
      {
        if (paramIntent.getAction().equals("com.tencent.feedback.A01"))
        {
          if (this.monierHandler == null)
          {
            com.tencent.feedback.common.e.a("no moniter handler", new Object[0]);
            return true;
          }
          try
          {
            Object localObject1 = paramContext.getPackageName();
            String str = c.a(paramContext).E();
            Object localObject2 = paramIntent.getByteArrayExtra("com.tencent.feedback.P12");
            paramContext = paramIntent.getBundleExtra("com.tencent.feedback.B01");
            if ((localObject2 != null) && (paramContext != null))
            {
              paramIntent = new String(com.tencent.feedback.proguard.a.b((byte[])localObject2, 1, "feedback"), "utf8");
              if (!paramIntent.equals(paramContext.getString("com.tencent.feedback.P01")))
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append(paramContext.getString("com.tencent.feedback.P01"));
                com.tencent.feedback.common.e.c("args fail other proc launch inner %s %s", new Object[] { paramIntent, ((StringBuilder)localObject1).toString() });
                return true;
              }
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append(paramIntent);
              ((StringBuilder)localObject2).append(paramContext.getString("com.tencent.feedback.P02"));
              localObject2 = ((StringBuilder)localObject2).toString();
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append((String)localObject1);
              localStringBuilder.append(str);
              if (((String)localObject2).equals(localStringBuilder.toString()))
              {
                com.tencent.feedback.common.e.a("current proc not need to notify", new Object[0]);
                return true;
              }
              com.tencent.feedback.common.e.a("notify other app lau %s", new Object[] { paramIntent });
              this.monierHandler.onOtherAppProcessLaunched(paramIntent, paramContext.getString("com.tencent.feedback.P02"), paramContext.getBoolean("com.tencent.feedback.P03"), paramContext);
              com.tencent.feedback.common.e.a("notify other app lau %s end", new Object[] { paramIntent });
            }
            else
            {
              paramIntent = new StringBuilder();
              paramIntent.append(localObject2);
              paramIntent = paramIntent.toString();
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append(paramContext);
              com.tencent.feedback.common.e.c("args fail other proc launch %s %s", new Object[] { paramIntent, ((StringBuilder)localObject1).toString() });
              return true;
            }
          }
          catch (UnsupportedEncodingException paramContext)
          {
            paramContext.printStackTrace();
            return true;
          }
        }
      }
      finally {}
    }
    return false;
  }
  
  public void regist(Context paramContext)
  {
    try
    {
      com.tencent.feedback.common.e.a("regis BC", new Object[0]);
      paramContext.registerReceiver(this, this.mFilter);
      this.mContext = paramContext;
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public void unregist(Context paramContext)
  {
    try
    {
      com.tencent.feedback.common.e.a("unregis BC", new Object[0]);
      paramContext.unregisterReceiver(this);
      this.mContext = paramContext;
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.feedback.eup.BuglyBroadcastRecevier
 * JD-Core Version:    0.7.0.1
 */