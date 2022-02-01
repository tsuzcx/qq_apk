import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class qfn
  extends Handler
{
  qfn(qfm paramqfm, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (this.this$0.aDd) {
      return;
    }
    qfm.a(this.this$0, this.this$0.mCurrentTime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qfn
 * JD-Core Version:    0.7.0.1
 */