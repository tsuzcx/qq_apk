package com.tencent.moai.mailsdk.protocol.mime.model;

import com.tencent.moai.mailsdk.exception.MessageException;
import com.tencent.moai.mailsdk.protocol.mime.ContentType;
import com.tencent.moai.mailsdk.protocol.mime.DataListener;
import com.tencent.moai.mailsdk.protocol.mime.MimeDefine;
import com.tencent.moai.mailsdk.protocol.model.Header;
import com.tencent.moai.mailsdk.protocol.model.MultiPart;
import com.tencent.moai.mailsdk.protocol.model.Part;
import com.tencent.moai.mailsdk.util.StringUtility;
import com.tencent.moai.mailsdk.util.UinqueUtility;
import com.tencent.moai.mailsdk.util.stream.LineInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Vector;

public class MimeMultiPart
  extends MultiPart
{
  private static final String TAG = "MimeMultiPart";
  protected String boundary;
  protected String boundaryEnd;
  protected String preamble;
  
  public MimeMultiPart()
    throws MessageException
  {
    String str = UinqueUtility.getUniqueBoundaryValue();
    this.boundary = ("--" + str);
    this.boundaryEnd = (this.boundary + "--");
    ContentType localContentType = new ContentType(MimeDefine.MULTIPART_MIXED);
    localContentType.setParam(MimeDefine.BOUNDARY, str);
    setContentType(localContentType.toString());
  }
  
  public MimeMultiPart(String paramString)
    throws MessageException
  {
    String str = UinqueUtility.getUniqueBoundaryValue();
    this.boundary = ("--" + str);
    this.boundaryEnd = (this.boundary + "--");
    paramString = new ContentType(paramString);
    paramString.setParam(MimeDefine.BOUNDARY, str);
    setContentType(paramString.toString());
  }
  
  public void addHeader(String paramString1, String paramString2) {}
  
  public Header getHeader()
  {
    MimeHeader localMimeHeader = new MimeHeader();
    localMimeHeader.addHeader(MimeDefine.CONTENT_TYPE, getContentType());
    return localMimeHeader;
  }
  
  public String getHeader(String paramString)
  {
    return null;
  }
  
  public String getPreamble()
  {
    return this.preamble;
  }
  
  public long getSize()
  {
    long l1 = 0L;
    if (this.preamble != null) {
      l1 = 0L + this.preamble.length();
    }
    long l2;
    if (this.parts.size() == 0)
    {
      l2 = this.boundary.getBytes().length + MimeDefine.CRLF.getBytes().length;
      l2 = MimeDefine.CRLF.getBytes().length + (l1 + l2);
      return this.boundaryEnd.getBytes().length + MimeDefine.CRLF.getBytes().length + l2;
    }
    Iterator localIterator = this.parts.iterator();
    for (;;)
    {
      l2 = l1;
      if (!localIterator.hasNext()) {
        break;
      }
      Part localPart = (Part)localIterator.next();
      l2 = this.boundary.getBytes().length + MimeDefine.CRLF.getBytes().length;
      long l3 = localPart.getHeader().getSize();
      l1 = localPart.getSize() + (l1 + l2 + l3) + MimeDefine.CRLF.getBytes().length;
    }
  }
  
  public void parseContentTypeString(String paramString)
    throws MessageException
  {
    setContentType(paramString);
    paramString = new ContentType(paramString).getParam(MimeDefine.BOUNDARY);
    this.boundary = ("--" + paramString);
    this.boundaryEnd = (this.boundary + "--");
  }
  
  public String read(InputStream paramInputStream, DataListener paramDataListener)
    throws MessageException
  {
    LineInputStream localLineInputStream;
    if ((paramInputStream instanceof LineInputStream)) {
      localLineInputStream = (LineInputStream)paramInputStream;
    }
    Object localObject2;
    Object localObject1;
    for (;;)
    {
      try
      {
        localObject2 = new StringBuilder();
        localObject1 = localLineInputStream.readLine();
        paramInputStream = (InputStream)localObject1;
        if (localObject1 != null)
        {
          paramInputStream = (InputStream)localObject1;
          if (paramDataListener != null)
          {
            paramDataListener.onDataChange(((String)localObject1).length());
            paramInputStream = (InputStream)localObject1;
          }
        }
        if ((paramInputStream == null) || (paramInputStream.equalsIgnoreCase(this.boundary))) {
          break;
        }
        ((StringBuilder)localObject2).append(paramInputStream);
        localObject1 = localLineInputStream.readLine();
        paramInputStream = (InputStream)localObject1;
        if (localObject1 != null)
        {
          paramInputStream = (InputStream)localObject1;
          if (paramDataListener != null)
          {
            paramDataListener.onDataChange(((String)localObject1).length());
            paramInputStream = (InputStream)localObject1;
            continue;
            localLineInputStream = new LineInputStream(paramInputStream);
          }
        }
      }
      catch (IOException paramInputStream)
      {
        throw new MessageException(3, "multi part read io", paramInputStream);
      }
    }
    this.preamble = ((StringBuilder)localObject2).toString();
    while ((paramInputStream != null) && (!paramInputStream.equalsIgnoreCase(this.boundaryEnd))) {
      if (paramInputStream.equalsIgnoreCase(this.boundary))
      {
        localObject2 = new MimeHeader();
        paramInputStream = ((MimeHeader)localObject2).read(localLineInputStream, paramDataListener);
        localObject1 = ((MimeHeader)localObject2).getHeader(MimeDefine.CONTENT_TYPE);
        if (!StringUtility.isNullOrEmpty((String)localObject1))
        {
          paramInputStream = new ContentType((String)localObject1).getType();
          if ((paramInputStream.equalsIgnoreCase(MimeDefine.MULTIPART_MIXED)) || (paramInputStream.equalsIgnoreCase(MimeDefine.MULTIPART_RELATED)) || (paramInputStream.equalsIgnoreCase(MimeDefine.MULTIPART_ALTERNATIVE)) || (paramInputStream.equalsIgnoreCase(MimeDefine.MULTIPART_DIGEST)) || (paramInputStream.equalsIgnoreCase(MimeDefine.MULTIPART_REPORT)))
          {
            localObject2 = new MimeMultiPart();
            ((MimeMultiPart)localObject2).parseContentTypeString((String)localObject1);
            paramInputStream = ((MimeMultiPart)localObject2).read(localLineInputStream, paramDataListener);
            addPart((Part)localObject2);
          }
          else
          {
            localObject1 = new MimeBodyPart((MimeHeader)localObject2);
            ((MimeBodyPart)localObject1).setBoundary(this.boundary, this.boundaryEnd);
            paramInputStream = ((MimeBodyPart)localObject1).read(localLineInputStream, paramDataListener);
            addPart((Part)localObject1);
          }
        }
      }
      else
      {
        localObject1 = localLineInputStream.readLine();
        paramInputStream = (InputStream)localObject1;
        if (localObject1 != null)
        {
          paramInputStream = (InputStream)localObject1;
          if (paramDataListener != null)
          {
            paramDataListener.onDataChange(((String)localObject1).length());
            paramInputStream = (InputStream)localObject1;
          }
        }
      }
    }
    return paramInputStream;
  }
  
  public String removeHeader(String paramString)
  {
    return null;
  }
  
  public void setPreamble(String paramString)
  {
    this.preamble = paramString;
  }
  
  /* Error */
  public void write(java.io.OutputStream paramOutputStream, DataListener paramDataListener)
    throws MessageException
  {
    // Byte code:
    //   0: aload_1
    //   1: instanceof 205
    //   4: ifeq +191 -> 195
    //   7: aload_1
    //   8: checkcast 205	com/tencent/moai/mailsdk/util/stream/LineOutputStream
    //   11: astore_1
    //   12: aload_0
    //   13: getfield 80	com/tencent/moai/mailsdk/protocol/mime/model/MimeMultiPart:preamble	Ljava/lang/String;
    //   16: ifnull +77 -> 93
    //   19: aload_0
    //   20: getfield 80	com/tencent/moai/mailsdk/protocol/mime/model/MimeMultiPart:preamble	Ljava/lang/String;
    //   23: invokestatic 210	com/tencent/moai/mailsdk/util/ASCIIUtility:getBytes	(Ljava/lang/String;)[B
    //   26: astore_3
    //   27: aload_1
    //   28: aload_3
    //   29: invokevirtual 213	com/tencent/moai/mailsdk/util/stream/LineOutputStream:write	([B)V
    //   32: aload_2
    //   33: ifnull +12 -> 45
    //   36: aload_2
    //   37: aload_3
    //   38: arraylength
    //   39: i2l
    //   40: invokeinterface 146 3 0
    //   45: aload_3
    //   46: arraylength
    //   47: ifle +46 -> 93
    //   50: aload_3
    //   51: aload_3
    //   52: arraylength
    //   53: iconst_1
    //   54: isub
    //   55: baload
    //   56: bipush 13
    //   58: if_icmpeq +35 -> 93
    //   61: aload_3
    //   62: aload_3
    //   63: arraylength
    //   64: iconst_1
    //   65: isub
    //   66: baload
    //   67: bipush 10
    //   69: if_icmpeq +24 -> 93
    //   72: aload_1
    //   73: invokevirtual 216	com/tencent/moai/mailsdk/util/stream/LineOutputStream:writeln	()V
    //   76: aload_2
    //   77: ifnull +16 -> 93
    //   80: aload_2
    //   81: getstatic 104	com/tencent/moai/mailsdk/protocol/mime/MimeDefine:CRLF	Ljava/lang/String;
    //   84: invokevirtual 88	java/lang/String:length	()I
    //   87: i2l
    //   88: invokeinterface 146 3 0
    //   93: aload_0
    //   94: getfield 92	com/tencent/moai/mailsdk/protocol/mime/model/MimeMultiPart:parts	Ljava/util/Vector;
    //   97: invokevirtual 97	java/util/Vector:size	()I
    //   100: ifne +107 -> 207
    //   103: aload_1
    //   104: aload_0
    //   105: getfield 37	com/tencent/moai/mailsdk/protocol/mime/model/MimeMultiPart:boundary	Ljava/lang/String;
    //   108: invokevirtual 218	com/tencent/moai/mailsdk/util/stream/LineOutputStream:writeln	(Ljava/lang/String;)V
    //   111: aload_2
    //   112: ifnull +24 -> 136
    //   115: aload_2
    //   116: aload_0
    //   117: getfield 37	com/tencent/moai/mailsdk/protocol/mime/model/MimeMultiPart:boundary	Ljava/lang/String;
    //   120: invokevirtual 88	java/lang/String:length	()I
    //   123: getstatic 104	com/tencent/moai/mailsdk/protocol/mime/MimeDefine:CRLF	Ljava/lang/String;
    //   126: invokevirtual 88	java/lang/String:length	()I
    //   129: iadd
    //   130: i2l
    //   131: invokeinterface 146 3 0
    //   136: aload_1
    //   137: invokevirtual 216	com/tencent/moai/mailsdk/util/stream/LineOutputStream:writeln	()V
    //   140: aload_2
    //   141: ifnull +16 -> 157
    //   144: aload_2
    //   145: getstatic 104	com/tencent/moai/mailsdk/protocol/mime/MimeDefine:CRLF	Ljava/lang/String;
    //   148: invokevirtual 88	java/lang/String:length	()I
    //   151: i2l
    //   152: invokeinterface 146 3 0
    //   157: aload_1
    //   158: aload_0
    //   159: getfield 39	com/tencent/moai/mailsdk/protocol/mime/model/MimeMultiPart:boundaryEnd	Ljava/lang/String;
    //   162: invokevirtual 218	com/tencent/moai/mailsdk/util/stream/LineOutputStream:writeln	(Ljava/lang/String;)V
    //   165: aload_2
    //   166: ifnull +24 -> 190
    //   169: aload_2
    //   170: aload_0
    //   171: getfield 39	com/tencent/moai/mailsdk/protocol/mime/model/MimeMultiPart:boundaryEnd	Ljava/lang/String;
    //   174: invokevirtual 88	java/lang/String:length	()I
    //   177: getstatic 104	com/tencent/moai/mailsdk/protocol/mime/MimeDefine:CRLF	Ljava/lang/String;
    //   180: invokevirtual 88	java/lang/String:length	()I
    //   183: iadd
    //   184: i2l
    //   185: invokeinterface 146 3 0
    //   190: aload_1
    //   191: invokevirtual 221	com/tencent/moai/mailsdk/util/stream/LineOutputStream:flush	()V
    //   194: return
    //   195: new 205	com/tencent/moai/mailsdk/util/stream/LineOutputStream
    //   198: dup
    //   199: aload_1
    //   200: invokespecial 224	com/tencent/moai/mailsdk/util/stream/LineOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   203: astore_1
    //   204: goto -192 -> 12
    //   207: aload_0
    //   208: getfield 92	com/tencent/moai/mailsdk/protocol/mime/model/MimeMultiPart:parts	Ljava/util/Vector;
    //   211: invokevirtual 108	java/util/Vector:iterator	()Ljava/util/Iterator;
    //   214: astore_3
    //   215: aload_3
    //   216: invokeinterface 114 1 0
    //   221: ifeq -64 -> 157
    //   224: aload_3
    //   225: invokeinterface 118 1 0
    //   230: checkcast 120	com/tencent/moai/mailsdk/protocol/model/Part
    //   233: astore 4
    //   235: aload_1
    //   236: aload_0
    //   237: getfield 37	com/tencent/moai/mailsdk/protocol/mime/model/MimeMultiPart:boundary	Ljava/lang/String;
    //   240: invokevirtual 218	com/tencent/moai/mailsdk/util/stream/LineOutputStream:writeln	(Ljava/lang/String;)V
    //   243: aload_2
    //   244: ifnull +24 -> 268
    //   247: aload_2
    //   248: aload_0
    //   249: getfield 37	com/tencent/moai/mailsdk/protocol/mime/model/MimeMultiPart:boundary	Ljava/lang/String;
    //   252: invokevirtual 88	java/lang/String:length	()I
    //   255: getstatic 104	com/tencent/moai/mailsdk/protocol/mime/MimeDefine:CRLF	Ljava/lang/String;
    //   258: invokevirtual 88	java/lang/String:length	()I
    //   261: iadd
    //   262: i2l
    //   263: invokeinterface 146 3 0
    //   268: aload 4
    //   270: invokeinterface 122 1 0
    //   275: aload_1
    //   276: aload_2
    //   277: invokevirtual 226	com/tencent/moai/mailsdk/protocol/model/Header:write	(Ljava/io/OutputStream;Lcom/tencent/moai/mailsdk/protocol/mime/DataListener;)V
    //   280: aload 4
    //   282: aload_1
    //   283: aload_2
    //   284: invokeinterface 227 3 0
    //   289: aload_1
    //   290: invokevirtual 216	com/tencent/moai/mailsdk/util/stream/LineOutputStream:writeln	()V
    //   293: aload_2
    //   294: ifnull -79 -> 215
    //   297: aload_2
    //   298: getstatic 104	com/tencent/moai/mailsdk/protocol/mime/MimeDefine:CRLF	Ljava/lang/String;
    //   301: invokevirtual 88	java/lang/String:length	()I
    //   304: i2l
    //   305: invokeinterface 146 3 0
    //   310: goto -95 -> 215
    //   313: astore_1
    //   314: new 15	com/tencent/moai/mailsdk/exception/MessageException
    //   317: dup
    //   318: iconst_3
    //   319: ldc 229
    //   321: aload_1
    //   322: invokespecial 155	com/tencent/moai/mailsdk/exception/MessageException:<init>	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   325: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	326	0	this	MimeMultiPart
    //   0	326	1	paramOutputStream	java.io.OutputStream
    //   0	326	2	paramDataListener	DataListener
    //   26	199	3	localObject	Object
    //   233	48	4	localPart	Part
    // Exception table:
    //   from	to	target	type
    //   12	32	313	java/io/IOException
    //   36	45	313	java/io/IOException
    //   45	76	313	java/io/IOException
    //   80	93	313	java/io/IOException
    //   93	111	313	java/io/IOException
    //   115	136	313	java/io/IOException
    //   136	140	313	java/io/IOException
    //   144	157	313	java/io/IOException
    //   157	165	313	java/io/IOException
    //   169	190	313	java/io/IOException
    //   190	194	313	java/io/IOException
    //   207	215	313	java/io/IOException
    //   215	243	313	java/io/IOException
    //   247	268	313	java/io/IOException
    //   268	293	313	java/io/IOException
    //   297	310	313	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.mime.model.MimeMultiPart
 * JD-Core Version:    0.7.0.1
 */