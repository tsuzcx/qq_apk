package com.tencent.mobileqq.olympic;

import akrf;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.mobileqq.ocr.activity.ScanBaseActivity;
import com.tencent.mobileqq.olympic.activity.OlympicToolBaseActivity;

public class ScannerResultReceiver
  extends ResultReceiver
{
  private ScanBaseActivity jdField_a_of_type_ComTencentMobileqqOcrActivityScanBaseActivity;
  private OlympicToolBaseActivity jdField_a_of_type_ComTencentMobileqqOlympicActivityOlympicToolBaseActivity;
  
  public ScannerResultReceiver(Handler paramHandler)
  {
    super(paramHandler);
  }
  
  public void a(ScanBaseActivity paramScanBaseActivity)
  {
    akrf.log("ScannerResultReceiver", new Object[] { "setActivity activity:", paramScanBaseActivity, this });
    this.jdField_a_of_type_ComTencentMobileqqOcrActivityScanBaseActivity = paramScanBaseActivity;
  }
  
  public void a(OlympicToolBaseActivity paramOlympicToolBaseActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqOlympicActivityOlympicToolBaseActivity = paramOlympicToolBaseActivity;
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    akrf.log("ScannerResultReceiver", new Object[] { "mResultReceiver.onReceiveResult, resultCode=", Integer.valueOf(paramInt), this });
    if (paramInt == 0)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqOcrActivityScanBaseActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqOcrActivityScanBaseActivity.ctg)) {
        this.jdField_a_of_type_ComTencentMobileqqOcrActivityScanBaseActivity.dCl();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqOlympicActivityOlympicToolBaseActivity != null) {
        this.jdField_a_of_type_ComTencentMobileqqOlympicActivityOlympicToolBaseActivity.dCl();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.ScannerResultReceiver
 * JD-Core Version:    0.7.0.1
 */