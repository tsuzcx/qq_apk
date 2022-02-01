import android.content.Context;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.c;
import com.tencent.biz.pubaccount.readinjoy.view.widget.RoundAngleFrameLayout;

public class kxr
{
  public static boolean K(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo.mFeedType == 25) || ((paramBaseArticleInfo.mFeedType == 1) && (d(paramBaseArticleInfo) == 25));
  }
  
  public static boolean L(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo.mSocialFeedInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.a != null);
  }
  
  public static void a(Context paramContext, View paramView, RoundAngleFrameLayout paramRoundAngleFrameLayout)
  {
    int j = paramView.getPaddingTop();
    int k = paramView.getPaddingBottom();
    if (kxm.AY()) {
      paramRoundAngleFrameLayout.setRaduis(aqcx.dip2px(paramContext, 8.0F));
    }
    for (int i = aqcx.dip2px(paramContext, 14.0F);; i = aqcx.dip2px(paramContext, 6.0F))
    {
      paramView.setPadding(i, j, i, k);
      return;
      paramRoundAngleFrameLayout.setRaduis(aqcx.dip2px(paramContext, 0.0F));
    }
  }
  
  public static int d(BaseArticleInfo paramBaseArticleInfo)
  {
    int j = 0;
    int i = j;
    if (L(paramBaseArticleInfo))
    {
      i = j;
      if (paramBaseArticleInfo.mSocialFeedInfo.a.z != null) {
        i = paramBaseArticleInfo.mSocialFeedInfo.a.z.intValue();
      }
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     kxr
 * JD-Core Version:    0.7.0.1
 */