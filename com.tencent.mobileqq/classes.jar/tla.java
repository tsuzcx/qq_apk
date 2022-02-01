import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.bridge.DeviceBridgeInvokeHandler.register.1;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.bridge.DeviceBridgeInvokeHandler.register.2;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.bridge.DeviceBridgeInvokeHandler.register.3;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.bridge.DeviceBridgeInvokeHandler.register.4;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.bridge.DeviceBridgeInvokeHandler.register.5;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.bridge.DeviceBridgeInvokeHandler.register.6;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.bridge.DeviceBridgeInvokeHandler.register.7;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.bridge.DeviceBridgeInvokeHandler.register.8;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.bridge.DeviceBridgeInvokeHandler.register.9;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/viola/modules/bridge/DeviceBridgeInvokeHandler;", "Lcom/tencent/biz/pubaccount/readinjoy/viola/modules/bridge/AbsBridgeInvokeHandler;", "module", "Lcom/tencent/biz/pubaccount/readinjoy/viola/modules/BridgeModule;", "(Lcom/tencent/biz/pubaccount/readinjoy/viola/modules/BridgeModule;)V", "nameSpace", "", "register", "", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class tla
  extends tks
{
  public static final tlb a = new tlb(null);
  
  public tla(@NotNull BridgeModule paramBridgeModule)
  {
    super(paramBridgeModule);
  }
  
  @NotNull
  public String a()
  {
    return "device";
  }
  
  public void a()
  {
    a("getDeviceInfo", (Function2)new DeviceBridgeInvokeHandler.register.1(this));
    a("getNetworkInfo", (Function2)new DeviceBridgeInvokeHandler.register.2(this));
    a("getNetType", (Function2)new DeviceBridgeInvokeHandler.register.3(this));
    a("getClientInfo", (Function2)new DeviceBridgeInvokeHandler.register.4(this));
    a("getCUKingStatus", (Function2)new DeviceBridgeInvokeHandler.register.5(this));
    a("getGdtInfo", (Function2)new DeviceBridgeInvokeHandler.register.6(this));
    a("getRecommendFlag", (Function2)new DeviceBridgeInvokeHandler.register.7(this));
    a("isMobileQQ", (Function2)new DeviceBridgeInvokeHandler.register.8(this));
    a("getNetworkType", (Function2)new DeviceBridgeInvokeHandler.register.9(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tla
 * JD-Core Version:    0.7.0.1
 */