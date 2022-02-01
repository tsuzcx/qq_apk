import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.DoodleActivity;

public class cjc
  implements View.OnClickListener
{
  public cjc(DoodleActivity paramDoodleActivity) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() == 0) || (this.a.b.getVisibility() == 0))
    {
      this.a.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.a.b.setVisibility(8);
      this.a.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
      return;
    }
    this.a.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.a.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130839725);
    this.a.c.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cjc
 * JD-Core Version:    0.7.0.1
 */