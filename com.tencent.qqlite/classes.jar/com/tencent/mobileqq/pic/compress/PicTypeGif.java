package com.tencent.mobileqq.pic.compress;

import com.tencent.mobileqq.pic.CompressInfo;

public class PicTypeGif
  extends PicType
{
  PicTypeGif(CompressInfo paramCompressInfo)
  {
    super(paramCompressInfo);
  }
  
  protected PicQuality a()
  {
    return new PicQualityOriginal(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pic.compress.PicTypeGif
 * JD-Core Version:    0.7.0.1
 */