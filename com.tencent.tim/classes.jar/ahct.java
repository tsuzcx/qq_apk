import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public abstract class ahct
  implements View.OnClickListener
{
  private long iu;
  
  public abstract void fk(View paramView);
  
  public void gN(View paramView) {}
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (l - this.iu >= 500L)
    {
      fk(paramView);
      this.iu = l;
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      gN(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahct
 * JD-Core Version:    0.7.0.1
 */