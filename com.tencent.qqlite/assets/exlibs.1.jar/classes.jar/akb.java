import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.DoodleActivity;
import com.tencent.mobileqq.widget.DoodlePicView;
import com.tencent.mobileqq.widget.DoodleTextView;

public class akb
  implements View.OnClickListener
{
  public akb(DoodleActivity paramDoodleActivity) {}
  
  public void onClick(View paramView)
  {
    int j = 0;
    int i = 0;
    while (i < 6)
    {
      this.a.jdField_b_of_type_ArrayOfAndroidWidgetImageView[i].setBackgroundDrawable(null);
      i += 1;
    }
    paramView.setBackgroundResource(2130839136);
    int k = paramView.getId();
    i = j;
    for (;;)
    {
      if (i < 6)
      {
        if (this.a.jdField_b_of_type_ArrayOfInt[i] == k)
        {
          if (this.a.jdField_a_of_type_Boolean) {
            this.a.jdField_a_of_type_ComTencentMobileqqWidgetDoodleTextView.d();
          }
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetDoodleTextView.setPaintColor(this.a.d[i]);
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetDoodlePicView.setPaintColor(this.a.d[i]);
        }
      }
      else {
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     akb
 * JD-Core Version:    0.7.0.1
 */