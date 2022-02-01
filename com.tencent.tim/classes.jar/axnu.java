import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class axnu
  implements View.OnClickListener
{
  axnu(axnr paramaxnr) {}
  
  public void onClick(View paramView)
  {
    axnr.b(this.this$0);
    this.this$0.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axnu
 * JD-Core Version:    0.7.0.1
 */