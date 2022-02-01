public class amue
{
  public String ccf;
  public String mAppName;
  public String mDescription;
  public int mID;
  public String mPath;
  public String mVersion;
  
  public amue(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.mID = paramInt;
    this.ccf = paramString3;
    this.mVersion = paramString2;
    this.mDescription = paramString4;
    this.mAppName = paramString1;
    this.mPath = paramString5;
  }
  
  public String getAppName()
  {
    return this.mAppName;
  }
  
  public String getAppVersion()
  {
    return this.mVersion;
  }
  
  public int getID()
  {
    return this.mID;
  }
  
  public String zo()
  {
    return this.mPath;
  }
  
  public String zp()
  {
    return this.ccf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amue
 * JD-Core Version:    0.7.0.1
 */