package com.tencent.superplayer.utils;

import android.content.Context;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.superplayer.api.SuperPlayerSDKMgr;

public class DisplayUtil
{
  public static int getScreenHeight()
  {
    if (SuperPlayerSDKMgr.getContext() != null)
    {
      WindowManager localWindowManager = (WindowManager)SuperPlayerSDKMgr.getContext().getSystemService("window");
      if (localWindowManager.getDefaultDisplay() != null) {
        return localWindowManager.getDefaultDisplay().getHeight();
      }
    }
    return 0;
  }
  
  public static int getScreenWidth()
  {
    if (SuperPlayerSDKMgr.getContext() != null)
    {
      WindowManager localWindowManager = (WindowManager)SuperPlayerSDKMgr.getContext().getSystemService("window");
      if (localWindowManager.getDefaultDisplay() != null) {
        return localWindowManager.getDefaultDisplay().getWidth();
      }
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.superplayer.utils.DisplayUtil
 * JD-Core Version:    0.7.0.1
 */