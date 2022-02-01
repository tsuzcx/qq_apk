import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class wcz
  implements View.OnClickListener
{
  public wcz(TroopRequestActivity paramTroopRequestActivity) {}
  
  public void onClick(View paramView)
  {
    String str = this.this$0.mPicUrl;
    apmj.O(this.this$0, str);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wcz
 * JD-Core Version:    0.7.0.1
 */