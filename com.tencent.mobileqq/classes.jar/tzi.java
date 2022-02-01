import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.bridge.SensorBridgeInvokeHandler.register.1;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/viola/modules/bridge/SensorBridgeInvokeHandler;", "Lcom/tencent/biz/pubaccount/readinjoy/viola/modules/bridge/AbsBridgeInvokeHandler;", "module", "Lcom/tencent/biz/pubaccount/readinjoy/viola/modules/BridgeModule;", "(Lcom/tencent/biz/pubaccount/readinjoy/viola/modules/BridgeModule;)V", "nameSpace", "", "register", "", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class tzi
  extends tyg
{
  public static final tzj a = new tzj(null);
  
  public tzi(@NotNull BridgeModule paramBridgeModule)
  {
    super(paramBridgeModule);
  }
  
  @NotNull
  public String a()
  {
    return "sensor";
  }
  
  public void a()
  {
    a("getLocation", (Function2)new SensorBridgeInvokeHandler.register.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tzi
 * JD-Core Version:    0.7.0.1
 */