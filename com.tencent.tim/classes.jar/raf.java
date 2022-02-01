import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class raf
  implements View.OnClickListener
{
  raf(rae paramrae) {}
  
  public void onClick(View paramView)
  {
    rae.a(this.b, false);
    this.b.notifyDataSetChanged();
    if (rae.a(this.b) != null) {
      rae.a(this.b).onMoreClick();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     raf
 * JD-Core Version:    0.7.0.1
 */