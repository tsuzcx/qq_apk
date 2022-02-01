import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatActivityUtils.c;
import com.tencent.mobileqq.app.QQAppInterface;

public final class uko
  implements DialogInterface.OnClickListener
{
  public uko(long paramLong, Context paramContext, QQAppInterface paramQQAppInterface, int paramInt, String paramString, boolean paramBoolean1, ChatActivityUtils.c paramc, Bundle paramBundle, boolean paramBoolean2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    boolean bool = false;
    paramDialogInterface = ChatActivityUtils.a(this.kQ, this.val$context);
    if (paramInt == 1)
    {
      ChatActivityUtils.a(this.val$app, paramDialogInterface, this.alR, this.val$uin, false, this.aTz, this.a, this.Z);
      return;
    }
    if (!this.Mi) {
      bool = true;
    }
    ChatActivityUtils.a(paramDialogInterface, bool, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uko
 * JD-Core Version:    0.7.0.1
 */