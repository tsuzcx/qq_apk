import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import cooperation.qzone.LocalMultiProcConfig;
import java.io.File;

class awbz
  implements Downloader.DownloadListener
{
  awbz(awby paramawby, String paramString1, Downloader.DownloadListener paramDownloadListener, String paramString2) {}
  
  public void onDownloadCanceled(String paramString)
  {
    File localFile = new File(awby.bg.getAbsolutePath() + "/tmp" + this.bss);
    if (localFile.exists()) {
      localFile.delete();
    }
    if (this.val$listener != null) {
      this.val$listener.onDownloadCanceled(paramString);
    }
    if (awby.cOG.equals(this.bss)) {
      this.b.C[awby.a(this.b)] = false;
    }
  }
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    File localFile = new File(awby.bg.getAbsolutePath() + "/tmp" + this.bss);
    if (localFile.exists()) {
      localFile.delete();
    }
    if (this.val$listener != null) {
      this.val$listener.onDownloadFailed(paramString, paramDownloadResult);
    }
    if (awby.cOG.equals(this.bss)) {
      this.b.C[awby.a(this.b)] = false;
    }
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat) {}
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    File localFile = new File(awby.bg.getAbsolutePath() + "/" + this.bss);
    if (localFile.exists()) {
      localFile.delete();
    }
    localFile = new File(awby.bg.getAbsolutePath() + "/tmp" + this.bss);
    if (localFile.exists()) {
      localFile.renameTo(new File(awby.bg.getAbsolutePath() + "/" + this.bss));
    }
    LocalMultiProcConfig.putBool(this.val$url, true);
    if (this.val$listener != null) {
      this.val$listener.onDownloadSucceed(paramString, paramDownloadResult);
    }
    if (awby.cOG.equals(this.bss)) {
      this.b.C[awby.a(this.b)] = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awbz
 * JD-Core Version:    0.7.0.1
 */