import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.smtt.sdk.QbSdk;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/webarticle/RIJWebArticleReportUtil$ReportR5Builder;", "", "()V", "r5", "Lorg/json/JSONObject;", "getR5", "()Lorg/json/JSONObject;", "addString", "key", "", "value", "build", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class udi
{
  @NotNull
  private final JSONObject a = new JSONObject();
  
  public udi()
  {
    JSONObject localJSONObject = this.a;
    if (udj.a.b())
    {
      localObject = "1";
      localJSONObject.put("param_webviewPoolReuse", localObject);
      localJSONObject = this.a;
      if (!udj.a.c()) {
        break label133;
      }
      localObject = "1";
      label57:
      localJSONObject.put("param_useVasSonic", localObject);
      localJSONObject = this.a;
      if (!udj.a.e()) {
        break label139;
      }
      localObject = "1";
      label82:
      localJSONObject.put("param_usePreload", localObject);
      localJSONObject = this.a;
      localObject = BaseApplicationImpl.sApplication;
      if (localObject == null) {
        break label145;
      }
      localObject = ((BaseApplicationImpl)localObject).getApplicationContext();
      label108:
      if (QbSdk.getTbsVersion((Context)localObject) == 0) {
        break label150;
      }
    }
    label133:
    label139:
    label145:
    label150:
    for (Object localObject = "1";; localObject = "0")
    {
      localJSONObject.put("param_isX5", localObject);
      return;
      localObject = "0";
      break;
      localObject = "0";
      break label57;
      localObject = "0";
      break label82;
      localObject = null;
      break label108;
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
  public final udi a(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "key");
    Intrinsics.checkParameterIsNotNull(paramString2, "value");
    this.a.put(paramString1, paramString2);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     udi
 * JD-Core Version:    0.7.0.1
 */