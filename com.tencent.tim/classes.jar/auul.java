import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.NegativeChildrenLayout;

public class auul
  implements View.OnClickListener
{
  public auul(NegativeChildrenLayout paramNegativeChildrenLayout) {}
  
  public void onClick(View paramView)
  {
    if (this.b.c != null) {
      this.b.c.iW(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auul
 * JD-Core Version:    0.7.0.1
 */