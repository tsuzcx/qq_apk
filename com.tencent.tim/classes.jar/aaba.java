import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.qwallet.fragment.SendHbMainFragment;
import com.tencent.mobileqq.widget.TipsBar;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aaba
  implements View.OnClickListener
{
  public aaba(SendHbMainFragment paramSendHbMainFragment, TipsBar paramTipsBar, SharedPreferences paramSharedPreferences, int paramInt) {}
  
  public void onClick(View paramView)
  {
    this.e.setVisibility(8);
    this.val$sp.edit().putInt("red_packet_bulletin", this.cfU).apply();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaba
 * JD-Core Version:    0.7.0.1
 */