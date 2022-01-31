import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.LocalFileAdapter;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.mobileqq.widget.SlideDetectListView.OnSlideListener;
import com.tencent.widget.MenuPopupDialog;

public class dgw
  implements SlideDetectListView.OnSlideListener
{
  public dgw(LocalFileBrowserActivity paramLocalFileBrowserActivity) {}
  
  public void a(SlideDetectListView paramSlideDetectListView, View paramView, int paramInt)
  {
    if (LocalFileBrowserActivity.a(this.a) != null) {
      LocalFileBrowserActivity.a(this.a).dismiss();
    }
    if (!this.a.f())
    {
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataLocalFileAdapter.a(null);
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.b();
      paramView.setPressed(false);
    }
    do
    {
      return;
      paramSlideDetectListView = paramView.findViewById(2131296441);
      paramView = (FileInfo)this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataLocalFileAdapter.getItem(paramInt);
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataLocalFileAdapter.a(paramView);
    } while (paramSlideDetectListView == null);
    paramView = (Button)paramSlideDetectListView.findViewById(2131297127);
    paramView.setTag(Integer.valueOf(paramInt));
    paramView.setOnClickListener(this.a.jdField_a_of_type_AndroidViewView$OnClickListener);
    ((ShaderAnimLayout)paramSlideDetectListView).a();
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setDeleteAreaDim(paramSlideDetectListView.getLayoutParams().width, paramSlideDetectListView.getLayoutParams().height);
  }
  
  public void b(SlideDetectListView paramSlideDetectListView, View paramView, int paramInt)
  {
    paramSlideDetectListView = paramView.findViewById(2131296441);
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataLocalFileAdapter.a(null);
    if (paramSlideDetectListView != null)
    {
      ((ShaderAnimLayout)paramSlideDetectListView).d();
      paramSlideDetectListView = (Button)paramSlideDetectListView.findViewById(2131297127);
      paramSlideDetectListView.setTag(null);
      paramSlideDetectListView.setOnClickListener(null);
    }
    LocalFileBrowserActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dgw
 * JD-Core Version:    0.7.0.1
 */