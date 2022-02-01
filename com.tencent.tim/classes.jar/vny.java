import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.QQIdentiferLegacy;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.qphone.base.util.QLog;

public class vny
  extends BroadcastReceiver
{
  public vny(QQIdentiferLegacy paramQQIdentiferLegacy) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (("tencent.av.v2q.StartVideoChat".equals(paramContext)) || ("tencent.av.v2q.AvSwitch".equals(paramContext)))
    {
      i = paramIntent.getIntExtra("sessionType", 0);
      QLog.d("QQIdentiferLegacy", 1, "received video chat broadcast: " + i);
      if ((i == 2) || (i == 4))
      {
        paramContext = new Intent();
        paramIntent = new Bundle();
        paramIntent.putInt("ret", 204);
        paramIntent.putString("errMsg", aijf.bOd);
        paramContext.putExtra("data", paramIntent);
        QQIdentiferLegacy.a(this.this$0).setResult(2, paramContext);
        QQIdentiferLegacy.a(this.this$0).finish();
      }
    }
    while (!"mqq.intent.action.ACCOUNT_KICKED".equals(paramContext))
    {
      int i;
      return;
    }
    QLog.d("QQIdentiferLegacy", 1, "received account kicked broadcast");
    QQIdentiferLegacy.a(this.this$0).finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vny
 * JD-Core Version:    0.7.0.1
 */