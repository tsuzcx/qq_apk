import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.networkedmodule.ModuleDownloadListener;
import cooperation.qzone.networkedmodule.QzoneModuleManager;
import java.io.File;

class avsi
  implements ModuleDownloadListener
{
  avsi(avsh paramavsh) {}
  
  public void onDownloadCanceled(String paramString)
  {
    avsh.y(false);
  }
  
  public void onDownloadFailed(String paramString)
  {
    avsh.y(false);
  }
  
  public void onDownloadProgress(String paramString, float paramFloat) {}
  
  public void onDownloadSucceed(String paramString)
  {
    if (!paramString.equals("upload.so")) {
      return;
    }
    avsh.y(false);
    String str = avsh.m().getAbsolutePath();
    QLog.d("UploadEnv", 1, "upload so download success : " + str);
    paramString = QzoneModuleManager.getInstance().getModuleFilePath(paramString);
    File localFile = new File(str);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    if (!awcf.d(new File(paramString), localFile))
    {
      QLog.d("UploadEnv", 1, "upload so unzip fail");
      avsh.y(false);
      return;
    }
    if (avsh.a(this.this$0, str))
    {
      QLog.d("UploadEnv", 1, "upload so save success");
      avsh.a(this.this$0, true);
      avsh.access$202(true);
    }
    for (;;)
    {
      avsh.y(false);
      return;
      try
      {
        localFile.delete();
        avsh.a(this.this$0, false);
      }
      catch (Throwable paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avsi
 * JD-Core Version:    0.7.0.1
 */