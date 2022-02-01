package com.tencent.mobileqq.hotpic;

import ahzd;
import aiaa;
import android.annotation.TargetApi;
import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.XPanelContainer;

@TargetApi(15)
public class PublicAccountHotPicPanel
  extends HotPicMainPanel
{
  aiaa a;
  
  public PublicAccountHotPicPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  @TargetApi(14)
  public void a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, PanelIconLinearLayout paramPanelIconLinearLayout, XPanelContainer paramXPanelContainer)
  {
    this.mApp = paramQQAppInterface;
    this.mContext = paramBaseActivity;
    this.mActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout = paramPanelIconLinearLayout;
    this.f = paramXPanelContainer;
    this.mSessionInfo = new SessionInfo();
    this.mLoadingView = findViewById(2131370787);
    this.DD = findViewById(2131368657);
    this.DC = LayoutInflater.from(this.mContext).inflate(2131558659, null);
    this.DC.setVisibility(8);
    this.mViewPager = ((ViewPager)findViewById(2131368663));
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTab = ((HotPicTab)findViewById(2131368644));
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTab.setOnItemClickListener(this);
    this.mSessionInfo.cZ = 1008;
  }
  
  public void cZu() {}
  
  public void cZv() {}
  
  public void setPublicAccountGifListener(aiaa paramaiaa)
  {
    this.jdField_a_of_type_Aiaa = paramaiaa;
    ahzd.a(this.mApp).setPublicAccountGifListener(paramaiaa);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.PublicAccountHotPicPanel
 * JD-Core Version:    0.7.0.1
 */