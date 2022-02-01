import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.filedownload.ApkFileDownloadFragment;
import com.tencent.open.filedownload.ApkFileDownloadFragment.3.1;
import com.tencent.open.filedownload.ui.ApkFileDownloadButton.a;
import mqq.os.MqqHandler;

public class asal
  extends ApkFileDownloadButton.a
{
  public asal(ApkFileDownloadFragment paramApkFileDownloadFragment) {}
  
  public void dlX()
  {
    ThreadManager.getUIHandler().post(new ApkFileDownloadFragment.3.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asal
 * JD-Core Version:    0.7.0.1
 */