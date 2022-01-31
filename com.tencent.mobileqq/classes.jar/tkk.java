import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;

class tkk
  implements slx<szx, szy>
{
  tkk(tkj paramtkj, tjy paramtjy) {}
  
  public void a(@NonNull szx paramszx, @Nullable szy paramszy, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isFail()) || (paramszy == null))
    {
      urk.a("Q.qqstory.player.data.TroopAssistantHomeFeedPlayPageLoader", "pull feedId list fail %s", paramErrorMessage.toString());
      this.jdField_a_of_type_Tjy.a(paramErrorMessage, null, false);
      return;
    }
    this.jdField_a_of_type_Tkj.a.a(paramszy.jdField_a_of_type_JavaUtilList, paramszy.jdField_a_of_type_JavaLangString, paramszy.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_Tjy.a(paramErrorMessage, tjg.b(paramszy.jdField_a_of_type_JavaUtilList), paramszy.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tkk
 * JD-Core Version:    0.7.0.1
 */