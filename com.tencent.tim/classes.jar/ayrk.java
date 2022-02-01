import android.graphics.Bitmap;

public class ayrk
{
  public String displayName;
  public String fileMd5;
  public String filePath;
  public Bitmap iconBitmap;
  public String iconUrl;
  public boolean isNewTroop;
  public boolean isSend;
  public boolean isVideo;
  public int messageType;
  public int operateStatus;
  public int progress;
  String thumbPath;
  public String troopUin;
  public String uin;
  public long uniseq;
  
  public void eTl()
  {
    this.operateStatus = 0;
    this.progress = 0;
    this.filePath = "";
    this.fileMd5 = "";
    this.uniseq = 0L;
    this.isSend = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayrk
 * JD-Core Version:    0.7.0.1
 */