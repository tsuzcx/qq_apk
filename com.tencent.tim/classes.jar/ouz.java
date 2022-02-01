import android.app.Activity;
import android.content.Context;
import android.os.CountDownTimer;
import android.widget.PopupWindow;

class ouz
  extends CountDownTimer
{
  ouz(ouy paramouy, long paramLong1, long paramLong2, Context paramContext)
  {
    super(paramLong1, paramLong2);
  }
  
  public void onFinish()
  {
    if ((ouy.a(this.this$0) != null) && ((this.val$context instanceof Activity)) && (!((Activity)this.val$context).isFinishing()))
    {
      ouy.a(this.this$0).dismiss();
      ouy.a(this.this$0, null);
    }
  }
  
  public void onTick(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ouz
 * JD-Core Version:    0.7.0.1
 */