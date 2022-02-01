package com.tencent.moai.mailsdk.protocol.imap.model;

public class IMAPContent
{
  private String content;
  private String subType;
  
  public String getContent()
  {
    return this.content;
  }
  
  public String getSubType()
  {
    return this.subType;
  }
  
  /* Error */
  public void read(java.io.InputStream paramInputStream, String paramString1, String paramString2)
    throws com.tencent.moai.mailsdk.exception.MessageException
  {
    // Byte code:
    //   0: new 27	com/tencent/moai/mailsdk/util/stream/LineInputStream
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 30	com/tencent/moai/mailsdk/util/stream/LineInputStream:<init>	(Ljava/io/InputStream;)V
    //   8: astore 6
    //   10: new 32	java/io/ByteArrayOutputStream
    //   13: dup
    //   14: invokespecial 33	java/io/ByteArrayOutputStream:<init>	()V
    //   17: astore 7
    //   19: new 35	com/tencent/moai/mailsdk/util/stream/LineOutputStream
    //   22: dup
    //   23: aload 7
    //   25: invokespecial 38	com/tencent/moai/mailsdk/util/stream/LineOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   28: astore 4
    //   30: aload 4
    //   32: astore_1
    //   33: aload 6
    //   35: invokevirtual 41	com/tencent/moai/mailsdk/util/stream/LineInputStream:readLine	()Ljava/lang/String;
    //   38: astore 5
    //   40: aload 5
    //   42: ifnull +26 -> 68
    //   45: aload 4
    //   47: astore_1
    //   48: aload 4
    //   50: aload 5
    //   52: invokevirtual 45	com/tencent/moai/mailsdk/util/stream/LineOutputStream:writeln	(Ljava/lang/String;)V
    //   55: aload 4
    //   57: astore_1
    //   58: aload 6
    //   60: invokevirtual 41	com/tencent/moai/mailsdk/util/stream/LineInputStream:readLine	()Ljava/lang/String;
    //   63: astore 5
    //   65: goto -25 -> 40
    //   68: aload 4
    //   70: astore_1
    //   71: aload 4
    //   73: invokevirtual 48	com/tencent/moai/mailsdk/util/stream/LineOutputStream:flush	()V
    //   76: aload 4
    //   78: astore_1
    //   79: aload_0
    //   80: new 50	java/lang/String
    //   83: dup
    //   84: aload 7
    //   86: invokevirtual 54	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   89: aload_3
    //   90: aload_2
    //   91: invokestatic 60	com/tencent/moai/mailsdk/util/MimeUtility:decodeData	([BLjava/lang/String;Ljava/lang/String;)[B
    //   94: invokespecial 63	java/lang/String:<init>	([B)V
    //   97: putfield 16	com/tencent/moai/mailsdk/protocol/imap/model/IMAPContent:content	Ljava/lang/String;
    //   100: aload 4
    //   102: ifnull +8 -> 110
    //   105: aload 4
    //   107: invokevirtual 66	com/tencent/moai/mailsdk/util/stream/LineOutputStream:close	()V
    //   110: return
    //   111: astore_2
    //   112: aconst_null
    //   113: astore_1
    //   114: new 23	com/tencent/moai/mailsdk/exception/MessageException
    //   117: dup
    //   118: iconst_3
    //   119: ldc 68
    //   121: aload_2
    //   122: invokespecial 71	com/tencent/moai/mailsdk/exception/MessageException:<init>	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   125: athrow
    //   126: astore_3
    //   127: aload_1
    //   128: astore_2
    //   129: aload_3
    //   130: astore_1
    //   131: aload_2
    //   132: ifnull +7 -> 139
    //   135: aload_2
    //   136: invokevirtual 66	com/tencent/moai/mailsdk/util/stream/LineOutputStream:close	()V
    //   139: aload_1
    //   140: athrow
    //   141: astore_1
    //   142: return
    //   143: astore_2
    //   144: goto -5 -> 139
    //   147: astore_1
    //   148: aconst_null
    //   149: astore_2
    //   150: goto -19 -> 131
    //   153: astore_2
    //   154: aload 4
    //   156: astore_1
    //   157: goto -43 -> 114
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	160	0	this	IMAPContent
    //   0	160	1	paramInputStream	java.io.InputStream
    //   0	160	2	paramString1	String
    //   0	160	3	paramString2	String
    //   28	127	4	localLineOutputStream	com.tencent.moai.mailsdk.util.stream.LineOutputStream
    //   38	26	5	str	String
    //   8	51	6	localLineInputStream	com.tencent.moai.mailsdk.util.stream.LineInputStream
    //   17	68	7	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   10	30	111	java/io/IOException
    //   33	40	126	finally
    //   48	55	126	finally
    //   58	65	126	finally
    //   71	76	126	finally
    //   79	100	126	finally
    //   114	126	126	finally
    //   105	110	141	java/io/IOException
    //   135	139	143	java/io/IOException
    //   10	30	147	finally
    //   33	40	153	java/io/IOException
    //   48	55	153	java/io/IOException
    //   58	65	153	java/io/IOException
    //   71	76	153	java/io/IOException
    //   79	100	153	java/io/IOException
  }
  
  public void setContent(String paramString)
  {
    this.content = paramString;
  }
  
  public void setSubType(String paramString)
  {
    this.subType = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.imap.model.IMAPContent
 * JD-Core Version:    0.7.0.1
 */