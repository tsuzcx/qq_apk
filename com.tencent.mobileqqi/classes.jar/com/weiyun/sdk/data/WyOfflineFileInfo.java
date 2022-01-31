package com.weiyun.sdk.data;

public class WyOfflineFileInfo
{
  public static final int OFFLINE_FILE_TYPE_ALL = 2;
  public static final int OFFLINE_FILE_TYPE_RECEIVE = 0;
  public static final int OFFLINE_FILE_TYPE_SEND = 1;
  public boolean bSend;
  public int dangerLevel;
  public String fileName;
  public long fileSize;
  public String guid;
  public long lifeTime;
  public long uin;
  public long uploadTime;
  
  public String toString()
  {
    return "WyOfflineFileInfo [bSend=" + this.bSend + ", guid=" + this.guid + ", uin=" + this.uin + ", fileName=" + this.fileName + ", fileSize=" + this.fileSize + ", lifeTime=" + this.lifeTime + ", uploadTime=" + this.uploadTime + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.weiyun.sdk.data.WyOfflineFileInfo
 * JD-Core Version:    0.7.0.1
 */