import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatActivityUtils.c;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;

public final class ulq
  implements DialogInterface.OnClickListener
{
  public ulq(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, ChatActivityUtils.c paramc, ArrayList paramArrayList, int paramInt2, int paramInt3, boolean paramBoolean4) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    ChatActivityUtils.b(this.val$app, this.val$context, this.alR, this.val$uin, this.aTA, this.aTz, this.aTB, this.a, this.oS, this.bFc, this.val$from, this.aTD, false);
    anot.a(this.val$app, "CliOper", "", "", "0X80067FB", "0X80067FB", 2, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ulq
 * JD-Core Version:    0.7.0.1
 */