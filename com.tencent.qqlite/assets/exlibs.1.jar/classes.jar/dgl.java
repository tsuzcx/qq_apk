import android.content.Intent;
import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity;
import com.tencent.mobileqq.filemanager.widget.FileWebView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class dgl
  extends WebViewClient
{
  long jdField_a_of_type_Long = 0L;
  
  public dgl(FilePreviewActivity paramFilePreviewActivity) {}
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.jdField_d_of_type_Boolean)
    {
      super.onPageFinished(paramWebView, paramString);
      return;
    }
    String str;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.jdField_a_of_type_Boolean)
    {
      str = "javascript:init('" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.e + "','" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.f + "','" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.jdField_d_of_type_JavaLangString + "','" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.b + "','" + "/" + "')";
      QLog.i("<FileAssistant>FilePreviewActivity", 1, "finish load run javascript![" + str + "]");
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.loadUrl(str);
      str = "javascript:show_file_list()";
      QLog.i("<FileAssistant>FilePreviewActivity", 1, "javascript:show_file_list()");
    }
    for (;;)
    {
      QLog.i("<FileAssistant>FilePreviewActivity", 1, "mWebView.loadUrl(" + str + ")");
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.loadUrl(str);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.jdField_d_of_type_Boolean = true;
      super.onPageFinished(paramWebView, paramString);
      return;
      str = "javascript:init('" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.e + "','" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.f + "','" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.jdField_d_of_type_JavaLangString + "','" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.b + "')";
      QLog.i("<FileAssistant>FilePreviewActivity", 1, "finish load run javascript![" + str + "]");
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.loadUrl(str);
      str = "javascript:add_more_page()";
      QLog.i("<FileAssistant>FilePreviewActivity", 1, "javascript:add_more_page()");
    }
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.runOnUiThread(new dgm(this, paramString2, paramInt, paramString1));
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if ((paramString == null) || ("".equals(paramString)) || ("about:blank;".equals(paramString)) || ("about:blank".equals(paramString))) {
      QLog.e("<FileAssistant>FilePreviewActivity", 1, "request url is null,or about:blank! return");
    }
    long l;
    do
    {
      do
      {
        return true;
        if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.e == null) || (paramString.indexOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.e) >= 0)) {
          break;
        }
      } while (!QLog.isDevelopLevel());
      QLog.w("<FileAssistant>FilePreviewActivity", 4, "recv new Url,return!");
      return true;
      l = System.currentTimeMillis();
    } while (l - this.jdField_a_of_type_Long < 1500L);
    this.jdField_a_of_type_Long = l;
    QLog.i("<FileAssistant>FilePreviewActivity", 1, "start load new[" + paramString + "]");
    int k = paramString.lastIndexOf("/") + 1;
    int j = paramString.lastIndexOf("&");
    int i = j;
    if (j < k) {
      i = paramString.length();
    }
    paramWebView = paramString.substring(k, i);
    try
    {
      localObject = URLDecoder.decode(paramWebView, "UTF-8");
      paramWebView = (WebView)localObject;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        Object localObject;
        localUnsupportedEncodingException.printStackTrace();
      }
    }
    localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity, FilePreviewActivity.class);
    ((Intent)localObject).putExtra("offline_file_type", 1);
    ((Intent)localObject).putExtra("offline_file_name", paramWebView);
    ((Intent)localObject).putExtra("offline_file_url", paramString);
    ((Intent)localObject).putExtra("offline_file_bZip", this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.jdField_a_of_type_Boolean);
    ((Intent)localObject).putExtra("offline_file_domain", this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.e);
    ((Intent)localObject).putExtra("offline_file_port", this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.f);
    ((Intent)localObject).putExtra("offline_file_domain_key", this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.jdField_d_of_type_JavaLangString);
    ((Intent)localObject).putExtra("offline_file_type_key", this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.b);
    QLog.i("<FileAssistant>FilePreviewActivity", 1, "open zip dic,open new activity");
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.startActivityForResult((Intent)localObject, 0);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dgl
 * JD-Core Version:    0.7.0.1
 */