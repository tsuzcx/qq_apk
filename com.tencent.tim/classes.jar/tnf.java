import android.app.Activity;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import java.util.ArrayList;
import java.util.Map;

public class tnf
  extends WebViewPlugin
{
  private ArrayList<tnd> oD = new ArrayList();
  
  public tnf()
  {
    this.mPluginNameSpace = "GdtWebReportPlugin";
    tne localtne = new tne(this);
    tng localtng = new tng(this);
    kmk localkmk = new kmk();
    this.oD.add(localtne);
    this.oD.add(localtng);
    this.oD.add(localkmk);
  }
  
  public void callJs(String paramString)
  {
    super.callJs(paramString);
  }
  
  public Activity getActivity()
  {
    if (this.mRuntime != null) {}
    for (Activity localActivity1 = this.mRuntime.getActivity();; localActivity1 = null)
    {
      Activity localActivity2 = localActivity1;
      if ((localActivity1 instanceof BasePluginActivity)) {
        localActivity2 = ((BasePluginActivity)BasePluginActivity.class.cast(localActivity1)).getOutActivity();
      }
      return localActivity2;
    }
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    int i = 0;
    while (i < this.oD.size())
    {
      ((tnd)this.oD.get(i)).handleEvent(paramString, paramLong, paramMap);
      i += 1;
    }
    return false;
  }
  
  public boolean handleSchemaRequest(String paramString1, String paramString2)
  {
    return super.handleSchemaRequest(paramString1, paramString2);
  }
  
  public void onActivityReady()
  {
    super.onActivityReady();
  }
  
  public void onCreate()
  {
    super.onCreate();
  }
  
  public void onWebViewCreated(CustomWebView paramCustomWebView)
  {
    super.onWebViewCreated(paramCustomWebView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tnf
 * JD-Core Version:    0.7.0.1
 */