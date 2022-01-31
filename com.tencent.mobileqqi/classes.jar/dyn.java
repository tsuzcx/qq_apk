import android.view.View;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.item.FileItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class dyn
  implements ActionSheet.OnButtonClickListener
{
  public dyn(FileItemBuilder paramFileItemBuilder, MessageForFile paramMessageForFile, BaseChatItemLayout paramBaseChatItemLayout, dyo paramdyo, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    paramView = FileItemBuilder.g(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemFileItemBuilder).a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.uniseq, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.istroop);
    if (paramView != null) {
      FileManagerUtil.a(FileItemBuilder.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemFileItemBuilder), paramView, FileItemBuilder.h(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemFileItemBuilder), false);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemFileItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile, this.jdField_a_of_type_Dyo, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.status, false);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     dyn
 * JD-Core Version:    0.7.0.1
 */