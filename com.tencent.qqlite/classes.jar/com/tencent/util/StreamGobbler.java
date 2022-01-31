package com.tencent.util;

import java.io.InputStream;
import java.io.OutputStream;

public class StreamGobbler
  extends Thread
{
  InputStream jdField_a_of_type_JavaIoInputStream;
  OutputStream jdField_a_of_type_JavaIoOutputStream;
  String jdField_a_of_type_JavaLangString;
  
  StreamGobbler(InputStream paramInputStream, String paramString)
  {
    this(paramInputStream, paramString, null);
  }
  
  StreamGobbler(InputStream paramInputStream, String paramString, OutputStream paramOutputStream)
  {
    this.jdField_a_of_type_JavaIoInputStream = paramInputStream;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaIoOutputStream = paramOutputStream;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_0
    //   3: getfield 23	com/tencent/util/StreamGobbler:jdField_a_of_type_JavaIoOutputStream	Ljava/io/OutputStream;
    //   6: ifnull +299 -> 305
    //   9: new 28	java/io/PrintWriter
    //   12: dup
    //   13: aload_0
    //   14: getfield 23	com/tencent/util/StreamGobbler:jdField_a_of_type_JavaIoOutputStream	Ljava/io/OutputStream;
    //   17: invokespecial 31	java/io/PrintWriter:<init>	(Ljava/io/OutputStream;)V
    //   20: astore_2
    //   21: aload_2
    //   22: astore_1
    //   23: new 33	java/io/InputStreamReader
    //   26: dup
    //   27: aload_0
    //   28: getfield 19	com/tencent/util/StreamGobbler:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   31: invokespecial 36	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   34: astore_3
    //   35: new 38	java/io/BufferedReader
    //   38: dup
    //   39: aload_3
    //   40: invokespecial 41	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   43: astore 5
    //   45: aload 5
    //   47: invokevirtual 45	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   50: astore_2
    //   51: aload_2
    //   52: ifnull +82 -> 134
    //   55: aload_1
    //   56: ifnull +8 -> 64
    //   59: aload_1
    //   60: aload_2
    //   61: invokevirtual 49	java/io/PrintWriter:println	(Ljava/lang/String;)V
    //   64: getstatic 55	java/lang/System:out	Ljava/io/PrintStream;
    //   67: new 57	java/lang/StringBuilder
    //   70: dup
    //   71: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   74: aload_0
    //   75: getfield 21	com/tencent/util/StreamGobbler:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   78: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: ldc 64
    //   83: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: aload_2
    //   87: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   93: invokevirtual 70	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   96: goto -51 -> 45
    //   99: astore 4
    //   101: aload 5
    //   103: astore_2
    //   104: aload 4
    //   106: invokevirtual 73	java/io/IOException:printStackTrace	()V
    //   109: aload_1
    //   110: ifnull +7 -> 117
    //   113: aload_1
    //   114: invokevirtual 76	java/io/PrintWriter:close	()V
    //   117: aload_2
    //   118: ifnull +7 -> 125
    //   121: aload_2
    //   122: invokevirtual 77	java/io/BufferedReader:close	()V
    //   125: aload_3
    //   126: ifnull +7 -> 133
    //   129: aload_3
    //   130: invokevirtual 78	java/io/InputStreamReader:close	()V
    //   133: return
    //   134: aload_1
    //   135: ifnull +7 -> 142
    //   138: aload_1
    //   139: invokevirtual 81	java/io/PrintWriter:flush	()V
    //   142: aload_1
    //   143: ifnull +7 -> 150
    //   146: aload_1
    //   147: invokevirtual 76	java/io/PrintWriter:close	()V
    //   150: aload 5
    //   152: ifnull +8 -> 160
    //   155: aload 5
    //   157: invokevirtual 77	java/io/BufferedReader:close	()V
    //   160: aload_3
    //   161: ifnull -28 -> 133
    //   164: aload_3
    //   165: invokevirtual 78	java/io/InputStreamReader:close	()V
    //   168: return
    //   169: astore_1
    //   170: return
    //   171: astore_2
    //   172: aconst_null
    //   173: astore 4
    //   175: aconst_null
    //   176: astore_1
    //   177: aconst_null
    //   178: astore_3
    //   179: aload 4
    //   181: ifnull +8 -> 189
    //   184: aload 4
    //   186: invokevirtual 76	java/io/PrintWriter:close	()V
    //   189: aload_1
    //   190: ifnull +7 -> 197
    //   193: aload_1
    //   194: invokevirtual 77	java/io/BufferedReader:close	()V
    //   197: aload_3
    //   198: ifnull +7 -> 205
    //   201: aload_3
    //   202: invokevirtual 78	java/io/InputStreamReader:close	()V
    //   205: aload_2
    //   206: athrow
    //   207: astore_1
    //   208: goto -48 -> 160
    //   211: astore_1
    //   212: goto -87 -> 125
    //   215: astore_1
    //   216: return
    //   217: astore_1
    //   218: goto -21 -> 197
    //   221: astore_1
    //   222: goto -17 -> 205
    //   225: astore_2
    //   226: aconst_null
    //   227: astore 5
    //   229: aconst_null
    //   230: astore_3
    //   231: aload_1
    //   232: astore 4
    //   234: aload 5
    //   236: astore_1
    //   237: goto -58 -> 179
    //   240: astore_2
    //   241: aconst_null
    //   242: astore 5
    //   244: aload_1
    //   245: astore 4
    //   247: aload 5
    //   249: astore_1
    //   250: goto -71 -> 179
    //   253: astore_2
    //   254: aload_1
    //   255: astore 4
    //   257: aload 5
    //   259: astore_1
    //   260: goto -81 -> 179
    //   263: astore 4
    //   265: aload_2
    //   266: astore 5
    //   268: aload 4
    //   270: astore_2
    //   271: aload_1
    //   272: astore 4
    //   274: aload 5
    //   276: astore_1
    //   277: goto -98 -> 179
    //   280: astore 4
    //   282: aconst_null
    //   283: astore_2
    //   284: aconst_null
    //   285: astore_3
    //   286: goto -182 -> 104
    //   289: astore 4
    //   291: aconst_null
    //   292: astore_3
    //   293: aconst_null
    //   294: astore_2
    //   295: goto -191 -> 104
    //   298: astore 4
    //   300: aconst_null
    //   301: astore_2
    //   302: goto -198 -> 104
    //   305: aconst_null
    //   306: astore_1
    //   307: goto -284 -> 23
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	310	0	this	StreamGobbler
    //   1	146	1	localObject1	java.lang.Object
    //   169	1	1	localIOException1	java.io.IOException
    //   176	18	1	localObject2	java.lang.Object
    //   207	1	1	localIOException2	java.io.IOException
    //   211	1	1	localIOException3	java.io.IOException
    //   215	1	1	localIOException4	java.io.IOException
    //   217	1	1	localIOException5	java.io.IOException
    //   221	11	1	localIOException6	java.io.IOException
    //   236	71	1	localObject3	java.lang.Object
    //   20	102	2	localObject4	java.lang.Object
    //   171	35	2	localObject5	java.lang.Object
    //   225	1	2	localObject6	java.lang.Object
    //   240	1	2	localObject7	java.lang.Object
    //   253	13	2	localObject8	java.lang.Object
    //   270	32	2	localObject9	java.lang.Object
    //   34	259	3	localInputStreamReader	java.io.InputStreamReader
    //   99	6	4	localIOException7	java.io.IOException
    //   173	83	4	localObject10	java.lang.Object
    //   263	6	4	localObject11	java.lang.Object
    //   272	1	4	localObject12	java.lang.Object
    //   280	1	4	localIOException8	java.io.IOException
    //   289	1	4	localIOException9	java.io.IOException
    //   298	1	4	localIOException10	java.io.IOException
    //   43	232	5	localObject13	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   45	51	99	java/io/IOException
    //   59	64	99	java/io/IOException
    //   64	96	99	java/io/IOException
    //   138	142	99	java/io/IOException
    //   164	168	169	java/io/IOException
    //   2	21	171	finally
    //   155	160	207	java/io/IOException
    //   121	125	211	java/io/IOException
    //   129	133	215	java/io/IOException
    //   193	197	217	java/io/IOException
    //   201	205	221	java/io/IOException
    //   23	35	225	finally
    //   35	45	240	finally
    //   45	51	253	finally
    //   59	64	253	finally
    //   64	96	253	finally
    //   138	142	253	finally
    //   104	109	263	finally
    //   2	21	280	java/io/IOException
    //   23	35	289	java/io/IOException
    //   35	45	298	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.util.StreamGobbler
 * JD-Core Version:    0.7.0.1
 */