import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class arnq
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext == null) {}
    while ((!paramContext.equals("mqq.intent.action.ACCOUNT_CHANGED")) || (paramIntent.getIntExtra("type", 0) == 0)) {
      return;
    }
    arnn.access$002(paramIntent.getStringExtra("account"));
    arnn.access$100(arnn.access$000());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arnq
 * JD-Core Version:    0.7.0.1
 */