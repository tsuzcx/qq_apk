package com.tencent.smtt.sdk;

import android.content.Context;
import android.util.Log;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.q;
import java.nio.channels.FileLock;

class y
{
  private static y a;
  private static FileLock e = null;
  private z b;
  private boolean c;
  private boolean d;
  
  public static y a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new y();
      }
      return a;
    }
    finally {}
  }
  
  public z a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return this.b;
    }
    return c();
  }
  
  /* Error */
  public FileLock a(Context paramContext)
  {
    // Byte code:
    //   0: ldc 34
    //   2: ldc 36
    //   4: invokestatic 42	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   7: getstatic 17	com/tencent/smtt/sdk/y:e	Ljava/nio/channels/FileLock;
    //   10: ifnull +7 -> 17
    //   13: getstatic 17	com/tencent/smtt/sdk/y:e	Ljava/nio/channels/FileLock;
    //   16: areturn
    //   17: ldc 2
    //   19: monitorenter
    //   20: getstatic 17	com/tencent/smtt/sdk/y:e	Ljava/nio/channels/FileLock;
    //   23: ifnonnull +23 -> 46
    //   26: aload_1
    //   27: invokestatic 46	com/tencent/smtt/utils/FileUtil:e	(Landroid/content/Context;)Ljava/nio/channels/FileLock;
    //   30: putstatic 17	com/tencent/smtt/sdk/y:e	Ljava/nio/channels/FileLock;
    //   33: getstatic 17	com/tencent/smtt/sdk/y:e	Ljava/nio/channels/FileLock;
    //   36: ifnonnull +17 -> 53
    //   39: ldc 34
    //   41: ldc 48
    //   43: invokestatic 42	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   46: ldc 2
    //   48: monitorexit
    //   49: getstatic 17	com/tencent/smtt/sdk/y:e	Ljava/nio/channels/FileLock;
    //   52: areturn
    //   53: ldc 34
    //   55: new 50	java/lang/StringBuilder
    //   58: dup
    //   59: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   62: ldc 53
    //   64: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: getstatic 17	com/tencent/smtt/sdk/y:e	Ljava/nio/channels/FileLock;
    //   70: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   73: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: invokestatic 42	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   79: goto -33 -> 46
    //   82: astore_1
    //   83: ldc 2
    //   85: monitorexit
    //   86: aload_1
    //   87: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	this	y
    //   0	88	1	paramContext	Context
    // Exception table:
    //   from	to	target	type
    //   20	46	82	finally
    //   46	49	82	finally
    //   53	79	82	finally
    //   83	86	82	finally
  }
  
  public void a(Context paramContext, p paramp)
  {
    Object localObject4 = null;
    for (;;)
    {
      g localg;
      StringBuilder localStringBuilder;
      w localw;
      int i;
      try
      {
        TbsLog.i("X5CoreEngine", "init", "#1# Start init");
        if (paramp != null) {
          paramp.a("x5_core_engine_init_sync", (byte)2);
        }
        localg = g.a(true);
        localg.a(paramContext, false, false, paramp);
        TbsLog.i("X5CoreEngine", "init", "#2# SDKEngine init finish");
        localStringBuilder = new StringBuilder();
        if (paramp != null) {
          paramp.a("init_x5_core", (byte)1);
        }
        localw = localg.a();
        if ((localg.b()) && (localw != null))
        {
          if (this.d) {
            break label929;
          }
          TbsLog.i("X5CoreEngine", "init", "#3-1# X5CoreWizard start to load dex and so");
          if (paramp != null) {
            paramp.a = true;
          }
          this.b = new z(localw.b());
          try
          {
            this.c = this.b.a();
            if (!this.c) {
              localStringBuilder.append("can not use X5 by x5corewizard return false");
            }
            localObject1 = null;
          }
          catch (NoSuchMethodException localNoSuchMethodException)
          {
            Object localObject1;
            boolean bool;
            this.c = true;
            Object localObject2 = null;
            continue;
          }
          catch (Throwable localThrowable1)
          {
            this.c = false;
            localStringBuilder.append("can not use x5 by x5corewizard throwable " + Log.getStackTraceString(localThrowable1));
            continue;
          }
          localObject3 = localObject1;
          if (this.c)
          {
            CookieManager.getInstance().a(paramContext, true, true);
            CookieManager.getInstance().a();
            localObject3 = localObject1;
          }
          TbsLog.i("X5CoreEngine", "init  mCanUseX5 is " + this.c);
          q.a("19is" + this.c);
          if (this.c) {
            break label844;
          }
          TbsLog.e("X5CoreEngine", "mCanUseX5 is false --> report");
          bool = localg.b();
          if ((!bool) || (localw == null) || (localObject3 != null)) {
            break label737;
          }
        }
      }
      finally {}
      try
      {
        localObject3 = localw.b();
        localObject1 = localObject4;
        if (localObject3 != null) {
          localObject1 = ((DexLoader)localObject3).invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "getLoadFailureDetails", new Class[0], new Object[0]);
        }
        if ((localObject1 instanceof Throwable))
        {
          localObject3 = (Throwable)localObject1;
          localStringBuilder.append("#" + ((Throwable)localObject3).getMessage() + "; cause: " + ((Throwable)localObject3).getCause() + "; th: " + localObject3);
        }
        if ((localObject1 instanceof String)) {
          localStringBuilder.append("failure detail: " + localObject1);
        }
      }
      catch (Throwable localThrowable2)
      {
        TbsLog.e("X5CoreEngine", "init", Log.getStackTraceString(localThrowable2));
        continue;
        TbsCoreLoadStat.getInstance().a(paramContext, 407, new Throwable("Failed in Core, details: " + localStringBuilder.toString()));
        TbsLog.e("X5CoreEngine", "init", "[LoadError] Failed in Core, details: " + localStringBuilder.toString());
        i = 2;
        continue;
      }
      if (localStringBuilder.toString().contains("isPreloadX5Disabled:-10000"))
      {
        TbsCoreLoadStat.getInstance().a(paramContext, 408, new Throwable("Core Crash, details: " + localStringBuilder.toString()));
        TbsLog.e("X5CoreEngine", "init", "[LoadError] Core Crash, details: " + localStringBuilder.toString());
        i = 1;
        if (localStringBuilder != null)
        {
          localObject1 = "step=is=" + i + "failreason=is=" + localStringBuilder.toString();
          if (TbsShareManager.isThirdPartyApp(paramContext)) {
            q.a(paramContext, "x5coreengine_fail", (String)localObject1);
          }
          this.d = true;
          if (paramp != null) {
            paramp.a("init_x5_core", (byte)2);
          }
          return;
          this.c = false;
          TbsLog.e("X5CoreEngine", "init", "SDKEngine tbs not available!");
          break label929;
        }
      }
      else
      {
        label737:
        if (localg.b())
        {
          TbsCoreLoadStat.getInstance().a(paramContext, 409, new Throwable("mCanUseX5=false, available true, reason: " + localStringBuilder.toString()));
          TbsLog.e("X5CoreEngine", "init", "[LoadError] details: " + localStringBuilder.toString());
          i = 3;
          continue;
        }
        TbsCoreLoadStat.getInstance().a(paramContext, 410);
        TbsLog.e("X5CoreEngine", "init", "[LoadError] mCanUseX5=false, available=false");
        i = 4;
        continue;
        label844:
        TbsLog.i("X5CoreEngine", "init", "#5# sTbsCoreLoadFileLock is " + e);
        if (e == null) {
          a(paramContext);
        }
        if (!TbsShareManager.isThirdPartyApp(paramContext)) {
          continue;
        }
        q.a(paramContext, "x5coreengine_ok", "" + QbSdk.getTbsVersion(paramContext));
        continue;
      }
      String str = "";
      continue;
      label929:
      Object localObject3 = null;
    }
  }
  
  public boolean b()
  {
    if (QbSdk.a) {
      return false;
    }
    return this.c;
  }
  
  public z c()
  {
    if (QbSdk.a) {
      return null;
    }
    return this.b;
  }
  
  boolean d()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.smtt.sdk.y
 * JD-Core Version:    0.7.0.1
 */