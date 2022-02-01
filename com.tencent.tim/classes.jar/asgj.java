import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

class asgj
  implements jox
{
  asgj(asgi paramasgi, String paramString, boolean paramBoolean) {}
  
  public void loaded(String paramString, int paramInt)
  {
    if (((paramInt != 0) || (paramString == null) || (!paramString.contains("url"))) && (paramInt != 7)) {
      asgf.ez.set(false);
    }
    this.a.mStatus = -1;
    switch (paramInt)
    {
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 6: 
    default: 
      this.a.onFail(this.val$bid);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QGDownloader.offline", 2, new Object[] { "onSoDownload loaded. code = ", Integer.valueOf(paramInt), ", param1:", paramString, ", DownloadStatus = " + this.a.mStatus });
      }
      return;
      this.a.dF(this.val$bid, this.dek);
      continue;
      if (paramString == null) {
        this.a.dF(this.val$bid, this.dek);
      }
    }
  }
  
  public void progress(int paramInt)
  {
    this.a.onProgress(this.val$bid, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asgj
 * JD-Core Version:    0.7.0.1
 */