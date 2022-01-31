import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import com.tencent.qphone.base.util.QLog;

public class cnz
  implements Runnable
{
  public cnz(ShortVideoPlayActivity paramShortVideoPlayActivity) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "mStartHidingRunnable run");
    }
    ShortVideoPlayActivity.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cnz
 * JD-Core Version:    0.7.0.1
 */