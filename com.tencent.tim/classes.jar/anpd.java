import android.os.Build;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.feedback.eup.CrashHandleListener;
import com.tencent.mobileqq.util.WebpSoLoader;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;
import mqq.os.MqqMessage;
import mqq.os.MqqMessageQueue;

class anpd
  implements CrashHandleListener
{
  anpd(anpc paramanpc) {}
  
  private String b(Message paramMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    if (paramMessage.getTarget() != null) {
      if (paramMessage.getCallback() != null)
      {
        localStringBuilder.append(" callback=");
        localStringBuilder.append(paramMessage.getCallback().getClass().getName());
        if (paramMessage.arg1 != 0)
        {
          localStringBuilder.append(" arg1=");
          localStringBuilder.append(paramMessage.arg1);
        }
        if (paramMessage.arg2 != 0)
        {
          localStringBuilder.append(" arg2=");
          localStringBuilder.append(paramMessage.arg2);
        }
        if (paramMessage.obj != null)
        {
          localStringBuilder.append(" obj=");
          localStringBuilder.append(paramMessage.obj);
        }
        localStringBuilder.append(" target=");
        localStringBuilder.append(paramMessage.getTarget().getClass().getName());
      }
    }
    for (;;)
    {
      return localStringBuilder.toString();
      localStringBuilder.append(" what=");
      localStringBuilder.append(paramMessage.what);
      break;
      localStringBuilder.append(" barrier=");
      localStringBuilder.append(paramMessage.arg1);
    }
  }
  
  private void c(StringBuilder paramStringBuilder)
  {
    Object localObject2;
    Object localObject1;
    int i;
    try
    {
      localObject2 = new HashMap();
      localObject1 = MqqMessageQueue.getSubMainThreadQueue();
      Object localObject4 = Class.forName("mqq.os.MqqMessageQueue").getDeclaredField("mMessages");
      ((Field)localObject4).setAccessible(true);
      Object localObject3 = Class.forName("mqq.os.MqqMessage");
      Field localField = ((Class)localObject3).getDeclaredField("wrappedMsg");
      localField.setAccessible(true);
      localObject3 = ((Class)localObject3).getDeclaredField("next");
      ((Field)localObject3).setAccessible(true);
      localObject1 = (MqqMessage)((Field)localObject4).get(localObject1);
      i = 0;
      if ((localObject1 != null) && (i <= 100000))
      {
        localObject4 = b((Message)localField.get(localObject1));
        if (((HashMap)localObject2).containsKey(localObject4)) {
          ((HashMap)localObject2).put(localObject4, Integer.valueOf(((Integer)((HashMap)localObject2).get(localObject4)).intValue() + 1));
        }
        for (;;)
        {
          localObject1 = (MqqMessage)((Field)localObject3).get(localObject1);
          i += 1;
          break;
          ((HashMap)localObject2).put(localObject4, Integer.valueOf(1));
        }
        return;
      }
    }
    catch (Throwable paramStringBuilder)
    {
      QLog.e("StatisticCollector", 1, "Fetch MqqMessageQueue's Messages faild", paramStringBuilder);
    }
    label353:
    for (;;)
    {
      localObject1 = g((HashMap)localObject2);
      paramStringBuilder.append("MqqMessageQueeu has " + i + " Messages, and it's Top 50 Messages:\n");
      QLog.d("StatisticCollector", 1, "MqqMessageQueeu has " + i + " Messages, and it's Top 50 Messages:");
      localObject1 = ((HashMap)localObject1).entrySet().iterator();
      i = 0;
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label353;
        }
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        if (i > 50) {
          break;
        }
        localObject2 = (String)((Map.Entry)localObject2).getKey() + ", Count = " + ((Map.Entry)localObject2).getValue() + "\n";
        paramStringBuilder.append((String)localObject2);
        QLog.d("StatisticCollector", 1, (String)localObject2);
        i += 1;
      }
    }
  }
  
  private void d(StringBuilder paramStringBuilder)
  {
    int j = 0;
    for (;;)
    {
      Object localObject2;
      try
      {
        localObject2 = new HashMap();
        localObject1 = Class.forName("android.os.MessageQueue").getDeclaredField("mMessages");
        ((Field)localObject1).setAccessible(true);
        Object localObject3 = Class.forName("android.os.Looper").getMethod("getQueue", new Class[0]);
        ((Method)localObject3).setAccessible(true);
        localObject1 = (Message)((Field)localObject1).get((MessageQueue)((Method)localObject3).invoke(Looper.getMainLooper(), new Object[0]));
        if (localObject1 == null) {
          break label450;
        }
        localObject3 = b((Message)localObject1);
        String str;
        if (((HashMap)localObject2).containsKey(localObject3))
        {
          ((HashMap)localObject2).put(localObject3, Integer.valueOf(((Integer)((HashMap)localObject2).get(localObject3)).intValue() + 1));
          i = 1;
          localObject3 = Class.forName("android.os.Message").getDeclaredField("next");
          ((Field)localObject3).setAccessible(true);
          localObject1 = (Message)((Field)localObject3).get(localObject1);
          if ((localObject1 == null) || (i > 100000)) {
            break label274;
          }
          str = b((Message)localObject1);
          if (((HashMap)localObject2).containsKey(str))
          {
            ((HashMap)localObject2).put(str, Integer.valueOf(((Integer)((HashMap)localObject2).get(str)).intValue() + 1));
            localObject1 = (Message)((Field)localObject3).get(localObject1);
            i += 1;
            continue;
          }
        }
        else
        {
          ((HashMap)localObject2).put(localObject3, Integer.valueOf(1));
          i = 1;
          continue;
        }
        ((HashMap)localObject2).put(str, Integer.valueOf(1));
        continue;
        localObject1 = g((HashMap)localObject2);
      }
      catch (Throwable paramStringBuilder)
      {
        QLog.e("StatisticCollector", 1, "Fetch Main Thread's Messages faild", paramStringBuilder);
        return;
      }
      label274:
      paramStringBuilder.append("Main Thread has " + i + " Messages, and it's Top 50 Messages:\n");
      QLog.d("StatisticCollector", 1, "Main Thread has " + i + " Messages, and it's Top 50 Messages:");
      Object localObject1 = ((HashMap)localObject1).entrySet().iterator();
      int i = j;
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label448;
        }
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        if (i > 50) {
          break;
        }
        localObject2 = (String)((Map.Entry)localObject2).getKey() + ", Count = " + ((Map.Entry)localObject2).getValue() + "\n";
        paramStringBuilder.append((String)localObject2);
        QLog.d("StatisticCollector", 1, (String)localObject2);
        i += 1;
      }
      label448:
      continue;
      label450:
      i = 0;
    }
  }
  
  private HashMap<String, Integer> g(HashMap<String, Integer> paramHashMap)
  {
    Object localObject = new LinkedList(paramHashMap.entrySet());
    Collections.sort((List)localObject, new anpe(this));
    paramHashMap = new LinkedHashMap();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      paramHashMap.put(localEntry.getKey(), localEntry.getValue());
    }
    return paramHashMap;
  }
  
  public byte[] getCrashExtraData(boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt, long paramLong)
  {
    return null;
  }
  
  /* Error */
  public String getCrashExtraMessage(boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt, long paramLong)
  {
    // Byte code:
    //   0: ldc 151
    //   2: iconst_1
    //   3: new 20	java/lang/StringBuilder
    //   6: dup
    //   7: ldc_w 270
    //   10: invokespecial 273	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   13: iload_1
    //   14: invokevirtual 276	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   17: ldc_w 278
    //   20: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_2
    //   24: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: ldc_w 280
    //   30: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: aload_3
    //   34: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: ldc_w 282
    //   40: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: aload 4
    //   45: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: ldc_w 284
    //   51: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: iload 5
    //   56: invokevirtual 58	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   59: ldc_w 286
    //   62: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: invokestatic 292	anpc:access$000	()Ljava/text/SimpleDateFormat;
    //   68: new 294	java/util/Date
    //   71: dup
    //   72: lload 6
    //   74: invokespecial 297	java/util/Date:<init>	(J)V
    //   77: invokevirtual 303	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   80: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   89: aload_2
    //   90: invokestatic 307	anpc:nB	(Ljava/lang/String;)Ljava/lang/String;
    //   93: pop
    //   94: aload 4
    //   96: invokestatic 310	anpc:br	(Ljava/lang/String;)Ljava/lang/String;
    //   99: pop
    //   100: iconst_1
    //   101: getstatic 315	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   104: if_icmpne +41 -> 145
    //   107: invokestatic 321	java/lang/System:currentTimeMillis	()J
    //   110: getstatic 325	anpc:ans	J
    //   113: lsub
    //   114: ldc2_w 326
    //   117: lcmp
    //   118: ifgt +27 -> 145
    //   121: invokestatic 331	anpc:p	()Landroid/content/Context;
    //   124: new 20	java/lang/StringBuilder
    //   127: dup
    //   128: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   131: aload_2
    //   132: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: aload_3
    //   136: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   142: invokestatic 337	swu:bg	(Landroid/content/Context;Ljava/lang/String;)V
    //   145: iconst_1
    //   146: getstatic 315	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   149: if_icmpne +47 -> 196
    //   152: aload 4
    //   154: invokestatic 343	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   157: ifne +39 -> 196
    //   160: iload_1
    //   161: ifeq +14 -> 175
    //   164: aload 4
    //   166: ldc_w 345
    //   169: invokevirtual 348	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   172: ifne +18 -> 190
    //   175: iload_1
    //   176: ifne +20 -> 196
    //   179: aload 4
    //   181: ldc_w 350
    //   184: invokevirtual 348	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   187: ifeq +9 -> 196
    //   190: invokestatic 356	com/tencent/mobileqq/statistics/thread/SuspendThreadManager:a	()Lcom/tencent/mobileqq/statistics/thread/SuspendThreadManager;
    //   193: invokevirtual 359	com/tencent/mobileqq/statistics/thread/SuspendThreadManager:dTe	()V
    //   196: getstatic 362	anpc:a	Lanpc$f;
    //   199: ifnull +43 -> 242
    //   202: iload_1
    //   203: ifne +39 -> 242
    //   206: ldc_w 364
    //   209: aload_2
    //   210: invokevirtual 367	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   213: ifeq +29 -> 242
    //   216: aload_3
    //   217: invokestatic 343	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   220: ifne +22 -> 242
    //   223: aload_3
    //   224: ldc_w 369
    //   227: invokevirtual 348	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   230: ifeq +12 -> 242
    //   233: getstatic 362	anpc:a	Lanpc$f;
    //   236: aload_2
    //   237: invokeinterface 374 2 0
    //   242: getstatic 378	com/tencent/common/app/BaseApplicationImpl:processName	Ljava/lang/String;
    //   245: ldc_w 380
    //   248: invokevirtual 384	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   251: ifeq +31 -> 282
    //   254: new 20	java/lang/StringBuilder
    //   257: dup
    //   258: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   261: ldc_w 386
    //   264: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: aload_2
    //   268: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: aload 4
    //   273: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   279: invokestatic 391	aaga:reportCrash	(Ljava/lang/String;)V
    //   282: aload 4
    //   284: ifnull +17 -> 301
    //   287: aload 4
    //   289: ldc_w 393
    //   292: invokevirtual 348	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   295: ifeq +6 -> 301
    //   298: invokestatic 398	anqa:dTc	()V
    //   301: aload 4
    //   303: ifnull +120 -> 423
    //   306: aload 4
    //   308: ldc_w 400
    //   311: invokevirtual 348	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   314: ifne +25 -> 339
    //   317: aload 4
    //   319: ldc_w 402
    //   322: invokevirtual 348	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   325: ifne +14 -> 339
    //   328: aload 4
    //   330: ldc_w 404
    //   333: invokevirtual 348	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   336: ifeq +87 -> 423
    //   339: iconst_0
    //   340: iconst_0
    //   341: invokestatic 410	com/tencent/mobileqq/statistics/FDNative:cu	(ZZ)V
    //   344: new 90	java/util/HashMap
    //   347: dup
    //   348: invokespecial 91	java/util/HashMap:<init>	()V
    //   351: astore 11
    //   353: iload_1
    //   354: ifeq +2141 -> 2495
    //   357: ldc_w 412
    //   360: astore 10
    //   362: aload 11
    //   364: ldc_w 414
    //   367: aload 10
    //   369: invokevirtual 149	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   372: pop
    //   373: aload 11
    //   375: ldc_w 416
    //   378: aload_2
    //   379: invokevirtual 149	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   382: pop
    //   383: aload 11
    //   385: ldc_w 418
    //   388: getstatic 378	com/tencent/common/app/BaseApplicationImpl:processName	Ljava/lang/String;
    //   391: invokevirtual 149	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   394: pop
    //   395: invokestatic 331	anpc:p	()Landroid/content/Context;
    //   398: invokestatic 421	anpc:a	(Landroid/content/Context;)Lanpc;
    //   401: aload_0
    //   402: getfield 12	anpd:this$0	Lanpc;
    //   405: getfield 424	anpc:mCurUin	Ljava/lang/String;
    //   408: ldc_w 426
    //   411: iconst_1
    //   412: lconst_0
    //   413: lconst_0
    //   414: aload 11
    //   416: ldc_w 428
    //   419: iconst_0
    //   420: invokevirtual 432	anpc:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   423: iload_1
    //   424: aload_2
    //   425: aload 4
    //   427: invokestatic 438	abxj:v	(ZLjava/lang/String;Ljava/lang/String;)V
    //   430: aload 4
    //   432: ifnull +104 -> 536
    //   435: aload 4
    //   437: ldc_w 440
    //   440: invokevirtual 348	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   443: ifne +14 -> 457
    //   446: aload 4
    //   448: ldc_w 442
    //   451: invokevirtual 348	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   454: ifeq +82 -> 536
    //   457: new 90	java/util/HashMap
    //   460: dup
    //   461: invokespecial 91	java/util/HashMap:<init>	()V
    //   464: astore 11
    //   466: iload_1
    //   467: ifeq +2036 -> 2503
    //   470: ldc_w 412
    //   473: astore 10
    //   475: aload 11
    //   477: ldc_w 414
    //   480: aload 10
    //   482: invokevirtual 149	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   485: pop
    //   486: aload 11
    //   488: ldc_w 416
    //   491: aload_2
    //   492: invokevirtual 149	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   495: pop
    //   496: aload 11
    //   498: ldc_w 418
    //   501: getstatic 378	com/tencent/common/app/BaseApplicationImpl:processName	Ljava/lang/String;
    //   504: invokevirtual 149	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   507: pop
    //   508: invokestatic 331	anpc:p	()Landroid/content/Context;
    //   511: invokestatic 421	anpc:a	(Landroid/content/Context;)Lanpc;
    //   514: aload_0
    //   515: getfield 12	anpd:this$0	Lanpc;
    //   518: getfield 424	anpc:mCurUin	Ljava/lang/String;
    //   521: ldc_w 444
    //   524: iconst_1
    //   525: lconst_0
    //   526: lconst_0
    //   527: aload 11
    //   529: ldc_w 428
    //   532: iconst_0
    //   533: invokevirtual 432	anpc:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   536: iload_1
    //   537: aload_2
    //   538: aload_3
    //   539: aload 4
    //   541: iload 5
    //   543: lload 6
    //   545: invokestatic 449	anmc:a	(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;IJ)V
    //   548: getstatic 455	com/tencent/mobileqq/app/BaseActivity:sActivityRoute	Ljava/util/ArrayList;
    //   551: ldc_w 457
    //   554: invokevirtual 461	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   557: ifeq +56 -> 613
    //   560: new 463	android/content/Intent
    //   563: dup
    //   564: invokespecial 464	android/content/Intent:<init>	()V
    //   567: astore 10
    //   569: aload 10
    //   571: ldc_w 466
    //   574: invokevirtual 470	android/content/Intent:setAction	(Ljava/lang/String;)Landroid/content/Intent;
    //   577: pop
    //   578: aload 10
    //   580: invokestatic 476	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   583: invokevirtual 479	com/tencent/qphone/base/util/BaseApplication:getPackageName	()Ljava/lang/String;
    //   586: invokevirtual 482	android/content/Intent:setPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   589: pop
    //   590: invokestatic 331	anpc:p	()Landroid/content/Context;
    //   593: aload 10
    //   595: invokevirtual 488	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   598: invokestatic 491	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   601: ifeq +12 -> 613
    //   604: ldc 151
    //   606: iconst_2
    //   607: ldc_w 493
    //   610: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   613: getstatic 378	com/tencent/common/app/BaseApplicationImpl:processName	Ljava/lang/String;
    //   616: ldc_w 495
    //   619: invokevirtual 384	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   622: ifeq +31 -> 653
    //   625: new 20	java/lang/StringBuilder
    //   628: dup
    //   629: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   632: ldc_w 386
    //   635: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   638: aload_2
    //   639: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   642: aload 4
    //   644: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   647: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   650: invokestatic 498	com/tencent/mobileqq/microapp/util/MiniAppCrashUtils:reportCrash	(Ljava/lang/String;)V
    //   653: aload 4
    //   655: invokestatic 343	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   658: ifne +139 -> 797
    //   661: aload 4
    //   663: ldc_w 500
    //   666: invokevirtual 348	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   669: ifeq +128 -> 797
    //   672: new 502	org/json/JSONObject
    //   675: dup
    //   676: invokespecial 503	org/json/JSONObject:<init>	()V
    //   679: astore 10
    //   681: aload 10
    //   683: ldc_w 505
    //   686: iload_1
    //   687: invokevirtual 508	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   690: pop
    //   691: aload 10
    //   693: ldc_w 510
    //   696: aload_2
    //   697: invokevirtual 513	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   700: pop
    //   701: aload 10
    //   703: ldc_w 515
    //   706: aload_3
    //   707: invokevirtual 513	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   710: pop
    //   711: aload 10
    //   713: ldc_w 517
    //   716: aload 4
    //   718: invokevirtual 513	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   721: pop
    //   722: aload 10
    //   724: ldc_w 519
    //   727: iload 5
    //   729: invokevirtual 522	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   732: pop
    //   733: aload 10
    //   735: ldc_w 524
    //   738: lload 6
    //   740: invokevirtual 527	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   743: pop
    //   744: getstatic 531	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   747: invokevirtual 535	com/tencent/common/app/BaseApplicationImpl:getClassLoader	()Ljava/lang/ClassLoader;
    //   750: astore 11
    //   752: aload 11
    //   754: ifnull +43 -> 797
    //   757: aload 11
    //   759: ldc_w 537
    //   762: invokevirtual 542	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   765: ldc_w 543
    //   768: iconst_1
    //   769: anewarray 45	java/lang/Class
    //   772: dup
    //   773: iconst_0
    //   774: ldc 200
    //   776: aastore
    //   777: invokevirtual 217	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   780: aconst_null
    //   781: iconst_1
    //   782: anewarray 4	java/lang/Object
    //   785: dup
    //   786: iconst_0
    //   787: aload 10
    //   789: invokevirtual 544	org/json/JSONObject:toString	()Ljava/lang/String;
    //   792: aastore
    //   793: invokevirtual 230	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   796: pop
    //   797: aconst_null
    //   798: astore 11
    //   800: new 546	java/io/File
    //   803: dup
    //   804: ldc_w 548
    //   807: invokespecial 549	java/io/File:<init>	(Ljava/lang/String;)V
    //   810: astore 10
    //   812: aload 10
    //   814: ifnull +17 -> 831
    //   817: aload 10
    //   819: invokevirtual 552	java/io/File:exists	()Z
    //   822: ifne +9 -> 831
    //   825: aload 10
    //   827: invokevirtual 555	java/io/File:mkdirs	()Z
    //   830: pop
    //   831: new 557	java/io/FileWriter
    //   834: dup
    //   835: new 20	java/lang/StringBuilder
    //   838: dup
    //   839: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   842: ldc_w 548
    //   845: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   848: lload 6
    //   850: invokevirtual 560	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   853: ldc_w 562
    //   856: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   859: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   862: invokespecial 563	java/io/FileWriter:<init>	(Ljava/lang/String;)V
    //   865: astore 10
    //   867: new 20	java/lang/StringBuilder
    //   870: dup
    //   871: sipush 128
    //   874: invokespecial 23	java/lang/StringBuilder:<init>	(I)V
    //   877: astore 11
    //   879: aload 11
    //   881: invokestatic 292	anpc:access$000	()Ljava/text/SimpleDateFormat;
    //   884: new 294	java/util/Date
    //   887: dup
    //   888: lload 6
    //   890: invokespecial 297	java/util/Date:<init>	(J)V
    //   893: invokevirtual 303	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   896: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   899: ldc 207
    //   901: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   904: aload_2
    //   905: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   908: ldc 207
    //   910: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   913: aload 4
    //   915: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   918: pop
    //   919: aload 10
    //   921: aload 11
    //   923: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   926: invokevirtual 566	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   929: aload 10
    //   931: invokevirtual 569	java/io/FileWriter:flush	()V
    //   934: aload 10
    //   936: ifnull +8 -> 944
    //   939: aload 10
    //   941: invokevirtual 572	java/io/FileWriter:close	()V
    //   944: aload_2
    //   945: invokestatic 343	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   948: ifne +47 -> 995
    //   951: aload_2
    //   952: ldc_w 574
    //   955: invokevirtual 348	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   958: ifeq +37 -> 995
    //   961: invokestatic 579	com/tencent/mobileqq/app/MemoryManager:a	()Lcom/tencent/mobileqq/app/MemoryManager;
    //   964: invokevirtual 582	com/tencent/mobileqq/app/MemoryManager:bBH	()V
    //   967: aload 4
    //   969: ldc_w 584
    //   972: invokevirtual 348	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   975: ifne +20 -> 995
    //   978: aload 4
    //   980: ldc_w 586
    //   983: invokevirtual 348	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   986: ifne +9 -> 995
    //   989: invokestatic 591	sxa:a	()Lsxa;
    //   992: invokevirtual 592	sxa:bBH	()V
    //   995: getstatic 378	com/tencent/common/app/BaseApplicationImpl:processName	Ljava/lang/String;
    //   998: astore 13
    //   1000: iload_1
    //   1001: ifeq +39 -> 1040
    //   1004: aload 13
    //   1006: ldc_w 594
    //   1009: invokevirtual 384	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1012: ifne +14 -> 1026
    //   1015: aload 13
    //   1017: ldc_w 596
    //   1020: invokevirtual 384	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1023: ifeq +17 -> 1040
    //   1026: ldc_w 598
    //   1029: iconst_1
    //   1030: aload 4
    //   1032: invokestatic 600	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1035: aload 4
    //   1037: invokestatic 605	cooperation/qzone/QZoneCrashHandler:saveLastCrashInf	(Ljava/lang/String;)V
    //   1040: invokestatic 331	anpc:p	()Landroid/content/Context;
    //   1043: invokestatic 611	com/tencent/common/app/QFixApplicationImpl:cT	(Landroid/content/Context;)V
    //   1046: new 20	java/lang/StringBuilder
    //   1049: dup
    //   1050: sipush 128
    //   1053: invokespecial 23	java/lang/StringBuilder:<init>	(I)V
    //   1056: astore 12
    //   1058: invokestatic 331	anpc:p	()Landroid/content/Context;
    //   1061: ldc_w 613
    //   1064: invokestatic 618	tnq:a	(Landroid/content/Context;Ljava/lang/String;)Ltnp;
    //   1067: astore 10
    //   1069: aload 12
    //   1071: ldc_w 620
    //   1074: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1077: pop
    //   1078: aload 12
    //   1080: ldc_w 622
    //   1083: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1086: pop
    //   1087: aload 12
    //   1089: ldc_w 624
    //   1092: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1095: getstatic 627	com/tencent/common/app/BaseApplicationImpl:sInjectResult	Ljava/lang/String;
    //   1098: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1101: pop
    //   1102: aload 12
    //   1104: ldc_w 629
    //   1107: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1110: getstatic 632	com/tencent/common/app/BaseApplicationImpl:sQQAppInterfaceEscapedMsg	Ljava/lang/String;
    //   1113: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1116: pop
    //   1117: aload 12
    //   1119: ldc_w 634
    //   1122: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1125: getstatic 637	com/tencent/common/app/BaseApplicationImpl:sSplashActivityEscapedMsg	Ljava/lang/String;
    //   1128: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1131: pop
    //   1132: aload 12
    //   1134: ldc_w 639
    //   1137: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1140: getstatic 642	com/tencent/common/app/BaseApplicationImpl:sImmersiveUtilsEscapedMsg	Ljava/lang/String;
    //   1143: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1146: pop
    //   1147: aload 12
    //   1149: ldc_w 644
    //   1152: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1155: getstatic 649	anmo:dKe	I
    //   1158: invokevirtual 58	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1161: pop
    //   1162: aload 12
    //   1164: ldc_w 651
    //   1167: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1170: astore 11
    //   1172: aload 10
    //   1174: ifnull +1393 -> 2567
    //   1177: aload 10
    //   1179: invokevirtual 656	tnp:On	()Z
    //   1182: ifeq +1385 -> 2567
    //   1185: iconst_1
    //   1186: istore 9
    //   1188: aload 11
    //   1190: iload 9
    //   1192: invokevirtual 276	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1195: ldc_w 658
    //   1198: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1201: getstatic 663	tnh:bCv	I
    //   1204: invokevirtual 58	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1207: ldc_w 665
    //   1210: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1213: getstatic 670	com/tencent/hotpatch/PatchResolveForDalvik:bCw	I
    //   1216: invokevirtual 58	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1219: ldc_w 672
    //   1222: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1225: getstatic 675	tnh:aJB	Ljava/lang/String;
    //   1228: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1231: pop
    //   1232: aload 12
    //   1234: ldc_w 677
    //   1237: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1240: invokestatic 683	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   1243: invokevirtual 686	java/lang/Runtime:maxMemory	()J
    //   1246: invokevirtual 560	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1249: ldc_w 688
    //   1252: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1255: invokestatic 683	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   1258: invokevirtual 691	java/lang/Runtime:totalMemory	()J
    //   1261: invokestatic 683	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   1264: invokevirtual 694	java/lang/Runtime:freeMemory	()J
    //   1267: lsub
    //   1268: invokevirtual 560	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1271: pop
    //   1272: aload 12
    //   1274: ldc_w 696
    //   1277: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1280: invokestatic 579	com/tencent/mobileqq/app/MemoryManager:a	()Lcom/tencent/mobileqq/app/MemoryManager;
    //   1283: invokevirtual 699	com/tencent/mobileqq/app/MemoryManager:Az	()I
    //   1286: invokevirtual 58	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1289: ldc_w 701
    //   1292: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1295: invokestatic 579	com/tencent/mobileqq/app/MemoryManager:a	()Lcom/tencent/mobileqq/app/MemoryManager;
    //   1298: invokevirtual 704	com/tencent/mobileqq/app/MemoryManager:AA	()I
    //   1301: invokevirtual 58	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1304: ldc_w 706
    //   1307: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1310: invokestatic 579	com/tencent/mobileqq/app/MemoryManager:a	()Lcom/tencent/mobileqq/app/MemoryManager;
    //   1313: invokevirtual 709	com/tencent/mobileqq/app/MemoryManager:AB	()I
    //   1316: invokevirtual 58	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1319: pop
    //   1320: aload 12
    //   1322: ldc_w 711
    //   1325: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1328: invokestatic 716	anoz:a	()Lanoz;
    //   1331: invokevirtual 719	anoz:Ak	()Ljava/lang/String;
    //   1334: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1337: pop
    //   1338: getstatic 723	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   1341: ifnull +21 -> 1362
    //   1344: aload 12
    //   1346: ldc_w 725
    //   1349: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1352: getstatic 723	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   1355: invokevirtual 730	android/support/v4/util/MQLruCache:size	()I
    //   1358: invokevirtual 58	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1361: pop
    //   1362: invokestatic 683	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   1365: invokevirtual 686	java/lang/Runtime:maxMemory	()J
    //   1368: invokestatic 683	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   1371: invokevirtual 691	java/lang/Runtime:totalMemory	()J
    //   1374: lsub
    //   1375: l2f
    //   1376: fconst_1
    //   1377: fmul
    //   1378: invokestatic 683	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   1381: invokevirtual 686	java/lang/Runtime:maxMemory	()J
    //   1384: l2f
    //   1385: fdiv
    //   1386: f2d
    //   1387: ldc2_w 731
    //   1390: dcmpl
    //   1391: iflt +29 -> 1420
    //   1394: aload_2
    //   1395: invokestatic 343	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1398: ifne +22 -> 1420
    //   1401: aload_2
    //   1402: ldc_w 574
    //   1405: invokevirtual 348	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1408: ifeq +12 -> 1420
    //   1411: aload_0
    //   1412: getfield 12	anpd:this$0	Lanpc;
    //   1415: aload 12
    //   1417: invokevirtual 734	anpc:b	(Ljava/lang/StringBuilder;)V
    //   1420: aload 12
    //   1422: ldc_w 736
    //   1425: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1428: getstatic 741	com/tencent/mqq/shared_file_accessor/SharedPreferencesProxyManager:sSystemSpExceptionMsg	Ljava/lang/String;
    //   1431: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1434: pop
    //   1435: getstatic 747	com/tencent/mobileqq/util/WebpSoLoader:oU	[I
    //   1438: astore 10
    //   1440: aload 10
    //   1442: ifnull +56 -> 1498
    //   1445: aload 10
    //   1447: arraylength
    //   1448: iconst_3
    //   1449: if_icmplt +49 -> 1498
    //   1452: aload 12
    //   1454: ldc_w 749
    //   1457: iconst_3
    //   1458: anewarray 4	java/lang/Object
    //   1461: dup
    //   1462: iconst_0
    //   1463: aload 10
    //   1465: iconst_0
    //   1466: iaload
    //   1467: invokestatic 145	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1470: aastore
    //   1471: dup
    //   1472: iconst_1
    //   1473: aload 10
    //   1475: iconst_1
    //   1476: iaload
    //   1477: invokestatic 145	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1480: aastore
    //   1481: dup
    //   1482: iconst_2
    //   1483: aload 10
    //   1485: iconst_2
    //   1486: iaload
    //   1487: invokestatic 145	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1490: aastore
    //   1491: invokestatic 752	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1494: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1497: pop
    //   1498: aload 12
    //   1500: ldc 207
    //   1502: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1505: pop
    //   1506: invokestatic 757	com/tencent/mfsdk/MagnifierSDK:a	()Lcom/tencent/mfsdk/MagnifierSDK;
    //   1509: invokevirtual 760	com/tencent/mfsdk/MagnifierSDK:a	()Ltxj;
    //   1512: invokeinterface 765 1 0
    //   1517: astore 11
    //   1519: invokestatic 771	aqgz:getRomMemroy	()[J
    //   1522: astore 14
    //   1524: aload 12
    //   1526: invokestatic 774	aqgz:BZ	()Ljava/lang/String;
    //   1529: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1532: ldc 207
    //   1534: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1537: pop
    //   1538: aload 11
    //   1540: astore 10
    //   1542: aload 11
    //   1544: ifnonnull +8 -> 1552
    //   1547: ldc_w 776
    //   1550: astore 10
    //   1552: aload 12
    //   1554: aload 10
    //   1556: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1559: ldc 207
    //   1561: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1564: pop
    //   1565: aload 12
    //   1567: ldc_w 778
    //   1570: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1573: aload 14
    //   1575: iconst_0
    //   1576: laload
    //   1577: invokevirtual 560	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1580: ldc_w 780
    //   1583: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1586: aload 14
    //   1588: iconst_1
    //   1589: laload
    //   1590: invokevirtual 560	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1593: ldc_w 782
    //   1596: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1599: pop
    //   1600: aload_0
    //   1601: getfield 12	anpd:this$0	Lanpc;
    //   1604: invokestatic 785	anpc:a	(Lanpc;)Ljava/lang/String;
    //   1607: ifnonnull +966 -> 2573
    //   1610: ldc_w 776
    //   1613: astore 10
    //   1615: aload 12
    //   1617: aload 10
    //   1619: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1622: ldc 207
    //   1624: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1627: pop
    //   1628: aload 12
    //   1630: new 20	java/lang/StringBuilder
    //   1633: dup
    //   1634: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   1637: ldc_w 787
    //   1640: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1643: getstatic 792	mqq/app/Foreground:sCountResume	I
    //   1646: invokevirtual 58	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1649: ldc 207
    //   1651: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1654: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1657: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1660: pop
    //   1661: aload 12
    //   1663: ldc_w 794
    //   1666: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1669: getstatic 799	com/tencent/mobileqq/activity/SplashActivity:bKT	I
    //   1672: invokevirtual 58	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1675: ldc 207
    //   1677: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1680: pop
    //   1681: getstatic 803	com/tencent/mobileqq/app/BaseActivity:sTopActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   1684: astore 10
    //   1686: aload 10
    //   1688: instanceof 796
    //   1691: ifeq +32 -> 1723
    //   1694: aload 10
    //   1696: checkcast 796	com/tencent/mobileqq/activity/SplashActivity
    //   1699: astore 10
    //   1701: aload 12
    //   1703: ldc_w 805
    //   1706: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1709: aload 10
    //   1711: invokevirtual 808	com/tencent/mobileqq/activity/SplashActivity:getCurrentTab	()I
    //   1714: invokevirtual 58	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1717: ldc 207
    //   1719: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1722: pop
    //   1723: getstatic 811	com/tencent/common/app/BaseApplicationImpl:sPublicFragmentEscapedMsg	Ljava/lang/String;
    //   1726: invokestatic 343	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1729: ifne +23 -> 1752
    //   1732: aload 12
    //   1734: ldc_w 813
    //   1737: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1740: getstatic 811	com/tencent/common/app/BaseApplicationImpl:sPublicFragmentEscapedMsg	Ljava/lang/String;
    //   1743: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1746: ldc 207
    //   1748: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1751: pop
    //   1752: getstatic 816	com/tencent/common/app/BaseApplicationImpl:sNativeMonitorEscapedMsg	Ljava/lang/String;
    //   1755: invokestatic 343	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1758: ifne +23 -> 1781
    //   1761: aload 12
    //   1763: ldc_w 818
    //   1766: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1769: getstatic 816	com/tencent/common/app/BaseApplicationImpl:sNativeMonitorEscapedMsg	Ljava/lang/String;
    //   1772: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1775: ldc 207
    //   1777: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1780: pop
    //   1781: getstatic 821	com/tencent/common/app/BaseApplicationImpl:ASanEscapedMsg	Ljava/lang/String;
    //   1784: invokestatic 343	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1787: ifne +23 -> 1810
    //   1790: aload 12
    //   1792: ldc_w 823
    //   1795: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1798: getstatic 821	com/tencent/common/app/BaseApplicationImpl:ASanEscapedMsg	Ljava/lang/String;
    //   1801: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1804: ldc 207
    //   1806: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1809: pop
    //   1810: aload 12
    //   1812: aload_0
    //   1813: getfield 12	anpd:this$0	Lanpc;
    //   1816: invokestatic 826	anpc:b	(Lanpc;)Ljava/lang/StringBuilder;
    //   1819: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1822: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1825: pop
    //   1826: aload 12
    //   1828: aload_0
    //   1829: getfield 12	anpd:this$0	Lanpc;
    //   1832: invokestatic 828	anpc:a	(Lanpc;)Ljava/lang/StringBuilder;
    //   1835: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1838: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1841: pop
    //   1842: getstatic 831	cooperation/qzone/QZoneCrashHandler:lastCrashedMeasuredText	Ljava/lang/String;
    //   1845: invokestatic 343	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1848: ifne +51 -> 1899
    //   1851: getstatic 836	android/os/Build$VERSION:SDK_INT	I
    //   1854: bipush 8
    //   1856: if_icmplt +43 -> 1899
    //   1859: aload 12
    //   1861: new 20	java/lang/StringBuilder
    //   1864: dup
    //   1865: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   1868: ldc_w 838
    //   1871: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1874: getstatic 831	cooperation/qzone/QZoneCrashHandler:lastCrashedMeasuredText	Ljava/lang/String;
    //   1877: invokevirtual 842	java/lang/String:getBytes	()[B
    //   1880: iconst_0
    //   1881: invokestatic 848	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   1884: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1887: ldc 207
    //   1889: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1892: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1895: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1898: pop
    //   1899: aload 12
    //   1901: invokestatic 853	avry:a	()Lavry;
    //   1904: invokevirtual 856	avry:Gh	()Ljava/lang/String;
    //   1907: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1910: pop
    //   1911: aload 12
    //   1913: ldc 207
    //   1915: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1918: pop
    //   1919: aload_0
    //   1920: getfield 12	anpd:this$0	Lanpc;
    //   1923: invokestatic 859	anpc:a	(Lanpc;)Ljava/util/LinkedList;
    //   1926: invokevirtual 860	java/util/LinkedList:size	()I
    //   1929: ifle +30 -> 1959
    //   1932: aload 12
    //   1934: aload_0
    //   1935: getfield 12	anpd:this$0	Lanpc;
    //   1938: invokestatic 859	anpc:a	(Lanpc;)Ljava/util/LinkedList;
    //   1941: invokevirtual 863	java/util/LinkedList:removeLast	()Ljava/lang/Object;
    //   1944: checkcast 865	anpc$a
    //   1947: invokevirtual 866	anpc$a:toString	()Ljava/lang/String;
    //   1950: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1953: pop
    //   1954: goto -35 -> 1919
    //   1957: astore 10
    //   1959: invokestatic 331	anpc:p	()Landroid/content/Context;
    //   1962: invokestatic 872	com/tencent/smtt/sdk/WebView:getTbsSDKVersion	(Landroid/content/Context;)I
    //   1965: istore 5
    //   1967: invokestatic 331	anpc:p	()Landroid/content/Context;
    //   1970: invokestatic 877	com/tencent/smtt/sdk/QbSdk:getTbsVersion	(Landroid/content/Context;)I
    //   1973: istore 8
    //   1975: aload 12
    //   1977: bipush 10
    //   1979: invokevirtual 880	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   1982: ldc_w 882
    //   1985: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1988: astore 11
    //   1990: iload 8
    //   1992: ifne +593 -> 2585
    //   1995: ldc_w 884
    //   1998: astore 10
    //   2000: aload 11
    //   2002: aload 10
    //   2004: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2007: ldc_w 886
    //   2010: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2013: iload 5
    //   2015: invokevirtual 58	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2018: ldc_w 888
    //   2021: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2024: iload 8
    //   2026: invokevirtual 58	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2029: pop
    //   2030: aload 12
    //   2032: ldc_w 890
    //   2035: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2038: invokestatic 331	anpc:p	()Landroid/content/Context;
    //   2041: invokestatic 893	com/tencent/smtt/sdk/WebView:getCrashExtraMessage	(Landroid/content/Context;)Ljava/lang/String;
    //   2044: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2047: pop
    //   2048: aload 12
    //   2050: ldc_w 895
    //   2053: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2056: invokestatic 292	anpc:access$000	()Ljava/text/SimpleDateFormat;
    //   2059: new 294	java/util/Date
    //   2062: dup
    //   2063: getstatic 898	swu:DH	J
    //   2066: invokespecial 297	java/util/Date:<init>	(J)V
    //   2069: invokevirtual 303	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   2072: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2075: pop
    //   2076: aload 12
    //   2078: ldc_w 900
    //   2081: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2084: invokestatic 292	anpc:access$000	()Ljava/text/SimpleDateFormat;
    //   2087: new 294	java/util/Date
    //   2090: dup
    //   2091: getstatic 903	swu:DI	J
    //   2094: invokespecial 297	java/util/Date:<init>	(J)V
    //   2097: invokevirtual 303	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   2100: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2103: ldc 207
    //   2105: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2108: pop
    //   2109: iload_1
    //   2110: ifeq +103 -> 2213
    //   2113: aload 13
    //   2115: ldc_w 594
    //   2118: invokevirtual 384	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2121: ifne +25 -> 2146
    //   2124: aload 13
    //   2126: ldc_w 596
    //   2129: invokevirtual 384	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2132: ifne +14 -> 2146
    //   2135: aload 13
    //   2137: ldc_w 380
    //   2140: invokevirtual 384	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2143: ifeq +70 -> 2213
    //   2146: invokestatic 331	anpc:p	()Landroid/content/Context;
    //   2149: ldc 151
    //   2151: iconst_4
    //   2152: invokevirtual 907	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   2155: ldc_w 909
    //   2158: aconst_null
    //   2159: invokeinterface 915 3 0
    //   2164: astore 10
    //   2166: aload 12
    //   2168: ldc_w 917
    //   2171: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2174: aload 10
    //   2176: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2179: pop
    //   2180: invokestatic 491	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2183: ifeq +30 -> 2213
    //   2186: ldc 151
    //   2188: iconst_2
    //   2189: new 20	java/lang/StringBuilder
    //   2192: dup
    //   2193: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   2196: ldc_w 919
    //   2199: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2202: aload 10
    //   2204: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2207: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2210: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2213: aload 13
    //   2215: ldc_w 921
    //   2218: invokevirtual 384	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2221: ifne +80 -> 2301
    //   2224: aload 13
    //   2226: ldc_w 923
    //   2229: invokevirtual 384	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2232: ifne +69 -> 2301
    //   2235: aload 13
    //   2237: ldc_w 925
    //   2240: invokevirtual 384	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2243: ifne +58 -> 2301
    //   2246: aload 13
    //   2248: ldc_w 927
    //   2251: invokevirtual 384	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2254: ifne +47 -> 2301
    //   2257: aload 13
    //   2259: ldc_w 929
    //   2262: invokevirtual 384	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2265: ifne +36 -> 2301
    //   2268: aload 13
    //   2270: ldc_w 931
    //   2273: invokevirtual 384	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2276: ifne +25 -> 2301
    //   2279: aload 13
    //   2281: ldc_w 933
    //   2284: invokevirtual 384	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2287: ifne +14 -> 2301
    //   2290: aload 13
    //   2292: ldc_w 935
    //   2295: invokevirtual 384	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2298: ifeq +60 -> 2358
    //   2301: invokestatic 940	avuf:GB	()Ljava/lang/String;
    //   2304: astore 10
    //   2306: aload 10
    //   2308: ifnull +50 -> 2358
    //   2311: aload 12
    //   2313: ldc_w 942
    //   2316: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2319: aload 10
    //   2321: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2324: pop
    //   2325: invokestatic 491	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2328: ifeq +30 -> 2358
    //   2331: ldc 151
    //   2333: iconst_2
    //   2334: new 20	java/lang/StringBuilder
    //   2337: dup
    //   2338: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   2341: ldc_w 944
    //   2344: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2347: aload 10
    //   2349: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2352: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2355: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2358: aload 12
    //   2360: ldc_w 946
    //   2363: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2366: invokestatic 950	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   2369: getfield 953	com/tencent/common/app/BaseApplicationImpl:startComponentInfo	Ljava/lang/String;
    //   2372: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2375: pop
    //   2376: invokestatic 950	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   2379: getfield 957	com/tencent/common/app/BaseApplicationImpl:broadcastInfoQueue	Ljava/util/Queue;
    //   2382: ifnull +233 -> 2615
    //   2385: invokestatic 950	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   2388: getfield 957	com/tencent/common/app/BaseApplicationImpl:broadcastInfoQueue	Ljava/util/Queue;
    //   2391: invokeinterface 961 1 0
    //   2396: ifne +219 -> 2615
    //   2399: invokestatic 950	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   2402: getfield 957	com/tencent/common/app/BaseApplicationImpl:broadcastInfoQueue	Ljava/util/Queue;
    //   2405: invokeinterface 962 1 0
    //   2410: astore 10
    //   2412: aload 10
    //   2414: invokeinterface 190 1 0
    //   2419: ifeq +196 -> 2615
    //   2422: aload 10
    //   2424: invokeinterface 193 1 0
    //   2429: checkcast 964	android/util/Pair
    //   2432: astore 11
    //   2434: aload 11
    //   2436: ifnull -24 -> 2412
    //   2439: aload 12
    //   2441: ldc_w 966
    //   2444: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2447: invokestatic 292	anpc:access$000	()Ljava/text/SimpleDateFormat;
    //   2450: new 294	java/util/Date
    //   2453: dup
    //   2454: aload 11
    //   2456: getfield 969	android/util/Pair:first	Ljava/lang/Object;
    //   2459: checkcast 971	java/lang/Long
    //   2462: invokevirtual 974	java/lang/Long:longValue	()J
    //   2465: invokespecial 297	java/util/Date:<init>	(J)V
    //   2468: invokevirtual 303	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   2471: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2474: ldc_w 976
    //   2477: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2480: aload 11
    //   2482: getfield 979	android/util/Pair:second	Ljava/lang/Object;
    //   2485: checkcast 200	java/lang/String
    //   2488: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2491: pop
    //   2492: goto -80 -> 2412
    //   2495: ldc_w 981
    //   2498: astore 10
    //   2500: goto -2138 -> 362
    //   2503: ldc_w 981
    //   2506: astore 10
    //   2508: goto -2033 -> 475
    //   2511: astore 10
    //   2513: aload 10
    //   2515: invokevirtual 984	java/lang/Throwable:printStackTrace	()V
    //   2518: goto -1721 -> 797
    //   2521: astore 12
    //   2523: aload 11
    //   2525: astore 10
    //   2527: aload 12
    //   2529: astore 11
    //   2531: aload 11
    //   2533: invokevirtual 985	java/lang/Exception:printStackTrace	()V
    //   2536: aload 10
    //   2538: ifnull -1594 -> 944
    //   2541: aload 10
    //   2543: invokevirtual 572	java/io/FileWriter:close	()V
    //   2546: goto -1602 -> 944
    //   2549: astore 10
    //   2551: goto -1607 -> 944
    //   2554: astore_2
    //   2555: aconst_null
    //   2556: astore_3
    //   2557: aload_3
    //   2558: ifnull +7 -> 2565
    //   2561: aload_3
    //   2562: invokevirtual 572	java/io/FileWriter:close	()V
    //   2565: aload_2
    //   2566: athrow
    //   2567: iconst_0
    //   2568: istore 9
    //   2570: goto -1382 -> 1188
    //   2573: aload_0
    //   2574: getfield 12	anpd:this$0	Lanpc;
    //   2577: invokestatic 785	anpc:a	(Lanpc;)Ljava/lang/String;
    //   2580: astore 10
    //   2582: goto -967 -> 1615
    //   2585: ldc_w 987
    //   2588: astore 10
    //   2590: goto -590 -> 2000
    //   2593: astore 10
    //   2595: invokestatic 491	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2598: ifeq -240 -> 2358
    //   2601: ldc 151
    //   2603: iconst_2
    //   2604: ldc_w 989
    //   2607: aload 10
    //   2609: invokestatic 159	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2612: goto -254 -> 2358
    //   2615: getstatic 994	asfg:cEz	Ljava/lang/String;
    //   2618: astore 10
    //   2620: aload 10
    //   2622: ifnull +25 -> 2647
    //   2625: aload 10
    //   2627: invokevirtual 997	java/lang/String:length	()I
    //   2630: ifle +17 -> 2647
    //   2633: aload 12
    //   2635: ldc_w 999
    //   2638: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2641: aload 10
    //   2643: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2646: pop
    //   2647: aload_2
    //   2648: invokestatic 343	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2651: ifne +49 -> 2700
    //   2654: aload_2
    //   2655: ldc_w 1001
    //   2658: invokevirtual 348	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2661: ifeq +39 -> 2700
    //   2664: aload 4
    //   2666: invokestatic 343	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2669: ifne +31 -> 2700
    //   2672: aload 4
    //   2674: ldc_w 1003
    //   2677: invokevirtual 348	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2680: ifeq +20 -> 2700
    //   2683: aload 12
    //   2685: ldc_w 1005
    //   2688: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2691: pop
    //   2692: invokestatic 950	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   2695: aload 12
    //   2697: invokestatic 1008	anpc:a	(Landroid/content/Context;Ljava/lang/StringBuilder;)V
    //   2700: ldc_w 1010
    //   2703: aload_2
    //   2704: invokevirtual 367	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2707: ifeq +22 -> 2729
    //   2710: aload 4
    //   2712: invokestatic 343	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2715: ifne +14 -> 2729
    //   2718: aload 4
    //   2720: ldc_w 1012
    //   2723: invokevirtual 348	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2726: ifne +32 -> 2758
    //   2729: ldc_w 1014
    //   2732: aload_2
    //   2733: invokevirtual 367	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2736: ifeq +40 -> 2776
    //   2739: aload 4
    //   2741: invokestatic 343	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2744: ifne +32 -> 2776
    //   2747: aload 4
    //   2749: ldc_w 1016
    //   2752: invokevirtual 348	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2755: ifeq +21 -> 2776
    //   2758: aload 12
    //   2760: ldc_w 1018
    //   2763: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2766: ldc_w 1020
    //   2769: invokestatic 1025	aqfo:getSystemProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   2772: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2775: pop
    //   2776: ldc_w 1027
    //   2779: aload_2
    //   2780: invokevirtual 367	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2783: ifne +66 -> 2849
    //   2786: ldc_w 364
    //   2789: aload_2
    //   2790: invokevirtual 367	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2793: ifeq +14 -> 2807
    //   2796: aload 4
    //   2798: ldc_w 1029
    //   2801: invokevirtual 348	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2804: ifne +45 -> 2849
    //   2807: ldc_w 1031
    //   2810: aload_2
    //   2811: invokevirtual 367	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2814: ifeq +14 -> 2828
    //   2817: aload 4
    //   2819: ldc_w 1033
    //   2822: invokevirtual 348	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2825: ifne +24 -> 2849
    //   2828: ldc_w 364
    //   2831: aload_2
    //   2832: invokevirtual 367	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2835: ifeq +94 -> 2929
    //   2838: aload 4
    //   2840: ldc_w 1035
    //   2843: invokevirtual 348	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2846: ifeq +83 -> 2929
    //   2849: invokestatic 292	anpc:access$000	()Ljava/text/SimpleDateFormat;
    //   2852: new 294	java/util/Date
    //   2855: dup
    //   2856: getstatic 1038	anpc:anr	J
    //   2859: invokespecial 297	java/util/Date:<init>	(J)V
    //   2862: invokevirtual 303	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   2865: astore 4
    //   2867: aload 12
    //   2869: ldc_w 1040
    //   2872: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2875: getstatic 1043	anpc:dKS	I
    //   2878: invokevirtual 58	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2881: ldc_w 1045
    //   2884: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2887: aload 4
    //   2889: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2892: pop
    //   2893: aload 12
    //   2895: ldc_w 1047
    //   2898: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2901: pop
    //   2902: aload 12
    //   2904: invokestatic 1050	anpc:ej	()Ljava/lang/String;
    //   2907: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2910: pop
    //   2911: aload 12
    //   2913: ldc_w 1052
    //   2916: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2919: pop
    //   2920: aload 12
    //   2922: invokestatic 1057	com/tencent/mobileqq/statistics/FDStatsHooker:getAllStackTrace	()Ljava/lang/String;
    //   2925: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2928: pop
    //   2929: iconst_1
    //   2930: getstatic 315	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   2933: if_icmpne +49 -> 2982
    //   2936: aload_3
    //   2937: invokestatic 343	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2940: ifne +42 -> 2982
    //   2943: aload_2
    //   2944: invokestatic 343	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2947: ifne +35 -> 2982
    //   2950: aload_2
    //   2951: ldc_w 1059
    //   2954: invokevirtual 348	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2957: ifeq +25 -> 2982
    //   2960: aload_3
    //   2961: ldc_w 1061
    //   2964: invokevirtual 348	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2967: ifeq +15 -> 2982
    //   2970: aload_0
    //   2971: aload 12
    //   2973: invokespecial 1063	anpd:d	(Ljava/lang/StringBuilder;)V
    //   2976: aload_0
    //   2977: aload 12
    //   2979: invokespecial 1065	anpd:c	(Ljava/lang/StringBuilder;)V
    //   2982: ldc 151
    //   2984: iconst_1
    //   2985: new 20	java/lang/StringBuilder
    //   2988: dup
    //   2989: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   2992: ldc_w 1067
    //   2995: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2998: aload 12
    //   3000: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3003: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3006: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3009: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3012: aload 12
    //   3014: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3017: areturn
    //   3018: astore 10
    //   3020: goto -2076 -> 944
    //   3023: astore_3
    //   3024: goto -459 -> 2565
    //   3027: astore 10
    //   3029: goto -253 -> 2776
    //   3032: astore 10
    //   3034: goto -387 -> 2647
    //   3037: astore 10
    //   3039: goto -930 -> 2109
    //   3042: astore 10
    //   3044: goto -996 -> 2048
    //   3047: astore 10
    //   3049: goto -1130 -> 1919
    //   3052: astore_2
    //   3053: aload 10
    //   3055: astore_3
    //   3056: goto -499 -> 2557
    //   3059: astore_2
    //   3060: aload 10
    //   3062: astore_3
    //   3063: goto -506 -> 2557
    //   3066: astore 11
    //   3068: goto -537 -> 2531
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3071	0	this	anpd
    //   0	3071	1	paramBoolean	boolean
    //   0	3071	2	paramString1	String
    //   0	3071	3	paramString2	String
    //   0	3071	4	paramString3	String
    //   0	3071	5	paramInt	int
    //   0	3071	6	paramLong	long
    //   1973	52	8	i	int
    //   1186	1383	9	bool	boolean
    //   360	1350	10	localObject1	Object
    //   1957	1	10	localThrowable1	Throwable
    //   1998	509	10	localObject2	Object
    //   2511	3	10	localThrowable2	Throwable
    //   2525	17	10	localObject3	Object
    //   2549	1	10	localException1	java.lang.Exception
    //   2580	9	10	str1	String
    //   2593	15	10	localThrowable3	Throwable
    //   2618	24	10	str2	String
    //   3018	1	10	localException2	java.lang.Exception
    //   3027	1	10	localThrowable4	Throwable
    //   3032	1	10	localThrowable5	Throwable
    //   3037	1	10	localThrowable6	Throwable
    //   3042	1	10	localThrowable7	Throwable
    //   3047	14	10	localThrowable8	Throwable
    //   351	2181	11	localObject4	Object
    //   3066	1	11	localException3	java.lang.Exception
    //   1056	1384	12	localStringBuilder	StringBuilder
    //   2521	492	12	localException4	java.lang.Exception
    //   998	1293	13	str3	String
    //   1522	65	14	arrayOfLong	long[]
    // Exception table:
    //   from	to	target	type
    //   1919	1954	1957	java/lang/Throwable
    //   672	752	2511	java/lang/Throwable
    //   757	797	2511	java/lang/Throwable
    //   800	812	2521	java/lang/Exception
    //   817	831	2521	java/lang/Exception
    //   831	867	2521	java/lang/Exception
    //   2541	2546	2549	java/lang/Exception
    //   800	812	2554	finally
    //   817	831	2554	finally
    //   831	867	2554	finally
    //   2213	2301	2593	java/lang/Throwable
    //   2301	2306	2593	java/lang/Throwable
    //   2311	2358	2593	java/lang/Throwable
    //   939	944	3018	java/lang/Exception
    //   2561	2565	3023	java/lang/Exception
    //   2647	2700	3027	java/lang/Throwable
    //   2700	2729	3027	java/lang/Throwable
    //   2729	2758	3027	java/lang/Throwable
    //   2758	2776	3027	java/lang/Throwable
    //   2615	2620	3032	java/lang/Throwable
    //   2625	2647	3032	java/lang/Throwable
    //   2048	2109	3037	java/lang/Throwable
    //   1959	1990	3042	java/lang/Throwable
    //   2000	2048	3042	java/lang/Throwable
    //   1058	1172	3047	java/lang/Throwable
    //   1177	1185	3047	java/lang/Throwable
    //   1188	1362	3047	java/lang/Throwable
    //   1362	1420	3047	java/lang/Throwable
    //   1420	1440	3047	java/lang/Throwable
    //   1445	1498	3047	java/lang/Throwable
    //   1498	1538	3047	java/lang/Throwable
    //   1552	1610	3047	java/lang/Throwable
    //   1615	1723	3047	java/lang/Throwable
    //   1723	1752	3047	java/lang/Throwable
    //   1752	1781	3047	java/lang/Throwable
    //   1781	1810	3047	java/lang/Throwable
    //   1810	1899	3047	java/lang/Throwable
    //   1899	1919	3047	java/lang/Throwable
    //   2573	2582	3047	java/lang/Throwable
    //   867	934	3052	finally
    //   2531	2536	3059	finally
    //   867	934	3066	java/lang/Exception
  }
  
  /* Error */
  public boolean onCrashHandleEnd(boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 151
    //   2: iconst_1
    //   3: new 20	java/lang/StringBuilder
    //   6: dup
    //   7: ldc_w 1071
    //   10: invokespecial 273	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   13: iload_1
    //   14: invokevirtual 276	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   17: ldc_w 1073
    //   20: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: invokestatic 1076	anpc:access$100	()Z
    //   26: invokevirtual 276	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   29: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   35: invokestatic 1076	anpc:access$100	()Z
    //   38: ifeq +10 -> 48
    //   41: iconst_0
    //   42: invokestatic 1079	anpc:access$102	(Z)Z
    //   45: pop
    //   46: iconst_1
    //   47: ireturn
    //   48: iload_1
    //   49: ifeq +32 -> 81
    //   52: invokestatic 331	anpc:p	()Landroid/content/Context;
    //   55: ldc 151
    //   57: iconst_4
    //   58: invokevirtual 907	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   61: invokeinterface 1083 1 0
    //   66: ldc_w 1085
    //   69: iconst_1
    //   70: invokeinterface 1091 3 0
    //   75: invokeinterface 1094 1 0
    //   80: pop
    //   81: iload_1
    //   82: ifne +21 -> 103
    //   85: invokestatic 1097	anpc:access$300	()Ljava/lang/String;
    //   88: invokestatic 1100	anpc:access$400	()Ljava/lang/String;
    //   91: invokestatic 1104	anpc:bB	(Ljava/lang/String;Ljava/lang/String;)Z
    //   94: ifeq +9 -> 103
    //   97: iconst_1
    //   98: putstatic 1108	anpc:cJd	Z
    //   101: iconst_1
    //   102: ireturn
    //   103: getstatic 378	com/tencent/common/app/BaseApplicationImpl:processName	Ljava/lang/String;
    //   106: astore_3
    //   107: aload_0
    //   108: getfield 12	anpd:this$0	Lanpc;
    //   111: invokestatic 1110	anpc:g	(Lanpc;)V
    //   114: invokestatic 950	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   117: invokevirtual 1113	com/tencent/common/app/BaseApplicationImpl:closeAllActivitys	()V
    //   120: aload_0
    //   121: getfield 12	anpd:this$0	Lanpc;
    //   124: invokestatic 331	anpc:p	()Landroid/content/Context;
    //   127: aload_3
    //   128: invokestatic 1116	anpc:a	(Lanpc;Landroid/content/Context;Ljava/lang/String;)V
    //   131: aload_3
    //   132: ldc_w 1118
    //   135: invokevirtual 367	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   138: ifeq +17 -> 155
    //   141: aload_0
    //   142: getfield 12	anpd:this$0	Lanpc;
    //   145: invokevirtual 1121	anpc:dSK	()V
    //   148: aload_0
    //   149: getfield 12	anpd:this$0	Lanpc;
    //   152: invokevirtual 1124	anpc:dSL	()V
    //   155: aload_3
    //   156: ldc_w 594
    //   159: invokevirtual 384	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   162: ifne +23 -> 185
    //   165: aload_3
    //   166: ldc_w 380
    //   169: invokevirtual 384	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   172: ifne +13 -> 185
    //   175: aload_3
    //   176: ldc_w 1126
    //   179: invokevirtual 384	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   182: ifeq +18 -> 200
    //   185: aload_0
    //   186: getfield 12	anpd:this$0	Lanpc;
    //   189: invokevirtual 1121	anpc:dSK	()V
    //   192: aload_0
    //   193: getfield 12	anpd:this$0	Lanpc;
    //   196: aload_3
    //   197: invokevirtual 1129	anpc:Ra	(Ljava/lang/String;)V
    //   200: aload_3
    //   201: ldc_w 594
    //   204: invokevirtual 384	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   207: ifne +43 -> 250
    //   210: aload_3
    //   211: ldc_w 380
    //   214: invokevirtual 384	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   217: ifne +33 -> 250
    //   220: aload_3
    //   221: ldc_w 1126
    //   224: invokevirtual 384	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   227: ifne +23 -> 250
    //   230: aload_3
    //   231: ldc_w 1131
    //   234: invokevirtual 384	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   237: ifne +13 -> 250
    //   240: aload_3
    //   241: ldc_w 596
    //   244: invokevirtual 384	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   247: ifeq +88 -> 335
    //   250: ldc_w 1133
    //   253: iconst_0
    //   254: invokestatic 1139	cooperation/qzone/LocalMultiProcConfig:getBool	(Ljava/lang/String;Z)Z
    //   257: ifeq +78 -> 335
    //   260: ldc 151
    //   262: iconst_1
    //   263: new 20	java/lang/StringBuilder
    //   266: dup
    //   267: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   270: ldc_w 1141
    //   273: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: invokestatic 321	java/lang/System:currentTimeMillis	()J
    //   279: ldc2_w 1142
    //   282: ldiv
    //   283: invokevirtual 560	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   286: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   289: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   292: new 20	java/lang/StringBuilder
    //   295: dup
    //   296: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   299: ldc_w 1145
    //   302: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: aload_0
    //   306: getfield 12	anpd:this$0	Lanpc;
    //   309: getfield 424	anpc:mCurUin	Ljava/lang/String;
    //   312: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   318: invokestatic 321	java/lang/System:currentTimeMillis	()J
    //   321: ldc2_w 1142
    //   324: ldiv
    //   325: invokestatic 1149	cooperation/qzone/LocalMultiProcConfig:putLong	(Ljava/lang/String;J)V
    //   328: ldc_w 1133
    //   331: iconst_0
    //   332: invokestatic 1153	cooperation/qzone/LocalMultiProcConfig:putBool	(Ljava/lang/String;Z)V
    //   335: invokestatic 950	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   338: invokevirtual 1156	com/tencent/common/app/BaseApplicationImpl:crashed	()V
    //   341: aload_3
    //   342: ldc_w 1118
    //   345: invokevirtual 367	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   348: ifeq +362 -> 710
    //   351: new 463	android/content/Intent
    //   354: dup
    //   355: ldc_w 1158
    //   358: invokespecial 1159	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   361: astore 4
    //   363: invokestatic 331	anpc:p	()Landroid/content/Context;
    //   366: ldc_w 1161
    //   369: invokevirtual 1165	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   372: checkcast 1167	android/app/ActivityManager
    //   375: invokevirtual 1171	android/app/ActivityManager:getRunningAppProcesses	()Ljava/util/List;
    //   378: astore 6
    //   380: new 459	java/util/ArrayList
    //   383: dup
    //   384: invokespecial 1172	java/util/ArrayList:<init>	()V
    //   387: astore 5
    //   389: aload 6
    //   391: ifnull +282 -> 673
    //   394: aload 6
    //   396: invokeinterface 1173 1 0
    //   401: ifle +272 -> 673
    //   404: aload 6
    //   406: invokeinterface 260 1 0
    //   411: astore 6
    //   413: aload 6
    //   415: invokeinterface 190 1 0
    //   420: ifeq +253 -> 673
    //   423: aload 6
    //   425: invokeinterface 193 1 0
    //   430: checkcast 1175	android/app/ActivityManager$RunningAppProcessInfo
    //   433: getfield 1176	android/app/ActivityManager$RunningAppProcessInfo:processName	Ljava/lang/String;
    //   436: astore 7
    //   438: aload 7
    //   440: ifnull -27 -> 413
    //   443: aload 7
    //   445: ldc_w 1178
    //   448: invokevirtual 1181	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   451: ifeq -38 -> 413
    //   454: aload 7
    //   456: ldc_w 1183
    //   459: invokevirtual 384	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   462: ifne -49 -> 413
    //   465: aload 5
    //   467: aload 7
    //   469: invokevirtual 1186	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   472: pop
    //   473: goto -60 -> 413
    //   476: astore 4
    //   478: aload 4
    //   480: invokevirtual 984	java/lang/Throwable:printStackTrace	()V
    //   483: aload_3
    //   484: ldc_w 1118
    //   487: invokevirtual 367	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   490: ifeq +395 -> 885
    //   493: aload_0
    //   494: getfield 12	anpd:this$0	Lanpc;
    //   497: getfield 1189	anpc:cJa	Z
    //   500: ifeq +376 -> 876
    //   503: ldc 151
    //   505: iconst_1
    //   506: new 20	java/lang/StringBuilder
    //   509: dup
    //   510: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   513: ldc_w 1191
    //   516: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   519: aload_0
    //   520: getfield 12	anpd:this$0	Lanpc;
    //   523: getfield 1189	anpc:cJa	Z
    //   526: invokevirtual 276	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   529: ldc_w 1193
    //   532: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   535: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   538: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   541: invokestatic 331	anpc:p	()Landroid/content/Context;
    //   544: ldc_w 1161
    //   547: invokevirtual 1165	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   550: checkcast 1167	android/app/ActivityManager
    //   553: invokevirtual 1171	android/app/ActivityManager:getRunningAppProcesses	()Ljava/util/List;
    //   556: astore_3
    //   557: aload_3
    //   558: ifnull +260 -> 818
    //   561: aload_3
    //   562: invokeinterface 1173 1 0
    //   567: ifle +251 -> 818
    //   570: aload_3
    //   571: invokeinterface 260 1 0
    //   576: astore_3
    //   577: aload_3
    //   578: invokeinterface 190 1 0
    //   583: ifeq +235 -> 818
    //   586: aload_3
    //   587: invokeinterface 193 1 0
    //   592: checkcast 1175	android/app/ActivityManager$RunningAppProcessInfo
    //   595: astore 4
    //   597: aload 4
    //   599: getfield 1176	android/app/ActivityManager$RunningAppProcessInfo:processName	Ljava/lang/String;
    //   602: astore 5
    //   604: aload 5
    //   606: ifnull -29 -> 577
    //   609: aload 5
    //   611: ldc_w 1178
    //   614: invokevirtual 1181	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   617: ifeq -40 -> 577
    //   620: aload 5
    //   622: ldc_w 1183
    //   625: invokevirtual 384	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   628: ifne -51 -> 577
    //   631: aload 4
    //   633: getfield 1196	android/app/ActivityManager$RunningAppProcessInfo:pid	I
    //   636: invokestatic 1201	android/os/Process:killProcess	(I)V
    //   639: goto -62 -> 577
    //   642: astore_3
    //   643: aload_3
    //   644: invokevirtual 984	java/lang/Throwable:printStackTrace	()V
    //   647: iconst_1
    //   648: ireturn
    //   649: astore 4
    //   651: aload 4
    //   653: invokevirtual 984	java/lang/Throwable:printStackTrace	()V
    //   656: goto -525 -> 131
    //   659: astore 4
    //   661: ldc 151
    //   663: iconst_1
    //   664: ldc_w 1203
    //   667: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   670: goto -335 -> 335
    //   673: aload 4
    //   675: ldc_w 1205
    //   678: aload 5
    //   680: invokevirtual 1209	android/content/Intent:putStringArrayListExtra	(Ljava/lang/String;Ljava/util/ArrayList;)Landroid/content/Intent;
    //   683: pop
    //   684: aload 4
    //   686: ldc_w 1211
    //   689: aload 5
    //   691: iconst_0
    //   692: invokestatic 1215	com/tencent/common/app/BaseApplicationImpl:getLocalVerify	(Ljava/util/ArrayList;Z)Ljava/lang/String;
    //   695: invokevirtual 1219	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   698: pop
    //   699: invokestatic 331	anpc:p	()Landroid/content/Context;
    //   702: aload 4
    //   704: invokevirtual 488	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   707: goto -224 -> 483
    //   710: aload_3
    //   711: ldc_w 594
    //   714: invokevirtual 384	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   717: ifeq +72 -> 789
    //   720: invokestatic 331	anpc:p	()Landroid/content/Context;
    //   723: ldc_w 1161
    //   726: invokevirtual 1165	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   729: checkcast 1167	android/app/ActivityManager
    //   732: invokevirtual 1171	android/app/ActivityManager:getRunningAppProcesses	()Ljava/util/List;
    //   735: invokeinterface 260 1 0
    //   740: astore 4
    //   742: aload 4
    //   744: invokeinterface 190 1 0
    //   749: ifeq -266 -> 483
    //   752: aload 4
    //   754: invokeinterface 193 1 0
    //   759: checkcast 1175	android/app/ActivityManager$RunningAppProcessInfo
    //   762: astore 5
    //   764: aload 5
    //   766: getfield 1176	android/app/ActivityManager$RunningAppProcessInfo:processName	Ljava/lang/String;
    //   769: ldc_w 1221
    //   772: invokevirtual 367	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   775: ifeq -33 -> 742
    //   778: aload 5
    //   780: getfield 1196	android/app/ActivityManager$RunningAppProcessInfo:pid	I
    //   783: invokestatic 1201	android/os/Process:killProcess	(I)V
    //   786: goto -44 -> 742
    //   789: aload_3
    //   790: ldc_w 1223
    //   793: invokevirtual 384	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   796: ifne -313 -> 483
    //   799: aload_3
    //   800: ldc_w 1225
    //   803: invokevirtual 384	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   806: ifeq -323 -> 483
    //   809: invokestatic 331	anpc:p	()Landroid/content/Context;
    //   812: invokestatic 1230	com/tencent/tmdownloader/TMAssistantDownloadManager:closeAllService	(Landroid/content/Context;)V
    //   815: goto -332 -> 483
    //   818: invokestatic 331	anpc:p	()Landroid/content/Context;
    //   821: ldc_w 1232
    //   824: iconst_0
    //   825: invokevirtual 907	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   828: astore_3
    //   829: aload_3
    //   830: ldc_w 1234
    //   833: iconst_0
    //   834: invokeinterface 1238 3 0
    //   839: istore_2
    //   840: aload_3
    //   841: invokeinterface 1083 1 0
    //   846: ldc_w 1234
    //   849: iload_2
    //   850: iconst_1
    //   851: iadd
    //   852: invokeinterface 1242 3 0
    //   857: invokeinterface 1094 1 0
    //   862: pop
    //   863: invokestatic 950	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   866: iconst_1
    //   867: invokevirtual 1245	com/tencent/common/app/BaseApplicationImpl:stopMsfOnCrash	(Z)V
    //   870: invokestatic 1248	android/os/Process:myPid	()I
    //   873: invokestatic 1201	android/os/Process:killProcess	(I)V
    //   876: invokestatic 950	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   879: iconst_1
    //   880: invokevirtual 1251	com/tencent/common/app/BaseApplicationImpl:QQProcessExit	(Z)V
    //   883: iconst_1
    //   884: ireturn
    //   885: aload_3
    //   886: ldc_w 594
    //   889: invokevirtual 384	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   892: ifne +45 -> 937
    //   895: aload_3
    //   896: ldc_w 1253
    //   899: invokevirtual 384	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   902: ifne +35 -> 937
    //   905: aload_3
    //   906: ldc_w 1223
    //   909: invokevirtual 384	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   912: ifne +25 -> 937
    //   915: aload_3
    //   916: ldc_w 921
    //   919: invokevirtual 348	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   922: ifeq +6 -> 928
    //   925: goto +12 -> 937
    //   928: invokestatic 950	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   931: iconst_0
    //   932: invokevirtual 1256	com/tencent/common/app/BaseApplicationImpl:otherProcessExit	(Z)V
    //   935: iconst_1
    //   936: ireturn
    //   937: iload_1
    //   938: ifeq -892 -> 46
    //   941: goto -13 -> 928
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	944	0	this	anpd
    //   0	944	1	paramBoolean	boolean
    //   839	13	2	i	int
    //   106	481	3	localObject1	Object
    //   642	158	3	localThrowable1	Throwable
    //   828	88	3	localSharedPreferences	android.content.SharedPreferences
    //   361	1	4	localIntent	android.content.Intent
    //   476	3	4	localThrowable2	Throwable
    //   595	37	4	localRunningAppProcessInfo	android.app.ActivityManager.RunningAppProcessInfo
    //   649	3	4	localThrowable3	Throwable
    //   659	44	4	localThrowable4	Throwable
    //   740	13	4	localIterator	Iterator
    //   387	392	5	localObject2	Object
    //   378	46	6	localObject3	Object
    //   436	32	7	str	String
    // Exception table:
    //   from	to	target	type
    //   335	389	476	java/lang/Throwable
    //   394	413	476	java/lang/Throwable
    //   413	438	476	java/lang/Throwable
    //   443	473	476	java/lang/Throwable
    //   673	707	476	java/lang/Throwable
    //   710	742	476	java/lang/Throwable
    //   742	786	476	java/lang/Throwable
    //   789	815	476	java/lang/Throwable
    //   483	557	642	java/lang/Throwable
    //   561	577	642	java/lang/Throwable
    //   577	604	642	java/lang/Throwable
    //   609	639	642	java/lang/Throwable
    //   818	876	642	java/lang/Throwable
    //   876	883	642	java/lang/Throwable
    //   885	925	642	java/lang/Throwable
    //   928	935	642	java/lang/Throwable
    //   107	131	649	java/lang/Throwable
    //   131	155	659	java/lang/Throwable
    //   155	185	659	java/lang/Throwable
    //   185	200	659	java/lang/Throwable
    //   200	250	659	java/lang/Throwable
    //   250	335	659	java/lang/Throwable
  }
  
  public void onCrashHandleStart(boolean paramBoolean)
  {
    QLog.d("StatisticCollector", 1, "onCrashHandleStart isNativeCrashed=" + paramBoolean + ", sHasCrashed=" + anpc.access$200() + ", sIsFinalizeTimeoutException=" + anpc.access$100());
    if ((anpc.access$200()) && (!anpc.access$100()) && (!anpc.bB(anpc.access$300(), anpc.access$400()))) {
      Process.killProcess(Process.myPid());
    }
    for (;;)
    {
      SharedPreferencesProxyManager.getInstance().onCrashStart();
      try
      {
        StringBuilder localStringBuilder1 = new StringBuilder(128);
        String str1 = "topActivity:" + aciz.rH();
        StringBuilder localStringBuilder2 = new StringBuilder(128);
        int j = anpc.a(this.this$0).size();
        int i = Math.min(j, 5);
        for (;;)
        {
          if (i > 0)
          {
            String str2 = (String)anpc.a(this.this$0).pop();
            if (localStringBuilder2.length() > 0) {
              localStringBuilder2.append("\n--->");
            }
            localStringBuilder2.append(str2);
            i -= 1;
            continue;
            anpc.access$202(true);
            break;
          }
        }
        anpc.a(this.this$0).clear();
        localStringBuilder1.append(str1).append("\n");
        localStringBuilder1.append("ActivityInfoStack:size=").append(j).append(",top five were:↓\n--->");
        localStringBuilder1.append(localStringBuilder2).append("\n");
        localStringBuilder1.append("Current mapEvent content is:\n");
        localStringBuilder1.append(anpc.a(this.this$0).toString());
        anpc.a(this.this$0, localStringBuilder1.toString());
        anpc.a(this.this$0).append("Current thread Id=").append(Process.myTid()).append(", Name=").append(Thread.currentThread().getName()).append("\n");
        return;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
    }
  }
  
  public boolean onCrashSaving(boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt, long paramLong, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    QLog.d("StatisticCollector", 1, "onCrashSaving isNativeCrashed=" + paramBoolean + ", crashType=" + paramString1 + ", crashAddress=" + paramString2 + ", crashTime=" + anpc.access$000().format(new Date(paramLong)) + ", curTime=" + anpc.access$000().format(new Date(System.currentTimeMillis())));
    if ((!paramBoolean) && ("java.util.concurrent.TimeoutException".equals(paramString1)) && (!TextUtils.isEmpty(paramString3)) && (paramString3.contains("java.lang.Daemons$FinalizerDaemon"))) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      anpc.access$102(paramBoolean);
      if (!anpc.access$100()) {
        break;
      }
      return false;
    }
    if ((22 == Build.VERSION.SDK_INT) && ("vivo".equalsIgnoreCase(Build.BRAND)) && ("android.app.RemoteServiceException".equalsIgnoreCase(paramString1)) && (!TextUtils.isEmpty(paramString3)) && (paramString3.contains("android.app.ActivityThread$H.handleMessage"))) {
      return false;
    }
    WebpSoLoader.Uy(paramString3);
    aqdr.Uq(paramString3);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     anpd
 * JD-Core Version:    0.7.0.1
 */