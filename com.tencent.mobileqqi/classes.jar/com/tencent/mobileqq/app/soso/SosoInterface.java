package com.tencent.mobileqq.app.soso;

import android.content.Context;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.map.lbsapi.api.SOSOMapLBSApi;
import fpf;
import java.util.ArrayList;

public class SosoInterface
{
  private static SosoInterface jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface;
  private static final String jdField_a_of_type_JavaLangString = "SosoInterface";
  private static final String jdField_b_of_type_JavaLangString = "QQ2013";
  private static final String c = "LWPAH-5CHEJ-Y6CR2-AQPLX-IV2JQ";
  private PhoneStateListener jdField_a_of_type_AndroidTelephonyPhoneStateListener;
  private SosoInterface.LocListener jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$LocListener;
  private final ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private final ArrayList jdField_b_of_type_JavaUtilArrayList;
  
  private SosoInterface()
  {
    this.b = new ArrayList();
    SOSOMapLBSApi.getInstance().verifyRegCode("QQ2013", "LWPAH-5CHEJ-Y6CR2-AQPLX-IV2JQ");
    this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$LocListener = new SosoInterface.LocListener(this, 0, 1, 0, 8);
  }
  
  public static SosoInterface a()
  {
    if (jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface == null) {
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface = new SosoInterface();
    }
    return jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface;
  }
  
  private void a()
  {
    this.b.clear();
    ((TelephonyManager)BaseApplicationImpl.getContext().getSystemService("phone")).listen(this.jdField_a_of_type_AndroidTelephonyPhoneStateListener, 0);
    this.jdField_a_of_type_AndroidTelephonyPhoneStateListener = null;
  }
  
  public void a(SosoInterface.OnCellsListener paramOnCellsListener)
  {
    if (paramOnCellsListener == null) {
      return;
    }
    for (;;)
    {
      synchronized (this.b)
      {
        if (this.b.isEmpty())
        {
          this.b.add(paramOnCellsListener);
          this.jdField_a_of_type_AndroidTelephonyPhoneStateListener = new fpf(this, null);
          ((TelephonyManager)BaseApplicationImpl.getContext().getSystemService("phone")).listen(this.jdField_a_of_type_AndroidTelephonyPhoneStateListener, 18);
          return;
        }
      }
      this.b.add(paramOnCellsListener);
    }
  }
  
  public void a(SosoInterface.OnLocationListener paramOnLocationListener)
  {
    if (paramOnLocationListener == null) {
      return;
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        if (this.jdField_a_of_type_JavaUtilArrayList.isEmpty())
        {
          this.jdField_a_of_type_JavaUtilArrayList.add(paramOnLocationListener);
          SOSOMapLBSApi.getInstance().requestLocationUpdate(BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$LocListener);
          return;
        }
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(paramOnLocationListener);
    }
  }
  
  public void b(SosoInterface.OnCellsListener paramOnCellsListener)
  {
    if (paramOnCellsListener == null) {
      return;
    }
    synchronized (this.b)
    {
      this.b.remove(paramOnCellsListener);
      if (this.b.isEmpty()) {
        a();
      }
      return;
    }
  }
  
  public void b(SosoInterface.OnLocationListener paramOnLocationListener)
  {
    if (paramOnLocationListener == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      this.jdField_a_of_type_JavaUtilArrayList.remove(paramOnLocationListener);
      if (this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
        SOSOMapLBSApi.getInstance().removeLocationUpdate();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.soso.SosoInterface
 * JD-Core Version:    0.7.0.1
 */