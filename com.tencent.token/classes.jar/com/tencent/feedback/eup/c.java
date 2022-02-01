package com.tencent.feedback.eup;

import android.content.Context;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class c
  implements Thread.UncaughtExceptionHandler
{
  private static c c = null;
  private Thread.UncaughtExceptionHandler a = null;
  private Context b = null;
  
  private c(Context paramContext)
  {
    if (paramContext == null) {}
    for (;;)
    {
      this.b = paramContext;
      return;
      Context localContext = paramContext.getApplicationContext();
      if (localContext != null) {
        paramContext = localContext;
      }
    }
  }
  
  private int a(List<e> paramList, int paramInt, boolean paramBoolean)
  {
    Context localContext = this.b;
    if ((paramList == null) || (paramInt <= 0)) {
      return 0;
    }
    ArrayList localArrayList = new ArrayList();
    Collections.sort(paramList, new b.2());
    paramList = paramList.iterator();
    while ((paramList.hasNext()) && (paramInt > localArrayList.size()))
    {
      e locale = (e)paramList.next();
      if ((locale.b()) && (!paramBoolean)) {
        break;
      }
      localArrayList.add(locale);
      paramList.remove();
    }
    if (localArrayList.size() > 0) {
      return b.a(localContext, localArrayList);
    }
    return 0;
  }
  
  public static c a(Context paramContext)
  {
    try
    {
      if ((c == null) && (paramContext != null)) {
        c = new c(paramContext);
      }
      paramContext = c;
      return paramContext;
    }
    finally {}
  }
  
  /* Error */
  private void a(Thread paramThread, Throwable paramThrowable)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 23	com/tencent/feedback/eup/c:a	Ljava/lang/Thread$UncaughtExceptionHandler;
    //   6: ifnull +27 -> 33
    //   9: ldc 88
    //   11: iconst_0
    //   12: anewarray 4	java/lang/Object
    //   15: invokestatic 93	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   18: pop
    //   19: aload_0
    //   20: getfield 23	com/tencent/feedback/eup/c:a	Ljava/lang/Thread$UncaughtExceptionHandler;
    //   23: aload_1
    //   24: aload_2
    //   25: invokeinterface 96 3 0
    //   30: aload_0
    //   31: monitorexit
    //   32: return
    //   33: ldc 98
    //   35: iconst_0
    //   36: anewarray 4	java/lang/Object
    //   39: invokestatic 93	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   42: pop
    //   43: invokestatic 103	android/os/Process:myPid	()I
    //   46: invokestatic 107	android/os/Process:killProcess	(I)V
    //   49: iconst_1
    //   50: invokestatic 112	java/lang/System:exit	(I)V
    //   53: goto -23 -> 30
    //   56: astore_1
    //   57: aload_0
    //   58: monitorexit
    //   59: aload_1
    //   60: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	61	0	this	c
    //   0	61	1	paramThread	Thread
    //   0	61	2	paramThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   2	30	56	finally
    //   33	53	56	finally
  }
  
  private static void c()
  {
    b.1 local1 = new b.1();
    local1.setName("ImmediateEUP");
    local1.start();
    try
    {
      local1.join(3000L);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      while (com.tencent.feedback.common.e.a(localInterruptedException)) {}
      localInterruptedException.printStackTrace();
    }
  }
  
  public final void a()
  {
    try
    {
      com.tencent.feedback.common.e.a("rqdp{ eup regist}", new Object[0]);
      Thread.UncaughtExceptionHandler localUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
      if (localUncaughtExceptionHandler != this)
      {
        this.a = localUncaughtExceptionHandler;
        Thread.setDefaultUncaughtExceptionHandler(this);
      }
      return;
    }
    finally {}
  }
  
  public final boolean a(e parame, CrashStrategyBean paramCrashStrategyBean)
  {
    if ((parame == null) && (paramCrashStrategyBean == null))
    {
      com.tencent.feedback.common.e.c("handler exception data params error", new Object[0]);
      return false;
    }
    Object localObject1;
    boolean bool;
    Object localObject3;
    if (paramCrashStrategyBean.isMerged())
    {
      localObject1 = this.b;
      if (parame == null) {
        localObject1 = null;
      }
      while (localObject1 != null)
      {
        com.tencent.feedback.common.e.a("merge success return", new Object[0]);
        if ((!((e)localObject1).w()) && (((e)localObject1).m() >= 2))
        {
          com.tencent.feedback.common.e.a("rqdp{ may be crash too frequent! do immediate upload in merge!}", new Object[0]);
          c();
        }
        return true;
        localObject2 = com.tencent.feedback.proguard.a.c((parame.P() + "\n" + parame.e() + "\n" + parame.h()).getBytes());
        if (localObject2 == null)
        {
          com.tencent.feedback.common.e.c("rqdp{  md5 error!}", new Object[0]);
          localObject1 = null;
        }
        else
        {
          parame.g((String)localObject2);
          parame.a(true);
          parame.b(1);
          parame.a(0);
          localObject2 = b.a((Context)localObject1, 1, "desc", -1, (String)localObject2, -1, -1, -1, -1, -1L, -1L, null);
          if ((localObject2 == null) || (((List)localObject2).size() <= 0))
          {
            com.tencent.feedback.common.e.b("rqdp{  new one ,no merged!}", new Object[0]);
            localObject1 = null;
          }
          else
          {
            localObject2 = (e)((List)localObject2).get(0);
            if ((((e)localObject2).l() != null) && (((e)localObject2).l().contains(parame.i())))
            {
              com.tencent.feedback.common.e.b("rqdp{ already merged} %d", new Object[] { Long.valueOf(parame.i()) });
              localObject1 = localObject2;
            }
            else
            {
              ((e)localObject2).b(((e)localObject2).m() + 1);
              if (((e)localObject2).l() == null) {
                ((e)localObject2).f("");
              }
              ((e)localObject2).f(((e)localObject2).l() + parame.i() + "\n");
              com.tencent.feedback.common.e.b("rqdp{  EUPDAO.insertOrUpdateEUP() start}", new Object[0]);
              if ((localObject1 == null) || (localObject2 == null)) {
                com.tencent.feedback.common.e.c("rqdp{  context == null || bean == null,pls check}", new Object[0]);
              }
              for (bool = false;; bool = b.b((Context)localObject1, (List)localObject3))
              {
                localObject1 = localObject2;
                if (!bool) {
                  break;
                }
                com.tencent.feedback.common.e.a("rqdp{  eupMeg update success} %b , c:%d , at:%s up:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(((e)localObject2).m()), ((e)localObject2).l(), Integer.valueOf(((e)localObject2).j()) });
                localObject1 = localObject2;
                if (parame.p() == null) {
                  break;
                }
                localObject3 = new File(parame.p());
                localObject1 = localObject2;
                if (!((File)localObject3).exists()) {
                  break;
                }
                localObject1 = localObject2;
                if (!((File)localObject3).isFile()) {
                  break;
                }
                ((File)localObject3).delete();
                localObject1 = localObject2;
                break;
                localObject3 = new ArrayList();
                ((List)localObject3).add(localObject2);
              }
            }
          }
        }
      }
    }
    int i = paramCrashStrategyBean.getMaxStoredNum();
    Object localObject2 = b.a(this.b, i + 1, "asc", -1, null, -1, -1, -1, -1, -1L, -1L, null);
    if ((localObject2 != null) && (((List)localObject2).size() > 0))
    {
      i = ((List)localObject2).size() - i + 1;
      if ((i > 0) && (a((List)localObject2, i, parame.b()) < i))
      {
        com.tencent.feedback.common.e.c("can't add more eup!", new Object[0]);
        return false;
      }
    }
    if ((localObject2 != null) && (((List)localObject2).size() > 1))
    {
      localObject1 = (e)((List)localObject2).get(0);
      localObject3 = ((List)localObject2).iterator();
      if (((Iterator)localObject3).hasNext())
      {
        localObject2 = (e)((Iterator)localObject3).next();
        if ((((e)localObject1).i() >= ((e)localObject2).i()) || (!((e)localObject2).b())) {
          break label890;
        }
        localObject1 = localObject2;
      }
    }
    label890:
    for (;;)
    {
      break;
      if ((((e)localObject1).b()) && (parame.i() - ((e)localObject1).i() < 60000L))
      {
        com.tencent.feedback.common.e.c("rqdp{ may be crash too frequent! do immediate upload in not merge!}", new Object[0]);
        c();
      }
      b.a(this.b, parame, paramCrashStrategyBean);
      if (com.tencent.feedback.common.a.e(this.b))
      {
        com.tencent.feedback.common.e.b("save log", new Object[0]);
        parame.a(com.tencent.feedback.proguard.a.a(paramCrashStrategyBean.getOnlyLogTag(), paramCrashStrategyBean.getMaxLogRow()));
      }
      for (;;)
      {
        bool = b.a(this.b, parame);
        com.tencent.feedback.common.e.a("store new eup pn:%s, isMe:%b , isNa:%b , res:%b ", new Object[] { parame.q(), Boolean.valueOf(parame.c()), Boolean.valueOf(parame.b()), Boolean.valueOf(bool) });
        return bool;
        parame.a(null);
      }
    }
  }
  
  /* Error */
  public final boolean a(String paramString1, Throwable paramThrowable, String paramString2, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 25	com/tencent/feedback/eup/c:b	Landroid/content/Context;
    //   4: invokestatic 354	com/tencent/feedback/common/c:a	(Landroid/content/Context;)Lcom/tencent/feedback/common/c;
    //   7: invokevirtual 357	com/tencent/feedback/common/c:E	()Ljava/lang/String;
    //   10: astore 16
    //   12: ldc_w 260
    //   15: astore 15
    //   17: ldc_w 260
    //   20: astore 11
    //   22: aload_2
    //   23: ifnull +463 -> 486
    //   26: aload_2
    //   27: invokevirtual 360	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   30: astore 12
    //   32: aload_2
    //   33: ifnull +461 -> 494
    //   36: aload_2
    //   37: invokevirtual 364	java/lang/Object:getClass	()Ljava/lang/Class;
    //   40: invokevirtual 369	java/lang/Class:getName	()Ljava/lang/String;
    //   43: astore 10
    //   45: invokestatic 374	com/tencent/feedback/eup/f:l	()Lcom/tencent/feedback/eup/f;
    //   48: astore 13
    //   50: aload 13
    //   52: ifnonnull +450 -> 502
    //   55: ldc_w 376
    //   58: iconst_0
    //   59: anewarray 4	java/lang/Object
    //   62: invokestatic 157	com/tencent/feedback/common/e:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   65: pop
    //   66: aconst_null
    //   67: astore 13
    //   69: new 378	java/util/Date
    //   72: dup
    //   73: invokespecial 379	java/util/Date:<init>	()V
    //   76: invokevirtual 382	java/util/Date:getTime	()J
    //   79: lstore 8
    //   81: aload_2
    //   82: invokestatic 388	com/tencent/feedback/eup/CrashReport:getCrashRuntimeStrategy	()Lcom/tencent/feedback/eup/CrashStrategyBean;
    //   85: invokestatic 391	com/tencent/feedback/eup/b:a	(Ljava/lang/Throwable;Lcom/tencent/feedback/eup/CrashStrategyBean;)Ljava/lang/String;
    //   88: astore 14
    //   90: aload 11
    //   92: astore 15
    //   94: aload 14
    //   96: ifnull +32 -> 128
    //   99: aload 11
    //   101: astore 15
    //   103: aload 14
    //   105: ldc 187
    //   107: invokevirtual 250	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   110: ifeq +18 -> 128
    //   113: aload 14
    //   115: iconst_0
    //   116: aload 14
    //   118: ldc 187
    //   120: invokevirtual 395	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   123: invokevirtual 399	java/lang/String:substring	(II)Ljava/lang/String;
    //   126: astore 15
    //   128: ldc_w 401
    //   131: iconst_1
    //   132: anewarray 4	java/lang/Object
    //   135: dup
    //   136: iconst_0
    //   137: aload 14
    //   139: aastore
    //   140: invokestatic 93	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   143: pop
    //   144: aload_3
    //   145: astore 11
    //   147: iload 5
    //   149: ifeq +474 -> 623
    //   152: aload_3
    //   153: astore 11
    //   155: aload 13
    //   157: ifnull +466 -> 623
    //   160: ldc_w 403
    //   163: iconst_0
    //   164: anewarray 4	java/lang/Object
    //   167: invokestatic 93	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   170: pop
    //   171: aload_3
    //   172: astore_2
    //   173: aload 13
    //   175: ifnull +34 -> 209
    //   178: ldc_w 405
    //   181: iconst_0
    //   182: anewarray 4	java/lang/Object
    //   185: invokestatic 144	com/tencent/feedback/common/e:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   188: pop
    //   189: aload 13
    //   191: iconst_0
    //   192: aload 10
    //   194: aload 15
    //   196: aload 14
    //   198: sipush -10000
    //   201: lload 8
    //   203: invokeinterface 411 8 0
    //   208: astore_2
    //   209: aload_2
    //   210: astore 11
    //   212: aload 13
    //   214: ifnull +409 -> 623
    //   217: ldc_w 413
    //   220: iconst_0
    //   221: anewarray 4	java/lang/Object
    //   224: invokestatic 144	com/tencent/feedback/common/e:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   227: pop
    //   228: aload 13
    //   230: iconst_0
    //   231: aload 10
    //   233: aload 15
    //   235: aload 14
    //   237: sipush -10000
    //   240: lload 8
    //   242: invokeinterface 417 8 0
    //   247: astore_3
    //   248: aload_0
    //   249: getfield 25	com/tencent/feedback/eup/c:b	Landroid/content/Context;
    //   252: invokestatic 354	com/tencent/feedback/common/c:a	(Landroid/content/Context;)Lcom/tencent/feedback/common/c;
    //   255: astore 4
    //   257: aload_0
    //   258: getfield 25	com/tencent/feedback/eup/c:b	Landroid/content/Context;
    //   261: aload 4
    //   263: invokevirtual 419	com/tencent/feedback/common/c:g	()Ljava/lang/String;
    //   266: aload 4
    //   268: invokevirtual 420	com/tencent/feedback/common/c:h	()Ljava/lang/String;
    //   271: aload 4
    //   273: invokevirtual 422	com/tencent/feedback/common/c:j	()J
    //   276: aload 4
    //   278: invokevirtual 426	com/tencent/feedback/common/c:y	()Ljava/util/Map;
    //   281: aload 16
    //   283: aload_1
    //   284: aload 15
    //   286: aload 10
    //   288: aload 12
    //   290: aload 14
    //   292: lload 8
    //   294: aload_2
    //   295: aload_3
    //   296: invokestatic 429	com/tencent/feedback/eup/b:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;JLjava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;[B)Lcom/tencent/feedback/eup/e;
    //   299: astore_2
    //   300: iload 5
    //   302: ifeq +330 -> 632
    //   305: iconst_0
    //   306: istore 6
    //   308: aload_2
    //   309: iload 6
    //   311: invokevirtual 432	com/tencent/feedback/eup/e:a	(B)V
    //   314: invokestatic 434	com/tencent/feedback/proguard/a:b	()Ljava/util/Map;
    //   317: astore_3
    //   318: aload_3
    //   319: ifnull +38 -> 357
    //   322: aload_2
    //   323: invokevirtual 437	com/tencent/feedback/eup/e:C	()Ljava/util/Map;
    //   326: aload_3
    //   327: invokeinterface 443 2 0
    //   332: aload_1
    //   333: ifnull +24 -> 357
    //   336: aload_1
    //   337: invokevirtual 446	java/lang/String:trim	()Ljava/lang/String;
    //   340: invokevirtual 449	java/lang/String:length	()I
    //   343: ifle +14 -> 357
    //   346: aload_2
    //   347: invokevirtual 437	com/tencent/feedback/eup/e:C	()Ljava/util/Map;
    //   350: aload_1
    //   351: invokeinterface 452 2 0
    //   356: pop
    //   357: iload 5
    //   359: ifeq +335 -> 694
    //   362: aload 13
    //   364: ifnull +330 -> 694
    //   367: ldc_w 454
    //   370: iconst_0
    //   371: anewarray 4	java/lang/Object
    //   374: invokestatic 144	com/tencent/feedback/common/e:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   377: pop
    //   378: aload 10
    //   380: astore_1
    //   381: aload 12
    //   383: ifnull +44 -> 427
    //   386: aload 10
    //   388: astore_1
    //   389: aload 12
    //   391: invokevirtual 446	java/lang/String:trim	()Ljava/lang/String;
    //   394: invokevirtual 449	java/lang/String:length	()I
    //   397: ifle +30 -> 427
    //   400: new 176	java/lang/StringBuilder
    //   403: dup
    //   404: invokespecial 177	java/lang/StringBuilder:<init>	()V
    //   407: aload 10
    //   409: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: ldc_w 456
    //   415: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   418: aload 12
    //   420: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   426: astore_1
    //   427: aload 13
    //   429: iconst_0
    //   430: aload_1
    //   431: aload 15
    //   433: aload 14
    //   435: sipush -10000
    //   438: lload 8
    //   440: aload_2
    //   441: invokevirtual 459	com/tencent/feedback/eup/e:k	()Ljava/lang/String;
    //   444: aload_2
    //   445: invokevirtual 462	com/tencent/feedback/eup/e:D	()Ljava/lang/String;
    //   448: aload_2
    //   449: invokevirtual 465	com/tencent/feedback/eup/e:v	()Ljava/lang/String;
    //   452: invokeinterface 469 11 0
    //   457: istore 7
    //   459: iload 5
    //   461: ifeq +11 -> 472
    //   464: aload_0
    //   465: getfield 25	com/tencent/feedback/eup/c:b	Landroid/content/Context;
    //   468: aload_2
    //   469: invokestatic 475	com/tencent/feedback/eup/BuglyBroadcastRecevier:brocastCrash	(Landroid/content/Context;Lcom/tencent/feedback/eup/e;)V
    //   472: iload 7
    //   474: ifeq +226 -> 700
    //   477: aload_0
    //   478: aload_2
    //   479: invokestatic 388	com/tencent/feedback/eup/CrashReport:getCrashRuntimeStrategy	()Lcom/tencent/feedback/eup/CrashStrategyBean;
    //   482: invokevirtual 477	com/tencent/feedback/eup/c:a	(Lcom/tencent/feedback/eup/e;Lcom/tencent/feedback/eup/CrashStrategyBean;)Z
    //   485: ireturn
    //   486: ldc_w 260
    //   489: astore 12
    //   491: goto -459 -> 32
    //   494: ldc_w 260
    //   497: astore 10
    //   499: goto -454 -> 45
    //   502: aload 13
    //   504: invokevirtual 481	com/tencent/feedback/eup/f:r	()Lcom/tencent/feedback/eup/CrashHandleListener;
    //   507: astore 13
    //   509: goto -440 -> 69
    //   512: astore_2
    //   513: ldc_w 483
    //   516: iconst_0
    //   517: anewarray 4	java/lang/Object
    //   520: invokestatic 486	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   523: pop
    //   524: aload 15
    //   526: astore 14
    //   528: aload_2
    //   529: invokestatic 137	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   532: ifne -442 -> 90
    //   535: aload_2
    //   536: invokevirtual 487	java/lang/Throwable:printStackTrace	()V
    //   539: aload 15
    //   541: astore 14
    //   543: goto -453 -> 90
    //   546: astore 11
    //   548: ldc_w 489
    //   551: iconst_1
    //   552: anewarray 4	java/lang/Object
    //   555: dup
    //   556: iconst_0
    //   557: aload 11
    //   559: invokevirtual 490	java/lang/Throwable:toString	()Ljava/lang/String;
    //   562: aastore
    //   563: invokestatic 486	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   566: pop
    //   567: aload_3
    //   568: astore_2
    //   569: aload 11
    //   571: invokestatic 137	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   574: ifne -365 -> 209
    //   577: aload 11
    //   579: invokevirtual 487	java/lang/Throwable:printStackTrace	()V
    //   582: aload_3
    //   583: astore_2
    //   584: goto -375 -> 209
    //   587: astore_3
    //   588: ldc_w 489
    //   591: iconst_1
    //   592: anewarray 4	java/lang/Object
    //   595: dup
    //   596: iconst_0
    //   597: aload_3
    //   598: invokevirtual 490	java/lang/Throwable:toString	()Ljava/lang/String;
    //   601: aastore
    //   602: invokestatic 486	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   605: pop
    //   606: aload_2
    //   607: astore 11
    //   609: aload_3
    //   610: invokestatic 137	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   613: ifne +10 -> 623
    //   616: aload_3
    //   617: invokevirtual 487	java/lang/Throwable:printStackTrace	()V
    //   620: aload_2
    //   621: astore 11
    //   623: aload 4
    //   625: astore_3
    //   626: aload 11
    //   628: astore_2
    //   629: goto -381 -> 248
    //   632: iconst_1
    //   633: istore 6
    //   635: goto -327 -> 308
    //   638: astore_1
    //   639: ldc_w 492
    //   642: iconst_0
    //   643: anewarray 4	java/lang/Object
    //   646: invokestatic 486	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   649: pop
    //   650: aload_1
    //   651: invokestatic 137	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   654: ifne -297 -> 357
    //   657: aload_1
    //   658: invokevirtual 487	java/lang/Throwable:printStackTrace	()V
    //   661: goto -304 -> 357
    //   664: astore_1
    //   665: ldc_w 489
    //   668: iconst_1
    //   669: anewarray 4	java/lang/Object
    //   672: dup
    //   673: iconst_0
    //   674: aload_1
    //   675: invokevirtual 490	java/lang/Throwable:toString	()Ljava/lang/String;
    //   678: aastore
    //   679: invokestatic 486	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   682: pop
    //   683: aload_1
    //   684: invokestatic 137	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   687: ifne +7 -> 694
    //   690: aload_1
    //   691: invokevirtual 487	java/lang/Throwable:printStackTrace	()V
    //   694: iconst_1
    //   695: istore 7
    //   697: goto -238 -> 459
    //   700: ldc_w 494
    //   703: iconst_0
    //   704: anewarray 4	java/lang/Object
    //   707: invokestatic 157	com/tencent/feedback/common/e:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   710: pop
    //   711: iconst_0
    //   712: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	713	0	this	c
    //   0	713	1	paramString1	String
    //   0	713	2	paramThrowable	Throwable
    //   0	713	3	paramString2	String
    //   0	713	4	paramArrayOfByte	byte[]
    //   0	713	5	paramBoolean	boolean
    //   306	328	6	b1	byte
    //   457	239	7	bool	boolean
    //   79	360	8	l	long
    //   43	455	10	str1	String
    //   20	191	11	localObject1	Object
    //   546	32	11	localThrowable1	Throwable
    //   607	20	11	localThrowable2	Throwable
    //   30	460	12	str2	String
    //   48	460	13	localObject2	Object
    //   88	454	14	localObject3	Object
    //   15	525	15	localObject4	Object
    //   10	272	16	str3	String
    // Exception table:
    //   from	to	target	type
    //   81	90	512	java/lang/Throwable
    //   178	209	546	java/lang/Throwable
    //   217	248	587	java/lang/Throwable
    //   314	318	638	java/lang/Throwable
    //   322	332	638	java/lang/Throwable
    //   336	357	638	java/lang/Throwable
    //   367	378	664	java/lang/Throwable
    //   389	427	664	java/lang/Throwable
    //   427	459	664	java/lang/Throwable
  }
  
  public final void b()
  {
    try
    {
      com.tencent.feedback.common.e.a("rqdp{ eup unregister}", new Object[0]);
      if (Thread.getDefaultUncaughtExceptionHandler() == this)
      {
        Thread.setDefaultUncaughtExceptionHandler(this.a);
        this.a = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    if (paramThrowable != null) {}
    for (;;)
    {
      try
      {
        if (!com.tencent.feedback.common.e.a(paramThrowable)) {
          paramThrowable.printStackTrace();
        }
        Object localObject = f.l();
        if (localObject == null)
        {
          com.tencent.feedback.common.e.c("rqdp{  instance == null}", new Object[0]);
          localObject = null;
          if (localObject == null) {}
        }
        try
        {
          com.tencent.feedback.common.e.a("your crhandler start", new Object[0]);
          ((CrashHandleListener)localObject).onCrashHandleStart(false);
          if (paramThread == null)
          {
            String str1 = "";
            com.tencent.feedback.common.e.b("rqdp{ handle eup result} %b", new Object[] { Boolean.valueOf(a(str1, paramThrowable, null, null, true)) });
            if (localObject == null) {
              break label234;
            }
          }
          try
          {
            com.tencent.feedback.common.e.a("your crhandler end", new Object[0]);
            bool = ((CrashHandleListener)localObject).onCrashHandleEnd(false);
            if (bool) {
              a(paramThread, paramThrowable);
            }
            return;
          }
          catch (Throwable localThrowable1)
          {
            String str2;
            com.tencent.feedback.common.e.d("rqdp{ your crash handle end error} %s", new Object[] { localThrowable1.toString() });
            if (com.tencent.feedback.common.e.a(localThrowable1)) {
              break label234;
            }
            localThrowable1.printStackTrace();
          }
          localObject = ((f)localObject).r();
        }
        catch (Throwable localThrowable2)
        {
          com.tencent.feedback.common.e.d("rqdp{ handle start error} %s", new Object[] { localThrowable2.toString() });
          if (com.tencent.feedback.common.e.a(localThrowable2)) {
            continue;
          }
          localThrowable2.printStackTrace();
          continue;
        }
        str2 = paramThread.getName();
      }
      finally {}
      continue;
      label234:
      boolean bool = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.feedback.eup.c
 * JD-Core Version:    0.7.0.1
 */