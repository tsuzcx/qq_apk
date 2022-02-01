import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aiuw
  implements View.OnClickListener
{
  aiuw(aiut paramaiut, View.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    if (this.fp != null) {
      this.fp.onClick(paramView);
    }
    this.a.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiuw
 * JD-Core Version:    0.7.0.1
 */