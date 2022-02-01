import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatActivityUtils.c;
import com.tencent.mobileqq.activity.ChatActivityUtils.d;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Map;

public final class uke
  implements DialogInterface.OnClickListener
{
  public uke(ChatActivityUtils.d paramd, long paramLong, QQAppInterface paramQQAppInterface, Context paramContext, ChatActivityUtils.c paramc) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    int i = jll.cL(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$d.uinType);
    String str;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$d.hh != null) && (i == 1))
    {
      str = (String)this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$d.hh.get("MultiAVType");
      if (str == null) {}
    }
    for (paramInt = Integer.valueOf(str).intValue();; paramInt = 0)
    {
      ChatActivityUtils.b(this.kQ, this.val$app, this.val$context, i, paramInt);
      this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$d.aTI = false;
      this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$d.aTJ = false;
      ChatActivityUtils.b(this.kQ, this.val$app, this.val$context, this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$c, this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$d);
      if (paramDialogInterface != null) {
        paramDialogInterface.dismiss();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uke
 * JD-Core Version:    0.7.0.1
 */