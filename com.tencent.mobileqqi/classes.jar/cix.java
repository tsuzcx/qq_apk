import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.DoodleActivity;
import com.tencent.mobileqq.widget.DoodleTextView;

public class cix
  implements View.OnClickListener
{
  public cix(DoodleActivity paramDoodleActivity) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() == 0) || (this.a.b.getVisibility() == 0))
    {
      this.a.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.a.b.setVisibility(8);
      this.a.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetDoodleTextView.d();
    this.a.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.a.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130839725);
    this.a.c.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cix
 * JD-Core Version:    0.7.0.1
 */