import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatActivityUtils.c;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Map;

public final class ulj
  implements DialogInterface.OnClickListener
{
  public ulj(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2, ChatActivityUtils.c paramc, Map paramMap) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    ChatActivityUtils.a(this.val$app, this.val$context, this.alR, this.val$uin, this.aTA, this.aTz, this.a, this.hf);
    anot.a(this.val$app, "CliOper", "", "", "0X80067FB", "0X80067FB", 2, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ulj
 * JD-Core Version:    0.7.0.1
 */