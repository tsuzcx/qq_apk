import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.cropvideo.CropVideoActivity;

public class axyj
  implements rqi
{
  public axyj(CropVideoActivity paramCropVideoActivity) {}
  
  public void onFailure(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CropVideoActivity", 2, "ffmpeg onFailure: " + paramString);
    }
    this.this$0.mHandler.sendEmptyMessage(4);
  }
  
  public void onFinish(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CropVideoActivity", 2, "ffmpeg onFinish: " + paramBoolean);
    }
    this.this$0.mHandler.sendEmptyMessage(3);
  }
  
  public void onProgress(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CropVideoActivity", 2, "ffmpeg onProgress: " + paramString);
    }
  }
  
  public void onStart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CropVideoActivity", 2, "ffmpeg onStart");
    }
  }
  
  public void onSuccess(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CropVideoActivity", 2, "ffmpeg onSuccess: " + paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axyj
 * JD-Core Version:    0.7.0.1
 */