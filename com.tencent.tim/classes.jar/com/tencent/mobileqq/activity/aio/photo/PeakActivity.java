package com.tencent.mobileqq.activity.aio.photo;

import android.os.Bundle;
import anlm;
import axol;
import com.tencent.common.app.AppInterface;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.NativeVideoImage;
import com.tencent.mobileqq.app.BaseActivity2;

public class PeakActivity
  extends BaseActivity2
{
  @Deprecated
  protected AppInterface appInterface;
  protected boolean mNeedPauseRichMedia = true;
  
  protected void adjustStatusBar()
  {
    anlm.a(this.mSystemBarComp, getWindow());
  }
  
  public String getModuleId()
  {
    return "peak";
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setVolumeControlStream(3);
    if (!isLatecyWaitRuntime()) {
      axol.getAppInterface();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.mNeedPauseRichMedia)
    {
      NativeVideoImage.pauseAll();
      AbstractGifImage.pauseAll();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    NativeVideoImage.resumeAll();
    AbstractGifImage.resumeAll();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.PeakActivity
 * JD-Core Version:    0.7.0.1
 */