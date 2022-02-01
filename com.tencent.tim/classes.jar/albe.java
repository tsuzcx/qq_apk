import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.util.Map;

public class albe
  extends WebViewPlugin
{
  private String aGZ;
  private Bundle bm;
  private boolean cvN;
  private WebView webview;
  
  public albe()
  {
    this.mPluginNameSpace = "profileJS";
  }
  
  private boolean n(String[] paramArrayOfString)
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.TAG, 2, "onAddTag");
    }
    if (this.bm == null) {
      this.bm = new Bundle();
    }
    this.bm.putBoolean("onTagChanged", true);
    return true;
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if (paramLong == 8589934598L)
    {
      if (QLog.isColorLevel()) {
        QLog.i(this.TAG, 2, "handleEvent finish or destroy. fromProfile:" + this.cvN);
      }
      if ((this.aGZ != null) && (!"".equals(this.aGZ)) && (this.bm != null))
      {
        paramString = new Intent();
        paramString.setAction(this.aGZ);
        if (this.bm != null) {
          paramString.putExtra("key_bundle_data", this.bm);
        }
        this.mRuntime.getActivity().sendBroadcast(paramString);
        this.bm = null;
        if (this.cvN)
        {
          paramString = new Intent(this.mRuntime.getActivity(), PersonalityLabelGalleryActivity.class);
          paramString.putExtra("fromType", 3);
          paramString.putExtra("uin", this.mRuntime.a().getCurrentAccountUin());
          this.mRuntime.getActivity().startActivity(paramString);
        }
      }
    }
    return false;
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((paramString2 == null) || (!paramString2.equalsIgnoreCase("profileJS")) || (paramString3 == null)) {}
    while ((this.mRuntime == null) || (this.mRuntime.getActivity() == null)) {
      return false;
    }
    if (paramString3.equals("onAddTag")) {
      return n(paramVarArgs);
    }
    return true;
  }
  
  public void onWebViewCreated(CustomWebView paramCustomWebView)
  {
    super.onWebViewCreated(paramCustomWebView);
    this.webview = this.mRuntime.getWebView();
    if (this.mRuntime.getActivity().getIntent() != null)
    {
      this.aGZ = this.mRuntime.getActivity().getIntent().getStringExtra("broadcastAction");
      this.cvN = this.mRuntime.getActivity().getIntent().getBooleanExtra("fromProfile", this.cvN);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     albe
 * JD-Core Version:    0.7.0.1
 */