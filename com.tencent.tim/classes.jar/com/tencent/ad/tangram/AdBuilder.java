package com.tencent.ad.tangram;

import android.support.annotation.Keep;
import com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGetRsp.AdInfo;

@Keep
public final class AdBuilder
{
  public static Ad build(qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo)
  {
    return new a(paramAdInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.AdBuilder
 * JD-Core Version:    0.7.0.1
 */