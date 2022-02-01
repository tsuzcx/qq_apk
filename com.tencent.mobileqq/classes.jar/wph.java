import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;

class wph
  implements vqp<wfc, wfd>
{
  wph(wpg paramwpg, woj paramwoj) {}
  
  public void a(@NonNull wfc paramwfc, @Nullable wfd paramwfd, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isFail()) || (paramwfd == null))
    {
      xvv.a("Q.qqstory.player.data.TroopAssistantHomeFeedPlayPageLoader", "pull feedId list fail %s", paramErrorMessage.toString());
      this.jdField_a_of_type_Woj.a(paramErrorMessage, null, false);
      return;
    }
    this.jdField_a_of_type_Wpg.a.a(paramwfd.jdField_a_of_type_JavaUtilList, paramwfd.jdField_a_of_type_JavaLangString, paramwfd.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_Woj.a(paramErrorMessage, wnr.b(paramwfd.jdField_a_of_type_JavaUtilList), paramwfd.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wph
 * JD-Core Version:    0.7.0.1
 */