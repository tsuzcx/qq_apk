package com.tencent.mobileqq.richmedia.capture.view;

import alvw;
import alwh;
import alwh.b;
import alwx;
import alxy;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListAdapter;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.adapter.FilterProviderPagerAdapter;
import com.tencent.mobileqq.richmedia.capture.data.FilterCategory;
import com.tencent.mobileqq.richmedia.capture.data.FilterCategoryItem;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.c;
import com.tencent.widget.GridView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.os.MqqHandler;

public class FilterProviderView
  extends ProviderView
  implements alwh.b, alxy, ViewPager.OnPageChangeListener, QQSlidingTabView.a, AdapterView.c
{
  FilterProviderPagerAdapter a;
  QQViewPager b;
  String bZv = "";
  private BroadcastReceiver by;
  private boolean cBh = true;
  boolean czH = true;
  public int dzH;
  List<FilterCategory> lI = new CopyOnWriteArrayList();
  public int mType = 0;
  
  public FilterProviderView(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.mType = paramInt;
  }
  
  private void refreshData()
  {
    this.lI.clear();
    this.lI.addAll(alwh.a().fX());
    if (this.jdField_c_of_type_ComTencentMobileqqRichmediaCaptureViewQQSlidingTabView != null) {
      this.jdField_c_of_type_ComTencentMobileqqRichmediaCaptureViewQQSlidingTabView.eL(dw());
    }
    if (this.a != null)
    {
      this.a.lV(this.lI);
      this.a.notifyDataSetChanged();
    }
    if (!TextUtils.isEmpty(this.bZv))
    {
      setTab(this.bZv);
      this.bZv = "";
    }
    if (QLog.isColorLevel()) {
      QLog.d("FilterProviderView", 2, "FilterProviderView refreshData size=" + this.lI.size());
    }
  }
  
  public void TX(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > this.lI.size())) {
      return;
    }
    this.dzH = paramInt;
    if (this.b != null) {
      this.b.setCurrentItem(paramInt);
    }
    alwh.a().I(2, ((FilterCategory)this.lI.get(paramInt)).categoryId, "");
  }
  
  public void dKI()
  {
    FilterCategoryItem localFilterCategoryItem = alwh.a().a();
    if (localFilterCategoryItem != null) {
      setTab(localFilterCategoryItem.categoryId);
    }
    dLo();
    this.cBh = true;
  }
  
  public void dKm()
  {
    ThreadManager.getUIHandler().post(new FilterProviderView.1(this));
  }
  
  public void dLo()
  {
    if (!this.mInited) {}
    for (;;)
    {
      return;
      int j = this.a.jdField_do.size();
      int i = 0;
      while (i < j)
      {
        int k = this.a.jdField_do.keyAt(i);
        ListAdapter localListAdapter = ((GridView)this.a.jdField_do.get(k)).getAdapter();
        if ((localListAdapter instanceof alvw)) {
          ((alvw)localListAdapter).notifyDataSetChanged();
        }
        i += 1;
      }
    }
  }
  
  public ArrayList<QQSlidingTabView.b> dw()
  {
    alwh localalwh = alwh.a();
    ArrayList localArrayList = new ArrayList();
    int j = localalwh.Io();
    int i = 0;
    while (i < this.lI.size())
    {
      QQSlidingTabView.b localb = new QQSlidingTabView.b();
      FilterCategory localFilterCategory = (FilterCategory)this.lI.get(i);
      localb.tabName = localFilterCategory.categoryName;
      localb.needRedDot = localalwh.needShowRedDot(2, ((FilterCategory)this.lI.get(i)).categoryId, "");
      localArrayList.add(localb);
      if ((j != -1) && (j == localFilterCategory.categoryId)) {
        localalwh.I(5, 0, null);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public void e(FilterCategoryItem paramFilterCategoryItem)
  {
    if ((paramFilterCategoryItem != null) && (paramFilterCategoryItem.advertisement))
    {
      if (this.jdField_c_of_type_ComTencentMobileqqRichmediaCaptureViewProviderView$a != null) {
        this.jdField_c_of_type_ComTencentMobileqqRichmediaCaptureViewProviderView$a.c(paramFilterCategoryItem);
      }
      return;
    }
    alwh.a().a(paramFilterCategoryItem);
    if ((this.jdField_c_of_type_ComTencentMobileqqRichmediaCaptureViewProviderView$a != null) && (paramFilterCategoryItem != null)) {
      this.jdField_c_of_type_ComTencentMobileqqRichmediaCaptureViewProviderView$a.b(paramFilterCategoryItem);
    }
    dLo();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.by = new a(null);
    getContext().registerReceiver(this.by, new IntentFilter("action_brocassreceiver_for_filter"));
    alwh.a().a(this);
    this.lI.clear();
    this.lI.addAll(alwh.a().fX());
    this.jdField_c_of_type_ComTencentMobileqqRichmediaCaptureViewQQSlidingTabView.eL(dw());
    this.jdField_c_of_type_ComTencentMobileqqRichmediaCaptureViewQQSlidingTabView.setTabCheckListener(this);
    if (this.mContentView == null) {}
    for (this.b = ((QQViewPager)LayoutInflater.from(getContext()).inflate(2131561635, this, false));; this.b = ((QQViewPager)this.mContentView))
    {
      this.a = new FilterProviderPagerAdapter(this.mContext, this.czH);
      this.a.b(this);
      this.a.lV(this.lI);
      this.b.setOnPageChangeListener(this);
      this.b.setAdapter(this.a);
      addContentView(this.b);
      if (QLog.isColorLevel()) {
        QLog.d("FilterProviderView", 2, "FilterProviderView onCreate size=" + this.lI.size());
      }
      int i = alwh.a().Io();
      if (i == -1) {
        break;
      }
      setTab(i);
      return;
    }
    setTab(0);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramView = (FilterCategory)this.lI.get(this.dzH);
    paramAdapterView = new ArrayList();
    if (this.czH) {
      paramAdapterView.addAll(paramView.Fv);
    }
    while (paramAdapterView.size() <= paramInt)
    {
      return;
      paramView = paramView.Fv.iterator();
      while (paramView.hasNext())
      {
        FilterCategoryItem localFilterCategoryItem = (FilterCategoryItem)paramView.next();
        if (!localFilterCategoryItem.advertisement) {
          paramAdapterView.add(localFilterCategoryItem);
        }
      }
    }
    e((FilterCategoryItem)paramAdapterView.get(paramInt));
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    this.cBh = false;
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    if (this.jdField_c_of_type_ComTencentMobileqqRichmediaCaptureViewQQSlidingTabView != null) {
      this.jdField_c_of_type_ComTencentMobileqqRichmediaCaptureViewQQSlidingTabView.TX(paramInt);
    }
    this.dzH = paramInt;
    if (!this.cBh) {
      alwx.Pp(((FilterCategory)this.lI.get(paramInt)).categoryId + "");
    }
  }
  
  public void setNeedAdvertisement(boolean paramBoolean)
  {
    this.czH = paramBoolean;
  }
  
  public void setTab(int paramInt)
  {
    int i = 0;
    if (i < this.lI.size()) {
      if (((FilterCategory)this.lI.get(i)).categoryId != paramInt) {}
    }
    for (;;)
    {
      if (this.b != null) {
        this.b.setCurrentItem(i);
      }
      if (this.jdField_c_of_type_ComTencentMobileqqRichmediaCaptureViewQQSlidingTabView != null) {
        this.jdField_c_of_type_ComTencentMobileqqRichmediaCaptureViewQQSlidingTabView.TX(i);
      }
      return;
      i += 1;
      break;
      i = 0;
    }
  }
  
  public void setTab(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    int i = 0;
    label10:
    if (i < this.lI.size()) {
      if (!((FilterCategory)this.lI.get(i)).categoryName.equals(paramString)) {}
    }
    for (;;)
    {
      if (this.b != null) {
        this.b.setCurrentItem(i);
      }
      if (this.jdField_c_of_type_ComTencentMobileqqRichmediaCaptureViewQQSlidingTabView != null) {
        this.jdField_c_of_type_ComTencentMobileqqRichmediaCaptureViewQQSlidingTabView.TX(i);
      }
      if (i != 0) {
        break;
      }
      this.bZv = paramString;
      return;
      i += 1;
      break label10;
      i = 0;
    }
  }
  
  final class a
    extends BroadcastReceiver
  {
    private a() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if ("action_brocassreceiver_for_filter".equals(paramIntent.getAction()))
      {
        alwh.a().init();
        FilterProviderView.a(FilterProviderView.this);
        if (QLog.isColorLevel()) {
          QLog.d("FilterProviderView", 2, "FilterProviderView FilterBroadcastReceiver size=" + FilterProviderView.this.lI.size());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.FilterProviderView
 * JD-Core Version:    0.7.0.1
 */