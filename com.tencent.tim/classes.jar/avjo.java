import android.os.Handler;
import android.os.Message;

public class avjo
  implements acci
{
  private Handler mHandler;
  
  public avjo(Handler paramHandler)
  {
    this.mHandler = paramHandler;
  }
  
  public void cLZ()
  {
    this.mHandler = null;
  }
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (this.mHandler == null) {
      return;
    }
    switch (paramInt)
    {
    default: 
      return;
    }
    Handler localHandler = this.mHandler;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localHandler.obtainMessage(paramInt, i, 0, paramObject).sendToTarget();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avjo
 * JD-Core Version:    0.7.0.1
 */