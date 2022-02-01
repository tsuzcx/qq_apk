import android.os.Handler;
import android.os.Message;
import com.tencent.widget.CountDownProgressBar;
import com.tencent.widget.CountDownProgressBar.a;

public class autd
  extends Handler
{
  public autd(CountDownProgressBar paramCountDownProgressBar) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      CountDownProgressBar.a(this.b, CountDownProgressBar.a(this.b) + CountDownProgressBar.a(this.b));
      CountDownProgressBar.a(this.b).sendEmptyMessageDelayed(1, CountDownProgressBar.a(this.b));
      return;
      CountDownProgressBar.a(this.b, CountDownProgressBar.a(this.b) + CountDownProgressBar.a(this.b));
      if (CountDownProgressBar.a(this.b) <= (float)CountDownProgressBar.a(this.b)) {
        break;
      }
      CountDownProgressBar.a(this.b, (int)(CountDownProgressBar.a(this.b) / (float)CountDownProgressBar.a(this.b) * 360.0F));
      this.b.invalidate();
    } while (CountDownProgressBar.a(this.b) == null);
    CountDownProgressBar.a(this.b).cYs();
    return;
    CountDownProgressBar.a(this.b, (int)(CountDownProgressBar.a(this.b) / (float)CountDownProgressBar.a(this.b) * 360.0F));
    if (CountDownProgressBar.b(this.b) >= (float)CountDownProgressBar.b(this.b))
    {
      CountDownProgressBar.b(this.b, 0.0F);
      CountDownProgressBar.b(this.b, CountDownProgressBar.b(this.b) - 1);
    }
    for (;;)
    {
      this.b.invalidate();
      CountDownProgressBar.a(this.b).sendEmptyMessageDelayed(1, CountDownProgressBar.a(this.b));
      return;
      CountDownProgressBar.b(this.b, CountDownProgressBar.b(this.b) + CountDownProgressBar.a(this.b));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     autd
 * JD-Core Version:    0.7.0.1
 */