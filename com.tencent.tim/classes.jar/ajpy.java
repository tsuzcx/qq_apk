import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.nearby.NearbyJsInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class ajpy
  extends BroadcastReceiver
{
  public ajpy(NearbyJsInterface paramNearbyJsInterface) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("command_type", 0);
    QLog.i("NearbyJsInterface", 2, "receive request" + paramIntent.getExtras());
    switch (i)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (TextUtils.isEmpty(NearbyJsInterface.a(this.this$0)));
        this.this$0.callJs(NearbyJsInterface.a(this.this$0), new String[] { paramIntent.getStringExtra("data") });
        NearbyJsInterface.a(this.this$0, "");
        return;
      } while (TextUtils.isEmpty(NearbyJsInterface.b(this.this$0)));
      this.this$0.callJs(NearbyJsInterface.b(this.this$0), new String[] { paramIntent.getStringExtra("data") });
      return;
    } while (TextUtils.isEmpty(NearbyJsInterface.c(this.this$0)));
    i = paramIntent.getIntExtra("exit_mode", 0);
    int j = paramIntent.getIntExtra("exit_action", 0);
    paramContext = new JSONObject();
    try
    {
      paramContext.put("mode", i);
      paramContext.put("action", j);
      this.this$0.callJs(NearbyJsInterface.c(this.this$0), new String[] { paramContext.toString() });
      NearbyJsInterface.b(this.this$0, "");
      return;
    }
    catch (JSONException paramContext)
    {
      for (;;)
      {
        QLog.e("NearbyJsInterface", 2, "onExitProfile, exp:" + paramContext.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajpy
 * JD-Core Version:    0.7.0.1
 */