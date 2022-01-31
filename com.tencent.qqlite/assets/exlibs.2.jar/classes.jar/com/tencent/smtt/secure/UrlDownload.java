package com.tencent.smtt.secure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class UrlDownload
{
  private String url;
  
  UrlDownload(String paramString)
  {
    this.url = paramString;
  }
  
  /* Error */
  byte[] getBinData()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: new 20	java/net/URL
    //   8: dup
    //   9: aload_0
    //   10: getfield 13	com/tencent/smtt/secure/UrlDownload:url	Ljava/lang/String;
    //   13: invokespecial 22	java/net/URL:<init>	(Ljava/lang/String;)V
    //   16: invokevirtual 26	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   19: checkcast 28	java/net/HttpURLConnection
    //   22: astore 5
    //   24: aload 5
    //   26: sipush 300
    //   29: invokevirtual 32	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   32: aload 5
    //   34: sipush 300
    //   37: invokevirtual 35	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   40: new 37	java/io/BufferedInputStream
    //   43: dup
    //   44: aload 5
    //   46: invokevirtual 41	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   49: invokespecial 44	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   52: astore_2
    //   53: sipush 4096
    //   56: newarray byte
    //   58: astore_3
    //   59: new 46	java/io/ByteArrayOutputStream
    //   62: dup
    //   63: invokespecial 47	java/io/ByteArrayOutputStream:<init>	()V
    //   66: astore 4
    //   68: aload_2
    //   69: aload_3
    //   70: invokevirtual 53	java/io/InputStream:read	([B)I
    //   73: istore_1
    //   74: iload_1
    //   75: iconst_m1
    //   76: if_icmpeq +25 -> 101
    //   79: aload 4
    //   81: aload_3
    //   82: iconst_0
    //   83: iload_1
    //   84: invokevirtual 57	java/io/ByteArrayOutputStream:write	([BII)V
    //   87: goto -19 -> 68
    //   90: astore_3
    //   91: aload_2
    //   92: ifnull +7 -> 99
    //   95: aload_2
    //   96: invokevirtual 60	java/io/InputStream:close	()V
    //   99: aconst_null
    //   100: areturn
    //   101: aload 5
    //   103: invokevirtual 63	java/net/HttpURLConnection:disconnect	()V
    //   106: aload 4
    //   108: invokevirtual 66	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   111: astore_3
    //   112: aload_2
    //   113: ifnull +7 -> 120
    //   116: aload_2
    //   117: invokevirtual 60	java/io/InputStream:close	()V
    //   120: aload_3
    //   121: areturn
    //   122: astore_2
    //   123: aload_3
    //   124: areturn
    //   125: astore_2
    //   126: aload_3
    //   127: ifnull +7 -> 134
    //   130: aload_3
    //   131: invokevirtual 60	java/io/InputStream:close	()V
    //   134: aload_2
    //   135: athrow
    //   136: astore_2
    //   137: aconst_null
    //   138: areturn
    //   139: astore_3
    //   140: goto -6 -> 134
    //   143: astore 4
    //   145: aload_2
    //   146: astore_3
    //   147: aload 4
    //   149: astore_2
    //   150: goto -24 -> 126
    //   153: astore_2
    //   154: aload 4
    //   156: astore_2
    //   157: goto -66 -> 91
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	160	0	this	UrlDownload
    //   73	11	1	i	int
    //   52	65	2	localBufferedInputStream	java.io.BufferedInputStream
    //   122	1	2	localException1	Exception
    //   125	10	2	localObject1	Object
    //   136	10	2	localException2	Exception
    //   149	1	2	localObject2	Object
    //   153	1	2	localException3	Exception
    //   156	1	2	localObject3	Object
    //   1	81	3	arrayOfByte1	byte[]
    //   90	1	3	localException4	Exception
    //   111	20	3	arrayOfByte2	byte[]
    //   139	1	3	localException5	Exception
    //   146	1	3	localObject4	Object
    //   3	104	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   143	12	4	localObject5	Object
    //   22	80	5	localHttpURLConnection	HttpURLConnection
    // Exception table:
    //   from	to	target	type
    //   53	68	90	java/lang/Exception
    //   68	74	90	java/lang/Exception
    //   79	87	90	java/lang/Exception
    //   101	112	90	java/lang/Exception
    //   116	120	122	java/lang/Exception
    //   5	53	125	finally
    //   95	99	136	java/lang/Exception
    //   130	134	139	java/lang/Exception
    //   53	68	143	finally
    //   68	74	143	finally
    //   79	87	143	finally
    //   101	112	143	finally
    //   5	53	153	java/lang/Exception
  }
  
  ArrayList<String> getListString()
  {
    ArrayList localArrayList = new ArrayList();
    HttpURLConnection localHttpURLConnection;
    try
    {
      localHttpURLConnection = (HttpURLConnection)new URL(this.url).openConnection();
      BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(localHttpURLConnection.getInputStream()));
      for (;;)
      {
        String str = localBufferedReader.readLine();
        if (str == null) {
          break;
        }
        localArrayList.add(str);
      }
      localBufferedReader.close();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return null;
    }
    localHttpURLConnection.disconnect();
    return localException;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.secure.UrlDownload
 * JD-Core Version:    0.7.0.1
 */