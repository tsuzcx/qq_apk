import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;

class tkw
  implements slx<tal, tam>
{
  tkw(tkv paramtkv, tjy paramtjy) {}
  
  public void a(@NonNull tal paramtal, @Nullable tam paramtam, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isFail()) || (paramtam == null))
    {
      urk.a("Q.qqstory.player.data.TroopAssistantHomeFeedPlayPageLoader", "pull feedId list fail %s", paramErrorMessage.toString());
      this.jdField_a_of_type_Tjy.a(paramErrorMessage, null, false);
      return;
    }
    this.jdField_a_of_type_Tkv.a.a(paramtam.jdField_a_of_type_JavaUtilList, paramtam.jdField_a_of_type_JavaLangString, paramtam.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_Tjy.a(paramErrorMessage, tjg.b(paramtam.jdField_a_of_type_JavaUtilList), paramtam.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tkw
 * JD-Core Version:    0.7.0.1
 */