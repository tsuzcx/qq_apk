package com.tencent.mobileqq.pic.compress;

import com.tencent.mobileqq.pic.CompressInfo;
import dzs;

public class PicTypeLong
  extends PicType
{
  PicTypeLong(CompressInfo paramCompressInfo)
  {
    super(paramCompressInfo);
  }
  
  protected PicQuality a()
  {
    switch (this.a.g)
    {
    default: 
      return null;
    case 0: 
    case 1: 
      return new dzs(this, this);
    }
    return new PicQualityOriginal(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pic.compress.PicTypeLong
 * JD-Core Version:    0.7.0.1
 */