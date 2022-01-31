package com.tmsdk.base.utils;

public class PhoneInfoFetcher$SizeInfo
{
  public long availdSize;
  public long totalSize;
  
  public int percent()
  {
    int i = 0;
    if (this.totalSize > 0L) {
      i = (int)((float)(this.totalSize - this.availdSize) / (float)this.totalSize * 100.0F);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tmsdk.base.utils.PhoneInfoFetcher.SizeInfo
 * JD-Core Version:    0.7.0.1
 */