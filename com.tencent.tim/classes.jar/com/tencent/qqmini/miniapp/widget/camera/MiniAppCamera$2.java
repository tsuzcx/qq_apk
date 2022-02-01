package com.tencent.qqmini.miniapp.widget.camera;

import android.hardware.Camera;
import android.hardware.Camera.PictureCallback;
import android.util.Log;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;

class MiniAppCamera$2
  implements Camera.PictureCallback
{
  MiniAppCamera$2(MiniAppCamera paramMiniAppCamera, boolean paramBoolean, String paramString, MiniAppCamera.GetPhotoCallback paramGetPhotoCallback) {}
  
  public void onPictureTaken(byte[] paramArrayOfByte, Camera paramCamera)
  {
    Log.i("MiniAppCamera", "onPictureTaken: ");
    try
    {
      paramCamera.reconnect();
      paramCamera.startPreview();
      ThreadManager.executeOnDiskIOThreadPool(new MiniAppCamera.2.1(this, paramArrayOfByte));
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.i("MiniAppCamera", "onPictureTaken: ", localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.camera.MiniAppCamera.2
 * JD-Core Version:    0.7.0.1
 */