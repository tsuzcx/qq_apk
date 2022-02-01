import android.app.Activity;
import android.content.ContextWrapper;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.DecelerateInterpolator;
import android.widget.ListAdapter;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.ProteusItemView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoyAd.ad.handlers.AdHandler.3;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdVideoGuide;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AdapterView;
import com.tencent.widget.ListView;
import cooperation.qzone.util.QZLog;
import java.lang.ref.SoftReference;
import java.util.List;

public class tsm
  extends prx
{
  private static twg jdField_a_of_type_Twg = new twg();
  private float jdField_a_of_type_Float = DeviceInfoUtil.getDispalyDpi() * 500 / 160.0F;
  private int jdField_a_of_type_Int;
  private SparseArray<View> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(1);
  private DecelerateInterpolator jdField_a_of_type_AndroidViewAnimationDecelerateInterpolator = new DecelerateInterpolator(this.jdField_c_of_type_Float);
  private AdvertisementInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  protected pkt a;
  private tsp jdField_a_of_type_Tsp = new tsp(this);
  private tyl jdField_a_of_type_Tyl;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float = DeviceInfoUtil.getDispalyDpi() * 1000 / 160.0F;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private float jdField_c_of_type_Float = 1.5F;
  private int jdField_c_of_type_Int = -1;
  
  public tsm()
  {
    this.jdField_a_of_type_Pkt = new tso(this);
  }
  
  private void a(View paramView)
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
        this.jdField_b_of_type_Int = paramView.getMeasuredHeight();
      }
    }
  }
  
  private void a(ArticleInfo paramArticleInfo, long paramLong, View paramView)
  {
    Activity localActivity = a();
    int i = b();
    sls localsls = (sls)a();
    long l;
    AdvertisementInfo localAdvertisementInfo;
    if (AdvertisementInfo.isAdvertisementInfo(paramArticleInfo))
    {
      if (twr.a(i))
      {
        pkm.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
        if (localsls != null) {
          localsls.notifyDataSetChanged();
        }
      }
      if (localsls != null)
      {
        localsls.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = uhs.a(localActivity, (AdvertisementInfo)paramArticleInfo, localsls, i, false, null);
        if (localsls.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params == null) {
          break label126;
        }
        l = SystemClock.elapsedRealtime();
        localsls.jdField_a_of_type_Long = l;
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
    sdc localsdc;
    label134:
    do
    {
      return;
      l = -2147483648L;
      break;
      localsdc = null;
      if (localsls != null) {
        localsdc = localsls.a();
      }
    } while (((paramView instanceof ProteusItemView)) && (uhs.a(paramArticleInfo, ((ProteusItemView)paramView).a().getVirtualView(), (Activity)localActivity, i, localsdc, localAdvertisementInfo)));
    label186:
    if ((pay.a(paramArticleInfo)) && (paramArticleInfo.mFeedType == 2))
    {
      boolean bool = uhs.a(paramArticleInfo, localsls);
      uhs.a((Activity)localActivity, (AdvertisementInfo)paramArticleInfo, localsls, i, true, twq.b((AdvertisementInfo)paramArticleInfo), new trj(bool));
      paramView = a();
      if ((paramView != null) && ((paramView instanceof ReadInJoyListViewGroup))) {
        uhs.a(a(), paramArticleInfo, localsls, b());
      }
    }
    for (;;)
    {
      QZLog.i("AdHandler", 4, "AdHandler processAdClickEvent");
      return;
      if ((AdvertisementInfo.isAppAdvertisementInfo(paramArticleInfo)) && (localsls != null) && (paramLong != -1L))
      {
        int j = localsls.getItemViewType((int)paramLong);
        if ((j == 39) || (j == 116) || (j == 117) || (j == 66) || (j == 115) || (j == 122)) {
          uhs.a(localActivity, (AdvertisementInfo)paramArticleInfo, localsls, i, true, twq.b((AdvertisementInfo)paramArticleInfo));
        } else {
          uhs.a(localActivity, (AdvertisementInfo)paramArticleInfo, localsls, i, false, null);
        }
      }
      else
      {
        if (localsls == null) {
          break;
        }
        uhs.a((Activity)localActivity, paramArticleInfo, localsls, i, null);
      }
    }
  }
  
  private void h()
  {
    int i = b();
    ReadInJoyXListView localReadInJoyXListView = (ReadInJoyXListView)((ReadInJoyListViewGroup)a()).a();
    long l = System.currentTimeMillis();
    if ((twr.a(i)) && (localReadInJoyXListView != null) && (localReadInJoyXListView.getChildCount() > 0))
    {
      i = 0;
      while (i < localReadInJoyXListView.getChildCount())
      {
        View localView = localReadInJoyXListView.getChildAt(i);
        if ((localView.getTag(2131380831) instanceof pwe))
        {
          Object localObject = ((pwe)localView.getTag(2131380831)).a();
          if ((localObject != null) && (AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject)) && ((localView instanceof ProteusItemView)))
          {
            localObject = ((ProteusItemView)localView).a();
            if (localObject != null)
            {
              localObject = ((Container)localObject).getVirtualView().findViewBaseByName("id_view_AdDownloadView");
              if ((localObject != null) && ((localObject instanceof tyx))) {
                ((tyx)localObject).c();
              }
            }
          }
          localView = localView.findViewById(2131362063);
          if ((localView != null) && ((localView instanceof ReadInJoyAdVideoGuide))) {
            ((ReadInJoyAdVideoGuide)localView).c();
          }
        }
        i += 1;
      }
    }
    tpl.a("AdHandler", "refreshADVideoFeedsDownloadState", System.currentTimeMillis() - l);
  }
  
  private void i()
  {
    sls localsls = (sls)a();
    int i = b();
    if (localsls != null)
    {
      uhs.a(i, localsls.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params, localsls.jdField_a_of_type_Long);
      localsls.jdField_a_of_type_Long = -2147483648L;
      localsls.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = null;
    }
  }
  
  public int a()
  {
    return 1;
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = a(paramInt).intValue();
    ArticleInfo localArticleInfo = (ArticleInfo)a(paramInt);
    if (localArticleInfo != null) {
      localArticleInfo.mResolvedFeedType = i;
    }
    paramViewGroup = null;
    tsp.a(this.jdField_a_of_type_Tsp);
    if (twj.a(i)) {
      paramViewGroup = tsp.a(this.jdField_a_of_type_Tsp, paramView, localArticleInfo, i, paramInt);
    }
    for (;;)
    {
      if ((a() != null) && (a().a() != null) && (localArticleInfo != null) && (AdvertisementInfo.isAdvertisementInfo(localArticleInfo)))
      {
        paramView = (AdvertisementInfo)localArticleInfo;
        a().a().a(paramView, a().a());
      }
      return paramViewGroup;
      if (qph.a(i)) {
        paramViewGroup = tsp.b(this.jdField_a_of_type_Tsp, paramView, localArticleInfo, i, paramInt);
      }
    }
  }
  
  public Boolean a()
  {
    if ((this.jdField_a_of_type_Tyl != null) && (this.jdField_a_of_type_Tyl.a())) {
      return Boolean.valueOf(true);
    }
    return super.a();
  }
  
  public void a()
  {
    super.a();
  }
  
  public void a(View paramView, ArticleInfo paramArticleInfo, int paramInt)
  {
    a(paramArticleInfo, -1L, paramView);
  }
  
  public void a(View paramView, ListView paramListView)
  {
    paramView = a();
    if (((paramListView instanceof ReadInJoyXListView)) && (paramView != null)) {
      ((ReadInJoyXListView)paramListView).setRefreshPullDistanceListener(new tsn(this, paramView));
    }
  }
  
  public void a(View paramView, ListView paramListView, long paramLong)
  {
    this.jdField_a_of_type_Int = b();
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
    tvi.a.b(new SoftReference(paramListView));
    slt localslt = a();
    twf localtwf = jdField_a_of_type_Twg.a(this.jdField_a_of_type_Int);
    paramListView = localtwf;
    if (localtwf == null)
    {
      paramListView = new twf(this.jdField_a_of_type_Int);
      jdField_a_of_type_Twg.a(this.jdField_a_of_type_Int, paramListView);
    }
    localslt.a(paramListView);
    ptk.a().a(this.jdField_a_of_type_Int, localslt);
    pkp.a().a(this.jdField_a_of_type_Pkt);
    tsp.a(this.jdField_a_of_type_Tsp);
    a(paramView);
  }
  
  public void a(ReadInJoyBaseListView paramReadInJoyBaseListView, int paramInt)
  {
    paramReadInJoyBaseListView = a();
    if (paramReadInJoyBaseListView != null)
    {
      Object localObject = paramReadInJoyBaseListView.a();
      if (localObject != null) {
        ((rti)localObject).jdField_a_of_type_Boolean = true;
      }
      localObject = paramReadInJoyBaseListView.a();
      if ((localObject != null) && (((sdc)localObject).a() != null))
      {
        sdg localsdg = ((sdc)localObject).a();
        if ((localsdg != null) && (localsdg.jdField_b_of_type_Boolean)) {
          ((sdc)localObject).b(11);
        }
      }
      paramReadInJoyBaseListView = paramReadInJoyBaseListView.a();
      if (paramReadInJoyBaseListView != null) {
        paramReadInJoyBaseListView.f();
      }
      if (pcl.c(this.jdField_a_of_type_Int)) {
        nwz.a().a("RIJAdRefreshSceneDaily");
      }
      if (this.jdField_a_of_type_Int == 0) {
        nwz.a().a("RIJAdRefreshSceneMainFeeds");
      }
      if (56 == this.jdField_a_of_type_Int) {
        nwz.a().a("RIJAdRefreshSceneVideoTab");
      }
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    b(paramAbsListView, paramInt);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    c(paramAbsListView, paramInt1 + paramInt2 - 1);
  }
  
  public void a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = a((int)paramLong);
    if ((paramAdapterView != null) && ((paramAdapterView instanceof ArticleInfo)))
    {
      a((ArticleInfo)paramAdapterView, paramLong, paramView);
      tvi.a.b(-1);
      twp.a("ReadInJoySuperMaskAd", "setSuperMaskChannelId -1 : onFeedsItemClick");
    }
  }
  
  public void a(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2)
  {
    if ((paramInt != this.jdField_a_of_type_Int) || (a() == null)) {
      return;
    }
    twx.a().a(paramInt);
  }
  
  public boolean a(int paramInt)
  {
    tsp.a(this.jdField_a_of_type_Tsp);
    return twj.a(paramInt);
  }
  
  public void b()
  {
    h();
    i();
    if ((a() != null) && (a().a() != null)) {
      a().a().a();
    }
  }
  
  public void b(AbsListView paramAbsListView, int paramInt)
  {
    boolean bool = true;
    if ((paramInt == 1) && (this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.adStrategyType = 0;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = null;
    }
    if (paramInt == 2) {}
    for (;;)
    {
      this.jdField_b_of_type_Boolean = bool;
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = false;
        paramAbsListView.setInterpolator(null);
      }
      if (pem.a() != null)
      {
        paramAbsListView = (ttq)pem.a().getManager(307);
        if (paramAbsListView != null) {
          paramAbsListView.a(paramInt);
        }
      }
      return;
      bool = false;
    }
  }
  
  public void c()
  {
    bjrh localbjrh = a().a();
    if ((localbjrh != null) && (localbjrh.isShowing())) {
      localbjrh.dismiss();
    }
    if ((a() != null) && (a().a() != null)) {
      a().a().b(a());
    }
  }
  
  protected void c(AbsListView paramAbsListView, int paramInt)
  {
    if ((!this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Boolean)) {}
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
        if ((f < this.jdField_a_of_type_Float) || (f > this.jdField_b_of_type_Float))
        {
          this.jdField_c_of_type_Int = paramInt;
          return;
        }
        if ((this.jdField_c_of_type_Int >= paramInt) || (paramInt >= paramAbsListView.getCount() - 1)) {
          break;
        }
        this.jdField_c_of_type_Int = paramInt;
        localObject1 = (ListAdapter)paramAbsListView.getAdapter();
        i = paramInt + 1;
        localObject2 = ((ListAdapter)localObject1).getItem(i);
      } while ((!(localObject2 instanceof BaseArticleInfo)) || (!AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject2)) || (!twq.c((AdvertisementInfo)localObject2)));
      j = ((ListAdapter)localObject1).getItemViewType(i);
      localView = (View)this.jdField_a_of_type_AndroidUtilSparseArray.get(j);
      if (localView != null) {
        break label374;
      }
      localObject1 = ((ListAdapter)localObject1).getView(i, null, paramAbsListView);
      this.jdField_a_of_type_AndroidUtilSparseArray.put(j, localObject1);
      localView = paramAbsListView.getChildAt(paramAbsListView.getLastVisiblePosition() - paramAbsListView.getFirstVisiblePosition());
      if ((localView == null) || (localObject1 == null)) {
        break;
      }
      j = paramAbsListView.getRemainFlingDisY();
    } while (j <= 0);
    int i = localView.getBottom();
    int k = paramAbsListView.getBottom();
    int m = paramAbsListView.getPaddingBottom();
    k = this.jdField_b_of_type_Int + (i - k - m);
    ViewGroup.LayoutParams localLayoutParams = ((View)localObject1).getLayoutParams();
    if (localLayoutParams != null)
    {
      i = localLayoutParams.width;
      label265:
      ((View)localObject1).measure(ViewGroup.getChildMeasureSpec(paramAbsListView.getMeasuredWidthAndState(), paramAbsListView.getPaddingLeft() + paramAbsListView.getPaddingRight(), i), 0);
      i = ((View)localObject1).getMeasuredHeight();
      if ((j > k) && (j < i / 1 + k))
      {
        this.jdField_a_of_type_Boolean = true;
        localObject1 = new AdHandler.3(this, localView, paramAbsListView, j, i);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = ((AdvertisementInfo)localObject2);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.adStrategyType = 1;
        if (Build.VERSION.SDK_INT < 16) {
          break label397;
        }
        paramAbsListView.postOnAnimation((Runnable)localObject1);
      }
    }
    for (;;)
    {
      this.jdField_c_of_type_Int = paramInt;
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
  
  public void d()
  {
    ptk.a().b(this.jdField_a_of_type_Int);
    pkp.a().b(this.jdField_a_of_type_Pkt);
    if ((a() != null) && (a().a() != null)) {
      a().a().b();
    }
    tvi.a.d();
  }
  
  public void f()
  {
    slt localslt = a();
    if (localslt != null)
    {
      Object localObject = localslt.a();
      if (localObject != null) {
        ((rti)localObject).jdField_a_of_type_Boolean = false;
      }
      if (pem.a() != null)
      {
        localObject = (ttq)pem.a().getManager(307);
        if (localObject != null)
        {
          ((ttq)localObject).a(localslt, localslt.a());
          if ((a() != null) && (a().a() != null)) {
            a().a().a(localslt, localslt.a());
          }
          ((ttq)localObject).a(localslt, localslt.a(), true);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tsm
 * JD-Core Version:    0.7.0.1
 */