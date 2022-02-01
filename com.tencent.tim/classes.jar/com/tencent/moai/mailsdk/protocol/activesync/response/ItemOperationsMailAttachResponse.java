package com.tencent.moai.mailsdk.protocol.activesync.response;

import com.tencent.moai.mailsdk.callback.AttachmentCallBack;
import com.tencent.moai.mailsdk.net.http.HttpResponse;
import com.tencent.moai.mailsdk.protocol.activesync.Status.CommonStatus;
import com.tencent.moai.mailsdk.protocol.activesync.Status.ItemOperationStatus;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ItemOperationsMailAttachResponse
  extends ActiveSyncResponse
{
  private long attachSize;
  private AttachmentCallBack attachmentCallBack;
  private CommonStatus commonStatus;
  private String contentType;
  private String fid;
  private ItemOperationStatus itemOperationStatus;
  private String path;
  
  public ItemOperationsMailAttachResponse(String paramString1, String paramString2, HttpResponse paramHttpResponse)
  {
    super(paramString1, paramString2, paramHttpResponse);
  }
  
  private boolean isMultipart(HttpResponse paramHttpResponse)
  {
    paramHttpResponse = (List)paramHttpResponse.getHeader().get("Content-Type");
    if (paramHttpResponse == null) {
      return false;
    }
    paramHttpResponse = paramHttpResponse.iterator();
    while (paramHttpResponse.hasNext())
    {
      String str = (String)paramHttpResponse.next();
      if ((str != null) && (str.contains("multipart"))) {
        return true;
      }
    }
    return false;
  }
  
  private boolean parseAttachmentMultipartResponse()
  {
    return true;
  }
  
  /* Error */
  private boolean parseAttachmentResponse()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 40	com/tencent/moai/mailsdk/protocol/activesync/response/ItemOperationsMailAttachResponse:fid	Ljava/lang/String;
    //   4: invokestatic 93	com/tencent/moai/mailsdk/util/FileUtility:generateExchangeTmpFilePath	(Ljava/lang/String;)Ljava/lang/String;
    //   7: astore_3
    //   8: aload_0
    //   9: getfield 40	com/tencent/moai/mailsdk/protocol/activesync/response/ItemOperationsMailAttachResponse:fid	Ljava/lang/String;
    //   12: invokestatic 96	com/tencent/moai/mailsdk/util/FileUtility:generateExchangeXmlFilePath	(Ljava/lang/String;)Ljava/lang/String;
    //   15: astore 4
    //   17: new 98	java/util/ArrayList
    //   20: dup
    //   21: invokespecial 101	java/util/ArrayList:<init>	()V
    //   24: astore 5
    //   26: aload 4
    //   28: aload 5
    //   30: aload_0
    //   31: getfield 105	com/tencent/moai/mailsdk/protocol/activesync/response/ItemOperationsMailAttachResponse:httpResponse	Lcom/tencent/moai/mailsdk/net/http/HttpResponse;
    //   34: invokevirtual 109	com/tencent/moai/mailsdk/net/http/HttpResponse:getResponseInputStream	()Ljava/io/InputStream;
    //   37: new 111	com/tencent/moai/mailsdk/protocol/activesync/response/ItemOperationsMailAttachResponse$1
    //   40: dup
    //   41: aload_0
    //   42: invokespecial 114	com/tencent/moai/mailsdk/protocol/activesync/response/ItemOperationsMailAttachResponse$1:<init>	(Lcom/tencent/moai/mailsdk/protocol/activesync/response/ItemOperationsMailAttachResponse;)V
    //   45: invokestatic 118	com/tencent/moai/mailsdk/util/FileUtility:writeFile	(Ljava/lang/String;Ljava/util/ArrayList;Ljava/io/InputStream;Lcom/tencent/moai/mailsdk/callback/AttachmentCallBack;)V
    //   48: new 120	java/io/ByteArrayOutputStream
    //   51: dup
    //   52: invokespecial 121	java/io/ByteArrayOutputStream:<init>	()V
    //   55: astore 6
    //   57: new 120	java/io/ByteArrayOutputStream
    //   60: dup
    //   61: invokespecial 121	java/io/ByteArrayOutputStream:<init>	()V
    //   64: astore 7
    //   66: new 120	java/io/ByteArrayOutputStream
    //   69: dup
    //   70: invokespecial 121	java/io/ByteArrayOutputStream:<init>	()V
    //   73: astore 8
    //   75: new 120	java/io/ByteArrayOutputStream
    //   78: dup
    //   79: invokespecial 121	java/io/ByteArrayOutputStream:<init>	()V
    //   82: astore 9
    //   84: new 120	java/io/ByteArrayOutputStream
    //   87: dup
    //   88: invokespecial 121	java/io/ByteArrayOutputStream:<init>	()V
    //   91: astore 10
    //   93: new 123	java/io/File
    //   96: dup
    //   97: aload 4
    //   99: invokespecial 126	java/io/File:<init>	(Ljava/lang/String;)V
    //   102: invokestatic 130	com/tencent/moai/mailsdk/util/FileUtility:getFileInputStream	(Ljava/io/File;)Ljava/io/InputStream;
    //   105: astore 11
    //   107: new 123	java/io/File
    //   110: dup
    //   111: aload_3
    //   112: invokespecial 126	java/io/File:<init>	(Ljava/lang/String;)V
    //   115: invokestatic 134	com/tencent/moai/mailsdk/util/FileUtility:getFileOutputStream	(Ljava/io/File;)Ljava/io/OutputStream;
    //   118: astore 12
    //   120: aload 11
    //   122: aload 5
    //   124: new 136	com/tencent/moai/mailsdk/protocol/activesync/response/ItemOperationsMailAttachResponse$2
    //   127: dup
    //   128: aload_0
    //   129: new 6	com/tencent/moai/mailsdk/protocol/activesync/response/ItemOperationsMailAttachResponse$TagStack
    //   132: dup
    //   133: aload_0
    //   134: invokespecial 137	com/tencent/moai/mailsdk/protocol/activesync/response/ItemOperationsMailAttachResponse$TagStack:<init>	(Lcom/tencent/moai/mailsdk/protocol/activesync/response/ItemOperationsMailAttachResponse;)V
    //   137: aload 6
    //   139: aload 7
    //   141: aload 8
    //   143: aload 9
    //   145: aload 12
    //   147: iconst_1
    //   148: newarray long
    //   150: dup
    //   151: iconst_0
    //   152: lconst_0
    //   153: lastore
    //   154: aload 10
    //   156: invokespecial 140	com/tencent/moai/mailsdk/protocol/activesync/response/ItemOperationsMailAttachResponse$2:<init>	(Lcom/tencent/moai/mailsdk/protocol/activesync/response/ItemOperationsMailAttachResponse;Lcom/tencent/moai/mailsdk/protocol/activesync/response/ItemOperationsMailAttachResponse$TagStack;Ljava/io/ByteArrayOutputStream;Ljava/io/ByteArrayOutputStream;Ljava/io/ByteArrayOutputStream;Ljava/io/ByteArrayOutputStream;Ljava/io/OutputStream;[JLjava/io/ByteArrayOutputStream;)V
    //   159: invokestatic 146	com/tencent/moai/mailsdk/util/XmlDocumentHelper:stream2XmlDoc	(Ljava/io/InputStream;Ljava/util/ArrayList;Lcom/tencent/moai/mailsdk/util/aswbxml/ASWBXML$StreamHandler;)Lorg/w3c/dom/Document;
    //   162: pop
    //   163: aload_0
    //   164: getfield 28	com/tencent/moai/mailsdk/protocol/activesync/response/ItemOperationsMailAttachResponse:attachmentCallBack	Lcom/tencent/moai/mailsdk/callback/AttachmentCallBack;
    //   167: ifnull +23 -> 190
    //   170: aload_0
    //   171: getfield 28	com/tencent/moai/mailsdk/protocol/activesync/response/ItemOperationsMailAttachResponse:attachmentCallBack	Lcom/tencent/moai/mailsdk/callback/AttachmentCallBack;
    //   174: aload_0
    //   175: getfield 148	com/tencent/moai/mailsdk/protocol/activesync/response/ItemOperationsMailAttachResponse:attachSize	J
    //   178: l2d
    //   179: ldc2_w 149
    //   182: dmul
    //   183: d2l
    //   184: invokeinterface 156 3 0
    //   189: pop
    //   190: aload 6
    //   192: invokevirtual 159	java/io/ByteArrayOutputStream:close	()V
    //   195: aload 7
    //   197: invokevirtual 159	java/io/ByteArrayOutputStream:close	()V
    //   200: aload 8
    //   202: invokevirtual 159	java/io/ByteArrayOutputStream:close	()V
    //   205: aload 9
    //   207: invokevirtual 159	java/io/ByteArrayOutputStream:close	()V
    //   210: aload 10
    //   212: invokevirtual 159	java/io/ByteArrayOutputStream:close	()V
    //   215: aload 12
    //   217: invokevirtual 162	java/io/OutputStream:close	()V
    //   220: aload 11
    //   222: invokevirtual 165	java/io/InputStream:close	()V
    //   225: aload_0
    //   226: getfield 32	com/tencent/moai/mailsdk/protocol/activesync/response/ItemOperationsMailAttachResponse:commonStatus	Lcom/tencent/moai/mailsdk/protocol/activesync/Status/CommonStatus;
    //   229: astore 5
    //   231: aload 5
    //   233: ifnonnull +16 -> 249
    //   236: aload 4
    //   238: invokestatic 169	com/tencent/moai/mailsdk/util/FileUtility:deleteFile	(Ljava/lang/String;)Z
    //   241: pop
    //   242: aload_3
    //   243: invokestatic 169	com/tencent/moai/mailsdk/util/FileUtility:deleteFile	(Ljava/lang/String;)Z
    //   246: pop
    //   247: iconst_0
    //   248: ireturn
    //   249: aload_0
    //   250: getfield 32	com/tencent/moai/mailsdk/protocol/activesync/response/ItemOperationsMailAttachResponse:commonStatus	Lcom/tencent/moai/mailsdk/protocol/activesync/Status/CommonStatus;
    //   253: invokevirtual 174	com/tencent/moai/mailsdk/protocol/activesync/Status/CommonStatus:isStatusOk	()Z
    //   256: istore_2
    //   257: iload_2
    //   258: ifne +19 -> 277
    //   261: aload 4
    //   263: invokestatic 169	com/tencent/moai/mailsdk/util/FileUtility:deleteFile	(Ljava/lang/String;)Z
    //   266: pop
    //   267: aload_3
    //   268: invokestatic 169	com/tencent/moai/mailsdk/util/FileUtility:deleteFile	(Ljava/lang/String;)Z
    //   271: pop
    //   272: iconst_0
    //   273: ireturn
    //   274: astore_3
    //   275: iconst_0
    //   276: ireturn
    //   277: aload_0
    //   278: getfield 36	com/tencent/moai/mailsdk/protocol/activesync/response/ItemOperationsMailAttachResponse:itemOperationStatus	Lcom/tencent/moai/mailsdk/protocol/activesync/Status/ItemOperationStatus;
    //   281: astore 5
    //   283: aload 5
    //   285: ifnonnull +19 -> 304
    //   288: aload 4
    //   290: invokestatic 169	com/tencent/moai/mailsdk/util/FileUtility:deleteFile	(Ljava/lang/String;)Z
    //   293: pop
    //   294: aload_3
    //   295: invokestatic 169	com/tencent/moai/mailsdk/util/FileUtility:deleteFile	(Ljava/lang/String;)Z
    //   298: pop
    //   299: iconst_0
    //   300: ireturn
    //   301: astore_3
    //   302: iconst_0
    //   303: ireturn
    //   304: aload_0
    //   305: getfield 36	com/tencent/moai/mailsdk/protocol/activesync/response/ItemOperationsMailAttachResponse:itemOperationStatus	Lcom/tencent/moai/mailsdk/protocol/activesync/Status/ItemOperationStatus;
    //   308: invokevirtual 177	com/tencent/moai/mailsdk/protocol/activesync/Status/ItemOperationStatus:isStatusOk	()Z
    //   311: istore_2
    //   312: iload_2
    //   313: ifne +19 -> 332
    //   316: aload 4
    //   318: invokestatic 169	com/tencent/moai/mailsdk/util/FileUtility:deleteFile	(Ljava/lang/String;)Z
    //   321: pop
    //   322: aload_3
    //   323: invokestatic 169	com/tencent/moai/mailsdk/util/FileUtility:deleteFile	(Ljava/lang/String;)Z
    //   326: pop
    //   327: iconst_0
    //   328: ireturn
    //   329: astore_3
    //   330: iconst_0
    //   331: ireturn
    //   332: aload_0
    //   333: getfield 40	com/tencent/moai/mailsdk/protocol/activesync/response/ItemOperationsMailAttachResponse:fid	Ljava/lang/String;
    //   336: astore 5
    //   338: aload 5
    //   340: ifnonnull +19 -> 359
    //   343: aload 4
    //   345: invokestatic 169	com/tencent/moai/mailsdk/util/FileUtility:deleteFile	(Ljava/lang/String;)Z
    //   348: pop
    //   349: aload_3
    //   350: invokestatic 169	com/tencent/moai/mailsdk/util/FileUtility:deleteFile	(Ljava/lang/String;)Z
    //   353: pop
    //   354: iconst_0
    //   355: ireturn
    //   356: astore_3
    //   357: iconst_0
    //   358: ireturn
    //   359: sipush 1024
    //   362: newarray byte
    //   364: astore 5
    //   366: new 123	java/io/File
    //   369: dup
    //   370: aload_3
    //   371: invokespecial 126	java/io/File:<init>	(Ljava/lang/String;)V
    //   374: invokestatic 130	com/tencent/moai/mailsdk/util/FileUtility:getFileInputStream	(Ljava/io/File;)Ljava/io/InputStream;
    //   377: ldc 179
    //   379: invokestatic 185	com/tencent/moai/mailsdk/util/MimeUtility:decode	(Ljava/io/InputStream;Ljava/lang/String;)Ljava/io/InputStream;
    //   382: astore 6
    //   384: new 123	java/io/File
    //   387: dup
    //   388: aload_0
    //   389: getfield 187	com/tencent/moai/mailsdk/protocol/activesync/response/ItemOperationsMailAttachResponse:path	Ljava/lang/String;
    //   392: invokespecial 126	java/io/File:<init>	(Ljava/lang/String;)V
    //   395: invokestatic 134	com/tencent/moai/mailsdk/util/FileUtility:getFileOutputStream	(Ljava/io/File;)Ljava/io/OutputStream;
    //   398: astore 7
    //   400: aload 6
    //   402: aload 5
    //   404: invokevirtual 191	java/io/InputStream:read	([B)I
    //   407: istore_1
    //   408: iload_1
    //   409: ifle +45 -> 454
    //   412: aload 7
    //   414: aload 5
    //   416: iconst_0
    //   417: iload_1
    //   418: invokevirtual 195	java/io/OutputStream:write	([BII)V
    //   421: goto -21 -> 400
    //   424: astore 5
    //   426: bipush 6
    //   428: ldc 197
    //   430: aload 5
    //   432: invokestatic 203	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   435: invokestatic 209	com/tencent/moai/mailsdk/util/log/Logger:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   438: aload 4
    //   440: invokestatic 169	com/tencent/moai/mailsdk/util/FileUtility:deleteFile	(Ljava/lang/String;)Z
    //   443: pop
    //   444: aload_3
    //   445: invokestatic 169	com/tencent/moai/mailsdk/util/FileUtility:deleteFile	(Ljava/lang/String;)Z
    //   448: pop
    //   449: iconst_0
    //   450: ireturn
    //   451: astore_3
    //   452: iconst_0
    //   453: ireturn
    //   454: aload_0
    //   455: getfield 28	com/tencent/moai/mailsdk/protocol/activesync/response/ItemOperationsMailAttachResponse:attachmentCallBack	Lcom/tencent/moai/mailsdk/callback/AttachmentCallBack;
    //   458: ifnull +17 -> 475
    //   461: aload_0
    //   462: getfield 28	com/tencent/moai/mailsdk/protocol/activesync/response/ItemOperationsMailAttachResponse:attachmentCallBack	Lcom/tencent/moai/mailsdk/callback/AttachmentCallBack;
    //   465: aload_0
    //   466: getfield 148	com/tencent/moai/mailsdk/protocol/activesync/response/ItemOperationsMailAttachResponse:attachSize	J
    //   469: invokeinterface 156 3 0
    //   474: pop
    //   475: aload 7
    //   477: invokevirtual 212	java/io/OutputStream:flush	()V
    //   480: aload 7
    //   482: invokevirtual 162	java/io/OutputStream:close	()V
    //   485: aload 6
    //   487: invokevirtual 165	java/io/InputStream:close	()V
    //   490: aload 4
    //   492: invokestatic 169	com/tencent/moai/mailsdk/util/FileUtility:deleteFile	(Ljava/lang/String;)Z
    //   495: pop
    //   496: aload_3
    //   497: invokestatic 169	com/tencent/moai/mailsdk/util/FileUtility:deleteFile	(Ljava/lang/String;)Z
    //   500: pop
    //   501: iconst_1
    //   502: ireturn
    //   503: astore 5
    //   505: aload 4
    //   507: invokestatic 169	com/tencent/moai/mailsdk/util/FileUtility:deleteFile	(Ljava/lang/String;)Z
    //   510: pop
    //   511: aload_3
    //   512: invokestatic 169	com/tencent/moai/mailsdk/util/FileUtility:deleteFile	(Ljava/lang/String;)Z
    //   515: pop
    //   516: aload 5
    //   518: athrow
    //   519: astore 4
    //   521: goto -279 -> 242
    //   524: astore_3
    //   525: iconst_0
    //   526: ireturn
    //   527: astore 4
    //   529: goto -262 -> 267
    //   532: astore 4
    //   534: goto -240 -> 294
    //   537: astore 4
    //   539: goto -217 -> 322
    //   542: astore 4
    //   544: goto -195 -> 349
    //   547: astore 4
    //   549: goto -53 -> 496
    //   552: astore_3
    //   553: goto -52 -> 501
    //   556: astore 4
    //   558: goto -114 -> 444
    //   561: astore 4
    //   563: goto -52 -> 511
    //   566: astore_3
    //   567: goto -51 -> 516
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	570	0	this	ItemOperationsMailAttachResponse
    //   407	11	1	i	int
    //   256	57	2	bool	boolean
    //   7	261	3	str1	String
    //   274	21	3	localIOException1	java.io.IOException
    //   301	22	3	localIOException2	java.io.IOException
    //   329	21	3	localIOException3	java.io.IOException
    //   356	89	3	localIOException4	java.io.IOException
    //   451	61	3	localIOException5	java.io.IOException
    //   524	1	3	localIOException6	java.io.IOException
    //   552	1	3	localIOException7	java.io.IOException
    //   566	1	3	localIOException8	java.io.IOException
    //   15	491	4	str2	String
    //   519	1	4	localIOException9	java.io.IOException
    //   527	1	4	localIOException10	java.io.IOException
    //   532	1	4	localIOException11	java.io.IOException
    //   537	1	4	localIOException12	java.io.IOException
    //   542	1	4	localIOException13	java.io.IOException
    //   547	1	4	localIOException14	java.io.IOException
    //   556	1	4	localIOException15	java.io.IOException
    //   561	1	4	localIOException16	java.io.IOException
    //   24	391	5	localObject1	Object
    //   424	7	5	localIOException17	java.io.IOException
    //   503	14	5	localObject2	Object
    //   55	431	6	localObject3	Object
    //   64	417	7	localObject4	Object
    //   73	128	8	localByteArrayOutputStream1	java.io.ByteArrayOutputStream
    //   82	124	9	localByteArrayOutputStream2	java.io.ByteArrayOutputStream
    //   91	120	10	localByteArrayOutputStream3	java.io.ByteArrayOutputStream
    //   105	116	11	localInputStream	java.io.InputStream
    //   118	98	12	localOutputStream	java.io.OutputStream
    // Exception table:
    //   from	to	target	type
    //   267	272	274	java/io/IOException
    //   294	299	301	java/io/IOException
    //   322	327	329	java/io/IOException
    //   349	354	356	java/io/IOException
    //   26	190	424	java/io/IOException
    //   190	231	424	java/io/IOException
    //   249	257	424	java/io/IOException
    //   277	283	424	java/io/IOException
    //   304	312	424	java/io/IOException
    //   332	338	424	java/io/IOException
    //   359	400	424	java/io/IOException
    //   400	408	424	java/io/IOException
    //   412	421	424	java/io/IOException
    //   454	475	424	java/io/IOException
    //   475	490	424	java/io/IOException
    //   444	449	451	java/io/IOException
    //   26	190	503	finally
    //   190	231	503	finally
    //   249	257	503	finally
    //   277	283	503	finally
    //   304	312	503	finally
    //   332	338	503	finally
    //   359	400	503	finally
    //   400	408	503	finally
    //   412	421	503	finally
    //   426	438	503	finally
    //   454	475	503	finally
    //   475	490	503	finally
    //   236	242	519	java/io/IOException
    //   242	247	524	java/io/IOException
    //   261	267	527	java/io/IOException
    //   288	294	532	java/io/IOException
    //   316	322	537	java/io/IOException
    //   343	349	542	java/io/IOException
    //   490	496	547	java/io/IOException
    //   496	501	552	java/io/IOException
    //   438	444	556	java/io/IOException
    //   505	511	561	java/io/IOException
    //   511	516	566	java/io/IOException
  }
  
  public AttachmentCallBack getAttachmentCallBack()
  {
    return this.attachmentCallBack;
  }
  
  public CommonStatus getCommonStatus()
  {
    return this.commonStatus;
  }
  
  public String getContentType()
  {
    return this.contentType;
  }
  
  public int getErrorCode()
  {
    if (this.itemOperationStatus != null) {
      return this.itemOperationStatus.getStatus();
    }
    if (this.commonStatus != null) {
      return this.commonStatus.getStatus();
    }
    return super.getErrorCode();
  }
  
  public String getErrorMsg()
  {
    if (this.itemOperationStatus != null) {
      return this.itemOperationStatus.getStatusMsg();
    }
    if (this.commonStatus != null) {
      return this.commonStatus.getStatusMsg();
    }
    return super.getErrorMsg();
  }
  
  public String getFid()
  {
    return this.fid;
  }
  
  public ItemOperationStatus getItemOperationStatus()
  {
    return this.itemOperationStatus;
  }
  
  public String getPath()
  {
    return this.path;
  }
  
  public boolean isOk()
  {
    if (this.itemOperationStatus != null) {
      return this.itemOperationStatus.isStatusOk();
    }
    if (this.commonStatus != null) {
      return this.commonStatus.isStatusOk();
    }
    return super.isOk();
  }
  
  public boolean parseResponse()
  {
    if (this.httpResponse == null) {}
    while ((!this.httpResponse.isOk()) || (this.httpResponse.getResponseInputStream() == null)) {
      return false;
    }
    if (isMultipart(this.httpResponse)) {
      return parseAttachmentMultipartResponse();
    }
    return parseAttachmentResponse();
  }
  
  public void setAttachSize(long paramLong)
  {
    this.attachSize = paramLong;
  }
  
  public void setAttachmentCallBack(AttachmentCallBack paramAttachmentCallBack)
  {
    this.attachmentCallBack = paramAttachmentCallBack;
  }
  
  public void setCommonStatus(CommonStatus paramCommonStatus)
  {
    this.commonStatus = paramCommonStatus;
  }
  
  public void setContentType(String paramString)
  {
    this.contentType = paramString;
  }
  
  public void setFid(String paramString)
  {
    this.fid = paramString;
  }
  
  public void setItemOperationStatus(ItemOperationStatus paramItemOperationStatus)
  {
    this.itemOperationStatus = paramItemOperationStatus;
  }
  
  public void setPath(String paramString)
  {
    this.path = paramString;
  }
  
  class TagStack
  {
    private String currentTag = "";
    private ArrayList<String> tagList = new ArrayList();
    
    public TagStack() {}
    
    private void currentTag()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int i = 0;
      if (i < this.tagList.size())
      {
        if (i == this.tagList.size() - 1) {
          localStringBuilder.append((String)this.tagList.get(i));
        }
        for (;;)
        {
          i += 1;
          break;
          localStringBuilder.append((String)this.tagList.get(i) + "-");
        }
      }
      this.currentTag = localStringBuilder.toString();
    }
    
    public String getCurrentTag()
    {
      return this.currentTag;
    }
    
    public String pop()
    {
      String str = (String)this.tagList.remove(this.tagList.size() - 1);
      currentTag();
      return str;
    }
    
    public void push(String paramString)
    {
      this.tagList.add(paramString);
      currentTag();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.activesync.response.ItemOperationsMailAttachResponse
 * JD-Core Version:    0.7.0.1
 */