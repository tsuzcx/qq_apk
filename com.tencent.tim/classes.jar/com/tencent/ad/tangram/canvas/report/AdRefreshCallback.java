package com.tencent.ad.tangram.canvas.report;

import android.support.annotation.Keep;
import com.tencent.ad.tangram.Ad;

@Keep
public abstract interface AdRefreshCallback
{
  public abstract void onAdRefresh(Ad paramAd);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.report.AdRefreshCallback
 * JD-Core Version:    0.7.0.1
 */