import android.os.CountDownTimer;
import android.widget.PopupWindow;

class ova
  extends CountDownTimer
{
  ova(ouy paramouy, long paramLong1, long paramLong2)
  {
    super(paramLong1, paramLong2);
  }
  
  public void onFinish()
  {
    if (ouy.a(this.this$0) != null)
    {
      ouy.a(this.this$0).dismiss();
      ouy.a(this.this$0, null);
    }
  }
  
  public void onTick(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ova
 * JD-Core Version:    0.7.0.1
 */