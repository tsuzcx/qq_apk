import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQProgressNotifier;

public class eyu
  extends Handler
{
  public eyu(QQProgressNotifier paramQQProgressNotifier, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      this.a.a(paramMessage.arg1, (String)paramMessage.obj, paramMessage.arg2);
    }
    do
    {
      do
      {
        return;
      } while (paramMessage.what != 2);
      this.a.a();
    } while ((paramMessage.arg1 != 3) && (paramMessage.arg1 != 4) && (paramMessage.arg1 != 6) && (paramMessage.arg1 != 5));
    if ((paramMessage.arg1 == 6) || (paramMessage.arg1 == 5))
    {
      paramMessage = new Intent();
      paramMessage.putExtra("isNeedFinish", true);
      this.a.a.setResult(-1, paramMessage);
    }
    for (;;)
    {
      this.a.a.finish();
      return;
      this.a.a.setResult(-1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     eyu
 * JD-Core Version:    0.7.0.1
 */