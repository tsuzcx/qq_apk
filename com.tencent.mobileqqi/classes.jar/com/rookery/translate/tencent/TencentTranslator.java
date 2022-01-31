package com.rookery.translate.tencent;

import android.content.Context;
import bfz;
import com.rookery.translate.Translator;
import com.rookery.translate.type.Language;
import com.rookery.translate.type.TranslateWithTimeCallback;
import com.tencent.mobileqq.app.I18nTranslatorHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.List;

public class TencentTranslator
  extends Translator
{
  private static TencentTranslator jdField_a_of_type_ComRookeryTranslateTencentTencentTranslator;
  private I18nTranslatorHandler jdField_a_of_type_ComTencentMobileqqAppI18nTranslatorHandler;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  private TencentTranslator(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppI18nTranslatorHandler = ((I18nTranslatorHandler)paramQQAppInterface.a(36));
  }
  
  public static TencentTranslator a(QQAppInterface paramQQAppInterface)
  {
    try
    {
      if (jdField_a_of_type_ComRookeryTranslateTencentTencentTranslator == null) {
        jdField_a_of_type_ComRookeryTranslateTencentTencentTranslator = new TencentTranslator(paramQQAppInterface);
      }
      return jdField_a_of_type_ComRookeryTranslateTencentTencentTranslator;
    }
    finally {}
  }
  
  public void a()
  {
    jdField_a_of_type_ComRookeryTranslateTencentTencentTranslator = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_ComTencentMobileqqAppI18nTranslatorHandler = null;
  }
  
  public void a(Context paramContext, List paramList, Language paramLanguage, String paramString, Long paramLong, TranslateWithTimeCallback paramTranslateWithTimeCallback)
  {
    if (paramLanguage == null) {
      Language.CHINESE_SIMPLIFIED.toString();
    }
    for (;;)
    {
      paramContext = new bfz(this, paramLong, paramTranslateWithTimeCallback);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramContext);
      this.jdField_a_of_type_ComTencentMobileqqAppI18nTranslatorHandler.a(paramLanguage.toString(), paramLong, paramList, true);
      return;
      paramContext = paramLanguage.toString();
      if ((paramContext == null) || (paramContext.length() == 0)) {
        Language.CHINESE_SIMPLIFIED.toString();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.rookery.translate.tencent.TencentTranslator
 * JD-Core Version:    0.7.0.1
 */