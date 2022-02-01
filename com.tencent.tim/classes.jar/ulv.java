import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatActivityUtils.c;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Map;

public final class ulv
  implements DialogInterface.OnClickListener
{
  public ulv(Map paramMap, QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, String paramString, boolean paramBoolean1, boolean paramBoolean2, ChatActivityUtils.c paramc, int paramInt2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.hf.put("PstnLevel", "LEVEL2");
    this.hf.put("ipPstnEnterType", String.valueOf(0));
    ChatActivityUtils.a(this.val$app, this.val$context, this.alR, this.val$uin, this.aTA, this.aTz, this.a, this.hf);
    paramDialogInterface = this.val$app;
    if (this.val$from == 6) {}
    for (paramInt = 1;; paramInt = 4)
    {
      anot.a(paramDialogInterface, "CliOper", "", "", "0X80063FA", "0X80063FA", paramInt, 0, "", "", "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ulv
 * JD-Core Version:    0.7.0.1
 */