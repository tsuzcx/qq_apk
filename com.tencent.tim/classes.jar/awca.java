import cooperation.qzone.networkedmodule.ModuleDownloadListener;
import cooperation.qzone.networkedmodule.QzoneModuleManager;
import java.io.File;

class awca
  implements ModuleDownloadListener
{
  awca(awby paramawby) {}
  
  public void onDownloadCanceled(String paramString) {}
  
  public void onDownloadFailed(String paramString) {}
  
  public void onDownloadProgress(String paramString, float paramFloat) {}
  
  public void onDownloadSucceed(String paramString)
  {
    if (!paramString.equals("pictureMarkerSo.zip")) {}
    do
    {
      return;
      localObject = awby.bg.getPath();
      paramString = new File(QzoneModuleManager.getInstance().getModuleFilePath(paramString));
    } while (!paramString.exists());
    Object localObject = new File((String)localObject);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    awcf.d(paramString, (File)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awca
 * JD-Core Version:    0.7.0.1
 */