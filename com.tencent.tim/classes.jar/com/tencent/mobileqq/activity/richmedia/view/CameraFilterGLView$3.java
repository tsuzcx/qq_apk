package com.tencent.mobileqq.activity.richmedia.view;

import aaso;
import aeah;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import anks.a;
import aqhu;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.util.PtvFilterUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.os.MqqHandler;

class CameraFilterGLView$3
  implements Runnable
{
  CameraFilterGLView$3(CameraFilterGLView paramCameraFilterGLView, anks.a parama) {}
  
  public void run()
  {
    Bitmap localBitmap = (Bitmap)PtvFilterUtils.getBitmapFromSharedMem(CameraFilterGLView.a(this.this$0), CameraFilterGLView.b(this.this$0), this.a.dJi);
    this.a.dRn();
    if (TextUtils.isEmpty(CameraFilterGLView.a(this.this$0)))
    {
      aaso.Gt(3);
      return;
    }
    File localFile = new File(CameraFilterGLView.a(this.this$0));
    CameraFilterGLView.a(this.this$0, null);
    for (;;)
    {
      for (;;)
      {
        try
        {
          localObject = new Matrix();
          if (CameraFilterGLView.c(this.this$0) % 180 == 0)
          {
            ((Matrix)localObject).postRotate(CameraFilterGLView.c(this.this$0) + 180);
            ((Matrix)localObject).postScale(-1.0F, 1.0F);
            localObject = aeah.H(Bitmap.createBitmap(localBitmap, 0, 0, CameraFilterGLView.a(this.this$0), CameraFilterGLView.b(this.this$0), (Matrix)localObject, true));
            bool = aqhu.a((Bitmap)localObject, localFile);
          }
        }
        catch (Throwable localThrowable1)
        {
          Object localObject;
          boolean bool = false;
        }
        try
        {
          localBitmap.recycle();
          aqhu.cn(BaseApplicationImpl.getContext(), localFile.getAbsolutePath());
          BaseApplicationImpl.sImageCache.put(localFile.getAbsolutePath() + "#short_video_camera_preview_cache", localObject);
          CameraFilterGLView.a(this.this$0, 90);
          if (!bool) {
            break label279;
          }
          ThreadManager.getUIHandler().post(new CameraFilterGLView.3.1(this, localFile));
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("PtvFilterUtils", 2, "Capture picture failed, cacheSuccess == null.");
          return;
        }
        catch (Throwable localThrowable2)
        {
          label272:
          break label272;
        }
      }
      ((Matrix)localObject).postRotate(CameraFilterGLView.c(this.this$0));
      continue;
      localThrowable1.printStackTrace();
    }
    label279:
    ThreadManager.getUIHandler().post(new CameraFilterGLView.3.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.view.CameraFilterGLView.3
 * JD-Core Version:    0.7.0.1
 */