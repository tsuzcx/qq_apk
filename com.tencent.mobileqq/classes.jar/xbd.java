import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.qwallet.goldmsg.GoldMsgAioState;
import com.tencent.mobileqq.activity.qwallet.goldmsg.GoldMsgChatHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.FormEditItem;

public class xbd
  implements DialogInterface.OnClickListener
{
  public xbd(GoldMsgAioState paramGoldMsgAioState, Context paramContext, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QQCustomDialog localQQCustomDialog = (QQCustomDialog)paramDialogInterface;
    FormEditItem localFormEditItem1 = (FormEditItem)localQQCustomDialog.findViewById(2131364059);
    FormEditItem localFormEditItem2 = (FormEditItem)localQQCustomDialog.findViewById(2131364061);
    if (GoldMsgChatHelper.a().a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, localFormEditItem1.a(), localFormEditItem2.a()))
    {
      GoldMsgAioState.a(localQQCustomDialog.getWindow(), this.jdField_a_of_type_AndroidContentContext, null);
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xbd
 * JD-Core Version:    0.7.0.1
 */