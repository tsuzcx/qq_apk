package com.tencent.mobileqq.activity.aio.doodle;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.util.MQLruCache;
import aqcu;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;

class DoodleMsgLayout$2
  implements Runnable
{
  DoodleMsgLayout$2(DoodleMsgLayout paramDoodleMsgLayout) {}
  
  public void run()
  {
    Bitmap localBitmap = aqcu.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130839658);
    if ((localBitmap != null) && (BaseApplicationImpl.sImageCache != null)) {
      BaseApplicationImpl.sImageCache.put("aio_doodle_progress", localBitmap, (byte)0);
    }
    new Handler(Looper.getMainLooper()).post(new DoodleMsgLayout.2.1(this, localBitmap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.DoodleMsgLayout.2
 * JD-Core Version:    0.7.0.1
 */