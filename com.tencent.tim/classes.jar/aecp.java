import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aecp
  implements View.OnClickListener
{
  aecp(aecn paramaecn) {}
  
  public void onClick(View paramView)
  {
    aecj.a(this.a.a).setVisibility(8);
    aecj.a(this.a.a, null);
    if (aecj.a(this.a.a).getItemCount() == 0) {
      aecj.a(this.a.a);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aecp
 * JD-Core Version:    0.7.0.1
 */