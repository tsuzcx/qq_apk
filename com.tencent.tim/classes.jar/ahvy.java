import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ahvy
  implements View.OnClickListener
{
  ahvy(ahvw paramahvw, ahvw.a parama) {}
  
  public void onClick(View paramView)
  {
    ahvw.a(this.this$0, this.a.mMessage);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahvy
 * JD-Core Version:    0.7.0.1
 */