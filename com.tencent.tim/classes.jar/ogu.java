import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ogu
  implements View.OnClickListener
{
  ogu(ogt paramogt, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (ogt.a(this.a) != null) {
      ogt.a(this.a).a(paramView, 12, this.val$pos, ogt.a(this.a));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ogu
 * JD-Core Version:    0.7.0.1
 */