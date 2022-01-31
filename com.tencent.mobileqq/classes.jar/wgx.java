import com.tencent.mobileqq.activity.chathistory.TroopMemberHistoryFragment;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import java.util.Calendar;

public class wgx
{
  long jdField_a_of_type_Long;
  MessageRecord jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  CharSequence jdField_a_of_type_JavaLangCharSequence;
  String jdField_a_of_type_JavaLangString;
  long jdField_b_of_type_Long;
  CharSequence jdField_b_of_type_JavaLangCharSequence;
  
  public wgx(TroopMemberHistoryFragment paramTroopMemberHistoryFragment, String paramString, long paramLong1, CharSequence paramCharSequence, long paramLong2, MessageRecord paramMessageRecord)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
    this.jdField_b_of_type_Long = paramLong2;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
  }
  
  public CharSequence a()
  {
    if (this.jdField_b_of_type_JavaLangCharSequence == null)
    {
      Calendar.getInstance().setTimeInMillis(this.jdField_a_of_type_Long * 1000L);
      this.jdField_b_of_type_JavaLangCharSequence = TimeFormatterUtils.a(this.jdField_a_of_type_Long * 1000L, true, "yyyy-MM-dd");
    }
    return this.jdField_b_of_type_JavaLangCharSequence;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wgx
 * JD-Core Version:    0.7.0.1
 */