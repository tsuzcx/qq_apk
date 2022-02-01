import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class uay
  implements tzd
{
  private WeakReference<CustomWebView> an;
  private String callbackId;
  
  public uay(CustomWebView paramCustomWebView, JSONObject paramJSONObject)
  {
    this.an = new WeakReference(paramCustomWebView);
    this.callbackId = paramJSONObject.optString("__nativeAPICallID__");
  }
  
  public void onComplete()
  {
    if (!TextUtils.isEmpty(this.callbackId))
    {
      CustomWebView localCustomWebView = (CustomWebView)this.an.get();
      if (localCustomWebView != null) {
        localCustomWebView.callJs("(window.NativeApi && NativeApi.execNativeAPICallback).apply(window, ['" + this.callbackId + "', 4]);");
      }
    }
  }
  
  public void onFailure(int paramInt, String paramString)
  {
    if (!TextUtils.isEmpty(this.callbackId))
    {
      CustomWebView localCustomWebView = (CustomWebView)this.an.get();
      if (localCustomWebView != null) {
        localCustomWebView.callJs("(window.NativeApi && NativeApi.execNativeAPICallback).apply(window, ['" + this.callbackId + "', 3, " + paramInt + ", '" + paramString + "']);");
      }
    }
  }
  
  public void onPermission(int paramInt)
  {
    if (!TextUtils.isEmpty(this.callbackId))
    {
      CustomWebView localCustomWebView = (CustomWebView)this.an.get();
      if (localCustomWebView != null) {
        localCustomWebView.callJs("(window.NativeApi && NativeApi.execNativeAPICallback).apply(window, ['" + this.callbackId + "', 1, " + paramInt + "]);");
      }
    }
  }
  
  public void onSuccess(JSONObject paramJSONObject)
  {
    if (!TextUtils.isEmpty(this.callbackId))
    {
      CustomWebView localCustomWebView = (CustomWebView)this.an.get();
      if (localCustomWebView != null) {
        localCustomWebView.callJs("(window.NativeApi && NativeApi.execNativeAPICallback).apply(window, ['" + this.callbackId + "', 2, " + paramJSONObject.toString() + "]);");
      }
    }
  }
  
  public void onTrigger(JSONObject paramJSONObject)
  {
    if (!TextUtils.isEmpty(this.callbackId))
    {
      CustomWebView localCustomWebView = (CustomWebView)this.an.get();
      if (localCustomWebView != null) {
        localCustomWebView.callJs("(window.NativeApi && NativeApi.execNativeAPICallback).apply(window, ['" + this.callbackId + "', 5, " + paramJSONObject.toString() + "]);");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uay
 * JD-Core Version:    0.7.0.1
 */