public abstract class anfp
  extends anfx
{
  public String bUG;
  public int dFl = -1;
  public String mLocalMd5;
  public String md5;
  public String peerUin;
  public String selfUin;
  public String thumbMD5;
  public int uinType = -1;
  public long uniseq;
  public String uuid;
  
  public boolean check()
  {
    if (this.dFl == -1)
    {
      gT("ShortVideoBaseInfo.check", "reqBusiType invalid, reqBusiType:" + this.dFl);
      return false;
    }
    if (this.uinType == -1)
    {
      gT("ShortVideoBaseInfo.check", "uinType invalid,uinType:" + this.uinType);
      return false;
    }
    if (this.peerUin == null)
    {
      gT("ShortVideoBaseInfo.check", "peerUin invalid,peerUin:" + this.peerUin);
      return false;
    }
    return true;
  }
  
  public String toLogString()
  {
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nShortVideoBaseInfo");
    localStringBuilder.append("\n |-").append("localUUID:").append(this.uuid);
    localStringBuilder.append("\n |-").append("uniseq:").append(this.uniseq);
    localStringBuilder.append("\n |-").append("reqBusiType:").append(this.dFl);
    localStringBuilder.append("\n |-").append("selfUin:").append(this.selfUin);
    localStringBuilder.append("\n |-").append("peerUin:").append(this.peerUin);
    localStringBuilder.append("\n |-").append("secondId:").append(this.bUG);
    localStringBuilder.append("\n |-").append("md5:").append(this.md5);
    localStringBuilder.append("\n |-").append("thumbMD5:").append(this.thumbMD5);
    localStringBuilder.append("\n |-").append("errInfo:").append(this.b);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anfp
 * JD-Core Version:    0.7.0.1
 */