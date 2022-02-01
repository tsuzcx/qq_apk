package com.tencent.moai.mailsdk.protocol.exchange.response;

import com.tencent.moai.mailsdk.callback.AttachmentCallBack;
import java.io.IOException;
import java.io.OutputStream;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

class GetAttachmentResponse$1
  extends DefaultHandler
{
  private String currentElement;
  
  GetAttachmentResponse$1(GetAttachmentResponse paramGetAttachmentResponse, String paramString, byte[] paramArrayOfByte, OutputStream paramOutputStream, long[] paramArrayOfLong) {}
  
  public void characters(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws SAXException
  {
    if ("Content".equalsIgnoreCase(this.currentElement))
    {
      int i = paramInt2;
      while (i > 0)
      {
        int j = paramInt1 + i;
        if (30720 < i) {
          j = paramInt1 + 30720;
        }
        int m = paramInt1;
        int k = 0;
        for (;;)
        {
          if (m < j) {}
          try
          {
            this.val$buffer[k] = ((byte)paramArrayOfChar[m]);
            m += 1;
            k += 1;
          }
          catch (IOException paramArrayOfChar)
          {
            throw new SAXException(paramArrayOfChar);
          }
        }
        this.val$tmpFileOutputStream.write(this.val$buffer, 0, k);
        i -= k;
      }
      paramArrayOfChar = this.val$downloadBytes;
      paramArrayOfChar[0] += paramInt2;
      if (GetAttachmentResponse.access$100(this.this$0) != null) {
        GetAttachmentResponse.access$100(this.this$0).onProgress(this.val$downloadBytes[0] * 3L / 4L);
      }
    }
  }
  
  /* Error */
  public void endElement(String paramString1, String paramString2, String paramString3)
    throws SAXException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aconst_null
    //   3: astore 6
    //   5: aconst_null
    //   6: astore_3
    //   7: aconst_null
    //   8: astore 7
    //   10: ldc 39
    //   12: aload_2
    //   13: invokevirtual 47	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   16: ifeq +199 -> 215
    //   19: new 77	java/io/File
    //   22: dup
    //   23: aload_0
    //   24: getfield 19	com/tencent/moai/mailsdk/protocol/exchange/response/GetAttachmentResponse$1:this$0	Lcom/tencent/moai/mailsdk/protocol/exchange/response/GetAttachmentResponse;
    //   27: invokestatic 81	com/tencent/moai/mailsdk/protocol/exchange/response/GetAttachmentResponse:access$000	(Lcom/tencent/moai/mailsdk/protocol/exchange/response/GetAttachmentResponse;)Ljava/lang/String;
    //   30: invokespecial 84	java/io/File:<init>	(Ljava/lang/String;)V
    //   33: astore 8
    //   35: new 86	android/util/Base64InputStream
    //   38: dup
    //   39: new 77	java/io/File
    //   42: dup
    //   43: aload_0
    //   44: getfield 21	com/tencent/moai/mailsdk/protocol/exchange/response/GetAttachmentResponse$1:val$tmpPath	Ljava/lang/String;
    //   47: invokespecial 84	java/io/File:<init>	(Ljava/lang/String;)V
    //   50: invokestatic 92	com/tencent/moai/mailsdk/util/FileUtility:getFileInputStream	(Ljava/io/File;)Ljava/io/InputStream;
    //   53: iconst_4
    //   54: invokespecial 95	android/util/Base64InputStream:<init>	(Ljava/io/InputStream;I)V
    //   57: astore 5
    //   59: aload 7
    //   61: astore_3
    //   62: aload 5
    //   64: astore_2
    //   65: aload 6
    //   67: astore_1
    //   68: aload 8
    //   70: invokestatic 99	com/tencent/moai/mailsdk/util/FileUtility:getFileOutputStream	(Ljava/io/File;)Ljava/io/OutputStream;
    //   73: astore 6
    //   75: aload 6
    //   77: astore_3
    //   78: aload 5
    //   80: astore_2
    //   81: aload 6
    //   83: astore_1
    //   84: sipush 1024
    //   87: newarray byte
    //   89: astore 7
    //   91: aload 6
    //   93: astore_3
    //   94: aload 5
    //   96: astore_2
    //   97: aload 6
    //   99: astore_1
    //   100: aload 5
    //   102: aload 7
    //   104: invokevirtual 103	android/util/Base64InputStream:read	([B)I
    //   107: istore 4
    //   109: iload 4
    //   111: iconst_m1
    //   112: if_icmpeq +69 -> 181
    //   115: aload 6
    //   117: astore_3
    //   118: aload 5
    //   120: astore_2
    //   121: aload 6
    //   123: astore_1
    //   124: aload 6
    //   126: aload 7
    //   128: iconst_0
    //   129: iload 4
    //   131: invokevirtual 53	java/io/OutputStream:write	([BII)V
    //   134: goto -43 -> 91
    //   137: astore 6
    //   139: aload_3
    //   140: astore_1
    //   141: aload 5
    //   143: astore_2
    //   144: aload 6
    //   146: astore_3
    //   147: new 35	org/xml/sax/SAXException
    //   150: dup
    //   151: aload_3
    //   152: invokespecial 56	org/xml/sax/SAXException:<init>	(Ljava/lang/Exception;)V
    //   155: athrow
    //   156: astore 5
    //   158: aload_1
    //   159: astore_3
    //   160: aload 5
    //   162: astore_1
    //   163: aload_2
    //   164: ifnull +7 -> 171
    //   167: aload_2
    //   168: invokevirtual 106	android/util/Base64InputStream:close	()V
    //   171: aload_3
    //   172: ifnull +7 -> 179
    //   175: aload_3
    //   176: invokevirtual 107	java/io/OutputStream:close	()V
    //   179: aload_1
    //   180: athrow
    //   181: aload 6
    //   183: astore_3
    //   184: aload 5
    //   186: astore_2
    //   187: aload 6
    //   189: astore_1
    //   190: aload 6
    //   192: invokevirtual 110	java/io/OutputStream:flush	()V
    //   195: aload 5
    //   197: ifnull +8 -> 205
    //   200: aload 5
    //   202: invokevirtual 106	android/util/Base64InputStream:close	()V
    //   205: aload 6
    //   207: ifnull +8 -> 215
    //   210: aload 6
    //   212: invokevirtual 107	java/io/OutputStream:close	()V
    //   215: return
    //   216: astore_1
    //   217: goto -12 -> 205
    //   220: astore_1
    //   221: return
    //   222: astore_2
    //   223: goto -52 -> 171
    //   226: astore_2
    //   227: goto -48 -> 179
    //   230: astore_1
    //   231: aconst_null
    //   232: astore_2
    //   233: goto -70 -> 163
    //   236: astore_3
    //   237: aconst_null
    //   238: astore_2
    //   239: goto -92 -> 147
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	242	0	this	1
    //   0	242	1	paramString1	String
    //   0	242	2	paramString2	String
    //   0	242	3	paramString3	String
    //   107	23	4	i	int
    //   57	85	5	localBase64InputStream	android.util.Base64InputStream
    //   156	45	5	localObject	java.lang.Object
    //   3	122	6	localOutputStream	OutputStream
    //   137	74	6	localIOException	IOException
    //   8	119	7	arrayOfByte	byte[]
    //   33	36	8	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   68	75	137	java/io/IOException
    //   84	91	137	java/io/IOException
    //   100	109	137	java/io/IOException
    //   124	134	137	java/io/IOException
    //   190	195	137	java/io/IOException
    //   68	75	156	finally
    //   84	91	156	finally
    //   100	109	156	finally
    //   124	134	156	finally
    //   147	156	156	finally
    //   190	195	156	finally
    //   200	205	216	java/io/IOException
    //   210	215	220	java/io/IOException
    //   167	171	222	java/io/IOException
    //   175	179	226	java/io/IOException
    //   35	59	230	finally
    //   35	59	236	java/io/IOException
  }
  
  public void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
    throws SAXException
  {
    this.currentElement = paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.exchange.response.GetAttachmentResponse.1
 * JD-Core Version:    0.7.0.1
 */