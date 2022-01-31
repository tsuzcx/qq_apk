import android.content.res.Resources;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mobileqq.activity.photo.PhotoPreviewActivity;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemSelectedListener;
import java.util.ArrayList;

public class cji
  implements AdapterView.OnItemSelectedListener
{
  public cji(PhotoPreviewActivity paramPhotoPreviewActivity) {}
  
  public void a(AdapterView paramAdapterView) {}
  
  public void b(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.a.jdField_b_of_type_Int = paramInt;
    if (this.a.jdField_b_of_type_JavaUtilArrayList.contains(Integer.valueOf(this.a.jdField_b_of_type_Int))) {
      this.a.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
    }
    while (this.a.jdField_a_of_type_JavaUtilArrayList.size() > 1)
    {
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt + 1 + " / " + this.a.jdField_a_of_type_JavaUtilArrayList.size());
      return;
      this.a.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
    }
    this.a.jdField_a_of_type_AndroidWidgetTextView.setText(this.a.getResources().getString(2131363435));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cji
 * JD-Core Version:    0.7.0.1
 */