import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/webarticle/RIJWebArticleReportUtil;", "", "()V", "KEY_PARAM_VAS_SONIC", "", "KEY_PARAM_WEBVIEW_POOL_REUSE", "REPORT_ACTION_WEB_ARTICLE_COST", "TAG", "reportWebArticle", "", "actionName", "r5Builder", "Lcom/tencent/biz/pubaccount/readinjoy/webarticle/RIJWebArticleReportUtil$ReportR5Builder;", "reportWebArticleDetailCost", "reportMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "ReportR5Builder", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class tpp
{
  public static final tpp a = new tpp();
  
  public final void a(@NotNull String paramString, @NotNull tpq paramtpq)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "actionName");
    Intrinsics.checkParameterIsNotNull(paramtpq, "r5Builder");
    QLog.i("RIJWebArticleReportUtil", 1, "[reportWebArticle] actionName = " + paramString + ", r5 = " + paramtpq.a());
    odq.a(null, "", paramString, paramString, 0, 0, "", "", "", paramtpq.a(), false);
  }
  
  public final void a(@NotNull HashMap<String, String> paramHashMap)
  {
    Intrinsics.checkParameterIsNotNull(paramHashMap, "reportMap");
    tpq localtpq = new tpq();
    paramHashMap = ((Map)paramHashMap).entrySet().iterator();
    while (paramHashMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramHashMap.next();
      localtpq.a((String)localEntry.getKey(), (String)localEntry.getValue());
    }
    a("0X800B4EF", localtpq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tpp
 * JD-Core Version:    0.7.0.1
 */