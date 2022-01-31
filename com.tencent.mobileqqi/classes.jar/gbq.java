import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.maproam.activity.RoamingActivity;
import com.tencent.mobileqq.maproam.widget.RoamLocalSearchBar;
import com.tencent.mobileqq.utils.VipUtils;

public class gbq
  implements Runnable
{
  static
  {
    if (!RoamingActivity.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  public gbq(RoamingActivity paramRoamingActivity, int paramInt) {}
  
  public void run()
  {
    if ((!jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqMaproamActivityRoamingActivity.c.getLayoutParams() == null)) {
      throw new AssertionError();
    }
    if (1 == this.jdField_a_of_type_Int)
    {
      View localView1 = this.jdField_a_of_type_ComTencentMobileqqMaproamActivityRoamingActivity.findViewById(16908290);
      if (localView1 == null) {
        return;
      }
      View localView2 = this.jdField_a_of_type_ComTencentMobileqqMaproamActivityRoamingActivity.findViewById(2131231448);
      this.jdField_a_of_type_ComTencentMobileqqMaproamActivityRoamingActivity.c.getLayoutParams().height = (localView1.getHeight() - localView2.getHeight());
      this.jdField_a_of_type_ComTencentMobileqqMaproamActivityRoamingActivity.jdField_b_of_type_AndroidViewView.setVisibility(8);
      RoamingActivity.a(this.jdField_a_of_type_ComTencentMobileqqMaproamActivityRoamingActivity).setVisibility(8);
      RoamingActivity.a(this.jdField_a_of_type_ComTencentMobileqqMaproamActivityRoamingActivity).setVisibility(8);
      if (VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqMaproamActivityRoamingActivity.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface)) {
        this.jdField_a_of_type_ComTencentMobileqqMaproamActivityRoamingActivity.a.setVisibility(0);
      }
      this.jdField_a_of_type_ComTencentMobileqqMaproamActivityRoamingActivity.setTitle(2131562996);
      RoamingActivity.a(this.jdField_a_of_type_ComTencentMobileqqMaproamActivityRoamingActivity);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqMaproamActivityRoamingActivity.c.requestLayout();
      return;
      this.jdField_a_of_type_ComTencentMobileqqMaproamActivityRoamingActivity.c.getLayoutParams().height = this.jdField_a_of_type_ComTencentMobileqqMaproamActivityRoamingActivity.getResources().getDimensionPixelSize(2131427577);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     gbq
 * JD-Core Version:    0.7.0.1
 */