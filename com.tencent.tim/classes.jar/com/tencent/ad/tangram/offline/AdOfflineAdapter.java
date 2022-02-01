package com.tencent.ad.tangram.offline;

import android.support.annotation.Keep;

@Keep
public abstract interface AdOfflineAdapter
{
  public abstract String getAppVersion();
  
  public abstract String getVersionIfExists(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.offline.AdOfflineAdapter
 * JD-Core Version:    0.7.0.1
 */