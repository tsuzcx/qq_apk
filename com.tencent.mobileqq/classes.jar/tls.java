import android.app.Activity;
import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.bridge.SchemaBridgeInvokeHandler.register.1;
import com.tencent.mobileqq.app.QQAppInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/viola/modules/bridge/SchemaBridgeInvokeHandler;", "Lcom/tencent/biz/pubaccount/readinjoy/viola/modules/bridge/AbsBridgeInvokeHandler;", "module", "Lcom/tencent/biz/pubaccount/readinjoy/viola/modules/BridgeModule;", "(Lcom/tencent/biz/pubaccount/readinjoy/viola/modules/BridgeModule;)V", "jumpAction", "", "params", "Lorg/json/JSONObject;", "callBackId", "", "nameSpace", "register", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class tls
  extends tks
{
  public static final tlt a = new tlt(null);
  
  public tls(@NotNull BridgeModule paramBridgeModule)
  {
    super(paramBridgeModule);
  }
  
  private final void a(JSONObject paramJSONObject, String paramString)
  {
    Object localObject = null;
    if (paramJSONObject == null)
    {
      a(paramString, "params is null");
      return;
    }
    if (!paramJSONObject.has("schema"))
    {
      a(paramString, "schema is null");
      return;
    }
    Activity localActivity = a();
    AppRuntime localAppRuntime = pay.a();
    if (!(localAppRuntime instanceof QQAppInterface)) {}
    for (;;)
    {
      for (;;)
      {
        localObject = (QQAppInterface)localObject;
        if ((localActivity != null) && (localObject != null)) {
          try
          {
            paramJSONObject = paramJSONObject.getString("schema");
            paramJSONObject = bfwg.a((QQAppInterface)localObject, (Context)localActivity, paramJSONObject);
            if (paramJSONObject == null) {
              break;
            }
            paramJSONObject.b("viola");
            paramJSONObject.a();
            a(paramString, null);
            return;
          }
          catch (JSONException paramJSONObject)
          {
            paramJSONObject.printStackTrace();
            return;
          }
        }
      }
      a(paramString, "activity or app is null");
      return;
      localObject = localAppRuntime;
    }
  }
  
  @NotNull
  public String a()
  {
    return "schema";
  }
  
  public void a()
  {
    a("jumpAction", (Function2)new SchemaBridgeInvokeHandler.register.1((tls)this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tls
 * JD-Core Version:    0.7.0.1
 */