import android.os.CountDownTimer;
import android.widget.PopupWindow;

class uxr
  extends CountDownTimer
{
  uxr(uxp paramuxp, long paramLong1, long paramLong2)
  {
    super(paramLong1, paramLong2);
  }
  
  public void onFinish()
  {
    if (uxp.a(this.a) != null)
    {
      uxp.a(this.a).dismiss();
      uxp.a(this.a, null);
    }
  }
  
  public void onTick(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uxr
 * JD-Core Version:    0.7.0.1
 */