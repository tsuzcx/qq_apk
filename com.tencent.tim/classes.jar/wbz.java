import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class wbz
  implements View.OnClickListener
{
  public wbz(TroopMemberListActivity paramTroopMemberListActivity, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    if ((this.val$dialog != null) && (this.val$dialog.isShowing())) {
      this.val$dialog.dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wbz
 * JD-Core Version:    0.7.0.1
 */