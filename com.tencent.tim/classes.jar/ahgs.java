import android.app.Activity;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class ahgs
  implements DialogInterface.OnClickListener
{
  ahgs(ahgq paramahgq) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    default: 
    case -2: 
      do
      {
        return;
        if (this.this$0.isSdkShare) {
          arts.a().a(this.this$0.app.getAccount(), "", String.valueOf(this.this$0.appid), "1000", "51", "0", false, this.this$0.isSdkShare);
        }
        this.this$0.Kp(true);
        this.this$0.mActivity.setResult(1);
        this.this$0.mActivity.finish();
      } while (!QLog.isColorLevel());
      QLog.i("ForwardOption.ForwardBaseOption", 2, "-->showQfavResultDialog--onClick--back call");
      return;
    }
    if (this.this$0.isSdkShare) {
      arts.a().a(this.this$0.app.getAccount(), "", String.valueOf(this.this$0.appid), "1000", "52", "0", false, this.this$0.isSdkShare);
    }
    if (QLog.isColorLevel()) {
      QLog.i("ForwardOption.ForwardBaseOption", 2, "-->showQfavResultDialog--onClick--send call");
    }
    paramDialogInterface = new Intent();
    paramDialogInterface.setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=complete&response={\"ret\":0}", new Object[] { Long.valueOf(this.this$0.appid), "shareToQQ" })));
    paramDialogInterface.setPackage(this.this$0.mActivity.getIntent().getStringExtra("pkg_name"));
    paramDialogInterface = PendingIntent.getActivity(this.this$0.mActivity, 0, paramDialogInterface, 268435456);
    Intent localIntent = new Intent();
    localIntent.putExtra("is_share_flag", true);
    if (this.this$0.appid > 0L) {
      localIntent.putExtra("activity_finish_run_pendingIntent", paramDialogInterface);
    }
    avja.a(this.this$0.mActivity, this.this$0.app.getAccount(), localIntent, -1, true);
    avjg.b(this.this$0.app, 5, 0);
    this.this$0.mActivity.setResult(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     ahgs
 * JD-Core Version:    0.7.0.1
 */