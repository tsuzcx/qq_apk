import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class arzq
  extends BroadcastReceiver
{
  arzq(arzk paramarzk) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    arwt.d("MyAppApi", "onReceive ---INTENT = " + paramIntent);
    if ((paramIntent != null) && (paramIntent.getAction().equals("mqq.intent.action.ACCOUNT_EXPIRED"))) {
      this.this$0.emm();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arzq
 * JD-Core Version:    0.7.0.1
 */