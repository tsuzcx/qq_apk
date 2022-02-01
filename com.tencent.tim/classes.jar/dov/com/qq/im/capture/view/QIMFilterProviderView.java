package dov.com.qq.im.capture.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListAdapter;
import awte;
import axov;
import axoy;
import axpr;
import axpr.a;
import axpr.b;
import axqc;
import axqf;
import axqm;
import axro;
import axtq;
import ayva;
import ayva.a;
import ayva.b;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.c;
import com.tencent.widget.GridView;
import dov.com.qq.im.capture.adapter.FilterProviderPagerAdapter;
import dov.com.qq.im.capture.data.FilterCategory;
import dov.com.qq.im.capture.data.QIMFilterCategoryItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import rpw;

public class QIMFilterProviderView
  extends ProviderView
  implements ViewPager.OnPageChangeListener, axpr.a, AdapterView.c, QIMSlidingTabView.a
{
  public ArrayList<FilterCategory> FB;
  public ayva.b a;
  FilterProviderPagerAdapter a;
  QQViewPager b;
  public int dzN;
  
  public QIMFilterProviderView(Context paramContext)
  {
    super(paramContext);
  }
  
  private void initData(Bundle paramBundle)
  {
    Bundle localBundle = null;
    if (paramBundle != null) {
      localBundle = paramBundle.getBundle(QIMFilterProviderView.class.getSimpleName());
    }
    if (localBundle != null)
    {
      if (ayva.a().a[this.eCJ] != null) {
        ayva.a().a[this.eCJ].eGG = 1;
      }
      paramBundle = (QIMFilterCategoryItem)localBundle.getParcelable("selected_filter_item");
      if (paramBundle != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("FilterProviderView", 2, "restore " + paramBundle.id);
        }
        paramBundle.eGG = 1;
      }
    }
  }
  
  protected Bundle D()
  {
    Bundle localBundle = new Bundle();
    QIMFilterCategoryItem localQIMFilterCategoryItem1 = ayva.a().c(this.eCJ);
    if (localQIMFilterCategoryItem1 != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FilterProviderView", 2, "save " + localQIMFilterCategoryItem1.id);
      }
      localBundle.putParcelable("selected_filter_item", localQIMFilterCategoryItem1);
      int i = Rx();
      if ((this.FB != null) && (!this.FB.isEmpty()) && (i >= 0) && (i < this.FB.size()))
      {
        FilterCategory localFilterCategory = (FilterCategory)this.FB.get(i);
        if (localFilterCategory != null)
        {
          Object localObject = localFilterCategory.Fv;
          if (localObject != null)
          {
            localObject = ((List)localObject).iterator();
            while (((Iterator)localObject).hasNext())
            {
              QIMFilterCategoryItem localQIMFilterCategoryItem2 = (QIMFilterCategoryItem)((Iterator)localObject).next();
              if ((localQIMFilterCategoryItem1.getFilterId() == localQIMFilterCategoryItem2.getFilterId()) && (localQIMFilterCategoryItem1.name != null) && (localQIMFilterCategoryItem1.name.equals(localQIMFilterCategoryItem2.name))) {
                localBundle.putParcelable("ProviderView.select_item_category", localFilterCategory);
              }
            }
          }
        }
      }
    }
    return localBundle;
  }
  
  protected int QW()
  {
    return 2131561124;
  }
  
  public int Rx()
  {
    if (this.b == null) {
      return 0;
    }
    return this.b.getCurrentItem();
  }
  
  public void TX(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > this.FB.size())) {
      return;
    }
    if (paramInt != 0) {
      ePc();
    }
    this.b.setCurrentItem(paramInt);
    ayva.a().I(2, ((FilterCategory)this.FB.get(paramInt)).categoryId, "");
  }
  
  public void a(axqc paramaxqc) {}
  
  public void a(axqc paramaxqc, boolean paramBoolean, int paramInt, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QCombo", 2, "fp onComboApply combo " + paramaxqc.target + " filter ");
    }
    dLo();
  }
  
  public void a(axqf paramaxqf, boolean paramBoolean, int paramInt, Bundle paramBundle)
  {
    if (this.jdField_c_of_type_DovComQqImCaptureViewProviderView$a != null) {
      this.jdField_c_of_type_DovComQqImCaptureViewProviderView$a.YI(true);
    }
    dLo();
    if (paramBoolean)
    {
      paramaxqf = (axro)axov.a().c(8);
      if (this.eCJ != 0) {
        break label58;
      }
    }
    label58:
    for (paramInt = awte.eCR;; paramInt = awte.eCS)
    {
      paramaxqf.aeJ(paramInt);
      paramaxqf.eOr();
      return;
    }
  }
  
  public void a(axqm paramaxqm, boolean paramBoolean, int paramInt, Bundle paramBundle) {}
  
  public void a(ayva.a parama)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onComboFilterDataUpdated data:");
      if (parama != null) {
        break label56;
      }
    }
    label56:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("FilterProviderView", 2, bool);
      if (parama != null) {
        setup(parama.a(this.eCJ));
      }
      return;
    }
  }
  
  public void apk()
  {
    super.apk();
    ayva.b localb = this.jdField_a_of_type_Ayva$b;
    axpr localaxpr = (axpr)axov.a(5);
    Object localObject;
    if (localb == null)
    {
      localObject = localaxpr.jdField_a_of_type_Ayva$a;
      if (localObject != null) {
        localb = ((ayva.a)localObject).a(this.eCJ);
      }
    }
    for (;;)
    {
      if ((localb != null) && (localb.h != null))
      {
        localObject = (Activity)getContext();
        localaxpr.a(localb.h).b((Activity)localObject, this.eCJ);
        ayva.a().b(localb.h, (Activity)getContext(), this.eCJ);
        ayva.a().a(localb.h, this.eCJ);
        dLo();
        onItemClick(null, null, 0, 0L);
      }
      return;
    }
  }
  
  public void aq(int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FilterProviderView", 2, "category= " + paramInt + " categoryName= " + paramString1 + ",itemId=" + paramString2);
    }
    int i = 0;
    if (i < this.FB.size()) {
      if ((paramInt != -1) && (((FilterCategory)this.FB.get(i)).categoryId == paramInt)) {
        paramInt = i;
      }
    }
    for (;;)
    {
      label94:
      a().TX(paramInt);
      Object localObject = (FilterCategory)this.FB.get(Rx());
      i = 0;
      label121:
      if (i < ((FilterCategory)localObject).Fv.size())
      {
        paramString1 = (QIMFilterCategoryItem)((FilterCategory)localObject).Fv.get(i);
        if (!paramString1.id.equals(paramString2)) {}
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("FilterProviderView", 2, "itemInfo= " + paramString1 + ",index=" + paramInt + ",pos=" + i);
        }
        if (paramString1 != null)
        {
          postDelayed(new QIMFilterProviderView.1(this, i), 200L);
          paramString2 = (axpr)axov.a(5);
          localObject = new Bundle();
          ((Bundle)localObject).putInt("apply_source", 1);
          ((Bundle)localObject).putInt("capture_scene", this.eCJ);
          paramString2.a(paramString1, (Activity)getContext(), (Bundle)localObject);
          dLo();
        }
        return;
        if ((paramString1 != null) && (paramString1.equals(((FilterCategory)this.FB.get(i)).categoryName)))
        {
          paramInt = i;
          break label94;
        }
        i += 1;
        break;
        i += 1;
        break label121;
        i = 0;
        paramString1 = null;
      }
      paramInt = 0;
    }
  }
  
  public void dKI()
  {
    super.dKI();
    if (this.jdField_c_of_type_DovComQqImCaptureViewProviderView$a != null)
    {
      this.jdField_c_of_type_DovComQqImCaptureViewProviderView$a.YI(true);
      this.jdField_c_of_type_DovComQqImCaptureViewProviderView$a.eNs();
    }
    dLo();
  }
  
  public void dLo()
  {
    if (!this.mInited) {}
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("QCombo", 2, "FilterProviderView updateSelectedState");
      }
      int j = this.jdField_a_of_type_DovComQqImCaptureAdapterFilterProviderPagerAdapter.jdField_do.size();
      int i = 0;
      while (i < j)
      {
        int k = this.jdField_a_of_type_DovComQqImCaptureAdapterFilterProviderPagerAdapter.jdField_do.keyAt(i);
        ListAdapter localListAdapter = ((GridView)this.jdField_a_of_type_DovComQqImCaptureAdapterFilterProviderPagerAdapter.jdField_do.get(k)).getAdapter();
        if ((localListAdapter instanceof axoy)) {
          ((axoy)localListAdapter).notifyDataSetChanged();
        }
        i += 1;
      }
    }
  }
  
  public void dLs()
  {
    super.dLs();
    if (this.jdField_c_of_type_DovComQqImCaptureViewProviderView$a != null) {
      this.jdField_c_of_type_DovComQqImCaptureViewProviderView$a.YI(false);
    }
  }
  
  public ArrayList<QIMSlidingTabView.b> dw()
  {
    ArrayList localArrayList = new ArrayList();
    int j = ayva.a().Io();
    int i = 0;
    while (i < this.FB.size())
    {
      QIMSlidingTabView.b localb = new QIMSlidingTabView.b();
      localb.tabName = ((FilterCategory)this.FB.get(i)).categoryName;
      ayva.a();
      localb.needRedDot = ayva.needShowRedDot(2, ((FilterCategory)this.FB.get(i)).categoryId, "");
      localArrayList.add(localb);
      if ((j != -1) && (j == ((FilterCategory)this.FB.get(i)).categoryId))
      {
        this.dzN = i;
        ayva.a().I(5, 0, null);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public void ex(Bundle paramBundle)
  {
    super.ex(paramBundle);
    initData(paramBundle);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_c_of_type_DovComQqImCaptureViewQIMSlidingTabView.setTabCheckListener(this);
    if (this.mContentView == null) {}
    for (this.b = ((QQViewPager)LayoutInflater.from(getContext()).inflate(2131561124, this, false));; this.b = ((QQViewPager)this.mContentView))
    {
      this.jdField_a_of_type_DovComQqImCaptureAdapterFilterProviderPagerAdapter = new FilterProviderPagerAdapter(this.mContext, this.eCJ);
      this.jdField_a_of_type_DovComQqImCaptureAdapterFilterProviderPagerAdapter.b(this);
      this.jdField_a_of_type_DovComQqImCaptureAdapterFilterProviderPagerAdapter.fC(new ArrayList());
      this.b.setOnPageChangeListener(this);
      this.b.setAdapter(this.jdField_a_of_type_DovComQqImCaptureAdapterFilterProviderPagerAdapter);
      addContentView(this.b);
      paramBundle = (axpr)axov.a(5);
      paramBundle.a(this);
      if (QLog.isColorLevel()) {
        QLog.d("QCombo", 2, "FilterProviderView onCreate");
      }
      paramBundle = paramBundle.jdField_a_of_type_Ayva$a;
      if (paramBundle != null) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("FilterProviderView", 2, "filterProviderView get data is null");
      }
      return;
    }
    setup(paramBundle.a(this.eCJ));
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ayva.a();
    ayva.Om(true);
    if (axov.a().oq(5))
    {
      axpr localaxpr = (axpr)axov.a(5);
      localaxpr.jdField_a_of_type_ArrayOfAxpr$b[this.eCJ].eNN();
      localaxpr.b(this);
    }
    if (QLog.isColorLevel()) {
      QLog.d("FilterProviderView", 2, "onDestroy");
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = null;
    if (paramView != null) {
      paramAdapterView = paramView.getTag();
    }
    if ((paramAdapterView != null) && ((paramAdapterView instanceof QIMFilterCategoryItem))) {
      paramAdapterView = (QIMFilterCategoryItem)paramAdapterView;
    }
    while (paramAdapterView.isWsBanner()) {
      do
      {
        rpw.a(this.mContext, paramAdapterView);
        do
        {
          return;
        } while (this.FB == null);
        paramAdapterView = (QIMFilterCategoryItem)((FilterCategory)this.FB.get(Rx())).Fv.get(paramInt);
      } while (paramAdapterView == null);
    }
    if ((paramLong > 0L) && (this.jdField_c_of_type_DovComQqImCaptureViewProviderView$a != null)) {
      this.jdField_c_of_type_DovComQqImCaptureViewProviderView$a.b(-1, paramAdapterView);
    }
    paramView = (axpr)axov.a(5);
    Bundle localBundle = new Bundle();
    localBundle.putInt("apply_source", 1);
    localBundle.putInt("capture_scene", this.eCJ);
    paramView.a(paramAdapterView, (Activity)getContext(), localBundle);
    ((axtq)axov.a(14)).hk(paramAdapterView.name, 1);
    ((axpr)axov.a(5)).a(this.eCJ, (Activity)this.mContext);
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    this.jdField_c_of_type_DovComQqImCaptureViewQIMSlidingTabView.TX(paramInt);
  }
  
  public void onResume()
  {
    super.onResume();
    ((axpr)axov.a(5)).a(this);
  }
  
  public void onStop()
  {
    super.onStop();
    ((axpr)axov.a(5)).b(this);
  }
  
  public void setup(ayva.b paramb)
  {
    if (this.jdField_c_of_type_DovComQqImCaptureViewQIMSlidingTabView == null) {
      return;
    }
    this.jdField_a_of_type_Ayva$b = paramb;
    this.FB = paramb.GF;
    this.jdField_c_of_type_DovComQqImCaptureViewQIMSlidingTabView.eL(dw());
    this.jdField_a_of_type_DovComQqImCaptureAdapterFilterProviderPagerAdapter = new FilterProviderPagerAdapter(this.mContext, this.eCJ);
    this.jdField_a_of_type_DovComQqImCaptureAdapterFilterProviderPagerAdapter.b(this);
    this.jdField_a_of_type_DovComQqImCaptureAdapterFilterProviderPagerAdapter.fC(this.FB);
    this.b.setAdapter(this.jdField_a_of_type_DovComQqImCaptureAdapterFilterProviderPagerAdapter);
    this.jdField_a_of_type_DovComQqImCaptureAdapterFilterProviderPagerAdapter.notifyDataSetChanged();
    if (this.FB.size() > this.dzN)
    {
      this.b.setCurrentItem(this.dzN);
      this.jdField_c_of_type_DovComQqImCaptureViewQIMSlidingTabView.TX(this.dzN);
    }
    this.jdField_a_of_type_DovComQqImCaptureAdapterFilterProviderPagerAdapter.notifyDataSetChanged();
    dLo();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.view.QIMFilterProviderView
 * JD-Core Version:    0.7.0.1
 */