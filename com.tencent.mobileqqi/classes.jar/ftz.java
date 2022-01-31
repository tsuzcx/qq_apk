import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import com.tencent.mobileqq.filemanager.activity.CloudFileBrowserActivity;
import com.tencent.mobileqq.filemanager.data.BaseFileAdapter;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.OfflineFileInfo;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.mobileqq.widget.SlideDetectListView.OnSlideListener;
import com.tencent.widget.BubblePopupWindow;

public class ftz
  implements SlideDetectListView.OnSlideListener
{
  public ftz(CloudFileBrowserActivity paramCloudFileBrowserActivity) {}
  
  public void a(SlideDetectListView paramSlideDetectListView, View paramView, int paramInt)
  {
    if (this.a.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null) {
      this.a.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b();
    }
    if (!this.a.f())
    {
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataBaseFileAdapter.a(null);
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.b();
      paramView.setPressed(false);
      return;
    }
    paramSlideDetectListView = paramView.findViewById(2131230987);
    if (this.a.jdField_a_of_type_Long == 9L)
    {
      CloudFileBrowserActivity.a(this.a, (OfflineFileInfo)this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataBaseFileAdapter.getItem(paramInt));
      CloudFileBrowserActivity.a(this.a, CloudFileBrowserActivity.a(this.a).a);
    }
    while (FMDataCache.a(CloudFileBrowserActivity.a(this.a)))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataBaseFileAdapter.a(null);
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.b();
      paramView.setPressed(false);
      return;
      CloudFileBrowserActivity.a(this.a, (WeiYunFileInfo)this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataBaseFileAdapter.getItem(paramInt));
      CloudFileBrowserActivity.a(this.a, CloudFileBrowserActivity.a(this.a).a);
    }
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataBaseFileAdapter.a(CloudFileBrowserActivity.a(this.a));
    if (paramSlideDetectListView != null)
    {
      ((Button)paramSlideDetectListView.findViewById(2131231699)).setOnClickListener(this.a.jdField_a_of_type_AndroidViewView$OnClickListener);
      ((ShaderAnimLayout)paramSlideDetectListView).a();
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setDeleteAreaDim(paramSlideDetectListView.getLayoutParams().width, paramSlideDetectListView.getLayoutParams().height);
    }
    CloudFileBrowserActivity.a(this.a, true);
  }
  
  public void b(SlideDetectListView paramSlideDetectListView, View paramView, int paramInt)
  {
    paramView.findViewById(2131230987);
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataBaseFileAdapter.a(null);
    CloudFileBrowserActivity.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     ftz
 * JD-Core Version:    0.7.0.1
 */