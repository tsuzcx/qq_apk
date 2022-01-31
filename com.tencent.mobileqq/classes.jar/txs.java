import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;

class txs
  implements syt<tnh, tni>
{
  txs(txr paramtxr, twu paramtwu) {}
  
  public void a(@NonNull tnh paramtnh, @Nullable tni paramtni, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isFail()) || (paramtni == null))
    {
      veg.a("Q.qqstory.player.data.TroopAssistantHomeFeedPlayPageLoader", "pull feedId list fail %s", paramErrorMessage.toString());
      this.jdField_a_of_type_Twu.a(paramErrorMessage, null, false);
      return;
    }
    this.jdField_a_of_type_Txr.a.a(paramtni.jdField_a_of_type_JavaUtilList, paramtni.jdField_a_of_type_JavaLangString, paramtni.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_Twu.a(paramErrorMessage, twc.b(paramtni.jdField_a_of_type_JavaUtilList), paramtni.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     txs
 * JD-Core Version:    0.7.0.1
 */