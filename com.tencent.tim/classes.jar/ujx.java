import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatActivityUtils.c;
import com.tencent.mobileqq.activity.ChatActivityUtils.d;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public final class ujx
  implements DialogInterface.OnClickListener
{
  public ujx(long paramLong, QQAppInterface paramQQAppInterface, Context paramContext, ChatActivityUtils.c paramc, ChatActivityUtils.d paramd, BaseActivity paramBaseActivity, boolean paramBoolean) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      ChatActivityUtils.b(this.kQ, this.val$app, this.val$context, this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$c, this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$d);
      return;
    }
    ChatActivityUtils.a(this.e, this.Pd, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ujx
 * JD-Core Version:    0.7.0.1
 */