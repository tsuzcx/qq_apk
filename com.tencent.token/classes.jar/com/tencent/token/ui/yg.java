package com.tencent.token.ui;

import android.hardware.Camera;
import android.hardware.Camera.PictureCallback;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.global.e;
import com.tencent.token.utils.i;

final class yg
  implements Camera.PictureCallback
{
  yg(yf paramyf) {}
  
  public final void onPictureTaken(byte[] paramArrayOfByte, Camera paramCamera)
  {
    Message localMessage;
    if (RealNameTakeIDPhotoActivity.access$100(this.a.a) == 1)
    {
      RealNameTakeIDPhotoActivity.access$202(this.a.a, i.a(paramArrayOfByte, "frontdata"));
      localMessage = RealNameTakeIDPhotoActivity.access$300(this.a.a).obtainMessage(0);
      localMessage.what = 1;
      localMessage.obj = RealNameTakeIDPhotoActivity.access$200(this.a.a);
      localMessage.arg1 = 1;
      localMessage.sendToTarget();
    }
    for (;;)
    {
      e.a("take id photo data=" + paramArrayOfByte.length);
      paramCamera.stopPreview();
      return;
      if (RealNameTakeIDPhotoActivity.access$100(this.a.a) == 2)
      {
        RealNameTakeIDPhotoActivity.access$402(this.a.a, i.a(paramArrayOfByte, "backdata"));
        localMessage = RealNameTakeIDPhotoActivity.access$300(this.a.a).obtainMessage(0);
        localMessage.what = 1;
        localMessage.obj = RealNameTakeIDPhotoActivity.access$400(this.a.a);
        localMessage.arg1 = 2;
        localMessage.sendToTarget();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.yg
 * JD-Core Version:    0.7.0.1
 */