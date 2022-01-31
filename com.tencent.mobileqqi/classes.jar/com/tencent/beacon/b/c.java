package com.tencent.beacon.b;

import android.content.Context;
import com.tencent.beacon.a.d;
import com.tencent.beacon.a.e;
import com.tencent.beacon.event.h;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class c
  implements Runnable
{
  private Context a;
  private List<b> b;
  
  public c(Context paramContext, List<b> paramList)
  {
    this.a = paramContext;
    this.b = paramList;
  }
  
  /* Error */
  private static byte[] a(String paramString1, byte[] paramArrayOfByte, String paramString2, int paramInt, String paramString3)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: new 30	org/apache/http/params/BasicHttpParams
    //   9: dup
    //   10: invokespecial 31	org/apache/http/params/BasicHttpParams:<init>	()V
    //   13: astore 7
    //   15: aload 7
    //   17: ldc 32
    //   19: invokestatic 38	org/apache/http/params/HttpConnectionParams:setConnectionTimeout	(Lorg/apache/http/params/HttpParams;I)V
    //   22: aload 7
    //   24: ldc 32
    //   26: invokestatic 41	org/apache/http/params/HttpConnectionParams:setSoTimeout	(Lorg/apache/http/params/HttpParams;I)V
    //   29: new 43	org/apache/http/entity/ByteArrayEntity
    //   32: dup
    //   33: aload_1
    //   34: invokespecial 46	org/apache/http/entity/ByteArrayEntity:<init>	([B)V
    //   37: astore 8
    //   39: aload_2
    //   40: invokevirtual 52	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   43: ldc 54
    //   45: invokevirtual 58	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   48: ifeq +174 -> 222
    //   51: new 60	org/apache/http/client/methods/HttpPost
    //   54: dup
    //   55: aload_0
    //   56: invokespecial 63	org/apache/http/client/methods/HttpPost:<init>	(Ljava/lang/String;)V
    //   59: astore_0
    //   60: aload_0
    //   61: checkcast 60	org/apache/http/client/methods/HttpPost
    //   64: aload 8
    //   66: invokevirtual 67	org/apache/http/client/methods/HttpPost:setEntity	(Lorg/apache/http/HttpEntity;)V
    //   69: aload 6
    //   71: astore_2
    //   72: new 69	org/apache/http/impl/client/DefaultHttpClient
    //   75: dup
    //   76: aload 7
    //   78: invokespecial 72	org/apache/http/impl/client/DefaultHttpClient:<init>	(Lorg/apache/http/params/HttpParams;)V
    //   81: astore_1
    //   82: aload 4
    //   84: ifnull +81 -> 165
    //   87: aload 6
    //   89: astore_2
    //   90: aload 4
    //   92: invokevirtual 52	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   95: ldc 74
    //   97: invokevirtual 78	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   100: ifeq +65 -> 165
    //   103: aload 6
    //   105: astore_2
    //   106: new 80	java/lang/StringBuilder
    //   109: dup
    //   110: ldc 82
    //   112: invokespecial 83	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   115: aload 4
    //   117: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: iconst_0
    //   124: anewarray 4	java/lang/Object
    //   127: invokestatic 95	com/tencent/beacon/d/a:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   130: aload 6
    //   132: astore_2
    //   133: new 97	org/apache/http/HttpHost
    //   136: dup
    //   137: invokestatic 102	android/net/Proxy:getDefaultHost	()Ljava/lang/String;
    //   140: invokestatic 106	android/net/Proxy:getDefaultPort	()I
    //   143: invokespecial 109	org/apache/http/HttpHost:<init>	(Ljava/lang/String;I)V
    //   146: astore 4
    //   148: aload 6
    //   150: astore_2
    //   151: aload_1
    //   152: invokevirtual 113	org/apache/http/impl/client/DefaultHttpClient:getParams	()Lorg/apache/http/params/HttpParams;
    //   155: ldc 115
    //   157: aload 4
    //   159: invokeinterface 121 3 0
    //   164: pop
    //   165: aload 6
    //   167: astore_2
    //   168: ldc 123
    //   170: iconst_0
    //   171: anewarray 4	java/lang/Object
    //   174: invokestatic 95	com/tencent/beacon/d/a:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   177: aload 6
    //   179: astore_2
    //   180: aload_1
    //   181: aload_0
    //   182: invokevirtual 127	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    //   185: astore_0
    //   186: aload 6
    //   188: astore_2
    //   189: aload_0
    //   190: invokeinterface 133 1 0
    //   195: invokeinterface 138 1 0
    //   200: sipush 200
    //   203: if_icmpeq +82 -> 285
    //   206: aload 6
    //   208: astore_2
    //   209: ldc 140
    //   211: iconst_0
    //   212: anewarray 4	java/lang/Object
    //   215: invokestatic 143	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   218: aconst_null
    //   219: astore_2
    //   220: aload_2
    //   221: areturn
    //   222: aload_1
    //   223: ifnonnull +35 -> 258
    //   226: ldc 145
    //   228: astore_1
    //   229: new 147	org/apache/http/client/methods/HttpGet
    //   232: dup
    //   233: new 80	java/lang/StringBuilder
    //   236: dup
    //   237: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   240: aload_0
    //   241: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: aload_1
    //   245: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   251: invokespecial 149	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   254: astore_0
    //   255: goto -186 -> 69
    //   258: new 80	java/lang/StringBuilder
    //   261: dup
    //   262: ldc 151
    //   264: invokespecial 83	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   267: new 48	java/lang/String
    //   270: dup
    //   271: aload_1
    //   272: invokespecial 152	java/lang/String:<init>	([B)V
    //   275: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   281: astore_1
    //   282: goto -53 -> 229
    //   285: aload 6
    //   287: astore_2
    //   288: aload_0
    //   289: invokeinterface 156 1 0
    //   294: astore_0
    //   295: aload_0
    //   296: ifnonnull +17 -> 313
    //   299: aload 6
    //   301: astore_2
    //   302: ldc 158
    //   304: iconst_0
    //   305: anewarray 4	java/lang/Object
    //   308: invokestatic 143	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   311: aconst_null
    //   312: areturn
    //   313: aload 6
    //   315: astore_2
    //   316: ldc 160
    //   318: iconst_0
    //   319: anewarray 4	java/lang/Object
    //   322: invokestatic 95	com/tencent/beacon/d/a:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   325: aload 6
    //   327: astore_2
    //   328: new 162	java/io/DataInputStream
    //   331: dup
    //   332: aload_0
    //   333: invokeinterface 168 1 0
    //   338: invokespecial 171	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   341: astore_0
    //   342: new 173	java/io/ByteArrayOutputStream
    //   345: dup
    //   346: invokespecial 174	java/io/ByteArrayOutputStream:<init>	()V
    //   349: astore_1
    //   350: aload_0
    //   351: invokevirtual 177	java/io/DataInputStream:read	()I
    //   354: istore_3
    //   355: iload_3
    //   356: iconst_m1
    //   357: if_icmpeq +70 -> 427
    //   360: aload_1
    //   361: iload_3
    //   362: invokevirtual 181	java/io/ByteArrayOutputStream:write	(I)V
    //   365: goto -15 -> 350
    //   368: astore 4
    //   370: aconst_null
    //   371: astore_2
    //   372: aload_0
    //   373: astore_1
    //   374: aload_2
    //   375: astore_0
    //   376: aload_1
    //   377: astore_2
    //   378: aload 4
    //   380: invokevirtual 184	java/lang/Throwable:printStackTrace	()V
    //   383: aload_1
    //   384: astore_2
    //   385: aload 4
    //   387: invokevirtual 187	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   390: iconst_0
    //   391: anewarray 4	java/lang/Object
    //   394: invokestatic 143	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   397: aload_0
    //   398: astore_2
    //   399: aload_1
    //   400: ifnull -180 -> 220
    //   403: aload_1
    //   404: invokevirtual 190	java/io/DataInputStream:close	()V
    //   407: aload_0
    //   408: areturn
    //   409: astore_1
    //   410: aload_1
    //   411: invokevirtual 191	java/io/IOException:printStackTrace	()V
    //   414: aload_1
    //   415: invokevirtual 192	java/io/IOException:getMessage	()Ljava/lang/String;
    //   418: iconst_0
    //   419: anewarray 4	java/lang/Object
    //   422: invokestatic 143	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   425: aload_0
    //   426: areturn
    //   427: aload_1
    //   428: invokevirtual 195	java/io/ByteArrayOutputStream:flush	()V
    //   431: aload_1
    //   432: invokevirtual 199	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   435: astore_1
    //   436: ldc 201
    //   438: iconst_0
    //   439: anewarray 4	java/lang/Object
    //   442: invokestatic 95	com/tencent/beacon/d/a:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   445: aload_0
    //   446: invokevirtual 190	java/io/DataInputStream:close	()V
    //   449: aload_1
    //   450: areturn
    //   451: astore_0
    //   452: aload_0
    //   453: invokevirtual 191	java/io/IOException:printStackTrace	()V
    //   456: aload_0
    //   457: invokevirtual 192	java/io/IOException:getMessage	()Ljava/lang/String;
    //   460: iconst_0
    //   461: anewarray 4	java/lang/Object
    //   464: invokestatic 143	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   467: aload_1
    //   468: areturn
    //   469: astore_0
    //   470: aload_2
    //   471: ifnull +7 -> 478
    //   474: aload_2
    //   475: invokevirtual 190	java/io/DataInputStream:close	()V
    //   478: aload_0
    //   479: athrow
    //   480: astore_1
    //   481: aload_1
    //   482: invokevirtual 191	java/io/IOException:printStackTrace	()V
    //   485: aload_1
    //   486: invokevirtual 192	java/io/IOException:getMessage	()Ljava/lang/String;
    //   489: iconst_0
    //   490: anewarray 4	java/lang/Object
    //   493: invokestatic 143	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   496: goto -18 -> 478
    //   499: astore_1
    //   500: aload_0
    //   501: astore_2
    //   502: aload_1
    //   503: astore_0
    //   504: goto -34 -> 470
    //   507: astore 4
    //   509: aconst_null
    //   510: astore_0
    //   511: aload 5
    //   513: astore_1
    //   514: goto -138 -> 376
    //   517: astore 4
    //   519: aload_0
    //   520: astore_2
    //   521: aload_1
    //   522: astore_0
    //   523: aload_2
    //   524: astore_1
    //   525: goto -149 -> 376
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	528	0	paramString1	String
    //   0	528	1	paramArrayOfByte	byte[]
    //   0	528	2	paramString2	String
    //   0	528	3	paramInt	int
    //   0	528	4	paramString3	String
    //   4	508	5	localObject1	Object
    //   1	325	6	localObject2	Object
    //   13	64	7	localBasicHttpParams	org.apache.http.params.BasicHttpParams
    //   37	28	8	localByteArrayEntity	org.apache.http.entity.ByteArrayEntity
    // Exception table:
    //   from	to	target	type
    //   342	350	368	java/lang/Throwable
    //   350	355	368	java/lang/Throwable
    //   360	365	368	java/lang/Throwable
    //   427	436	368	java/lang/Throwable
    //   403	407	409	java/io/IOException
    //   445	449	451	java/io/IOException
    //   72	82	469	finally
    //   90	103	469	finally
    //   106	130	469	finally
    //   133	148	469	finally
    //   151	165	469	finally
    //   168	177	469	finally
    //   180	186	469	finally
    //   189	206	469	finally
    //   209	218	469	finally
    //   288	295	469	finally
    //   302	311	469	finally
    //   316	325	469	finally
    //   328	342	469	finally
    //   378	383	469	finally
    //   385	397	469	finally
    //   474	478	480	java/io/IOException
    //   342	350	499	finally
    //   350	355	499	finally
    //   360	365	499	finally
    //   427	436	499	finally
    //   436	445	499	finally
    //   72	82	507	java/lang/Throwable
    //   90	103	507	java/lang/Throwable
    //   106	130	507	java/lang/Throwable
    //   133	148	507	java/lang/Throwable
    //   151	165	507	java/lang/Throwable
    //   168	177	507	java/lang/Throwable
    //   180	186	507	java/lang/Throwable
    //   189	206	507	java/lang/Throwable
    //   209	218	507	java/lang/Throwable
    //   288	295	507	java/lang/Throwable
    //   302	311	507	java/lang/Throwable
    //   316	325	507	java/lang/Throwable
    //   328	342	507	java/lang/Throwable
    //   436	445	517	java/lang/Throwable
  }
  
  public final void run()
  {
    if ((this.a == null) || (this.b == null)) {
      return;
    }
    Object localObject1 = d.m();
    if (localObject1 == null)
    {
      com.tencent.beacon.d.a.d(" common info null", new Object[0]);
      return;
    }
    label1706:
    label1713:
    for (;;)
    {
      long l1;
      HashMap localHashMap;
      b localb;
      Object localObject4;
      long l2;
      try
      {
        l1 = ((d)localObject1).h();
        String str2 = ((d)localObject1).g();
        String str1 = com.tencent.beacon.d.b.c(this.a);
        if (str1 != null) {
          break label1713;
        }
        str1 = "null";
        localObject1 = "null";
        if (e.a(this.a) == null) {
          break label1706;
        }
        localObject3 = e.j(this.a);
        localObject1 = localObject3;
        if (localObject3 != null) {
          break label1706;
        }
        localObject3 = "null";
        localHashMap = new HashMap();
        Iterator localIterator = this.b.iterator();
        if (!localIterator.hasNext()) {
          break label893;
        }
        localb = (b)localIterator.next();
        com.tencent.beacon.d.a.a(" check " + localb.a(), new Object[0]);
        com.tencent.beacon.d.a.b(" address:" + localb.b(), new Object[0]);
        localObject1 = null;
        localHashMap.clear();
        localHashMap.put("A28", str2);
        localHashMap.put("A3", a.a(this.a).a());
        if ("PG".equals(localb.a())) {
          if (str1.toLowerCase().contains("wap"))
          {
            com.tencent.beacon.d.a.a(" using wap request", new Object[0]);
            localObject1 = a.a(localb.b(), str1);
            localObject4 = localObject1;
            if (localObject1 == null) {
              localObject4 = new a.b();
            }
            if (((a.b)localObject4).a + ((a.b)localObject4).b + ((a.b)localObject4).c + ((a.b)localObject4).d + ((a.b)localObject4).e <= 0L)
            {
              com.tencent.beacon.d.a.a(" elapse bean is not avilable!try apach}", new Object[0]);
              l2 = System.currentTimeMillis();
              if (a(localb.b(), " ".getBytes(), "post", 60000, str1) != null)
              {
                ((a.b)localObject4).e = (System.currentTimeMillis() - l2);
                com.tencent.beacon.d.a.a(" get a total time}" + ((a.b)localObject4).e, new Object[0]);
              }
            }
            localObject1 = new h();
            ((h)localObject1).b(localb.b());
            l2 = new Date().getTime();
            com.tencent.beacon.d.a.a(" loc time:}" + l2, new Object[0]);
            l2 += l1;
            com.tencent.beacon.d.a.a(" to stime:}" + l2, new Object[0]);
            ((h)localObject1).b(l2);
            ((h)localObject1).a("DN");
            localHashMap.put("A19", str1);
            localHashMap.put("A40", ((a.b)localObject4).b);
            localHashMap.put("A34", "unknown");
            localHashMap.put("A39", ((a.b)localObject4).f);
            localHashMap.put("A35", ((a.b)localObject4).a);
            localHashMap.put("A36", ((a.b)localObject4).c);
            localHashMap.put("A38", ((a.b)localObject4).e);
            localHashMap.put("A37", ((a.b)localObject4).d);
            localHashMap.put("A33", localObject3);
            ((h)localObject1).a(localHashMap);
            if (localObject1 == null) {
              continue;
            }
            com.tencent.beacon.d.a.a(" insert record type " + localb.a(), new Object[0]);
            if (e.a(this.a, (h)localObject1)) {
              continue;
            }
            com.tencent.beacon.d.a.a(" insert record fail!", new Object[0]);
            continue;
          }
        }
      }
      finally {}
      if ("IP".equals(localb.a()))
      {
        localObject1 = localb.b().trim();
        localObject4 = ((String)localObject1).split(":");
        if ((localObject4 == null) || (localObject4.length != 2))
        {
          com.tencent.beacon.d.a.d(" ip dest wrong }" + (String)localObject1, new Object[0]);
          label893:
          localObject1 = this.a;
          l1 = new Date().getTime();
          com.tencent.beacon.d.a.a(" MonitorDAO.deleteSpeedMonitorSources() start}", new Object[0]);
          if (localObject1 == null) {
            com.tencent.beacon.d.a.a(" MonitorDAO.deleteSpeedMonitorSources() context is null arg}", new Object[0]);
          }
        }
        else
        {
          l2 = a.a(localObject4[0], Integer.parseInt(localObject4[1]));
          localObject1 = new h();
          ((h)localObject1).b(localb.b());
          long l3 = new Date().getTime();
          com.tencent.beacon.d.a.a(" loc time:}" + l3, new Object[0]);
          l3 += l1;
          com.tencent.beacon.d.a.a(" to stime:}" + l3, new Object[0]);
          ((h)localObject1).b(l3);
          ((h)localObject1).a("IP");
          localHashMap.put("A19", localObject2);
          localHashMap.put("A26", l2);
          localHashMap.put("A33", localObject3);
          ((h)localObject1).a(localHashMap);
        }
      }
      else
      {
        if (!"HOST".equals(localb.a())) {
          continue;
        }
        String str3 = "http://" + localb.c() + localb.b();
        com.tencent.beacon.d.a.a(" host domain test:" + str3, new Object[0]);
        if (localObject2.toLowerCase().contains("wap")) {
          com.tencent.beacon.d.a.a(" using wap request", new Object[0]);
        }
        for (localObject1 = a.a(str3, localObject2);; localObject1 = a.a(localb.d(), localb.c(), localb.b()))
        {
          localObject4 = localObject1;
          if (localObject1 == null) {
            localObject4 = new a.b();
          }
          if (((a.b)localObject4).a + ((a.b)localObject4).b + ((a.b)localObject4).c + ((a.b)localObject4).d + ((a.b)localObject4).e <= 0L)
          {
            com.tencent.beacon.d.a.a(" elapse bean is not avilable!try apach", new Object[0]);
            l2 = System.currentTimeMillis();
            if (a(str3, " ".getBytes(), "post", 60000, localObject2) != null)
            {
              ((a.b)localObject4).e = (System.currentTimeMillis() - l2);
              com.tencent.beacon.d.a.a(" get a total time}" + ((a.b)localObject4).e, new Object[0]);
            }
          }
          localObject1 = new h();
          ((h)localObject1).b(localb.b());
          l2 = new Date().getTime();
          com.tencent.beacon.d.a.a("loc time:" + l2, new Object[0]);
          l2 += l1;
          com.tencent.beacon.d.a.a("to stime:" + l2, new Object[0]);
          ((h)localObject1).b(l2);
          ((h)localObject1).a("HO");
          localHashMap.put("A19", localObject2);
          localHashMap.put("A40", ((a.b)localObject4).b);
          localHashMap.put("A34", localb.c());
          localHashMap.put("hostip", localb.d());
          localHashMap.put("A39", ((a.b)localObject4).f);
          localHashMap.put("A35", ((a.b)localObject4).a);
          localHashMap.put("A36", ((a.b)localObject4).c);
          localHashMap.put("A38", ((a.b)localObject4).e);
          localHashMap.put("A37", ((a.b)localObject4).d);
          localHashMap.put("A33", localObject3);
          ((h)localObject1).a(localHashMap);
          break;
        }
      }
      com.tencent.beacon.a.a.a.a((Context)localObject1, new int[] { 5 }, -1L, l1);
      return;
      Object localObject3 = localObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.beacon.b.c
 * JD-Core Version:    0.7.0.1
 */