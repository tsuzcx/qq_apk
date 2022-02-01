import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class lmt
  implements View.OnClickListener
{
  lmt(lmp paramlmp, ndi paramndi, lie paramlie) {}
  
  public void onClick(View paramView)
  {
    ndi.d locald = this.c.a();
    if (locald != null) {
      locald.a(paramView, this.b.a(), 2);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lmt
 * JD-Core Version:    0.7.0.1
 */