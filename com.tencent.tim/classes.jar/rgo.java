public class rgo
  implements Cloneable
{
  public final String awr;
  public final String aws;
  public final String awt;
  public final String awu;
  public final String awv;
  public final String aww;
  public final String awx;
  public final int mItemType;
  public String mLocalEmojiFolderPath;
  
  public rgo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    this.awr = paramString1;
    this.aws = paramString2;
    this.awt = null;
    this.awu = paramString3;
    this.awv = paramString4;
    this.awx = paramString5;
    this.aww = paramString6;
    this.mItemType = 1;
  }
  
  public rgo(qaf.a parama)
  {
    this.awr = parama.awr;
    this.aws = parama.aws;
    this.awt = parama.awt;
    this.awu = parama.awu;
    this.awv = parama.awv;
    this.awx = parama.awx;
    this.aww = parama.aww;
    this.mItemType = parama.mType;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass())) {
      return false;
    }
    paramObject = (rgo)paramObject;
    return this.awr.equals(paramObject.awr);
  }
  
  public String getLocalEmojiFolderPath()
  {
    return this.mLocalEmojiFolderPath;
  }
  
  public int hashCode()
  {
    return this.awr.hashCode();
  }
  
  public void setLocalEmojiFolderPath(String paramString)
  {
    this.mLocalEmojiFolderPath = paramString;
  }
  
  public String toString()
  {
    return "DoodleEmojiItem{mPackId='" + this.awr + '\'' + ", mLogoUrl='" + this.aws + '\'' + ", mDownloadLogoUrl='" + this.awt + '\'' + ", mPackName='" + this.awu + '\'' + ", mPackDownloadUrl='" + this.awv + '\'' + ", mPackMd5='" + this.aww + '\'' + ", mLocalEmojiFolderPath='" + this.mLocalEmojiFolderPath + '\'' + ", mConfig='" + this.awx + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rgo
 * JD-Core Version:    0.7.0.1
 */