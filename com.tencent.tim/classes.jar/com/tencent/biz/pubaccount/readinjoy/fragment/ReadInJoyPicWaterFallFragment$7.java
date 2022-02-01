package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.r;
import java.util.List;
import java.util.Map;
import kxm;
import mhs;
import mhy;
import ndi;

class ReadInJoyPicWaterFallFragment$7
  implements Runnable
{
  ReadInJoyPicWaterFallFragment$7(ReadInJoyPicWaterFallFragment paramReadInJoyPicWaterFallFragment, BaseArticleInfo paramBaseArticleInfo, int paramInt1, int paramInt2, long paramLong) {}
  
  public void run()
  {
    mhy localmhy = new mhy();
    localmhy.mStrategyId = this.c.mStrategyId;
    localmhy.mAlgorithmID = this.c.mAlgorithmID;
    if (!TextUtils.isEmpty(this.c.mVideoVid)) {
      localmhy.mVideoVid = this.c.mVideoVid;
    }
    localmhy.mArticleType = kxm.a(this.c);
    int i;
    label106:
    boolean bool;
    if (((ArticleInfo)this.c).hasChannelInfo())
    {
      i = this.c.mChannelInfoId;
      localmhy.aRx = i;
      if (!TextUtils.isEmpty(this.c.mArticleFriendLikeText)) {
        break label381;
      }
      i = 0;
      localmhy.aRy = i;
      localmhy.mServerContext = this.c.mServerContext;
      localmhy.agM = kxm.f(this.c);
      localmhy.j = this.c;
      localmhy.k = this.c;
      if ((this.c.mGroupId == -1L) && (!this.c.isSubscriptFeed())) {
        break label386;
      }
      bool = true;
      label175:
      localmhy.amr = bool;
      if (((!ndi.ak(this.c)) && (!ndi.S((ArticleInfo)this.c)) && (!ndi.T((ArticleInfo)this.c)) && (!ndi.U((ArticleInfo)this.c))) || (ndi.Y((ArticleInfo)this.c))) {
        break label391;
      }
      localmhy.agN = String.valueOf(this.c.mSocialFeedInfo.a.cuin);
      localmhy.v = Long.valueOf(this.c.businessId);
    }
    for (;;)
    {
      localmhy.mStrCircleId = this.c.mStrCircleId;
      localmhy.agO = this.c.innerUniqueID;
      localmhy.aRz = this.aOl;
      localmhy.aRA = kxm.nR();
      localmhy.aRD = this.c.mVideoAdsJumpType;
      localmhy.aRC = this.c.mVideoAdsSource;
      localmhy.ve = this.tV;
      localmhy.mPosition = this.val$position;
      this.this$0.ek.put(Long.valueOf(this.c.mArticleID), localmhy);
      return;
      i = 0;
      break;
      label381:
      i = 1;
      break label106;
      label386:
      bool = false;
      break label175;
      label391:
      if ((kxm.r(this.c)) && (this.c.mPolymericInfo.aRX == 6))
      {
        localmhy.agN = (this.c.mPolymericInfo.uin + "");
        localmhy.v = Long.valueOf(this.c.mArticleID);
      }
      else
      {
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
          }
        }
        if (kxm.B(this.c))
        {
          localmhy.agN = this.c.mSubscribeID;
          localmhy.v = Long.valueOf(this.c.mArticleID);
        }
        else
        {
          localmhy.agN = this.c.mSubscribeID;
          localmhy.v = Long.valueOf(this.c.mArticleID);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyPicWaterFallFragment.7
 * JD-Core Version:    0.7.0.1
 */