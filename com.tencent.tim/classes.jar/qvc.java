import android.support.annotation.Nullable;

public class qvc
{
  public String avr;
  public String mFeedId;
  public int mSource;
  public int mType = -1;
  
  public qvc(String paramString1, int paramInt, @Nullable String paramString2)
  {
    this.mFeedId = paramString1;
    this.avr = paramString2;
    this.mSource = paramInt;
  }
  
  public qvc(String paramString1, int paramInt1, @Nullable String paramString2, int paramInt2)
  {
    this.mFeedId = paramString1;
    this.avr = paramString2;
    this.mSource = paramInt1;
    this.mType = paramInt2;
  }
  
  public boolean isOpen()
  {
    return (this.mSource != 1) && ((this.mSource != 2) || (this.mType != 0));
  }
  
  public String toString()
  {
    return "FeedCommentSync{feedId='" + this.mFeedId + '\'' + ", mNextCookie='" + this.avr + '\'' + ", mSource=" + this.mSource + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qvc
 * JD-Core Version:    0.7.0.1
 */