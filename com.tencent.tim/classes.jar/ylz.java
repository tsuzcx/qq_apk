import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.bless.BlessSelectMemberActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ylz
  implements View.OnClickListener
{
  public ylz(BlessSelectMemberActivity paramBlessSelectMemberActivity) {}
  
  public void onClick(View paramView)
  {
    if (BlessSelectMemberActivity.b() != null) {
      BlessSelectMemberActivity.b().sendEmptyMessage(1);
    }
    if (this.this$0.v.isShowing()) {
      this.this$0.v.dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ylz
 * JD-Core Version:    0.7.0.1
 */