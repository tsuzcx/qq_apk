import android.os.Handler;
import com.tencent.biz.richframework.widget.BaseVideoView;
import com.tencent.biz.richframework.widget.BaseVideoView.1.1;
import com.tencent.mobileqq.videoplatform.SDKInitListener;

public class zax
  implements SDKInitListener
{
  public zax(BaseVideoView paramBaseVideoView) {}
  
  public void onSDKInited(boolean paramBoolean)
  {
    this.a.a().post(new BaseVideoView.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zax
 * JD-Core Version:    0.7.0.1
 */