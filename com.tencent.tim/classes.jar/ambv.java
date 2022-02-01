public class ambv
{
  public boolean cCb = true;
  public long mFileLength;
  public int mHeight;
  public int mIndex;
  public String mMd5;
  public String mPath;
  public long mStartTime;
  public long mTimestamp;
  public int mType;
  public int mVideoDuration;
  public int mWidth;
  
  public boolean avl()
  {
    return this.mType == 4;
  }
  
  public boolean avm()
  {
    return this.mType == 3;
  }
  
  public boolean avn()
  {
    return this.mType == 5;
  }
  
  public String toString()
  {
    return "SegmentSendInfo{mPath='" + this.mPath + '\'' + ", mMd5='" + this.mMd5 + '\'' + ", mFileLength=" + this.mFileLength + ", mWidth=" + this.mWidth + ", mHeight=" + this.mHeight + ", mType=" + this.mType + ", mIndex=" + this.mIndex + ", mTimestamp=" + this.mTimestamp + ", mStartTime=" + this.mStartTime + ", mVideoDuration=" + this.mVideoDuration + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ambv
 * JD-Core Version:    0.7.0.1
 */