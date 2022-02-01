package com.tencent.moai.mailsdk.model;

import com.tencent.moai.mailsdk.protocol.imap.model.IMAPBodyStructure;
import com.tencent.moai.mailsdk.protocol.model.Flags;
import com.tencent.moai.mailsdk.protocol.model.Flags.Flag;
import java.util.ArrayList;
import java.util.Iterator;

public class Mail
{
  public static final int FLAG_TYPE_FLAGGED = 1;
  public static final int FLAG_TYPE_SEEN = 2;
  public static final int FLAG_VALUE_NO = 2;
  public static final int FLAG_VALUE_YES = 1;
  private ArrayList<Attachment> attachments;
  private ArrayList<Contact> bcc;
  private ArrayList<IMAPBodyStructure> bodyStructures;
  private Calendar calendar;
  private String calendarContent = "";
  private ArrayList<Contact> cc;
  private Contact from;
  private boolean hasAttach;
  private String htmlContent = "";
  private long id;
  private boolean isContentComplete = true;
  private boolean isNew;
  private boolean isRead;
  private boolean isReply;
  private boolean isSearchMail;
  private boolean isStar;
  private String messageId;
  private String plainContent = "";
  private String reference;
  private String remoteId;
  private Contact replyTo;
  private Contact sender;
  private long size;
  private String subject = "";
  private String svrKey = "";
  private ArrayList<Contact> to;
  private int type;
  private long utc;
  
  public ArrayList<Attachment> getAttachments()
  {
    return this.attachments;
  }
  
  public ArrayList<Contact> getBcc()
  {
    return this.bcc;
  }
  
  public ArrayList<IMAPBodyStructure> getBodyStructures()
  {
    return this.bodyStructures;
  }
  
  public Calendar getCalendar()
  {
    return this.calendar;
  }
  
  public String getCalendarContent()
  {
    return this.calendarContent;
  }
  
  public ArrayList<Contact> getCc()
  {
    return this.cc;
  }
  
  public Contact getFrom()
  {
    return this.from;
  }
  
  public String getHtmlContent()
  {
    return this.htmlContent;
  }
  
  public long getId()
  {
    return this.id;
  }
  
