import android.content.Context;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.UiThread;
import android.widget.ImageView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import cooperation.qqreader.helper.LoadingAnimationManager.1;
import cooperation.qqreader.helper.LoadingAnimationManager.2;
import cooperation.qqreader.helper.LoadingAnimationManager.3;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

public final class avms
{
  private static avms a;
  private LottieDrawable b = new LottieDrawable();
  private WeakReference<ImageView> bF = new WeakReference(null);
  private boolean dny;
  private Runnable iC;
  
  public static avms a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new avms();
      }
      return a;
    }
    finally {}
  }
  
  private void eAP()
  {
    ImageView localImageView = (ImageView)this.bF.get();
    if (localImageView == null) {
      return;
    }
    localImageView.setImageDrawable(this.b);
    localImageView.setVisibility(0);
    this.b.playAnimation();
  }
  
  private void nF(long paramLong)
  {
    if (paramLong > 0L)
    {
      Message localMessage = Message.obtain(null, new LoadingAnimationManager.3(this));
      localMessage.what = 30002;
      ThreadManager.getUIHandler().sendMessageDelayed(localMessage, paramLong);
      return;
    }
    eAP();
  }
  
  @UiThread
  public void a(@NonNull Context paramContext, @NonNull ImageView paramImageView)
  {
    a(paramContext, paramImageView, 0L);
  }
  
  @UiThread
  public void a(@NonNull Context paramContext, @NonNull ImageView paramImageView, long paramLong)
  {
    ImageView localImageView = (ImageView)this.bF.get();
    if ((localImageView != paramImageView) && (localImageView != null)) {
      eAO();
    }
    this.bF = new WeakReference(paramImageView);
    if (this.b.getComposition() == null)
    {
      this.iC = new LoadingAnimationManager.1(this, paramLong);
      if (!this.dny) {
        this.dny = true;
      }
      try
      {
        ThreadManager.getSubThreadHandler().post(new LoadingAnimationManager.2(this, paramContext));
        return;
      }
      catch (Exception paramContext)
      {
        avoc.m("LoadingAnimationManager", "loadLottieAnimation  fail :", paramContext);
        return;
      }
    }
    nF(paramLong);
  }
  
  @UiThread
  public void eAO()
  {
    ThreadManager.getUIHandler().removeMessages(30002);
    ImageView localImageView = (ImageView)this.bF.get();
    if (localImageView != null)
    {
      this.b.stop();
      localImageView.setVisibility(8);
    }
    this.iC = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avms
 * JD-Core Version:    0.7.0.1
 */