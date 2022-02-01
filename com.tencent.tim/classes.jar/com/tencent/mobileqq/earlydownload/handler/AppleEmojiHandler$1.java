package com.tencent.mobileqq.earlydownload.handler;

import acbn;
import afer;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;
import aofd;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;

public class AppleEmojiHandler$1
  implements Runnable
{
  public AppleEmojiHandler$1(afer paramafer, File paramFile, String paramString) {}
  
  public void run()
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    if (Build.VERSION.SDK_INT >= 24) {}
    for (String str = PreferenceManager.getDefaultSharedPreferencesName(localBaseApplication);; str = localBaseApplication.getPackageName() + "_preferences")
    {
      localBaseApplication.getSharedPreferences(str, 4).edit().putString("apple_emoji_file", acbn.SDCARD_PATH + "early/" + this.at.getName()).commit();
      aofd.F(this.at);
      afer.a(this.this$0, this.val$filepath);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.handler.AppleEmojiHandler.1
 * JD-Core Version:    0.7.0.1
 */