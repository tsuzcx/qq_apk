import android.app.Dialog;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.biz.PoiMapActivity;

public class ka
  implements Animation.AnimationListener
{
  public ka(PoiMapActivity paramPoiMapActivity, TranslateAnimation paramTranslateAnimation1, Dialog paramDialog, int paramInt, TranslateAnimation paramTranslateAnimation2) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    if (paramAnimation == this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation)
    {
      this.jdField_a_of_type_AndroidAppDialog.show();
      localLayoutParams.height = (this.jdField_a_of_type_ComTencentBizPoiMapActivity.a.getHeight() + this.jdField_a_of_type_Int);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPoiMapActivity.a.setLayoutParams(localLayoutParams);
      return;
      if (paramAnimation == this.b) {
        localLayoutParams.height = (this.jdField_a_of_type_ComTencentBizPoiMapActivity.a.getHeight() - this.jdField_a_of_type_Int);
      }
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ka
 * JD-Core Version:    0.7.0.1
 */