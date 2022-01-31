import com.tencent.mobileqq.filemanager.core.FileManagerRSWorker;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.OutputStream;

public class dnu
  implements Runnable
{
  public dnu(FileManagerRSWorker paramFileManagerRSWorker) {}
  
  public void run()
  {
    if (this.a.b == 0)
    {
      if (this.a.f != null)
      {
        this.a.i = 0L;
        this.a.a(this.a.f, 0L);
        return;
      }
      this.a.b();
      return;
    }
    if (this.a.f.equalsIgnoreCase(""))
    {
      this.a.a();
      return;
    }
    this.a.g = System.currentTimeMillis();
    try
    {
      if (this.a.jdField_a_of_type_JavaIoOutputStream != null) {
        this.a.jdField_a_of_type_JavaIoOutputStream.flush();
      }
      this.a.jdField_a_of_type_Long = FileManagerUtil.a(this.a.d);
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "nSessionId[" + this.a.c + "]retry request Httpmsg,rd[" + String.valueOf(this.a.jdField_a_of_type_Long) + "]");
      FileManagerRSWorker.a(this.a, this.a.jdField_a_of_type_Long, this.a.h);
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        QLog.e("FileManagerRSWorker<FileAssistant>", 1, localIOException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     dnu
 * JD-Core Version:    0.7.0.1
 */