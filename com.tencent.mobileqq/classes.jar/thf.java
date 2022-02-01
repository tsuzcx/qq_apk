import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.bridge.NowLiveBridgeInvokeHandler.preload.1;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.bridge.NowLiveBridgeInvokeHandler.register.1;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.bridge.NowLiveBridgeInvokeHandler.register.2;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/viola/modules/bridge/NowLiveBridgeInvokeHandler;", "Lcom/tencent/biz/pubaccount/readinjoy/viola/modules/bridge/AbsBridgeInvokeHandler;", "module", "Lcom/tencent/biz/pubaccount/readinjoy/viola/modules/BridgeModule;", "(Lcom/tencent/biz/pubaccount/readinjoy/viola/modules/BridgeModule;)V", "nameSpace", "", "openRoom", "", "param", "Lorg/json/JSONObject;", "callback", "preload", "register", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class thf
  extends tgo
{
  public static final thg a = new thg(null);
  
  public thf(@NotNull BridgeModule paramBridgeModule)
  {
    super(paramBridgeModule);
  }
  
  private final void a(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject != null)
    {
      paramString = paramJSONObject.optString("params");
      Intrinsics.checkExpressionValueIsNotNull(paramString, "jsonObject.optString(\"params\")");
      paramJSONObject = new Bundle();
      paramJSONObject.putInt("jumpType", 1);
      paramJSONObject.putString("roomid", paramString);
      paramJSONObject.putString("fromid", "violaCall");
      if (QLog.isColorLevel()) {
        QLog.e(BridgeModule.TAG, 2, "nowlive openRoom  roomid = " + paramString);
      }
      paramString = BaseApplicationImpl.getApplication();
      Intrinsics.checkExpressionValueIsNotNull(paramString, "BaseApplicationImpl.getApplication()");
      paramString = paramString.getRuntime();
      if ((paramString instanceof QQAppInterface))
      {
        paramString = paramString.getManager(306);
        if (paramString == null) {
          throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.intervideo.now.dynamic.DynamicNowManager");
        }
        ((awcc)paramString).a(paramJSONObject);
      }
    }
  }
  
  private final void b(JSONObject paramJSONObject, String paramString)
  {
    ThreadManager.post((Runnable)NowLiveBridgeInvokeHandler.preload.1.a, 8, null, true);
  }
  
  @NotNull
  public String a()
  {
    return "nowlive";
  }
  
  public void a()
  {
    a("openRoom", (Function2)new NowLiveBridgeInvokeHandler.register.1((thf)this));
    a("preload", (Function2)new NowLiveBridgeInvokeHandler.register.2((thf)this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     thf
 * JD-Core Version:    0.7.0.1
 */