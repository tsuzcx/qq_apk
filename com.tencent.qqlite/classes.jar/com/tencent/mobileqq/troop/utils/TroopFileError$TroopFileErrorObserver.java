package com.tencent.mobileqq.troop.utils;

import android.content.Context;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import java.lang.ref.WeakReference;

public class TroopFileError$TroopFileErrorObserver
  extends BizTroopObserver
{
  public int a;
  private long jdField_a_of_type_Long;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TroopFileError.TroopFileErrorFilter jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorFilter;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  
  public TroopFileError$TroopFileErrorObserver(Context paramContext, long paramLong, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Int = 0;
  }
  
  public TroopFileError$TroopFileErrorObserver(Context paramContext, TroopFileError.TroopFileErrorFilter paramTroopFileErrorFilter, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorFilter = paramTroopFileErrorFilter;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Int = 0;
  }
  
  protected void b(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof TroopFileError.SimpleErrorInfo))) {}
    label81:
    for (;;)
    {
      return;
      paramObject = (TroopFileError.SimpleErrorInfo)paramObject;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorFilter != null) {}
      for (long l = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorFilter.a();; l = this.jdField_a_of_type_Long)
      {
        if (paramObject.jdField_a_of_type_Long != l) {
          break label81;
        }
        Context localContext = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (localContext == null) {
          break;
        }
        TroopFileError.a(paramObject, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localContext);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileError.TroopFileErrorObserver
 * JD-Core Version:    0.7.0.1
 */