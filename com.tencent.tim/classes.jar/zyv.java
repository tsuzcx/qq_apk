import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.qwallet.RedPacketKSongFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class zyv
  implements View.OnClickListener
{
  public zyv(RedPacketKSongFragment paramRedPacketKSongFragment) {}
  
  public void onClick(View paramView)
  {
    this.this$0.csD();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zyv
 * JD-Core Version:    0.7.0.1
 */