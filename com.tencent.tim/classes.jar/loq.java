import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class loq
  implements View.OnClickListener
{
  loq(lom paramlom, lie paramlie, ndi paramndi) {}
  
  public void onClick(View paramView)
  {
    this.b.a();
    ndi.d locald = this.c.a();
    if (locald != null) {
      locald.a(paramView, this.b.a(), 2);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     loq
 * JD-Core Version:    0.7.0.1
 */