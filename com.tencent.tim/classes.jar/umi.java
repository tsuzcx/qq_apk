import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatActivityUtils.c;
import com.tencent.mobileqq.activity.ChatActivityUtils.d;
import com.tencent.mobileqq.app.QQAppInterface;

public final class umi
  implements DialogInterface.OnClickListener
{
  public umi(QQAppInterface paramQQAppInterface, ChatActivityUtils.d paramd, long paramLong, Context paramContext, ChatActivityUtils.c paramc) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ChatActivityUtils.a(this.val$app, null, this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$d.uinType, this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$d.peerUin, this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$d.phoneNum, true);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$d.aTF) {
      anot.a(null, "CliOper", "", "", "Two_call", "Clk_shield_btn", 0, 0, "1", "", "", "");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$d.aTG = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$d.aTH = true;
    this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$d.aTJ = false;
    ChatActivityUtils.b(this.kQ, this.val$app, this.val$context, this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$c, this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$d);
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     umi
 * JD-Core Version:    0.7.0.1
 */