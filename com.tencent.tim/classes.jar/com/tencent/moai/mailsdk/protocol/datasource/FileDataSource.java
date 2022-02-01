package com.tencent.moai.mailsdk.protocol.datasource;

import com.tencent.moai.mailsdk.exception.MessageException;
import com.tencent.moai.mailsdk.protocol.mime.DataListener;
import com.tencent.moai.mailsdk.util.FileUtility;
import com.tencent.moai.mailsdk.util.MimeUtility;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileDataSource
  implements DataSource
{
  private static final String TAG = "FileDataSource";
  public static final int TYPE_ATTACHMENT = 0;
  public static final int TYPE_INLINE = 1;
  private String boundary;
  private String boundaryEnd;
  private File file;
  private File tempFile;
  private int type;
  
  public String getBoundary()
  {
    return this.boundary;
  }
  
  public String getBoundaryEnd()
  {
    return this.boundaryEnd;
  }
  
  public File getFile()
  {
    return this.file;
  }
  
  public long getSize()
  {
    long l = 0L;
    if (this.file != null) {
      l = this.file.length();
    }
    return l;
  }
  
  public File getTempFile()
  {
    return this.tempFile;
  }
  
  public int getType()
  {
    return this.type;
  }
  
  /* Error */
  public String read(InputStream paramInputStream, DataListener paramDataListener, String paramString1, String paramString2)
    throws MessageException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 7
    //   6: new 61	com/tencent/moai/mailsdk/util/stream/LineInputStream
    //   9: dup
    //   10: aload_1
    //   11: invokespecial 64	com/tencent/moai/mailsdk/util/stream/LineInputStream:<init>	(Ljava/io/InputStream;)V
    //   14: astore 9
    //   16: aload_0
    //   17: getfield 47	com/tencent/moai/mailsdk/protocol/datasource/FileDataSource:tempFile	Ljava/io/File;
    //   20: invokevirtual 67	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   23: invokestatic 73	com/tencent/moai/mailsdk/util/FileUtility:createFile	(Ljava/lang/String;)Z
    //   26: pop
    //   27: new 75	com/tencent/moai/mailsdk/util/stream/LineOutputStream
    //   30: dup
    //   31: aload_0
    //   32: getfield 47	com/tencent/moai/mailsdk/protocol/datasource/FileDataSource:tempFile	Ljava/io/File;
    //   35: invokestatic 79	com/tencent/moai/mailsdk/util/FileUtility:getFileOutputStream	(Ljava/io/File;)Ljava/io/OutputStream;
    //   38: invokespecial 82	com/tencent/moai/mailsdk/util/stream/LineOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   41: astore 6
    //   43: aload 9
    //   45: invokevirtual 85	com/tencent/moai/mailsdk/util/stream/LineInputStream:readLine	()Ljava/lang/String;
    //   48: astore_1
    //   49: aload_1
    //   50: astore_3
    //   51: aload_1
    //   52: ifnull +22 -> 74
    //   55: aload_1
    //   56: astore_3
    //   57: aload_2
    //   58: ifnull +16 -> 74
    //   61: aload_2
    //   62: aload_1
    //   63: invokevirtual 89	java/lang/String:length	()I
    //   66: i2l
    //   67: invokeinterface 95 3 0
    //   72: aload_1
    //   73: astore_3
    //   74: aload_3
    //   75: ifnull +144 -> 219
    //   78: aload_3
    //   79: aload_0
    //   80: getfield 30	com/tencent/moai/mailsdk/protocol/datasource/FileDataSource:boundary	Ljava/lang/String;
    //   83: invokevirtual 98	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   86: ifne +133 -> 219
    //   89: aload_3
    //   90: aload_0
    //   91: getfield 33	com/tencent/moai/mailsdk/protocol/datasource/FileDataSource:boundaryEnd	Ljava/lang/String;
    //   94: invokevirtual 98	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   97: ifne +122 -> 219
    //   100: aload 6
    //   102: aload_3
    //   103: invokevirtual 102	com/tencent/moai/mailsdk/util/stream/LineOutputStream:writeln	(Ljava/lang/String;)V
    //   106: aload 9
    //   108: invokevirtual 85	com/tencent/moai/mailsdk/util/stream/LineInputStream:readLine	()Ljava/lang/String;
    //   111: astore_1
    //   112: aload_1
    //   113: astore_3
    //   114: aload_1
    //   115: ifnull -41 -> 74
    //   118: aload_1
    //   119: astore_3
    //   120: aload_2
    //   121: ifnull -47 -> 74
    //   124: aload_2
    //   125: aload_1
    //   126: invokevirtual 89	java/lang/String:length	()I
    //   129: i2l
    //   130: invokeinterface 95 3 0
    //   135: aload_1
    //   136: astore_3
    //   137: goto -63 -> 74
    //   140: astore_2
    //   141: aconst_null
    //   142: astore_1
    //   143: aload 6
    //   145: astore 4
    //   147: aload 7
    //   149: astore_3
    //   150: aload_0
    //   151: getfield 47	com/tencent/moai/mailsdk/protocol/datasource/FileDataSource:tempFile	Ljava/io/File;
    //   154: invokevirtual 67	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   157: invokestatic 105	com/tencent/moai/mailsdk/util/FileUtility:deleteFile	(Ljava/lang/String;)Z
    //   160: pop
    //   161: aload_0
    //   162: getfield 37	com/tencent/moai/mailsdk/protocol/datasource/FileDataSource:file	Ljava/io/File;
    //   165: invokevirtual 67	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   168: invokestatic 105	com/tencent/moai/mailsdk/util/FileUtility:deleteFile	(Ljava/lang/String;)Z
    //   171: pop
    //   172: new 55	com/tencent/moai/mailsdk/exception/MessageException
    //   175: dup
    //   176: iconst_3
    //   177: ldc 107
    //   179: aload_2
    //   180: invokespecial 110	com/tencent/moai/mailsdk/exception/MessageException:<init>	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   183: athrow
    //   184: astore 6
    //   186: aload_1
    //   187: astore_2
    //   188: aload 6
    //   190: astore_1
    //   191: aload_2
    //   192: ifnull +7 -> 199
    //   195: aload_2
    //   196: invokevirtual 115	java/io/InputStream:close	()V
    //   199: aload_3
    //   200: ifnull +7 -> 207
    //   203: aload_3
    //   204: invokevirtual 118	java/io/OutputStream:close	()V
    //   207: aload 4
    //   209: ifnull +8 -> 217
    //   212: aload 4
    //   214: invokevirtual 119	com/tencent/moai/mailsdk/util/stream/LineOutputStream:close	()V
    //   217: aload_1
    //   218: athrow
    //   219: aload 6
    //   221: invokevirtual 122	com/tencent/moai/mailsdk/util/stream/LineOutputStream:flush	()V
    //   224: aload_0
    //   225: getfield 37	com/tencent/moai/mailsdk/protocol/datasource/FileDataSource:file	Ljava/io/File;
    //   228: invokevirtual 67	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   231: invokestatic 73	com/tencent/moai/mailsdk/util/FileUtility:createFile	(Ljava/lang/String;)Z
    //   234: pop
    //   235: aload_0
    //   236: getfield 37	com/tencent/moai/mailsdk/protocol/datasource/FileDataSource:file	Ljava/io/File;
    //   239: invokestatic 79	com/tencent/moai/mailsdk/util/FileUtility:getFileOutputStream	(Ljava/io/File;)Ljava/io/OutputStream;
    //   242: astore_1
    //   243: aload_0
    //   244: getfield 47	com/tencent/moai/mailsdk/protocol/datasource/FileDataSource:tempFile	Ljava/io/File;
    //   247: invokestatic 126	com/tencent/moai/mailsdk/util/FileUtility:getFileInputStream	(Ljava/io/File;)Ljava/io/InputStream;
    //   250: aload 4
    //   252: invokestatic 132	com/tencent/moai/mailsdk/util/MimeUtility:decode	(Ljava/io/InputStream;Ljava/lang/String;)Ljava/io/InputStream;
    //   255: astore_2
    //   256: sipush 8192
    //   259: newarray byte
    //   261: astore 4
    //   263: aload_2
    //   264: aload 4
    //   266: invokevirtual 135	java/io/InputStream:read	([B)I
    //   269: istore 5
    //   271: iload 5
    //   273: iconst_m1
    //   274: if_icmpeq +15 -> 289
    //   277: aload_1
    //   278: aload 4
    //   280: iconst_0
    //   281: iload 5
    //   283: invokevirtual 139	java/io/OutputStream:write	([BII)V
    //   286: goto -23 -> 263
    //   289: aload_1
    //   290: invokevirtual 140	java/io/OutputStream:flush	()V
    //   293: aload_0
    //   294: getfield 47	com/tencent/moai/mailsdk/protocol/datasource/FileDataSource:tempFile	Ljava/io/File;
    //   297: invokevirtual 67	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   300: invokestatic 105	com/tencent/moai/mailsdk/util/FileUtility:deleteFile	(Ljava/lang/String;)Z
    //   303: pop
    //   304: aload_2
    //   305: ifnull +7 -> 312
    //   308: aload_2
    //   309: invokevirtual 115	java/io/InputStream:close	()V
    //   312: aload_1
    //   313: ifnull +7 -> 320
    //   316: aload_1
    //   317: invokevirtual 118	java/io/OutputStream:close	()V
    //   320: aload 6
    //   322: ifnull +8 -> 330
    //   325: aload 6
    //   327: invokevirtual 119	com/tencent/moai/mailsdk/util/stream/LineOutputStream:close	()V
    //   330: aload_3
    //   331: areturn
    //   332: astore_2
    //   333: goto -116 -> 217
    //   336: astore_1
    //   337: aconst_null
    //   338: astore_2
    //   339: aconst_null
    //   340: astore 4
    //   342: aload 8
    //   344: astore_3
    //   345: goto -154 -> 191
    //   348: astore_1
    //   349: aconst_null
    //   350: astore_2
    //   351: aload 8
    //   353: astore_3
    //   354: aload 6
    //   356: astore 4
    //   358: goto -167 -> 191
    //   361: astore 4
    //   363: aconst_null
    //   364: astore_2
    //   365: aload_1
    //   366: astore_3
    //   367: aload 4
    //   369: astore_1
    //   370: aload 6
    //   372: astore 4
    //   374: goto -183 -> 191
    //   377: astore 4
    //   379: aload_1
    //   380: astore_3
    //   381: aload 4
    //   383: astore_1
    //   384: aload 6
    //   386: astore 4
    //   388: goto -197 -> 191
    //   391: astore 6
    //   393: goto -221 -> 172
    //   396: astore 6
    //   398: goto -237 -> 161
    //   401: astore_2
    //   402: aconst_null
    //   403: astore_1
    //   404: aconst_null
    //   405: astore 4
    //   407: aload 7
    //   409: astore_3
    //   410: goto -260 -> 150
    //   413: astore_2
    //   414: aconst_null
    //   415: astore 4
    //   417: aload_1
    //   418: astore_3
    //   419: aload 4
    //   421: astore_1
    //   422: aload 6
    //   424: astore 4
    //   426: goto -276 -> 150
    //   429: astore_1
    //   430: aload_3
    //   431: areturn
    //   432: astore_3
    //   433: aload_2
    //   434: astore 4
    //   436: aload_3
    //   437: astore_2
    //   438: aload_1
    //   439: astore_3
    //   440: aload 4
    //   442: astore_1
    //   443: aload 6
    //   445: astore 4
    //   447: goto -297 -> 150
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	450	0	this	FileDataSource
    //   0	450	1	paramInputStream	InputStream
    //   0	450	2	paramDataListener	DataListener
    //   0	450	3	paramString1	String
    //   0	450	4	paramString2	String
    //   269	13	5	i	int
    //   41	103	6	localLineOutputStream	com.tencent.moai.mailsdk.util.stream.LineOutputStream
    //   184	201	6	localObject1	Object
    //   391	1	6	localException1	java.lang.Exception
    //   396	48	6	localException2	java.lang.Exception
    //   4	404	7	localObject2	Object
    //   1	351	8	localObject3	Object
    //   14	93	9	localLineInputStream	com.tencent.moai.mailsdk.util.stream.LineInputStream
    // Exception table:
    //   from	to	target	type
    //   43	49	140	java/io/IOException
    //   61	72	140	java/io/IOException
    //   78	112	140	java/io/IOException
    //   124	135	140	java/io/IOException
    //   219	243	140	java/io/IOException
    //   150	161	184	finally
    //   161	172	184	finally
    //   172	184	184	finally
    //   195	199	332	java/io/IOException
    //   203	207	332	java/io/IOException
    //   212	217	332	java/io/IOException
    //   16	43	336	finally
    //   43	49	348	finally
    //   61	72	348	finally
    //   78	112	348	finally
    //   124	135	348	finally
    //   219	243	348	finally
    //   243	256	361	finally
    //   256	263	377	finally
    //   263	271	377	finally
    //   277	286	377	finally
    //   289	304	377	finally
    //   161	172	391	java/lang/Exception
    //   150	161	396	java/lang/Exception
    //   16	43	401	java/io/IOException
    //   243	256	413	java/io/IOException
    //   308	312	429	java/io/IOException
    //   316	320	429	java/io/IOException
    //   325	330	429	java/io/IOException
    //   256	263	432	java/io/IOException
    //   263	271	432	java/io/IOException
    //   277	286	432	java/io/IOException
    //   289	304	432	java/io/IOException
  }
  
  public void setBoundary(String paramString)
  {
    this.boundary = paramString;
  }
  
  public void setBoundaryEnd(String paramString)
  {
    this.boundaryEnd = paramString;
  }
  
  public void setFile(File paramFile)
  {
    this.file = paramFile;
  }
  
  public void setTempFile(File paramFile)
  {
    this.tempFile = paramFile;
  }
  
  public void setType(int paramInt)
  {
    this.type = paramInt;
  }
  
  public void write(OutputStream paramOutputStream, DataListener paramDataListener, String paramString1, String paramString2)
    throws MessageException
  {
    Object localObject = null;
    localInputStream2 = null;
    localInputStream1 = localInputStream2;
    paramString1 = localObject;
    try
    {
      FileUtility.createFile(this.file.getAbsolutePath());
      localInputStream1 = localInputStream2;
      paramString1 = localObject;
      localInputStream2 = FileUtility.getFileInputStream(this.file);
      localInputStream1 = localInputStream2;
      paramString1 = localInputStream2;
      paramOutputStream = MimeUtility.encode(paramOutputStream, paramString2);
      localInputStream1 = localInputStream2;
      paramString1 = localInputStream2;
      paramString2 = new byte[8192];
      for (;;)
      {
        localInputStream1 = localInputStream2;
        paramString1 = localInputStream2;
        int i = localInputStream2.read(paramString2);
        if (i <= 0) {
          break;
        }
        localInputStream1 = localInputStream2;
        paramString1 = localInputStream2;
        paramOutputStream.write(paramString2, 0, i);
        if (paramDataListener != null)
        {
          localInputStream1 = localInputStream2;
          paramString1 = localInputStream2;
          paramDataListener.onDataChange(i);
        }
      }
      try
      {
        paramString1.close();
        throw paramOutputStream;
        localInputStream1 = localInputStream2;
        paramString1 = localInputStream2;
        paramOutputStream.flush();
        if (localInputStream2 != null) {}
        try
        {
          localInputStream2.close();
          return;
        }
        catch (IOException paramOutputStream) {}
      }
      catch (IOException paramDataListener)
      {
        break label153;
      }
    }
    catch (IOException paramOutputStream)
    {
      paramString1 = localInputStream1;
      throw new MessageException(3, "file data source write io", paramOutputStream);
    }
    finally
    {
      if (paramString1 == null) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.datasource.FileDataSource
 * JD-Core Version:    0.7.0.1
 */