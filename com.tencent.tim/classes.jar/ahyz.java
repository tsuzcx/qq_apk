import android.os.Handler;
import android.widget.ImageView;
import com.tencent.image.URLDrawable.DownloadListener;
import com.tencent.mobileqq.hotpic.HotPicMainPanel;
import com.tencent.mobileqq.hotpic.HotPicMainPanel.2.1;

public class ahyz
  implements URLDrawable.DownloadListener
{
  public ahyz(HotPicMainPanel paramHotPicMainPanel, ImageView paramImageView) {}
  
  public void onFileDownloadFailed(int paramInt) {}
  
  public void onFileDownloadStarted() {}
  
  public void onFileDownloadSucceed(long paramLong)
  {
    this.b.mUiHandler.post(new HotPicMainPanel.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahyz
 * JD-Core Version:    0.7.0.1
 */