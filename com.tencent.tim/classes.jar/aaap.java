import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.mobileqq.activity.qwallet.fragment.LingHbFragment;
import com.tencent.mobileqq.activity.qwallet.redpacket.draw.ChooseItemView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aaap
  implements View.OnClickListener
{
  public aaap(LingHbFragment paramLingHbFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.aW.clearFocus();
    LingHbFragment.a(this.a).dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaap
 * JD-Core Version:    0.7.0.1
 */