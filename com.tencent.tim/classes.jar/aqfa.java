import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.concurrent.atomic.AtomicBoolean;

final class aqfa
  implements View.OnClickListener
{
  aqfa(AtomicBoolean paramAtomicBoolean, akoy paramakoy) {}
  
  public void onClick(View paramView)
  {
    this.ef.set(true);
    this.c.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqfa
 * JD-Core Version:    0.7.0.1
 */