package com.tencent.mobileqq.activity.aio.photo;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

class PhotoListPanel$3
  implements Runnable
{
  PhotoListPanel$3(PhotoListPanel paramPhotoListPanel, String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    this.this$0.pref.edit().putBoolean(this.val$key, this.bjR).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.3
 * JD-Core Version:    0.7.0.1
 */