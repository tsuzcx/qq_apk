import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import cooperation.qzone.util.QZLog;

class awnk
  extends BroadcastReceiver
{
  awnk(awnj paramawnj) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    try
    {
      paramContext = paramIntent.getAction();
      QZLog.i("BaseTranslucentControll", 4, "reveiver action = " + paramContext);
      this.this$0.et(paramIntent);
      return;
    }
    catch (Exception paramContext)
    {
      QZLog.e("BaseTranslucentControll", "onReceive error", paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awnk
 * JD-Core Version:    0.7.0.1
 */