package com.tencent.mobileqq.mini.apkgEntity;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import java.util.Arrays;

@uniqueConstraints(clause=ConflictClause.REPLACE, columnNames="appId,entryPath")
public class MiniAppByIdEntity
  extends Entity
{
  public String appId;
  public String entryPath;
  public String extData;
  public byte[] extInfo;
  public String extendData;
  public byte[] first;
  public byte[] mDebug;
  public byte[] operInfo;
  public String shareTicket;
  public long timeStamp;
  
  public String toString()
  {
    return "MiniAppByIdEntity{appId='" + this.appId + '\'' + ", entryPath='" + this.entryPath + '\'' + ", timeStamp='" + this.timeStamp + '\'' + ", shareTicket='" + this.shareTicket + '\'' + ", first=" + Arrays.toString(this.first) + ", mDebug=" + Arrays.toString(this.mDebug) + ", extData='" + this.extData + '\'' + ", operInfo=" + Arrays.toString(this.operInfo) + ", extInfo=" + Arrays.toString(this.extInfo) + ", extendData='" + this.extendData + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.apkgEntity.MiniAppByIdEntity
 * JD-Core Version:    0.7.0.1
 */