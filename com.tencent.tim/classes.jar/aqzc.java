import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aqzc
  implements View.OnClickListener
{
  aqzc(aqzb paramaqzb) {}
  
  public void onClick(View paramView)
  {
    this.a.mInActivity.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqzc
 * JD-Core Version:    0.7.0.1
 */