import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Map;

public final class ukw
  implements DialogInterface.OnClickListener
{
  public ukw(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean, Map paramMap) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ChatActivityUtils.b(-1034L, this.val$app, this.val$context, this.aMY, this.bEZ);
    ChatActivityUtils.a(this.val$app, this.val$context, this.alR, this.val$uin, this.aTA, false, this.he);
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ukw
 * JD-Core Version:    0.7.0.1
 */