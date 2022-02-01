package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class AppShareID
  extends Entity
{
  public String appstorelink;
  public String bundleid;
  public String messagetail;
  public String officalwebsite;
  public short sLanType;
  public short sPriority;
  public short sResType;
  public String sourceUrl;
  @unique
  public String strPkgName;
  public String strResDesc;
  public String strResName;
  public String strResURL_big;
  public String strResURL_small;
  public long uiNewVer;
  @unique
  public long uiResID;
  public long updateTime;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(200);
    localStringBuilder.append("[strPkgName = ").append(this.strPkgName).append("; uiResID = ").append(this.uiResID).append("; uiNewVer = ").append(this.uiNewVer).append("; messagetail = ").append(this.messagetail).append("; bundleid = ").append(this.bundleid).append("; sourceUrl = ").append(this.sourceUrl).append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.AppShareID
 * JD-Core Version:    0.7.0.1
 */