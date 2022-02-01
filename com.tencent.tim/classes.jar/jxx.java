import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.log.VipWebViewReportLog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.JsBridgeController;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage.MessageLevel;
import com.tencent.smtt.export.external.interfaces.JsPromptResult;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;
import java.net.MalformedURLException;
import java.net.URL;

public class jxx
  extends WebChromeClient
{
  String UV = "";
  int aEu = 0;
  public boolean acW;
  long lastLogTime = 0L;
  aqju mDialog;
  
  private String p(Context paramContext, String paramString)
  {
    if (paramString == null) {
      return null;
    }
    if (paramString.startsWith("data:")) {
      return paramContext.getString(2131695154);
    }
    try
    {
      paramContext = new URL(paramString).getHost();
      return paramContext;
    }
    catch (MalformedURLException paramContext) {}
    return paramString;
  }
  
  public void aBe()
  {
    if ((this.mDialog != null) && (this.mDialog.isShowing())) {
      this.mDialog.cancel();
    }
  }
  
  public boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    super.onConsoleMessage(paramConsoleMessage);
    VipWebViewReportLog.a(paramConsoleMessage);
    Object localObject2;
    if (((this.acW) && (paramConsoleMessage.messageLevel() == ConsoleMessage.MessageLevel.ERROR)) || (QLog.isColorLevel())) {
      localObject2 = "";
    }
    for (;;)
    {
      try
      {
        if (paramConsoleMessage.messageLevel() != null) {
          localObject2 = "" + "messageLevel =" + paramConsoleMessage.messageLevel().toString();
        }
        localObject1 = localObject2;
        if (paramConsoleMessage.sourceId() != null) {
          localObject1 = (String)localObject2 + ", sourceId=" + paramConsoleMessage.sourceId();
        }
        localObject2 = localObject1;
        if (paramConsoleMessage.lineNumber() != 0) {
          localObject2 = (String)localObject1 + ", lineNumber=" + paramConsoleMessage.lineNumber();
        }
        localObject1 = localObject2;
        if (paramConsoleMessage.message() != null) {
          localObject1 = (String)localObject2 + ", message=" + paramConsoleMessage.message();
        }
        if (paramConsoleMessage.messageLevel() != ConsoleMessage.MessageLevel.ERROR) {
          continue;
        }
        if ((System.currentTimeMillis() - this.lastLogTime > 60000L) || (!((String)localObject1).equals(this.UV)))
        {
          QLog.e("WEBVIEWCHECK", 1, "CustomWebChromeClient onConsoleMessage:" + (String)localObject1);
          this.UV = ((String)localObject1);
          this.lastLogTime = System.currentTimeMillis();
        }
      }
      catch (Exception paramConsoleMessage)
      {
        Object localObject1;
        paramConsoleMessage.printStackTrace();
        continue;
      }
      if (QLog.isColorLevel()) {
        break label357;
      }
      return true;
      if ((System.currentTimeMillis() - this.lastLogTime > 180000L) || (!((String)localObject1).equals(this.UV)))
      {
        QLog.d("WEBVIEWCHECK", 2, "CustomWebChromeClient onConsoleMessage:" + (String)localObject1);
        this.UV = ((String)localObject1);
        this.lastLogTime = System.currentTimeMillis();
      }
    }
    label357:
    return false;
  }
  
  public boolean onJsAlert(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    Context localContext = paramWebView.getContext();
    if (((localContext instanceof Activity)) && (!((Activity)localContext).isFinishing()) && ((!(paramWebView instanceof CustomWebView)) || (!((CustomWebView)paramWebView).isPaused)))
    {
      if ((this.mDialog != null) && (this.mDialog.isShowing())) {
        this.mDialog.dismiss();
      }
      this.mDialog = aqha.a(localContext, 0);
      this.mDialog.setTitle(p(localContext, paramString1));
      this.mDialog.setMessage(paramString2);
      this.mDialog.setPositiveButton(2131721079, new jxy(this, paramJsResult));
      if (this.aEu > 2) {
        this.mDialog.setNegativeButton(localContext.getString(2131691019), localContext.getResources().getColor(2131165409), new jyb(this, paramJsResult, localContext));
      }
      this.mDialog.setOnCancelListener(new jyc(this, paramJsResult, localContext));
      this.mDialog.show();
      this.aEu += 1;
      return true;
    }
    paramJsResult.cancel();
    return true;
  }
  
  public boolean onJsBeforeUnload(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    paramString1 = paramWebView.getContext();
    if (((paramString1 instanceof Activity)) && (!((Activity)paramString1).isFinishing()) && ((!(paramWebView instanceof CustomWebView)) || (!((CustomWebView)paramWebView).isPaused)))
    {
      if ((this.mDialog != null) && (this.mDialog.isShowing())) {
        this.mDialog.dismiss();
      }
      this.mDialog = aqha.a(paramString1, 0);
      this.mDialog.setTitle(2131695153);
      this.mDialog.setMessage(paramString2);
      this.mDialog.setPositiveButton(2131690831, new jyh(this, paramJsResult));
      if (this.aEu > 2) {
        this.mDialog.setNegativeButton(paramString1.getString(2131691019), paramString1.getResources().getColor(2131165409), new jyi(this, paramJsResult, paramString1));
      }
      for (;;)
      {
        this.mDialog.setOnCancelListener(new jya(this, paramJsResult, paramString1));
        this.mDialog.show();
        return true;
        this.mDialog.setNegativeButton(2131690830, new jxz(this, paramJsResult));
      }
    }
    paramJsResult.cancel();
    return true;
  }
  
  public boolean onJsConfirm(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    Context localContext = paramWebView.getContext();
    if (((localContext instanceof Activity)) && (!((Activity)localContext).isFinishing()) && ((!(paramWebView instanceof CustomWebView)) || (!((CustomWebView)paramWebView).isPaused)))
    {
      if ((this.mDialog != null) && (this.mDialog.isShowing())) {
        this.mDialog.dismiss();
      }
      this.mDialog = aqha.a(localContext, 0);
      this.mDialog.setTitle(p(localContext, paramString1));
      this.mDialog.setMessage(paramString2);
      this.mDialog.setPositiveButton(2131721079, new jyd(this, paramJsResult));
      if (this.aEu > 2) {
        this.mDialog.setNegativeButton(localContext.getString(2131691019), localContext.getResources().getColor(2131165409), new jye(this, paramJsResult, localContext));
      }
      for (;;)
      {
        this.mDialog.setOnCancelListener(new jyg(this, paramJsResult, localContext));
        this.mDialog.show();
        return true;
        this.mDialog.setNegativeButton(2131721058, new jyf(this, paramJsResult));
      }
    }
    paramJsResult.cancel();
    return true;
  }
  
  public boolean onJsPrompt(WebView paramWebView, String paramString1, String paramString2, String paramString3, JsPromptResult paramJsPromptResult)
  {
    if (JsBridgeController.getInstance().shouldIntercept(paramWebView, paramString2, paramString1, paramJsPromptResult)) {
      return true;
    }
    paramJsPromptResult.cancel();
    return true;
  }
  
  @Override
  public void onProgressChanged(WebView paramWebView, int paramInt)
  {
    JsInjector.getInstance().onProgressChanged(paramWebView, paramInt);
    super.onProgressChanged(paramWebView, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jxx
 * JD-Core Version:    0.7.0.1
 */