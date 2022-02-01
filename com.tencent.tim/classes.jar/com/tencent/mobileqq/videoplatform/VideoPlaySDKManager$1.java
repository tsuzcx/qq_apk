package com.tencent.mobileqq.videoplatform;

import android.content.Context;
import com.tencent.mobileqq.videoplatform.api.LoadSoCallback;
import com.tencent.mobileqq.videoplatform.util.ThreadUtil;
import com.tencent.superplayer.api.SuperPlayerSdkOption;

class VideoPlaySDKManager$1
  implements LoadSoCallback
{
  VideoPlaySDKManager$1(VideoPlaySDKManager paramVideoPlaySDKManager, Context paramContext, SuperPlayerSdkOption paramSuperPlayerSdkOption) {}
  
  public void onLoad(boolean paramBoolean)
  {
    VideoPlaySDKManager.access$002(this.this$0, paramBoolean);
    ThreadUtil.postOnSubThread(new VideoPlaySDKManager.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.videoplatform.VideoPlaySDKManager.1
 * JD-Core Version:    0.7.0.1
 */