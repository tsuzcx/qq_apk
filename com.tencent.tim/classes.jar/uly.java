import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatActivityUtils.c;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Map;

public final class uly
  implements DialogInterface.OnClickListener
{
  public uly(atdc paramatdc, QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, String paramString4, boolean paramBoolean2, boolean paramBoolean3, ChatActivityUtils.c paramc, Map paramMap, int paramInt2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    boolean bool = ((aqju)paramDialogInterface).getCheckBoxState();
    if (bool) {
      this.b.Vm(true);
    }
    ChatActivityUtils.a(this.val$app, this.val$context, this.alR, this.Mu, this.val$name, this.aLS, this.Pd, this.Mz, this.aTE, this.aTA, this.a, this.hg, this.val$from, false);
    paramDialogInterface = this.val$app;
    if (bool) {}
    for (paramInt = 1;; paramInt = 2)
    {
      anot.a(paramDialogInterface, "CliOper", "", "", "0X8006402", "0X8006402", paramInt, 0, "", "", "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uly
 * JD-Core Version:    0.7.0.1
 */