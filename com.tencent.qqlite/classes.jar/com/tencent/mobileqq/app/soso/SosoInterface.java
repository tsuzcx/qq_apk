package com.tencent.mobileqq.app.soso;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.map.lbsapi.api.SOSOMapLBSApi;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class SosoInterface
{
  private static SosoInterface jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface;
  private static final String jdField_a_of_type_JavaLangString = "SosoInterface";
  private static final String b = "QQ2013";
  private static final String c = "LWPAH-5CHEJ-Y6CR2-AQPLX-IV2JQ";
  private SosoInterface.LocListener jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$LocListener;
  private final ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  
  private SosoInterface()
  {
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
  
  public void a(SosoInterface.OnLocationListener paramOnLocationListener)
  {
    a(paramOnLocationListener, true);
  }
  
  public void a(SosoInterface.OnLocationListener paramOnLocationListener, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LBS", 2, "startLocation");
    }
    if (paramOnLocationListener == null) {
      return;
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        if (this.jdField_a_of_type_JavaUtilArrayList.isEmpty())
        {
          this.jdField_a_of_type_Boolean = paramBoolean;
          this.jdField_a_of_type_JavaUtilArrayList.add(paramOnLocationListener);
          SOSOMapLBSApi.getInstance().requestLocationUpdate(BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$LocListener, paramBoolean);
          return;
        }
      }
      if ((paramBoolean) && (!this.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_Boolean = paramBoolean;
        SOSOMapLBSApi.getInstance().removeLocationUpdate();
        SOSOMapLBSApi.getInstance().requestLocationUpdate(BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$LocListener, paramBoolean);
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(paramOnLocationListener);
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
      if (this.jdField_a_of_type_JavaUtilArrayList.isEmpty())
      {
        this.jdField_a_of_type_Boolean = false;
        SOSOMapLBSApi.getInstance().removeLocationUpdate();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.soso.SosoInterface
 * JD-Core Version:    0.7.0.1
 */