import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.qwallet.RedPacketKSongFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class zys
  implements View.OnClickListener
{
  public zys(RedPacketKSongFragment paramRedPacketKSongFragment) {}
  
  public void onClick(View paramView)
  {
    this.this$0.yZ.setVisibility(8);
    this.this$0.Ap.setVisibility(8);
    RedPacketKSongFragment.a(this.this$0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zys
 * JD-Core Version:    0.7.0.1
 */