package com.tencent.mobileqq.msf.core.net.c;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class i
{
  private static final String a = "PingAndTraceroute";
  private boolean b = false;
  private String c = "";
  private String d = "";
  private int e = 60;
  private int f = 10;
  private int g = 1200000;
  private int h = 3;
  private boolean i = false;
  private a j = new a();
  private HashMap k = null;
  private String l = "";
  
  public i(String paramString, boolean paramBoolean)
  {
    this.c = paramString;
    this.b = paramBoolean;
  }
  
  public i(String paramString, boolean paramBoolean, int paramInt)
  {
    this.c = paramString;
    this.b = paramBoolean;
    this.g = paramInt;
  }
  
  /* Error */
  private String a(String paramString, int paramInt1, int paramInt2)
    throws Exception
  {
    // Byte code:
    //   0: invokestatic 67	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   3: new 69	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   10: ldc 72
    //   12: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: iload_3
    //   16: invokevirtual 79	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   19: ldc 81
    //   21: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: iload_2
    //   25: invokevirtual 79	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   28: ldc 83
    //   30: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: aload_1
    //   34: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: invokevirtual 91	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   43: astore 5
    //   45: new 93	java/io/BufferedReader
    //   48: dup
    //   49: new 95	java/io/InputStreamReader
    //   52: dup
    //   53: aload 5
    //   55: invokevirtual 101	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   58: invokespecial 104	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   61: invokespecial 107	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   64: astore 6
    //   66: new 109	java/lang/String
    //   69: dup
    //   70: invokespecial 110	java/lang/String:<init>	()V
    //   73: pop
    //   74: ldc 34
    //   76: astore_1
    //   77: aload 6
    //   79: invokevirtual 113	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   82: astore 4
    //   84: aload 4
    //   86: ifnull +100 -> 186
    //   89: new 69	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   96: aload_1
    //   97: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: aload 4
    //   102: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   108: astore 4
    //   110: aload 4
    //   112: astore_1
    //   113: goto -36 -> 77
    //   116: astore 4
    //   118: ldc 34
    //   120: astore_1
    //   121: aload 4
    //   123: invokevirtual 116	java/lang/Exception:printStackTrace	()V
    //   126: aload 5
    //   128: invokevirtual 120	java/lang/Process:exitValue	()I
    //   131: pop
    //   132: aload_1
    //   133: invokevirtual 123	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   136: areturn
    //   137: astore_1
    //   138: aload 5
    //   140: invokevirtual 120	java/lang/Process:exitValue	()I
    //   143: pop
    //   144: aload_1
    //   145: athrow
    //   146: astore 4
    //   148: aload 5
    //   150: invokevirtual 126	java/lang/Process:destroy	()V
    //   153: goto -9 -> 144
    //   156: astore 5
    //   158: aload 4
    //   160: invokevirtual 116	java/lang/Exception:printStackTrace	()V
    //   163: goto -19 -> 144
    //   166: astore 4
    //   168: aload 5
    //   170: invokevirtual 126	java/lang/Process:destroy	()V
    //   173: goto -41 -> 132
    //   176: astore 5
    //   178: aload 4
    //   180: invokevirtual 116	java/lang/Exception:printStackTrace	()V
    //   183: goto -51 -> 132
    //   186: aload 5
    //   188: invokevirtual 120	java/lang/Process:exitValue	()I
    //   191: pop
    //   192: goto -60 -> 132
    //   195: astore 4
    //   197: aload 5
    //   199: invokevirtual 126	java/lang/Process:destroy	()V
    //   202: goto -70 -> 132
    //   205: astore 5
    //   207: goto -29 -> 178
    //   210: astore 4
    //   212: goto -91 -> 121
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	215	0	this	i
    //   0	215	1	paramString	String
    //   0	215	2	paramInt1	int
    //   0	215	3	paramInt2	int
    //   82	29	4	str	String
    //   116	6	4	localException1	Exception
    //   146	13	4	localException2	Exception
    //   166	13	4	localException3	Exception
    //   195	1	4	localException4	Exception
    //   210	1	4	localException5	Exception
    //   43	106	5	localProcess	java.lang.Process
    //   156	13	5	localException6	Exception
    //   176	22	5	localException7	Exception
    //   205	1	5	localException8	Exception
    //   64	14	6	localBufferedReader	java.io.BufferedReader
    // Exception table:
    //   from	to	target	type
    //   45	74	116	java/lang/Exception
    //   45	74	137	finally
    //   77	84	137	finally
    //   89	110	137	finally
    //   121	126	137	finally
    //   138	144	146	java/lang/Exception
    //   148	153	156	java/lang/Exception
    //   126	132	166	java/lang/Exception
    //   168	173	176	java/lang/Exception
    //   186	192	195	java/lang/Exception
    //   197	202	205	java/lang/Exception
    //   77	84	210	java/lang/Exception
    //   89	110	210	java/lang/Exception
  }
  
  private String b(String paramString)
  {
    String str2 = "*";
    int m = paramString.indexOf("from");
    String str1 = str2;
    if (m >= 0)
    {
      int n = paramString.indexOf(" ", m + 5);
      str1 = str2;
      if (n > 0) {
        str1 = paramString.substring(m + 5, n);
      }
    }
    str1 = str1.trim();
    paramString = str1;
    if (str1.endsWith(":")) {
      paramString = str1.substring(0, str1.length() - 1).trim();
    }
    str1 = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str1 = "*";
    }
    return str1;
  }
  
  private String c(String paramString)
  {
    String str = "";
    if (paramString.contains("ping")) {
      str = paramString.substring(paramString.indexOf("(") + 1, paramString.indexOf(")"));
    }
    return str;
  }
  
  private String d()
  {
    if (TextUtils.isEmpty(this.d)) {
      return this.c;
    }
    return this.d;
  }
  
  public a a()
  {
    long l1 = SystemClock.elapsedRealtime();
    StringBuilder localStringBuilder = new StringBuilder();
    int m = 1;
    String str1;
    String str2;
    int n;
    if (m < this.e)
    {
      str1 = "*";
      str2 = "";
      n = 0;
    }
    for (;;)
    {
      try
      {
        if (n < this.h)
        {
          long l2 = SystemClock.elapsedRealtime();
          int i1 = this.f;
          int i2 = (int)(l2 - l1);
          if (i2 >= this.g)
          {
            this.j.b = true;
            this.j.a = m;
            this.j.d = "\n";
            return this.j;
          }
          if (this.g - i2 < 10000) {
            i1 = (this.g - i2) / 1000 + 1;
          }
          str2 = a(d(), m, i1);
          long l3 = SystemClock.elapsedRealtime();
          String str3 = c(str2);
          if (!TextUtils.isEmpty(str3))
          {
            this.d = str3;
            if (!this.i)
            {
              this.j.c = str3;
              str3 = "Traceroute to " + this.c + " (" + str3 + "), " + this.e + " hops max, 60 byte packets, mTimeout " + this.f + "s";
              this.i = true;
              if (this.b) {
                QLog.d("PingAndTraceroute", 1, str3);
              }
              localStringBuilder.append(str3).append("\n");
            }
          }
          str2 = b(str2);
          if (str2.equals("*")) {
            break label652;
          }
          if (!str2.equals(str1)) {
            break label645;
          }
          str2 = "";
          str2 = String.format("%s %10d ms ", new Object[] { str2, Long.valueOf(l3 - l2) }).toString();
          localStringBuilder.append(str2);
          n += 1;
          continue;
        }
        localStringBuilder.append("\n");
        if (this.b) {
          QLog.d("PingAndTraceroute", 1, str2);
        }
        if ((this.c.equals(str1)) || (this.d.equals(str1)))
        {
          this.j.b = true;
          this.j.a = m;
          if (!this.j.b) {
            break label591;
          }
          str1 = "Traceroute succ host: " + this.c + "(" + this.d + ") TTL: " + this.j.a;
          if ((this.b) && (QLog.isColorLevel())) {
            QLog.d("PingAndTraceroute", 2, str1);
          }
          this.j.d = localStringBuilder.toString();
          return this.j;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        localObject = "Ping error: " + localException.getMessage();
        if (this.b) {
          QLog.d("PingAndTraceroute", 1, (String)localObject);
        }
        localStringBuilder.append((String)localObject).append("\n");
        m += 1;
      }
      break;
      label591:
      Object localObject = "Traceroute fail host: " + this.c + "(" + this.d + ") TTL: " + this.j.a;
      continue;
      label645:
      localObject = str2;
      continue;
      label652:
      str2 = " * ";
    }
  }
  
  public void a(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void a(String paramString)
  {
    this.l = paramString;
  }
  
  public void a(HashMap paramHashMap)
  {
    this.k = paramHashMap;
  }
  
  /* Error */
  public a b()
  {
    // Byte code:
    //   0: invokestatic 177	android/os/SystemClock:elapsedRealtime	()J
    //   3: lstore_1
    //   4: new 69	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   11: astore 5
    //   13: aload_0
    //   14: getfield 56	com/tencent/mobileqq/msf/core/net/c/i:l	Ljava/lang/String;
    //   17: invokestatic 161	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   20: ifne +275 -> 295
    //   23: new 69	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   30: ldc 246
    //   32: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: aload_0
    //   36: getfield 56	com/tencent/mobileqq/msf/core/net/c/i:l	Ljava/lang/String;
    //   39: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: astore 4
    //   47: aload 4
    //   49: astore_3
    //   50: aload 4
    //   52: ldc 248
    //   54: invokevirtual 166	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   57: ifne +24 -> 81
    //   60: new 69	java/lang/StringBuilder
    //   63: dup
    //   64: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   67: aload 4
    //   69: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: ldc 250
    //   74: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: astore_3
    //   81: aload_3
    //   82: astore 4
    //   84: aload_3
    //   85: ldc 252
    //   87: invokevirtual 166	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   90: ifne +24 -> 114
    //   93: new 69	java/lang/StringBuilder
    //   96: dup
    //   97: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   100: aload_3
    //   101: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: ldc 254
    //   106: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: astore 4
    //   114: new 69	java/lang/StringBuilder
    //   117: dup
    //   118: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   121: aload 4
    //   123: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: aload_0
    //   127: invokespecial 185	com/tencent/mobileqq/msf/core/net/c/i:d	()Ljava/lang/String;
    //   130: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   136: astore_3
    //   137: invokestatic 232	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   140: ifeq +29 -> 169
    //   143: ldc 10
    //   145: iconst_2
    //   146: new 69	java/lang/StringBuilder
    //   149: dup
    //   150: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   153: ldc_w 256
    //   156: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: aload_3
    //   160: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   166: invokestatic 205	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   169: invokestatic 67	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   172: aload_3
    //   173: invokevirtual 91	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   176: astore_3
    //   177: new 93	java/io/BufferedReader
    //   180: dup
    //   181: new 95	java/io/InputStreamReader
    //   184: dup
    //   185: aload_3
    //   186: invokevirtual 101	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   189: invokespecial 104	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   192: invokespecial 107	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   195: astore 4
    //   197: new 109	java/lang/String
    //   200: dup
    //   201: invokespecial 110	java/lang/String:<init>	()V
    //   204: pop
    //   205: aload 4
    //   207: invokevirtual 113	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   210: astore 6
    //   212: aload 6
    //   214: ifnull +30 -> 244
    //   217: aload 5
    //   219: aload 6
    //   221: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: ldc 182
    //   226: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: pop
    //   230: invokestatic 177	android/os/SystemClock:elapsedRealtime	()J
    //   233: lload_1
    //   234: lsub
    //   235: aload_0
    //   236: getfield 45	com/tencent/mobileqq/msf/core/net/c/i:g	I
    //   239: i2l
    //   240: lcmp
    //   241: iflt -36 -> 205
    //   244: aload_0
    //   245: getfield 52	com/tencent/mobileqq/msf/core/net/c/i:j	Lcom/tencent/mobileqq/msf/core/net/c/i$a;
    //   248: iconst_1
    //   249: putfield 178	com/tencent/mobileqq/msf/core/net/c/i$a:b	Z
    //   252: aload_3
    //   253: invokevirtual 120	java/lang/Process:exitValue	()I
    //   256: pop
    //   257: aload_0
    //   258: getfield 52	com/tencent/mobileqq/msf/core/net/c/i:j	Lcom/tencent/mobileqq/msf/core/net/c/i$a;
    //   261: aload 5
    //   263: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   266: putfield 183	com/tencent/mobileqq/msf/core/net/c/i$a:d	Ljava/lang/String;
    //   269: aload_0
    //   270: getfield 52	com/tencent/mobileqq/msf/core/net/c/i:j	Lcom/tencent/mobileqq/msf/core/net/c/i$a;
    //   273: aload_0
    //   274: aload_0
    //   275: getfield 52	com/tencent/mobileqq/msf/core/net/c/i:j	Lcom/tencent/mobileqq/msf/core/net/c/i$a;
    //   278: getfield 183	com/tencent/mobileqq/msf/core/net/c/i$a:d	Ljava/lang/String;
    //   281: invokevirtual 123	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   284: invokespecial 189	com/tencent/mobileqq/msf/core/net/c/i:c	(Ljava/lang/String;)Ljava/lang/String;
    //   287: putfield 190	com/tencent/mobileqq/msf/core/net/c/i$a:c	Ljava/lang/String;
    //   290: aload_0
    //   291: getfield 52	com/tencent/mobileqq/msf/core/net/c/i:j	Lcom/tencent/mobileqq/msf/core/net/c/i$a;
    //   294: areturn
    //   295: new 69	java/lang/StringBuilder
    //   298: dup
    //   299: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   302: ldc 246
    //   304: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: ldc_w 258
    //   310: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   316: astore 4
    //   318: goto -204 -> 114
    //   321: astore 4
    //   323: aload 4
    //   325: invokevirtual 116	java/lang/Exception:printStackTrace	()V
    //   328: aload_3
    //   329: invokevirtual 120	java/lang/Process:exitValue	()I
    //   332: pop
    //   333: goto -76 -> 257
    //   336: astore 4
    //   338: aload_3
    //   339: invokevirtual 126	java/lang/Process:destroy	()V
    //   342: goto -85 -> 257
    //   345: astore_3
    //   346: aload 4
    //   348: invokevirtual 116	java/lang/Exception:printStackTrace	()V
    //   351: goto -94 -> 257
    //   354: astore_3
    //   355: invokestatic 232	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   358: ifeq -101 -> 257
    //   361: ldc 10
    //   363: iconst_2
    //   364: aload_3
    //   365: iconst_0
    //   366: anewarray 4	java/lang/Object
    //   369: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   372: goto -115 -> 257
    //   375: astore 4
    //   377: aload_3
    //   378: invokevirtual 120	java/lang/Process:exitValue	()I
    //   381: pop
    //   382: aload 4
    //   384: athrow
    //   385: astore 6
    //   387: aload_3
    //   388: invokevirtual 126	java/lang/Process:destroy	()V
    //   391: goto -9 -> 382
    //   394: astore_3
    //   395: aload 6
    //   397: invokevirtual 116	java/lang/Exception:printStackTrace	()V
    //   400: goto -18 -> 382
    //   403: astore 4
    //   405: aload_3
    //   406: invokevirtual 126	java/lang/Process:destroy	()V
    //   409: goto -152 -> 257
    //   412: astore_3
    //   413: aload 4
    //   415: invokevirtual 116	java/lang/Exception:printStackTrace	()V
    //   418: goto -161 -> 257
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	421	0	this	i
    //   3	231	1	l1	long
    //   49	290	3	localObject1	Object
    //   345	1	3	localException1	Exception
    //   354	34	3	localException2	Exception
    //   394	12	3	localException3	Exception
    //   412	1	3	localException4	Exception
    //   45	272	4	localObject2	Object
    //   321	3	4	localException5	Exception
    //   336	11	4	localException6	Exception
    //   375	8	4	localObject3	Object
    //   403	11	4	localException7	Exception
    //   11	251	5	localStringBuilder	StringBuilder
    //   210	10	6	str	String
    //   385	11	6	localException8	Exception
    // Exception table:
    //   from	to	target	type
    //   177	205	321	java/lang/Exception
    //   205	212	321	java/lang/Exception
    //   217	244	321	java/lang/Exception
    //   244	252	321	java/lang/Exception
    //   328	333	336	java/lang/Exception
    //   338	342	345	java/lang/Exception
    //   13	47	354	java/lang/Exception
    //   50	81	354	java/lang/Exception
    //   84	114	354	java/lang/Exception
    //   114	169	354	java/lang/Exception
    //   169	177	354	java/lang/Exception
    //   295	318	354	java/lang/Exception
    //   346	351	354	java/lang/Exception
    //   382	385	354	java/lang/Exception
    //   395	400	354	java/lang/Exception
    //   413	418	354	java/lang/Exception
    //   177	205	375	finally
    //   205	212	375	finally
    //   217	244	375	finally
    //   244	252	375	finally
    //   323	328	375	finally
    //   377	382	385	java/lang/Exception
    //   387	391	394	java/lang/Exception
    //   252	257	403	java/lang/Exception
    //   405	409	412	java/lang/Exception
  }
  
  public void b(int paramInt)
  {
    this.f = paramInt;
  }
  
  public a c()
  {
    return this.j;
  }
  
  public static class a
  {
    public int a = 0;
    public boolean b = false;
    public String c = "";
    public String d = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.c.i
 * JD-Core Version:    0.7.0.1
 */