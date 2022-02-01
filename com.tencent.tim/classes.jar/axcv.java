import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.gif.AEGifTipsPopupPart.1;
import dov.com.qq.im.ae.gif.AEGifTipsPopupPart.5;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class axcv
  extends axgh
{
  private static List<String> blackList = Arrays.asList(new String[] { "Xiaomi_MI 4C" });
  private static final String[] jj = { acfp.m(2131690015), acfp.m(2131690016), acfp.m(2131690017) };
  private View Ms;
  private View Mt;
  private Animation be;
  private Animation bf;
  private Animation bg;
  private awtq c;
  private boolean duc;
  private boolean dud;
  private boolean due;
  private Runnable runnable = new AEGifTipsPopupPart.5(this);
  private TextView textView;
  
  public axcv(Activity paramActivity, View paramView, axgi paramaxgi)
  {
    super(paramActivity, paramView, paramaxgi);
    this.c = ((awtq)paramaxgi.a(65537, new Object[0]));
    eIS();
  }
  
  private String HI()
  {
    int i = Math.abs(new Random(System.currentTimeMillis()).nextInt());
    int j = jj.length;
    return jj[(i % j)];
  }
  
  private String HJ()
  {
    return jj[0];
  }
  
  private void aE(Runnable paramRunnable)
  {
    QLog.d("AEGifTipsPopupPart", 4, "###  showup tips");
    AnimationSet localAnimationSet = new AnimationSet(false);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F);
    localScaleAnimation.setDuration(500L);
    localScaleAnimation.setInterpolator(new DecelerateInterpolator(3.0F));
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setDuration(500L);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.5F, 1, 0.0F, 0, this.Mt.getY() + this.Mt.getHeight() / 2 - this.Ms.getY(), 1, 0.0F);
    localTranslateAnimation.setDuration(500L);
    localTranslateAnimation.setInterpolator(new DecelerateInterpolator(3.0F));
    localAnimationSet.addAnimation(localScaleAnimation);
    localAnimationSet.addAnimation(localAlphaAnimation);
    localAnimationSet.addAnimation(localTranslateAnimation);
    localAnimationSet.setAnimationListener(new axcx(this, paramRunnable));
    this.Ms.startAnimation(localAnimationSet);
  }
  
  private boolean aOu()
  {
    if (!this.dud) {}
    while (axis.a().c("has_enter_aio_gif", false, 0)) {
      return false;
    }
    return true;
  }
  
  private void cT(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (isInBlackList()) {}
    label145:
    for (;;)
    {
      return;
      this.due = false;
      QLog.d("AEGifTipsPopupPart", 4, "###  show tips, random = " + paramBoolean1);
      if (this.dud)
      {
        if (paramBoolean1) {
          this.textView.setText(HI());
        }
        for (;;)
        {
          if ((isAnimationRunning(this.be)) || (isAnimationRunning(this.bf))) {
            break label145;
          }
          if (isAnimationRunning(this.bg))
          {
            this.bg.setAnimationListener(null);
            this.bg.cancel();
            this.bg = null;
          }
          if (this.Ms == null) {
            break;
          }
          if (!paramBoolean2) {
            break label147;
          }
          aE(new AEGifTipsPopupPart.1(this));
          return;
          this.textView.setText(HJ());
        }
      }
    }
    label147:
    eIT();
  }
  
  private void dCB()
  {
    this.duc = false;
    this.Ms.removeCallbacks(this.runnable);
    this.Ms.setVisibility(4);
    if (isAnimationRunning(this.be))
    {
      this.be.setAnimationListener(null);
      this.be.cancel();
      this.be = null;
    }
    if (isAnimationRunning(this.bf))
    {
      this.bf.setAnimationListener(null);
      this.bf.cancel();
      this.bf = null;
    }
    if (isAnimationRunning(this.bg))
    {
      this.bg.setAnimationListener(null);
      this.bg.cancel();
      this.bg = null;
    }
  }
  
  private void eIS()
  {
    int i = 200;
    Intent localIntent = this.c.getActivity().getIntent();
    if (localIntent != null) {
      i = localIntent.getIntExtra("AECAMERA_MODE", 200);
    }
    if (i == 202) {
      this.dud = true;
    }
    QLog.d("AEGifTipsPopupPart", 4, "###  isFromAIOGif = " + this.dud);
  }
  
  private void eIT()
  {
    if (this.due) {
      return;
    }
    this.Ms.setVisibility(0);
    this.bf = new TranslateAnimation(0.0F, 0.0F, 0.0F, 15.0F);
    this.bf.setDuration(300L);
    this.bf.setRepeatCount(-1);
    this.bf.setRepeatMode(2);
    this.bf.setAnimationListener(new axcw(this));
    this.Ms.startAnimation(this.bf);
  }
  
  private void eIU()
  {
    if (!this.dud) {
      return;
    }
    axis.a().n("has_enter_aio_gif", true, 0);
  }
  
  private void eIV()
  {
    if (!this.dud) {}
    while ((isInBlackList()) || (isAnimationRunning(this.be)) || (isAnimationRunning(this.bf))) {
      return;
    }
    boolean bool = aOu();
    QLog.d("AEGifTipsPopupPart", 4, "###  showIfFirstTimeEnter， first = " + bool);
    if (bool)
    {
      cT(false, false);
      eIU();
      return;
    }
    this.duc = false;
    this.Ms.postDelayed(this.runnable, 5000L);
  }
  
  private void hide()
  {
    QLog.d("AEGifTipsPopupPart", 4, "###  hide tips");
    this.due = true;
    if (isAnimationRunning(this.be))
    {
      this.be.setAnimationListener(null);
      this.be.reset();
      this.be = null;
    }
    if (isAnimationRunning(this.bf))
    {
      this.bf.setAnimationListener(null);
      this.bf.reset();
      this.bf = null;
    }
    if (this.Ms == null) {}
    do
    {
      return;
      this.Ms.removeCallbacks(this.runnable);
    } while (this.Ms.getVisibility() != 0);
    AnimationSet localAnimationSet = new AnimationSet(false);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F);
    localScaleAnimation.setDuration(300L);
    localScaleAnimation.setInterpolator(new AccelerateInterpolator(3.0F));
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.5F, 1, 0.0F, 0, this.Mt.getY() + this.Mt.getHeight() / 2 - this.Ms.getY());
    localTranslateAnimation.setDuration(300L);
    localTranslateAnimation.setInterpolator(new AccelerateInterpolator(3.0F));
    localAnimationSet.addAnimation(localScaleAnimation);
    localAnimationSet.addAnimation(localTranslateAnimation);
    localAnimationSet.setAnimationListener(new axcy(this));
    this.Ms.startAnimation(localAnimationSet);
  }
  
  private static boolean isAnimationRunning(Animation paramAnimation)
  {
    return (paramAnimation != null) && (paramAnimation.hasStarted()) && (!paramAnimation.hasEnded());
  }
  
  private static boolean isInBlackList()
  {
    String str = Build.MANUFACTURER + "_" + Build.MODEL;
    return blackList.contains(str);
  }
  
  public <T> T a(int paramInt, Object... paramVarArgs)
  {
    return super.a(paramInt, paramVarArgs);
  }
  
  protected void initView()
  {
    this.Mt = this.mRootView.findViewById(2131367247);
    this.Ms = this.mRootView.findViewById(2131368031);
    this.textView = ((TextView)this.Ms.findViewById(2131368032));
  }
  
  public void onActivityPause()
  {
    super.onActivityPause();
  }
  
  public void onActivityResume()
  {
    eIV();
    super.onActivityResume();
  }
  
  public void onDestroy()
  {
    dCB();
    super.onDestroy();
  }
  
  public void p(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    hide();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axcv
 * JD-Core Version:    0.7.0.1
 */