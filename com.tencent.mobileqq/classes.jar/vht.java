import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

public class vht
{
  private static Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private static HandlerThread jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("createDecoration");
  private Handler jdField_a_of_type_AndroidOsHandler = new vhu(this, jdField_a_of_type_AndroidOsHandlerThread.getLooper());
  private WeakReference<vip> jdField_a_of_type_JavaLangRefWeakReference;
  private vhw jdField_a_of_type_Vhw;
  
  static
  {
    jdField_a_of_type_AndroidOsHandlerThread.start();
  }
  
  vht(vip paramvip, Looper paramLooper)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramvip);
    this.jdField_a_of_type_Vhw = new vhw(paramvip, paramLooper);
  }
  
  void a()
  {
    if (this.jdField_a_of_type_Vhw != null) {
      this.jdField_a_of_type_Vhw.obtainMessage(0).sendToTarget();
    }
  }
  
  void a(vhv paramvhv)
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2, paramvhv).sendToTarget();
    }
  }
  
  void b()
  {
    if (this.jdField_a_of_type_Vhw != null)
    {
      this.jdField_a_of_type_Vhw.removeMessages(0);
      this.jdField_a_of_type_Vhw.removeMessages(1);
    }
  }
  
  void c()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vht
 * JD-Core Version:    0.7.0.1
 */