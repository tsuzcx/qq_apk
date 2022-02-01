package com.tencent.superplayer.preload;

import android.app.Activity;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.utils.ThreadUtil;
import com.tencent.superplayer.view.ISPlayerVideoView;

public class PreloadUtils
{
  static ISPlayerVideoView createCleanTextureView(Activity paramActivity)
  {
    ViewGroup localViewGroup = (ViewGroup)paramActivity.getWindow().getDecorView();
    paramActivity = SuperPlayerFactory.createPlayerVideoView(paramActivity);
    paramActivity.addViewCallBack(new PreloadUtils.1(localViewGroup, paramActivity));
    ThreadUtil.runOnUiThread(new PreloadUtils.2(localViewGroup, paramActivity));
    return paramActivity;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.superplayer.preload.PreloadUtils
 * JD-Core Version:    0.7.0.1
 */