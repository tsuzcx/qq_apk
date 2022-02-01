import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class awup
  implements View.OnClickListener
{
  awup(awuo paramawuo) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a != null) {
      this.a.a.eGx();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awup
 * JD-Core Version:    0.7.0.1
 */