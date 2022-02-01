package com.tencent.mobileqq.richstatus.comment.bean;

import amhr;
import java.io.Serializable;

public class CommentItem
  implements Serializable
{
  public String content;
  public String feedId;
  public long id;
  public long targetId;
  public long timeStamp;
  public amhr toReplyUser;
  public amhr user;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.comment.bean.CommentItem
 * JD-Core Version:    0.7.0.1
 */