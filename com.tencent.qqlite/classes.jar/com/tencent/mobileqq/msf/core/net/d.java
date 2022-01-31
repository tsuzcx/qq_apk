package com.tencent.mobileqq.msf.core.net;

import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.util.QLog;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;

public class d
{
  private static final String a = "LightHttpEngine";
  private String b;
  private URL c;
  private int d = 10000;
  private HttpURLConnection e;
  private int f;
  private String g;
  
  private String a(String paramString)
  {
    Object localObject = new Random(System.currentTimeMillis());
    localObject = "r=" + String.valueOf(((Random)localObject).nextInt(100000));
    if (paramString.contains("?"))
    {
      if (paramString.endsWith("?")) {
        return paramString + (String)localObject;
      }
      return (String)localObject + "&" + (String)localObject;
    }
    return "?" + (String)localObject;
  }
  
  public void a()
  {
    QLog.d("LightHttpEngine", 1, "LightHttpEngine disconnect " + this.b);
    if (this.e != null) {
      this.e.disconnect();
    }
  }
  
  public void a(int paramInt)
  {
    this.d = paramInt;
  }
  
  public boolean a(String paramString, int paramInt)
  {
    try
    {
      paramString = "http://" + paramString + ":" + paramInt;
      this.b = (paramString + a(paramString));
      this.b = MsfSdkUtils.insertMtype("pcactive", this.b);
      QLog.d("LightHttpEngine", 1, "LightHttpEngine try connect " + this.b);
      this.c = new URL(this.b);
      this.e = ((HttpURLConnection)this.c.openConnection());
      this.e.setDoOutput(true);
      this.e.setDoInput(true);
      this.e.setUseCaches(false);
      this.e.setReadTimeout(30000);
      this.e.setRequestMethod("POST");
      this.e.setRequestProperty("User-Agent", "aqq");
      this.e.setRequestProperty("content-type", "oct");
      this.e.setConnectTimeout(this.d);
      this.e.setRequestProperty("Connection", "close");
      this.e.setRequestProperty("Accept-Encoding", "");
      this.e.connect();
      QLog.d("LightHttpEngine", 1, "LightHttpEngine connect " + this.b + " succ.");
      return true;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
      QLog.d("LightHttpEngine", 1, "LightHttpEngine connect " + this.b + " failed.", paramString);
    }
    try
    {
      if (this.e != null) {
        this.e.disconnect();
      }
      return false;
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  /* Error */
  public byte[] a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aload_0
    //   4: getfield 83	com/tencent/mobileqq/msf/core/net/d:e	Ljava/net/HttpURLConnection;
    //   7: invokevirtual 183	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   10: astore_3
    //   11: aload_3
    //   12: aload_1
    //   13: invokevirtual 189	java/io/OutputStream:write	([B)V
    //   16: aload_3
    //   17: invokevirtual 192	java/io/OutputStream:flush	()V
    //   20: ldc 8
    //   22: iconst_1
    //   23: ldc 194
    //   25: invokestatic 81	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   28: aload_0
    //   29: aload_0
    //   30: getfield 83	com/tencent/mobileqq/msf/core/net/d:e	Ljava/net/HttpURLConnection;
    //   33: invokevirtual 198	java/net/HttpURLConnection:getResponseCode	()I
    //   36: putfield 200	com/tencent/mobileqq/msf/core/net/d:f	I
    //   39: aload_0
    //   40: aload_0
    //   41: getfield 83	com/tencent/mobileqq/msf/core/net/d:e	Ljava/net/HttpURLConnection;
    //   44: invokevirtual 204	java/net/HttpURLConnection:getURL	()Ljava/net/URL;
    //   47: invokevirtual 207	java/net/URL:getHost	()Ljava/lang/String;
    //   50: putfield 209	com/tencent/mobileqq/msf/core/net/d:g	Ljava/lang/String;
    //   53: aload_0
    //   54: getfield 83	com/tencent/mobileqq/msf/core/net/d:e	Ljava/net/HttpURLConnection;
    //   57: invokevirtual 213	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   60: astore_1
    //   61: aload_1
    //   62: astore 5
    //   64: aload_3
    //   65: astore 4
    //   67: new 215	java/io/BufferedInputStream
    //   70: dup
    //   71: aload_1
    //   72: invokespecial 218	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   75: astore 6
    //   77: aload_1
    //   78: astore 5
    //   80: aload_3
    //   81: astore 4
    //   83: new 220	org/apache/http/util/ByteArrayBuffer
    //   86: dup
    //   87: sipush 1024
    //   90: invokespecial 222	org/apache/http/util/ByteArrayBuffer:<init>	(I)V
    //   93: astore 8
    //   95: aload_1
    //   96: astore 5
    //   98: aload_3
    //   99: astore 4
    //   101: bipush 50
    //   103: newarray byte
    //   105: astore 9
    //   107: aload_1
    //   108: astore 5
    //   110: aload_3
    //   111: astore 4
    //   113: aload 6
    //   115: aload 9
    //   117: invokevirtual 226	java/io/BufferedInputStream:read	([B)I
    //   120: istore_2
    //   121: iload_2
    //   122: iconst_m1
    //   123: if_icmpne +58 -> 181
    //   126: aload_1
    //   127: astore 5
    //   129: aload_3
    //   130: astore 4
    //   132: ldc 8
    //   134: iconst_1
    //   135: ldc 228
    //   137: invokestatic 81	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   140: aload_1
    //   141: astore 5
    //   143: aload_3
    //   144: astore 4
    //   146: aload 8
    //   148: invokevirtual 232	org/apache/http/util/ByteArrayBuffer:toByteArray	()[B
    //   151: astore 6
    //   153: aload 6
    //   155: astore 4
    //   157: aload_3
    //   158: ifnull +7 -> 165
    //   161: aload_3
    //   162: invokevirtual 234	java/io/OutputStream:close	()V
    //   165: aload 4
    //   167: astore_3
    //   168: aload_1
    //   169: ifnull +10 -> 179
    //   172: aload_1
    //   173: invokevirtual 237	java/io/InputStream:close	()V
    //   176: aload 4
    //   178: astore_3
    //   179: aload_3
    //   180: areturn
    //   181: aload_1
    //   182: astore 5
    //   184: aload_3
    //   185: astore 4
    //   187: aload 8
    //   189: aload 9
    //   191: iconst_0
    //   192: iload_2
    //   193: invokevirtual 240	org/apache/http/util/ByteArrayBuffer:append	([BII)V
    //   196: goto -89 -> 107
    //   199: astore 6
    //   201: aload_1
    //   202: astore 5
    //   204: aload_3
    //   205: astore 4
    //   207: aload 6
    //   209: invokevirtual 173	java/lang/Throwable:printStackTrace	()V
    //   212: aload_1
    //   213: astore 5
    //   215: aload_3
    //   216: astore 4
    //   218: ldc 8
    //   220: iconst_1
    //   221: ldc 242
    //   223: aload 6
    //   225: invokestatic 178	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   228: aload_3
    //   229: ifnull +7 -> 236
    //   232: aload_3
    //   233: invokevirtual 234	java/io/OutputStream:close	()V
    //   236: aload 7
    //   238: astore_3
    //   239: aload_1
    //   240: ifnull -61 -> 179
    //   243: aload_1
    //   244: invokevirtual 237	java/io/InputStream:close	()V
    //   247: aconst_null
    //   248: areturn
    //   249: astore_1
    //   250: aload_1
    //   251: invokevirtual 173	java/lang/Throwable:printStackTrace	()V
    //   254: aconst_null
    //   255: areturn
    //   256: astore_1
    //   257: aload_1
    //   258: invokevirtual 173	java/lang/Throwable:printStackTrace	()V
    //   261: aload 4
    //   263: areturn
    //   264: astore_1
    //   265: aconst_null
    //   266: astore 5
    //   268: aconst_null
    //   269: astore_3
    //   270: aload_3
    //   271: ifnull +7 -> 278
    //   274: aload_3
    //   275: invokevirtual 234	java/io/OutputStream:close	()V
    //   278: aload 5
    //   280: ifnull +8 -> 288
    //   283: aload 5
    //   285: invokevirtual 237	java/io/InputStream:close	()V
    //   288: aload_1
    //   289: athrow
    //   290: astore_3
    //   291: aload_3
    //   292: invokevirtual 173	java/lang/Throwable:printStackTrace	()V
    //   295: goto -7 -> 288
    //   298: astore_1
    //   299: aconst_null
    //   300: astore 5
    //   302: goto -32 -> 270
    //   305: astore_1
    //   306: aload 4
    //   308: astore_3
    //   309: goto -39 -> 270
    //   312: astore 6
    //   314: aconst_null
    //   315: astore_1
    //   316: aconst_null
    //   317: astore_3
    //   318: goto -117 -> 201
    //   321: astore 6
    //   323: aconst_null
    //   324: astore_1
    //   325: goto -124 -> 201
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	328	0	this	d
    //   0	328	1	paramArrayOfByte	byte[]
    //   120	73	2	i	int
    //   10	265	3	localObject1	Object
    //   290	2	3	localThrowable1	Throwable
    //   308	10	3	localObject2	Object
    //   65	242	4	localObject3	Object
    //   62	239	5	arrayOfByte1	byte[]
    //   75	79	6	localObject4	Object
    //   199	25	6	localThrowable2	Throwable
    //   312	1	6	localThrowable3	Throwable
    //   321	1	6	localThrowable4	Throwable
    //   1	236	7	localObject5	Object
    //   93	95	8	localByteArrayBuffer	org.apache.http.util.ByteArrayBuffer
    //   105	85	9	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   67	77	199	java/lang/Throwable
    //   83	95	199	java/lang/Throwable
    //   101	107	199	java/lang/Throwable
    //   113	121	199	java/lang/Throwable
    //   132	140	199	java/lang/Throwable
    //   146	153	199	java/lang/Throwable
    //   187	196	199	java/lang/Throwable
    //   232	236	249	java/lang/Throwable
    //   243	247	249	java/lang/Throwable
    //   161	165	256	java/lang/Throwable
    //   172	176	256	java/lang/Throwable
    //   3	11	264	finally
    //   274	278	290	java/lang/Throwable
    //   283	288	290	java/lang/Throwable
    //   11	61	298	finally
    //   67	77	305	finally
    //   83	95	305	finally
    //   101	107	305	finally
    //   113	121	305	finally
    //   132	140	305	finally
    //   146	153	305	finally
    //   187	196	305	finally
    //   207	212	305	finally
    //   218	228	305	finally
    //   3	11	312	java/lang/Throwable
    //   11	61	321	java/lang/Throwable
  }
  
  public void b()
  {
    this.b = null;
    this.c = null;
    this.d = 10000;
    this.e = null;
    this.f = 0;
    this.g = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.d
 * JD-Core Version:    0.7.0.1
 */