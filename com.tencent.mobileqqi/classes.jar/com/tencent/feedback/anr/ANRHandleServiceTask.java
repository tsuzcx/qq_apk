package com.tencent.feedback.anr;

import android.app.ActivityManager;
import android.app.ActivityManager.ProcessErrorStateInfo;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Process;
import android.util.Log;
import android.util.SparseArray;
import com.tencent.feedback.common.PlugInInfo;
import com.tencent.feedback.common.service.RQDServiceTask;
import com.tencent.feedback.eup.CrashStrategyBean;
import com.tencent.feedback.eup.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ANRHandleServiceTask
  implements Parcelable, RQDServiceTask
{
  public static final Parcelable.Creator<ANRHandleServiceTask> CREATOR = new Parcelable.Creator() {};
  protected static final long PROCESS_ERROR_STATE_WAITING_PERIOD = 500L;
  protected static final long PROCESS_ERROR_STATE_WAITING_TIMEOUT = 10000L;
  protected static final long PROCESS_KILL_WAITING_TIMEOUT = 10000L;
  protected static final String TRACE_FILE_DIR = "/data/anr/";
  protected static final String TRACE_FILE_PATH = "/data/anr/traces.txt";
  public static AtomicBoolean isHandling = new AtomicBoolean(false);
  public static e lastHandledANRFirstDump = null;
  private final boolean isUseMerge;
  private final Map<String, PlugInInfo> pluginList;
  private final long serverTimeGap;
  private final String userId;
  
  public ANRHandleServiceTask(Parcel paramParcel)
  {
    if (paramParcel.readInt() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.isUseMerge = bool;
      this.userId = paramParcel.readString();
      this.serverTimeGap = paramParcel.readLong();
      int j = paramParcel.readInt();
      if (j <= 0) {
        break;
      }
      this.pluginList = new HashMap();
      while (i < j)
      {
        PlugInInfo localPlugInInfo = new PlugInInfo(paramParcel);
        this.pluginList.put(localPlugInInfo.plugInId, localPlugInInfo);
        i += 1;
      }
    }
    this.pluginList = null;
  }
  
  public ANRHandleServiceTask(boolean paramBoolean, String paramString, long paramLong, Map<String, PlugInInfo> paramMap)
  {
    this.isUseMerge = paramBoolean;
    this.userId = paramString;
    this.serverTimeGap = paramLong;
    this.pluginList = paramMap;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Map<String, PlugInInfo> getPluginList()
  {
    return this.pluginList;
  }
  
  public SparseArray<String> getRunningProcessSameUid()
  {
    return com.tencent.feedback.common.a.a(Process.myUid());
  }
  
  public long getServerTimeGap()
  {
    return this.serverTimeGap;
  }
  
  public int getTaskId()
  {
    return 1000;
  }
  
  public String getTaskName()
  {
    return "2000";
  }
  
  public String getUploadThreadsDump(Map<String, String[]> paramMap)
  {
    if ((paramMap != null) && (paramMap.size() > 0))
    {
      HashMap localHashMap1 = new HashMap();
      HashMap localHashMap2 = new HashMap();
      Object localObject1 = Pattern.compile("held by tid=\\d+");
      Iterator localIterator = paramMap.entrySet().iterator();
      Object localObject2;
      Object localObject3;
      while (localIterator.hasNext())
      {
        localObject2 = (Map.Entry)localIterator.next();
        localHashMap1.put(((String[])localObject2.getValue())[2], ((Map.Entry)localObject2).getKey());
        localObject3 = ((Pattern)localObject1).matcher(((String[])localObject2.getValue())[1]);
        if (((Matcher)localObject3).find())
        {
          localHashMap2.put(((String[])localObject2.getValue())[2], null);
          localObject2 = ((Matcher)localObject3).group();
          localHashMap2.put(((String)localObject2).substring(((String)localObject2).indexOf("=") + 1), null);
        }
        else if ("main".equals(((Map.Entry)localObject2).getKey()))
        {
          localHashMap2.put(((String[])localObject2.getValue())[2], null);
        }
      }
      localObject1 = new StringBuffer();
      localIterator = localHashMap2.keySet().iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (String)localIterator.next();
        localHashMap2.put(localObject2, localHashMap1.get(localObject2));
        localObject3 = (String)localHashMap1.get(localObject2);
        String str1 = ((String[])paramMap.get(localObject3))[0];
        String str2 = ((String[])paramMap.get(localObject3))[1];
        ((StringBuffer)localObject1).append("\"" + (String)localObject3 + "\" tid=" + (String)localObject2 + " :\n" + str1 + "\n" + str2 + "\n");
      }
      return ((StringBuffer)localObject1).toString();
    }
    return null;
  }
  
  public String getUserId()
  {
    return this.userId;
  }
  
  public void handleANRInfo(Context paramContext, int paramInt, String paramString1, String paramString2, long paramLong)
  {
    if ((paramContext == null) || (paramInt <= 0) || (paramString1 == null)) {
      return;
    }
    a locala = new a();
    locala.a(paramString1);
    locala.a(paramLong);
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "unvisiable ANR";
    }
    locala.b(paramString1);
    handleANRInfo(paramContext, locala);
  }
  
  public void handleANRInfo(Context paramContext, a parama)
  {
    if ((paramContext == null) || (parama == null)) {
      return;
    }
    Object localObject1;
    if ((parama.a() == null) || ("/data/anr/traces.txt" == null)) {
      localObject1 = null;
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        localObject2 = getUploadThreadsDump(((e)localObject1).d);
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "dump traces fail!";
        }
        parama.c((String)localObject1);
      }
      recordANR(paramContext, parama);
      return;
      Object localObject2 = new e();
      a.a("/data/anr/traces.txt", new c((e)localObject2, true));
      if ((((e)localObject2).a > 0L) && (((e)localObject2).c > 0L))
      {
        localObject1 = localObject2;
        if (((e)localObject2).b != null) {}
      }
      else
      {
        localObject1 = null;
      }
    }
  }
  
  public boolean isUseMerge()
  {
    return this.isUseMerge;
  }
  
  public e readTraceDumpInfo()
  {
    if ("/data/anr/traces.txt" == null)
    {
      Log.e("path:%s", "/data/anr/traces.txt");
      return null;
    }
    e locale = new e();
    a.a("/data/anr/traces.txt", new d(locale, false));
    if ((locale.a > 0L) && (locale.c > 0L) && (locale.b != null)) {
      return locale;
    }
    Log.e("first dump error", locale.a + " " + locale.c + " " + locale.b);
    return null;
  }
  
  public void recordANR(Context paramContext, a parama)
  {
    CrashStrategyBean localCrashStrategyBean = new CrashStrategyBean();
    localCrashStrategyBean.setMerged(this.isUseMerge);
    parama = b.a(paramContext, this.userId, this.serverTimeGap, this.pluginList, parama.a(), "main", "", "ANR_RQD_EXCEPTION", "", parama.e(), parama.b(), parama.d(), null);
    parama.e(true);
    boolean bool = b.a(paramContext).a(parama, localCrashStrategyBean);
    com.tencent.feedback.common.e.b("sha1:%s %d", new Object[] { parama.t(), Integer.valueOf(parama.r()) });
    com.tencent.feedback.common.e.b("handle anr %b", new Object[] { Boolean.valueOf(bool) });
  }
  
  /* Error */
  public void runInService(com.tencent.feedback.common.service.RQDService paramRQDService, android.content.Intent paramIntent)
  {
    // Byte code:
    //   0: invokestatic 371	com/tencent/feedback/eup/CrashReport:getCrashRuntimeStrategy	()Lcom/tencent/feedback/eup/CrashStrategyBean;
    //   3: ifnonnull +21 -> 24
    //   6: ldc_w 373
    //   9: iconst_0
    //   10: anewarray 4	java/lang/Object
    //   13: invokestatic 352	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   16: aload_1
    //   17: invokevirtual 379	com/tencent/feedback/common/service/RQDService:getApplicationContext	()Landroid/content/Context;
    //   20: iconst_0
    //   21: invokestatic 383	com/tencent/feedback/eup/CrashReport:initCrashReport	(Landroid/content/Context;Z)V
    //   24: getstatic 49	com/tencent/feedback/anr/ANRHandleServiceTask:isHandling	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   27: invokevirtual 385	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   30: ifeq +14 -> 44
    //   33: ldc_w 387
    //   36: iconst_0
    //   37: anewarray 4	java/lang/Object
    //   40: invokestatic 352	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   43: return
    //   44: getstatic 49	com/tencent/feedback/anr/ANRHandleServiceTask:isHandling	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   47: iconst_1
    //   48: invokevirtual 390	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   51: aload_0
    //   52: invokevirtual 392	com/tencent/feedback/anr/ANRHandleServiceTask:getRunningProcessSameUid	()Landroid/util/SparseArray;
    //   55: astore_2
    //   56: aload_2
    //   57: ifnull +10 -> 67
    //   60: aload_2
    //   61: invokevirtual 395	android/util/SparseArray:size	()I
    //   64: ifgt +21 -> 85
    //   67: ldc_w 397
    //   70: iconst_0
    //   71: anewarray 4	java/lang/Object
    //   74: invokestatic 399	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   77: getstatic 49	com/tencent/feedback/anr/ANRHandleServiceTask:isHandling	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   80: iconst_0
    //   81: invokevirtual 390	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   84: return
    //   85: aload_0
    //   86: invokevirtual 401	com/tencent/feedback/anr/ANRHandleServiceTask:readTraceDumpInfo	()Lcom/tencent/feedback/anr/e;
    //   89: astore 7
    //   91: aload 7
    //   93: ifnonnull +21 -> 114
    //   96: ldc_w 403
    //   99: iconst_0
    //   100: anewarray 4	java/lang/Object
    //   103: invokestatic 399	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   106: getstatic 49	com/tencent/feedback/anr/ANRHandleServiceTask:isHandling	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   109: iconst_0
    //   110: invokevirtual 390	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   113: return
    //   114: getstatic 51	com/tencent/feedback/anr/ANRHandleServiceTask:lastHandledANRFirstDump	Lcom/tencent/feedback/anr/e;
    //   117: ifnull +89 -> 206
    //   120: getstatic 51	com/tencent/feedback/anr/ANRHandleServiceTask:lastHandledANRFirstDump	Lcom/tencent/feedback/anr/e;
    //   123: getfield 277	com/tencent/feedback/anr/e:a	J
    //   126: aload 7
    //   128: getfield 277	com/tencent/feedback/anr/e:a	J
    //   131: lcmp
    //   132: ifne +74 -> 206
    //   135: getstatic 51	com/tencent/feedback/anr/ANRHandleServiceTask:lastHandledANRFirstDump	Lcom/tencent/feedback/anr/e;
    //   138: getfield 281	com/tencent/feedback/anr/e:b	Ljava/lang/String;
    //   141: aload 7
    //   143: getfield 281	com/tencent/feedback/anr/e:b	Ljava/lang/String;
    //   146: invokevirtual 195	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   149: ifeq +57 -> 206
    //   152: getstatic 51	com/tencent/feedback/anr/ANRHandleServiceTask:lastHandledANRFirstDump	Lcom/tencent/feedback/anr/e;
    //   155: getfield 279	com/tencent/feedback/anr/e:c	J
    //   158: aload 7
    //   160: getfield 279	com/tencent/feedback/anr/e:c	J
    //   163: lcmp
    //   164: ifne +42 -> 206
    //   167: ldc_w 405
    //   170: iconst_2
    //   171: anewarray 4	java/lang/Object
    //   174: dup
    //   175: iconst_0
    //   176: getstatic 51	com/tencent/feedback/anr/ANRHandleServiceTask:lastHandledANRFirstDump	Lcom/tencent/feedback/anr/e;
    //   179: getfield 281	com/tencent/feedback/anr/e:b	Ljava/lang/String;
    //   182: aastore
    //   183: dup
    //   184: iconst_1
    //   185: getstatic 51	com/tencent/feedback/anr/ANRHandleServiceTask:lastHandledANRFirstDump	Lcom/tencent/feedback/anr/e;
    //   188: getfield 279	com/tencent/feedback/anr/e:c	J
    //   191: invokestatic 410	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   194: aastore
    //   195: invokestatic 352	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   198: getstatic 49	com/tencent/feedback/anr/ANRHandleServiceTask:isHandling	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   201: iconst_0
    //   202: invokevirtual 390	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   205: return
    //   206: aload 7
    //   208: putstatic 51	com/tencent/feedback/anr/ANRHandleServiceTask:lastHandledANRFirstDump	Lcom/tencent/feedback/anr/e;
    //   211: aload 7
    //   213: getfield 279	com/tencent/feedback/anr/e:c	J
    //   216: lstore 5
    //   218: aload_0
    //   219: aload_1
    //   220: invokevirtual 414	com/tencent/feedback/anr/ANRHandleServiceTask:waitForANRProcessErrorSate	(Landroid/content/Context;)Ljava/util/List;
    //   223: astore 7
    //   225: aload 7
    //   227: ifnull +112 -> 339
    //   230: aload 7
    //   232: invokeinterface 417 1 0
    //   237: ifle +102 -> 339
    //   240: invokestatic 110	android/os/Process:myUid	()I
    //   243: istore_3
    //   244: aload 7
    //   246: invokeinterface 418 1 0
    //   251: astore_2
    //   252: aload_2
    //   253: invokeinterface 151 1 0
    //   258: ifeq +63 -> 321
    //   261: aload_2
    //   262: invokeinterface 155 1 0
    //   267: checkcast 235	com/tencent/feedback/anr/a
    //   270: astore 7
    //   272: iload_3
    //   273: aload 7
    //   275: invokevirtual 420	com/tencent/feedback/anr/a:c	()I
    //   278: if_icmpne -26 -> 252
    //   281: ldc_w 422
    //   284: iconst_1
    //   285: anewarray 4	java/lang/Object
    //   288: dup
    //   289: iconst_0
    //   290: aload 7
    //   292: invokevirtual 251	com/tencent/feedback/anr/a:a	()Ljava/lang/String;
    //   295: aastore
    //   296: invokestatic 352	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   299: aload 7
    //   301: lload 5
    //   303: invokevirtual 241	com/tencent/feedback/anr/a:a	(J)V
    //   306: aload_0
    //   307: aload_1
    //   308: aload 7
    //   310: invokevirtual 249	com/tencent/feedback/anr/ANRHandleServiceTask:handleANRInfo	(Landroid/content/Context;Lcom/tencent/feedback/anr/a;)V
    //   313: getstatic 49	com/tencent/feedback/anr/ANRHandleServiceTask:isHandling	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   316: iconst_0
    //   317: invokevirtual 390	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   320: return
    //   321: ldc_w 424
    //   324: iconst_0
    //   325: anewarray 4	java/lang/Object
    //   328: invokestatic 352	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   331: getstatic 49	com/tencent/feedback/anr/ANRHandleServiceTask:isHandling	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   334: iconst_0
    //   335: invokevirtual 390	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   338: return
    //   339: ldc2_w 16
    //   342: invokestatic 429	java/lang/Thread:sleep	(J)V
    //   345: aload_0
    //   346: invokevirtual 392	com/tencent/feedback/anr/ANRHandleServiceTask:getRunningProcessSameUid	()Landroid/util/SparseArray;
    //   349: astore 7
    //   351: aload 7
    //   353: ifnull +11 -> 364
    //   356: aload 7
    //   358: invokevirtual 395	android/util/SparseArray:size	()I
    //   361: ifgt +64 -> 425
    //   364: ldc_w 397
    //   367: iconst_0
    //   368: anewarray 4	java/lang/Object
    //   371: invokestatic 399	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   374: getstatic 49	com/tencent/feedback/anr/ANRHandleServiceTask:isHandling	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   377: iconst_0
    //   378: invokevirtual 390	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   381: return
    //   382: astore 7
    //   384: aload 7
    //   386: invokevirtual 432	java/lang/InterruptedException:printStackTrace	()V
    //   389: goto -44 -> 345
    //   392: astore_1
    //   393: ldc_w 434
    //   396: iconst_0
    //   397: anewarray 4	java/lang/Object
    //   400: invokestatic 399	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   403: invokestatic 438	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   406: aload_1
    //   407: aconst_null
    //   408: aconst_null
    //   409: invokestatic 442	com/tencent/feedback/eup/CrashReport:handleCatchException	(Ljava/lang/Thread;Ljava/lang/Throwable;Ljava/lang/String;[B)Z
    //   412: pop
    //   413: aload_1
    //   414: invokevirtual 443	java/lang/Throwable:printStackTrace	()V
    //   417: getstatic 49	com/tencent/feedback/anr/ANRHandleServiceTask:isHandling	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   420: iconst_0
    //   421: invokevirtual 390	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   424: return
    //   425: iconst_0
    //   426: istore_3
    //   427: iload_3
    //   428: aload_2
    //   429: invokevirtual 395	android/util/SparseArray:size	()I
    //   432: if_icmpge +78 -> 510
    //   435: aload_2
    //   436: iload_3
    //   437: invokevirtual 447	android/util/SparseArray:keyAt	(I)I
    //   440: istore 4
    //   442: aload 7
    //   444: iload 4
    //   446: invokevirtual 450	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   449: ifnonnull +54 -> 503
    //   452: aload_2
    //   453: iload 4
    //   455: invokevirtual 450	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   458: checkcast 181	java/lang/String
    //   461: astore_2
    //   462: ldc_w 452
    //   465: iconst_2
    //   466: anewarray 4	java/lang/Object
    //   469: dup
    //   470: iconst_0
    //   471: iload 4
    //   473: invokestatic 347	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   476: aastore
    //   477: dup
    //   478: iconst_1
    //   479: aload_2
    //   480: aastore
    //   481: invokestatic 352	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   484: aload_0
    //   485: aload_1
    //   486: iload 4
    //   488: aload_2
    //   489: aconst_null
    //   490: lload 5
    //   492: invokevirtual 454	com/tencent/feedback/anr/ANRHandleServiceTask:handleANRInfo	(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;J)V
    //   495: getstatic 49	com/tencent/feedback/anr/ANRHandleServiceTask:isHandling	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   498: iconst_0
    //   499: invokevirtual 390	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   502: return
    //   503: iload_3
    //   504: iconst_1
    //   505: iadd
    //   506: istore_3
    //   507: goto -80 -> 427
    //   510: getstatic 49	com/tencent/feedback/anr/ANRHandleServiceTask:isHandling	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   513: iconst_0
    //   514: invokevirtual 390	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   517: return
    //   518: astore_1
    //   519: getstatic 49	com/tencent/feedback/anr/ANRHandleServiceTask:isHandling	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   522: iconst_0
    //   523: invokevirtual 390	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   526: aload_1
    //   527: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	528	0	this	ANRHandleServiceTask
    //   0	528	1	paramRQDService	com.tencent.feedback.common.service.RQDService
    //   0	528	2	paramIntent	android.content.Intent
    //   243	264	3	i	int
    //   440	47	4	j	int
    //   216	275	5	l	long
    //   89	268	7	localObject	Object
    //   382	61	7	localInterruptedException	InterruptedException
    // Exception table:
    //   from	to	target	type
    //   339	345	382	java/lang/InterruptedException
    //   51	56	392	java/lang/Throwable
    //   60	67	392	java/lang/Throwable
    //   67	77	392	java/lang/Throwable
    //   85	91	392	java/lang/Throwable
    //   96	106	392	java/lang/Throwable
    //   114	198	392	java/lang/Throwable
    //   206	225	392	java/lang/Throwable
    //   230	252	392	java/lang/Throwable
    //   252	313	392	java/lang/Throwable
    //   321	331	392	java/lang/Throwable
    //   339	345	392	java/lang/Throwable
    //   345	351	392	java/lang/Throwable
    //   356	364	392	java/lang/Throwable
    //   364	374	392	java/lang/Throwable
    //   384	389	392	java/lang/Throwable
    //   427	495	392	java/lang/Throwable
    //   51	56	518	finally
    //   60	67	518	finally
    //   67	77	518	finally
    //   85	91	518	finally
    //   96	106	518	finally
    //   114	198	518	finally
    //   206	225	518	finally
    //   230	252	518	finally
    //   252	313	518	finally
    //   321	331	518	finally
    //   339	345	518	finally
    //   345	351	518	finally
    //   356	364	518	finally
    //   364	374	518	finally
    //   384	389	518	finally
    //   393	417	518	finally
    //   427	495	518	finally
  }
  
  public List<a> waitForANRProcessErrorSate(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    ActivityManager localActivityManager = (ActivityManager)paramContext.getSystemService("activity");
    int i = 0;
    for (;;)
    {
      int j = i + 1;
      if (i >= 20L) {
        break;
      }
      paramContext = localActivityManager.getProcessesInErrorState();
      if (paramContext != null)
      {
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = paramContext.iterator();
        while (localIterator.hasNext())
        {
          ActivityManager.ProcessErrorStateInfo localProcessErrorStateInfo = (ActivityManager.ProcessErrorStateInfo)localIterator.next();
          if (localProcessErrorStateInfo.condition == 2)
          {
            com.tencent.feedback.common.e.b("anr error found in %s \n lMsg:%s\n sMsg:%s", new Object[] { localProcessErrorStateInfo.processName, localProcessErrorStateInfo.longMsg, localProcessErrorStateInfo.shortMsg });
            if ((localProcessErrorStateInfo == null) || (localProcessErrorStateInfo.condition != 2)) {
              paramContext = null;
            }
            for (;;)
            {
              localArrayList.add(paramContext);
              break;
              paramContext = new a();
              paramContext.a(localProcessErrorStateInfo.processName);
              i = localProcessErrorStateInfo.pid;
              paramContext.b(localProcessErrorStateInfo.longMsg);
              paramContext.a(localProcessErrorStateInfo.uid);
            }
          }
        }
        if (localArrayList.size() > 0) {
          return localArrayList;
        }
      }
      try
      {
        Thread.sleep(500L);
        i = j;
      }
      catch (InterruptedException paramContext)
      {
        paramContext.printStackTrace();
        i = j;
      }
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (this.isUseMerge) {}
    for (paramInt = 1;; paramInt = -1)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.userId);
      paramParcel.writeLong(this.serverTimeGap);
      if ((this.pluginList == null) || (this.pluginList.size() <= 0)) {
        break;
      }
      paramParcel.writeInt(this.pluginList.size());
      Iterator localIterator = this.pluginList.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        paramParcel.writeParcelable((Parcelable)this.pluginList.get(str), 0);
      }
    }
    paramParcel.writeInt(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.feedback.anr.ANRHandleServiceTask
 * JD-Core Version:    0.7.0.1
 */