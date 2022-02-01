package org.libpag;

public class PAGMarker
{
  public String mComment;
  public long mDuration;
  public long mStartTime;
  
  public PAGMarker(long paramLong1, long paramLong2, String paramString)
  {
    this.mStartTime = paramLong1;
    this.mDuration = paramLong2;
    this.mComment = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.libpag.PAGMarker
 * JD-Core Version:    0.7.0.1
 */