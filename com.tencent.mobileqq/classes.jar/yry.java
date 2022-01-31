import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.ApolloTextureView;
import com.tencent.mobileqq.apollo.ApolloTicker;
import com.tencent.mobileqq.apollo.script.SpriteBackgroundManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class yry
  implements Runnable
{
  public yry(SpriteBackgroundManager paramSpriteBackgroundManager) {}
  
  public void run()
  {
    ApolloTextureView localApolloTextureView = (ApolloTextureView)SpriteBackgroundManager.a(this.a).get();
    if ((localApolloTextureView != null) && (localApolloTextureView.getRender() != null) && (localApolloTextureView.getRender().mApolloTicker != null)) {
      ApolloRender.tickerResume(localApolloTextureView.getRender().mApolloTicker.ticker);
    }
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteBackgroundManager", 2, "mResumeTickerTask");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yry
 * JD-Core Version:    0.7.0.1
 */