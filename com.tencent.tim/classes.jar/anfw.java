public class anfw
  extends anfp
{
  public anfw.a a;
  public long aeM;
  public boolean cFp;
  public String cdA;
  public String cdB = "";
  public String cdC = "";
  public int dFm;
  public int dFn;
  public int dFo;
  public int dFp;
  public int fileFormat;
  public int fileHeight;
  public String fileName;
  public int fileSize;
  public String fileSource;
  public int fileWidth;
  public int forwardID;
  public int fromChatType;
  public String fromUin;
  public String hotVideoTitle = "";
  public String hotVideoUrl = "";
  public boolean isStoryVideo;
  public String localPath;
  public Object message;
  public int msgTailType;
  public int redBagType;
  public String shortVideoId = "";
  public int specialVideoType;
  public boolean supportProgressive;
  public String templateId = "";
  public String templateName = "";
  public int thumbFileSize;
  public int thumbHeight;
  public String thumbPath;
  public int thumbWidth;
  public int toChatType;
  
  public String toLogString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nShortVideoForwardInfo");
    localStringBuilder.append("\n |-").append("fromChatType:").append(this.fromChatType);
    localStringBuilder.append("\n |-").append("toChatType:").append(this.toChatType);
    localStringBuilder.append("\n |-").append("fromBusiType:").append(this.dFm);
    localStringBuilder.append("\n |-").append("toBusiType:").append(this.dFn);
    localStringBuilder.append("\n |-").append("localPath:").append(this.localPath);
    localStringBuilder.append("\n |-").append("md5:").append(this.md5);
    localStringBuilder.append("\n |-").append("thumbPath:").append(this.thumbPath);
    localStringBuilder.append("\n |-").append("thumbWidth:").append(this.thumbWidth);
    localStringBuilder.append("\n |-").append("thumbHeight:").append(this.thumbHeight);
    localStringBuilder.append("\n |-").append("sendSizeSpec:").append(this.fileSize);
    localStringBuilder.append("\n |-").append("fileTime:").append(this.dFo);
    localStringBuilder.append("\n |-").append("fileSource:").append(this.fileSource);
    localStringBuilder.append("\n |-").append("uuid:").append(this.uuid);
    localStringBuilder.append("\n |-").append("fromUin:").append(this.fromUin);
    localStringBuilder.append("\n |-").append("fromSessionUin:").append(this.cdA);
    localStringBuilder.append("\n |-").append("supportProgressive:").append(this.supportProgressive);
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
 * Qualified Name:     anfw
 * JD-Core Version:    0.7.0.1
 */