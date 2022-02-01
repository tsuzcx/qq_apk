import com.tencent.component.network.utils.thread.ThreadPool.Job;
import com.tencent.component.network.utils.thread.ThreadPool.JobContext;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelper;

public final class awgy
  implements ThreadPool.Job<Object>
{
  public awgy(String paramString1, String paramString2) {}
  
  public Object run(ThreadPool.JobContext paramJobContext)
  {
    QzoneZipCacheHelper.access$100().H(QzoneZipCacheHelper.access$100().getPath(QzoneZipCacheHelper.access$000(this.Gv, this.cQc)), true);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awgy
 * JD-Core Version:    0.7.0.1
 */