import android.os.Handler;
import android.os.Looper;
import com.tencent.biz.webviewplugin.BusinessReportPlugin.1;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;

public class sst
  extends WebViewPlugin
{
  public boolean aNb;
  private Handler mUIHandler = new Handler(Looper.getMainLooper());
  
  public sst()
  {
    this.mPluginNameSpace = "JD_REPORT";
  }
  
  public Object handleEvent(String paramString, long paramLong)
  {
    if (paramLong == 8L) {
      tE(paramString);
    }
    return null;
  }
  
  public void tE(String paramString)
  {
    if (this.aNb) {}
    try
    {
      this.mUIHandler.post(new BusinessReportPlugin.1(this, paramString));
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("BusinessReporter", 1, "Report Error:" + paramString);
    }
  }
  
  public void tF(String paramString)
  {
    this.aNb = kdl.dq(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sst
 * JD-Core Version:    0.7.0.1
 */