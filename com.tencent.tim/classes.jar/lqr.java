import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo.a;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.e;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class lqr
  implements ViewBase.OnClickListener
{
  public final String TAG = "OnSocialHeaderFollowClickListener";
  private int aPw;
  private ArticleInfo b;
  private Context mContext;
  
  public lqr(ArticleInfo paramArticleInfo, Context paramContext, int paramInt)
  {
    this.b = paramArticleInfo;
    this.mContext = paramContext;
    this.aPw = paramInt;
  }
  
  public static boolean B(ArticleInfo paramArticleInfo)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramArticleInfo != null)
    {
      bool1 = bool2;
      if (paramArticleInfo.mSocialFeedInfo != null)
      {
        bool1 = bool2;
        if (paramArticleInfo.mSocialFeedInfo.mFollowStatus == 2) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static long a(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {
      return 0L;
    }
    try
    {
      long l = Long.parseLong(paramArticleInfo.mSubscribeID);
      return l;
    }
    catch (NumberFormatException paramArticleInfo)
    {
      paramArticleInfo.printStackTrace();
      return 0L;
    }
    catch (Exception paramArticleInfo)
    {
      paramArticleInfo.printStackTrace();
    }
    return 0L;
  }
  
  private void aMZ()
  {
    AppRuntime localAppRuntime = kxm.getAppRuntime();
    ArticleInfo localArticleInfo;
    if (localAppRuntime != null)
    {
      localArticleInfo = this.b;
      if (localArticleInfo != null)
      {
        if ((localArticleInfo.mSocialFeedInfo == null) || (localArticleInfo.mSocialFeedInfo.mFollowStatus == 2)) {
          return;
        }
        localArticleInfo.needShowFollwedButton = true;
        if (!odv.aT(localArticleInfo.mChannelID)) {
          break label134;
        }
      }
    }
    label134:
    for (String str = "0X800941D";; str = "0X80080EC")
    {
      ndi.b(localArticleInfo, str, str, (int)localArticleInfo.mChannelID);
      lbz.k(localArticleInfo);
      if (localArticleInfo.mSocialFeedInfo != null)
      {
        long l = localArticleInfo.mSocialFeedInfo.a.uin;
        lbz.a().a().a(localAppRuntime.getAccount(), String.valueOf(l), true, new lqt(this, localArticleInfo));
      }
      aNa();
      return;
    }
  }
  
  private void aNa()
  {
    ReportInfo localReportInfo = new ReportInfo();
    Object localObject2 = this.b;
    if (localObject2 != null)
    {
      Object localObject3 = ((ArticleInfo)localObject2).mSocialFeedInfo;
      localObject1 = new ReportInfo.a();
      localReportInfo.mUin = kxm.getLongAccountUin();
      localReportInfo.mSource = 0;
      localReportInfo.mSourceArticleId = ((ArticleInfo)localObject2).mArticleID;
      localReportInfo.mChannelId = ((int)((ArticleInfo)localObject2).mChannelID);
      localReportInfo.mAlgorithmId = ((int)((ArticleInfo)localObject2).mAlgorithmID);
      localReportInfo.mStrategyId = ((ArticleInfo)localObject2).mStrategyId;
      localReportInfo.mServerContext = ((ArticleInfo)localObject2).mServerContext;
      localReportInfo.mReadTimeLength = -1;
      if (localObject3 != null)
      {
        ((ReportInfo.a)localObject1).vd = ((SocializeFeedsInfo)localObject3).mFeedId;
        if (((SocializeFeedsInfo)localObject3).a != null) {
          ((ReportInfo.a)localObject1).vg = ((SocializeFeedsInfo)localObject3).a.uin;
        }
        ((ReportInfo.a)localObject1).aSx = ((SocializeFeedsInfo)localObject3).mLikeCount;
        ((ReportInfo.a)localObject1).aSy = ((SocializeFeedsInfo)localObject3).mCommentCount;
        localObject2 = ((SocializeFeedsInfo)localObject3).iS;
        if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
        {
          ((ReportInfo.a)localObject1).iR = new ArrayList();
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (SocializeFeedsInfo.e)((Iterator)localObject2).next();
            if (localObject3 != null) {
              ((ReportInfo.a)localObject1).iR.add(Long.valueOf(((SocializeFeedsInfo.e)localObject3).uin));
            }
          }
        }
      }
      localReportInfo.mOperation = 14;
      localReportInfo.mFeedsReportData = ((ReportInfo.a)localObject1);
    }
    Object localObject1 = new ArrayList();
    ((List)localObject1).add(localReportInfo);
    lbz.a().cb((List)localObject1);
  }
  
  private void followPublicAccount()
  {
    if (this.b == null) {}
    while (B(this.b)) {
      return;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if ((this.b != null) && (this.b.mSocialFeedInfo != null)) {
      this.b.needShowFollwedButton = true;
    }
    long l = a(this.b);
    lbz.a().a().a(localQQAppInterface.getAccount(), String.valueOf(l), true, new lqs(this), 1);
    aNa();
  }
  
  public void onClick(ViewBase paramViewBase)
  {
    if (this.b != null)
    {
      QLog.d("OnSocialHeaderFollowClickListener", 2, "OnSocialHeaderFollowClickListener: " + this.b.mTitle);
      if ((this.aPw != 31) && (this.aPw != 32) && (this.aPw != 83) && (this.aPw != 84) && (this.aPw != 85) && (this.aPw != 86) && (this.aPw != 77) && (this.aPw != 78) && (!this.b.isPGCShortContent()) && (!this.b.isAccountShown)) {
        break label145;
      }
      followPublicAccount();
    }
    for (;;)
    {
      kmy.a(paramViewBase, this.b, true);
      return;
      label145:
      aMZ();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lqr
 * JD-Core Version:    0.7.0.1
 */