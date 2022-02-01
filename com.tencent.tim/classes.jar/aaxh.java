import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.selectmember.PhoneContactTabView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aaxh
  implements View.OnClickListener
{
  public aaxh(PhoneContactTabView paramPhoneContactTabView) {}
  
  public void onClick(View paramView)
  {
    PhoneContactTabView.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaxh
 * JD-Core Version:    0.7.0.1
 */