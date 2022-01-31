import com.rookery.translate.tencent.TencentTranslator;
import com.rookery.translate.type.Language;
import com.rookery.translate.type.TranslateError;
import com.rookery.translate.type.TranslateWithTimeCallback;
import com.tencent.mobileqq.app.I18nTranslatorObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class bgh
  extends I18nTranslatorObserver
{
  public bgh(TencentTranslator paramTencentTranslator, Long paramLong, TranslateWithTimeCallback paramTranslateWithTimeCallback) {}
  
  protected void a(int paramInt, boolean paramBoolean, Long paramLong, List paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Translator", 2, "startTime:" + paramLong + " request_time:" + this.jdField_a_of_type_JavaLangLong);
    }
    if (!paramLong.equals(this.jdField_a_of_type_JavaLangLong)) {}
    for (;;)
    {
      return;
      if (!paramBoolean)
      {
        this.jdField_a_of_type_ComRookeryTranslateTypeTranslateWithTimeCallback.a(new TranslateError("error"), this.jdField_a_of_type_JavaLangLong);
        if (QLog.isColorLevel()) {
          QLog.e("Translator", 2, " [onFailure][TencentTranslateClient] Throwable:error");
        }
      }
      while (TencentTranslator.a(this.jdField_a_of_type_ComRookeryTranslateTencentTencentTranslator) != null)
      {
        TencentTranslator.a(this.jdField_a_of_type_ComRookeryTranslateTencentTencentTranslator).c(this);
        return;
        paramLong = new ArrayList();
        paramLong.add(Language.AUTO_DETECT);
        this.jdField_a_of_type_ComRookeryTranslateTypeTranslateWithTimeCallback.a(paramLong, paramList, this.jdField_a_of_type_JavaLangLong);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     bgh
 * JD-Core Version:    0.7.0.1
 */