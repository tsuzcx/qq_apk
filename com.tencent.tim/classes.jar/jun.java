import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class jun
  implements View.OnClickListener
{
  jun(juk paramjuk) {}
  
  public void onClick(View paramView)
  {
    this.b.on(this.b.state);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jun
 * JD-Core Version:    0.7.0.1
 */