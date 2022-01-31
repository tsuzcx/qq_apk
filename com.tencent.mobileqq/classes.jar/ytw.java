import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.apollo.view.ApolloFavViewBinder;
import com.tencent.mobileqq.apollo.view.ApolloLinearLayout.ViewHolder;

public class ytw
  implements Runnable
{
  public ytw(ApolloFavViewBinder paramApolloFavViewBinder, ImageView paramImageView, RelativeLayout paramRelativeLayout1, RelativeLayout paramRelativeLayout2, ApolloLinearLayout.ViewHolder paramViewHolder) {}
  
  public void run()
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, -0.5F, 1, 0.5F, 1, -0.5F, 1, 0.5F);
    localTranslateAnimation.setDuration(400L);
    localTranslateAnimation.setRepeatCount(1);
    localTranslateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
    localTranslateAnimation.setAnimationListener(new ytx(this));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(localTranslateAnimation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ytw
 * JD-Core Version:    0.7.0.1
 */