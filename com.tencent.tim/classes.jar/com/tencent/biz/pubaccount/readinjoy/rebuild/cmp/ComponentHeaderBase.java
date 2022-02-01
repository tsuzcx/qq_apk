package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import aqdf;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo.a;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.e;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kxm;
import lbz;
import lie;
import lwk;
import lwm.a;
import mas;
import ndi;

public abstract class ComponentHeaderBase
  extends FrameLayout
  implements lwk
{
  aqdf a;
  public ComponentNotIntrest a;
  public mas a;
  ndi b;
  
  public ComponentHeaderBase(Context paramContext)
  {
    super(paramContext);
    bY(paramContext);
  }
  
  public ComponentHeaderBase(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    bY(paramContext);
  }
  
  public ComponentHeaderBase(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    bY(paramContext);
  }
  
  private void bY(Context paramContext)
  {
    this.jdField_a_of_type_Mas = new mas();
    init(paramContext);
    aHq();
  }
  
  public boolean Dj()
  {
    if ((this.jdField_a_of_type_Mas.a == null) || (this.jdField_a_of_type_Mas.a.a() == null)) {
      QLog.d("ComponentHeaderBase", 2, "isHideNotInterestView model or articleInfo is null !");
    }
    ArticleInfo localArticleInfo;
    do
    {
      return false;
      localArticleInfo = this.jdField_a_of_type_Mas.a.a();
    } while (((kxm.i(localArticleInfo)) || (kxm.j(localArticleInfo)) || (kxm.l(localArticleInfo)) || (kxm.m(localArticleInfo))) && ((localArticleInfo.mChannelID != 70L) || ((!this.jdField_a_of_type_Mas.CV()) && (localArticleInfo.mChannelID != 70L) && ((localArticleInfo.mSocialFeedInfo == null) || (localArticleInfo.mSocialFeedInfo.mFollowStatus != 1)))));
    return true;
  }
  
  public void P(Object paramObject)
  {
    if ((paramObject instanceof lie))
    {
      lie locallie = (lie)paramObject;
      this.jdField_a_of_type_Mas.setModel(locallie);
      aNf();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentNotIntrest != null)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentNotIntrest.P(paramObject);
        if (!Dj()) {
          break label56;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentNotIntrest.setVisibility(8);
      }
    }
    return;
    label56:
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentNotIntrest.setVisibility(0);
  }
  
  public void a(lwm.a parama)
  {
    this.jdField_a_of_type_Mas.b(parama);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentNotIntrest != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentNotIntrest.a(parama);
    }
  }
  
  public void aHq() {}
  
  protected void aNa()
  {
    ReportInfo localReportInfo = new ReportInfo();
    Object localObject2 = this.jdField_a_of_type_Mas.a.a();
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
  
  public void aNf() {}
  
  public void cG(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentNotIntrest = ((ComponentNotIntrest)paramView.findViewById(2131372477));
  }
  
  public View f(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131560314, this, true);
  }
  
  public void init(Context paramContext)
  {
    cG(f(paramContext));
  }
  
  public void setLogic(ndi paramndi, aqdf paramaqdf)
  {
    this.b = paramndi;
    this.jdField_a_of_type_Aqdf = paramaqdf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderBase
 * JD-Core Version:    0.7.0.1
 */