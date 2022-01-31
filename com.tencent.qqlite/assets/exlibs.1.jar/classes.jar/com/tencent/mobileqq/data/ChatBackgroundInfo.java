package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class ChatBackgroundInfo
  extends Entity
{
  @unique
  public String id;
  public String name;
  public String thumb_url;
  public String type;
  public String url;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.ChatBackgroundInfo
 * JD-Core Version:    0.7.0.1
 */