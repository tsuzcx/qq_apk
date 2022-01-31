import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.AccountManageActivity;

class byz
  implements Runnable
{
  byz(byy parambyy) {}
  
  public void run()
  {
    if (this.a.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams;
    switch (this.a.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 0: 
      localLayoutParams = (RelativeLayout.LayoutParams)this.a.jdField_a_of_type_AndroidViewView.getLayoutParams();
      localLayoutParams.leftMargin += (int)(this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.a * 34.0F);
      this.a.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
      this.a.jdField_a_of_type_AndroidViewView.setTag("right");
    }
    for (;;)
    {
      this.a.jdField_a_of_type_AndroidViewView.clearAnimation();
      return;
      localLayoutParams = (RelativeLayout.LayoutParams)this.a.jdField_a_of_type_AndroidViewView.getLayoutParams();
      localLayoutParams.leftMargin -= (int)(this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.a * 34.0F);
      this.a.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
      this.a.jdField_a_of_type_AndroidViewView.setTag("left");
      continue;
      ((ImageView)this.a.jdField_a_of_type_AndroidViewView).setImageResource(2130839713);
      continue;
      ((ImageView)this.a.jdField_a_of_type_AndroidViewView).setImageResource(2130839712);
      continue;
      this.a.jdField_a_of_type_AndroidViewView.setVisibility(0);
      if (this.a.jdField_a_of_type_AndroidViewView.getId() == 2131231002)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.q_();
        continue;
        this.a.jdField_a_of_type_AndroidViewView.setVisibility(4);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     byz
 * JD-Core Version:    0.7.0.1
 */