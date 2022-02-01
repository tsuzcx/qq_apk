package com.tencent.biz.subscribe.event;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class RecommendFeedbackEvent
  extends SimpleBaseEvent
{
  public static final int FEEDBACK_TYPE_RECOMMEND_BANNER_FEED = 2;
  public static final int FEEDBACK_TYPE_RECOMMEND_BANNER_USER = 1;
  public CertifiedAccountMeta.StFeed feed;
  public int type;
  public CertifiedAccountMeta.StUser user;
  
  public RecommendFeedbackEvent(CertifiedAccountMeta.StFeed paramStFeed)
  {
    this.feed = paramStFeed;
    this.type = 2;
  }
  
  public RecommendFeedbackEvent(CertifiedAccountMeta.StUser paramStUser)
  {
    this.user = paramStUser;
    this.type = 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.event.RecommendFeedbackEvent
 * JD-Core Version:    0.7.0.1
 */