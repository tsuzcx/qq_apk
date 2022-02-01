package com.tencent.biz.qqstory.database;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class ReportWatchVideoEntry
  extends Entity
{
  public long createTime;
  public boolean isLiveVideo;
  public int source;
  @unique
  public String vid;
  public int vidType;
  public String videoUnionId;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.database.ReportWatchVideoEntry
 * JD-Core Version:    0.7.0.1
 */