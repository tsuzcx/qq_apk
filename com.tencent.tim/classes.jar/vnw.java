import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQIdentiferActivity;
import com.tencent.qphone.base.util.QLog;

public class vnw
  extends BroadcastReceiver
{
  public vnw(QQIdentiferActivity paramQQIdentiferActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (("tencent.av.v2q.StartVideoChat".equals(paramContext)) || ("tencent.av.v2q.AvSwitch".equals(paramContext)))
    {
      i = paramIntent.getIntExtra("sessionType", 0);
      QLog.d("qq_Identification.act", 1, "received video chat broadcast: " + i);
      if ((i == 2) || (i == 4))
      {
        QQIdentiferActivity.a(this.this$0, 204, aijf.bOd);
        QQIdentiferActivity.a(this.this$0, 204, aijf.bOd);
        this.this$0.finish();
      }
    }
    while (!"mqq.intent.action.ACCOUNT_KICKED".equals(paramContext))
    {
      int i;
      return;
    }
    this.this$0.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vnw
 * JD-Core Version:    0.7.0.1
 */