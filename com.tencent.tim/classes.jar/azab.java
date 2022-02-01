import android.text.TextUtils;

public class azab
  extends ayzy
{
  public boolean cFo;
  public int fileType;
  public int format;
  public String localPath;
  public int mRequestType;
  public int mSceneType;
  public String thumbPath;
  public int time;
  
  public boolean check()
  {
    if (TextUtils.isEmpty(this.uuid))
    {
      gT("ShortVideoDownloadInfo.check", "uuid invaid:" + this.uuid);
      return false;
    }
    if (this.selfUin == null)
    {
      gT("ShortVideoDownloadInfo", "selfUin invalid,selfUin:" + this.selfUin);
      return false;
    }
    return super.check();
  }
  
  public String toLogString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nShortVideoDownloadInfo");
    localStringBuilder.append("\n |-").append("md5:").append(this.md5);
    localStringBuilder.append("\n |-").append("uuid:").append(this.uuid);
    localStringBuilder.append("\n |-").append("fileType:").append(this.fileType);
    localStringBuilder.append("\n |-").append("format:").append(this.format);
    localStringBuilder.append("\n |-").append("mRequestType:").append(this.mRequestType);
    localStringBuilder.append("\n |-").append("mSceneType:").append(this.mSceneType);
    return localStringBuilder.toString();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(toLogString());
    localStringBuilder.append(super.toString());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     azab
 * JD-Core Version:    0.7.0.1
 */