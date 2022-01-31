import android.view.View;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.item.FilePicItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class utv
  implements ActionSheet.OnButtonClickListener
{
  public utv(FilePicItemBuilder paramFilePicItemBuilder, MessageForFile paramMessageForFile, ActionSheet paramActionSheet, BaseChatItemLayout paramBaseChatItemLayout, utz paramutz) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemFilePicItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.uniseq, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.istroop);
    if (paramView != null)
    {
      if (paramView.status == 16)
      {
        FMToastUtil.a(2131428188);
        this.jdField_a_of_type_ComTencentWidgetActionSheet.cancel();
        return;
      }
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemFilePicItemBuilder.jdField_a_of_type_AndroidContentContext, paramView, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemFilePicItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemFilePicItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile, this.jdField_a_of_type_Utz, paramView, false);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     utv
 * JD-Core Version:    0.7.0.1
 */