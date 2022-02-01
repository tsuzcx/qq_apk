package com.tencent.moai.mailsdk;

import androidx.annotation.NonNull;
import com.tencent.moai.mailsdk.exception.MessageException;
import com.tencent.moai.mailsdk.model.Attachment;
import com.tencent.moai.mailsdk.model.Contact;
import com.tencent.moai.mailsdk.model.Mail;
import com.tencent.moai.mailsdk.protocol.datasource.FileDataSource;
import com.tencent.moai.mailsdk.protocol.datasource.TextDataSource;
import com.tencent.moai.mailsdk.protocol.mime.ContentDisposition;
import com.tencent.moai.mailsdk.protocol.mime.ContentType;
import com.tencent.moai.mailsdk.protocol.mime.MimeDefine;
import com.tencent.moai.mailsdk.protocol.mime.model.MimeAddress;
import com.tencent.moai.mailsdk.protocol.mime.model.MimeBodyPart;
import com.tencent.moai.mailsdk.protocol.mime.model.MimeMessage;
import com.tencent.moai.mailsdk.protocol.mime.model.MimeMultiPart;
import com.tencent.moai.mailsdk.protocol.model.Address;
import com.tencent.moai.mailsdk.protocol.model.Message.RecipientType;
import com.tencent.moai.mailsdk.protocol.model.Part;
import com.tencent.moai.mailsdk.util.MimeUtility;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class MailParser
{
  private static final String[] DOMAIN_USE_FULL_NAME = { "163.com", "126.com", "yeah.net", "outlook.com", "sina.com", "hotmail.com", "live.com", "189.cn", "yahoo.com", "21cn.com", "139.com", "icloud.com ", "tom.com", "aliyun.com", "aol.com", "gmail.com", "sohu.com", "sina.cn" };
  
  public static boolean canUseFullName(@NonNull String paramString)
  {
    paramString = paramString.split("@")[1];
    String[] arrayOfString = DOMAIN_USE_FULL_NAME;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (arrayOfString[i].equals(paramString.toLowerCase())) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  private static MimeBodyPart createAttachmentBodyPart(Attachment paramAttachment)
    throws MessageException
  {
    Object localObject = new File(paramAttachment.getPath());
    FileDataSource localFileDataSource = new FileDataSource();
    localFileDataSource.setType(0);
    localFileDataSource.setFile((File)localObject);
    localFileDataSource.setTempFile((File)localObject);
    try
    {
      paramAttachment = MimeUtility.encodeText(((File)localObject).getName());
      localObject = new ContentType(MimeUtility.getContentType((File)localObject));
      ((ContentType)localObject).setParam(MimeDefine.CHARSET, MimeUtility.getDefaultMIMECharset());
      ((ContentType)localObject).setParam(MimeDefine.NAME, paramAttachment);
      ContentDisposition localContentDisposition = new ContentDisposition(MimeDefine.DISPOSITION_ATTACHMENT);
      localContentDisposition.setParam(MimeDefine.FILE_NAME, paramAttachment);
      paramAttachment = new MimeBodyPart(localFileDataSource);
      paramAttachment.setContentType(((ContentType)localObject).toString());
      paramAttachment.setContentEncoding(MimeDefine.BASE64);
      paramAttachment.setDisposition(localContentDisposition.toString());
      return paramAttachment;
    }
    catch (Exception paramAttachment)
    {
      for (;;)
      {
        paramAttachment = ((File)localObject).getName();
      }
    }
  }
  
  private static MimeBodyPart createHtmlBodyPart(String paramString)
    throws MessageException
  {
    ContentType localContentType = new ContentType(MimeDefine.TEXT_HTML);
    TextDataSource localTextDataSource;
    if ((paramString == null) || (MimeUtility.checkAscii(paramString) != 1))
    {
      localContentType.setParam(MimeDefine.CHARSET, MimeUtility.getDefaultMIMECharset());
      localTextDataSource = new TextDataSource();
      localTextDataSource.setType(1);
      if (paramString == null) {
        break label94;
      }
    }
    for (;;)
    {
      localTextDataSource.setText(paramString);
      paramString = new MimeBodyPart(localTextDataSource);
      paramString.setContentType(localContentType.toString());
      paramString.setContentEncoding(MimeDefine.BASE64);
      return paramString;
      localContentType.setParam(MimeDefine.CHARSET, MimeDefine.US_ASCII);
      break;
      label94:
      paramString = "";
    }
  }
  
  private static MimeBodyPart createInlineBodyPart(Attachment paramAttachment)
    throws MessageException
  {
    Object localObject2 = new File(paramAttachment.getPath());
    FileDataSource localFileDataSource = new FileDataSource();
    localFileDataSource.setType(1);
    localFileDataSource.setFile((File)localObject2);
    localFileDataSource.setTempFile((File)localObject2);
    try
    {
      Object localObject1 = MimeUtility.encodeText(((File)localObject2).getName());
      localObject2 = new ContentType(MimeUtility.getContentType((File)localObject2));
      ((ContentType)localObject2).setParam(MimeDefine.CHARSET, MimeUtility.getDefaultMIMECharset());
      ((ContentType)localObject2).setParam(MimeDefine.NAME, (String)localObject1);
      ContentDisposition localContentDisposition = new ContentDisposition(MimeDefine.DISPOSITION_INLINE);
      localContentDisposition.setParam(MimeDefine.FILE_NAME, (String)localObject1);
      paramAttachment = paramAttachment.getCid();
      localObject1 = new MimeBodyPart(localFileDataSource);
      ((MimeBodyPart)localObject1).setContentType(((ContentType)localObject2).toString());
      ((MimeBodyPart)localObject1).setContentID(paramAttachment);
      ((MimeBodyPart)localObject1).setContentEncoding(MimeDefine.BASE64);
      ((MimeBodyPart)localObject1).setDisposition(localContentDisposition.toString());
      return localObject1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str = ((File)localObject2).getName();
      }
    }
  }
  
  public static Mail createMail(MimeMessage paramMimeMessage)
  {
    int j = 0;
    Mail localMail = new Mail();
    if (paramMimeMessage.getSubject() != null) {
      localMail.setSubject(paramMimeMessage.getSubject());
    }
    Object localObject1 = paramMimeMessage.getDate();
    if (localObject1 != null) {
      localMail.setUtc(((Date)localObject1).getTime());
    }
    localMail.setSize(paramMimeMessage.getSize());
    localObject1 = paramMimeMessage.getFrom();
    if (localObject1 != null) {
      localMail.setFrom(new Contact(((Address)localObject1).getEmail(), ((Address)localObject1).getNick()));
    }
    localObject1 = paramMimeMessage.getReplyTo();
    if (localObject1 != null) {
      localMail.setReplyTo(new Contact(((Address)localObject1).getEmail(), ((Address)localObject1).getNick()));
    }
    localObject1 = paramMimeMessage.getRecipients(Message.RecipientType.TO);
    ArrayList localArrayList;
    int k;
    int i;
    Object localObject2;
    if (localObject1 != null)
    {
      localArrayList = new ArrayList();
      k = localObject1.length;
      i = 0;
      while (i < k)
      {
        localObject2 = localObject1[i];
        localArrayList.add(new Contact(localObject2.getEmail(), localObject2.getNick()));
        i += 1;
      }
      localMail.setTo(localArrayList);
    }
    localObject1 = paramMimeMessage.getRecipients(Message.RecipientType.CC);
    if (localObject1 != null)
    {
      localArrayList = new ArrayList();
      k = localObject1.length;
      i = 0;
      while (i < k)
      {
        localObject2 = localObject1[i];
        localArrayList.add(new Contact(localObject2.getEmail(), localObject2.getNick()));
        i += 1;
      }
      localMail.setCc(localArrayList);
    }
    localObject1 = paramMimeMessage.getRecipients(Message.RecipientType.BCC);
    if (localObject1 != null)
    {
      localArrayList = new ArrayList();
      k = localObject1.length;
      i = j;
      while (i < k)
      {
        localObject2 = localObject1[i];
        localArrayList.add(new Contact(localObject2.getEmail(), localObject2.getNick()));
        i += 1;
      }
      localMail.setBcc(localArrayList);
    }
    localObject1 = paramMimeMessage.getBodyPart();
    paramMimeMessage = paramMimeMessage.getMultiPart();
    if (paramMimeMessage != null) {
      parseMultiPart(localMail, paramMimeMessage);
    }
    while (localObject1 == null) {
      return localMail;
    }
    parseBodyPart(localMail, (MimeBodyPart)localObject1);
    return localMail;
  }
  
  public static MimeMessage createMessage(Mail paramMail)
    throws MessageException
  {
    int j = 0;
    MimeMessage localMimeMessage = new MimeMessage();
    if (paramMail.getMessageId() != null) {
      localMimeMessage.setMessageId(paramMail.getMessageId());
    }
    if (paramMail.getSubject() != null) {
      localMimeMessage.setSubject(paramMail.getSubject());
    }
    if (paramMail.getUtc() > 0L) {
      localMimeMessage.setDate(new Date(paramMail.getUtc()));
    }
    if (paramMail.getFrom() != null) {
      localMimeMessage.setFrom(new MimeAddress(paramMail.getFrom().getEmail(), paramMail.getFrom().getNick()));
    }
    if (paramMail.getReplyTo() != null) {
      localMimeMessage.setReplyTo(new MimeAddress(paramMail.getReplyTo().getEmail(), paramMail.getReplyTo().getNick()));
    }
    int i;
    if ((paramMail.getTo() != null) && (paramMail.getTo().size() > 0))
    {
      localObject1 = new MimeAddress[paramMail.getTo().size()];
      i = 0;
      while (i < paramMail.getTo().size())
      {
        localObject1[i] = new MimeAddress(((Contact)paramMail.getTo().get(i)).getEmail(), ((Contact)paramMail.getTo().get(i)).getNick());
        i += 1;
      }
      localMimeMessage.setRecipients((Address[])localObject1, Message.RecipientType.TO);
    }
    if ((paramMail.getCc() != null) && (paramMail.getCc().size() > 0))
    {
      localObject1 = new MimeAddress[paramMail.getCc().size()];
      i = 0;
      while (i < paramMail.getCc().size())
      {
        localObject1[i] = new MimeAddress(((Contact)paramMail.getCc().get(i)).getEmail(), ((Contact)paramMail.getCc().get(i)).getNick());
        i += 1;
      }
      localMimeMessage.setRecipients((Address[])localObject1, Message.RecipientType.CC);
    }
    if ((paramMail.getBcc() != null) && (paramMail.getBcc().size() > 0))
    {
      localObject1 = new MimeAddress[paramMail.getBcc().size()];
      i = j;
      while (i < paramMail.getBcc().size())
      {
        localObject1[i] = new MimeAddress(((Contact)paramMail.getBcc().get(i)).getEmail(), ((Contact)paramMail.getBcc().get(i)).getNick());
        i += 1;
      }
      localMimeMessage.setRecipients((Address[])localObject1, Message.RecipientType.BCC);
    }
    if ((paramMail.inlineAttachmentCount() == 0) && (paramMail.normalAttachmentCount() == 0)) {
      localMimeMessage.setMultiPart(createTextPart(paramMail));
    }
    do
    {
      return localMimeMessage;
      if ((paramMail.inlineAttachmentCount() > 0) && (paramMail.normalAttachmentCount() == 0))
      {
        localObject2 = createTextPart(paramMail);
        localObject1 = new MimeMultiPart(MimeDefine.MULTIPART_RELATED);
        ((MimeMultiPart)localObject1).addPart((Part)localObject2);
        paramMail = paramMail.getInlineAttachment().iterator();
        while (paramMail.hasNext()) {
          ((MimeMultiPart)localObject1).addPart(createInlineBodyPart((Attachment)paramMail.next()));
        }
        localMimeMessage.setMultiPart((MimeMultiPart)localObject1);
        return localMimeMessage;
      }
      if ((paramMail.inlineAttachmentCount() == 0) && (paramMail.normalAttachmentCount() > 0))
      {
        localObject2 = createTextPart(paramMail);
        localObject1 = new MimeMultiPart(MimeDefine.MULTIPART_MIXED);
        ((MimeMultiPart)localObject1).addPart((Part)localObject2);
        paramMail = paramMail.getNormalAttachment().iterator();
        while (paramMail.hasNext()) {
          ((MimeMultiPart)localObject1).addPart(createAttachmentBodyPart((Attachment)paramMail.next()));
        }
        localMimeMessage.setMultiPart((MimeMultiPart)localObject1);
        return localMimeMessage;
      }
    } while ((paramMail.inlineAttachmentCount() <= 0) || (paramMail.normalAttachmentCount() <= 0));
    Object localObject2 = createTextPart(paramMail);
    Object localObject1 = new MimeMultiPart(MimeDefine.MULTIPART_RELATED);
    ((MimeMultiPart)localObject1).addPart((Part)localObject2);
    localObject2 = paramMail.getInlineAttachment().iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((MimeMultiPart)localObject1).addPart(createInlineBodyPart((Attachment)((Iterator)localObject2).next()));
    }
    localObject2 = new MimeMultiPart(MimeDefine.MULTIPART_MIXED);
    ((MimeMultiPart)localObject2).addPart((Part)localObject1);
    paramMail = paramMail.getNormalAttachment().iterator();
    while (paramMail.hasNext()) {
      ((MimeMultiPart)localObject2).addPart(createAttachmentBodyPart((Attachment)paramMail.next()));
    }
    localMimeMessage.setMultiPart((MimeMultiPart)localObject2);
    return localMimeMessage;
  }
  
  private static MimeBodyPart createPlainBodyPart(String paramString)
    throws MessageException
  {
    ContentType localContentType = new ContentType(MimeDefine.TEXT_PLAIN);
    TextDataSource localTextDataSource;
    if ((paramString == null) || (MimeUtility.checkAscii(paramString) != 1))
    {
      localContentType.setParam(MimeDefine.CHARSET, MimeUtility.getDefaultMIMECharset());
      localTextDataSource = new TextDataSource();
      localTextDataSource.setType(0);
      if (paramString == null) {
        break label94;
      }
    }
    for (;;)
    {
      localTextDataSource.setText(paramString);
      paramString = new MimeBodyPart(localTextDataSource);
      paramString.setContentType(localContentType.toString());
      paramString.setContentEncoding(MimeDefine.BASE64);
      return paramString;
      localContentType.setParam(MimeDefine.CHARSET, MimeDefine.US_ASCII);
      break;
      label94:
      paramString = "";
    }
  }
  
  private static MimeMultiPart createTextPart(Mail paramMail)
    throws MessageException
  {
    MimeBodyPart localMimeBodyPart = createPlainBodyPart(paramMail.getPlainContent());
    paramMail = createHtmlBodyPart(paramMail.getHtmlContent());
    MimeMultiPart localMimeMultiPart = new MimeMultiPart(MimeDefine.MULTIPART_ALTERNATIVE);
    localMimeMultiPart.addPart(localMimeBodyPart);
    localMimeMultiPart.addPart(paramMail);
    return localMimeMultiPart;
  }
  
  public static String getAttachmentContentId(String paramString)
  {
    if (paramString == null) {}
    for (paramString = "";; paramString = paramString.replace("\"", ""))
    {
      int i = paramString.indexOf('<');
      String str = paramString;
      if (i == 0)
      {
        int j = paramString.indexOf('>', i + 1);
        str = paramString;
        if (j == paramString.length() - 1) {
          str = paramString.substring(i + 1, j);
        }
      }
      return str;
    }
  }
  
  public static String getUserName(@NonNull String paramString)
  {
    return paramString.split("@")[0];
  }
  
  private static void parseBodyPart(Mail paramMail, MimeBodyPart paramMimeBodyPart)
  {
    Object localObject1 = paramMimeBodyPart.getDataSource();
    int i;
    if ((localObject1 instanceof TextDataSource))
    {
      paramMimeBodyPart = (TextDataSource)localObject1;
      i = paramMimeBodyPart.getType();
      if (i == 0) {
        paramMail.setPlainContent(paramMimeBodyPart.getText());
      }
    }
    FileDataSource localFileDataSource;
    do
    {
      do
      {
        do
        {
          return;
          if (i == 1)
          {
            paramMail.setHtmlContent(paramMimeBodyPart.getText());
            return;
          }
        } while (i != 2);
        paramMail.setCalendarContent(paramMimeBodyPart.getText());
        return;
      } while (!(localObject1 instanceof FileDataSource));
      localFileDataSource = (FileDataSource)localObject1;
      i = localFileDataSource.getType();
      if (i == 1)
      {
        localObject2 = paramMail.getAttachments();
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new ArrayList();
        }
        localObject2 = new Attachment();
        ((Attachment)localObject2).setType("inline");
        ((Attachment)localObject2).setName(localFileDataSource.getFile().getName());
        ((Attachment)localObject2).setPath(localFileDataSource.getFile().getAbsolutePath());
        ((Attachment)localObject2).setCid(getAttachmentContentId(paramMimeBodyPart.getContentID()));
        ((Attachment)localObject2).setSize(localFileDataSource.getFile().length());
        ((ArrayList)localObject1).add(localObject2);
        paramMail.setAttachments((ArrayList)localObject1);
        return;
      }
    } while (i != 0);
    Object localObject2 = paramMail.getAttachments();
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new ArrayList();
    }
    localObject2 = new Attachment();
    ((Attachment)localObject2).setType("attachment");
    ((Attachment)localObject2).setName(localFileDataSource.getFile().getName());
    ((Attachment)localObject2).setPath(localFileDataSource.getFile().getAbsolutePath());
    ((Attachment)localObject2).setCid(getAttachmentContentId(paramMimeBodyPart.getContentID()));
    ((Attachment)localObject2).setSize(localFileDataSource.getFile().length());
    ((ArrayList)localObject1).add(localObject2);
    paramMail.setAttachments((ArrayList)localObject1);
  }
  
  private static void parseMultiPart(Mail paramMail, MimeMultiPart paramMimeMultiPart)
  {
    int i = 0;
    if (i < paramMimeMultiPart.getCount())
    {
      Part localPart = paramMimeMultiPart.getPart(i);
      if ((localPart instanceof MimeMultiPart)) {
        parseMultiPart(paramMail, (MimeMultiPart)localPart);
      }
      for (;;)
      {
        i += 1;
        break;
        if ((localPart instanceof MimeBodyPart)) {
          parseBodyPart(paramMail, (MimeBodyPart)localPart);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.MailParser
 * JD-Core Version:    0.7.0.1
 */