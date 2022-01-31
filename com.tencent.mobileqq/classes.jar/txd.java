import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;

class txd
  implements syq<tmq, tmr>
{
  txd(txc paramtxc, twr paramtwr) {}
  
  public void a(@NonNull tmq paramtmq, @Nullable tmr paramtmr, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isFail()) || (paramtmr == null))
    {
      ved.a("Q.qqstory.player.data.TroopAssistantHomeFeedPlayPageLoader", "pull feedId list fail %s", paramErrorMessage.toString());
      this.jdField_a_of_type_Twr.a(paramErrorMessage, null, false);
      return;
    }
    this.jdField_a_of_type_Txc.a.a(paramtmr.jdField_a_of_type_JavaUtilList, paramtmr.jdField_a_of_type_JavaLangString, paramtmr.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_Twr.a(paramErrorMessage, tvz.b(paramtmr.jdField_a_of_type_JavaUtilList), paramtmr.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     txd
 * JD-Core Version:    0.7.0.1
 */