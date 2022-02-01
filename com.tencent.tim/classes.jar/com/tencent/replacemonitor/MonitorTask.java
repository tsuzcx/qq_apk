package com.tencent.replacemonitor;

import com.tencent.tmassistantbase.util.d;
import java.util.Map;

public class MonitorTask
{
  public String additionalId;
  public String appName;
  public int appType;
  public String cpChannelId;
  public String downloadUrl;
  public Map<String, String> externalParams;
  public String fileMd5;
  public String filePath;
  public long fileSize;
  public long id;
  public String installDir;
  public boolean isTencentDownload;
  public long lastModifedTime;
  public MonitorStep lastStep;
  public String packageName;
  public String traceId;
  public int versionCode;
  public long yybApkId;
  public long yybAppId;
  
  public MonitorTask() {}
  
  public MonitorTask(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    this.packageName = paramString1;
    this.versionCode = paramInt;
    this.downloadUrl = paramString2;
    this.filePath = paramString3;
  }
  
  public MonitorTask(String paramString1, int paramInt, String paramString2, String paramString3, long paramLong, String paramString4)
  {
    this(paramString1, paramInt, paramString2, paramString3);
    this.fileSize = paramLong;
    this.fileMd5 = paramString4;
  }
  
  public String toString()
  {
    return "MonitorTask:" + " id = " + this.id + " packageName = " + this.packageName + " versionCode = " + this.versionCode + " appName = " + this.appName + " fileSize = " + this.fileSize + " fileMd5 = " + this.fileMd5 + " cpChannelId = " + this.cpChannelId + " filePath = " + this.filePath + " downloadUrl = " + this.downloadUrl + " yybAppId = " + this.yybAppId + " yybApkId = " + this.yybApkId + " installDir = " + this.installDir + " lastModifedTime = " + this.lastModifedTime + " additionalId = " + this.additionalId + " traceId = " + this.traceId + " appType = " + this.appType + " lastStep = " + this.lastStep + " isTencentDownload = " + this.isTencentDownload + " externalParams = " + d.a(this.externalParams, "&");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.replacemonitor.MonitorTask
 * JD-Core Version:    0.7.0.1
 */