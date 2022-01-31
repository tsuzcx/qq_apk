import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.TextView;
import com.dataline.activities.LiteWifiphotoActivity;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;

public class bu
  extends BroadcastReceiver
{
  public bu(LiteWifiphotoActivity paramLiteWifiphotoActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      paramContext = paramIntent.getAction();
      if (paramContext != null)
      {
        if (!paramContext.equals("com.tencent.dataline.wifiphoto.ACTION_WIFIPHOTO_CLOSE")) {
          break label54;
        }
        paramContext = (DataLineHandler)this.a.app.a(8);
        if (paramContext != null) {
          paramContext.g();
        }
        this.a.finish();
      }
    }
    label54:
    while (!paramContext.equals("com.tencent.dataline.wifiphoto.ACTION_WIFIPHOTO_CONNECTED")) {
      return;
    }
    LiteWifiphotoActivity.a(this.a).setText(2131361857);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bu
 * JD-Core Version:    0.7.0.1
 */