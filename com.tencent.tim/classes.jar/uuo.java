import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;

class uuo
  implements DialogInterface.OnClickListener
{
  uuo(uum paramuum, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    DiscussionInfoCardActivity.a(this.a.this$0).jV(this.aMJ);
    paramDialogInterface = this.a.this$0.app.a().a();
    paramDialogInterface.f(paramDialogInterface.a(this.aMJ, 3000));
    paramDialogInterface = new Intent();
    paramDialogInterface.putExtra("isNeedFinish", true);
    this.a.this$0.setResult(-1, paramDialogInterface);
    this.a.this$0.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uuo
 * JD-Core Version:    0.7.0.1
 */