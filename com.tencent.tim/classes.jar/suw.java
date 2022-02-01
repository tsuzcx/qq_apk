import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.webviewplugin.QzonePlugin.1;
import com.tencent.biz.webviewplugin.QzonePlugin.2;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.smtt.sdk.WebView;
import java.util.Map;

public class suw
  extends WebViewPlugin
{
  public static final String PLUGIN_NAMESPACE = suw.class.getSimpleName();
  private String aGZ;
  private String aHa = "";
  private boolean aNn;
  private String mUrl;
  private WebView webview;
  
  public suw()
  {
    this.mPluginNameSpace = PLUGIN_NAMESPACE;
  }
  
  private void W(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (this.mUrl == null)) {}
    while ((this.mUrl != null) && (this.aHa != null) && (this.aHa.equals(this.mUrl))) {
      return;
    }
    new Handler().post(new QzonePlugin.1(this, paramArrayOfByte));
    this.aHa = this.mUrl;
  }
  
  private void bBe()
  {
    new Handler().post(new QzonePlugin.2(this));
  }
  
  public boolean gm(String paramString)
  {
    Intent localIntent = this.mRuntime.getActivity().getIntent();
    Bundle localBundle = localIntent.getExtras();
    byte[] arrayOfByte = localBundle.getByteArray("post_data");
    boolean bool = localBundle.getBoolean("UrlorData", true);
    this.mUrl = paramString;
    if (localBundle.getString("originalURL") != null) {
      this.mUrl = localBundle.getString("originalURL");
    }
    if (arrayOfByte == null)
    {
      if (bool) {
        return false;
      }
      bBe();
      return true;
    }
    W(arrayOfByte);
    localIntent.removeExtra("post_data");
    return true;
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if ((paramLong == 8589934601L) && (this.aGZ != null) && (!"".equals(this.aGZ)))
    {
      paramString = new Intent();
      paramString.setAction(this.aGZ);
      paramString.putExtra("key_qzone_vip_open_back_need_check_vipinfo", this.aNn);
      if ("com.tencent.mobileqq.opencenter.vipInfo".equals(this.aGZ))
      {
        paramMap = this.mRuntime.a(this.mRuntime.getActivity());
        if ((paramMap != null) && ((paramMap instanceof ardm.c))) {
          paramString.putExtra("key_pay_action_result", ((ardm.c)paramMap).aGb());
        }
      }
      this.mRuntime.getActivity().sendBroadcast(paramString);
    }
    return false;
  }
  
  public boolean handleSchemaRequest(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (paramString1.equalsIgnoreCase("pay://requestQzoneOpenVip")))
    {
      this.aNn = true;
      return true;
    }
    if ((this.mRuntime.getActivity().getIntent().getBooleanExtra("fromQZone", false)) && ((paramString2.equals("http")) || (paramString2.equals("https")))) {
      return gm(paramString1);
    }
    return false;
  }
  
  public void onCreate()
  {
    super.onCreate();
  }
  
  public void onDestroy()
  {
    this.webview = null;
  }
  
  public void onWebViewCreated(CustomWebView paramCustomWebView)
  {
    super.onWebViewCreated(paramCustomWebView);
    this.webview = this.mRuntime.getWebView();
    if (this.mRuntime.getActivity().getIntent() != null) {
      this.aGZ = this.mRuntime.getActivity().getIntent().getStringExtra("broadcastAction");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     suw
 * JD-Core Version:    0.7.0.1
 */