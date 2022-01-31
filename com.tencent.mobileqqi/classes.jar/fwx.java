import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.mobileqq.filemanager.core.UniformDownloadNfn;
import com.tencent.qphone.base.util.QLog;

public class fwx
  implements Runnable
{
  public fwx(UniformDownloadNfn paramUniformDownloadNfn) {}
  
  public void run()
  {
    this.a.jdField_a_of_type_AndroidOsHandlerThread.getLooper().quit();
    this.a.jdField_a_of_type_AndroidOsHandlerThread = null;
    this.a.jdField_a_of_type_AndroidOsHandler = null;
    QLog.i(UniformDownloadNfn.jdField_a_of_type_JavaLangString, 1, "[UniformDL] >>>stop thread:D_NFThread...");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     fwx
 * JD-Core Version:    0.7.0.1
 */