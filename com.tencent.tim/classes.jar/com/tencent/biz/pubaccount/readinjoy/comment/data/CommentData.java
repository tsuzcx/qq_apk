package com.tencent.biz.pubaccount.readinjoy.comment.data;

import java.util.List;

public class CommentData
  extends BaseCommentData
{
  public static final int EXPOSURE_SUB_COMMMENT_COUNT = 2;
  public List<SubCommentData> subCommentList;
  public int subCommentNum;
  
  public int getSubCommentCnt()
  {
    return this.subCommentNum;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.data.CommentData
 * JD-Core Version:    0.7.0.1
 */