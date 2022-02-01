import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity.c;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class wbc
  implements View.OnClickListener
{
  public wbc(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public void onClick(View paramView)
  {
    this.this$0.bbn = false;
    this.this$0.aQZ = "";
    this.this$0.Gk.setVisibility(8);
    this.this$0.ru.setVisibility(0);
    if (this.this$0.mFrom != 22) {
      this.this$0.rv.setVisibility(0);
    }
    if (this.this$0.a != null) {
      this.this$0.a.bSJ();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wbc
 * JD-Core Version:    0.7.0.1
 */