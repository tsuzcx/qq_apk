import android.os.CountDownTimer;
import android.widget.PopupWindow;

class uza
  extends CountDownTimer
{
  uza(uyy paramuyy, long paramLong1, long paramLong2)
  {
    super(paramLong1, paramLong2);
  }
  
  public void onFinish()
  {
    if (uyy.a(this.a) != null)
    {
      uyy.a(this.a).dismiss();
      uyy.a(this.a, null);
    }
  }
  
  public void onTick(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uza
 * JD-Core Version:    0.7.0.1
 */