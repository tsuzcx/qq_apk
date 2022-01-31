package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;

public class SubAccountInfo
  extends Entity
{
  public byte[] cookie;
  public byte isbind;
  public long lasttime;
  public String serverErrorMsg = null;
  public int serverErrorType = 0;
  @Deprecated
  public String subname;
  public String subuin;
  public String trunkuin;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("SubAccountINfo,");
    localStringBuilder.append("subuin:").append(this.subuin).append(",subname:").append(this.subname).append(",trunk:").append(this.trunkuin).append(",isbind:").append(this.isbind).append(",lasttime:").append(this.lasttime).append(",serverErrorType:").append(this.serverErrorType).append(",serverErrorMsg:").append(this.serverErrorMsg);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.SubAccountInfo
 * JD-Core Version:    0.7.0.1
 */