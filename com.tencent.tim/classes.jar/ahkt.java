import android.app.Activity;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mobileqq.app.QQAppInterface;

class ahkt
  implements DialogInterface.OnClickListener
{
  ahkt(ahkr paramahkr) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.this$0.isSdkShare) {
      arts.a().a(this.this$0.app.getAccount(), "", String.valueOf(this.this$0.appid), "1000", "52", "0", false, true);
    }
    paramDialogInterface = new Intent();
    paramDialogInterface.setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=complete&response={\"ret\":0}", new Object[] { Long.valueOf(this.this$0.appid), "addToQQFavorites" })));
    paramDialogInterface.setPackage(this.this$0.mActivity.getIntent().getStringExtra("pkg_name"));
    paramDialogInterface = PendingIntent.getActivity(this.this$0.mActivity, 0, paramDialogInterface, 268435456);
    Intent localIntent = new Intent();
    localIntent.putExtra("is_share_flag", true);
    if (this.this$0.appid > 0L) {
      localIntent.putExtra("activity_finish_run_pendingIntent", paramDialogInterface);
    }
    avja.a(this.this$0.mActivity, this.this$0.app.getAccount(), localIntent, -1, true);
    avjg.b(this.this$0.app, 2, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahkt
 * JD-Core Version:    0.7.0.1
 */