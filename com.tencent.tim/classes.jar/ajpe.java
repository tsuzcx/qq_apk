import android.content.Context;
import android.os.SystemClock;
import com.tencent.image.URLDrawable.DownloadListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.ImgDownloadListener.1;
import com.tencent.mobileqq.nearby.ImgDownloadListener.2;

public class ajpe
  implements URLDrawable.DownloadListener
{
  private long ade;
  private Context mContext;
  private String mTagName = "freshnews.small_pic_download";
  
  public ajpe(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public ajpe(Context paramContext, String paramString)
  {
    this.mContext = paramContext;
    this.mTagName = paramString;
  }
  
  public void onFileDownloadFailed(int paramInt)
  {
    ThreadManager.postImmediately(new ImgDownloadListener.2(this, paramInt), null, true);
  }
  
  public void onFileDownloadStarted()
  {
    this.ade = SystemClock.elapsedRealtime();
  }
  
  public void onFileDownloadSucceed(long paramLong)
  {
    ThreadManager.postImmediately(new ImgDownloadListener.1(this, paramLong), null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajpe
 * JD-Core Version:    0.7.0.1
 */