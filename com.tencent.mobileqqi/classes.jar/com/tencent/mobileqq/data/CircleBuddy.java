package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.richstatus.RichStatus;

public class CircleBuddy
  extends Entity
{
  public static final String FIELD_GROUP_ID = "groupId";
  public volatile long checkUpdateTime;
  public int closeness;
  public int groupId;
  public String nickName;
  @notColumn
  public int randomCloseness;
  public String remark;
  @notColumn
  public long reqCheckTimeFlag;
  public byte[] richBuffer;
  @notColumn
  private RichStatus richStatus;
  public long richTime;
  @unique
  public String uin;
  
  public RichStatus getRichStatus(boolean paramBoolean)
  {
    if (this.richStatus == null)
    {
      if ((this.richTime > 0L) && (paramBoolean)) {
        return RichStatus.a();
      }
      if (this.richTime <= 0L) {
        break label60;
      }
      this.richStatus = RichStatus.a(this.richBuffer);
      this.richStatus.a = this.richTime;
    }
    for (;;)
    {
      return this.richStatus;
      label60:
      this.richStatus = RichStatus.a();
    }
  }
  
  public void setRichBuffer(byte[] paramArrayOfByte, long paramLong)
  {
    this.richStatus = null;
    this.richBuffer = paramArrayOfByte;
    this.richTime = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.CircleBuddy
 * JD-Core Version:    0.7.0.1
 */