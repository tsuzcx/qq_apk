public class aepa
{
  private String bAm;
  private int jumpType;
  private String jumpUrl;
  private int version;
  
  public void Hs(String paramString)
  {
    this.bAm = paramString;
  }
  
  public void LX(int paramInt)
  {
    this.jumpType = paramInt;
  }
  
  public int getJumpType()
  {
    return this.jumpType;
  }
  
  public String getJumpUrl()
  {
    return this.jumpUrl;
  }
  
  public int getVersion()
  {
    return this.version;
  }
  
  public void setJumpUrl(String paramString)
  {
    this.jumpUrl = paramString;
  }
  
  public void setVersion(int paramInt)
  {
    this.version = paramInt;
  }
  
  public String tC()
  {
    return this.bAm;
  }
  
  public String toString()
  {
    return "WatchTogetherBean{version=" + this.version + ", jumpType=" + this.jumpType + ", jumpUrl='" + this.jumpUrl + '\'' + ", jumpExtensionInfo='" + this.bAm + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aepa
 * JD-Core Version:    0.7.0.1
 */