import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.bless.BlessActivity;

public class wen
  extends BroadcastReceiver
{
  public wen(BlessActivity paramBlessActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("tencent.av.v2q.StartVideoChat".equals(paramIntent.getAction())) {
      BlessActivity.a(this.a, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wen
 * JD-Core Version:    0.7.0.1
 */