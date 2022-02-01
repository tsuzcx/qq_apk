import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.redpacket.ui.RedPacketGameView;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ite
  implements View.OnClickListener
{
  public ite(RedPacketGameView paramRedPacketGameView, long paramLong) {}
  
  public void onClick(View paramView)
  {
    AVActivity localAVActivity = this.this$0.getAVActivity();
    if (localAVActivity != null)
    {
      localAVActivity.mControlUI.da(this.kQ);
      ((VideoAppInterface)localAVActivity.getAppRuntime()).l(new Object[] { Integer.valueOf(105), Boolean.valueOf(true), Long.valueOf(this.kQ) });
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ite
 * JD-Core Version:    0.7.0.1
 */