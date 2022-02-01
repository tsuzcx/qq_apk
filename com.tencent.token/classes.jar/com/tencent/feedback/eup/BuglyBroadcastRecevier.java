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
  private static BuglyBroadcastRecevier instance = null;
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
    if ((paramContext == null) || (parame == null)) {}
    do
    {
      return;
      try
      {
        localObject1 = CrashReport.getCrashRuntimeStrategy();
        if (localObject1 != null) {
          break;
        }
        com.tencent.feedback.common.e.d("magic! no crash stategy,no notify return ?", new Object[0]);
        return;
      }
      catch (Throwable paramContext) {}
    } while (com.tencent.feedback.common.e.a(paramContext));
    Log.w("eup", "something error " + paramContext.getClass().getName());
    return;
    if (!((CrashStrategyBean)localObject1).isBroadcast())
    {
      com.tencent.feedback.common.e.a("close brocast!", new Object[0]);
      return;
    }
    com.tencent.feedback.common.e.a("notify crash !", new Object[0]);
    Object localObject1 = com.tencent.feedback.common.a.b(paramContext);
    Object localObject2 = com.tencent.feedback.proguard.a.a(((String)localObject1).getBytes("utf8"), 1, "feedback");
    Intent localIntent = new Intent("com.tencent.feedback.A02");
    localIntent.putExtra("com.tencent.feedback.P12", (byte[])localObject2);
    localObject2 = new Bundle();
    ((Bundle)localObject2).putString("com.tencent.feedback.P01", (String)localObject1);
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
  }
  
  protected static void brocastProcessLaunch(Context paramContext)
  {
    if (paramContext == null) {}
    do
    {
      return;
      try
      {
        localObject1 = CrashReport.getCrashRuntimeStrategy();
        if (localObject1 != null) {
          break;
        }
        com.tencent.feedback.common.e.d("magic! no crash stategy,no notify return ?", new Object[0]);
        return;
      }
      catch (Throwable paramContext) {}
    } while (com.tencent.feedback.common.e.a(paramContext));
    Log.w("eup", "something error " + paramContext.getClass().getName());
    return;
    if (!((CrashStrategyBean)localObject1).isBroadcast())
    {
      com.tencent.feedback.common.e.a("close brocast!", new Object[0]);
      return;
    }
    com.tencent.feedback.common.e.a("notify launch !", new Object[0]);
    Object localObject1 = com.tencent.feedback.common.a.b(paramContext);
    Object localObject2 = com.tencent.feedback.proguard.a.a(((String)localObject1).getBytes("utf8"), 1, "feedback");
    Intent localIntent = new Intent("com.tencent.feedback.A01");
    localIntent.putExtra("com.tencent.feedback.P12", (byte[])localObject2);
    localObject2 = new Bundle();
    ((Bundle)localObject2).putString("com.tencent.feedback.P01", (String)localObject1);
    ((Bundle)localObject2).putString("com.tencent.feedback.P02", com.tencent.feedback.common.a.a(Process.myPid()));
    ((Bundle)localObject2).putBoolean("com.tencent.feedback.P03", com.tencent.feedback.common.a.g(paramContext));
    localIntent.putExtra("com.tencent.feedback.B01", (Bundle)localObject2);
    paramContext.sendBroadcast(localIntent);
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
    if (this.mContext != null) {
      this.mContext.unregisterReceiver(this);
    }
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if (processConnectedBroadCast(paramContext, paramIntent)) {}
    do
    {
      return;
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
    } while ((processOtherProcessLaunched(paramContext, paramIntent)) || (!processOtherProcessCrashed(paramContext, paramIntent)));
  }
  
  protected final boolean processConnectedBroadCast(Context paramContext, Intent paramIntent)
  {
    return false;
  }
  
  /* Error */
  public final boolean processOtherProcessCrashed(Context paramContext, Intent paramIntent)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +21 -> 24
    //   6: aload_2
    //   7: ifnull +17 -> 24
    //   10: aload_2
    //   11: invokevirtual 382	android/content/Intent:getAction	()Ljava/lang/String;
    //   14: ldc 14
    //   16: invokevirtual 386	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   19: istore_3
    //   20: iload_3
    //   21: ifne +9 -> 30
    //   24: iconst_0
    //   25: istore_3
    //   26: aload_0
    //   27: monitorexit
    //   28: iload_3
    //   29: ireturn
    //   30: aload_0
    //   31: getfield 102	com/tencent/feedback/eup/BuglyBroadcastRecevier:monierHandler	Lcom/tencent/feedback/eup/ProcessMoniterHandler;
    //   34: ifnonnull +19 -> 53
    //   37: ldc_w 388
    //   40: iconst_0
    //   41: anewarray 117	java/lang/Object
    //   44: invokestatic 169	com/tencent/feedback/common/e:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   47: pop
    //   48: iconst_1
    //   49: istore_3
    //   50: goto -24 -> 26
    //   53: aload_1
    //   54: invokevirtual 391	android/content/Context:getPackageName	()Ljava/lang/String;
    //   57: astore 4
    //   59: aload_1
    //   60: invokestatic 396	com/tencent/feedback/common/c:a	(Landroid/content/Context;)Lcom/tencent/feedback/common/c;
    //   63: invokevirtual 399	com/tencent/feedback/common/c:E	()Ljava/lang/String;
    //   66: astore_1
    //   67: aload_2
    //   68: ldc 38
    //   70: invokevirtual 402	android/content/Intent:getByteArrayExtra	(Ljava/lang/String;)[B
    //   73: astore 5
    //   75: aload_2
    //   76: ldc 23
    //   78: invokevirtual 406	android/content/Intent:getBundleExtra	(Ljava/lang/String;)Landroid/os/Bundle;
    //   81: astore_2
    //   82: aload 5
    //   84: ifnull +7 -> 91
    //   87: aload_2
    //   88: ifnonnull +54 -> 142
    //   91: ldc_w 408
    //   94: iconst_2
    //   95: anewarray 117	java/lang/Object
    //   98: dup
    //   99: iconst_0
    //   100: new 131	java/lang/StringBuilder
    //   103: dup
    //   104: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   107: aload 5
    //   109: invokevirtual 411	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   112: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: aastore
    //   116: dup
    //   117: iconst_1
    //   118: new 131	java/lang/StringBuilder
    //   121: dup
    //   122: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   125: aload_2
    //   126: invokevirtual 411	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   129: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: aastore
    //   133: invokestatic 414	com/tencent/feedback/common/e:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   136: pop
    //   137: iconst_1
    //   138: istore_3
    //   139: goto -113 -> 26
    //   142: new 181	java/lang/String
    //   145: dup
    //   146: aload 5
    //   148: iconst_1
    //   149: ldc 8
    //   151: invokestatic 416	com/tencent/feedback/proguard/a:b	([BILjava/lang/String;)[B
    //   154: ldc 179
    //   156: invokespecial 419	java/lang/String:<init>	([BLjava/lang/String;)V
    //   159: astore 5
    //   161: aload 5
    //   163: aload_2
    //   164: ldc 53
    //   166: invokevirtual 423	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   169: invokevirtual 386	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   172: ifne +46 -> 218
    //   175: ldc_w 425
    //   178: iconst_2
    //   179: anewarray 117	java/lang/Object
    //   182: dup
    //   183: iconst_0
    //   184: aload 5
    //   186: aastore
    //   187: dup
    //   188: iconst_1
    //   189: new 131	java/lang/StringBuilder
    //   192: dup
    //   193: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   196: aload_2
    //   197: ldc 53
    //   199: invokevirtual 423	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   202: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   208: aastore
    //   209: invokestatic 414	com/tencent/feedback/common/e:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   212: pop
    //   213: iconst_1
    //   214: istore_3
    //   215: goto -189 -> 26
    //   218: new 131	java/lang/StringBuilder
    //   221: dup
    //   222: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   225: aload 5
    //   227: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: aload_2
    //   231: ldc 56
    //   233: invokevirtual 423	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   236: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   242: new 131	java/lang/StringBuilder
    //   245: dup
    //   246: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   249: aload 4
    //   251: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: aload_1
    //   255: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   261: invokevirtual 386	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   264: ifeq +19 -> 283
    //   267: ldc_w 427
    //   270: iconst_0
    //   271: anewarray 117	java/lang/Object
    //   274: invokestatic 169	com/tencent/feedback/common/e:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   277: pop
    //   278: iconst_1
    //   279: istore_3
    //   280: goto -254 -> 26
    //   283: ldc_w 429
    //   286: iconst_1
    //   287: anewarray 117	java/lang/Object
    //   290: dup
    //   291: iconst_0
    //   292: aload 5
    //   294: aastore
    //   295: invokestatic 169	com/tencent/feedback/common/e:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   298: pop
    //   299: aload_0
    //   300: getfield 102	com/tencent/feedback/eup/BuglyBroadcastRecevier:monierHandler	Lcom/tencent/feedback/eup/ProcessMoniterHandler;
    //   303: aload 5
    //   305: aload_2
    //   306: ldc 56
    //   308: invokevirtual 423	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   311: aload_2
    //   312: ldc 68
    //   314: invokevirtual 423	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   317: aload_2
    //   318: ldc 35
    //   320: invokevirtual 433	android/os/Bundle:getByte	(Ljava/lang/String;)B
    //   323: aload_2
    //   324: ldc 29
    //   326: invokevirtual 437	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   329: aload_2
    //   330: ldc 32
    //   332: invokevirtual 437	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   335: aload_2
    //   336: ldc 26
    //   338: invokevirtual 437	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   341: aload_2
    //   342: ldc 47
    //   344: invokevirtual 423	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   347: aload_2
    //   348: ldc 41
    //   350: invokevirtual 423	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   353: aload_2
    //   354: ldc 44
    //   356: invokevirtual 423	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   359: aload_2
    //   360: ldc 50
    //   362: invokevirtual 440	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   365: aload_2
    //   366: ldc 65
    //   368: invokevirtual 437	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   371: aload_2
    //   372: invokeinterface 446 18 0
    //   377: ldc_w 448
    //   380: iconst_1
    //   381: anewarray 117	java/lang/Object
    //   384: dup
    //   385: iconst_0
    //   386: aload 5
    //   388: aastore
    //   389: invokestatic 169	com/tencent/feedback/common/e:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   392: pop
    //   393: iconst_1
    //   394: istore_3
    //   395: goto -369 -> 26
    //   398: astore_1
    //   399: aload_1
    //   400: invokevirtual 451	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   403: goto -10 -> 393
    //   406: astore_1
    //   407: aload_0
    //   408: monitorexit
    //   409: aload_1
    //   410: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	411	0	this	BuglyBroadcastRecevier
    //   0	411	1	paramContext	Context
    //   0	411	2	paramIntent	Intent
    //   19	376	3	bool	boolean
    //   57	193	4	str	String
    //   73	314	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   53	82	398	java/io/UnsupportedEncodingException
    //   91	137	398	java/io/UnsupportedEncodingException
    //   142	213	398	java/io/UnsupportedEncodingException
    //   218	278	398	java/io/UnsupportedEncodingException
    //   283	393	398	java/io/UnsupportedEncodingException
    //   10	20	406	finally
    //   30	48	406	finally
    //   53	82	406	finally
    //   91	137	406	finally
    //   142	213	406	finally
    //   218	278	406	finally
    //   283	393	406	finally
    //   399	403	406	finally
  }
  
  protected final boolean processOtherProcessLaunched(Context paramContext, Intent paramIntent)
  {
    boolean bool1 = true;
    if ((paramContext != null) && (paramIntent != null)) {}
    for (;;)
    {
      try
      {
        boolean bool2 = paramIntent.getAction().equals("com.tencent.feedback.A01");
        if (!bool2)
        {
          bool1 = false;
          return bool1;
        }
        if (this.monierHandler == null)
        {
          com.tencent.feedback.common.e.a("no moniter handler", new Object[0]);
          continue;
        }
        try
        {
          str = paramContext.getPackageName();
          paramContext = c.a(paramContext).E();
          localObject = paramIntent.getByteArrayExtra("com.tencent.feedback.P12");
          paramIntent = paramIntent.getBundleExtra("com.tencent.feedback.B01");
          if ((localObject != null) && (paramIntent != null)) {
            break label155;
          }
          com.tencent.feedback.common.e.c("args fail other proc launch %s %s", new Object[] { localObject, paramIntent });
        }
        catch (UnsupportedEncodingException paramContext)
        {
          paramContext.printStackTrace();
        }
      }
      finally {}
      String str;
      continue;
      label155:
      Object localObject = new String(com.tencent.feedback.proguard.a.b((byte[])localObject, 1, "feedback"), "utf8");
      if (!((String)localObject).equals(paramIntent.getString("com.tencent.feedback.P01")))
      {
        com.tencent.feedback.common.e.c("args fail other proc launch inner %s %s", new Object[] { localObject, paramIntent.getString("com.tencent.feedback.P01") });
      }
      else if (((String)localObject + paramIntent.getString("com.tencent.feedback.P02")).equals(str + paramContext))
      {
        com.tencent.feedback.common.e.a("current proc not need to notify", new Object[0]);
      }
      else
      {
        com.tencent.feedback.common.e.a("notify other app lau %s", new Object[] { localObject });
        this.monierHandler.onOtherAppProcessLaunched((String)localObject, paramIntent.getString("com.tencent.feedback.P02"), paramIntent.getBoolean("com.tencent.feedback.P03"), paramIntent);
        com.tencent.feedback.common.e.a("notify other app lau %s end", new Object[] { localObject });
      }
    }
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