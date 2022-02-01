import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.EditText;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qqconnect.wtlogin.Login;
import java.util.HashMap;

public class huh
  extends Handler
{
  public huh(Login paramLogin) {}
  
  public void handleMessage(Message paramMessage)
  {
    Bundle localBundle = paramMessage.getData();
    this.a.g();
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      this.a.a(String.format(this.a.getResources().getString(2131561498), new Object[] { this.a.getResources().getString(2131562443), Integer.valueOf(3100) }));
      paramMessage = new HashMap();
      paramMessage.put("error", "3100");
      StatisticCollector.a(this.a).a("0", "connect_sso_authfail", false, 0L, 0L, paramMessage, "");
      return;
    }
    paramMessage = localBundle.getString("OTHER_ERROR");
    if (localBundle.getBoolean("pwdblank", false)) {
      this.a.b.setText("");
    }
    this.a.a(String.format(this.a.getResources().getString(2131561498), new Object[] { paramMessage, Integer.valueOf(3101) }));
    paramMessage = new HashMap();
    paramMessage.put("error", "3101");
    StatisticCollector.a(this.a).a("0", "connect_sso_authfail", false, 0L, 0L, paramMessage, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     huh
 * JD-Core Version:    0.7.0.1
 */