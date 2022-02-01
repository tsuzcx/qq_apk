import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class atbd
  implements View.OnClickListener
{
  atbd(atbb paramatbb, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (atbb.a(this.b) != null) {
      atbb.a(this.b).b((atbe)atbb.a(this.b).get(this.val$position));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atbd
 * JD-Core Version:    0.7.0.1
 */