package cooperation.troop_homework.model;

import apcy;
import java.io.Serializable;
import java.util.UUID;

public class HWTroopFileStatusInfo
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  public int BusId;
  public int ErrorCode;
  public String FileName;
  public String FilePath;
  public UUID Id;
  public boolean IsNewStatus;
  public String LocalFile;
  public String NickName;
  public long ProgressTotal;
  public long ProgressValue;
  public int SeqId;
  public int Status;
  public String ThumbnailFile_Large;
  public String ThumbnailFile_Small;
  public long TroopUin;
  public int UploadTime;
  public long entrySessionID;
  public String sha1;
  public long uniseq;
  
  public static HWTroopFileStatusInfo parse(apcy paramapcy)
  {
    if (paramapcy == null) {
      return null;
    }
    HWTroopFileStatusInfo localHWTroopFileStatusInfo = new HWTroopFileStatusInfo();
    localHWTroopFileStatusInfo.Id = paramapcy.Id;
    localHWTroopFileStatusInfo.SeqId = paramapcy.SeqId;
    localHWTroopFileStatusInfo.uniseq = paramapcy.uniseq;
    localHWTroopFileStatusInfo.TroopUin = paramapcy.TroopUin;
    localHWTroopFileStatusInfo.Status = paramapcy.Status;
    localHWTroopFileStatusInfo.IsNewStatus = paramapcy.IsNewStatus;
    localHWTroopFileStatusInfo.ErrorCode = paramapcy.ErrorCode;
    localHWTroopFileStatusInfo.UploadTime = paramapcy.UploadTime;
    localHWTroopFileStatusInfo.ProgressTotal = paramapcy.ProgressTotal;
    localHWTroopFileStatusInfo.ProgressValue = paramapcy.ProgressValue;
    localHWTroopFileStatusInfo.LocalFile = paramapcy.LocalFile;
    localHWTroopFileStatusInfo.ThumbnailFile_Small = paramapcy.ThumbnailFile_Small;
    localHWTroopFileStatusInfo.ThumbnailFile_Large = paramapcy.ThumbnailFile_Large;
    localHWTroopFileStatusInfo.FilePath = paramapcy.FilePath;
    localHWTroopFileStatusInfo.sha1 = paramapcy.sha1;
    localHWTroopFileStatusInfo.FileName = paramapcy.FileName;
    localHWTroopFileStatusInfo.BusId = paramapcy.BusId;
    localHWTroopFileStatusInfo.entrySessionID = paramapcy.entrySessionID;
    localHWTroopFileStatusInfo.NickName = paramapcy.NickName;
    return localHWTroopFileStatusInfo;
  }
  
  public apcy toTroopFileStatusInfo()
  {
    apcy localapcy = new apcy();
    localapcy.Id = this.Id;
    localapcy.SeqId = this.SeqId;
    localapcy.uniseq = this.uniseq;
    localapcy.TroopUin = this.TroopUin;
    localapcy.Status = this.Status;
    localapcy.IsNewStatus = this.IsNewStatus;
    localapcy.ErrorCode = this.ErrorCode;
    localapcy.UploadTime = this.UploadTime;
    localapcy.ProgressTotal = this.ProgressTotal;
    localapcy.ProgressValue = this.ProgressValue;
    localapcy.LocalFile = this.LocalFile;
    localapcy.ThumbnailFile_Small = this.ThumbnailFile_Small;
    localapcy.ThumbnailFile_Large = this.ThumbnailFile_Large;
    localapcy.FilePath = this.FilePath;
    localapcy.sha1 = this.sha1;
    localapcy.FileName = this.FileName;
    localapcy.BusId = this.BusId;
    localapcy.entrySessionID = this.entrySessionID;
    localapcy.NickName = this.NickName;
    return localapcy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.troop_homework.model.HWTroopFileStatusInfo
 * JD-Core Version:    0.7.0.1
 */