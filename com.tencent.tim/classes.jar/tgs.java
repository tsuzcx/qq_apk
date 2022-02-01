import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class tgs
  implements View.OnClickListener
{
  tgs(tgq paramtgq) {}
  
  public void onClick(View paramView)
  {
    this.this$0.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tgs
 * JD-Core Version:    0.7.0.1
 */