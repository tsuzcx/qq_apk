import com.tencent.biz.pubaccount.readinjoy.view.imageloader.RunningJob;
import com.tencent.image.URLDrawableHandler;
import com.tencent.qphone.base.util.QLog;

public class npd
  implements URLDrawableHandler
{
  public npd(RunningJob paramRunningJob, StringBuilder paramStringBuilder) {}
  
  public void doCancel() {}
  
  public boolean isCancelled()
  {
    return false;
  }
  
  public void onFileDownloadFailed(int paramInt)
  {
    QLog.d(RunningJob.tag, 1, "receive image data error: " + paramInt + " progress: " + this.y);
  }
  
  public void onFileDownloadStarted()
  {
    lgl.b(3, this.this$0.a);
  }
  
  public void onFileDownloadSucceed(long paramLong)
  {
    if (this.this$0.a.cacheType == 0) {
      lgl.b(2, this.this$0.a);
    }
    QLog.d(RunningJob.tag, 1, "receive image data success, total size: " + paramLong + " progress: " + this.y);
  }
  
  public void publishProgress(int paramInt)
  {
    this.y.append(System.currentTimeMillis() + " " + paramInt + " ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     npd
 * JD-Core Version:    0.7.0.1
 */