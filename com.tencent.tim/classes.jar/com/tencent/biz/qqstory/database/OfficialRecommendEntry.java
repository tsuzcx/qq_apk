package com.tencent.biz.qqstory.database;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class OfficialRecommendEntry
  extends Entity
{
  public int bigvColor;
  public String bigvCover;
  public String bigvDesc;
  public int bigvFans;
  public int bigvId;
  public String bigvLog;
  public String bigvUserHeadUrl;
  public boolean bigvUserIsVip;
  public String bigvUserNickName;
  public String bigvUserRemark;
  public String bigvUserSymbolUrl;
  public String bigvUserUnionId;
  public boolean isMarkRead;
  @unique
  public int itemId;
  public int linkColor;
  public String linkCover;
  public String linkDesc;
  public int linkId;
  public String linkLogo;
  public String linkUrl;
  public boolean topicCanJoin;
  public int topicColor;
  public String topicCover;
  public String topicDesc;
  public long topicId;
  public String topicLogo;
  public String topicName;
  public int type;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.database.OfficialRecommendEntry
 * JD-Core Version:    0.7.0.1
 */