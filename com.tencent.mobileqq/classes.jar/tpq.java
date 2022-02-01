import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/webarticle/RIJWebArticleReportUtil$ReportR5Builder;", "", "()V", "r5", "Lorg/json/JSONObject;", "getR5", "()Lorg/json/JSONObject;", "addString", "key", "", "value", "build", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class tpq
{
  @NotNull
  private final JSONObject a = new JSONObject();
  
  public tpq()
  {
    JSONObject localJSONObject = this.a;
    if (tpr.a.b())
    {
      str = "1";
      localJSONObject.put("param_webviewPoolReuse", str);
      localJSONObject = this.a;
      if (!tpr.a.c()) {
        break label72;
      }
    }
    label72:
    for (String str = "1";; str = "0")
    {
      localJSONObject.put("param_useVasSonic", str);
      return;
      str = "0";
      break;
    }
  }
  
  @NotNull
  public final String a()
  {
    String str = this.a.toString();
    Intrinsics.checkExpressionValueIsNotNull(str, "r5.toString()");
    return str;
  }
  
  @NotNull
  public final tpq a(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "key");
    Intrinsics.checkParameterIsNotNull(paramString2, "value");
    this.a.put(paramString1, paramString2);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tpq
 * JD-Core Version:    0.7.0.1
 */