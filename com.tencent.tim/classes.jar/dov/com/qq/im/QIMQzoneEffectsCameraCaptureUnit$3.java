package dov.com.qq.im;

import anis;
import awsu;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.VideoCaptureResult;
import cooperation.qzone.util.QZLog;
import java.io.File;

public class QIMQzoneEffectsCameraCaptureUnit$3
  implements Runnable
{
  public QIMQzoneEffectsCameraCaptureUnit$3(awsu paramawsu, CameraCaptureView.VideoCaptureResult paramVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo) {}
  
  public void run()
  {
    boolean bool = true;
    try
    {
      File localFile = new File(awsu.a(this.this$0));
      int i = anis.a(this.e.videoMp4FilePath, this.j.mediaWidth, this.j.mediaHeight, this.j.mDuration, localFile.getAbsolutePath());
      QZLog.d(awsu.access$200(), 1, "Video2GifConverter: convert retCode=" + i);
      awsu localawsu = this.this$0;
      if (i == 0) {}
      for (;;)
      {
        awsu.a(localawsu, bool, localFile.getAbsolutePath());
        return;
        bool = false;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QZLog.e(awsu.access$200(), "processNotExistVideoData: convert exception", localThrowable);
      awsu.a(this.this$0, false, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.QIMQzoneEffectsCameraCaptureUnit.3
 * JD-Core Version:    0.7.0.1
 */