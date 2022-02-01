import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class smh
  implements View.OnClickListener
{
  smh(slz paramslz, apbo.c paramc) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopTipsPopWindow", 2, "mTroopNotifyAdImage onClick--------");
    }
    Intent localIntent = new Intent(this.this$0.mContext, QQBrowserActivity.class);
    localIntent.putExtra("url", this.b.rl);
    this.this$0.mContext.startActivity(localIntent);
    anot.a(this.this$0.app, "P_CliOper", "Grp_bulletin", "", "bulletin_popUp", "clk_ad", 0, 0, this.this$0.troopUin, String.valueOf(this.this$0.a.mType), "8020205751015455", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     smh
 * JD-Core Version:    0.7.0.1
 */