import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.AnimationSet;
import android.view.animation.OvershootInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.qphone.base.util.QLog;

public class zxb
{
  private View jdField_a_of_type_AndroidViewView;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private volatile boolean jdField_a_of_type_Boolean;
  private ImageView b;
  
  private Drawable a(String paramString, View paramView)
  {
    return ImageLoader.getInstance().loadImage(paramString, new zxc(this, paramView));
  }
  
  private AnimationSet a()
  {
    AnimationSet localAnimationSet = new AnimationSet(false);
    localAnimationSet.setFillAfter(true);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation.setDuration(200L);
    localScaleAnimation.setStartOffset(280L);
    localScaleAnimation.setAnimationListener(new zxd(this));
    localAnimationSet.addAnimation(localScaleAnimation);
    return localAnimationSet;
  }
  
  private AnimationSet b()
  {
    AnimationSet localAnimationSet = new AnimationSet(false);
    localAnimationSet.setFillAfter(true);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation.setDuration(200L);
    localScaleAnimation.setStartOffset(2240L);
    localScaleAnimation.setFillAfter(true);
    localScaleAnimation.setAnimationListener(new zxe(this));
    localAnimationSet.addAnimation(localScaleAnimation);
    return localAnimationSet;
  }
  
  private AnimationSet c()
  {
    if (this.b != null)
    {
      AnimationSet localAnimationSet = new AnimationSet(false);
      localAnimationSet.setFillAfter(true);
      ScaleAnimation localScaleAnimation = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, 0.5F, 1, 0.5F);
      localScaleAnimation.setInterpolator(new OvershootInterpolator());
      localScaleAnimation.setDuration(440L);
      localScaleAnimation.setStartOffset(400L);
      localScaleAnimation.setAnimationListener(new zxf(this));
      localAnimationSet.addAnimation(localScaleAnimation);
      localScaleAnimation = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.5F, 1, 0.5F);
      localScaleAnimation.setDuration(320L);
      localScaleAnimation.setStartOffset(2400L);
      localAnimationSet.addAnimation(localScaleAnimation);
      return localAnimationSet;
    }
    return null;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setAlpha(0.0F);
      this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
      this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(a());
      this.b.clearAnimation();
      this.b.startAnimation(c());
    }
    for (;;)
    {
      QLog.d("Q.videostory.config.VSEntranceWidget", 1, "playWidgetAnimationset resourceReady:" + this.jdField_a_of_type_Boolean);
      return;
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    }
  }
  
  public void a(FrameLayout paramFrameLayout, View paramView, String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout = paramFrameLayout;
    this.jdField_a_of_type_AndroidViewView = paramView;
    paramFrameLayout = zxj.a().a(paramString);
    if ((paramFrameLayout == null) || (!paramFrameLayout.a()))
    {
      QLog.e("Q.videostory.config.VSEntranceWidget", 1, "bindTargetView error!widgetConfig is null or resource not ready!");
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    paramView = a(paramFrameLayout.c, this.jdField_a_of_type_AndroidWidgetFrameLayout);
    if (paramView != null) {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundDrawable(paramView);
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131364167));
    paramView = a(paramFrameLayout.d, this.jdField_a_of_type_AndroidWidgetImageView);
    if (paramView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramView);
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.b = ((ImageView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131381091));
    paramFrameLayout = a(paramFrameLayout.f, this.b);
    if (paramFrameLayout != null) {
      this.b.setImageDrawable(paramFrameLayout);
    }
    this.b.setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zxb
 * JD-Core Version:    0.7.0.1
 */