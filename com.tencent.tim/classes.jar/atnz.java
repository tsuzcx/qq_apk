import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.tim.filemanager.activity.FMActivity;

public class atnz
  extends BroadcastReceiver
{
  public atnz(FMActivity paramFMActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("com.tencent.mobileqq.qlink.destory.fmactivity".equalsIgnoreCase(paramIntent.getAction()))
    {
      this.a.finish();
      this.a.overridePendingTransition(0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atnz
 * JD-Core Version:    0.7.0.1
 */