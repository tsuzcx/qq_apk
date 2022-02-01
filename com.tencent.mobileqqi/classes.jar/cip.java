import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.DoodleActivity;
import com.tencent.mobileqq.widget.DoodlePicView;

public class cip
  implements View.OnClickListener
{
  public cip(DoodleActivity paramDoodleActivity) {}
  
  public void onClick(View paramView)
  {
    int j = 0;
    int i = 0;
    while (i < 6)
    {
      this.a.jdField_a_of_type_ArrayOfAndroidWidgetImageView[i].setBackgroundDrawable(null);
      i += 1;
    }
    paramView.setBackgroundResource(2130839734);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cip
 * JD-Core Version:    0.7.0.1
 */