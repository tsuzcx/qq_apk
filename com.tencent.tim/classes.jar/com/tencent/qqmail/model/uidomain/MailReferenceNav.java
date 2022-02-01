package com.tencent.qqmail.model.uidomain;

public class MailReferenceNav
{
  private long id;
  private boolean isConv;
  private boolean isConvChild;
  
  public MailReferenceNav() {}
  
  public MailReferenceNav(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.id = paramLong;
    this.isConv = paramBoolean1;
    this.isConvChild = paramBoolean2;
  }
  
  public long getId()
  {
    return this.id;
  }
  
  public boolean isConv()
  {
    return this.isConv;
  }
  
  public boolean isConvChild()
  {
    return this.isConvChild;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.uidomain.MailReferenceNav
 * JD-Core Version:    0.7.0.1
 */