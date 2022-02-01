import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper.CommonJsPluginFactory;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;

public class awhy
  extends aqyg
  implements aqza
{
  public static final WebAccelerateHelper.CommonJsPluginFactory a;
  private boolean DL = true;
  private awhy.a a;
  protected Intent mIntent;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqWebprocessWebAccelerateHelper$CommonJsPluginFactory = new awhz();
  }
  
  public awhy(Context paramContext, Activity paramActivity, Intent paramIntent, AppInterface paramAppInterface, boolean paramBoolean)
  {
    super(paramContext, paramActivity, paramAppInterface);
    this.mIntent = paramIntent;
    this.DL = paramBoolean;
  }
  
  public void a(awhy.a parama)
  {
    this.jdField_a_of_type_Awhy$a = parama;
  }
  
  public void a(TouchWebView paramTouchWebView)
  {
    this.mWebview = paramTouchWebView;
  }
  
  public void bindJavaScript(ArrayList<WebViewPlugin> paramArrayList)
  {
    if (this.mPluginList == null) {
      this.mPluginList = new ArrayList();
    }
    this.mPluginList.add(new awff());
  }
  
  public void buildBottomBar() {}
  
  public void buildContentView(Bundle paramBundle) {}
  
  public void buildData() {}
  
  public void buildLayout() {}
  
  public void buildTitleBar() {}
  
  public final void buildWebView(AppInterface paramAppInterface)
  {
    super.buildBaseWebView(paramAppInterface);
    onWebViewReady();
  }
  
  public void callJs(String paramString)
  {
    if (this.mWebview != null) {
      this.mWebview.callJs(paramString);
    }
  }
  
  protected WebAccelerateHelper.CommonJsPluginFactory myCommonJsPlugins()
  {
    if (this.DL) {
      return jdField_a_of_type_ComTencentMobileqqWebprocessWebAccelerateHelper$CommonJsPluginFactory;
    }
    return new WebAccelerateHelper.CommonJsPluginFactory();
  }
  
  public void onDestroy()
  {
    try
    {
      super.doOnDestroy();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    if (this.jdField_a_of_type_Awhy$a != null) {}
    try
    {
      this.jdField_a_of_type_Awhy$a.onPageFinished();
      return;
    }
    catch (Exception paramWebView) {}
  }
  
  public void onPause()
  {
    super.doOnPause();
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Awhy$a != null) {}
    try
    {
      this.jdField_a_of_type_Awhy$a.onReceiveError(paramInt, paramString1, paramString2);
      return;
    }
    catch (Exception paramWebView) {}
  }
  
  public void onResume()
  {
    super.doOnResume();
  }
  
  public void onWebViewReady() {}
  
  public void preInitWebviewPlugin()
  {
    super.preInitPluginEngine();
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QzoneWebViewBaseBuilder", 2, "loadUrl in shouldOverrideUrlLoading url=" + paramString);
    }
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("jsbridge://"))) {
      return true;
    }
    paramWebView.loadUrl(paramString);
    return true;
  }
  
  public static abstract interface a
  {
    public abstract void onPageFinished();
    
    public abstract void onReceiveError(int paramInt, String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awhy
 * JD-Core Version:    0.7.0.1
 */