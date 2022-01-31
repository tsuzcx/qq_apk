import android.app.Activity;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import java.util.ArrayList;
import java.util.Map;

public class zci
  extends WebViewPlugin
{
  private ArrayList<zcg> a = new ArrayList();
  
  public zci()
  {
    this.mPluginNameSpace = "GdtWebReportPlugin";
    zch localzch = new zch(this);
    zcj localzcj = new zcj(this);
    oaa localoaa = new oaa();
    this.a.add(localzch);
    this.a.add(localzcj);
    this.a.add(localoaa);
  }
  
  public Activity a()
  {
    if (this.mRuntime != null) {}
    for (Activity localActivity1 = this.mRuntime.a();; localActivity1 = null)
    {
      Activity localActivity2 = localActivity1;
      if ((localActivity1 instanceof BasePluginActivity)) {
        localActivity2 = ((BasePluginActivity)BasePluginActivity.class.cast(localActivity1)).getOutActivity();
      }
      return localActivity2;
    }
  }
  
  public void callJs(String paramString)
  {
    super.callJs(paramString);
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    int i = 0;
    while (i < this.a.size())
    {
      ((zcg)this.a.get(i)).a(paramString, paramLong, paramMap);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     zci
 * JD-Core Version:    0.7.0.1
 */