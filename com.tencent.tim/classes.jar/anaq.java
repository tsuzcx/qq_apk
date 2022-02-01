import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.NewIntent;

class anaq
  extends Handler
{
  anaq(anan paramanan, Looper paramLooper, Context paramContext, String paramString1, int paramInt, AppInterface paramAppInterface, String paramString2, String paramString3)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    default: 
      return;
    case 0: 
      this.a.mIsCanceled = true;
      if (this.a.i != null)
      {
        this.a.i.setObserver(null);
        this.a.i = null;
      }
      if (QLog.isColorLevel()) {
        QLog.d(getClass().getSimpleName(), 2, "lauchApp time out");
      }
      paramMessage = anan.f(this.a.ccI);
      arxn.a(this.val$context, this.val$packageName, paramMessage, this.val$flags);
      anan.cEB = false;
      return;
    }
    this.a.mIsCanceled = true;
    if (this.a.i != null)
    {
      this.a.i.setObserver(null);
      this.a.i = null;
    }
    anan.a(this.a, this.b, this.val$context, this.val$appid, this.val$params, this.val$packageName, "", this.val$flags);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anaq
 * JD-Core Version:    0.7.0.1
 */