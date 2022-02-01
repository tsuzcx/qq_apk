package com.tencent.moai.mailsdk.protocol.exchange.response;

import com.tencent.moai.mailsdk.callback.AttachmentCallBack;
import com.tencent.moai.mailsdk.net.http.HttpResponse;

public class GetAttachmentResponse
  extends ExchangeResponse
{
  private AttachmentCallBack attachmentCallBack;
  private String fid;
  private String path;
  
  public GetAttachmentResponse(String paramString, HttpResponse paramHttpResponse)
  {
    super(paramString, paramHttpResponse);
  }
  
  /* Error */
  private boolean parseSAX()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 32	com/tencent/moai/mailsdk/protocol/exchange/response/GetAttachmentResponse:fid	Ljava/lang/String;
    //   4: invokestatic 38	com/tencent/moai/mailsdk/util/FileUtility:generateExchangeTmpFilePath	(Ljava/lang/String;)Ljava/lang/String;
    //   7: astore_1
    //   8: new 40	java/io/File
    //   11: dup
    //   12: aload_1
    //   13: invokespecial 43	java/io/File:<init>	(Ljava/lang/String;)V
    //   16: invokestatic 47	com/tencent/moai/mailsdk/util/FileUtility:getFileOutputStream	(Ljava/io/File;)Ljava/io/OutputStream;
    //   19: astore_2
    //   20: sipush 30720
    //   23: newarray byte
    //   25: astore_3
    //   26: invokestatic 53	javax/xml/parsers/SAXParserFactory:newInstance	()Ljavax/xml/parsers/SAXParserFactory;
    //   29: invokevirtual 57	javax/xml/parsers/SAXParserFactory:newSAXParser	()Ljavax/xml/parsers/SAXParser;
    //   32: aload_0
    //   33: getfield 61	com/tencent/moai/mailsdk/protocol/exchange/response/GetAttachmentResponse:httpResponse	Lcom/tencent/moai/mailsdk/net/http/HttpResponse;
    //   36: invokevirtual 67	com/tencent/moai/mailsdk/net/http/HttpResponse:getResponseInputStream	()Ljava/io/InputStream;
    //   39: new 69	com/tencent/moai/mailsdk/protocol/exchange/response/GetAttachmentResponse$1
    //   42: dup
    //   43: aload_0
    //   44: aload_1
    //   45: aload_3
    //   46: aload_2
    //   47: iconst_1
    //   48: newarray long
    //   50: dup
    //   51: iconst_0
    //   52: lconst_0
    //   53: lastore
    //   54: invokespecial 72	com/tencent/moai/mailsdk/protocol/exchange/response/GetAttachmentResponse$1:<init>	(Lcom/tencent/moai/mailsdk/protocol/exchange/response/GetAttachmentResponse;Ljava/lang/String;[BLjava/io/OutputStream;[J)V
    //   57: invokevirtual 78	javax/xml/parsers/SAXParser:parse	(Ljava/io/InputStream;Lorg/xml/sax/helpers/DefaultHandler;)V
    //   60: aload_2
    //   61: invokevirtual 84	java/io/OutputStream:close	()V
    //   64: aload_0
    //   65: ldc 86
    //   67: putfield 89	com/tencent/moai/mailsdk/protocol/exchange/response/GetAttachmentResponse:responseCode	Ljava/lang/String;
    //   70: aload_1
    //   71: invokestatic 93	com/tencent/moai/mailsdk/util/FileUtility:deleteFile	(Ljava/lang/String;)Z
    //   74: pop
    //   75: iconst_1
    //   76: ireturn
    //   77: astore_2
    //   78: aload_2
    //   79: invokevirtual 96	java/io/IOException:printStackTrace	()V
    //   82: aload_1
    //   83: invokestatic 93	com/tencent/moai/mailsdk/util/FileUtility:deleteFile	(Ljava/lang/String;)Z
    //   86: pop
    //   87: iconst_0
    //   88: ireturn
    //   89: astore_2
    //   90: aload_2
    //   91: invokevirtual 97	javax/xml/parsers/ParserConfigurationException:printStackTrace	()V
    //   94: aload_1
    //   95: invokestatic 93	com/tencent/moai/mailsdk/util/FileUtility:deleteFile	(Ljava/lang/String;)Z
    //   98: pop
    //   99: iconst_0
    //   100: ireturn
    //   101: astore_2
    //   102: aload_2
    //   103: invokevirtual 98	org/xml/sax/SAXException:printStackTrace	()V
    //   106: aload_1
    //   107: invokestatic 93	com/tencent/moai/mailsdk/util/FileUtility:deleteFile	(Ljava/lang/String;)Z
    //   110: pop
    //   111: iconst_0
    //   112: ireturn
    //   113: astore_2
    //   114: aload_1
    //   115: invokestatic 93	com/tencent/moai/mailsdk/util/FileUtility:deleteFile	(Ljava/lang/String;)Z
    //   118: pop
    //   119: aload_2
    //   120: athrow
    //   121: astore_1
    //   122: goto -47 -> 75
    //   125: astore_1
    //   126: goto -39 -> 87
    //   129: astore_1
    //   130: goto -31 -> 99
    //   133: astore_1
    //   134: goto -23 -> 111
    //   137: astore_1
    //   138: goto -19 -> 119
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	141	0	this	GetAttachmentResponse
    //   7	108	1	str	String
    //   121	1	1	localIOException1	java.io.IOException
    //   125	1	1	localIOException2	java.io.IOException
    //   129	1	1	localIOException3	java.io.IOException
    //   133	1	1	localIOException4	java.io.IOException
    //   137	1	1	localIOException5	java.io.IOException
    //   19	42	2	localOutputStream	java.io.OutputStream
    //   77	2	2	localIOException6	java.io.IOException
    //   89	2	2	localParserConfigurationException	javax.xml.parsers.ParserConfigurationException
    //   101	2	2	localSAXException	org.xml.sax.SAXException
    //   113	7	2	localObject	java.lang.Object
    //   25	21	3	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   8	70	77	java/io/IOException
    //   8	70	89	javax/xml/parsers/ParserConfigurationException
    //   8	70	101	org/xml/sax/SAXException
    //   8	70	113	finally
    //   78	82	113	finally
    //   90	94	113	finally
    //   102	106	113	finally
    //   70	75	121	java/io/IOException
    //   82	87	125	java/io/IOException
    //   94	99	129	java/io/IOException
    //   106	111	133	java/io/IOException
    //   114	119	137	java/io/IOException
  }
  
  public AttachmentCallBack getAttachmentCallBack()
  {
    return this.attachmentCallBack;
  }
  
  public String getFid()
  {
    return this.fid;
  }
  
  public String getPath()
  {
    return this.path;
  }
  
  public boolean parseResponse()
  {
    if (this.httpResponse == null) {}
    while ((!this.httpResponse.isOk()) || (this.httpResponse.getResponseInputStream() == null)) {
      return false;
    }
    return parseSAX();
  }
  
  public void setAttachmentCallBack(AttachmentCallBack paramAttachmentCallBack)
  {
    this.attachmentCallBack = paramAttachmentCallBack;
  }
  
  public void setFid(String paramString)
  {
    this.fid = paramString;
  }
  
  public void setPath(String paramString)
  {
    this.path = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.exchange.response.GetAttachmentResponse
 * JD-Core Version:    0.7.0.1
 */