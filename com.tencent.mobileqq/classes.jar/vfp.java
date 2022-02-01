import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

public class vfp
{
  private static Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private static HandlerThread jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("createDecoration");
  private Handler jdField_a_of_type_AndroidOsHandler = new vfq(this, jdField_a_of_type_AndroidOsHandlerThread.getLooper());
  private WeakReference<vgl> jdField_a_of_type_JavaLangRefWeakReference;
  private vfs jdField_a_of_type_Vfs;
  
  static
  {
    jdField_a_of_type_AndroidOsHandlerThread.start();
  }
  
  vfp(vgl paramvgl, Looper paramLooper)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramvgl);
    this.jdField_a_of_type_Vfs = new vfs(paramvgl, paramLooper);
  }
  
  void a()
  {
    if (this.jdField_a_of_type_Vfs != null) {
      this.jdField_a_of_type_Vfs.obtainMessage(0).sendToTarget();
    }
  }
  
  void a(vfr paramvfr)
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2, paramvfr).sendToTarget();
    }
  }
  
  void b()
  {
    if (this.jdField_a_of_type_Vfs != null)
    {
      this.jdField_a_of_type_Vfs.removeMessages(0);
      this.jdField_a_of_type_Vfs.removeMessages(1);
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
 * Qualified Name:     vfp
 * JD-Core Version:    0.7.0.1
 */