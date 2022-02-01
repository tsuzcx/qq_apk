import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"isFromLiuJin", "", "Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;", "toDeepLinkUrl", "", "Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;", "toDownloadJumpUrl", "toJumpType", "", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/data/AdvertisementSoftInfo;", "toPackageName", "toQQMiniProSchema", "toViolaUrl", "toWebViewUrl", "AQQLiteApp_release"}, k=2, mv={1, 1, 16})
public final class ugj
{
  public static final int a(@Nullable AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramAdvertisementInfo != null)
    {
      paramAdvertisementInfo = paramAdvertisementInfo.mAdExtInfo;
      if (paramAdvertisementInfo == null) {}
    }
    for (;;)
    {
      try
      {
        paramAdvertisementInfo = new JSONObject(paramAdvertisementInfo).optString("jump_type");
        Intrinsics.checkExpressionValueIsNotNull(paramAdvertisementInfo, "type");
        int i = Integer.parseInt(paramAdvertisementInfo);
        return i;
      }
      catch (Exception paramAdvertisementInfo) {}
      paramAdvertisementInfo = "";
    }
    return 0;
  }
  
  public static final int a(@Nullable uga paramuga)
  {
    if (paramuga != null)
    {
      paramuga = paramuga.n;
      if (paramuga == null) {}
    }
    try
    {
      paramuga = new JSONObject(paramuga).optString("jump_type");
      if (paramuga != null) {}
      for (;;)
      {
        int i = Integer.parseInt(paramuga);
        return i;
        paramuga = "";
        break;
        paramuga = "0";
      }
      return 0;
    }
    catch (Exception paramuga) {}
  }
  
  public static final boolean a(@Nullable BaseArticleInfo paramBaseArticleInfo)
  {
    if (!(paramBaseArticleInfo instanceof AdvertisementInfo)) {}
    for (Object localObject = null;; localObject = paramBaseArticleInfo)
    {
      localObject = (AdvertisementInfo)localObject;
      if (localObject != null)
      {
        localObject = ((AdvertisementInfo)localObject).mAdvertisementExtInfo;
        if ((localObject != null) && (((ufz)localObject).j == 32)) {}
      }
      else
      {
        if ((paramBaseArticleInfo instanceof AdvertisementInfo)) {
          break label65;
        }
        paramBaseArticleInfo = null;
      }
      label65:
      for (;;)
      {
        paramBaseArticleInfo = (AdvertisementInfo)paramBaseArticleInfo;
        return (paramBaseArticleInfo == null) || (a(paramBaseArticleInfo) != 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ugj
 * JD-Core Version:    0.7.0.1
 */