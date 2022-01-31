import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.open.agent.AuthorityActivity;
import com.tencent.open.agent.QuickLoginAuthorityActivity;
import com.tencent.open.agent.util.AuthorityUtil;

public class fbp
  extends Handler
{
  public fbp(QuickLoginAuthorityActivity paramQuickLoginAuthorityActivity, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
          paramMessage = (Bitmap)paramMessage.obj;
        } while (paramMessage == null);
        paramMessage = AuthorityUtil.a(this.a, paramMessage, 50, 50);
        localMessage = Message.obtain();
        localMessage.what = 1002;
        localMessage.obj = paramMessage;
        this.a.b.sendMessage(localMessage);
        return;
        paramMessage = (String)paramMessage.obj;
      } while (TextUtils.isEmpty(paramMessage));
      paramMessage = AuthorityActivity.a(paramMessage);
    } while (paramMessage == null);
    Message localMessage = Message.obtain();
    localMessage.what = 1003;
    localMessage.obj = paramMessage;
    this.a.b.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     fbp
 * JD-Core Version:    0.7.0.1
 */