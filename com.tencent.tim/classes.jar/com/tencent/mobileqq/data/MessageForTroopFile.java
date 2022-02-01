package com.tencent.mobileqq.data;

import acfp;
import aczw;

public class MessageForTroopFile
  extends ChatMessage
{
  public static final String TAG = "MessageForTroopFile";
  public String FromUin;
  public boolean bReported = false;
  public int bisID;
  public String dspFileName;
  public String dspFileSize;
  public int duration;
  public long entitySessionId;
  public String fileName;
  public long fileSize;
  public int height;
  public boolean isPause;
  public long lastTime;
  public String sha1;
  public String url;
  public String uuid;
  public int width;
  public String yybApkIconUrl;
  public String yybApkName;
  public String yybApkPackageName;
  
  public void doParse()
  {
    try
    {
      TroopFileData localTroopFileData = (TroopFileData)aczw.c(this.msgData);
      if (localTroopFileData != null)
      {
        this.url = localTroopFileData.fileUrl;
        this.sha1 = localTroopFileData.sha1;
        this.dspFileSize = localTroopFileData.dspFileSize;
        this.dspFileName = localTroopFileData.dspFileName;
        this.bisID = localTroopFileData.bisID;
        this.uuid = localTroopFileData.uuid;
        this.fileSize = localTroopFileData.lfileSize;
        this.fileName = localTroopFileData.fileName;
        this.FromUin = localTroopFileData.FromUin;
        this.lastTime = localTroopFileData.lastTime;
        this.entitySessionId = localTroopFileData.entitySessionId;
        this.width = localTroopFileData.width;
        this.height = localTroopFileData.height;
        this.duration = localTroopFileData.duration;
        this.yybApkPackageName = localTroopFileData.yybApkPackageName;
        this.yybApkName = localTroopFileData.yybApkName;
        this.yybApkIconUrl = localTroopFileData.yybApkIconUrl;
      }
      this.msg = acfp.m(2131708147);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        Object localObject = null;
      }
    }
  }
  
  public String getSummaryMsg()
  {
    return acfp.m(2131708196) + this.fileName;
  }
  
  public boolean isSupportReply()
  {
    return true;
  }
  
  public void postRead()
  {
    parse();
  }
  
  public void prewrite()
  {
    serial();
  }
  
  public void serial()
  {
    TroopFileData localTroopFileData = new TroopFileData();
    localTroopFileData.fileUrl = this.url;
    localTroopFileData.sha1 = this.sha1;
    localTroopFileData.fileName = this.fileName;
    localTroopFileData.dspFileName = this.dspFileName;
    localTroopFileData.dspFileSize = this.dspFileSize;
    localTroopFileData.bisID = this.bisID;
    localTroopFileData.uuid = this.uuid;
    localTroopFileData.lfileSize = this.fileSize;
    localTroopFileData.FromUin = this.FromUin;
    localTroopFileData.lastTime = this.lastTime;
    localTroopFileData.entitySessionId = this.entitySessionId;
    localTroopFileData.width = this.width;
    localTroopFileData.height = this.height;
    localTroopFileData.duration = this.duration;
    localTroopFileData.yybApkPackageName = this.yybApkPackageName;
    localTroopFileData.yybApkName = this.yybApkName;
    localTroopFileData.yybApkIconUrl = this.yybApkIconUrl;
    try
    {
      this.msgData = aczw.b(localTroopFileData);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForTroopFile
 * JD-Core Version:    0.7.0.1
 */