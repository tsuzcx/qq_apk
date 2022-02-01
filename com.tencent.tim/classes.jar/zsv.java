import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class zsv
  implements DialogInterface.OnClickListener
{
  zsv(Activity paramActivity, String paramString1, String paramString2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 0)
    {
      zsq.b(this.val$activity, false, this.abn, this.val$appid, false);
      this.val$activity.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zsv
 * JD-Core Version:    0.7.0.1
 */