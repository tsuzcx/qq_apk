package com.tencent.mobileqq.activity.richmedia;

import aara;
import aarb;
import aasr;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.qphone.base.util.QLog;

public class NewFlowCameraActivity$21$1$1
  implements Runnable
{
  public NewFlowCameraActivity$21$1$1(aara paramaara) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PTV.NewFlowCameraActivity", 2, "onResourceDownload update filterpager begin");
    }
    NewFlowCameraActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity$21.this$0, (VideoFilterViewPager)this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity$21.this$0.$(2131367272));
    this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity$21.this$0.a = new aarb(this);
    NewFlowCameraActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity$21.this$0).setViewPagerItemVisiableChangeListener(this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity$21.this$0.a);
    NewFlowCameraActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity$21.this$0).bD(this.a.jdField_a_of_type_Aasr.dw());
    FilterDesc localFilterDesc = NewFlowCameraActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity$21.this$0).a(NewFlowCameraActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity$21.this$0).getCurrentItem());
    this.a.jdField_a_of_type_Aasr.setCurrentId(localFilterDesc);
    if (QLog.isColorLevel()) {
      QLog.d("PTV.NewFlowCameraActivity", 2, "onResourceDownload update filterpager end");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity.21.1.1
 * JD-Core Version:    0.7.0.1
 */