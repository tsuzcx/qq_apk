package com.tmsdk.base.oaid;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.text.TextUtils;
import btmsdkobf.m;
import btmsdkobf.m.a;
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicReference;

public class OaidProxy
{
  /* Error */
  public static String doGetOaid(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: invokestatic 26	com/tmsdk/base/utils/PhoneInfoFetcher:isHUAWEI	()Z
    //   9: ifeq +81 -> 90
    //   12: new 28	android/content/Intent
    //   15: dup
    //   16: ldc 30
    //   18: invokespecial 33	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   21: astore 4
    //   23: aload 4
    //   25: ldc 35
    //   27: invokevirtual 39	android/content/Intent:setPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   30: pop
    //   31: new 10	com/tmsdk/base/oaid/OaidProxy$a
    //   34: dup
    //   35: aconst_null
    //   36: invokespecial 42	com/tmsdk/base/oaid/OaidProxy$a:<init>	(Lcom/tmsdk/base/oaid/OaidProxy$1;)V
    //   39: astore_3
    //   40: aload_0
    //   41: aload 4
    //   43: aload_3
    //   44: iconst_1
    //   45: invokevirtual 48	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   48: istore_2
    //   49: iload_2
    //   50: ifeq +40 -> 90
    //   53: aload_3
    //   54: invokevirtual 52	com/tmsdk/base/oaid/OaidProxy$a:getBinder	()Landroid/os/IBinder;
    //   57: invokestatic 57	btmsdkobf/g$a:a	(Landroid/os/IBinder;)Lbtmsdkobf/g;
    //   60: invokeinterface 63 1 0
    //   65: astore 4
    //   67: aload_0
    //   68: aload_3
    //   69: invokevirtual 67	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   72: aload 4
    //   74: areturn
    //   75: astore 4
    //   77: aload_0
    //   78: aload_3
    //   79: invokevirtual 67	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   82: aload 4
    //   84: athrow
    //   85: aload_0
    //   86: aload_3
    //   87: invokevirtual 67	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   90: invokestatic 70	com/tmsdk/base/utils/PhoneInfoFetcher:isXIAOMI	()Z
    //   93: ifeq +8 -> 101
    //   96: aload_0
    //   97: invokestatic 74	btmsdkobf/f:a	(Landroid/content/Context;)Ljava/lang/String;
    //   100: areturn
    //   101: invokestatic 77	com/tmsdk/base/utils/PhoneInfoFetcher:isOPPO	()Z
    //   104: ifne +141 -> 245
    //   107: aload_0
    //   108: invokestatic 81	com/tmsdk/base/utils/PhoneInfoFetcher:isOnePlus	(Landroid/content/Context;)Z
    //   111: ifeq +6 -> 117
    //   114: goto +131 -> 245
    //   117: invokestatic 84	com/tmsdk/base/utils/PhoneInfoFetcher:isVIVO	()Z
    //   120: ifeq +8 -> 128
    //   123: aload_0
    //   124: invokestatic 87	btmsdkobf/ew:a	(Landroid/content/Context;)Ljava/lang/String;
    //   127: areturn
    //   128: invokestatic 90	com/tmsdk/base/utils/PhoneInfoFetcher:isMEIZU	()Z
    //   131: ifeq +8 -> 139
    //   134: aload_0
    //   135: invokestatic 93	btmsdkobf/b:a	(Landroid/content/Context;)Ljava/lang/String;
    //   138: areturn
    //   139: invokestatic 96	com/tmsdk/base/utils/PhoneInfoFetcher:isLenovo	()Z
    //   142: ifeq +110 -> 252
    //   145: new 4	java/lang/Object
    //   148: dup
    //   149: invokespecial 15	java/lang/Object:<init>	()V
    //   152: astore_3
    //   153: new 98	java/util/ArrayList
    //   156: dup
    //   157: invokespecial 99	java/util/ArrayList:<init>	()V
    //   160: astore 4
    //   162: aload 4
    //   164: ldc 101
    //   166: invokevirtual 105	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   169: pop
    //   170: new 107	btmsdkobf/m
    //   173: dup
    //   174: invokespecial 108	btmsdkobf/m:<init>	()V
    //   177: aload_0
    //   178: new 8	com/tmsdk/base/oaid/OaidProxy$2
    //   181: dup
    //   182: aload 4
    //   184: aload_3
    //   185: invokespecial 111	com/tmsdk/base/oaid/OaidProxy$2:<init>	(Ljava/util/ArrayList;Ljava/lang/Object;)V
    //   188: invokevirtual 114	btmsdkobf/m:a	(Landroid/content/Context;Lbtmsdkobf/m$a;)I
    //   191: pop
    //   192: aload_3
    //   193: monitorenter
    //   194: aload 4
    //   196: iconst_0
    //   197: invokevirtual 118	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   200: checkcast 120	java/lang/String
    //   203: ldc 101
    //   205: invokevirtual 124	java/lang/String:compareTo	(Ljava/lang/String;)I
    //   208: istore_1
    //   209: iload_1
    //   210: ifne +7 -> 217
    //   213: aload_3
    //   214: invokevirtual 127	java/lang/Object:wait	()V
    //   217: aload_3
    //   218: monitorexit
    //   219: aload 4
    //   221: invokevirtual 131	java/util/ArrayList:size	()I
    //   224: iconst_1
    //   225: if_icmple +27 -> 252
    //   228: aload 4
    //   230: iconst_1
    //   231: invokevirtual 118	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   234: checkcast 120	java/lang/String
    //   237: astore_0
    //   238: aload_0
    //   239: areturn
    //   240: astore_0
    //   241: aload_3
    //   242: monitorexit
    //   243: aload_0
    //   244: athrow
    //   245: aload_0
    //   246: invokestatic 134	btmsdkobf/ev:a	(Landroid/content/Context;)Ljava/lang/String;
    //   249: astore_0
    //   250: aload_0
    //   251: areturn
    //   252: aconst_null
    //   253: areturn
    //   254: astore_0
    //   255: aconst_null
    //   256: areturn
    //   257: astore 4
    //   259: goto -174 -> 85
    //   262: astore_0
    //   263: aload 4
    //   265: areturn
    //   266: astore_0
    //   267: goto -185 -> 82
    //   270: astore_3
    //   271: goto -181 -> 90
    //   274: astore_0
    //   275: goto -58 -> 217
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	278	0	paramContext	Context
    //   208	2	1	i	int
    //   48	2	2	bool	boolean
    //   39	203	3	localObject1	Object
    //   270	1	3	localThrowable1	Throwable
    //   21	52	4	localObject2	Object
    //   75	8	4	localObject3	Object
    //   160	69	4	localArrayList	ArrayList
    //   257	7	4	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   53	67	75	finally
    //   194	209	240	finally
    //   213	217	240	finally
    //   217	219	240	finally
    //   241	243	240	finally
    //   6	49	254	java/lang/Throwable
    //   82	85	254	java/lang/Throwable
    //   90	101	254	java/lang/Throwable
    //   101	114	254	java/lang/Throwable
    //   117	128	254	java/lang/Throwable
    //   128	139	254	java/lang/Throwable
    //   139	194	254	java/lang/Throwable
    //   219	238	254	java/lang/Throwable
    //   243	245	254	java/lang/Throwable
    //   245	250	254	java/lang/Throwable
    //   53	67	257	java/lang/Throwable
    //   67	72	262	java/lang/Throwable
    //   77	82	266	java/lang/Throwable
    //   85	90	270	java/lang/Throwable
    //   213	217	274	java/lang/Throwable
  }
  
