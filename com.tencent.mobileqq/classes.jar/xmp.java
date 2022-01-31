import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;
import org.json.JSONObject;

public class xmp
  extends WebViewPlugin
{
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("Q.security_verify", 2, String.format(Locale.getDefault(), "handleJsRequest url: %s pkgName; %s method: %s, args: %s", new Object[] { paramString1, paramString2, paramString3, paramVarArgs }));
    }
    if (!"userVerify".equals(paramString2)) {}
    do
    {
      return false;
      paramJsBridgeListener = this.mRuntime.a();
    } while (paramJsBridgeListener == null);
    if ("setTicket".equals(paramString3)) {}
    for (;;)
    {
      try
      {
        paramString1 = new JSONObject(paramVarArgs[0]).optString("ticket");
        int i = paramJsBridgeListener.getIntent().getIntExtra("verify_type", -1);
        if (QLog.isColorLevel()) {
          QLog.d("Q.security_verify", 2, String.format("verifyTicket: %s, verifyType: %s", new Object[] { paramString1, Integer.valueOf(i) }));
        }
        paramString2 = new Intent();
        paramString2.putExtra("ticket", paramString1);
        paramJsBridgeListener.setResult(-1, paramString2);
        paramJsBridgeListener.finish();
      }
      catch (Exception paramJsBridgeListener)
      {
        paramJsBridgeListener.printStackTrace();
        QLog.d("Q.security_verify", 1, "handleJsRequest", paramJsBridgeListener);
        continue;
      }
      return bool;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xmp
 * JD-Core Version:    0.7.0.1
 */