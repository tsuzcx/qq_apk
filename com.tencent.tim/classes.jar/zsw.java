import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;

final class zsw
  implements DialogInterface.OnClickListener
{
  zsw(Activity paramActivity, String paramString1, String paramString2, QQAppInterface paramQQAppInterface) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      zsq.b(this.val$activity, true, this.abn, this.val$appid, false);
      this.val$activity.finish();
      anot.a(this.val$app, "dc00898", "", "", "0X8009DFC", "0X8009DFC", 0, 0, this.val$appid, "", "", "");
      return;
    }
    anot.a(this.val$app, "dc00898", "", "", "0X8009DFD", "0X8009DFD", 0, 0, this.val$appid, "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zsw
 * JD-Core Version:    0.7.0.1
 */