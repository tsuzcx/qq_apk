import android.content.res.Resources;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.FriendProfileImageActivity;

public class cnt
  implements Runnable
{
  public cnt(FriendProfileImageActivity paramFriendProfileImageActivity) {}
  
  public void run()
  {
    this.a.jdField_c_of_type_Boolean = false;
    if (this.a.a != 0L)
    {
      this.a.b.setVisibility(0);
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, this.a.getResources().getDimension(2131427548), 0.0F);
      localTranslateAnimation.setDuration(300L);
      localTranslateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
      this.a.jdField_c_of_type_AndroidWidgetRelativeLayout.startAnimation(localTranslateAnimation);
      return;
    }
    this.a.b.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cnt
 * JD-Core Version:    0.7.0.1
 */