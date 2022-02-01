import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.pubaccount.util.ProfileParams;
import com.tencent.mobileqq.app.QQAppInterface;

final class ocs
  implements DialogInterface.OnClickListener
{
  ocs(Activity paramActivity, ProfileParams paramProfileParams, QQAppInterface paramQQAppInterface) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
        ahkr.a(this.val$activity, false, "shareToQzone", Long.valueOf(this.c.la()).longValue());
      } while ((this.val$activity == null) || (this.val$activity.isFinishing()));
      this.val$activity.setResult(0);
      this.val$activity.finish();
      return;
    } while (ocp.j == null);
    ocp.j.dismiss();
    ocp.j = null;
    this.val$activity.finish();
    ocp.d(this.val$activity, this.val$app, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ocs
 * JD-Core Version:    0.7.0.1
 */