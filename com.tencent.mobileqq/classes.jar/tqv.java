import android.os.CountDownTimer;
import android.widget.PopupWindow;

class tqv
  extends CountDownTimer
{
  tqv(tqt paramtqt, long paramLong1, long paramLong2)
  {
    super(paramLong1, paramLong2);
  }
  
  public void onFinish()
  {
    if (tqt.a(this.a) != null)
    {
      tqt.a(this.a).dismiss();
      tqt.a(this.a, null);
    }
  }
  
  public void onTick(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tqv
 * JD-Core Version:    0.7.0.1
 */