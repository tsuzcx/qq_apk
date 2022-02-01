import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;

class ajqj
  implements DialogInterface.OnClickListener
{
  ajqj(ajqh paramajqh, Activity paramActivity, QQAppInterface paramQQAppInterface, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.b.a;
    if ((paramDialogInterface != null) && (!TextUtils.isEmpty(paramDialogInterface.bSj)))
    {
      Intent localIntent = new Intent(this.val$activity, QQBrowserActivity.class);
      localIntent.putExtra("url", paramDialogInterface.bSj);
      this.val$activity.startActivity(localIntent);
    }
    ajqh.j(this.val$app, "clk_up", this.val$from);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajqj
 * JD-Core Version:    0.7.0.1
 */