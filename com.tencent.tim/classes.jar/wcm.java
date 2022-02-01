import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity.c;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class wcm
  implements View.OnClickListener
{
  public wcm(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public void onClick(View paramView)
  {
    this.this$0.bbo = true;
    this.this$0.Bi.setVisibility(8);
    this.this$0.Bi = ((TextView)this.this$0.findViewById(2131369581));
    this.this$0.Bi.setVisibility(0);
    this.this$0.Bi.setText(acfp.m(2131715995));
    this.this$0.Bi.setOnClickListener(new wcn(this));
    TroopMemberListActivity.a(this.this$0);
    if (this.this$0.a != null) {
      this.this$0.a.bSJ();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wcm
 * JD-Core Version:    0.7.0.1
 */