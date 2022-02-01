import java.io.File;

public abstract class akxh
  extends akxn
{
  public String bUG;
  public int busiType = -1;
  public boolean cuF;
  public String localUUID;
  public String md5;
  public String peerUin;
  public int picExtraFlag;
  public Object picExtraObject;
  public String protocol;
  public String selfUin;
  public int subVersion = 5;
  public int uinType = -1;
  public long uniseq;
  
  public boolean check()
  {
    if (this.busiType == -1)
    {
      gT("PicBaseInfo.check", "busiType invalid,busiType:" + this.busiType);
      return false;
    }
    if (this.uinType == -1)
    {
      gT("PicBaseInfo.check", "uinType invalid,uinType:" + this.uinType);
      return false;
    }
    if (this.peerUin == null)
    {
      gT("PicBaseInfo.check", "peerUin invalid,peerUin:" + this.peerUin);
      return false;
    }
    return true;
  }
  
  public File getFile()
  {
    return aoiz.getFile(xN());
  }
  
  public String getFilePath()
  {
    return aoiz.getFilePath(xN());
  }
  
  public boolean hasFile()
  {
    return getFile() != null;
  }
  
  public String toLogString()
  {
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nPicBaseInfo");
    localStringBuilder.append("\n |-").append("localUUID:").append(this.localUUID);
    localStringBuilder.append("\n |-").append("uniseq:").append(this.uniseq);
    localStringBuilder.append("\n |-").append("busiType:").append(this.busiType);
    localStringBuilder.append("\n |-").append("selfUin:").append(this.selfUin);
    localStringBuilder.append("\n |-").append("peerUin:").append(this.peerUin);
    localStringBuilder.append("\n |-").append("secondId:").append(this.bUG);
    localStringBuilder.append("\n |-").append("md5:").append(this.md5);
    localStringBuilder.append("\n |-").append("errInfo:").append(this.b);
    return localStringBuilder.toString();
  }
  
  abstract String xN();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akxh
 * JD-Core Version:    0.7.0.1
 */