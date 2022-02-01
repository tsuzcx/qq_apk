import android.os.Handler;
import android.os.Message;

public class ackf
  implements acci
{
  private Handler mHandler;
  
  public ackf(Handler paramHandler)
  {
    this.mHandler = paramHandler;
  }
  
  public void cLZ()
  {
    this.mHandler = null;
  }
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    int i = 1;
    if (this.mHandler == null) {}
    while ((paramInt != 1) && (paramInt != 4) && (paramInt != 5)) {
      return;
    }
    Handler localHandler = this.mHandler;
    if (paramBoolean) {}
    for (;;)
    {
      localHandler.obtainMessage(paramInt, i, 0, paramObject).sendToTarget();
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     ackf
 * JD-Core Version:    0.7.0.1
 */