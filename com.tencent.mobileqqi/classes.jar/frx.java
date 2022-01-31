import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.LocalFileAdapter;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.mobileqq.widget.SlideDetectListView.OnSlideListener;
import com.tencent.widget.BubblePopupWindow;

public class frx
  implements SlideDetectListView.OnSlideListener
{
  public frx(LocalFileBrowserActivity paramLocalFileBrowserActivity) {}
  
  public void a(SlideDetectListView paramSlideDetectListView, View paramView, int paramInt)
  {
    if (this.a.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null) {
      this.a.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b();
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
      paramSlideDetectListView = paramView.findViewById(2131230987);
      paramView = (FileInfo)this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataLocalFileAdapter.getItem(paramInt);
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataLocalFileAdapter.a(paramView);
    } while (paramSlideDetectListView == null);
    paramView = (Button)paramSlideDetectListView.findViewById(2131231701);
    paramView.setTag(Integer.valueOf(paramInt));
    paramView.setOnClickListener(this.a.jdField_a_of_type_AndroidViewView$OnClickListener);
    ((ShaderAnimLayout)paramSlideDetectListView).a();
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setDeleteAreaDim(paramSlideDetectListView.getLayoutParams().width, paramSlideDetectListView.getLayoutParams().height);
  }
  
  public void b(SlideDetectListView paramSlideDetectListView, View paramView, int paramInt)
  {
    paramSlideDetectListView = paramView.findViewById(2131230987);
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataLocalFileAdapter.a(null);
    if (paramSlideDetectListView != null)
    {
      ((ShaderAnimLayout)paramSlideDetectListView).d();
      paramSlideDetectListView = (Button)paramSlideDetectListView.findViewById(2131231701);
      paramSlideDetectListView.setTag(null);
      paramSlideDetectListView.setOnClickListener(null);
    }
    LocalFileBrowserActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     frx
 * JD-Core Version:    0.7.0.1
 */