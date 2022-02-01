import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.apollo.view.ApolloLottieAnim;
import com.tencent.mobileqq.app.MemoryManager;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;

public class awlv
  extends awlz
{
  private boolean anS = true;
  protected ApolloLottieAnim d;
  private boolean mIsLoop;
  private String mZipUrl;
  
  public awlv(String paramString, View paramView)
  {
    super(paramString, paramView);
  }
  
  protected void RC()
  {
    super.RC();
    if (!(this.ey instanceof DiniFlyAnimationView)) {
      return;
    }
    if (this.d == null) {
      this.d = a(this.ey.getContext());
    }
    ((DiniFlyAnimationView)this.ey).loop(this.mIsLoop);
    ((DiniFlyAnimationView)this.ey).setScaleType(ImageView.ScaleType.CENTER_CROP);
    if (QLog.isColorLevel()) {
      QLog.i("JsonInflateViewModel", 0, " lottie url = " + this.mZipUrl);
    }
    ApolloLottieAnim localApolloLottieAnim1 = this.d;
    DiniFlyAnimationView localDiniFlyAnimationView = (DiniFlyAnimationView)this.ey;
    String str = this.mZipUrl;
    ApolloLottieAnim localApolloLottieAnim2 = this.d;
    localApolloLottieAnim1.a(localDiniFlyAnimationView, str, ApolloLottieAnim.jb(this.mZipUrl), this.anS);
  }
  
  protected ApolloLottieAnim a(Context paramContext)
  {
    paramContext = new aqvv(null, paramContext);
    paramContext.hx((int)(MemoryManager.eS() / 2L));
    return paramContext;
  }
  
  public void onDestory()
  {
    super.onDestory();
    if (this.d != null) {
      this.d.destroy();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if ((this.ey != null) && ((this.ey instanceof DiniFlyAnimationView))) {
      ((DiniFlyAnimationView)this.ey).pauseAnimation();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if ((this.ey != null) && ((this.ey instanceof DiniFlyAnimationView))) {
      ((DiniFlyAnimationView)this.ey).playAnimation();
    }
  }
  
  protected void setAttribute(String paramString1, String paramString2)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    super.setAttribute(paramString1, paramString2);
    if (!(this.ey instanceof ImageView)) {}
    do
    {
      return;
      if ("content".equals(paramString1))
      {
        this.mZipUrl = paramString2;
        return;
      }
      if ("loop".equals(paramString1))
      {
        if (Integer.parseInt(paramString2) == 1) {}
        for (;;)
        {
          this.mIsLoop = bool1;
          return;
          bool1 = false;
        }
      }
    } while (!"auto_play".equals(paramString1));
    if (Integer.parseInt(paramString2) == 1) {}
    for (bool1 = bool2;; bool1 = false)
    {
      this.anS = bool1;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awlv
 * JD-Core Version:    0.7.0.1
 */