package com.tencent.mobileqq.troop.homework.entry.ui.view;

import ahbj;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.widget.ImageView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

final class GuideViewPager$1
  implements Runnable
{
  GuideViewPager$1(String paramString, ImageView paramImageView) {}
  
  public void run()
  {
    try
    {
      if (ahbj.isFileExists(this.val$path))
      {
        Object localObject = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
        BitmapFactory.decodeFile(this.val$path, (BitmapFactory.Options)localObject);
        ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
        localObject = BitmapFactory.decodeFile(this.val$path, (BitmapFactory.Options)localObject);
        ThreadManager.getUIHandler().post(new GuideViewPager.1.1(this, (Bitmap)localObject));
      }
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      QLog.e("setBitmapByPath", 2, localOutOfMemoryError.getStackTrace());
      return;
    }
    catch (Exception localException)
    {
      QLog.e("setBitmapByPath", 2, localException.getStackTrace());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.entry.ui.view.GuideViewPager.1
 * JD-Core Version:    0.7.0.1
 */