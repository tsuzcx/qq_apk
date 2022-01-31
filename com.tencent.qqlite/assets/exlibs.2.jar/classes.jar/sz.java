import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import com.tencent.biz.widgets.ScannerView;
import com.tencent.qphone.base.util.QLog;

public class sz
  extends Thread
  implements Camera.AutoFocusCallback
{
  static final long jdField_a_of_type_Long = 3000L;
  Camera jdField_a_of_type_AndroidHardwareCamera;
  boolean jdField_a_of_type_Boolean = false;
  
  public sz(Camera paramCamera)
  {
    this.jdField_a_of_type_AndroidHardwareCamera = paramCamera;
  }
  
  public void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(ScannerView.a, 4, "onAutoFocus");
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void run()
  {
    try
    {
      for (;;)
      {
        Thread.sleep(3000L);
        this.jdField_a_of_type_Boolean = true;
        try
        {
          this.jdField_a_of_type_AndroidHardwareCamera.autoFocus(this);
        }
        catch (RuntimeException localRuntimeException1) {}
      }
      try
      {
        this.jdField_a_of_type_AndroidHardwareCamera.cancelAutoFocus();
        this.jdField_a_of_type_AndroidHardwareCamera = null;
        return;
      }
      catch (RuntimeException localRuntimeException2)
      {
        break label41;
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      if (!this.jdField_a_of_type_Boolean) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     sz
 * JD-Core Version:    0.7.0.1
 */