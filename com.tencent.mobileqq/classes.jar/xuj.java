import android.view.View;
import android.view.animation.AlphaAnimation;
import com.tencent.mobileqq.activity.richmedia.VideoFilterViewPager;
import com.tencent.mobileqq.activity.richmedia.VideoFilterViewPager.AnimationProxy;

class xuj
  implements Runnable
{
  xuj(xui paramxui, int paramInt, View paramView) {}
  
  public void run()
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(1000L);
    localAlphaAnimation.setFillAfter(true);
    localAlphaAnimation.setAnimationListener(new VideoFilterViewPager.AnimationProxy(this.jdField_a_of_type_Xui.a, VideoFilterViewPager.a(this.jdField_a_of_type_Xui.a), this.jdField_a_of_type_Int));
    this.jdField_a_of_type_AndroidViewView.startAnimation(localAlphaAnimation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xuj
 * JD-Core Version:    0.7.0.1
 */