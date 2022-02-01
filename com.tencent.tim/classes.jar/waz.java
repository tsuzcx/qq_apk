import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class waz
  implements View.OnClickListener
{
  public waz(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public void onClick(View paramView)
  {
    if ((this.this$0.mFrom == 15) && (TroopMemberListActivity.a(this.this$0).size() > 0))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("param_deleted_uins", TroopMemberListActivity.a(this.this$0));
      this.this$0.setResult(-1, localIntent);
      if ((this.this$0.aPW == null) || (!this.this$0.aPW.equals(this.this$0.app.getCurrentAccountUin()))) {
        break label166;
      }
    }
    label166:
    for (int i = 0;; i = 1)
    {
      anot.a(this.this$0.app, "dc00899", "Grp_mber", "", "mber_list", "del_inacmem", 0, 0, this.this$0.mTroopUin, "" + i, "1", TroopMemberListActivity.a(this.this$0).toString());
      this.this$0.finish();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     waz
 * JD-Core Version:    0.7.0.1
 */