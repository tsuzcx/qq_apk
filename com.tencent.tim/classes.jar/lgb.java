import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.ProteusItemView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.AdapterView;
import com.tencent.widget.ListView;
import java.util.List;

public class lgb
  extends lfz
  implements kgi.b
{
  private final String TAG = "FrameworkHandler";
  private lgb.a jdField_a_of_type_Lgb$a = new lgb.a();
  private luy jdField_a_of_type_Luy;
  private int aOE = -1;
  public boolean afs;
  public boolean aft;
  private boolean ajV = true;
  private ImageView iS;
  private TextView oS;
  
  private void aLZ()
  {
    if ((!this.afs) && (this.aft))
    {
      this.afs = true;
      this.aft = false;
      if (nh() != lhn.oC()) {
        break label100;
      }
      odd.tabIndex = 1;
    }
    for (;;)
    {
      odd.bU("KANDIAN_NEW_FEEDS_LIST_VIEW_GROUP_MEASURE_LAYOUT_DRAW", null);
      odd.bU("KANDIAN_FEEDS_STAGE_2_COST", null);
      odd.bU("KANDIAN_FEEDS_COST", null);
      if (nh() == 56) {
        odd.bU("video_tab_cost", null);
      }
      if (this.ajV)
      {
        this.ajV = false;
        if (nh() != lhn.oC()) {
          break;
        }
        odd.bU("recommend_tab_cost", null);
      }
      return;
      label100:
      switch (nh())
      {
      default: 
        break;
      case 0: 
        odd.tabIndex = 1;
        break;
      case 56: 
        odd.tabIndex = 2;
        break;
      case 70: 
        odd.tabIndex = 3;
      }
    }
    switch (nh())
    {
    default: 
      return;
    case 0: 
      odd.bU("recommend_tab_cost", null);
      return;
    case 56: 
      odd.bU("video_tab_cost", null);
      return;
    }
    odd.bU("subscribe_tab_cost", null);
  }
  
  private void cs(View paramView)
  {
    if (paramView == null) {}
    do
    {
      return;
      this.oS = ((TextView)paramView.findViewById(2131366995));
    } while (!(a() instanceof ReadInJoyListViewGroup));
    kgi.a().a(nh(), (lgb)((ReadInJoyListViewGroup)a()).a());
  }
  
  private void ct(View paramView)
  {
    this.iS = ((ImageView)paramView.findViewById(2131369675));
    if ((nh() == 0) && (awit.Vs()))
    {
      paramView = (FrameLayout.LayoutParams)this.iS.getLayoutParams();
      paramView.setMargins(paramView.leftMargin, paramView.topMargin, aqnm.dip2px(34.0F), aqnm.dip2px(184.0F));
      this.iS.setLayoutParams(paramView);
    }
    this.iS.setOnClickListener(new lgc(this));
  }
  
  private void qT(int paramInt) {}
  
  public void O(boolean paramBoolean, int paramInt)
  {
    this.ajV = true;
    lcm.k localk;
    if ((nh() == 0) || (kys.dv(nh())))
    {
      localk = lcm.a().a;
      if (a() == null) {
        break label54;
      }
    }
    label54:
    for (ListView localListView = a().b();; localListView = null)
    {
      localk.onScrollStateChanged(localListView, 6);
      return;
    }
  }
  
  public void a(View paramView, ListView paramListView)
  {
    cs(paramView);
    ct(paramView);
    if (lvy.a().CN()) {
      this.jdField_a_of_type_Luy = new luy(getActivity(), a());
    }
  }
  
  public void aLV()
  {
    aLZ();
    lcm.k localk;
    if ((nh() == 0) || (kys.dv(nh())))
    {
      localk = lcm.a().a;
      if (a() == null) {
        break label50;
      }
    }
    label50:
    for (ListView localListView = a().b();; localListView = null)
    {
      localk.a(4, localListView);
      return;
    }
  }
  
  public void aLW()
  {
    super.aLW();
    if ((nh() == 0) || (kys.dv(nh()))) {
      lcm.a().a.aKj();
    }
  }
  
  public void aLX() {}
  
  public void aLY() {}
  
  public void b(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    ArticleInfo localArticleInfo = (ArticleInfo)getData((int)paramLong);
    if ((kys.dv(nh())) || (nh() == 0))
    {
      lcm.a().a.a(paramView, (AbsListView)paramAdapterView, localArticleInfo);
      meu.a().b(paramView, (AbsListView)paramAdapterView, localArticleInfo);
    }
  }
  
  public void ck(List<BaseArticleInfo> paramList)
  {
    this.aft = false;
  }
  
  public View d(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    System.currentTimeMillis();
    int j = c(paramInt).intValue();
    ArticleInfo localArticleInfo1 = (ArticleInfo)getData(paramInt);
    ArticleInfo localArticleInfo2 = (ArticleInfo)getData(paramInt + 1);
    if (localArticleInfo1 != null) {
      localArticleInfo1.mResolvedFeedType = j;
    }
    paramViewGroup = null;
    this.jdField_a_of_type_Lgb$a.init();
    if ((this.jdField_a_of_type_Luy != null) && (luy.Y(localArticleInfo1))) {
      paramViewGroup = this.jdField_a_of_type_Luy.a(paramView, localArticleInfo1, paramInt, a());
    }
    label216:
    do
    {
      do
      {
        do
        {
          do
          {
            return paramViewGroup;
            if ((j == 123) && (!kvx.a(a().getVafContext(), j, localArticleInfo1))) {}
            for (int i = 1;; i = 0)
            {
              if ((i != 0) || (!kvx.jdMethod_do(j))) {
                break label216;
              }
              l = System.currentTimeMillis();
              paramView = lgb.a.a(this.jdField_a_of_type_Lgb$a, paramView, localArticleInfo1, localArticleInfo2, j, paramInt);
              nxr.a("FrameworkHandler", String.valueOf(j), "getProteusNormalView", System.currentTimeMillis() - l);
              paramViewGroup = paramView;
              if (localArticleInfo1 == null) {
                break;
              }
              QLog.d("FrameworkHandler", 2, "article is normalProteusView: " + localArticleInfo1.mTitle);
              return paramView;
            }
            if (!lgb.a.a(this.jdField_a_of_type_Lgb$a).dx(j)) {
              break;
            }
            l = System.currentTimeMillis();
            paramView = lgb.a.b(this.jdField_a_of_type_Lgb$a, paramView, localArticleInfo1, localArticleInfo2, j, paramInt);
            nxr.a("FrameworkHandler", String.valueOf(j), "getDynamicProteusView", System.currentTimeMillis() - l);
            paramViewGroup = paramView;
          } while (localArticleInfo1 == null);
          QLog.d("FrameworkHandler", 2, "article is dynamicProteusView: " + localArticleInfo1.mTitle);
          return paramView;
          if (j != 38) {
            break;
          }
          l = System.currentTimeMillis();
          paramView = lgb.a.a(this.jdField_a_of_type_Lgb$a, paramView, localArticleInfo1, paramInt);
          nxr.a("FrameworkHandler", String.valueOf(j), "getArkAppView", System.currentTimeMillis() - l);
          paramViewGroup = paramView;
        } while (localArticleInfo1 == null);
        QLog.d("FrameworkHandler", 2, "article is arkAppView: " + localArticleInfo1.mTitle);
        return paramView;
      } while (!lwj.dM(j));
      long l = System.currentTimeMillis();
      paramView = lgb.a.a(this.jdField_a_of_type_Lgb$a, paramView, localArticleInfo1, j, paramInt);
      nxr.a("FrameworkHandler", String.valueOf(j), "cellRebuildCompleted", System.currentTimeMillis() - l);
      paramViewGroup = paramView;
    } while (localArticleInfo1 == null);
    QLog.d("FrameworkHandler", 2, "article is cellRebuildView: " + localArticleInfo1.mTitle);
    return paramView;
  }
  
  public boolean df(int paramInt)
  {
    this.jdField_a_of_type_Lgb$a.init();
    if (kmz.dg(paramInt)) {}
    while ((!kvx.jdMethod_do(paramInt)) && (!lgb.a.a(this.jdField_a_of_type_Lgb$a).dx(paramInt)) && (38 != paramInt) && (!lwj.dM(paramInt)) && (!luy.dx(paramInt))) {
      return false;
    }
    return true;
  }
  
  public void mc(String paramString)
  {
    if (this.oS != null)
    {
      this.oS.setText(paramString);
      this.oS.setVisibility(0);
    }
  }
  
  public int np()
  {
    return 2;
  }
  
  public void onDestroy()
  {
    kgi.a().b(nh(), this);
    if (this.jdField_a_of_type_Luy != null) {
      this.jdField_a_of_type_Luy.destroy();
    }
  }
  
  public void onListViewScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    qT(paramInt1);
    if ((nh() == 0) || (kys.dv(nh()))) {
      lcm.a().a.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void onListViewScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    super.onListViewScrollStateChanged(paramAbsListView, paramInt);
    if ((nh() == 0) || (kys.dv(nh()))) {
      lcm.a().a.onScrollStateChanged(paramAbsListView, paramInt);
    }
  }
  
  public void onPause()
  {
    kpc.ps(nh());
    mrh.a().aRx();
    lcm.k localk;
    if ((nh() == 0) || (kys.dv(nh())))
    {
      localk = lcm.a().a;
      if (a() == null) {
        break label59;
      }
    }
    label59:
    for (ListView localListView = a().b();; localListView = null)
    {
      localk.onScrollStateChanged(localListView, 5);
      return;
    }
  }
  
  public void onResume()
  {
    this.ajV = true;
    kpc.pt(nh());
  }
  
  public void onStart()
  {
    super.onStart();
    QLog.d("FrameworkHandler", 2, "doStart!");
  }
  
  public class a
  {
    private lrj b;
    private volatile boolean isInit;
    private VafContext mVafContext;
    
    public a() {}
    
    private View a(View paramView, ArticleInfo paramArticleInfo, int paramInt)
    {
      if (paramArticleInfo != null)
      {
        ArkAppMessage localArkAppMessage = kpc.a(paramArticleInfo.mArkAppFeedsInfo);
        if (QLog.isColorLevel()) {
          QLog.d("FrameworkHandler", 2, new Object[] { "getArkAppView, position: ", Integer.valueOf(paramInt), ", articleInfo: ", paramArticleInfo, ", arkAppMessage: ", localArkAppMessage });
        }
        return a(paramArticleInfo, paramView, localArkAppMessage);
      }
      kpc.cf(paramView);
      return paramView;
    }
    
    private View a(View paramView, ArticleInfo paramArticleInfo1, ArticleInfo paramArticleInfo2, int paramInt1, int paramInt2)
    {
      paramArticleInfo2 = new lis(lgb.this.getActivity(), paramArticleInfo1, paramInt1, lgb.this.nh(), lgb.this.ni(), paramInt2, lgb.this.Cb(), lgb.this.getCount(), paramArticleInfo2, lgb.this.a());
      paramArticleInfo2.d(this.mVafContext);
      long l;
      if ((paramView != null) && ((paramView instanceof ProteusItemView)))
      {
        l = System.currentTimeMillis();
        kvx.a((ProteusItemView)paramView, paramInt1, paramArticleInfo1, this.mVafContext, lgb.this.a(), lgb.this.a(), paramArticleInfo2, paramInt2, "default_feeds");
        paramView = (ProteusItemView)paramView;
        nxr.a("FrameworkHandler", String.valueOf(paramInt1), "getProteusNormalView.convertview#bindData", System.currentTimeMillis() - l);
      }
      for (;;)
      {
        if ((paramView != null) && (paramView.a() != null))
        {
          l = System.currentTimeMillis();
          paramArticleInfo1 = lgb.this.f();
          paramView.a().setTag(2131370016, paramArticleInfo1);
          paramView.setTag(2131381960, paramArticleInfo2);
          nxr.a("FrameworkHandler", String.valueOf(paramInt1), "getProteusNormalView.setTag", System.currentTimeMillis() - l);
        }
        return paramView;
        l = System.currentTimeMillis();
        paramView = kvx.a(this.mVafContext, paramInt1, paramArticleInfo1);
        nxr.a("FrameworkHandler", String.valueOf(paramInt1), "getProteusNormalView.getView", System.currentTimeMillis() - l);
        l = System.currentTimeMillis();
        kvx.a(paramView, paramInt1, paramArticleInfo1, this.mVafContext, lgb.this.a(), lgb.this.a(), paramArticleInfo2, paramInt2, "default_feeds");
        nxr.a("FrameworkHandler", String.valueOf(paramInt1), "getProteusNormalView.newview#bindData", System.currentTimeMillis() - l);
      }
    }
    
    private View a(BaseArticleInfo paramBaseArticleInfo, View paramView, ArkAppMessage paramArkAppMessage)
    {
      Object localObject2;
      if (paramBaseArticleInfo == null)
      {
        localObject2 = paramView;
        return localObject2;
      }
      Object localObject1;
      if ((paramView != null) && ((paramView.getTag() instanceof kpa))) {
        localObject1 = (kpa)paramView.getTag();
      }
      for (;;)
      {
        localObject2 = paramView;
        if (localObject1 == null) {
          break;
        }
        localObject2 = paramView;
        if (paramView == null) {
          break;
        }
        if (!kpc.a(paramArkAppMessage)) {
          break label127;
        }
        ((kpa)localObject1).a(paramArkAppMessage, paramBaseArticleInfo);
        ((kpa)localObject1).aFE();
        kpc.ce(paramView);
        return paramView;
        localObject2 = new kpa(paramArkAppMessage, paramBaseArticleInfo);
        kpc.a((kpa)localObject2, lgb.this.nh());
        localObject1 = localObject2;
        if (((kpa)localObject2).S() != null)
        {
          paramView = ((kpa)localObject2).S();
          paramView.setTag(localObject2);
          localObject1 = localObject2;
        }
      }
      label127:
      kpc.a(paramArkAppMessage, 0);
      kpc.cf(paramView);
      return paramView;
    }
    
    private View b(View paramView, ArticleInfo paramArticleInfo, int paramInt1, int paramInt2)
    {
      Object localObject = new lis(lgb.this.getActivity(), paramArticleInfo, paramInt1, lgb.this.nh(), lgb.this.ni(), paramInt2, lgb.this.Cb(), lgb.this.getCount(), null, lgb.this.a());
      View localView = lwj.a(paramInt2, localObject, paramInt1, paramView, lgb.this.getActivity(), lgb.this.a(), lgb.this.a());
      if (localView != null)
      {
        localView.setTag(2131381960, localObject);
        if (QLog.isColorLevel()) {
          QLog.d("FrameworkHandler", 2, "CellFactory.getView = " + localView.getTag().getClass().getSimpleName());
        }
        localView.setTag(2131370016, lgb.this.f());
        if (paramArticleInfo == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("FrameworkHandler", 2, "getView() article is null, set view gone, position: " + paramInt2);
          }
          if (localView.getVisibility() != 8) {
            localView.setVisibility(8);
          }
          if ((localView.getLayoutParams() instanceof AbsListView.LayoutParams))
          {
            paramView = (AbsListView.LayoutParams)localView.getLayoutParams();
            if (paramView.height != 1)
            {
              paramView.height = 1;
              localView.setLayoutParams(paramView);
            }
          }
          if (localView != null) {
            break label417;
          }
          paramInt1 = 0;
          label256:
          localObject = lgb.this.ni() + "";
          if (paramArticleInfo == null) {
            break label422;
          }
        }
      }
      label417:
      label422:
      for (paramView = String.valueOf(paramArticleInfo.mArticleID);; paramView = "")
      {
        kbp.a(null, "", "0X80095B4", "0X80095B4", 0, paramInt1, (String)localObject, paramView, lgb.this.nh() + "", "", false);
        return localView;
        if (localView.getVisibility() != 0) {
          localView.setVisibility(0);
        }
        if (!(localView.getLayoutParams() instanceof AbsListView.LayoutParams)) {
          break;
        }
        paramView = (AbsListView.LayoutParams)localView.getLayoutParams();
        if (paramView.height == -2) {
          break;
        }
        paramView.height = -2;
        localView.setLayoutParams(paramView);
        break;
        QLog.w("FrameworkHandler", 1, "CellFactory.getView = null");
        break;
        paramInt1 = 1;
        break label256;
      }
    }
    
    private View b(View paramView, ArticleInfo paramArticleInfo1, ArticleInfo paramArticleInfo2, int paramInt1, int paramInt2)
    {
      paramArticleInfo2 = new lis(lgb.this.getActivity(), paramArticleInfo1, paramInt1, lgb.this.nh(), lgb.this.ni(), paramInt2, lgb.this.Cb(), lgb.this.getCount(), paramArticleInfo2, lgb.this.a());
      long l;
      if ((paramView != null) && ((paramView instanceof ProteusItemView)))
      {
        l = System.currentTimeMillis();
        this.b.a((ProteusItemView)paramView, paramInt1, paramArticleInfo1, this.mVafContext, lgb.this.a(), lgb.this.a(), paramArticleInfo2, paramInt2);
        nxr.a("FrameworkHandler", String.valueOf(paramInt1), "getDynamicProteusView.convertview#bindData", System.currentTimeMillis() - l);
        paramView = (ProteusItemView)paramView;
      }
      for (;;)
      {
        paramArticleInfo1 = lgb.this.f();
        if (paramView.a() != null) {
          paramView.a().setTag(2131370016, paramArticleInfo1);
        }
        paramView.setTag(2131381960, paramArticleInfo2);
        return paramView;
        l = System.currentTimeMillis();
        paramView = this.b.a(this.mVafContext, paramInt1, paramArticleInfo1);
        nxr.a("FrameworkHandler", String.valueOf(paramInt1), "getDynamicProteusView.getView", System.currentTimeMillis() - l);
        l = System.currentTimeMillis();
        this.b.a(paramView, paramInt1, paramArticleInfo1, this.mVafContext, lgb.this.a(), lgb.this.a(), paramArticleInfo2, paramInt2);
        nxr.a("FrameworkHandler", String.valueOf(paramInt1), "getDynamicProteusView.newview#bindData", System.currentTimeMillis() - l);
      }
    }
    
    public void init()
    {
      try
      {
        if (!this.isInit)
        {
          this.mVafContext = lgb.this.a().getVafContext();
          this.b = lgb.this.a().a();
          this.isInit = true;
        }
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lgb
 * JD-Core Version:    0.7.0.1
 */