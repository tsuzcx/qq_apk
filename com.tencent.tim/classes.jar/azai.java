public class azai
  extends ayzy
{
  public azai.a a;
  public boolean cFA;
  public boolean cFz;
  public boolean cMb;
  public String cdH;
  public int ceG;
  public boolean dAH;
  public int dFo;
  public int dFp;
  public int fileHeight;
  public String fileSource;
  public int fileWidth;
  public String localPath;
  public boolean mediacodecEncode;
  public Object message;
  public boolean supportProgressive;
  public boolean syncToStory;
  public int thumbHeight;
  public String thumbPath;
  public int thumbWidth;
  
  public boolean check()
  {
    return super.check();
  }
  
  public String toLogString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nShortVideoUploadInfo");
    localStringBuilder.append("\n |-").append("localPath:").append(this.localPath);
    localStringBuilder.append("\n |-").append("md5:").append(this.md5);
    localStringBuilder.append("\n |-").append("thumbPath:").append(this.thumbPath);
    localStringBuilder.append("\n |-").append("thumbWidth:").append(this.thumbWidth);
    localStringBuilder.append("\n |-").append("thumbHeight:").append(this.thumbHeight);
    localStringBuilder.append("\n |-").append("sendSizeSpec:").append(this.ceG);
    localStringBuilder.append("\n |-").append("fileTime:").append(this.dFo);
    localStringBuilder.append("\n |-").append("fileSource:").append(this.fileSource);
    localStringBuilder.append("\n |-").append("supportProgressive:").append(this.supportProgressive);
    localStringBuilder.append("\n |-").append("fileWidth:").append(this.fileWidth);
    localStringBuilder.append("\n |-").append("fileHeight:").append(this.fileHeight);
    localStringBuilder.append("\n |-").append("isQIM:").append(this.dAH);
    return localStringBuilder.toString();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(toLogString());
    localStringBuilder.append(super.toString());
    return localStringBuilder.toString();
  }
  
  public static class a
  {
    public long msgUid;
    public long msgseq;
    public long shmsgseq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     azai
 * JD-Core Version:    0.7.0.1
 */