package com.tencent.superplayer.vinfo;

import android.content.Context;
import android.os.Looper;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;

public class VInfoGetter
{
  private VInfoGetterListener mListener;
  private TVideoImpl mTVideoImpl;
  
  public VInfoGetter(Context paramContext, Looper paramLooper)
  {
    this.mTVideoImpl = new TVideoImpl(paramContext, paramLooper);
  }
  
  public void doGetVInfo(SuperPlayerVideoInfo paramSuperPlayerVideoInfo)
  {
    switch (paramSuperPlayerVideoInfo.getVideoSource())
    {
    default: 
      return;
    }
    this.mTVideoImpl.doGetVInfo(paramSuperPlayerVideoInfo);
  }
  
  public void setListener(VInfoGetterListener paramVInfoGetterListener)
  {
    this.mTVideoImpl.setListener(paramVInfoGetterListener);
  }
  
  public static abstract interface VInfoGetterListener
  {
    public abstract void onGetVInfoFailed(SuperPlayerVideoInfo paramSuperPlayerVideoInfo, int paramInt1, int paramInt2, String paramString);
    
    public abstract void onGetVInfoSuccess(SuperPlayerVideoInfo paramSuperPlayerVideoInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.superplayer.vinfo.VInfoGetter
 * JD-Core Version:    0.7.0.1
 */