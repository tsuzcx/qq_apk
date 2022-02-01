import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.common.util.Util;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ForwardOperations;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.qphone.base.util.QLog;

public class bxb
  implements DialogInterface.OnClickListener
{
  public bxb(ChatActivity paramChatActivity, AbsShareMsg paramAbsShareMsg, Context paramContext) {}
  
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
        Util.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.b, "", "choose", this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceAppid, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID, "back");
        ForwardOperations.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity, true, "shareToQQ", this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceAppid);
      }
      Util.a(this.jdField_a_of_type_AndroidContentContext, 0, "", "");
      this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.finish();
      return;
    } while (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg == null);
    Util.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.b, "", "choose", this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceAppid, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID, "stay");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     bxb
 * JD-Core Version:    0.7.0.1
 */