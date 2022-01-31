import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.AccountManageActivity;

class vy
  implements Runnable
{
  vy(vx paramvx) {}
  
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
      ((ImageView)this.a.jdField_a_of_type_AndroidViewView).setImageResource(2130839155);
      continue;
      ((ImageView)this.a.jdField_a_of_type_AndroidViewView).setImageResource(2130839154);
      continue;
      this.a.jdField_a_of_type_AndroidViewView.setVisibility(0);
      if (this.a.jdField_a_of_type_AndroidViewView.getId() == 2131296460)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.c();
        continue;
        this.a.jdField_a_of_type_AndroidViewView.setVisibility(4);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     vy
 * JD-Core Version:    0.7.0.1
 */