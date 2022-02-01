import android.os.Handler;
import com.tencent.biz.pubaccount.weishi_new.player.WSVideoPluginInstall.1;
import com.tencent.biz.pubaccount.weishi_new.player.WSVideoPluginInstall.2;
import com.tencent.mobileqq.app.ThreadManager;

public class olj
{
  private static boolean mIsInitialized;
  private olj.a a;
  private Handler aW = new Handler(new olk(this));
  private boolean ajR;
  
  public olj()
  {
    ThreadManager.executeOnSubThread(new WSVideoPluginInstall.1(this));
  }
  
  private void acu() {}
  
  public boolean EU()
  {
    return false;
  }
  
  public void a(olj.a parama)
  {
    this.a = parama;
  }
  
  public void destroy()
  {
    this.a = null;
    this.aW.removeCallbacksAndMessages(null);
  }
  
  public void installPlugin()
  {
    if ((!EU()) && (!this.ajR)) {
      ThreadManager.post(new WSVideoPluginInstall.2(this), 8, null, true);
    }
  }
  
  public static abstract interface a
  {
    public abstract void ns(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     olj
 * JD-Core Version:    0.7.0.1
 */