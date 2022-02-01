import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.qwallet.RedPacketVoiceFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class zzg
  implements View.OnClickListener
{
  public zzg(RedPacketVoiceFragment paramRedPacketVoiceFragment) {}
  
  public void onClick(View paramView)
  {
    if ((!this.this$0.isFinish()) && (RedPacketVoiceFragment.a(this.this$0) != null) && (paramView != null))
    {
      Intent localIntent = new Intent(paramView.getContext(), PayBridgeActivity.class);
      localIntent.putExtras(RedPacketVoiceFragment.a(this.this$0));
      localIntent.putExtra("pay_requestcode", 5);
      paramView.getContext().startActivity(localIntent);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zzg
 * JD-Core Version:    0.7.0.1
 */