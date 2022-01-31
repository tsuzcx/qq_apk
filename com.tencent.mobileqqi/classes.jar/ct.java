import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.TextView;
import com.dataline.activities.LiteWifiphotoActivity;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;

public class ct
  extends BroadcastReceiver
{
  public ct(LiteWifiphotoActivity paramLiteWifiphotoActivity) {}
  
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
        paramContext = (DataLineHandler)this.a.b.a(8);
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
    LiteWifiphotoActivity.a(this.a).setText(2131558531);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     ct
 * JD-Core Version:    0.7.0.1
 */