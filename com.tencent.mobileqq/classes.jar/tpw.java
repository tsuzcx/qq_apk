import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/viola/modules/bridge/BridgeInvokeHandler;", "", "bridgeModule", "Lcom/tencent/biz/pubaccount/readinjoy/viola/modules/BridgeModule;", "(Lcom/tencent/biz/pubaccount/readinjoy/viola/modules/BridgeModule;)V", "nsHandlerList", "Ljava/util/ArrayList;", "Lcom/tencent/biz/pubaccount/readinjoy/viola/modules/bridge/AbsBridgeInvokeHandler;", "Lkotlin/collections/ArrayList;", "invoke", "", "ns", "", "method", "jsonObject", "Lorg/json/JSONObject;", "callback", "nonStandardFormat", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class tpw
{
  private final ArrayList<tpt> a = new ArrayList(16);
  
  public tpw(@NotNull BridgeModule paramBridgeModule)
  {
    ArrayList localArrayList = this.a;
    localArrayList.add(new tqr(paramBridgeModule));
    localArrayList.add(new tpx(paramBridgeModule));
    localArrayList.add(new tqx(paramBridgeModule));
    localArrayList.add(new tpu(paramBridgeModule));
    localArrayList.add(new tqb(paramBridgeModule));
    localArrayList.add(new tpz(paramBridgeModule));
    localArrayList.add(new tqh(paramBridgeModule));
    localArrayList.add(new tql(paramBridgeModule));
    localArrayList.add(new tqd(paramBridgeModule));
    localArrayList.add(new tqt(paramBridgeModule));
    localArrayList.add(new tqf(paramBridgeModule));
    localArrayList.add(new tqj(paramBridgeModule));
    localArrayList.add(new tqn(paramBridgeModule));
    localArrayList.add(new tqv(paramBridgeModule));
  }
  
  private final boolean a(String paramString1, String paramString2)
  {
    return (("downloadApp".equals(paramString2)) && ("app".equals(paramString1))) || (("openRoom".equals(paramString2)) && ("nowlive".equals(paramString1)));
  }
  
  public final boolean a(@NotNull String paramString1, @NotNull String paramString2, @NotNull JSONObject paramJSONObject, @Nullable String paramString3)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "ns");
    Intrinsics.checkParameterIsNotNull(paramString2, "method");
    Intrinsics.checkParameterIsNotNull(paramJSONObject, "jsonObject");
    if (a(paramString1, paramString2)) {}
    for (;;)
    {
      Iterator localIterator = this.a.iterator();
      tpt localtpt;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localtpt = (tpt)localIterator.next();
      } while (!localtpt.a(paramString1));
      return localtpt.a(paramString2, paramJSONObject, paramString3);
      paramJSONObject = paramJSONObject.optJSONObject("params");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tpw
 * JD-Core Version:    0.7.0.1
 */