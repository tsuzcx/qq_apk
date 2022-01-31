import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import com.tencent.qphone.base.util.QLog;

public class yau
  implements Runnable
{
  public yau(ShortVideoPlayActivity paramShortVideoPlayActivity) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "mStartHidingRunnable run");
    }
    this.a.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     yau
 * JD-Core Version:    0.7.0.1
 */