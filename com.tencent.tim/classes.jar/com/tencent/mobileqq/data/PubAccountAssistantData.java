package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class PubAccountAssistantData
  extends Entity
{
  public int mDistance;
  public long mLastDraftTime;
  public long mLastMsgTime;
  public int mType;
  @unique
  public String mUin;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.PubAccountAssistantData
 * JD-Core Version:    0.7.0.1
 */