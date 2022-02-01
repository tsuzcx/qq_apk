import android.app.Activity;
import android.content.res.Resources;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyPicWaterFallFragment.f;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopBannerInfo;
import com.tencent.biz.pubaccount.util.PreloadManager;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

class kgd
  extends lce
{
  kgd(kgc paramkgc) {}
  
  private void bQ(List<Long> paramList)
  {
    Object localObject = kxm.getAppRuntime();
    if ((!awit.Q((AppRuntime)localObject)) || (!awit.R((AppRuntime)localObject))) {}
    while ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    if (paramList.size() > 5) {}
    for (int i = 5;; i = paramList.size())
    {
      localObject = new ArrayList();
      int j = 0;
      while (j < i)
      {
        long l = ((Long)paramList.get(j)).longValue();
        ArticleInfo localArticleInfo = lbz.a().a(kgc.a(this.this$0), l);
        if ((localArticleInfo != null) && (!kxm.j(localArticleInfo))) {
          ((ArrayList)localObject).add((ArticleInfo)localArticleInfo);
        }
        j += 1;
      }
    }
    lbz.a().a().bQ((List)localObject);
  }
  
  private void mb(String paramString) {}
  
  public void a(int paramInt, boolean paramBoolean, List<ChannelCoverInfo> paramList)
  {
    super.a(paramInt, paramBoolean, paramList);
    if ((paramInt == kgc.a(this.this$0)) && (paramBoolean) && (paramList != null) && (!paramList.isEmpty())) {
      this.this$0.a.ch(paramList);
    }
  }
  
  public void a(TopBannerInfo paramTopBannerInfo) {}
  
  public void a(boolean paramBoolean, int paramInt, long paramLong, List<Long> paramList, List<ArticleInfo> paramList1) {}
  
  public void a(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2)
  {
    if (paramInt != kgc.a(this.this$0)) {
      return;
    }
    paramInt = lbz.a().a(Integer.valueOf(paramInt));
    Object localObject;
    if (paramBoolean1) {
      if ((paramList != null) && (paramInt > 0) && (paramList.size() > 0))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder("onChannelRefreshed ");
          Iterator localIterator = paramList.iterator();
          while (localIterator.hasNext())
          {
            Long localLong = (Long)localIterator.next();
            ((StringBuilder)localObject).append("recommendSeq = " + localLong + ",\n ");
          }
          QLog.d("ReadInJoyChannelWaterFallViewController_" + kgc.a(this.this$0), 1, ((StringBuilder)localObject).toString());
        }
        kgc.a(this.this$0, lbz.a().a(Integer.valueOf(kgc.a(this.this$0)), paramList), 1);
        localObject = String.format(this.this$0.getActivity().getResources().getString(2131718336), new Object[] { Integer.valueOf(paramInt) });
        this.this$0.a.t(true, (String)localObject);
      }
    }
    for (;;)
    {
      bP(paramList);
      bQ(paramList);
      return;
      if (this.this$0.a.BY())
      {
        this.this$0.a.nr(true);
        mb(this.this$0.getActivity().getResources().getString(2131718494));
      }
      else
      {
        localObject = this.this$0.getActivity().getResources().getString(2131718335);
        this.this$0.a.t(true, (String)localObject);
        continue;
        if (this.this$0.a.BY()) {
          mb(this.this$0.getActivity().getResources().getString(2131718448));
        }
        this.this$0.a.nr(paramBoolean1);
      }
    }
  }
  
  public void aCi()
  {
    this.this$0.a.notifyDataChange();
  }
  
  public void b(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2)
  {
    boolean bool = true;
    if (paramInt != kgc.a(this.this$0))
    {
      kgc.c(this.this$0, false);
      return;
    }
    if ((paramBoolean1) && (paramList != null)) {
      kgc.a(this.this$0, lbz.a().a(Integer.valueOf(kgc.a(this.this$0)), paramList), 2);
    }
    ReadInJoyPicWaterFallFragment.f localf;
    if ((paramBoolean1) && (paramList == null))
    {
      paramBoolean2 = true;
      localf = this.this$0.a;
      if (paramBoolean2) {
        break label273;
      }
    }
    for (;;)
    {
      localf.e(paramBoolean1, bool);
      if ((paramList != null) && (!paramList.isEmpty())) {
        kgc.a(this.this$0, NetConnInfoCenter.getServerTime());
      }
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyChannelWaterFallViewController", 2, "autoLoad:" + kgc.b(this.this$0) + " noMoreData:" + paramBoolean2 + " fore:" + GesturePWDUtils.isAppOnForeground(this.this$0.getActivity()));
      }
      if ((!kgc.b(this.this$0)) && (paramBoolean2) && (GesturePWDUtils.isAppOnForeground(this.this$0.getActivity())) && (kgc.a(this.this$0) != 70))
      {
        paramList = this.this$0.getActivity().getResources().getString(2131718335);
        QQToast.a(this.this$0.getActivity().getApplicationContext(), paramList, 0).show();
      }
      kgc.c(this.this$0, false);
      return;
      paramBoolean2 = false;
      break;
      label273:
      bool = false;
    }
  }
  
  public void bP(List<Long> paramList)
  {
    if (!PreloadManager.a().Gu()) {}
    for (;;)
    {
      return;
      PreloadManager.a().bdm();
      kgc.a(this.this$0);
      if ((paramList != null) && (paramList.size() >= 5))
      {
        int i = 0;
        while (i < 5)
        {
          long l = ((Long)paramList.get(i)).longValue();
          Object localObject = lbz.a().a(kgc.a(this.this$0), l);
          if ((localObject != null) && (!kxm.a(((BaseArticleInfo)localObject).mArticleContentUrl, ((BaseArticleInfo)localObject).mChannelID, (ArticleInfo)localObject)) && (!kxm.j((BaseArticleInfo)localObject)) && (!lbz.a().aO(((BaseArticleInfo)localObject).mArticleID)))
          {
            localObject = ((BaseArticleInfo)localObject).mArticleContentUrl;
            if (sum.gg((String)localObject)) {
              PreloadManager.a().oZ((String)localObject);
            }
          }
          i += 1;
        }
      }
    }
  }
  
  public void j(int paramInt, List<Long> paramList)
  {
    if (paramInt != kgc.a(this.this$0)) {
      return;
    }
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      kgc.a(this.this$0, lbz.a().a(Integer.valueOf(kgc.a(this.this$0)), paramList), 1);
      Object localObject1 = (Long)paramList.get(0);
      Object localObject2 = lbz.a().a(kgc.a(this.this$0), ((Long)localObject1).longValue());
      StringBuilder localStringBuilder = new StringBuilder().append("load history successful ! first article title : ");
      if (localObject2 != null)
      {
        localObject1 = ((ArticleInfo)localObject2).mTitle;
        localObject1 = kxm.ev((String)localObject1);
        localStringBuilder = new StringBuilder().append((String)localObject1).append(" articleID : ");
        if (localObject2 == null) {
          break label289;
        }
      }
      label289:
      for (localObject1 = Long.valueOf(((ArticleInfo)localObject2).mArticleID);; localObject1 = "-1")
      {
        localObject1 = localObject1;
        QLog.d("ReadInJoyChannelWaterFallViewController_" + kgc.a(this.this$0), 1, (String)localObject1);
        if (!QLog.isColorLevel()) {
          break label331;
        }
        localObject1 = new StringBuilder("onChannelArticleLoaded ");
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localObject2 = (Long)paramList.next();
          ((StringBuilder)localObject1).append("recommendSeq = " + localObject2 + ",\n ");
        }
        localObject1 = "";
        break;
      }
      QLog.d("ReadInJoyChannelWaterFallViewController_" + kgc.a(this.this$0), 1, ((StringBuilder)localObject1).toString());
    }
    label331:
    this.this$0.a.e(true, true);
    paramList = this.this$0;
    if (!kgc.a(this.this$0)) {}
    for (boolean bool = true;; bool = false)
    {
      if (!kgc.a(paramList, bool)) {
        kgc.a(this.this$0);
      }
      if (kgc.a(this.this$0)) {
        break;
      }
      kgc.b(this.this$0, true);
      return;
    }
  }
  
  public void k(int paramInt, List<Long> paramList)
  {
    if ((paramInt != kgc.a(this.this$0)) || (paramList == null)) {
      return;
    }
    paramList = lbz.a().a(Integer.valueOf(kgc.a(this.this$0)), paramList);
    this.this$0.a.cg(paramList);
    this.this$0.a.notifyDataChange();
  }
  
  public void l(int paramInt, List<Long> paramList)
  {
    if ((paramInt != kgc.a(this.this$0)) || (paramList == null)) {}
    do
    {
      return;
      if (paramList.size() > 0)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder("refreshChannelData ");
          localStringBuilder.append("channelID : ").append(paramInt).append("\n");
          Iterator localIterator = paramList.iterator();
          while (localIterator.hasNext())
          {
            Long localLong = (Long)localIterator.next();
            localStringBuilder.append("recommendSeq = " + localLong + ",\n ");
          }
          QLog.d("ReadInJoyChannelWaterFallViewController_" + kgc.a(this.this$0), 1, localStringBuilder.toString());
        }
        kgc.a(this.this$0, lbz.a().a(Integer.valueOf(kgc.a(this.this$0)), paramList), 1);
        return;
      }
    } while (!this.this$0.a.BY());
    mb(this.this$0.getActivity().getResources().getString(2131718494));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kgd
 * JD-Core Version:    0.7.0.1
 */