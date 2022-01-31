import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.DoodleActivity;
import com.tencent.mobileqq.widget.DoodlePicView;

public class akf
  implements View.OnClickListener
{
  public akf(DoodleActivity paramDoodleActivity) {}
  
  public void onClick(View paramView)
  {
    int j = 0;
    int i = 0;
    while (i < 6)
    {
      this.a.jdField_a_of_type_ArrayOfAndroidWidgetImageView[i].setBackgroundDrawable(null);
      i += 1;
    }
    paramView.setBackgroundResource(2130839172);
    int k = paramView.getId();
    i = j;
    for (;;)
    {
      if (i < 6)
      {
        if (this.a.jdField_a_of_type_ArrayOfInt[i] == k) {
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetDoodlePicView.setPaintThickness(this.a.c[i]);
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
 * Qualified Name:     akf
 * JD-Core Version:    0.7.0.1
 */