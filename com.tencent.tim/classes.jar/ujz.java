import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatActivityUtils.c;
import com.tencent.mobileqq.activity.ChatActivityUtils.d;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public final class ujz
  implements DialogInterface.OnClickListener
{
  public ujz(ChatActivityUtils.d paramd, int paramInt, long paramLong, QQAppInterface paramQQAppInterface, Context paramContext, ChatActivityUtils.c paramc) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    long l = System.currentTimeMillis();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$d.aTF)
    {
      if (this.val$netType != 2) {
        break label130;
      }
      anot.a(null, "CliOper", "", "", "Two_call", "Clk_2G_tips_btn", 0, 0, "1", "", "", "");
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$d.aTG = false;
      this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$d.aTH = false;
      this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$d.aTJ = false;
      ChatActivityUtils.b(this.kQ, this.val$app, this.val$context, this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$c, this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$d);
      if (QLog.isColorLevel()) {
        QLog.d("chenlong", 2, "" + (System.currentTimeMillis() - l));
      }
      return;
      label130:
      if ((this.val$netType == 3) || (this.val$netType == 4)) {
        anot.a(null, "CliOper", "", "", "Two_call", "Clk_3G_tips_btn", 0, 0, "1", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ujz
 * JD-Core Version:    0.7.0.1
 */