import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;

class vmh
  implements uni<vbw, vbx>
{
  vmh(vmg paramvmg, vlj paramvlj) {}
  
  public void a(@NonNull vbw paramvbw, @Nullable vbx paramvbx, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isFail()) || (paramvbx == null))
    {
      wsv.a("Q.qqstory.player.data.TroopAssistantHomeFeedPlayPageLoader", "pull feedId list fail %s", paramErrorMessage.toString());
      this.jdField_a_of_type_Vlj.a(paramErrorMessage, null, false);
      return;
    }
    this.jdField_a_of_type_Vmg.a.a(paramvbx.jdField_a_of_type_JavaUtilList, paramvbx.jdField_a_of_type_JavaLangString, paramvbx.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_Vlj.a(paramErrorMessage, vkr.b(paramvbx.jdField_a_of_type_JavaUtilList), paramvbx.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vmh
 * JD-Core Version:    0.7.0.1
 */