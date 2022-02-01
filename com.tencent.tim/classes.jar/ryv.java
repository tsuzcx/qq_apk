import android.os.Handler;
import com.tencent.biz.richframework.widget.BaseVideoView;
import com.tencent.biz.richframework.widget.BaseVideoView.1.1;
import com.tencent.mobileqq.videoplatform.SDKInitListener;

public class ryv
  implements SDKInitListener
{
  public ryv(BaseVideoView paramBaseVideoView) {}
  
  public void onSDKInited(boolean paramBoolean)
  {
    this.this$0.getMainHandler().post(new BaseVideoView.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ryv
 * JD-Core Version:    0.7.0.1
 */