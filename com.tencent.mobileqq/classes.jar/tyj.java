import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/viola/modules/bridge/BridgeInvokeHandler;", "", "bridgeModule", "Lcom/tencent/biz/pubaccount/readinjoy/viola/modules/BridgeModule;", "(Lcom/tencent/biz/pubaccount/readinjoy/viola/modules/BridgeModule;)V", "nsHandlerList", "Ljava/util/ArrayList;", "Lcom/tencent/biz/pubaccount/readinjoy/viola/modules/bridge/AbsBridgeInvokeHandler;", "Lkotlin/collections/ArrayList;", "invoke", "", "ns", "", "method", "jsonObject", "Lorg/json/JSONObject;", "callback", "nonStandardFormat", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class tyj
{
  private final ArrayList<tyg> a = new ArrayList(16);
  
  public tyj(@NotNull BridgeModule paramBridgeModule)
  {
    ArrayList localArrayList = this.a;
    localArrayList.add(new tze(paramBridgeModule));
    localArrayList.add(new tyk(paramBridgeModule));
    localArrayList.add(new tzk(paramBridgeModule));
    localArrayList.add(new tyh(paramBridgeModule));
    localArrayList.add(new tyo(paramBridgeModule));
    localArrayList.add(new tym(paramBridgeModule));
    localArrayList.add(new tyu(paramBridgeModule));
    localArrayList.add(new tyy(paramBridgeModule));
    localArrayList.add(new tyq(paramBridgeModule));
    localArrayList.add(new tzg(paramBridgeModule));
    localArrayList.add(new tys(paramBridgeModule));
    localArrayList.add(new tyw(paramBridgeModule));
    localArrayList.add(new tza(paramBridgeModule));
    localArrayList.add(new tzi(paramBridgeModule));
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
      tyg localtyg;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localtyg = (tyg)localIterator.next();
      } while (!localtyg.a(paramString1));
      return localtyg.a(paramString2, paramJSONObject, paramString3);
      paramJSONObject = paramJSONObject.optJSONObject("params");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tyj
 * JD-Core Version:    0.7.0.1
 */