import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;

class txp
  implements syq<tne, tnf>
{
  txp(txo paramtxo, twr paramtwr) {}
  
  public void a(@NonNull tne paramtne, @Nullable tnf paramtnf, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isFail()) || (paramtnf == null))
    {
      ved.a("Q.qqstory.player.data.TroopAssistantHomeFeedPlayPageLoader", "pull feedId list fail %s", paramErrorMessage.toString());
      this.jdField_a_of_type_Twr.a(paramErrorMessage, null, false);
      return;
    }
    this.jdField_a_of_type_Txo.a.a(paramtnf.jdField_a_of_type_JavaUtilList, paramtnf.jdField_a_of_type_JavaLangString, paramtnf.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_Twr.a(paramErrorMessage, tvz.b(paramtnf.jdField_a_of_type_JavaUtilList), paramtnf.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     txp
 * JD-Core Version:    0.7.0.1
 */