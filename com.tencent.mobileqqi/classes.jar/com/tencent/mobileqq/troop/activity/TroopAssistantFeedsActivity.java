package com.tencent.mobileqq.troop.activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.troop.logic.VideoPlayLogic;
import java.util.concurrent.atomic.AtomicBoolean;

public class TroopAssistantFeedsActivity
  extends QQBrowserActivity
{
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout = null;
  private TroopMemberApiClient jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = null;
  private VideoPlayLogic jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic = null;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  
  protected boolean b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic.a();
    }
    return super.b();
  }
  
  public void c(String paramString1, String paramString2, String paramString3)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic == null)
    {
      SessionInfo localSessionInfo = new SessionInfo();
      localSessionInfo.a = paramString2;
      this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic = new VideoPlayLogic(this, this, localSessionInfo, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient, paramString3);
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic.a(paramString1, null, this.jdField_a_of_type_AndroidWidgetRelativeLayout);
  }
  
  public void doOnBackPressed()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic.b()))
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic.a();
      return;
    }
    super.doOnBackPressed();
  }
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    super.doOnConfigurationChanged(paramConfiguration);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic.a(paramConfiguration);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    getWindow().setFormat(-3);
    super.doOnCreate(paramBundle);
    paramBundle = (FrameLayout)findViewById(2131231179);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    paramBundle.addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    e();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic.j();
        this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic = null;
      }
      try
      {
        label23:
        if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
          this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b();
        }
        return;
      }
      catch (Exception localException1) {}
    }
    catch (Exception localException2)
    {
      break label23;
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic.a();
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic.b();
    }
  }
  
  void e()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))
    {
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = TroopMemberApiClient.a();
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopAssistantFeedsActivity
 * JD-Core Version:    0.7.0.1
 */