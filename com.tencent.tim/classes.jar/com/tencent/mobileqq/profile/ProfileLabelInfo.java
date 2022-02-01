package com.tencent.mobileqq.profile;

import java.io.Serializable;

public class ProfileLabelInfo
  implements Serializable, Cloneable
{
  public static int STATUS_CHECKED = 1;
  public static int STATUS_NORMAL;
  public Long labelId;
  public String labelName;
  public int labelStatus = STATUS_NORMAL;
  public Long likeNum;
  public String typeId;
  
  public ProfileLabelInfo() {}
  
  public ProfileLabelInfo(Long paramLong1, Long paramLong2, String paramString)
  {
    this.labelId = paramLong1;
    this.labelName = paramString;
    this.likeNum = paramLong2;
  }
  
  public Object clone()
  {
    try
    {
      Object localObject = super.clone();
      return localObject;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException) {}
    return this;
  }
  
  public void toggleStatus()
  {
    if (this.labelStatus == STATUS_NORMAL) {
      this.labelStatus = STATUS_CHECKED;
    }
    while (this.labelStatus != STATUS_CHECKED) {
      return;
    }
    this.labelStatus = STATUS_NORMAL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.ProfileLabelInfo
 * JD-Core Version:    0.7.0.1
 */