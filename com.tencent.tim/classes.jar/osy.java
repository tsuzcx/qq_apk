import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class osy
  implements View.OnClickListener
{
  osy(osx paramosx) {}
  
  public void onClick(View paramView)
  {
    if (this.b.isShowing()) {
      this.b.dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     osy
 * JD-Core Version:    0.7.0.1
 */