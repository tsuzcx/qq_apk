package com.tencent.mobileqq.app;

import com.tencent.mobileqq.activity.NearbyActivity;

public abstract class NearbyFrame
  extends Frame
{
  public static final int x = 0;
  public static final int y = 1;
  public static final int z = 2;
  protected NearbyActivity a;
  private NearbyFrame.OnNearbyCallBack jdField_a_of_type_ComTencentMobileqqAppNearbyFrame$OnNearbyCallBack;
  private boolean jdField_a_of_type_Boolean = false;
  public boolean c = false;
  public boolean e = false;
  
  public void a()
  {
    super.a();
    if ((a() instanceof NearbyActivity))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity = ((NearbyActivity)a());
      this.jdField_a_of_type_ComTencentMobileqqAppNearbyFrame$OnNearbyCallBack = this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity;
    }
    o();
  }
  
  protected void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppNearbyFrame$OnNearbyCallBack.a(paramInt1, paramInt2, paramBoolean);
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      n();
      return;
    }
    o();
  }
  
  public void e()
  {
    super.e();
  }
  
  protected void n()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqAppNearbyFrame$OnNearbyCallBack.a(0);
  }
  
  protected void o()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppNearbyFrame$OnNearbyCallBack.a(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.NearbyFrame
 * JD-Core Version:    0.7.0.1
 */