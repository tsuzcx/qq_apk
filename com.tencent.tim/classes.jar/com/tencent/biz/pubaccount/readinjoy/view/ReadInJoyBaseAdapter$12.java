package com.tencent.biz.pubaccount.readinjoy.view;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyBaseFragment;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.r;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kxm;
import kys;
import lbz;
import lie;
import mgu;
import mhr;
import mhs;
import mhy;
import ndi;
import obr;

public class ReadInJoyBaseAdapter$12
  implements Runnable
{
  public ReadInJoyBaseAdapter$12(ndi paramndi, BaseArticleInfo paramBaseArticleInfo1, lie paramlie, int paramInt, long paramLong, BaseArticleInfo paramBaseArticleInfo2) {}
  
  public void run()
  {
    int j = 1;
    mhy localmhy = new mhy();
    localmhy.mStrategyId = this.c.mStrategyId;
    localmhy.mAlgorithmID = this.c.mAlgorithmID;
    if (!TextUtils.isEmpty(this.c.mVideoVid)) {
      localmhy.mVideoVid = this.c.mVideoVid;
    }
    localmhy.mArticleType = kxm.a(this.c);
    int i;
    if (((ArticleInfo)this.c).hasChannelInfo()) {
      i = this.c.mChannelInfoId;
    }
    for (;;)
    {
      localmhy.aRx = i;
      label114:
      boolean bool;
      if (TextUtils.isEmpty(this.c.mArticleFriendLikeText))
      {
        i = 0;
        localmhy.aRy = i;
        localmhy.mServerContext = this.c.mServerContext;
        localmhy.agM = kxm.f(this.c);
        localmhy.j = this.b.a();
        localmhy.k = this.c;
        if ((this.c.mGroupId == -1L) && (!this.c.isSubscriptFeed())) {
          break label773;
        }
        bool = true;
        label193:
        localmhy.amr = bool;
        localmhy.ams = this.b.isShowHeader();
        if ((!this.b.Cq()) && (!this.b.Cs())) {
          break label778;
        }
        bool = true;
        label239:
        localmhy.amt = bool;
        if (((!ndi.ak(this.c)) && (!ndi.S((ArticleInfo)this.c)) && (!ndi.T((ArticleInfo)this.c)) && (!ndi.U((ArticleInfo)this.c))) || (ndi.Y((ArticleInfo)this.c))) {
          break label783;
        }
        localmhy.agN = String.valueOf(this.c.mSocialFeedInfo.a.cuin);
        localmhy.v = Long.valueOf(this.c.businessId);
        label343:
        if (localmhy.amt)
        {
          if (!this.b.Cq()) {
            break label1090;
          }
          i = 2;
          label365:
          localmhy.aRw = i;
        }
        localmhy.mStrCircleId = this.c.mStrCircleId;
        localmhy.agO = this.c.innerUniqueID;
        localmhy.aRz = this.this$0.aQo;
        localmhy.aRA = kxm.nR();
        localmhy.aRD = this.c.mVideoAdsJumpType;
        localmhy.aRC = this.c.mVideoAdsSource;
        if (this.c.mFeedType == 3)
        {
          ArrayList localArrayList = new ArrayList();
          ReportInfo localReportInfo = new ReportInfo();
          localReportInfo.mUin = kxm.getLongAccountUin();
          localReportInfo.mSource = 0;
          localReportInfo.mSourceArticleId = this.c.mArticleID;
          localReportInfo.mChannelId = this.this$0.mChannelID;
          localReportInfo.mAlgorithmId = ((int)this.c.mAlgorithmID);
          localReportInfo.mStrategyId = this.c.mStrategyId;
          localReportInfo.mOperation = 7;
          localReportInfo.mServerContext = this.c.mServerContext;
          localReportInfo.mReadTimeLength = -1;
          if (!TextUtils.isEmpty(this.c.innerUniqueID)) {
            localReportInfo.mInnerId = this.c.innerUniqueID;
          }
          localArrayList.add(localReportInfo);
          lbz.a().cb(localArrayList);
        }
        localmhy.ve = this.tV;
        localmhy.mPosition = this.val$position;
        localmhy.agP = kxm.i(this.c);
        if ((this.this$0.mChannelID == 0) || (kys.dv(this.this$0.mChannelID))) {
          ndi.b(localmhy);
        }
        localmhy.aRF = ReadInJoyBaseFragment.di(this.this$0.mChannelID);
        if ((!kxm.B(this.c)) || (!this.c.mNewPolymericInfo.amx)) {
          break label1109;
        }
        this.this$0.ek.put(Long.valueOf(-this.c.mArticleID), localmhy);
        if (!kys.dv(this.this$0.mChannelID)) {}
      }
      try
      {
        this.this$0.lB.add(localmhy);
        obr.n(this.n);
        obr.k(this.n, 2);
        return;
        i = 0;
        continue;
        i = 1;
        break label114;
        label773:
        bool = false;
        break label193;
        label778:
        bool = false;
        break label239;
        label783:
        if ((kxm.r(this.c)) && (this.c.mPolymericInfo.aRX == 6))
        {
          localmhy.agN = (this.c.mPolymericInfo.uin + "");
          localmhy.v = Long.valueOf(this.c.mArticleID);
          break label343;
        }
        if (kxm.u(this.c))
        {
          if (kxm.s(this.c)) {
            if (this.c.mGroupSubArticleList.size() >= 1)
            {
              if (!TextUtils.isEmpty(((BaseArticleInfo)this.c.mGroupSubArticleList.get(0)).mVideoVid)) {
                localmhy.mVideoVid = ((BaseArticleInfo)this.c.mGroupSubArticleList.get(0)).mVideoVid;
              }
              localmhy.agO = ((BaseArticleInfo)this.c.mGroupSubArticleList.get(0)).innerUniqueID;
            }
          }
          for (;;)
          {
            localmhy.v = Long.valueOf(this.c.mArticleID);
            break;
            localmhy.mPosition = this.val$position;
            if (this.c.mPolymericInfo != null) {
              this.c.mPolymericInfo.hasExposed = true;
            }
          }
        }
        if (kxm.B(this.c))
        {
          localmhy.agN = this.c.mSubscribeID;
          localmhy.v = Long.valueOf(this.c.mArticleID);
          break label343;
        }
        localmhy.agN = this.c.mSubscribeID;
        localmhy.v = Long.valueOf(this.c.mArticleID);
        break label343;
        label1090:
        i = j;
        if (this.b.Cs()) {
          break label365;
        }
        i = 0;
        break label365;
        label1109:
        this.this$0.ek.put(Long.valueOf(this.c.mArticleID), localmhy);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.d("ReadInJoyBaseAdapter", 2, "mDailyReportDatas error!  msg=" + localException);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.12
 * JD-Core Version:    0.7.0.1
 */