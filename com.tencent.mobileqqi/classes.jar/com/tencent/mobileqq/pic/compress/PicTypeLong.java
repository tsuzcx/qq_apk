package com.tencent.mobileqq.pic.compress;

import com.tencent.mobileqq.pic.CompressInfo;
import geb;

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
      return new geb(this, this);
    }
    return new PicQualityOriginal(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pic.compress.PicTypeLong
 * JD-Core Version:    0.7.0.1
 */