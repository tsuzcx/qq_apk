import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.trooppiceffects.TroopPicEffectsEditActivity;

class apyy
  implements DialogInterface.OnClickListener
{
  apyy(apyx paramapyx) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = String.format("https://qun.qq.com/qunpay/gifts/buy.html?_bid=2204&_wvSb=1&from=7&troopUin=%s", new Object[] { this.a.this$0.cqt });
    Intent localIntent = new Intent(this.a.this$0, QQBrowserActivity.class);
    localIntent.putExtra("selfSet_leftViewText", acfp.m(2131716051));
    localIntent.putExtra("hide_more_button", true);
    localIntent.putExtra("hide_operation_bar", true);
    localIntent.putExtra("url", this.a.this$0.gI(paramDialogInterface));
    this.a.this$0.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apyy
 * JD-Core Version:    0.7.0.1
 */