package com.tencent.mobileqq.activity.aio.panel;

import acfp;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.StateListDrawable;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.PokePanel;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import wja;
import xks;

public class PokeAndEmoPanel
  extends RelativeLayout
  implements ViewPager.OnPageChangeListener, View.OnClickListener
{
  private PokePanel jdField_b_of_type_ComTencentMobileqqActivityAioPokePanel;
  private PEPanel jdField_b_of_type_ComTencentMobileqqActivityAioPanelPEPanel;
  private QQViewPager jdField_b_of_type_ComTencentMobileqqWidgetQQViewPager;
  private int bWE;
  private BaseChatPie c;
  private ViewGroup dv;
  private int mCurrentIndex;
  private SessionInfo mSessionInfo;
  private View xa;
  private View xb;
  
  public PokeAndEmoPanel(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public PokeAndEmoPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public PokeAndEmoPanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public ImageView a(int paramInt1, int paramInt2, String paramString)
  {
    ImageButton localImageButton = new ImageButton(getContext());
    localImageButton.setLayoutParams(new LinearLayout.LayoutParams(wja.dp2px(50.0F, getResources()), -1));
    localImageButton.setId(paramInt1);
    localImageButton.setImageResource(paramInt2);
    StateListDrawable localStateListDrawable = new StateListDrawable();
    ColorDrawable localColorDrawable1 = new ColorDrawable();
    localColorDrawable1.setColor(-1644826);
    ColorDrawable localColorDrawable2 = new ColorDrawable();
    localStateListDrawable.addState(new int[] { 16842919 }, localColorDrawable1);
    localStateListDrawable.addState(new int[] { 16842913 }, localColorDrawable1);
    localStateListDrawable.addState(new int[0], localColorDrawable2);
    localImageButton.setBackgroundDrawable(localStateListDrawable);
    localImageButton.setContentDescription(paramString);
    return localImageButton;
  }
  
  public void a(BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    this.c = paramBaseChatPie;
    this.mSessionInfo = paramSessionInfo;
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQViewPager = ((QQViewPager)findViewById(2131372958));
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQViewPager.setOnPageChangeListener(this);
    this.dv = ((ViewGroup)findViewById(2131379177));
    this.xb = a(2131379159, 2130838269, getContext().getString(2131700634));
    this.xa = a(2131379158, 2130838270, getContext().getString(2131700633));
    if (AppSetting.enableTalkBack)
    {
      this.xb.setContentDescription(acfp.m(2131709791));
      this.xa.setContentDescription(acfp.m(2131709792));
    }
    this.xa.setOnClickListener(this);
    this.xb.setOnClickListener(this);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioPokePanel = ((PokePanel)View.inflate(getContext(), 2131558680, null));
    String str = xks.i(paramBaseChatPie.getApp());
    this.jdField_b_of_type_ComTencentMobileqqActivityAioPokePanel.a(paramBaseChatPie, paramSessionInfo, str);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioPokePanel.reload(str);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPEPanel = new PEPanel(getContext());
    str = xks.f(paramBaseChatPie.getApp(), 8);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPEPanel.a(paramBaseChatPie, paramSessionInfo);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPEPanel.reload(str);
    paramSessionInfo = new ArrayList();
    int i = xks.c(paramBaseChatPie.getApp(), 4);
    int j = xks.c(paramBaseChatPie.getApp(), 11);
    if ((i == 1) && (xks.bhj))
    {
      this.bWE = 1;
      this.dv.addView(this.xb);
      this.dv.addView(this.xa);
      paramSessionInfo.add(this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPEPanel);
      paramSessionInfo.add(this.jdField_b_of_type_ComTencentMobileqqActivityAioPokePanel);
      this.xb.setSelected(true);
      this.xa.setSelected(false);
      this.xb.setVisibility(0);
      if (j == 1)
      {
        this.xa.setVisibility(8);
        paramSessionInfo.remove(this.jdField_b_of_type_ComTencentMobileqqActivityAioPokePanel);
      }
      paramBaseChatPie = new PokeEmoPageAdapter(getContext(), paramSessionInfo);
      this.jdField_b_of_type_ComTencentMobileqqWidgetQQViewPager.setAdapter(paramBaseChatPie);
      if (paramSessionInfo.size() <= 1) {
        break label589;
      }
      this.mCurrentIndex = xks.bTJ;
      if (this.mCurrentIndex == -1) {
        this.mCurrentIndex = ((this.bWE + 1) % 2);
      }
      if ((this.bWE != 1) || (this.mCurrentIndex != 0)) {
        break label575;
      }
      this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPEPanel.cer();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PokeAndEmoPanel", 2, String.format(" init..entryType = %d,viewType = %d,currentIndex = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(this.mCurrentIndex) }));
      }
      return;
      this.bWE = 0;
      this.dv.addView(this.xa);
      this.dv.addView(this.xb);
      paramSessionInfo.add(this.jdField_b_of_type_ComTencentMobileqqActivityAioPokePanel);
      paramSessionInfo.add(this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPEPanel);
      this.xa.setSelected(true);
      this.xb.setSelected(false);
      if ((j != 1) && (xks.bhj)) {
        break;
      }
      this.xb.setVisibility(8);
      paramSessionInfo.remove(this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPEPanel);
      break;
      label575:
      this.jdField_b_of_type_ComTencentMobileqqWidgetQQViewPager.setCurrentItem(this.mCurrentIndex);
      continue;
      label589:
      if (this.bWE == 1) {
        this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPEPanel.cer();
      }
    }
  }
  
  public void clear()
  {
    this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPEPanel.clear();
    this.jdField_b_of_type_ComTencentMobileqqActivityAioPokePanel.clear();
    xks.bTJ = this.mCurrentIndex;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_b_of_type_ComTencentMobileqqWidgetQQViewPager.setCurrentItem(this.bWE, true);
      paramView.setSelected(true);
      this.xb.setSelected(false);
      continue;
      int i = this.bWE;
      this.jdField_b_of_type_ComTencentMobileqqWidgetQQViewPager.setCurrentItem((i + 1) % 2, true);
      paramView.setSelected(true);
      this.xa.setSelected(false);
    }
  }
  
  public void onHide()
  {
    this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPEPanel.onHide();
    this.jdField_b_of_type_ComTencentMobileqqActivityAioPokePanel.onHide();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    getParent().requestDisallowInterceptTouchEvent(true);
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    if (paramInt == this.bWE)
    {
      this.xa.setSelected(true);
      this.xb.setSelected(false);
    }
    for (;;)
    {
      this.mCurrentIndex = paramInt;
      xks.bTJ = this.mCurrentIndex;
      return;
      this.xb.setSelected(true);
      this.xa.setSelected(false);
      this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPEPanel.cer();
      if (QLog.isColorLevel()) {
        QLog.d("PokeAndEmoPanel", 2, String.format(" onPageSelected i = %d", new Object[] { Integer.valueOf(paramInt) }));
      }
    }
  }
  
  public void onShow()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqActivityAioPokePanel != null) {
      this.jdField_b_of_type_ComTencentMobileqqActivityAioPokePanel.onShow();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.panel.PokeAndEmoPanel
 * JD-Core Version:    0.7.0.1
 */