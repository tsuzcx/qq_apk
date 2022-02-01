package com.tencent.mobileqq.qzonealbumreddot;

import allp;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;

public class QzoneAlbumRedTouchManager$2
  implements Runnable
{
  public QzoneAlbumRedTouchManager$2(allp paramallp) {}
  
  public void run()
  {
    SharedPreferences.Editor localEditor = allp.a(this.this$0).edit().putLong("key_photo_guide_has_red_date", System.currentTimeMillis());
    if (Build.VERSION.SDK_INT < 9)
    {
      localEditor.commit();
      return;
    }
    localEditor.apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qzonealbumreddot.QzoneAlbumRedTouchManager.2
 * JD-Core Version:    0.7.0.1
 */