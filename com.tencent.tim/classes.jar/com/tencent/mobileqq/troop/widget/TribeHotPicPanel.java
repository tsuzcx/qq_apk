package com.tencent.mobileqq.troop.widget;

import ahyx;
import ahzd;
import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import anot;
import aqiw;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpic.HotPicMainPanel;
import com.tencent.mobileqq.hotpic.HotPicPageView.e;
import com.tencent.mobileqq.hotpic.HotPicPanelViewPagerAdapter;
import com.tencent.mobileqq.hotpic.HotPicTab;
import com.tencent.mobileqq.hotpic.HotPicTagInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TribeHotPicPanel
  extends HotPicMainPanel
{
  protected HotPicPageView.e a;
  protected boolean isShown;
  
  public TribeHotPicPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, HotPicPageView.e parame)
  {
    this.mApp = paramQQAppInterface;
    this.mContext = paramBaseActivity;
    this.mActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$e = parame;
    this.mLoadingView = findViewById(2131370787);
    this.DD = findViewById(2131368657);
    this.DC = LayoutInflater.from(paramBaseActivity).inflate(2131558659, null);
    this.DC.setVisibility(8);
    this.mViewPager = ((ViewPager)findViewById(2131368663));
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTab = ((HotPicTab)findViewById(2131368644));
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTab.setOnItemClickListener(this);
  }
  
  public void aM(int paramInt1, int paramInt2, int paramInt3) {}
  
  public boolean isShown()
  {
    return this.isShown;
  }
  
  public void onShow()
  {
    this.bQS = XPanelContainer.aLe;
    if (bQT > this.bQS) {}
    ahzd localahzd;
    Object localObject1;
    Object localObject3;
    for (boolean bool = true;; bool = false)
    {
      this.cjf = bool;
      if (QLog.isColorLevel()) {
        QLog.d("HotPicManager.Panel", 2, "onShow " + AppSetting.getRevision() + " init panelH " + this.bQS + " needExtendPanel" + this.cjf);
      }
      localahzd = ahzd.a(this.mApp);
      localahzd.a(this);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setInterceptListener(this);
      }
      localahzd.drb();
      localahzd.dre();
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).addAll(localahzd.di());
      if (!aoy()) {
        break label269;
      }
      localObject2 = new ArrayList();
      localObject3 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        HotPicTagInfo localHotPicTagInfo = (HotPicTagInfo)((Iterator)localObject3).next();
        if (localHotPicTagInfo.tagType == 2) {
          ((ArrayList)localObject2).add(localHotPicTagInfo);
        }
      }
    }
    if (((ArrayList)localObject2).size() > 0)
    {
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (HotPicTagInfo)((Iterator)localObject2).next();
        if (((ArrayList)localObject1).contains(localObject3)) {
          ((ArrayList)localObject1).remove(localObject3);
        }
      }
    }
    label269:
    Object localObject2 = ((ArrayList)localObject1).iterator();
    int i = 0;
    int j = -1;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (HotPicTagInfo)((Iterator)localObject2).next();
      this.jdField_a_of_type_Ahyx.a((HotPicTagInfo)localObject3);
      if (((HotPicTagInfo)localObject3).tagId == localahzd.dcz) {
        j = i;
      }
      i += 1;
    }
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPanelViewPagerAdapter = new HotPicPanelViewPagerAdapter(this, this.mViewPager);
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPanelViewPagerAdapter.setOnHotPicItemClickListener(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$e);
    this.mViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPanelViewPagerAdapter);
    this.mViewPager.setOnPageChangeListener(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPanelViewPagerAdapter);
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTab.X((List)localObject1, j);
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTab.setOnItemClickListener(this);
    if (j != -1) {
      this.mViewPager.setCurrentItem(j);
    }
    if (aqiw.isNetworkAvailable(this.mContext))
    {
      localObject1 = localahzd.di().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (HotPicTagInfo)((Iterator)localObject1).next();
        i = ((HotPicTagInfo)localObject2).tagId;
        j = ((HotPicTagInfo)localObject2).tagType;
        if ((i != 2) && (j != 255) && (!localahzd.kc(i))) {
          localahzd.Pz(i);
        }
      }
    }
    anot.a(this.mApp, "dc00898", "", "", "0X8007B11", "0X8007B11", 0, 0, "", "", "", "");
    dqW();
    dqZ();
    setVisibility(0);
    this.isShown = true;
  }
  
  public void yQ(boolean paramBoolean)
  {
    super.yQ(paramBoolean);
    this.isShown = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TribeHotPicPanel
 * JD-Core Version:    0.7.0.1
 */