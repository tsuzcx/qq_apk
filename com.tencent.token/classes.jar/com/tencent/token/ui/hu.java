package com.tencent.token.ui;

import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import android.os.Message;
import com.tencent.token.global.e;
import java.util.concurrent.ExecutorService;

final class hu
  implements Camera.PreviewCallback
{
  Message a = null;
  long b = 0L;
  
  hu(FaceRecognitionCameraPreviewOld paramFaceRecognitionCameraPreviewOld) {}
  
  public final void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    if ((FaceRecognitionCameraPreviewOld.a(this.c)) || (FaceRecognitionCameraPreviewOld.b(this.c))) {}
    for (;;)
    {
      return;
      try
      {
        Object localObject = this.c;
        ((FaceRecognitionCameraPreviewOld)localObject).e += 1L;
        if (!FaceRecognitionCameraPreviewOld.c(this.c))
        {
          paramCamera = paramCamera.getParameters();
          localObject = paramCamera.getPreviewSize();
          FaceRecognitionCameraPreviewOld.k(this.c).execute(new hv(this, paramCamera, (Camera.Size)localObject, paramArrayOfByte));
          return;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        e.c("preview handler is null");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.hu
 * JD-Core Version:    0.7.0.1
 */