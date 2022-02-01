package com.dataline.activities;

import android.graphics.Bitmap;
import aqcu;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import java.io.File;

final class LiteActivity$15
  implements Runnable
{
  LiteActivity$15(String paramString, LiteActivity.b paramb) {}
  
  public void run()
  {
    if (ChatBackgroundManager.z(new File(this.val$path))) {
      this.a.a(null, true);
    }
    Bitmap localBitmap;
    do
    {
      return;
      localBitmap = aqcu.decodeFile(this.val$path);
    } while (this.a == null);
    this.a.a(localBitmap, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.dataline.activities.LiteActivity.15
 * JD-Core Version:    0.7.0.1
 */