  public ArrayList<Attachment> getInlineAttachment()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.attachments == null) {
      return localArrayList;
    }
    Iterator localIterator = this.attachments.iterator();
    while (localIterator.hasNext())
    {
      Attachment localAttachment = (Attachment)localIterator.next();
      if (localAttachment.getType() == "inline") {
        localArrayList.add(localAttachment);
      }
    }
    return localArrayList;
  }
  
  public String getMessageId()
  {
    return this.messageId;
  }
  
  public ArrayList<Attachment> getNormalAttachment()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.attachments == null) {
      return localArrayList;
    }
    Iterator localIterator = this.attachments.iterator();
    while (localIterator.hasNext())
    {
      Attachment localAttachment = (Attachment)localIterator.next();
      if (localAttachment.getType() == "attachment") {
        localArrayList.add(localAttachment);
      }
    }
    return localArrayList;
  }
  
  public String getPlainContent()
  {
    return this.plainContent;
  }
  
  public String getReference()
  {
    return this.reference;
  }
  
  public String getRemoteId()
  {
    return this.remoteId;
  }
  
  public Contact getReplyTo()
  {
    return this.replyTo;
  }
  
  public Contact getSender()
  {
    return this.sender;
  }
  
  public long getSize()
  {
    return this.size;
  }
  
  public String getSubject()
  {
    return this.subject;
  }
  
  public String getSvrKey()
  {
    return this.svrKey;
  }
  
  public ArrayList<Contact> getTo()
  {
    return this.to;
  }
  
  public int getType()
  {
    return this.type;
  }
  
  public long getUtc()
  {
    return this.utc;
  }
  
  public int inlineAttachmentCount()
  {
    if (this.attachments == null) {
      return 0;
    }
    Iterator localIterator = this.attachments.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      if (((Attachment)localIterator.next()).getType() != "inline") {
        break label54;
      }
      i += 1;
    }
    label54:
    for (;;)
    {
      break;
      return i;
    }
  }
  
  public boolean isContentComplete()
  {
    return this.isContentComplete;
  }
  
  public boolean isHasAttach()
  {
    return this.hasAttach;
  }
  
  public boolean isNew()
  {
    return this.isNew;
  }
  
  public boolean isRead()
  {
    return this.isRead;
  }
  
  public boolean isReply()
  {
    return this.isReply;
  }
  
  public boolean isSearchMail()
  {
    return this.isSearchMail;
  }
  
  public boolean isStar()
  {
    return this.isStar;
  }
  
  public int normalAttachmentCount()
  {
    if (this.attachments == null) {
      return 0;
    }
    Iterator localIterator = this.attachments.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      if (((Attachment)localIterator.next()).getType() != "attachment") {
        break label54;
      }
      i += 1;
    }
    label54:
    for (;;)
    {
      break;
      return i;
    }
  }
  
  public void setAttachments(ArrayList<Attachment> paramArrayList)
  {
    this.attachments = paramArrayList;
  }
  
  public void setBcc(ArrayList<Contact> paramArrayList)
  {
    this.bcc = paramArrayList;
  }
  
  public void setBodyStructures(ArrayList<IMAPBodyStructure> paramArrayList)
  {
    this.bodyStructures = paramArrayList;
  }
  
  public void setCalendar(Calendar paramCalendar)
  {
    this.calendar = paramCalendar;
  }
  
  public void setCalendarContent(String paramString)
  {
    this.calendarContent = paramString;
  }
  
  public void setCc(ArrayList<Contact> paramArrayList)
  {
    this.cc = paramArrayList;
  }
  
  public void setFlags(Flags paramFlags)
  {
    if (paramFlags != null)
    {
      setIsRead(paramFlags.contain(Flags.Flag.SEEN));
      setIsStar(paramFlags.contain(Flags.Flag.FLAGGED));
      setIsReply(paramFlags.contain(Flags.Flag.ANSWERED));
    }
  }
  
  public void setFrom(Contact paramContact)
  {
    this.from = paramContact;
  }
  
  public void setHasAttach(boolean paramBoolean)
  {
    this.hasAttach = paramBoolean;
  }
  
  public void setHtmlContent(String paramString)
  {
    this.htmlContent = paramString;
  }
  
  public void setId(long paramLong)
  {
    this.id = paramLong;
  }
  
  public void setIsContentComplete(boolean paramBoolean)
  {
    this.isContentComplete = paramBoolean;
  }
  
  public void setIsNew(boolean paramBoolean)
  {
    this.isNew = paramBoolean;
  }
  
  public void setIsRead(boolean paramBoolean)
  {
    this.isRead = paramBoolean;
  }
  
  public void setIsReply(boolean paramBoolean)
  {
    this.isReply = paramBoolean;
  }
  
  public void setIsStar(boolean paramBoolean)
  {
    this.isStar = paramBoolean;
  }
  
  public void setMessageId(String paramString)
  {
    this.messageId = paramString;
  }
  
  public void setPlainContent(String paramString)
  {
    this.plainContent = paramString;
  }
  
  public void setReference(String paramString)
  {
    this.reference = paramString;
  }
  
  public void setRemoteId(String paramString)
  {
    this.remoteId = paramString;
  }
  
  public void setReplyTo(Contact paramContact)
  {
    this.replyTo = paramContact;
  }
  
  public void setSearchMail(boolean paramBoolean)
  {
    this.isSearchMail = paramBoolean;
  }
  
  public void setSender(Contact paramContact)
  {
    this.sender = paramContact;
  }
  
  public void setSize(long paramLong)
  {
    this.size = paramLong;
  }
  
  public void setSubject(String paramString)
  {
    this.subject = paramString;
  }
  
  public void setSvrKey(String paramString)
  {
    this.svrKey = paramString;
  }
  
  public void setTo(ArrayList<Contact> paramArrayList)
  {
    this.to = paramArrayList;
  }
  
  public void setType(int paramInt)
  {
    this.type = paramInt;
  }
  
  public void setUtc(long paramLong)
  {
    this.utc = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.model.Mail
 * JD-Core Version:    0.7.0.1
 */