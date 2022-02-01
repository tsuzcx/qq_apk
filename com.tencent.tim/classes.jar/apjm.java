import android.os.CountDownTimer;
import com.tencent.mobileqq.troop.homework.recite.ui.ReciteRecordLayout;

public class apjm
  extends CountDownTimer
{
  public apjm(ReciteRecordLayout paramReciteRecordLayout, long paramLong1, long paramLong2)
  {
    super(paramLong1, paramLong2);
  }
  
  public void onFinish()
  {
    ReciteRecordLayout.a(this.this$0);
  }
  
  public void onTick(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apjm
 * JD-Core Version:    0.7.0.1
 */