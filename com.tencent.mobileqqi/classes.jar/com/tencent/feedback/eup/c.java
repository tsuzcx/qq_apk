package com.tencent.feedback.eup;

import android.content.Context;
import com.tencent.feedback.proguard.V;
import com.tencent.feedback.proguard.a;
import com.tencent.feedback.proguard.h;
import com.tencent.feedback.proguard.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class c
  implements com.tencent.feedback.upload.e
{
  private Context a;
  
  public c(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public static int a(Context paramContext)
  {
    com.tencent.feedback.common.e.b("rqdp{  EUPDAO.querySum() start}", new Object[0]);
    if (paramContext == null)
    {
      com.tencent.feedback.common.e.c("rqdp{  querySum() context is null arg}", new Object[0]);
      return -1;
    }
    return l.a(paramContext, new int[] { 2, 1 }, -1L, 9223372036854775807L, null);
  }
  
  public static int a(Context paramContext, List<d> paramList)
  {
    int i = 0;
    com.tencent.feedback.common.e.b("rqdp{  EUPDAO.deleteEupList() start}", new Object[0]);
    if (paramContext == null)
    {
      com.tencent.feedback.common.e.c("rqdp{  deleteEupList() have null args!}", new Object[0]);
      i = -1;
    }
    while (paramList.size() <= 0) {
      return i;
    }
    Long[] arrayOfLong = new Long[paramList.size()];
    i = 0;
    while (i < paramList.size())
    {
      arrayOfLong[i] = Long.valueOf(((d)paramList.get(i)).a());
      i += 1;
    }
    return l.a(paramContext, arrayOfLong);
  }
  
  protected static l a(d paramd)
  {
    if (paramd == null) {
      return null;
    }
    for (;;)
    {
      try
      {
        if (paramd.b())
        {
          i = 1;
          l locall = new l(i, 0, paramd.i(), a.a(paramd));
          locall.b(paramd.o());
          locall.a(paramd.r());
          locall.a(paramd.t());
          locall.a(paramd.a());
          if (!paramd.B()) {
            break label98;
          }
          i = 1;
          locall.c(i);
          return locall;
        }
      }
      catch (Throwable paramd)
      {
        paramd.printStackTrace();
        return null;
      }
      int i = 2;
      continue;
      label98:
      i = 0;
    }
  }
  
  public static List<d> a(Context paramContext, int paramInt1, String paramString1, int paramInt2, String paramString2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong1, long paramLong2, Boolean paramBoolean)
  {
    com.tencent.feedback.common.e.b("rqdp{  EUPDAO.queryEupRecent() start}", new Object[0]);
    if ((paramContext == null) || (paramInt1 == 0) || ((paramLong2 > 0L) && (paramLong1 > paramLong2)) || ((paramInt4 > 0) && (paramInt3 > paramInt4)))
    {
      com.tencent.feedback.common.e.c("rqdp{  context == null || limitNum == 0 || (timeEnd > 0 && timeStart > timeEnd) || (maxCount > 0 && miniCount > maxCount ,pls check}", new Object[0]);
      return null;
    }
    int i;
    if ("asc".equals(paramString1))
    {
      i = 1;
      paramString1 = null;
      if (paramInt2 != 2) {
        break label138;
      }
      paramString1 = new int[1];
      paramString1[0] = 2;
      label82:
      if (paramBoolean != null) {
        break label187;
      }
      paramInt2 = -1;
    }
    for (;;)
    {
      paramString1 = l.a(paramContext, paramString1, -1, i, -1L, paramInt1, paramString2, paramInt3, paramInt4, paramInt5, paramInt6, paramLong1, paramLong2, paramInt2);
      if ((paramString1 != null) && (paramString1.size() > 0)) {
        break label205;
      }
      return null;
      i = 2;
      break;
      label138:
      if (paramInt2 == 1)
      {
        paramString1 = new int[1];
        paramString1[0] = 1;
        break label82;
      }
      if (paramInt2 < 0)
      {
        paramString1 = new int[2];
        String tmp163_162 = paramString1;
        tmp163_162[0] = 1;
        String tmp167_163 = tmp163_162;
        tmp167_163[1] = 2;
        tmp167_163;
        break label82;
      }
      com.tencent.feedback.common.e.c("rqdp{  queryEupRecent() seletedRecordType unaccepted}", new Object[0]);
      break label82;
      label187:
      if (paramBoolean.booleanValue()) {
        paramInt2 = 1;
      } else {
        paramInt2 = 0;
      }
    }
    label205:
    paramString2 = new ArrayList();
    paramBoolean = paramString1.iterator();
    while (paramBoolean.hasNext())
    {
      l locall = (l)paramBoolean.next();
      try
      {
        Object localObject = a.b(locall.b());
        if ((localObject != null) && (d.class.isInstance(localObject)))
        {
          localObject = (d)d.class.cast(localObject);
          ((d)localObject).a(locall.a());
          paramString2.add(localObject);
          paramBoolean.remove();
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        com.tencent.feedback.common.e.d("rqdp{  query have error!}", new Object[0]);
      }
    }
    if (paramString1.size() > 0)
    {
      com.tencent.feedback.common.e.b("rqdp{  there are error datas ,should be remove }" + paramString1.size(), new Object[0]);
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
  
  public static boolean a(Context paramContext, d paramd)
  {
    com.tencent.feedback.common.e.b("rqdp{  EUPDAO.insertEUP() start}", new Object[0]);
    if ((paramContext == null) || (paramd == null))
    {
      com.tencent.feedback.common.e.c("rqdp{  EUPDAO.insertEUP() have null args}", new Object[0]);
      return false;
    }
    try
    {
      l locall = a(paramd);
      if ((paramContext == null) || (locall == null)) {
        com.tencent.feedback.common.e.a("rqdp{  AnalyticsDAO.insert() have null args}", new Object[0]);
      }
      ArrayList localArrayList;
      for (boolean bool = false; bool; bool = l.a(paramContext, localArrayList))
      {
        paramd.a(locall.a());
        return true;
        localArrayList = new ArrayList();
        localArrayList.add(locall);
      }
      return false;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
      com.tencent.feedback.common.e.d("rqdp{  insert fail!}", new Object[0]);
      return false;
    }
    finally
    {
      com.tencent.feedback.common.e.b("rqdp{  EUPDAO.insertEUP() end}", new Object[0]);
    }
  }
  
  /* Error */
  public static boolean b(Context paramContext, List<d> paramList)
  {
    // Byte code:
    //   0: ldc 222
    //   2: iconst_0
    //   3: anewarray 4	java/lang/Object
    //   6: invokestatic 25	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   9: aload_0
    //   10: ifnull +16 -> 26
    //   13: aload_1
    //   14: ifnull +12 -> 26
    //   17: aload_1
    //   18: invokeinterface 50 1 0
    //   23: ifgt +14 -> 37
    //   26: ldc 224
    //   28: iconst_0
    //   29: anewarray 4	java/lang/Object
    //   32: invokestatic 30	com/tencent/feedback/common/e:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   35: iconst_0
    //   36: ireturn
    //   37: new 141	java/util/ArrayList
    //   40: dup
    //   41: invokespecial 142	java/util/ArrayList:<init>	()V
    //   44: astore_3
    //   45: aload_1
    //   46: invokeinterface 146 1 0
    //   51: astore_1
    //   52: aload_1
    //   53: invokeinterface 151 1 0
    //   58: ifeq +57 -> 115
    //   61: aload_1
    //   62: invokeinterface 155 1 0
    //   67: checkcast 58	com/tencent/feedback/eup/d
    //   70: invokestatic 209	com/tencent/feedback/eup/c:a	(Lcom/tencent/feedback/eup/d;)Lcom/tencent/feedback/proguard/l;
    //   73: astore 4
    //   75: aload 4
    //   77: ifnull -25 -> 52
    //   80: aload_3
    //   81: aload 4
    //   83: invokevirtual 177	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   86: pop
    //   87: goto -35 -> 52
    //   90: astore_0
    //   91: aload_0
    //   92: invokevirtual 116	java/lang/Throwable:printStackTrace	()V
    //   95: ldc 220
    //   97: iconst_0
    //   98: anewarray 4	java/lang/Object
    //   101: invokestatic 185	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   104: ldc 226
    //   106: iconst_0
    //   107: anewarray 4	java/lang/Object
    //   110: invokestatic 25	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   113: iconst_0
    //   114: ireturn
    //   115: aload_0
    //   116: aload_3
    //   117: invokestatic 228	com/tencent/feedback/proguard/l:b	(Landroid/content/Context;Ljava/util/List;)Z
    //   120: istore_2
    //   121: ldc 226
    //   123: iconst_0
    //   124: anewarray 4	java/lang/Object
    //   127: invokestatic 25	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   130: iload_2
    //   131: ireturn
    //   132: astore_0
    //   133: ldc 226
    //   135: iconst_0
    //   136: anewarray 4	java/lang/Object
    //   139: invokestatic 25	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   142: aload_0
    //   143: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	144	0	paramContext	Context
    //   0	144	1	paramList	List<d>
    //   120	11	2	bool	boolean
    //   44	73	3	localArrayList	ArrayList
    //   73	9	4	locall	l
    // Exception table:
    //   from	to	target	type
    //   37	52	90	java/lang/Throwable
    //   52	75	90	java/lang/Throwable
    //   80	87	90	java/lang/Throwable
    //   115	121	90	java/lang/Throwable
    //   37	52	132	finally
    //   52	75	132	finally
    //   80	87	132	finally
    //   91	104	132	finally
    //   115	121	132	finally
  }
  
  public final void a(int paramInt, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    if ((paramInt == 302) && (paramArrayOfByte != null)) {}
    for (;;)
    {
      V localV;
      try
      {
        e locale = e.k();
        if (locale == null)
        {
          com.tencent.feedback.common.e.c("rqdp{  imposiable handle response ,but no eup instance!}", new Object[0]);
          return;
        }
        localV = new V();
        localV.a(new h(paramArrayOfByte));
        localCrashStrategyBean = locale.o();
        if (localCrashStrategyBean != null) {
          break label390;
        }
        localCrashStrategyBean = locale.n();
        if (localCrashStrategyBean != null) {
          break label173;
        }
        com.tencent.feedback.common.e.f("rqdp{  init eup sStrategy by default}", new Object[0]);
        localCrashStrategyBean = new CrashStrategyBean();
        locale.a(localCrashStrategyBean);
      }
      catch (Throwable paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        com.tencent.feedback.common.e.d("rqdp{  process crash strategy error} %s", new Object[] { paramArrayOfByte.toString() });
        return;
      }
      if ((i != 0) && (paramBoolean))
      {
        com.tencent.feedback.common.e.f("rqdp{  save eup strategy}", new Object[0]);
        a.a(this.a, paramInt, paramArrayOfByte);
      }
      com.tencent.feedback.common.e.h("rqdp{  crashStrategy}[%s]", new Object[] { localV });
      return;
      label173:
      com.tencent.feedback.common.e.f("rqdp{  init eup sStrategy by uStrategy}", new Object[0]);
      CrashStrategyBean localCrashStrategyBean = localCrashStrategyBean.clone();
      continue;
      label390:
      do
      {
        if (localCrashStrategyBean.isMerged() != localV.a)
        {
          com.tencent.feedback.common.e.h("rqdp{  is merged changed} %b", new Object[] { Boolean.valueOf(localV.a) });
          localCrashStrategyBean.setMerged(localV.a);
        }
        for (i = 1;; i = 0)
        {
          if (localCrashStrategyBean.isAssertOn() != localV.b)
          {
            localCrashStrategyBean.setAssertEnable(localV.b);
            com.tencent.feedback.common.e.h("rqdp{ Assert enable changed: } %s", new Object[] { Boolean.valueOf(localV.b) });
            i = 1;
          }
          if (localCrashStrategyBean.getAssertTaskInterval() != localV.c)
          {
            localCrashStrategyBean.setAssertTaskInterval(localV.c);
            com.tencent.feedback.common.e.h("rqdp{ Assert task interval changed: } %s", new Object[] { Integer.valueOf(localV.c) });
            i = 1;
          }
          if (localCrashStrategyBean.getAssertLimitCount() == localV.d) {
            break;
          }
          localCrashStrategyBean.setAssertLimitCount(localV.d);
          com.tencent.feedback.common.e.h("rqdp{ Assert limit count changed: } %s", new Object[] { Integer.valueOf(localV.d) });
          i = 1;
          break;
        }
        continue;
        return;
      } while ((localV != null) && (localCrashStrategyBean != null));
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.feedback.eup.c
 * JD-Core Version:    0.7.0.1
 */