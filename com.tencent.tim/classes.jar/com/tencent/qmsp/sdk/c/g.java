package com.tencent.qmsp.sdk.c;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.util.Pair;
import com.tencent.qmsp.sdk.a.b;
import com.tencent.qmsp.sdk.a.d;
import com.tencent.qmsp.sdk.a.e;
import com.tencent.qmsp.sdk.app.QmspSDK;
import com.tencent.qmsp.sdk.f.k;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public class g
{
  private static final byte[] f = { 51, 117, -95 };
  private static final byte[] g = { 38, 114, -96 };
  private static final byte[] h = { 20, 125, -96, 80, 13, 57, 57, -7, 36, 100 };
  private static final byte[] i = { 20, 125, -96, 80, 13, 57, 91, -20, 49 };
  private static final byte[] j = { 52, 100 };
  private static final byte[] k = { 20, 125, -96, 80, 96, 24, 117 };
  private static final byte[][] l = { { 54, 100 }, { 49, 99, -70 }, { 54, 115 } };
  private static g m;
  private ConcurrentHashMap<Integer, Integer> a = new ConcurrentHashMap();
  private CopyOnWriteArrayList<c> b = new CopyOnWriteArrayList();
  private SharedPreferences c = null;
  private long d = QmspSDK.getAtomCbTimeout().get();
  private int e = 0;
  
  private g()
  {
    b();
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    return a(new Pair(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2)));
  }
  
  private int a(Pair<Integer, Integer> paramPair)
  {
    if (paramPair == null) {
      return -1;
    }
    switch (((Integer)paramPair.first).intValue())
    {
    default: 
      return -1;
    case 10003: 
      if ((QmspSDK.getAtomUpdateInterval().get() != ((Integer)paramPair.second).intValue()) && (((Integer)paramPair.second).intValue() > 3600000))
      {
        QmspSDK.getAtomUpdateInterval().set(((Integer)paramPair.second).intValue());
        com.tencent.qmsp.sdk.f.g.a(a(k), 1, "[CB-CYC] Plugin Ruery TimeOut : " + QmspSDK.getAtomUpdateInterval().get());
      }
      return 0;
    case 10002: 
      if ((QmspSDK.getAtomCbTimeout().get() != ((Integer)paramPair.second).intValue()) && (((Integer)paramPair.second).intValue() > 3600000))
      {
        QmspSDK.getAtomCbTimeout().set(((Integer)paramPair.second).intValue());
        com.tencent.qmsp.sdk.f.g.a(a(k), 1, "[CB-CYC] CB Ruery TimeOut : " + QmspSDK.getAtomCbTimeout().get());
      }
      return 0;
    case 10001: 
      if ((QmspSDK.getAtomReadTimeOut().get() != ((Integer)paramPair.second).intValue()) && (((Integer)paramPair.second).intValue() > 5000))
      {
        QmspSDK.getAtomReadTimeOut().set(((Integer)paramPair.second).intValue());
        com.tencent.qmsp.sdk.f.g.a(a(k), 1, "[CB-CYC] Socket Read TimeOut: " + QmspSDK.getAtomReadTimeOut().get());
      }
      return 0;
    }
    if ((QmspSDK.getAtomConnTimeOut().get() != ((Integer)paramPair.second).intValue()) && (((Integer)paramPair.second).intValue() > 5000))
    {
      QmspSDK.getAtomConnTimeOut().set(((Integer)paramPair.second).intValue());
      com.tencent.qmsp.sdk.f.g.a(a(k), 1, "[CB-CYC] Socket Conn TimeOut: " + QmspSDK.getAtomConnTimeOut().get());
    }
    return 0;
  }
  
  private Pair<Integer, Integer> a(String paramString, JSONObject paramJSONObject)
  {
    try
    {
      paramString = new Pair(Integer.valueOf(Integer.parseInt(paramString)), Integer.valueOf(paramJSONObject.getInt(paramString)));
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  private String a(byte[] paramArrayOfByte)
  {
    return k.a(paramArrayOfByte);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    com.tencent.qmsp.sdk.f.g.a(a(k), 1, String.format("[CB] report: funType=%d, result=%d,  NowTaskID=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }));
    com.tencent.qmsp.sdk.a.g localg = new com.tencent.qmsp.sdk.a.g();
    try
    {
      localg.a(paramInt1).a(paramInt2).a(paramInt3);
      com.tencent.qmsp.sdk.a.f.a(localg.toString(), 1);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      com.tencent.qmsp.sdk.f.g.b(com.tencent.qmsp.sdk.f.g.a, 0, "onReport error!");
    }
  }
  
  private void a(long paramLong)
  {
    g.a locala = new g.a(this);
    f.i().c().postDelayed(locala, paramLong);
  }
  
  private void a(String paramString)
  {
    LinkedList localLinkedList = new LinkedList();
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        if (paramString.getInt(a(f)) != 1) {
          return;
        }
        paramString = paramString.getJSONObject(a(g));
        if (paramString == null) {
          continue;
        }
        Iterator localIterator = paramString.keys();
        if (localIterator == null) {
          continue;
        }
        if (!localIterator.hasNext()) {
          continue;
        }
        localPair = a((String)localIterator.next(), paramString);
        if (localPair == null) {
          continue;
        }
        a(localPair);
        localInteger = (Integer)this.a.get(localPair.first);
        if (localInteger != null) {
          continue;
        }
      }
      catch (Exception paramString)
      {
        Pair localPair;
        Integer localInteger;
        a(1002, -1, this.e);
        paramString.printStackTrace();
        g();
        if (localLinkedList.isEmpty()) {
          return;
        }
        paramString = this.b.iterator();
        if (!paramString.hasNext()) {
          return;
        }
        ((c)paramString.next()).a(localLinkedList);
        continue;
        int n = localInteger.byteValue();
        int i1 = ((Integer)localPair.second).intValue();
        if (n == i1) {
          continue;
        }
        continue;
      }
      localLinkedList.add(localPair);
      this.a.put(localPair.first, localPair.second);
    }
  }
  
  private void a(JSONObject paramJSONObject)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      com.tencent.qmsp.sdk.f.g.a("Task: ", 0, "cb-->Result: " + paramJSONObject);
      int i1 = -1;
      int n = i1;
      if (!paramJSONObject.isNull(a(l[0])))
      {
        n = i1;
        if (!paramJSONObject.isNull(a(l[1])))
        {
          n = i1;
          if (!paramJSONObject.isNull(a(l[2])))
          {
            i1 = paramJSONObject.optInt(a(l[0]));
            this.e = Integer.valueOf(paramJSONObject.optString(a(l[1]))).intValue();
            paramJSONObject = paramJSONObject.optString(a(l[2]));
            n = i1;
            if (i1 == 0)
            {
              n = i1;
              if (paramJSONObject != null)
              {
                n = i1;
                if (!paramJSONObject.equals(""))
                {
                  a(paramJSONObject);
                  n = i1;
                }
              }
            }
          }
        }
      }
      a(1001, n, this.e);
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  /* Error */
  private void b(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 324	java/io/DataInputStream
    //   3: dup
    //   4: new 326	java/io/ByteArrayInputStream
    //   7: dup
    //   8: aload_1
    //   9: invokespecial 328	java/io/ByteArrayInputStream:<init>	([B)V
    //   12: invokespecial 331	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   15: astore_1
    //   16: aload_1
    //   17: astore 5
    //   19: aload_1
    //   20: astore 4
    //   22: aload_1
    //   23: invokevirtual 334	java/io/DataInputStream:available	()I
    //   26: ifeq +68 -> 94
    //   29: aload_1
    //   30: astore 4
    //   32: aload_1
    //   33: invokevirtual 337	java/io/DataInputStream:readInt	()I
    //   36: istore_2
    //   37: aload_1
    //   38: astore 4
    //   40: aload_1
    //   41: invokevirtual 337	java/io/DataInputStream:readInt	()I
    //   44: istore_3
    //   45: aload_1
    //   46: astore 4
    //   48: aload_0
    //   49: iload_2
    //   50: iload_3
    //   51: invokespecial 339	com/tencent/qmsp/sdk/c/g:a	(II)I
    //   54: pop
    //   55: aload_1
    //   56: astore 4
    //   58: aload_0
    //   59: getfield 55	com/tencent/qmsp/sdk/c/g:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   62: iload_2
    //   63: invokestatic 118	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   66: iload_3
    //   67: invokestatic 118	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   70: invokevirtual 274	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   73: pop
    //   74: goto -58 -> 16
    //   77: astore 5
    //   79: aload_1
    //   80: astore 4
    //   82: aload 5
    //   84: invokevirtual 340	java/io/IOException:printStackTrace	()V
    //   87: aload_1
    //   88: ifnull +11 -> 99
    //   91: aload_1
    //   92: astore 5
    //   94: aload 5
    //   96: invokevirtual 343	java/io/DataInputStream:close	()V
    //   99: return
    //   100: astore_1
    //   101: aconst_null
    //   102: astore 4
    //   104: aload 4
    //   106: ifnull +8 -> 114
    //   109: aload 4
    //   111: invokevirtual 343	java/io/DataInputStream:close	()V
    //   114: aload_1
    //   115: athrow
    //   116: astore 5
    //   118: aconst_null
    //   119: astore_1
    //   120: goto -41 -> 79
    //   123: astore_1
    //   124: aload_1
    //   125: invokevirtual 340	java/io/IOException:printStackTrace	()V
    //   128: return
    //   129: astore 4
    //   131: aload 4
    //   133: invokevirtual 340	java/io/IOException:printStackTrace	()V
    //   136: goto -22 -> 114
    //   139: astore_1
    //   140: goto -36 -> 104
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	143	0	this	g
    //   0	143	1	paramArrayOfByte	byte[]
    //   36	27	2	n	int
    //   44	23	3	i1	int
    //   20	90	4	arrayOfByte1	byte[]
    //   129	3	4	localIOException1	java.io.IOException
    //   17	1	5	arrayOfByte2	byte[]
    //   77	6	5	localIOException2	java.io.IOException
    //   92	3	5	arrayOfByte3	byte[]
    //   116	1	5	localIOException3	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   22	29	77	java/io/IOException
    //   32	37	77	java/io/IOException
    //   40	45	77	java/io/IOException
    //   48	55	77	java/io/IOException
    //   58	74	77	java/io/IOException
    //   0	16	100	finally
    //   0	16	116	java/io/IOException
    //   94	99	123	java/io/IOException
    //   109	114	129	java/io/IOException
    //   22	29	139	finally
    //   32	37	139	finally
    //   40	45	139	finally
    //   48	55	139	finally
    //   58	74	139	finally
    //   82	87	139	finally
  }
  
  private JSONObject c()
  {
    try
    {
      Object localObject1 = this.c.edit();
      ((SharedPreferences.Editor)localObject1).putLong(a(j), System.currentTimeMillis());
      ((SharedPreferences.Editor)localObject1).commit();
      localObject1 = new JSONObject();
      JSONObject localJSONObject = d.a(1);
      if (localJSONObject == null)
      {
        localObject2 = a(k);
        com.tencent.qmsp.sdk.f.g.d((String)localObject2, 0, "make query head Fail!");
      }
      Object localObject2 = new JSONObject();
      ((JSONObject)localObject2).put(e.a(20), 1);
      ((JSONObject)localObject2).put(e.a(21), 512);
      ((JSONObject)localObject1).put(e.a(15), localJSONObject);
      ((JSONObject)localObject1).put(e.a(16), localObject2);
      return localObject1;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  public static g d()
  {
    if (m == null) {}
    try
    {
      if (m == null) {
        m = new g();
      }
      return m;
    }
    finally {}
  }
  
  private String e()
  {
    return b.a() + File.separator + a(h);
  }
  
  private boolean f()
  {
    long l2;
    for (long l1 = 0L;; l1 = l2)
    {
      try
      {
        this.d = QmspSDK.getAtomCbTimeout().get();
        l2 = this.c.getLong(a(j), 0L);
        l2 = System.currentTimeMillis() - l2;
        if (l2 >= 0L) {
          continue;
        }
        if (l1 < QmspSDK.getAtomCbTimeout().get())
        {
          this.d -= l1;
          return false;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      return true;
    }
  }
  
  private void g()
  {
    byte[] arrayOfByte = h();
    if (arrayOfByte != null) {
      new m().a(e(), arrayOfByte, null, 1);
    }
  }
  
  /* Error */
  private byte[] h()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 416	java/io/ByteArrayOutputStream
    //   5: dup
    //   6: invokespecial 417	java/io/ByteArrayOutputStream:<init>	()V
    //   9: astore_1
    //   10: new 419	java/io/DataOutputStream
    //   13: dup
    //   14: aload_1
    //   15: invokespecial 422	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   18: astore_2
    //   19: aload_0
    //   20: getfield 55	com/tencent/qmsp/sdk/c/g:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   23: invokevirtual 426	java/util/concurrent/ConcurrentHashMap:entrySet	()Ljava/util/Set;
    //   26: invokeinterface 429 1 0
    //   31: astore_3
    //   32: aload_3
    //   33: invokeinterface 255 1 0
    //   38: ifeq +84 -> 122
    //   41: aload_3
    //   42: invokeinterface 259 1 0
    //   47: checkcast 431	java/util/Map$Entry
    //   50: astore 4
    //   52: aload_2
    //   53: aload 4
    //   55: invokeinterface 434 1 0
    //   60: checkcast 114	java/lang/Integer
    //   63: invokevirtual 131	java/lang/Integer:intValue	()I
    //   66: invokevirtual 437	java/io/DataOutputStream:writeInt	(I)V
    //   69: aload_2
    //   70: aload 4
    //   72: invokeinterface 440 1 0
    //   77: checkcast 114	java/lang/Integer
    //   80: invokevirtual 131	java/lang/Integer:intValue	()I
    //   83: invokevirtual 437	java/io/DataOutputStream:writeInt	(I)V
    //   86: goto -54 -> 32
    //   89: astore 4
    //   91: aload_2
    //   92: astore_3
    //   93: aload_1
    //   94: astore_2
    //   95: aload_3
    //   96: astore_1
    //   97: aload 4
    //   99: astore_3
    //   100: aload_3
    //   101: invokevirtual 340	java/io/IOException:printStackTrace	()V
    //   104: aload_2
    //   105: ifnull +7 -> 112
    //   108: aload_2
    //   109: invokevirtual 441	java/io/ByteArrayOutputStream:close	()V
    //   112: aload_1
    //   113: ifnull +7 -> 120
    //   116: aload_1
    //   117: invokevirtual 442	java/io/DataOutputStream:close	()V
    //   120: aconst_null
    //   121: areturn
    //   122: aload_1
    //   123: invokevirtual 445	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   126: astore_3
    //   127: aload_1
    //   128: invokevirtual 441	java/io/ByteArrayOutputStream:close	()V
    //   131: aload_2
    //   132: invokevirtual 442	java/io/DataOutputStream:close	()V
    //   135: aload_3
    //   136: areturn
    //   137: astore_1
    //   138: aload_1
    //   139: invokevirtual 340	java/io/IOException:printStackTrace	()V
    //   142: aload_3
    //   143: areturn
    //   144: astore_1
    //   145: aload_1
    //   146: invokevirtual 340	java/io/IOException:printStackTrace	()V
    //   149: goto -18 -> 131
    //   152: astore 4
    //   154: aload_2
    //   155: astore_3
    //   156: aload_1
    //   157: astore_2
    //   158: aload 4
    //   160: astore_1
    //   161: aload_2
    //   162: ifnull +7 -> 169
    //   165: aload_2
    //   166: invokevirtual 441	java/io/ByteArrayOutputStream:close	()V
    //   169: aload_3
    //   170: ifnull +7 -> 177
    //   173: aload_3
    //   174: invokevirtual 442	java/io/DataOutputStream:close	()V
    //   177: aload_1
    //   178: athrow
    //   179: astore 4
    //   181: aload_1
    //   182: astore_2
    //   183: aload 4
    //   185: astore_1
    //   186: goto -25 -> 161
    //   189: astore_3
    //   190: aconst_null
    //   191: astore 4
    //   193: aload_1
    //   194: astore_2
    //   195: aload 4
    //   197: astore_1
    //   198: goto -98 -> 100
    //   201: astore_1
    //   202: aconst_null
    //   203: astore_2
    //   204: goto -43 -> 161
    //   207: astore_3
    //   208: aconst_null
    //   209: astore_1
    //   210: aconst_null
    //   211: astore_2
    //   212: goto -112 -> 100
    //   215: astore_2
    //   216: aload_2
    //   217: invokevirtual 340	java/io/IOException:printStackTrace	()V
    //   220: goto -108 -> 112
    //   223: astore_1
    //   224: aload_1
    //   225: invokevirtual 340	java/io/IOException:printStackTrace	()V
    //   228: goto -108 -> 120
    //   231: astore 4
    //   233: aload_1
    //   234: astore_3
    //   235: aload 4
    //   237: astore_1
    //   238: goto -77 -> 161
    //   241: astore_2
    //   242: aload_2
    //   243: invokevirtual 340	java/io/IOException:printStackTrace	()V
    //   246: goto -77 -> 169
    //   249: astore_2
    //   250: aload_2
    //   251: invokevirtual 340	java/io/IOException:printStackTrace	()V
    //   254: goto -77 -> 177
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	257	0	this	g
    //   9	119	1	localObject1	Object
    //   137	2	1	localIOException1	java.io.IOException
    //   144	13	1	localIOException2	java.io.IOException
    //   160	38	1	localObject2	Object
    //   201	1	1	localObject3	Object
    //   209	1	1	localObject4	Object
    //   223	11	1	localIOException3	java.io.IOException
    //   237	1	1	localObject5	Object
    //   18	194	2	localObject6	Object
    //   215	2	2	localIOException4	java.io.IOException
    //   241	2	2	localIOException5	java.io.IOException
    //   249	2	2	localIOException6	java.io.IOException
    //   1	173	3	localObject7	Object
    //   189	1	3	localIOException7	java.io.IOException
    //   207	1	3	localIOException8	java.io.IOException
    //   234	1	3	localObject8	Object
    //   50	21	4	localEntry	java.util.Map.Entry
    //   89	9	4	localIOException9	java.io.IOException
    //   152	7	4	localObject9	Object
    //   179	5	4	localObject10	Object
    //   191	5	4	localObject11	Object
    //   231	5	4	localObject12	Object
    // Exception table:
    //   from	to	target	type
    //   19	32	89	java/io/IOException
    //   32	86	89	java/io/IOException
    //   122	127	89	java/io/IOException
    //   131	135	137	java/io/IOException
    //   127	131	144	java/io/IOException
    //   19	32	152	finally
    //   32	86	152	finally
    //   122	127	152	finally
    //   10	19	179	finally
    //   10	19	189	java/io/IOException
    //   2	10	201	finally
    //   2	10	207	java/io/IOException
    //   108	112	215	java/io/IOException
    //   116	120	223	java/io/IOException
    //   100	104	231	finally
    //   165	169	241	java/io/IOException
    //   173	177	249	java/io/IOException
  }
  
  private void i()
  {
    try
    {
      a(1003, 0, this.e);
      JSONObject localJSONObject = c();
      String str = a(k);
      StringBuilder localStringBuilder = new StringBuilder();
      com.tencent.qmsp.sdk.f.g.d(str, 0, "CB: " + localJSONObject.toString());
      com.tencent.qmsp.sdk.b.g.b().a(1, QmspSDK.getAppID(), 1, localJSONObject, new g.b(this));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public int a(int paramInt)
  {
    Integer localInteger = (Integer)this.a.get(Integer.valueOf(paramInt));
    if (localInteger != null) {
      return localInteger.intValue();
    }
    return -1;
  }
  
  public void a()
  {
    if (m != null) {
      m = null;
    }
  }
  
  public void a(c paramc)
  {
    this.b.add(paramc);
  }
  
  /* Error */
  public void a(boolean paramBoolean)
  {
    // Byte code:
    //   0: invokestatic 471	com/tencent/qmsp/sdk/app/QmspSDK:getTaskStatus	()Z
    //   3: ifne +18 -> 21
    //   6: aload_0
    //   7: getstatic 43	com/tencent/qmsp/sdk/c/g:k	[B
    //   10: invokespecial 97	com/tencent/qmsp/sdk/c/g:a	([B)Ljava/lang/String;
    //   13: iconst_1
    //   14: ldc_w 473
    //   17: invokestatic 152	com/tencent/qmsp/sdk/f/g:a	(Ljava/lang/String;ILjava/lang/String;)V
    //   20: return
    //   21: aload_0
    //   22: getstatic 43	com/tencent/qmsp/sdk/c/g:k	[B
    //   25: invokespecial 97	com/tencent/qmsp/sdk/c/g:a	([B)Ljava/lang/String;
    //   28: astore_2
    //   29: aload_2
    //   30: iconst_1
    //   31: ldc_w 475
    //   34: invokestatic 152	com/tencent/qmsp/sdk/f/g:a	(Ljava/lang/String;ILjava/lang/String;)V
    //   37: iload_1
    //   38: ifne +26 -> 64
    //   41: aload_0
    //   42: invokespecial 477	com/tencent/qmsp/sdk/c/g:f	()Z
    //   45: ifne +62 -> 107
    //   48: aload_0
    //   49: getstatic 43	com/tencent/qmsp/sdk/c/g:k	[B
    //   52: invokespecial 97	com/tencent/qmsp/sdk/c/g:a	([B)Ljava/lang/String;
    //   55: astore_2
    //   56: aload_2
    //   57: iconst_1
    //   58: ldc_w 479
    //   61: invokestatic 152	com/tencent/qmsp/sdk/f/g:a	(Ljava/lang/String;ILjava/lang/String;)V
    //   64: aload_0
    //   65: getstatic 43	com/tencent/qmsp/sdk/c/g:k	[B
    //   68: invokespecial 97	com/tencent/qmsp/sdk/c/g:a	([B)Ljava/lang/String;
    //   71: iconst_0
    //   72: new 84	java/lang/StringBuilder
    //   75: dup
    //   76: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   79: ldc_w 481
    //   82: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: aload_0
    //   86: getfield 76	com/tencent/qmsp/sdk/c/g:d	J
    //   89: invokevirtual 484	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   92: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: invokestatic 152	com/tencent/qmsp/sdk/f/g:a	(Ljava/lang/String;ILjava/lang/String;)V
    //   98: aload_0
    //   99: aload_0
    //   100: getfield 76	com/tencent/qmsp/sdk/c/g:d	J
    //   103: invokespecial 486	com/tencent/qmsp/sdk/c/g:a	(J)V
    //   106: return
    //   107: aload_0
    //   108: invokespecial 488	com/tencent/qmsp/sdk/c/g:i	()V
    //   111: goto -47 -> 64
    //   114: astore_2
    //   115: aload_2
    //   116: invokevirtual 491	java/lang/Throwable:printStackTrace	()V
    //   119: aload_0
    //   120: getstatic 43	com/tencent/qmsp/sdk/c/g:k	[B
    //   123: invokespecial 97	com/tencent/qmsp/sdk/c/g:a	([B)Ljava/lang/String;
    //   126: iconst_0
    //   127: new 84	java/lang/StringBuilder
    //   130: dup
    //   131: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   134: ldc_w 481
    //   137: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: aload_0
    //   141: getfield 76	com/tencent/qmsp/sdk/c/g:d	J
    //   144: invokevirtual 484	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   147: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   150: invokestatic 152	com/tencent/qmsp/sdk/f/g:a	(Ljava/lang/String;ILjava/lang/String;)V
    //   153: aload_0
    //   154: aload_0
    //   155: getfield 76	com/tencent/qmsp/sdk/c/g:d	J
    //   158: invokespecial 486	com/tencent/qmsp/sdk/c/g:a	(J)V
    //   161: return
    //   162: astore_2
    //   163: aload_0
    //   164: getstatic 43	com/tencent/qmsp/sdk/c/g:k	[B
    //   167: invokespecial 97	com/tencent/qmsp/sdk/c/g:a	([B)Ljava/lang/String;
    //   170: iconst_0
    //   171: new 84	java/lang/StringBuilder
    //   174: dup
    //   175: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   178: ldc_w 481
    //   181: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: aload_0
    //   185: getfield 76	com/tencent/qmsp/sdk/c/g:d	J
    //   188: invokevirtual 484	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   191: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   194: invokestatic 152	com/tencent/qmsp/sdk/f/g:a	(Ljava/lang/String;ILjava/lang/String;)V
    //   197: aload_0
    //   198: aload_0
    //   199: getfield 76	com/tencent/qmsp/sdk/c/g:d	J
    //   202: invokespecial 486	com/tencent/qmsp/sdk/c/g:a	(J)V
    //   205: aload_2
    //   206: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	207	0	this	g
    //   0	207	1	paramBoolean	boolean
    //   28	29	2	str	String
    //   114	2	2	localObject1	Object
    //   162	44	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   21	29	114	finally
    //   29	37	114	finally
    //   41	56	114	finally
    //   56	64	114	finally
    //   107	111	114	finally
    //   115	119	162	finally
  }
  
  public void b()
  {
    byte[] arrayOfByte = new m().a(e(), null, 1);
    if (arrayOfByte != null) {
      b(arrayOfByte);
    }
  }
  
  public static abstract interface c
  {
    public abstract void a(List<Pair<Integer, Integer>> paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qmsp.sdk.c.g
 * JD-Core Version:    0.7.0.1
 */