import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.mobileqq.activity.aio.doodle.DoodleDrawer;
import com.tencent.mobileqq.app.ThreadManager;

public class uwe
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  
  public uwe(DoodleDrawer paramDoodleDrawer) {}
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null)
    {
      HandlerThread localHandlerThread = ThreadManager.newFreeHandlerThread("DoodleDrawerThread", 0);
      localHandlerThread.start();
      this.jdField_a_of_type_AndroidOsHandler = new Handler(localHandlerThread.getLooper());
    }
  }
  
  public void a(Runnable paramRunnable)
  {
    if ((paramRunnable == null) || (this.jdField_a_of_type_AndroidOsHandler == null)) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(paramRunnable);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler.getLooper().quit();
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uwe
 * JD-Core Version:    0.7.0.1
 */