import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatActivityUtils.c;
import com.tencent.mobileqq.activity.ChatActivityUtils.d;
import com.tencent.mobileqq.app.QQAppInterface;

public final class ulp
  implements DialogInterface.OnClickListener
{
  public ulp(QQAppInterface paramQQAppInterface, ChatActivityUtils.d paramd, long paramLong, Context paramContext, ChatActivityUtils.c paramc) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ajqy localajqy = (ajqy)this.val$app.getBusinessHandler(66);
    if (localajqy != null) {
      localajqy.k((byte)0);
    }
    this.val$app.a().Mj(true);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$d.aTF) {
      anot.a(null, "CliOper", "", "", "Two_call", "Clk_shield_btn", 0, 0, "1", "", "", "");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$d.aTJ = false;
    ChatActivityUtils.b(this.kQ, this.val$app, this.val$context, this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$c, this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$d);
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ulp
 * JD-Core Version:    0.7.0.1
 */