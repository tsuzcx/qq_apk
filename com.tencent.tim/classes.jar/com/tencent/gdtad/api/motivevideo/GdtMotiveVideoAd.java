package com.tencent.gdtad.api.motivevideo;

import tis;
import tkw;
import tls;

public final class GdtMotiveVideoAd
  extends com.tencent.gdtad.api.GdtAd
{
  private tis params;
  
  public GdtMotiveVideoAd(tis paramtis)
  {
    super(paramtis);
    this.params = paramtis;
  }
  
  public int getErrorCode(com.tencent.gdtad.aditem.GdtAd paramGdtAd, int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt1 = super.getErrorCode(paramGdtAd, paramInt1, paramInt2, paramInt3);
    if (paramInt1 != 0) {
      return paramInt1;
    }
    if ((paramGdtAd == null) || (!isValid()))
    {
      tkw.e("GdtMotiveVideoAd", "getErrorCode error");
      return 1;
    }
    if (tls.fp(paramGdtAd.getCreativeSize())) {
      return 0;
    }
    return 7;
  }
  
  protected tis getParams()
  {
    return this.params;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.gdtad.api.motivevideo.GdtMotiveVideoAd
 * JD-Core Version:    0.7.0.1
 */