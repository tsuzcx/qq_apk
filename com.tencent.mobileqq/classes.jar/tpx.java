import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.bridge.DataBridgeInvokeHandler.isFollowUin..inlined.also.lambda.1;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.bridge.DataBridgeInvokeHandler.register.1;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.bridge.DataBridgeInvokeHandler.register.2;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.bridge.DataBridgeInvokeHandler.register.3;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.bridge.DataBridgeInvokeHandler.register.4;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.bridge.DataBridgeInvokeHandler.register.5;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.bridge.DataBridgeInvokeHandler.register.6;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.bridge.DataBridgeInvokeHandler.register.7;
import com.tencent.mobileqq.app.ThreadManagerV2;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/viola/modules/bridge/DataBridgeInvokeHandler;", "Lcom/tencent/biz/pubaccount/readinjoy/viola/modules/bridge/AbsBridgeInvokeHandler;", "module", "Lcom/tencent/biz/pubaccount/readinjoy/viola/modules/BridgeModule;", "(Lcom/tencent/biz/pubaccount/readinjoy/viola/modules/BridgeModule;)V", "followUin", "", "params", "Lorg/json/JSONObject;", "callback", "", "invokeJs", "isFollow", "", "isFollowUin", "nameSpace", "register", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class tpx
  extends tpt
{
  public static final tpy a = new tpy(null);
  
  public tpx(@NotNull BridgeModule paramBridgeModule)
  {
    super(paramBridgeModule);
  }
  
  private final void a(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject != null)
    {
      paramJSONObject = paramJSONObject.optString("uin");
      if (paramJSONObject != null) {
        ThreadManagerV2.excute((Runnable)new DataBridgeInvokeHandler.isFollowUin..inlined.also.lambda.1(paramJSONObject, this, paramString), 16, null, true);
      }
    }
  }
  
  private final void a(boolean paramBoolean, String paramString)
  {
    JSONObject localJSONObject = new JSONObject().put("follow", paramBoolean);
    a(paramString, new JSONObject().put("response", localJSONObject).put("ret", 0));
  }
  
  private final void b(JSONObject paramJSONObject, String paramString)
  {
    boolean bool = true;
    String str;
    if (paramJSONObject != null)
    {
      str = paramJSONObject.optString("uin");
      if (str != null) {
        if (paramJSONObject.optInt("isUgc") != 1) {
          break label46;
        }
      }
    }
    for (;;)
    {
      ryx.a(pha.a(), str, bool, false);
      a(paramString, null);
      return;
      label46:
      bool = false;
    }
  }
  
  @NotNull
  public String a()
  {
    return "data";
  }
  
  public void a()
  {
    a("ssoRequest", (Function2)new DataBridgeInvokeHandler.register.1(this));
    a("getUserInfo", (Function2)new DataBridgeInvokeHandler.register.2(this));
    a("setClipboard", (Function2)new DataBridgeInvokeHandler.register.3(this));
    a("getClipboard", (Function2)new DataBridgeInvokeHandler.register.4(this));
    a("getPerformance", (Function2)new DataBridgeInvokeHandler.register.5(this));
    a("isFollowUin", (Function2)new DataBridgeInvokeHandler.register.6((tpx)this));
    a("followUin", (Function2)new DataBridgeInvokeHandler.register.7((tpx)this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tpx
 * JD-Core Version:    0.7.0.1
 */