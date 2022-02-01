import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.gdtad.api.motivevideo.GdtMvViewAnimationAbs.1;
import com.tencent.gdtad.api.motivevideo.GdtMvViewAnimationAbs.2;

public class tjd
{
  public tiw a;
  protected Context mContext;
  protected Handler mUIHandler;
  
  protected tjd(Context paramContext)
  {
    this.mContext = paramContext;
    this.mUIHandler = new Handler(Looper.getMainLooper());
  }
  
  private void a(tiw paramtiw)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramtiw.qX.getLayoutParams();
    localLayoutParams.height = paramtiw.bBP;
    localLayoutParams.width = paramtiw.bBQ;
    localLayoutParams.addRule(3, 0);
    localLayoutParams.addRule(12, 0);
    localLayoutParams.addRule(14);
    localLayoutParams.addRule(15);
    paramtiw.qX.setLayoutParams(localLayoutParams);
    paramtiw.qX.postInvalidate();
  }
  
  public static void el(View paramView)
  {
    if ((paramView == null) || (paramView.getVisibility() != 0)) {
      return;
    }
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(200L);
    paramView.startAnimation(localAlphaAnimation);
    paramView.setVisibility(8);
  }
  
  public static void em(View paramView)
  {
    if (paramView == null) {
      return;
    }
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setDuration(100L);
    paramView.startAnimation(localAlphaAnimation);
    paramView.setVisibility(0);
  }
  
  protected void a(tiw paramtiw, View paramView)
  {
    paramtiw.qX = paramView;
    paramtiw.bBQ = tls.i(470, 750, tls.af(this.mContext));
    paramtiw.bBP = tls.i(470, 1334, tls.ae(this.mContext));
  }
  
  public void bDr()
  {
    if ((this.a == null) || (this.a.qW == null)) {
      return;
    }
    el(this.a.qW);
    this.mUIHandler.postDelayed(new GdtMvViewAnimationAbs.1(this), 300L);
  }
  
  public void c(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramView == null) {
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
    int i = localLayoutParams.topMargin;
    int j = localLayoutParams.leftMargin;
    int k = localLayoutParams.rightMargin;
    el(paramView);
    this.mUIHandler.postDelayed(new GdtMvViewAnimationAbs.2(this, localLayoutParams, i, paramInt1, j, paramInt2, paramInt3, k, paramView), 200L);
  }
  
  public void o(View paramView, int paramInt1, int paramInt2)
  {
    c(paramView, paramInt1, paramInt2, -1);
  }
  
  public void onDestroy()
  {
    this.mUIHandler.removeCallbacksAndMessages(null);
    this.mContext = null;
  }
  
  public void zu(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tjd
 * JD-Core Version:    0.7.0.1
 */