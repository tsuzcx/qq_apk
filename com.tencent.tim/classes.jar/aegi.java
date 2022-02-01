import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.conditionsearch.widget.TimeSelectView;
import com.tencent.mobileqq.conditionsearch.widget.TimeSelectView.c;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aegi
  implements View.OnClickListener
{
  public aegi(TimeSelectView paramTimeSelectView) {}
  
  public void onClick(View paramView)
  {
    if (TimeSelectView.a(this.b) != null) {
      TimeSelectView.a(this.b).dn();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aegi
 * JD-Core Version:    0.7.0.1
 */