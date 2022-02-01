package com.tencent.mobileqq.ark;

import adqu;
import adqx;
import adrj;
import adrj.a;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import aqhv;
import aqik;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticonview.EmoticonPagerRadioGroup;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.theme.SkinnableBitmapDrawable;
import java.util.ArrayList;

public class ArkAppManagerPanel
  extends RelativeLayout
  implements adrj.a, ViewPager.OnPageChangeListener, View.OnClickListener
{
  public ArkPanelPagerAdapter a;
  private EmoticonPagerRadioGroup jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup;
  private QQViewPager jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager;
  private QQAppInterface app;
  private LinearLayout ir;
  private LinearLayout is;
  private int mState = 0;
  
  public ArkAppManagerPanel(Context paramContext)
  {
    super(paramContext);
  }
  
  public ArkAppManagerPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void Lr(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.mState = paramInt;
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setVisibility(8);
      this.ir.setVisibility(0);
      this.is.setVisibility(8);
      return;
    case 1: 
      this.mState = paramInt;
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setVisibility(0);
      this.ir.setVisibility(8);
      this.is.setVisibility(8);
      return;
    }
    this.mState = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setVisibility(8);
    this.ir.setVisibility(8);
    this.is.setVisibility(0);
  }
  
  public void a(BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    this.app = paramBaseChatPie.getApp();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager = ((QQViewPager)findViewById(2131368755));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup = ((EmoticonPagerRadioGroup)findViewById(2131368721));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setViewPager(this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager);
    this.jdField_a_of_type_ComTencentMobileqqArkArkPanelPagerAdapter = new ArkPanelPagerAdapter(BaseApplicationImpl.getContext());
    this.jdField_a_of_type_ComTencentMobileqqArkArkPanelPagerAdapter.w(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqArkArkPanelPagerAdapter);
    setPagerChangedListener(this);
    this.ir = ((LinearLayout)findViewById(2131370787));
    this.is = ((LinearLayout)findViewById(2131377028));
    this.is.setOnClickListener(this);
    Lr(0);
    paramBaseChatPie = getResources().getDrawable(2130851275);
    if ((paramBaseChatPie instanceof BitmapDrawable)) {
      paramBaseChatPie = ((BitmapDrawable)paramBaseChatPie).getBitmap();
    }
    for (;;)
    {
      paramBaseChatPie = new BitmapDrawable(paramBaseChatPie);
      if (paramBaseChatPie != null)
      {
        paramBaseChatPie.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        paramBaseChatPie.setDither(true);
        setBackgroundDrawable(paramBaseChatPie);
      }
      for (;;)
      {
        adrj.a(this);
        return;
        if (!(paramBaseChatPie instanceof SkinnableBitmapDrawable)) {
          break label220;
        }
        paramBaseChatPie = ((SkinnableBitmapDrawable)paramBaseChatPie).getBitmap();
        break;
        if (QLog.isColorLevel()) {
          QLog.d("ArkAppManagerPanel", 2, "ArkAppManagerPanel background is null:");
        }
      }
      label220:
      paramBaseChatPie = null;
    }
  }
  
  public void ch(ArrayList<a> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() <= 0))
    {
      Lr(2);
      return;
    }
    int j = paramArrayList.size() - 7;
    if (j > 0)
    {
      int i = 0;
      while (i < j)
      {
        paramArrayList.remove(paramArrayList.size() - 1);
        i += 1;
      }
    }
    a locala = new a();
    locala.bQv = true;
    locala.bvh = null;
    locala.arkAppName = getResources().getString(2131695245);
    paramArrayList.add(locala);
    ArkAppCenter.a().postToMainThread(new ArkAppManagerPanel.2(this, paramArrayList));
  }
  
  public void dV(ArrayList<a> paramArrayList)
  {
    this.jdField_a_of_type_ComTencentMobileqqArkArkPanelPagerAdapter.dW(paramArrayList);
    Lr(1);
    if (this.jdField_a_of_type_ComTencentMobileqqArkArkPanelPagerAdapter.getCount() > 1) {}
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.MF(this.jdField_a_of_type_ComTencentMobileqqArkArkPanelPagerAdapter.getCount());
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqArkArkPanelPagerAdapter.notifyDataSetChanged();
        post(new ArkAppManagerPanel.1(this));
        return;
      }
      catch (Exception paramArrayList)
      {
        QLog.d("ArkAppManagerPanel", 2, "exception=" + paramArrayList);
        continue;
      }
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setVisibility(4);
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    if (this.mState == 1)
    {
      localObject = (ArkPanelPagerAdapter.a)paramView.getTag();
      if (!TextUtils.isEmpty(((ArkPanelPagerAdapter.a)localObject).appId))
      {
        String str = "mqqapi://lightapp/open?app=" + ((ArkPanelPagerAdapter.a)localObject).appId;
        aqik.c(this.app, getContext(), str).ace();
        ((adqx)this.app.getBusinessHandler(95)).lg(((ArkPanelPagerAdapter.a)localObject).appId);
        adqu.a(this.app, ((ArkPanelPagerAdapter.a)localObject).appId, "ArkPanelAppIconClick", 1, 0, 0L, 0L, 0L, null, null);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localObject = new Intent(getContext(), QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", "https://ti.qq.com/ark/aioplus/index.html");
      getContext().startActivity((Intent)localObject);
      adqu.a(this.app, "com.tencent.ark.panel.more", "ArkPanelMoreIconClick", 1, 0, 0L, 0L, 0L, null, null);
      continue;
      if (this.mState == 2)
      {
        Lr(0);
        adrj.a(this);
      }
    }
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt) {}
  
  public void setPagerChangedListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setPagerChangedListener(paramOnPageChangeListener);
  }
  
  public static class a
  {
    public String arkAppName;
    public boolean bQv;
    public boolean beg;
    public String bvh;
    public String bvi;
    
    public a() {}
    
    public a(String paramString1, String paramString2, String paramString3)
    {
      this.bvh = paramString1;
      this.arkAppName = paramString2;
      this.bvi = paramString3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAppManagerPanel
 * JD-Core Version:    0.7.0.1
 */