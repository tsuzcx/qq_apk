import android.view.View;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.RecentFileAdapter.ItemHolder;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class fqa
  implements ActionSheet.OnButtonClickListener
{
  fqa(fpz paramfpz, RecentFileAdapter.ItemHolder paramItemHolder, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    FileManagerUtil.a(this.jdField_a_of_type_Fpz.a, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataRecentFileAdapter$ItemHolder.a, this.jdField_a_of_type_Fpz.a.b, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataRecentFileAdapter$ItemHolder.a.bSend);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     fqa
 * JD-Core Version:    0.7.0.1
 */