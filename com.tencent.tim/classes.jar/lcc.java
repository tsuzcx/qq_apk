import android.content.res.Configuration;
import android.support.annotation.UiThread;
import android.util.SparseArray;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.model.DiandianTopConfig;
import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule.PositionData;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.InterestLabelInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.RecommendFollowInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TagInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopBannerInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import tencent.im.oidb.cmd0xbd6.oidb_cmd0xbd6.RspBody;
import tencent.im.oidb.cmd0xc6d.oidb_cmd0xc6d.ModuleInfo;
import tencent.im.oidb.cmd0xc6d.oidb_cmd0xc6d.TextCardInfo;

public class lcc
{
  private static lcc a;
  private final CopyOnWriteArrayList<lce> p = new CopyOnWriteArrayList();
  
  public static lcc a()
  {
    try
    {
      if (a == null) {
        a = new lcc();
      }
      return a;
    }
    finally {}
  }
  
  public void V(long paramLong, boolean paramBoolean)
  {
    synchronized (this.p)
    {
      Iterator localIterator = this.p.iterator();
      if (localIterator.hasNext()) {
        ((lce)localIterator.next()).V(paramLong, paramBoolean);
      }
    }
  }
  
  public void W(long paramLong, boolean paramBoolean)
  {
    synchronized (this.p)
    {
      Iterator localIterator = this.p.iterator();
      if (localIterator.hasNext()) {
        ((lce)localIterator.next()).W(paramLong, paramBoolean);
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, lhs paramlhs)
  {
    synchronized (this.p)
    {
      Iterator localIterator = this.p.iterator();
      if (localIterator.hasNext()) {
        ((lce)localIterator.next()).a(paramInt1, paramInt2, paramInt3, paramBoolean, paramlhs);
      }
    }
  }
  
  public void a(int paramInt1, long paramLong, String paramString1, int paramInt2, String paramString2, String paramString3)
  {
    synchronized (this.p)
    {
      Iterator localIterator = this.p.iterator();
      if (localIterator.hasNext()) {
        ((lce)localIterator.next()).a(paramInt1, paramLong, paramString1, paramInt2, paramString2, paramString3);
      }
    }
  }
  
  public void a(int paramInt1, long paramLong, List<Long> paramList, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    synchronized (this.p)
    {
      Iterator localIterator = this.p.iterator();
      if (localIterator.hasNext()) {
        ((lce)localIterator.next()).a(paramInt1, paramLong, paramList, paramInt2, paramInt3, paramBoolean);
      }
    }
  }
  
  public void a(int paramInt, SelectPositionModule.PositionData paramPositionData)
  {
    synchronized (this.p)
    {
      Iterator localIterator = new ArrayList(this.p).iterator();
      if (localIterator.hasNext()) {
        ((lce)localIterator.next()).a(paramInt, paramPositionData);
      }
    }
  }
  
  public void a(int paramInt, ArticleInfo paramArticleInfo, String paramString1, String paramString2)
  {
    synchronized (this.p)
    {
      Iterator localIterator = this.p.iterator();
      if (localIterator.hasNext()) {
        ((lce)localIterator.next()).a(paramInt, paramArticleInfo, paramString1, paramString2);
      }
    }
  }
  
  public void a(int paramInt, mhn parammhn)
  {
    synchronized (this.p)
    {
      Iterator localIterator = this.p.iterator();
      if (localIterator.hasNext()) {
        ((lce)localIterator.next()).b(paramInt, parammhn);
      }
    }
  }
  
  public void a(int paramInt, boolean paramBoolean, List<ChannelCoverInfo> paramList)
  {
    synchronized (this.p)
    {
      Iterator localIterator = this.p.iterator();
      if (localIterator.hasNext()) {
        ((lce)localIterator.next()).a(paramInt, paramBoolean, paramList);
      }
    }
  }
  
  public void a(Configuration paramConfiguration)
  {
    synchronized (this.p)
    {
      Iterator localIterator = this.p.iterator();
      if (localIterator.hasNext()) {
        ((lce)localIterator.next()).a(paramConfiguration);
      }
    }
  }
  
  public void a(ArticleInfo paramArticleInfo, boolean paramBoolean)
  {
    synchronized (this.p)
    {
      Iterator localIterator = this.p.iterator();
      if (localIterator.hasNext()) {
        ((lce)localIterator.next()).a(paramArticleInfo, paramBoolean);
      }
    }
  }
  
  public void a(TopBannerInfo paramTopBannerInfo)
  {
    synchronized (this.p)
    {
      Iterator localIterator = this.p.iterator();
      if (localIterator.hasNext()) {
        ((lce)localIterator.next()).a(paramTopBannerInfo);
      }
    }
  }
  
  public void a(Object paramObject, int paramInt, boolean paramBoolean, String... paramVarArgs)
  {
    synchronized (this.p)
    {
      Iterator localIterator = this.p.iterator();
      if (localIterator.hasNext()) {
        ((lce)localIterator.next()).a(paramObject, paramInt, paramBoolean, paramVarArgs);
      }
    }
  }
  
  public void a(String paramString1, int paramInt1, long paramLong, String paramString2, int paramInt2, String paramString3, String paramString4)
  {
    synchronized (this.p)
    {
      Iterator localIterator = this.p.iterator();
      if (localIterator.hasNext()) {
        ((lce)localIterator.next()).a(paramString1, paramInt1, paramLong, paramString2, paramInt2, paramString3, paramString4);
      }
    }
  }
  
  public void a(String paramString1, int paramInt, oidb_cmd0xbd6.RspBody paramRspBody, String paramString2)
  {
    synchronized (this.p)
    {
      Iterator localIterator = this.p.iterator();
      if (localIterator.hasNext()) {
        ((lce)localIterator.next()).b(paramString1, paramInt, paramRspBody, paramString2);
      }
    }
  }
  
  public void a(ArrayList<String> paramArrayList, List<oidb_cmd0xc6d.ModuleInfo> paramList, List<oidb_cmd0xc6d.TextCardInfo> paramList1)
  {
    synchronized (this.p)
    {
      Iterator localIterator = this.p.iterator();
      if (localIterator.hasNext()) {
        ((lce)localIterator.next()).b(paramArrayList, paramList, paramList1);
      }
    }
  }
  
  public void a(lcc.a parama)
  {
    synchronized (this.p)
    {
      Iterator localIterator = this.p.iterator();
      if (localIterator.hasNext()) {
        parama.a((lce)localIterator.next());
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, long paramLong, List<Long> paramList, List<ArticleInfo> paramList1)
  {
    synchronized (this.p)
    {
      Iterator localIterator = this.p.iterator();
      if (localIterator.hasNext()) {
        ((lce)localIterator.next()).a(paramBoolean, paramInt, paramLong, paramList, paramList1);
      }
    }
  }
  
  public void a(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2)
  {
    synchronized (this.p)
    {
      Iterator localIterator = this.p.iterator();
      if (localIterator.hasNext()) {
        ((lce)localIterator.next()).a(paramBoolean1, paramInt, paramList, paramBoolean2);
      }
    }
  }
  
  public void a(boolean paramBoolean, long paramLong, List<RecommendFollowInfo> paramList)
  {
    synchronized (this.p)
    {
      Iterator localIterator = this.p.iterator();
      if (localIterator.hasNext()) {
        ((lce)localIterator.next()).a(paramBoolean, paramLong, paramList);
      }
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    synchronized (this.p)
    {
      Iterator localIterator = this.p.iterator();
      if (localIterator.hasNext()) {
        ((lce)localIterator.next()).b(paramBoolean, paramString1, paramString2, paramString3, paramInt1, paramInt2);
      }
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, int paramInt2, String paramString5)
  {
    synchronized (this.p)
    {
      Iterator localIterator = this.p.iterator();
      if (localIterator.hasNext()) {
        ((lce)localIterator.next()).b(paramBoolean, paramString1, paramString2, paramString3, paramInt1, paramString4, paramInt2, paramString5);
      }
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    synchronized (this.p)
    {
      Iterator localIterator = this.p.iterator();
      if (localIterator.hasNext()) {
        ((lce)localIterator.next()).b(paramBoolean, paramString1, paramString2, paramString3, paramString4, paramInt);
      }
    }
  }
  
  public void aCi()
  {
    synchronized (this.p)
    {
      Iterator localIterator = this.p.iterator();
      if (localIterator.hasNext()) {
        ((lce)localIterator.next()).aCi();
      }
    }
  }
  
  public void aD(String paramString, int paramInt)
  {
    synchronized (this.p)
    {
      Iterator localIterator = this.p.iterator();
      if (localIterator.hasNext()) {
        ((lce)localIterator.next()).aD(paramString, paramInt);
      }
    }
  }
  
  public void aJB()
  {
    ??? = this.p.iterator();
    lce locallce;
    do
    {
      if (!((Iterator)???).hasNext()) {
        break;
      }
      locallce = (lce)((Iterator)???).next();
    } while (!(locallce instanceof acza));
    for (;;)
    {
      synchronized (this.p)
      {
        this.p.clear();
        if (locallce != null) {
          this.p.add(locallce);
        }
        return;
      }
      Object localObject2 = null;
    }
  }
  
  public void aJC()
  {
    synchronized (this.p)
    {
      Iterator localIterator = this.p.iterator();
      if (localIterator.hasNext()) {
        ((lce)localIterator.next()).aJC();
      }
    }
  }
  
  public void aJD()
  {
    synchronized (this.p)
    {
      Iterator localIterator = this.p.iterator();
      if (localIterator.hasNext()) {
        ((lce)localIterator.next()).aJD();
      }
    }
  }
  
  public void aJE()
  {
    synchronized (this.p)
    {
      Iterator localIterator = this.p.iterator();
      if (localIterator.hasNext()) {
        ((lce)localIterator.next()).aJE();
      }
    }
  }
  
  public void aJF()
  {
    synchronized (this.p)
    {
      Iterator localIterator = this.p.iterator();
      if (localIterator.hasNext()) {
        ((lce)localIterator.next()).aJF();
      }
    }
  }
  
  public void aJG()
  {
    synchronized (this.p)
    {
      Iterator localIterator = this.p.iterator();
      if (localIterator.hasNext()) {
        ((lce)localIterator.next()).aJG();
      }
    }
  }
  
  public void aJH()
  {
    synchronized (this.p)
    {
      Iterator localIterator = this.p.iterator();
      if (localIterator.hasNext()) {
        ((lce)localIterator.next()).aJH();
      }
    }
  }
  
  public void aJI()
  {
    synchronized (this.p)
    {
      Iterator localIterator = this.p.iterator();
      if (localIterator.hasNext()) {
        ((lce)localIterator.next()).aJI();
      }
    }
  }
  
  public void aJJ()
  {
    synchronized (this.p)
    {
      Iterator localIterator = this.p.iterator();
      if (localIterator.hasNext()) {
        ((lce)localIterator.next()).aJJ();
      }
    }
  }
  
  public void b(lce paramlce)
  {
    if (paramlce == null) {}
    while (this.p.contains(paramlce)) {
      return;
    }
    synchronized (this.p)
    {
      this.p.add(paramlce);
      return;
    }
  }
  
  public void b(boolean paramBoolean, int paramInt, SparseArray<ChannelInfo> paramSparseArray)
  {
    synchronized (this.p)
    {
      Iterator localIterator = this.p.iterator();
      if (localIterator.hasNext()) {
        ((lce)localIterator.next()).a(paramBoolean, paramInt, paramSparseArray);
      }
    }
  }
  
  public void b(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2)
  {
    synchronized (this.p)
    {
      Iterator localIterator = this.p.iterator();
      if (localIterator.hasNext()) {
        ((lce)localIterator.next()).b(paramBoolean1, paramInt, paramList, paramBoolean2);
      }
    }
  }
  
  public void b(boolean paramBoolean, List<Long> paramList, List<ArticleInfo> paramList1)
  {
    synchronized (this.p)
    {
      Iterator localIterator = this.p.iterator();
      if (localIterator.hasNext()) {
        ((lce)localIterator.next()).a(paramBoolean, paramList, paramList1);
      }
    }
  }
  
  public void bR(List<oal> paramList)
  {
    synchronized (this.p)
    {
      Iterator localIterator = this.p.iterator();
      if (localIterator.hasNext()) {
        ((lce)localIterator.next()).bR(paramList);
      }
    }
  }
  
  public void bZ(View paramView)
  {
    synchronized (this.p)
    {
      Iterator localIterator = this.p.iterator();
      if (localIterator.hasNext()) {
        ((lce)localIterator.next()).bZ(paramView);
      }
    }
  }
  
  public void c(float paramFloat, int paramInt)
  {
    synchronized (this.p)
    {
      Iterator localIterator = this.p.iterator();
      if (localIterator.hasNext()) {
        ((lce)localIterator.next()).c(paramFloat, paramInt);
      }
    }
  }
  
  public void c(int paramInt, long paramLong, String paramString)
  {
    synchronized (this.p)
    {
      Iterator localIterator = this.p.iterator();
      if (localIterator.hasNext()) {
        ((lce)localIterator.next()).c(paramInt, paramLong, paramString);
      }
    }
  }
  
  public void c(lce paramlce)
  {
    synchronized (this.p)
    {
      this.p.remove(paramlce);
      return;
    }
  }
  
  public void c(boolean paramBoolean1, List<mhg> paramList, long paramLong, boolean paramBoolean2)
  {
    synchronized (this.p)
    {
      Iterator localIterator = this.p.iterator();
      if (localIterator.hasNext()) {
        ((lce)localIterator.next()).b(paramBoolean1, paramList, paramLong, paramBoolean2);
      }
    }
  }
  
  public void cc(List<InterestLabelInfo> paramList)
  {
    synchronized (this.p)
    {
      Iterator localIterator = this.p.iterator();
      if (localIterator.hasNext()) {
        ((lce)localIterator.next()).cc(paramList);
      }
    }
  }
  
  public void cd(List<TagInfo> paramList)
  {
    synchronized (this.p)
    {
      Iterator localIterator = this.p.iterator();
      if (localIterator.hasNext()) {
        ((lce)localIterator.next()).cd(paramList);
      }
    }
  }
  
  public void cp(int paramInt1, int paramInt2)
  {
    synchronized (this.p)
    {
      Iterator localIterator = this.p.iterator();
      if (localIterator.hasNext()) {
        ((lce)localIterator.next()).cp(paramInt1, paramInt2);
      }
    }
  }
  
  public void d(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    synchronized (this.p)
    {
      Iterator localIterator = new ArrayList(this.p).iterator();
      if (localIterator.hasNext()) {
        ((lce)localIterator.next()).d(paramTabChannelCoverInfo);
      }
    }
  }
  
  public void d(boolean paramBoolean, List<TabChannelCoverInfo> paramList)
  {
    synchronized (this.p)
    {
      Iterator localIterator = new ArrayList(this.p).iterator();
      if (localIterator.hasNext()) {
        ((lce)localIterator.next()).d(paramBoolean, paramList);
      }
    }
  }
  
  public void d(boolean paramBoolean1, List<mhg> paramList, long paramLong, boolean paramBoolean2)
  {
    synchronized (this.p)
    {
      Iterator localIterator = this.p.iterator();
      if (localIterator.hasNext()) {
        ((lce)localIterator.next()).a(paramBoolean1, paramList, paramLong, paramBoolean2);
      }
    }
  }
  
  public void e(boolean paramBoolean1, List<mhf> paramList, long paramLong, boolean paramBoolean2)
  {
    synchronized (this.p)
    {
      Iterator localIterator = this.p.iterator();
      if (localIterator.hasNext()) {
        ((lce)localIterator.next()).f(paramBoolean1, paramList, paramLong, paramBoolean2);
      }
    }
  }
  
  public void g(boolean paramBoolean, List<ChannelCoverInfo> paramList)
  {
    synchronized (this.p)
    {
      Iterator localIterator = this.p.iterator();
      if (localIterator.hasNext()) {
        ((lce)localIterator.next()).g(paramBoolean, paramList);
      }
    }
  }
  
  public void h(int paramInt, Object paramObject)
  {
    synchronized (this.p)
    {
      Iterator localIterator = this.p.iterator();
      if (localIterator.hasNext()) {
        ((lce)localIterator.next()).h(paramInt, paramObject);
      }
    }
  }
  
  public void h(long paramLong, int paramInt, String paramString)
  {
    synchronized (this.p)
    {
      Iterator localIterator = this.p.iterator();
      if (localIterator.hasNext()) {
        ((lce)localIterator.next()).h(paramLong, paramInt, paramString);
      }
    }
  }
  
  public void i(String paramString1, String paramString2, int paramInt)
  {
    synchronized (this.p)
    {
      Iterator localIterator = this.p.iterator();
      if (localIterator.hasNext()) {
        ((lce)localIterator.next()).j(paramString1, paramString2, paramInt);
      }
    }
  }
  
  public void i(boolean paramBoolean, List<DiandianTopConfig> paramList)
  {
    synchronized (this.p)
    {
      Iterator localIterator = this.p.iterator();
      if (localIterator.hasNext()) {
        ((lce)localIterator.next()).i(paramBoolean, paramList);
      }
    }
  }
  
  public void j(int paramInt, List<Long> paramList)
  {
    synchronized (this.p)
    {
      Iterator localIterator = this.p.iterator();
      if (localIterator.hasNext()) {
        ((lce)localIterator.next()).j(paramInt, paramList);
      }
    }
  }
  
  public void j(boolean paramBoolean, List<ChannelInfo> paramList)
  {
    synchronized (this.p)
    {
      Iterator localIterator = this.p.iterator();
      if (localIterator.hasNext()) {
        ((lce)localIterator.next()).j(paramBoolean, paramList);
      }
    }
  }
  
  public void k(int paramInt, List<Long> paramList)
  {
    synchronized (this.p)
    {
      Iterator localIterator = this.p.iterator();
      if (localIterator.hasNext()) {
        ((lce)localIterator.next()).k(paramInt, paramList);
      }
    }
  }
  
  public void k(boolean paramBoolean, List<ChannelInfo> paramList)
  {
    synchronized (this.p)
    {
      Iterator localIterator = this.p.iterator();
      if (localIterator.hasNext()) {
        ((lce)localIterator.next()).k(paramBoolean, paramList);
      }
    }
  }
  
  public void l(int paramInt, List<Long> paramList)
  {
    synchronized (this.p)
    {
      Iterator localIterator = this.p.iterator();
      if (localIterator.hasNext()) {
        ((lce)localIterator.next()).l(paramInt, paramList);
      }
    }
  }
  
  public void l(List<String> paramList, List<TopicInfo> paramList1)
  {
    synchronized (this.p)
    {
      Iterator localIterator = this.p.iterator();
      if (localIterator.hasNext()) {
        ((lce)localIterator.next()).l(paramList, paramList1);
      }
    }
  }
  
  public void l(boolean paramBoolean, List<Integer> paramList)
  {
    synchronized (this.p)
    {
      Iterator localIterator = this.p.iterator();
      if (localIterator.hasNext()) {
        ((lce)localIterator.next()).l(paramBoolean, paramList);
      }
    }
  }
  
  public void lT(boolean paramBoolean)
  {
    synchronized (this.p)
    {
      Iterator localIterator = new ArrayList(this.p).iterator();
      if (localIterator.hasNext()) {
        ((lce)localIterator.next()).lT(paramBoolean);
      }
    }
  }
  
  public void m(boolean paramBoolean, List<ChannelCoverInfo> paramList)
  {
    synchronized (this.p)
    {
      Iterator localIterator = this.p.iterator();
      if (localIterator.hasNext()) {
        ((lce)localIterator.next()).e(paramBoolean, paramList);
      }
    }
  }
  
  public void mh(String paramString)
  {
    synchronized (this.p)
    {
      Iterator localIterator = this.p.iterator();
      if (localIterator.hasNext()) {
        ((lce)localIterator.next()).mh(paramString);
      }
    }
  }
  
  public void n(boolean paramBoolean, List<ChannelCoverInfo> paramList)
  {
    synchronized (this.p)
    {
      Iterator localIterator = this.p.iterator();
      if (localIterator.hasNext()) {
        ((lce)localIterator.next()).n(paramBoolean, paramList);
      }
    }
  }
  
  public void nc(boolean paramBoolean)
  {
    synchronized (this.p)
    {
      Iterator localIterator = this.p.iterator();
      if (localIterator.hasNext()) {
        ((lce)localIterator.next()).nf(paramBoolean);
      }
    }
  }
  
  public void nd(boolean paramBoolean)
  {
    synchronized (this.p)
    {
      Iterator localIterator = this.p.iterator();
      if (localIterator.hasNext()) {
        ((lce)localIterator.next()).nd(paramBoolean);
      }
    }
  }
  
  @UiThread
  public void ne(boolean paramBoolean)
  {
    synchronized (this.p)
    {
      Iterator localIterator = this.p.iterator();
      if (localIterator.hasNext()) {
        ((lce)localIterator.next()).lO(paramBoolean);
      }
    }
  }
  
  public void o(String paramString, int paramInt1, int paramInt2)
  {
    synchronized (this.p)
    {
      Iterator localIterator = this.p.iterator();
      if (localIterator.hasNext()) {
        ((lce)localIterator.next()).o(paramString, paramInt1, paramInt2);
      }
    }
  }
  
  public void o(boolean paramBoolean, String paramString)
  {
    synchronized (this.p)
    {
      Iterator localIterator = this.p.iterator();
      if (localIterator.hasNext()) {
        ((lce)localIterator.next()).o(paramBoolean, paramString);
      }
    }
  }
  
  public void oC(int paramInt)
  {
    synchronized (this.p)
    {
      Iterator localIterator = new ArrayList(this.p).iterator();
      if (localIterator.hasNext()) {
        ((lce)localIterator.next()).oC(paramInt);
      }
    }
  }
  
  public void oU(int paramInt)
  {
    synchronized (this.p)
    {
      Iterator localIterator = this.p.iterator();
      if (localIterator.hasNext()) {
        ((lce)localIterator.next()).oU(paramInt);
      }
    }
  }
  
  public void oV(int paramInt)
  {
    synchronized (this.p)
    {
      Iterator localIterator = this.p.iterator();
      if (localIterator.hasNext()) {
        ((lce)localIterator.next()).oV(paramInt);
      }
    }
  }
  
  public void onDrawerOpened()
  {
    Iterator localIterator = this.p.iterator();
    while (localIterator.hasNext()) {
      ((lce)localIterator.next()).onDrawerOpened();
    }
  }
  
  public void onThemeChanged()
  {
    synchronized (this.p)
    {
      Iterator localIterator = this.p.iterator();
      if (localIterator.hasNext()) {
        ((lce)localIterator.next()).onThemeChanged();
      }
    }
  }
  
  public void pe(int paramInt)
  {
    synchronized (this.p)
    {
      Iterator localIterator = this.p.iterator();
      if (localIterator.hasNext()) {
        ((lce)localIterator.next()).pe(paramInt);
      }
    }
  }
  
  public void qA(int paramInt)
  {
    synchronized (this.p)
    {
      Iterator localIterator = this.p.iterator();
      if (localIterator.hasNext()) {
        ((lce)localIterator.next()).qA(paramInt);
      }
    }
  }
  
  public void qy(int paramInt)
  {
    synchronized (this.p)
    {
      Iterator localIterator = this.p.iterator();
      if (localIterator.hasNext()) {
        ((lce)localIterator.next()).qy(paramInt);
      }
    }
  }
  
  public void qz(int paramInt)
  {
    synchronized (this.p)
    {
      Iterator localIterator = this.p.iterator();
      if (localIterator.hasNext()) {
        ((lce)localIterator.next()).qB(paramInt);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(lce paramlce);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lcc
 * JD-Core Version:    0.7.0.1
 */