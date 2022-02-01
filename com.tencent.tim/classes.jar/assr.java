import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import android.content.Intent;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import cooperation.vip.pb.vac_adv_get.VacFeedsAdvMetaReq;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo;

@JsPlugin(secondary=true)
public class assr
  extends BaseJsPlugin
{
  private JSONObject a(RequestEvent paramRequestEvent)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      QLog.e("QQPublicAccountNativePlugin", 1, "Failed to parse jsonParams=" + paramRequestEvent.jsonParams);
    }
    return null;
  }
  
  @JsEvent({"qsubscribe_getdeviceinfo"})
  public void qsubscribeGetdeviceinfo(RequestEvent paramRequestEvent)
  {
    try
    {
      a(paramRequestEvent);
      Object localObject = new tlm.a();
      ((tlm.a)localObject).aJy = "1b0ad2";
      localObject = tlm.a(BaseApplication.getContext(), (tlm.a)localObject);
      if ((localObject != null) && (((tlm.b)localObject).b != null))
      {
        vac_adv_get.VacFeedsAdvMetaReq localVacFeedsAdvMetaReq = new vac_adv_get.VacFeedsAdvMetaReq();
        localVacFeedsAdvMetaReq.device_info.set(((tlm.b)localObject).b);
        localObject = Arrays.toString(localVacFeedsAdvMetaReq.toByteArray());
        new JSONObject().put("deviceinfo", localObject);
        paramRequestEvent.ok();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QQPublicAccountNativePlugin", 1, "Handle QQPublicAccountNativePlugin failed! ", localThrowable);
      paramRequestEvent.fail();
    }
  }
  
  @JsEvent({"qsubscribe_opendetail"})
  public void qsubscribeOpendetail(RequestEvent paramRequestEvent)
  {
    try
    {
      Object localObject = a(paramRequestEvent).optJSONObject("data");
      if (localObject != null)
      {
        String str1 = ((JSONObject)localObject).optString("uin");
        int i = ((JSONObject)localObject).optInt("type");
        String str2 = ((JSONObject)localObject).optString("feedid");
        long l = ((JSONObject)localObject).optLong("createtime");
        localObject = rzd.a(str2, str1, i, ((JSONObject)localObject).optInt("width"), ((JSONObject)localObject).optInt("height"), l);
        rzd.a(this.mMiniAppContext.getAttachedActivity(), (CertifiedAccountMeta.StFeed)localObject, 9001);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QQPublicAccountNativePlugin", 1, "Handle QQPublicAccountNativePlugin failed! ", localThrowable);
      paramRequestEvent.fail();
    }
  }
  
  @JsEvent({"qsubscribe_opendiscover"})
  public void qsubscribeOpendiscover(RequestEvent paramRequestEvent)
  {
    boolean bool = false;
    try
    {
      Object localObject = a(paramRequestEvent).optJSONObject("data");
      if (localObject != null)
      {
        String str = ((JSONObject)localObject).optString("uin");
        int i = ((JSONObject)localObject).optInt("shoptype");
        localObject = new Intent();
        ((Intent)localObject).putExtra("postUin", str);
        ((Intent)localObject).putExtra("sourceFrom", 1);
        if (i > 1) {
          bool = true;
        }
        ((Intent)localObject).putExtra("has_shop", bool);
        ((Intent)localObject).addFlags(268435456);
        avpw.i(this.mMiniAppContext.getAttachedActivity(), (Intent)localObject, 0);
        paramRequestEvent.ok();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QQPublicAccountNativePlugin", 1, "Handle QQPublicAccountNativePlugin failed! ", localThrowable);
      paramRequestEvent.fail();
    }
  }
  
  @JsEvent({"qsubscribe_openhomepage"})
  public void qsubscribeOpenhomepage(RequestEvent paramRequestEvent)
  {
    try
    {
      Object localObject = a(paramRequestEvent).optJSONObject("data");
      if (localObject != null)
      {
        localObject = ((JSONObject)localObject).optString("uin");
        rzd.i(this.mMiniAppContext.getAttachedActivity(), (String)localObject, 9001);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QQPublicAccountNativePlugin", 1, "Handle QQPublicAccountNativePlugin failed! ", localThrowable);
      paramRequestEvent.fail();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     assr
 * JD-Core Version:    0.7.0.1
 */