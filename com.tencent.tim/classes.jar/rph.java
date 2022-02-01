import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class rph
  implements View.OnClickListener
{
  rph(rpg.i parami) {}
  
  public void onClick(View paramView)
  {
    rpg.e locale = this.a.b;
    if (locale != null) {
      locale.a(this.a.a, this.a);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rph
 * JD-Core Version:    0.7.0.1
 */