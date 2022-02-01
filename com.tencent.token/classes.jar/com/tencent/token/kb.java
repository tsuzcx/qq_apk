package com.tencent.token;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class kb
  implements apz
{
  public int a;
  public String b;
  public int c;
  private final String d = "SharkOutlet";
  private ka e;
  private long f = -1L;
  
  public kb(Context paramContext)
  {
    this.e = new ka(paramContext);
  }
  
  private static String[] a(Context paramContext)
  {
    String str2 = Build.MODEL;
    String str3 = Build.VERSION.RELEASE;
    Object localObject = "";
    try
    {
      String str1 = e("/proc/cpuinfo").split("\\n")[0];
      localObject = str1;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Integer.toString(arr.d(paramContext)));
    localStringBuilder.append("*");
    localStringBuilder.append(Integer.toString(arr.e(paramContext)));
    return new String[] { str2, str3, localObject, localStringBuilder.toString() };
  }
  
  private static String b(ArrayList paramArrayList)
  {
    if (paramArrayList == null) {
      return null;
    }
    if (paramArrayList.size() <= 0) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramArrayList.size();
    int i = 0;
    while (i < j)
    {
      String str = (String)paramArrayList.get(i);
      if (!TextUtils.isEmpty(str))
      {
        localStringBuilder.append(str);
        if (j - 1 != i) {
          localStringBuilder.append("|");
        }
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  private static void c(ArrayList paramArrayList)
  {
    if (paramArrayList != null)
    {
      if (paramArrayList.size() <= 0) {
        return;
      }
      int j = paramArrayList.size();
      int i = 0;
      while (i < j)
      {
        if (paramArrayList.get(i) != null)
        {
          StringBuilder localStringBuilder = new StringBuilder("printIpList() ipList[");
          localStringBuilder.append(i);
          localStringBuilder.append("]: ");
          localStringBuilder.append((String)paramArrayList.get(i));
          localStringBuilder = new StringBuilder("printIpList() ipList[");
          localStringBuilder.append(i);
          localStringBuilder.append("]: ");
          localStringBuilder.append((String)paramArrayList.get(i));
        }
        i += 1;
      }
      return;
    }
  }
  
  private static String d(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  /* Error */
  private static String e(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore_3
    //   5: aconst_null
    //   6: astore_2
    //   7: aconst_null
    //   8: astore 6
    //   10: new 128	java/io/BufferedInputStream
    //   13: dup
    //   14: new 130	java/io/FileInputStream
    //   17: dup
    //   18: aload_0
    //   19: invokespecial 131	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   22: invokespecial 134	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   25: astore_0
    //   26: aload_3
    //   27: astore_2
    //   28: aload_0
    //   29: astore_3
    //   30: new 136	java/io/ByteArrayOutputStream
    //   33: dup
    //   34: invokespecial 137	java/io/ByteArrayOutputStream:<init>	()V
    //   37: astore 4
    //   39: sipush 1024
    //   42: newarray byte
    //   44: astore_2
    //   45: aload_0
    //   46: aload_2
    //   47: invokevirtual 141	java/io/BufferedInputStream:read	([B)I
    //   50: istore_1
    //   51: iload_1
    //   52: iconst_m1
    //   53: if_icmpeq +14 -> 67
    //   56: aload 4
    //   58: aload_2
    //   59: iconst_0
    //   60: iload_1
    //   61: invokevirtual 145	java/io/ByteArrayOutputStream:write	([BII)V
    //   64: goto -19 -> 45
    //   67: new 60	java/lang/String
    //   70: dup
    //   71: aload 4
    //   73: invokevirtual 149	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   76: invokespecial 152	java/lang/String:<init>	([B)V
    //   79: astore_2
    //   80: aload 4
    //   82: invokevirtual 155	java/io/ByteArrayOutputStream:close	()V
    //   85: goto +8 -> 93
    //   88: astore_3
    //   89: aload_3
    //   90: invokevirtual 156	java/io/IOException:printStackTrace	()V
    //   93: aload_0
    //   94: invokevirtual 157	java/io/BufferedInputStream:close	()V
    //   97: aload_2
    //   98: areturn
    //   99: astore_0
    //   100: aload_0
    //   101: invokevirtual 156	java/io/IOException:printStackTrace	()V
    //   104: aload_2
    //   105: areturn
    //   106: astore_3
    //   107: aload 4
    //   109: astore_2
    //   110: aload_3
    //   111: astore 4
    //   113: goto +144 -> 257
    //   116: astore 5
    //   118: goto +41 -> 159
    //   121: astore 5
    //   123: goto +83 -> 206
    //   126: astore 5
    //   128: aload 6
    //   130: astore 4
    //   132: goto +27 -> 159
    //   135: astore 5
    //   137: aload 7
    //   139: astore 4
    //   141: goto +65 -> 206
    //   144: astore 4
    //   146: aconst_null
    //   147: astore_0
    //   148: goto +109 -> 257
    //   151: astore 5
    //   153: aconst_null
    //   154: astore_0
    //   155: aload 6
    //   157: astore 4
    //   159: aload 4
    //   161: astore_2
    //   162: aload_0
    //   163: astore_3
    //   164: aload 5
    //   166: invokevirtual 156	java/io/IOException:printStackTrace	()V
    //   169: aload 4
    //   171: ifnull +16 -> 187
    //   174: aload 4
    //   176: invokevirtual 155	java/io/ByteArrayOutputStream:close	()V
    //   179: goto +8 -> 187
    //   182: astore_2
    //   183: aload_2
    //   184: invokevirtual 156	java/io/IOException:printStackTrace	()V
    //   187: aload_0
    //   188: ifnull +62 -> 250
    //   191: aload_0
    //   192: invokevirtual 157	java/io/BufferedInputStream:close	()V
    //   195: goto +55 -> 250
    //   198: astore 5
    //   200: aconst_null
    //   201: astore_0
    //   202: aload 7
    //   204: astore 4
    //   206: aload 4
    //   208: astore_2
    //   209: aload_0
    //   210: astore_3
    //   211: aload 5
    //   213: invokevirtual 158	java/io/FileNotFoundException:printStackTrace	()V
    //   216: aload 4
    //   218: ifnull +16 -> 234
    //   221: aload 4
    //   223: invokevirtual 155	java/io/ByteArrayOutputStream:close	()V
    //   226: goto +8 -> 234
    //   229: astore_2
    //   230: aload_2
    //   231: invokevirtual 156	java/io/IOException:printStackTrace	()V
    //   234: aload_0
    //   235: ifnull +15 -> 250
    //   238: aload_0
    //   239: invokevirtual 157	java/io/BufferedInputStream:close	()V
    //   242: goto +8 -> 250
    //   245: astore_0
    //   246: aload_0
    //   247: invokevirtual 156	java/io/IOException:printStackTrace	()V
    //   250: ldc 51
    //   252: areturn
    //   253: astore 4
    //   255: aload_3
    //   256: astore_0
    //   257: aload_2
    //   258: ifnull +15 -> 273
    //   261: aload_2
    //   262: invokevirtual 155	java/io/ByteArrayOutputStream:close	()V
    //   265: goto +8 -> 273
    //   268: astore_2
    //   269: aload_2
    //   270: invokevirtual 156	java/io/IOException:printStackTrace	()V
    //   273: aload_0
    //   274: ifnull +15 -> 289
    //   277: aload_0
    //   278: invokevirtual 157	java/io/BufferedInputStream:close	()V
    //   281: goto +8 -> 289
    //   284: astore_0
    //   285: aload_0
    //   286: invokevirtual 156	java/io/IOException:printStackTrace	()V
    //   289: aload 4
    //   291: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	292	0	paramString	String
    //   50	11	1	i	int
    //   6	156	2	localObject1	Object
    //   182	2	2	localIOException1	IOException
    //   208	1	2	localObject2	Object
    //   229	33	2	localIOException2	IOException
    //   268	2	2	localIOException3	IOException
    //   4	26	3	str1	String
    //   88	2	3	localIOException4	IOException
    //   106	5	3	localObject3	Object
    //   163	93	3	str2	String
    //   37	103	4	localObject4	Object
    //   144	1	4	localObject5	Object
    //   157	65	4	localObject6	Object
    //   253	37	4	localObject7	Object
    //   116	1	5	localIOException5	IOException
    //   121	1	5	localFileNotFoundException1	java.io.FileNotFoundException
    //   126	1	5	localIOException6	IOException
    //   135	1	5	localFileNotFoundException2	java.io.FileNotFoundException
    //   151	14	5	localIOException7	IOException
    //   198	14	5	localFileNotFoundException3	java.io.FileNotFoundException
    //   8	148	6	localObject8	Object
    //   1	202	7	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   80	85	88	java/io/IOException
    //   93	97	99	java/io/IOException
    //   39	45	106	finally
    //   45	51	106	finally
    //   56	64	106	finally
    //   67	80	106	finally
    //   39	45	116	java/io/IOException
    //   45	51	116	java/io/IOException
    //   56	64	116	java/io/IOException
    //   67	80	116	java/io/IOException
    //   39	45	121	java/io/FileNotFoundException
    //   45	51	121	java/io/FileNotFoundException
    //   56	64	121	java/io/FileNotFoundException
    //   67	80	121	java/io/FileNotFoundException
    //   30	39	126	java/io/IOException
    //   30	39	135	java/io/FileNotFoundException
    //   10	26	144	finally
    //   10	26	151	java/io/IOException
    //   174	179	182	java/io/IOException
    //   10	26	198	java/io/FileNotFoundException
    //   221	226	229	java/io/IOException
    //   191	195	245	java/io/IOException
    //   238	242	245	java/io/IOException
    //   30	39	253	finally
    //   164	169	253	finally
    //   211	216	253	finally
    //   261	265	268	java/io/IOException
    //   277	281	284	java/io/IOException
  }
  
  private static int f(String paramString)
  {
    try
    {
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (Exception paramString)
    {
      label7:
      break label7;
    }
    return 0;
  }
  
  private static ArrayList g(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = paramString.split("\\|");
    if (paramString != null)
    {
      if (paramString.length <= 0) {
        return null;
      }
      ArrayList localArrayList = new ArrayList();
      Collections.addAll(localArrayList, paramString);
      return localArrayList;
    }
    return null;
  }
  
  private static String m()
  {
    String str1 = "";
    String str2;
    try
    {
      InputStream localInputStream = new ProcessBuilder(new String[] { "/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq" }).start().getInputStream();
      byte[] arrayOfByte = new byte[24];
      while (localInputStream.read(arrayOfByte) != -1)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str1);
        localStringBuilder.append(new String(arrayOfByte));
        str1 = localStringBuilder.toString();
      }
      localInputStream.close();
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
      str2 = "N/A";
    }
    return str2.trim();
  }
  
  /* Error */
  private long n()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 29	com/tencent/token/kb:f	J
    //   4: ldc2_w 26
    //   7: lcmp
    //   8: ifne +240 -> 248
    //   11: new 208	java/io/File
    //   14: dup
    //   15: ldc 210
    //   17: invokespecial 211	java/io/File:<init>	(Ljava/lang/String;)V
    //   20: astore 4
    //   22: aconst_null
    //   23: astore 5
    //   25: aconst_null
    //   26: astore 6
    //   28: aconst_null
    //   29: astore 7
    //   31: aconst_null
    //   32: astore_3
    //   33: aload 4
    //   35: invokevirtual 215	java/io/File:exists	()Z
    //   38: ifeq +210 -> 248
    //   41: new 217	java/io/DataInputStream
    //   44: dup
    //   45: new 130	java/io/FileInputStream
    //   48: dup
    //   49: aload 4
    //   51: invokespecial 220	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   54: invokespecial 221	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   57: astore 4
    //   59: aload 4
    //   61: invokevirtual 224	java/io/DataInputStream:readLine	()Ljava/lang/String;
    //   64: astore_3
    //   65: aload_3
    //   66: ifnull +29 -> 95
    //   69: aload_0
    //   70: aload_3
    //   71: invokevirtual 202	java/lang/String:trim	()Ljava/lang/String;
    //   74: ldc 226
    //   76: invokevirtual 64	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   79: iconst_1
    //   80: aaload
    //   81: invokestatic 232	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   84: putfield 29	com/tencent/token/kb:f	J
    //   87: aload 4
    //   89: invokevirtual 233	java/io/DataInputStream:close	()V
    //   92: goto +156 -> 248
    //   95: new 126	java/io/IOException
    //   98: dup
    //   99: ldc 235
    //   101: invokespecial 236	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   104: athrow
    //   105: astore_3
    //   106: goto +120 -> 226
    //   109: astore 5
    //   111: goto +32 -> 143
    //   114: astore 5
    //   116: goto +54 -> 170
    //   119: astore 5
    //   121: goto +76 -> 197
    //   124: astore 5
    //   126: aload_3
    //   127: astore 4
    //   129: aload 5
    //   131: astore_3
    //   132: goto +94 -> 226
    //   135: astore_3
    //   136: aload 5
    //   138: astore 4
    //   140: aload_3
    //   141: astore 5
    //   143: aload 4
    //   145: astore_3
    //   146: aload 5
    //   148: invokevirtual 237	java/lang/NumberFormatException:printStackTrace	()V
    //   151: aload 4
    //   153: ifnull +95 -> 248
    //   156: aload 4
    //   158: invokevirtual 233	java/io/DataInputStream:close	()V
    //   161: goto +87 -> 248
    //   164: astore 5
    //   166: aload 6
    //   168: astore 4
    //   170: aload 4
    //   172: astore_3
    //   173: aload 5
    //   175: invokevirtual 156	java/io/IOException:printStackTrace	()V
    //   178: aload 4
    //   180: ifnull +68 -> 248
    //   183: aload 4
    //   185: invokevirtual 233	java/io/DataInputStream:close	()V
    //   188: goto +60 -> 248
    //   191: astore 5
    //   193: aload 7
    //   195: astore 4
    //   197: aload 4
    //   199: astore_3
    //   200: aload 5
    //   202: invokevirtual 158	java/io/FileNotFoundException:printStackTrace	()V
    //   205: aload 4
    //   207: ifnull +41 -> 248
    //   210: aload 4
    //   212: invokevirtual 233	java/io/DataInputStream:close	()V
    //   215: goto +33 -> 248
    //   218: astore_3
    //   219: aload_3
    //   220: invokevirtual 156	java/io/IOException:printStackTrace	()V
    //   223: goto +25 -> 248
    //   226: aload 4
    //   228: ifnull +18 -> 246
    //   231: aload 4
    //   233: invokevirtual 233	java/io/DataInputStream:close	()V
    //   236: goto +10 -> 246
    //   239: astore 4
    //   241: aload 4
    //   243: invokevirtual 156	java/io/IOException:printStackTrace	()V
    //   246: aload_3
    //   247: athrow
    //   248: aload_0
    //   249: getfield 29	com/tencent/token/kb:f	J
    //   252: lstore_1
    //   253: lload_1
    //   254: lconst_0
    //   255: lcmp
    //   256: ifle +5 -> 261
    //   259: lload_1
    //   260: lreturn
    //   261: lconst_1
    //   262: lreturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	263	0	this	kb
    //   252	8	1	l	long
    //   32	39	3	str	String
    //   105	22	3	localObject1	Object
    //   131	1	3	localObject2	Object
    //   135	6	3	localNumberFormatException1	java.lang.NumberFormatException
    //   145	55	3	localObject3	Object
    //   218	29	3	localIOException1	IOException
    //   20	212	4	localObject4	Object
    //   239	3	4	localIOException2	IOException
    //   23	1	5	localObject5	Object
    //   109	1	5	localNumberFormatException2	java.lang.NumberFormatException
    //   114	1	5	localIOException3	IOException
    //   119	1	5	localFileNotFoundException1	java.io.FileNotFoundException
    //   124	13	5	localObject6	Object
    //   141	6	5	localObject7	Object
    //   164	10	5	localIOException4	IOException
    //   191	10	5	localFileNotFoundException2	java.io.FileNotFoundException
    //   26	141	6	localObject8	Object
    //   29	165	7	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   59	65	105	finally
    //   69	87	105	finally
    //   95	105	105	finally
    //   59	65	109	java/lang/NumberFormatException
    //   69	87	109	java/lang/NumberFormatException
    //   95	105	109	java/lang/NumberFormatException
    //   59	65	114	java/io/IOException
    //   69	87	114	java/io/IOException
    //   95	105	114	java/io/IOException
    //   59	65	119	java/io/FileNotFoundException
    //   69	87	119	java/io/FileNotFoundException
    //   95	105	119	java/io/FileNotFoundException
    //   41	59	124	finally
    //   146	151	124	finally
    //   173	178	124	finally
    //   200	205	124	finally
    //   41	59	135	java/lang/NumberFormatException
    //   41	59	164	java/io/IOException
    //   41	59	191	java/io/FileNotFoundException
    //   87	92	218	java/io/IOException
    //   156	161	218	java/io/IOException
    //   183	188	218	java/io/IOException
    //   210	215	218	java/io/IOException
    //   231	236	239	java/io/IOException
  }
  
  public final int a()
  {
    return this.e.d();
  }
  
  public final void a(int paramInt)
  {
    ka localka = this.e;
    String str = Integer.toString(paramInt);
    if (str != null) {
      localka.a("key_itsc", str);
    }
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    ka localka = this.e;
    String str = Integer.toString(paramInt1);
    if (str != null) {
      localka.a("key_ha", str);
    }
    localka = this.e;
    str = Integer.toString(paramInt2);
    if (str != null) {
      localka.a("key_ha_sq", str);
    }
  }
  
  public final void a(long paramLong)
  {
    this.e.a("key_gd_ck_tm", Long.toString(paramLong));
  }
  
  public final void a(long paramLong, ArrayList paramArrayList1, ArrayList paramArrayList2, ArrayList paramArrayList3)
  {
    ka localka = this.e;
    String str = Long.toString(paramLong);
    if (str != null) {
      localka.a("key_lt_tm", str);
    }
    paramArrayList1 = b(paramArrayList1);
    if (paramArrayList1 != null) {
      this.e.a("key_mc", paramArrayList1);
    }
    paramArrayList1 = b(paramArrayList2);
    if (paramArrayList1 != null) {
      this.e.a("key_nu", paramArrayList1);
    }
    paramArrayList1 = b(paramArrayList3);
    if (paramArrayList1 != null) {
      this.e.a("key_tc", paramArrayList1);
    }
  }
  
  public final void a(ag paramag)
  {
    ka localka = this.e;
    localka.a("key_gd_1", paramag.a);
    localka.a("key_gd_2", paramag.b);
    localka.a("key_gd_3", paramag.c);
    localka.a("key_gd_4", paramag.d);
    localka.a("key_gd_5", paramag.e);
    localka.a("key_gd_6", Integer.toString(paramag.f));
    localka.a("key_gd_7", paramag.g);
    localka.a("key_gd_8", Integer.toString(paramag.h));
    localka.a("key_gd_9", paramag.i);
    localka.a("key_gd_10", Integer.toString(paramag.j));
    localka.a("key_gd_11", Integer.toString(paramag.k));
    localka.a("key_gd_12", Boolean.toString(paramag.l));
    localka.a("key_gd_13", paramag.m);
    localka.a("key_gd_14", paramag.n);
    localka.a("key_gd_15", Integer.toString(paramag.o));
    localka.a("key_gd_16", paramag.p);
    localka.a("key_gd_17", Integer.toString(paramag.q));
    localka.a("key_gd_18", Integer.toString(paramag.r));
    localka.a("key_gd_19", paramag.s);
    localka.a("key_gd_20", paramag.t);
    localka.a("key_gd_21", Integer.toString(paramag.u));
    localka.a("key_gd_22", paramag.v);
    localka.a("key_gd_23", Long.toString(paramag.w));
    localka.a("key_gd_24", Long.toString(paramag.x));
    localka.a("key_gd_25", Long.toString(paramag.y));
    localka.a("key_gd_26", paramag.z);
    localka.a("key_gd_27", paramag.A);
    localka.a("key_gd_28", paramag.B);
    localka.a("key_gd_29", paramag.P);
    localka.a("key_gd_30", Integer.toString(paramag.Q));
  }
  
  public final void a(String paramString)
  {
    this.e.a("key_ek", paramString);
  }
  
  public final void a(ArrayList paramArrayList)
  {
    int j = paramArrayList.size();
    if (paramArrayList != null)
    {
      if (j <= 0) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      int i = 0;
      while (i < j)
      {
        localStringBuilder.append(paramArrayList.get(i));
        if (j - 1 != i) {
          localStringBuilder.append("|");
        }
        i += 1;
      }
      new StringBuilder("onSavePortList() portList: ").append(localStringBuilder.toString());
      new StringBuilder("onSavePortList() portList: ").append(localStringBuilder.toString());
      this.e.a("key_pl", localStringBuilder.toString());
      return;
    }
  }
  
  public final void a(AtomicLong paramAtomicLong, AtomicReference paramAtomicReference1, AtomicReference paramAtomicReference2, AtomicReference paramAtomicReference3)
  {
    paramAtomicLong.set(this.e.e());
    paramAtomicLong = this.e.b("key_mc", "");
    String str1 = this.e.b("key_nu", "");
    String str2 = this.e.b("key_tc", "");
    if (!TextUtils.isEmpty(paramAtomicLong)) {
      paramAtomicReference1.set(g(paramAtomicLong));
    }
    if (!TextUtils.isEmpty(str1)) {
      paramAtomicReference2.set(g(str1));
    }
    if (!TextUtils.isEmpty(str2)) {
      paramAtomicReference3.set(g(str2));
    }
    c((ArrayList)paramAtomicReference1.get());
    c((ArrayList)paramAtomicReference2.get());
    c((ArrayList)paramAtomicReference3.get());
  }
  
  public final int b()
  {
    return this.e.c();
  }
  
  public final void b(long paramLong)
  {
    ka localka = this.e;
    String str = Long.toString(paramLong);
    if (str != null) {
      localka.a("key_gd_tm", str);
    }
  }
  
  public final void b(String paramString)
  {
    this.e.a("key_sid", paramString);
  }
  
  public final String c()
  {
    return this.e.b("key_ek", "");
  }
  
  public final void c(String paramString)
  {
    if (paramString == null) {
      return;
    }
    this.e.a("key_gd", paramString);
  }
  
  public final String d()
  {
    return this.e.b("key_sid", "");
  }
  
  public final String e()
  {
    return this.e.b("key_gd", "");
  }
  
  public final String f()
  {
    new StringBuilder("onGetGuidFromSdCard() guid: ").append(null);
    new StringBuilder("onGetGuidFromSdCard() guid: ").append(null);
    return null;
  }
  
  public final ag g()
  {
    ka localka = this.e;
    ag localag = new ag();
    localag.a = localka.b("key_gd_1", "");
    localag.b = localka.b("key_gd_2", "");
    localag.c = localka.b("key_gd_3", "");
    localag.d = localka.b("key_gd_4", "");
    localag.e = localka.b("key_gd_5", "");
    localag.f = ka.b(localka.b("key_gd_6", ""));
    localag.g = localka.b("key_gd_7", "");
    localag.h = ka.b(localka.b("key_gd_8", ""));
    localag.i = localka.b("key_gd_9", "");
    localag.j = ka.b(localka.b("key_gd_10", ""));
    localag.k = ka.b(localka.b("key_gd_11", ""));
    localag.l = ka.c(localka.b("key_gd_12", ""));
    localag.m = localka.b("key_gd_13", "");
    localag.n = localka.b("key_gd_14", "");
    localag.o = ka.b(localka.b("key_gd_15", ""));
    localag.p = localka.b("key_gd_16", "");
    localag.q = ((short)ka.b(localka.b("key_gd_17", "")));
    localag.r = ka.b(localka.b("key_gd_18", ""));
    localag.s = localka.b("key_gd_19", "");
    localag.t = localka.b("key_gd_20", "");
    localag.u = ka.b(localka.b("key_gd_21", ""));
    localag.v = localka.b("key_gd_22", "");
    localag.w = ka.a(localka.b("key_gd_23", ""));
    localag.x = ka.a(localka.b("key_gd_24", ""));
    localag.y = ka.a(localka.b("key_gd_25", ""));
    localag.z = localka.b("key_gd_26", "");
    localag.A = localka.b("key_gd_27", "");
    localag.B = localka.b("key_gd_28", "");
    localag.P = localka.b("key_gd_29", "");
    localag.Q = ka.b(localka.b("key_gd_30", ""));
    return localag;
  }
  
  public final ag h()
  {
    String[] arrayOfString = a(aot.a());
    long l1 = n();
    Object localObject1 = new ars();
    if (Environment.getExternalStorageState().equals("mounted"))
    {
      localObject2 = new StatFs(Environment.getExternalStorageDirectory().getPath());
      l2 = ((StatFs)localObject2).getBlockSize();
      ((ars)localObject1).a = (((StatFs)localObject2).getAvailableBlocks() * l2);
      ((ars)localObject1).b = (((StatFs)localObject2).getBlockCount() * l2);
    }
    else
    {
      ((ars)localObject1).a = 0L;
      ((ars)localObject1).b = 0L;
    }
    long l2 = ((ars)localObject1).b;
    localObject1 = arr.c(aot.a());
    Object localObject2 = new ag();
    ((ag)localObject2).a = arr.a(aot.a());
    ((ag)localObject2).b = arr.b(aot.a());
    if (localObject1 == null) {
      localObject1 = "";
    }
    ((ag)localObject2).c = ((String)localObject1);
    ((ag)localObject2).d = "0";
    ((ag)localObject2).e = "0";
    ((ag)localObject2).f = this.a;
    ((ag)localObject2).h = this.c;
    ((ag)localObject2).j = 2;
    ((ag)localObject2).l = false;
    ((ag)localObject2).m = aot.a().getPackageName();
    ((ag)localObject2).n = d(arr.b());
    ((ag)localObject2).o = Build.VERSION.SDK_INT;
    ((ag)localObject2).p = d(arr.a());
    ((ag)localObject2).q = 2052;
    ((ag)localObject2).r = 1;
    ((ag)localObject2).s = arrayOfString[2];
    ((ag)localObject2).t = m();
    ((ag)localObject2).u = Runtime.getRuntime().availableProcessors();
    ((ag)localObject2).v = arrayOfString[3];
    ((ag)localObject2).w = l1;
    localObject1 = new StatFs(Environment.getDataDirectory().getPath());
    ((ag)localObject2).x = (((StatFs)localObject1).getBlockSize() * ((StatFs)localObject1).getBlockCount());
    ((ag)localObject2).y = l2;
    ((ag)localObject2).z = d(Build.BRAND);
    ((ag)localObject2).A = d(Build.VERSION.INCREMENTAL);
    ((ag)localObject2).B = d(Build.VERSION.RELEASE);
    ((ag)localObject2).P = this.b;
    ((ag)localObject2).Q = 1;
    return localObject2;
  }
  
  public final long i()
  {
    return this.e.a();
  }
  
  public final long j()
  {
    return this.e.b();
  }
  
  public final int k()
  {
    this.e.f();
    return 0;
  }
  
  public final ArrayList l()
  {
    Object localObject1 = this.e.b("key_pl", "");
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return null;
    }
    localObject1 = ((String)localObject1).split("|");
    if (localObject1.length <= 0) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < localObject1.length)
    {
      Object localObject2 = localObject1[i];
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        int j = f((String)localObject2);
        localObject2 = new StringBuilder("onGetPortList() port[");
        ((StringBuilder)localObject2).append(i);
        ((StringBuilder)localObject2).append("]: ");
        ((StringBuilder)localObject2).append(j);
        localObject2 = new StringBuilder("onGetPortList() port[");
        ((StringBuilder)localObject2).append(i);
        ((StringBuilder)localObject2).append("]: ");
        ((StringBuilder)localObject2).append(j);
        localArrayList.add(Integer.valueOf(j));
      }
      i += 1;
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.kb
 * JD-Core Version:    0.7.0.1
 */