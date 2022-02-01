package dov.com.qq.im.ae.camera;

import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.VideoCaptureResult;

public class AEVideoCaptureResult
  extends CameraCaptureView.VideoCaptureResult
{
  public long finishTimeMs;
  public long startTimeMs;
  
  public long getVideoCaptureLength()
  {
    return this.finishTimeMs - this.startTimeMs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.AEVideoCaptureResult
 * JD-Core Version:    0.7.0.1
 */