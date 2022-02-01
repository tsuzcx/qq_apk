import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import tencent.mobileim.structmsg.structmsg.StructMsg;

public class wdg
  implements View.OnClickListener
{
  public wdg(TroopRequestActivity paramTroopRequestActivity) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.this$0, AccountDetailActivity.class);
    localIntent.putExtra("uin", this.this$0.a.req_uin.get() + "");
    localIntent.putExtra("source", 112);
    this.this$0.startActivity(localIntent);
    anot.a(this.this$0.app, "P_CliOper", "Grp_public", "", "oper", "Clk_invite", 0, 0, "", "", "", this.this$0.a.req_uin.get() + "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wdg
 * JD-Core Version:    0.7.0.1
 */