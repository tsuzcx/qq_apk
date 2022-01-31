import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.RecentFileAdapter;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.mobileqq.widget.SlideDetectListView.OnSlideListener;
import com.tencent.widget.BubblePopupWindow;

public class fqi
  implements SlideDetectListView.OnSlideListener
{
  public fqi(FMActivity paramFMActivity) {}
  
  public void a(SlideDetectListView paramSlideDetectListView, View paramView, int paramInt)
  {
    if (this.a.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null) {
      this.a.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b();
    }
    if (!this.a.f())
    {
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataRecentFileAdapter.a(Integer.valueOf(-1));
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.b();
      paramView.setPressed(false);
      return;
    }
    paramSlideDetectListView = paramView.findViewById(2131230987);
    paramView = (FileManagerEntity)this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataRecentFileAdapter.getItem(paramInt);
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataRecentFileAdapter.a(paramView);
    this.a.jdField_a_of_type_Long = paramView.nSessionId;
    if (paramSlideDetectListView != null)
    {
      ((Button)paramSlideDetectListView.findViewById(2131231701)).setOnClickListener(this.a.jdField_a_of_type_AndroidViewView$OnClickListener);
      ((ShaderAnimLayout)paramSlideDetectListView).a();
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setDeleteAreaDim(paramSlideDetectListView.getLayoutParams().width, paramSlideDetectListView.getLayoutParams().height);
    }
    FMActivity.a(this.a);
  }
  
  public void b(SlideDetectListView paramSlideDetectListView, View paramView, int paramInt)
  {
    paramView.findViewById(2131230987);
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataRecentFileAdapter.a(null);
    FMActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     fqi
 * JD-Core Version:    0.7.0.1
 */