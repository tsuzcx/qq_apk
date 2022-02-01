import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import java.util.HashSet;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin(secondary=true)
public class astf
  extends BaseJsPlugin
  implements awos
{
  SparseArray<RequestEvent> callbackMap = new SparseArray();
  private int seq;
  
  public astf()
  {
    awot.a().a(this);
  }
  
  private JSONObject a(RequestEvent paramRequestEvent)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      QLog.e("WebSsoJsPlugin", 1, "Failed to parse jsonParams=" + paramRequestEvent.jsonParams);
    }
    return null;
  }
  
  private int genSeq()
  {
    try
    {
      int i = this.seq;
      this.seq = (i + 1);
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public HashSet<String> getFilterCmds()
  {
    asbv localasbv = (asbv)asbw.a().w("comminfo");
    if (localasbv != null) {
      return localasbv.i();
    }
    return awot.bU;
  }
  
  public void onCmdRsp(Intent paramIntent, String paramString, long paramLong, JSONObject paramJSONObject)
  {
    int i;
    if (paramIntent != null)
    {
      i = paramIntent.getIntExtra("mini_seq", -1);
      if (i != -1) {
        break label26;
      }
    }
    label26:
    RequestEvent localRequestEvent;
    do
    {
      return;
      i = -1;
      break;
      localRequestEvent = (RequestEvent)this.callbackMap.get(i);
      this.callbackMap.remove(i);
    } while (localRequestEvent == null);
    paramIntent = paramJSONObject;
    if (paramJSONObject == null) {
      paramIntent = new JSONObject();
    }
    paramJSONObject = new JSONObject();
    try
    {
      paramJSONObject.put("cmd", paramString);
      paramJSONObject.put("ret", paramLong);
      paramJSONObject.put("rsp", paramIntent);
      if (paramLong == 0L)
      {
        localRequestEvent.ok(paramJSONObject);
        return;
      }
    }
    catch (JSONException paramIntent)
    {
      for (;;)
      {
        paramIntent.printStackTrace();
      }
      localRequestEvent.fail(paramJSONObject, "");
    }
  }
  
  @JsEvent({"requestWebSSO"})
  public void requestWebSSO(RequestEvent paramRequestEvent)
  {
    try
    {
      JSONObject localJSONObject = a(paramRequestEvent).getJSONObject("data");
      String str = localJSONObject.getString("webssoCmdId");
      localJSONObject = localJSONObject.getJSONObject("webssoReq");
      Object localObject = getFilterCmds();
      if ((TextUtils.isEmpty(str)) || (localObject == null) || (!((HashSet)localObject).contains(str)))
      {
        paramRequestEvent.fail(acfp.m(2131716904));
        return;
      }
      int i = genSeq();
      this.callbackMap.put(i, paramRequestEvent);
      localObject = new Bundle();
      ((Bundle)localObject).putInt("mini_seq", i);
      awot.a().a(str, localJSONObject, (Bundle)localObject);
      return;
    }
    catch (Throwable localThrowable)
    {
      paramRequestEvent.fail(acfp.m(2131716903));
      if (QLog.isColorLevel()) {
        QLog.w("WebSsoJsPlugin", 2, "requestWebSSO,decode param error");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     astf
 * JD-Core Version:    0.7.0.1
 */