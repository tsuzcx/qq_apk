import android.os.Handler;
import android.os.Looper;
import com.tencent.biz.webviewplugin.BusinessReportPlugin.1;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;

public class yyp
  extends WebViewPlugin
{
  private Handler a;
  public boolean a;
  
  public yyp()
  {
    this.mPluginNameSpace = "JD_REPORT";
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Boolean) {}
    try
    {
      this.jdField_a_of_type_AndroidOsHandler.post(new BusinessReportPlugin.1(this, paramString));
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("BusinessReporter", 1, "Report Error:" + paramString);
    }
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_Boolean = ntv.a(paramString);
  }
  
  public Object handleEvent(String paramString, long paramLong)
  {
    if (paramLong == 8L) {
      a(paramString);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yyp
 * JD-Core Version:    0.7.0.1
 */