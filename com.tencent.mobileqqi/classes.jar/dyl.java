import android.os.Handler;
import android.view.View;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.FileItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.filemanager.core.FileManagerRSCenter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class dyl
  implements ActionSheet.OnButtonClickListener
{
  public dyl(FileItemBuilder paramFileItemBuilder, MessageForFile paramMessageForFile, BaseChatItemLayout paramBaseChatItemLayout, dyo paramdyo, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (FileItemBuilder.e(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemFileItemBuilder).a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.uniseq, FileItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemFileItemBuilder).jdField_a_of_type_JavaLangString, FileItemBuilder.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemFileItemBuilder).jdField_a_of_type_Int, -1L) != -1) {
      FileItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemFileItemBuilder).post(new dym(this));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.cancel();
      return;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.status = 1002;
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemFileItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
      FileManagerUtil.a(FileItemBuilder.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemFileItemBuilder), paramView, FileItemBuilder.f(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemFileItemBuilder), true);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemFileItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile, this.jdField_a_of_type_Dyo, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.status, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     dyl
 * JD-Core Version:    0.7.0.1
 */