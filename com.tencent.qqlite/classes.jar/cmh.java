import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;

public class cmh
  implements Animation.AnimationListener
{
  public cmh(SelectMemberActivity paramSelectMemberActivity, TranslateAnimation paramTranslateAnimation, AlphaAnimation paramAlphaAnimation, long paramLong) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation == this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.f();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.b.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation);
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_a_of_type_ComTencentWidgetXListView.setSelection(0);
      SelectMemberActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity).setVisibility(8);
      new Thread(new cmi(this)).start();
      if (QLog.isColorLevel()) {
        QLog.d("Q.PerfTrace", 2, "selectmember search up anim time: " + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
      }
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cmh
 * JD-Core Version:    0.7.0.1
 */