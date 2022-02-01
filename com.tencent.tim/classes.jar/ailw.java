import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.jsp.X5ApiPlugin.1;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.WebView;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class ailw
  extends WebViewPlugin
{
  private ConcurrentHashMap<String, ailw.a> fH;
  private ConcurrentHashMap<String, ailw.a> fI;
  
  public ailw()
  {
    this.mPluginNameSpace = "x5";
  }
  
  private int A(Context paramContext, String paramString)
  {
    if (arcp.aGk())
    {
      if ((!TextUtils.isEmpty(paramString)) && (arcp.rU(paramString)) && (!paramString.contains("asyncMode=3")) && (!paramString.contains("sonic=1")))
      {
        if ((paramContext != null) && (QbSdk.getTbsVersion(paramContext) >= 43810)) {
          return 4;
        }
        return 3;
      }
      return 2;
    }
    return 1;
  }
  
  private void Le(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.fI != null) && (this.fH != null))
    {
      Object localObject = this.fI.values().iterator();
      if (((Iterator)localObject).hasNext())
      {
        localObject = (ailw.a)((Iterator)localObject).next();
        this.fI.remove(((ailw.a)localObject).bzI);
        this.fH.put(((ailw.a)localObject).bzI, localObject);
        a(this.mRuntime.getWebView(), (ailw.a)localObject);
        cI(4, ((ailw.a)localObject).bOY);
      }
    }
  }
  
  private void a(ailw.a parama)
  {
    this.fI.put(parama.bzI, parama);
    cI(5, parama.bOY);
  }
  
  private void a(Context paramContext, WebView paramWebView, ailw.a parama)
  {
    int i = A(paramContext, parama.bzI);
    if (i == 4) {
      a(paramWebView, parama);
    }
    cI(i, parama.bOY);
  }
  
  private void a(WebView paramWebView, ailw.a parama)
  {
    this.fH.put(parama.bzI, parama);
    ThreadManager.post(new X5ApiPlugin.1(this, parama, paramWebView), 5, null, true);
  }
  
  private boolean apd()
  {
    Object localObject = this.mRuntime.b();
    if (localObject != null)
    {
      localObject = (arbz)((WebViewFragment)localObject).b().q(-2);
      return (localObject != null) && (!((arbz)localObject).cXR);
    }
    return false;
  }
  
  private void cI(int paramInt, String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("code", paramInt);
      callJs(paramString, new String[] { localJSONObject.toString() });
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void dsO()
  {
    if (this.fH == null) {
      this.fH = new ConcurrentHashMap();
    }
    if (this.fI == null) {
      this.fI = new ConcurrentHashMap();
    }
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (!"x5".equals(paramString2)) {
      return false;
    }
    if (("preload".equals(paramString3)) && (paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      try
      {
        paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
        paramString1 = new ailw.a();
        paramString1.bzI = paramJsBridgeListener.optString("url");
        paramString1.bOY = paramJsBridgeListener.optString("callback");
        paramString1.ckD = paramJsBridgeListener.optBoolean("doWhenPageFinish", false);
        dsO();
        if (paramString1.ckD) {
          if (apd()) {
            a(this.mRuntime.getActivity(), this.mRuntime.getWebView(), paramString1);
          } else {
            a(paramString1);
          }
        }
      }
      catch (JSONException paramJsBridgeListener)
      {
        paramJsBridgeListener.printStackTrace();
      }
      a(this.mRuntime.getActivity(), this.mRuntime.getWebView(), paramString1);
    }
    return true;
  }
  
  public void onPageFinished()
  {
    Le(true);
  }
  
  public void onPreloadCallback(int paramInt, String paramString)
  {
    if (paramInt == 0)
    {
      if (this.fH.containsKey(paramString)) {
        cI(0, ((ailw.a)this.fH.remove(paramString)).bOY);
      }
      Le(apd());
    }
  }
  
  public static class a
  {
    String bOY;
    public String bzI;
    boolean ckD;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ailw
 * JD-Core Version:    0.7.0.1
 */