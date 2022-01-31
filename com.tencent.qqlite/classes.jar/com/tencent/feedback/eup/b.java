package com.tencent.feedback.eup;

import android.content.Context;
import android.os.Environment;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class b
  implements Thread.UncaughtExceptionHandler
{
  private static b c = null;
  private Thread.UncaughtExceptionHandler a = null;
  private Context b = null;
  
  private b(Context paramContext)
  {
    this.b = paramContext.getApplicationContext();
  }
  
  private int a(List<d> paramList, int paramInt, boolean paramBoolean)
  {
    if ((paramList == null) || (paramInt <= 0)) {
      return 0;
    }
    ArrayList localArrayList = new ArrayList();
    Collections.sort(paramList, new Comparator() {});
    paramList = paramList.iterator();
    while ((paramList.hasNext()) && (paramInt > localArrayList.size()))
    {
      d locald = (d)paramList.next();
      if ((locald.b()) && (!paramBoolean)) {
        break;
      }
      localArrayList.add(locald);
      paramList.remove();
    }
    if (localArrayList.size() > 0) {
      return c.a(this.b, localArrayList);
    }
    return 0;
  }
  
  public static b a(Context paramContext)
  {
    try
    {
      if ((c == null) && (paramContext != null)) {
        c = new b(paramContext);
      }
      paramContext = c;
      return paramContext;
    }
    finally {}
  }
  
  /* Error */
  public static d a(Context paramContext, String paramString1, long paramLong1, Map<String, com.tencent.feedback.common.PlugInInfo> paramMap, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, long paramLong2, String paramString8, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 70	com/tencent/feedback/eup/d
    //   3: dup
    //   4: invokespecial 93	com/tencent/feedback/eup/d:<init>	()V
    //   7: astore 17
    //   9: aload 17
    //   11: aload 5
    //   13: invokevirtual 97	com/tencent/feedback/eup/d:i	(Ljava/lang/String;)V
    //   16: aload 17
    //   18: aload 6
    //   20: invokevirtual 100	com/tencent/feedback/eup/d:j	(Ljava/lang/String;)V
    //   23: aload 17
    //   25: lload 11
    //   27: lload_2
    //   28: ladd
    //   29: invokevirtual 103	com/tencent/feedback/eup/d:b	(J)V
    //   32: aload 13
    //   34: astore 5
    //   36: aload 13
    //   38: ifnull +39 -> 77
    //   41: aload 13
    //   43: astore 5
    //   45: aload 13
    //   47: invokevirtual 108	java/lang/String:length	()I
    //   50: sipush 10000
    //   53: if_icmple +24 -> 77
    //   56: aload 13
    //   58: aload 13
    //   60: invokevirtual 108	java/lang/String:length	()I
    //   63: sipush 10000
    //   66: isub
    //   67: aload 13
    //   69: invokevirtual 108	java/lang/String:length	()I
    //   72: invokevirtual 112	java/lang/String:substring	(II)Ljava/lang/String;
    //   75: astore 5
    //   77: aload 14
    //   79: astore 6
    //   81: aload 14
    //   83: ifnull +86 -> 169
    //   86: aload 14
    //   88: astore 6
    //   90: aload 14
    //   92: arraylength
    //   93: sipush 10000
    //   96: if_icmple +73 -> 169
    //   99: sipush 10000
    //   102: newarray byte
    //   104: astore 6
    //   106: aload 6
    //   108: arraylength
    //   109: iconst_1
    //   110: isub
    //   111: istore 16
    //   113: aload 14
    //   115: arraylength
    //   116: iconst_1
    //   117: isub
    //   118: istore 15
    //   120: iload 16
    //   122: iflt +47 -> 169
    //   125: iload 15
    //   127: iflt +42 -> 169
    //   130: aload 6
    //   132: iload 16
    //   134: aload 14
    //   136: iload 15
    //   138: baload
    //   139: bastore
    //   140: iload 16
    //   142: iconst_1
    //   143: isub
    //   144: istore 16
    //   146: iload 15
    //   148: iconst_1
    //   149: isub
    //   150: istore 15
    //   152: goto -32 -> 120
    //   155: astore 5
    //   157: aload 5
    //   159: invokevirtual 115	java/lang/Throwable:printStackTrace	()V
    //   162: aload 13
    //   164: astore 5
    //   166: goto -89 -> 77
    //   169: aload 17
    //   171: aload 5
    //   173: invokevirtual 118	com/tencent/feedback/eup/d:l	(Ljava/lang/String;)V
    //   176: aload 17
    //   178: aload 6
    //   180: invokevirtual 121	com/tencent/feedback/eup/d:b	([B)V
    //   183: aload 17
    //   185: aload 7
    //   187: invokevirtual 123	com/tencent/feedback/eup/d:c	(Ljava/lang/String;)V
    //   190: aload 9
    //   192: ifnull +14 -> 206
    //   195: aload 9
    //   197: invokevirtual 127	java/lang/String:trim	()Ljava/lang/String;
    //   200: invokevirtual 108	java/lang/String:length	()I
    //   203: ifne +262 -> 465
    //   206: ldc 129
    //   208: astore 5
    //   210: aload 17
    //   212: aload 5
    //   214: invokevirtual 131	com/tencent/feedback/eup/d:b	(Ljava/lang/String;)V
    //   217: aload 17
    //   219: aload 8
    //   221: invokevirtual 133	com/tencent/feedback/eup/d:a	(Ljava/lang/String;)V
    //   224: aload 10
    //   226: ifnull +18 -> 244
    //   229: aload 10
    //   231: astore 5
    //   233: aload 10
    //   235: invokevirtual 127	java/lang/String:trim	()Ljava/lang/String;
    //   238: invokevirtual 108	java/lang/String:length	()I
    //   241: ifne +7 -> 248
    //   244: ldc 135
    //   246: astore 5
    //   248: aload 17
    //   250: aload 5
    //   252: invokevirtual 138	com/tencent/feedback/eup/d:d	(Ljava/lang/String;)V
    //   255: aload 17
    //   257: ldc 139
    //   259: invokevirtual 142	com/tencent/feedback/eup/d:a	(F)V
    //   262: aload_0
    //   263: invokestatic 147	com/tencent/feedback/common/d:a	(Landroid/content/Context;)Lcom/tencent/feedback/common/d;
    //   266: pop
    //   267: aload 17
    //   269: aload_0
    //   270: invokestatic 151	com/tencent/feedback/common/d:h	(Landroid/content/Context;)J
    //   273: invokevirtual 153	com/tencent/feedback/eup/d:c	(J)V
    //   276: aload 17
    //   278: aload_0
    //   279: invokestatic 147	com/tencent/feedback/common/d:a	(Landroid/content/Context;)Lcom/tencent/feedback/common/d;
    //   282: invokevirtual 156	com/tencent/feedback/common/d:j	()J
    //   285: invokevirtual 159	com/tencent/feedback/eup/d:e	(J)V
    //   288: aload_0
    //   289: invokestatic 147	com/tencent/feedback/common/d:a	(Landroid/content/Context;)Lcom/tencent/feedback/common/d;
    //   292: pop
    //   293: aload 17
    //   295: invokestatic 161	com/tencent/feedback/common/d:i	()J
    //   298: invokevirtual 163	com/tencent/feedback/eup/d:d	(J)V
    //   301: aload 17
    //   303: aload_1
    //   304: invokevirtual 165	com/tencent/feedback/eup/d:e	(Ljava/lang/String;)V
    //   307: aload 17
    //   309: aload_1
    //   310: invokevirtual 168	com/tencent/feedback/eup/d:k	(Ljava/lang/String;)V
    //   313: aload 17
    //   315: aload 4
    //   317: invokevirtual 171	com/tencent/feedback/eup/d:a	(Ljava/util/Map;)V
    //   320: aload 17
    //   322: new 173	java/lang/StringBuilder
    //   325: dup
    //   326: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   329: invokestatic 178	com/tencent/feedback/proguard/a:d	()Ljava/lang/String;
    //   332: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   338: invokevirtual 188	com/tencent/feedback/eup/d:m	(Ljava/lang/String;)V
    //   341: new 173	java/lang/StringBuilder
    //   344: dup
    //   345: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   348: astore_1
    //   349: aload_0
    //   350: invokestatic 147	com/tencent/feedback/common/d:a	(Landroid/content/Context;)Lcom/tencent/feedback/common/d;
    //   353: pop
    //   354: iconst_3
    //   355: anewarray 105	java/lang/String
    //   358: dup
    //   359: iconst_0
    //   360: ldc 190
    //   362: aastore
    //   363: dup
    //   364: iconst_1
    //   365: ldc 192
    //   367: aastore
    //   368: dup
    //   369: iconst_2
    //   370: ldc 194
    //   372: aastore
    //   373: invokestatic 197	com/tencent/feedback/proguard/a:a	([Ljava/lang/String;)Ljava/util/ArrayList;
    //   376: astore_0
    //   377: aload_0
    //   378: ifnull +116 -> 494
    //   381: aload_0
    //   382: invokeinterface 64 1 0
    //   387: ifle +107 -> 494
    //   390: aload_0
    //   391: iconst_0
    //   392: invokeinterface 201 2 0
    //   397: checkcast 105	java/lang/String
    //   400: astore_0
    //   401: aload 17
    //   403: aload_1
    //   404: aload_0
    //   405: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   408: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   411: invokevirtual 204	com/tencent/feedback/eup/d:n	(Ljava/lang/String;)V
    //   414: ldc 206
    //   416: iconst_1
    //   417: anewarray 4	java/lang/Object
    //   420: dup
    //   421: iconst_0
    //   422: aload 17
    //   424: invokevirtual 209	com/tencent/feedback/eup/d:A	()Ljava/lang/String;
    //   427: aastore
    //   428: invokestatic 214	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   431: ldc 216
    //   433: iconst_1
    //   434: anewarray 4	java/lang/Object
    //   437: dup
    //   438: iconst_0
    //   439: aload 17
    //   441: invokevirtual 219	com/tencent/feedback/eup/d:D	()Ljava/lang/String;
    //   444: aastore
    //   445: invokestatic 214	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   448: aload 17
    //   450: areturn
    //   451: astore 6
    //   453: aload 6
    //   455: invokevirtual 115	java/lang/Throwable:printStackTrace	()V
    //   458: aload 14
    //   460: astore 6
    //   462: goto -293 -> 169
    //   465: aload 9
    //   467: astore 5
    //   469: aload 9
    //   471: invokevirtual 108	java/lang/String:length	()I
    //   474: sipush 1000
    //   477: if_icmple -267 -> 210
    //   480: aload 9
    //   482: iconst_0
    //   483: sipush 1000
    //   486: invokevirtual 112	java/lang/String:substring	(II)Ljava/lang/String;
    //   489: astore 5
    //   491: goto -281 -> 210
    //   494: ldc 221
    //   496: astore_0
    //   497: goto -96 -> 401
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	500	0	paramContext	Context
    //   0	500	1	paramString1	String
    //   0	500	2	paramLong1	long
    //   0	500	4	paramMap	Map<String, com.tencent.feedback.common.PlugInInfo>
    //   0	500	5	paramString2	String
    //   0	500	6	paramString3	String
    //   0	500	7	paramString4	String
    //   0	500	8	paramString5	String
    //   0	500	9	paramString6	String
    //   0	500	10	paramString7	String
    //   0	500	11	paramLong2	long
    //   0	500	13	paramString8	String
    //   0	500	14	paramArrayOfByte	byte[]
    //   118	33	15	i	int
    //   111	34	16	j	int
    //   7	442	17	locald	d
    // Exception table:
    //   from	to	target	type
    //   56	77	155	java/lang/Throwable
    //   99	120	451	java/lang/Throwable
  }
  
  public static d a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, long paramLong, String paramString7, byte[] paramArrayOfByte)
  {
    com.tencent.feedback.common.c localc = com.tencent.feedback.common.c.p();
    return a(paramContext, localc.g(), localc.i(), localc.n(), paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramLong, paramString7, paramArrayOfByte);
  }
  
  private static void a(ArrayList<String> paramArrayList, Throwable paramThrowable, int paramInt1, int paramInt2, int paramInt3)
  {
    for (;;)
    {
      if ((paramArrayList == null) || (paramThrowable == null) || (paramInt1 > paramInt2) || (paramArrayList.size() > paramInt3)) {}
      int i;
      do
      {
        return;
        i = paramInt1 + 1;
        StackTraceElement[] arrayOfStackTraceElement = paramThrowable.getStackTrace();
        if (arrayOfStackTraceElement != null)
        {
          int j = arrayOfStackTraceElement.length;
          paramInt1 = 0;
          while (paramInt1 < j)
          {
            paramArrayList.add(arrayOfStackTraceElement[paramInt1].toString());
            paramInt1 += 1;
          }
        }
      } while (paramThrowable.getCause() == null);
      paramArrayList.add("cause by:");
      paramArrayList.add(paramThrowable.getCause().getClass().getName() + ": " + paramThrowable.getCause().getMessage());
      paramThrowable = paramThrowable.getCause();
      paramInt1 = i;
    }
  }
  
  private boolean b(d paramd, CrashStrategyBean paramCrashStrategyBean)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramCrashStrategyBean != null)
    {
      bool1 = bool2;
      if (paramCrashStrategyBean.isStoreCrashSdcard())
      {
        String str1;
        try
        {
          com.tencent.feedback.common.e.b("save eup logs", new Object[0]);
          localObject = com.tencent.feedback.common.c.p();
          str1 = ((com.tencent.feedback.common.c)localObject).c();
          String str2 = ((com.tencent.feedback.common.c)localObject).d();
          String str3 = paramd.v();
          Locale localLocale = Locale.US;
          String str4 = ((com.tencent.feedback.common.c)localObject).f();
          localObject = new Date(paramd.i());
          if (localObject == null) {}
          for (localObject = null;; localObject = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format((Date)localObject))
          {
            str1 = String.format(localLocale, "#--------\npackage:%s\nversion:%s\nsdk:%s\nprocess:%s\ndate:%s\ntype:%s\nmessage:%s\nstack:\n%s\neupID:%s\n", new Object[] { str1, str2, str4, str3, localObject, paramd.e(), paramd.f(), paramd.h(), paramd.A() });
            if (paramCrashStrategyBean.getStoreDirectoryPath() != null) {
              break label336;
            }
            if (com.tencent.feedback.common.a.f(this.b)) {
              break;
            }
            return false;
          }
          paramd = this.b;
          int i = paramCrashStrategyBean.getCrashSdcardMaxSize();
          com.tencent.feedback.common.e.b("rqdp{  sv sd start}", new Object[0]);
          if ((str1 == null) || (str1.trim().length() <= 0)) {
            break label403;
          }
          if (Environment.getExternalStorageState().equals("mounted")) {
            com.tencent.feedback.proguard.a.a(new File(Environment.getExternalStorageDirectory(), "/Tencent/" + com.tencent.feedback.common.a.b(paramd) + "/euplog.txt").getAbsolutePath(), str1, i);
          }
          com.tencent.feedback.common.e.b("rqdp{  sv sd end}", new Object[0]);
        }
        catch (Throwable paramd)
        {
          com.tencent.feedback.common.e.c("rqdp{  save error} %s", new Object[] { paramd.toString() });
          paramd.printStackTrace();
          return false;
        }
        label336:
        Object localObject = new File(paramCrashStrategyBean.getStoreDirectoryPath());
        paramd = (d)localObject;
        if (!((File)localObject).isFile()) {
          paramd = ((File)localObject).getParentFile();
        }
        paramd = new File(paramd, "euplog.txt");
        localObject = this.b;
        com.tencent.feedback.proguard.a.a(paramd.getAbsolutePath(), str1, paramCrashStrategyBean.getCrashSdcardMaxSize());
        bool1 = true;
      }
    }
    return bool1;
    label403:
    return true;
  }
  
  private static Map<String, String> d()
  {
    Object localObject = Thread.getAllStackTraces();
    HashMap localHashMap;
    if (localObject != null)
    {
      localHashMap = new HashMap();
      StringBuilder localStringBuilder = new StringBuilder();
      try
      {
        localObject = ((Map)localObject).entrySet().iterator();
        while (((Iterator)localObject).hasNext())
        {
          Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
          localStringBuilder.setLength(0);
          StackTraceElement[] arrayOfStackTraceElement = (StackTraceElement[])localEntry.getValue();
          int j = arrayOfStackTraceElement.length;
          int i = 0;
          while (i < j)
          {
            localStringBuilder.append(arrayOfStackTraceElement[i].toString()).append("\n");
            i += 1;
          }
          localHashMap.put(((Thread)localEntry.getKey()).getName(), localStringBuilder.toString());
        }
        return localHashMap;
      }
      catch (Throwable localThrowable)
      {
        com.tencent.feedback.common.e.d("add all thread error", new Object[0]);
        localThrowable.printStackTrace();
      }
    }
    return null;
  }
  
  private void e()
  {
    Thread local2 = new Thread()
    {
      public final void run()
      {
        e.l();
      }
    };
    local2.setName("ImmediateEUP");
    local2.start();
    try
    {
      local2.join(3000L);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      localInterruptedException.printStackTrace();
    }
  }
  
  public final void a()
  {
    try
    {
      com.tencent.feedback.common.e.e("rqdp{ eup regist}", new Object[0]);
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
  
  public final boolean a(d paramd)
  {
    return a(paramd, e.k().q());
  }
  
  public final boolean a(d paramd, CrashStrategyBean paramCrashStrategyBean)
  {
    if (paramd == null)
    {
      com.tencent.feedback.common.e.c("bean == null ", new Object[0]);
      return false;
    }
    if (paramCrashStrategyBean == null)
    {
      com.tencent.feedback.common.e.c("no strategy!", new Object[0]);
      return false;
    }
    Object localObject1;
    label158:
    boolean bool;
    Object localObject3;
    if (paramCrashStrategyBean.isMerged())
    {
      if (paramd == null) {
        localObject1 = null;
      }
      while (localObject1 != null)
      {
        com.tencent.feedback.common.e.e("merge success return", new Object[0]);
        if ((!((d)localObject1).B()) && (((d)localObject1).r() >= 2))
        {
          com.tencent.feedback.common.e.e("rqdp{ may be crash too frequent! do immediate upload in merge!}", new Object[0]);
          e();
        }
        return true;
        localObject1 = paramd.h();
        if (localObject1 == null) {}
        for (localObject1 = null;; localObject1 = Pattern.compile("(0x[\\d[a-z]]{8})|(\\d)").matcher((CharSequence)localObject1).replaceAll(""))
        {
          localObject1 = com.tencent.feedback.proguard.a.a((String)localObject1);
          if (localObject1 != null) {
            break label158;
          }
          com.tencent.feedback.common.e.c("rqdp{  md5 error!}", new Object[0]);
          localObject1 = null;
          break;
        }
        paramd.g((String)localObject1);
        paramd.b(true);
        paramd.b(1);
        paramd.a(0);
        localObject1 = c.a(this.b, 1, "desc", -1, (String)localObject1, -1, -1, -1, -1, -1L, -1L, null);
        if ((localObject1 == null) || (((List)localObject1).size() <= 0))
        {
          com.tencent.feedback.common.e.b("rqdp{  new one ,no merged!}", new Object[0]);
          localObject1 = null;
        }
        else
        {
          localObject2 = (d)((List)localObject1).get(0);
          if ((((d)localObject2).q() != null) && (((d)localObject2).q().contains(paramd.i())))
          {
            com.tencent.feedback.common.e.b("rqdp{ already merged} %d", new Object[] { Long.valueOf(paramd.i()) });
            localObject1 = localObject2;
          }
          else
          {
            ((d)localObject2).b(((d)localObject2).r() + 1);
            if (((d)localObject2).q() == null) {
              ((d)localObject2).f("");
            }
            ((d)localObject2).f(((d)localObject2).q() + paramd.i() + "\n");
            localObject1 = this.b;
            com.tencent.feedback.common.e.b("rqdp{  EUPDAO.insertOrUpdateEUP() start}", new Object[0]);
            if ((localObject1 == null) || (localObject2 == null)) {
              com.tencent.feedback.common.e.c("rqdp{  context == null || bean == null,pls check}", new Object[0]);
            }
            for (bool = false;; bool = c.b((Context)localObject1, (List)localObject3))
            {
              localObject1 = localObject2;
              if (!bool) {
                break;
              }
              com.tencent.feedback.common.e.g("rqdp{  eupMeg update success} %b , c:%d , at:%s up:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(((d)localObject2).r()), ((d)localObject2).q(), Integer.valueOf(((d)localObject2).o()) });
              localObject1 = localObject2;
              if (paramd.u() == null) {
                break;
              }
              localObject3 = new File(paramd.u());
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
    int i = paramCrashStrategyBean.getMaxStoredNum();
    Object localObject2 = c.a(this.b, i + 1, "asc", -1, null, -1, -1, -1, -1, -1L, -1L, null);
    if ((localObject2 != null) && (((List)localObject2).size() > 0))
    {
      i = ((List)localObject2).size() - i + 1;
      if ((i > 0) && (a((List)localObject2, i, paramd.b()) < i))
      {
        com.tencent.feedback.common.e.e("can't add more eup!", new Object[0]);
        return false;
      }
      if (((List)localObject2).size() > 0)
      {
        localObject1 = (d)((List)localObject2).get(0);
        localObject3 = ((List)localObject2).iterator();
        if (((Iterator)localObject3).hasNext())
        {
          localObject2 = (d)((Iterator)localObject3).next();
          if ((((d)localObject1).i() >= ((d)localObject2).i()) || (!((d)localObject2).b())) {
            break label886;
          }
          localObject1 = localObject2;
        }
      }
    }
    label886:
    for (;;)
    {
      break;
      if ((((d)localObject1).b()) && (paramd.i() - ((d)localObject1).i() < 60000L))
      {
        com.tencent.feedback.common.e.e("rqdp{ may be crash too frequent! do immediate upload in not merge!}", new Object[0]);
        e();
      }
      b(paramd, paramCrashStrategyBean);
      if (com.tencent.feedback.common.a.e(this.b))
      {
        com.tencent.feedback.common.e.e("save log", new Object[0]);
        paramd.a(com.tencent.feedback.proguard.a.a(paramCrashStrategyBean.getOnlyLogTag(), paramCrashStrategyBean.getMaxLogRow()));
      }
      for (;;)
      {
        bool = c.a(this.b, paramd);
        com.tencent.feedback.common.e.g("store new eup pn:%s, isMe:%b , isNa:%b , res:%b ", new Object[] { paramd.v(), Boolean.valueOf(paramd.c()), Boolean.valueOf(paramd.d()), Boolean.valueOf(bool) });
        return bool;
        paramd.a(null);
      }
    }
  }
  
  public final boolean a(String paramString1, Throwable paramThrowable, String paramString2, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    String str4 = com.tencent.feedback.common.a.h(this.b);
    Object localObject1 = "";
    String str3 = "";
    String str1;
    String str2;
    if (paramThrowable != null)
    {
      str1 = paramThrowable.getMessage();
      if (paramThrowable == null) {
        break label352;
      }
      str2 = paramThrowable.getClass().getName();
      try
      {
        label42:
        Object localObject2 = CrashReport.getCrashRuntimeStrategy();
        int j = 3;
        int i = 100;
        if (localObject2 != null)
        {
          j = Math.max(3, ((CrashStrategyBean)localObject2).getMaxStackFrame());
          i = Math.max(100, ((CrashStrategyBean)localObject2).getMaxStackLine());
          com.tencent.feedback.common.e.b("change frame:%d  line:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
        }
        localObject2 = new ArrayList();
        a((ArrayList)localObject2, paramThrowable, 0, j, i);
        if (((ArrayList)localObject2).size() > 0)
        {
          paramThrowable = new StringBuilder(((ArrayList)localObject2).size());
          localObject2 = ((ArrayList)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            paramThrowable.append((String)((Iterator)localObject2).next()).append("\n");
            continue;
            localObject1 = str3;
          }
        }
      }
      catch (Throwable paramThrowable)
      {
        com.tencent.feedback.common.e.d("create stack from throw fail!", new Object[0]);
        paramThrowable.printStackTrace();
        paramThrowable = (Throwable)localObject1;
      }
    }
    label393:
    for (;;)
    {
      if (paramThrowable != null)
      {
        localObject1 = str3;
        if (paramThrowable.contains("\n")) {
          localObject1 = paramThrowable.substring(0, paramThrowable.indexOf("\n"));
        }
      }
      com.tencent.feedback.common.e.b("rqdp{ stack:}%s", new Object[] { paramThrowable });
      paramThrowable = a(this.b, str4, paramString1, (String)localObject1, str2, str1, paramThrowable, new Date().getTime(), paramString2, paramArrayOfByte);
      paramThrowable.a(paramBoolean);
      try
      {
        paramString2 = d();
        if (paramString2 != null)
        {
          paramThrowable.I().putAll(paramString2);
          if ((paramString1 != null) && (paramString1.trim().length() > 0)) {
            paramThrowable.I().remove(paramString1);
          }
        }
      }
      catch (Throwable paramString1)
      {
        for (;;)
        {
          com.tencent.feedback.common.e.d("get all threads stack fail", new Object[0]);
          paramString1.printStackTrace();
        }
      }
      return a(paramThrowable);
      str1 = "";
      break;
      label352:
      str2 = "";
      break label42;
      paramThrowable = paramThrowable.toString();
      break label393;
      paramThrowable = "";
    }
  }
  
  public final void b()
  {
    try
    {
      com.tencent.feedback.common.e.e("rqdp{ eup unregister}", new Object[0]);
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
  
  public final boolean c()
  {
    if (com.tencent.feedback.proguard.a.b() < 0L)
    {
      com.tencent.feedback.common.e.e("rqdp{  today fail?}", new Object[0]);
      new Date().getTime();
    }
    List localList = f.a(this.b).a(this.b, 1);
    return (localList != null) && (localList.size() > 0);
  }
  
  /* Error */
  public final void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_2
    //   3: ifnull +7 -> 10
    //   6: aload_2
    //   7: invokevirtual 115	java/lang/Throwable:printStackTrace	()V
    //   10: invokestatic 459	com/tencent/feedback/eup/e:k	()Lcom/tencent/feedback/eup/e;
    //   13: astore 4
    //   15: aload 4
    //   17: ifnonnull +140 -> 157
    //   20: ldc_w 693
    //   23: iconst_0
    //   24: anewarray 4	java/lang/Object
    //   27: invokestatic 372	com/tencent/feedback/common/e:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   30: aconst_null
    //   31: astore 6
    //   33: aload 6
    //   35: ifnull +12 -> 47
    //   38: aload 6
    //   40: aload_1
    //   41: aload_2
    //   42: invokeinterface 698 3 0
    //   47: aload 6
    //   49: ifnull +273 -> 322
    //   52: aload 6
    //   54: invokeinterface 702 1 0
    //   59: astore 5
    //   61: aload 6
    //   63: invokeinterface 705 1 0
    //   68: astore 4
    //   70: aload_1
    //   71: ifnonnull +191 -> 262
    //   74: ldc_w 503
    //   77: astore 7
    //   79: ldc_w 707
    //   82: iconst_1
    //   83: anewarray 4	java/lang/Object
    //   86: dup
    //   87: iconst_0
    //   88: aload_0
    //   89: aload 7
    //   91: aload_2
    //   92: aload 4
    //   94: aload 5
    //   96: iconst_1
    //   97: invokevirtual 709	com/tencent/feedback/eup/b:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[BZ)Z
    //   100: invokestatic 556	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   103: aastore
    //   104: invokestatic 445	com/tencent/feedback/common/e:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   107: aload 6
    //   109: ifnull +222 -> 331
    //   112: aload 6
    //   114: aload_1
    //   115: aload_2
    //   116: invokeinterface 713 3 0
    //   121: istore_3
    //   122: iload_3
    //   123: ifeq +31 -> 154
    //   126: aload_0
    //   127: getfield 27	com/tencent/feedback/eup/b:a	Ljava/lang/Thread$UncaughtExceptionHandler;
    //   130: ifnull +169 -> 299
    //   133: ldc_w 715
    //   136: iconst_0
    //   137: anewarray 4	java/lang/Object
    //   140: invokestatic 445	com/tencent/feedback/common/e:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   143: aload_0
    //   144: getfield 27	com/tencent/feedback/eup/b:a	Ljava/lang/Thread$UncaughtExceptionHandler;
    //   147: aload_1
    //   148: aload_2
    //   149: invokeinterface 717 3 0
    //   154: aload_0
    //   155: monitorexit
    //   156: return
    //   157: aload 4
    //   159: invokevirtual 720	com/tencent/feedback/eup/e:p	()Lcom/tencent/feedback/eup/CrashHandleListener;
    //   162: astore 6
    //   164: goto -131 -> 33
    //   167: astore 4
    //   169: ldc_w 722
    //   172: iconst_1
    //   173: anewarray 4	java/lang/Object
    //   176: dup
    //   177: iconst_0
    //   178: aload 4
    //   180: invokevirtual 370	java/lang/Throwable:toString	()Ljava/lang/String;
    //   183: aastore
    //   184: invokestatic 423	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   187: aload 4
    //   189: invokevirtual 115	java/lang/Throwable:printStackTrace	()V
    //   192: goto -145 -> 47
    //   195: astore_1
    //   196: aload_0
    //   197: monitorexit
    //   198: aload_1
    //   199: athrow
    //   200: astore 4
    //   202: ldc_w 724
    //   205: iconst_1
    //   206: anewarray 4	java/lang/Object
    //   209: dup
    //   210: iconst_0
    //   211: aload 4
    //   213: invokevirtual 370	java/lang/Throwable:toString	()Ljava/lang/String;
    //   216: aastore
    //   217: invokestatic 423	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   220: aload 4
    //   222: invokevirtual 115	java/lang/Throwable:printStackTrace	()V
    //   225: aconst_null
    //   226: astore 5
    //   228: goto -167 -> 61
    //   231: astore 4
    //   233: ldc_w 726
    //   236: iconst_1
    //   237: anewarray 4	java/lang/Object
    //   240: dup
    //   241: iconst_0
    //   242: aload 4
    //   244: invokevirtual 370	java/lang/Throwable:toString	()Ljava/lang/String;
    //   247: aastore
    //   248: invokestatic 423	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   251: aload 4
    //   253: invokevirtual 115	java/lang/Throwable:printStackTrace	()V
    //   256: aconst_null
    //   257: astore 4
    //   259: goto -189 -> 70
    //   262: aload_1
    //   263: invokevirtual 415	java/lang/Thread:getName	()Ljava/lang/String;
    //   266: astore 7
    //   268: goto -189 -> 79
    //   271: astore 4
    //   273: ldc_w 728
    //   276: iconst_1
    //   277: anewarray 4	java/lang/Object
    //   280: dup
    //   281: iconst_0
    //   282: aload 4
    //   284: invokevirtual 370	java/lang/Throwable:toString	()Ljava/lang/String;
    //   287: aastore
    //   288: invokestatic 423	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   291: aload 4
    //   293: invokevirtual 115	java/lang/Throwable:printStackTrace	()V
    //   296: goto +35 -> 331
    //   299: ldc_w 730
    //   302: iconst_0
    //   303: anewarray 4	java/lang/Object
    //   306: invokestatic 445	com/tencent/feedback/common/e:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   309: invokestatic 735	android/os/Process:myPid	()I
    //   312: invokestatic 738	android/os/Process:killProcess	(I)V
    //   315: iconst_1
    //   316: invokestatic 743	java/lang/System:exit	(I)V
    //   319: goto -165 -> 154
    //   322: aconst_null
    //   323: astore 5
    //   325: aconst_null
    //   326: astore 4
    //   328: goto -258 -> 70
    //   331: iconst_1
    //   332: istore_3
    //   333: goto -211 -> 122
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	336	0	this	b
    //   0	336	1	paramThread	Thread
    //   0	336	2	paramThrowable	Throwable
    //   121	212	3	bool	boolean
    //   13	145	4	localObject1	Object
    //   167	21	4	localThrowable1	Throwable
    //   200	21	4	localThrowable2	Throwable
    //   231	21	4	localThrowable3	Throwable
    //   257	1	4	localObject2	Object
    //   271	21	4	localThrowable4	Throwable
    //   326	1	4	localObject3	Object
    //   59	265	5	arrayOfByte	byte[]
    //   31	132	6	localCrashHandleListener	CrashHandleListener
    //   77	190	7	str	String
    // Exception table:
    //   from	to	target	type
    //   38	47	167	java/lang/Throwable
    //   6	10	195	finally
    //   10	15	195	finally
    //   20	30	195	finally
    //   38	47	195	finally
    //   52	61	195	finally
    //   61	70	195	finally
    //   79	107	195	finally
    //   112	122	195	finally
    //   126	154	195	finally
    //   157	164	195	finally
    //   169	192	195	finally
    //   202	225	195	finally
    //   233	256	195	finally
    //   262	268	195	finally
    //   273	296	195	finally
    //   299	319	195	finally
    //   52	61	200	java/lang/Throwable
    //   61	70	231	java/lang/Throwable
    //   112	122	271	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.feedback.eup.b
 * JD-Core Version:    0.7.0.1
 */