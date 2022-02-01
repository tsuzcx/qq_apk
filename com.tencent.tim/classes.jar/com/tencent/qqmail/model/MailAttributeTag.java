package com.tencent.qqmail.model;

public class MailAttributeTag
{
  public int tag_count;
  public int[] tag_ids;
  
  public MailAttributeTag() {}
  
  public MailAttributeTag(int paramInt, int[] paramArrayOfInt)
  {
    this.tag_count = paramInt;
    this.tag_ids = paramArrayOfInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.MailAttributeTag
 * JD-Core Version:    0.7.0.1
 */