import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.PeopleAroundBaseActivity;

public class deq
  implements View.OnClickListener
{
  public deq(PeopleAroundBaseActivity paramPeopleAroundBaseActivity, View paramView1, Drawable[] paramArrayOfDrawable, LinearLayout paramLinearLayout, View paramView2) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    if (this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable != null) {
      PeopleAroundBaseActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPeopleAroundBaseActivity).setCompoundDrawables(this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[0], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[1], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[2], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[3]);
    }
    PeopleAroundBaseActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPeopleAroundBaseActivity).setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeView(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     deq
 * JD-Core Version:    0.7.0.1
 */