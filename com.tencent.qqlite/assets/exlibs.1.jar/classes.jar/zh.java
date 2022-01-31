import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.common.util.Util;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ForwardOperations;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.qphone.base.util.QLog;

public class zh
  implements DialogInterface.OnClickListener
{
  public zh(BaseChatPie paramBaseChatPie, AbsShareMsg paramAbsShareMsg, Context paramContext) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("ChatActivity", 2, "qbShowShareResultDialog back");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg != null)
      {
        Util.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "", "choose", this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceAppid, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID, "back");
        ForwardOperations.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, true, "shareToQQ", this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceAppid);
      }
      Util.a(this.jdField_a_of_type_AndroidContentContext, 0, "", "");
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.t();
      return;
    } while (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg == null);
    Util.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "", "choose", this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceAppid, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID, "stay");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     zh
 * JD-Core Version:    0.7.0.1
 */