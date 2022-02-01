import cooperation.qzone.networkedmodule.ModuleDownloadListener;
import cooperation.qzone.networkedmodule.QzoneModuleManager;
import cooperation.qzone.util.QZLog;
import java.io.File;

class awcb
  implements ModuleDownloadListener
{
  awcb(awby paramawby) {}
  
  public void onDownloadCanceled(String paramString) {}
  
  public void onDownloadFailed(String paramString) {}
  
  public void onDownloadProgress(String paramString, float paramFloat) {}
  
  public void onDownloadSucceed(String paramString)
  {
    if (!paramString.equals("libandroidndkbeauty.so")) {}
    for (;;)
    {
      return;
      String str = awby.bg.getPath();
      paramString = new File(QzoneModuleManager.getInstance().getModuleFilePath(paramString));
      if (paramString.exists()) {}
      try
      {
        awby.l(paramString, new File(awby.bg.getPath() + "/libandroidndkbeauty.zip"));
        paramString = new File(str);
        if (!paramString.exists()) {
          paramString.mkdirs();
        }
        if (this.b.T(awby.cOH, false)) {
          continue;
        }
        QZLog.e("AlbumLibDownloaderUtil", 1, new Object[] { "unzip beauty so" });
        awcf.d(new File(awby.bg.getPath() + "/libandroidndkbeauty.zip"), paramString);
        QZLog.e("AlbumLibDownloaderUtil", 1, new Object[] { "unzip beauty so finish" });
        return;
      }
      catch (Exception paramString)
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
 * Qualified Name:     awcb
 * JD-Core Version:    0.7.0.1
 */