public class alwk
{
  public alwk.a b;
  public String bZa = "";
  public boolean czX;
  public int mID = 0;
  public String mIconUrl;
  public boolean mIsShow;
  public String mName;
  public int mPosition;
  
  public boolean auH()
  {
    return this.mID == 0;
  }
  
  public boolean isResourceReady()
  {
    return (this.b == null) || (this.b.mState == 2);
  }
  
  public String toString()
  {
    return "SubtitleItem{id=" + this.mID + " name=" + this.mName + " isShow=" + this.mIsShow + " pos=" + this.mPosition + "}";
  }
  
  public static class a
  {
    public String bYU = "";
    public String bZb = "";
    public int dyA;
    public int dyB = -1;
    public String mFile;
    public int mID;
    public String mMd5 = "";
    public String mName = "";
    public int mProgress;
    public int mState = 0;
    public String mTitle = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alwk
 * JD-Core Version:    0.7.0.1
 */