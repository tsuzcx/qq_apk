import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.nearby.interestTag.InterestTagItemView;
import com.tencent.mobileqq.nearby.interestTag.InterestTagItemView.a;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ajux
  implements View.OnClickListener
{
  public ajux(InterestTagItemView paramInterestTagItemView) {}
  
  public void onClick(View paramView)
  {
    if ((paramView == InterestTagItemView.a(this.a)) || (paramView == this.a))
    {
      InterestTagItemView.a(this.a).d(InterestTagItemView.a(this.a));
      this.a.dzw();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajux
 * JD-Core Version:    0.7.0.1
 */