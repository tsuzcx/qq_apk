import android.widget.Scroller;
import com.tencent.mobileqq.activity.aio.item.ClickedWaveView;

public class vah
  implements Runnable
{
  public vah(ClickedWaveView paramClickedWaveView) {}
  
  public void run()
  {
    if ((this.a.a.computeScrollOffset()) || (this.a.d > 0))
    {
      this.a.c = this.a.a.getCurrX();
      if (this.a.d > 0)
      {
        ClickedWaveView localClickedWaveView = this.a;
        localClickedWaveView.d -= 3;
      }
      if (this.a.d < 0) {
        this.a.d = 0;
      }
      this.a.postInvalidate();
      this.a.postDelayed(this, 20L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vah
 * JD-Core Version:    0.7.0.1
 */