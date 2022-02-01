import android.app.Activity;
import android.content.ContextWrapper;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.DecelerateInterpolator;
import android.widget.ListAdapter;
import com.tencent.biz.pubaccount.readinjoy.ad.handlers.AdHandler.3;
import com.tencent.biz.pubaccount.readinjoy.ad.view.KandianAdPandentMask;
import com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInJoyAdVideoGuide;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.ProteusItemView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ViewBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.AdapterView;
import com.tencent.widget.ListView;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.List;

public class klc
  extends lfz
{
  private static kmw.a jdField_a_of_type_Kmw$a = new kmw.a();
  private final String TAG = "AdHandler";
  private SparseArray<View> Y = new SparseArray(1);
  private DecelerateInterpolator jdField_a_of_type_AndroidViewAnimationDecelerateInterpolator = new DecelerateInterpolator(this.iI);
  private KandianAdPandentMask jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewKandianAdPandentMask;
  private klc.a jdField_a_of_type_Klc$a = new klc.a();
  private int aJT;
  private int aJU = -1;
  private boolean agi;
  private boolean agj;
  private ListView b;
  private AdvertisementInfo c;
  private float iG = aqgz.getDispalyDpi() * 500 / 160.0F;
  private float iH = aqgz.getDispalyDpi() * 1000 / 160.0F;
  private float iI = 1.5F;
  private int mChannelID;
  protected lce mObserver = new kle(this);
  
  private void a(ArticleInfo paramArticleInfo, long paramLong, View paramView)
  {
    Activity localActivity = getActivity();
    int i = nh();
    ndh localndh = (ndh)a();
    long l;
    AdvertisementInfo localAdvertisementInfo;
    if (AdvertisementInfo.isAdvertisementInfo(paramArticleInfo))
    {
      if (knd.dh(i))
      {
        lbz.a().H(paramArticleInfo.mArticleID, System.currentTimeMillis());
        if (localndh != null) {
          localndh.notifyDataSetChanged();
        }
      }
      if (localndh != null)
      {
        localndh.a = ods.a(localActivity, (AdvertisementInfo)paramArticleInfo, localndh, i, false, null);
        if (localndh.a == null) {
          break label126;
        }
        l = SystemClock.elapsedRealtime();
        localndh.sr = l;
      }
      if (!(paramArticleInfo instanceof AdvertisementInfo)) {
        break label186;
      }
      localAdvertisementInfo = (AdvertisementInfo)paramArticleInfo;
      if ((paramView instanceof ViewGroup)) {
        break label134;
      }
    }
    label126:
    mye localmye;
    label134:
    do
    {
      return;
      l = -2147483648L;
      break;
      localmye = null;
      if (localndh != null) {
        localmye = localndh.a();
      }
    } while (((paramView instanceof ProteusItemView)) && (ods.a(paramArticleInfo, ((ProteusItemView)paramView).a().getVirtualView(), (Activity)localActivity, i, localmye, localAdvertisementInfo)));
    label186:
    if ((kxm.j(paramArticleInfo)) && (paramArticleInfo.mFeedType == 2))
    {
      boolean bool = ods.a(paramArticleInfo, localndh);
      ods.a((Activity)localActivity, (AdvertisementInfo)paramArticleInfo, localndh, i, true, knc.b((AdvertisementInfo)paramArticleInfo), new kks(bool));
      paramView = a();
      if ((paramView != null) && ((paramView instanceof ReadInJoyListViewGroup))) {
        ((ReadInJoyListViewGroup)paramView).D(paramArticleInfo);
      }
    }
    for (;;)
    {
      QZLog.i("AdHandler", 4, "AdHandler processAdClickEvent");
      return;
      if ((AdvertisementInfo.isAppAdvertisementInfo(paramArticleInfo)) && (localndh != null) && (paramLong != -1L))
      {
        int j = localndh.getItemViewType((int)paramLong);
        if ((j == 39) || (j == 116) || (j == 117) || (j == 66) || (j == 115) || (j == 122)) {
          ods.a(localActivity, (AdvertisementInfo)paramArticleInfo, localndh, i, true, knc.b((AdvertisementInfo)paramArticleInfo));
        } else {
          ods.a(localActivity, (AdvertisementInfo)paramArticleInfo, localndh, i, false, null);
        }
      }
      else
      {
        if (localndh == null) {
          break;
        }
        ods.a((Activity)localActivity, paramArticleInfo, localndh, i, null);
      }
    }
  }
  
  private void aEb()
  {
    int i = nh();
    ReadInJoyXListView localReadInJoyXListView = (ReadInJoyXListView)((ReadInJoyListViewGroup)a()).b();
    long l = System.currentTimeMillis();
    if ((knd.dh(i)) && (localReadInJoyXListView != null) && (localReadInJoyXListView.getChildCount() > 0))
    {
      i = 0;
      while (i < localReadInJoyXListView.getChildCount())
      {
        View localView = localReadInJoyXListView.getChildAt(i);
        if ((localView.getTag(2131381960) instanceof lis))
        {
          Object localObject = ((lis)localView.getTag(2131381960)).a();
          if ((localObject != null) && (AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject)) && ((localView instanceof ProteusItemView)))
          {
            localObject = ((ProteusItemView)localView).a();
            if (localObject != null)
            {
              localObject = ((Container)localObject).getVirtualView().findViewBaseByName("id_view_AdDownloadView");
              if ((localObject != null) && ((localObject instanceof koh))) {
                ((koh)localObject).ma();
              }
            }
          }
          localView = localView.findViewById(2131362099);
          if ((localView != null) && ((localView instanceof ReadInJoyAdVideoGuide))) {
            ((ReadInJoyAdVideoGuide)localView).aFt();
          }
        }
        i += 1;
      }
    }
    nxr.a("AdHandler", "refreshADVideoFeedsDownloadState", System.currentTimeMillis() - l);
  }
  
  private void aEc()
  {
    ndh localndh = (ndh)a();
    int i = nh();
    if (localndh != null)
    {
      ods.a(i, localndh.a, localndh.sr);
      localndh.sr = -2147483648L;
      localndh.a = null;
    }
  }
  
  private void ca(View paramView)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (paramView != null)
    {
      localObject2 = paramView.getContext();
      paramView = (View)localObject1;
      for (localObject1 = localObject2;; localObject1 = ((ContextWrapper)localObject1).getBaseContext())
      {
        localObject2 = paramView;
        if (!(localObject1 instanceof ContextWrapper)) {
          break;
        }
        if ((localObject1 instanceof Activity)) {
          paramView = (Activity)localObject1;
        }
      }
    }
    if ((localObject2 != null) && (((Activity)localObject2).getWindow() != null))
    {
      paramView = ((Activity)localObject2).getWindow().getDecorView().findViewById(16908307);
      if (paramView != null) {
        this.aJT = paramView.getMeasuredHeight();
      }
    }
  }
  
  public void a(View paramView, ArticleInfo paramArticleInfo, int paramInt)
  {
    a(paramArticleInfo, -1L, paramView);
  }
  
  public void a(View paramView, ListView paramListView)
  {
    this.mChannelID = nh();
    this.b = paramListView;
    knj.a().a(paramListView);
    ndi localndi = a();
    kmw localkmw = jdField_a_of_type_Kmw$a.a(this.mChannelID);
    paramListView = localkmw;
    if (localkmw == null)
    {
      paramListView = new kmw(this.mChannelID);
      jdField_a_of_type_Kmw$a.a(this.mChannelID, paramListView);
    }
    localndi.a(paramListView);
    lgy.a().a(this.mChannelID, localndi);
    lcc.a().b(this.mObserver);
    klc.a.a(this.jdField_a_of_type_Klc$a);
    ca(paramView);
  }
  
  public void a(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2)
  {
    if ((paramInt != this.mChannelID) || (a() == null)) {
      return;
    }
    knj.a().pn(paramInt);
  }
  
  public void aEa()
  {
    ndi localndi = a();
    if (localndi != null)
    {
      Object localObject = localndi.a();
      if (localObject != null) {
        ((msl)localObject).ob = false;
      }
      if (ndi.getApp() != null)
      {
        localObject = (klu)ndi.getApp().getManager(307);
        if (localObject != null)
        {
          ((klu)localObject).a(localndi, localndi.getActivity());
          if ((a() != null) && (a().a() != null)) {
            a().a().a(localndi, localndi.getActivity());
          }
          ((klu)localObject).a(localndi, localndi.getActivity(), true);
        }
      }
    }
  }
  
  public void b(View paramView, ListView paramListView)
  {
    paramView = a();
    if (((paramListView instanceof ReadInJoyXListView)) && (paramView != null)) {
      ((ReadInJoyXListView)paramListView).setRefreshPullDistanceListener(new kld(this, paramView));
    }
  }
  
  public void b(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = getData((int)paramLong);
    if ((paramAdapterView != null) && ((paramAdapterView instanceof ArticleInfo)))
    {
      a((ArticleInfo)paramAdapterView, paramLong, paramView);
      knj.a().pl(4);
    }
  }
  
  public void c(ReadInJoyBaseListView paramReadInJoyBaseListView, int paramInt)
  {
    paramReadInJoyBaseListView = a();
    if (paramReadInJoyBaseListView != null)
    {
      Object localObject = paramReadInJoyBaseListView.a();
      if (localObject != null) {
        ((msl)localObject).ob = true;
      }
      localObject = paramReadInJoyBaseListView.a();
      if ((localObject != null) && (((mye)localObject).c() != null))
      {
        mye.b localb = ((mye)localObject).c();
        if ((localb != null) && (localb.aqp)) {
          ((mye)localObject).stop(11);
        }
      }
      paramReadInJoyBaseListView = paramReadInJoyBaseListView.a();
      if (paramReadInJoyBaseListView != null) {
        paramReadInJoyBaseListView.aEJ();
      }
      if ((this.mChannelID == 0) && (knj.a().agA) && (awit.aMG()))
      {
        paramReadInJoyBaseListView = a();
        if ((paramReadInJoyBaseListView != null) && ((paramReadInJoyBaseListView instanceof ReadInJoyListViewGroup)))
        {
          if ((((ReadInJoyListViewGroup)paramReadInJoyBaseListView).Fx()) || (knj.a().bc().size() <= 0)) {
            break label160;
          }
          knj.a().ms(true);
          if (QLog.isColorLevel()) {
            QLog.d("AdHandler", 2, "setShouldAskSuperMask");
          }
        }
      }
    }
    return;
    label160:
    knj.a().ms(false);
  }
  
  public View d(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = c(paramInt).intValue();
    ArticleInfo localArticleInfo = (ArticleInfo)getData(paramInt);
    if (localArticleInfo != null) {
      localArticleInfo.mResolvedFeedType = i;
    }
    paramViewGroup = null;
    klc.a.a(this.jdField_a_of_type_Klc$a);
    if (kmz.dg(i)) {
      paramViewGroup = klc.a.a(this.jdField_a_of_type_Klc$a, paramView, localArticleInfo, i, paramInt);
    }
    for (;;)
    {
      if ((a() != null) && (a().a() != null) && (localArticleInfo != null) && (AdvertisementInfo.isAdvertisementInfo(localArticleInfo)))
      {
        paramView = (AdvertisementInfo)localArticleInfo;
        a().a().a(paramView, a().getActivity());
      }
      return paramViewGroup;
      if (lwj.dM(i)) {
        paramViewGroup = klc.a.b(this.jdField_a_of_type_Klc$a, paramView, localArticleInfo, i, paramInt);
      }
    }
  }
  
  public boolean df(int paramInt)
  {
    klc.a.a(this.jdField_a_of_type_Klc$a);
    return kmz.dg(paramInt);
  }
  
  public void f(AbsListView paramAbsListView, int paramInt)
  {
    boolean bool = true;
    if ((paramInt == 1) && (this.agi) && (this.c != null))
    {
      this.c.adStrategyType = 0;
      this.c = null;
    }
    if (paramInt == 2) {}
    for (;;)
    {
      this.agj = bool;
      if (this.agi)
      {
        this.agi = false;
        paramAbsListView.setInterpolator(null);
      }
      if (ndi.getApp() != null)
      {
        paramAbsListView = (klu)ndi.getApp().getManager(307);
        if (paramAbsListView != null) {
          paramAbsListView.pj(paramInt);
        }
      }
      return;
      bool = false;
    }
  }
  
  public Boolean g()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewKandianAdPandentMask != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewKandianAdPandentMask.zY())) {
      return Boolean.valueOf(true);
    }
    return super.g();
  }
  
  protected void g(AbsListView paramAbsListView, int paramInt)
  {
    if ((!this.agj) || (this.agi)) {}
    Object localObject1;
    Object localObject2;
    int j;
    View localView;
    do
    {
      do
      {
        return;
        float f = paramAbsListView.getFlingVelocityY();
        if ((f < this.iG) || (f > this.iH))
        {
          this.aJU = paramInt;
          return;
        }
        if ((this.aJU >= paramInt) || (paramInt >= paramAbsListView.getCount() - 1)) {
          break;
        }
        this.aJU = paramInt;
        localObject1 = (ListAdapter)paramAbsListView.getAdapter();
        i = paramInt + 1;
        localObject2 = ((ListAdapter)localObject1).getItem(i);
      } while ((!(localObject2 instanceof BaseArticleInfo)) || (!AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject2)) || (!knc.c((AdvertisementInfo)localObject2)));
      j = ((ListAdapter)localObject1).getItemViewType(i);
      localView = (View)this.Y.get(j);
      if (localView != null) {
        break label374;
      }
      localObject1 = ((ListAdapter)localObject1).getView(i, null, paramAbsListView);
      this.Y.put(j, localObject1);
      localView = paramAbsListView.getChildAt(paramAbsListView.getLastVisiblePosition() - paramAbsListView.getFirstVisiblePosition());
      if ((localView == null) || (localObject1 == null)) {
        break;
      }
      j = paramAbsListView.getRemainFlingDisY();
    } while (j <= 0);
    int i = localView.getBottom();
    int k = paramAbsListView.getBottom();
    int m = paramAbsListView.getPaddingBottom();
    k = this.aJT + (i - k - m);
    ViewGroup.LayoutParams localLayoutParams = ((View)localObject1).getLayoutParams();
    if (localLayoutParams != null)
    {
      i = localLayoutParams.width;
      label265:
      ((View)localObject1).measure(ViewGroup.getChildMeasureSpec(paramAbsListView.getMeasuredWidthAndState(), paramAbsListView.getPaddingLeft() + paramAbsListView.getPaddingRight(), i), 0);
      i = ((View)localObject1).getMeasuredHeight();
      if ((j > k) && (j < i / 1 + k))
      {
        this.agi = true;
        localObject1 = new AdHandler.3(this, localView, paramAbsListView, j, i);
        this.c = ((AdvertisementInfo)localObject2);
        this.c.adStrategyType = 1;
        if (Build.VERSION.SDK_INT < 16) {
          break label397;
        }
        paramAbsListView.postOnAnimation((Runnable)localObject1);
      }
    }
    for (;;)
    {
      this.aJU = paramInt;
      return;
      label374:
      localObject1 = ((ListAdapter)localObject1).getView(i, localView, paramAbsListView);
      break;
      i = -1;
      break label265;
      label397:
      paramAbsListView.post((Runnable)localObject1);
    }
  }
  
  public int np()
  {
    return 1;
  }
  
  public void onDestroy()
  {
    lgy.a().qX(this.mChannelID);
    lcc.a().c(this.mObserver);
    if ((a() != null) && (a().a() != null)) {
      a().a().aEF();
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewKandianAdPandentMask != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewKandianAdPandentMask.zY())) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewKandianAdPandentMask.aES();
    }
  }
  
  public void onListViewScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    g(paramAbsListView, paramInt1 + paramInt2 - 1);
  }
  
  public void onListViewScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    f(paramAbsListView, paramInt);
  }
  
  public void onPause()
  {
    auua localauua = a().a();
    if ((localauua != null) && (localauua.isShowing())) {
      localauua.dismiss();
    }
    if ((a() != null) && (a().a() != null)) {
      a().a().aD(getActivity());
    }
    if (knj.a().getShowStatus() == 1) {
      knj.a().mr(false);
    }
  }
  
  public void onResume()
  {
    aEb();
    aEc();
    if ((a() != null) && (a().a() != null)) {
      a().a().aEE();
    }
    if (knj.a().getShowStatus() == 1) {
      knj.a().mr(true);
    }
  }
  
  public void onStart()
  {
    super.onStart();
  }
  
  public class a
    implements lgf.c
  {
    private View bu;
    private volatile boolean isInit;
    private int mPosition;
    private VafContext mVafContext = new luh();
    
    public a() {}
    
    private View a(View paramView, ArticleInfo paramArticleInfo, int paramInt1, int paramInt2)
    {
      lis locallis = new lis(klc.this.getActivity(), paramArticleInfo, paramInt1, klc.this.nh(), klc.this.ni(), paramInt2, klc.this.Cb(), klc.this.getCount(), null, klc.this.a());
      long l;
      if ((paramView != null) && ((paramView instanceof ProteusItemView)))
      {
        l = System.currentTimeMillis();
        kvx.a((ProteusItemView)paramView, paramInt1, paramArticleInfo, this.mVafContext, klc.this.a(), klc.this.a(), locallis, paramInt2, "default_feeds");
        paramView = (ProteusItemView)paramView;
        nxr.a("AdHandler", String.valueOf(paramInt1), "getProteusNormalView.convertview#bindData", System.currentTimeMillis() - l);
      }
      for (;;)
      {
        if ((paramView != null) && (paramView.a() != null))
        {
          paramArticleInfo = klc.this.f();
          paramView.a().setTag(2131370016, paramArticleInfo);
          paramView.setTag(2131381960, locallis);
          paramView.setTag(this);
        }
        this.bu = paramView;
        this.mPosition = paramInt2;
        return paramView;
        l = System.currentTimeMillis();
        paramView = kvx.a(this.mVafContext, paramInt1, paramArticleInfo);
        nxr.a("AdHandler", String.valueOf(paramInt1), "getProteusNormalView.getView", System.currentTimeMillis() - l);
        l = System.currentTimeMillis();
        kvx.a(paramView, paramInt1, paramArticleInfo, this.mVafContext, klc.this.a(), klc.this.a(), locallis, paramInt2, "default_feeds");
        nxr.a("AdHandler", String.valueOf(paramInt1), "getProteusNormalView.newview#bindData", System.currentTimeMillis() - l);
      }
    }
    
    private View b(View paramView, ArticleInfo paramArticleInfo, int paramInt1, int paramInt2)
    {
      Object localObject = new lis(klc.this.getActivity(), paramArticleInfo, paramInt1, klc.this.nh(), klc.this.ni(), paramInt2, klc.this.Cb(), klc.this.getCount(), null, klc.this.a());
      View localView = lwj.a(paramInt2, localObject, paramInt1, paramView, klc.this.getActivity(), klc.this.a(), klc.this.a());
      if (localView != null)
      {
        localView.setTag(2131381960, localObject);
        if (QLog.isColorLevel()) {
          QLog.d("AdHandler", 2, "CellFactory.getView = " + localView.getTag().getClass().getSimpleName());
        }
        localView.setTag(2131370016, klc.this.f());
        if (paramArticleInfo == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("AdHandler", 2, "getView() article is null, set view gone, position: " + paramInt2);
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
            break label410;
          }
          paramInt1 = 0;
          label256:
          localObject = klc.this.ni() + "";
          if (paramArticleInfo == null) {
            break label415;
          }
        }
      }
      label410:
      label415:
      for (paramView = String.valueOf(paramArticleInfo.mArticleID);; paramView = "")
      {
        kbp.a(null, "", "0X80095B4", "0X80095B4", 0, paramInt1, (String)localObject, paramView, klc.this.nh() + "", "", false);
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
        QLog.w("AdHandler", 1, "CellFactory.getView = null");
        break;
        paramInt1 = 1;
        break label256;
      }
    }
    
    private void b(mye.b paramb)
    {
      if (paramb == null) {}
      Object localObject;
      do
      {
        do
        {
          return;
          localObject = ((ProteusItemView)this.bu).getTemplateBean();
        } while (localObject == null);
        ViewBean localViewBean = ((TemplateBean)localObject).findViewById("id_top_left_mask");
        localObject = ((TemplateBean)localObject).getStyleName();
        if (localViewBean != null)
        {
          paramb.topLeftRadius = aqcx.dip2px(klc.this.getActivity(), 8.0F);
          paramb.topRightRadius = aqcx.dip2px(klc.this.getActivity(), 8.0F);
          paramb.bottomLeftRadius = aqcx.dip2px(klc.this.getActivity(), 8.0F);
          paramb.bottomRightRadius = aqcx.dip2px(klc.this.getActivity(), 8.0F);
        }
      } while (!((String)localObject).equals("ReadInjoy_ad_video_cell_new_division"));
      paramb.bottomLeftRadius = 0;
      paramb.bottomRightRadius = 0;
    }
    
    private void init()
    {
      try
      {
        if (!this.isInit)
        {
          this.mVafContext.setContext(klc.this.getActivity());
          this.mVafContext.setCurActivity(klc.this.getActivity());
          kvx.a(this.mVafContext, "default_feeds");
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
    
    public mye.b a()
    {
      Object localObject2 = null;
      Object localObject1 = localObject2;
      ndi localndi;
      if (this.bu != null)
      {
        localObject1 = localObject2;
        if ((this.bu instanceof ProteusItemView))
        {
          localObject1 = (lis)this.bu.getTag(2131381960);
          if (localObject1 == null) {
            break label124;
          }
          localObject2 = ((lis)localObject1).a();
          if ((!AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject2)) || ((((lis)localObject1).getCellType() != 6) && (((lis)localObject1).getCellType() != 66) && (((lis)localObject1).getCellType() != 115))) {
            break label124;
          }
          localObject2 = (AdvertisementInfo)localObject2;
          localndi = klc.this.a();
          if ((localndi == null) || (localndi.c() == null)) {
            break label124;
          }
        }
      }
      label124:
      for (localObject1 = localndi.a().a((AdvertisementInfo)localObject2, this.bu, (lis)localObject1);; localObject1 = null)
      {
        b((mye.b)localObject1);
        return localObject1;
      }
    }
    
    public int getPosition()
    {
      return this.mPosition;
    }
    
    public boolean z(View paramView)
    {
      Object localObject;
      if ((this.bu != null) && ((this.bu instanceof ProteusItemView)))
      {
        paramView = (lis)this.bu.getTag(2131381960);
        if (paramView != null)
        {
          localObject = paramView.a();
          if ((AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject)) && ((paramView.getCellType() == 6) || (paramView.getCellType() == 66) || (paramView.getCellType() == 115)))
          {
            localObject = (AdvertisementInfo)localObject;
            if (!TextUtils.isEmpty(ods.a((ArticleInfo)localObject, "AdsIconText"))) {
              break label93;
            }
          }
        }
      }
      label93:
      ndi localndi;
      do
      {
        return false;
        localndi = klc.this.a();
      } while ((localndi == null) || (localndi.c() == null));
      paramView = localndi.a().a((AdvertisementInfo)localObject, this.bu, paramView);
      if ((knc.a((AdvertisementInfo)localObject, null, localndi.getActivity(), 1)) && (localndi.a().c(paramView))) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     klc
 * JD-Core Version:    0.7.0.1
 */