package com.tencent.qqmail.model;

public class MailAttribute
{
  public int conv_count;
  public boolean detail;
  public boolean star;
  public MailAttributeTag tag;
  public boolean unread;
  
  public MailAttribute() {}
  
  public MailAttribute(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt, MailAttributeTag paramMailAttributeTag)
  {
    this.detail = paramBoolean1;
    this.unread = paramBoolean2;
    this.star = paramBoolean3;
    this.conv_count = paramInt;
    this.tag = paramMailAttributeTag;
  }
  
  public boolean encode_mail_time_start(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.MailAttribute
 * JD-Core Version:    0.7.0.1
 */