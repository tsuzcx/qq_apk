import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.bridge.DebugBridgeInvokeHandler.register.1;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/viola/modules/bridge/DebugBridgeInvokeHandler;", "Lcom/tencent/biz/pubaccount/readinjoy/viola/modules/bridge/AbsBridgeInvokeHandler;", "module", "Lcom/tencent/biz/pubaccount/readinjoy/viola/modules/BridgeModule;", "(Lcom/tencent/biz/pubaccount/readinjoy/viola/modules/BridgeModule;)V", "nameSpace", "", "register", "", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class tym
  extends tyg
{
  public static final tyn a = new tyn(null);
  
  public tym(@NotNull BridgeModule paramBridgeModule)
  {
    super(paramBridgeModule);
  }
  
  @NotNull
  public String a()
  {
    return "debug";
  }
  
  public void a()
  {
    a("detailLog", (Function2)new DebugBridgeInvokeHandler.register.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tym
 * JD-Core Version:    0.7.0.1
 */