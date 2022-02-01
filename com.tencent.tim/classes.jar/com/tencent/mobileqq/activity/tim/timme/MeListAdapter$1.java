package com.tencent.mobileqq.activity.tim.timme;

import abcg;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.util.MQLruCache;
import android.widget.ImageView;
import aunr;
import auns;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class MeListAdapter$1
  implements Runnable
{
  public MeListAdapter$1(abcg paramabcg, File paramFile, aunr paramaunr, String paramString, ImageView paramImageView) {}
  
  public void run()
  {
    if (this.val$file.exists())
    {
      Object localObject = auns.d(this.val$file);
      if (localObject == null) {
        break label120;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MeListAdapter", 2, "found bitmap from sdcard, info=" + this.a.c.strResName);
      }
      BaseApplicationImpl.sImageCache.put(this.bfm, localObject);
      this.a.icon = new BitmapDrawable((Bitmap)localObject);
      localObject = this.a.icon;
      ((BaseActivity)abcg.a(this.this$0)).runOnUiThread(new MeListAdapter.1.1(this, (Drawable)localObject));
    }
    label120:
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("MeListAdapter", 2, "can't find bitmap form cache & sdcard" + this.a.c.strResName);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.tim.timme.MeListAdapter.1
 * JD-Core Version:    0.7.0.1
 */