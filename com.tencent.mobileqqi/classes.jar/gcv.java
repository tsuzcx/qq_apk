import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import cooperation.qlink.QQProxyForQlink;

public final class gcv
  implements ActionSheet.OnButtonClickListener
{
  public gcv(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     gcv
 * JD-Core Version:    0.7.0.1
 */