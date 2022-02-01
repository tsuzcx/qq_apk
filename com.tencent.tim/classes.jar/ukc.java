import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatActivityUtils.c;
import com.tencent.mobileqq.activity.ChatActivityUtils.d;
import com.tencent.mobileqq.app.QQAppInterface;

public final class ukc
  implements DialogInterface.OnClickListener
{
  public ukc(ChatActivityUtils.d paramd, long paramLong, QQAppInterface paramQQAppInterface, Context paramContext, ChatActivityUtils.c paramc) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$d.aTI = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$d.aTJ = false;
    ChatActivityUtils.b(this.kQ, this.val$app, this.val$context, this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$c, this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$d);
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ukc
 * JD-Core Version:    0.7.0.1
 */