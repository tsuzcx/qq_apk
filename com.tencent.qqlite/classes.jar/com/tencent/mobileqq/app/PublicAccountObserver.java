package com.tencent.mobileqq.app;

import com.tencent.mobileqq.data.PublicAccountInfo;
import cvv;
import cvw;

public class PublicAccountObserver
  implements BusinessObserver
{
  public static final int a = 100;
  public static final int b = 101;
  public static final int c = 102;
  public static final int d = 103;
  public static final int e = 104;
  
  public void a() {}
  
  public void a(int paramInt, PublicAccountInfo paramPublicAccountInfo) {}
  
  public void a(int paramInt, boolean paramBoolean) {}
  
  public void a(boolean paramBoolean) {}
  
  public void b(int paramInt, PublicAccountInfo paramPublicAccountInfo) {}
  
  public final void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (100 == paramInt)
    {
      paramObject = (cvw)paramObject;
      a(paramObject.jdField_a_of_type_Int, paramObject.jdField_a_of_type_Boolean);
    }
    do
    {
      return;
      if (101 == paramInt)
      {
        paramObject = (cvv)paramObject;
        a(paramObject.jdField_a_of_type_Int, paramObject.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo);
        return;
      }
      if (102 == paramInt)
      {
        paramObject = (cvv)paramObject;
        b(paramObject.jdField_a_of_type_Int, paramObject.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo);
        return;
      }
      if (103 == paramInt)
      {
        a();
        return;
      }
    } while (104 != paramInt);
    a(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.PublicAccountObserver
 * JD-Core Version:    0.7.0.1
 */