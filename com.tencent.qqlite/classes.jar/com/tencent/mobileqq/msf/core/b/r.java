package com.tencent.mobileqq.msf.core.b;

import android.os.Environment;
import java.io.File;

public class r
{
  public static final String a = "VideoProxyRateReport";
  static String b = "";
  static r c = null;
  public static final int d = 0;
  public static final int e = 1;
  public static final int f = 2;
  public static final int g = 3;
  public static final int h = 4;
  public static final int i = 5;
  public static final int j = 6;
  public static final int k = 7;
  public static final int l = 8;
  public static final int m = 9;
  public static final int n = 10;
  public static final int o = 11;
  public static final int p = 12;
  public static final int q = 13;
  public static final int r = 14;
  public static final int s = 15;
  public static final int t = 16;
  public static final int u = 17;
  public static final int v = 18;
  public static final int w = 19;
  public static final int x = 20;
  public static final int y = 100;
  
  public static r a()
  {
    if (c == null)
    {
      c = new r();
      b = Environment.getExternalStorageDirectory().getPath() + "/tencent/audio/";
    }
    return c;
  }
  
  /* Error */
  public void a(a parama, byte[] paramArrayOfByte, int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: aload_2
    //   4: ifnonnull +4 -> 8
    //   7: return
    //   8: new 74	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   15: aload_1
    //   16: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   19: ldc 106
    //   21: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: invokestatic 112	android/os/SystemClock:elapsedRealtime	()J
    //   27: invokestatic 118	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   30: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: ldc 106
    //   35: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: iload_3
    //   39: invokevirtual 121	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   42: ldc 123
    //   44: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: astore_1
    //   51: invokestatic 126	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   54: ldc 128
    //   56: invokevirtual 132	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   59: ifeq -52 -> 7
    //   62: new 83	java/io/File
    //   65: dup
    //   66: getstatic 64	com/tencent/mobileqq/msf/core/b/r:b	Ljava/lang/String;
    //   69: invokespecial 135	java/io/File:<init>	(Ljava/lang/String;)V
    //   72: astore 5
    //   74: aload 5
    //   76: invokevirtual 139	java/io/File:exists	()Z
    //   79: ifne +11 -> 90
    //   82: aload 5
    //   84: invokevirtual 142	java/io/File:mkdirs	()Z
    //   87: ifeq -80 -> 7
    //   90: new 83	java/io/File
    //   93: dup
    //   94: new 74	java/lang/StringBuilder
    //   97: dup
    //   98: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   101: getstatic 64	com/tencent/mobileqq/msf/core/b/r:b	Ljava/lang/String;
    //   104: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: aload_1
    //   108: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   114: invokespecial 135	java/io/File:<init>	(Ljava/lang/String;)V
    //   117: astore 6
    //   119: aconst_null
    //   120: astore 5
    //   122: aload 6
    //   124: ifnull -117 -> 7
    //   127: new 144	java/io/FileOutputStream
    //   130: dup
    //   131: aload 6
    //   133: invokespecial 147	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   136: astore_1
    //   137: aload_1
    //   138: aload_2
    //   139: invokevirtual 151	java/io/FileOutputStream:write	([B)V
    //   142: aload_1
    //   143: invokevirtual 154	java/io/FileOutputStream:flush	()V
    //   146: aload_1
    //   147: ifnull +7 -> 154
    //   150: aload_1
    //   151: invokevirtual 157	java/io/FileOutputStream:close	()V
    //   154: iconst_1
    //   155: istore_3
    //   156: iload_3
    //   157: ifne -150 -> 7
    //   160: aload 6
    //   162: invokevirtual 160	java/io/File:delete	()Z
    //   165: pop
    //   166: return
    //   167: astore_1
    //   168: aconst_null
    //   169: astore_1
    //   170: aload_1
    //   171: ifnull +7 -> 178
    //   174: aload_1
    //   175: invokevirtual 157	java/io/FileOutputStream:close	()V
    //   178: aload 6
    //   180: invokevirtual 160	java/io/File:delete	()Z
    //   183: pop
    //   184: return
    //   185: astore_1
    //   186: aconst_null
    //   187: astore_1
    //   188: aload_1
    //   189: ifnull +7 -> 196
    //   192: aload_1
    //   193: invokevirtual 157	java/io/FileOutputStream:close	()V
    //   196: aload 6
    //   198: invokevirtual 160	java/io/File:delete	()Z
    //   201: pop
    //   202: return
    //   203: astore_1
    //   204: aload 5
    //   206: astore_2
    //   207: aload_2
    //   208: ifnull +7 -> 215
    //   211: aload_2
    //   212: invokevirtual 157	java/io/FileOutputStream:close	()V
    //   215: iconst_1
    //   216: istore_3
    //   217: iload_3
    //   218: ifne +9 -> 227
    //   221: aload 6
    //   223: invokevirtual 160	java/io/File:delete	()Z
    //   226: pop
    //   227: aload_1
    //   228: athrow
    //   229: astore_2
    //   230: iconst_0
    //   231: istore_3
    //   232: goto -15 -> 217
    //   235: astore_1
    //   236: iload 4
    //   238: istore_3
    //   239: goto -83 -> 156
    //   242: astore_1
    //   243: goto -65 -> 178
    //   246: astore_1
    //   247: goto -51 -> 196
    //   250: astore 5
    //   252: aload_1
    //   253: astore_2
    //   254: aload 5
    //   256: astore_1
    //   257: goto -50 -> 207
    //   260: astore_2
    //   261: goto -73 -> 188
    //   264: astore_2
    //   265: goto -95 -> 170
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	268	0	this	r
    //   0	268	1	parama	a
    //   0	268	2	paramArrayOfByte	byte[]
    //   0	268	3	paramInt	int
    //   1	236	4	i1	int
    //   72	133	5	localFile1	File
    //   250	5	5	localObject	Object
    //   117	105	6	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   127	137	167	java/io/FileNotFoundException
    //   127	137	185	java/io/IOException
    //   127	137	203	finally
    //   211	215	229	java/io/IOException
    //   150	154	235	java/io/IOException
    //   174	178	242	java/io/IOException
    //   192	196	246	java/io/IOException
    //   137	146	250	finally
    //   137	146	260	java/io/IOException
    //   137	146	264	java/io/FileNotFoundException
  }
  
  public static enum a
  {
    public static a a(String paramString)
    {
      return (a)Enum.valueOf(a.class, paramString);
    }
    
    public static a[] a()
    {
      return (a[])j.clone();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.b.r
 * JD-Core Version:    0.7.0.1
 */