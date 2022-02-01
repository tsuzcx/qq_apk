import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.qwallet.SendHbActivity;
import com.tencent.mobileqq.activity.qwallet.redpacket.draw.DrawHbFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aaen
  implements View.OnClickListener
{
  public aaen(DrawHbFragment paramDrawHbFragment) {}
  
  public void onClick(View paramView)
  {
    DrawHbFragment.b(this.a).zY("draw.wrappacket.random");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaen
 * JD-Core Version:    0.7.0.1
 */