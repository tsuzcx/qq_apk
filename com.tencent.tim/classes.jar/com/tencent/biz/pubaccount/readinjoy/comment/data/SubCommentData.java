package com.tencent.biz.pubaccount.readinjoy.comment.data;

public class SubCommentData
  extends BaseCommentData
{
  public int hasTarget;
  public String parentCommentId;
  public String repliedUserHomePage;
  public String repliedUserNickname;
  public String repliedUserUin;
  
  public boolean hasTarget()
  {
    return this.hasTarget == 1;
  }
  
  public String toString()
  {
    return "SubCommentData{parentCommentId='" + this.parentCommentId + '\'' + ", repliedUserUin='" + this.repliedUserUin + '\'' + ", repliedUserNickname='" + this.repliedUserNickname + '\'' + ", repliedUserHomePage='" + this.repliedUserHomePage + '\'' + ", hasTarget=" + this.hasTarget + '\'' + super.toString() + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.data.SubCommentData
 * JD-Core Version:    0.7.0.1
 */