import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;

public class voa
  implements vnq
{
  public long a;
  public vnq a;
  
  public voa(vnq paramvnq)
  {
    this.jdField_a_of_type_Vnq = paramvnq;
  }
  
  public void onFailure(String paramString)
  {
    if (this.jdField_a_of_type_Vnq != null) {
      this.jdField_a_of_type_Vnq.onFailure(paramString);
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.qqstory.ffmpeg.FFmpegCmd", 2, "play_video hflip video Error:" + paramString);
    }
  }
  
  public void onFinish(boolean paramBoolean) {}
  
  public void onProgress(String paramString) {}
  
  public void onStart()
  {
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
  }
  
  public void onSuccess(String paramString)
  {
    paramString = String.valueOf(SystemClock.uptimeMillis() - this.jdField_a_of_type_Long);
    urp.a("play_video", "down_watermark_hfliptime", 0, 0, new String[] { paramString });
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.ffmpeg.FFmpegCmd", 2, "play_video down_watermark_hfliptime:" + paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     voa
 * JD-Core Version:    0.7.0.1
 */