  public static String getOaid(final Context paramContext)
  {
    final Object localObject = new Object();
    AtomicReference localAtomicReference = new AtomicReference("");
    new Thread()
    {
      public final void run()
      {
        this.v.set(OaidProxy.doGetOaid(paramContext));
        try
        {
          synchronized (localObject)
          {
            localObject.notifyAll();
          }
        }
        catch (Throwable localThrowable)
        {
          label35:
          break label35;
        }
        return;
        throw localObject2;
      }
    }.start();
    try
    {
      try
      {
        localObject.wait(1000L);
      }
      finally
      {
        break label57;
      }
    }
    catch (Throwable paramContext)
    {
      label47:
      break label47;
    }
    return (String)localAtomicReference.get();
    label57:
    throw paramContext;
  }
  
  static final class a
    implements ServiceConnection
  {
    boolean A = false;
    private final LinkedBlockingQueue<IBinder> B = new LinkedBlockingQueue(1);
    
    public final IBinder getBinder()
    {
      if (this.A) {
        return null;
      }
      this.A = true;
      try
      {
        IBinder localIBinder = (IBinder)this.B.take();
        return localIBinder;
      }
      catch (Throwable localThrowable) {}
      return null;
    }
    
    public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
    {
      try
      {
        this.B.put(paramIBinder);
        return;
      }
      catch (Throwable paramComponentName) {}
    }
    
    public final void onServiceDisconnected(ComponentName paramComponentName) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tmsdk.base.oaid.OaidProxy
 * JD-Core Version:    0.7.0.1
 */