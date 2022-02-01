package cooperation.qzone;

import avsh;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class UploadSoDownloader$1
  implements Runnable
{
  public UploadSoDownloader$1(avsh paramavsh) {}
  
  public void run()
  {
    boolean bool = avsh.a(this.this$0, avsh.m().getAbsolutePath());
    QLog.d("UploadEnv", 1, "check so md5 result: " + bool);
    if (bool)
    {
      avsh.access$202(true);
      return;
    }
    try
    {
      if (avsh.m().exists()) {
        avsh.m().delete();
      }
      avsh.a(this.this$0, false);
      avsh.access$202(false);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.UploadSoDownloader.1
 * JD-Core Version:    0.7.0.1
 */