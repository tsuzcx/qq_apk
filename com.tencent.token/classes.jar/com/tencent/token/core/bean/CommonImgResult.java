package com.tencent.token.core.bean;

import android.graphics.Bitmap;
import java.io.Serializable;

public class CommonImgResult
  implements Serializable
{
  private static final long serialVersionUID = 4858996832142963048L;
  public Bitmap mBmp;
  public String mUrl;
  
  public CommonImgResult(String paramString, Bitmap paramBitmap)
  {
    this.mUrl = paramString;
    this.mBmp = paramBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.bean.CommonImgResult
 * JD-Core Version:    0.7.0.1
 */