import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.apollo.ApolloTicker;
import com.tencent.mobileqq.apollo.process.data.CmGameLauncher;
import com.tencent.qphone.base.util.QLog;

public class yro
  implements Runnable
{
  public yro(CmGameLauncher paramCmGameLauncher) {}
  
  public void run()
  {
    if ((CmGameLauncher.a(this.a) != null) && (CmGameLauncher.a(this.a).getRender() != null) && (CmGameLauncher.a(this.a).getRender().mApolloTicker != null))
    {
      ApolloRender.tickerResume(CmGameLauncher.a(this.a).getRender().mApolloTicker.ticker);
      if (QLog.isColorLevel()) {
        QLog.d("cmgame_process.CmGameLauncher", 2, "mResumeTickerTask");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yro
 * JD-Core Version:    0.7.0.1
 */