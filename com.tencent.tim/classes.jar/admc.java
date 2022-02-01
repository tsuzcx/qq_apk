import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.ar.view.QRScanEntryView;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class admc
  implements View.OnClickListener
{
  public admc(QRScanEntryView paramQRScanEntryView) {}
  
  public void onClick(View paramView)
  {
    this.this$0.findViewById(2131369822).setAlpha(1.0F);
    ScanTorchActivity localScanTorchActivity = (ScanTorchActivity)this.this$0.mContext;
    String str2 = this.this$0.mAppInterface.getCurrentAccountUin();
    if (!TextUtils.isEmpty(localScanTorchActivity.azS)) {}
    for (String str1 = localScanTorchActivity.azS;; str1 = str2)
    {
      Intent localIntent = new Intent(localScanTorchActivity, QRDisplayActivity.class);
      localIntent.putExtra("from", "ScannerActivity");
      localIntent.putExtra("title", localScanTorchActivity.getString(2131717228));
      localIntent.putExtra("nick", str1);
      localIntent.putExtra("uin", str2);
      localIntent.putExtra("type", 1);
      localScanTorchActivity.startActivity(localIntent);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     admc
 * JD-Core Version:    0.7.0.1
 */