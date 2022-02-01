import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo.a;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.e;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ndh
  extends ndi
  implements aqdf.a
{
  private aqdf a;
  
  public ndh(Activity paramActivity, LayoutInflater paramLayoutInflater, int paramInt, ListView paramListView, aqdf paramaqdf, SparseArray<lfz> paramSparseArray)
  {
    super(paramActivity, paramLayoutInflater, paramInt, paramListView, paramSparseArray);
    this.jdField_a_of_type_Aqdf = paramaqdf;
    this.jdField_a_of_type_Aqdf.a(this);
  }
  
  public boolean Fo()
  {
    return kxm.isAppOnForeground(this.mContext);
  }
  
  public aqdf a()
  {
    return this.jdField_a_of_type_Aqdf;
  }
  
  public BaseArticleInfo a(int paramInt, long paramLong)
  {
    return lbz.a().a(this.mChannelID, paramLong);
  }
  
  public void a(int paramInt, BaseArticleInfo paramBaseArticleInfo, ArrayList<DislikeInfo> paramArrayList)
  {
    Object localObject = (ArticleInfo)paramBaseArticleInfo;
    if (localObject == null) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (lgy.aP(paramBaseArticleInfo.mRecommendSeq))
            {
              lgy.a().F(this.mChannelID, paramBaseArticleInfo.mRecommendSeq);
              return;
            }
            paramBaseArticleInfo = kxm.getAccount();
            Iterator localIterator = paramArrayList.iterator();
            while (localIterator.hasNext())
            {
              DislikeInfo localDislikeInfo = (DislikeInfo)localIterator.next();
              if (localDislikeInfo.type == 5) {
                ea(localDislikeInfo.puin);
              }
            }
            lbz.a().a(Long.valueOf(paramBaseArticleInfo).longValue(), ((ArticleInfo)localObject).makeDislikeParam(paramArrayList));
            lbz.a().b(this.mChannelID, (BaseArticleInfo)localObject);
          } while (paramInt != 0);
          paramBaseArticleInfo = (QQAppInterface)kxm.getAppRuntime();
          paramArrayList = (KandianMergeManager)paramBaseArticleInfo.getManager(162);
          if (this.gO.size() <= 0) {
            break;
          }
        } while (this.mChannelID != 0);
        paramArrayList = (BaseArticleInfo)this.gO.get(0);
      } while (paramArrayList == null);
      localObject = ocp.b(getApp(), paramArrayList);
      ocp.a(paramBaseArticleInfo, ocp.q(paramArrayList), String.valueOf(NetConnInfoCenter.getServerTime()), (String)localObject, true);
      return;
      lbz.a().a(this.mChannelID, 20, 9223372036854775807L, true);
    } while (this.mChannelID != 0);
    ocp.a(paramBaseArticleInfo, paramBaseArticleInfo.getApp().getResources().getString(2131697442), String.valueOf(NetConnInfoCenter.getServerTime()), "", true);
  }
  
  public void a(int paramInt, ArrayList<BaseArticleInfo> paramArrayList, ArrayList<DislikeInfo> paramArrayList1)
  {
    Object localObject = kxm.getAccount();
    ArticleInfo localArticleInfo = (ArticleInfo)paramArrayList.get(0);
    if (localArticleInfo != null) {
      lbz.a().a(Long.valueOf((String)localObject).longValue(), localArticleInfo.makeDislikeParam(paramArrayList1));
    }
    paramArrayList1 = paramArrayList1.iterator();
    while (paramArrayList1.hasNext())
    {
      localObject = (DislikeInfo)paramArrayList1.next();
      if (((DislikeInfo)localObject).type == 5) {
        ea(((DislikeInfo)localObject).puin);
      }
    }
    int i = 0;
    if (i < paramArrayList.size())
    {
      paramArrayList1 = (ArticleInfo)paramArrayList.get(i);
      if (paramArrayList1 == null) {}
      for (;;)
      {
        i += 1;
        break;
        long l = paramArrayList1.mRecommendSeq;
        if (lgy.aP(l)) {
          lgy.a().F(this.mChannelID, l);
        } else {
          lbz.a().b(this.mChannelID, paramArrayList1);
        }
      }
    }
    if (paramInt == 0)
    {
      paramArrayList = (QQAppInterface)kxm.getAppRuntime();
      paramArrayList1 = (KandianMergeManager)paramArrayList.getManager(162);
      if (this.gO.size() <= 0) {
        break label248;
      }
      if (this.mChannelID == 0)
      {
        paramArrayList1 = (BaseArticleInfo)this.gO.get(0);
        if (paramArrayList1 != null)
        {
          localObject = ocp.b(getApp(), paramArrayList1);
          ocp.a(paramArrayList, ocp.q(paramArrayList1), String.valueOf(NetConnInfoCenter.getServerTime()), (String)localObject, true);
        }
      }
    }
    label248:
    do
    {
      return;
      lbz.a().a(this.mChannelID, 20, 9223372036854775807L, true);
    } while (this.mChannelID != 0);
    ocp.a(paramArrayList, paramArrayList.getApp().getResources().getString(2131697442), String.valueOf(NetConnInfoCenter.getServerTime()), "", true);
  }
  
  public void a(mye.b paramb, BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBaseArticleInfo == null) || (paramb == null)) {
      return;
    }
    if (paramBoolean2) {
      super.b(paramb, paramBaseArticleInfo);
    }
    if (this.mChannelID != 40677)
    {
      ArrayList localArrayList = new ArrayList();
      ReportInfo localReportInfo = new ReportInfo();
      localReportInfo.mUin = kxm.getLongAccountUin();
      localReportInfo.mSource = 0;
      localReportInfo.mSourceArticleId = paramBaseArticleInfo.mArticleID;
      localReportInfo.mChannelId = this.mChannelID;
      localReportInfo.mAlgorithmId = ((int)paramBaseArticleInfo.mAlgorithmID);
      localReportInfo.mStrategyId = paramBaseArticleInfo.mStrategyId;
      localReportInfo.mOperation = 1;
      localReportInfo.mServerContext = paramBaseArticleInfo.mServerContext;
      localReportInfo.mReadTimeLength = -1;
      localReportInfo.mInnerId = paramBaseArticleInfo.innerUniqueID;
      localReportInfo.videoReportInfo = paramBaseArticleInfo.videoReportInfo;
      if (paramBaseArticleInfo.mVideoColumnInfo != null) {
        localReportInfo.mColumnID = paramBaseArticleInfo.mVideoColumnInfo.aHc;
      }
      if (paramBaseArticleInfo.mSocialFeedInfo != null)
      {
        ReportInfo.a locala = new ReportInfo.a();
        locala.vd = paramBaseArticleInfo.mSocialFeedInfo.mFeedId;
        if (paramBaseArticleInfo.mSocialFeedInfo.a != null) {
          locala.vg = paramBaseArticleInfo.mSocialFeedInfo.a.uin;
        }
        locala.aSx = paramBaseArticleInfo.mSocialFeedInfo.mLikeCount;
        locala.aSy = paramBaseArticleInfo.mSocialFeedInfo.mCommentCount;
        Object localObject = paramBaseArticleInfo.mSocialFeedInfo.iS;
        if ((localObject != null) && (!((List)localObject).isEmpty()))
        {
          locala.iR = new ArrayList();
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            SocializeFeedsInfo.e locale = (SocializeFeedsInfo.e)((Iterator)localObject).next();
            if (locale != null) {
              locala.iR.add(Long.valueOf(locale.uin));
            }
          }
        }
        localReportInfo.mFeedsReportData = locala;
      }
      localArrayList.add(localReportInfo);
      lbz.a().cb(localArrayList);
    }
    lbz.a().H(paramBaseArticleInfo.mArticleID, System.currentTimeMillis());
    super.a(paramb, paramBaseArticleInfo, paramBoolean1, paramBoolean2);
  }
  
  public void clearData()
  {
    super.clearData();
  }
  
  public BaseArticleInfo d(int paramInt)
  {
    return lbz.a().a(Integer.valueOf(this.mChannelID));
  }
  
  public int dA(int paramInt)
  {
    return b((ArticleInfo)this.gO.get(paramInt), this.mChannelType);
  }
  
  public boolean ea(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      new kbv((QQAppInterface)kxm.getAppRuntime(), paramString, this.mContext).start();
      return true;
    }
    QLog.d("Q.readinjoy.ui", 2, "unfollow fail , puin is null !");
    return false;
  }
  
  public Activity getActivity()
  {
    return this.mContext;
  }
  
  public boolean m(int paramInt, long paramLong)
  {
    return lbz.a().aO(paramLong);
  }
  
  public boolean n(int paramInt, long paramLong)
  {
    return lbz.a().d(Long.valueOf(paramLong));
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (!this.jdField_a_of_type_Aqdf.isPausing())
    {
      paramInt2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildCount();
      paramInt1 = 0;
      for (;;)
      {
        if (paramInt1 < paramInt2)
        {
          Object localObject = (lie)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(paramInt1).getTag(2131381960);
          nhk localnhk = (nhk)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(paramInt1).getTag(2131381965);
          lkf locallkf = (lkf)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(paramInt1).getTag(2131381962);
          if ((localObject != null) && (localnhk != null) && (locallkf != null)) {
            locallkf.a(localnhk, (lie)localObject, Long.valueOf(paramString).longValue(), paramBitmap);
          }
          if ((localObject != null) && (lwj.dM(((lie)localObject).getCellType())))
          {
            localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(paramInt1);
            if (localObject != null)
            {
              localObject = (lwm)((View)localObject).getTag();
              if (localObject == null) {}
            }
          }
          try
          {
            ((lwm)localObject).a(Long.valueOf(paramString).longValue(), paramBitmap);
            paramInt1 += 1;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              localException.printStackTrace();
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ndh
 * JD-Core Version:    0.7.0.1
 */