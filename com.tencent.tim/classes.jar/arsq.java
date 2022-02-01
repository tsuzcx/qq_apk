import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.open.agent.AuthorityAccountView;
import com.tencent.open.agent.CardContainer;
import com.tencent.open.agent.QuickLoginAuthorityActivity;

public class arsq
  extends Handler
{
  public arsq(QuickLoginAuthorityActivity paramQuickLoginAuthorityActivity, Looper paramLooper)
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
          this.this$0.a.a("", "", paramMessage, true);
          return;
          paramMessage = (Bitmap)paramMessage.obj;
        } while (paramMessage == null);
        this.this$0.a.F("", paramMessage);
        return;
        paramMessage = (String)paramMessage.obj;
      } while (TextUtils.isEmpty(paramMessage));
      this.this$0.a.setAppType(paramMessage);
      return;
    } while (this.this$0.a.a == null);
    this.this$0.a.a.ekL();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arsq
 * JD-Core Version:    0.7.0.1
 */