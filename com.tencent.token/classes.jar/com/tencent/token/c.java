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
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import tmsdk.common.e.h;
import tmsdk.common.e.i;

public class c
  implements tmsdk.common.d.a.b.g
{
  private final String a = "SharkOutlet";
  private b b;
  private long c = -1L;
  private int d;
  private String e;
  private int f;
  
  public c(Context paramContext)
  {
    this.b = new b(paramContext);
  }
  
  public static void a(File paramFile, h paramh)
  {
    paramFile = new StatFs(paramFile.getPath());
    long l = paramFile.getBlockSize();
    paramh.a = (paramFile.getAvailableBlocks() * l);
    paramh.b = (paramFile.getBlockCount() * l);
  }
  
  private static void a(h paramh)
  {
    if (t())
    {
      a(Environment.getExternalStorageDirectory(), paramh);
      return;
    }
    paramh.a = 0L;
    paramh.b = 0L;
  }
  
  public static String[] a(Context paramContext)
  {
    String str2 = Build.MODEL;
    String str3 = Build.VERSION.RELEASE;
    Object localObject = "";
    try
    {
      String str1 = f("/proc/cpuinfo").split("\\n")[0];
      localObject = str1;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Integer.toString(tmsdk.common.e.g.d(paramContext)));
    localStringBuilder.append("*");
    localStringBuilder.append(Integer.toString(tmsdk.common.e.g.e(paramContext)));
    return new String[] { str2, str3, localObject, localStringBuilder.toString() };
  }
  
  private String b(ArrayList paramArrayList)
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
  
  private void c(ArrayList paramArrayList)
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
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("printIpList() ipList[");
          localStringBuilder.append(i);
          localStringBuilder.append("]: ");
          localStringBuilder.append((String)paramArrayList.get(i));
          localStringBuilder.toString();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("printIpList() ipList[");
          localStringBuilder.append(i);
          localStringBuilder.append("]: ");
          localStringBuilder.append((String)paramArrayList.get(i));
          localStringBuilder.toString();
        }
        i += 1;
      }
      return;
    }
  }
  
  private String e(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  /* Error */
  private static String f(String paramString)
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
    //   10: new 164	java/io/BufferedInputStream
    //   13: dup
    //   14: new 166	java/io/FileInputStream
    //   17: dup
    //   18: aload_0
    //   19: invokespecial 167	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   22: invokespecial 170	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   25: astore_0
    //   26: aload_3
    //   27: astore_2
    //   28: aload_0
    //   29: astore_3
    //   30: new 172	java/io/ByteArrayOutputStream
    //   33: dup
    //   34: invokespecial 173	java/io/ByteArrayOutputStream:<init>	()V
    //   37: astore 4
    //   39: sipush 1024
    //   42: newarray byte
    //   44: astore_2
    //   45: aload_0
    //   46: aload_2
    //   47: invokevirtual 177	java/io/BufferedInputStream:read	([B)I
    //   50: istore_1
    //   51: iload_1
    //   52: iconst_m1
    //   53: if_icmpeq +14 -> 67
    //   56: aload 4
    //   58: aload_2
    //   59: iconst_0
    //   60: iload_1
    //   61: invokevirtual 181	java/io/ByteArrayOutputStream:write	([BII)V
    //   64: goto -19 -> 45
    //   67: new 101	java/lang/String
    //   70: dup
    //   71: aload 4
    //   73: invokevirtual 185	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   76: invokespecial 188	java/lang/String:<init>	([B)V
    //   79: astore_2
    //   80: aload 4
    //   82: invokevirtual 191	java/io/ByteArrayOutputStream:close	()V
    //   85: goto +8 -> 93
    //   88: astore_3
    //   89: aload_3
    //   90: invokevirtual 192	java/io/IOException:printStackTrace	()V
    //   93: aload_0
    //   94: invokevirtual 193	java/io/BufferedInputStream:close	()V
    //   97: aload_2
    //   98: areturn
    //   99: astore_0
    //   100: aload_0
    //   101: invokevirtual 192	java/io/IOException:printStackTrace	()V
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
    //   123: goto +91 -> 214
    //   126: astore 5
    //   128: aload 6
    //   130: astore 4
    //   132: goto +27 -> 159
    //   135: astore 5
    //   137: aload 7
    //   139: astore 4
    //   141: goto +73 -> 214
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
    //   166: invokevirtual 192	java/io/IOException:printStackTrace	()V
    //   169: aload 4
    //   171: ifnull +16 -> 187
    //   174: aload 4
    //   176: invokevirtual 191	java/io/ByteArrayOutputStream:close	()V
    //   179: goto +8 -> 187
    //   182: astore_2
    //   183: aload_2
    //   184: invokevirtual 192	java/io/IOException:printStackTrace	()V
    //   187: aload_0
    //   188: ifnull +62 -> 250
    //   191: aload_0
    //   192: invokevirtual 193	java/io/BufferedInputStream:close	()V
    //   195: goto +55 -> 250
    //   198: astore_0
    //   199: aload_0
    //   200: invokevirtual 192	java/io/IOException:printStackTrace	()V
    //   203: goto +47 -> 250
    //   206: astore 5
    //   208: aconst_null
    //   209: astore_0
    //   210: aload 7
    //   212: astore 4
    //   214: aload 4
    //   216: astore_2
    //   217: aload_0
    //   218: astore_3
    //   219: aload 5
    //   221: invokevirtual 194	java/io/FileNotFoundException:printStackTrace	()V
    //   224: aload 4
    //   226: ifnull +16 -> 242
    //   229: aload 4
    //   231: invokevirtual 191	java/io/ByteArrayOutputStream:close	()V
    //   234: goto +8 -> 242
    //   237: astore_2
    //   238: aload_2
    //   239: invokevirtual 192	java/io/IOException:printStackTrace	()V
    //   242: aload_0
    //   243: ifnull +7 -> 250
    //   246: aload_0
    //   247: invokevirtual 193	java/io/BufferedInputStream:close	()V
    //   250: ldc 92
    //   252: areturn
    //   253: astore 4
    //   255: aload_3
    //   256: astore_0
    //   257: aload_2
    //   258: ifnull +15 -> 273
    //   261: aload_2
    //   262: invokevirtual 191	java/io/ByteArrayOutputStream:close	()V
    //   265: goto +8 -> 273
    //   268: astore_2
    //   269: aload_2
    //   270: invokevirtual 192	java/io/IOException:printStackTrace	()V
    //   273: aload_0
    //   274: ifnull +15 -> 289
    //   277: aload_0
    //   278: invokevirtual 193	java/io/BufferedInputStream:close	()V
    //   281: goto +8 -> 289
    //   284: astore_0
    //   285: aload_0
    //   286: invokevirtual 192	java/io/IOException:printStackTrace	()V
    //   289: aload 4
    //   291: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	292	0	paramString	String
    //   50	11	1	i	int
    //   6	156	2	localObject1	Object
    //   182	2	2	localIOException1	IOException
    //   216	1	2	localObject2	Object
    //   237	25	2	localIOException2	IOException
    //   268	2	2	localIOException3	IOException
    //   4	26	3	str1	String
    //   88	2	3	localIOException4	IOException
    //   106	5	3	localObject3	Object
    //   163	93	3	str2	String
    //   37	103	4	localObject4	Object
    //   144	1	4	localObject5	Object
    //   157	73	4	localObject6	Object
    //   253	37	4	localObject7	Object
    //   116	1	5	localIOException5	IOException
    //   121	1	5	localFileNotFoundException1	java.io.FileNotFoundException
    //   126	1	5	localIOException6	IOException
    //   135	1	5	localFileNotFoundException2	java.io.FileNotFoundException
    //   151	14	5	localIOException7	IOException
    //   206	14	5	localFileNotFoundException3	java.io.FileNotFoundException
    //   8	148	6	localObject8	Object
    //   1	210	7	localObject9	Object
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
    //   191	195	198	java/io/IOException
    //   246	250	198	java/io/IOException
    //   10	26	206	java/io/FileNotFoundException
    //   229	234	237	java/io/IOException
    //   30	39	253	finally
    //   164	169	253	finally
    //   219	224	253	finally
    //   261	265	268	java/io/IOException
    //   277	281	284	java/io/IOException
  }
  
  private int g(String paramString)
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
  
  private ArrayList h(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getIpListFromStr() ipListStr: ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getIpListFromStr() ipListStr: ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).toString();
    paramString = paramString.split("\\|");
    if (paramString != null)
    {
      if (paramString.length <= 0) {
        return null;
      }
      localObject = new ArrayList();
      Collections.addAll((Collection)localObject, paramString);
      return localObject;
    }
    return null;
  }
  
  public static String n()
  {
    return Build.VERSION.INCREMENTAL;
  }
  
  public static String o()
  {
    return Build.VERSION.RELEASE;
  }
  
  public static String p()
  {
    return Build.BRAND;
  }
  
  private static long r()
  {
    StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
    return localStatFs.getBlockSize() * localStatFs.getBlockCount();
  }
  
  private static String s()
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
  
  private static boolean t()
  {
    return Environment.getExternalStorageState().equals("mounted");
  }
  
  /* Error */
  private long u()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 29	com/tencent/token/c:c	J
    //   4: ldc2_w 26
    //   7: lcmp
    //   8: ifne +243 -> 251
    //   11: new 41	java/io/File
    //   14: dup
    //   15: ldc_w 269
    //   18: invokespecial 270	java/io/File:<init>	(Ljava/lang/String;)V
    //   21: astore 4
    //   23: aconst_null
    //   24: astore 5
    //   26: aconst_null
    //   27: astore 6
    //   29: aconst_null
    //   30: astore 7
    //   32: aconst_null
    //   33: astore_3
    //   34: aload 4
    //   36: invokevirtual 273	java/io/File:exists	()Z
    //   39: ifeq +212 -> 251
    //   42: new 275	java/io/DataInputStream
    //   45: dup
    //   46: new 166	java/io/FileInputStream
    //   49: dup
    //   50: aload 4
    //   52: invokespecial 278	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   55: invokespecial 279	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   58: astore 4
    //   60: aload 4
    //   62: invokevirtual 282	java/io/DataInputStream:readLine	()Ljava/lang/String;
    //   65: astore_3
    //   66: aload_3
    //   67: ifnull +38 -> 105
    //   70: aload_0
    //   71: aload_3
    //   72: invokevirtual 255	java/lang/String:trim	()Ljava/lang/String;
    //   75: ldc_w 284
    //   78: invokevirtual 105	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   81: iconst_1
    //   82: aaload
    //   83: invokestatic 290	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   86: putfield 29	com/tencent/token/c:c	J
    //   89: aload 4
    //   91: invokevirtual 291	java/io/DataInputStream:close	()V
    //   94: goto +157 -> 251
    //   97: astore_3
    //   98: aload_3
    //   99: invokevirtual 192	java/io/IOException:printStackTrace	()V
    //   102: goto +149 -> 251
    //   105: new 162	java/io/IOException
    //   108: dup
    //   109: ldc_w 293
    //   112: invokespecial 294	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   115: athrow
    //   116: astore_3
    //   117: goto +112 -> 229
    //   120: astore 5
    //   122: goto +32 -> 154
    //   125: astore 5
    //   127: goto +54 -> 181
    //   130: astore 5
    //   132: goto +76 -> 208
    //   135: astore 5
    //   137: aload_3
    //   138: astore 4
    //   140: aload 5
    //   142: astore_3
    //   143: goto +86 -> 229
    //   146: astore_3
    //   147: aload 5
    //   149: astore 4
    //   151: aload_3
    //   152: astore 5
    //   154: aload 4
    //   156: astore_3
    //   157: aload 5
    //   159: invokevirtual 295	java/lang/NumberFormatException:printStackTrace	()V
    //   162: aload 4
    //   164: ifnull +87 -> 251
    //   167: aload 4
    //   169: invokevirtual 291	java/io/DataInputStream:close	()V
    //   172: goto +79 -> 251
    //   175: astore 5
    //   177: aload 6
    //   179: astore 4
    //   181: aload 4
    //   183: astore_3
    //   184: aload 5
    //   186: invokevirtual 192	java/io/IOException:printStackTrace	()V
    //   189: aload 4
    //   191: ifnull +60 -> 251
    //   194: aload 4
    //   196: invokevirtual 291	java/io/DataInputStream:close	()V
    //   199: goto +52 -> 251
    //   202: astore 5
    //   204: aload 7
    //   206: astore 4
    //   208: aload 4
    //   210: astore_3
    //   211: aload 5
    //   213: invokevirtual 194	java/io/FileNotFoundException:printStackTrace	()V
    //   216: aload 4
    //   218: ifnull +33 -> 251
    //   221: aload 4
    //   223: invokevirtual 291	java/io/DataInputStream:close	()V
    //   226: goto +25 -> 251
    //   229: aload 4
    //   231: ifnull +18 -> 249
    //   234: aload 4
    //   236: invokevirtual 291	java/io/DataInputStream:close	()V
    //   239: goto +10 -> 249
    //   242: astore 4
    //   244: aload 4
    //   246: invokevirtual 192	java/io/IOException:printStackTrace	()V
    //   249: aload_3
    //   250: athrow
    //   251: aload_0
    //   252: getfield 29	com/tencent/token/c:c	J
    //   255: lstore_1
    //   256: lload_1
    //   257: lconst_0
    //   258: lcmp
    //   259: ifle +5 -> 264
    //   262: lload_1
    //   263: lreturn
    //   264: lconst_1
    //   265: lreturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	266	0	this	c
    //   255	8	1	l	long
    //   33	39	3	str	String
    //   97	2	3	localIOException1	IOException
    //   116	22	3	localObject1	Object
    //   142	1	3	localObject2	Object
    //   146	6	3	localNumberFormatException1	java.lang.NumberFormatException
    //   156	94	3	localObject3	Object
    //   21	214	4	localObject4	Object
    //   242	3	4	localIOException2	IOException
    //   24	1	5	localObject5	Object
    //   120	1	5	localNumberFormatException2	java.lang.NumberFormatException
    //   125	1	5	localIOException3	IOException
    //   130	1	5	localFileNotFoundException1	java.io.FileNotFoundException
    //   135	13	5	localObject6	Object
    //   152	6	5	localObject7	Object
    //   175	10	5	localIOException4	IOException
    //   202	10	5	localFileNotFoundException2	java.io.FileNotFoundException
    //   27	151	6	localObject8	Object
    //   30	175	7	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   89	94	97	java/io/IOException
    //   167	172	97	java/io/IOException
    //   194	199	97	java/io/IOException
    //   221	226	97	java/io/IOException
    //   60	66	116	finally
    //   70	89	116	finally
    //   105	116	116	finally
    //   60	66	120	java/lang/NumberFormatException
    //   70	89	120	java/lang/NumberFormatException
    //   105	116	120	java/lang/NumberFormatException
    //   60	66	125	java/io/IOException
    //   70	89	125	java/io/IOException
    //   105	116	125	java/io/IOException
    //   60	66	130	java/io/FileNotFoundException
    //   70	89	130	java/io/FileNotFoundException
    //   105	116	130	java/io/FileNotFoundException
    //   42	60	135	finally
    //   157	162	135	finally
    //   184	189	135	finally
    //   211	216	135	finally
    //   42	60	146	java/lang/NumberFormatException
    //   42	60	175	java/io/IOException
    //   42	60	202	java/io/FileNotFoundException
    //   234	239	242	java/io/IOException
  }
  
  public void a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSaveIntervalSecond() intervalSecond: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSaveIntervalSecond() intervalSecond: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.toString();
    this.b.c(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSaveHash() hash: ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSaveHash() hash: ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.toString();
    this.b.a(paramInt1);
    this.b.b(paramInt2);
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    this.d = paramInt1;
    this.e = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      this.f = paramInt2;
      return;
    }
    throw new RuntimeException("appVersion couldn't be null or empty");
  }
  
  public void a(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSaveGuidUpdateCheckTimeMillis() timeMillis: ");
    localStringBuilder.append(paramLong);
    localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSaveGuidUpdateCheckTimeMillis() timeMillis: ");
    localStringBuilder.append(paramLong);
    localStringBuilder.toString();
    this.b.a(paramLong);
  }
  
  public void a(long paramLong, ArrayList paramArrayList1, ArrayList paramArrayList2, ArrayList paramArrayList3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSaveIpListInfo() validperiodLocalMillis: ");
    localStringBuilder.append(paramLong);
    localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSaveIpListInfo() validperiodLocalMillis: ");
    localStringBuilder.append(paramLong);
    localStringBuilder.toString();
    this.b.c(paramLong);
    paramArrayList1 = b(paramArrayList1);
    if (paramArrayList1 != null)
    {
      this.b.e(paramArrayList1);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSaveIpListInfo() cmStr: ");
      localStringBuilder.append(paramArrayList1);
      localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSaveIpListInfo() cmStr: ");
      localStringBuilder.append(paramArrayList1);
      localStringBuilder.toString();
    }
    paramArrayList1 = b(paramArrayList2);
    if (paramArrayList1 != null)
    {
      this.b.f(paramArrayList1);
      paramArrayList2 = new StringBuilder();
      paramArrayList2.append("onSaveIpListInfo() unStr: ");
      paramArrayList2.append(paramArrayList1);
      paramArrayList2.toString();
      paramArrayList2 = new StringBuilder();
      paramArrayList2.append("onSaveIpListInfo() unStr: ");
      paramArrayList2.append(paramArrayList1);
      paramArrayList2.toString();
    }
    paramArrayList1 = b(paramArrayList3);
    if (paramArrayList1 != null)
    {
      this.b.g(paramArrayList1);
      paramArrayList2 = new StringBuilder();
      paramArrayList2.append("onSaveIpListInfo() ctStr: ");
      paramArrayList2.append(paramArrayList1);
      paramArrayList2.toString();
      paramArrayList2 = new StringBuilder();
      paramArrayList2.append("onSaveIpListInfo() ctStr: ");
      paramArrayList2.append(paramArrayList1);
      paramArrayList2.toString();
    }
  }
  
  public void a(a.e.a parama)
  {
    this.b.a(parama);
  }
  
  public void a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSaveEncodeKey() encodeKey: ");
    localStringBuilder.append(paramString);
    localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSaveEncodeKey() encodeKey: ");
    localStringBuilder.append(paramString);
    localStringBuilder.toString();
    this.b.a(paramString);
  }
  
  public void a(ArrayList paramArrayList)
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
      paramArrayList = new StringBuilder();
      paramArrayList.append("onSavePortList() portList: ");
      paramArrayList.append(localStringBuilder.toString());
      paramArrayList.toString();
      paramArrayList = new StringBuilder();
      paramArrayList.append("onSavePortList() portList: ");
      paramArrayList.append(localStringBuilder.toString());
      paramArrayList.toString();
      this.b.d(localStringBuilder.toString());
      return;
    }
  }
  
  public void a(AtomicLong paramAtomicLong, AtomicReference paramAtomicReference1, AtomicReference paramAtomicReference2, AtomicReference paramAtomicReference3)
  {
    long l = this.b.i();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onGetIpList() validperiodLocalMillis: ");
    ((StringBuilder)localObject).append(l);
    ((StringBuilder)localObject).toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onGetIpList() validperiodLocalMillis: ");
    ((StringBuilder)localObject).append(l);
    ((StringBuilder)localObject).toString();
    if (paramAtomicLong != null) {
      paramAtomicLong.set(l);
    }
    paramAtomicLong = this.b.m();
    localObject = this.b.n();
    String str = this.b.o();
    if (!TextUtils.isEmpty(paramAtomicLong)) {
      paramAtomicReference1.set(h(paramAtomicLong));
    }
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      paramAtomicReference2.set(h((String)localObject));
    }
    if (!TextUtils.isEmpty(str)) {
      paramAtomicReference3.set(h(str));
    }
    c((ArrayList)paramAtomicReference1.get());
    c((ArrayList)paramAtomicReference2.get());
    c((ArrayList)paramAtomicReference3.get());
  }
  
  public boolean a()
  {
    return true;
  }
  
  public int b()
  {
    return this.b.h();
  }
  
  public void b(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSaveGuidCheckTimeMillis() timeMillis: ");
    localStringBuilder.append(paramLong);
    localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSaveGuidCheckTimeMillis() timeMillis: ");
    localStringBuilder.append(paramLong);
    localStringBuilder.toString();
    this.b.b(paramLong);
  }
  
  public void b(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSaveSessionId() sessionId: ");
    localStringBuilder.append(paramString);
    localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSaveSessionId() sessionId: ");
    localStringBuilder.append(paramString);
    localStringBuilder.toString();
    this.b.b(paramString);
  }
  
  public int c()
  {
    int i = this.b.g();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onGetHash() hash: ");
    localStringBuilder.append(i);
    localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("onGetHash() hash: ");
    localStringBuilder.append(i);
    localStringBuilder.toString();
    return i;
  }
  
  public void c(String paramString)
  {
    if (paramString == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSaveGuidToPhone() guid: ");
    localStringBuilder.append(paramString);
    localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSaveGuidToPhone() guid: ");
    localStringBuilder.append(paramString);
    localStringBuilder.toString();
    this.b.c(paramString);
  }
  
  public String d()
  {
    String str = this.b.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onGetEncodeKey() encodeKey: ");
    localStringBuilder.append(str);
    localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("onGetEncodeKey() encodeKey: ");
    localStringBuilder.append(str);
    localStringBuilder.toString();
    return str;
  }
  
  public void d(String paramString)
  {
    if (paramString == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSaveGuidToSdCard() guid: ");
    localStringBuilder.append(paramString);
    localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSaveGuidToSdCard() guid: ");
    localStringBuilder.append(paramString);
    localStringBuilder.toString();
    paramString = this.b;
  }
  
  public String e()
  {
    String str = this.b.b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onGetSessionId() sessionId: ");
    localStringBuilder.append(str);
    localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("onGetSessionId() sessionId: ");
    localStringBuilder.append(str);
    localStringBuilder.toString();
    return str;
  }
  
  public String f()
  {
    String str = this.b.c();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onGetGuidFromPhone() guid: ");
    localStringBuilder.append(str);
    localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("onGetGuidFromPhone() guid: ");
    localStringBuilder.append(str);
    localStringBuilder.toString();
    return str;
  }
  
  public String g()
  {
    String str = this.b.d();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onGetGuidFromSdCard() guid: ");
    localStringBuilder.append(str);
    localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("onGetGuidFromSdCard() guid: ");
    localStringBuilder.append(str);
    localStringBuilder.toString();
    return str;
  }
  
  public a.e.a h()
  {
    return this.b.j();
  }
  
  public a.e.a i()
  {
    String[] arrayOfString = a(tmsdk.common.a.a());
    long l1 = u();
    Object localObject = new h();
    a((h)localObject);
    long l2 = ((h)localObject).b;
    localObject = tmsdk.common.e.g.c(tmsdk.common.a.a());
    a.e.a locala = new a.e.a();
    locala.a = tmsdk.common.e.g.a(tmsdk.common.a.a());
    locala.b = tmsdk.common.e.g.b(tmsdk.common.a.a());
    if (localObject == null) {
      localObject = "";
    }
    locala.c = ((String)localObject);
    locala.d = "0";
    locala.e = "0";
    locala.f = this.d;
    locala.h = this.f;
    locala.j = 2;
    locala.l = false;
    locala.m = tmsdk.common.a.a().getPackageName();
    locala.n = e(tmsdk.common.e.g.b());
    locala.o = i.a();
    locala.p = e(tmsdk.common.e.g.a());
    locala.q = 2052;
    locala.r = 1;
    locala.s = arrayOfString[2];
    locala.t = s();
    locala.u = Runtime.getRuntime().availableProcessors();
    locala.v = arrayOfString[3];
    locala.w = l1;
    locala.x = r();
    locala.y = l2;
    locala.z = e(p());
    locala.A = e(n());
    locala.B = e(o());
    locala.P = this.e;
    locala.Q = 1;
    return locala;
  }
  
  public long j()
  {
    long l = this.b.e();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onGetGuidUpdateCheckTimeMillis() tm: ");
    localStringBuilder.append(l);
    localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("onGetGuidUpdateCheckTimeMillis() tm: ");
    localStringBuilder.append(l);
    localStringBuilder.toString();
    return l;
  }
  
  public long k()
  {
    long l = this.b.f();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onGetGuidCheckTimeMillis() tm: ");
    localStringBuilder.append(l);
    localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("onGetGuidCheckTimeMillis() tm: ");
    localStringBuilder.append(l);
    localStringBuilder.toString();
    return l;
  }
  
  public int l()
  {
    int i = this.b.k();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onGetIntervalSecond() intervalSecond: ");
    localStringBuilder.append(i);
    localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("onGetIntervalSecond() intervalSecond: ");
    localStringBuilder.append(i);
    localStringBuilder.toString();
    return 0;
  }
  
  public ArrayList m()
  {
    Object localObject1 = this.b.l();
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return null;
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("onGetPortList() portList: ");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("onGetPortList() portList: ");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).toString();
    localObject1 = ((String)localObject1).split("|");
    if (localObject1.length <= 0) {
      return null;
    }
    localObject2 = new ArrayList();
    int i = 0;
    while (i < localObject1.length)
    {
      Object localObject3 = localObject1[i];
      if (!TextUtils.isEmpty((CharSequence)localObject3))
      {
        int j = g((String)localObject3);
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("onGetPortList() port[");
        ((StringBuilder)localObject3).append(i);
        ((StringBuilder)localObject3).append("]: ");
        ((StringBuilder)localObject3).append(j);
        ((StringBuilder)localObject3).toString();
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("onGetPortList() port[");
        ((StringBuilder)localObject3).append(i);
        ((StringBuilder)localObject3).append("]: ");
        ((StringBuilder)localObject3).append(j);
        ((StringBuilder)localObject3).toString();
        ((ArrayList)localObject2).add(Integer.valueOf(j));
      }
      i += 1;
    }
    return localObject2;
  }
  
  public long q()
  {
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.c
 * JD-Core Version:    0.7.0.1
 */