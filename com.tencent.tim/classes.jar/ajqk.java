import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;

class ajqk
  implements DialogInterface.OnClickListener
{
  ajqk(ajqh paramajqh, Activity paramActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.b.a;
    if ((paramDialogInterface != null) && (!TextUtils.isEmpty(paramDialogInterface.bSi)))
    {
      Intent localIntent = new Intent(this.val$activity, QQBrowserActivity.class);
      localIntent.putExtra("url", paramDialogInterface.bSi);
      this.val$activity.startActivityForResult(localIntent, 1028);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajqk
 * JD-Core Version:    0.7.0.1
 */