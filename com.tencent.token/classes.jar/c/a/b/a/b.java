package c.a.b.a;

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
import tmsdk.common.e.h;
import tmsdk.common.e.i;

public class b
  implements tmsdk.common.d.a.b.g
{
  private final String a = "SharkOutlet";
  private a b;
  private long c = -1L;
  private int d;
  private String e;
  private int f;
  
  public b(Context paramContext)
  {
    this.b = new a(paramContext);
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
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    return new String[] { str2, str3, localObject, Integer.toString(tmsdk.common.e.g.d(paramContext)) + "*" + Integer.toString(tmsdk.common.e.g.e(paramContext)) };
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
    if (i < j)
    {
      String str = (String)paramArrayList.get(i);
      if (TextUtils.isEmpty(str)) {}
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append(str);
        if (j - 1 != i) {
          localStringBuilder.append("|");
        }
      }
    }
    return localStringBuilder.toString();
  }
  
  private void c(ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() <= 0)) {
      return;
    }
    int j = paramArrayList.size();
    int i = 0;
    label19:
    if (i < j) {
      if (paramArrayList.get(i) != null) {
        break label39;
      }
    }
    for (;;)
    {
      i += 1;
      break label19;
      break;
      label39:
      new StringBuilder().append("printIpList() ipList[").append(i).append("]: ").append((String)paramArrayList.get(i)).toString();
      new StringBuilder().append("printIpList() ipList[").append(i).append("]: ").append((String)paramArrayList.get(i)).toString();
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
    //   1: astore_2
    //   2: new 164	java/io/BufferedInputStream
    //   5: dup
    //   6: new 166	java/io/FileInputStream
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 167	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   14: invokespecial 170	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   17: astore_0
    //   18: new 172	java/io/ByteArrayOutputStream
    //   21: dup
    //   22: invokespecial 173	java/io/ByteArrayOutputStream:<init>	()V
    //   25: astore_3
    //   26: aload_3
    //   27: astore 5
    //   29: aload_0
    //   30: astore 4
    //   32: sipush 1024
    //   35: newarray byte
    //   37: astore_2
    //   38: aload_3
    //   39: astore 5
    //   41: aload_0
    //   42: astore 4
    //   44: aload_0
    //   45: aload_2
    //   46: invokevirtual 177	java/io/BufferedInputStream:read	([B)I
    //   49: istore_1
    //   50: iload_1
    //   51: iconst_m1
    //   52: if_icmpeq +53 -> 105
    //   55: aload_3
    //   56: astore 5
    //   58: aload_0
    //   59: astore 4
    //   61: aload_3
    //   62: aload_2
    //   63: iconst_0
    //   64: iload_1
    //   65: invokevirtual 181	java/io/ByteArrayOutputStream:write	([BII)V
    //   68: goto -30 -> 38
    //   71: astore 4
    //   73: aload_0
    //   74: astore_2
    //   75: aload_3
    //   76: astore_0
    //   77: aload 4
    //   79: astore_3
    //   80: aload_3
    //   81: invokevirtual 182	java/io/FileNotFoundException:printStackTrace	()V
    //   84: aload_0
    //   85: ifnull +7 -> 92
    //   88: aload_0
    //   89: invokevirtual 185	java/io/ByteArrayOutputStream:close	()V
    //   92: aload_2
    //   93: ifnull +7 -> 100
    //   96: aload_2
    //   97: invokevirtual 186	java/io/BufferedInputStream:close	()V
    //   100: ldc 92
    //   102: astore_2
    //   103: aload_2
    //   104: areturn
    //   105: aload_3
    //   106: astore 5
    //   108: aload_0
    //   109: astore 4
    //   111: new 101	java/lang/String
    //   114: dup
    //   115: aload_3
    //   116: invokevirtual 190	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   119: invokespecial 193	java/lang/String:<init>	([B)V
    //   122: astore 6
    //   124: aload_3
    //   125: ifnull +7 -> 132
    //   128: aload_3
    //   129: invokevirtual 185	java/io/ByteArrayOutputStream:close	()V
    //   132: aload 6
    //   134: astore_2
    //   135: aload_0
    //   136: ifnull -33 -> 103
    //   139: aload_0
    //   140: invokevirtual 186	java/io/BufferedInputStream:close	()V
    //   143: aload 6
    //   145: areturn
    //   146: astore_0
    //   147: aload_0
    //   148: invokevirtual 194	java/io/IOException:printStackTrace	()V
    //   151: aload 6
    //   153: areturn
    //   154: astore_2
    //   155: aload_2
    //   156: invokevirtual 194	java/io/IOException:printStackTrace	()V
    //   159: goto -27 -> 132
    //   162: astore_0
    //   163: aload_0
    //   164: invokevirtual 194	java/io/IOException:printStackTrace	()V
    //   167: goto -75 -> 92
    //   170: astore_0
    //   171: aload_0
    //   172: invokevirtual 194	java/io/IOException:printStackTrace	()V
    //   175: goto -75 -> 100
    //   178: astore 6
    //   180: aconst_null
    //   181: astore_2
    //   182: aconst_null
    //   183: astore_0
    //   184: aload_2
    //   185: astore 5
    //   187: aload_0
    //   188: astore 4
    //   190: aload 6
    //   192: invokevirtual 194	java/io/IOException:printStackTrace	()V
    //   195: aload_2
    //   196: ifnull +7 -> 203
    //   199: aload_2
    //   200: invokevirtual 185	java/io/ByteArrayOutputStream:close	()V
    //   203: aload_0
    //   204: ifnull -104 -> 100
    //   207: aload_0
    //   208: invokevirtual 186	java/io/BufferedInputStream:close	()V
    //   211: goto -111 -> 100
    //   214: astore_0
    //   215: aload_0
    //   216: invokevirtual 194	java/io/IOException:printStackTrace	()V
    //   219: goto -119 -> 100
    //   222: astore_2
    //   223: aload_2
    //   224: invokevirtual 194	java/io/IOException:printStackTrace	()V
    //   227: goto -24 -> 203
    //   230: astore_2
    //   231: aconst_null
    //   232: astore_3
    //   233: aconst_null
    //   234: astore_0
    //   235: aload_3
    //   236: ifnull +7 -> 243
    //   239: aload_3
    //   240: invokevirtual 185	java/io/ByteArrayOutputStream:close	()V
    //   243: aload_0
    //   244: ifnull +7 -> 251
    //   247: aload_0
    //   248: invokevirtual 186	java/io/BufferedInputStream:close	()V
    //   251: aload_2
    //   252: athrow
    //   253: astore_3
    //   254: aload_3
    //   255: invokevirtual 194	java/io/IOException:printStackTrace	()V
    //   258: goto -15 -> 243
    //   261: astore_0
    //   262: aload_0
    //   263: invokevirtual 194	java/io/IOException:printStackTrace	()V
    //   266: goto -15 -> 251
    //   269: astore_2
    //   270: aconst_null
    //   271: astore_3
    //   272: goto -37 -> 235
    //   275: astore_2
    //   276: aload 5
    //   278: astore_3
    //   279: aload 4
    //   281: astore_0
    //   282: goto -47 -> 235
    //   285: astore_3
    //   286: aload_2
    //   287: astore 4
    //   289: aload_3
    //   290: astore_2
    //   291: aload_0
    //   292: astore_3
    //   293: aload 4
    //   295: astore_0
    //   296: goto -61 -> 235
    //   299: astore 6
    //   301: aconst_null
    //   302: astore_2
    //   303: goto -119 -> 184
    //   306: astore 6
    //   308: aload_3
    //   309: astore_2
    //   310: goto -126 -> 184
    //   313: astore_3
    //   314: aconst_null
    //   315: astore_0
    //   316: goto -236 -> 80
    //   319: astore_3
    //   320: aconst_null
    //   321: astore 4
    //   323: aload_0
    //   324: astore_2
    //   325: aload 4
    //   327: astore_0
    //   328: goto -248 -> 80
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	331	0	paramString	String
    //   49	16	1	i	int
    //   1	134	2	localObject1	Object
    //   154	2	2	localIOException1	IOException
    //   181	19	2	localObject2	Object
    //   222	2	2	localIOException2	IOException
    //   230	22	2	localObject3	Object
    //   269	1	2	localObject4	Object
    //   275	12	2	localObject5	Object
    //   290	35	2	localObject6	Object
    //   25	215	3	localObject7	Object
    //   253	2	3	localIOException3	IOException
    //   271	8	3	localObject8	Object
    //   285	5	3	localObject9	Object
    //   292	17	3	str1	String
    //   313	1	3	localFileNotFoundException1	java.io.FileNotFoundException
    //   319	1	3	localFileNotFoundException2	java.io.FileNotFoundException
    //   30	30	4	str2	String
    //   71	7	4	localFileNotFoundException3	java.io.FileNotFoundException
    //   109	217	4	localObject10	Object
    //   27	250	5	localObject11	Object
    //   122	30	6	str3	String
    //   178	13	6	localIOException4	IOException
    //   299	1	6	localIOException5	IOException
    //   306	1	6	localIOException6	IOException
    // Exception table:
    //   from	to	target	type
    //   32	38	71	java/io/FileNotFoundException
    //   44	50	71	java/io/FileNotFoundException
    //   61	68	71	java/io/FileNotFoundException
    //   111	124	71	java/io/FileNotFoundException
    //   139	143	146	java/io/IOException
    //   128	132	154	java/io/IOException
    //   88	92	162	java/io/IOException
    //   96	100	170	java/io/IOException
    //   2	18	178	java/io/IOException
    //   207	211	214	java/io/IOException
    //   199	203	222	java/io/IOException
    //   2	18	230	finally
    //   239	243	253	java/io/IOException
    //   247	251	261	java/io/IOException
    //   18	26	269	finally
    //   32	38	275	finally
    //   44	50	275	finally
    //   61	68	275	finally
    //   111	124	275	finally
    //   190	195	275	finally
    //   80	84	285	finally
    //   18	26	299	java/io/IOException
    //   32	38	306	java/io/IOException
    //   44	50	306	java/io/IOException
    //   61	68	306	java/io/IOException
    //   111	124	306	java/io/IOException
    //   2	18	313	java/io/FileNotFoundException
    //   18	26	319	java/io/FileNotFoundException
  }
  
  private int g(String paramString)
  {
    try
    {
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (Exception paramString) {}
    return 0;
  }
  
  private ArrayList h(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      new StringBuilder().append("getIpListFromStr() ipListStr: ").append(paramString).toString();
      new StringBuilder().append("getIpListFromStr() ipListStr: ").append(paramString).toString();
      paramString = paramString.split("\\|");
    } while ((paramString == null) || (paramString.length <= 0));
    ArrayList localArrayList = new ArrayList();
    Collections.addAll(localArrayList, paramString);
    return localArrayList;
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
    long l = localStatFs.getBlockSize();
    return localStatFs.getBlockCount() * l;
  }
  
  private static String s()
  {
    String str1 = "";
    try
    {
      InputStream localInputStream = new ProcessBuilder(new String[] { "/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq" }).start().getInputStream();
      byte[] arrayOfByte = new byte[24];
      while (localInputStream.read(arrayOfByte) != -1) {
        str1 = str1 + new String(arrayOfByte);
      }
      localInputStream.close();
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
        String str2 = "N/A";
      }
    }
    return str1.trim();
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
    //   1: getfield 29	c/a/b/a/b:c	J
    //   4: ldc2_w 26
    //   7: lcmp
    //   8: ifne +76 -> 84
    //   11: new 41	java/io/File
    //   14: dup
    //   15: ldc_w 269
    //   18: invokespecial 270	java/io/File:<init>	(Ljava/lang/String;)V
    //   21: astore_1
    //   22: aload_1
    //   23: invokevirtual 273	java/io/File:exists	()Z
    //   26: ifeq +58 -> 84
    //   29: new 275	java/io/DataInputStream
    //   32: dup
    //   33: new 166	java/io/FileInputStream
    //   36: dup
    //   37: aload_1
    //   38: invokespecial 278	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   41: invokespecial 279	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   44: astore_2
    //   45: aload_2
    //   46: astore_1
    //   47: aload_2
    //   48: invokevirtual 282	java/io/DataInputStream:readLine	()Ljava/lang/String;
    //   51: astore_3
    //   52: aload_3
    //   53: ifnonnull +45 -> 98
    //   56: aload_2
    //   57: astore_1
    //   58: new 162	java/io/IOException
    //   61: dup
    //   62: ldc_w 284
    //   65: invokespecial 285	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   68: athrow
    //   69: astore_3
    //   70: aload_2
    //   71: astore_1
    //   72: aload_3
    //   73: invokevirtual 182	java/io/FileNotFoundException:printStackTrace	()V
    //   76: aload_2
    //   77: ifnull +7 -> 84
    //   80: aload_2
    //   81: invokevirtual 286	java/io/DataInputStream:close	()V
    //   84: aload_0
    //   85: getfield 29	c/a/b/a/b:c	J
    //   88: lconst_0
    //   89: lcmp
    //   90: ifle +133 -> 223
    //   93: aload_0
    //   94: getfield 29	c/a/b/a/b:c	J
    //   97: lreturn
    //   98: aload_2
    //   99: astore_1
    //   100: aload_0
    //   101: aload_3
    //   102: invokevirtual 253	java/lang/String:trim	()Ljava/lang/String;
    //   105: ldc_w 288
    //   108: invokevirtual 105	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   111: iconst_1
    //   112: aaload
    //   113: invokestatic 294	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   116: putfield 29	c/a/b/a/b:c	J
    //   119: aload_2
    //   120: ifnull -36 -> 84
    //   123: aload_2
    //   124: invokevirtual 286	java/io/DataInputStream:close	()V
    //   127: goto -43 -> 84
    //   130: astore_1
    //   131: aload_1
    //   132: invokevirtual 194	java/io/IOException:printStackTrace	()V
    //   135: goto -51 -> 84
    //   138: astore_1
    //   139: aload_1
    //   140: invokevirtual 194	java/io/IOException:printStackTrace	()V
    //   143: goto -59 -> 84
    //   146: astore_3
    //   147: aconst_null
    //   148: astore_2
    //   149: aload_2
    //   150: astore_1
    //   151: aload_3
    //   152: invokevirtual 194	java/io/IOException:printStackTrace	()V
    //   155: aload_2
    //   156: ifnull -72 -> 84
    //   159: aload_2
    //   160: invokevirtual 286	java/io/DataInputStream:close	()V
    //   163: goto -79 -> 84
    //   166: astore_1
    //   167: aload_1
    //   168: invokevirtual 194	java/io/IOException:printStackTrace	()V
    //   171: goto -87 -> 84
    //   174: astore_3
    //   175: aconst_null
    //   176: astore_2
    //   177: aload_2
    //   178: astore_1
    //   179: aload_3
    //   180: invokevirtual 295	java/lang/NumberFormatException:printStackTrace	()V
    //   183: aload_2
    //   184: ifnull -100 -> 84
    //   187: aload_2
    //   188: invokevirtual 286	java/io/DataInputStream:close	()V
    //   191: goto -107 -> 84
    //   194: astore_1
    //   195: aload_1
    //   196: invokevirtual 194	java/io/IOException:printStackTrace	()V
    //   199: goto -115 -> 84
    //   202: astore_2
    //   203: aconst_null
    //   204: astore_1
    //   205: aload_1
    //   206: ifnull +7 -> 213
    //   209: aload_1
    //   210: invokevirtual 286	java/io/DataInputStream:close	()V
    //   213: aload_2
    //   214: athrow
    //   215: astore_1
    //   216: aload_1
    //   217: invokevirtual 194	java/io/IOException:printStackTrace	()V
    //   220: goto -7 -> 213
    //   223: lconst_1
    //   224: lreturn
    //   225: astore_2
    //   226: goto -21 -> 205
    //   229: astore_3
    //   230: goto -53 -> 177
    //   233: astore_3
    //   234: goto -85 -> 149
    //   237: astore_3
    //   238: aconst_null
    //   239: astore_2
    //   240: goto -170 -> 70
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	243	0	this	b
    //   21	79	1	localObject1	Object
    //   130	2	1	localIOException1	IOException
    //   138	2	1	localIOException2	IOException
    //   150	1	1	localObject2	Object
    //   166	2	1	localIOException3	IOException
    //   178	1	1	localObject3	Object
    //   194	2	1	localIOException4	IOException
    //   204	6	1	localObject4	Object
    //   215	2	1	localIOException5	IOException
    //   44	144	2	localDataInputStream	java.io.DataInputStream
    //   202	12	2	localObject5	Object
    //   225	1	2	localObject6	Object
    //   239	1	2	localObject7	Object
    //   51	2	3	str	String
    //   69	33	3	localFileNotFoundException1	java.io.FileNotFoundException
    //   146	6	3	localIOException6	IOException
    //   174	6	3	localNumberFormatException1	java.lang.NumberFormatException
    //   229	1	3	localNumberFormatException2	java.lang.NumberFormatException
    //   233	1	3	localIOException7	IOException
    //   237	1	3	localFileNotFoundException2	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   47	52	69	java/io/FileNotFoundException
    //   58	69	69	java/io/FileNotFoundException
    //   100	119	69	java/io/FileNotFoundException
    //   123	127	130	java/io/IOException
    //   80	84	138	java/io/IOException
    //   29	45	146	java/io/IOException
    //   159	163	166	java/io/IOException
    //   29	45	174	java/lang/NumberFormatException
    //   187	191	194	java/io/IOException
    //   29	45	202	finally
    //   209	213	215	java/io/IOException
    //   47	52	225	finally
    //   58	69	225	finally
    //   72	76	225	finally
    //   100	119	225	finally
    //   151	155	225	finally
    //   179	183	225	finally
    //   47	52	229	java/lang/NumberFormatException
    //   58	69	229	java/lang/NumberFormatException
    //   100	119	229	java/lang/NumberFormatException
    //   47	52	233	java/io/IOException
    //   58	69	233	java/io/IOException
    //   100	119	233	java/io/IOException
    //   29	45	237	java/io/FileNotFoundException
  }
  
  public void a(int paramInt)
  {
    new StringBuilder().append("onSaveIntervalSecond() intervalSecond: ").append(paramInt).toString();
    new StringBuilder().append("onSaveIntervalSecond() intervalSecond: ").append(paramInt).toString();
    this.b.c(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    new StringBuilder().append("onSaveHash() hash: ").append(paramInt1).toString();
    new StringBuilder().append("onSaveHash() hash: ").append(paramInt1).toString();
    this.b.a(paramInt1);
    this.b.b(paramInt2);
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    this.d = paramInt1;
    this.e = paramString;
    if (TextUtils.isEmpty(paramString)) {
      throw new RuntimeException("appVersion couldn't be null or empty");
    }
    this.f = paramInt2;
  }
  
  public void a(long paramLong)
  {
    new StringBuilder().append("onSaveGuidUpdateCheckTimeMillis() timeMillis: ").append(paramLong).toString();
    new StringBuilder().append("onSaveGuidUpdateCheckTimeMillis() timeMillis: ").append(paramLong).toString();
    this.b.a(paramLong);
  }
  
  public void a(long paramLong, ArrayList paramArrayList1, ArrayList paramArrayList2, ArrayList paramArrayList3)
  {
    new StringBuilder().append("onSaveIpListInfo() validperiodLocalMillis: ").append(paramLong).toString();
    new StringBuilder().append("onSaveIpListInfo() validperiodLocalMillis: ").append(paramLong).toString();
    this.b.c(paramLong);
    paramArrayList1 = b(paramArrayList1);
    if (paramArrayList1 != null)
    {
      this.b.e(paramArrayList1);
      new StringBuilder().append("onSaveIpListInfo() cmStr: ").append(paramArrayList1).toString();
      new StringBuilder().append("onSaveIpListInfo() cmStr: ").append(paramArrayList1).toString();
    }
    paramArrayList1 = b(paramArrayList2);
    if (paramArrayList1 != null)
    {
      this.b.f(paramArrayList1);
      new StringBuilder().append("onSaveIpListInfo() unStr: ").append(paramArrayList1).toString();
      new StringBuilder().append("onSaveIpListInfo() unStr: ").append(paramArrayList1).toString();
    }
    paramArrayList1 = b(paramArrayList3);
    if (paramArrayList1 != null)
    {
      this.b.g(paramArrayList1);
      new StringBuilder().append("onSaveIpListInfo() ctStr: ").append(paramArrayList1).toString();
      new StringBuilder().append("onSaveIpListInfo() ctStr: ").append(paramArrayList1).toString();
    }
  }
  
  public void a(a.e.a parama)
  {
    this.b.a(parama);
  }
  
  public void a(String paramString)
  {
    new StringBuilder().append("onSaveEncodeKey() encodeKey: ").append(paramString).toString();
    new StringBuilder().append("onSaveEncodeKey() encodeKey: ").append(paramString).toString();
    this.b.a(paramString);
  }
  
  public void a(ArrayList paramArrayList)
  {
    int j = paramArrayList.size();
    if ((paramArrayList == null) || (j <= 0)) {
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
    new StringBuilder().append("onSavePortList() portList: ").append(localStringBuilder.toString()).toString();
    new StringBuilder().append("onSavePortList() portList: ").append(localStringBuilder.toString()).toString();
    this.b.d(localStringBuilder.toString());
  }
  
  public void a(AtomicLong paramAtomicLong, AtomicReference paramAtomicReference1, AtomicReference paramAtomicReference2, AtomicReference paramAtomicReference3)
  {
    long l = this.b.i();
    new StringBuilder().append("onGetIpList() validperiodLocalMillis: ").append(l).toString();
    new StringBuilder().append("onGetIpList() validperiodLocalMillis: ").append(l).toString();
    if (paramAtomicLong != null) {
      paramAtomicLong.set(l);
    }
    paramAtomicLong = this.b.m();
    String str1 = this.b.n();
    String str2 = this.b.o();
    if (!TextUtils.isEmpty(paramAtomicLong)) {
      paramAtomicReference1.set(h(paramAtomicLong));
    }
    if (!TextUtils.isEmpty(str1)) {
      paramAtomicReference2.set(h(str1));
    }
    if (!TextUtils.isEmpty(str2)) {
      paramAtomicReference3.set(h(str2));
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
    new StringBuilder().append("onSaveGuidCheckTimeMillis() timeMillis: ").append(paramLong).toString();
    new StringBuilder().append("onSaveGuidCheckTimeMillis() timeMillis: ").append(paramLong).toString();
    this.b.b(paramLong);
  }
  
  public void b(String paramString)
  {
    new StringBuilder().append("onSaveSessionId() sessionId: ").append(paramString).toString();
    new StringBuilder().append("onSaveSessionId() sessionId: ").append(paramString).toString();
    this.b.b(paramString);
  }
  
  public int c()
  {
    int i = this.b.g();
    new StringBuilder().append("onGetHash() hash: ").append(i).toString();
    new StringBuilder().append("onGetHash() hash: ").append(i).toString();
    return i;
  }
  
  public void c(String paramString)
  {
    if (paramString == null) {
      return;
    }
    new StringBuilder().append("onSaveGuidToPhone() guid: ").append(paramString).toString();
    new StringBuilder().append("onSaveGuidToPhone() guid: ").append(paramString).toString();
    this.b.c(paramString);
  }
  
  public String d()
  {
    String str = this.b.a();
    new StringBuilder().append("onGetEncodeKey() encodeKey: ").append(str).toString();
    new StringBuilder().append("onGetEncodeKey() encodeKey: ").append(str).toString();
    return str;
  }
  
  public void d(String paramString)
  {
    if (paramString == null) {
      return;
    }
    new StringBuilder().append("onSaveGuidToSdCard() guid: ").append(paramString).toString();
    new StringBuilder().append("onSaveGuidToSdCard() guid: ").append(paramString).toString();
    paramString = this.b;
  }
  
  public String e()
  {
    String str = this.b.b();
    new StringBuilder().append("onGetSessionId() sessionId: ").append(str).toString();
    new StringBuilder().append("onGetSessionId() sessionId: ").append(str).toString();
    return str;
  }
  
  public String f()
  {
    String str = this.b.c();
    new StringBuilder().append("onGetGuidFromPhone() guid: ").append(str).toString();
    new StringBuilder().append("onGetGuidFromPhone() guid: ").append(str).toString();
    return str;
  }
  
  public String g()
  {
    String str = this.b.d();
    new StringBuilder().append("onGetGuidFromSdCard() guid: ").append(str).toString();
    new StringBuilder().append("onGetGuidFromSdCard() guid: ").append(str).toString();
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
    if (localObject != null) {}
    for (;;)
    {
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
      localObject = "";
    }
  }
  
  public long j()
  {
    long l = this.b.e();
    new StringBuilder().append("onGetGuidUpdateCheckTimeMillis() tm: ").append(l).toString();
    new StringBuilder().append("onGetGuidUpdateCheckTimeMillis() tm: ").append(l).toString();
    return l;
  }
  
  public long k()
  {
    long l = this.b.f();
    new StringBuilder().append("onGetGuidCheckTimeMillis() tm: ").append(l).toString();
    new StringBuilder().append("onGetGuidCheckTimeMillis() tm: ").append(l).toString();
    return l;
  }
  
  public int l()
  {
    int i = this.b.k();
    new StringBuilder().append("onGetIntervalSecond() intervalSecond: ").append(i).toString();
    new StringBuilder().append("onGetIntervalSecond() intervalSecond: ").append(i).toString();
    return 0;
  }
  
  public ArrayList m()
  {
    Object localObject = this.b.l();
    if (TextUtils.isEmpty((CharSequence)localObject)) {}
    do
    {
      return null;
      new StringBuilder().append("onGetPortList() portList: ").append((String)localObject).toString();
      new StringBuilder().append("onGetPortList() portList: ").append((String)localObject).toString();
      localObject = ((String)localObject).split("|");
    } while (localObject.length <= 0);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < localObject.length)
    {
      CharSequence localCharSequence = localObject[i];
      if (TextUtils.isEmpty(localCharSequence)) {}
      for (;;)
      {
        i += 1;
        break;
        int j = g(localCharSequence);
        new StringBuilder().append("onGetPortList() port[").append(i).append("]: ").append(j).toString();
        new StringBuilder().append("onGetPortList() port[").append(i).append("]: ").append(j).toString();
        localArrayList.add(Integer.valueOf(j));
      }
    }
    return localArrayList;
  }
  
  public long q()
  {
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     c.a.b.a.b
 * JD-Core Version:    0.7.0.1
 */