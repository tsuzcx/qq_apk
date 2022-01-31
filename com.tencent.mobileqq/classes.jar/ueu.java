import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorListenerAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.VisitorsActivity;
import java.util.List;

public class ueu
  extends AnimatorListenerAdapter
{
  int jdField_a_of_type_Int = 0;
  boolean jdField_a_of_type_Boolean = true;
  
  public ueu(VisitorsActivity paramVisitorsActivity) {}
  
  public void onAnimationRepeat(Animator paramAnimator)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      int j = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.a.size();
      int i = 0;
      for (;;)
      {
        if (i < j)
        {
          this.jdField_a_of_type_Int = ((this.jdField_a_of_type_Int + 1) % j);
          paramAnimator = (Drawable)this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.a.get(this.jdField_a_of_type_Int);
          if (paramAnimator == null) {
            break label112;
          }
          if (!(paramAnimator instanceof URLDrawable)) {
            break label98;
          }
          if (((URLDrawable)paramAnimator).getStatus() != 1) {
            break label112;
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.c.setImageDrawable(paramAnimator);
        }
        for (;;)
        {
          this.jdField_a_of_type_Boolean = false;
          return;
          label98:
          this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.c.setImageDrawable(paramAnimator);
        }
        label112:
        i += 1;
      }
    }
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ueu
 * JD-Core Version:    0.7.0.1
 */