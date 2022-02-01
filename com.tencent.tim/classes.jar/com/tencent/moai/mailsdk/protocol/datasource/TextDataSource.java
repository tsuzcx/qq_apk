package com.tencent.moai.mailsdk.protocol.datasource;

public class TextDataSource
  implements DataSource
{
  private static final String TAG = "TextDataSource";
  public static final int TYPE_CALENDAR = 2;
  public static final int TYPE_HTML = 1;
  public static final int TYPE_PLAIN = 0;
  private String boundary;
  private String boundaryEnd;
  private String text;
  private int type;
  
  public TextDataSource() {}
  
  public TextDataSource(String paramString)
  {
    this.text = paramString;
  }
  
  public String getBoundary()
  {
    return this.boundary;
  }
  
  public String getBoundaryEnd()
  {
    return this.boundaryEnd;
  }
  
  public long getSize()
  {
    long l = 0L;
    if (this.text != null) {
      l = this.text.getBytes().length;
    }
    return l;
  }
  
  public String getText()
  {
    return this.text;
  }
  
  public int getType()
  {
    return this.type;
  }
  
  /* Error */
  public String read(java.io.InputStream paramInputStream, com.tencent.moai.mailsdk.protocol.mime.DataListener paramDataListener, String paramString1, String paramString2)
    throws com.tencent.moai.mailsdk.exception.MessageException
  {
    // Byte code:
    //   0: new 57	com/tencent/moai/mailsdk/util/stream/LineInputStream
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 60	com/tencent/moai/mailsdk/util/stream/LineInputStream:<init>	(Ljava/io/InputStream;)V
    //   8: astore 8
    //   10: new 62	java/io/ByteArrayOutputStream
    //   13: dup
    //   14: invokespecial 63	java/io/ByteArrayOutputStream:<init>	()V
    //   17: astore 9
    //   19: new 65	com/tencent/moai/mailsdk/util/stream/LineOutputStream
    //   22: dup
    //   23: aload 9
    //   25: invokespecial 68	com/tencent/moai/mailsdk/util/stream/LineOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   28: astore 5
    //   30: aload 5
    //   32: astore_1
    //   33: aload 8
    //   35: invokevirtual 71	com/tencent/moai/mailsdk/util/stream/LineInputStream:readLine	()Ljava/lang/String;
    //   38: astore 7
    //   40: aload 7
    //   42: astore 6
    //   44: aload 7
    //   46: ifnull +30 -> 76
    //   49: aload 7
    //   51: astore 6
    //   53: aload_2
    //   54: ifnull +22 -> 76
    //   57: aload 5
    //   59: astore_1
    //   60: aload_2
    //   61: aload 7
    //   63: invokevirtual 74	java/lang/String:length	()I
    //   66: i2l
    //   67: invokeinterface 80 3 0
    //   72: aload 7
    //   74: astore 6
    //   76: aload 6
    //   78: ifnull +123 -> 201
    //   81: aload 5
    //   83: astore_1
    //   84: aload 6
    //   86: aload_0
    //   87: getfield 33	com/tencent/moai/mailsdk/protocol/datasource/TextDataSource:boundary	Ljava/lang/String;
    //   90: invokevirtual 84	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   93: ifne +108 -> 201
    //   96: aload 5
    //   98: astore_1
    //   99: aload 6
    //   101: aload_0
    //   102: getfield 36	com/tencent/moai/mailsdk/protocol/datasource/TextDataSource:boundaryEnd	Ljava/lang/String;
    //   105: invokevirtual 84	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   108: ifne +93 -> 201
    //   111: aload 5
    //   113: astore_1
    //   114: aload 5
    //   116: aload 6
    //   118: invokevirtual 87	com/tencent/moai/mailsdk/util/stream/LineOutputStream:writeln	(Ljava/lang/String;)V
    //   121: aload 5
    //   123: astore_1
    //   124: aload 8
    //   126: invokevirtual 71	com/tencent/moai/mailsdk/util/stream/LineInputStream:readLine	()Ljava/lang/String;
    //   129: astore 7
    //   131: aload 7
    //   133: astore 6
    //   135: aload 7
    //   137: ifnull -61 -> 76
    //   140: aload 7
    //   142: astore 6
    //   144: aload_2
    //   145: ifnull -69 -> 76
    //   148: aload 5
    //   150: astore_1
    //   151: aload_2
    //   152: aload 7
    //   154: invokevirtual 74	java/lang/String:length	()I
    //   157: i2l
    //   158: invokeinterface 80 3 0
    //   163: aload 7
    //   165: astore 6
    //   167: goto -91 -> 76
    //   170: astore_2
    //   171: aload 5
    //   173: astore_1
    //   174: new 53	com/tencent/moai/mailsdk/exception/MessageException
    //   177: dup
    //   178: iconst_3
    //   179: ldc 89
    //   181: aload_2
    //   182: invokespecial 92	com/tencent/moai/mailsdk/exception/MessageException:<init>	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   185: athrow
    //   186: astore_3
    //   187: aload_1
    //   188: astore_2
    //   189: aload_3
    //   190: astore_1
    //   191: aload_2
    //   192: ifnull +7 -> 199
    //   195: aload_2
    //   196: invokevirtual 95	com/tencent/moai/mailsdk/util/stream/LineOutputStream:close	()V
    //   199: aload_1
    //   200: athrow
    //   201: aload 5
    //   203: astore_1
    //   204: aload 5
    //   206: invokevirtual 98	com/tencent/moai/mailsdk/util/stream/LineOutputStream:flush	()V
    //   209: aload 5
    //   211: astore_1
    //   212: aload_0
    //   213: new 40	java/lang/String
    //   216: dup
    //   217: aload 9
    //   219: invokevirtual 101	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   222: aload 4
    //   224: aload_3
    //   225: invokestatic 107	com/tencent/moai/mailsdk/util/MimeUtility:decodeData	([BLjava/lang/String;Ljava/lang/String;)[B
    //   228: invokespecial 110	java/lang/String:<init>	([B)V
    //   231: putfield 29	com/tencent/moai/mailsdk/protocol/datasource/TextDataSource:text	Ljava/lang/String;
    //   234: aload 5
    //   236: ifnull +8 -> 244
    //   239: aload 5
    //   241: invokevirtual 95	com/tencent/moai/mailsdk/util/stream/LineOutputStream:close	()V
    //   244: aload 6
    //   246: areturn
    //   247: astore_1
    //   248: aload 6
    //   250: areturn
    //   251: astore_2
    //   252: goto -53 -> 199
    //   255: astore_1
    //   256: aconst_null
    //   257: astore_2
    //   258: goto -67 -> 191
    //   261: astore_2
    //   262: aconst_null
    //   263: astore_1
    //   264: goto -90 -> 174
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	267	0	this	TextDataSource
    //   0	267	1	paramInputStream	java.io.InputStream
    //   0	267	2	paramDataListener	com.tencent.moai.mailsdk.protocol.mime.DataListener
    //   0	267	3	paramString1	String
    //   0	267	4	paramString2	String
    //   28	212	5	localLineOutputStream	com.tencent.moai.mailsdk.util.stream.LineOutputStream
    //   42	207	6	str1	String
    //   38	126	7	str2	String
    //   8	117	8	localLineInputStream	com.tencent.moai.mailsdk.util.stream.LineInputStream
    //   17	201	9	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   33	40	170	java/io/IOException
    //   60	72	170	java/io/IOException
    //   84	96	170	java/io/IOException
    //   99	111	170	java/io/IOException
    //   114	121	170	java/io/IOException
    //   124	131	170	java/io/IOException
    //   151	163	170	java/io/IOException
    //   204	209	170	java/io/IOException
    //   212	234	170	java/io/IOException
    //   33	40	186	finally
    //   60	72	186	finally
    //   84	96	186	finally
    //   99	111	186	finally
    //   114	121	186	finally
    //   124	131	186	finally
    //   151	163	186	finally
    //   174	186	186	finally
    //   204	209	186	finally
    //   212	234	186	finally
    //   239	244	247	java/io/IOException
    //   195	199	251	java/io/IOException
    //   10	30	255	finally
    //   10	30	261	java/io/IOException
  }
  
  public void setBoundary(String paramString)
  {
    this.boundary = paramString;
  }
  
  public void setBoundaryEnd(String paramString)
  {
    this.boundaryEnd = paramString;
  }
  
  public void setText(String paramString)
  {
    this.text = paramString;
  }
  
  public void setType(int paramInt)
  {
    this.type = paramInt;
  }
  
  /* Error */
  public void write(java.io.OutputStream paramOutputStream, com.tencent.moai.mailsdk.protocol.mime.DataListener paramDataListener, String paramString1, String paramString2)
    throws com.tencent.moai.mailsdk.exception.MessageException
  {
    // Byte code:
    //   0: new 120	java/io/ByteArrayInputStream
    //   3: dup
    //   4: aload_0
    //   5: getfield 29	com/tencent/moai/mailsdk/protocol/datasource/TextDataSource:text	Ljava/lang/String;
    //   8: invokevirtual 44	java/lang/String:getBytes	()[B
    //   11: invokespecial 121	java/io/ByteArrayInputStream:<init>	([B)V
    //   14: astore 6
    //   16: aload 6
    //   18: astore_3
    //   19: aload_1
    //   20: aload 4
    //   22: invokestatic 125	com/tencent/moai/mailsdk/util/MimeUtility:encode	(Ljava/io/OutputStream;Ljava/lang/String;)Ljava/io/OutputStream;
    //   25: astore_1
    //   26: aload 6
    //   28: astore_3
    //   29: sipush 8192
    //   32: newarray byte
    //   34: astore 4
    //   36: aload 6
    //   38: astore_3
    //   39: aload 6
    //   41: aload 4
    //   43: invokevirtual 128	java/io/ByteArrayInputStream:read	([B)I
    //   46: istore 5
    //   48: iload 5
    //   50: ifle +61 -> 111
    //   53: aload 6
    //   55: astore_3
    //   56: aload_1
    //   57: aload 4
    //   59: iconst_0
    //   60: iload 5
    //   62: invokevirtual 133	java/io/OutputStream:write	([BII)V
    //   65: aload_2
    //   66: ifnull -30 -> 36
    //   69: aload 6
    //   71: astore_3
    //   72: aload_2
    //   73: iload 5
    //   75: i2l
    //   76: invokeinterface 80 3 0
    //   81: goto -45 -> 36
    //   84: astore_1
    //   85: aload 6
    //   87: astore_3
    //   88: new 53	com/tencent/moai/mailsdk/exception/MessageException
    //   91: dup
    //   92: iconst_3
    //   93: ldc 135
    //   95: aload_1
    //   96: invokespecial 92	com/tencent/moai/mailsdk/exception/MessageException:<init>	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   99: athrow
    //   100: astore_1
    //   101: aload_3
    //   102: ifnull +7 -> 109
    //   105: aload_3
    //   106: invokevirtual 136	java/io/ByteArrayInputStream:close	()V
    //   109: aload_1
    //   110: athrow
    //   111: aload 6
    //   113: astore_3
    //   114: aload_1
    //   115: invokevirtual 137	java/io/OutputStream:flush	()V
    //   118: aload 6
    //   120: ifnull +8 -> 128
    //   123: aload 6
    //   125: invokevirtual 136	java/io/ByteArrayInputStream:close	()V
    //   128: return
    //   129: astore_1
    //   130: return
    //   131: astore_2
    //   132: goto -23 -> 109
    //   135: astore_1
    //   136: aconst_null
    //   137: astore_3
    //   138: goto -37 -> 101
    //   141: astore_1
    //   142: aconst_null
    //   143: astore_3
    //   144: goto -56 -> 88
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	147	0	this	TextDataSource
    //   0	147	1	paramOutputStream	java.io.OutputStream
    //   0	147	2	paramDataListener	com.tencent.moai.mailsdk.protocol.mime.DataListener
    //   0	147	3	paramString1	String
    //   0	147	4	paramString2	String
    //   46	28	5	i	int
    //   14	110	6	localByteArrayInputStream	java.io.ByteArrayInputStream
    // Exception table:
    //   from	to	target	type
    //   19	26	84	java/io/IOException
    //   29	36	84	java/io/IOException
    //   39	48	84	java/io/IOException
    //   56	65	84	java/io/IOException
    //   72	81	84	java/io/IOException
    //   114	118	84	java/io/IOException
    //   19	26	100	finally
    //   29	36	100	finally
    //   39	48	100	finally
    //   56	65	100	finally
    //   72	81	100	finally
    //   88	100	100	finally
    //   114	118	100	finally
    //   123	128	129	java/io/IOException
    //   105	109	131	java/io/IOException
    //   0	16	135	finally
    //   0	16	141	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.datasource.TextDataSource
 * JD-Core Version:    0.7.0.1
 */