import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.bridge.OfflineBridgeInvokeHandler.register.1;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.bridge.OfflineBridgeInvokeHandler.register.2;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.bridge.OfflineBridgeInvokeHandler.register.3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/viola/modules/bridge/OfflineBridgeInvokeHandler;", "Lcom/tencent/biz/pubaccount/readinjoy/viola/modules/bridge/AbsBridgeInvokeHandler;", "module", "Lcom/tencent/biz/pubaccount/readinjoy/viola/modules/BridgeModule;", "(Lcom/tencent/biz/pubaccount/readinjoy/viola/modules/BridgeModule;)V", "nameSpace", "", "register", "", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class tlk
  extends tks
{
  public static final tll a = new tll(null);
  
  public tlk(@NotNull BridgeModule paramBridgeModule)
  {
    super(paramBridgeModule);
  }
  
  @NotNull
  public String a()
  {
    return "offline";
  }
  
  public void a()
  {
    a("updateIfNeed", (Function2)new OfflineBridgeInvokeHandler.register.1(this));
    a("batchCheckUpdate", (Function2)new OfflineBridgeInvokeHandler.register.2(this));
    a("isCached", (Function2)new OfflineBridgeInvokeHandler.register.3(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tlk
 * JD-Core Version:    0.7.0.1
 */