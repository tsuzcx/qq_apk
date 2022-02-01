import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qrcode.activity.QRLoginMgrActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aahs
  implements View.OnClickListener
{
  aahs(aahb paramaahb) {}
  
  public void onClick(View paramView)
  {
    if ((this.this$0.bdc != null) && ("1600000104".equals(this.this$0.bdc.trim())))
    {
      if (this.this$0.LU == 77313L) {
        this.this$0.bvD = true;
      }
      this.this$0.cuj();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Intent localIntent = new Intent(aahb.a(this.this$0), QRLoginMgrActivity.class);
      localIntent.putExtra("loginInfo", this.this$0.bdb);
      localIntent.putExtra("appType", this.this$0.cgI);
      localIntent.putExtra("subappid", this.this$0.LT);
      localIntent.putExtra("clientType", this.this$0.LU);
      aahb.a(this.this$0).startActivity(localIntent);
      anot.c(aahb.a(this.this$0).app, "dc00898", "", "", "0X8009EE2", "0X8009EE2", 10, 0, "", "", "", "");
      if (this.this$0.LU == 77313L) {
        anot.a(aahb.a(this.this$0).app, "dc00898", "", "", "0X8008880", "0X8008880", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aahs
 * JD-Core Version:    0.7.0.1
 */