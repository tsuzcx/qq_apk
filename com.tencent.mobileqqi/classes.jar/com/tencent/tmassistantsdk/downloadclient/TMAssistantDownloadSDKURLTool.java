package com.tencent.tmassistantsdk.downloadclient;

import com.tencent.tmassistantsdk.d.a;
import com.tencent.tmassistantsdk.f.j;
import com.tencent.tmassistantsdk.protocol.jce.AppDetailParam;
import java.util.ArrayList;
import java.util.Iterator;

public class TMAssistantDownloadSDKURLTool
  implements ITMAssistantExchangeURLListenner
{
  protected static final String TAG = "TMAssistantDownloadSDKExchangeURL";
  protected static TMAssistantDownloadSDKURLTool mInstance = null;
  protected a engine = null;
  protected ITMAssistantExchangeURLListenner mListener = null;
  
  private TMAssistantDownloadSDKURLTool(ITMAssistantExchangeURLListenner paramITMAssistantExchangeURLListenner)
  {
    if (paramITMAssistantExchangeURLListenner != null)
    {
      this.mListener = paramITMAssistantExchangeURLListenner;
      this.engine = new a(this.mListener);
      return;
    }
    j.e("TMAssistantDownloadSDKExchangeURL", "ITMAssistantExchangeURLListenner listener shouldn't be null!");
  }
  
  public static TMAssistantDownloadSDKURLTool getInstance(ITMAssistantExchangeURLListenner paramITMAssistantExchangeURLListenner)
  {
    try
    {
      if (mInstance == null) {
        mInstance = new TMAssistantDownloadSDKURLTool(paramITMAssistantExchangeURLListenner);
      }
      paramITMAssistantExchangeURLListenner = mInstance;
      return paramITMAssistantExchangeURLListenner;
    }
    finally {}
  }
  
  public void exchangeUrlsFromPackageNames(ArrayList paramArrayList)
  {
    if (paramArrayList != null)
    {
      ArrayList localArrayList = new ArrayList();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        String[] arrayOfString = ((String)paramArrayList.next()).split(";");
        if ((arrayOfString != null) && (arrayOfString.length > 0))
        {
          AppDetailParam localAppDetailParam = new AppDetailParam();
          localAppDetailParam.packageName = arrayOfString[0];
          if (arrayOfString.length > 1) {
            localAppDetailParam.channelId = arrayOfString[1];
          }
          localArrayList.add(localAppDetailParam);
        }
      }
      if ((localArrayList.size() > 0) && (this.engine != null)) {
        this.engine.a(localArrayList);
      }
      return;
    }
    j.d("TMAssistantDownloadSDKExchangeURL", "packageNames is null!");
  }
  
  public void onExchangedURLSucceed(ArrayList paramArrayList, boolean paramBoolean)
  {
    if (this.mListener != null) {
      this.mListener.onExchangedURLSucceed(paramArrayList, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKURLTool
 * JD-Core Version:    0.7.0.1
 */