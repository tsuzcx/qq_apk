import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.aio.PlusPanel;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.widget.QQToast;

public class yej
  extends Handler
{
  public yej(TroopChatPie paramTroopChatPie, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 3: 
    default: 
    case 1: 
    case 2: 
    case 4: 
      do
      {
        do
        {
          return;
          this.this$0.a(null, false);
          return;
          paramMessage = paramMessage.obj;
        } while (!(paramMessage instanceof apsw.e));
        this.this$0.a((apsw.e)paramMessage);
        return;
        paramMessage = (PlusPanel)TroopChatPie.f(this.this$0).B(8);
      } while (paramMessage == null);
      paramMessage.reload();
      return;
    }
    String str = (String)paramMessage.obj;
    int i = paramMessage.arg1;
    QQToast.a(this.this$0.mActivity, str, i).show(this.this$0.mActivity.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yej
 * JD-Core Version:    0.7.0.1
 */