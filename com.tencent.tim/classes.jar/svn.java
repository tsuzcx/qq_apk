import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qphone.base.util.QLog;
import mqq.app.NewIntent;
import org.json.JSONObject;

public class svn
  extends VasWebviewJsPlugin
{
  public String aue = "";
  public String auf = "";
  public String mShareUrl = "";
  public String zc = "";
  
  public svn()
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
          this.auf = paramJsBridgeListener.optString("image");
          this.zc = paramJsBridgeListener.optString("title");
          this.aue = paramJsBridgeListener.optString("summary");
          this.mShareUrl = paramJsBridgeListener.optString("shareURL");
          if (QLog.isColorLevel()) {
            QLog.e("shareWebPage", 2, "Share info after JS capture: title=" + this.zc + ", summary=" + this.aue + ", thumb=" + this.auf + ", shareURL=" + this.mShareUrl);
          }
          i = 0;
          if (TextUtils.isEmpty(this.auf)) {
            i = 1;
          }
          j = i;
          if (TextUtils.isEmpty(this.aue)) {
            j = i | 0x2;
          }
          if (!TextUtils.isEmpty(this.zc)) {
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
          paramJsBridgeListener.putString("stringext_1", "" + this.mShareUrl);
          arts.a().a(paramJsBridgeListener, "", this.mRuntime.a().getAccount(), false);
        }
        paramJsBridgeListener = this.mRuntime.a(this.mRuntime.getActivity());
        if ((paramJsBridgeListener == null) || (!(paramJsBridgeListener instanceof ardm.f))) {
          break label747;
        }
        paramString1 = (ardm.f)paramJsBridgeListener;
        if (QLog.isColorLevel()) {
          QLog.d("ShareApiPlugin", 2, "Share JS deal cost=" + (System.currentTimeMillis() - paramString1.hY()));
        }
        if (!(paramJsBridgeListener instanceof ardm.k)) {
          break label747;
        }
        paramJsBridgeListener = (ardm.k)paramJsBridgeListener;
        paramString2 = paramJsBridgeListener.b();
        if (paramString2 == null) {
          break label747;
        }
        if (paramString2.a == null) {
          paramString2.a = this.mRuntime.getWebView();
        }
        if (paramString1.hF(paramString2.getShareUrl()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ShareApiPlugin", 2, "is not need load share js");
          }
        }
        else if ((TextUtils.isEmpty(this.aue)) || (TextUtils.isEmpty(this.zc)) || (TextUtils.isEmpty(this.auf)) || (TextUtils.isEmpty(this.mShareUrl)) || (this.aue.startsWith("http://")) || (this.aue.startsWith("https://")))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ShareApiPlugin", 2, "Share info imperfect, request from svr");
          }
          paramString1 = new NewIntent(this.mRuntime.a().getApplication(), ailv.class);
          paramString1.putExtra("extra_cmd", "SQQzoneSvc.getUrlInfo");
          paramString1.putExtra("extra_current_uin", this.mRuntime.a().getAccount());
          paramString1.putExtra("extra_url", paramString2.getShareUrl());
          paramString1.setObserver(new svo(this, paramJsBridgeListener));
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
      paramJsBridgeListener.a(this.zc, this.aue, this.mShareUrl, this.auf, paramString1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     svn
 * JD-Core Version:    0.7.0.1
 */