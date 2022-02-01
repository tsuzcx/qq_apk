package com.tencent.qqmini.miniapp.widget.camera;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.util.Log;
import com.tencent.qqmini.miniapp.util.CameraCompatibleList;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.io.File;

class MiniAppCamera$2$1
  implements Runnable
{
  MiniAppCamera$2$1(MiniAppCamera.2 param2, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    Log.i("MiniAppCamera", "run: onPictureTaken");
    long l4;
    try
    {
      long l1 = Runtime.getRuntime().totalMemory() / 1024L;
      long l2 = Runtime.getRuntime().maxMemory() / 1024L;
      long l3 = Runtime.getRuntime().freeMemory() / 1024L;
      l4 = l2 - (l1 - l3);
      if (QMLog.isColorLevel()) {
        QMLog.d("MiniAppCamera", "remain= " + l4 + ",totalMemory=" + l1 + ",maxMemory=" + l2 + ",freeMemory" + l3);
      }
      if (l4 >= 51200L) {
        break label643;
      }
      System.gc();
    }
    catch (Exception localException)
    {
      Object localObject2;
      int i;
      int j;
      Object localObject3;
      Log.e("MiniAppCamera", "run: nativeTakePhoto ", localException);
      this.this$1.val$callback.onGetPhoto(null);
      return;
    }
    localObject2 = BitmapFactory.decodeByteArray(this.val$data, 0, this.val$data.length);
    i = ((Bitmap)localObject2).getWidth();
    j = ((Bitmap)localObject2).getHeight();
    localObject3 = new Matrix();
    float f1;
    float f5;
    float f2;
    float f4;
    if (CameraCompatibleList.isFoundProduct(CameraCompatibleList.KEY_PREVIEW_ORIENTATION_270_OF_BACK_MODEL))
    {
      if (!this.this$1.this$0.isBackCameraNow) {
        break label681;
      }
      f1 = 270.0F;
      break label655;
      Log.i("MiniAppCamera", "run: " + this.this$1.this$0.getWidth() + ":" + this.this$1.this$0.getHeight());
      if (!this.this$1.val$adapt) {
        break label698;
      }
      f5 = Math.max(this.this$1.this$0.getHeight() / i, this.this$1.this$0.getWidth() / j);
      f2 = i;
      f1 = j;
      f2 = (this.this$1.this$0.getHeight() - f2 * f5) / f5;
      f4 = (this.this$1.this$0.getWidth() - f1 * f5) / f5;
      f1 = f2;
      if (f2 <= 0.0F) {
        break label660;
      }
      f1 = 0.0F;
      break label660;
    }
    for (;;)
    {
      label355:
      Object localObject1;
      ((Matrix)localObject3).postRotate(localObject1);
      ((Matrix)localObject3).postScale(f2, f2);
      if (!this.this$1.this$0.isBackCameraNow) {
        ((Matrix)localObject3).postScale(-1.0F, 1.0F);
      }
      localObject3 = Bitmap.createBitmap((Bitmap)localObject2, (int)(-f1 / 2.0F), (int)(-f4 / 2.0F), (int)(f1 + ((Bitmap)localObject2).getWidth()), (int)(f4 + ((Bitmap)localObject2).getHeight()), (Matrix)localObject3, true);
      if ("normal".equals(this.this$1.val$quality)) {
        f1 = 0.8F;
      }
      for (;;)
      {
        localObject2 = localObject3;
        if (f1 < 1.0F)
        {
          localObject2 = new Matrix();
          ((Matrix)localObject2).postScale(f1, f1);
          localObject2 = Bitmap.createBitmap((Bitmap)localObject3, 0, 0, ((Bitmap)localObject3).getWidth(), ((Bitmap)localObject3).getHeight(), (Matrix)localObject2, true);
        }
        localObject3 = new File(this.this$1.this$0.getTmpPath("jpg"));
        ((File)localObject3).getParentFile().mkdirs();
        localObject2 = MiniAppCamera.access$000((Bitmap)localObject2, (File)localObject3, this.this$1.val$quality);
        Log.i("MiniAppCamera", "run: return");
        this.this$1.val$callback.onGetPhoto((String)localObject2);
        return;
        if (!this.this$1.this$0.isBackCameraNow) {
          break label692;
        }
        f1 = 90.0F;
        break;
        boolean bool = "low".equals(this.this$1.val$quality);
        if (bool) {
          f1 = 0.6F;
        } else {
          f1 = 1.0F;
        }
      }
      label643:
      if (l4 >= 81920L) {
        break;
      }
      break;
      label655:
      float f3;
      for (;;)
      {
        f3 = f1;
        break;
        label660:
        f2 = f4;
        if (f4 > 0.0F) {
          f2 = 0.0F;
        }
        f4 = f2;
        f2 = f5;
        break label355;
        label681:
        f1 = 90.0F;
      }
      for (;;)
      {
        f3 = f1;
        break;
        label692:
        f1 = 270.0F;
      }
      label698:
      f4 = 0.0F;
      f1 = 0.0F;
      f2 = 1.0F;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.camera.MiniAppCamera.2.1
 * JD-Core Version:    0.7.0.1
 */