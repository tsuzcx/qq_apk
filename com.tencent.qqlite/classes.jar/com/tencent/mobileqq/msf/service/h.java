package com.tencent.mobileqq.msf.service;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.IInterface;
import android.os.RemoteException;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.b.m;
import com.tencent.mobileqq.msf.core.push.f;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Random;

public class h
  implements IBinder.DeathRecipient
{
  private static final int A = 1;
  private static final int B = 0;
  private static final int E = 3600000;
  public static final int a = 2;
  public static final int b = 1;
  public static final int c = 0;
  private static final int f = 500;
  private static final String g = "GuardManager";
  private static final String h = "gm_history";
  private static final int i = 1;
  private static final int j = 2;
  private static final int k = 3;
  private static final int l = 4;
  private static final int m = 5;
  private static long t = 720000L;
  private static long v = 0L;
  private static final int z = 2;
  private int C = 0;
  private int D = 3;
  public boolean d = false;
  public volatile boolean e = false;
  private long[] n = null;
  private long[] o = null;
  private long[] p = null;
  private long[] q = null;
  private long r = 0L;
  private int s = 0;
  private IBinder u;
  private int w = 1;
  private long x = 0L;
  private MsfCore y;
  
  public h(MsfCore paramMsfCore)
  {
    this.y = paramMsfCore;
  }
  
  private void a(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    if (this.n == null) {
      b();
    }
    int i3 = this.o.length;
    if (paramInt1 != i3)
    {
      localObject = new long[24];
      long[] arrayOfLong1 = new long[24];
      long[] arrayOfLong2 = new long[24];
      long[] arrayOfLong3 = new long[24];
      int i4 = 24 / i3;
      i1 = 0;
      int i2;
      while (i1 < i3)
      {
        i2 = 0;
        while (i2 < i4)
        {
          localObject[(i1 * i4 + i2)] = 0L;
          arrayOfLong1[(i1 * i4 + i2)] = 0L;
          arrayOfLong2[(i1 * i4 + i2)] = 0L;
          arrayOfLong3[(i1 * i4 + i2)] = 0L;
          i2 += 1;
        }
        localObject[((int)(this.n[i1] / 3600000L))] = this.n[i1];
        arrayOfLong1[((int)(this.n[i1] / 3600000L))] = this.o[i1];
        arrayOfLong2[((int)(this.p[i1] / 3600000L))] = this.p[i1];
        arrayOfLong3[((int)(this.p[i1] / 3600000L))] = this.q[i1];
        i1 += 1;
      }
      this.n = new long[paramInt1];
      this.o = new long[paramInt1];
      this.p = new long[paramInt1];
      this.q = new long[paramInt1];
      i3 = 24 / paramInt1;
      i1 = 0;
      while (i1 < paramInt1)
      {
        i2 = 0;
        while (i2 < i3)
        {
          arrayOfLong2 = this.o;
          arrayOfLong2[i1] += arrayOfLong1[(i1 * i3 + i2)];
          arrayOfLong2 = this.n;
          arrayOfLong2[i1] += localObject[(i1 * i3 + i2)] * arrayOfLong1[(i1 * i3 + i2)];
          arrayOfLong2 = this.q;
          arrayOfLong2[i1] += arrayOfLong1[(i1 * i3 + i2)];
          arrayOfLong2 = this.p;
          arrayOfLong2[i1] += localObject[(i1 * i3 + i2)] * arrayOfLong1[(i1 * i3 + i2)];
          i2 += 1;
        }
        if (this.o[i1] != 0L)
        {
          arrayOfLong2 = this.n;
          arrayOfLong2[i1] /= this.o[i1];
        }
        if (this.q[i1] != 0L)
        {
          arrayOfLong2 = this.p;
          arrayOfLong2[i1] /= this.q[i1];
        }
        i1 += 1;
      }
    }
    Object localObject = Calendar.getInstance(Locale.getDefault());
    ((Calendar)localObject).setTimeInMillis(paramLong - 15000L);
    int i1 = ((Calendar)localObject).get(7);
    paramInt1 = ((Calendar)localObject).get(11);
    paramLong = paramInt1 * 60 * 60 * 1000 + paramLong % 3600000L;
    long l1;
    if (this.C == 2) {
      if (paramBoolean)
      {
        localObject = "11";
        a("GM_StartTime", paramLong, (String)localObject);
        paramInt1 /= 24 / this.n.length;
        if ((i1 == 1) || (i1 == 7)) {
          break label749;
        }
        l1 = this.o[paramInt1] + 1L;
        paramLong = (this.n[paramInt1] * this.o[paramInt1] + paramLong) / l1;
        this.n[paramInt1] = paramLong;
        this.o[paramInt1] = l1;
        label656:
        this.D = paramInt2;
        if (paramInt3 == 0) {
          break label801;
        }
        if (paramInt3 != 2) {
          break label796;
        }
        paramInt1 = 2;
        this.C = paramInt1;
      }
    }
    label749:
    while (this.C != 0) {
      for (;;)
      {
        c();
        if (this.r != i1)
        {
          this.r = i1;
          this.s = 0;
        }
        if (paramBoolean) {
          this.s += 1;
        }
        return;
        localObject = "10";
        break;
        if (paramBoolean)
        {
          localObject = "01";
          break;
        }
        localObject = "00";
        break;
        l1 = this.q[paramInt1] + 1L;
        paramLong = (this.p[paramInt1] * this.q[paramInt1] + paramLong) / l1;
        this.p[paramInt1] = paramLong;
        this.q[paramInt1] = l1;
        break label656;
        paramInt1 = 1;
      }
    }
    label796:
    label801:
    if (new Random().nextInt(2) == 0) {}
    for (paramInt1 = 2;; paramInt1 = 1)
    {
      this.C = paramInt1;
      break;
    }
  }
  
  private void a(String paramString1, long paramLong, String paramString2)
  {
    HashMap localHashMap = null;
    if (paramString2 != null)
    {
      localHashMap = new HashMap();
      localHashMap.put("Tag", paramString2);
    }
    this.y.getStatReporter().a(paramString1, true, paramLong, 0L, localHashMap, false, false);
  }
  
  /* Error */
  private void b()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: new 171	java/io/ObjectInputStream
    //   7: dup
    //   8: invokestatic 177	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   11: ldc 26
    //   13: invokevirtual 183	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   16: invokespecial 186	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   19: astore 5
    //   21: aload 5
    //   23: astore 4
    //   25: aload 5
    //   27: invokevirtual 190	java/io/ObjectInputStream:readByte	()B
    //   30: istore_3
    //   31: iload_3
    //   32: ifeq +88 -> 120
    //   35: bipush 24
    //   37: iload_3
    //   38: irem
    //   39: ifne +81 -> 120
    //   42: aload 5
    //   44: astore 4
    //   46: iload_3
    //   47: newarray long
    //   49: astore 6
    //   51: aload 5
    //   53: astore 4
    //   55: iload_3
    //   56: newarray long
    //   58: astore 7
    //   60: iconst_0
    //   61: istore_1
    //   62: iload_1
    //   63: iload_3
    //   64: if_icmpge +36 -> 100
    //   67: aload 5
    //   69: astore 4
    //   71: aload 7
    //   73: iload_1
    //   74: aload 5
    //   76: invokevirtual 194	java/io/ObjectInputStream:readLong	()J
    //   79: lastore
    //   80: aload 5
    //   82: astore 4
    //   84: aload 6
    //   86: iload_1
    //   87: aload 5
    //   89: invokevirtual 194	java/io/ObjectInputStream:readLong	()J
    //   92: lastore
    //   93: iload_1
    //   94: iconst_1
    //   95: iadd
    //   96: istore_1
    //   97: goto -35 -> 62
    //   100: aload 5
    //   102: astore 4
    //   104: aload_0
    //   105: aload 6
    //   107: putfield 75	com/tencent/mobileqq/msf/service/h:o	[J
    //   110: aload 5
    //   112: astore 4
    //   114: aload_0
    //   115: aload 7
    //   117: putfield 73	com/tencent/mobileqq/msf/service/h:n	[J
    //   120: aload 5
    //   122: astore 4
    //   124: aload_0
    //   125: aload 5
    //   127: invokevirtual 198	java/io/ObjectInputStream:readInt	()I
    //   130: putfield 91	com/tencent/mobileqq/msf/service/h:D	I
    //   133: aload 5
    //   135: astore 4
    //   137: aload_0
    //   138: aload 5
    //   140: invokevirtual 198	java/io/ObjectInputStream:readInt	()I
    //   143: putfield 89	com/tencent/mobileqq/msf/service/h:C	I
    //   146: iload_3
    //   147: ifeq +88 -> 235
    //   150: bipush 24
    //   152: iload_3
    //   153: irem
    //   154: ifne +81 -> 235
    //   157: aload 5
    //   159: astore 4
    //   161: iload_3
    //   162: newarray long
    //   164: astore 6
    //   166: aload 5
    //   168: astore 4
    //   170: iload_3
    //   171: newarray long
    //   173: astore 7
    //   175: iload_2
    //   176: istore_1
    //   177: iload_1
    //   178: iload_3
    //   179: if_icmpge +36 -> 215
    //   182: aload 5
    //   184: astore 4
    //   186: aload 7
    //   188: iload_1
    //   189: aload 5
    //   191: invokevirtual 194	java/io/ObjectInputStream:readLong	()J
    //   194: lastore
    //   195: aload 5
    //   197: astore 4
    //   199: aload 6
    //   201: iload_1
    //   202: aload 5
    //   204: invokevirtual 194	java/io/ObjectInputStream:readLong	()J
    //   207: lastore
    //   208: iload_1
    //   209: iconst_1
    //   210: iadd
    //   211: istore_1
    //   212: goto -35 -> 177
    //   215: aload 5
    //   217: astore 4
    //   219: aload_0
    //   220: aload 6
    //   222: putfield 79	com/tencent/mobileqq/msf/service/h:q	[J
    //   225: aload 5
    //   227: astore 4
    //   229: aload_0
    //   230: aload 7
    //   232: putfield 77	com/tencent/mobileqq/msf/service/h:p	[J
    //   235: aload 5
    //   237: ifnull +8 -> 245
    //   240: aload 5
    //   242: invokevirtual 201	java/io/ObjectInputStream:close	()V
    //   245: aload_0
    //   246: getfield 75	com/tencent/mobileqq/msf/service/h:o	[J
    //   249: ifnonnull +17 -> 266
    //   252: aload_0
    //   253: iconst_1
    //   254: newarray long
    //   256: putfield 75	com/tencent/mobileqq/msf/service/h:o	[J
    //   259: aload_0
    //   260: iconst_1
    //   261: newarray long
    //   263: putfield 73	com/tencent/mobileqq/msf/service/h:n	[J
    //   266: aload_0
    //   267: getfield 79	com/tencent/mobileqq/msf/service/h:q	[J
    //   270: ifnonnull +25 -> 295
    //   273: aload_0
    //   274: aload_0
    //   275: getfield 75	com/tencent/mobileqq/msf/service/h:o	[J
    //   278: arraylength
    //   279: newarray long
    //   281: putfield 79	com/tencent/mobileqq/msf/service/h:q	[J
    //   284: aload_0
    //   285: aload_0
    //   286: getfield 75	com/tencent/mobileqq/msf/service/h:o	[J
    //   289: arraylength
    //   290: newarray long
    //   292: putfield 77	com/tencent/mobileqq/msf/service/h:p	[J
    //   295: aload_0
    //   296: monitorexit
    //   297: return
    //   298: astore 6
    //   300: aconst_null
    //   301: astore 5
    //   303: aload 5
    //   305: astore 4
    //   307: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   310: ifeq +17 -> 327
    //   313: aload 5
    //   315: astore 4
    //   317: ldc 23
    //   319: iconst_2
    //   320: ldc 209
    //   322: aload 6
    //   324: invokestatic 212	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   327: aload 5
    //   329: ifnull -84 -> 245
    //   332: aload 5
    //   334: invokevirtual 201	java/io/ObjectInputStream:close	()V
    //   337: goto -92 -> 245
    //   340: astore 4
    //   342: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   345: ifeq -100 -> 245
    //   348: ldc 23
    //   350: iconst_2
    //   351: ldc 214
    //   353: aload 4
    //   355: invokestatic 212	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   358: goto -113 -> 245
    //   361: astore 4
    //   363: aload_0
    //   364: monitorexit
    //   365: aload 4
    //   367: athrow
    //   368: astore 5
    //   370: aconst_null
    //   371: astore 4
    //   373: aload 4
    //   375: ifnull +8 -> 383
    //   378: aload 4
    //   380: invokevirtual 201	java/io/ObjectInputStream:close	()V
    //   383: aload 5
    //   385: athrow
    //   386: astore 4
    //   388: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   391: ifeq -8 -> 383
    //   394: ldc 23
    //   396: iconst_2
    //   397: ldc 214
    //   399: aload 4
    //   401: invokestatic 212	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   404: goto -21 -> 383
    //   407: astore 4
    //   409: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   412: ifeq -167 -> 245
    //   415: ldc 23
    //   417: iconst_2
    //   418: ldc 214
    //   420: aload 4
    //   422: invokestatic 212	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   425: goto -180 -> 245
    //   428: astore 5
    //   430: goto -57 -> 373
    //   433: astore 6
    //   435: goto -132 -> 303
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	438	0	this	h
    //   61	151	1	i1	int
    //   1	175	2	i2	int
    //   30	150	3	i3	int
    //   23	293	4	localObjectInputStream1	java.io.ObjectInputStream
    //   340	14	4	localIOException1	java.io.IOException
    //   361	5	4	localObject1	Object
    //   371	8	4	localObject2	Object
    //   386	14	4	localIOException2	java.io.IOException
    //   407	14	4	localIOException3	java.io.IOException
    //   19	314	5	localObjectInputStream2	java.io.ObjectInputStream
    //   368	16	5	localObject3	Object
    //   428	1	5	localObject4	Object
    //   49	172	6	arrayOfLong1	long[]
    //   298	25	6	localThrowable1	java.lang.Throwable
    //   433	1	6	localThrowable2	java.lang.Throwable
    //   58	173	7	arrayOfLong2	long[]
    // Exception table:
    //   from	to	target	type
    //   4	21	298	java/lang/Throwable
    //   332	337	340	java/io/IOException
    //   240	245	361	finally
    //   245	266	361	finally
    //   266	295	361	finally
    //   332	337	361	finally
    //   342	358	361	finally
    //   378	383	361	finally
    //   383	386	361	finally
    //   388	404	361	finally
    //   409	425	361	finally
    //   4	21	368	finally
    //   378	383	386	java/io/IOException
    //   240	245	407	java/io/IOException
    //   25	31	428	finally
    //   46	51	428	finally
    //   55	60	428	finally
    //   71	80	428	finally
    //   84	93	428	finally
    //   104	110	428	finally
    //   114	120	428	finally
    //   124	133	428	finally
    //   137	146	428	finally
    //   161	166	428	finally
    //   170	175	428	finally
    //   186	195	428	finally
    //   199	208	428	finally
    //   219	225	428	finally
    //   229	235	428	finally
    //   307	313	428	finally
    //   317	327	428	finally
    //   25	31	433	java/lang/Throwable
    //   46	51	433	java/lang/Throwable
    //   55	60	433	java/lang/Throwable
    //   71	80	433	java/lang/Throwable
    //   84	93	433	java/lang/Throwable
    //   104	110	433	java/lang/Throwable
    //   114	120	433	java/lang/Throwable
    //   124	133	433	java/lang/Throwable
    //   137	146	433	java/lang/Throwable
    //   161	166	433	java/lang/Throwable
    //   170	175	433	java/lang/Throwable
    //   186	195	433	java/lang/Throwable
    //   199	208	433	java/lang/Throwable
    //   219	225	433	java/lang/Throwable
    //   229	235	433	java/lang/Throwable
  }
  
  /* Error */
  private void c()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 75	com/tencent/mobileqq/msf/service/h:o	[J
    //   8: ifnull +27 -> 35
    //   11: aload_0
    //   12: getfield 75	com/tencent/mobileqq/msf/service/h:o	[J
    //   15: arraylength
    //   16: iconst_1
    //   17: if_icmpne +21 -> 38
    //   20: aload_0
    //   21: getfield 75	com/tencent/mobileqq/msf/service/h:o	[J
    //   24: iconst_0
    //   25: laload
    //   26: lstore 4
    //   28: lload 4
    //   30: lconst_0
    //   31: lcmp
    //   32: ifne +6 -> 38
    //   35: aload_0
    //   36: monitorexit
    //   37: return
    //   38: new 216	java/io/ObjectOutputStream
    //   41: dup
    //   42: invokestatic 177	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   45: ldc 26
    //   47: iconst_0
    //   48: invokevirtual 220	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   51: invokespecial 223	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   54: astore 7
    //   56: aload 7
    //   58: astore 6
    //   60: aload_0
    //   61: getfield 75	com/tencent/mobileqq/msf/service/h:o	[J
    //   64: arraylength
    //   65: istore_3
    //   66: aload 7
    //   68: astore 6
    //   70: aload 7
    //   72: iload_3
    //   73: invokevirtual 227	java/io/ObjectOutputStream:writeByte	(I)V
    //   76: iconst_0
    //   77: istore_1
    //   78: iload_1
    //   79: iload_3
    //   80: if_icmpge +40 -> 120
    //   83: aload 7
    //   85: astore 6
    //   87: aload 7
    //   89: aload_0
    //   90: getfield 73	com/tencent/mobileqq/msf/service/h:n	[J
    //   93: iload_1
    //   94: laload
    //   95: invokevirtual 230	java/io/ObjectOutputStream:writeLong	(J)V
    //   98: aload 7
    //   100: astore 6
    //   102: aload 7
    //   104: aload_0
    //   105: getfield 75	com/tencent/mobileqq/msf/service/h:o	[J
    //   108: iload_1
    //   109: laload
    //   110: invokevirtual 230	java/io/ObjectOutputStream:writeLong	(J)V
    //   113: iload_1
    //   114: iconst_1
    //   115: iadd
    //   116: istore_1
    //   117: goto -39 -> 78
    //   120: aload 7
    //   122: astore 6
    //   124: aload 7
    //   126: aload_0
    //   127: getfield 91	com/tencent/mobileqq/msf/service/h:D	I
    //   130: invokevirtual 233	java/io/ObjectOutputStream:writeInt	(I)V
    //   133: aload 7
    //   135: astore 6
    //   137: aload 7
    //   139: aload_0
    //   140: getfield 89	com/tencent/mobileqq/msf/service/h:C	I
    //   143: invokevirtual 233	java/io/ObjectOutputStream:writeInt	(I)V
    //   146: aload 7
    //   148: astore 6
    //   150: aload_0
    //   151: getfield 79	com/tencent/mobileqq/msf/service/h:q	[J
    //   154: ifnull +194 -> 348
    //   157: aload 7
    //   159: astore 6
    //   161: aload_0
    //   162: getfield 79	com/tencent/mobileqq/msf/service/h:q	[J
    //   165: arraylength
    //   166: iconst_1
    //   167: if_icmpne +18 -> 185
    //   170: aload 7
    //   172: astore 6
    //   174: aload_0
    //   175: getfield 79	com/tencent/mobileqq/msf/service/h:q	[J
    //   178: iconst_0
    //   179: laload
    //   180: lconst_0
    //   181: lcmp
    //   182: ifeq +166 -> 348
    //   185: aload 7
    //   187: astore 6
    //   189: aload_0
    //   190: getfield 79	com/tencent/mobileqq/msf/service/h:q	[J
    //   193: arraylength
    //   194: istore_3
    //   195: iload_2
    //   196: istore_1
    //   197: iload_1
    //   198: iload_3
    //   199: if_icmpge +149 -> 348
    //   202: aload 7
    //   204: astore 6
    //   206: aload 7
    //   208: aload_0
    //   209: getfield 77	com/tencent/mobileqq/msf/service/h:p	[J
    //   212: iload_1
    //   213: laload
    //   214: invokevirtual 230	java/io/ObjectOutputStream:writeLong	(J)V
    //   217: aload 7
    //   219: astore 6
    //   221: aload 7
    //   223: aload_0
    //   224: getfield 79	com/tencent/mobileqq/msf/service/h:q	[J
    //   227: iload_1
    //   228: laload
    //   229: invokevirtual 230	java/io/ObjectOutputStream:writeLong	(J)V
    //   232: iload_1
    //   233: iconst_1
    //   234: iadd
    //   235: istore_1
    //   236: goto -39 -> 197
    //   239: astore 8
    //   241: aconst_null
    //   242: astore 7
    //   244: aload 7
    //   246: astore 6
    //   248: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   251: ifeq +17 -> 268
    //   254: aload 7
    //   256: astore 6
    //   258: ldc 23
    //   260: iconst_2
    //   261: ldc 214
    //   263: aload 8
    //   265: invokestatic 212	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   268: aload 7
    //   270: ifnull -235 -> 35
    //   273: aload 7
    //   275: invokevirtual 234	java/io/ObjectOutputStream:close	()V
    //   278: goto -243 -> 35
    //   281: astore 6
    //   283: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   286: ifeq -251 -> 35
    //   289: ldc 23
    //   291: iconst_2
    //   292: ldc 214
    //   294: aload 6
    //   296: invokestatic 212	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   299: goto -264 -> 35
    //   302: astore 6
    //   304: aload_0
    //   305: monitorexit
    //   306: aload 6
    //   308: athrow
    //   309: astore 7
    //   311: aconst_null
    //   312: astore 6
    //   314: aload 6
    //   316: ifnull +8 -> 324
    //   319: aload 6
    //   321: invokevirtual 234	java/io/ObjectOutputStream:close	()V
    //   324: aload 7
    //   326: athrow
    //   327: astore 6
    //   329: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   332: ifeq -8 -> 324
    //   335: ldc 23
    //   337: iconst_2
    //   338: ldc 214
    //   340: aload 6
    //   342: invokestatic 212	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   345: goto -21 -> 324
    //   348: aload 7
    //   350: ifnull -315 -> 35
    //   353: aload 7
    //   355: invokevirtual 234	java/io/ObjectOutputStream:close	()V
    //   358: goto -323 -> 35
    //   361: astore 6
    //   363: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   366: ifeq -331 -> 35
    //   369: ldc 23
    //   371: iconst_2
    //   372: ldc 214
    //   374: aload 6
    //   376: invokestatic 212	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   379: goto -344 -> 35
    //   382: astore 7
    //   384: goto -70 -> 314
    //   387: astore 8
    //   389: goto -145 -> 244
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	392	0	this	h
    //   77	159	1	i1	int
    //   1	195	2	i2	int
    //   65	135	3	i3	int
    //   26	3	4	l1	long
    //   58	199	6	localObjectOutputStream1	java.io.ObjectOutputStream
    //   281	14	6	localIOException1	java.io.IOException
    //   302	5	6	localObject1	Object
    //   312	8	6	localObject2	Object
    //   327	14	6	localIOException2	java.io.IOException
    //   361	14	6	localIOException3	java.io.IOException
    //   54	220	7	localObjectOutputStream2	java.io.ObjectOutputStream
    //   309	45	7	localObject3	Object
    //   382	1	7	localObject4	Object
    //   239	25	8	localThrowable1	java.lang.Throwable
    //   387	1	8	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   38	56	239	java/lang/Throwable
    //   273	278	281	java/io/IOException
    //   4	28	302	finally
    //   273	278	302	finally
    //   283	299	302	finally
    //   319	324	302	finally
    //   324	327	302	finally
    //   329	345	302	finally
    //   353	358	302	finally
    //   363	379	302	finally
    //   38	56	309	finally
    //   319	324	327	java/io/IOException
    //   353	358	361	java/io/IOException
    //   60	66	382	finally
    //   70	76	382	finally
    //   87	98	382	finally
    //   102	113	382	finally
    //   124	133	382	finally
    //   137	146	382	finally
    //   150	157	382	finally
    //   161	170	382	finally
    //   174	185	382	finally
    //   189	195	382	finally
    //   206	217	382	finally
    //   221	232	382	finally
    //   248	254	382	finally
    //   258	268	382	finally
    //   60	66	387	java/lang/Throwable
    //   70	76	387	java/lang/Throwable
    //   87	98	387	java/lang/Throwable
    //   102	113	387	java/lang/Throwable
    //   124	133	387	java/lang/Throwable
    //   137	146	387	java/lang/Throwable
    //   150	157	387	java/lang/Throwable
    //   161	170	387	java/lang/Throwable
    //   174	185	387	java/lang/Throwable
    //   189	195	387	java/lang/Throwable
    //   206	217	387	java/lang/Throwable
    //   221	232	387	java/lang/Throwable
  }
  
  public void a(int paramInt, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager", 2, "onEvent:" + paramInt + ", " + paramLong1 + ", " + paramLong2);
    }
    long l1 = System.currentTimeMillis();
    this.x = l1;
    this.e = true;
    switch (paramInt)
    {
    default: 
      return;
    case 5: 
      paramInt = (int)(paramLong1 >> 8);
      int i1 = (int)(0xFF & paramLong1);
      if ((0xFF & paramLong2) == 1L) {}
      for (boolean bool = true;; bool = false)
      {
        a(l1, paramInt, i1, bool, (int)(paramLong2 >> 8));
        return;
      }
    case 100: 
      v = l1;
      this.w = 1;
      this.e = false;
      return;
    case 1: 
      this.w = 2;
      return;
    case 3: 
      this.w = 4;
      return;
    case 2: 
      this.w = 3;
      t = paramLong1;
      return;
    case 4: 
      this.w = 5;
      t = paramLong1;
      return;
    }
    MsfService.getCore().pushManager.j();
    MsfService.getCore().pushManager.k();
  }
  
  public void a(IInterface paramIInterface)
  {
    IBinder localIBinder;
    if (paramIInterface != null) {
      localIBinder = paramIInterface.asBinder();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GuardManager", 2, "onAppBind with " + paramIInterface);
      }
      paramIInterface = this.u;
      long l1;
      if (paramIInterface != localIBinder)
      {
        l1 = System.currentTimeMillis();
        if (paramIInterface != null)
        {
          paramIInterface.unlinkToDeath(this, 0);
          this.u = null;
          v = l1;
          this.x = l1;
        }
        if ((localIBinder == null) || (!localIBinder.isBinderAlive())) {}
      }
      try
      {
        localIBinder.linkToDeath(this, 0);
        this.u = localIBinder;
        v = l1;
        return;
        localIBinder = null;
      }
      catch (RemoteException paramIInterface)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("GuardManager", 2, "onAppBind ", paramIInterface);
      }
    }
  }
  
  public boolean a()
  {
    IBinder localIBinder = this.u;
    return (this.e) && (localIBinder != null) && (localIBinder.isBinderAlive());
  }
  
  public boolean a(int paramInt)
  {
    if ((this.d) || ((this.u != null) && (this.u.isBinderAlive())) || ((paramInt != 0) && (this.w == 2)) || ((paramInt != 0) && (this.w == 4))) {
      return true;
    }
    this.d = true;
    long l4 = System.currentTimeMillis();
    long l1 = Math.abs(l4 - v);
    int i1;
    if (((paramInt == 1) && (this.e) && (l1 > t)) || ((paramInt == 0) && (l1 > 500L)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("GuardManager", 2, "prestart " + paramInt + ", " + l4 + ", " + v + ", " + t);
      }
      localObject = new Intent("com.tencent.qqlite.broadcast.qq");
      if (paramInt == 1)
      {
        i1 = 1;
        ((Intent)localObject).putExtra("k_start_mode", i1);
        BaseApplication.getContext().sendBroadcast((Intent)localObject);
        v = l4;
        if (paramInt != 1) {
          break label240;
        }
        localObject = "0";
        a("GM_LiteTime", 0L, (String)localObject);
      }
    }
    label240:
    while ((paramInt != 2) || (l1 <= t)) {
      for (;;)
      {
        return true;
        i1 = 0;
        continue;
        localObject = "1";
      }
    }
    if (this.o == null) {
      b();
    }
    Object localObject = Calendar.getInstance(Locale.getDefault());
    ((Calendar)localObject).setTimeInMillis(l4);
    paramInt = ((Calendar)localObject).get(11);
    long l5 = l4 % 3600000L + paramInt * 60 * 60 * 1000;
    int i5 = paramInt / (24 / this.o.length);
    paramInt = this.n.length;
    int i4 = this.D + this.s;
    l1 = 0L;
    long l3;
    long l2;
    int i2;
    int i3;
    if (this.C != 2)
    {
      l3 = this.o[i5] + this.q[i5];
      i1 = paramInt;
      l2 = l3;
      if (l3 > 7L)
      {
        i2 = 0;
        for (i1 = paramInt; (i2 < paramInt) && (i1 > i4); i1 = i3)
        {
          i3 = i1;
          if (this.o[i2] + this.q[i2] < l3) {
            i3 = i1 - 1;
          }
          i2 += 1;
        }
        l1 = (this.n[i5] * this.o[i5] + this.p[i5] * this.q[i5]) / (this.o[i5] + this.q[i5]);
        l2 = l3;
      }
      label494:
      if ((i1 <= i4) && (l1 - l5 < t) && (l1 - l5 > -t))
      {
        if (QLog.isColorLevel()) {
          QLog.d("GuardManager", 2, "prestart bgFetch " + i1 + ", " + this.D + ", " + this.s + ", " + l2 + ", " + l5 + ", " + l1 + ", " + l4 + ", " + v + ", " + t);
        }
        localObject = new Intent("com.tencent.qqlite.broadcast.qq");
        ((Intent)localObject).putExtra("k_start_mode", 2);
        BaseApplication.getContext().sendBroadcast((Intent)localObject);
        if (this.C != 2) {
          break label894;
        }
      }
    }
    label894:
    for (localObject = "1";; localObject = "0")
    {
      a("GM_PrestartTime", l5, (String)localObject);
      v = l4;
      break;
      i1 = ((Calendar)localObject).get(7);
      if ((i1 == 7) || (i1 == 1))
      {
        l3 = this.q[i5];
        i1 = paramInt;
        l2 = l3;
        if (l3 <= 2L) {
          break label494;
        }
        i2 = 0;
        for (i1 = paramInt; (i2 < paramInt) && (i1 > i4); i1 = i3)
        {
          i3 = i1;
          if (this.q[i2] < l3) {
            i3 = i1 - 1;
          }
          i2 += 1;
        }
        l1 = this.p[i5];
        l2 = l3;
        break label494;
      }
      l3 = this.o[i5];
      i1 = paramInt;
      l2 = l3;
      if (l3 <= 5L) {
        break label494;
      }
      i2 = 0;
      for (i1 = paramInt; (i2 < paramInt) && (i1 > i4); i1 = i3)
      {
        i3 = i1;
        if (this.o[i2] < l3) {
          i3 = i1 - 1;
        }
        i2 += 1;
      }
      l1 = this.n[i5];
      l2 = l3;
      break label494;
    }
  }
  
  public void binderDied()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager", 2, "binderDied");
    }
    IBinder localIBinder = this.u;
    if (localIBinder != null)
    {
      localIBinder.unlinkToDeath(this, 0);
      this.u = null;
      v = System.currentTimeMillis();
      long l1 = v - this.x;
      if ((l1 > 0L) && (l1 < 86400000L)) {
        a("GM_AliveTime" + this.w, l1, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.service.h
 * JD-Core Version:    0.7.0.1
 */