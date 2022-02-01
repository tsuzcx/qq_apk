import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import com.tencent.tim.filemanager.activity.FilePreviewActivity;
import com.tencent.tim.filemanager.widget.FileWebView;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class atoj
  extends WebViewClient
{
  long Yl = 0L;
  
  public atoj(FilePreviewActivity paramFilePreviewActivity) {}
  
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
        this.this$0.jdField_a_of_type_ComTencentTimFilemanagerWidgetFileWebView.loadUrl(str);
        str = "javascript:qpreview.onClientResponse('showFileList', {})";
        QLog.i("<FileAssistant>FilePreviewActivity", 1, "javascript:qpreview.onClientResponse('showFileList', {})");
      }
    }
    for (;;)
    {
      QLog.i("<FileAssistant>FilePreviewActivity", 1, "mWebView.loadUrl(" + str + ")");
      this.this$0.jdField_a_of_type_ComTencentTimFilemanagerWidgetFileWebView.loadUrl(str);
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
      throw new NullPointerException("压缩文件类型错误！！！");
      str = this.this$0.getInitString(this.this$0.bGu, this.this$0.nFileType, Integer.parseInt(this.this$0.bGv), this.this$0.bGt, this.this$0.strCookie, null);
      QLog.i("<FileAssistant>FilePreviewActivity", 1, "finish load run javascript![" + str + "]");
      this.this$0.jdField_a_of_type_ComTencentTimFilemanagerWidgetFileWebView.loadUrl(str);
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
        int k;
        int j;
        int i;
        continue;
      }
      try
      {
        if (QLog.isColorLevel()) {
          QLog.i("<FileAssistant>FilePreviewActivity", 1, "URLDecoder.decode, url:" + paramString);
        }
        bool = this.this$0.jdField_a_of_type_ComTencentTimFilemanagerWidgetFileWebView.a(paramWebView, paramString, this.this$0.jdField_a_of_type_ComTencentTimFilemanagerWidgetFileWebView$a);
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
        k = paramString.lastIndexOf("/") + 1;
        j = paramString.lastIndexOf("&");
        i = j;
        if (j >= k) {
          continue;
        }
        i = paramString.length();
        paramWebView = paramString.substring(k, i);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atoj
 * JD-Core Version:    0.7.0.1
 */