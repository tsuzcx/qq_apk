package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import java.io.Serializable;

public class TroopFileData
  extends Entity
  implements Serializable
{
  public static final long serialVersionUID = 0L;
  public String FromUin;
  public int bisID;
  public String dspFileName;
  public String dspFileSize;
  public int duration;
  public long entitySessionId;
  public String fileName;
  @unique
  public String fileUrl;
  public int height;
  public long lastTime;
  public long lfileSize;
  public String sha1;
  public String uuid;
  public int width;
  public String yybApkIconUrl;
  public String yybApkName;
  public String yybApkPackageName;
  
  public String toString()
  {
    return "TroopFileData{dspFileSize='" + this.dspFileSize + '\'' + ", dspFileName='" + this.dspFileName + '\'' + ", bisID=" + this.bisID + ", fileUrl='" + this.fileUrl + '\'' + ", fileName='" + this.fileName + '\'' + ", lfileSize=" + this.lfileSize + ", uuid='" + this.uuid + '\'' + ", FromUin='" + this.FromUin + '\'' + ", lastTime=" + this.lastTime + ", entitySessionId=" + this.entitySessionId + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.TroopFileData
 * JD-Core Version:    0.7.0.1
 */