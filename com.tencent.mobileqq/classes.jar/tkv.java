import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/viola/modules/bridge/BridgeInvokeHandler;", "", "bridgeModule", "Lcom/tencent/biz/pubaccount/readinjoy/viola/modules/BridgeModule;", "(Lcom/tencent/biz/pubaccount/readinjoy/viola/modules/BridgeModule;)V", "nsHandlerList", "Ljava/util/ArrayList;", "Lcom/tencent/biz/pubaccount/readinjoy/viola/modules/bridge/AbsBridgeInvokeHandler;", "Lkotlin/collections/ArrayList;", "invoke", "", "ns", "", "method", "jsonObject", "Lorg/json/JSONObject;", "callback", "nonStandardFormat", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class tkv
{
  private final ArrayList<tks> a = new ArrayList(16);
  
  public tkv(@NotNull BridgeModule paramBridgeModule)
  {
    ArrayList localArrayList = this.a;
    localArrayList.add(new tlq(paramBridgeModule));
    localArrayList.add(new tkw(paramBridgeModule));
    localArrayList.add(new tlw(paramBridgeModule));
    localArrayList.add(new tkt(paramBridgeModule));
    localArrayList.add(new tla(paramBridgeModule));
    localArrayList.add(new tky(paramBridgeModule));
    localArrayList.add(new tlg(paramBridgeModule));
    localArrayList.add(new tlk(paramBridgeModule));
    localArrayList.add(new tlc(paramBridgeModule));
    localArrayList.add(new tls(paramBridgeModule));
    localArrayList.add(new tle(paramBridgeModule));
    localArrayList.add(new tli(paramBridgeModule));
    localArrayList.add(new tlm(paramBridgeModule));
    localArrayList.add(new tlu(paramBridgeModule));
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
      tks localtks;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localtks = (tks)localIterator.next();
      } while (!localtks.a(paramString1));
      return localtks.a(paramString2, paramJSONObject, paramString3);
      paramJSONObject = paramJSONObject.optJSONObject("params");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tkv
 * JD-Core Version:    0.7.0.1
 */