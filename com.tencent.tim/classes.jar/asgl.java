import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.ToolRuntimePeak;
import com.tencent.qg.sdk.invoke.BaseJsModule;
import com.tencent.qg.sdk.invoke.InvokeCallback;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONObject;

public class asgl
  extends BaseJsModule
{
  private asgl.a a;
  private WeakReference<AppInterface> n;
  
  public asgl()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof ToolRuntimePeak)) {
      this.n = new WeakReference((AppInterface)((ToolRuntimePeak)localAppRuntime).getAppRuntime("peak"));
    }
  }
  
  public void a(asgl.a parama)
  {
    this.a = parama;
  }
  
  public String getModuleName()
  {
    return "textEffect";
  }
  
  public boolean handleJsRequest(String paramString, JSONObject paramJSONObject, InvokeCallback paramInvokeCallback)
  {
    ram.d("TextEffectModule", "handleJsRequest method = " + paramString);
    try
    {
      if ("wordSplit".equals(paramString))
      {
        if (paramJSONObject == null)
        {
          paramInvokeCallback.exec(4);
          return false;
        }
        JSONArray localJSONArray = new JSONArray();
        paramJSONObject = paramJSONObject.optString("text");
        if (TextUtils.isEmpty(paramJSONObject))
        {
          paramInvokeCallback.exec(0, "success", localJSONArray);
          return true;
        }
        paramJSONObject = adpo.a((AppInterface)this.n.get(), paramJSONObject);
        if (!paramJSONObject.success)
        {
          paramInvokeCallback.exec(-1, "sdk init failed! soLoaded.");
          return false;
        }
        if (paramJSONObject.es != null)
        {
          paramJSONObject = paramJSONObject.es;
          int j = paramJSONObject.length;
          int i = 0;
          while (i < j)
          {
            localJSONArray.put(paramJSONObject[i]);
            i += 1;
          }
        }
        paramInvokeCallback.exec(0, "success", localJSONArray);
        return true;
      }
      if ("getTextConfig".equals(paramString))
      {
        paramJSONObject = ((axpr)axov.a(5)).a.auB;
        if (!TextUtils.isEmpty(paramJSONObject)) {
          paramInvokeCallback.exec(0, "success", new JSONObject(paramJSONObject));
        }
        while (this.a != null)
        {
          this.a.enh();
          break;
          paramInvokeCallback.exec(-1, "text config is empty!");
        }
      }
      return false;
    }
    catch (Exception paramJSONObject)
    {
      QLog.e("TextEffectModule", 1, "handle method " + paramString + "failed", paramJSONObject);
    }
    return true;
  }
  
  public static abstract interface a
  {
    public abstract void enh();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asgl
 * JD-Core Version:    0.7.0.1
 */