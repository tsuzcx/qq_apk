import android.os.Handler;
import android.os.Message;

class mzb
  extends Handler
{
  mzb(mza parammza) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 100: 
    case 101: 
    case 102: 
      do
      {
        return;
        mza.c(this.this$0);
        return;
        this.this$0.aRm();
        return;
        mza.d(this.this$0);
        sendEmptyMessageDelayed(102, 1000L);
      } while (mza.a(this.this$0) != 1);
      mza.e(this.this$0);
      return;
    case 103: 
      mza.a(this.this$0, 3);
      return;
    case 104: 
      mza.f(this.this$0);
      return;
    }
    mza.g(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mzb
 * JD-Core Version:    0.7.0.1
 */