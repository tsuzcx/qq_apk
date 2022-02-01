import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.open.agent.AuthorityAccountView;
import com.tencent.open.agent.AuthorityActivity;
import com.tencent.open.agent.CardContainer;
import com.tencent.open.agent.QuickLoginAuthorityActivity;
import com.tencent.qphone.base.util.QLog;

public class arsp
  extends Handler
{
  public arsp(QuickLoginAuthorityActivity paramQuickLoginAuthorityActivity, Looper paramLooper)
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
          do
          {
            return;
            paramMessage = (Bitmap)paramMessage.obj;
          } while (paramMessage == null);
          paramMessage = artw.a(this.this$0, paramMessage, 50, 50);
          localMessage = Message.obtain();
          localMessage.what = 1002;
          localMessage.obj = paramMessage;
          this.this$0.mHandler.sendMessage(localMessage);
          return;
          paramMessage = (String)paramMessage.obj;
        } while (TextUtils.isEmpty(paramMessage));
        paramMessage = AuthorityActivity.P(paramMessage);
      } while (paramMessage == null);
      Message localMessage = Message.obtain();
      localMessage.what = 1003;
      localMessage.obj = paramMessage;
      this.this$0.mHandler.sendMessage(localMessage);
      return;
      QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "--> handler message GET_ACCOUNT_LIST");
    } while (this.this$0.a.a == null);
    this.this$0.a.a.ekK();
    paramMessage = Message.obtain();
    paramMessage.what = 1006;
    this.this$0.mHandler.sendMessage(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arsp
 * JD-Core Version:    0.7.0.1
 */