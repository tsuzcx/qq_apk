package com.tencent.mobileqq.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;

public class AudioUtil
{
  @TargetApi(8)
  public static boolean a(Context paramContext, boolean paramBoolean)
  {
    boolean bool = true;
    if (paramContext == null) {
      if (QLog.isColorLevel()) {
        QLog.d("AudioUtil", 2, "context is null.");
      }
    }
    do
    {
      return false;
      if (VersionUtils.b()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("AudioUtil", 2, "Android 2.1 and below can not stop music");
    return false;
    paramContext = (AudioManager)paramContext.getSystemService("audio");
    if (paramBoolean) {
      if (paramContext.requestAudioFocus(null, 3, 2) == 1) {
        bool = true;
      }
    }
    while (paramContext.abandonAudioFocus(null) == 1) {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AudioUtil", 2, "pauseMusic bMute=" + paramBoolean + " result=" + bool);
        }
        return bool;
        bool = false;
      }
    }
    for (;;)
    {
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.AudioUtil
 * JD-Core Version:    0.7.0.1
 */