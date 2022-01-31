import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;

class txg
  implements syt<tmt, tmu>
{
  txg(txf paramtxf, twu paramtwu) {}
  
  public void a(@NonNull tmt paramtmt, @Nullable tmu paramtmu, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isFail()) || (paramtmu == null))
    {
      veg.a("Q.qqstory.player.data.TroopAssistantHomeFeedPlayPageLoader", "pull feedId list fail %s", paramErrorMessage.toString());
      this.jdField_a_of_type_Twu.a(paramErrorMessage, null, false);
      return;
    }
    this.jdField_a_of_type_Txf.a.a(paramtmu.jdField_a_of_type_JavaUtilList, paramtmu.jdField_a_of_type_JavaLangString, paramtmu.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_Twu.a(paramErrorMessage, twc.b(paramtmu.jdField_a_of_type_JavaUtilList), paramtmu.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     txg
 * JD-Core Version:    0.7.0.1
 */