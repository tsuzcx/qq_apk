import android.os.Handler;
import android.os.Message;

public class ackh
  implements acci
{
  private Handler mHandler;
  
  public ackh(Handler paramHandler)
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
    while ((paramInt != 1) && (paramInt != 0)) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     ackh
 * JD-Core Version:    0.7.0.1
 */