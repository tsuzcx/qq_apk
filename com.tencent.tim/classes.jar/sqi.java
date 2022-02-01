import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import cooperation.qzone.util.QZLog;
import java.io.File;

class sqi
  extends aquy
{
  sqi(sqh paramsqh, Downloader.DownloadListener paramDownloadListener, String paramString1, sqh.a parama, String paramString2, String paramString3) {}
  
  public void onCancel(aquz paramaquz)
  {
    if (this.val$listener != null) {
      this.val$listener.onDownloadCanceled(this.val$destPath);
    }
    sqh.a.a(this.a, 3);
    QZLog.e("Q.videostory.config.VSEntranceWidgetDownLoadHelper", 1, new Object[] { "onDownloadCanceled" });
  }
  
  public void onDone(aquz paramaquz)
  {
    if (paramaquz.errCode == 0)
    {
      boolean bool;
      if (new File(sqh.aFJ).exists())
      {
        bool = awcf.d(new File(this.val$destPath), new File(sqh.aFJ + "/" + this.aFK));
        if (!bool) {
          break label158;
        }
        if (this.val$listener != null) {
          this.val$listener.onDownloadSucceed(this.val$destPath, new DownloadResult(this.val$url));
        }
        new File(this.val$destPath).delete();
        sqh.a.a(this.a, 0);
      }
      for (;;)
      {
        QZLog.i("Q.videostory.config.VSEntranceWidgetDownLoadHelper", 1, "downLoadByIdsuccess:" + bool);
        return;
        label158:
        sqh.a.a(this.a, 2);
      }
    }
    if (this.val$listener != null) {
      this.val$listener.onDownloadFailed(this.val$destPath, new DownloadResult(this.val$url));
    }
    sqh.a.a(this.a, 2);
    QZLog.e("Q.videostory.config.VSEntranceWidgetDownLoadHelper", 1, new Object[] { "downLoadByIdonDownloadFailed:" });
  }
  
  public void onProgress(aquz paramaquz)
  {
    if (this.val$listener != null) {
      this.val$listener.onDownloadProgress(this.val$destPath, 0L, 0.0F);
    }
    sqh.a.a(this.a, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sqi
 * JD-Core Version:    0.7.0.1
 */