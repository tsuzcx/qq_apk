import android.os.Handler;
import android.view.View;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.FileItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.filemanager.core.FileManagerRSCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class uwl
  implements ActionSheet.OnButtonClickListener
{
  public uwl(FileItemBuilder paramFileItemBuilder, MessageForFile paramMessageForFile, ActionSheet paramActionSheet, BaseChatItemLayout paramBaseChatItemLayout, uwr paramuwr) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemFileItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.uniseq, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemFileItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemFileItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, -1L) != -1) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemFileItemBuilder.b.post(new uwm(this));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.cancel();
      return;
      paramView = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemFileItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
      if (paramView.status == 16)
      {
        FMToastUtil.a(2131428188);
        this.jdField_a_of_type_ComTencentWidgetActionSheet.cancel();
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.status = 1002;
      paramInt = paramView.peerType;
      paramView.peerType = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemFileItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
      if ((paramView.nOpType != 21) && (paramView.nOpType != 22) && (paramView.nOpType != 27) && (paramView.nOpType != 20)) {
        paramView.selfUin = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemFileItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      }
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemFileItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView.selfUin, paramView.peerUin, paramView);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioItemFileItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1004) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemFileItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1000)) {
        paramView.tmpSessionRelatedUin = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemFileItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b;
      }
      paramView.peerType = paramInt;
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemFileItemBuilder.jdField_a_of_type_AndroidContentContext, paramView, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemFileItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemFileItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile, this.jdField_a_of_type_Uwr, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.status);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uwl
 * JD-Core Version:    0.7.0.1
 */