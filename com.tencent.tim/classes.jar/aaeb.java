import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.qwallet.redpacket.draw.ChooseItemView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aaeb
  implements View.OnClickListener
{
  public aaeb(ChooseItemView paramChooseItemView, View.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    this.this$0.dismiss();
    this.cM.onClick(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaeb
 * JD-Core Version:    0.7.0.1
 */