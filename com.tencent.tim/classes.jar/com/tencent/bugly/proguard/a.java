package com.tencent.bugly.proguard;

import com.tencent.bugly.crashreport.biz.UserInfoBean;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class a
{
  protected HashMap<String, HashMap<String, byte[]>> a = new HashMap();
  protected String b;
  i c;
  private HashMap<String, Object> d;
  
  a()
  {
    new HashMap();
    this.d = new HashMap();
    this.b = "GBK";
    this.c = new i();
  }
  
  /* Error */
  public static am a(android.content.Context paramContext, int paramInt, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: invokestatic 42	com/tencent/bugly/crashreport/common/info/a:b	()Lcom/tencent/bugly/crashreport/common/info/a;
    //   3: astore 5
    //   5: invokestatic 47	com/tencent/bugly/crashreport/common/strategy/a:a	()Lcom/tencent/bugly/crashreport/common/strategy/a;
    //   8: invokevirtual 50	com/tencent/bugly/crashreport/common/strategy/a:c	()Lcom/tencent/bugly/crashreport/common/strategy/StrategyBean;
    //   11: astore 6
    //   13: aload 5
    //   15: ifnull +8 -> 23
    //   18: aload 6
    //   20: ifnonnull +15 -> 35
    //   23: ldc 52
    //   25: iconst_0
    //   26: anewarray 4	java/lang/Object
    //   29: invokestatic 58	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   32: pop
    //   33: aconst_null
    //   34: areturn
    //   35: new 60	com/tencent/bugly/proguard/am
    //   38: dup
    //   39: invokespecial 61	com/tencent/bugly/proguard/am:<init>	()V
    //   42: astore 4
    //   44: aload 5
    //   46: monitorenter
    //   47: aload 4
    //   49: iconst_1
    //   50: putfield 64	com/tencent/bugly/proguard/am:a	I
    //   53: aload 4
    //   55: aload 5
    //   57: invokevirtual 67	com/tencent/bugly/crashreport/common/info/a:e	()Ljava/lang/String;
    //   60: putfield 68	com/tencent/bugly/proguard/am:b	Ljava/lang/String;
    //   63: aload 4
    //   65: aload 5
    //   67: getfield 70	com/tencent/bugly/crashreport/common/info/a:c	Ljava/lang/String;
    //   70: putfield 71	com/tencent/bugly/proguard/am:c	Ljava/lang/String;
    //   73: aload 4
    //   75: aload 5
    //   77: getfield 74	com/tencent/bugly/crashreport/common/info/a:l	Ljava/lang/String;
    //   80: putfield 76	com/tencent/bugly/proguard/am:d	Ljava/lang/String;
    //   83: aload 4
    //   85: aload 5
    //   87: getfield 79	com/tencent/bugly/crashreport/common/info/a:n	Ljava/lang/String;
    //   90: putfield 81	com/tencent/bugly/proguard/am:e	Ljava/lang/String;
    //   93: aload 4
    //   95: aload 5
    //   97: getfield 84	com/tencent/bugly/crashreport/common/info/a:g	Ljava/lang/String;
    //   100: putfield 87	com/tencent/bugly/proguard/am:f	Ljava/lang/String;
    //   103: aload 4
    //   105: iload_1
    //   106: putfield 89	com/tencent/bugly/proguard/am:g	I
    //   109: aload_2
    //   110: astore_3
    //   111: aload_2
    //   112: ifnonnull +9 -> 121
    //   115: ldc 91
    //   117: invokevirtual 97	java/lang/String:getBytes	()[B
    //   120: astore_3
    //   121: aload 4
    //   123: aload_3
    //   124: putfield 101	com/tencent/bugly/proguard/am:h	[B
    //   127: aload 4
    //   129: aload 5
    //   131: invokevirtual 103	com/tencent/bugly/crashreport/common/info/a:h	()Ljava/lang/String;
    //   134: putfield 106	com/tencent/bugly/proguard/am:i	Ljava/lang/String;
    //   137: aload 4
    //   139: aload 5
    //   141: getfield 107	com/tencent/bugly/crashreport/common/info/a:i	Ljava/lang/String;
    //   144: putfield 110	com/tencent/bugly/proguard/am:j	Ljava/lang/String;
    //   147: aload 4
    //   149: new 19	java/util/HashMap
    //   152: dup
    //   153: invokespecial 20	java/util/HashMap:<init>	()V
    //   156: putfield 114	com/tencent/bugly/proguard/am:k	Ljava/util/Map;
    //   159: aload 4
    //   161: aload 5
    //   163: invokevirtual 116	com/tencent/bugly/crashreport/common/info/a:d	()Ljava/lang/String;
    //   166: putfield 117	com/tencent/bugly/proguard/am:l	Ljava/lang/String;
    //   169: aload 4
    //   171: aload 6
    //   173: getfield 122	com/tencent/bugly/crashreport/common/strategy/StrategyBean:n	J
    //   176: putfield 125	com/tencent/bugly/proguard/am:m	J
    //   179: aload 4
    //   181: aload 5
    //   183: invokevirtual 127	com/tencent/bugly/crashreport/common/info/a:g	()Ljava/lang/String;
    //   186: putfield 130	com/tencent/bugly/proguard/am:o	Ljava/lang/String;
    //   189: aload 4
    //   191: aload_0
    //   192: invokestatic 135	com/tencent/bugly/crashreport/common/info/b:b	(Landroid/content/Context;)Ljava/lang/String;
    //   195: putfield 138	com/tencent/bugly/proguard/am:p	Ljava/lang/String;
    //   198: aload 4
    //   200: invokestatic 144	java/lang/System:currentTimeMillis	()J
    //   203: putfield 147	com/tencent/bugly/proguard/am:q	J
    //   206: aload 4
    //   208: aload 5
    //   210: invokevirtual 149	com/tencent/bugly/crashreport/common/info/a:i	()Ljava/lang/String;
    //   213: putfield 152	com/tencent/bugly/proguard/am:r	Ljava/lang/String;
    //   216: aload 4
    //   218: new 154	java/lang/StringBuilder
    //   221: dup
    //   222: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   225: aload 5
    //   227: invokevirtual 127	com/tencent/bugly/crashreport/common/info/a:g	()Ljava/lang/String;
    //   230: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   236: putfield 165	com/tencent/bugly/proguard/am:s	Ljava/lang/String;
    //   239: aload 4
    //   241: aload 4
    //   243: getfield 138	com/tencent/bugly/proguard/am:p	Ljava/lang/String;
    //   246: putfield 168	com/tencent/bugly/proguard/am:t	Ljava/lang/String;
    //   249: aload 5
    //   251: invokevirtual 172	java/lang/Object:getClass	()Ljava/lang/Class;
    //   254: pop
    //   255: aload 4
    //   257: ldc 174
    //   259: putfield 175	com/tencent/bugly/proguard/am:n	Ljava/lang/String;
    //   262: aload 4
    //   264: getfield 114	com/tencent/bugly/proguard/am:k	Ljava/util/Map;
    //   267: ldc 177
    //   269: new 154	java/lang/StringBuilder
    //   272: dup
    //   273: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   276: aload 5
    //   278: invokevirtual 179	com/tencent/bugly/crashreport/common/info/a:s	()Ljava/lang/String;
    //   281: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   287: invokeinterface 185 3 0
    //   292: pop
    //   293: aload 4
    //   295: getfield 114	com/tencent/bugly/proguard/am:k	Ljava/util/Map;
    //   298: ldc 187
    //   300: new 154	java/lang/StringBuilder
    //   303: dup
    //   304: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   307: aload 5
    //   309: invokevirtual 191	com/tencent/bugly/crashreport/common/info/a:D	()Z
    //   312: invokevirtual 194	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   315: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   318: invokeinterface 185 3 0
    //   323: pop
    //   324: aload 4
    //   326: getfield 114	com/tencent/bugly/proguard/am:k	Ljava/util/Map;
    //   329: ldc 196
    //   331: new 154	java/lang/StringBuilder
    //   334: dup
    //   335: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   338: aload 5
    //   340: invokevirtual 199	com/tencent/bugly/crashreport/common/info/a:E	()Z
    //   343: invokevirtual 194	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   346: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   349: invokeinterface 185 3 0
    //   354: pop
    //   355: aload 4
    //   357: getfield 114	com/tencent/bugly/proguard/am:k	Ljava/util/Map;
    //   360: ldc 201
    //   362: new 154	java/lang/StringBuilder
    //   365: dup
    //   366: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   369: aload 5
    //   371: getfield 205	com/tencent/bugly/crashreport/common/info/a:B	Z
    //   374: invokevirtual 194	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   377: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   380: invokeinterface 185 3 0
    //   385: pop
    //   386: aload 4
    //   388: getfield 114	com/tencent/bugly/proguard/am:k	Ljava/util/Map;
    //   391: ldc 207
    //   393: new 154	java/lang/StringBuilder
    //   396: dup
    //   397: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   400: aload 5
    //   402: getfield 210	com/tencent/bugly/crashreport/common/info/a:A	Z
    //   405: invokevirtual 194	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   408: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   411: invokeinterface 185 3 0
    //   416: pop
    //   417: aload 4
    //   419: getfield 114	com/tencent/bugly/proguard/am:k	Ljava/util/Map;
    //   422: ldc 212
    //   424: new 154	java/lang/StringBuilder
    //   427: dup
    //   428: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   431: aload 5
    //   433: getfield 214	com/tencent/bugly/crashreport/common/info/a:m	Ljava/lang/String;
    //   436: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   439: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   442: invokeinterface 185 3 0
    //   447: pop
    //   448: getstatic 219	com/tencent/bugly/b:b	Ljava/util/List;
    //   451: ifnull +87 -> 538
    //   454: getstatic 219	com/tencent/bugly/b:b	Ljava/util/List;
    //   457: invokeinterface 225 1 0
    //   462: astore_0
    //   463: aload_0
    //   464: invokeinterface 230 1 0
    //   469: ifeq +69 -> 538
    //   472: aload_0
    //   473: invokeinterface 234 1 0
    //   478: checkcast 236	com/tencent/bugly/a
    //   481: astore_2
    //   482: aload_2
    //   483: getfield 239	com/tencent/bugly/a:versionKey	Ljava/lang/String;
    //   486: ifnull -23 -> 463
    //   489: aload_2
    //   490: getfield 242	com/tencent/bugly/a:version	Ljava/lang/String;
    //   493: ifnull -30 -> 463
    //   496: aload 4
    //   498: getfield 114	com/tencent/bugly/proguard/am:k	Ljava/util/Map;
    //   501: aload_2
    //   502: getfield 239	com/tencent/bugly/a:versionKey	Ljava/lang/String;
    //   505: aload_2
    //   506: getfield 242	com/tencent/bugly/a:version	Ljava/lang/String;
    //   509: invokeinterface 185 3 0
    //   514: pop
    //   515: goto -52 -> 463
    //   518: astore_0
    //   519: aload 5
    //   521: monitorexit
    //   522: aload_0
    //   523: athrow
    //   524: astore_0
    //   525: aload_0
    //   526: invokestatic 245	com/tencent/bugly/proguard/x:b	(Ljava/lang/Throwable;)Z
    //   529: ifne +7 -> 536
    //   532: aload_0
    //   533: invokevirtual 248	java/lang/Throwable:printStackTrace	()V
    //   536: aconst_null
    //   537: areturn
    //   538: aload 4
    //   540: getfield 114	com/tencent/bugly/proguard/am:k	Ljava/util/Map;
    //   543: ldc 250
    //   545: ldc 250
    //   547: ldc 91
    //   549: invokestatic 255	com/tencent/bugly/proguard/z:c	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   552: invokeinterface 185 3 0
    //   557: pop
    //   558: aload 4
    //   560: getfield 114	com/tencent/bugly/proguard/am:k	Ljava/util/Map;
    //   563: ldc_w 257
    //   566: ldc_w 257
    //   569: ldc 91
    //   571: invokestatic 255	com/tencent/bugly/proguard/z:c	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   574: invokeinterface 185 3 0
    //   579: pop
    //   580: aload 4
    //   582: getfield 114	com/tencent/bugly/proguard/am:k	Ljava/util/Map;
    //   585: ldc_w 259
    //   588: ldc_w 259
    //   591: ldc_w 261
    //   594: invokestatic 255	com/tencent/bugly/proguard/z:c	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   597: invokeinterface 185 3 0
    //   602: pop
    //   603: aload 5
    //   605: monitorexit
    //   606: aload 5
    //   608: invokevirtual 265	com/tencent/bugly/crashreport/common/info/a:x	()Ljava/util/Map;
    //   611: astore_0
    //   612: aload_0
    //   613: ifnull +60 -> 673
    //   616: aload_0
    //   617: invokeinterface 269 1 0
    //   622: invokeinterface 272 1 0
    //   627: astore_0
    //   628: aload_0
    //   629: invokeinterface 230 1 0
    //   634: ifeq +39 -> 673
    //   637: aload_0
    //   638: invokeinterface 234 1 0
    //   643: checkcast 274	java/util/Map$Entry
    //   646: astore_2
    //   647: aload 4
    //   649: getfield 114	com/tencent/bugly/proguard/am:k	Ljava/util/Map;
    //   652: aload_2
    //   653: invokeinterface 277 1 0
    //   658: aload_2
    //   659: invokeinterface 280 1 0
    //   664: invokeinterface 185 3 0
    //   669: pop
    //   670: goto -42 -> 628
    //   673: aload 4
    //   675: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	676	0	paramContext	android.content.Context
    //   0	676	1	paramInt	int
    //   0	676	2	paramArrayOfByte	byte[]
    //   110	14	3	arrayOfByte	byte[]
    //   42	632	4	localam	am
    //   3	604	5	locala	com.tencent.bugly.crashreport.common.info.a
    //   11	161	6	localStrategyBean	com.tencent.bugly.crashreport.common.strategy.StrategyBean
    // Exception table:
    //   from	to	target	type
    //   47	109	518	finally
    //   115	121	518	finally
    //   121	463	518	finally
    //   463	515	518	finally
    //   538	606	518	finally
    //   35	47	524	java/lang/Throwable
    //   519	524	524	java/lang/Throwable
    //   606	612	524	java/lang/Throwable
    //   616	628	524	java/lang/Throwable
    //   628	670	524	java/lang/Throwable
  }
  
  public static aq a(UserInfoBean paramUserInfoBean)
  {
    if (paramUserInfoBean == null) {
      return null;
    }
    aq localaq = new aq();
    localaq.a = paramUserInfoBean.e;
    localaq.e = paramUserInfoBean.j;
    localaq.d = paramUserInfoBean.c;
    localaq.c = paramUserInfoBean.d;
    if (paramUserInfoBean.o == 1)
    {
      bool = true;
      localaq.g = bool;
      switch (paramUserInfoBean.b)
      {
      default: 
        if ((paramUserInfoBean.b < 10) || (paramUserInfoBean.b >= 20)) {
          break;
        }
        localaq.b = ((byte)paramUserInfoBean.b);
      }
    }
    else
    {
      for (;;)
      {
        localaq.f = new HashMap();
        if (paramUserInfoBean.p >= 0) {
          localaq.f.put("C01", paramUserInfoBean.p);
        }
        if (paramUserInfoBean.q >= 0) {
          localaq.f.put("C02", paramUserInfoBean.q);
        }
        if ((paramUserInfoBean.r == null) || (paramUserInfoBean.r.size() <= 0)) {
          break label368;
        }
        localObject1 = paramUserInfoBean.r.entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Map.Entry)((Iterator)localObject1).next();
          localaq.f.put("C03_" + (String)((Map.Entry)localObject2).getKey(), ((Map.Entry)localObject2).getValue());
        }
        bool = false;
        break;
        localaq.b = 1;
        continue;
        localaq.b = 2;
        continue;
        localaq.b = 4;
        continue;
        localaq.b = 3;
      }
    }
    x.e("unknown uinfo type %d ", new Object[] { Integer.valueOf(paramUserInfoBean.b) });
    return null;
    label368:
    if ((paramUserInfoBean.s != null) && (paramUserInfoBean.s.size() > 0))
    {
      localObject1 = paramUserInfoBean.s.entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        localaq.f.put("C04_" + (String)((Map.Entry)localObject2).getKey(), ((Map.Entry)localObject2).getValue());
      }
    }
    Object localObject1 = localaq.f;
    Object localObject2 = new StringBuilder();
    if (!paramUserInfoBean.l) {}
    for (boolean bool = true;; bool = false)
    {
      ((Map)localObject1).put("A36", bool);
      localaq.f.put("F02", paramUserInfoBean.g);
      localaq.f.put("F03", paramUserInfoBean.h);
      localaq.f.put("F04", paramUserInfoBean.j);
      localaq.f.put("F05", paramUserInfoBean.i);
      localaq.f.put("F06", paramUserInfoBean.m);
      localaq.f.put("F10", paramUserInfoBean.k);
      x.c("summary type %d vm:%d", new Object[] { Byte.valueOf(localaq.b), Integer.valueOf(localaq.f.size()) });
      return localaq;
    }
  }
  
  public static ar a(List<UserInfoBean> paramList, int paramInt)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return null;
    }
    Object localObject = com.tencent.bugly.crashreport.common.info.a.b();
    if (localObject == null) {
      return null;
    }
    ((com.tencent.bugly.crashreport.common.info.a)localObject).o();
    ar localar = new ar();
    localar.b = ((com.tencent.bugly.crashreport.common.info.a)localObject).d;
    localar.c = ((com.tencent.bugly.crashreport.common.info.a)localObject).g();
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      aq localaq = a((UserInfoBean)paramList.next());
      if (localaq != null) {
        localArrayList.add(localaq);
      }
    }
    localar.d = localArrayList;
    localar.e = new HashMap();
    localar.e.put("A7", ((com.tencent.bugly.crashreport.common.info.a)localObject).h);
    localar.e.put("A6", ((com.tencent.bugly.crashreport.common.info.a)localObject).n());
    localar.e.put("A5", ((com.tencent.bugly.crashreport.common.info.a)localObject).m());
    localar.e.put("A2", ((com.tencent.bugly.crashreport.common.info.a)localObject).k());
    localar.e.put("A1", ((com.tencent.bugly.crashreport.common.info.a)localObject).k());
    localar.e.put("A24", ((com.tencent.bugly.crashreport.common.info.a)localObject).i);
    localar.e.put("A17", ((com.tencent.bugly.crashreport.common.info.a)localObject).l());
    localar.e.put("A15", ((com.tencent.bugly.crashreport.common.info.a)localObject).q());
    localar.e.put("A13", ((com.tencent.bugly.crashreport.common.info.a)localObject).r());
    localar.e.put("F08", ((com.tencent.bugly.crashreport.common.info.a)localObject).w);
    localar.e.put("F09", ((com.tencent.bugly.crashreport.common.info.a)localObject).x);
    paramList = ((com.tencent.bugly.crashreport.common.info.a)localObject).y();
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.entrySet().iterator();
      while (paramList.hasNext())
      {
        localObject = (Map.Entry)paramList.next();
        localar.e.put("C04_" + (String)((Map.Entry)localObject).getKey(), ((Map.Entry)localObject).getValue());
      }
    }
    switch (paramInt)
    {
    default: 
      x.e("unknown up type %d ", new Object[] { Integer.valueOf(paramInt) });
      return null;
    }
    for (localar.a = 1;; localar.a = 2) {
      return localar;
    }
  }
  
  public static <T extends k> T a(byte[] paramArrayOfByte, Class<T> paramClass)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
      return null;
    }
    try
    {
      paramClass = (k)paramClass.newInstance();
      paramArrayOfByte = new i(paramArrayOfByte);
      paramArrayOfByte.a("utf-8");
      paramClass.a(paramArrayOfByte);
      return paramClass;
    }
    catch (Throwable paramArrayOfByte)
    {
      if (!x.b(paramArrayOfByte)) {
        paramArrayOfByte.printStackTrace();
      }
    }
    return null;
  }
  
  public static String a(ArrayList<String> paramArrayList)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    String str1;
    if (i < paramArrayList.size())
    {
      String str2 = (String)paramArrayList.get(i);
      if ((str2.equals("java.lang.Integer")) || (str2.equals("int"))) {
        str1 = "int32";
      }
      for (;;)
      {
        paramArrayList.set(i, str1);
        i += 1;
        break;
        if ((str2.equals("java.lang.Boolean")) || (str2.equals("boolean")))
        {
          str1 = "bool";
        }
        else if ((str2.equals("java.lang.Byte")) || (str2.equals("byte")))
        {
          str1 = "char";
        }
        else if ((str2.equals("java.lang.Double")) || (str2.equals("double")))
        {
          str1 = "double";
        }
        else if ((str2.equals("java.lang.Float")) || (str2.equals("float")))
        {
          str1 = "float";
        }
        else if ((str2.equals("java.lang.Long")) || (str2.equals("long")))
        {
          str1 = "int64";
        }
        else if ((str2.equals("java.lang.Short")) || (str2.equals("short")))
        {
          str1 = "short";
        }
        else
        {
          if (str2.equals("java.lang.Character")) {
            throw new IllegalArgumentException("can not support java.lang.Character");
          }
          if (str2.equals("java.lang.String"))
          {
            str1 = "string";
          }
          else if (str2.equals("java.util.List"))
          {
            str1 = "list";
          }
          else
          {
            str1 = str2;
            if (str2.equals("java.util.Map")) {
              str1 = "map";
            }
          }
        }
      }
    }
    Collections.reverse(paramArrayList);
    i = 0;
    if (i < paramArrayList.size())
    {
      str1 = (String)paramArrayList.get(i);
      if (str1.equals("list"))
      {
        paramArrayList.set(i - 1, "<" + (String)paramArrayList.get(i - 1));
        paramArrayList.set(0, (String)paramArrayList.get(0) + ">");
      }
      for (;;)
      {
        i += 1;
        break;
        if (str1.equals("map"))
        {
          paramArrayList.set(i - 1, "<" + (String)paramArrayList.get(i - 1) + ",");
          paramArrayList.set(0, (String)paramArrayList.get(0) + ">");
        }
        else if (str1.equals("Array"))
        {
          paramArrayList.set(i - 1, "<" + (String)paramArrayList.get(i - 1));
          paramArrayList.set(0, (String)paramArrayList.get(0) + ">");
        }
      }
    }
    Collections.reverse(paramArrayList);
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      localStringBuffer.append((String)paramArrayList.next());
    }
    return localStringBuffer.toString();
  }
  
  private void a(ArrayList<String> paramArrayList, Object paramObject)
  {
    if (paramObject.getClass().isArray())
    {
      if (!paramObject.getClass().getComponentType().toString().equals("byte")) {
        throw new IllegalArgumentException("only byte[] is supported");
      }
      if (Array.getLength(paramObject) > 0)
      {
        paramArrayList.add("java.util.List");
        a(paramArrayList, Array.get(paramObject, 0));
        return;
      }
      paramArrayList.add("Array");
      paramArrayList.add("?");
      return;
    }
    if ((paramObject instanceof Array)) {
      throw new IllegalArgumentException("can not support Array, please use List");
    }
    if ((paramObject instanceof List))
    {
      paramArrayList.add("java.util.List");
      paramObject = (List)paramObject;
      if (paramObject.size() > 0)
      {
        a(paramArrayList, paramObject.get(0));
        return;
      }
      paramArrayList.add("?");
      return;
    }
    if ((paramObject instanceof Map))
    {
      paramArrayList.add("java.util.Map");
      Object localObject = (Map)paramObject;
      if (((Map)localObject).size() > 0)
      {
        paramObject = ((Map)localObject).keySet().iterator().next();
        localObject = ((Map)localObject).get(paramObject);
        paramArrayList.add(paramObject.getClass().getName());
        a(paramArrayList, localObject);
        return;
      }
      paramArrayList.add("?");
      paramArrayList.add("?");
      return;
    }
    paramArrayList.add(paramObject.getClass().getName());
  }
  
  public static byte[] a(k paramk)
  {
    try
    {
      j localj = new j();
      localj.a("utf-8");
      paramk.a(localj);
      paramk = localj.b();
      return paramk;
    }
    catch (Throwable paramk)
    {
      if (!x.b(paramk)) {
        paramk.printStackTrace();
      }
    }
    return null;
  }
  
  public static byte[] a(Object paramObject)
  {
    try
    {
      d locald = new d();
      locald.d();
      locald.a("utf-8");
      locald.a(1);
      locald.b("RqdServer");
      locald.c("sync");
      locald.a("detail", paramObject);
      paramObject = locald.a();
      return paramObject;
    }
    catch (Throwable paramObject)
    {
      if (!x.b(paramObject)) {
        paramObject.printStackTrace();
      }
    }
    return null;
  }
  
  public static an b(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {
      try
      {
        d locald = new d();
        locald.d();
        locald.a("utf-8");
        locald.a(paramArrayOfByte);
        paramArrayOfByte = locald.b("detail", new an());
        if (!an.class.isInstance(paramArrayOfByte)) {
          break label80;
        }
        paramArrayOfByte = (an)an.class.cast(paramArrayOfByte);
        return paramArrayOfByte;
      }
      catch (Throwable paramArrayOfByte)
      {
        if (!x.b(paramArrayOfByte)) {
          paramArrayOfByte.printStackTrace();
        }
      }
    } else {
      return null;
    }
    label80:
    return null;
  }
  
  public void a(String paramString)
  {
    this.b = paramString;
  }
  
  public <T> void a(String paramString, T paramT)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("put key can not is null");
    }
    if (paramT == null) {
      throw new IllegalArgumentException("put value can not is null");
    }
    if ((paramT instanceof Set)) {
      throw new IllegalArgumentException("can not support Set");
    }
    Object localObject = new j();
    ((j)localObject).a(this.b);
    ((j)localObject).a(paramT, 0);
    localObject = l.a(((j)localObject).a());
    HashMap localHashMap = new HashMap(1);
    ArrayList localArrayList = new ArrayList(1);
    a(localArrayList, paramT);
    localHashMap.put(a(localArrayList), localObject);
    this.d.remove(paramString);
    this.a.put(paramString, localHashMap);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.c.a(paramArrayOfByte);
    this.c.a(this.b);
    paramArrayOfByte = new HashMap(1);
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("", new byte[0]);
    paramArrayOfByte.put("", localHashMap);
    this.a = this.c.a(paramArrayOfByte, 0, false);
  }
  
  public byte[] a()
  {
    j localj = new j(0);
    localj.a(this.b);
    localj.a(this.a, 0);
    return l.a(localj.a());
  }
  
  public Map<String, String> b()
  {
    return null;
  }
  
  public byte[] c()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.bugly.proguard.a
 * JD-Core Version:    0.7.0.1
 */