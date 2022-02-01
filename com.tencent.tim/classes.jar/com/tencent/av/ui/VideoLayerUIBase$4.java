package com.tencent.av.ui;

import acbn;
import ahbj;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import aqhu;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

class VideoLayerUIBase$4
  implements Runnable
{
  VideoLayerUIBase$4(VideoLayerUIBase paramVideoLayerUIBase, Bitmap paramBitmap, long paramLong) {}
  
  public void run()
  {
    new File(acbn.oM).mkdirs();
    Object localObject = new Matrix();
    ((Matrix)localObject).setScale(1.0F, -1.0F);
    Bitmap localBitmap = Bitmap.createBitmap(this.val$bitmap, 0, 0, this.val$bitmap.getWidth(), this.val$bitmap.getHeight(), (Matrix)localObject, true);
    localObject = new SimpleDateFormat("yyyyMMdd.HHmmss.SSS");
    localObject = ((SimpleDateFormat)localObject).format(new Date(System.currentTimeMillis())) + ".jpg";
    File localFile = new File(acbn.oM, (String)localObject);
    for (;;)
    {
      try
      {
        bool1 = ahbj.f(localBitmap, localFile.getAbsolutePath());
        QLog.w(this.this$0.TAG, 1, "tryScreenShot, screenShotFlag[" + this.pf + "], Exception", localException1);
      }
      catch (Exception localException1)
      {
        try
        {
          QLog.w(this.this$0.TAG, 1, "tryScreenShot, writeBitmapToFile, ret[" + bool1 + "]");
          bool2 = bool1;
          if (bool1)
          {
            aqhu.cn(BaseApplicationImpl.getContext(), localFile.getAbsolutePath());
            bool2 = bool1;
          }
          if (this.this$0.mApp != null) {
            this.this$0.mApp.l(new Object[] { Integer.valueOf(20001), Long.valueOf(this.pf), Boolean.valueOf(bool2), localFile.getAbsolutePath() });
          }
          this.val$bitmap.recycle();
          localBitmap.recycle();
          return;
        }
        catch (Exception localException2)
        {
          boolean bool1;
          boolean bool2;
          break label251;
        }
        localException1 = localException1;
        bool1 = false;
      }
      label251:
      bool2 = bool1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.VideoLayerUIBase.4
 * JD-Core Version:    0.7.0.1
 */