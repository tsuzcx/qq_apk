public class angt
  extends anfp
{
  public angt.a a;
  public long akZ;
  public boolean cFA;
  public boolean cFB;
  public boolean cFC;
  public boolean cFz = true;
  public String cdB = "";
  public String cdC = "";
  public String cdH;
  public String cdI = "";
  public int ceG;
  public boolean cjw;
  public int dFo;
  public int dFp;
  public int fileHeight;
  public String fileSource;
  public int fileWidth;
  public String hotVideoTitle = "";
  public String hotVideoUrl = "";
  public String localPath;
  public boolean mediacodecEncode;
  public Object message;
  public int msgTailType;
  public String originalFilePath;
  public int redBagType;
  public boolean sendRawVideo;
  public String shortVideoId;
  public int specialVideoType;
  public boolean supportProgressive;
  public boolean syncToStory;
  public String templateId;
  public String templateName;
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
    localStringBuilder.append("\n |-").append("templateId:").append(this.templateId);
    localStringBuilder.append("\n |-").append("templateName:").append(this.templateName);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     angt
 * JD-Core Version:    0.7.0.1
 */