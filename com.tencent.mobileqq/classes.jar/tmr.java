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
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AdapterView;
import com.tencent.widget.ListView;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.List;

public class tmr
  extends pmk
{
  private static tpo jdField_a_of_type_Tpo = new tpo();
  private float jdField_a_of_type_Float = bhlo.d() * 500 / 160.0F;
  private int jdField_a_of_type_Int;
  private SparseArray<View> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(1);
  private DecelerateInterpolator jdField_a_of_type_AndroidViewAnimationDecelerateInterpolator = new DecelerateInterpolator(this.jdField_c_of_type_Float);
  private AdvertisementInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  protected pfh a;
  private tmu jdField_a_of_type_Tmu = new tmu(this);
  private trs jdField_a_of_type_Trs;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float = bhlo.d() * 1000 / 160.0F;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private float jdField_c_of_type_Float = 1.5F;
  private int jdField_c_of_type_Int = -1;
  
  public tmr()
  {
    this.jdField_a_of_type_Pfh = new tmt(this);
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
    sek localsek = (sek)a();
    long l;
    AdvertisementInfo localAdvertisementInfo;
    if (AdvertisementInfo.isAdvertisementInfo(paramArticleInfo))
    {
      if (tqa.a(i))
      {
        pfa.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
        if (localsek != null) {
          localsek.notifyDataSetChanged();
        }
      }
      if (localsek != null)
      {
        localsek.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = ubd.a(localActivity, (AdvertisementInfo)paramArticleInfo, localsek, i, false, null);
        if (localsek.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params == null) {
          break label126;
        }
        l = SystemClock.elapsedRealtime();
        localsek.jdField_a_of_type_Long = l;
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
    rvy localrvy;
    label134:
    do
    {
      return;
      l = -2147483648L;
      break;
      localrvy = null;
      if (localsek != null) {
        localrvy = localsek.a();
      }
    } while (((paramView instanceof ProteusItemView)) && (ubd.a(paramArticleInfo, ((ProteusItemView)paramView).a().getVirtualView(), (Activity)localActivity, i, localrvy, localAdvertisementInfo)));
    label186:
    if ((ozs.a(paramArticleInfo)) && (paramArticleInfo.mFeedType == 2))
    {
      boolean bool = ubd.a(paramArticleInfo, localsek);
      ubd.a((Activity)localActivity, (AdvertisementInfo)paramArticleInfo, localsek, i, true, tpz.b((AdvertisementInfo)paramArticleInfo), new tlt(bool));
      paramView = a();
      if ((paramView != null) && ((paramView instanceof ReadInJoyListViewGroup))) {
        ((ReadInJoyListViewGroup)paramView).a(paramArticleInfo);
      }
    }
    for (;;)
    {
      QZLog.i("AdHandler", 4, "AdHandler processAdClickEvent");
      return;
      if ((AdvertisementInfo.isAppAdvertisementInfo(paramArticleInfo)) && (localsek != null) && (paramLong != -1L))
      {
        int j = localsek.getItemViewType((int)paramLong);
        if ((j == 39) || (j == 116) || (j == 117) || (j == 66) || (j == 115) || (j == 122)) {
          ubd.a(localActivity, (AdvertisementInfo)paramArticleInfo, localsek, i, true, tpz.b((AdvertisementInfo)paramArticleInfo));
        } else {
          ubd.a(localActivity, (AdvertisementInfo)paramArticleInfo, localsek, i, false, null);
        }
      }
      else
      {
        if (localsek == null) {
          break;
        }
        ubd.a((Activity)localActivity, paramArticleInfo, localsek, i, null);
      }
    }
  }
  
  private void i()
  {
    int i = b();
    ReadInJoyXListView localReadInJoyXListView = (ReadInJoyXListView)((ReadInJoyListViewGroup)a()).a();
    long l = System.currentTimeMillis();
    if ((tqa.a(i)) && (localReadInJoyXListView != null) && (localReadInJoyXListView.getChildCount() > 0))
    {
      i = 0;
      while (i < localReadInJoyXListView.getChildCount())
      {
        View localView = localReadInJoyXListView.getChildAt(i);
        if ((localView.getTag(2131381109) instanceof pqk))
        {
          Object localObject = ((pqk)localView.getTag(2131381109)).a();
          if ((localObject != null) && (AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject)) && ((localView instanceof ProteusItemView)))
          {
            localObject = ((ProteusItemView)localView).a();
            if (localObject != null)
            {
              localObject = ((Container)localObject).getVirtualView().findViewBaseByName("id_view_AdDownloadView");
              if ((localObject != null) && ((localObject instanceof tse))) {
                ((tse)localObject).c();
              }
            }
          }
          localView = localView.findViewById(2131362064);
          if ((localView != null) && ((localView instanceof ReadInJoyAdVideoGuide))) {
            ((ReadInJoyAdVideoGuide)localView).c();
          }
        }
        i += 1;
      }
    }
    tkb.a("AdHandler", "refreshADVideoFeedsDownloadState", System.currentTimeMillis() - l);
  }
  
  private void j()
  {
    sek localsek = (sek)a();
    int i = b();
    if (localsek != null)
    {
      ubd.a(i, localsek.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params, localsek.jdField_a_of_type_Long);
      localsek.jdField_a_of_type_Long = -2147483648L;
      localsek.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = null;
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
    tmu.a(this.jdField_a_of_type_Tmu);
    if (tpr.a(i)) {
      paramViewGroup = tmu.a(this.jdField_a_of_type_Tmu, paramView, localArticleInfo, i, paramInt);
    }
    for (;;)
    {
      if ((a() != null) && (a().a() != null) && (localArticleInfo != null) && (AdvertisementInfo.isAdvertisementInfo(localArticleInfo)))
      {
        paramView = (AdvertisementInfo)localArticleInfo;
        a().a().a(paramView, a().a());
      }
      return paramViewGroup;
      if (qje.a(i)) {
        paramViewGroup = tmu.b(this.jdField_a_of_type_Tmu, paramView, localArticleInfo, i, paramInt);
      }
    }
  }
  
  public Boolean a()
  {
    if ((this.jdField_a_of_type_Trs != null) && (this.jdField_a_of_type_Trs.a())) {
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
    this.jdField_a_of_type_Int = b();
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
    tqi.a().a(paramListView);
    sel localsel = a();
    tpn localtpn = jdField_a_of_type_Tpo.a(this.jdField_a_of_type_Int);
    paramListView = localtpn;
    if (localtpn == null)
    {
      paramListView = new tpn(this.jdField_a_of_type_Int);
      jdField_a_of_type_Tpo.a(this.jdField_a_of_type_Int, paramListView);
    }
    localsel.a(paramListView);
    poc.a().a(this.jdField_a_of_type_Int, localsel);
    pfd.a().a(this.jdField_a_of_type_Pfh);
    tmu.a(this.jdField_a_of_type_Tmu);
    a(paramView);
  }
  
  public void a(ReadInJoyBaseListView paramReadInJoyBaseListView, int paramInt)
  {
    paramReadInJoyBaseListView = a();
    if (paramReadInJoyBaseListView != null)
    {
      Object localObject = paramReadInJoyBaseListView.a();
      if (localObject != null) {
        ((rmg)localObject).jdField_a_of_type_Boolean = true;
      }
      localObject = paramReadInJoyBaseListView.a();
      if ((localObject != null) && (((rvy)localObject).a() != null))
      {
        rwc localrwc = ((rvy)localObject).a();
        if ((localrwc != null) && (localrwc.jdField_b_of_type_Boolean)) {
          ((rvy)localObject).b(11);
        }
      }
      paramReadInJoyBaseListView = paramReadInJoyBaseListView.a();
      if (paramReadInJoyBaseListView != null) {
        paramReadInJoyBaseListView.f();
      }
      if ((tqi.a().d()) && (tqi.a().b()))
      {
        paramReadInJoyBaseListView = a();
        if ((paramReadInJoyBaseListView instanceof ReadInJoyListViewGroup))
        {
          if ((((ReadInJoyListViewGroup)paramReadInJoyBaseListView).f()) || (tqi.a().a().size() <= 0)) {
            break label152;
          }
          tqi.a().b(true);
          if (QLog.isColorLevel()) {
            QLog.d("AdHandler", 2, "setShouldAskSuperMask");
          }
        }
      }
    }
    return;
    label152:
    tqi.a().b(false);
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
      tqi.a().b(4);
    }
  }
  
  public void a(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2)
  {
    if ((paramInt != this.jdField_a_of_type_Int) || (a() == null)) {
      return;
    }
    tqi.a().e(paramInt);
  }
  
  public boolean a(int paramInt)
  {
    tmu.a(this.jdField_a_of_type_Tmu);
    return tpr.a(paramInt);
  }
  
  public void b()
  {
    i();
    j();
    if ((a() != null) && (a().a() != null)) {
      a().a().a();
    }
    if (tqi.a().a() == 1) {
      tqi.a().a(true);
    }
  }
  
  public void b(View paramView, ListView paramListView)
  {
    paramView = a();
    if (((paramListView instanceof ReadInJoyXListView)) && (paramView != null)) {
      ((ReadInJoyXListView)paramListView).setRefreshPullDistanceListener(new tms(this, paramView));
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
      if (sel.a() != null)
      {
        paramAbsListView = (tnt)sel.a().getManager(307);
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
    blms localblms = a().a();
    if ((localblms != null) && (localblms.isShowing())) {
      localblms.dismiss();
    }
    if ((a() != null) && (a().a() != null)) {
      a().a().b(a());
    }
    if (tqi.a().a() == 1) {
      tqi.a().a(false);
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
      } while ((!(localObject2 instanceof BaseArticleInfo)) || (!AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject2)) || (!tpz.c((AdvertisementInfo)localObject2)));
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
  
  public void e()
  {
    poc.a().b(this.jdField_a_of_type_Int);
    pfd.a().b(this.jdField_a_of_type_Pfh);
    if ((a() != null) && (a().a() != null)) {
      a().a().b();
    }
    if ((this.jdField_a_of_type_Trs != null) && (this.jdField_a_of_type_Trs.a())) {
      this.jdField_a_of_type_Trs.a();
    }
  }
  
  public void g()
  {
    sel localsel = a();
    if (localsel != null)
    {
      Object localObject = localsel.a();
      if (localObject != null) {
        ((rmg)localObject).jdField_a_of_type_Boolean = false;
      }
      if (sel.a() != null)
      {
        localObject = (tnt)sel.a().getManager(307);
        if (localObject != null)
        {
          ((tnt)localObject).a(localsel, localsel.a());
          if ((a() != null) && (a().a() != null)) {
            a().a().a(localsel, localsel.a());
          }
          ((tnt)localObject).a(localsel, localsel.a(), true);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tmr
 * JD-Core Version:    0.7.0.1
 */