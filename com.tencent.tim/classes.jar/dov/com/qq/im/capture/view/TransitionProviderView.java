package dov.com.qq.im.capture.view;

import acfp;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import auru;
import axov;
import axpr;
import axrh;
import axro;
import axxw;
import ayih;
import ayva;
import ayva.a;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.c;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import dov.com.qq.im.capture.adapter.TransitionProviderPagerAdapter;
import dov.com.qq.im.capture.data.FilterCategory;
import dov.com.qq.im.capture.data.TransitionCategoryItem;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;
import java.util.ArrayList;
import java.util.List;
import rar;
import rly;
import rly.a;
import rma;

public class TransitionProviderView
  extends ProviderView
  implements Handler.Callback, ViewPager.OnPageChangeListener, AdapterView.c, QIMSlidingTabView.a
{
  public ArrayList<FilterCategory> FB;
  axrh jdField_a_of_type_Axrh = new axxw(this);
  private TransitionProviderPagerAdapter jdField_a_of_type_DovComQqImCaptureAdapterTransitionProviderPagerAdapter;
  public auru b;
  private QQViewPager b;
  public int dzN;
  public MusicItemInfo e;
  public int eIK = -1;
  
  public TransitionProviderView(Context paramContext)
  {
    super(paramContext);
    this.jdField_b_of_type_Auru = new auru(Looper.getMainLooper(), this);
  }
  
  private void n(MusicItemInfo paramMusicItemInfo)
  {
    axro localaxro;
    if (paramMusicItemInfo != null)
    {
      localaxro = (axro)axov.a().c(8);
      if ((localaxro == null) || (!localaxro.b(paramMusicItemInfo))) {
        break label52;
      }
      localaxro.a(paramMusicItemInfo);
      if (this.jdField_c_of_type_DovComQqImCaptureViewProviderView$a != null) {
        this.jdField_c_of_type_DovComQqImCaptureViewProviderView$a.uZ(true);
      }
    }
    label52:
    while (localaxro == null) {
      return;
    }
    localaxro.a(paramMusicItemInfo, this.jdField_a_of_type_Axrh);
  }
  
  protected int QW()
  {
    return 0;
  }
  
  public void TX(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > this.FB.size())) {
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQViewPager.setCurrentItem(paramInt);
  }
  
  public void dLo()
  {
    if (!this.mInited) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("TransitionProviderView", 2, "TransitionProviderView updateSelectedState");
      }
    } while (this.jdField_a_of_type_DovComQqImCaptureAdapterTransitionProviderPagerAdapter == null);
    this.jdField_a_of_type_DovComQqImCaptureAdapterTransitionProviderPagerAdapter.dLo();
  }
  
  public ArrayList<QIMSlidingTabView.b> dw()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.FB.size())
    {
      QIMSlidingTabView.b localb = new QIMSlidingTabView.b();
      localb.tabName = ((FilterCategory)this.FB.get(i)).categoryName;
      localb.needRedDot = false;
      localb.cWw = (acfp.m(2131715428) + localb.tabName + acfp.m(2131715429));
      localArrayList.add(localb);
      i += 1;
    }
    return localArrayList;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      n(this.e);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QCombo", 2, "TransitionProviderView onCreate");
    }
    super.onCreate(paramBundle);
    this.jdField_c_of_type_DovComQqImCaptureViewQIMSlidingTabView.setTabCheckListener(this);
    if (this.mContentView == null) {}
    for (this.jdField_b_of_type_ComTencentMobileqqWidgetQQViewPager = ((QQViewPager)LayoutInflater.from(getContext()).inflate(2131561124, this, false));; this.jdField_b_of_type_ComTencentMobileqqWidgetQQViewPager = ((QQViewPager)this.mContentView))
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetQQViewPager.setOnPageChangeListener(this);
      addContentView(this.jdField_b_of_type_ComTencentMobileqqWidgetQQViewPager);
      paramBundle = ((axpr)axov.a(5)).a;
      if (paramBundle != null) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QCombo", 2, "comboFilterData null");
      }
      return;
    }
    setup(paramBundle.eR());
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_DovComQqImCaptureAdapterTransitionProviderPagerAdapter != null) {
      this.jdField_a_of_type_DovComQqImCaptureAdapterTransitionProviderPagerAdapter.onDestroy();
    }
    super.onDestroy();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramView == null) {
      break label4;
    }
    for (;;)
    {
      label4:
      return;
      if (this.jdField_b_of_type_ComTencentMobileqqWidgetQQViewPager.getCurrentItem() < this.FB.size())
      {
        paramAdapterView = (FilterCategory)this.FB.get(this.jdField_b_of_type_ComTencentMobileqqWidgetQQViewPager.getCurrentItem());
        if (paramInt >= paramAdapterView.Fv.size()) {
          break;
        }
        paramView = (TransitionCategoryItem)paramAdapterView.Fv.get(paramInt);
        if ((paramView != null) && (!paramView.equals(ayva.a().a())))
        {
          ayva.a().a(paramView);
          dLo();
          if (this.jdField_c_of_type_DovComQqImCaptureViewProviderView$a != null)
          {
            paramInt = Integer.parseInt(paramView.id);
            this.jdField_c_of_type_DovComQqImCaptureViewProviderView$a.aey(paramInt);
          }
          rar.a("video_edit_transition", "clk_effects", ayih.lZ(this.eIK), 0, new String[] { paramView.transId, paramView.cVO, paramView.cVN, paramView.themeId });
        }
        if (rma.a().tG() == 22)
        {
          if ((paramView == null) || (Integer.valueOf(paramView.id).intValue() >= 0)) {
            break label307;
          }
          LpReportInfo_pf00064.allReport(680, 7, 2);
        }
        while (paramView != null)
        {
          paramAdapterView = new MusicItemInfo();
          paramAdapterView.mType = 2;
          paramView = rly.a(getContext()).S(paramView.transId);
          if ((paramView == null) || (paramView.size() <= 0)) {
            break label372;
          }
          this.e = ((QIMMusicConfigManager)axov.a(2)).a(((rly.a)paramView.get(0)).tagId, ((rly.a)paramView.get(0)).itemId);
          if (this.e == null) {
            break label366;
          }
          n(this.e);
          return;
          label307:
          if ((paramView != null) && (Integer.valueOf(paramView.id).intValue() == 4)) {
            LpReportInfo_pf00064.allReport(680, 7, 1);
          } else if ((paramView != null) && (Integer.valueOf(paramView.id).intValue() > 0)) {
            LpReportInfo_pf00064.allReport(680, 7, 3);
          }
        }
      }
    }
    label366:
    n(paramAdapterView);
    return;
    label372:
    n(paramAdapterView);
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    this.jdField_c_of_type_DovComQqImCaptureViewQIMSlidingTabView.TX(paramInt);
  }
  
  public void onResume()
  {
    ApngImage.playByTag(16);
    super.onResume();
  }
  
  public void onStop()
  {
    ApngImage.pauseByTag(16);
    super.onStop();
  }
  
  public void setup(ArrayList<FilterCategory> paramArrayList)
  {
    if (paramArrayList == null) {}
    do
    {
      return;
      this.FB = new ArrayList(5);
      this.FB.addAll(paramArrayList);
      this.jdField_c_of_type_DovComQqImCaptureViewQIMSlidingTabView.eL(dw());
      this.jdField_a_of_type_DovComQqImCaptureAdapterTransitionProviderPagerAdapter = new TransitionProviderPagerAdapter(this.mContext, this.eCJ);
      this.jdField_a_of_type_DovComQqImCaptureAdapterTransitionProviderPagerAdapter.fC(this.FB);
      this.jdField_a_of_type_DovComQqImCaptureAdapterTransitionProviderPagerAdapter.b(this);
      this.jdField_b_of_type_ComTencentMobileqqWidgetQQViewPager.setAdapter(this.jdField_a_of_type_DovComQqImCaptureAdapterTransitionProviderPagerAdapter);
      this.jdField_a_of_type_DovComQqImCaptureAdapterTransitionProviderPagerAdapter.notifyDataSetChanged();
    } while (this.FB.size() <= this.dzN);
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQViewPager.setCurrentItem(this.dzN);
    this.jdField_c_of_type_DovComQqImCaptureViewQIMSlidingTabView.TX(this.dzN);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.view.TransitionProviderView
 * JD-Core Version:    0.7.0.1
 */