package com.tencent.moai.mailsdk.protocol.model;

import com.tencent.moai.mailsdk.protocol.mime.MimeDefine;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.Date;

public abstract class Message
  implements Part
{
  protected boolean expunged = false;
  protected Folder folder;
  protected int msgNumber;
  
  protected Message() {}
  
  protected Message(Folder paramFolder, int paramInt)
  {
    this.folder = paramFolder;
    this.msgNumber = paramInt;
  }
  
  public abstract Date getDate();
  
  public abstract Flags getFlags();
  
  public Folder getFolder()
  {
    return this.folder;
  }
  
  public abstract Address getFrom();
  
  public abstract String getMessageId();
  
  public int getMsgNumber()
  {
    return this.msgNumber;
  }
  
  public abstract Address[] getRecipients(RecipientType paramRecipientType);
  
  public abstract Address getReplyTo();
  
  public abstract String getSubject();
  
  public boolean isExpunged()
  {
    return this.expunged;
  }
  
  public abstract boolean isFlag(Flags.Flag paramFlag);
  
  public abstract void setDate(Date paramDate);
  
  public void setExpunged(boolean paramBoolean)
  {
    this.expunged = paramBoolean;
  }
  
  public abstract void setFlags(Flags paramFlags);
  
  public void setFolder(Folder paramFolder)
  {
    this.folder = paramFolder;
  }
  
  public abstract void setFrom(Address paramAddress);
  
  public abstract void setMessageId(String paramString);
  
  public void setMsgNumber(int paramInt)
  {
    this.msgNumber = paramInt;
  }
  
  public abstract void setRecipients(Address[] paramArrayOfAddress, RecipientType paramRecipientType);
  
  public abstract void setReplyTo(Address paramAddress);
  
  public abstract void setSubject(String paramString);
  
  public static class RecipientType
    implements Serializable
  {
    public static final RecipientType BCC = new RecipientType(MimeDefine.BCC);
    public static final RecipientType CC;
    public static final RecipientType TO = new RecipientType(MimeDefine.TO);
    protected String type;
    
    static
    {
      CC = new RecipientType(MimeDefine.CC);
    }
    
    protected RecipientType(String paramString)
    {
      this.type = paramString;
    }
    
    protected Object readResolve()
      throws ObjectStreamException
    {
      if (this.type.equals(MimeDefine.TO)) {
        return TO;
      }
      if (this.type.equals(MimeDefine.TO)) {
        return CC;
      }
      if (this.type.equals(MimeDefine.BCC)) {
        return BCC;
      }
      throw new InvalidObjectException("Attempt to resolve unknown RecipientType: " + this.type);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.model.Message
 * JD-Core Version:    0.7.0.1
 */