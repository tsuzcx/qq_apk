import android.graphics.Paint;
import com.tencent.mobileqq.widget.UnderlinePageIndicator;

public class fby
  implements Runnable
{
  public fby(UnderlinePageIndicator paramUnderlinePageIndicator) {}
  
  public void run()
  {
    if (!this.a.a) {}
    int i;
    do
    {
      return;
      i = Math.max(UnderlinePageIndicator.a(this.a).getAlpha() - UnderlinePageIndicator.a(this.a), 0);
      UnderlinePageIndicator.a(this.a).setAlpha(i);
      this.a.invalidate();
    } while (i <= 0);
    this.a.postDelayed(this, 30L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     fby
 * JD-Core Version:    0.7.0.1
 */