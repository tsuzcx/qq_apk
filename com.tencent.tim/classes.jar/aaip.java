import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qrcode.activity.QRLoginMgrActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aaip
  implements View.OnClickListener
{
  aaip(aahb paramaahb) {}
  
  public void onClick(View paramView)
  {
    if ((this.this$0.bdc != null) && ("1600000104".equals(this.this$0.bdc.trim()))) {
      this.this$0.cus();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Intent localIntent = new Intent(aahb.a(this.this$0), QRLoginMgrActivity.class);
      localIntent.putExtra("qrlogin_position", this.this$0.bdb);
      localIntent.putExtra("qrlogin_appid", this.this$0.LT);
      aahb.a(this.this$0).startActivity(localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaip
 * JD-Core Version:    0.7.0.1
 */