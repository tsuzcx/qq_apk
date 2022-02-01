import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.filedownload.ApkFileDownloadFragment;
import com.tencent.open.filedownload.ApkFileDownloadFragment.2.1;
import com.tencent.open.filedownload.ui.ApkFileDownloadButton.a;
import mqq.os.MqqHandler;

public class asak
  extends ApkFileDownloadButton.a
{
  public asak(ApkFileDownloadFragment paramApkFileDownloadFragment) {}
  
  public void dlX()
  {
    ThreadManager.getUIHandler().post(new ApkFileDownloadFragment.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asak
 * JD-Core Version:    0.7.0.1
 */