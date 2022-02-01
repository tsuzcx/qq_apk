import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;

public class aopp
  extends aopm
  implements Handler.Callback
{
  private long aqs;
  private Runnable mRunnable;
  private Handler mSubHandler;
  
  public aopp(QQAppInterface paramQQAppInterface, String paramString, Runnable paramRunnable, long paramLong)
  {
    super(paramQQAppInterface, paramString);
    this.mRunnable = paramRunnable;
    this.aqs = paramLong;
    this.mSubHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 0) {
      this.ctrl.a(this);
    }
    return true;
  }
  
  protected void realCancel()
  {
    this.mSubHandler.removeCallbacks(this.mRunnable);
  }
  
  protected void realStart()
  {
    this.mSubHandler.post(this.mRunnable);
    this.mSubHandler.sendEmptyMessageDelayed(0, this.aqs);
  }
  
  public String toString()
  {
    return super.toString() + "[" + this.mRunnable + ", " + this.aqs + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aopp
 * JD-Core Version:    0.7.0.1
 */