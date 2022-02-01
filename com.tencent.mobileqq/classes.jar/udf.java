import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.webarticle.RIJWebArticlePreloadUtil.preload.runnable.1;
import com.tencent.biz.pubaccount.readinjoy.webarticle.RIJWebArticlePreloadUtil.preloadImpInWebProcess.runnable.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/webarticle/RIJWebArticlePreloadUtil;", "", "()V", "BUNDLE_KEY_ARTICLE_URL", "", "TAG", "preloadList", "Ljava/util/LinkedList;", "Lcom/tencent/biz/pubaccount/readinjoy/webarticle/RIJWebArticlePreloadUtil$PreloadData;", "isInPreloadList", "", "url", "preload", "", "articleInfo", "Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;", "preloadImpInWebProcess", "PreloadData", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class udf
{
  private static final LinkedList<udg> a;
  public static final udf a;
  
  static
  {
    jdField_a_of_type_Udf = new udf();
    jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  }
  
  private final boolean a(String paramString)
  {
    if ((TextUtils.isEmpty((CharSequence)paramString)) || (jdField_a_of_type_JavaUtilLinkedList.size() <= 0)) {
      return false;
    }
    Iterator localIterator = jdField_a_of_type_JavaUtilLinkedList.iterator();
    while (localIterator.hasNext())
    {
      udg localudg = (udg)localIterator.next();
      if (TextUtils.equals((CharSequence)paramString, (CharSequence)localudg.a())) {
        return true;
      }
    }
    return false;
  }
  
  public final void a(@NotNull BaseArticleInfo paramBaseArticleInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseArticleInfo, "articleInfo");
    if (!udj.a.e())
    {
      QLog.i("RIJWebArticlePreloadUtil", 2, "[preload] web article preload switch is off.");
      return;
    }
    if ((pqw.a(paramBaseArticleInfo)) || (TextUtils.isEmpty((CharSequence)paramBaseArticleInfo.mArticleContentUrl)))
    {
      QLog.i("RIJWebArticlePreloadUtil", 2, "[preload] article is video or url is empty.");
      return;
    }
    Object localObject = pkh.a();
    if (localObject == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
    }
    localObject = (pvp)((QQAppInterface)localObject).getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
    if (localObject != null)
    {
      localObject = ((pvp)localObject).a();
      if ((localObject != null) && (((pvj)localObject).a(paramBaseArticleInfo.mArticleID) == true))
      {
        QLog.i("RIJWebArticlePreloadUtil", 1, "[preload] article has been read, do not preload.");
        return;
      }
    }
    paramBaseArticleInfo = (Runnable)new RIJWebArticlePreloadUtil.preload.runnable.1(ude.a.a(paramBaseArticleInfo.mArticleContentUrl));
    ThreadManager.getSubThreadHandler().post(paramBaseArticleInfo);
  }
  
  public final void a(@Nullable String paramString)
  {
    paramString = (Runnable)new RIJWebArticlePreloadUtil.preloadImpInWebProcess.runnable.1(paramString);
    ThreadManager.getSubThreadHandler().post(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     udf
 * JD-Core Version:    0.7.0.1
 */