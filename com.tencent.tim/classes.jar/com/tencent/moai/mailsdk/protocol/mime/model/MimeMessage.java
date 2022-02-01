package com.tencent.moai.mailsdk.protocol.mime.model;

import android.util.Log;
import com.tencent.moai.mailsdk.exception.MessageException;
import com.tencent.moai.mailsdk.protocol.mime.ContentType;
import com.tencent.moai.mailsdk.protocol.mime.DataListener;
import com.tencent.moai.mailsdk.protocol.mime.MimeDefine;
import com.tencent.moai.mailsdk.protocol.model.Address;
import com.tencent.moai.mailsdk.protocol.model.Flags;
import com.tencent.moai.mailsdk.protocol.model.Flags.Flag;
import com.tencent.moai.mailsdk.protocol.model.Message;
import com.tencent.moai.mailsdk.protocol.model.Message.RecipientType;
import com.tencent.moai.mailsdk.util.MailDateFormat;
import com.tencent.moai.mailsdk.util.MimeUtility;
import com.tencent.moai.mailsdk.util.StringUtility;
import com.tencent.moai.mailsdk.util.log.Logger;
import com.tencent.moai.mailsdk.util.stream.LineInputStream;
import java.io.InputStream;
import java.util.Date;

public class MimeMessage
  extends Message
  implements MimePart
{
  private static final String TAG = "MimeMessage";
  protected long availableSize;
  protected MimeBodyPart bodyPart;
  protected Flags flags;
  protected MimeHeader header = new MimeHeader();
  protected MailDateFormat mailDateFormat;
  protected MimeMultiPart multiPart;
  
  public MimeMessage()
  {
    this.header.addHeader(MimeDefine.MIME_VERSION, MimeDefine.MIME_VERSION_VALUE);
    this.header.addHeader(MimeDefine.MIME_X_QQ_MIME, MimeDefine.MIME_X_QQ_MIME_VALUE);
    this.header.addHeader(MimeDefine.MIME_X_MAILER, MimeDefine.MIME_X_MAILER_VALUE);
    this.header.addHeader(MimeDefine.MIME_X_QQ_MAILER, MimeDefine.MIME_X_QQ_MAILER_VALUE);
    this.flags = new Flags();
    this.mailDateFormat = new MailDateFormat();
  }
  
  private String getHeaderName(Message.RecipientType paramRecipientType)
  {
    String str = null;
    if (paramRecipientType == Message.RecipientType.TO) {
      str = MimeDefine.TO;
    }
    do
    {
      return str;
      if (paramRecipientType == Message.RecipientType.CC) {
        return MimeDefine.CC;
      }
    } while (paramRecipientType != Message.RecipientType.BCC);
    return MimeDefine.BCC;
  }
  
  public void addHeader(String paramString1, String paramString2)
  {
    this.header.addHeader(paramString1, paramString2);
  }
  
  public long getAvailableSize()
  {
    return this.availableSize;
  }
  
  public MimeBodyPart getBodyPart()
  {
    return this.bodyPart;
  }
  
  public String getContentDescription()
  {
    try
    {
      String str = MimeUtility.decodeText(MimeUtility.unfold(getHeader(MimeDefine.CONTENT_DESCRIPTION)));
      return str;
    }
    catch (Exception localException) {}
    return getHeader(MimeDefine.CONTENT_DESCRIPTION);
  }
  
  public String getContentEncoding()
  {
    return getHeader(MimeDefine.CONTENT_ENCODING);
  }
  
  public String getContentID()
  {
    return getHeader(MimeDefine.CONTENT_ID);
  }
  
  public String getContentLanguage()
  {
    return getHeader(MimeDefine.CONTENT_LANGUAGE);
  }
  
  public String getContentMD5()
  {
    return getHeader(MimeDefine.CONTENT_MD5);
  }
  
  public String getContentType()
  {
    return getHeader(MimeDefine.CONTENT_TYPE);
  }
  
  /* Error */
  public Date getDate()
  {
    // Byte code:
    //   0: aload_0
    //   1: getstatic 144	com/tencent/moai/mailsdk/protocol/mime/MimeDefine:DATE	Ljava/lang/String;
    //   4: invokevirtual 111	com/tencent/moai/mailsdk/protocol/mime/model/MimeMessage:getHeader	(Ljava/lang/String;)Ljava/lang/String;
    //   7: astore_1
    //   8: aload_1
    //   9: invokestatic 150	com/tencent/moai/mailsdk/util/StringUtility:isNullOrEmpty	(Ljava/lang/String;)Z
    //   12: ifne +64 -> 76
    //   15: aload_0
    //   16: getfield 71	com/tencent/moai/mailsdk/protocol/mime/model/MimeMessage:mailDateFormat	Lcom/tencent/moai/mailsdk/util/MailDateFormat;
    //   19: aload_1
    //   20: invokevirtual 154	com/tencent/moai/mailsdk/util/MailDateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   23: astore_1
    //   24: aload_1
    //   25: ifnull +5 -> 30
    //   28: aload_1
    //   29: areturn
    //   30: aload_0
    //   31: getstatic 157	com/tencent/moai/mailsdk/protocol/mime/MimeDefine:RECEIVED	Ljava/lang/String;
    //   34: invokevirtual 111	com/tencent/moai/mailsdk/protocol/mime/model/MimeMessage:getHeader	(Ljava/lang/String;)Ljava/lang/String;
    //   37: astore_2
    //   38: aload_2
    //   39: invokestatic 150	com/tencent/moai/mailsdk/util/StringUtility:isNullOrEmpty	(Ljava/lang/String;)Z
    //   42: ifne -14 -> 28
    //   45: aload_0
    //   46: getfield 71	com/tencent/moai/mailsdk/protocol/mime/model/MimeMessage:mailDateFormat	Lcom/tencent/moai/mailsdk/util/MailDateFormat;
    //   49: aload_2
    //   50: invokevirtual 160	com/tencent/moai/mailsdk/util/MailDateFormat:parseMultiLine	(Ljava/lang/String;)Ljava/util/Date;
    //   53: astore_2
    //   54: aload_2
    //   55: areturn
    //   56: astore_2
    //   57: aconst_null
    //   58: astore_1
    //   59: bipush 6
    //   61: ldc 10
    //   63: aload_2
    //   64: invokestatic 166	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   67: invokestatic 172	com/tencent/moai/mailsdk/util/log/Logger:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   70: aload_1
    //   71: areturn
    //   72: astore_2
    //   73: goto -14 -> 59
    //   76: aconst_null
    //   77: astore_1
    //   78: goto -54 -> 24
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	81	0	this	MimeMessage
    //   7	71	1	localObject1	Object
    //   37	18	2	localObject2	Object
    //   56	8	2	localException1	Exception
    //   72	1	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   0	24	56	java/lang/Exception
    //   30	54	72	java/lang/Exception
  }
  
  public String getDisposition()
  {
    return getHeader(MimeDefine.CONTENT_DISPOSITION);
  }
  
  public Flags getFlags()
  {
    return this.flags;
  }
  
  public Address getFrom()
  {
    return MimeAddress.parseAddress(getHeader(MimeDefine.FROM));
  }
  
  public MimeHeader getHeader()
  {
    return this.header;
  }
  
  public String getHeader(String paramString)
  {
    return this.header.getHeader(paramString);
  }
  
  public String getMessageId()
  {
    return getHeader(MimeDefine.MESSAGE_ID);
  }
  
  public MimeMultiPart getMultiPart()
  {
    return this.multiPart;
  }
  
  public Address[] getRecipients(Message.RecipientType paramRecipientType)
  {
    return MimeAddress.parseAddresses(getHeader(getHeaderName(paramRecipientType)));
  }
  
  public Address getReplyTo()
  {
    return MimeAddress.parseAddress(getHeader(MimeDefine.REPLY_TO));
  }
  
  public long getSize()
  {
    long l2 = 0L + this.header.getSize();
    long l1;
    if (this.multiPart != null) {
      l1 = l2 + this.multiPart.getSize();
    }
    do
    {
      return l1;
      l1 = l2;
    } while (this.bodyPart == null);
    return l2 + this.bodyPart.getSize();
  }
  
  public String getSubject()
  {
    try
    {
      String str = MimeUtility.decodeText(MimeUtility.unfold(getHeader(MimeDefine.SUBJECT)));
      return str;
    }
    catch (Exception localException) {}
    return getHeader(MimeDefine.SUBJECT);
  }
  
  public boolean isFlag(Flags.Flag paramFlag)
  {
    return this.flags.contain(paramFlag);
  }
  
  public String read(InputStream paramInputStream, DataListener paramDataListener)
    throws MessageException
  {
    if ((paramInputStream instanceof LineInputStream)) {}
    for (paramInputStream = (LineInputStream)paramInputStream;; paramInputStream = new LineInputStream(paramInputStream))
    {
      this.header.read(paramInputStream, paramDataListener);
      String str = getContentType();
      if (StringUtility.isNullOrEmpty(str)) {
        break label190;
      }
      Logger.log(4, "MimeMessage", "contentType: " + str);
      str = new ContentType(str).getType();
      if ((!str.equalsIgnoreCase(MimeDefine.MULTIPART_MIXED)) && (!str.equalsIgnoreCase(MimeDefine.MULTIPART_RELATED)) && (!str.equalsIgnoreCase(MimeDefine.MULTIPART_ALTERNATIVE)) && (!str.equalsIgnoreCase(MimeDefine.MULTIPART_DIGEST)) && (!str.equalsIgnoreCase(MimeDefine.MULTIPART_REPORT))) {
        break;
      }
      this.multiPart = new MimeMultiPart();
      this.multiPart.parseContentTypeString(getContentType());
      return this.multiPart.read(paramInputStream, paramDataListener);
    }
    this.bodyPart = new MimeBodyPart(this.header);
    return this.bodyPart.read(paramInputStream, paramDataListener);
    label190:
    this.bodyPart = new MimeBodyPart(this.header);
    return this.bodyPart.read(paramInputStream, paramDataListener);
  }
  
  public String removeHeader(String paramString)
  {
    return this.header.removeHeader(paramString);
  }
  
  public void setAvailableSize(long paramLong)
  {
    this.availableSize = paramLong;
  }
  
  public void setBodyPart(MimeBodyPart paramMimeBodyPart)
  {
    this.bodyPart = paramMimeBodyPart;
    setContentType(paramMimeBodyPart.getContentType());
    setContentEncoding(paramMimeBodyPart.getContentEncoding());
    setContentID(paramMimeBodyPart.getContentID());
    setContentMD5(paramMimeBodyPart.getContentMD5());
    setContentLanguage(paramMimeBodyPart.getContentLanguage());
    setContentDescription(paramMimeBodyPart.getContentDescription());
    setDisposition(paramMimeBodyPart.getDisposition());
  }
  
  public void setContentDescription(String paramString)
  {
    if (paramString == null)
    {
      removeHeader(MimeDefine.CONTENT_DESCRIPTION);
      return;
    }
    try
    {
      String str = MimeUtility.fold(21, MimeUtility.encodeText(paramString));
      paramString = str;
    }
    catch (Exception localException)
    {
      label25:
      break label25;
    }
    addHeader(MimeDefine.CONTENT_DESCRIPTION, paramString);
  }
  
  public void setContentEncoding(String paramString)
  {
    if (paramString == null)
    {
      removeHeader(MimeDefine.CONTENT_ENCODING);
      return;
    }
    addHeader(MimeDefine.CONTENT_ENCODING, paramString);
  }
  
  public void setContentID(String paramString)
  {
    if (paramString == null)
    {
      removeHeader(MimeDefine.CONTENT_ID);
      return;
    }
    addHeader(MimeDefine.CONTENT_ID, paramString);
  }
  
  public void setContentLanguage(String paramString)
  {
    if (paramString == null)
    {
      removeHeader(MimeDefine.CONTENT_LANGUAGE);
      return;
    }
    addHeader(MimeDefine.CONTENT_LANGUAGE, paramString);
  }
  
  public void setContentMD5(String paramString)
  {
    if (paramString == null)
    {
      removeHeader(MimeDefine.CONTENT_MD5);
      return;
    }
    addHeader(MimeDefine.CONTENT_MD5, paramString);
  }
  
  public void setContentType(String paramString)
  {
    if (paramString == null)
    {
      removeHeader(MimeDefine.CONTENT_TYPE);
      return;
    }
    addHeader(MimeDefine.CONTENT_TYPE, paramString);
  }
  
  public void setDate(Date paramDate)
  {
    if (paramDate == null) {}
    try
    {
      removeHeader(MimeDefine.DATE);
      return;
    }
    catch (Exception paramDate)
    {
      Logger.log(6, "MimeMessage", Log.getStackTraceString(paramDate));
    }
    addHeader(MimeDefine.DATE, this.mailDateFormat.format(paramDate));
    return;
  }
  
  public void setDisposition(String paramString)
  {
    if (paramString == null)
    {
      removeHeader(MimeDefine.CONTENT_DISPOSITION);
      return;
    }
    addHeader(MimeDefine.CONTENT_DISPOSITION, paramString);
  }
  
  public void setFlags(Flags paramFlags)
  {
    this.flags = paramFlags;
  }
  
  public void setFrom(Address paramAddress)
  {
    if (paramAddress == null)
    {
      removeHeader(MimeDefine.FROM);
      return;
    }
    addHeader(MimeDefine.FROM, paramAddress.toString());
  }
  
  public void setHeader(MimeHeader paramMimeHeader)
  {
    this.header = paramMimeHeader;
  }
  
  public void setMessageId(String paramString)
  {
    if (paramString == null)
    {
      removeHeader(MimeDefine.MESSAGE_ID);
      return;
    }
    addHeader(MimeDefine.MESSAGE_ID, paramString);
  }
  
  public void setMultiPart(MimeMultiPart paramMimeMultiPart)
  {
    this.multiPart = paramMimeMultiPart;
    setContentType(paramMimeMultiPart.getContentType());
  }
  
  public void setRecipients(Address[] paramArrayOfAddress, Message.RecipientType paramRecipientType)
  {
    paramRecipientType = getHeaderName(paramRecipientType);
    paramArrayOfAddress = MimeAddress.parseAddressToString(paramArrayOfAddress, paramRecipientType.length() + 2);
    if (paramArrayOfAddress == null)
    {
      removeHeader(paramRecipientType);
      return;
    }
    addHeader(paramRecipientType, paramArrayOfAddress);
  }
  
  public void setReplyTo(Address paramAddress)
  {
    if (paramAddress == null)
    {
      removeHeader(MimeDefine.REPLY_TO);
      return;
    }
    addHeader(MimeDefine.REPLY_TO, paramAddress.toString());
  }
  
  public void setSubject(String paramString)
  {
    if (paramString == null)
    {
      removeHeader(MimeDefine.SUBJECT);
      return;
    }
    try
    {
      String str = MimeUtility.fold(9, MimeUtility.encodeText(paramString));
      paramString = str;
    }
    catch (Exception localException)
    {
      label25:
      break label25;
    }
    addHeader(MimeDefine.SUBJECT, paramString);
  }
  
  /* Error */
  public void write(java.io.OutputStream paramOutputStream, DataListener paramDataListener)
    throws MessageException
  {
    // Byte code:
    //   0: aload_1
    //   1: instanceof 381
    //   4: ifeq +38 -> 42
    //   7: aload_1
    //   8: checkcast 381	com/tencent/moai/mailsdk/util/stream/LineOutputStream
    //   11: astore_1
    //   12: aload_0
    //   13: getfield 31	com/tencent/moai/mailsdk/protocol/mime/model/MimeMessage:header	Lcom/tencent/moai/mailsdk/protocol/mime/model/MimeHeader;
    //   16: aload_1
    //   17: aload_2
    //   18: invokevirtual 383	com/tencent/moai/mailsdk/protocol/mime/model/MimeHeader:write	(Ljava/io/OutputStream;Lcom/tencent/moai/mailsdk/protocol/mime/DataListener;)V
    //   21: aload_0
    //   22: getfield 202	com/tencent/moai/mailsdk/protocol/mime/model/MimeMessage:multiPart	Lcom/tencent/moai/mailsdk/protocol/mime/model/MimeMultiPart;
    //   25: ifnull +29 -> 54
    //   28: aload_0
    //   29: getfield 202	com/tencent/moai/mailsdk/protocol/mime/model/MimeMessage:multiPart	Lcom/tencent/moai/mailsdk/protocol/mime/model/MimeMultiPart;
    //   32: aload_1
    //   33: aload_2
    //   34: invokevirtual 384	com/tencent/moai/mailsdk/protocol/mime/model/MimeMultiPart:write	(Ljava/io/OutputStream;Lcom/tencent/moai/mailsdk/protocol/mime/DataListener;)V
    //   37: aload_1
    //   38: invokevirtual 387	com/tencent/moai/mailsdk/util/stream/LineOutputStream:flush	()V
    //   41: return
    //   42: new 381	com/tencent/moai/mailsdk/util/stream/LineOutputStream
    //   45: dup
    //   46: aload_1
    //   47: invokespecial 390	com/tencent/moai/mailsdk/util/stream/LineOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   50: astore_1
    //   51: goto -39 -> 12
    //   54: aload_0
    //   55: getfield 100	com/tencent/moai/mailsdk/protocol/mime/model/MimeMessage:bodyPart	Lcom/tencent/moai/mailsdk/protocol/mime/model/MimeBodyPart;
    //   58: ifnull -21 -> 37
    //   61: aload_0
    //   62: getfield 100	com/tencent/moai/mailsdk/protocol/mime/model/MimeMessage:bodyPart	Lcom/tencent/moai/mailsdk/protocol/mime/model/MimeBodyPart;
    //   65: aload_1
    //   66: aload_2
    //   67: invokevirtual 391	com/tencent/moai/mailsdk/protocol/mime/model/MimeBodyPart:write	(Ljava/io/OutputStream;Lcom/tencent/moai/mailsdk/protocol/mime/DataListener;)V
    //   70: goto -33 -> 37
    //   73: astore_1
    //   74: new 236	com/tencent/moai/mailsdk/exception/MessageException
    //   77: dup
    //   78: iconst_3
    //   79: ldc_w 393
    //   82: aload_1
    //   83: invokespecial 396	com/tencent/moai/mailsdk/exception/MessageException:<init>	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   86: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	this	MimeMessage
    //   0	87	1	paramOutputStream	java.io.OutputStream
    //   0	87	2	paramDataListener	DataListener
    // Exception table:
    //   from	to	target	type
    //   12	37	73	java/io/IOException
    //   37	41	73	java/io/IOException
    //   54	70	73	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.mime.model.MimeMessage
 * JD-Core Version:    0.7.0.1
 */