import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.mobileqq.filemanager.core.UniformDownloadNfn;
import com.tencent.qphone.base.util.QLog;

public class drn
  implements Runnable
{
  public drn(UniformDownloadNfn paramUniformDownloadNfn) {}
  
  public void run()
  {
    this.a.jdField_a_of_type_AndroidOsHandlerThread.getLooper().quit();
    this.a.jdField_a_of_type_AndroidOsHandlerThread = null;
    this.a.jdField_a_of_type_AndroidOsHandler = null;
    QLog.i(UniformDownloadNfn.jdField_a_of_type_JavaLangString, 1, "[UniformDL] >>>stop thread:D_NFThread...");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     drn
 * JD-Core Version:    0.7.0.1
 */