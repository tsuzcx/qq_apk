import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class atbc
  implements View.OnClickListener
{
  atbc(atbb paramatbb, atbe paramatbe) {}
  
  public void onClick(View paramView)
  {
    if (atbb.a(this.b) != null) {
      atbb.a(this.b).b(this.a);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atbc
 * JD-Core Version:    0.7.0.1
 */