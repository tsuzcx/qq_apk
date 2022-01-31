import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.qphone.base.util.QLog;
import mqq.app.NewIntent;
import org.json.JSONObject;

public class xmw
  extends VasWebviewJsPlugin
{
  public String a = "";
  public String b = "";
  public String c = "";
  public String d = "";
  
  public xmw()
  {
    this.mPluginNameSpace = "share";
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((paramString2 != null) && ("share".equals(paramString2))) {
      if ((paramString3 == null) || (!"setShare".equals(paramString3)) || (paramVarArgs.length != 1)) {
        break label747;
      }
    }
    for (;;)
    {
      try
      {
        paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
        if ("share".equals(paramJsBridgeListener.optString("type")))
        {
          this.d = paramJsBridgeListener.optString("image");
          this.b = paramJsBridgeListener.optString("title");
          this.c = paramJsBridgeListener.optString("summary");
          this.a = paramJsBridgeListener.optString("shareURL");
          if (QLog.isColorLevel()) {
            QLog.e("shareWebPage", 2, "Share info after JS capture: title=" + this.b + ", summary=" + this.c + ", thumb=" + this.d + ", shareURL=" + this.a);
          }
          i = 0;
          if (TextUtils.isEmpty(this.d)) {
            i = 1;
          }
          j = i;
          if (TextUtils.isEmpty(this.c)) {
            j = i | 0x2;
          }
          if (!TextUtils.isEmpty(this.b)) {
            break label740;
          }
          i = j | 0x4;
          paramJsBridgeListener = new Bundle();
          paramJsBridgeListener.putString("report_type", "102");
          paramJsBridgeListener.putString("act_type", "90");
          paramString1 = new StringBuilder().append("");
          if (i != 0) {
            break label749;
          }
          j = 0;
          paramJsBridgeListener.putString("intext_1", j);
          paramJsBridgeListener.putString("intext_2", "" + i);
          paramJsBridgeListener.putString("stringext_1", "" + this.a);
          bdes.a().a(paramJsBridgeListener, "", this.mRuntime.a().getAccount(), false);
        }
        paramJsBridgeListener = this.mRuntime.a(this.mRuntime.a());
        if ((paramJsBridgeListener == null) || (!(paramJsBridgeListener instanceof bcia))) {
          break label747;
        }
        paramString1 = (bcia)paramJsBridgeListener;
        if (QLog.isColorLevel()) {
          QLog.d("ShareApiPlugin", 2, "Share JS deal cost=" + (System.currentTimeMillis() - paramString1.b()));
        }
        if (!(paramJsBridgeListener instanceof bcif)) {
          break label747;
        }
        paramJsBridgeListener = (bcif)paramJsBridgeListener;
        paramString2 = paramJsBridgeListener.a();
        if (paramString2 == null) {
          break label747;
        }
        if (paramString2.a == null) {
          paramString2.a = this.mRuntime.a();
        }
        if (paramString1.c(paramString2.a()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ShareApiPlugin", 2, "is not need load share js");
          }
        }
        else if ((TextUtils.isEmpty(this.c)) || (TextUtils.isEmpty(this.b)) || (TextUtils.isEmpty(this.d)) || (TextUtils.isEmpty(this.a)) || (this.c.startsWith("http://")) || (this.c.startsWith("https://")))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ShareApiPlugin", 2, "Share info imperfect, request from svr");
          }
          paramString1 = new NewIntent(this.mRuntime.a().getApplication(), arpe.class);
          paramString1.putExtra("extra_cmd", "SQQzoneSvc.getUrlInfo");
          paramString1.putExtra("extra_current_uin", this.mRuntime.a().getAccount());
          paramString1.putExtra("extra_url", paramString2.a());
          paramString1.setObserver(new xmx(this, paramJsBridgeListener));
          this.mRuntime.a().startServlet(paramString1);
        }
      }
      catch (Exception paramJsBridgeListener)
      {
        if (!QLog.isColorLevel()) {
          break label747;
        }
      }
      QLog.d("ShareApiPlugin", 2, "exception =" + paramJsBridgeListener);
      break label747;
      paramString1 = new Bundle();
      paramString1.putInt("extra_url_info_from", 3);
      paramJsBridgeListener.a(this.b, this.c, this.a, this.d, paramString1);
      break label747;
      return false;
      label740:
      int i = j;
      continue;
      label747:
      return true;
      label749:
      int j = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xmw
 * JD-Core Version:    0.7.0.1
 */