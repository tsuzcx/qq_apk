package com.tencent.biz.pubaccount.readinjoy.model;

import android.os.Handler;
import awit;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import knd;
import kxm;
import kys;
import lbz;
import lhf;
import lum;
import luq.b;
import lvd;

public class ArticleInfoModule$19
  implements Runnable
{
  public ArticleInfoModule$19(lhf paramlhf, String paramString, int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean, int paramInt7) {}
  
  public void run()
  {
    Object localObject1 = this.this$0.mEntityManager;
    Object localObject2 = this.aeP;
    int i = this.aHH;
    long l = this.tl;
    int j = this.val$count;
    localObject1 = ((EntityManager)localObject1).query(ArticleInfo.class, true, (String)localObject2, new String[] { String.valueOf(i), String.valueOf(l) }, null, null, "mRecommendSeq desc", String.valueOf(j));
    if (localObject1 != null) {
      lum.cF((List)localObject1);
    }
    if ((localObject1 == null) || (this.val$count != ((List)localObject1).size()))
    {
      if (this.aHH == 70)
      {
        i = -1;
        if (this.this$0.mApp != null) {
          i = ((KandianMergeManager)this.this$0.mApp.getManager(162)).og();
        }
        if (i < 0)
        {
          lbz.a().mY(false);
          return;
        }
        this.this$0.a(Integer.valueOf(this.aHH), (List)localObject1, false);
        localObject1 = this.this$0.c(Integer.valueOf(this.aHH));
        this.this$0.mMainThreadHandler.post(new ArticleInfoModule.19.1(this, (List)localObject1));
        return;
      }
      localObject1 = new luq.b();
      ((luq.b)localObject1).channelID = this.aHH;
      ((luq.b)localObject1).ale = false;
      ((luq.b)localObject1).it = null;
      ((luq.b)localObject1).alf = false;
      ((luq.b)localObject1).iu = null;
      ((luq.b)localObject1).alg = true;
      ((luq.b)localObject1).bo = lhf.D();
      ((luq.b)localObject1).channelType = this.aLn;
      ((luq.b)localObject1).reqType = this.JC;
      ((luq.b)localObject1).aPZ |= this.aOQ;
      ((luq.b)localObject1).aPV = this.aOR;
      if (this.ake) {
        ((luq.b)localObject1).uH = this.tl;
      }
      for (((luq.b)localObject1).uI = -1L;; ((luq.b)localObject1).uI = this.tl)
      {
        if (this.val$from == 0)
        {
          ((luq.b)localObject1).aPX |= 0x10;
          ((luq.b)localObject1).aPX |= 0x20;
          ((luq.b)localObject1).aPX |= 0x100;
          ((luq.b)localObject1).aPX |= 0x40;
          ((luq.b)localObject1).aPX |= 0x400;
          if (this.aHH == 56) {
            ((luq.b)localObject1).aPX |= 0x1080;
          }
          if (this.aHH == 0) {
            ((luq.b)localObject1).aPX |= 0x800;
          }
        }
        if (this.aHH == 40677) {
          ((luq.b)localObject1).serviceType = 2;
        }
        if (kys.dv(this.aHH)) {
          ((luq.b)localObject1).serviceType = 3;
        }
        if (knd.dh(this.aHH)) {
          ((luq.b)localObject1).alk = true;
        }
        if (!awit.aMG()) {
          ((luq.b)localObject1).aPZ |= 0x200;
        }
        QLog.d("ArticleInfoModule", 1, new Object[] { "68b params recommendFlag = ", Integer.valueOf(((luq.b)localObject1).aPZ) });
        if (this.aHH == 41695)
        {
          localObject2 = lbz.a().a();
          if (localObject2 != null)
          {
            localObject2 = ((SelectPositionModule)localObject2).a();
            if (localObject2 != null)
            {
              if (QLog.isColorLevel()) {
                QLog.i("ArticleInfoModule", 2, "loadMoreChannelArticleList positionData = " + localObject2);
              }
              ((luq.b)localObject1).e = new SelectPositionModule.PositionData();
              ((luq.b)localObject1).e.copy((SelectPositionModule.PositionData)localObject2);
            }
          }
        }
        kxm.pW(this.JC);
        this.this$0.b((luq.b)localObject1);
        return;
        ((luq.b)localObject1).uH = -1L;
      }
    }
    this.this$0.a(Integer.valueOf(this.aHH), (List)localObject1, false);
    lvd.cG((List)localObject1);
    localObject1 = this.this$0.c(Integer.valueOf(this.aHH));
    this.this$0.mMainThreadHandler.post(new ArticleInfoModule.19.2(this, (List)localObject1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule.19
 * JD-Core Version:    0.7.0.1
 */