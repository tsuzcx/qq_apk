package com.qzone.common.dns;

public class DnsMain
{
  private static final String TAG = "DnsMain";
  
  /* Error */
  public static java.net.InetAddress[] getBetterHostByName(String paramString, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 29	com/qzone/common/dns/DnsMain:getHostName	(Ljava/lang/String;)Ljava/lang/String;
    //   4: astore_0
    //   5: ldc 8
    //   7: new 31	java/lang/StringBuilder
    //   10: dup
    //   11: ldc 33
    //   13: invokespecial 36	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   16: aload_0
    //   17: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: ldc 42
    //   22: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: lload_1
    //   26: invokevirtual 45	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   29: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokestatic 55	com/qzone/common/logging/QDLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   35: ldc 8
    //   37: new 31	java/lang/StringBuilder
    //   40: dup
    //   41: ldc 57
    //   43: invokespecial 36	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   46: aload_0
    //   47: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: invokestatic 55	com/qzone/common/logging/QDLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   56: aload_0
    //   57: ifnull +13 -> 70
    //   60: aload_0
    //   61: invokevirtual 62	java/lang/String:trim	()Ljava/lang/String;
    //   64: invokevirtual 66	java/lang/String:length	()I
    //   67: ifgt +5 -> 72
    //   70: aconst_null
    //   71: areturn
    //   72: aload_0
    //   73: invokevirtual 62	java/lang/String:trim	()Ljava/lang/String;
    //   76: astore_3
    //   77: iconst_0
    //   78: ifeq +35 -> 113
    //   81: ldc 8
    //   83: new 31	java/lang/StringBuilder
    //   86: dup
    //   87: ldc 68
    //   89: invokespecial 36	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   92: aload_3
    //   93: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: ldc 70
    //   98: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: aconst_null
    //   102: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   105: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   108: invokestatic 55	com/qzone/common/logging/QDLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   111: aconst_null
    //   112: areturn
    //   113: new 75	com/qzone/common/dns/Lookup
    //   116: dup
    //   117: ldc 77
    //   119: invokespecial 78	com/qzone/common/dns/Lookup:<init>	(Ljava/lang/String;)V
    //   122: astore_0
    //   123: aload_0
    //   124: aload_3
    //   125: lload_1
    //   126: invokevirtual 81	com/qzone/common/dns/Lookup:run	(Ljava/lang/String;J)[Ljava/net/InetAddress;
    //   129: astore_0
    //   130: aload_0
    //   131: ifnull +76 -> 207
    //   134: aload_0
    //   135: arraylength
    //   136: ifle +71 -> 207
    //   139: ldc 8
    //   141: new 31	java/lang/StringBuilder
    //   144: dup
    //   145: ldc 83
    //   147: invokespecial 36	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   150: aload_3
    //   151: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: ldc 70
    //   156: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: aload_0
    //   160: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   163: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   166: invokestatic 55	com/qzone/common/logging/QDLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   169: aload_0
    //   170: areturn
    //   171: astore_0
    //   172: ldc 8
    //   174: new 31	java/lang/StringBuilder
    //   177: dup
    //   178: ldc 85
    //   180: invokespecial 36	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   183: aload_3
    //   184: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: ldc 87
    //   189: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: aload_0
    //   193: invokevirtual 90	java/net/UnknownHostException:getMessage	()Ljava/lang/String;
    //   196: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   202: invokestatic 93	com/qzone/common/logging/QDLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   205: aconst_null
    //   206: areturn
    //   207: ldc 8
    //   209: ldc 95
    //   211: invokestatic 93	com/qzone/common/logging/QDLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   214: goto -9 -> 205
    //   217: astore_0
    //   218: ldc 8
    //   220: new 31	java/lang/StringBuilder
    //   223: dup
    //   224: ldc 97
    //   226: invokespecial 36	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   229: aload_3
    //   230: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: ldc 87
    //   235: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: aload_0
    //   239: invokevirtual 98	com/qzone/common/dns/WireParseException:getMessage	()Ljava/lang/String;
    //   242: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   248: invokestatic 93	com/qzone/common/logging/QDLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   251: goto -46 -> 205
    //   254: astore_0
    //   255: ldc 8
    //   257: new 31	java/lang/StringBuilder
    //   260: dup
    //   261: ldc 100
    //   263: invokespecial 36	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   266: aload_3
    //   267: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: ldc 87
    //   272: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: aload_0
    //   276: invokevirtual 101	java/net/SocketTimeoutException:getMessage	()Ljava/lang/String;
    //   279: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   285: invokestatic 93	com/qzone/common/logging/QDLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   288: goto -83 -> 205
    //   291: astore_0
    //   292: ldc 8
    //   294: new 31	java/lang/StringBuilder
    //   297: dup
    //   298: ldc 103
    //   300: invokespecial 36	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   303: aload_3
    //   304: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: ldc 87
    //   309: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: aload_0
    //   313: invokevirtual 104	java/io/IOException:getMessage	()Ljava/lang/String;
    //   316: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   322: invokestatic 93	com/qzone/common/logging/QDLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   325: goto -120 -> 205
    //   328: astore_0
    //   329: ldc 8
    //   331: new 31	java/lang/StringBuilder
    //   334: dup
    //   335: ldc 106
    //   337: invokespecial 36	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   340: aload_3
    //   341: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: ldc 87
    //   346: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: aload_0
    //   350: invokevirtual 107	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   353: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   359: invokestatic 93	com/qzone/common/logging/QDLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   362: goto -157 -> 205
    //   365: astore_0
    //   366: goto -37 -> 329
    //   369: astore_0
    //   370: goto -78 -> 292
    //   373: astore_0
    //   374: goto -119 -> 255
    //   377: astore_0
    //   378: goto -160 -> 218
    //   381: astore_0
    //   382: goto -210 -> 172
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	385	0	paramString	String
    //   0	385	1	paramLong	long
    //   76	265	3	str	String
    // Exception table:
    //   from	to	target	type
    //   123	130	171	java/net/UnknownHostException
    //   134	169	171	java/net/UnknownHostException
    //   207	214	171	java/net/UnknownHostException
    //   113	123	217	com/qzone/common/dns/WireParseException
    //   113	123	254	java/net/SocketTimeoutException
    //   113	123	291	java/io/IOException
    //   113	123	328	java/lang/Exception
    //   123	130	365	java/lang/Exception
    //   134	169	365	java/lang/Exception
    //   207	214	365	java/lang/Exception
    //   123	130	369	java/io/IOException
    //   134	169	369	java/io/IOException
    //   207	214	369	java/io/IOException
    //   123	130	373	java/net/SocketTimeoutException
    //   134	169	373	java/net/SocketTimeoutException
    //   207	214	373	java/net/SocketTimeoutException
    //   123	130	377	com/qzone/common/dns/WireParseException
    //   134	169	377	com/qzone/common/dns/WireParseException
    //   207	214	377	com/qzone/common/dns/WireParseException
    //   113	123	381	java/net/UnknownHostException
  }
  
  public static String getHostName(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    paramString = paramString.trim();
    String str = paramString.toLowerCase();
    int i;
    if (str.startsWith("http://"))
    {
      i = paramString.indexOf("/", 8);
      if (i > 7) {
        return paramString.substring(7, i);
      }
      return paramString.substring(7);
    }
    if (str.startsWith("https://"))
    {
      i = paramString.indexOf("/", 9);
      if (i > 8) {
        return paramString.substring(8, i);
      }
      return paramString.substring(8);
    }
    if (paramString.indexOf("/", 1) > 1) {
      return paramString.substring(0, paramString.indexOf("/", 1));
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.qzone.common.dns.DnsMain
 * JD-Core Version:    0.7.0.1
 */