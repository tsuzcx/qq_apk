import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.pool.RecyclablePool;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Stack;

public class anql
{
  private static volatile anql jdField_a_of_type_Anql;
  private static HandlerThread aa;
  private static volatile Handler du;
  public static final String[] hb = { "sdcard/Tencent/Tim", "sdcard/Tencent/Tim_Images", "sdcard/Tencent/TIMfile_recv", "sdcard/Tencent/QQ_Collection", "sdcard/Tencent/TIM_Favorite", "sdcard/Tencent/QQ_Video", "sdcard/Tencent/QQfile_share", "sdcard/Tencent/QQHomework_recv", "sdcard/Tencent/QQHomework_attach", "sdcard/Tencent/AIO_FORWARD", "sdcard/Tencent/QQ_business", "sdcard/Tencent/msflogs" };
  public static final String[] hc = { "data/data/com.tencent.mobileqq", "data/data/com.tencent.mobileqq/files" };
  private static final RecyclablePool sPool = new RecyclablePool(anqk.class, 50);
  private ArrayList<anqk> AL = new ArrayList(20);
  private ArrayList<anqk> AM = new ArrayList(40);
  private ArrayList<anqk> AN = new ArrayList(7);
  private ArrayList<anqk> AO = new ArrayList(7);
  private anql.a jdField_a_of_type_Anql$a = new anql.a(null);
  private anql.b jdField_a_of_type_Anql$b = new anql.b(null);
  private long anT;
  private boolean cJq;
  private String cgP = "";
  private boolean mNeedReport = true;
  private Field jdField_s_of_type_JavaLangReflectField;
  private Method jdField_s_of_type_JavaLangReflectMethod;
  private Field t;
  
  private anql()
  {
    if (0.001000000047497451D >= Math.random()) {}
    for (;;)
    {
      this.mNeedReport = bool;
      return;
      bool = false;
    }
  }
  
  public static anql a()
  {
    if (jdField_a_of_type_Anql == null) {}
    try
    {
      if (jdField_a_of_type_Anql == null) {
        jdField_a_of_type_Anql = new anql();
      }
      return jdField_a_of_type_Anql;
    }
    finally {}
  }
  
  private void a(anqk paramanqk)
  {
    if (!this.mNeedReport) {
      return;
    }
    HashMap localHashMap = new HashMap(20);
    localHashMap.put("report_key", this.cgP);
    localHashMap.put("path", paramanqk.path);
    localHashMap.put("name", paramanqk.name);
    localHashMap.put("size", String.valueOf(paramanqk.size));
    localHashMap.put("accessTime", String.valueOf(paramanqk.accessTime));
    localHashMap.put("isFile", String.valueOf(paramanqk.isFile));
    localHashMap.put("fileCount", String.valueOf(paramanqk.anR));
    localHashMap.put("dirCount", String.valueOf(paramanqk.anS));
    if (QLog.isColorLevel()) {
      QLog.d("StorageReport", 2, "--scan qq-- file report to tdw : report key = " + this.cgP + ",item info=" + paramanqk.toString());
    }
    anpc.a(BaseApplicationImpl.getApplication()).collectPerformance(null, "qqStorageReport", true, 0L, 0L, localHashMap, null);
  }
  
  private void a(anqk paramanqk, long paramLong)
  {
    int i = 0;
    if ((paramanqk == null) || (TextUtils.isEmpty(paramanqk.path))) {
      return;
    }
    if (paramLong < 10240L) {
      if (!paramanqk.path.contains("data/data/com.tencent.mobileqq")) {
        break label197;
      }
    }
    label197:
    for (paramanqk = (anqk)this.AO.get(i);; paramanqk = (anqk)this.AN.get(i))
    {
      paramanqk.size += paramLong;
      paramanqk.anR += 1L;
      return;
      if ((paramLong >= 10240L) && (paramLong < 102400L))
      {
        i = 1;
        break;
      }
      if ((paramLong >= 102400L) && (paramLong < 1048576L))
      {
        i = 2;
        break;
      }
      if ((paramLong >= 1048576L) && (paramLong < 2097152L))
      {
        i = 3;
        break;
      }
      if ((paramLong >= 2097152L) && (paramLong < 10485760L))
      {
        i = 4;
        break;
      }
      if ((paramLong >= 10485760L) && (paramLong < 104857600L))
      {
        i = 5;
        break;
      }
      if (paramLong < 104857600L) {
        break;
      }
      i = 6;
      break;
    }
  }
  
  public static void dTd()
  {
    try
    {
      if (du != null)
      {
        du.removeCallbacks(null);
        du = null;
      }
      if (aa != null)
      {
        aa.quit();
        aa = null;
      }
      return;
    }
    finally {}
  }
  
  private long f(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    File localFile;
    do
    {
      return 0L;
      localFile = new File(paramString1 + "/" + paramString2);
    } while (localFile.isDirectory());
    anqk localanqk = (anqk)sPool.obtain(anqk.class);
    localanqk.name = paramString2;
    localanqk.isFile = true;
    localanqk.size = localFile.length();
    localanqk.path = (paramString1 + "/" + paramString2);
    localanqk.accessTime = c(localFile);
    localanqk.anR = 1L;
    if (localanqk.size >= 524288.0D) {
      QLog.d("StorageReport", 1, "--scan qq-- file info: " + localanqk.toString());
    }
    if (localanqk.size >= 2097152L) {
      a(localanqk);
    }
    a(localanqk, localanqk.size);
    if (this.AL.size() < 20)
    {
      this.AL.add(localanqk);
      if (this.AL.size() == 20) {
        Collections.sort(this.AL, this.jdField_a_of_type_Anql$a);
      }
      return localanqk.size;
    }
    paramString1 = (anqk)this.AL.get(this.AL.size() - 1);
    if ((this.AL.size() >= 20) && (localanqk.accessTime > paramString1.accessTime))
    {
      this.AL.remove(this.AL.size() - 1);
      sPool.recycle(paramString1);
      this.AL.add(localanqk);
      Collections.sort(this.AL, this.jdField_a_of_type_Anql$a);
      return localanqk.size;
    }
    sPool.recycle(localanqk);
    return localanqk.size;
  }
  
  private Bundle g(String paramString)
  {
    Bundle localBundle = new Bundle();
    Stack localStack = new Stack();
    localStack.push(paramString);
    long l1 = 0L;
    long l2 = 0L;
    long l3 = 0L;
    if (!localStack.isEmpty())
    {
      paramString = new File((String)localStack.pop());
      long l4;
      if (paramString.isDirectory())
      {
        String[] arrayOfString = paramString.list();
        long l5;
        if (arrayOfString != null)
        {
          int j = arrayOfString.length;
          int i = 0;
          l4 = l1;
          l5 = l2;
          l1 = l4;
          if (i < j)
          {
            String str = arrayOfString[i];
            File localFile = new File(paramString, str);
            if (localFile.isDirectory()) {
              localStack.push(localFile.getAbsolutePath());
            }
            for (;;)
            {
              i += 1;
              break;
              f(paramString.getAbsolutePath(), str);
              l4 += localFile.length();
              l2 += 1L;
            }
          }
        }
        else
        {
          l5 = l2;
        }
        l2 = l5;
        l3 += 1L;
        l4 = l1;
        l1 = l3;
      }
      for (;;)
      {
        l4 += paramString.length();
        l3 = l1;
        l1 = l4;
        break;
        f(paramString.getParent(), paramString.getName());
        l4 = l1;
        l1 = l3;
        l2 = 1L + l2;
      }
    }
    localBundle.putLong("key_size", l1);
    localBundle.putLong("key_file_count", l2);
    localBundle.putLong("key_dir_count", l3);
    return localBundle;
  }
  
