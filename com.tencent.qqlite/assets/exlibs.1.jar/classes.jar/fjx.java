import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import cooperation.qqfav.QfavUtil;
import mqq.app.AppRuntime;

class fjx
  extends Handler
{
  fjx(fjw paramfjw, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    QfavUtil.a(this.a.a.a, 2131362663, 2);
    paramMessage = BaseApplicationImpl.a.a();
    QfavUtil.a(this.a.a.a, paramMessage.getAccount(), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     fjx
 * JD-Core Version:    0.7.0.1
 */