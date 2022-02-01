import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideofeedsUserGuideController.1;
import com.tencent.biz.pubaccount.readinjoy.video.VideofeedsUserGuideController.4;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;

public class mzn
{
  private boolean apC;
  private boolean aqQ = true;
  private boolean aqR;
  private boolean aqS;
  private LinearLayout ee;
  private Activity mActivity;
  private Context mAppContext;
  private boolean mIsFullScreen;
  private View mRoot;
  private AppRuntime mRuntime;
  private Handler mUIHandler = new mzq(this, Looper.getMainLooper());
  private TranslateAnimation r;
  private TranslateAnimation s;
  private AnimatorSet y;
  
  public mzn(Activity paramActivity, AppRuntime paramAppRuntime, View paramView, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mRoot = paramView;
    this.mRuntime = paramAppRuntime;
    this.aqS = paramBoolean1;
    this.mAppContext = paramActivity.getApplicationContext();
    this.mActivity = paramActivity;
    this.apC = paramBoolean2;
    this.ee = ((LinearLayout)this.mRoot.findViewById(2131381396));
  }
  
  @TargetApi(11)
  private void a(View paramView1, View paramView2, long paramLong1, long paramLong2)
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      paramView1.setAlpha(0.0F);
      paramView1.setVisibility(0);
      paramView2.setAlpha(0.0F);
      paramView2.setVisibility(0);
      paramView1 = ObjectAnimator.ofFloat(paramView1, "alpha", new float[] { 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F });
      paramView2 = ObjectAnimator.ofFloat(paramView2, "alpha", new float[] { 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F });
      paramView1.setDuration(1800L);
      paramView1.setRepeatCount(-1);
      paramView1.setRepeatMode(1);
      paramView1.setStartDelay(paramLong1);
      paramView2.setDuration(1800L);
      paramView2.setRepeatCount(-1);
      paramView2.setRepeatMode(1);
      paramView2.setStartDelay(paramLong2);
      if (this.y == null) {
        this.y = new AnimatorSet();
      }
      this.y.playTogether(new Animator[] { paramView1, paramView2 });
      this.y.start();
      return;
    }
    paramView1.setVisibility(0);
    paramView2.setVisibility(0);
  }
  
  @TargetApi(11)
  public void M(VideoInfo paramVideoInfo)
  {
    if (!this.aqQ) {}
    int i;
    do
    {
      do
      {
        return;
        this.aqR = true;
      } while ((this.ee.getVisibility() == 0) || (this.mIsFullScreen) || (this.apC));
      i = awit.P(this.mRuntime);
    } while (i >= 3);
    awit.N(this.mRuntime, i + 1);
    this.mUIHandler.sendEmptyMessageDelayed(1, 5000L);
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideofeedsUserGuideController", 2, "show user guide");
    }
    TextView localTextView = (TextView)this.ee.findViewById(2131381403);
    if ((TextUtils.isEmpty(paramVideoInfo.Wz)) || (this.r != null)) {
      this.r.cancel();
    }
    if (this.s != null) {
      this.s.cancel();
    }
    this.r = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, -0.2F);
    this.r.setDuration(200L);
    this.r.setFillAfter(true);
    this.s = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, -0.2F, 1, 0.0F);
    this.s.setDuration(300L);
    this.s.setFillAfter(true);
    this.r.setAnimationListener(new mzo(this));
    this.s.setAnimationListener(new mzp(this));
    this.mUIHandler.postDelayed(new VideofeedsUserGuideController.4(this), 300L);
  }
  
  @TargetApi(11)
  public void aTb()
  {
    if (!this.aqR) {}
    while (this.ee.getVisibility() == 8) {
      return;
    }
    this.aqR = false;
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideofeedsUserGuideController", 2, "hide user guide");
    }
    aUN();
    this.mUIHandler.post(new VideofeedsUserGuideController.1(this));
  }
  
  @TargetApi(11)
  public void aUN()
  {
    if (this.ee.getAnimation() != null)
    {
      this.ee.getAnimation().setAnimationListener(null);
      this.ee.getAnimation().cancel();
      this.ee.clearAnimation();
    }
    if (this.r != null)
    {
      this.r.setAnimationListener(null);
      this.r.cancel();
      this.r = null;
    }
    if (this.s != null)
    {
      this.s.setAnimationListener(null);
      this.s.cancel();
      this.s = null;
    }
    if (Build.VERSION.SDK_INT >= 11)
    {
      if (this.y != null)
      {
        Iterator localIterator = this.y.getChildAnimations().iterator();
        while (localIterator.hasNext())
        {
          Animator localAnimator = (Animator)localIterator.next();
          localAnimator.end();
          localAnimator.cancel();
        }
        this.y.end();
        this.y.cancel();
      }
      this.y = null;
    }
  }
  
  public void pa(boolean paramBoolean)
  {
    this.aqQ = paramBoolean;
  }
  
  public void setFullScreen(boolean paramBoolean)
  {
    this.mIsFullScreen = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mzn
 * JD-Core Version:    0.7.0.1
 */