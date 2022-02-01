package dov.com.qq.im.ae.camera.ui.capture;

import akxe;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import awyk;
import awyt;
import axiy;
import com.tencent.biz.videostory.video.FrameVideoHelper.FrameBuffer;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView;
import java.io.ByteArrayOutputStream;
import java.util.List;
import sqm;

public class VideoStoryCapturePart$9$1
  implements Runnable
{
  public VideoStoryCapturePart$9$1(awyt paramawyt, Bitmap paramBitmap) {}
  
  public void run()
  {
    try
    {
      if ((this.val$bitmap == null) || (this.val$bitmap.isRecycled())) {
        return;
      }
      if ((this.val$bitmap.getWidth() <= 0) || (this.val$bitmap.getHeight() <= 0))
      {
        axiy.e("VideoStoryCapturePart", "error bitmap width height.");
        return;
      }
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      sqm.C(this.val$bitmap).compress(Bitmap.CompressFormat.JPEG, 80, localByteArrayOutputStream);
      localObject = localByteArrayOutputStream.toByteArray();
      awyk.a(this.a.a, awyk.a(this.a.a) + localObject.length);
      if (awyk.a(this.a.a) > awyk.b(this.a.a))
      {
        awyk.a(this.a.a, awyk.a(this.a.a) - localObject.length);
        akxe.M("Q.videostory", "Q.videostory.capture", "onCapture", "size to larger");
        localByteArrayOutputStream.close();
        awyk.a(this.a.a).setCaptureRequest(null);
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    Object localObject = new FrameVideoHelper.FrameBuffer((byte[])localObject);
    this.a.a.Me.add(localObject);
    localException.close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.capture.VideoStoryCapturePart.9.1
 * JD-Core Version:    0.7.0.1
 */