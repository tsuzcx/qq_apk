import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ohs
  implements View.OnClickListener
{
  ohs(ohl.b paramb) {}
  
  public void onClick(View paramView)
  {
    ohl.a(this.b.this$0).dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ohs
 * JD-Core Version:    0.7.0.1
 */