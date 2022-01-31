import com.tencent.mobileqq.activity.bless.CountDownView;
import com.tencent.mobileqq.activity.bless.CountDownView.CountDownFinishedListener;

public class wlg
  implements Runnable
{
  public wlg(CountDownView paramCountDownView) {}
  
  public void run()
  {
    if ((CountDownView.a(this.a)) && (CountDownView.a(this.a) >= CountDownView.a().length))
    {
      this.a.a();
      if (CountDownView.a(this.a) != null) {
        CountDownView.a(this.a).a();
      }
    }
    while (CountDownView.a(this.a) >= CountDownView.a().length) {
      return;
    }
    CountDownView.a(this.a);
    this.a.setImageResource(CountDownView.a()[CountDownView.a(this.a)]);
    this.a.postDelayed(CountDownView.a(this.a), 1000L);
    CountDownView.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wlg
 * JD-Core Version:    0.7.0.1
 */