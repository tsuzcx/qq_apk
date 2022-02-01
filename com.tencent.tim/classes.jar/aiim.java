import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

@Deprecated
public class aiim
{
  jml authCfg;
  HashMap<String, aiim.b> lm = new HashMap();
  
  public void Lf(String paramString)
  {
    if (paramString == null)
    {
      this.lm.clear();
      return;
    }
    this.lm.remove(paramString);
  }
  
  public void a(aiim.b paramb, String paramString)
  {
    this.lm.put(paramString, paramb);
  }
  
  public void a(String paramString1, String paramString2, List<String> paramList, aiim.a parama)
  {
    int j = paramList.size();
    int i = 0;
    for (;;)
    {
      if (i < j) {
        try
        {
          paramList.set(i, URLDecoder.decode((String)paramList.get(i), "UTF-8"));
          i += 1;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          for (;;)
          {
            localUnsupportedEncodingException.printStackTrace();
            if (QLog.isDevelopLevel()) {
              QLog.i("JB", 4, "decode failed: " + (String)paramList.get(i));
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
            if (QLog.isDevelopLevel()) {
              QLog.i("JB", 4, "decode failed, exception: " + (String)paramList.get(i));
            }
          }
        }
      }
    }
    paramString1 = (aiim.b)this.lm.get(paramString1);
    if (paramString1 != null) {
      paramString1.call(paramString2, paramList, parama);
    }
    while (parama == null) {
      return;
    }
    parama.dsA();
  }
  
  public boolean b(WebView paramWebView, String paramString)
  {
    if (paramString == null) {
      return false;
    }
    if (!paramString.startsWith("jsbridge://")) {
      return false;
    }
    List localList = Arrays.asList((paramString + "/#").split("/"));
    if (localList.size() < 6) {
      return false;
    }
    String str1 = (String)localList.get(2);
    String str2 = (String)localList.get(3);
    String str3 = (String)localList.get(4);
    for (;;)
    {
      try
      {
        long l = Long.parseLong(str3);
        localList = localList.subList(5, localList.size() - 1);
        if (QLog.isDevelopLevel()) {
          QLog.d("JB", 4, "calling " + str1 + "." + str2);
        }
        paramString = new aiim.a(paramWebView, l, paramString);
        paramWebView = paramWebView.getUrl();
        if (this.authCfg == null) {
          this.authCfg = jml.a();
        }
        if (this.authCfg.z(paramWebView, str1 + "." + str2))
        {
          a(str1, str2, localList, paramString);
          return true;
        }
      }
      catch (Exception paramWebView)
      {
        return false;
      }
      QLog.e("JsBridge", 1, "JS API no auth url = " + jqo.filterKeyForLog(paramWebView, new String[0]) + " objectName = " + str1 + " methodName = " + str2);
      paramString.dsB();
    }
  }
  
  public static class a
  {
    long abC;
    WeakReference<WebView> hh;
    String url;
    
    public a(WebView paramWebView, long paramLong, String paramString)
    {
      this.hh = new WeakReference(paramWebView);
      this.abC = paramLong;
      this.url = paramString;
    }
    
    public void Lg(String paramString)
    {
      WebView localWebView = (WebView)this.hh.get();
      if (localWebView != null) {
        localWebView.loadUrl("javascript:" + paramString);
      }
    }
    
    public void dsA()
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("JB", 4, "onNoMatchMethod");
      }
      WebView localWebView = (WebView)this.hh.get();
      if (localWebView == null) {
        return;
      }
      localWebView.loadUrl("javascript:window.JsBridge&&JsBridge.callback(" + this.abC + ",{'r':1,'result':'no such method'})");
    }
    
    public void dsB()
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("JB", 4, "onPermissionDenied");
      }
      WebView localWebView = (WebView)this.hh.get();
      if (localWebView != null) {
        localWebView.loadUrl("javascript:window.JsBridge&&JsBridge.callback(" + this.abC + ",{'r':2,'result':'Permission denied'})");
      }
    }
    
    public void onComplete(Object paramObject)
    {
      WebView localWebView = (WebView)this.hh.get();
      if (localWebView == null) {
        return;
      }
      if (paramObject == null)
      {
        localWebView.loadUrl("javascript:window.JsBridge&&JsBridge.callback(" + this.abC + ",{'r':0});");
        return;
      }
      if (((paramObject instanceof Number)) || ((paramObject instanceof Boolean)) || ((paramObject instanceof JSONObject))) {}
      for (paramObject = paramObject.toString();; paramObject = "'" + paramObject.toString().replace("\\", "\\\\").replace("'", "\\'") + "'")
      {
        localWebView.loadUrl("javascript:window.JsBridge&&JsBridge.callback(" + this.abC + ",{'r':0,'result':" + paramObject + "});");
        return;
      }
    }
  }
  
  @Deprecated
  public static class b
  {
    public void call(String paramString, List<String> paramList, aiim.a parama)
    {
      Object localObject2 = null;
      Method[] arrayOfMethod = getClass().getDeclaredMethods();
      int j = arrayOfMethod.length;
      int i = 0;
      for (;;)
      {
        Object localObject1 = localObject2;
        if (i < j)
        {
          localObject1 = arrayOfMethod[i];
          if ((!((Method)localObject1).getName().equals(paramString)) || (((Method)localObject1).getParameterTypes().length != paramList.size())) {}
        }
        else
        {
          if (localObject1 != null) {}
          try
          {
            if (paramList.size() == 0) {}
            for (localObject2 = ((Method)localObject1).invoke(this, new Object[0]);; localObject2 = ((Method)localObject1).invoke(this, paramList.toArray()))
            {
              localObject1 = ((Method)localObject1).getReturnType();
              if ((localObject1 != Void.TYPE) && (localObject1 != Void.class)) {
                break;
              }
              if (parama == null) {
                break label276;
              }
              parama.onComplete(null);
              return;
            }
            if (parama != null) {
              if (customCallback())
              {
                parama.Lg(localObject2.toString());
                return;
              }
            }
          }
          catch (IllegalAccessException localIllegalAccessException)
          {
            if (parama != null) {
              parama.dsA();
            }
            if (QLog.isDevelopLevel()) {
              QLog.d("JB", 4, "cannot found match method,maybe your method using args type is NO String? request method:class:" + getClass().getSimpleName() + paramString + " args:" + paramList);
            }
            if (parama != null)
            {
              parama.dsA();
              return;
              parama.onComplete(localObject2);
              return;
            }
          }
          catch (IllegalArgumentException localIllegalArgumentException)
          {
            for (;;)
            {
              if (parama != null) {
                parama.dsA();
              }
            }
          }
          catch (InvocationTargetException localInvocationTargetException)
          {
            for (;;)
            {
              if (parama != null) {
                parama.dsA();
              }
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              if (parama != null) {
                parama.dsA();
              }
            }
          }
          label276:
          return;
        }
        i += 1;
      }
    }
    
    public boolean customCallback()
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiim
 * JD-Core Version:    0.7.0.1
 */