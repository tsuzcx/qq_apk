import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo.a;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.e;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.r;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class lqv
  implements ViewBase.OnClickListener
{
  ArticleInfo articleInfo;
  Context context;
  
  lqv(ArticleInfo paramArticleInfo, Context paramContext)
  {
    this.articleInfo = paramArticleInfo;
    this.context = paramContext;
  }
  
  public static void a(ArticleInfo paramArticleInfo, String paramString1, String paramString2)
  {
    if ((paramArticleInfo == null) || (paramArticleInfo.mSocialFeedInfo == null)) {
      return;
    }
    SocializeFeedsInfo localSocializeFeedsInfo = paramArticleInfo.mSocialFeedInfo;
    label28:
    label40:
    int i;
    label59:
    int j;
    label73:
    long l;
    if (odv.aT(paramArticleInfo.mChannelID))
    {
      if (!ndi.K(paramArticleInfo)) {
        break label290;
      }
      paramString1 = paramArticleInfo.mSubscribeID;
      if (localSocializeFeedsInfo.iS == null) {
        break label320;
      }
      i = localSocializeFeedsInfo.iS.size();
      if (!TextUtils.isEmpty(localSocializeFeedsInfo.ahL)) {
        break label325;
      }
      j = 0;
      int k = localSocializeFeedsInfo.mLikeCount;
      int m = localSocializeFeedsInfo.mCommentCount;
      int n = localSocializeFeedsInfo.aSI;
      paramString1 = kxm.a((int)paramArticleInfo.mChannelID, paramArticleInfo.mAlgorithmID, kxm.a(paramArticleInfo), paramString1, paramArticleInfo.innerUniqueID, i + 1, j, k, m, n).build();
      l = paramArticleInfo.mArticleID;
      if ((!kxm.i(paramArticleInfo)) && (!kxm.j(paramArticleInfo)) && (!kxm.l(paramArticleInfo)) && (!kxm.m(paramArticleInfo))) {
        break label381;
      }
      l = paramArticleInfo.businessId;
    }
    label290:
    label320:
    label325:
    label381:
    for (;;)
    {
      if ((ndi.S(paramArticleInfo)) || (ndi.ak(paramArticleInfo)) || (ndi.T(paramArticleInfo)) || (ndi.U(paramArticleInfo)))
      {
        if (!ndi.Y(paramArticleInfo)) {
          kbp.a(null, String.valueOf(localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.cuin), paramString2, paramString2, 0, 0, String.valueOf(localSocializeFeedsInfo.mFeedId), String.valueOf(l), "" + paramArticleInfo.mStrategyId, paramString1, false);
        }
        if ((kxm.r(paramArticleInfo)) || (kxm.s(paramArticleInfo))) {
          break;
        }
        ndi.g(paramArticleInfo, (int)paramArticleInfo.mChannelID);
        return;
        paramString2 = paramString1;
        break label28;
        paramString1 = "" + localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e.uin;
        break label40;
        i = 0;
        break label59;
        j = 1;
        break label73;
      }
      kbp.a(null, paramArticleInfo.mSubscribeID, paramString2, paramString2, 0, 0, String.valueOf(localSocializeFeedsInfo.mFeedId), String.valueOf(l), "" + paramArticleInfo.mStrategyId, paramString1, false);
      return;
    }
  }
  
  private void e(ArticleInfo paramArticleInfo, int paramInt)
  {
    if (paramArticleInfo != null)
    {
      ReportInfo localReportInfo = new ReportInfo();
      Object localObject = paramArticleInfo.mSocialFeedInfo;
      ReportInfo.a locala = new ReportInfo.a();
      localReportInfo.mUin = kxm.getLongAccountUin();
      localReportInfo.mSource = 0;
      localReportInfo.mSourceArticleId = paramArticleInfo.mArticleID;
      localReportInfo.mChannelId = ((int)paramArticleInfo.mChannelID);
      localReportInfo.mAlgorithmId = ((int)paramArticleInfo.mAlgorithmID);
      localReportInfo.mStrategyId = paramArticleInfo.mStrategyId;
      localReportInfo.mServerContext = paramArticleInfo.mServerContext;
      localReportInfo.mReadTimeLength = -1;
      localReportInfo.mOperation = paramInt;
      if (localObject != null)
      {
        locala.vd = ((SocializeFeedsInfo)localObject).mFeedId;
        if (((SocializeFeedsInfo)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e != null) {
          locala.vg = ((SocializeFeedsInfo)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e.uin;
        }
        locala.aSx = ((SocializeFeedsInfo)localObject).mLikeCount;
        locala.aSy = ((SocializeFeedsInfo)localObject).mCommentCount;
        paramArticleInfo = ((SocializeFeedsInfo)localObject).iS;
        if ((paramArticleInfo != null) && (!paramArticleInfo.isEmpty()))
        {
          locala.iR = new ArrayList();
          paramArticleInfo = paramArticleInfo.iterator();
          while (paramArticleInfo.hasNext())
          {
            localObject = (SocializeFeedsInfo.e)paramArticleInfo.next();
            if (localObject != null) {
              locala.iR.add(Long.valueOf(((SocializeFeedsInfo.e)localObject).uin));
            }
          }
        }
      }
      localReportInfo.mFeedsReportData = locala;
      paramArticleInfo = new ArrayList();
      paramArticleInfo.add(localReportInfo);
      lbz.a().cb(paramArticleInfo);
    }
  }
  
  private void n(ArticleInfo paramArticleInfo)
  {
    o(paramArticleInfo);
    e(paramArticleInfo, getOperation());
  }
  
  private void r(ArticleInfo paramArticleInfo)
  {
    kxm.c = paramArticleInfo;
  }
  
  protected abstract void b(ViewBase paramViewBase);
  
  protected abstract int getOperation();
  
  protected abstract void o(ArticleInfo paramArticleInfo);
  
  public final void onClick(ViewBase paramViewBase)
  {
    r(this.articleInfo);
    b(paramViewBase);
    n(this.articleInfo);
    kmy.a(paramViewBase, this.articleInfo, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lqv
 * JD-Core Version:    0.7.0.1
 */