import android.content.Context;
import com.rookery.translate.AITranslator;
import com.rookery.translate.type.Language;
import com.rookery.translate.type.TranslateCallback;
import com.rookery.translate.type.TranslateError;
import com.rookery.translate.type.TranslateWithTimeCallback;
import com.tencent.mobileqq.activity.aio.item.TextTranslationItemBuilder.Holder;
import java.util.List;

public class bgd
  implements TranslateWithTimeCallback
{
  public bgd(AITranslator paramAITranslator, String paramString1, long paramLong, Context paramContext, TextTranslationItemBuilder.Holder paramHolder, String paramString2, Language paramLanguage, TranslateCallback paramTranslateCallback, List paramList1, List paramList2, int paramInt) {}
  
  public void a(TranslateError paramTranslateError, Long paramLong)
  {
    AITranslator.a(this.jdField_a_of_type_ComRookeryTranslateAITranslator).remove(this.jdField_a_of_type_JavaLangString);
    AITranslator.a(this.jdField_a_of_type_ComRookeryTranslateAITranslator, this.jdField_a_of_type_Long, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextTranslationItemBuilder$Holder, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_JavaUtilList, this.jdField_a_of_type_ComRookeryTranslateTypeLanguage, this.jdField_a_of_type_ComRookeryTranslateTypeTranslateCallback, this.jdField_a_of_type_Int, paramTranslateError, paramLong);
  }
  
  public void a(List paramList1, List paramList2, Long paramLong)
  {
    AITranslator.a(this.jdField_a_of_type_ComRookeryTranslateAITranslator).remove(this.jdField_a_of_type_JavaLangString);
    AITranslator.a(this.jdField_a_of_type_ComRookeryTranslateAITranslator, this.jdField_a_of_type_Long, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextTranslationItemBuilder$Holder, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComRookeryTranslateTypeLanguage, this.jdField_a_of_type_ComRookeryTranslateTypeTranslateCallback, 0, paramList1, paramList2, this.jdField_a_of_type_JavaUtilList, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     bgd
 * JD-Core Version:    0.7.0.1
 */