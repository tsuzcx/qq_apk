import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;

class xjp
  implements wld<wzd, wze>
{
  xjp(xjo paramxjo, xjd paramxjd) {}
  
  public void a(@NonNull wzd paramwzd, @Nullable wze paramwze, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isFail()) || (paramwze == null))
    {
      yqp.a("Q.qqstory.player.data.TroopAssistantHomeFeedPlayPageLoader", "pull feedId list fail %s", paramErrorMessage.toString());
      this.jdField_a_of_type_Xjd.a(paramErrorMessage, null, false);
      return;
    }
    this.jdField_a_of_type_Xjo.a.a(paramwze.jdField_a_of_type_JavaUtilList, paramwze.jdField_a_of_type_JavaLangString, paramwze.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_Xjd.a(paramErrorMessage, xil.b(paramwze.jdField_a_of_type_JavaUtilList), paramwze.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xjp
 * JD-Core Version:    0.7.0.1
 */