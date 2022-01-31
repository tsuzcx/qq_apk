import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.FMRecentFileActivity;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.RecentFileAdapter;
import com.tencent.mobileqq.filemanager.widget.ViewerMoreRelativeLayout;
import com.tencent.mobileqq.widget.SlideDetectListView;

public class frd
  implements View.OnClickListener
{
  public frd(FMRecentFileActivity paramFMRecentFileActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.b();
    }
    if ((((Button)paramView.findViewById(2131231701)).getTag() != null) && (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataRecentFileAdapter != null)) {
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataRecentFileAdapter.a(null);
    }
    if (this.a.b.a().b(this.a.jdField_a_of_type_Long)) {
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout.setVisible();
    }
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataRecentFileAdapter.a(Integer.valueOf(-1));
    FMRecentFileActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     frd
 * JD-Core Version:    0.7.0.1
 */