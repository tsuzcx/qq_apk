import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.bridge.PublicAccountNewBridgeInvokeHandler.register.1;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.bridge.PublicAccountNewBridgeInvokeHandler.register.2;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.bridge.PublicAccountNewBridgeInvokeHandler.register.3;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/viola/modules/bridge/PublicAccountNewBridgeInvokeHandler;", "Lcom/tencent/biz/pubaccount/readinjoy/viola/modules/bridge/AbsBridgeInvokeHandler;", "module", "Lcom/tencent/biz/pubaccount/readinjoy/viola/modules/BridgeModule;", "(Lcom/tencent/biz/pubaccount/readinjoy/viola/modules/BridgeModule;)V", "getRIJAppType", "", "param", "Lorg/json/JSONObject;", "callbackId", "", "getUserInfo", "nameSpace", "register", "showReadInJoyNativeCommentView", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class tqn
  extends tpt
{
  public static final tqo a = new tqo(null);
  
  public tqn(@NotNull BridgeModule paramBridgeModule)
  {
    super(paramBridgeModule);
  }
  
  private final void a(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject != null) {
      if (!TextUtils.isEmpty((CharSequence)paramJSONObject.optString("callback"))) {
        break label39;
      }
    }
    label39:
    for (String str = paramString;; str = paramJSONObject.optString("callback"))
    {
      tym.a(paramJSONObject, str, (tol)new tqq(this, paramString));
      return;
    }
  }
  
  private final void b(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject != null)
    {
      QLog.d("PublicAccountNewBridgeInvokeHandler", 1, "call getRIJAppType");
      if (!TextUtils.isEmpty((CharSequence)paramJSONObject.optString("callback"))) {
        break label93;
      }
    }
    try
    {
      for (;;)
      {
        paramJSONObject = new JSONObject().put("app_type", ube.c()).toString();
        Intrinsics.checkExpressionValueIsNotNull(paramJSONObject, "JSONObject().put(\"app_ty…portAppType()).toString()");
        QLog.d("PublicAccountNewBridgeInvokeHandler", 1, "callback: " + paramString + "result: " + paramJSONObject);
        a(paramString, paramJSONObject);
        return;
        label93:
        paramString = paramJSONObject.optString("callback");
      }
    }
    catch (JSONException paramJSONObject)
    {
      for (;;)
      {
        QLog.e("PublicAccountNewBridgeInvokeHandler", 1, paramJSONObject.getMessage());
      }
    }
  }
  
  private final void c(JSONObject paramJSONObject, String paramString)
  {
    String str;
    if (paramJSONObject != null)
    {
      QLog.d("PublicAccountNewBridgeInvokeHandler", 1, "call getUserInfo");
      if (!TextUtils.isEmpty((CharSequence)paramJSONObject.optString("callback"))) {
        break label59;
      }
      str = paramString;
    }
    try
    {
      for (;;)
      {
        ReadInJoyUserInfoModule.a(Long.parseLong(paramJSONObject.opt("uin").toString()), (pyb)new tqp(str, this, paramString));
        return;
        label59:
        str = paramJSONObject.optString("callback");
      }
    }
    catch (Exception paramJSONObject)
    {
      for (;;)
      {
        QLog.e("PublicAccountNewBridgeInvokeHandler", 1, paramJSONObject.getMessage());
        a(str, tym.a(paramJSONObject.getMessage()));
      }
    }
  }
  
  @NotNull
  public String a()
  {
    return "publicAccountNew";
  }
  
  public void a()
  {
    a("showReadInJoyNativeCommentView", (Function2)new PublicAccountNewBridgeInvokeHandler.register.1((tqn)this));
    a("getRIJAppType", (Function2)new PublicAccountNewBridgeInvokeHandler.register.2((tqn)this));
    a("getUserInfo", (Function2)new PublicAccountNewBridgeInvokeHandler.register.3((tqn)this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tqn
 * JD-Core Version:    0.7.0.1
 */