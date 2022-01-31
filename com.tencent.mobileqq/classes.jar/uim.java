import android.view.View;
import android.view.animation.Animation;
import android.widget.TextView;
import com.tencent.mobileqq.activity.VisitorsActivity;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

public class uim
  implements AbsListView.OnScrollListener
{
  public int a;
  public boolean a;
  
  public uim(VisitorsActivity paramVisitorsActivity)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (VersionUtils.k())
    {
      paramAbsListView = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.getCurrentFocus();
      if (paramAbsListView != null) {
        paramAbsListView.clearFocus();
      }
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VisitorsActivity", 2, paramAbsListView + ", mLastTop=" + this.jdField_a_of_type_Int + ", mHeaderVisible=" + this.jdField_a_of_type_Boolean);
    }
    paramAbsListView = paramAbsListView.getChildAt(0);
    Object localObject;
    CharSequence localCharSequence;
    if ((paramAbsListView != null) && (paramInt1 == 0))
    {
      paramInt1 = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.c.getHeight();
      paramInt2 = paramInt1 - this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.f;
      if (QLog.isColorLevel()) {
        QLog.d("VisitorsActivity", 2, "mSummaryHeight = " + paramInt1);
      }
      paramInt3 = Math.abs(paramAbsListView.getTop());
      if ((paramInt3 <= this.jdField_a_of_type_Int) || (paramInt3 < paramInt1) || (this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.getVisibility() != 8)) {
        break label269;
      }
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setVisibility(0);
      localObject = null;
      localCharSequence = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.centerView.getText();
      if ((paramInt3 <= this.jdField_a_of_type_Int) || (paramInt3 < paramInt2) || (!"".equals(localCharSequence))) {
        break label317;
      }
      paramAbsListView = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_AndroidViewAnimationAlphaAnimation;
    }
    for (;;)
    {
      if ((paramAbsListView != null) && (paramAbsListView != this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.centerView.getAnimation()))
      {
        paramAbsListView.reset();
        if (this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.d) {
          this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.centerView.startAnimation(paramAbsListView);
        }
      }
      this.jdField_a_of_type_Int = paramInt3;
      return;
      label269:
      if ((paramInt3 >= this.jdField_a_of_type_Int) || (paramInt3 > paramInt1) || (this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.getVisibility() != 0)) {
        break;
      }
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setVisibility(8);
      break;
      label317:
      paramAbsListView = localObject;
      if (paramInt3 < this.jdField_a_of_type_Int)
      {
        paramAbsListView = localObject;
        if (paramInt3 <= paramInt2)
        {
          paramAbsListView = localObject;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_b_of_type_JavaLangString.equals(localCharSequence)) {
            paramAbsListView = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_b_of_type_AndroidViewAnimationAlphaAnimation;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uim
 * JD-Core Version:    0.7.0.1
 */