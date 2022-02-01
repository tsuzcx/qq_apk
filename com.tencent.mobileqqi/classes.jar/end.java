import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mobileqq.activity.photo.PhotoPreviewActivity;
import java.util.ArrayList;

public class end
  implements View.OnClickListener
{
  public end(PhotoPreviewActivity paramPhotoPreviewActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.getIntent().getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
    if (this.a.jdField_b_of_type_JavaUtilArrayList.contains(Integer.valueOf(this.a.jdField_b_of_type_Int)))
    {
      this.a.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
      int i = this.a.jdField_b_of_type_JavaUtilArrayList.indexOf(Integer.valueOf(this.a.jdField_b_of_type_Int));
      if (i >= 0) {
        this.a.jdField_b_of_type_JavaUtilArrayList.remove(i);
      }
      PhotoPreviewActivity.a(this.a);
      return;
    }
    if ((PhotoPreviewActivity.a(this.a) == 1) && (this.a.jdField_b_of_type_Int < this.a.jdField_a_of_type_JavaUtilArrayList.size())) {
      PhotoPreviewActivity.a(this.a, (String)this.a.jdField_a_of_type_JavaUtilArrayList.get(this.a.jdField_b_of_type_Int));
    }
    this.a.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
    this.a.jdField_b_of_type_JavaUtilArrayList.add(Integer.valueOf(this.a.jdField_b_of_type_Int));
    PhotoPreviewActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     end
 * JD-Core Version:    0.7.0.1
 */