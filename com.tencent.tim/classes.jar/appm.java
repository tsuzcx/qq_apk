import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.troopCard.VisitorTroopCardFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class appm
  implements View.OnClickListener
{
  public appm(VisitorTroopCardFragment paramVisitorTroopCardFragment, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    if ((this.val$dialog.isShowing()) && (this.val$dialog.getWindow() != null)) {
      this.val$dialog.dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     appm
 * JD-Core Version:    0.7.0.1
 */