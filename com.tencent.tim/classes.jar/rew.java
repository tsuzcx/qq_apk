import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class rew
  implements View.OnClickListener
{
  public rew.a a;
  protected long iu;
  protected View oV;
  
  public rew(rew.a parama, View paramView)
  {
    this.a = parama;
    this.oV = paramView;
    paramView.setOnClickListener(this);
  }
  
  private boolean isFastDoubleClick()
  {
    long l1 = System.currentTimeMillis();
    long l2 = l1 - this.iu;
    if ((l2 > 0L) && (l2 < 2000L)) {
      return true;
    }
    this.iu = l1;
    return false;
  }
  
  public void onClick(View paramView)
  {
    if (!isFastDoubleClick())
    {
      rar.a("home_page", "clk_shoot", 0, 0, new String[0]);
      this.a.bpP();
    }
    aoob.dWj();
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public static abstract interface a
  {
    public abstract void bpP();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rew
 * JD-Core Version:    0.7.0.1
 */