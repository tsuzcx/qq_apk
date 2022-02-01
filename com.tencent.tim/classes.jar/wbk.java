import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class wbk
  implements View.OnClickListener
{
  public wbk(TroopMemberListActivity paramTroopMemberListActivity, int paramInt1, int paramInt2) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.this$0, TroopMemberListActivity.class);
    localIntent.putExtra("troop_uin", this.this$0.mTroopUin);
    localIntent.putExtra("param_from", 15);
    localIntent.putExtra("param_seq_days", TroopMemberListActivity.b(this.this$0));
    localIntent.putExtra("param_seq_name", TroopMemberListActivity.c(this.this$0));
    localIntent.putExtra("TROOP_INFO_MEMBER_NUM", this.BM);
    this.this$0.startActivityForResult(localIntent, 4);
    anot.a(this.this$0.app, "dc00899", "Grp_mber", "", "mber_list", "clk_inacentry", 0, 0, this.this$0.mTroopUin, "" + this.bLS, "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wbk
 * JD-Core Version:    0.7.0.1
 */