import android.app.Dialog;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ContactSyncJumpActivity;

public class urv
  extends Handler
{
  public urv(ContactSyncJumpActivity paramContactSyncJumpActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1000)
    {
      if (this.a.isScreenLocked()) {
        break label149;
      }
      i = paramMessage.arg1 - 1;
      if (i != 0) {
        break label39;
      }
      ContactSyncJumpActivity.a(this.a);
    }
    label39:
    while ((this.a.H == null) || (this.a.bGa != 2))
    {
      int i;
      return;
      if ((this.a.H != null) && (this.a.bGa == 2))
      {
        paramMessage = "(" + i + ")";
        ((TextView)this.a.H.findViewById(2131365895)).setText(String.format(this.a.getResources().getString(2131700863), new Object[] { paramMessage }));
      }
      paramMessage = obtainMessage(1000);
      paramMessage.arg1 = i;
      sendMessageDelayed(paramMessage, 1000L);
      return;
    }
    label149:
    ((TextView)this.a.H.findViewById(2131365895)).setText(String.format(this.a.getResources().getString(2131700863), new Object[] { "" }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     urv
 * JD-Core Version:    0.7.0.1
 */