package com.tencent.image;

import android.content.Context;
import android.media.AudioManager;
import android.os.Build.VERSION;
import com.tencent.qphone.base.util.BaseApplication;

public class AudioUtils
{
  public static void abandonAudioFoucus()
  {
    if (Build.VERSION.SDK_INT >= 8)
    {
      BaseApplication localBaseApplication = BaseApplication.getContext();
      if (localBaseApplication != null) {
        ((AudioManager)localBaseApplication.getSystemService("audio")).abandonAudioFocus(null);
      }
    }
  }
  
  public static void requesetAudioFoucus()
  {
    if (Build.VERSION.SDK_INT >= 8)
    {
      BaseApplication localBaseApplication = BaseApplication.getContext();
      if (localBaseApplication != null) {
        ((AudioManager)localBaseApplication.getSystemService("audio")).requestAudioFocus(null, 3, 2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.image.AudioUtils
 * JD-Core Version:    0.7.0.1
 */