import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;

class wov
  implements vqp<weo, wep>
{
  wov(wou paramwou, woj paramwoj) {}
  
  public void a(@NonNull weo paramweo, @Nullable wep paramwep, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isFail()) || (paramwep == null))
    {
      xvv.a("Q.qqstory.player.data.TroopAssistantHomeFeedPlayPageLoader", "pull feedId list fail %s", paramErrorMessage.toString());
      this.jdField_a_of_type_Woj.a(paramErrorMessage, null, false);
      return;
    }
    this.jdField_a_of_type_Wou.a.a(paramwep.jdField_a_of_type_JavaUtilList, paramwep.jdField_a_of_type_JavaLangString, paramwep.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_Woj.a(paramErrorMessage, wnr.b(paramwep.jdField_a_of_type_JavaUtilList), paramwep.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wov
 * JD-Core Version:    0.7.0.1
 */