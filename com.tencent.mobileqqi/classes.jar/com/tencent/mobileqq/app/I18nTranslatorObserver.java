package com.tencent.mobileqq.app;

import com.rookery.translate.tencent.TranslateRespWrapper;
import com.rookery.translate.tencent.TranslateRespWrapperFYJ;
import com.tencent.i18n.translate.util.Translate.TranslateResp;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.List;

public class I18nTranslatorObserver
  implements BusinessObserver
{
  protected void a(int paramInt, boolean paramBoolean, Long paramLong, List paramList) {}
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    boolean bool2 = false;
    switch (paramInt)
    {
    default: 
      return;
    case 80001: 
      paramObject = (TranslateRespWrapper)paramObject;
      if (paramObject.jdField_a_of_type_ComTencentI18nTranslateUtilTranslate$TranslateResp == null)
      {
        a(paramInt, false, paramObject.jdField_a_of_type_JavaLangLong, null);
        return;
      }
      boolean bool1 = bool2;
      if (paramBoolean)
      {
        bool1 = bool2;
        if (paramObject.jdField_a_of_type_ComTencentI18nTranslateUtilTranslate$TranslateResp.result_code.get() == 0) {
          bool1 = true;
        }
      }
      a(paramInt, bool1, paramObject.jdField_a_of_type_JavaLangLong, paramObject.jdField_a_of_type_ComTencentI18nTranslateUtilTranslate$TranslateResp.translated_array_text.get());
      return;
    }
    paramObject = (TranslateRespWrapperFYJ)paramObject;
    if (paramObject.jdField_a_of_type_JavaUtilList == null)
    {
      a(paramInt, false, paramObject.jdField_a_of_type_JavaLangLong, null);
      return;
    }
    a(paramInt, paramBoolean, paramObject.jdField_a_of_type_JavaLangLong, paramObject.jdField_a_of_type_JavaUtilList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.I18nTranslatorObserver
 * JD-Core Version:    0.7.0.1
 */