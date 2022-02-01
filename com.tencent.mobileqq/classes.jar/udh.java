import com.tencent.mobileqq.webview.sonic.SonicClientImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sonic.sdk.SonicSession;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/webarticle/RIJWebArticleReportUtil;", "", "()V", "KEY_PARAM_HIT_PRELOAD", "", "KEY_PARAM_IS_X5", "KEY_PARAM_USE_PRELOAD", "KEY_PARAM_VAS_SONIC", "KEY_PARAM_WEBVIEW_POOL_REUSE", "REPORT_ACTION_WEB_ARTICLE_COST", "TAG", "reportWebArticle", "", "actionName", "r5Builder", "Lcom/tencent/biz/pubaccount/readinjoy/webarticle/RIJWebArticleReportUtil$ReportR5Builder;", "reportWebArticleDetailCost", "reportMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "sonicClientImpl", "Lcom/tencent/mobileqq/webview/sonic/SonicClientImpl;", "ReportR5Builder", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class udh
{
  public static final udh a = new udh();
  
  public final void a(@NotNull String paramString, @NotNull udi paramudi)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "actionName");
    Intrinsics.checkParameterIsNotNull(paramudi, "r5Builder");
    QLog.i("RIJWebArticleReportUtil", 1, "[reportWebArticle] actionName = " + paramString + ", r5 = " + paramudi.a());
    olh.a(null, "", paramString, paramString, 0, 0, "", "", "", paramudi.a(), false);
  }
  
  public final void a(@NotNull HashMap<String, String> paramHashMap, @Nullable SonicClientImpl paramSonicClientImpl)
  {
    Intrinsics.checkParameterIsNotNull(paramHashMap, "reportMap");
    udi localudi = new udi();
    paramHashMap = ((Map)paramHashMap).entrySet().iterator();
    while (paramHashMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramHashMap.next();
      localudi.a((String)localEntry.getKey(), (String)localEntry.getValue());
    }
    if (paramSonicClientImpl != null)
    {
      paramHashMap = paramSonicClientImpl.getSession();
      if ((paramHashMap == null) || (paramHashMap.isPreload() != true)) {}
    }
    for (paramHashMap = "1";; paramHashMap = "0")
    {
      localudi.a("param_hitPreload", paramHashMap);
      a("0X800B4EF", localudi);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     udh
 * JD-Core Version:    0.7.0.1
 */