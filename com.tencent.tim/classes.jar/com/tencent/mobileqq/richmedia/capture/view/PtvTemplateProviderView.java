package com.tencent.mobileqq.richmedia.capture.view;

import aarz;
import alvx;
import alwd;
import alwd.c;
import alwl;
import alwx;
import alxy;
import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anho;
import anjo;
import aqnm;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.adapter.PtvTemplateViewPagerAdapter;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.GridView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import wja;

public class PtvTemplateProviderView
  extends ProviderView
  implements alwd.c, alxy, ViewPager.OnPageChangeListener, ViewTreeObserver.OnScrollChangedListener, anho, QQSlidingTabView.a
{
  private ImageView Dg;
  private ImageView Dh;
  List<alwl> Ft = new CopyOnWriteArrayList();
  private View Gs;
  PtvTemplateViewPagerAdapter a;
  QQViewPager b;
  String bZw = "";
  private BroadcastReceiver bz;
  alwd jdField_c_of_type_Alwd;
  private alwl jdField_c_of_type_Alwl;
  private boolean cBh = true;
  boolean cBl = false;
  private boolean cBm;
  boolean czH = true;
  public int dzH;
  int dzN = 1;
  int dzO = -1;
  private int dzP = -1;
  private TextView mTipsTextView;
  
  public PtvTemplateProviderView(Context paramContext)
  {
    super(paramContext);
  }
  
  private void dLu()
  {
    this.Ft.clear();
    this.Ft.addAll(this.jdField_c_of_type_Alwd.du());
    if (this.a != null) {
      this.a.lV(this.Ft);
    }
    if (this.jdField_c_of_type_ComTencentMobileqqRichmediaCaptureViewQQSlidingTabView != null) {
      this.jdField_c_of_type_ComTencentMobileqqRichmediaCaptureViewQQSlidingTabView.eL(dx());
    }
    dLv();
    int i = this.jdField_c_of_type_ComTencentMobileqqRichmediaCaptureViewQQSlidingTabView.getScrollX();
    if (this.mTipsTextView == null) {
      dLx();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PtvTemplateProviderView", 2, "PtvTemplateProviderView reloadDataAndNotifyDataChanged size=" + this.Ft.size());
      }
      dLt();
      return;
      if (i != 0) {
        dLw();
      }
    }
  }
  
  private void dLv()
  {
    ThreadManager.getUIHandler().post(new PtvTemplateProviderView.1(this));
  }
  
  private ArrayList<QQSlidingTabView.b> dx()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_c_of_type_Alwd != null) {}
    for (int i = this.jdField_c_of_type_Alwd.Io();; i = -1)
    {
      int j = 0;
      while (j < this.Ft.size())
      {
        alwl localalwl = (alwl)this.Ft.get(j);
        if ((i != -1) && (i == localalwl.categoryId))
        {
          this.dzN = j;
          if (this.jdField_c_of_type_Alwd != null) {
            this.jdField_c_of_type_Alwd.I(5, 0, null);
          }
        }
        QQSlidingTabView.b localb = new QQSlidingTabView.b();
        localb.tabName = localalwl.categoryName;
        localb.czY = localalwl.czY;
        if (this.jdField_c_of_type_Alwd != null) {
          localb.needRedDot = this.jdField_c_of_type_Alwd.needShowRedDot(2, localalwl.categoryId, "");
        }
        localArrayList.add(localb);
        j += 1;
      }
      return localArrayList;
    }
  }
  
  @TargetApi(9)
  public void TX(int paramInt)
  {
    this.b.setCurrentItem(paramInt);
    paramInt = ((alwl)this.Ft.get(paramInt)).categoryId;
    if (this.jdField_c_of_type_Alwd != null) {
      this.jdField_c_of_type_Alwd.I(2, paramInt, "");
    }
  }
  
  public void a(Object paramObject, int paramInt, Object... paramVarArgs)
  {
    if ((paramInt != 114) || (paramVarArgs == null) || (paramVarArgs.length != 1)) {
      return;
    }
    dLw();
  }
  
  public boolean bg(int paramInt1, int paramInt2)
  {
    if (this.mApp == null) {}
    for (Object localObject = BaseApplicationImpl.sApplication.getRuntime();; localObject = this.mApp)
    {
      localObject = getContext().getSharedPreferences(anjo.cer + ((AppRuntime)localObject).getAccount(), 4);
      if (!((SharedPreferences)localObject).getBoolean(paramInt1 + "&" + paramInt2, false)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PtvTemplateProviderView", 2, new Object[] { "VideoRedbag, checkTipsLayoutShown, already shown, id:", Integer.valueOf(paramInt1), " tipver:", Integer.valueOf(paramInt2) });
      }
      return true;
    }
    if (((SharedPreferences)localObject).contains(String.valueOf(paramInt1)))
    {
      if (((SharedPreferences)localObject).getInt(String.valueOf(paramInt1), 0) > paramInt2)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PtvTemplateProviderView", 2, new Object[] { "VideoRedbag, checkTipsLayoutShown, exist high version, id:", Integer.valueOf(paramInt1), " tipver:", Integer.valueOf(paramInt2) });
        }
        return true;
      }
      ((SharedPreferences)localObject).edit().remove(String.valueOf(paramInt1)).commit();
    }
    if (QLog.isColorLevel()) {
      QLog.d("PtvTemplateProviderView", 2, new Object[] { "VideoRedbag, checkTipsLayoutShown, not shown, id: ", Integer.valueOf(paramInt1), " tipver: ", Integer.valueOf(paramInt2) });
    }
    return false;
  }
  
  public void dKI()
  {
    super.dKI();
    this.cBh = true;
    dLt();
  }
  
  public void dKk()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PtvTemplateProviderView", 2, "PtvTemplateProviderView onCapturePtvTemplateRefresh");
    }
    if (Looper.getMainLooper().getThread() == Thread.currentThread())
    {
      dLu();
      return;
    }
    ThreadManager.getUIHandler().post(new PtvTemplateProviderView.2(this));
  }
  
  public void dLt()
  {
    Iterator localIterator = this.a.mF.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Integer)localIterator.next();
      localObject = (GridView)this.a.mF.get(localObject);
      if (localObject != null)
      {
        localObject = ((GridView)localObject).getAdapter();
        if ((localObject != null) && ((localObject instanceof alvx))) {
          ((alvx)localObject).notifyDataSetChanged();
        }
      }
    }
  }
  
  public void dLw()
  {
    if ((this.mTipsTextView != null) && (this.mTipsTextView.getVisibility() == 0))
    {
      this.Gs = null;
      this.mTipsTextView.setVisibility(8);
      this.Dg.setVisibility(8);
      if (this.Dh != null) {
        this.Dh.setVisibility(8);
      }
      if (this.jdField_c_of_type_Alwl != null) {
        if (this.mApp != null) {
          break label192;
        }
      }
    }
    label192:
    for (Object localObject = BaseApplicationImpl.sApplication.getRuntime();; localObject = this.mApp)
    {
      String str = this.jdField_c_of_type_Alwl.categoryId + "&" + this.jdField_c_of_type_Alwl.dyC;
      localObject = getContext().getSharedPreferences(anjo.cer + ((AppRuntime)localObject).getAccount(), 4).edit();
      ((SharedPreferences.Editor)localObject).putBoolean(str, true);
      ((SharedPreferences.Editor)localObject).putInt(String.valueOf(this.jdField_c_of_type_Alwl.categoryId), this.jdField_c_of_type_Alwl.dyC);
      ((SharedPreferences.Editor)localObject).commit();
      return;
    }
  }
  
  public void dLx()
  {
    int i;
    label134:
    int m;
    int i2;
    int k;
    int n;
    try
    {
      if (this.jdField_c_of_type_ComTencentMobileqqRichmediaCaptureViewQQSlidingTabView == null) {
        return;
      }
      if (this.cBm) {
        break label134;
      }
      this.cBm = true;
      localObject = alwd.a().du();
      i = 0;
    }
    catch (Exception localException)
    {
      Object localObject;
      int j;
      int i1;
      RelativeLayout.LayoutParams localLayoutParams;
      label939:
      label944:
      label957:
      label993:
      label1005:
      while (QLog.isColorLevel())
      {
        QLog.d("PtvTemplateProviderView", 2, new Object[] { "VideoRedbag, showTipsLayout ", localException.getMessage() });
        return;
        i += 1;
        continue;
        j = 0;
        continue;
        this.Dg.setImageResource(2130850732);
        continue;
        this.mTipsTextView.setTextColor(-16777216);
        this.mTipsTextView.setBackgroundResource(2130850734);
        this.mTipsTextView.setPadding(n, k, n, k);
        continue;
        localLayoutParams.setMargins(k, 0, i, 0);
      }
    }
    if (i < ((ArrayList)localObject).size())
    {
      this.jdField_c_of_type_Alwl = ((alwl)((ArrayList)localObject).get(i));
      if ((this.jdField_c_of_type_Alwl.bZc != null) && (!bg(this.jdField_c_of_type_Alwl.categoryId, this.jdField_c_of_type_Alwl.dyC))) {
        this.dzP = i;
      }
    }
    else
    {
      if ((this.dzP != -1) && (this.jdField_c_of_type_ComTencentMobileqqRichmediaCaptureViewQQSlidingTabView.dy().size() > this.dzP)) {
        this.Gs = ((View)this.jdField_c_of_type_ComTencentMobileqqRichmediaCaptureViewQQSlidingTabView.dy().get(this.dzP));
      }
      if ((this.Gs == null) || (this.jdField_c_of_type_Alwl == null)) {
        break label1008;
      }
      i = this.Gs.getLeft();
      j = this.Gs.getRight();
      m = this.Gs.getWidth();
      if ((i == 0) && (j == 0)) {
        break label1008;
      }
      i2 = aqnm.getScreenWidth();
      i1 = this.jdField_c_of_type_ComTencentMobileqqRichmediaCaptureViewQQSlidingTabView.getScrollX();
      j = m / 2 + i - i1;
      k = wja.dp2px(30.0F, getContext().getResources());
      if ((j <= 0) || (j + k >= i2)) {
        break label939;
      }
      j = 1;
      if ((this.mTipsTextView == null) && (j != 0) && (this.dzM == 2))
      {
        if ((this.mBaseView == null) || (!(this.mBaseView instanceof RelativeLayout))) {
          break label1008;
        }
        localObject = getContext();
        this.Dg = new ImageView((Context)localObject);
        this.Dg.setId(2131378277);
        if (!this.jdField_c_of_type_Alwl.czY) {
          break label944;
        }
        this.Dg.setImageResource(2130850733);
        localLayoutParams = new RelativeLayout.LayoutParams(wja.dp2px(20.0F, ((Context)localObject).getResources()), wja.dp2px(10.0F, ((Context)localObject).getResources()));
        localLayoutParams.addRule(2, this.jdField_c_of_type_ComTencentMobileqqRichmediaCaptureViewQQSlidingTabView.getId());
        localLayoutParams.addRule(9);
        localLayoutParams.leftMargin = (m / 2 + i - wja.dp2px(20.0F, ((Context)localObject).getResources()) / 2);
        localLayoutParams.bottomMargin = 5;
        ((RelativeLayout)this.mBaseView).addView(this.Dg, localLayoutParams);
        this.mTipsTextView = new TextView((Context)localObject);
        this.mTipsTextView.setText(this.jdField_c_of_type_Alwl.bZc);
        k = wja.dp2px(5.0F, ((Context)localObject).getResources());
        n = wja.dp2px(5.0F, ((Context)localObject).getResources());
        if (!this.jdField_c_of_type_Alwl.czY) {
          break label957;
        }
        this.mTipsTextView.setTextColor(Color.parseColor("#FBD49D"));
        this.mTipsTextView.setBackgroundResource(2130850735);
        this.mTipsTextView.setPadding(wja.dp2px(30.0F, ((Context)localObject).getResources()), k, n, k);
        this.mTipsTextView.setTextSize(1, 16.0F);
        this.mTipsTextView.setGravity(17);
        this.mTipsTextView.setSingleLine();
        this.mTipsTextView.measure(-2, -2);
        k = this.mTipsTextView.getMeasuredWidth();
        if (!this.jdField_c_of_type_Alwl.czY) {
          break label1005;
        }
        k += wja.dp2px(17.0F, ((Context)localObject).getResources());
        m = m / 2 + i - k / 2;
        n = i2 - m - k;
        i = 16;
        if ((n >= 16) || (k + 32 >= i2)) {
          break label1025;
        }
        if (n >= 16) {
          break label1019;
        }
        break label1009;
        localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.addRule(2, 2131378277);
        localLayoutParams.addRule(9);
        if (!this.jdField_c_of_type_Alwl.czY) {
          break label993;
        }
        localLayoutParams.setMargins(wja.dp2px(17.0F, ((Context)localObject).getResources()) + k, 0, i, 0);
        ((RelativeLayout)this.mBaseView).addView(this.mTipsTextView, localLayoutParams);
        if (this.jdField_c_of_type_Alwl.czY)
        {
          this.Dh = new ImageView((Context)localObject);
          this.Dh.setImageResource(2130850736);
          localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
          localLayoutParams.addRule(2, this.jdField_c_of_type_ComTencentMobileqqRichmediaCaptureViewQQSlidingTabView.getId());
          localLayoutParams.addRule(9);
          localLayoutParams.leftMargin = k;
          localLayoutParams.bottomMargin = wja.dp2px(3.0F, ((Context)localObject).getResources());
          ((RelativeLayout)this.mBaseView).addView(this.Dh, localLayoutParams);
        }
      }
      if ((this.mTipsTextView == null) || (j == 0)) {
        break label1008;
      }
      this.mTipsTextView.setTranslationX(-i1);
      this.Dg.setTranslationX(-i1);
      this.mTipsTextView.setVisibility(0);
      this.Dg.setVisibility(0);
      if (this.Dh == null) {
        break label1008;
      }
      this.Dh.setTranslationX(-i1);
      this.Dh.setVisibility(0);
      return;
    }
    label1008:
    return;
    for (;;)
    {
      label1009:
      k = i2 - i - k;
      break;
      label1019:
      i = n;
    }
    label1025:
    if (m < 16) {}
    for (;;)
    {
      m = i2 - i - k;
      k = i;
      i = m;
      break;
      i = m;
    }
  }
  
  public String getTag()
  {
    return "PtvTemplateProviderView";
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (this.mContentView == null) {
      this.mContentView = LayoutInflater.from(getContext()).inflate(2131561778, this, false);
    }
    alwd.a().a(this);
    alwd.a().a(this, 114);
    this.bz = new a(null);
    getContext().registerReceiver(this.bz, new IntentFilter("action_brocassreceiver_for_ptv"));
    addContentView(this.mContentView);
    this.b = ((QQViewPager)findViewById(2131381896));
    this.a = new PtvTemplateViewPagerAdapter(this.mContext, this.mApp, this.jdField_c_of_type_ComTencentMobileqqRichmediaCaptureViewProviderView$a, this.czH);
    this.jdField_c_of_type_Alwd = alwd.a();
    this.Ft.clear();
    this.Ft.addAll(this.jdField_c_of_type_Alwd.du());
    this.a.lV(this.Ft);
    this.b.setOnPageChangeListener(this);
    this.b.setAdapter(this.a);
    this.jdField_c_of_type_ComTencentMobileqqRichmediaCaptureViewQQSlidingTabView.eL(dx());
    this.jdField_c_of_type_ComTencentMobileqqRichmediaCaptureViewQQSlidingTabView.setTabCheckListener(this);
    this.jdField_c_of_type_ComTencentMobileqqRichmediaCaptureViewQQSlidingTabView.getViewTreeObserver().addOnScrollChangedListener(this);
    dLv();
    if (this.Ft.size() > 1) {
      aarz.Gq(1);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PtvTemplateProviderView", 2, "PtvTemplateProviderView onCreate size=" + this.Ft.size());
      }
      return;
      aarz.Gq(0);
    }
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    this.cBh = false;
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    this.jdField_c_of_type_ComTencentMobileqqRichmediaCaptureViewQQSlidingTabView.TX(paramInt);
    this.dzH = paramInt;
    if (!this.cBh) {
      alwx.Po(((alwl)this.Ft.get(paramInt)).categoryId + "");
    }
    dLw();
  }
  
  public void onScrollChanged()
  {
    int i = this.jdField_c_of_type_ComTencentMobileqqRichmediaCaptureViewQQSlidingTabView.getScrollX();
    if (this.mTipsTextView == null) {
      dLx();
    }
    while (i == 0) {
      return;
    }
    dLw();
  }
  
  public void setNeedAdvertisement(boolean paramBoolean)
  {
    this.czH = paramBoolean;
  }
  
  public void setTab(int paramInt)
  {
    int i = 0;
    if (i < this.Ft.size()) {
      if (((alwl)this.Ft.get(i)).categoryId != paramInt) {}
    }
    for (;;)
    {
      if ((this.b != null) && (i > 0)) {
        this.b.setCurrentItem(i);
      }
      if ((this.jdField_c_of_type_ComTencentMobileqqRichmediaCaptureViewQQSlidingTabView != null) && (i > 0)) {
        this.jdField_c_of_type_ComTencentMobileqqRichmediaCaptureViewQQSlidingTabView.TX(i);
      }
      if (i == 0) {
        this.dzO = paramInt;
      }
      return;
      i += 1;
      break;
      i = 0;
    }
  }
  
  public void setTab(String paramString)
  {
    int i = 0;
    if (i < this.Ft.size()) {
      if (!((alwl)this.Ft.get(i)).categoryName.equals(paramString)) {}
    }
    for (;;)
    {
      if ((this.b != null) && (i > 0)) {
        this.b.setCurrentItem(i);
      }
      if ((this.jdField_c_of_type_ComTencentMobileqqRichmediaCaptureViewQQSlidingTabView != null) && (i > 0)) {
        this.jdField_c_of_type_ComTencentMobileqqRichmediaCaptureViewQQSlidingTabView.TX(i);
      }
      if (i == 0) {
        this.bZw = paramString;
      }
      return;
      i += 1;
      break;
      i = 0;
    }
  }
  
  final class a
    extends BroadcastReceiver
  {
    private a() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if ("action_brocassreceiver_for_ptv".equals(paramIntent.getAction()))
      {
        alwd.a().Ol(false);
        PtvTemplateProviderView.a(PtvTemplateProviderView.this);
        if (QLog.isColorLevel()) {
          QLog.d("PtvTemplateProviderView", 2, "PtvTemplateProviderView PtvBroadcastReceiver size=" + PtvTemplateProviderView.this.Ft.size());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.PtvTemplateProviderView
 * JD-Core Version:    0.7.0.1
 */