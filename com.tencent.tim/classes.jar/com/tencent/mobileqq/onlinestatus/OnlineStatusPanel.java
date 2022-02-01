package com.tencent.mobileqq.onlinestatus;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emoticonview.EmoticonPagerRadioGroup;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import wja;

public class OnlineStatusPanel
  extends LinearLayout
{
  EmoticonPagerRadioGroup a;
  public OnlineStatusPagerAdapter a;
  public QQViewPager a;
  
  public OnlineStatusPanel(Context paramContext)
  {
    super(paramContext);
  }
  
  public OnlineStatusPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public OnlineStatusPanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void dDu()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.getCount() > 1) {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.MF(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.getCount());
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setVisibility(0);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("OnlineStatusPanel", 1, "e=" + localException);
        }
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setVisibility(8);
  }
  
  private int iw(int paramInt)
  {
    return wja.dp2px(32.0F, getResources()) * paramInt + wja.dp2px(20.0F, getResources()) * (paramInt - 1) + wja.dp2px(16.0F, getResources());
  }
  
  public void dDt()
  {
    ThreadManager.getFileThreadHandler().post(new OnlineStatusPanel.1(this));
  }
  
  public void init(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter = new OnlineStatusPagerAdapter(BaseApplicationImpl.getContext(), paramInt);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager = ((QQViewPager)findViewById(2131372643));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup = ((EmoticonPagerRadioGroup)findViewById(2131368721));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setViewPager(this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.getLayoutParams();
    localLayoutParams.height = iw(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setLayoutParams(localLayoutParams);
    dDt();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnlineStatusPanel
 * JD-Core Version:    0.7.0.1
 */