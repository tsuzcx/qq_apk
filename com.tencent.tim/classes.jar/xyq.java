import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.RecentUser;

class xyq
  implements DialogInterface.OnClickListener
{
  xyq(xyp paramxyp, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ((acdu)this.a.this$0.app.getManager(53)).jV(this.val$uin);
    paramDialogInterface = this.a.this$0.app.a().a();
    RecentUser localRecentUser = paramDialogInterface.b(this.val$uin, 3000);
    if (localRecentUser != null) {
      paramDialogInterface.f(localRecentUser);
    }
    this.a.this$0.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xyq
 * JD-Core Version:    0.7.0.1
 */