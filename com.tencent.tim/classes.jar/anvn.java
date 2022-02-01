import com.tencent.mobileqq.structmsg.widget.CountdownTextView;
import com.tencent.mobileqq.structmsg.widget.CountdownTextView.a;

public class anvn
  extends zxc.a
{
  public anvn(CountdownTextView paramCountdownTextView, long paramLong, CountdownTextView.a parama)
  {
    super(paramLong);
  }
  
  public void onFinish()
  {
    if (this.a != null) {
      this.a.onFinish();
    }
    this.b.stopTimer();
  }
  
  public void onTick(long paramLong)
  {
    if (this.a != null) {
      this.a.onTick(paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anvn
 * JD-Core Version:    0.7.0.1
 */