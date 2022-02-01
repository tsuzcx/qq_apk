package dov.com.qq.im.capture.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListAdapter;
import axov;
import axpr;
import axpr.a;
import axpu;
import axpz;
import axqc;
import axqf;
import axqm;
import axsu;
import axtq;
import axwm;
import axxj;
import ayva;
import ayva.a;
import ayva.b;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.c;
import com.tencent.widget.GridView;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import dov.com.qq.im.capture.adapter.ComboProviderGridAdapter;
import dov.com.qq.im.capture.adapter.ComboProviderPagerAdapter;
import dov.com.qq.im.capture.data.FilterCategory;
import dov.com.qq.im.capture.data.QIMFilterCategoryItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import rma;
import rpw;

public class ComboProviderView
  extends ProviderView
  implements Handler.Callback, ViewPager.OnPageChangeListener, axpr.a, AdapterView.c, QIMSlidingTabView.a
{
  ArrayList<FilterCategory> FB;
  public ayva.b a;
  ComboProviderPagerAdapter a;
  QQViewPager b;
  axpu c;
  public int dzN;
  public Handler mUiHandler = new Handler(Looper.getMainLooper(), this);
  
  public ComboProviderView(Context paramContext)
  {
    super(paramContext);
    this.jdField_c_of_type_Axpu = new axwm(this);
  }
  
  private void initData(Bundle paramBundle)
  {
    Object localObject = null;
    if (paramBundle != null) {
      localObject = paramBundle.getBundle(ComboProviderView.class.getSimpleName());
    }
    if (localObject != null)
    {
      paramBundle = (QIMFilterCategoryItem)((Bundle)localObject).getParcelable("select_filter_item");
      if (paramBundle != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ComboProviderView", 2, "restore " + paramBundle.id);
        }
        localObject = (axpr)axov.a(5);
        if (((this.eCJ == 2) || (this.eCJ == 1)) && (ayva.a().a[this.eCJ] == null)) {
          ayva.a().a[this.eCJ] = ((axpr)localObject).a(paramBundle);
        }
        paramBundle = ((axpr)localObject).a;
        if (paramBundle != null) {
          this.jdField_a_of_type_Ayva$b = paramBundle.a(this.eCJ);
        }
      }
    }
  }
  
  protected Bundle D()
  {
    Bundle localBundle = new Bundle();
    QIMFilterCategoryItem localQIMFilterCategoryItem1 = ayva.a().b(this.eCJ);
    if (localQIMFilterCategoryItem1 != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ComboProviderView", 2, "save " + localQIMFilterCategoryItem1.id);
      }
      localBundle.putParcelable("select_filter_item", localQIMFilterCategoryItem1);
      if ((this.FB != null) && (!this.FB.isEmpty()) && (Rx() >= 0) && (Rx() < this.FB.size()))
      {
        FilterCategory localFilterCategory = (FilterCategory)this.FB.get(Rx());
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
    eOY();
  }
  
  public void a(axqf paramaxqf, boolean paramBoolean, int paramInt, Bundle paramBundle) {}
  
  public void a(axqm paramaxqm, boolean paramBoolean, int paramInt, Bundle paramBundle) {}
  
  public void a(ayva.a parama)
  {
    setup(parama.a(this.eCJ));
  }
  
  public void apk()
  {
    super.apk();
    if (this.jdField_a_of_type_Ayva$b != null)
    {
      axpr localaxpr = (axpr)axov.a(5);
      Activity localActivity = (Activity)getContext();
      ayva.b localb = localaxpr.a.a(this.eCJ);
      if (localb.g != null) {
        localaxpr.a(localb.g).b(localActivity, this.eCJ);
      }
      ayva.a().a(localb.g, localActivity, this.eCJ);
      eOY();
    }
  }
  
  public void aq(int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComboProviderView", 2, "category= " + paramInt + " categoryName= " + paramString1 + ",itemId=" + paramString2);
    }
    if (this.FB == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ComboProviderView", 2, "selectCategoryAndItem when mTagInfos null " + paramInt + " " + paramString2);
      }
      return;
    }
    int i = 0;
    label105:
    if (i < this.FB.size()) {
      if ((paramInt != -1) && (((FilterCategory)this.FB.get(i)).categoryId == paramInt)) {
        paramInt = i;
      }
    }
    for (;;)
    {
      label144:
      a().TX(paramInt);
      Object localObject = (FilterCategory)this.FB.get(Rx());
      i = 0;
      label171:
      if (i < ((FilterCategory)localObject).Fv.size())
      {
        paramString1 = (QIMFilterCategoryItem)((FilterCategory)localObject).Fv.get(i);
        if (!paramString1.id.equals(paramString2)) {}
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ComboProviderView", 2, "itemInfo= " + paramString1 + ",index=" + paramInt + ",pos=" + i);
        }
        if (paramString1 == null) {
          break;
        }
        if (paramString1.isWsBanner())
        {
          rpw.a(this.mContext, paramString1);
          return;
          if ((paramString1 != null) && (paramString1.equals(((FilterCategory)this.FB.get(i)).categoryName)))
          {
            paramInt = i;
            break label144;
          }
          i += 1;
          break label105;
          i += 1;
          break label171;
        }
        postDelayed(new ComboProviderView.2(this, i), 500L);
        paramString2 = (axpr)axov.a(5);
        localObject = new Bundle();
        ((Bundle)localObject).putInt("apply_source", 1);
        ((Bundle)localObject).putInt("capture_scene", this.eCJ);
        axqc localaxqc = paramString2.a(paramString1);
        if ((localaxqc.outState == 1) || (localaxqc.outState == 2)) {
          axxj.a(localaxqc).start();
        }
        paramString2.a(paramString1, (Activity)getContext(), (Bundle)localObject);
        eOY();
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("ComboProviderView", 2, "selectFilterItem state = " + paramString1);
        return;
        i = 0;
        paramString1 = null;
      }
      paramInt = 0;
    }
  }
  
  public void b(QIMFilterCategoryItem paramQIMFilterCategoryItem)
  {
    int j = 0;
    int k = paramQIMFilterCategoryItem.categoryId;
    int i = 0;
    if (i < this.FB.size()) {
      if (((FilterCategory)this.FB.get(i)).categoryId != k) {}
    }
    for (;;)
    {
      if (this.b.getCurrentItem() != i) {
        this.b.setCurrentItem(i);
      }
      Iterator localIterator = ((FilterCategory)this.FB.get(i)).Fv.iterator();
      i = j;
      for (;;)
      {
        if ((!localIterator.hasNext()) || (((QIMFilterCategoryItem)localIterator.next()).id.equals(paramQIMFilterCategoryItem.id)))
        {
          paramQIMFilterCategoryItem = this.jdField_a_of_type_DovComQqImCaptureAdapterComboProviderPagerAdapter.a(this.b.getCurrentItem());
          if (paramQIMFilterCategoryItem != null)
          {
            paramQIMFilterCategoryItem.setSelection(i);
            ((ComboProviderGridAdapter)paramQIMFilterCategoryItem.getAdapter()).eNE();
          }
          return;
          i += 1;
          break;
        }
        i += 1;
      }
      i = 0;
    }
  }
  
  public void dKI()
  {
    super.dKI();
    QIMFilterCategoryItem localQIMFilterCategoryItem = ((axpr)axov.a(5)).a().f;
    if (localQIMFilterCategoryItem != null) {
      b(localQIMFilterCategoryItem);
    }
  }
  
  public ArrayList<QIMSlidingTabView.b> dw()
  {
    ArrayList localArrayList = new ArrayList();
    int j = ayva.a().Si();
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
        ayva.a().I(7, 0, null);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public void eOY()
  {
    if (!this.mInited) {}
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("QCombo", 2, "ComboProviderView updateComboState");
      }
      int j = this.jdField_a_of_type_DovComQqImCaptureAdapterComboProviderPagerAdapter.jdField_do.size();
      int i = 0;
      while (i < j)
      {
        int k = this.jdField_a_of_type_DovComQqImCaptureAdapterComboProviderPagerAdapter.jdField_do.keyAt(i);
        ListAdapter localListAdapter = ((GridView)this.jdField_a_of_type_DovComQqImCaptureAdapterComboProviderPagerAdapter.jdField_do.get(k)).getAdapter();
        if ((localListAdapter instanceof ComboProviderGridAdapter)) {
          ((ComboProviderGridAdapter)localListAdapter).notifyDataSetChanged();
        }
        i += 1;
      }
    }
  }
  
  public void ex(Bundle paramBundle)
  {
    super.ex(paramBundle);
    initData(paramBundle);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_c_of_type_DovComQqImCaptureViewQIMSlidingTabView.setTabCheckListener(this);
    if (this.mContentView == null) {}
    for (this.b = ((QQViewPager)LayoutInflater.from(getContext()).inflate(2131561124, this, false));; this.b = ((QQViewPager)this.mContentView))
    {
      this.jdField_a_of_type_DovComQqImCaptureAdapterComboProviderPagerAdapter = new ComboProviderPagerAdapter(this.mContext, this.eCJ);
      this.jdField_a_of_type_DovComQqImCaptureAdapterComboProviderPagerAdapter.b(this);
      this.jdField_a_of_type_DovComQqImCaptureAdapterComboProviderPagerAdapter.fC(new ArrayList());
      this.b.setOnPageChangeListener(this);
      this.b.setAdapter(this.jdField_a_of_type_DovComQqImCaptureAdapterComboProviderPagerAdapter);
      addContentView(this.b);
      this.mApp.registObserver(this.jdField_c_of_type_Axpu);
      paramBundle = (axpr)axov.a(5);
      paramBundle.a(this);
      paramBundle.a().setScene(this.eCJ);
      if (QLog.isColorLevel()) {
        QLog.d("QCombo", 2, "ComboProviderView onCreate");
      }
      paramBundle = paramBundle.a;
      if (paramBundle != null) {
        setup(paramBundle.a(this.eCJ));
      }
      paramBundle = (axsu)axov.a().c(4);
      paramBundle.eNH();
      paramBundle.c(true, (Activity)getContext());
      return;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.mUiHandler != null)
    {
      this.mUiHandler.removeCallbacksAndMessages(null);
      this.mUiHandler = null;
    }
    if (this.mApp != null) {
      this.mApp.unRegistObserver(this.jdField_c_of_type_Axpu);
    }
    if (axov.a().oq(5)) {
      ((axpr)axov.a(5)).b(this);
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int i = Rx();
    paramAdapterView = (QIMFilterCategoryItem)((FilterCategory)this.FB.get(i)).Fv.get(paramInt);
    if (paramAdapterView.isWsBanner()) {
      rpw.a(this.mContext, paramAdapterView);
    }
    do
    {
      return;
      if ((paramLong > 0L) && (this.jdField_c_of_type_DovComQqImCaptureViewProviderView$a != null)) {
        this.jdField_c_of_type_DovComQqImCaptureViewProviderView$a.b(-1, paramAdapterView);
      }
      paramView = (axpr)axov.a(5);
      ((axtq)axov.a(14)).hk(paramAdapterView.id, 0);
      localObject = paramAdapterView.id;
    } while (paramView.a().m((String)localObject, getContext()));
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("apply_source", 1);
    ((Bundle)localObject).putInt("capture_scene", this.eCJ);
    axqc localaxqc = paramView.a(paramAdapterView);
    if ((localaxqc.outState == 1) || (localaxqc.outState == 2)) {
      axxj.a(localaxqc).start();
    }
    paramView.a(paramAdapterView, (Activity)getContext(), (Bundle)localObject);
    if ((rma.a().tG() == 22) && (paramAdapterView.type != null) && (paramAdapterView.type.isEmpty())) {
      LpReportInfo_pf00064.allReport(680, 6, 1);
    }
    if ((rma.a().tG() == 22) && (paramAdapterView.type != null) && (!paramAdapterView.type.isEmpty())) {
      LpReportInfo_pf00064.allReport(680, 6, 2);
    }
    eOY();
    if (QLog.isColorLevel()) {
      QLog.i("QCombo", 2, "onItemClick combo " + i + "," + paramInt + ", combo " + localaxqc);
    }
    if (QLog.isColorLevel()) {
      QLog.i("QCombo", 2, "onItemClick state = " + paramAdapterView);
    }
    ePc();
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
    axpr localaxpr = (axpr)axov.a(5);
    if (localaxpr.a().dvX)
    {
      localaxpr.a().dvX = false;
      ((QIMProviderContainerView)((Activity)getContext()).findViewById(2131373718)).aeT(0);
    }
    eOY();
  }
  
  public void onStop()
  {
    ayva.a();
    ayva.Om(true);
    super.onStop();
    if (axov.a().oq(5)) {
      ((axpr)axov.a(5)).a(this.eCJ, (Activity)getContext());
    }
  }
  
  public void setup(ayva.b paramb)
  {
    this.jdField_a_of_type_Ayva$b = paramb;
    this.FB = paramb.GE;
    this.jdField_c_of_type_DovComQqImCaptureViewQIMSlidingTabView.eL(dw());
    this.jdField_a_of_type_DovComQqImCaptureAdapterComboProviderPagerAdapter = new ComboProviderPagerAdapter(this.mContext, this.eCJ);
    this.jdField_a_of_type_DovComQqImCaptureAdapterComboProviderPagerAdapter.b(this);
    this.jdField_a_of_type_DovComQqImCaptureAdapterComboProviderPagerAdapter.fC(this.FB);
    this.b.setAdapter(this.jdField_a_of_type_DovComQqImCaptureAdapterComboProviderPagerAdapter);
    this.jdField_a_of_type_DovComQqImCaptureAdapterComboProviderPagerAdapter.notifyDataSetChanged();
    if (this.FB.size() > this.dzN)
    {
      this.b.setCurrentItem(this.dzN);
      this.jdField_c_of_type_DovComQqImCaptureViewQIMSlidingTabView.TX(this.dzN);
    }
    eOY();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.view.ComboProviderView
 * JD-Core Version:    0.7.0.1
 */