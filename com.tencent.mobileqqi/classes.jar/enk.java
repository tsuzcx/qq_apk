import android.content.res.Resources;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mobileqq.activity.photo.PhotoPreviewActivity;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemSelectedListener;
import java.util.ArrayList;

public class enk
  implements AdapterView.OnItemSelectedListener
{
  public enk(PhotoPreviewActivity paramPhotoPreviewActivity) {}
  
  public void a(AdapterView paramAdapterView) {}
  
  public void a_(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.a.jdField_b_of_type_Int = paramInt;
    if (this.a.jdField_b_of_type_JavaUtilArrayList.contains(Integer.valueOf(this.a.jdField_b_of_type_Int)))
    {
      this.a.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
      if (this.a.jdField_a_of_type_JavaUtilArrayList.size() <= 1) {
        break label135;
      }
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt + 1 + " / " + this.a.jdField_a_of_type_JavaUtilArrayList.size());
    }
    for (;;)
    {
      this.a.getSupportActionBar().setTitle(this.a.jdField_a_of_type_AndroidWidgetTextView.getText());
      return;
      this.a.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
      break;
      label135:
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText(this.a.getResources().getString(2131562660));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     enk
 * JD-Core Version:    0.7.0.1
 */