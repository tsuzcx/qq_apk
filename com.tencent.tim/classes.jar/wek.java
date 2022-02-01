import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopTransferActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class wek
  implements View.OnClickListener
{
  public wek(TroopTransferActivity paramTroopTransferActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.this$0.a != null) {
      this.this$0.a.dismiss();
    }
    this.this$0.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wek
 * JD-Core Version:    0.7.0.1
 */