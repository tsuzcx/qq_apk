package com.tencent.moai.mailsdk.protocol.imap.model;

import com.tencent.moai.mailsdk.exception.MessageException;
import com.tencent.moai.mailsdk.util.MailDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class IMAPEnvelop
  implements IMAPFetchItem
{
  private static final MailDateFormat mailDateFormat = new MailDateFormat();
  static final char[] name = { 69, 78, 86, 69, 76, 79, 80, 69 };
  public ArrayList<IMAPAddress> bcc;
  public ArrayList<IMAPAddress> cc;
  public Date date = null;
  public ArrayList<IMAPAddress> from;
  public String inReplyTo;
  public String messageId;
  public ArrayList<IMAPAddress> replyTo;
  public ArrayList<IMAPAddress> sender;
  public String subject;
  public ArrayList<IMAPAddress> to;
  
  public IMAPEnvelop() {}
  
  /* Error */
  public IMAPEnvelop(IMAPResponse paramIMAPResponse)
    throws MessageException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 43	java/lang/Object:<init>	()V
    //   4: aload_0
    //   5: aconst_null
    //   6: putfield 45	com/tencent/moai/mailsdk/protocol/imap/model/IMAPEnvelop:date	Ljava/util/Date;
    //   9: aload_1
    //   10: invokevirtual 55	com/tencent/moai/mailsdk/protocol/imap/model/IMAPResponse:skipSpaces	()V
    //   13: aload_1
    //   14: invokevirtual 59	com/tencent/moai/mailsdk/protocol/imap/model/IMAPResponse:readByte	()B
    //   17: bipush 40
    //   19: if_icmpeq +34 -> 53
    //   22: new 48	com/tencent/moai/mailsdk/exception/MessageException
    //   25: dup
    //   26: iconst_2
    //   27: new 61	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   34: ldc 64
    //   36: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: aload_1
    //   40: invokevirtual 72	com/tencent/moai/mailsdk/protocol/imap/model/IMAPResponse:getContent	()Ljava/lang/String;
    //   43: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokespecial 78	com/tencent/moai/mailsdk/exception/MessageException:<init>	(ILjava/lang/String;)V
    //   52: athrow
    //   53: aload_1
    //   54: invokevirtual 81	com/tencent/moai/mailsdk/protocol/imap/model/IMAPResponse:readString	()Ljava/lang/String;
    //   57: astore_3
    //   58: aload_3
    //   59: ifnull +22 -> 81
    //   62: getstatic 41	com/tencent/moai/mailsdk/protocol/imap/model/IMAPEnvelop:mailDateFormat	Lcom/tencent/moai/mailsdk/util/MailDateFormat;
    //   65: astore_2
    //   66: aload_2
    //   67: monitorenter
    //   68: aload_0
    //   69: getstatic 41	com/tencent/moai/mailsdk/protocol/imap/model/IMAPEnvelop:mailDateFormat	Lcom/tencent/moai/mailsdk/util/MailDateFormat;
    //   72: aload_3
    //   73: invokevirtual 85	com/tencent/moai/mailsdk/util/MailDateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   76: invokevirtual 89	com/tencent/moai/mailsdk/protocol/imap/model/IMAPEnvelop:setDate	(Ljava/util/Date;)V
    //   79: aload_2
    //   80: monitorexit
    //   81: aload_0
    //   82: aload_1
    //   83: invokevirtual 81	com/tencent/moai/mailsdk/protocol/imap/model/IMAPResponse:readString	()Ljava/lang/String;
    //   86: invokevirtual 93	com/tencent/moai/mailsdk/protocol/imap/model/IMAPEnvelop:setSubject	(Ljava/lang/String;)V
    //   89: aload_0
    //   90: aload_0
    //   91: aload_1
    //   92: invokespecial 97	com/tencent/moai/mailsdk/protocol/imap/model/IMAPEnvelop:parseAddressList	(Lcom/tencent/moai/mailsdk/protocol/imap/model/IMAPResponse;)Ljava/util/ArrayList;
    //   95: invokevirtual 101	com/tencent/moai/mailsdk/protocol/imap/model/IMAPEnvelop:setFrom	(Ljava/util/ArrayList;)V
    //   98: aload_0
    //   99: aload_0
    //   100: aload_1
    //   101: invokespecial 97	com/tencent/moai/mailsdk/protocol/imap/model/IMAPEnvelop:parseAddressList	(Lcom/tencent/moai/mailsdk/protocol/imap/model/IMAPResponse;)Ljava/util/ArrayList;
    //   104: invokevirtual 104	com/tencent/moai/mailsdk/protocol/imap/model/IMAPEnvelop:setSender	(Ljava/util/ArrayList;)V
    //   107: aload_0
    //   108: aload_0
    //   109: aload_1
    //   110: invokespecial 97	com/tencent/moai/mailsdk/protocol/imap/model/IMAPEnvelop:parseAddressList	(Lcom/tencent/moai/mailsdk/protocol/imap/model/IMAPResponse;)Ljava/util/ArrayList;
    //   113: invokevirtual 107	com/tencent/moai/mailsdk/protocol/imap/model/IMAPEnvelop:setReplyTo	(Ljava/util/ArrayList;)V
    //   116: aload_0
    //   117: aload_0
    //   118: aload_1
    //   119: invokespecial 97	com/tencent/moai/mailsdk/protocol/imap/model/IMAPEnvelop:parseAddressList	(Lcom/tencent/moai/mailsdk/protocol/imap/model/IMAPResponse;)Ljava/util/ArrayList;
    //   122: invokevirtual 110	com/tencent/moai/mailsdk/protocol/imap/model/IMAPEnvelop:setTo	(Ljava/util/ArrayList;)V
    //   125: aload_0
    //   126: aload_0
    //   127: aload_1
    //   128: invokespecial 97	com/tencent/moai/mailsdk/protocol/imap/model/IMAPEnvelop:parseAddressList	(Lcom/tencent/moai/mailsdk/protocol/imap/model/IMAPResponse;)Ljava/util/ArrayList;
    //   131: invokevirtual 113	com/tencent/moai/mailsdk/protocol/imap/model/IMAPEnvelop:setCc	(Ljava/util/ArrayList;)V
    //   134: aload_0
    //   135: aload_0
    //   136: aload_1
    //   137: invokespecial 97	com/tencent/moai/mailsdk/protocol/imap/model/IMAPEnvelop:parseAddressList	(Lcom/tencent/moai/mailsdk/protocol/imap/model/IMAPResponse;)Ljava/util/ArrayList;
    //   140: invokevirtual 116	com/tencent/moai/mailsdk/protocol/imap/model/IMAPEnvelop:setBcc	(Ljava/util/ArrayList;)V
    //   143: aload_0
    //   144: aload_1
    //   145: invokevirtual 81	com/tencent/moai/mailsdk/protocol/imap/model/IMAPResponse:readString	()Ljava/lang/String;
    //   148: invokevirtual 119	com/tencent/moai/mailsdk/protocol/imap/model/IMAPEnvelop:setInReplyTo	(Ljava/lang/String;)V
    //   151: aload_0
    //   152: aload_1
    //   153: invokevirtual 81	com/tencent/moai/mailsdk/protocol/imap/model/IMAPResponse:readString	()Ljava/lang/String;
    //   156: invokevirtual 122	com/tencent/moai/mailsdk/protocol/imap/model/IMAPEnvelop:setMessageId	(Ljava/lang/String;)V
    //   159: aload_1
    //   160: invokevirtual 59	com/tencent/moai/mailsdk/protocol/imap/model/IMAPResponse:readByte	()B
    //   163: bipush 41
    //   165: if_icmpeq +43 -> 208
    //   168: new 48	com/tencent/moai/mailsdk/exception/MessageException
    //   171: dup
    //   172: iconst_2
    //   173: new 61	java/lang/StringBuilder
    //   176: dup
    //   177: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   180: ldc 124
    //   182: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: aload_1
    //   186: invokevirtual 72	com/tencent/moai/mailsdk/protocol/imap/model/IMAPResponse:getContent	()Ljava/lang/String;
    //   189: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: invokespecial 78	com/tencent/moai/mailsdk/exception/MessageException:<init>	(ILjava/lang/String;)V
    //   198: athrow
    //   199: astore_3
    //   200: aload_2
    //   201: monitorexit
    //   202: aload_3
    //   203: athrow
    //   204: astore_2
    //   205: goto -124 -> 81
    //   208: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	209	0	this	IMAPEnvelop
    //   0	209	1	paramIMAPResponse	IMAPResponse
    //   204	1	2	localParseException	java.text.ParseException
    //   57	16	3	str	String
    //   199	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   68	81	199	finally
    //   200	202	199	finally
    //   62	68	204	java/text/ParseException
    //   202	204	204	java/text/ParseException
  }
  
  private ArrayList<IMAPAddress> parseAddressList(IMAPResponse paramIMAPResponse)
    throws MessageException
  {
    ArrayList localArrayList = new ArrayList();
    paramIMAPResponse.skipSpaces();
    int i = paramIMAPResponse.readByte();
    Object localObject;
    if (i == 40) {
      if (paramIMAPResponse.peekByte() == 41)
      {
        paramIMAPResponse.skip(1);
        localObject = null;
      }
    }
    do
    {
      return localObject;
      do
      {
        localObject = new IMAPAddress(paramIMAPResponse);
        if (!((IMAPAddress)localObject).isEndOfGroup()) {
          localArrayList.add(localObject);
        }
      } while (paramIMAPResponse.peekByte() != 41);
      paramIMAPResponse.skip(1);
      return localArrayList;
      if (i == 78) {
        break;
      }
      localObject = localArrayList;
    } while (i != 110);
    paramIMAPResponse.skip(2);
    return localArrayList;
  }
  
  public ArrayList<IMAPAddress> getBcc()
  {
    return this.bcc;
  }
  
  public ArrayList<IMAPAddress> getCc()
  {
    return this.cc;
  }
  
  public Date getDate()
  {
    return this.date;
  }
  
  public ArrayList<IMAPAddress> getFrom()
  {
    return this.from;
  }
  
  public String getInReplyTo()
  {
    return this.inReplyTo;
  }
  
  public String getMessageId()
  {
    return this.messageId;
  }
  
  public ArrayList<IMAPAddress> getReplyTo()
  {
    return this.replyTo;
  }
  
  public ArrayList<IMAPAddress> getSender()
  {
    return this.sender;
  }
  
  public String getSubject()
  {
    return this.subject;
  }
  
  public ArrayList<IMAPAddress> getTo()
  {
    return this.to;
  }
  
  public void setBcc(ArrayList<IMAPAddress> paramArrayList)
  {
    this.bcc = paramArrayList;
  }
  
  public void setCc(ArrayList<IMAPAddress> paramArrayList)
  {
    this.cc = paramArrayList;
  }
  
  public void setDate(Date paramDate)
  {
    this.date = paramDate;
  }
  
  public void setFrom(ArrayList<IMAPAddress> paramArrayList)
  {
    this.from = paramArrayList;
  }
  
  public void setInReplyTo(String paramString)
  {
    this.inReplyTo = paramString;
  }
  
  public void setMessageId(String paramString)
  {
    this.messageId = paramString;
  }
  
  public void setReplyTo(ArrayList<IMAPAddress> paramArrayList)
  {
    this.replyTo = paramArrayList;
  }
  
  public void setSender(ArrayList<IMAPAddress> paramArrayList)
  {
    this.sender = paramArrayList;
  }
  
  public void setSubject(String paramString)
  {
    this.subject = paramString;
  }
  
  public void setTo(ArrayList<IMAPAddress> paramArrayList)
  {
    this.to = paramArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.imap.model.IMAPEnvelop
 * JD-Core Version:    0.7.0.1
 */