import java.util.UUID;

public class apcy
{
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
  public boolean cPV;
  public String coc;
  public int dTo;
  public int dTp;
  public int dTq;
  public long entrySessionID;
  public boolean genThumb_Middle_OnGettedLargeOrOrigPic;
  public String mExcitingSpeed;
  public String mParentId;
  public String sha1;
  public int thumbInvalidCode;
  public long uniseq;
  public String yybApkIconUrl;
  public String yybApkName;
  public String yybApkPackageName;
  
  public apcy()
  {
    this.Status = 7;
  }
  
  public apcy(apcy paramapcy)
  {
    e(paramapcy);
  }
  
  public void e(apcy paramapcy)
  {
    this.Status = 7;
    if (paramapcy != null)
    {
      this.Id = paramapcy.Id;
      this.SeqId = paramapcy.SeqId;
      this.uniseq = paramapcy.uniseq;
      this.TroopUin = paramapcy.TroopUin;
      this.Status = paramapcy.Status;
      this.ErrorCode = paramapcy.ErrorCode;
      this.ProgressTotal = paramapcy.ProgressTotal;
      this.ProgressValue = paramapcy.ProgressValue;
      this.LocalFile = paramapcy.LocalFile;
      this.ThumbnailFile_Small = paramapcy.ThumbnailFile_Small;
      this.ThumbnailFile_Large = paramapcy.ThumbnailFile_Large;
      this.coc = paramapcy.coc;
      this.dTo = paramapcy.dTo;
      this.dTp = paramapcy.dTp;
      this.dTq = paramapcy.dTq;
      this.FilePath = paramapcy.FilePath;
      this.FileName = paramapcy.FileName;
      this.BusId = paramapcy.BusId;
      this.NickName = paramapcy.NickName;
      this.mParentId = paramapcy.mParentId;
      this.cPV = paramapcy.cPV;
      this.mExcitingSpeed = paramapcy.mExcitingSpeed;
      this.thumbInvalidCode = paramapcy.thumbInvalidCode;
      this.genThumb_Middle_OnGettedLargeOrOrigPic = paramapcy.genThumb_Middle_OnGettedLargeOrOrigPic;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apcy
 * JD-Core Version:    0.7.0.1
 */