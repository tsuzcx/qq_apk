import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.r;

public class kvm
{
  public static long a(BaseArticleInfo paramBaseArticleInfo)
  {
    long l1;
    if ((paramBaseArticleInfo == null) || (paramBaseArticleInfo.mSocialFeedInfo == null)) {
      l1 = 0L;
    }
    long l2;
    do
    {
      return l1;
      if (paramBaseArticleInfo.mSocialFeedInfo.a == null) {
        break;
      }
      l2 = paramBaseArticleInfo.mSocialFeedInfo.a.cuin;
      l1 = l2;
    } while (l2 != 0L);
    for (;;)
    {
      try
      {
        l1 = Long.parseLong(paramBaseArticleInfo.mSubscribeID);
        return l1;
      }
      catch (NumberFormatException paramBaseArticleInfo)
      {
        paramBaseArticleInfo.printStackTrace();
        return l2;
      }
      l2 = 0L;
    }
  }
  
  public static boolean e(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo == null) || (paramArticleInfo.mSocialFeedInfo == null)) {}
    while ((!paramArticleInfo.mSocialFeedInfo.DB()) || (ndi.P(paramArticleInfo)) || (i(paramArticleInfo))) {
      return false;
    }
    return true;
  }
  
  public static boolean h(BaseArticleInfo paramBaseArticleInfo)
  {
    if ((paramBaseArticleInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.DB()))
    {
      if (ndi.P((ArticleInfo)paramBaseArticleInfo)) {
        return true;
      }
      if (!i(paramBaseArticleInfo)) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
    return false;
  }
  
  public static boolean i(BaseArticleInfo paramBaseArticleInfo)
  {
    return a(paramBaseArticleInfo) == kxm.getLongAccountUin();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kvm
 * JD-Core Version:    0.7.0.1
 */