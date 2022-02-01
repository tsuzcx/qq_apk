import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.tencent.mobileqq.profile.VipProfileCardBaseActivity;

public class aldk
  extends Handler
{
  public aldk(VipProfileCardBaseActivity paramVipProfileCardBaseActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (!this.this$0.p(paramMessage)) {}
    switch (paramMessage.what)
    {
    case 5: 
    case 8: 
    default: 
      return;
    case 6: 
      if ((paramMessage.obj != null) && ((paramMessage.obj instanceof String)))
      {
        Toast.makeText(this.this$0.mContext.getApplicationContext(), (String)paramMessage.obj, 0).show();
        return;
      }
      Toast.makeText(this.this$0.mContext.getApplicationContext(), 2131697314, 0).show();
      return;
    case 7: 
      Toast.makeText(this.this$0.mContext.getApplicationContext(), 2131697264, 0).show();
      return;
    }
    this.this$0.bOQ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aldk
 * JD-Core Version:    0.7.0.1
 */