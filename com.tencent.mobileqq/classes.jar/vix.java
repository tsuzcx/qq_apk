import android.os.Handler;
import com.tencent.biz.qqstory.playvideo.ProgressControler.2;
import com.tencent.biz.qqstory.playvideo.ProgressControler.3;
import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;

public class vix
{
  protected long a;
  public Handler a;
  public WeakReference<vrr> a;
  public Timer a;
  private TimerTask a;
  public boolean a;
  public long b;
  public long c;
  
  private void a()
  {
    ProgressControler.2 local2 = new ProgressControler.2(this);
    this.jdField_a_of_type_AndroidOsHandler.post(local2);
  }
  
  private void b()
  {
    Timer localTimer = new Timer();
    ProgressControler.3 local3 = new ProgressControler.3(this);
    localTimer.scheduleAtFixedRate(local3, 0L, 50L);
    this.jdField_a_of_type_JavaUtilTimer = localTimer;
    this.jdField_a_of_type_JavaUtilTimerTask = local3;
  }
  
  public void a(long paramLong1, long paramLong2, vrr paramvrr)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Long = paramLong1;
    this.c = this.jdField_a_of_type_Long;
    this.b = paramLong2;
    if (this.jdField_a_of_type_JavaUtilTimer != null) {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
    }
    if (this.jdField_a_of_type_JavaUtilTimerTask != null) {
      this.jdField_a_of_type_JavaUtilTimerTask.cancel();
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    if (paramLong2 <= 0L)
    {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramvrr);
      a();
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
      return;
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vix
 * JD-Core Version:    0.7.0.1
 */