package com.tencent.mobileqq.highway.transaction;

import com.tencent.mobileqq.highway.utils.BdhUtils;

public class DataTransInfo
{
  public int bitmapEnd;
  public int bitmapStart;
  public int errno;
  public int fileSize;
  public int length;
  public byte[] md5;
  public String md5Str;
  public int offset;
  public Transaction parent;
  public int retryTimes = 0;
  public long timeCost_cache = 0L;
  public long timeCost_hw = 0L;
  public long timeCost_req = 0L;
  
  public DataTransInfo(Transaction paramTransaction)
  {
    this.parent = paramTransaction;
  }
  
  public byte[] getData()
  {
    byte[] arrayOfByte = this.parent.getData(this);
    if (arrayOfByte != null)
    {
      this.md5 = BdhUtils.encode(arrayOfByte);
      this.md5Str = BdhUtils.bytes2HexStr(this.md5);
    }
    return arrayOfByte;
  }
  
  public void handleCancle()
  {
    byte[] arrayOfByte = this.parent.bitmap;
    int i = this.bitmapStart;
    while (i <= this.bitmapEnd)
    {
      arrayOfByte[i] = 0;
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.transaction.DataTransInfo
 * JD-Core Version:    0.7.0.1
 */