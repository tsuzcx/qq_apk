import android.app.Activity;
import com.tencent.biz.pubaccount.readinjoy.ad.view.KandianAdPandentMask;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;

public class lcu
  extends lcs
  implements knj.a
{
  private KandianAdPandentMask a;
  private boolean ajr;
  private boolean ajs;
  private WeakReference<Activity> q;
  
  public lcu(@NotNull lct paramlct, QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    super(paramlct, "RIJADSuperMaskPopupStep");
    this.q = new WeakReference(paramActivity);
  }
  
  private void aKs()
  {
    this.ajr = false;
    if (knj.a().getShowStatus() == 1)
    {
      aKt();
      return;
    }
    if (knj.a().zX())
    {
      nn(false);
      return;
    }
    if (this.ajs)
    {
      nn(false);
      return;
    }
    this.ajr = true;
  }
  
  private void aKt()
  {
    if ((knj.a().getShowStatus() == 1) && (knj.zV()))
    {
      if (this.a == null) {
        this.a = new KandianAdPandentMask();
      }
      Activity localActivity = (Activity)this.q.get();
      this.a.a(localActivity, knj.a().b());
      nn(true);
      return;
    }
    nn(false);
  }
  
  public boolean BN()
  {
    return super.BN();
  }
  
  public void T(int paramInt, boolean paramBoolean)
  {
    if (paramInt == 0) {
      if (paramBoolean) {
        break label35;
      }
    }
    label35:
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.ajs = paramBoolean;
      if ((this.ajs) && (this.ajr)) {
        nn(false);
      }
      return;
    }
  }
  
  public void aKl()
  {
    super.aKl();
  }
  
  public void aKm()
  {
    super.aKm();
  }
  
  protected void aKn()
  {
    aKs();
  }
  
  protected void aKo()
  {
    aKs();
  }
  
  public boolean isResumed()
  {
    return super.isResumed();
  }
  
  public void nn(boolean paramBoolean)
  {
    super.nn(paramBoolean);
  }
  
  public void onCreate()
  {
    super.onCreate();
    knj.a().a(this);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if ((this.a != null) && (this.a.zY())) {
      this.a.aES();
    }
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  public void pn(int paramInt)
  {
    if (this.ajr)
    {
      this.ajr = false;
      if ((paramInt != 0) || (knj.a().getShowStatus() != 1)) {
        break label52;
      }
      aKt();
    }
    for (;;)
    {
      if ((paramInt == 0) && (knj.a().getShowStatus() == 2)) {
        knj.a().agA = false;
      }
      return;
      label52:
      nn(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lcu
 * JD-Core Version:    0.7.0.1
 */