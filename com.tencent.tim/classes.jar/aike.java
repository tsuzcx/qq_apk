import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.support.annotation.Nullable;
import android.support.v4.util.ArraySet;
import android.text.TextUtils;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import java.io.ByteArrayInputStream;
import java.util.Iterator;
import org.json.JSONObject;

public class aike
  extends WebViewPlugin
{
  private Activity activity;
  @Nullable
  private ArraySet<Integer> h;
  
  public aike()
  {
    this.mPluginNameSpace = "Gdt";
  }
  
  private void LF(String paramString)
  {
    for (;;)
    {
      Object localObject;
      try
      {
        localObject = new JSONObject(paramString);
        paramString = ((JSONObject)localObject).optString("businessId");
        String str1 = ((JSONObject)localObject).optString("openlink");
        String str2 = ((JSONObject)localObject).optString("packageName");
        localObject = ((JSONObject)localObject).optString("callback");
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label207;
        }
        aikf localaikf = new aikf(this, (String)localObject);
        i = adxf.a().a(localaikf);
        if (this.h == null) {
          this.h = new ArraySet();
        }
        this.h.add(Integer.valueOf(i));
        try
        {
          if (!TextUtils.isEmpty(str1))
          {
            adxj.e(this.activity, str1, paramString, i);
            return;
          }
          if (TextUtils.isEmpty(str2)) {
            break label183;
          }
          aqiz.b(this.activity, str2, null, paramString, i);
          return;
        }
        catch (ActivityNotFoundException paramString)
        {
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            break;
          }
        }
        callJs((String)localObject, new String[] { "{\"openresult\":-3}" });
        return;
      }
      catch (Exception paramString)
      {
        QLog.e(this.TAG, 1, paramString, new Object[0]);
        return;
      }
      label183:
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break;
      }
      callJs((String)localObject, new String[] { "{\"openresult\":-3}" });
      return;
      label207:
      int i = 0;
    }
  }
  
  private Activity r()
  {
    for (Activity localActivity = this.mRuntime.getActivity(); (localActivity != null) && ((localActivity instanceof BasePluginActivity)); localActivity = ((BasePluginActivity)localActivity).getOutActivity()) {}
    return localActivity;
  }
  
  public Object handleEvent(String paramString, long paramLong)
  {
    if ((paramLong == 8L) && (paramString != null)) {
      try
      {
        if (((adxg.a)aeif.a().o(416)).lk(paramString))
        {
          QLog.d(this.TAG, 1, "doInterceptRequest");
          WebResourceResponse localWebResourceResponse = new WebResourceResponse("text/html", "utf-8", new ByteArrayInputStream(new byte[0]));
          return localWebResourceResponse;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e(this.TAG, 1, localThrowable, new Object[0]);
        return super.handleEvent(paramString, paramLong);
      }
    }
    return super.handleEvent(paramString, paramLong);
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    boolean bool = false;
    if ("Gdt".equals(paramString2))
    {
      addOpenApiListenerIfNeeded(paramString3, paramJsBridgeListener);
      if (("Openlink".equals(paramString3)) && (paramVarArgs.length > 0)) {
        LF(paramVarArgs[0]);
      }
      bool = true;
    }
    return bool;
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.activity = r();
  }
  
  public void onDestroy()
  {
    if (this.h != null)
    {
      Iterator localIterator = this.h.iterator();
      while (localIterator.hasNext())
      {
        int i = ((Integer)localIterator.next()).intValue();
        adxf.a().oa(i);
      }
      this.h.clear();
    }
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aike
 * JD-Core Version:    0.7.0.1
 */