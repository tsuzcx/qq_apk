import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class lyf
  implements View.OnClickListener
{
  lyf(lxz paramlxz) {}
  
  public void onClick(View paramView)
  {
    ndi.d locald = this.a.d.a();
    if (locald != null) {
      locald.a(null, ((lie)this.a.aN).a(), 1);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lyf
 * JD-Core Version:    0.7.0.1
 */