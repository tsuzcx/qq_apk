package cooperation.qwallet.plugin.pay;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;

class PayLogic$2
  implements DialogInterface.OnClickListener
{
  PayLogic$2(PayLogic paramPayLogic, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      if ((!TextUtils.isEmpty(this.val$url)) && (BaseActivity.sTopActivity != null))
      {
        Intent localIntent = new Intent(BaseActivity.sTopActivity, QQBrowserActivity.class);
        localIntent.putExtra("url", this.val$url);
        localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
        PayLogic.access$000(this.this$0).startActivity(localIntent);
      }
      paramDialogInterface.dismiss();
      this.this$0.end();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qwallet.plugin.pay.PayLogic.2
 * JD-Core Version:    0.7.0.1
 */