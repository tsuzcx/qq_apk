import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.appcommon.js.OpenJsBridge.1;
import com.tencent.open.appcommon.js.OpenJsBridge.OpenJsBridgeListener.1;
import com.tencent.open.appcommon.js.OpenJsBridge.OpenJsBridgeListener.2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;

public class aruu
  extends aiim
{
  public HashMap<String, aiim.b> lm = new HashMap();
  
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
    long l1 = System.currentTimeMillis();
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
              QLog.i("OpenJsBridge", 4, "[getResult]decode failed: " + (String)paramList.get(i));
            }
          }
        }
      }
    }
    long l2 = System.currentTimeMillis();
    arwt.i("OpenJsBridge", "[getResult]time4-time3=" + (l2 - l1));
    paramString1 = (aiim.b)this.lm.get(paramString1);
    if (paramString1 != null) {
      paramString1.call(paramString2, paramList, parama);
    }
    while (!(parama instanceof aruu.a)) {
      return;
    }
    ((aruu.a)parama).Xj(paramString2);
  }
  
  public HashMap<String, aiim.b> af()
  {
    return this.lm;
  }
  
  public boolean b(WebView paramWebView, String paramString)
  {
    if (paramString == null) {}
    Uri localUri;
    do
    {
      return false;
      localUri = Uri.parse(paramString);
    } while ((localUri == null) || (localUri.getScheme() == null) || (!localUri.getScheme().equals("jsbridge")));
    arwt.i("OpenJsBridge", "[canHandleUrl] AsyncInterface_start:" + paramString);
    ThreadManager.executeOnSubThread(new OpenJsBridge.1(this, paramString, paramWebView));
    return true;
  }
  
  public static class a
    extends aiim.a
  {
    public long abC;
    WeakReference<WebView> hh;
    String url;
    
    public a(WebView paramWebView, long paramLong, String paramString)
    {
      super(paramLong, paramString);
      this.hh = new WeakReference(paramWebView);
      this.abC = paramLong;
      this.url = paramString;
    }
    
    public void D(String paramString, Object paramObject)
    {
      WebView localWebView = (WebView)this.hh.get();
      if ((localWebView == null) || (paramObject == null)) {
        return;
      }
      String str = "'undefined'";
      if ((paramObject instanceof String))
      {
        paramObject = ((String)paramObject).replace("\\", "\\\\").replace("'", "\\'");
        str = "'" + paramObject + "'";
      }
      for (;;)
      {
        new Handler(Looper.getMainLooper()).post(new OpenJsBridge.OpenJsBridgeListener.1(this, paramString, str, localWebView));
        return;
        if (((paramObject instanceof Number)) || ((paramObject instanceof Long)) || ((paramObject instanceof Integer)) || ((paramObject instanceof Double)) || ((paramObject instanceof Float))) {
          str = paramObject.toString();
        } else if ((paramObject instanceof Boolean)) {
          str = paramObject.toString();
        }
      }
    }
    
    public void Xj(String paramString)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("OpenJsBridge", 4, "onNoMatchMethod");
      }
      WebView localWebView = (WebView)this.hh.get();
      if (localWebView == null) {
        return;
      }
      new Handler(Looper.getMainLooper()).post(new OpenJsBridge.OpenJsBridgeListener.2(this, paramString, localWebView));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aruu
 * JD-Core Version:    0.7.0.1
 */