import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.qwallet.redpacket.draw.ChooseItemView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aady
  implements View.OnClickListener
{
  public aady(ChooseItemView paramChooseItemView) {}
  
  public void onClick(View paramView)
  {
    this.this$0.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aady
 * JD-Core Version:    0.7.0.1
 */