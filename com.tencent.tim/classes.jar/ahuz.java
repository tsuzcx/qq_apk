import android.os.Handler;
import android.view.View;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.d;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.gamecenter.web.QQGameFeedWebFragment;
import com.tencent.mobileqq.gamecenter.web.QQGameFeedWebFragment.4.1;

public class ahuz
  implements PreloadManager.d
{
  public ahuz(QQGameFeedWebFragment paramQQGameFeedWebFragment, View paramView) {}
  
  public void onResult(int paramInt, PreloadManager.PathResult paramPathResult)
  {
    ThreadManagerV2.getUIHandlerV2().post(new QQGameFeedWebFragment.4.1(this, paramInt, paramPathResult));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahuz
 * JD-Core Version:    0.7.0.1
 */