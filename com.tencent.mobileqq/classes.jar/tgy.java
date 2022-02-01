import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.pts.core.PTSComposer;
import com.tencent.pts.core.lite.DefaultPTSLiteEventListener;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/item/PtsItemViewEventListener;", "Lcom/tencent/pts/core/lite/DefaultPTSLiteEventListener;", "()V", "addR5CommonParams", "", "r5Builder", "Lcom/tencent/biz/pubaccount/readinjoy/decoupling/uilayer/framewrok/report/RIJTransMergeKanDianReport$ReportR5Builder;", "articleInfo", "Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;", "onExposureTriggered", "id", "", "dataSet", "Ljava/util/HashMap;", "view", "Landroid/view/View;", "ptsComposer", "Lcom/tencent/pts/core/PTSComposer;", "onTapEventTriggered", "reportWithCommonParams", "reportName", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class tgy
  extends DefaultPTSLiteEventListener
{
  public static final tgz a = new tgz(null);
  
  private final void a(String paramString, pqg parampqg)
  {
    String str1 = null;
    Object localObject1 = BaseActivity.sTopActivity;
    QQAppInterface localQQAppInterface;
    String str2;
    Object localObject2;
    label54:
    label66:
    Object localObject3;
    if ((localObject1 instanceof FastWebActivity))
    {
      localObject1 = ((FastWebActivity)localObject1).a;
      a(parampqg, (BaseArticleInfo)localObject1);
      localQQAppInterface = pnn.a();
      str2 = pkh.a();
      if (localObject1 == null) {
        break label142;
      }
      localObject2 = Long.valueOf(((ArticleInfo)localObject1).mArticleID);
      localObject2 = String.valueOf(localObject2);
      if (localObject2 == null) {
        break label148;
      }
      if (localObject1 == null) {
        break label155;
      }
      localObject3 = Integer.valueOf(((ArticleInfo)localObject1).mStrategyId);
      label79:
      localObject3 = String.valueOf(localObject3);
      if (localObject3 == null) {
        break label161;
      }
      label91:
      if (localObject1 != null) {
        str1 = ((ArticleInfo)localObject1).innerUniqueID;
      }
      localObject1 = String.valueOf(str1);
      if (localObject1 == null) {
        break label168;
      }
    }
    for (;;)
    {
      olh.a(localQQAppInterface, "P_CliOper", "Pb_account_lifeservice", str2, paramString, paramString, 0, 0, (String)localObject2, (String)localObject3, (String)localObject1, parampqg.a(), false);
      return;
      localObject1 = null;
      break;
      label142:
      localObject2 = null;
      break label54;
      label148:
      localObject2 = "";
      break label66;
      label155:
      localObject3 = null;
      break label79;
      label161:
      localObject3 = "";
      break label91;
      label168:
      localObject1 = "";
    }
  }
  
  private final void a(pqg parampqg, BaseArticleInfo paramBaseArticleInfo)
  {
    long l;
    if (paramBaseArticleInfo != null)
    {
      l = paramBaseArticleInfo.mAlgorithmID;
      parampqg = parampqg.a(l).e().f().l();
      if (paramBaseArticleInfo == null) {
        break label49;
      }
    }
    label49:
    for (int i = (int)paramBaseArticleInfo.mChannelID;; i = 0)
    {
      parampqg.a(i);
      return;
      l = 0L;
      break;
    }
  }
  
  public void onExposureTriggered(@Nullable String paramString, @Nullable HashMap<String, String> paramHashMap, @Nullable View paramView, @Nullable PTSComposer paramPTSComposer)
  {
    if (paramHashMap == null) {
      QLog.d("PtsItemViewEventListener", 1, "[onExposureTriggered] dataSet is null");
    }
    do
    {
      return;
      paramView = (String)paramHashMap.get("exposureReportName");
    } while (paramView == null);
    try
    {
      paramString = new pqg(new JSONObject((Map)paramHashMap));
      a(paramView, paramString);
      return;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString = new pqg();
      }
    }
  }
  
  public void onTapEventTriggered(@Nullable String paramString, @Nullable HashMap<String, String> paramHashMap, @Nullable View paramView, @Nullable PTSComposer paramPTSComposer)
  {
    qyl.a.a(paramPTSComposer, paramHashMap);
    if (paramHashMap != null)
    {
      paramPTSComposer = (String)paramHashMap.get("jumpUrl");
      if (paramPTSComposer != null)
      {
        Intrinsics.checkExpressionValueIsNotNull(paramPTSComposer, "dataSet?.get(PTSConstant…A_SET_JUMP_URL) ?: return");
        if (paramView == null) {
          break label92;
        }
        paramString = paramView.getContext();
      }
    }
    for (;;)
    {
      pkh.a(paramString, paramPTSComposer);
      paramView = (String)paramHashMap.get("clickReportName");
      if (paramView != null) {}
      try
      {
        paramString = new pqg(new JSONObject((Map)paramHashMap));
        a(paramView, paramString);
        return;
        label92:
        paramString = null;
      }
      catch (JSONException paramString)
      {
        for (;;)
        {
          paramString = new pqg();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tgy
 * JD-Core Version:    0.7.0.1
 */