  private String t(ArrayList<anqk> paramArrayList)
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    int i = 0;
    while (i < paramArrayList.size())
    {
      anqk localanqk = (anqk)paramArrayList.get(i);
      localStringBuilder.append(localanqk.anR);
      localStringBuilder.append("-").append(localanqk.size);
      if (i < paramArrayList.size() - 1) {
        localStringBuilder.append("|");
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static Handler y()
  {
    try
    {
      if (du == null)
      {
        aa = new HandlerThread("SETTING_STORAGE_CLEAN_SCAN", 0);
        aa.start();
        du = new Handler(aa.getLooper());
      }
      Handler localHandler = du;
      return localHandler;
    }
    finally {}
  }
  
  public void Qm(boolean paramBoolean)
  {
    this.cJq = paramBoolean;
  }
  
  /* Error */
  public long a(com.tencent.mobileqq.activity.QQSettingCleanActivity.a parama, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +10 -> 13
    //   6: aload_1
    //   7: iload_2
    //   8: invokeinterface 401 2 0
    //   13: lconst_0
    //   14: lstore 54
    //   16: aload_0
    //   17: invokestatic 406	java/lang/System:currentTimeMillis	()J
    //   20: ldc2_w 407
    //   23: ldiv
    //   24: putfield 410	anql:anT	J
    //   27: invokestatic 208	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   30: invokevirtual 414	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   33: checkcast 416	com/tencent/mobileqq/app/QQAppInterface
    //   36: astore 64
    //   38: aload 64
    //   40: ifnull +12 -> 52
    //   43: aload_0
    //   44: aload 64
    //   46: invokevirtual 419	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   49: putfield 111	anql:cgP	Ljava/lang/String;
    //   52: aload_0
    //   53: new 184	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   60: aload_0
    //   61: getfield 111	anql:cgP	Ljava/lang/String;
    //   64: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: ldc_w 421
    //   70: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: aload_0
    //   74: getfield 410	anql:anT	J
    //   77: invokestatic 153	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   80: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: putfield 111	anql:cgP	Ljava/lang/String;
    //   89: invokestatic 208	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   92: ldc_w 423
    //   95: iconst_0
    //   96: invokevirtual 427	com/tencent/common/app/BaseApplicationImpl:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   99: astore 64
    //   101: aload 64
    //   103: ldc_w 429
    //   106: lconst_0
    //   107: invokeinterface 435 4 0
    //   112: lstore 6
    //   114: aload_0
    //   115: getfield 107	anql:mNeedReport	Z
    //   118: ifeq +41 -> 159
    //   121: lload 6
    //   123: lconst_0
    //   124: lcmp
    //   125: ifle +34 -> 159
    //   128: aload_0
    //   129: getfield 410	anql:anT	J
    //   132: lload 6
    //   134: lsub
    //   135: invokestatic 439	java/lang/Math:abs	(J)J
    //   138: ldc2_w 440
    //   141: lcmp
    //   142: ifge +17 -> 159
    //   145: aload_0
    //   146: iconst_0
    //   147: putfield 107	anql:mNeedReport	Z
    //   150: ldc 182
    //   152: iconst_2
    //   153: ldc_w 443
    //   156: invokestatic 202	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   159: aload_0
    //   160: getfield 97	anql:AM	Ljava/util/ArrayList;
    //   163: invokevirtual 446	java/util/ArrayList:clear	()V
    //   166: aload_0
    //   167: getfield 95	anql:AL	Ljava/util/ArrayList;
    //   170: invokevirtual 446	java/util/ArrayList:clear	()V
    //   173: aload_0
    //   174: getfield 113	anql:AN	Ljava/util/ArrayList;
    //   177: invokevirtual 446	java/util/ArrayList:clear	()V
    //   180: aload_0
    //   181: getfield 115	anql:AO	Ljava/util/ArrayList;
    //   184: invokevirtual 446	java/util/ArrayList:clear	()V
    //   187: iconst_0
    //   188: istore_2
    //   189: iload_2
    //   190: bipush 7
    //   192: if_icmpge +80 -> 272
    //   195: getstatic 51	anql:sPool	Lcom/tencent/commonsdk/pool/RecyclablePool;
    //   198: ldc 45
    //   200: invokevirtual 277	com/tencent/commonsdk/pool/RecyclablePool:obtain	(Ljava/lang/Class;)Lcom/tencent/commonsdk/pool/RecyclablePool$Recyclable;
    //   203: checkcast 45	anqk
    //   206: astore 65
    //   208: aload 65
    //   210: lconst_0
    //   211: putfield 149	anqk:size	J
    //   214: aload 65
    //   216: lconst_0
    //   217: putfield 169	anqk:anR	J
    //   220: aload_0
    //   221: getfield 113	anql:AN	Ljava/util/ArrayList;
    //   224: aload 65
    //   226: invokevirtual 300	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   229: pop
    //   230: getstatic 51	anql:sPool	Lcom/tencent/commonsdk/pool/RecyclablePool;
    //   233: ldc 45
    //   235: invokevirtual 277	com/tencent/commonsdk/pool/RecyclablePool:obtain	(Ljava/lang/Class;)Lcom/tencent/commonsdk/pool/RecyclablePool$Recyclable;
    //   238: checkcast 45	anqk
    //   241: astore 65
    //   243: aload 65
    //   245: lconst_0
    //   246: putfield 149	anqk:size	J
    //   249: aload 65
    //   251: lconst_0
    //   252: putfield 169	anqk:anR	J
    //   255: aload_0
    //   256: getfield 115	anql:AO	Ljava/util/ArrayList;
    //   259: aload 65
    //   261: invokevirtual 300	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   264: pop
    //   265: iload_2
    //   266: iconst_1
    //   267: iadd
    //   268: istore_2
    //   269: goto -80 -> 189
    //   272: new 265	java/io/File
    //   275: dup
    //   276: getstatic 79	anql:hb	[Ljava/lang/String;
    //   279: iconst_0
    //   280: aaload
    //   281: invokespecial 270	java/io/File:<init>	(Ljava/lang/String;)V
    //   284: invokevirtual 335	java/io/File:list	()[Ljava/lang/String;
    //   287: astore 65
    //   289: aload 65
    //   291: ifnull +2736 -> 3027
    //   294: aload 65
    //   296: arraylength
    //   297: ifle +2730 -> 3027
    //   300: lconst_0
    //   301: lstore 10
    //   303: lconst_0
    //   304: lstore 12
    //   306: iconst_0
    //   307: istore_2
    //   308: lload 10
    //   310: lstore 8
    //   312: lload 12
    //   314: lstore 6
    //   316: iload_2
    //   317: aload 65
    //   319: arraylength
    //   320: if_icmpge +2713 -> 3033
    //   323: new 265	java/io/File
    //   326: dup
    //   327: new 184	java/lang/StringBuilder
    //   330: dup
    //   331: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   334: getstatic 79	anql:hb	[Ljava/lang/String;
    //   337: iconst_0
    //   338: aaload
    //   339: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: ldc_w 267
    //   345: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: aload 65
    //   350: iload_2
    //   351: aaload
    //   352: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   358: invokespecial 270	java/io/File:<init>	(Ljava/lang/String;)V
    //   361: astore 66
    //   363: aload 66
    //   365: invokevirtual 273	java/io/File:isDirectory	()Z
    //   368: ifeq +99 -> 467
    //   371: new 45	anqk
    //   374: dup
    //   375: invokespecial 447	anqk:<init>	()V
    //   378: astore 67
    //   380: aload 67
    //   382: iconst_0
    //   383: putfield 161	anqk:isFile	Z
    //   386: aload 67
    //   388: aload_0
    //   389: aload 66
    //   391: invokevirtual 285	anql:c	(Ljava/io/File;)J
    //   394: putfield 157	anqk:accessTime	J
    //   397: aload 67
    //   399: aload 65
    //   401: iload_2
    //   402: aaload
    //   403: putfield 145	anqk:name	Ljava/lang/String;
    //   406: aload 67
    //   408: new 184	java/lang/StringBuilder
    //   411: dup
    //   412: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   415: getstatic 79	anql:hb	[Ljava/lang/String;
    //   418: iconst_0
    //   419: aaload
    //   420: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: ldc_w 267
    //   426: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   429: aload 65
    //   431: iload_2
    //   432: aaload
    //   433: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   436: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   439: putfield 141	anqk:path	Ljava/lang/String;
    //   442: aload 67
    //   444: lconst_0
    //   445: putfield 169	anqk:anR	J
    //   448: aload 67
    //   450: lconst_0
    //   451: putfield 174	anqk:anS	J
    //   454: aload_0
    //   455: getfield 97	anql:AM	Ljava/util/ArrayList;
    //   458: aload 67
    //   460: invokevirtual 300	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   463: pop
    //   464: goto +2556 -> 3020
    //   467: lload 12
    //   469: aload_0
    //   470: getstatic 79	anql:hb	[Ljava/lang/String;
    //   473: iconst_0
    //   474: aaload
    //   475: aload 65
    //   477: iload_2
    //   478: aaload
    //   479: invokespecial 343	anql:f	(Ljava/lang/String;Ljava/lang/String;)J
    //   482: ladd
    //   483: lstore 12
    //   485: lload 10
    //   487: lconst_1
    //   488: ladd
    //   489: lstore 10
    //   491: goto +2529 -> 3020
    //   494: iload_2
    //   495: getstatic 79	anql:hb	[Ljava/lang/String;
    //   498: arraylength
    //   499: if_icmpge +2546 -> 3045
    //   502: getstatic 79	anql:hb	[Ljava/lang/String;
    //   505: iload_2
    //   506: aaload
    //   507: astore 65
    //   509: new 265	java/io/File
    //   512: dup
    //   513: aload 65
    //   515: invokespecial 270	java/io/File:<init>	(Ljava/lang/String;)V
    //   518: astore 66
    //   520: aload 66
    //   522: invokevirtual 273	java/io/File:isDirectory	()Z
    //   525: ifeq +2513 -> 3038
    //   528: new 45	anqk
    //   531: dup
    //   532: invokespecial 447	anqk:<init>	()V
    //   535: astore 67
    //   537: aload 67
    //   539: iconst_0
    //   540: putfield 161	anqk:isFile	Z
    //   543: aload 67
    //   545: aload_0
    //   546: aload 66
    //   548: invokevirtual 285	anql:c	(Ljava/io/File;)J
    //   551: putfield 157	anqk:accessTime	J
    //   554: aload 67
    //   556: aload 65
    //   558: ldc_w 267
    //   561: invokevirtual 451	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   564: iconst_2
    //   565: aaload
    //   566: putfield 145	anqk:name	Ljava/lang/String;
    //   569: aload 67
    //   571: aload 65
    //   573: putfield 141	anqk:path	Ljava/lang/String;
    //   576: aload 67
    //   578: lconst_0
    //   579: putfield 169	anqk:anR	J
    //   582: aload 67
    //   584: lconst_0
    //   585: putfield 174	anqk:anS	J
    //   588: aload_0
    //   589: getfield 97	anql:AM	Ljava/util/ArrayList;
    //   592: aload 67
    //   594: invokevirtual 300	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   597: pop
    //   598: goto +2440 -> 3038
    //   601: iload_2
    //   602: getstatic 85	anql:hc	[Ljava/lang/String;
    //   605: arraylength
    //   606: if_icmpge +277 -> 883
    //   609: getstatic 85	anql:hc	[Ljava/lang/String;
    //   612: iload_2
    //   613: aaload
    //   614: astore 65
    //   616: new 265	java/io/File
    //   619: dup
    //   620: aload 65
    //   622: invokespecial 270	java/io/File:<init>	(Ljava/lang/String;)V
    //   625: invokevirtual 335	java/io/File:list	()[Ljava/lang/String;
    //   628: astore 66
    //   630: aload 66
    //   632: ifnull +2427 -> 3059
    //   635: aload 66
    //   637: arraylength
    //   638: ifle +2421 -> 3059
    //   641: iconst_0
    //   642: istore 4
    //   644: iload 4
    //   646: aload 66
    //   648: arraylength
    //   649: if_icmpge +2410 -> 3059
    //   652: new 265	java/io/File
    //   655: dup
    //   656: new 184	java/lang/StringBuilder
    //   659: dup
    //   660: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   663: aload 65
    //   665: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   668: ldc_w 267
    //   671: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   674: aload 66
    //   676: iload 4
    //   678: aaload
    //   679: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   682: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   685: invokespecial 270	java/io/File:<init>	(Ljava/lang/String;)V
    //   688: astore 67
    //   690: ldc 83
    //   692: new 184	java/lang/StringBuilder
    //   695: dup
    //   696: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   699: aload 65
    //   701: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   704: ldc_w 267
    //   707: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   710: aload 66
    //   712: iload 4
    //   714: aaload
    //   715: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   718: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   721: invokevirtual 454	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   724: ifeq +36 -> 760
    //   727: ldc 182
    //   729: iconst_2
    //   730: new 184	java/lang/StringBuilder
    //   733: dup
    //   734: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   737: ldc_w 456
    //   740: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   743: aload 66
    //   745: iload 4
    //   747: aaload
    //   748: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   751: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   754: invokestatic 202	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   757: goto +2293 -> 3050
    //   760: aload 67
    //   762: invokevirtual 273	java/io/File:isDirectory	()Z
    //   765: ifeq +103 -> 868
    //   768: new 45	anqk
    //   771: dup
    //   772: invokespecial 447	anqk:<init>	()V
    //   775: astore 68
    //   777: aload 68
    //   779: iconst_0
    //   780: putfield 161	anqk:isFile	Z
    //   783: aload 68
    //   785: aload_0
    //   786: aload 67
    //   788: invokevirtual 285	anql:c	(Ljava/io/File;)J
    //   791: putfield 157	anqk:accessTime	J
    //   794: aload 68
    //   796: aload 66
    //   798: iload 4
    //   800: aaload
    //   801: putfield 145	anqk:name	Ljava/lang/String;
    //   804: aload 68
    //   806: new 184	java/lang/StringBuilder
    //   809: dup
    //   810: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   813: aload 65
    //   815: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   818: ldc_w 267
    //   821: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   824: aload 66
    //   826: iload 4
    //   828: aaload
    //   829: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   832: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   835: putfield 141	anqk:path	Ljava/lang/String;
    //   838: aload 68
    //   840: lconst_0
    //   841: putfield 169	anqk:anR	J
    //   844: aload 68
    //   846: lconst_0
    //   847: putfield 174	anqk:anS	J
    //   850: aload_0
    //   851: getfield 97	anql:AM	Ljava/util/ArrayList;
    //   854: aload 68
    //   856: invokevirtual 300	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   859: pop
    //   860: goto +2190 -> 3050
    //   863: astore_1
    //   864: aload_0
    //   865: monitorexit
    //   866: aload_1
    //   867: athrow
    //   868: aload_0
    //   869: aload 65
    //   871: aload 66
    //   873: iload 4
    //   875: aaload
    //   876: invokespecial 343	anql:f	(Ljava/lang/String;Ljava/lang/String;)J
    //   879: pop2
    //   880: goto +2170 -> 3050
    //   883: ldc 182
    //   885: iconst_2
    //   886: new 184	java/lang/StringBuilder
    //   889: dup
    //   890: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   893: ldc_w 458
    //   896: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   899: aload_0
    //   900: getfield 410	anql:anT	J
    //   903: invokevirtual 364	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   906: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   909: invokestatic 202	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   912: iconst_0
    //   913: istore_2
    //   914: lconst_0
    //   915: lstore 14
    //   917: lconst_0
    //   918: lstore 18
    //   920: lconst_0
    //   921: lstore 32
    //   923: lconst_0
    //   924: lstore 10
    //   926: lconst_0
    //   927: lstore 12
    //   929: lconst_0
    //   930: lstore 20
    //   932: lconst_0
    //   933: lstore 22
    //   935: lload 6
    //   937: lstore 24
    //   939: lload 8
    //   941: lstore 16
    //   943: lload 18
    //   945: lstore 8
    //   947: lload 12
    //   949: lstore 6
    //   951: aload_0
    //   952: getfield 97	anql:AM	Ljava/util/ArrayList;
    //   955: invokevirtual 296	java/util/ArrayList:size	()I
    //   958: istore 4
    //   960: iload_2
    //   961: iload 4
    //   963: if_icmpge +1495 -> 2458
    //   966: aload_0
    //   967: getfield 97	anql:AM	Ljava/util/ArrayList;
    //   970: invokevirtual 296	java/util/ArrayList:size	()I
    //   973: sipush 500
    //   976: if_icmplt +475 -> 1451
    //   979: ldc2_w 459
    //   982: invokestatic 466	java/lang/Thread:sleep	(J)V
    //   985: aload_0
    //   986: getfield 97	anql:AM	Ljava/util/ArrayList;
    //   989: iload_2
    //   990: invokevirtual 235	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   993: checkcast 45	anqk
    //   996: astore 65
    //   998: aload 65
    //   1000: lconst_0
    //   1001: putfield 149	anqk:size	J
    //   1004: aload 65
    //   1006: lconst_0
    //   1007: putfield 169	anqk:anR	J
    //   1010: aload 65
    //   1012: lconst_0
    //   1013: putfield 174	anqk:anS	J
    //   1016: aload 65
    //   1018: getfield 141	anqk:path	Ljava/lang/String;
    //   1021: astore 66
    //   1023: lload 6
    //   1025: lstore 62
    //   1027: lload 14
    //   1029: lstore 46
    //   1031: lload 20
    //   1033: lstore 42
    //   1035: lload 8
    //   1037: lstore 60
    //   1039: lload 22
    //   1041: lstore 38
    //   1043: lload 32
    //   1045: lstore 36
    //   1047: lload 10
    //   1049: lstore 58
    //   1051: lload 16
    //   1053: lstore 18
    //   1055: lload 24
    //   1057: lstore 12
    //   1059: lload 54
    //   1061: lstore 56
    //   1063: new 265	java/io/File
    //   1066: dup
    //   1067: aload 66
    //   1069: invokespecial 270	java/io/File:<init>	(Ljava/lang/String;)V
    //   1072: invokevirtual 335	java/io/File:list	()[Ljava/lang/String;
    //   1075: astore 67
    //   1077: aload 67
    //   1079: ifnull +391 -> 1470
    //   1082: lload 6
    //   1084: lstore 62
    //   1086: lload 14
    //   1088: lstore 46
    //   1090: lload 20
    //   1092: lstore 42
    //   1094: lload 8
    //   1096: lstore 60
    //   1098: lload 22
    //   1100: lstore 38
    //   1102: lload 32
    //   1104: lstore 36
    //   1106: lload 10
    //   1108: lstore 58
    //   1110: lload 16
    //   1112: lstore 18
    //   1114: lload 24
    //   1116: lstore 12
    //   1118: lload 54
    //   1120: lstore 56
    //   1122: aload 67
    //   1124: arraylength
    //   1125: ifle +345 -> 1470
    //   1128: lload 6
    //   1130: lstore 62
    //   1132: lload 14
    //   1134: lstore 46
    //   1136: lload 20
    //   1138: lstore 42
    //   1140: lload 8
    //   1142: lstore 60
    //   1144: lload 22
    //   1146: lstore 38
    //   1148: lload 32
    //   1150: lstore 36
    //   1152: lload 10
    //   1154: lstore 58
    //   1156: lload 16
    //   1158: lstore 18
    //   1160: lload 24
    //   1162: lstore 12
    //   1164: lload 54
    //   1166: lstore 56
    //   1168: aload 67
    //   1170: arraylength
    //   1171: istore 5
    //   1173: iconst_0
    //   1174: istore 4
    //   1176: iload 4
    //   1178: iload 5
    //   1180: if_icmpge +290 -> 1470
    //   1183: aload 67
    //   1185: iload 4
    //   1187: aaload
    //   1188: astore 68
    //   1190: lload 6
    //   1192: lstore 62
    //   1194: lload 14
    //   1196: lstore 46
    //   1198: lload 20
    //   1200: lstore 42
    //   1202: lload 8
    //   1204: lstore 60
    //   1206: lload 22
    //   1208: lstore 38
    //   1210: lload 32
    //   1212: lstore 36
    //   1214: lload 10
    //   1216: lstore 58
    //   1218: lload 16
    //   1220: lstore 18
    //   1222: lload 24
    //   1224: lstore 12
    //   1226: lload 54
    //   1228: lstore 56
    //   1230: aload_0
    //   1231: new 184	java/lang/StringBuilder
    //   1234: dup
    //   1235: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   1238: aload 66
    //   1240: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1243: ldc_w 267
    //   1246: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1249: aload 68
    //   1251: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1254: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1257: invokespecial 468	anql:g	(Ljava/lang/String;)Landroid/os/Bundle;
    //   1260: astore 68
    //   1262: lload 6
    //   1264: lstore 62
    //   1266: lload 14
    //   1268: lstore 46
    //   1270: lload 20
    //   1272: lstore 42
    //   1274: lload 8
    //   1276: lstore 60
    //   1278: lload 22
    //   1280: lstore 38
    //   1282: lload 32
    //   1284: lstore 36
    //   1286: lload 10
    //   1288: lstore 58
    //   1290: lload 16
    //   1292: lstore 18
    //   1294: lload 24
    //   1296: lstore 12
    //   1298: lload 54
    //   1300: lstore 56
    //   1302: aload 65
    //   1304: aload 65
    //   1306: getfield 149	anqk:size	J
    //   1309: aload 68
    //   1311: ldc_w 351
    //   1314: lconst_0
    //   1315: invokevirtual 469	android/os/Bundle:getLong	(Ljava/lang/String;J)J
    //   1318: ladd
    //   1319: putfield 149	anqk:size	J
    //   1322: lload 6
    //   1324: lstore 62
    //   1326: lload 14
    //   1328: lstore 46
    //   1330: lload 20
    //   1332: lstore 42
    //   1334: lload 8
    //   1336: lstore 60
    //   1338: lload 22
    //   1340: lstore 38
    //   1342: lload 32
    //   1344: lstore 36
    //   1346: lload 10
    //   1348: lstore 58
    //   1350: lload 16
    //   1352: lstore 18
    //   1354: lload 24
    //   1356: lstore 12
    //   1358: lload 54
    //   1360: lstore 56
    //   1362: aload 65
    //   1364: aload 65
    //   1366: getfield 169	anqk:anR	J
    //   1369: aload 68
    //   1371: ldc_w 357
    //   1374: lconst_0
    //   1375: invokevirtual 469	android/os/Bundle:getLong	(Ljava/lang/String;J)J
    //   1378: ladd
    //   1379: putfield 169	anqk:anR	J
    //   1382: lload 6
    //   1384: lstore 62
    //   1386: lload 14
    //   1388: lstore 46
    //   1390: lload 20
    //   1392: lstore 42
    //   1394: lload 8
    //   1396: lstore 60
    //   1398: lload 22
    //   1400: lstore 38
    //   1402: lload 32
    //   1404: lstore 36
    //   1406: lload 10
    //   1408: lstore 58
    //   1410: lload 16
    //   1412: lstore 18
    //   1414: lload 24
    //   1416: lstore 12
    //   1418: lload 54
    //   1420: lstore 56
    //   1422: aload 65
    //   1424: aload 65
    //   1426: getfield 174	anqk:anS	J
    //   1429: aload 68
    //   1431: ldc_w 359
    //   1434: lconst_0
    //   1435: invokevirtual 469	android/os/Bundle:getLong	(Ljava/lang/String;J)J
    //   1438: ladd
    //   1439: putfield 174	anqk:anS	J
    //   1442: iload 4
    //   1444: iconst_1
    //   1445: iadd
    //   1446: istore 4
    //   1448: goto -272 -> 1176
    //   1451: ldc2_w 470
    //   1454: invokestatic 466	java/lang/Thread:sleep	(J)V
    //   1457: goto -472 -> 985
    //   1460: astore 65
    //   1462: aload 65
    //   1464: invokevirtual 474	java/lang/InterruptedException:printStackTrace	()V
    //   1467: goto -482 -> 985
    //   1470: lload 6
    //   1472: lstore 62
    //   1474: lload 14
    //   1476: lstore 46
    //   1478: lload 20
    //   1480: lstore 42
    //   1482: lload 8
    //   1484: lstore 60
    //   1486: lload 22
    //   1488: lstore 38
    //   1490: lload 32
    //   1492: lstore 36
    //   1494: lload 10
    //   1496: lstore 58
    //   1498: lload 16
    //   1500: lstore 18
    //   1502: lload 24
    //   1504: lstore 12
    //   1506: lload 54
    //   1508: lstore 56
    //   1510: aload 66
    //   1512: ldc_w 476
    //   1515: invokevirtual 231	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1518: ifeq +597 -> 2115
    //   1521: lload 6
    //   1523: lstore 62
    //   1525: lload 14
    //   1527: lstore 46
    //   1529: lload 20
    //   1531: lstore 42
    //   1533: lload 8
    //   1535: lstore 60
    //   1537: lload 22
    //   1539: lstore 38
    //   1541: lload 32
    //   1543: lstore 36
    //   1545: lload 10
    //   1547: lstore 58
    //   1549: lload 16
    //   1551: lstore 18
    //   1553: lload 24
    //   1555: lstore 12
    //   1557: lload 54
    //   1559: lstore 56
    //   1561: aload 66
    //   1563: ldc_w 478
    //   1566: invokevirtual 231	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1569: ifeq +369 -> 1938
    //   1572: lload 6
    //   1574: lstore 62
    //   1576: lload 14
    //   1578: lstore 46
    //   1580: lload 20
    //   1582: lstore 42
    //   1584: lload 8
    //   1586: lstore 60
    //   1588: lload 22
    //   1590: lstore 38
    //   1592: lload 32
    //   1594: lstore 36
    //   1596: lload 10
    //   1598: lstore 58
    //   1600: lload 16
    //   1602: lstore 18
    //   1604: lload 24
    //   1606: lstore 12
    //   1608: lload 54
    //   1610: lstore 56
    //   1612: lload 20
    //   1614: aload 65
    //   1616: getfield 149	anqk:size	J
    //   1619: ladd
    //   1620: lstore 30
    //   1622: lload 6
    //   1624: lstore 62
    //   1626: lload 14
    //   1628: lstore 46
    //   1630: lload 30
    //   1632: lstore 42
    //   1634: lload 8
    //   1636: lstore 60
    //   1638: lload 22
    //   1640: lstore 38
    //   1642: lload 32
    //   1644: lstore 36
    //   1646: lload 10
    //   1648: lstore 58
    //   1650: lload 16
    //   1652: lstore 18
    //   1654: lload 24
    //   1656: lstore 12
    //   1658: lload 54
    //   1660: lstore 56
    //   1662: lload 14
    //   1664: aload 65
    //   1666: getfield 169	anqk:anR	J
    //   1669: ladd
    //   1670: lstore 28
    //   1672: lload 6
    //   1674: lstore 62
    //   1676: lload 28
    //   1678: lstore 46
    //   1680: lload 30
    //   1682: lstore 42
    //   1684: lload 8
    //   1686: lstore 60
    //   1688: lload 22
    //   1690: lstore 38
    //   1692: lload 32
    //   1694: lstore 36
    //   1696: lload 10
    //   1698: lstore 58
    //   1700: lload 16
    //   1702: lstore 18
    //   1704: lload 24
    //   1706: lstore 12
    //   1708: lload 54
    //   1710: lstore 56
    //   1712: lload 6
    //   1714: aload 65
    //   1716: getfield 174	anqk:anS	J
    //   1719: ladd
    //   1720: lstore 26
    //   1722: lload 24
    //   1724: lstore 52
    //   1726: lload 16
    //   1728: lstore 50
    //   1730: lload 10
    //   1732: lstore 48
    //   1734: lload 32
    //   1736: lstore 44
    //   1738: lload 22
    //   1740: lstore 40
    //   1742: lload 8
    //   1744: lstore 34
    //   1746: lload 26
    //   1748: lstore 62
    //   1750: lload 28
    //   1752: lstore 46
    //   1754: lload 30
    //   1756: lstore 42
    //   1758: lload 34
    //   1760: lstore 60
    //   1762: lload 40
    //   1764: lstore 38
    //   1766: lload 44
    //   1768: lstore 36
    //   1770: lload 48
    //   1772: lstore 58
    //   1774: lload 50
    //   1776: lstore 18
    //   1778: lload 52
    //   1780: lstore 12
    //   1782: lload 54
    //   1784: lstore 56
    //   1786: lload 54
    //   1788: aload 65
    //   1790: getfield 149	anqk:size	J
    //   1793: ladd
    //   1794: lstore 54
    //   1796: lload 26
    //   1798: lstore 62
    //   1800: lload 28
    //   1802: lstore 46
    //   1804: lload 30
    //   1806: lstore 42
    //   1808: lload 34
    //   1810: lstore 60
    //   1812: lload 40
    //   1814: lstore 38
    //   1816: lload 44
    //   1818: lstore 36
    //   1820: lload 48
    //   1822: lstore 58
    //   1824: lload 50
    //   1826: lstore 18
    //   1828: lload 52
    //   1830: lstore 12
    //   1832: lload 54
    //   1834: lstore 56
    //   1836: ldc 182
    //   1838: iconst_1
    //   1839: new 184	java/lang/StringBuilder
    //   1842: dup
    //   1843: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   1846: ldc_w 480
    //   1849: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1852: aload 65
    //   1854: invokevirtual 197	anqk:toString	()Ljava/lang/String;
    //   1857: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1860: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1863: invokestatic 202	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1866: lload 52
    //   1868: lstore 12
    //   1870: lload 50
    //   1872: lstore 16
    //   1874: lload 48
    //   1876: lstore 10
    //   1878: lload 44
    //   1880: lstore 32
    //   1882: lload 40
    //   1884: lstore 22
    //   1886: lload 34
    //   1888: lstore 8
    //   1890: lload 30
    //   1892: lstore 20
    //   1894: lload 28
    //   1896: lstore 14
    //   1898: lload 26
    //   1900: lstore 6
    //   1902: aload_1
    //   1903: ifnull +24 -> 1927
    //   1906: aload_1
    //   1907: iload_2
    //   1908: iconst_1
    //   1909: iadd
    //   1910: iload_3
    //   1911: iconst_2
    //   1912: isub
    //   1913: imul
    //   1914: aload_0
    //   1915: getfield 97	anql:AM	Ljava/util/ArrayList;
    //   1918: invokevirtual 296	java/util/ArrayList:size	()I
    //   1921: idiv
    //   1922: invokeinterface 401 2 0
    //   1927: iload_2
    //   1928: iconst_1
    //   1929: iadd
    //   1930: istore_2
    //   1931: lload 12
    //   1933: lstore 24
    //   1935: goto -984 -> 951
    //   1938: lload 6
    //   1940: lstore 62
    //   1942: lload 14
    //   1944: lstore 46
    //   1946: lload 20
    //   1948: lstore 42
    //   1950: lload 8
    //   1952: lstore 60
    //   1954: lload 22
    //   1956: lstore 38
    //   1958: lload 32
    //   1960: lstore 36
    //   1962: lload 10
    //   1964: lstore 58
    //   1966: lload 16
    //   1968: lstore 18
    //   1970: lload 24
    //   1972: lstore 12
    //   1974: lload 54
    //   1976: lstore 56
    //   1978: lload 24
    //   1980: aload 65
    //   1982: getfield 149	anqk:size	J
    //   1985: ladd
    //   1986: lstore 52
    //   1988: lload 6
    //   1990: lstore 62
    //   1992: lload 14
    //   1994: lstore 46
    //   1996: lload 20
    //   1998: lstore 42
    //   2000: lload 8
    //   2002: lstore 60
    //   2004: lload 22
    //   2006: lstore 38
    //   2008: lload 32
    //   2010: lstore 36
    //   2012: lload 10
    //   2014: lstore 58
    //   2016: lload 16
    //   2018: lstore 18
    //   2020: lload 52
    //   2022: lstore 12
    //   2024: lload 54
    //   2026: lstore 56
    //   2028: lload 16
    //   2030: aload 65
    //   2032: getfield 169	anqk:anR	J
    //   2035: ladd
    //   2036: lstore 50
    //   2038: lload 6
    //   2040: lstore 62
    //   2042: lload 14
    //   2044: lstore 46
    //   2046: lload 20
    //   2048: lstore 42
    //   2050: lload 8
    //   2052: lstore 60
    //   2054: lload 22
    //   2056: lstore 38
    //   2058: lload 32
    //   2060: lstore 36
    //   2062: lload 10
    //   2064: lstore 58
    //   2066: lload 50
    //   2068: lstore 18
    //   2070: lload 52
    //   2072: lstore 12
    //   2074: lload 54
    //   2076: lstore 56
    //   2078: lload 10
    //   2080: aload 65
    //   2082: getfield 174	anqk:anS	J
    //   2085: ladd
    //   2086: lstore 48
    //   2088: lload 6
    //   2090: lstore 26
    //   2092: lload 14
    //   2094: lstore 28
    //   2096: lload 20
    //   2098: lstore 30
    //   2100: lload 8
    //   2102: lstore 34
    //   2104: lload 22
    //   2106: lstore 40
    //   2108: lload 32
    //   2110: lstore 44
    //   2112: goto -366 -> 1746
    //   2115: lload 6
    //   2117: lstore 26
    //   2119: lload 14
    //   2121: lstore 28
    //   2123: lload 20
    //   2125: lstore 30
    //   2127: lload 8
    //   2129: lstore 34
    //   2131: lload 22
    //   2133: lstore 40
    //   2135: lload 32
    //   2137: lstore 44
    //   2139: lload 10
    //   2141: lstore 48
    //   2143: lload 16
    //   2145: lstore 50
    //   2147: lload 24
    //   2149: lstore 52
    //   2151: lload 6
    //   2153: lstore 62
    //   2155: lload 14
    //   2157: lstore 46
    //   2159: lload 20
    //   2161: lstore 42
    //   2163: lload 8
    //   2165: lstore 60
    //   2167: lload 22
    //   2169: lstore 38
    //   2171: lload 32
    //   2173: lstore 36
    //   2175: lload 10
    //   2177: lstore 58
    //   2179: lload 16
    //   2181: lstore 18
    //   2183: lload 24
    //   2185: lstore 12
    //   2187: lload 54
    //   2189: lstore 56
    //   2191: aload 66
    //   2193: ldc 81
    //   2195: invokevirtual 231	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2198: ifeq -452 -> 1746
    //   2201: lload 6
    //   2203: lstore 62
    //   2205: lload 14
    //   2207: lstore 46
    //   2209: lload 20
    //   2211: lstore 42
    //   2213: lload 8
    //   2215: lstore 60
    //   2217: lload 22
    //   2219: lstore 38
    //   2221: lload 32
    //   2223: lstore 36
    //   2225: lload 10
    //   2227: lstore 58
    //   2229: lload 16
    //   2231: lstore 18
    //   2233: lload 24
    //   2235: lstore 12
    //   2237: lload 54
    //   2239: lstore 56
    //   2241: lload 32
    //   2243: aload 65
    //   2245: getfield 149	anqk:size	J
    //   2248: ladd
    //   2249: lstore 44
    //   2251: lload 6
    //   2253: lstore 62
    //   2255: lload 14
    //   2257: lstore 46
    //   2259: lload 20
    //   2261: lstore 42
    //   2263: lload 8
    //   2265: lstore 60
    //   2267: lload 22
    //   2269: lstore 38
    //   2271: lload 44
    //   2273: lstore 36
    //   2275: lload 10
    //   2277: lstore 58
    //   2279: lload 16
    //   2281: lstore 18
    //   2283: lload 24
    //   2285: lstore 12
    //   2287: lload 54
    //   2289: lstore 56
    //   2291: lload 22
    //   2293: aload 65
    //   2295: getfield 169	anqk:anR	J
    //   2298: ladd
    //   2299: lstore 40
    //   2301: lload 6
    //   2303: lstore 62
    //   2305: lload 14
    //   2307: lstore 46
    //   2309: lload 20
    //   2311: lstore 42
    //   2313: lload 8
    //   2315: lstore 60
    //   2317: lload 40
    //   2319: lstore 38
    //   2321: lload 44
    //   2323: lstore 36
    //   2325: lload 10
    //   2327: lstore 58
    //   2329: lload 16
    //   2331: lstore 18
    //   2333: lload 24
    //   2335: lstore 12
    //   2337: lload 54
    //   2339: lstore 56
    //   2341: aload 65
    //   2343: getfield 174	anqk:anS	J
    //   2346: lstore 22
    //   2348: lload 8
    //   2350: lload 22
    //   2352: ladd
    //   2353: lstore 34
    //   2355: lload 6
    //   2357: lstore 26
    //   2359: lload 14
    //   2361: lstore 28
    //   2363: lload 20
    //   2365: lstore 30
    //   2367: lload 10
    //   2369: lstore 48
    //   2371: lload 16
    //   2373: lstore 50
    //   2375: lload 24
    //   2377: lstore 52
    //   2379: goto -633 -> 1746
    //   2382: astore 65
    //   2384: aload 65
    //   2386: invokevirtual 481	java/lang/Exception:printStackTrace	()V
    //   2389: ldc 182
    //   2391: iconst_1
    //   2392: new 184	java/lang/StringBuilder
    //   2395: dup
    //   2396: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   2399: ldc_w 483
    //   2402: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2405: aload 65
    //   2407: invokevirtual 487	java/lang/Exception:getStackTrace	()[Ljava/lang/StackTraceElement;
    //   2410: invokevirtual 490	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2413: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2416: invokestatic 202	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2419: lload 62
    //   2421: lstore 6
    //   2423: lload 46
    //   2425: lstore 14
    //   2427: lload 42
    //   2429: lstore 20
    //   2431: lload 60
    //   2433: lstore 8
    //   2435: lload 38
    //   2437: lstore 22
    //   2439: lload 36
    //   2441: lstore 32
    //   2443: lload 58
    //   2445: lstore 10
    //   2447: lload 18
    //   2449: lstore 16
    //   2451: lload 56
    //   2453: lstore 54
    //   2455: goto -553 -> 1902
    //   2458: aload_0
    //   2459: getfield 97	anql:AM	Ljava/util/ArrayList;
    //   2462: aload_0
    //   2463: getfield 105	anql:jdField_a_of_type_Anql$b	Lanql$b;
    //   2466: invokestatic 306	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   2469: ldc 182
    //   2471: iconst_1
    //   2472: ldc_w 492
    //   2475: invokestatic 202	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2478: iconst_0
    //   2479: istore_2
    //   2480: iload_2
    //   2481: aload_0
    //   2482: getfield 97	anql:AM	Ljava/util/ArrayList;
    //   2485: invokevirtual 296	java/util/ArrayList:size	()I
    //   2488: if_icmpge +25 -> 2513
    //   2491: aload_0
    //   2492: aload_0
    //   2493: getfield 97	anql:AM	Ljava/util/ArrayList;
    //   2496: iload_2
    //   2497: invokevirtual 235	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   2500: checkcast 45	anqk
    //   2503: invokespecial 291	anql:a	(Lanqk;)V
    //   2506: iload_2
    //   2507: iconst_1
    //   2508: iadd
    //   2509: istore_2
    //   2510: goto -30 -> 2480
    //   2513: ldc 182
    //   2515: iconst_1
    //   2516: new 184	java/lang/StringBuilder
    //   2519: dup
    //   2520: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   2523: ldc_w 494
    //   2526: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2529: lload 54
    //   2531: invokevirtual 364	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2534: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2537: invokestatic 202	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2540: new 45	anqk
    //   2543: dup
    //   2544: invokespecial 447	anqk:<init>	()V
    //   2547: astore 65
    //   2549: aload 65
    //   2551: iconst_0
    //   2552: putfield 161	anqk:isFile	Z
    //   2555: aload 65
    //   2557: ldc_w 496
    //   2560: putfield 141	anqk:path	Ljava/lang/String;
    //   2563: aload 65
    //   2565: lload 16
    //   2567: lload 22
    //   2569: ladd
    //   2570: lload 14
    //   2572: ladd
    //   2573: putfield 169	anqk:anR	J
    //   2576: aload 65
    //   2578: lload 10
    //   2580: lload 8
    //   2582: ladd
    //   2583: lload 6
    //   2585: ladd
    //   2586: putfield 174	anqk:anS	J
    //   2589: aload 65
    //   2591: lconst_0
    //   2592: putfield 157	anqk:accessTime	J
    //   2595: aload 65
    //   2597: lload 54
    //   2599: putfield 149	anqk:size	J
    //   2602: aload_0
    //   2603: aload 65
    //   2605: invokespecial 291	anql:a	(Lanqk;)V
    //   2608: ldc 182
    //   2610: iconst_1
    //   2611: new 184	java/lang/StringBuilder
    //   2614: dup
    //   2615: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   2618: ldc_w 498
    //   2621: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2624: aload 65
    //   2626: invokevirtual 197	anqk:toString	()Ljava/lang/String;
    //   2629: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2632: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2635: invokestatic 202	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2638: new 45	anqk
    //   2641: dup
    //   2642: invokespecial 447	anqk:<init>	()V
    //   2645: astore 65
    //   2647: aload 65
    //   2649: iconst_0
    //   2650: putfield 161	anqk:isFile	Z
    //   2653: aload 65
    //   2655: ldc_w 500
    //   2658: putfield 141	anqk:path	Ljava/lang/String;
    //   2661: aload 65
    //   2663: aload_0
    //   2664: aload_0
    //   2665: getfield 113	anql:AN	Ljava/util/ArrayList;
    //   2668: invokespecial 502	anql:t	(Ljava/util/ArrayList;)Ljava/lang/String;
    //   2671: putfield 145	anqk:name	Ljava/lang/String;
    //   2674: aload 65
    //   2676: lload 14
    //   2678: lload 16
    //   2680: ladd
    //   2681: putfield 169	anqk:anR	J
    //   2684: aload 65
    //   2686: lload 6
    //   2688: lload 10
    //   2690: ladd
    //   2691: putfield 174	anqk:anS	J
    //   2694: aload 65
    //   2696: lconst_0
    //   2697: putfield 157	anqk:accessTime	J
    //   2700: aload 65
    //   2702: lload 24
    //   2704: lload 20
    //   2706: ladd
    //   2707: putfield 149	anqk:size	J
    //   2710: aload_0
    //   2711: aload 65
    //   2713: invokespecial 291	anql:a	(Lanqk;)V
    //   2716: ldc 182
    //   2718: iconst_1
    //   2719: new 184	java/lang/StringBuilder
    //   2722: dup
    //   2723: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   2726: ldc_w 504
    //   2729: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2732: aload 65
    //   2734: invokevirtual 197	anqk:toString	()Ljava/lang/String;
    //   2737: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2740: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2743: invokestatic 202	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2746: new 45	anqk
    //   2749: dup
    //   2750: invokespecial 447	anqk:<init>	()V
    //   2753: astore 65
    //   2755: aload 65
    //   2757: iconst_0
    //   2758: putfield 161	anqk:isFile	Z
    //   2761: aload 65
    //   2763: ldc_w 506
    //   2766: putfield 141	anqk:path	Ljava/lang/String;
    //   2769: aload 65
    //   2771: aload_0
    //   2772: aload_0
    //   2773: getfield 115	anql:AO	Ljava/util/ArrayList;
    //   2776: invokespecial 502	anql:t	(Ljava/util/ArrayList;)Ljava/lang/String;
    //   2779: putfield 145	anqk:name	Ljava/lang/String;
    //   2782: aload 65
    //   2784: lload 22
    //   2786: putfield 169	anqk:anR	J
    //   2789: aload 65
    //   2791: lload 8
    //   2793: putfield 174	anqk:anS	J
    //   2796: aload 65
    //   2798: lconst_0
    //   2799: putfield 157	anqk:accessTime	J
    //   2802: aload 65
    //   2804: lload 32
    //   2806: putfield 149	anqk:size	J
    //   2809: aload_0
    //   2810: aload 65
    //   2812: invokespecial 291	anql:a	(Lanqk;)V
    //   2815: ldc 182
    //   2817: iconst_1
    //   2818: new 184	java/lang/StringBuilder
    //   2821: dup
    //   2822: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   2825: ldc_w 508
    //   2828: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2831: aload 65
    //   2833: invokevirtual 197	anqk:toString	()Ljava/lang/String;
    //   2836: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2839: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2842: invokestatic 202	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2845: ldc 182
    //   2847: iconst_1
    //   2848: ldc_w 510
    //   2851: invokestatic 202	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2854: iconst_0
    //   2855: istore_2
    //   2856: iload_2
    //   2857: aload_0
    //   2858: getfield 95	anql:AL	Ljava/util/ArrayList;
    //   2861: invokevirtual 296	java/util/ArrayList:size	()I
    //   2864: if_icmpge +58 -> 2922
    //   2867: aload_0
    //   2868: getfield 95	anql:AL	Ljava/util/ArrayList;
    //   2871: iload_2
    //   2872: invokevirtual 235	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   2875: checkcast 45	anqk
    //   2878: astore 65
    //   2880: aload 65
    //   2882: new 184	java/lang/StringBuilder
    //   2885: dup
    //   2886: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   2889: ldc_w 512
    //   2892: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2895: aload 65
    //   2897: getfield 145	anqk:name	Ljava/lang/String;
    //   2900: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2903: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2906: putfield 145	anqk:name	Ljava/lang/String;
    //   2909: aload_0
    //   2910: aload 65
    //   2912: invokespecial 291	anql:a	(Lanqk;)V
    //   2915: iload_2
    //   2916: iconst_1
    //   2917: iadd
    //   2918: istore_2
    //   2919: goto -63 -> 2856
    //   2922: aload_0
    //   2923: getfield 107	anql:mNeedReport	Z
    //   2926: ifeq +140 -> 3066
    //   2929: aload 64
    //   2931: invokeinterface 516 1 0
    //   2936: ldc_w 429
    //   2939: aload_0
    //   2940: getfield 410	anql:anT	J
    //   2943: invokeinterface 521 4 0
    //   2948: invokeinterface 524 1 0
    //   2953: pop
    //   2954: goto +112 -> 3066
    //   2957: iload_2
    //   2958: bipush 7
    //   2960: if_icmpge +44 -> 3004
    //   2963: getstatic 51	anql:sPool	Lcom/tencent/commonsdk/pool/RecyclablePool;
    //   2966: aload_0
    //   2967: getfield 113	anql:AN	Ljava/util/ArrayList;
    //   2970: iload_2
    //   2971: invokevirtual 235	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   2974: checkcast 526	com/tencent/commonsdk/pool/RecyclablePool$Recyclable
    //   2977: invokevirtual 313	com/tencent/commonsdk/pool/RecyclablePool:recycle	(Lcom/tencent/commonsdk/pool/RecyclablePool$Recyclable;)V
    //   2980: getstatic 51	anql:sPool	Lcom/tencent/commonsdk/pool/RecyclablePool;
    //   2983: aload_0
    //   2984: getfield 115	anql:AO	Ljava/util/ArrayList;
    //   2987: iload_2
    //   2988: invokevirtual 235	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   2991: checkcast 526	com/tencent/commonsdk/pool/RecyclablePool$Recyclable
    //   2994: invokevirtual 313	com/tencent/commonsdk/pool/RecyclablePool:recycle	(Lcom/tencent/commonsdk/pool/RecyclablePool$Recyclable;)V
    //   2997: iload_2
    //   2998: iconst_1
    //   2999: iadd
    //   3000: istore_2
    //   3001: goto -44 -> 2957
    //   3004: aload_1
    //   3005: ifnull +10 -> 3015
    //   3008: aload_1
    //   3009: iload_3
    //   3010: invokeinterface 401 2 0
    //   3015: aload_0
    //   3016: monitorexit
    //   3017: lload 24
    //   3019: lreturn
    //   3020: iload_2
    //   3021: iconst_1
    //   3022: iadd
    //   3023: istore_2
    //   3024: goto -2716 -> 308
    //   3027: lconst_0
    //   3028: lstore 8
    //   3030: lconst_0
    //   3031: lstore 6
    //   3033: iconst_1
    //   3034: istore_2
    //   3035: goto -2541 -> 494
    //   3038: iload_2
    //   3039: iconst_1
    //   3040: iadd
    //   3041: istore_2
    //   3042: goto -2548 -> 494
    //   3045: iconst_0
    //   3046: istore_2
    //   3047: goto -2446 -> 601
    //   3050: iload 4
    //   3052: iconst_1
    //   3053: iadd
    //   3054: istore 4
    //   3056: goto -2412 -> 644
    //   3059: iload_2
    //   3060: iconst_1
    //   3061: iadd
    //   3062: istore_2
    //   3063: goto -2462 -> 601
    //   3066: iconst_0
    //   3067: istore_2
    //   3068: goto -111 -> 2957
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3071	0	this	anql
    //   0	3071	1	parama	com.tencent.mobileqq.activity.QQSettingCleanActivity.a
    //   0	3071	2	paramInt1	int
    //   0	3071	3	paramInt2	int
    //   642	2413	4	i	int
    //   1171	10	5	j	int
    //   112	2920	6	l1	long
    //   310	2719	8	l2	long
    //   301	2388	10	l3	long
    //   304	2032	12	l4	long
    //   915	1762	14	l5	long
    //   941	1738	16	l6	long
    //   918	1530	18	l7	long
    //   930	1775	20	l8	long
    //   933	1852	22	l9	long
    //   937	2081	24	l10	long
    //   1720	638	26	l11	long
    //   1670	692	28	l12	long
    //   1620	746	30	l13	long
    //   921	1884	32	l14	long
    //   1744	610	34	l15	long
    //   1045	1395	36	l16	long
    //   1041	1395	38	l17	long
    //   1740	578	40	l18	long
    //   1033	1395	42	l19	long
    //   1736	586	44	l20	long
    //   1029	1395	46	l21	long
    //   1732	638	48	l22	long
    //   1728	646	50	l23	long
    //   1724	654	52	l24	long
    //   14	2584	54	l25	long
    //   1061	1391	56	l26	long
    //   1049	1395	58	l27	long
    //   1037	1395	60	l28	long
    //   1025	1395	62	l29	long
    //   36	2894	64	localObject1	Object
    //   206	1219	65	localObject2	Object
    //   1460	882	65	localInterruptedException	java.lang.InterruptedException
    //   2382	24	65	localException	java.lang.Exception
    //   2547	364	65	localanqk	anqk
    //   361	1831	66	localObject3	Object
    //   378	806	67	localObject4	Object
    //   775	655	68	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   6	13	863	finally
    //   16	38	863	finally
    //   43	52	863	finally
    //   52	121	863	finally
    //   128	159	863	finally
    //   159	187	863	finally
    //   195	265	863	finally
    //   272	289	863	finally
    //   294	300	863	finally
    //   316	464	863	finally
    //   467	485	863	finally
    //   494	598	863	finally
    //   601	630	863	finally
    //   635	641	863	finally
    //   644	757	863	finally
    //   760	860	863	finally
    //   868	880	863	finally
    //   883	912	863	finally
    //   951	960	863	finally
    //   966	985	863	finally
    //   985	1023	863	finally
    //   1063	1077	863	finally
    //   1122	1128	863	finally
    //   1168	1173	863	finally
    //   1230	1262	863	finally
    //   1302	1322	863	finally
    //   1362	1382	863	finally
    //   1422	1442	863	finally
    //   1451	1457	863	finally
    //   1462	1467	863	finally
    //   1510	1521	863	finally
    //   1561	1572	863	finally
    //   1612	1622	863	finally
    //   1662	1672	863	finally
    //   1712	1722	863	finally
    //   1786	1796	863	finally
    //   1836	1866	863	finally
    //   1906	1927	863	finally
    //   1978	1988	863	finally
    //   2028	2038	863	finally
    //   2078	2088	863	finally
    //   2191	2201	863	finally
    //   2241	2251	863	finally
    //   2291	2301	863	finally
    //   2341	2348	863	finally
    //   2384	2419	863	finally
    //   2458	2478	863	finally
    //   2480	2506	863	finally
    //   2513	2854	863	finally
    //   2856	2915	863	finally
    //   2922	2954	863	finally
    //   2963	2997	863	finally
    //   3008	3015	863	finally
    //   966	985	1460	java/lang/InterruptedException
    //   1451	1457	1460	java/lang/InterruptedException
    //   1063	1077	2382	java/lang/Exception
    //   1122	1128	2382	java/lang/Exception
    //   1168	1173	2382	java/lang/Exception
    //   1230	1262	2382	java/lang/Exception
    //   1302	1322	2382	java/lang/Exception
    //   1362	1382	2382	java/lang/Exception
    //   1422	1442	2382	java/lang/Exception
    //   1510	1521	2382	java/lang/Exception
    //   1561	1572	2382	java/lang/Exception
    //   1612	1622	2382	java/lang/Exception
    //   1662	1672	2382	java/lang/Exception
    //   1712	1722	2382	java/lang/Exception
    //   1786	1796	2382	java/lang/Exception
    //   1836	1866	2382	java/lang/Exception
    //   1978	1988	2382	java/lang/Exception
    //   2028	2038	2382	java/lang/Exception
    //   2078	2088	2382	java/lang/Exception
    //   2191	2201	2382	java/lang/Exception
    //   2241	2251	2382	java/lang/Exception
    //   2291	2301	2382	java/lang/Exception
    //   2341	2348	2382	java/lang/Exception
  }
  
  public boolean ayL()
  {
    return this.cJq;
  }
  
  public long c(File paramFile)
  {
    for (;;)
    {
      try
      {
        if (this.jdField_s_of_type_JavaLangReflectField == null)
        {
          this.jdField_s_of_type_JavaLangReflectField = Class.forName("libcore.io.Libcore").getDeclaredField("os");
          if (!this.jdField_s_of_type_JavaLangReflectField.isAccessible()) {
            this.jdField_s_of_type_JavaLangReflectField.setAccessible(true);
          }
        }
        Object localObject = this.jdField_s_of_type_JavaLangReflectField.get(null);
        if (this.jdField_s_of_type_JavaLangReflectMethod == null) {
          this.jdField_s_of_type_JavaLangReflectMethod = localObject.getClass().getMethod("lstat", new Class[] { String.class });
        }
        paramFile = this.jdField_s_of_type_JavaLangReflectMethod.invoke(localObject, new Object[] { paramFile.getAbsolutePath() });
        if (this.t == null)
        {
          this.t = paramFile.getClass().getDeclaredField("st_atime");
          if (!this.t.isAccessible()) {
            this.t.setAccessible(true);
          }
        }
        l = this.t.getLong(paramFile);
        if (l != 0L) {
          continue;
        }
      }
      catch (ClassNotFoundException paramFile)
      {
        paramFile.printStackTrace();
        if (0L == 0L) {
          continue;
        }
        l = this.anT - 0L;
        if (l < 0L) {
          continue;
        }
        return l;
      }
      catch (NoSuchMethodException paramFile)
      {
        paramFile.printStackTrace();
        if (0L == 0L) {
          continue;
        }
        l = this.anT - 0L;
        if (l < 0L) {
          continue;
        }
        return l;
      }
      catch (IllegalAccessException paramFile)
      {
        paramFile.printStackTrace();
        if (0L == 0L) {
          continue;
        }
        l = this.anT - 0L;
        if (l < 0L) {
          continue;
        }
        return l;
      }
      catch (InvocationTargetException paramFile)
      {
        paramFile.printStackTrace();
        if (0L == 0L) {
          continue;
        }
        l = this.anT - 0L;
        if (l < 0L) {
          continue;
        }
        return l;
      }
      catch (NoSuchFieldException paramFile)
      {
        paramFile.printStackTrace();
        if (0L == 0L) {
          continue;
        }
        long l = this.anT - 0L;
        if (l < 0L) {
          continue;
        }
        return l;
      }
      finally
      {
        if (0L != 0L) {
          break label313;
        }
      }
      return 0L;
      l = this.anT - l;
      if (l >= 0L) {
        return l;
      }
    }
    for (;;)
    {
      throw paramFile;
      label313:
      if (this.anT - 0L >= 0L) {}
    }
  }
  
  public long e(ArrayList<String> paramArrayList)
  {
    long l2;
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      l2 = 0L;
      return l2;
    }
    long l1 = 0L;
    int i = 0;
    for (;;)
    {
      l2 = l1;
      if (i >= paramArrayList.size()) {
        break;
      }
      String str = (String)paramArrayList.get(i);
      String[] arrayOfString = new File(str).list();
      l2 = l1;
      if (arrayOfString != null)
      {
        l2 = l1;
        if (arrayOfString.length > 0)
        {
          int k = arrayOfString.length;
          int j = 0;
          for (;;)
          {
            l2 = l1;
            if (j >= k) {
              break;
            }
            File localFile = new File(str, arrayOfString[j]);
            l2 = l1;
            if (localFile.isFile()) {
              l2 = l1 + localFile.length();
            }
            j += 1;
            l1 = l2;
          }
        }
      }
      i += 1;
      l1 = l2;
    }
  }
  
  static class a
    implements Comparator
  {
    public int compare(Object paramObject1, Object paramObject2)
    {
      paramObject1 = (anqk)paramObject1;
      paramObject2 = (anqk)paramObject2;
      if (paramObject1.accessTime > paramObject2.accessTime) {
        return -1;
      }
      if (paramObject1.accessTime < paramObject2.accessTime) {
        return 1;
      }
      return 0;
    }
  }
  
  static class b
    implements Comparator
  {
    public int compare(Object paramObject1, Object paramObject2)
    {
      paramObject1 = (anqk)paramObject1;
      paramObject2 = (anqk)paramObject2;
      if (paramObject1.size > paramObject2.size) {
        return -1;
      }
      if (paramObject1.size < paramObject2.size) {
        return 1;
      }
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anql
 * JD-Core Version:    0.7.0.1
 */