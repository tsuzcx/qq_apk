package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StReply;
import ovd;

public class QCircleCommentUpdateEvent
  extends SimpleBaseEvent
{
  public static final int EVENT_ADD_COMMENT = 1;
  public static final int EVENT_ADD_REPLY = 3;
  public static final int EVENT_CANCEL_STICKY_COMMENT = 7;
  public static final int EVENT_COMMENT_TOTAL_NUM = 5;
  public static final int EVENT_DELETE_COMMENT = 2;
  public static final int EVENT_DELETE_REPLY = 4;
  public static final int EVENT_STICKY_COMMENT = 6;
  public FeedCloudMeta.StComment comment;
  public int commentTotalNum;
  public int eventStatus;
  public String feedId;
  public String mFakeReplyId;
  public FeedCloudMeta.StReply reply;
  
  public QCircleCommentUpdateEvent(int paramInt1, String paramString, int paramInt2)
  {
    this.eventStatus = paramInt1;
    this.feedId = paramString;
    this.commentTotalNum = paramInt2;
  }
  
  public QCircleCommentUpdateEvent(int paramInt1, String paramString, FeedCloudMeta.StComment paramStComment, int paramInt2)
  {
    this.eventStatus = paramInt1;
    this.feedId = paramString;
    this.comment = ovd.b(paramStComment);
    this.commentTotalNum = paramInt2;
  }
  
  public QCircleCommentUpdateEvent(int paramInt1, String paramString, FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply, int paramInt2)
  {
    this.eventStatus = paramInt1;
    this.feedId = paramString;
    this.comment = ovd.b(paramStComment);
    this.reply = ovd.a(paramStReply);
    this.commentTotalNum = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.events.QCircleCommentUpdateEvent
 * JD-Core Version:    0.7.0.1
 */