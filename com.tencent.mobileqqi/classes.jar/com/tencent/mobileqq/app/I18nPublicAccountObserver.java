package com.tencent.mobileqq.app;

import fhj;
import fhk;
import java.util.List;

public class I18nPublicAccountObserver
  implements BusinessObserver
{
  protected void a(int paramInt, String paramString, boolean paramBoolean) {}
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    boolean bool2 = false;
    switch (paramInt)
    {
    default: 
      return;
    case 90001: 
      if (paramObject == null)
      {
        a(paramInt, false, null);
        return;
      }
      paramObject = (fhj)paramObject;
      boolean bool1 = bool2;
      if (paramBoolean)
      {
        bool1 = bool2;
        if (paramObject.jdField_a_of_type_Int == 0) {
          bool1 = true;
        }
      }
      a(paramInt, bool1, paramObject.jdField_a_of_type_JavaUtilList);
      return;
    }
    paramObject = (fhk)paramObject;
    a(paramObject.jdField_a_of_type_Int, paramObject.jdField_a_of_type_JavaLangString, paramObject.jdField_a_of_type_Boolean);
  }
  
  protected void a(int paramInt, boolean paramBoolean, List paramList) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.I18nPublicAccountObserver
 * JD-Core Version:    0.7.0.1
 */