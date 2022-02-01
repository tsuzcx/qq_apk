package com.tencent.feedback.eup;

import android.content.Context;
import android.os.Environment;
import com.tencent.feedback.common.PlugInInfo;
import com.tencent.feedback.common.c;
import com.tencent.feedback.common.d;
import com.tencent.feedback.proguard.j;
import com.tencent.feedback.proguard.l;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class b
{
  private StringBuilder a;
  private int b = 0;
  
  public b(StringBuilder paramStringBuilder, int paramInt)
  {
    this.a = paramStringBuilder;
    this.b = paramInt;
  }
  
  public static int a(Context paramContext, List<e> paramList)
  {
    int i = 0;
    com.tencent.feedback.common.e.b("rqdp{  EUPDAO.deleteEupList() start}", new Object[0]);
    if (paramContext == null)
    {
      com.tencent.feedback.common.e.c("rqdp{  deleteEupList() have null args!}", new Object[0]);
      return -1;
    }
    if (paramList.size() > 0)
    {
      Long[] arrayOfLong = new Long[paramList.size()];
      while (i < paramList.size())
      {
        arrayOfLong[i] = Long.valueOf(((e)paramList.get(i)).a());
        i += 1;
      }
      return l.a(paramContext, arrayOfLong);
    }
    return 0;
  }
  
  public static e a(Context paramContext, String paramString1, String paramString2, long paramLong1, Map<String, PlugInInfo> paramMap, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, long paramLong2, String paramString9, byte[] paramArrayOfByte)
  {
    String str1 = paramString7;
    String str2 = paramString9;
    e locale = new e();
    locale.i(paramString3);
    locale.j(paramString4);
    locale.b(paramLong2 + paramLong1);
    paramString3 = str2;
    if (str2 != null)
    {
      paramString3 = str2;
      if (paramString9.length() > 10000) {
        try
        {
          paramString3 = str2.substring(paramString9.length() - 10000, paramString9.length());
        }
        catch (Throwable paramString4)
        {
          paramString3 = str2;
          if (!com.tencent.feedback.common.e.a(paramString4))
          {
            paramString4.printStackTrace();
            paramString3 = str2;
          }
        }
      }
    }
    int i;
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 10000)) {
      try
      {
        paramString9 = new byte[10000];
        int j = paramString9.length - 1;
        i = paramArrayOfByte.length - 1;
        for (;;)
        {
          paramString4 = paramString9;
          if (j < 0) {
            break;
          }
          paramString4 = paramString9;
          if (i < 0) {
            break;
          }
          paramString9[j] = paramArrayOfByte[i];
          j -= 1;
          i -= 1;
        }
        paramString4 = paramArrayOfByte;
      }
      catch (Throwable paramString4)
      {
        if (!com.tencent.feedback.common.e.a(paramString4)) {
          paramString4.printStackTrace();
        }
      }
    }
    locale.k(paramString3);
    locale.b(paramString4);
    locale.c(paramString5);
    if ((str1 != null) && (paramString7.trim().length() != 0))
    {
      paramString3 = str1;
      if (paramString7.length() > 1000) {
        paramString3 = str1.substring(0, 1000);
      }
    }
    else
    {
      paramString3 = "empty message";
    }
    locale.b(paramString3);
    locale.a(paramString6);
    if ((paramString8 != null) && (paramString8.trim().length() != 0)) {
      break label321;
    }
    paramString8 = "empty stack";
    label321:
    locale.d(paramString8);
    locale.a(-1.0F);
    paramString3 = d.a(paramContext);
    locale.c(d.h());
    locale.e(paramString3.j());
    locale.d(d.f());
    locale.i(d.n());
    locale.j(d.o());
    com.tencent.feedback.common.e.b("avram:%d,avsd:%d,avrom:%d,avstack:%d,avheap:%d", new Object[] { Long.valueOf(locale.F()), Long.valueOf(locale.H()), Long.valueOf(locale.G()), Long.valueOf(locale.L()), Long.valueOf(locale.M()) });
    paramString3 = c.a(paramContext);
    locale.f(paramString3.t());
    locale.g(paramString3.s());
    locale.h(paramString3.u());
    locale.r(paramString3.B());
    locale.s(paramString3.z());
    com.tencent.feedback.common.e.b("tram:%d,trom:%d,tsd:%d,v:%s,cn:%s", new Object[] { Long.valueOf(locale.I()), Long.valueOf(locale.J()), Long.valueOf(locale.K()), locale.N(), locale.O() });
    locale.e(paramString1);
    locale.q(paramString2);
    locale.a(paramMap);
    paramString1 = new StringBuilder();
    paramString1.append(com.tencent.feedback.proguard.a.d());
    locale.l(paramString1.toString());
    paramString2 = new StringBuilder();
    paramString1 = com.tencent.feedback.proguard.a.a(paramContext, "ro.miui.ui.version.name");
    if ((paramString1 != null) && (paramString1.trim().length() > 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if ((i == 0) && (!paramString1.equals("fail"))) {
      paramContext = new StringBuilder("XiaoMi/MIUI/");
    }
    for (;;)
    {
      paramContext.append(paramString1);
      paramContext = paramContext.toString();
      break label1049;
      paramString1 = com.tencent.feedback.proguard.a.a(paramContext, "ro.build.version.emui");
      if ((paramString1 != null) && (paramString1.trim().length() > 0)) {
        i = 0;
      } else {
        i = 1;
      }
      if ((i == 0) && (!paramString1.equals("fail")))
      {
        paramContext = new StringBuilder("HuaWei/EMUI/");
      }
      else
      {
        paramString1 = com.tencent.feedback.proguard.a.a(paramContext, "ro.lenovo.series");
        if ((paramString1 != null) && (paramString1.trim().length() > 0)) {
          i = 0;
        } else {
          i = 1;
        }
        if ((i == 0) && (!paramString1.equals("fail")))
        {
          paramContext = com.tencent.feedback.proguard.a.a(paramContext, "ro.build.version.incremental");
          paramString1 = new StringBuilder("Lenovo/VIBE/");
        }
        for (;;)
        {
          paramString1.append(paramContext);
          paramContext = paramString1.toString();
          break label1049;
          paramString1 = com.tencent.feedback.proguard.a.a(paramContext, "ro.build.nubia.rom.name");
          if ((paramString1 != null) && (paramString1.trim().length() > 0)) {
            i = 0;
          } else {
            i = 1;
          }
          if ((i == 0) && (!paramString1.equals("fail")))
          {
            paramMap = new StringBuilder("Zte/NUBIA/");
            paramMap.append(paramString1);
            paramMap.append("_");
            paramMap.append(com.tencent.feedback.proguard.a.a(paramContext, "ro.build.nubia.rom.code"));
            paramContext = paramMap.toString();
            break label1049;
          }
          paramString1 = com.tencent.feedback.proguard.a.a(paramContext, "ro.meizu.product.model");
          if ((paramString1 != null) && (paramString1.trim().length() > 0)) {
            i = 0;
          } else {
            i = 1;
          }
          if ((i != 0) || (paramString1.equals("fail"))) {
            break;
          }
          paramString1 = new StringBuilder("Meizu/FLYME/");
          paramContext = com.tencent.feedback.proguard.a.a(paramContext, "ro.build.display.id");
        }
        paramString1 = com.tencent.feedback.proguard.a.a(paramContext, "ro.build.version.opporom");
        if ((paramString1 != null) && (paramString1.trim().length() > 0)) {
          i = 0;
        } else {
          i = 1;
        }
        if ((i != 0) || (paramString1.equals("fail"))) {
          break;
        }
        paramContext = new StringBuilder("Oppo/COLOROS/");
      }
    }
    paramContext = com.tencent.feedback.proguard.a.a(paramContext, "ro.build.fingerprint");
    label1049:
    paramString2.append(paramContext);
    locale.m(paramString2.toString());
    locale.k(locale.i() - paramString3.D());
    com.tencent.feedback.common.e.b("record id:%s", new Object[] { locale.v() });
    com.tencent.feedback.common.e.b("rom id %s", new Object[] { locale.y() });
    locale.c(paramString3.F());
    locale.d(paramString3.G());
    locale.b(paramString3.H());
    locale.c(paramString3.K());
    com.tencent.feedback.common.e.b("record user scene:%d", new Object[] { Integer.valueOf(locale.R()) });
    return locale;
  }
  
  protected static l a(e parame)
  {
    if (parame == null) {
      return null;
    }
    for (;;)
    {
      try
      {
        i = parame.P();
        int j = 1;
        if (i != 1)
        {
          i = 1;
          l locall = new l(i, 0, parame.i(), com.tencent.feedback.proguard.a.a(parame));
          locall.b(parame.j());
          locall.a(parame.m());
          locall.a(parame.o());
          locall.a(parame.a());
          if (!parame.w()) {
            break label116;
          }
          i = j;
          locall.c(i);
          return locall;
        }
      }
      catch (Throwable parame)
      {
        if (!com.tencent.feedback.common.e.a(parame)) {
          parame.printStackTrace();
        }
        return null;
      }
      int i = 2;
      continue;
      label116:
      i = 0;
    }
  }
  
  protected static String a(Throwable paramThrowable, CrashStrategyBean paramCrashStrategyBean)
  {
    int i = 100;
    int j = 3;
    if (paramCrashStrategyBean != null)
    {
      j = Math.max(3, paramCrashStrategyBean.getMaxStackFrame());
      i = Math.max(100, paramCrashStrategyBean.getMaxStackLine());
      com.tencent.feedback.common.e.b("change frame:%d  line:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
    }
    paramCrashStrategyBean = new ArrayList();
    a(paramCrashStrategyBean, paramThrowable, 0, j, i);
    if (paramCrashStrategyBean.size() > 0)
    {
      paramThrowable = new StringBuilder(paramCrashStrategyBean.size());
      paramCrashStrategyBean = paramCrashStrategyBean.iterator();
      while (paramCrashStrategyBean.hasNext())
      {
        paramThrowable.append((String)paramCrashStrategyBean.next());
        paramThrowable.append("\n");
      }
      return paramThrowable.toString();
    }
    return "";
  }
  
  public static List<e> a(Context paramContext, int paramInt1, String paramString1, int paramInt2, String paramString2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong1, long paramLong2, Boolean paramBoolean)
  {
    com.tencent.feedback.common.e.b("rqdp{  EUPDAO.queryEupRecent() start}", new Object[0]);
    if ((paramContext != null) && (paramInt1 != 0) && ((paramLong2 <= 0L) || (paramLong1 <= paramLong2)) && ((paramInt4 <= 0) || (paramInt3 <= paramInt4)))
    {
      int i;
      if ("asc".equals(paramString1)) {
        i = 1;
      } else {
        i = 2;
      }
      if (paramInt2 == 2)
      {
        paramString1 = new int[] { 2 };
      }
      else if (paramInt2 == 1)
      {
        paramString1 = new int[] { 1 };
      }
      else if (paramInt2 < 0)
      {
        paramString1 = new int[] { 1, 2 };
      }
      else
      {
        com.tencent.feedback.common.e.c("rqdp{  queryEupRecent() seletedRecordType unaccepted}", new Object[0]);
        paramString1 = null;
      }
      if (paramBoolean == null) {
        paramInt2 = -1;
      } else if (paramBoolean.booleanValue()) {
        paramInt2 = 1;
      } else {
        paramInt2 = 0;
      }
      paramString1 = l.a(paramContext, paramString1, -1, i, -1L, paramInt1, paramString2, paramInt3, paramInt4, paramInt5, paramInt6, paramLong1, paramLong2, paramInt2);
      if (paramString1 != null)
      {
        if (paramString1.size() <= 0) {
          return null;
        }
        paramString2 = new ArrayList();
        paramBoolean = paramString1.iterator();
        while (paramBoolean.hasNext())
        {
          l locall = (l)paramBoolean.next();
          try
          {
            Object localObject = com.tencent.feedback.proguard.a.b(locall.b());
            if ((localObject != null) && (e.class.isInstance(localObject)))
            {
              localObject = (e)e.class.cast(localObject);
              ((e)localObject).a(locall.a());
              paramString2.add(localObject);
              paramBoolean.remove();
            }
          }
          catch (Throwable localThrowable)
          {
            if (!com.tencent.feedback.common.e.a(localThrowable)) {
              localThrowable.printStackTrace();
            }
            com.tencent.feedback.common.e.d("rqdp{  query have error!}", new Object[0]);
          }
        }
        if (paramString1.size() > 0)
        {
          paramBoolean = new StringBuilder("rqdp{  there are error datas ,should be remove }");
          paramBoolean.append(paramString1.size());
          com.tencent.feedback.common.e.b(paramBoolean.toString(), new Object[0]);
          paramBoolean = new Long[paramString1.size()];
          paramInt1 = 0;
          while (paramInt1 < paramString1.size())
          {
            paramBoolean[paramInt1] = Long.valueOf(((l)paramString1.get(paramInt1)).a());
            paramInt1 += 1;
          }
          l.a(paramContext, paramBoolean);
        }
        com.tencent.feedback.common.e.b("rqdp{  EUPDAO.queryEupRecent() end}", new Object[0]);
        return paramString2;
      }
      return null;
    }
    com.tencent.feedback.common.e.c("rqdp{  context == null || limitNum == 0 || (timeEnd > 0 && timeStart > timeEnd) || (maxCount > 0 && miniCount > maxCount ,pls check}", new Object[0]);
    return null;
  }
  
  private void a(String paramString)
  {
    int i = 0;
    while (i < this.b)
    {
      this.a.append('\t');
      i += 1;
    }
    if (paramString != null)
    {
      StringBuilder localStringBuilder = this.a;
      localStringBuilder.append(paramString);
      localStringBuilder.append(": ");
    }
  }
  
  private static void a(ArrayList<String> paramArrayList, Throwable paramThrowable, int paramInt1, int paramInt2, int paramInt3)
  {
    while ((paramArrayList != null) && (paramThrowable != null) && (paramInt1 <= paramInt2))
    {
      if (paramArrayList.size() > paramInt3) {
        return;
      }
      int i = paramInt1 + 1;
      Object localObject = paramThrowable.getStackTrace();
      if (localObject != null)
      {
        int j = localObject.length;
        paramInt1 = 0;
        while (paramInt1 < j)
        {
          paramArrayList.add(localObject[paramInt1].toString());
          paramInt1 += 1;
        }
      }
      if (paramThrowable.getCause() != null)
      {
        paramArrayList.add("cause by:");
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramThrowable.getCause().getClass().getName());
        ((StringBuilder)localObject).append(": ");
        ((StringBuilder)localObject).append(paramThrowable.getCause().getMessage());
        paramArrayList.add(((StringBuilder)localObject).toString());
        paramThrowable = paramThrowable.getCause();
        paramInt1 = i;
      }
      else {}
    }
  }
  
  public static boolean a(Context paramContext)
  {
    if (com.tencent.feedback.proguard.a.c() < 0L)
    {
      com.tencent.feedback.common.e.d("rqdp{  today fail?}", new Object[0]);
      new Date().getTime();
    }
    paramContext = g.a(paramContext).a(paramContext, 1);
    return (paramContext != null) && (paramContext.size() > 0);
  }
  
  /* Error */
  public static boolean a(Context paramContext, e parame)
  {
    // Byte code:
    //   0: ldc_w 517
    //   3: iconst_0
    //   4: anewarray 4	java/lang/Object
    //   7: invokestatic 30	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   10: pop
    //   11: aload_0
    //   12: ifnull +156 -> 168
    //   15: aload_1
    //   16: ifnonnull +6 -> 22
    //   19: goto +149 -> 168
    //   22: aload_1
    //   23: invokestatic 519	com/tencent/feedback/eup/b:a	(Lcom/tencent/feedback/eup/e;)Lcom/tencent/feedback/proguard/l;
    //   26: astore_3
    //   27: aload_0
    //   28: ifnull +36 -> 64
    //   31: aload_3
    //   32: ifnonnull +6 -> 38
    //   35: goto +29 -> 64
    //   38: new 386	java/util/ArrayList
    //   41: dup
    //   42: invokespecial 387	java/util/ArrayList:<init>	()V
    //   45: astore 4
    //   47: aload 4
    //   49: aload_3
    //   50: invokevirtual 449	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   53: pop
    //   54: aload_0
    //   55: aload 4
    //   57: invokestatic 522	com/tencent/feedback/proguard/l:a	(Landroid/content/Context;Ljava/util/List;)Z
    //   60: istore_2
    //   61: goto +16 -> 77
    //   64: ldc_w 524
    //   67: iconst_0
    //   68: anewarray 4	java/lang/Object
    //   71: invokestatic 526	com/tencent/feedback/common/e:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   74: pop
    //   75: iconst_0
    //   76: istore_2
    //   77: iload_2
    //   78: ifeq +24 -> 102
    //   81: aload_1
    //   82: aload_3
    //   83: invokevirtual 444	com/tencent/feedback/proguard/l:a	()J
    //   86: invokevirtual 446	com/tencent/feedback/eup/e:a	(J)V
    //   89: ldc_w 528
    //   92: iconst_0
    //   93: anewarray 4	java/lang/Object
    //   96: invokestatic 30	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   99: pop
    //   100: iconst_1
    //   101: ireturn
    //   102: ldc_w 528
    //   105: iconst_0
    //   106: anewarray 4	java/lang/Object
    //   109: invokestatic 30	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   112: pop
    //   113: iconst_0
    //   114: ireturn
    //   115: astore_0
    //   116: goto +39 -> 155
    //   119: astore_0
    //   120: aload_0
    //   121: invokestatic 89	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   124: ifne +7 -> 131
    //   127: aload_0
    //   128: invokevirtual 92	java/lang/Throwable:printStackTrace	()V
    //   131: ldc_w 530
    //   134: iconst_0
    //   135: anewarray 4	java/lang/Object
    //   138: invokestatic 456	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   141: pop
    //   142: ldc_w 528
    //   145: iconst_0
    //   146: anewarray 4	java/lang/Object
    //   149: invokestatic 30	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   152: pop
    //   153: iconst_0
    //   154: ireturn
    //   155: ldc_w 528
    //   158: iconst_0
    //   159: anewarray 4	java/lang/Object
    //   162: invokestatic 30	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   165: pop
    //   166: aload_0
    //   167: athrow
    //   168: ldc_w 532
    //   171: iconst_0
    //   172: anewarray 4	java/lang/Object
    //   175: invokestatic 35	com/tencent/feedback/common/e:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   178: pop
    //   179: iconst_0
    //   180: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	181	0	paramContext	Context
    //   0	181	1	parame	e
    //   60	18	2	bool	boolean
    //   26	57	3	locall	l
    //   45	11	4	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   22	27	115	finally
    //   38	61	115	finally
    //   64	75	115	finally
    //   81	89	115	finally
    //   120	131	115	finally
    //   131	142	115	finally
    //   22	27	119	java/lang/Throwable
    //   38	61	119	java/lang/Throwable
    //   64	75	119	java/lang/Throwable
    //   81	89	119	java/lang/Throwable
  }
  
  protected static boolean a(Context paramContext, e parame, CrashStrategyBean paramCrashStrategyBean)
  {
    if ((paramCrashStrategyBean != null) && (paramCrashStrategyBean.isStoreCrashSdcard())) {
      try
      {
        com.tencent.feedback.common.e.b("save eup logs", new Object[0]);
        Object localObject = c.a(paramContext);
        String str1 = ((c)localObject).b();
        String str2 = ((c)localObject).B();
        String str3 = parame.q();
        Locale localLocale = Locale.US;
        localObject = ((c)localObject).c();
        Date localDate = new Date(parame.i());
        str1 = String.format(localLocale, "#--------\npackage:%s\nversion:%s\nsdk:%s\nprocess:%s\ndate:%s\ntype:%s\nmessage:%s\nstack:\n%s\neupID:%s\n", new Object[] { str1, str2, localObject, str3, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(localDate), parame.e(), parame.f(), parame.h(), parame.v() });
        if (paramCrashStrategyBean.getStoreDirectoryPath() == null)
        {
          if (!com.tencent.feedback.common.a.f(paramContext)) {
            return false;
          }
          int i = paramCrashStrategyBean.getCrashSdcardMaxSize();
          com.tencent.feedback.common.e.b("rqdp{  sv sd start}", new Object[0]);
          if (str1 == null) {
            break label371;
          }
          if (str1.trim().length() <= 0) {
            return true;
          }
          if (Environment.getExternalStorageState().equals("mounted"))
          {
            parame = Environment.getExternalStorageDirectory();
            paramCrashStrategyBean = new StringBuilder("/Tencent/");
            paramCrashStrategyBean.append(com.tencent.feedback.common.a.b(paramContext));
            paramCrashStrategyBean.append("/euplog.txt");
            com.tencent.feedback.proguard.a.a(new File(parame, paramCrashStrategyBean.toString()).getAbsolutePath(), str1, i);
          }
          com.tencent.feedback.common.e.b("rqdp{  sv sd end}", new Object[0]);
          return true;
        }
        parame = new File(paramCrashStrategyBean.getStoreDirectoryPath());
        paramContext = parame;
        if (!parame.isFile()) {
          paramContext = parame.getParentFile();
        }
        com.tencent.feedback.proguard.a.a(new File(paramContext, "euplog.txt").getAbsolutePath(), str1, paramCrashStrategyBean.getCrashSdcardMaxSize());
        return true;
      }
      catch (Throwable paramContext)
      {
        com.tencent.feedback.common.e.c("rqdp{  save error} %s", new Object[] { paramContext.toString() });
        if (!com.tencent.feedback.common.e.a(paramContext)) {
          paramContext.printStackTrace();
        }
      }
    } else {
      return false;
    }
    label371:
    return true;
  }
  
  public static int b(Context paramContext)
  {
    com.tencent.feedback.common.e.b("rqdp{  EUPDAO.querySum() start}", new Object[0]);
    if (paramContext == null)
    {
      com.tencent.feedback.common.e.c("rqdp{  querySum() context is null arg}", new Object[0]);
      return -1;
    }
    return l.a(paramContext, new int[] { 2, 1 }, -1L, 9223372036854775807L, null);
  }
  
  /* Error */
  public static boolean b(Context paramContext, List<e> paramList)
  {
    // Byte code:
    //   0: ldc_w 641
    //   3: iconst_0
    //   4: anewarray 4	java/lang/Object
    //   7: invokestatic 30	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   10: pop
    //   11: aload_0
    //   12: ifnull +144 -> 156
    //   15: aload_1
    //   16: ifnull +140 -> 156
    //   19: aload_1
    //   20: invokeinterface 41 1 0
    //   25: ifgt +6 -> 31
    //   28: goto +128 -> 156
    //   31: new 386	java/util/ArrayList
    //   34: dup
    //   35: invokespecial 387	java/util/ArrayList:<init>	()V
    //   38: astore_3
    //   39: aload_1
    //   40: invokeinterface 428 1 0
    //   45: astore_1
    //   46: aload_1
    //   47: invokeinterface 402 1 0
    //   52: ifeq +32 -> 84
    //   55: aload_1
    //   56: invokeinterface 406 1 0
    //   61: checkcast 49	com/tencent/feedback/eup/e
    //   64: invokestatic 519	com/tencent/feedback/eup/b:a	(Lcom/tencent/feedback/eup/e;)Lcom/tencent/feedback/proguard/l;
    //   67: astore 4
    //   69: aload 4
    //   71: ifnull -25 -> 46
    //   74: aload_3
    //   75: aload 4
    //   77: invokevirtual 449	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   80: pop
    //   81: goto -35 -> 46
    //   84: aload_0
    //   85: aload_3
    //   86: invokestatic 643	com/tencent/feedback/proguard/l:b	(Landroid/content/Context;Ljava/util/List;)Z
    //   89: istore_2
    //   90: ldc_w 645
    //   93: iconst_0
    //   94: anewarray 4	java/lang/Object
    //   97: invokestatic 30	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   100: pop
    //   101: iload_2
    //   102: ireturn
    //   103: astore_0
    //   104: goto +39 -> 143
    //   107: astore_0
    //   108: aload_0
    //   109: invokestatic 89	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   112: ifne +7 -> 119
    //   115: aload_0
    //   116: invokevirtual 92	java/lang/Throwable:printStackTrace	()V
    //   119: ldc_w 530
    //   122: iconst_0
    //   123: anewarray 4	java/lang/Object
    //   126: invokestatic 456	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   129: pop
    //   130: ldc_w 645
    //   133: iconst_0
    //   134: anewarray 4	java/lang/Object
    //   137: invokestatic 30	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   140: pop
    //   141: iconst_0
    //   142: ireturn
    //   143: ldc_w 645
    //   146: iconst_0
    //   147: anewarray 4	java/lang/Object
    //   150: invokestatic 30	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   153: pop
    //   154: aload_0
    //   155: athrow
    //   156: ldc_w 647
    //   159: iconst_0
    //   160: anewarray 4	java/lang/Object
    //   163: invokestatic 35	com/tencent/feedback/common/e:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   166: pop
    //   167: iconst_0
    //   168: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	169	0	paramContext	Context
    //   0	169	1	paramList	List<e>
    //   89	13	2	bool	boolean
    //   38	48	3	localArrayList	ArrayList
    //   67	9	4	locall	l
    // Exception table:
    //   from	to	target	type
    //   31	46	103	finally
    //   46	69	103	finally
    //   74	81	103	finally
    //   84	90	103	finally
    //   108	119	103	finally
    //   119	130	103	finally
    //   31	46	107	java/lang/Throwable
    //   46	69	107	java/lang/Throwable
    //   74	81	107	java/lang/Throwable
    //   84	90	107	java/lang/Throwable
  }
  
  public b a(byte paramByte, String paramString)
  {
    a(paramString);
    paramString = this.a;
    paramString.append(paramByte);
    paramString.append('\n');
    return this;
  }
  
  public b a(char paramChar, String paramString)
  {
    a(paramString);
    paramString = this.a;
    paramString.append(paramChar);
    paramString.append('\n');
    return this;
  }
  
  public b a(double paramDouble, String paramString)
  {
    a(paramString);
    paramString = this.a;
    paramString.append(paramDouble);
    paramString.append('\n');
    return this;
  }
  
  public b a(float paramFloat, String paramString)
  {
    a(paramString);
    paramString = this.a;
    paramString.append(paramFloat);
    paramString.append('\n');
    return this;
  }
  
  public b a(int paramInt, String paramString)
  {
    a(paramString);
    paramString = this.a;
    paramString.append(paramInt);
    paramString.append('\n');
    return this;
  }
  
  public b a(long paramLong, String paramString)
  {
    a(paramString);
    paramString = this.a;
    paramString.append(paramLong);
    paramString.append('\n');
    return this;
  }
  
  public b a(j paramj, String paramString)
  {
    a('{', paramString);
    if (paramj == null)
    {
      paramj = this.a;
      paramj.append('\t');
      paramj.append("null");
    }
    else
    {
      paramj.a(this.a, this.b + 1);
    }
    a('}', null);
    return this;
  }
  
  public <T> b a(T paramT, String paramString)
  {
    if (paramT == null)
    {
      this.a.append("null\n");
      return this;
    }
    if ((paramT instanceof Byte))
    {
      a(((Byte)paramT).byteValue(), paramString);
      return this;
    }
    if ((paramT instanceof Boolean))
    {
      a(((Boolean)paramT).booleanValue(), paramString);
      return this;
    }
    if ((paramT instanceof Short))
    {
      a(((Short)paramT).shortValue(), paramString);
      return this;
    }
    if ((paramT instanceof Integer))
    {
      a(((Integer)paramT).intValue(), paramString);
      return this;
    }
    if ((paramT instanceof Long))
    {
      a(((Long)paramT).longValue(), paramString);
      return this;
    }
    if ((paramT instanceof Float))
    {
      a(((Float)paramT).floatValue(), paramString);
      return this;
    }
    if ((paramT instanceof Double))
    {
      a(((Double)paramT).doubleValue(), paramString);
      return this;
    }
    if ((paramT instanceof String))
    {
      a((String)paramT, paramString);
      return this;
    }
    if ((paramT instanceof Map))
    {
      a((Map)paramT, paramString);
      return this;
    }
    if ((paramT instanceof List))
    {
      a((List)paramT, paramString);
      return this;
    }
    if ((paramT instanceof j))
    {
      a((j)paramT, paramString);
      return this;
    }
    if ((paramT instanceof byte[]))
    {
      a((byte[])paramT, paramString);
      return this;
    }
    if ((paramT instanceof boolean[]))
    {
      a((boolean[])paramT, paramString);
      return this;
    }
    if ((paramT instanceof short[]))
    {
      a((short[])paramT, paramString);
      return this;
    }
    if ((paramT instanceof int[]))
    {
      a((int[])paramT, paramString);
      return this;
    }
    if ((paramT instanceof long[]))
    {
      a((long[])paramT, paramString);
      return this;
    }
    if ((paramT instanceof float[]))
    {
      a((float[])paramT, paramString);
      return this;
    }
    if ((paramT instanceof double[]))
    {
      a((double[])paramT, paramString);
      return this;
    }
    if (paramT.getClass().isArray())
    {
      a((Object[])paramT, paramString);
      return this;
    }
    throw new com.tencent.feedback.proguard.b("write object error: unsupport type.");
  }
  
  public b a(String paramString1, String paramString2)
  {
    a(paramString2);
    if (paramString1 == null)
    {
      this.a.append("null\n");
      return this;
    }
    paramString2 = this.a;
    paramString2.append(paramString1);
    paramString2.append('\n');
    return this;
  }
  
  public <T> b a(Collection<T> paramCollection, String paramString)
  {
    if (paramCollection == null)
    {
      a(paramString);
      this.a.append("null\t");
      return this;
    }
    return a(paramCollection.toArray(), paramString);
  }
  
  public <K, V> b a(Map<K, V> paramMap, String paramString)
  {
    a(paramString);
    if (paramMap == null)
    {
      this.a.append("null\n");
      return this;
    }
    if (paramMap.isEmpty())
    {
      paramString = this.a;
      paramString.append(paramMap.size());
      paramString.append(", {}\n");
      return this;
    }
    paramString = this.a;
    paramString.append(paramMap.size());
    paramString.append(", {\n");
    paramString = new b(this.a, this.b + 1);
    b localb = new b(this.a, this.b + 2);
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      paramString.a('(', null);
      localb.a(localEntry.getKey(), null);
      localb.a(localEntry.getValue(), null);
      paramString.a(')', null);
    }
    a('}', null);
    return this;
  }
  
  public b a(short paramShort, String paramString)
  {
    a(paramString);
    paramString = this.a;
    paramString.append(paramShort);
    paramString.append('\n');
    return this;
  }
  
  public b a(boolean paramBoolean, String paramString)
  {
    a(paramString);
    paramString = this.a;
    char c;
    if (paramBoolean) {
      c = 'T';
    } else {
      c = 'F';
    }
    paramString.append(c);
    paramString.append('\n');
    return this;
  }
  
  public b a(byte[] paramArrayOfByte, String paramString)
  {
    a(paramString);
    if (paramArrayOfByte == null)
    {
      this.a.append("null\n");
      return this;
    }
    if (paramArrayOfByte.length == 0)
    {
      paramString = this.a;
      paramString.append(paramArrayOfByte.length);
      paramString.append(", []\n");
      return this;
    }
    paramString = this.a;
    paramString.append(paramArrayOfByte.length);
    paramString.append(", [\n");
    paramString = new b(this.a, this.b + 1);
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      paramString.a(paramArrayOfByte[i], null);
      i += 1;
    }
    a(']', null);
    return this;
  }
  
  public b a(double[] paramArrayOfDouble, String paramString)
  {
    a(paramString);
    if (paramArrayOfDouble == null)
    {
      this.a.append("null\n");
      return this;
    }
    if (paramArrayOfDouble.length == 0)
    {
      paramString = this.a;
      paramString.append(paramArrayOfDouble.length);
      paramString.append(", []\n");
      return this;
    }
    paramString = this.a;
    paramString.append(paramArrayOfDouble.length);
    paramString.append(", [\n");
    paramString = new b(this.a, this.b + 1);
    int j = paramArrayOfDouble.length;
    int i = 0;
    while (i < j)
    {
      paramString.a(paramArrayOfDouble[i], null);
      i += 1;
    }
    a(']', null);
    return this;
  }
  
  public b a(float[] paramArrayOfFloat, String paramString)
  {
    a(paramString);
    if (paramArrayOfFloat == null)
    {
      this.a.append("null\n");
      return this;
    }
    if (paramArrayOfFloat.length == 0)
    {
      paramString = this.a;
      paramString.append(paramArrayOfFloat.length);
      paramString.append(", []\n");
      return this;
    }
    paramString = this.a;
    paramString.append(paramArrayOfFloat.length);
    paramString.append(", [\n");
    paramString = new b(this.a, this.b + 1);
    int j = paramArrayOfFloat.length;
    int i = 0;
    while (i < j)
    {
      paramString.a(paramArrayOfFloat[i], null);
      i += 1;
    }
    a(']', null);
    return this;
  }
  
  public b a(int[] paramArrayOfInt, String paramString)
  {
    a(paramString);
    if (paramArrayOfInt == null)
    {
      this.a.append("null\n");
      return this;
    }
    if (paramArrayOfInt.length == 0)
    {
      paramString = this.a;
      paramString.append(paramArrayOfInt.length);
      paramString.append(", []\n");
      return this;
    }
    paramString = this.a;
    paramString.append(paramArrayOfInt.length);
    paramString.append(", [\n");
    paramString = new b(this.a, this.b + 1);
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      paramString.a(paramArrayOfInt[i], null);
      i += 1;
    }
    a(']', null);
    return this;
  }
  
  public b a(long[] paramArrayOfLong, String paramString)
  {
    a(paramString);
    if (paramArrayOfLong == null)
    {
      this.a.append("null\n");
      return this;
    }
    if (paramArrayOfLong.length == 0)
    {
      paramString = this.a;
      paramString.append(paramArrayOfLong.length);
      paramString.append(", []\n");
      return this;
    }
    paramString = this.a;
    paramString.append(paramArrayOfLong.length);
    paramString.append(", [\n");
    paramString = new b(this.a, this.b + 1);
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      paramString.a(paramArrayOfLong[i], null);
      i += 1;
    }
    a(']', null);
    return this;
  }
  
  public <T> b a(T[] paramArrayOfT, String paramString)
  {
    a(paramString);
    if (paramArrayOfT == null)
    {
      this.a.append("null\n");
      return this;
    }
    if (paramArrayOfT.length == 0)
    {
      paramString = this.a;
      paramString.append(paramArrayOfT.length);
      paramString.append(", []\n");
      return this;
    }
    paramString = this.a;
    paramString.append(paramArrayOfT.length);
    paramString.append(", [\n");
    paramString = new b(this.a, this.b + 1);
    int j = paramArrayOfT.length;
    int i = 0;
    while (i < j)
    {
      paramString.a(paramArrayOfT[i], null);
      i += 1;
    }
    a(']', null);
    return this;
  }
  
  public b a(short[] paramArrayOfShort, String paramString)
  {
    a(paramString);
    if (paramArrayOfShort == null)
    {
      this.a.append("null\n");
      return this;
    }
    if (paramArrayOfShort.length == 0)
    {
      paramString = this.a;
      paramString.append(paramArrayOfShort.length);
      paramString.append(", []\n");
      return this;
    }
    paramString = this.a;
    paramString.append(paramArrayOfShort.length);
    paramString.append(", [\n");
    paramString = new b(this.a, this.b + 1);
    int j = paramArrayOfShort.length;
    int i = 0;
    while (i < j)
    {
      paramString.a(paramArrayOfShort[i], null);
      i += 1;
    }
    a(']', null);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.feedback.eup.b
 * JD-Core Version:    0.7.0.1
 */