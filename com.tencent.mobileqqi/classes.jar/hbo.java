import android.text.TextUtils.TruncateAt;
import android.widget.Button;

public final class hbo
  implements Runnable
{
  public hbo(Button paramButton) {}
  
  public void run()
  {
    this.a.setEllipsize(TextUtils.TruncateAt.MARQUEE);
    this.a.setMarqueeRepeatLimit(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hbo
 * JD-Core Version:    0.7.0.1
 */