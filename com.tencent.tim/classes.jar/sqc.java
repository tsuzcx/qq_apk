import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.AnimationSet;
import android.view.animation.OvershootInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.qphone.base.util.QLog;

public class sqc
{
  private volatile boolean aMy;
  private FrameLayout aN;
  private ImageView oD;
  private ImageView oE;
  private View qz;
  
  private Drawable a(String paramString, View paramView)
  {
    return ImageLoader.getInstance().loadImage(paramString, new sqd(this, paramView));
  }
  
  private AnimationSet e()
  {
    if (this.oE != null)
    {
      AnimationSet localAnimationSet = new AnimationSet(false);
      localAnimationSet.setFillAfter(true);
      ScaleAnimation localScaleAnimation = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, 0.5F, 1, 0.5F);
      localScaleAnimation.setInterpolator(new OvershootInterpolator());
      localScaleAnimation.setDuration(440L);
      localScaleAnimation.setStartOffset(400L);
      localScaleAnimation.setAnimationListener(new sqg(this));
      localAnimationSet.addAnimation(localScaleAnimation);
      localScaleAnimation = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.5F, 1, 0.5F);
      localScaleAnimation.setDuration(320L);
      localScaleAnimation.setStartOffset(2400L);
      localAnimationSet.addAnimation(localScaleAnimation);
      return localAnimationSet;
    }
    return null;
  }
  
  private AnimationSet g()
  {
    AnimationSet localAnimationSet = new AnimationSet(false);
    localAnimationSet.setFillAfter(true);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation.setDuration(200L);
    localScaleAnimation.setStartOffset(280L);
    localScaleAnimation.setAnimationListener(new sqe(this));
    localAnimationSet.addAnimation(localScaleAnimation);
    return localAnimationSet;
  }
  
  private AnimationSet h()
  {
    AnimationSet localAnimationSet = new AnimationSet(false);
    localAnimationSet.setFillAfter(true);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation.setDuration(200L);
    localScaleAnimation.setStartOffset(2240L);
    localScaleAnimation.setFillAfter(true);
    localScaleAnimation.setAnimationListener(new sqf(this));
    localAnimationSet.addAnimation(localScaleAnimation);
    return localAnimationSet;
  }
  
  public void a(FrameLayout paramFrameLayout, View paramView, String paramString)
  {
    this.aN = paramFrameLayout;
    this.qz = paramView;
    paramFrameLayout = sqj.a().a(paramString);
    if ((paramFrameLayout == null) || (!paramFrameLayout.isResourceReady()))
    {
      QLog.e("Q.videostory.config.VSEntranceWidget", 1, "bindTargetView error!widgetConfig is null or resource not ready!");
      this.aMy = false;
      return;
    }
    this.aMy = true;
    paramView = a(paramFrameLayout.aFS, this.aN);
    if (paramView != null) {
      this.aN.setBackgroundDrawable(paramView);
    }
    this.aN.setVisibility(4);
    this.oD = ((ImageView)this.aN.findViewById(2131364212));
    paramView = a(paramFrameLayout.aFT, this.oD);
    if (paramView != null) {
      this.oD.setImageDrawable(paramView);
    }
    this.oD.setVisibility(0);
    this.oE = ((ImageView)this.aN.findViewById(2131382243));
    paramFrameLayout = a(paramFrameLayout.aFV, this.oE);
    if (paramFrameLayout != null) {
      this.oE.setImageDrawable(paramFrameLayout);
    }
    this.oE.setVisibility(4);
  }
  
  public void bzQ()
  {
    if (this.aMy)
    {
      this.aN.setVisibility(0);
      this.qz.setAlpha(0.0F);
      this.oD.clearAnimation();
      this.oD.startAnimation(g());
      this.oE.clearAnimation();
      this.oE.startAnimation(e());
    }
    for (;;)
    {
      QLog.d("Q.videostory.config.VSEntranceWidget", 1, "playWidgetAnimationset resourceReady:" + this.aMy);
      return;
      this.aN.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sqc
 * JD-Core Version:    0.7.0.1
 */