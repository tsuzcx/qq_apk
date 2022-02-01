import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.widget.EditText;
import com.tencent.qqconnect.wtlogin.Login;
import java.util.HashMap;
import mqq.os.MqqHandler;

public class assg
  extends MqqHandler
{
  public assg(Login paramLogin) {}
  
  public void handleMessage(Message paramMessage)
  {
    Bundle localBundle = paramMessage.getData();
    this.a.elD();
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return;
        this.a.showDialog(String.format(this.a.getResources().getString(2131698727), new Object[] { this.a.getResources().getString(2131696664), Integer.valueOf(3100) }));
        paramMessage = new HashMap();
        paramMessage.put("error", "3100");
        anpc.a(this.a).collectPerformance("0", "connect_sso_authfail", false, 0L, 0L, paramMessage, "");
        return;
        localBundle.getInt("ret");
        int i = localBundle.getInt("code");
        paramMessage = localBundle.getString("OTHER_ERROR");
        if (localBundle.getBoolean("pwdblank", false)) {
          this.a.bH.setText("");
        }
        this.a.showDialog(String.format(this.a.getResources().getString(2131698727), new Object[] { paramMessage, Integer.valueOf(i) }));
        paramMessage = new HashMap();
        paramMessage.put("error", "3101");
        anpc.a(this.a).collectPerformance("0", "connect_sso_authfail", false, 0L, 0L, paramMessage, "");
        return;
      } while (this.a.isFinishing());
      this.a.elD();
      return;
    } while (this.a.isFinishing());
    this.a.elC();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     assg
 * JD-Core Version:    0.7.0.1
 */