import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;

class vlv
  implements uni<vbi, vbj>
{
  vlv(vlu paramvlu, vlj paramvlj) {}
  
  public void a(@NonNull vbi paramvbi, @Nullable vbj paramvbj, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isFail()) || (paramvbj == null))
    {
      wsv.a("Q.qqstory.player.data.TroopAssistantHomeFeedPlayPageLoader", "pull feedId list fail %s", paramErrorMessage.toString());
      this.jdField_a_of_type_Vlj.a(paramErrorMessage, null, false);
      return;
    }
    this.jdField_a_of_type_Vlu.a.a(paramvbj.jdField_a_of_type_JavaUtilList, paramvbj.jdField_a_of_type_JavaLangString, paramvbj.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_Vlj.a(paramErrorMessage, vkr.b(paramvbj.jdField_a_of_type_JavaUtilList), paramvbj.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vlv
 * JD-Core Version:    0.7.0.1
 */