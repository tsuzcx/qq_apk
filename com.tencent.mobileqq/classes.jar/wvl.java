import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.photo.PhotoPreviewActivity;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemSelectedListener;
import java.util.ArrayList;

public class wvl
  implements AdapterView.OnItemSelectedListener
{
  public wvl(PhotoPreviewActivity paramPhotoPreviewActivity) {}
  
  public void a(AdapterView paramAdapterView) {}
  
  public void b(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.a.r = paramInt;
    if (this.a.c.contains(Integer.valueOf(this.a.r)))
    {
      int i = this.a.c.indexOf(Integer.valueOf(this.a.r));
      if (i != -1) {
        PhotoPreviewActivity.a(this.a, i + 1);
      }
    }
    for (;;)
    {
      this.a.e();
      if (!this.a.i) {
        break;
      }
      this.a.d.setText("文件预览");
      return;
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
      continue;
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
    }
    if (this.a.jdField_a_of_type_JavaUtilArrayList.size() > 1) {
      this.a.d.setText(paramInt + 1 + " / " + this.a.jdField_a_of_type_JavaUtilArrayList.size());
    }
    for (;;)
    {
      paramAdapterView = (String)paramAdapterView.getItemAtPosition(paramInt);
      if ((PhotoPreviewActivity.a(this.a, paramAdapterView) != 1) || (this.a.e)) {
        break;
      }
      this.a.d();
      return;
      this.a.d.setText(this.a.getResources().getString(2131434539));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wvl
 * JD-Core Version:    0.7.0.1
 */