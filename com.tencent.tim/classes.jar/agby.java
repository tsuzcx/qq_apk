import android.graphics.Bitmap;
import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity;
import com.tencent.mobileqq.filemanager.widget.FileWebView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class agby
  extends WebViewClient
{
  long Yl = 0L;
  
  public agby(FilePreviewActivity paramFilePreviewActivity) {}
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    String str = null;
    if (this.this$0.ccQ)
    {
      super.onPageFinished(paramWebView, paramString);
      return;
    }
    if (this.this$0.ccL) {
      this.this$0.ccQ = true;
    }
    if (this.this$0.ccL) {
      if (this.this$0.cWD == 0)
      {
        str = this.this$0.getInitString(this.this$0.bGu, this.this$0.nFileType, Integer.parseInt(this.this$0.bGv), this.this$0.bGt, this.this$0.strCookie, null);
        QLog.i("<FileAssistant>FilePreviewActivity", 1, "finish load run javascript![" + str + "]");
        this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.loadUrl(str);
        str = "javascript:qpreview.onClientResponse('showFileList', {})";
        QLog.i("<FileAssistant>FilePreviewActivity", 1, "javascript:qpreview.onClientResponse('showFileList', {})");
      }
    }
    for (;;)
    {
      QLog.i("<FileAssistant>FilePreviewActivity", 1, "mWebView.loadUrl(" + str + ")");
      this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.loadUrl(str);
      this.this$0.ccQ = true;
      super.onPageFinished(paramWebView, paramString);
      return;
      if (this.this$0.cWD == 1)
      {
        str = this.this$0.getInitString(this.this$0.bGu, this.this$0.nFileType, Integer.parseInt(this.this$0.bGv), this.this$0.bGt, this.this$0.strCookie, this.this$0.bGr);
        break;
      }
      if (!QLog.isDevelopLevel()) {
        break;
      }
      throw new NullPointerException(acfp.m(2131706287));
      str = this.this$0.getInitString(this.this$0.bGu, this.this$0.nFileType, Integer.parseInt(this.this$0.bGv), this.this$0.bGt, this.this$0.strCookie, null);
      QLog.i("<FileAssistant>FilePreviewActivity", 1, "finish load run javascript![" + str + "]");
      this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.loadUrl(str);
      str = "javascript:qpreview.onClientResponse('addMorePage',{})";
      QLog.i("<FileAssistant>FilePreviewActivity", 1, "javascript:qpreview.onClientResponse('addMorePage',{})");
    }
  }
  
  @Override
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    JsInjector.getInstance().onPageStarted(paramWebView);
    super.onPageStarted(paramWebView, paramString, paramBitmap);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    for (;;)
    {
      try
      {
        String str = URLDecoder.decode(paramString, "UTF-8");
        paramString = str;
      }
      catch (Exception localException)
      {
        boolean bool;
        long l;
        continue;
      }
      try
      {
        if (QLog.isColorLevel()) {
          QLog.i("<FileAssistant>FilePreviewActivity", 1, "URLDecoder.decode, url:" + paramString);
        }
        bool = this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.a(paramWebView, paramString, this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView$a);
        if (!bool) {
          continue;
        }
      }
      catch (Exception paramWebView)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("<FileAssistant>FilePreviewActivity", 2, "parseUrl error,exception:" + paramWebView.toString());
        if ((paramString != null) && (!"".equals(paramString)) && (!"about:blank;".equals(paramString)) && (!"about:blank".equals(paramString))) {
          continue;
        }
        QLog.e("<FileAssistant>FilePreviewActivity", 1, "request url is null,or about:blank! return");
        return true;
        l = System.currentTimeMillis();
        if (l - this.Yl < 1500L) {
          continue;
        }
        this.Yl = l;
        QLog.i("<FileAssistant>FilePreviewActivity", 1, "start load new[" + paramString + "]");
        paramWebView = FilePreviewActivity.a(this.this$0, paramString);
        try
        {
          URLDecoder.decode(paramWebView, "UTF-8");
          return true;
        }
        catch (UnsupportedEncodingException paramWebView)
        {
          paramWebView.printStackTrace();
          return true;
        }
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agby
 * JD-Core Version:    0.7.0.1
 */