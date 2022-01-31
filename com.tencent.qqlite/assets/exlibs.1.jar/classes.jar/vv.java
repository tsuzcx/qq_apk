import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.qphone.base.util.QLog;

class vv
  extends GestureDetector.SimpleOnGestureListener
{
  vv(vu paramvu) {}
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    ViewGroup.LayoutParams localLayoutParams;
    if ((paramFloat1 > 0.0F) && (Math.abs(paramFloat1) > Math.abs(paramFloat2)) && (Math.abs(paramFloat1) > 20.0F) && (!this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.c) && (this.a.jdField_a_of_type_AndroidViewView != null))
    {
      paramMotionEvent1 = this.a.jdField_a_of_type_AndroidViewView.findViewById(2131296441);
      if (paramMotionEvent1 != null)
      {
        if (paramMotionEvent1.getVisibility() == 0) {
          break label453;
        }
        if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.jdField_a_of_type_AndroidViewView != null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("AccountManage", 2, "hide previous selectedAccountView");
          }
          ((ShaderAnimLayout)AccountManageActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity, this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.jdField_a_of_type_AndroidViewView)).d();
          paramMotionEvent2 = AccountManageActivity.b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity, this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.jdField_a_of_type_AndroidViewView);
          this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.jdField_a_of_type_AndroidViewView, 2130968579, 3);
          localLayoutParams = paramMotionEvent2.getLayoutParams();
          if (!this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.jdField_a_of_type_Boolean) {
            break label402;
          }
          localLayoutParams.width = ((int)(AccountManageActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity) - AccountManageActivity.c(this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity) * 40.0F));
          paramMotionEvent2.setLayoutParams(localLayoutParams);
        }
        if (QLog.isColorLevel()) {
          QLog.i("AccountManage", 2, "show current selectedAccountView");
        }
        ((ShaderAnimLayout)paramMotionEvent1).a();
        this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.jdField_a_of_type_AndroidViewView = this.a.jdField_a_of_type_AndroidViewView.findViewById(2131296452);
        paramMotionEvent1 = AccountManageActivity.b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity, this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.jdField_a_of_type_AndroidViewView);
        this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.jdField_a_of_type_AndroidViewView, 2130968580, 2);
        paramMotionEvent2 = paramMotionEvent1.getLayoutParams();
        if (!this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.jdField_a_of_type_Boolean) {
          break label421;
        }
      }
    }
    label402:
    label421:
    for (paramMotionEvent2.width = ((int)(AccountManageActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity) - 75.0F * AccountManageActivity.d(this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity)));; paramMotionEvent2.width = ((int)(AccountManageActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity) - 35.0F * AccountManageActivity.e(this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity))))
    {
      paramMotionEvent1.setLayoutParams(paramMotionEvent2);
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.a(true);
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.c = true;
      this.a.jdField_a_of_type_AndroidViewView.setPressed(false);
      return true;
      localLayoutParams.width = ((int)AccountManageActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity));
      break;
    }
    label453:
    if (QLog.isColorLevel()) {
      QLog.i("AccountManage", 2, "hide current selectedAccountView");
    }
    ((ShaderAnimLayout)paramMotionEvent1).d();
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.jdField_a_of_type_AndroidViewView != null)
    {
      paramMotionEvent1 = AccountManageActivity.b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity, this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.jdField_a_of_type_AndroidViewView);
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.jdField_a_of_type_AndroidViewView, 2130968579, 3);
      paramMotionEvent2 = paramMotionEvent1.getLayoutParams();
      if (!this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.jdField_a_of_type_Boolean) {
        break label642;
      }
    }
    label642:
    for (paramMotionEvent2.width = ((int)(AccountManageActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity) - AccountManageActivity.f(this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity) * 40.0F));; paramMotionEvent2.width = ((int)AccountManageActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity)))
    {
      paramMotionEvent1.setLayoutParams(paramMotionEvent2);
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.jdField_a_of_type_AndroidViewView = null;
      if (!this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.jdField_a_of_type_Boolean) {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.a(false);
      }
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.c = true;
      this.a.jdField_a_of_type_AndroidViewView.setPressed(false);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     vv
 * JD-Core Version:    0.7.0.1
 */