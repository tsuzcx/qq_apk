package com.tencent.mobileqq.mini.apkgEntity;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class MiniAppInfoEntity
  extends Entity
{
  public static final String TAG = "MiniAppInfoEntity";
  @unique
  public String appId;
  public byte[] appInfo;
  public long timeStamp;
  
  public String toString()
  {
    return "MiniAppInfoEntity{appId='" + this.appId + '\'' + ", timeStamp='" + this.timeStamp + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.apkgEntity.MiniAppInfoEntity
 * JD-Core Version:    0.7.0.1
 */