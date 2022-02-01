import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.AccountDetail.activity.EqqAccountDetailActivity;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class jtd
  implements View.OnClickListener
{
  public jtd(EqqAccountDetailActivity paramEqqAccountDetailActivity, jzs.a parama, String paramString) {}
  
  public void onClick(View paramView)
  {
    if ((TextUtils.isEmpty(this.a.lat)) || (TextUtils.isEmpty(this.a.lng))) {
      if (QLog.isColorLevel()) {
        QLog.d(this.this$0.TAG, 2, "buildMapItemForEqq no lat or lng");
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Intent localIntent = new Intent(this.this$0, QQMapActivity.class);
      localIntent.putExtra("lat", this.a.lat);
      localIntent.putExtra("lon", this.a.lng);
      if (!TextUtils.isEmpty(this.val$address)) {
        localIntent.putExtra("loc", this.val$address);
      }
      this.this$0.startActivity(localIntent);
      anot.a(EqqAccountDetailActivity.h(this.this$0), "CliOper", "", "", "Biz_card", "Biz_card_map", 0, 0, EqqAccountDetailActivity.h(this.this$0), "", "", "");
      EqqAccountDetailActivity.c(this.this$0, this.a.title);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jtd
 * JD-Core Version:    0.7.0.1
 */