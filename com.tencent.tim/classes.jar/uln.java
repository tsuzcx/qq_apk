import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatActivityUtils.c;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;

public final class uln
  implements DialogInterface.OnClickListener
{
  public uln(atdc paramatdc, QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, ChatActivityUtils.c paramc, ArrayList paramArrayList, int paramInt2, int paramInt3, boolean paramBoolean4) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    boolean bool = ((aqju)paramDialogInterface).getCheckBoxState();
    if (bool) {
      this.jdField_a_of_type_Atdc.Vn(true);
    }
    ChatActivityUtils.b(this.val$app, this.val$context, this.alR, this.val$uin, this.aTA, this.aTz, this.aTB, this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$c, this.oS, this.bFc, this.val$from, false, this.aTC);
    paramDialogInterface.dismiss();
    paramDialogInterface = this.val$app;
    if (bool) {}
    for (paramInt = 1;; paramInt = 2)
    {
      anot.a(paramDialogInterface, "CliOper", "", "", "0X8006404", "0X8006404", paramInt, 0, "", "", "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uln
 * JD-Core Version:    0.7.0.1
 */