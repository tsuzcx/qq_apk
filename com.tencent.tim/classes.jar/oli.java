public class oli
{
  public String aql;
  public String aqm;
  public int bfp;
  public String id;
  public String mCoverUrl;
  public int mDuration;
  public int mHeight;
  public String mTitle;
  public int mVideoPoolType;
  public int mVideoType;
  public String mVideoUrl;
  public int mWidth;
  public String traceId;
  
  public int rC()
  {
    if ((this.mWidth > 0) && (this.mHeight > 0) && (this.mHeight / this.mWidth > 1.33F)) {
      return 2;
    }
    return 0;
  }
  
  public int rD()
  {
    if ((this.mWidth > 0) && (this.mHeight > 0)) {
      return 0;
    }
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oli
 * JD-Core Version:    0.7.0.1
 */