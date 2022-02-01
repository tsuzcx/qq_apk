import android.content.Context;
import android.os.Handler;
import com.tencent.gdtad.views.video.GdtVideoCommonView;
import com.tencent.gdtad.views.video.GdtVideoCommonView.3.1;
import com.tencent.mobileqq.videoplatform.SDKInitListener;

public class tml
  implements SDKInitListener
{
  public tml(GdtVideoCommonView paramGdtVideoCommonView, Context paramContext) {}
  
  public void onSDKInited(boolean paramBoolean)
  {
    if (paramBoolean) {
      GdtVideoCommonView.a(this.this$0).post(new GdtVideoCommonView.3.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tml
 * JD-Core Version:    0.7.0.1
 */