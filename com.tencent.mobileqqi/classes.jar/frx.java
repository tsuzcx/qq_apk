import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity;
import com.tencent.mobileqq.filemanager.data.LocalFileAdapter;
import com.tencent.mobileqq.widget.SlideDetectListView;

public class frx
  implements View.OnClickListener
{
  public frx(LocalFileBrowserActivity paramLocalFileBrowserActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.b();
    }
    paramView = (Button)paramView.findViewById(2131231700);
    if (paramView.getTag() != null)
    {
      this.a.jdField_a_of_type_Int = ((Integer)paramView.getTag()).intValue();
      if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataLocalFileAdapter != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataLocalFileAdapter.a(null);
      }
    }
    this.a.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     frx
 * JD-Core Version:    0.7.0.1
 */