import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class pbq
  implements View.OnClickListener
{
  pbq(pbp parampbp) {}
  
  public void onClick(View paramView)
  {
    pbp.a(this.b, false);
    this.b.dismiss();
    if (pbp.a(this.b) != null) {
      pbp.a(this.b).bjo();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pbq
 * JD-Core Version:    0.7.0.1
 */